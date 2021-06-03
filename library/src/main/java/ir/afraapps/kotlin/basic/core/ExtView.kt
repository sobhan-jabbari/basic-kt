package ir.afraapps.kotlin.basic.core

import android.view.View
import android.widget.TextView
import androidx.annotation.StyleRes

/**
 * In the name of Allah
 *
 * Created by Ali Jabbari on 4/24/20.
 */


fun View.onClick(action: (v: View) -> Unit) {
    setOnClickListener(action)
}

fun View.onSingleClick(action: (v: View) -> Unit) {
    setOnClickListener(object : View.OnClickListener {
        override fun onClick(v: View) {
            isEnabled = false
            action(v)
            postDelayed({ isEnabled = true }, 700)
        }
    })
}

fun View.onLongClick(action: (v: View) -> Boolean) {
    setOnLongClickListener(action)
}

@Suppress("DEPRECATION")
fun TextView.setTextAppearanceCompat(@StyleRes resId: Int) {
    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
        setTextAppearance(resId)
    } else {
        setTextAppearance(context, resId)
    }
}



