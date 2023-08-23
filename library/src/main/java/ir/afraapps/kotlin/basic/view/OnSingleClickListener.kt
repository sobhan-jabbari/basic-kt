package ir.afraapps.kotlin.basic.view

import android.view.View

class OnSingleClickListener(private val action: (v: View) -> Unit) : View.OnClickListener {
    private var lastClickTime = 0L
    override fun onClick(v: View) {
        val currentTime = System.currentTimeMillis()
        if (currentTime - lastClickTime < 800) {
            return
        }
        lastClickTime = currentTime
        action.invoke(v)
    }
}