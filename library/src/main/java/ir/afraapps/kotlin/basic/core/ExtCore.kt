package ir.afraapps.kotlin.basic.core

import android.app.AlarmManager
import android.app.PendingIntent
import android.os.Build.VERSION

/**
 * In the name of Allah
 *
 * Created by Ali Jabbari on 10/7/20.
 */

fun Boolean.takeIfTrue(action: () -> Unit): Boolean {
    if (this) {
        action.invoke()
        return true
    }
    return false
}

fun Boolean.takeIfFalse(action: () -> Unit): Boolean {
    if (!this) {
        action.invoke()
        return true
    }
    return false
}


fun <T> List<T>.takeIfNotEmpty(): List<T>? {
    return if (isNotEmpty()) this else null
}


fun AlarmManager.setExactWakeUp(timeMills: Long, pendingIntent: PendingIntent) {
    cancel(pendingIntent)
    if (VERSION.SDK_INT >= 23) {
        setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, timeMills, pendingIntent)

    } else if (VERSION.SDK_INT >= 19) {
        setExact(AlarmManager.RTC_WAKEUP, timeMills, pendingIntent)

    } else {
        set(AlarmManager.RTC_WAKEUP, timeMills, pendingIntent)
    }
}


fun AlarmManager.setExact(timeMills: Long, pendingIntent: PendingIntent) {
    cancel(pendingIntent)
    if (VERSION.SDK_INT >= 23) {
        setExactAndAllowWhileIdle(AlarmManager.RTC, timeMills, pendingIntent)

    } else if (VERSION.SDK_INT >= 19) {
        setExact(AlarmManager.RTC, timeMills, pendingIntent)

    } else {
        set(AlarmManager.RTC, timeMills, pendingIntent)
    }
}


fun <T : Any> T.getPrivateProperty(variableName: String): Any? {
    return javaClass.getDeclaredField(variableName).let { field ->
        field.isAccessible = true
        return@let field.get(this)
    }
}
