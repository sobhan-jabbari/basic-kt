package ir.afraapps.kotlin.basic.component

import android.content.Context
import android.content.res.ColorStateList
import android.content.res.Resources
import android.graphics.*
import android.graphics.drawable.Drawable
import android.os.Build
import android.view.View
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.Size
import ir.afraapps.kotlin.basic.core.getColorRes
import ir.afraapps.kotlin.basic.core.getColorStateListCompat
import ir.afraapps.kotlin.basic.core.isLocaleRTL

/**
 * In the name of Allah
 *
 * Created by Ali Jabbari on 5/22/20.
 */

class RoundDrawable(val context: Context) : Drawable() {

    private val paint: Paint
    private val boundRound: RectF
    private val path: Path
    private var alphaColor = -1


    constructor(context: Context, init: RoundDrawable.() -> Unit) : this(context) {
        apply(init)
    }

    var drawableState: RoundDrawableState? = null
    private var mutated = false


    init {
        drawableState = mutateRoundConstantState()
        paint = Paint(Paint.ANTI_ALIAS_FLAG)
        boundRound = RectF()
        path = Path()
    }


    var strokeWidth: Float = 0f

    @ColorInt
    var strokeColor: Int = 0

    @ColorRes
    var strokeColorResource: Int = 0
        set(value) {
            strokeColor = context.getColorRes(value)
        }

    var strokeColorStateList: ColorStateList? = null

    @ColorRes
    var strokeColorStateListResource: Int = 0
        set(value) {
            strokeColorStateList = context.getColorStateListCompat(value)
        }


    @ColorInt
    var fillColor: Int = Color.TRANSPARENT

    @ColorRes
    var fillColorResource: Int = 0
        set(value) {
            fillColor = context.getColorRes(value)
            fillColorStateList = null
        }

    var fillColorStateList: ColorStateList? = null

    @ColorRes
    var fillColorStateListResource: Int = 0
        set(value) {
            fillColorStateList = context.getColorStateListCompat(value)
        }


    var radius = 0f
        set(value) {
            if (value >= 0f) {
                field = value
                radiuses = floatArrayOf(value, value, value, value)
            }
        }

    /**
     * [tl, tr, br, bl]
     */
    @Size(4)
    var radiuses: FloatArray = floatArrayOf(radius, radius, radius, radius)


    fun topCorner(radius: Float) {
        radiuses = floatArrayOf(radius, radius, 0f, 0f)
    }

    fun bottomCorner(radius: Float) {
        radiuses = floatArrayOf(0f, 0f, radius, radius)
    }

    fun rightCorner(radius: Float) {
        radiuses = floatArrayOf(0f, radius, radius, 0f)
    }

    fun leftCorner(radius: Float) {
        radiuses = floatArrayOf(radius, 0f, 0f, radius)
    }

    fun startLocaleCorner(radius: Float) {
        if (context.isLocaleRTL()) rightCorner(radius) else leftCorner(radius)
    }

    fun endLocaleCorner(radius: Float) {
        if (context.isLocaleRTL()) leftCorner(radius) else rightCorner(radius)
    }


    var isCircle: Boolean = false

    var shadowColor: Int = 0x30000000
    var shadowSize = 0f
    var shadowX = 2f
    var shadowY = 5f

    var padding = 0


    private fun mutateRoundConstantState(): RoundDrawableState {
        return RoundDrawableState(context, drawableState)
    }

    override fun getConstantState(): ConstantState? {
        return drawableState?.let {
            it.stateChangingConfigurations = changingConfigurations
            it.strokeWidth = strokeWidth
            it.strokeColor = strokeColor
            it.strokeColorStateList = strokeColorStateList
            it.fillColor = fillColor
            it.fillColorStateList = fillColorStateList
            it.radiuses = radiuses
            it.shadowColor = shadowColor
            it.shadowSize = shadowSize
            it.shadowX = shadowX
            it.shadowY = shadowY
            it.padding = padding
            it
        }
    }

    override fun mutate(): Drawable {
        if (!mutated && super.mutate() == this) {
            drawableState = mutateRoundConstantState()
            mutated = true
        }
        return this
    }

    override fun draw(canvas: Canvas) {

        //----------------------------------------------------------
        paint.style = Paint.Style.FILL

        if (shadowSize > 0f) {
            paint.setColor(shadowColor)
            paint.setMaskFilter(BlurMaskFilter(shadowSize, BlurMaskFilter.Blur.NORMAL))
            val count = canvas.save()
            canvas.translate(shadowX, shadowY)
            drawRoundDrawable(canvas)
            canvas.restoreToCount(count)
            paint.setMaskFilter(null)
        }


        fillColorStateList?.let {
            paint.setColor(it.getColorForState(state, fillColor))

        } ?: paint.setColor(fillColor)

        drawRoundDrawable(canvas)

        //----------------------------------------------------------
        if (strokeWidth <= 0f) return
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = strokeWidth

        strokeColorStateList?.let {
            paint.setColor(it.getColorForState(state, strokeColor))

        } ?: paint.setColor(strokeColor)

        drawRoundDrawable(canvas)
    }


    private fun drawRoundDrawable(canvas: Canvas) {
        if (alphaColor > -1) {
            paint.alpha = alphaColor
        }
        if (isCircle) {
            val r = Math.min(boundRound.height(), boundRound.width()) / 2f
            canvas.drawCircle(boundRound.centerX(), boundRound.centerY(), r, paint)

        } else {
            canvas.drawPath(path, paint)
        }
    }


    override fun setAlpha(alpha: Int) {
        alphaColor = alpha
        invalidateSelf()
    }


    override fun getAlpha(): Int {
        return paint.alpha
    }


    override fun getOpacity(): Int {
        return PixelFormat.TRANSLUCENT
    }

    override fun setColorFilter(colorFilter: ColorFilter?) {


    }


    override fun getPadding(padding: Rect): Boolean {
        if (shadowSize <= 0 && this.padding <= 0) return super.getPadding(padding)
        padding.set(0, 0, 0, 0)
        if (shadowSize > 0) {
            val leftOffset = (shadowSize - shadowX).toInt()
            val rightOffset = (shadowSize + shadowX).toInt()
            val topOffset = (shadowSize - shadowY).toInt()
            val bottomOffset = (shadowSize + shadowY).toInt()
            padding.set(leftOffset, topOffset, rightOffset, bottomOffset)
        }

        if (this.padding > 0) {
            val halfPadding = this.padding / 2
            padding.left += halfPadding
            padding.right += halfPadding
            padding.top += halfPadding
            padding.bottom += halfPadding
        }

        return true
    }


    /*override fun getOpticalInsets(): Insets {
        if (shadowSize <= 0 || Build.VERSION.SDK_INT < Build.VERSION_CODES.Q) return super.getOpticalInsets()
        val contentInsets = super.getOpticalInsets()
        val leftOffset = (shadowSize - shadowX).takeIf { it >= 0f }?.toInt() ?: 0
        val rightOffset = (shadowSize + shadowX).toInt()
        val topOffset = (shadowSize - shadowY).takeIf { it >= 0f }?.toInt() ?: 0
        val bottomOffset = (shadowSize + shadowY).toInt()
        return Insets.of(
            contentInsets.left + leftOffset,
            contentInsets.top + topOffset,
            contentInsets.right + rightOffset,
            contentInsets.bottom + bottomOffset
        )
    }*/


    override fun onStateChange(state: IntArray): Boolean {
        if (strokeColorStateList == null && fillColorStateList == null) return false
        invalidateSelf()
        return true
    }


    override fun isStateful(): Boolean {
        return true
    }


    override fun onBoundsChange(bounds: Rect) {
        boundRound.set(bounds)
        if (strokeWidth > 0f) {
            val padding = strokeWidth / 2f
            boundRound.left += padding
            boundRound.top += padding
            boundRound.right -= padding
            boundRound.bottom -= padding
        }
        if (shadowSize > 0f) {
            val leftOffset = (shadowSize - shadowX)
            val rightOffset = (shadowSize + shadowX)
            val topOffset = (shadowSize - shadowY)
            val bottomOffset = (shadowSize + shadowY)
            boundRound.left += leftOffset
            boundRound.top += topOffset
            boundRound.right -= rightOffset
            boundRound.bottom -= bottomOffset
        }
        generatePath(boundRound)
    }


    override fun getOutline(outline: Outline) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (isCircle) {
                val padding = strokeWidth / 2f
                outline.setOval(
                    (boundRound.left - padding).toInt(),
                    (boundRound.top - padding).toInt(),
                    (boundRound.right + padding).toInt(),
                    (boundRound.bottom + padding).toInt()
                )
            } else {

                val firstRadius = radiuses[0]
                if (radiuses.all { it == firstRadius }) {
                    outline.setRoundRect(boundRound.left.toInt(), boundRound.top.toInt(), boundRound.right.toInt(), boundRound.bottom.toInt(), radius)
                } else {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                        outline.setPath(path)
                    } else {
                        @Suppress("DEPRECATION")
                        outline.setConvexPath(path)
                    }
                }
            }

            outline.alpha = alpha / 255.0f
        }
    }


    private fun getCorrectRadius(): FloatArray {
        val tl = radiuses[0].takeIf { it >= 0f } ?: 0f
        val tr = radiuses[1].takeIf { it >= 0f } ?: 0f
        val br = radiuses[2].takeIf { it >= 0f } ?: 0f
        val bl = radiuses[3].takeIf { it >= 0f } ?: 0f
        return floatArrayOf(tl, tl, tr, tr, br, br, bl, bl)
    }

    private fun generatePath(bounds: RectF) {
        path.reset()
        path.addRoundRect(bounds, getCorrectRadius(), Path.Direction.CW)
    }


    class RoundDrawableState(val context: Context, origin: RoundDrawableState? = null) : ConstantState() {

        var stateChangingConfigurations = 0

        var strokeWidth: Float = 0f

        @ColorInt
        var strokeColor: Int = Color.TRANSPARENT

        var strokeColorStateList: ColorStateList? = null

        @ColorInt
        var fillColor: Int = Color.TRANSPARENT

        var fillColorStateList: ColorStateList? = null

        /**
         * [tl, tr, br, bl]
         */
        @Size(4)
        var radiuses: FloatArray = floatArrayOf(0f, 0f, 0f, 0f)


        var isCircle: Boolean = false

        var shadowColor: Int = 0x30000000
        var shadowSize = 0f
        var shadowX = 2f
        var shadowY = 5f

        var padding = 0

        init {
            origin?.let {
                stateChangingConfigurations = it.stateChangingConfigurations
            }
        }

        override fun newDrawable(): Drawable {
            return RoundDrawable(context).also {
                it.strokeWidth = strokeWidth
                it.strokeColor = strokeColor
                it.strokeColorStateList = strokeColorStateList
                it.fillColor = fillColor
                it.fillColorStateList = fillColorStateList
                it.isCircle = isCircle
                it.radiuses = radiuses
                it.shadowSize = shadowSize
                it.shadowColor = shadowColor
                it.shadowX = shadowX
                it.shadowY = shadowY
                it.padding = padding
            }
        }

        override fun newDrawable(res: Resources?): Drawable {
            return newDrawable()
        }

        override fun newDrawable(res: Resources?, theme: Resources.Theme?): Drawable {
            return newDrawable()
        }

        override fun getChangingConfigurations(): Int {
            return stateChangingConfigurations
        }

    }


}


fun Context.roundDrawable(init: RoundDrawable.() -> Unit = {}): RoundDrawable {
    return RoundDrawable(this, init)
}

fun Context.circleDrawable(init: RoundDrawable.() -> Unit = {}): RoundDrawable {
    return RoundDrawable(this, init).apply {
        isCircle = true
    }
}

fun View.roundDrawable(init: RoundDrawable.() -> Unit = {}): RoundDrawable {
    return context.roundDrawable(init)
}

fun View.circleDrawable(init: RoundDrawable.() -> Unit = {}): RoundDrawable {
    return context.circleDrawable(init)
}