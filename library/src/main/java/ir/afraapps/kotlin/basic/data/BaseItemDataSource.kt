package ir.afraapps.kotlin.basic.data

import androidx.lifecycle.MutableLiveData
import androidx.paging.ItemKeyedDataSource
import ir.afraapps.kotlin.basic.data.web.FetchState
import java.util.concurrent.Executor


abstract class BaseItemDataSource<T> constructor(
    private val executor: Executor,
    private val liveDataInitState: MutableLiveData<FetchState>? = null,
    private val liveDataFetchState: MutableLiveData<FetchState>? = null,
    private val totalCount: Int
) : ItemKeyedDataSource<Int, T>() {


    private var retry: (() -> Unit)? = null


    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<T>) {
        retry = null

        liveDataInitState?.postValue(FetchState.LOADING)

        val limit = params.requestedLoadSize

        val data = getData(limit, 0)

        if (data == null) {
            liveDataInitState?.postValue(FetchState.FAILED)
            retry = { loadInitial(params, callback) }

        } else {
            callback.onResult(data, data.size, totalCount)
            liveDataInitState?.postValue(if (data.isEmpty()) FetchState.FINISHED else FetchState.SUCCESS)
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<T>) {
        retry = null

        liveDataFetchState?.postValue(FetchState.LOADING)

        var limit = params.requestedLoadSize
        limit = Math.min(limit, params.key + 1)
        var offset = (params.key + 1) - limit
        offset = Math.max(offset, 0)

        val data = getData(limit, offset)

        if (data == null) {
            liveDataFetchState?.postValue(FetchState.FAILED)
            retry = { loadBefore(params, callback) }

        } else {
            callback.onResult(data)
            liveDataFetchState?.postValue(if (data.size < params.requestedLoadSize) FetchState.FINISHED else FetchState.SUCCESS)
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<T>) {
        retry = null

        liveDataFetchState?.postValue(FetchState.LOADING)

        val limit = params.requestedLoadSize

        val data = getData(limit, params.key)

        if (data == null) {
            liveDataFetchState?.postValue(FetchState.FAILED)
            retry = { loadAfter(params, callback) }

        } else {
            callback.onResult(data)
            liveDataFetchState?.postValue(if (data.isEmpty()) FetchState.FINISHED else FetchState.SUCCESS)
        }
    }

    override fun getKey(item: T): Int {
        TODO("Not yet implemented")
    }


    protected abstract fun getData(limit: Int, offset: Int): List<T>?


    fun retry() {
        retry?.let { executor.execute(it) }
    }


}
