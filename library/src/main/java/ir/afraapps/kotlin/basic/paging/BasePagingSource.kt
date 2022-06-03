package ir.afraapps.kotlin.basic.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState

abstract class BasePagingSource<T : Any>(val startPosition: Int = 0) : PagingSource<Int, T>() {

    abstract suspend fun getData(limit: Int, offset: Int): List<T>

    override fun getRefreshKey(state: PagingState<Int, T>): Int? {
        val initialLoadSize = state.config.initialLoadSize
        return when {
            state.anchorPosition == null -> null
            else -> maxOf(0, state.anchorPosition!! - (initialLoadSize / 2))
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, T> {
        return try {
            val key = params.key ?: startPosition
            val limit: Int = getLimit(params, key)
            val offset: Int = getOffset(params, key)
            val data = getData(limit, offset)

            val nextPosToLoad = offset + data.size
            val nextKey = if (data.size < limit) null else nextPosToLoad
            val prevKey = if (offset <= 0 || data.isEmpty()) null else offset
            LoadResult.Page(data, prevKey, nextKey)

        } catch (e: Throwable) {
            LoadResult.Error(e)
        }
    }

    private fun getLimit(params: LoadParams<Int>, key: Int): Int {
        return when (params) {
            is LoadParams.Prepend -> if (key < params.loadSize) key else params.loadSize
            else -> params.loadSize
        }
    }

    private fun getOffset(params: LoadParams<Int>, key: Int): Int {
        return when (params) {
            is LoadParams.Prepend -> if (key < params.loadSize) 0 else (key - params.loadSize)
            is LoadParams.Append -> key
            is LoadParams.Refresh -> key
        }
    }
}