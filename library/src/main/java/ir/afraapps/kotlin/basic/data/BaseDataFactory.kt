package ir.afraapps.kotlin.basic.data

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource

abstract class BaseDataFactory<T : BaseDataSource<C>, C> : DataSource.Factory<Int, C>() {

    val dataSourceLiveData: MutableLiveData<T>
    private lateinit var dataSource: T

    init {
        this.dataSourceLiveData = MutableLiveData()
    }

    override fun create(): BaseDataSource<C> {
        dataSource = createDataSource()
        dataSourceLiveData.postValue(dataSource)
        return dataSource
    }

    abstract fun createDataSource(): T

}
