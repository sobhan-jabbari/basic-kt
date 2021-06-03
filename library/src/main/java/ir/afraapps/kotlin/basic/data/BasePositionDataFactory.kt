package ir.afraapps.kotlin.basic.data

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource

abstract class BasePositionDataFactory<T : BasePositionDataSource<C>, C> : DataSource.Factory<Int, C>() {

    val dataSourceLiveData: MutableLiveData<T>
    private lateinit var dataSource: T

    init {
        this.dataSourceLiveData = MutableLiveData()
    }

    override fun create(): BasePositionDataSource<C> {
        dataSource = createDataSource()
        dataSourceLiveData.postValue(dataSource)
        return dataSource
    }

    abstract fun createDataSource(): T

}
