package ir.afraapps.kotlin.basic.util.property

typealias PropertyListener<T> = (oldValue: T, newValue: T) -> Unit