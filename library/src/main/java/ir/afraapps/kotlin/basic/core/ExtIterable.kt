package ir.afraapps.kotlin.basic.core

/**
 * In the name of Allah
 *
 * Created by Ali Jabbari on 9/12/2021.
 */

fun <T> Iterable<T>?.equals(other: Iterable<T>?, equalCondition: ((first: T, second: T) -> Boolean)? = null): Boolean {
    return when {
        this === other -> true
        this == null || other == null -> false
        this.count() != other.count() -> false
        else -> {
            var containItem: Boolean
            for (item1 in this) {
                containItem = false
                for (item2 in other) {
                    if (equalCondition != null) {
                        if (equalCondition.invoke(item1, item2)) {
                            containItem = true
                            break
                        }
                    } else if (item1 == item2) {
                        containItem = true
                        break
                    }
                }
                if (!containItem) {
                    return false
                }
            }
            true
        }
    }
}

fun <T> Iterable<T>?.notEquals(other: Iterable<T>?, equalCondition: ((first: T, second: T) -> Boolean)? = null): Boolean {
    return equals(other, equalCondition).not()
}