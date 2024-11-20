package ir.afraapps.kotlin.basic.util.property

import kotlin.reflect.KProperty


abstract class BaseProperty<T>(initValue: T) {

    private val listeners: MutableList<PropertyListener<T>> = ArrayList()


    var value: T = initValue
        set(value) {
            val oldValue = field
            field = value
            firePropertyChange(oldValue, value)
        }


    private fun firePropertyChange(oldValue: T, newValue: T) {
        if (oldValue != newValue) {
            listeners.forEach { it.invoke(oldValue, newValue) }
        }
    }

    fun addListener(listener: PropertyListener<T>) {
        listeners.add(listener)
    }

    fun removeListener(listener: PropertyListener<T>) {
        listeners.remove(listener)
    }

    fun clearListeners() {
        listeners.clear()
    }

    fun bind(property: BaseProperty<T>) {
        value = property.value
        property.addListener { _, newValue -> value = newValue }
    }

    operator fun getValue(u: Any, p: KProperty<*>): T {
        return value
    }

    operator fun setValue(u: Any, p: KProperty<*>, v: T) {
        value = v
    }

}