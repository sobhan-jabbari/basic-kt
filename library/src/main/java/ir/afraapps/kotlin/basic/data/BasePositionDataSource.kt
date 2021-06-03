package ir.afraapps.kotlin.basic.data

import androidx.lifecycle.MutableLiveData
import androidx.paging.PositionalDataSource
import ir.afraapps.kotlin.basic.data.web.FetchState


abstract class BasePositionDataSource<T> constructor(
    private val liveDataInitState: MutableLiveData<FetchState>? = null,
    private val liveDataLoadState: MutableLiveData<FetchState>? = null,
    private val totalCount: Int
) : PositionalDataSource<T>() {


    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<T>) {
        val position = computeInitialLoadPosition(params, totalCount)
        val loadSize = computeInitialLoadSize(params, position, totalCount)

        liveDataInitState?.postValue(FetchState.LOADING)

        val data = getData(position, loadSize)

        callback.onResult(data, position, totalCount)

        liveDataInitState?.postValue(if (data.isEmpty()) FetchState.FINISHED else FetchState.SUCCESS)
    }

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<T>) {
        liveDataLoadState?.postValue(FetchState.LOADING)
        val data = getData(params.startPosition, params.loadSize)
        callback.onResult(data)
        liveDataLoadState?.postValue(if (data.size < params.loadSize) FetchState.FINISHED else FetchState.SUCCESS)
    }


    protected abstract fun getData(startPosition: Int, loadCount: Int): List<T>

}
