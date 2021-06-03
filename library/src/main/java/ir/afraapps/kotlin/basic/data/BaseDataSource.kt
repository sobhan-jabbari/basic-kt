package ir.afraapps.kotlin.basic.data

import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import ir.afraapps.kotlin.basic.data.web.FetchState
import java.util.concurrent.Executor


abstract class BaseDataSource<T> constructor(
    private val executor: Executor,
    private val liveDataInitState: MutableLiveData<FetchState>? = null,
    private val liveDataFetchState: MutableLiveData<FetchState>? = null,
    private val startPosition: Int = 0
) : PageKeyedDataSource<Int, T>() {


    private var retry: (() -> Unit)? = null


    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, T>
    ) {
        retry = null

        liveDataInitState?.postValue(FetchState.LOADING)

        val limit = params.requestedLoadSize

        val data = getData(limit, startPosition)

        if (data == null) {
            liveDataInitState?.postValue(FetchState.FAILED)
            retry = { loadInitial(params, callback) }

        } else {
            callback.onResult(
                data,
                if (startPosition == 0) null else (startPosition - 1),
                if (data.size < limit) null else (startPosition + limit)
            )
            liveDataInitState?.postValue(if (startPosition == 0 && data.size < limit) FetchState.FINISHED else FetchState.SUCCESS)
        }
    }


    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, T>) {
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
            callback.onResult(data, if (data.size < params.requestedLoadSize) null else params.key - 1)
            liveDataFetchState?.postValue(if (data.size < params.requestedLoadSize) FetchState.FINISHED else FetchState.SUCCESS)
        }

    }


    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, T>) {
        retry = null

        liveDataFetchState?.postValue(FetchState.LOADING)

        val limit = params.requestedLoadSize

        val data = getData(limit, params.key)

        if (data == null) {
            liveDataFetchState?.postValue(FetchState.FAILED)
            retry = { loadAfter(params, callback) }

        } else {
            callback.onResult(data, if (data.size < limit) null else params.key + limit)
            liveDataFetchState?.postValue(if (data.size < limit) FetchState.FINISHED else FetchState.SUCCESS)
        }
    }


    protected abstract fun getData(limit: Int, offset: Int): List<T>?


    fun retry() {
        retry?.let { executor.execute(it) }
    }


}
