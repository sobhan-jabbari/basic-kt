package ir.afraapps.kotlin.basic.view

import android.os.SystemClock
import android.view.View

class OnSingleClickListener(private val action: (v: View) -> Unit) : View.OnClickListener {
    private var lastClickTime = 0L
    override fun onClick(v: View) {
        if (SystemClock.elapsedRealtime() - lastClickTime < 800) {
            return
        }
        lastClickTime = SystemClock.elapsedRealtime()
        action.invoke(v)
    }
}