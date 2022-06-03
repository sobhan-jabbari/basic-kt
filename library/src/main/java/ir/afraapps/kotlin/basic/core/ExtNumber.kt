package ir.afraapps.kotlin.basic.core

import android.content.Context
import androidx.annotation.ColorInt
import androidx.annotation.FloatRange
import androidx.core.graphics.ColorUtils
import org.jetbrains.anko.dip
import org.jetbrains.anko.displayMetrics
import org.jetbrains.anko.sp
import java.util.*
import kotlin.math.abs

/**
 * In the name of Allah
 *
 * Created by Ali Jabbari on 5/21/20.
 */


fun Long.toTimeFormat(): String {
    val isNegative = this < 0
    val pTime = abs(this)
    val second = pTime / 1000 % 60
    val minute = pTime / 60000 % 60
    val hours = pTime / 3600000 % 24
    return if (isNegative)
        String.format(Locale.ENGLISH, "-%02d:%02d:%02d", hours, minute, second)
    else
        String.format(Locale.ENGLISH, "%02d:%02d:%02d", hours, minute, second)
}

fun Long.toTimeHoursMinute(): String {
    val isNegative = this < 0
    val pTime = abs(this)
    val minute = pTime / 60000 % 60
    val hours = pTime / 3600000 % 24
    return if (isNegative)
        String.format(Locale.ENGLISH, "-%02d:%02d", hours, minute)
    else
        String.format(Locale.ENGLISH, "%02d:%02d", hours, minute)
}

fun Long.toTimeMinuteSecond(): String {
    val isNegative = this < 0
    val pTime = abs(this)
    val second = pTime / 1000 % 60
    val minute = pTime / 60000 % 60
    return if (isNegative)
        String.format(Locale.ENGLISH, "-%02d:%02d", minute, second)
    else
        String.format(Locale.ENGLISH, "%02d:%02d", minute, second)
}

fun Int.toTimeFormat(): String {
    return this.toLong().toTimeFormat()
}

fun Int.toTimeHoursMinute(): String {
    return this.toLong().toTimeHoursMinute()
}

fun Int.toTimeMinuteSecond(): String {
    return this.toLong().toTimeMinuteSecond()
}


@ColorInt
fun @receiver:ColorInt Int.darken(@FloatRange(from = 0.0, to = 1.0) level: Float = 0.1f): Int {
    return ColorUtils.HSLToColor(FloatArray(3).apply {
        ColorUtils.colorToHSL(this@darken, this)
        val brightness = this[2]
        this[2] = Math.max(brightness - level, 0f)
    })
}

@ColorInt
fun @receiver:ColorInt Int.brighten(@FloatRange(from = 0.0, to = 1.0) level: Float = 0.1f): Int {
    return ColorUtils.HSLToColor(FloatArray(3).apply {
        ColorUtils.colorToHSL(this@brighten, this)
        val brightness = this[2]
        this[2] = Math.min(brightness + level, 1f)
    })
}

fun Int.toDip(context: Context): Int {
    return context.dip(this)
}

fun Int.toDipf(context: Context): Float {
    return context.dipf(this)
}

fun Float.toDip(context: Context): Int {
    return context.dip(this)
}

fun Float.toDipf(context: Context): Float {
    return context.dipf(this)
}

fun Int.toSp(context: Context): Int {
    return context.sp(this)
}

fun Int.toSpf(context: Context): Float {
    return context.spf(this)
}

fun Float.toSp(context: Context): Int {
    return context.sp(this)
}

fun Float.toSpf(context: Context): Float {
    return context.spf(this)
}

fun Boolean.toInt(): Int = if (this) 1 else 0
