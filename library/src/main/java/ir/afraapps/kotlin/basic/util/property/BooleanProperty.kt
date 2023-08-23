package ir.afraapps.kotlin.basic.util.property


class BooleanProperty(initValue: Boolean = false) : BaseProperty<Boolean>(initValue) {

    fun toggle() {
        value = !value
    }
}
