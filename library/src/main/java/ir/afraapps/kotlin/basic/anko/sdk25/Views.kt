@file:JvmName("Sdk25ViewsKt")

package org.jetbrains.anko

import org.jetbrains.anko.custom.*
import org.jetbrains.anko.AnkoViewDslMarker
import android.view.ViewManager
import android.view.ViewGroup.LayoutParams
import android.app.Activity
import android.content.Context
import android.os.Build
import android.widget.*

@PublishedApi
internal object `$$Anko$Factories$Sdk25View` {
    val MEDIA_ROUTE_BUTTON = { ctx: Context -> android.app.MediaRouteButton(ctx) }
    val GESTURE_OVERLAY_VIEW = { ctx: Context -> android.gesture.GestureOverlayView(ctx) }
    val EXTRACT_EDIT_TEXT = { ctx: Context -> android.inputmethodservice.ExtractEditText(ctx) }
    val TV_VIEW = { ctx: Context -> android.media.tv.TvView(ctx) }
    val G_L_SURFACE_VIEW = { ctx: Context -> android.opengl.GLSurfaceView(ctx) }
    val SURFACE_VIEW = { ctx: Context -> android.view.SurfaceView(ctx) }
    val TEXTURE_VIEW = { ctx: Context -> android.view.TextureView(ctx) }
    val VIEW = { ctx: Context -> android.view.View(ctx) }
    val VIEW_STUB = { ctx: Context -> android.view.ViewStub(ctx) }
    val WEB_VIEW = { ctx: Context -> android.webkit.WebView(ctx) }
    val ADAPTER_VIEW_FLIPPER = { ctx: Context -> AdapterViewFlipper(ctx) }
    val AUTO_COMPLETE_TEXT_VIEW = { ctx: Context -> android.widget.AutoCompleteTextView(ctx) }
    val BUTTON = { ctx: Context -> Button(ctx) }
    val CALENDAR_VIEW = { ctx: Context -> android.widget.CalendarView(ctx) }
    val CHECK_BOX = { ctx: Context -> CheckBox(ctx) }
    val CHECKED_TEXT_VIEW = { ctx: Context -> android.widget.CheckedTextView(ctx) }
    val CHRONOMETER = { ctx: Context -> android.widget.Chronometer(ctx) }
    val DATE_PICKER = { ctx: Context -> DatePicker(ctx) }
    val EDIT_TEXT = { ctx: Context -> EditText(ctx) }
    val EXPANDABLE_LIST_VIEW = { ctx: Context -> ExpandableListView(ctx) }
    val IMAGE_BUTTON = { ctx: Context -> ImageButton(ctx) }
    val IMAGE_VIEW = { ctx: Context -> ImageView(ctx) }
    val LIST_VIEW = { ctx: Context -> android.widget.ListView(ctx) }
    val MULTI_AUTO_COMPLETE_TEXT_VIEW = { ctx: Context -> MultiAutoCompleteTextView(ctx) }
    val NUMBER_PICKER = { ctx: Context -> NumberPicker(ctx) }
    val PROGRESS_BAR = { ctx: Context -> ProgressBar(ctx) }
    val QUICK_CONTACT_BADGE = { ctx: Context -> android.widget.QuickContactBadge(ctx) }
    val RADIO_BUTTON = { ctx: Context -> android.widget.RadioButton(ctx) }
    val RATING_BAR = { ctx: Context -> android.widget.RatingBar(ctx) }
    val SEARCH_VIEW = { ctx: Context -> SearchView(ctx) }
    val SEEK_BAR = { ctx: Context -> SeekBar(ctx) }
    val SPACE = { ctx: Context -> Space(ctx) }
    val SPINNER = { ctx: Context -> Spinner(ctx) }
    val STACK_VIEW = { ctx: Context -> StackView(ctx) }
    val SWITCH = { ctx: Context -> Switch(ctx) }
    val TEXT_CLOCK = { ctx: Context -> TextClock(ctx) }
    val TEXT_VIEW = { ctx: Context -> TextView(ctx) }
    val TIME_PICKER = { ctx: Context -> TimePicker(ctx) }
    val TOGGLE_BUTTON = { ctx: Context -> ToggleButton(ctx) }
    val VIDEO_VIEW = { ctx: Context -> VideoView(ctx) }
    val VIEW_FLIPPER = { ctx: Context -> ViewFlipper(ctx) }
}

fun ViewManager.mediaRouteButton(): android.app.MediaRouteButton = mediaRouteButton() {}
inline fun ViewManager.mediaRouteButton(init: (@AnkoViewDslMarker android.app.MediaRouteButton).() -> Unit): android.app.MediaRouteButton {
    return ankoView(`$$Anko$Factories$Sdk25View`.MEDIA_ROUTE_BUTTON, theme = 0) { init() }
}

fun ViewManager.themedMediaRouteButton(theme: Int = 0): android.app.MediaRouteButton = themedMediaRouteButton(theme) {}
inline fun ViewManager.themedMediaRouteButton(
    theme: Int = 0,
    init: (@AnkoViewDslMarker android.app.MediaRouteButton).() -> Unit
): android.app.MediaRouteButton {
    return ankoView(`$$Anko$Factories$Sdk25View`.MEDIA_ROUTE_BUTTON, theme) { init() }
}

fun ViewManager.gestureOverlayView(): android.gesture.GestureOverlayView = gestureOverlayView() {}
inline fun ViewManager.gestureOverlayView(init: (@AnkoViewDslMarker android.gesture.GestureOverlayView).() -> Unit): android.gesture.GestureOverlayView {
    return ankoView(`$$Anko$Factories$Sdk25View`.GESTURE_OVERLAY_VIEW, theme = 0) { init() }
}

fun ViewManager.themedGestureOverlayView(theme: Int = 0): android.gesture.GestureOverlayView = themedGestureOverlayView(theme) {}
inline fun ViewManager.themedGestureOverlayView(
    theme: Int = 0,
    init: (@AnkoViewDslMarker android.gesture.GestureOverlayView).() -> Unit
): android.gesture.GestureOverlayView {
    return ankoView(`$$Anko$Factories$Sdk25View`.GESTURE_OVERLAY_VIEW, theme) { init() }
}

fun Context.gestureOverlayView(): android.gesture.GestureOverlayView = gestureOverlayView() {}
inline fun Context.gestureOverlayView(init: (@AnkoViewDslMarker android.gesture.GestureOverlayView).() -> Unit): android.gesture.GestureOverlayView {
    return ankoView(`$$Anko$Factories$Sdk25View`.GESTURE_OVERLAY_VIEW, theme = 0) { init() }
}

fun Context.themedGestureOverlayView(theme: Int = 0): android.gesture.GestureOverlayView = themedGestureOverlayView(theme) {}
inline fun Context.themedGestureOverlayView(
    theme: Int = 0,
    init: (@AnkoViewDslMarker android.gesture.GestureOverlayView).() -> Unit
): android.gesture.GestureOverlayView {
    return ankoView(`$$Anko$Factories$Sdk25View`.GESTURE_OVERLAY_VIEW, theme) { init() }
}

fun Activity.gestureOverlayView(): android.gesture.GestureOverlayView = gestureOverlayView() {}
inline fun Activity.gestureOverlayView(init: (@AnkoViewDslMarker android.gesture.GestureOverlayView).() -> Unit): android.gesture.GestureOverlayView {
    return ankoView(`$$Anko$Factories$Sdk25View`.GESTURE_OVERLAY_VIEW, theme = 0) { init() }
}

fun Activity.themedGestureOverlayView(theme: Int = 0): android.gesture.GestureOverlayView = themedGestureOverlayView(theme) {}
inline fun Activity.themedGestureOverlayView(
    theme: Int = 0,
    init: (@AnkoViewDslMarker android.gesture.GestureOverlayView).() -> Unit
): android.gesture.GestureOverlayView {
    return ankoView(`$$Anko$Factories$Sdk25View`.GESTURE_OVERLAY_VIEW, theme) { init() }
}

fun ViewManager.extractEditText(): android.inputmethodservice.ExtractEditText = extractEditText() {}
inline fun ViewManager.extractEditText(init: (@AnkoViewDslMarker android.inputmethodservice.ExtractEditText).() -> Unit): android.inputmethodservice.ExtractEditText {
    return ankoView(`$$Anko$Factories$Sdk25View`.EXTRACT_EDIT_TEXT, theme = 0) { init() }
}

fun ViewManager.themedExtractEditText(theme: Int = 0): android.inputmethodservice.ExtractEditText = themedExtractEditText(theme) {}
inline fun ViewManager.themedExtractEditText(
    theme: Int = 0,
    init: (@AnkoViewDslMarker android.inputmethodservice.ExtractEditText).() -> Unit
): android.inputmethodservice.ExtractEditText {
    return ankoView(`$$Anko$Factories$Sdk25View`.EXTRACT_EDIT_TEXT, theme) { init() }
}

fun ViewManager.tvView(): android.media.tv.TvView = tvView() {}
inline fun ViewManager.tvView(init: (@AnkoViewDslMarker android.media.tv.TvView).() -> Unit): android.media.tv.TvView {
    return ankoView(`$$Anko$Factories$Sdk25View`.TV_VIEW, theme = 0) { init() }
}

fun ViewManager.themedTvView(theme: Int = 0): android.media.tv.TvView = themedTvView(theme) {}
inline fun ViewManager.themedTvView(theme: Int = 0, init: (@AnkoViewDslMarker android.media.tv.TvView).() -> Unit): android.media.tv.TvView {
    return ankoView(`$$Anko$Factories$Sdk25View`.TV_VIEW, theme) { init() }
}

fun Context.tvView(): android.media.tv.TvView = tvView() {}
inline fun Context.tvView(init: (@AnkoViewDslMarker android.media.tv.TvView).() -> Unit): android.media.tv.TvView {
    return ankoView(`$$Anko$Factories$Sdk25View`.TV_VIEW, theme = 0) { init() }
}

fun Context.themedTvView(theme: Int = 0): android.media.tv.TvView = themedTvView(theme) {}
inline fun Context.themedTvView(theme: Int = 0, init: (@AnkoViewDslMarker android.media.tv.TvView).() -> Unit): android.media.tv.TvView {
    return ankoView(`$$Anko$Factories$Sdk25View`.TV_VIEW, theme) { init() }
}

fun Activity.tvView(): android.media.tv.TvView = tvView() {}
inline fun Activity.tvView(init: (@AnkoViewDslMarker android.media.tv.TvView).() -> Unit): android.media.tv.TvView {
    return ankoView(`$$Anko$Factories$Sdk25View`.TV_VIEW, theme = 0) { init() }
}

fun Activity.themedTvView(theme: Int = 0): android.media.tv.TvView = themedTvView(theme) {}
inline fun Activity.themedTvView(theme: Int = 0, init: (@AnkoViewDslMarker android.media.tv.TvView).() -> Unit): android.media.tv.TvView {
    return ankoView(`$$Anko$Factories$Sdk25View`.TV_VIEW, theme) { init() }
}

fun ViewManager.gLSurfaceView(): android.opengl.GLSurfaceView = gLSurfaceView() {}
inline fun ViewManager.gLSurfaceView(init: (@AnkoViewDslMarker android.opengl.GLSurfaceView).() -> Unit): android.opengl.GLSurfaceView {
    return ankoView(`$$Anko$Factories$Sdk25View`.G_L_SURFACE_VIEW, theme = 0) { init() }
}

fun ViewManager.themedGLSurfaceView(theme: Int = 0): android.opengl.GLSurfaceView = themedGLSurfaceView(theme) {}
inline fun ViewManager.themedGLSurfaceView(
    theme: Int = 0,
    init: (@AnkoViewDslMarker android.opengl.GLSurfaceView).() -> Unit
): android.opengl.GLSurfaceView {
    return ankoView(`$$Anko$Factories$Sdk25View`.G_L_SURFACE_VIEW, theme) { init() }
}

fun ViewManager.surfaceView(): android.view.SurfaceView = surfaceView() {}
inline fun ViewManager.surfaceView(init: (@AnkoViewDslMarker android.view.SurfaceView).() -> Unit): android.view.SurfaceView {
    return ankoView(`$$Anko$Factories$Sdk25View`.SURFACE_VIEW, theme = 0) { init() }
}

fun ViewManager.themedSurfaceView(theme: Int = 0): android.view.SurfaceView = themedSurfaceView(theme) {}
inline fun ViewManager.themedSurfaceView(theme: Int = 0, init: (@AnkoViewDslMarker android.view.SurfaceView).() -> Unit): android.view.SurfaceView {
    return ankoView(`$$Anko$Factories$Sdk25View`.SURFACE_VIEW, theme) { init() }
}

fun ViewManager.textureView(): android.view.TextureView = textureView() {}
inline fun ViewManager.textureView(init: (@AnkoViewDslMarker android.view.TextureView).() -> Unit): android.view.TextureView {
    return ankoView(`$$Anko$Factories$Sdk25View`.TEXTURE_VIEW, theme = 0) { init() }
}

fun ViewManager.themedTextureView(theme: Int = 0): android.view.TextureView = themedTextureView(theme) {}
inline fun ViewManager.themedTextureView(theme: Int = 0, init: (@AnkoViewDslMarker android.view.TextureView).() -> Unit): android.view.TextureView {
    return ankoView(`$$Anko$Factories$Sdk25View`.TEXTURE_VIEW, theme) { init() }
}

fun ViewManager.view(): android.view.View = view() {}
inline fun ViewManager.view(init: (@AnkoViewDslMarker android.view.View).() -> Unit): android.view.View {
    return ankoView(`$$Anko$Factories$Sdk25View`.VIEW, theme = 0) { init() }
}

fun ViewManager.themedView(theme: Int = 0): android.view.View = themedView(theme) {}
inline fun ViewManager.themedView(theme: Int = 0, init: (@AnkoViewDslMarker android.view.View).() -> Unit): android.view.View {
    return ankoView(`$$Anko$Factories$Sdk25View`.VIEW, theme) { init() }
}

fun ViewManager.viewStub(): android.view.ViewStub = viewStub() {}
inline fun ViewManager.viewStub(init: (@AnkoViewDslMarker android.view.ViewStub).() -> Unit): android.view.ViewStub {
    return ankoView(`$$Anko$Factories$Sdk25View`.VIEW_STUB, theme = 0) { init() }
}

fun ViewManager.themedViewStub(theme: Int = 0): android.view.ViewStub = themedViewStub(theme) {}
inline fun ViewManager.themedViewStub(theme: Int = 0, init: (@AnkoViewDslMarker android.view.ViewStub).() -> Unit): android.view.ViewStub {
    return ankoView(`$$Anko$Factories$Sdk25View`.VIEW_STUB, theme) { init() }
}

fun ViewManager.webView(): android.webkit.WebView = webView() {}
inline fun ViewManager.webView(init: (@AnkoViewDslMarker android.webkit.WebView).() -> Unit): android.webkit.WebView {
    return ankoView(`$$Anko$Factories$Sdk25View`.WEB_VIEW, theme = 0) { init() }
}

fun ViewManager.themedWebView(theme: Int = 0): android.webkit.WebView = themedWebView(theme) {}
inline fun ViewManager.themedWebView(theme: Int = 0, init: (@AnkoViewDslMarker android.webkit.WebView).() -> Unit): android.webkit.WebView {
    return ankoView(`$$Anko$Factories$Sdk25View`.WEB_VIEW, theme) { init() }
}

fun Context.webView(): android.webkit.WebView = webView() {}
inline fun Context.webView(init: (@AnkoViewDslMarker android.webkit.WebView).() -> Unit): android.webkit.WebView {
    return ankoView(`$$Anko$Factories$Sdk25View`.WEB_VIEW, theme = 0) { init() }
}

fun Context.themedWebView(theme: Int = 0): android.webkit.WebView = themedWebView(theme) {}
inline fun Context.themedWebView(theme: Int = 0, init: (@AnkoViewDslMarker android.webkit.WebView).() -> Unit): android.webkit.WebView {
    return ankoView(`$$Anko$Factories$Sdk25View`.WEB_VIEW, theme) { init() }
}

fun Activity.webView(): android.webkit.WebView = webView() {}
inline fun Activity.webView(init: (@AnkoViewDslMarker android.webkit.WebView).() -> Unit): android.webkit.WebView {
    return ankoView(`$$Anko$Factories$Sdk25View`.WEB_VIEW, theme = 0) { init() }
}

fun Activity.themedWebView(theme: Int = 0): android.webkit.WebView = themedWebView(theme) {}
inline fun Activity.themedWebView(theme: Int = 0, init: (@AnkoViewDslMarker android.webkit.WebView).() -> Unit): android.webkit.WebView {
    return ankoView(`$$Anko$Factories$Sdk25View`.WEB_VIEW, theme) { init() }
}

fun ViewManager.adapterViewFlipper(): AdapterViewFlipper = adapterViewFlipper() {}
inline fun ViewManager.adapterViewFlipper(init: (@AnkoViewDslMarker AdapterViewFlipper).() -> Unit): AdapterViewFlipper {
    return ankoView(`$$Anko$Factories$Sdk25View`.ADAPTER_VIEW_FLIPPER, theme = 0) { init() }
}

fun ViewManager.themedAdapterViewFlipper(theme: Int = 0): AdapterViewFlipper = themedAdapterViewFlipper(theme) {}
inline fun ViewManager.themedAdapterViewFlipper(
    theme: Int = 0,
    init: (@AnkoViewDslMarker AdapterViewFlipper).() -> Unit
): AdapterViewFlipper {
    return ankoView(`$$Anko$Factories$Sdk25View`.ADAPTER_VIEW_FLIPPER, theme) { init() }
}

fun Context.adapterViewFlipper(): AdapterViewFlipper = adapterViewFlipper() {}
inline fun Context.adapterViewFlipper(init: (@AnkoViewDslMarker AdapterViewFlipper).() -> Unit): AdapterViewFlipper {
    return ankoView(`$$Anko$Factories$Sdk25View`.ADAPTER_VIEW_FLIPPER, theme = 0) { init() }
}

fun Context.themedAdapterViewFlipper(theme: Int = 0): AdapterViewFlipper = themedAdapterViewFlipper(theme) {}
inline fun Context.themedAdapterViewFlipper(
    theme: Int = 0,
    init: (@AnkoViewDslMarker AdapterViewFlipper).() -> Unit
): AdapterViewFlipper {
    return ankoView(`$$Anko$Factories$Sdk25View`.ADAPTER_VIEW_FLIPPER, theme) { init() }
}

fun Activity.adapterViewFlipper(): AdapterViewFlipper = adapterViewFlipper() {}
inline fun Activity.adapterViewFlipper(init: (@AnkoViewDslMarker AdapterViewFlipper).() -> Unit): AdapterViewFlipper {
    return ankoView(`$$Anko$Factories$Sdk25View`.ADAPTER_VIEW_FLIPPER, theme = 0) { init() }
}

fun Activity.themedAdapterViewFlipper(theme: Int = 0): AdapterViewFlipper = themedAdapterViewFlipper(theme) {}
inline fun Activity.themedAdapterViewFlipper(
    theme: Int = 0,
    init: (@AnkoViewDslMarker AdapterViewFlipper).() -> Unit
): AdapterViewFlipper {
    return ankoView(`$$Anko$Factories$Sdk25View`.ADAPTER_VIEW_FLIPPER, theme) { init() }
}

fun ViewManager.autoCompleteTextView(): android.widget.AutoCompleteTextView = autoCompleteTextView() {}
inline fun ViewManager.autoCompleteTextView(init: (@AnkoViewDslMarker android.widget.AutoCompleteTextView).() -> Unit): android.widget.AutoCompleteTextView {
    return ankoView(`$$Anko$Factories$Sdk25View`.AUTO_COMPLETE_TEXT_VIEW, theme = 0) { init() }
}

fun ViewManager.themedAutoCompleteTextView(theme: Int = 0): android.widget.AutoCompleteTextView = themedAutoCompleteTextView(theme) {}
inline fun ViewManager.themedAutoCompleteTextView(
    theme: Int = 0,
    init: (@AnkoViewDslMarker android.widget.AutoCompleteTextView).() -> Unit
): android.widget.AutoCompleteTextView {
    return ankoView(`$$Anko$Factories$Sdk25View`.AUTO_COMPLETE_TEXT_VIEW, theme) { init() }
}

fun ViewManager.button(): Button = button() {}
inline fun ViewManager.button(init: (@AnkoViewDslMarker Button).() -> Unit): Button {
    return ankoView(`$$Anko$Factories$Sdk25View`.BUTTON, theme = 0) { init() }
}

fun ViewManager.themedButton(theme: Int = 0): Button = themedButton(theme) {}
inline fun ViewManager.themedButton(theme: Int = 0, init: (@AnkoViewDslMarker Button).() -> Unit): Button {
    return ankoView(`$$Anko$Factories$Sdk25View`.BUTTON, theme) { init() }
}

fun ViewManager.button(text: CharSequence?): Button {
    return ankoView(`$$Anko$Factories$Sdk25View`.BUTTON, theme = 0) {
        setText(text)
    }
}

inline fun ViewManager.button(text: CharSequence?, init: (@AnkoViewDslMarker Button).() -> Unit): Button {
    return ankoView(`$$Anko$Factories$Sdk25View`.BUTTON, theme = 0) {
        init()
        setText(text)
    }
}

fun ViewManager.themedButton(text: CharSequence?, theme: Int): Button {
    return ankoView(`$$Anko$Factories$Sdk25View`.BUTTON, theme) {
        setText(text)
    }
}

inline fun ViewManager.themedButton(
    text: CharSequence?,
    theme: Int,
    init: (@AnkoViewDslMarker Button).() -> Unit
): Button {
    return ankoView(`$$Anko$Factories$Sdk25View`.BUTTON, theme) {
        init()
        setText(text)
    }
}

fun ViewManager.button(text: Int): Button {
    return ankoView(`$$Anko$Factories$Sdk25View`.BUTTON, theme = 0) {
        setText(text)
    }
}

inline fun ViewManager.button(text: Int, init: (@AnkoViewDslMarker Button).() -> Unit): Button {
    return ankoView(`$$Anko$Factories$Sdk25View`.BUTTON, theme = 0) {
        init()
        setText(text)
    }
}

fun ViewManager.themedButton(text: Int, theme: Int): Button {
    return ankoView(`$$Anko$Factories$Sdk25View`.BUTTON, theme) {
        setText(text)
    }
}

inline fun ViewManager.themedButton(text: Int, theme: Int, init: (@AnkoViewDslMarker Button).() -> Unit): Button {
    return ankoView(`$$Anko$Factories$Sdk25View`.BUTTON, theme) {
        init()
        setText(text)
    }
}

fun ViewManager.calendarView(): android.widget.CalendarView = calendarView() {}
inline fun ViewManager.calendarView(init: (@AnkoViewDslMarker android.widget.CalendarView).() -> Unit): android.widget.CalendarView {
    return ankoView(`$$Anko$Factories$Sdk25View`.CALENDAR_VIEW, theme = 0) { init() }
}

fun ViewManager.themedCalendarView(theme: Int = 0): android.widget.CalendarView = themedCalendarView(theme) {}
inline fun ViewManager.themedCalendarView(
    theme: Int = 0,
    init: (@AnkoViewDslMarker android.widget.CalendarView).() -> Unit
): android.widget.CalendarView {
    return ankoView(`$$Anko$Factories$Sdk25View`.CALENDAR_VIEW, theme) { init() }
}

fun Context.calendarView(): android.widget.CalendarView = calendarView() {}
inline fun Context.calendarView(init: (@AnkoViewDslMarker android.widget.CalendarView).() -> Unit): android.widget.CalendarView {
    return ankoView(`$$Anko$Factories$Sdk25View`.CALENDAR_VIEW, theme = 0) { init() }
}

fun Context.themedCalendarView(theme: Int = 0): android.widget.CalendarView = themedCalendarView(theme) {}
inline fun Context.themedCalendarView(
    theme: Int = 0,
    init: (@AnkoViewDslMarker android.widget.CalendarView).() -> Unit
): android.widget.CalendarView {
    return ankoView(`$$Anko$Factories$Sdk25View`.CALENDAR_VIEW, theme) { init() }
}

fun Activity.calendarView(): android.widget.CalendarView = calendarView() {}
inline fun Activity.calendarView(init: (@AnkoViewDslMarker android.widget.CalendarView).() -> Unit): android.widget.CalendarView {
    return ankoView(`$$Anko$Factories$Sdk25View`.CALENDAR_VIEW, theme = 0) { init() }
}

fun Activity.themedCalendarView(theme: Int = 0): android.widget.CalendarView = themedCalendarView(theme) {}
inline fun Activity.themedCalendarView(
    theme: Int = 0,
    init: (@AnkoViewDslMarker android.widget.CalendarView).() -> Unit
): android.widget.CalendarView {
    return ankoView(`$$Anko$Factories$Sdk25View`.CALENDAR_VIEW, theme) { init() }
}

fun ViewManager.checkBox(): CheckBox = checkBox() {}
inline fun ViewManager.checkBox(init: (@AnkoViewDslMarker CheckBox).() -> Unit): CheckBox {
    return ankoView(`$$Anko$Factories$Sdk25View`.CHECK_BOX, theme = 0) { init() }
}

fun ViewManager.themedCheckBox(theme: Int = 0): CheckBox = themedCheckBox(theme) {}
inline fun ViewManager.themedCheckBox(theme: Int = 0, init: (@AnkoViewDslMarker CheckBox).() -> Unit): CheckBox {
    return ankoView(`$$Anko$Factories$Sdk25View`.CHECK_BOX, theme) { init() }
}

fun ViewManager.checkBox(text: CharSequence?): CheckBox {
    return ankoView(`$$Anko$Factories$Sdk25View`.CHECK_BOX, theme = 0) {
        setText(text)
    }
}

inline fun ViewManager.checkBox(text: CharSequence?, init: (@AnkoViewDslMarker CheckBox).() -> Unit): CheckBox {
    return ankoView(`$$Anko$Factories$Sdk25View`.CHECK_BOX, theme = 0) {
        init()
        setText(text)
    }
}

fun ViewManager.themedCheckBox(text: CharSequence?, theme: Int): CheckBox {
    return ankoView(`$$Anko$Factories$Sdk25View`.CHECK_BOX, theme) {
        setText(text)
    }
}

inline fun ViewManager.themedCheckBox(
    text: CharSequence?,
    theme: Int,
    init: (@AnkoViewDslMarker CheckBox).() -> Unit
): CheckBox {
    return ankoView(`$$Anko$Factories$Sdk25View`.CHECK_BOX, theme) {
        init()
        setText(text)
    }
}

fun ViewManager.checkBox(text: Int): CheckBox {
    return ankoView(`$$Anko$Factories$Sdk25View`.CHECK_BOX, theme = 0) {
        setText(text)
    }
}

inline fun ViewManager.checkBox(text: Int, init: (@AnkoViewDslMarker CheckBox).() -> Unit): CheckBox {
    return ankoView(`$$Anko$Factories$Sdk25View`.CHECK_BOX, theme = 0) {
        init()
        setText(text)
    }
}

fun ViewManager.themedCheckBox(text: Int, theme: Int): CheckBox {
    return ankoView(`$$Anko$Factories$Sdk25View`.CHECK_BOX, theme) {
        setText(text)
    }
}

inline fun ViewManager.themedCheckBox(text: Int, theme: Int, init: (@AnkoViewDslMarker CheckBox).() -> Unit): CheckBox {
    return ankoView(`$$Anko$Factories$Sdk25View`.CHECK_BOX, theme) {
        init()
        setText(text)
    }
}

fun ViewManager.checkBox(text: CharSequence?, checked: Boolean): CheckBox {
    return ankoView(`$$Anko$Factories$Sdk25View`.CHECK_BOX, theme = 0) {
        setText(text)
        setChecked(checked)
    }
}

inline fun ViewManager.checkBox(
    text: CharSequence?,
    checked: Boolean,
    init: (@AnkoViewDslMarker CheckBox).() -> Unit
): CheckBox {
    return ankoView(`$$Anko$Factories$Sdk25View`.CHECK_BOX, theme = 0) {
        init()
        setText(text)
        setChecked(checked)
    }
}

fun ViewManager.themedCheckBox(text: CharSequence?, checked: Boolean, theme: Int): CheckBox {
    return ankoView(`$$Anko$Factories$Sdk25View`.CHECK_BOX, theme) {
        setText(text)
        setChecked(checked)
    }
}

inline fun ViewManager.themedCheckBox(
    text: CharSequence?,
    checked: Boolean,
    theme: Int,
    init: (@AnkoViewDslMarker CheckBox).() -> Unit
): CheckBox {
    return ankoView(`$$Anko$Factories$Sdk25View`.CHECK_BOX, theme) {
        init()
        setText(text)
        setChecked(checked)
    }
}

fun ViewManager.checkBox(text: Int, checked: Boolean): CheckBox {
    return ankoView(`$$Anko$Factories$Sdk25View`.CHECK_BOX, theme = 0) {
        setText(text)
        setChecked(checked)
    }
}

inline fun ViewManager.checkBox(text: Int, checked: Boolean, init: (@AnkoViewDslMarker CheckBox).() -> Unit): CheckBox {
    return ankoView(`$$Anko$Factories$Sdk25View`.CHECK_BOX, theme = 0) {
        init()
        setText(text)
        setChecked(checked)
    }
}

fun ViewManager.themedCheckBox(text: Int, checked: Boolean, theme: Int): CheckBox {
    return ankoView(`$$Anko$Factories$Sdk25View`.CHECK_BOX, theme) {
        setText(text)
        setChecked(checked)
    }
}

inline fun ViewManager.themedCheckBox(
    text: Int,
    checked: Boolean,
    theme: Int,
    init: (@AnkoViewDslMarker CheckBox).() -> Unit
): CheckBox {
    return ankoView(`$$Anko$Factories$Sdk25View`.CHECK_BOX, theme) {
        init()
        setText(text)
        setChecked(checked)
    }
}

fun ViewManager.checkedTextView(): android.widget.CheckedTextView = checkedTextView() {}
inline fun ViewManager.checkedTextView(init: (@AnkoViewDslMarker android.widget.CheckedTextView).() -> Unit): android.widget.CheckedTextView {
    return ankoView(`$$Anko$Factories$Sdk25View`.CHECKED_TEXT_VIEW, theme = 0) { init() }
}

fun ViewManager.themedCheckedTextView(theme: Int = 0): android.widget.CheckedTextView = themedCheckedTextView(theme) {}
inline fun ViewManager.themedCheckedTextView(
    theme: Int = 0,
    init: (@AnkoViewDslMarker android.widget.CheckedTextView).() -> Unit
): android.widget.CheckedTextView {
    return ankoView(`$$Anko$Factories$Sdk25View`.CHECKED_TEXT_VIEW, theme) { init() }
}

fun ViewManager.chronometer(): android.widget.Chronometer = chronometer() {}
inline fun ViewManager.chronometer(init: (@AnkoViewDslMarker android.widget.Chronometer).() -> Unit): android.widget.Chronometer {
    return ankoView(`$$Anko$Factories$Sdk25View`.CHRONOMETER, theme = 0) { init() }
}

fun ViewManager.themedChronometer(theme: Int = 0): android.widget.Chronometer = themedChronometer(theme) {}
inline fun ViewManager.themedChronometer(
    theme: Int = 0,
    init: (@AnkoViewDslMarker android.widget.Chronometer).() -> Unit
): android.widget.Chronometer {
    return ankoView(`$$Anko$Factories$Sdk25View`.CHRONOMETER, theme) { init() }
}

fun ViewManager.datePicker(): DatePicker = datePicker() {}
inline fun ViewManager.datePicker(init: (@AnkoViewDslMarker DatePicker).() -> Unit): DatePicker {
    return ankoView(`$$Anko$Factories$Sdk25View`.DATE_PICKER, theme = 0) { init() }
}

fun ViewManager.themedDatePicker(theme: Int = 0): DatePicker = themedDatePicker(theme) {}
inline fun ViewManager.themedDatePicker(theme: Int = 0, init: (@AnkoViewDslMarker DatePicker).() -> Unit): DatePicker {
    return ankoView(`$$Anko$Factories$Sdk25View`.DATE_PICKER, theme) { init() }
}

fun Context.datePicker(): DatePicker = datePicker() {}
inline fun Context.datePicker(init: (@AnkoViewDslMarker DatePicker).() -> Unit): DatePicker {
    return ankoView(`$$Anko$Factories$Sdk25View`.DATE_PICKER, theme = 0) { init() }
}

fun Context.themedDatePicker(theme: Int = 0): DatePicker = themedDatePicker(theme) {}
inline fun Context.themedDatePicker(theme: Int = 0, init: (@AnkoViewDslMarker DatePicker).() -> Unit): DatePicker {
    return ankoView(`$$Anko$Factories$Sdk25View`.DATE_PICKER, theme) { init() }
}

fun Activity.datePicker(): DatePicker = datePicker() {}
inline fun Activity.datePicker(init: (@AnkoViewDslMarker DatePicker).() -> Unit): DatePicker {
    return ankoView(`$$Anko$Factories$Sdk25View`.DATE_PICKER, theme = 0) { init() }
}

fun Activity.themedDatePicker(theme: Int = 0): DatePicker = themedDatePicker(theme) {}
inline fun Activity.themedDatePicker(theme: Int = 0, init: (@AnkoViewDslMarker DatePicker).() -> Unit): DatePicker {
    return ankoView(`$$Anko$Factories$Sdk25View`.DATE_PICKER, theme) { init() }
}

fun ViewManager.editText(): EditText = editText {}
inline fun ViewManager.editText(init: (@AnkoViewDslMarker EditText).() -> Unit): EditText {
    return ankoView(`$$Anko$Factories$Sdk25View`.EDIT_TEXT, theme = 0) { init() }
}

fun Context.editText(): EditText = editText {}
inline fun Context.editText(init: (@AnkoViewDslMarker EditText).() -> Unit): EditText {
    return ankoView(`$$Anko$Factories$Sdk25View`.EDIT_TEXT, theme = 0) { init() }
}

fun ViewManager.themedEditText(theme: Int = 0): EditText = themedEditText(theme) {}
inline fun ViewManager.themedEditText(theme: Int = 0, init: (@AnkoViewDslMarker EditText).() -> Unit): EditText {
    return ankoView(`$$Anko$Factories$Sdk25View`.EDIT_TEXT, theme) { init() }
}

fun ViewManager.editText(text: CharSequence?): EditText {
    return ankoView(`$$Anko$Factories$Sdk25View`.EDIT_TEXT, theme = 0) {
        setText(text)
    }
}

inline fun ViewManager.editText(text: CharSequence?, init: (@AnkoViewDslMarker EditText).() -> Unit): EditText {
    return ankoView(`$$Anko$Factories$Sdk25View`.EDIT_TEXT, theme = 0) {
        init()
        setText(text)
    }
}

fun ViewManager.themedEditText(text: CharSequence?, theme: Int): EditText {
    return ankoView(`$$Anko$Factories$Sdk25View`.EDIT_TEXT, theme) {
        setText(text)
    }
}

inline fun ViewManager.themedEditText(
    text: CharSequence?,
    theme: Int,
    init: (@AnkoViewDslMarker EditText).() -> Unit
): EditText {
    return ankoView(`$$Anko$Factories$Sdk25View`.EDIT_TEXT, theme) {
        init()
        setText(text)
    }
}

fun ViewManager.editText(text: Int): EditText {
    return ankoView(`$$Anko$Factories$Sdk25View`.EDIT_TEXT, theme = 0) {
        setText(text)
    }
}

inline fun ViewManager.editText(text: Int, init: (@AnkoViewDslMarker EditText).() -> Unit): EditText {
    return ankoView(`$$Anko$Factories$Sdk25View`.EDIT_TEXT, theme = 0) {
        init()
        setText(text)
    }
}

fun ViewManager.themedEditText(text: Int, theme: Int): EditText {
    return ankoView(`$$Anko$Factories$Sdk25View`.EDIT_TEXT, theme) {
        setText(text)
    }
}

inline fun ViewManager.themedEditText(text: Int, theme: Int, init: (@AnkoViewDslMarker EditText).() -> Unit): EditText {
    return ankoView(`$$Anko$Factories$Sdk25View`.EDIT_TEXT, theme) {
        init()
        setText(text)
    }
}

fun ViewManager.expandableListView(): ExpandableListView = expandableListView() {}
inline fun ViewManager.expandableListView(init: (@AnkoViewDslMarker ExpandableListView).() -> Unit): ExpandableListView {
    return ankoView(`$$Anko$Factories$Sdk25View`.EXPANDABLE_LIST_VIEW, theme = 0) { init() }
}

fun ViewManager.themedExpandableListView(theme: Int = 0): ExpandableListView = themedExpandableListView(theme) {}
inline fun ViewManager.themedExpandableListView(
    theme: Int = 0,
    init: (@AnkoViewDslMarker ExpandableListView).() -> Unit
): ExpandableListView {
    return ankoView(`$$Anko$Factories$Sdk25View`.EXPANDABLE_LIST_VIEW, theme) { init() }
}

fun Context.expandableListView(): ExpandableListView = expandableListView() {}
inline fun Context.expandableListView(init: (@AnkoViewDslMarker ExpandableListView).() -> Unit): ExpandableListView {
    return ankoView(`$$Anko$Factories$Sdk25View`.EXPANDABLE_LIST_VIEW, theme = 0) { init() }
}

fun Context.themedExpandableListView(theme: Int = 0): ExpandableListView = themedExpandableListView(theme) {}
inline fun Context.themedExpandableListView(
    theme: Int = 0,
    init: (@AnkoViewDslMarker ExpandableListView).() -> Unit
): ExpandableListView {
    return ankoView(`$$Anko$Factories$Sdk25View`.EXPANDABLE_LIST_VIEW, theme) { init() }
}

fun Activity.expandableListView(): ExpandableListView = expandableListView() {}
inline fun Activity.expandableListView(init: (@AnkoViewDslMarker ExpandableListView).() -> Unit): ExpandableListView {
    return ankoView(`$$Anko$Factories$Sdk25View`.EXPANDABLE_LIST_VIEW, theme = 0) { init() }
}

fun Activity.themedExpandableListView(theme: Int = 0): ExpandableListView = themedExpandableListView(theme) {}
inline fun Activity.themedExpandableListView(
    theme: Int = 0,
    init: (@AnkoViewDslMarker ExpandableListView).() -> Unit
): ExpandableListView {
    return ankoView(`$$Anko$Factories$Sdk25View`.EXPANDABLE_LIST_VIEW, theme) { init() }
}

fun ViewManager.imageButton(): ImageButton = imageButton {}
inline fun ViewManager.imageButton(init: (@AnkoViewDslMarker ImageButton).() -> Unit): ImageButton {
    return ankoView(`$$Anko$Factories$Sdk25View`.IMAGE_BUTTON, theme = 0) { init() }
}

fun ViewManager.themedImageButton(theme: Int = 0): ImageButton = themedImageButton(theme) {}
inline fun ViewManager.themedImageButton(
    theme: Int = 0,
    init: (@AnkoViewDslMarker ImageButton).() -> Unit
): ImageButton {
    return ankoView(`$$Anko$Factories$Sdk25View`.IMAGE_BUTTON, theme) { init() }
}

fun ViewManager.imageButton(imageDrawable: android.graphics.drawable.Drawable?): ImageButton {
    return ankoView(`$$Anko$Factories$Sdk25View`.IMAGE_BUTTON, theme = 0) {
        setImageDrawable(imageDrawable)
    }
}

inline fun ViewManager.imageButton(
    imageDrawable: android.graphics.drawable.Drawable?,
    init: (@AnkoViewDslMarker ImageButton).() -> Unit
): ImageButton {
    return ankoView(`$$Anko$Factories$Sdk25View`.IMAGE_BUTTON, theme = 0) {
        init()
        setImageDrawable(imageDrawable)
    }
}

fun ViewManager.themedImageButton(imageDrawable: android.graphics.drawable.Drawable?, theme: Int): ImageButton {
    return ankoView(`$$Anko$Factories$Sdk25View`.IMAGE_BUTTON, theme) {
        setImageDrawable(imageDrawable)
    }
}

inline fun ViewManager.themedImageButton(
    imageDrawable: android.graphics.drawable.Drawable?,
    theme: Int,
    init: (@AnkoViewDslMarker ImageButton).() -> Unit
): ImageButton {
    return ankoView(`$$Anko$Factories$Sdk25View`.IMAGE_BUTTON, theme) {
        init()
        setImageDrawable(imageDrawable)
    }
}

fun ViewManager.imageButton(imageResource: Int): ImageButton {
    return ankoView(`$$Anko$Factories$Sdk25View`.IMAGE_BUTTON, theme = 0) {
        setImageResource(imageResource)
    }
}

inline fun ViewManager.imageButton(imageResource: Int, init: (@AnkoViewDslMarker ImageButton).() -> Unit): ImageButton {
    return ankoView(`$$Anko$Factories$Sdk25View`.IMAGE_BUTTON, theme = 0) {
        init()
        setImageResource(imageResource)
    }
}

fun ViewManager.themedImageButton(imageResource: Int, theme: Int): ImageButton {
    return ankoView(`$$Anko$Factories$Sdk25View`.IMAGE_BUTTON, theme) {
        setImageResource(imageResource)
    }
}

inline fun ViewManager.themedImageButton(
    imageResource: Int,
    theme: Int,
    init: (@AnkoViewDslMarker ImageButton).() -> Unit
): ImageButton {
    return ankoView(`$$Anko$Factories$Sdk25View`.IMAGE_BUTTON, theme) {
        init()
        setImageResource(imageResource)
    }
}

fun ViewManager.imageView(): ImageView = imageView() {}
inline fun ViewManager.imageView(init: (@AnkoViewDslMarker ImageView).() -> Unit): ImageView {
    return ankoView(`$$Anko$Factories$Sdk25View`.IMAGE_VIEW, theme = 0) { init() }
}

fun ViewManager.themedImageView(theme: Int = 0): ImageView = themedImageView(theme) {}
inline fun ViewManager.themedImageView(theme: Int = 0, init: (@AnkoViewDslMarker ImageView).() -> Unit): ImageView {
    return ankoView(`$$Anko$Factories$Sdk25View`.IMAGE_VIEW, theme) { init() }
}

fun ViewManager.imageView(imageDrawable: android.graphics.drawable.Drawable?): ImageView {
    return ankoView(`$$Anko$Factories$Sdk25View`.IMAGE_VIEW, theme = 0) {
        setImageDrawable(imageDrawable)
    }
}

inline fun ViewManager.imageView(
    imageDrawable: android.graphics.drawable.Drawable?,
    init: (@AnkoViewDslMarker ImageView).() -> Unit
): ImageView {
    return ankoView(`$$Anko$Factories$Sdk25View`.IMAGE_VIEW, theme = 0) {
        init()
        setImageDrawable(imageDrawable)
    }
}

fun ViewManager.themedImageView(imageDrawable: android.graphics.drawable.Drawable?, theme: Int): ImageView {
    return ankoView(`$$Anko$Factories$Sdk25View`.IMAGE_VIEW, theme) {
        setImageDrawable(imageDrawable)
    }
}

inline fun ViewManager.themedImageView(
    imageDrawable: android.graphics.drawable.Drawable?,
    theme: Int,
    init: (@AnkoViewDslMarker ImageView).() -> Unit
): ImageView {
    return ankoView(`$$Anko$Factories$Sdk25View`.IMAGE_VIEW, theme) {
        init()
        setImageDrawable(imageDrawable)
    }
}

fun ViewManager.imageView(imageResource: Int): ImageView {
    return ankoView(`$$Anko$Factories$Sdk25View`.IMAGE_VIEW, theme = 0) {
        setImageResource(imageResource)
    }
}

inline fun ViewManager.imageView(imageResource: Int, init: (@AnkoViewDslMarker ImageView).() -> Unit): ImageView {
    return ankoView(`$$Anko$Factories$Sdk25View`.IMAGE_VIEW, theme = 0) {
        init()
        setImageResource(imageResource)
    }
}

fun ViewManager.themedImageView(imageResource: Int, theme: Int): ImageView {
    return ankoView(`$$Anko$Factories$Sdk25View`.IMAGE_VIEW, theme) {
        setImageResource(imageResource)
    }
}

inline fun ViewManager.themedImageView(
    imageResource: Int,
    theme: Int,
    init: (@AnkoViewDslMarker ImageView).() -> Unit
): ImageView {
    return ankoView(`$$Anko$Factories$Sdk25View`.IMAGE_VIEW, theme) {
        init()
        setImageResource(imageResource)
    }
}

fun ViewManager.listView(): android.widget.ListView = listView() {}
inline fun ViewManager.listView(init: (@AnkoViewDslMarker android.widget.ListView).() -> Unit): android.widget.ListView {
    return ankoView(`$$Anko$Factories$Sdk25View`.LIST_VIEW, theme = 0) { init() }
}

fun ViewManager.themedListView(theme: Int = 0): android.widget.ListView = themedListView(theme) {}
inline fun ViewManager.themedListView(theme: Int = 0, init: (@AnkoViewDslMarker android.widget.ListView).() -> Unit): android.widget.ListView {
    return ankoView(`$$Anko$Factories$Sdk25View`.LIST_VIEW, theme) { init() }
}

fun Context.listView(): android.widget.ListView = listView() {}
inline fun Context.listView(init: (@AnkoViewDslMarker android.widget.ListView).() -> Unit): android.widget.ListView {
    return ankoView(`$$Anko$Factories$Sdk25View`.LIST_VIEW, theme = 0) { init() }
}

fun Context.themedListView(theme: Int = 0): android.widget.ListView = themedListView(theme) {}
inline fun Context.themedListView(theme: Int = 0, init: (@AnkoViewDslMarker android.widget.ListView).() -> Unit): android.widget.ListView {
    return ankoView(`$$Anko$Factories$Sdk25View`.LIST_VIEW, theme) { init() }
}

fun Activity.listView(): android.widget.ListView = listView() {}
inline fun Activity.listView(init: (@AnkoViewDslMarker android.widget.ListView).() -> Unit): android.widget.ListView {
    return ankoView(`$$Anko$Factories$Sdk25View`.LIST_VIEW, theme = 0) { init() }
}

fun Activity.themedListView(theme: Int = 0): android.widget.ListView = themedListView(theme) {}
inline fun Activity.themedListView(theme: Int = 0, init: (@AnkoViewDslMarker android.widget.ListView).() -> Unit): android.widget.ListView {
    return ankoView(`$$Anko$Factories$Sdk25View`.LIST_VIEW, theme) { init() }
}

fun ViewManager.multiAutoCompleteTextView(): MultiAutoCompleteTextView = multiAutoCompleteTextView() {}
inline fun ViewManager.multiAutoCompleteTextView(init: (@AnkoViewDslMarker MultiAutoCompleteTextView).() -> Unit): MultiAutoCompleteTextView {
    return ankoView(`$$Anko$Factories$Sdk25View`.MULTI_AUTO_COMPLETE_TEXT_VIEW, theme = 0) { init() }
}

fun ViewManager.themedMultiAutoCompleteTextView(theme: Int = 0): MultiAutoCompleteTextView =
    themedMultiAutoCompleteTextView(theme) {}

inline fun ViewManager.themedMultiAutoCompleteTextView(
    theme: Int = 0,
    init: (@AnkoViewDslMarker MultiAutoCompleteTextView).() -> Unit
): MultiAutoCompleteTextView {
    return ankoView(`$$Anko$Factories$Sdk25View`.MULTI_AUTO_COMPLETE_TEXT_VIEW, theme) { init() }
}

fun ViewManager.numberPicker(): NumberPicker = numberPicker() {}
inline fun ViewManager.numberPicker(init: (@AnkoViewDslMarker NumberPicker).() -> Unit): NumberPicker {
    return ankoView(`$$Anko$Factories$Sdk25View`.NUMBER_PICKER, theme = 0) { init() }
}

fun ViewManager.themedNumberPicker(theme: Int = 0): NumberPicker = themedNumberPicker(theme) {}
inline fun ViewManager.themedNumberPicker(
    theme: Int = 0,
    init: (@AnkoViewDslMarker NumberPicker).() -> Unit
): NumberPicker {
    return ankoView(`$$Anko$Factories$Sdk25View`.NUMBER_PICKER, theme) { init() }
}

fun Context.numberPicker(): NumberPicker = numberPicker() {}
inline fun Context.numberPicker(init: (@AnkoViewDslMarker NumberPicker).() -> Unit): NumberPicker {
    return ankoView(`$$Anko$Factories$Sdk25View`.NUMBER_PICKER, theme = 0) { init() }
}

fun Context.themedNumberPicker(theme: Int = 0): NumberPicker = themedNumberPicker(theme) {}
inline fun Context.themedNumberPicker(
    theme: Int = 0,
    init: (@AnkoViewDslMarker NumberPicker).() -> Unit
): NumberPicker {
    return ankoView(`$$Anko$Factories$Sdk25View`.NUMBER_PICKER, theme) { init() }
}

fun Activity.numberPicker(): NumberPicker = numberPicker() {}
inline fun Activity.numberPicker(init: (@AnkoViewDslMarker NumberPicker).() -> Unit): NumberPicker {
    return ankoView(`$$Anko$Factories$Sdk25View`.NUMBER_PICKER, theme = 0) { init() }
}

fun Activity.themedNumberPicker(theme: Int = 0): NumberPicker = themedNumberPicker(theme) {}
inline fun Activity.themedNumberPicker(
    theme: Int = 0,
    init: (@AnkoViewDslMarker NumberPicker).() -> Unit
): NumberPicker {
    return ankoView(`$$Anko$Factories$Sdk25View`.NUMBER_PICKER, theme) { init() }
}

fun ViewManager.progressBar(): ProgressBar = progressBar() {}
inline fun ViewManager.progressBar(init: (@AnkoViewDslMarker ProgressBar).() -> Unit): ProgressBar {
    return ankoView(`$$Anko$Factories$Sdk25View`.PROGRESS_BAR, theme = 0) { init() }
}

fun ViewManager.themedProgressBar(theme: Int = 0): ProgressBar = themedProgressBar(theme) {}
inline fun ViewManager.themedProgressBar(
    theme: Int = 0,
    init: (@AnkoViewDslMarker ProgressBar).() -> Unit
): ProgressBar {
    return ankoView(`$$Anko$Factories$Sdk25View`.PROGRESS_BAR, theme) { init() }
}

fun ViewManager.quickContactBadge(): android.widget.QuickContactBadge = quickContactBadge() {}
inline fun ViewManager.quickContactBadge(init: (@AnkoViewDslMarker android.widget.QuickContactBadge).() -> Unit): android.widget.QuickContactBadge {
    return ankoView(`$$Anko$Factories$Sdk25View`.QUICK_CONTACT_BADGE, theme = 0) { init() }
}

fun ViewManager.themedQuickContactBadge(theme: Int = 0): android.widget.QuickContactBadge = themedQuickContactBadge(theme) {}
inline fun ViewManager.themedQuickContactBadge(
    theme: Int = 0,
    init: (@AnkoViewDslMarker android.widget.QuickContactBadge).() -> Unit
): android.widget.QuickContactBadge {
    return ankoView(`$$Anko$Factories$Sdk25View`.QUICK_CONTACT_BADGE, theme) { init() }
}

fun ViewManager.radioButton(): android.widget.RadioButton = radioButton() {}
inline fun ViewManager.radioButton(init: (@AnkoViewDslMarker android.widget.RadioButton).() -> Unit): android.widget.RadioButton {
    return ankoView(`$$Anko$Factories$Sdk25View`.RADIO_BUTTON, theme = 0) { init() }
}

fun ViewManager.themedRadioButton(theme: Int = 0): android.widget.RadioButton = themedRadioButton(theme) {}
inline fun ViewManager.themedRadioButton(
    theme: Int = 0,
    init: (@AnkoViewDslMarker android.widget.RadioButton).() -> Unit
): android.widget.RadioButton {
    return ankoView(`$$Anko$Factories$Sdk25View`.RADIO_BUTTON, theme) { init() }
}

fun ViewManager.ratingBar(): android.widget.RatingBar = ratingBar() {}
inline fun ViewManager.ratingBar(init: (@AnkoViewDslMarker android.widget.RatingBar).() -> Unit): android.widget.RatingBar {
    return ankoView(`$$Anko$Factories$Sdk25View`.RATING_BAR, theme = 0) { init() }
}

fun ViewManager.themedRatingBar(theme: Int = 0): android.widget.RatingBar = themedRatingBar(theme) {}
inline fun ViewManager.themedRatingBar(theme: Int = 0, init: (@AnkoViewDslMarker android.widget.RatingBar).() -> Unit): android.widget.RatingBar {
    return ankoView(`$$Anko$Factories$Sdk25View`.RATING_BAR, theme) { init() }
}

fun ViewManager.searchView(): SearchView = searchView() {}
inline fun ViewManager.searchView(init: (@AnkoViewDslMarker SearchView).() -> Unit): SearchView {
    return ankoView(`$$Anko$Factories$Sdk25View`.SEARCH_VIEW, theme = 0) { init() }
}

fun ViewManager.themedSearchView(theme: Int = 0): SearchView = themedSearchView(theme) {}
inline fun ViewManager.themedSearchView(theme: Int = 0, init: (@AnkoViewDslMarker SearchView).() -> Unit): SearchView {
    return ankoView(`$$Anko$Factories$Sdk25View`.SEARCH_VIEW, theme) { init() }
}

fun Context.searchView(): SearchView = searchView() {}
inline fun Context.searchView(init: (@AnkoViewDslMarker SearchView).() -> Unit): SearchView {
    return ankoView(`$$Anko$Factories$Sdk25View`.SEARCH_VIEW, theme = 0) { init() }
}

fun Context.themedSearchView(theme: Int = 0): SearchView = themedSearchView(theme) {}
inline fun Context.themedSearchView(theme: Int = 0, init: (@AnkoViewDslMarker SearchView).() -> Unit): SearchView {
    return ankoView(`$$Anko$Factories$Sdk25View`.SEARCH_VIEW, theme) { init() }
}

fun Activity.searchView(): SearchView = searchView() {}
inline fun Activity.searchView(init: (@AnkoViewDslMarker SearchView).() -> Unit): SearchView {
    return ankoView(`$$Anko$Factories$Sdk25View`.SEARCH_VIEW, theme = 0) { init() }
}

fun Activity.themedSearchView(theme: Int = 0): SearchView = themedSearchView(theme) {}
inline fun Activity.themedSearchView(theme: Int = 0, init: (@AnkoViewDslMarker SearchView).() -> Unit): SearchView {
    return ankoView(`$$Anko$Factories$Sdk25View`.SEARCH_VIEW, theme) { init() }
}

fun ViewManager.seekBar(): SeekBar = seekBar() {}
inline fun ViewManager.seekBar(init: (@AnkoViewDslMarker SeekBar).() -> Unit): SeekBar {
    return ankoView(`$$Anko$Factories$Sdk25View`.SEEK_BAR, theme = 0) { init() }
}

fun ViewManager.themedSeekBar(theme: Int = 0): SeekBar = themedSeekBar(theme) {}
inline fun ViewManager.themedSeekBar(theme: Int = 0, init: (@AnkoViewDslMarker SeekBar).() -> Unit): SeekBar {
    return ankoView(`$$Anko$Factories$Sdk25View`.SEEK_BAR, theme) { init() }
}

fun ViewManager.space(): Space = space() {}
inline fun ViewManager.space(init: (@AnkoViewDslMarker Space).() -> Unit): Space {
    return ankoView(`$$Anko$Factories$Sdk25View`.SPACE, theme = 0) { init() }
}

fun ViewManager.themedSpace(theme: Int = 0): Space = themedSpace(theme) {}
inline fun ViewManager.themedSpace(theme: Int = 0, init: (@AnkoViewDslMarker Space).() -> Unit): Space {
    return ankoView(`$$Anko$Factories$Sdk25View`.SPACE, theme) { init() }
}

fun ViewManager.spinner(): Spinner = spinner() {}
inline fun ViewManager.spinner(init: (@AnkoViewDslMarker Spinner).() -> Unit): Spinner {
    return ankoView(`$$Anko$Factories$Sdk25View`.SPINNER, theme = 0) { init() }
}

fun ViewManager.themedSpinner(theme: Int = 0): Spinner = themedSpinner(theme) {}
inline fun ViewManager.themedSpinner(theme: Int = 0, init: (@AnkoViewDslMarker Spinner).() -> Unit): Spinner {
    return ankoView(`$$Anko$Factories$Sdk25View`.SPINNER, theme) { init() }
}

fun Context.spinner(): Spinner = spinner {}
inline fun Context.spinner(init: (@AnkoViewDslMarker Spinner).() -> Unit): Spinner {
    return ankoView(`$$Anko$Factories$Sdk25View`.SPINNER, theme = 0) { init() }
}

fun Context.themedSpinner(theme: Int = 0): Spinner = themedSpinner(theme) {}
inline fun Context.themedSpinner(theme: Int = 0, init: (@AnkoViewDslMarker Spinner).() -> Unit): Spinner {
    return ankoView(`$$Anko$Factories$Sdk25View`.SPINNER, theme) { init() }
}

fun Activity.spinner(): Spinner = spinner {}
inline fun Activity.spinner(init: (@AnkoViewDslMarker Spinner).() -> Unit): Spinner {
    return ankoView(`$$Anko$Factories$Sdk25View`.SPINNER, theme = 0) { init() }
}

fun Activity.themedSpinner(theme: Int = 0): Spinner = themedSpinner(theme) {}
inline fun Activity.themedSpinner(theme: Int = 0, init: (@AnkoViewDslMarker Spinner).() -> Unit): Spinner {
    return ankoView(`$$Anko$Factories$Sdk25View`.SPINNER, theme) { init() }
}

fun ViewManager.stackView(): StackView = stackView {}
inline fun ViewManager.stackView(init: (@AnkoViewDslMarker StackView).() -> Unit): StackView {
    return ankoView(`$$Anko$Factories$Sdk25View`.STACK_VIEW, theme = 0) { init() }
}

fun ViewManager.themedStackView(theme: Int = 0): StackView = themedStackView(theme) {}
inline fun ViewManager.themedStackView(theme: Int = 0, init: (@AnkoViewDslMarker StackView).() -> Unit): StackView {
    return ankoView(`$$Anko$Factories$Sdk25View`.STACK_VIEW, theme) { init() }
}

fun Context.stackView(): StackView = stackView {}
inline fun Context.stackView(init: (@AnkoViewDslMarker StackView).() -> Unit): StackView {
    return ankoView(`$$Anko$Factories$Sdk25View`.STACK_VIEW, theme = 0) { init() }
}

fun Context.themedStackView(theme: Int = 0): StackView = themedStackView(theme) {}
inline fun Context.themedStackView(theme: Int = 0, init: (@AnkoViewDslMarker StackView).() -> Unit): StackView {
    return ankoView(`$$Anko$Factories$Sdk25View`.STACK_VIEW, theme) { init() }
}

fun Activity.stackView(): StackView = stackView {}
inline fun Activity.stackView(init: (@AnkoViewDslMarker StackView).() -> Unit): StackView {
    return ankoView(`$$Anko$Factories$Sdk25View`.STACK_VIEW, theme = 0) { init() }
}

fun Activity.themedStackView(theme: Int = 0): StackView = themedStackView(theme) {}
inline fun Activity.themedStackView(theme: Int = 0, init: (@AnkoViewDslMarker StackView).() -> Unit): StackView {
    return ankoView(`$$Anko$Factories$Sdk25View`.STACK_VIEW, theme) { init() }
}

fun ViewManager.switch(): Switch = switch {}
inline fun ViewManager.switch(init: (@AnkoViewDslMarker Switch).() -> Unit): Switch {
    return ankoView(`$$Anko$Factories$Sdk25View`.SWITCH, theme = 0) { init() }
}

fun ViewManager.themedSwitch(theme: Int = 0): Switch = themedSwitch(theme) {}
inline fun ViewManager.themedSwitch(theme: Int = 0, init: (@AnkoViewDslMarker Switch).() -> Unit): Switch {
    return ankoView(`$$Anko$Factories$Sdk25View`.SWITCH, theme) { init() }
}

fun ViewManager.textClock(): TextClock = textClock {}
inline fun ViewManager.textClock(init: (@AnkoViewDslMarker TextClock).() -> Unit): TextClock {
    return ankoView(`$$Anko$Factories$Sdk25View`.TEXT_CLOCK, theme = 0) { init() }
}

fun ViewManager.themedTextClock(theme: Int = 0): TextClock = themedTextClock(theme) {}
inline fun ViewManager.themedTextClock(theme: Int = 0, init: (@AnkoViewDslMarker TextClock).() -> Unit): TextClock {
    return ankoView(`$$Anko$Factories$Sdk25View`.TEXT_CLOCK, theme) { init() }
}

fun ViewManager.textView(): TextView = textView() {}
inline fun ViewManager.textView(init: (@AnkoViewDslMarker TextView).() -> Unit): TextView {
    return ankoView(`$$Anko$Factories$Sdk25View`.TEXT_VIEW, theme = 0) { init() }
}

fun ViewManager.themedTextView(theme: Int = 0): TextView = themedTextView(theme) {}
inline fun ViewManager.themedTextView(theme: Int = 0, init: (@AnkoViewDslMarker TextView).() -> Unit): TextView {
    return ankoView(`$$Anko$Factories$Sdk25View`.TEXT_VIEW, theme) { init() }
}

fun ViewManager.textView(text: CharSequence?): TextView {
    return ankoView(`$$Anko$Factories$Sdk25View`.TEXT_VIEW, theme = 0) {
        setText(text)
    }
}

inline fun ViewManager.textView(text: CharSequence?, init: (@AnkoViewDslMarker TextView).() -> Unit): TextView {
    return ankoView(`$$Anko$Factories$Sdk25View`.TEXT_VIEW, theme = 0) {
        init()
        setText(text)
    }
}

fun ViewManager.themedTextView(text: CharSequence?, theme: Int): TextView {
    return ankoView(`$$Anko$Factories$Sdk25View`.TEXT_VIEW, theme) {
        setText(text)
    }
}

inline fun ViewManager.themedTextView(
    text: CharSequence?,
    theme: Int,
    init: (@AnkoViewDslMarker TextView).() -> Unit
): TextView {
    return ankoView(`$$Anko$Factories$Sdk25View`.TEXT_VIEW, theme) {
        init()
        setText(text)
    }
}

fun ViewManager.textView(text: Int): TextView {
    return ankoView(`$$Anko$Factories$Sdk25View`.TEXT_VIEW, theme = 0) {
        setText(text)
    }
}

inline fun ViewManager.textView(text: Int, init: (@AnkoViewDslMarker TextView).() -> Unit): TextView {
    return ankoView(`$$Anko$Factories$Sdk25View`.TEXT_VIEW, theme = 0) {
        init()
        setText(text)
    }
}

fun ViewManager.themedTextView(text: Int, theme: Int): TextView {
    return ankoView(`$$Anko$Factories$Sdk25View`.TEXT_VIEW, theme) {
        setText(text)
    }
}

inline fun ViewManager.themedTextView(text: Int, theme: Int, init: (@AnkoViewDslMarker TextView).() -> Unit): TextView {
    return ankoView(`$$Anko$Factories$Sdk25View`.TEXT_VIEW, theme) {
        init()
        setText(text)
    }
}

fun ViewManager.timePicker(): TimePicker = timePicker {}
inline fun ViewManager.timePicker(init: (@AnkoViewDslMarker TimePicker).() -> Unit): TimePicker {
    return ankoView(`$$Anko$Factories$Sdk25View`.TIME_PICKER, theme = 0) { init() }
}

fun ViewManager.themedTimePicker(theme: Int = 0): TimePicker = themedTimePicker(theme) {}
inline fun ViewManager.themedTimePicker(theme: Int = 0, init: (@AnkoViewDslMarker TimePicker).() -> Unit): TimePicker {
    return ankoView(`$$Anko$Factories$Sdk25View`.TIME_PICKER, theme) { init() }
}

fun Context.timePicker(): TimePicker = timePicker {}
inline fun Context.timePicker(init: (@AnkoViewDslMarker TimePicker).() -> Unit): TimePicker {
    return ankoView(`$$Anko$Factories$Sdk25View`.TIME_PICKER, theme = 0) { init() }
}

fun Context.themedTimePicker(theme: Int = 0): TimePicker = themedTimePicker(theme) {}
inline fun Context.themedTimePicker(theme: Int = 0, init: (@AnkoViewDslMarker TimePicker).() -> Unit): TimePicker {
    return ankoView(`$$Anko$Factories$Sdk25View`.TIME_PICKER, theme) { init() }
}

fun Activity.timePicker(): TimePicker = timePicker {}
inline fun Activity.timePicker(init: (@AnkoViewDslMarker TimePicker).() -> Unit): TimePicker {
    return ankoView(`$$Anko$Factories$Sdk25View`.TIME_PICKER, theme = 0) { init() }
}

fun Activity.themedTimePicker(theme: Int = 0): TimePicker = themedTimePicker(theme) {}
inline fun Activity.themedTimePicker(theme: Int = 0, init: (@AnkoViewDslMarker TimePicker).() -> Unit): TimePicker {
    return ankoView(`$$Anko$Factories$Sdk25View`.TIME_PICKER, theme) { init() }
}

fun ViewManager.toggleButton(): ToggleButton = toggleButton {}
inline fun ViewManager.toggleButton(init: (@AnkoViewDslMarker ToggleButton).() -> Unit): ToggleButton {
    return ankoView(`$$Anko$Factories$Sdk25View`.TOGGLE_BUTTON, theme = 0) { init() }
}

fun ViewManager.themedToggleButton(theme: Int = 0): ToggleButton = themedToggleButton(theme) {}
inline fun ViewManager.themedToggleButton(
    theme: Int = 0,
    init: (@AnkoViewDslMarker ToggleButton).() -> Unit
): ToggleButton {
    return ankoView(`$$Anko$Factories$Sdk25View`.TOGGLE_BUTTON, theme) { init() }
}

fun ViewManager.videoView(): VideoView = videoView {}
inline fun ViewManager.videoView(init: (@AnkoViewDslMarker VideoView).() -> Unit): VideoView {
    return ankoView(`$$Anko$Factories$Sdk25View`.VIDEO_VIEW, theme = 0) { init() }
}

fun ViewManager.themedVideoView(theme: Int = 0): VideoView = themedVideoView(theme) {}
inline fun ViewManager.themedVideoView(theme: Int = 0, init: (@AnkoViewDslMarker VideoView).() -> Unit): VideoView {
    return ankoView(`$$Anko$Factories$Sdk25View`.VIDEO_VIEW, theme) { init() }
}

fun ViewManager.viewFlipper(): ViewFlipper = viewFlipper {}
inline fun ViewManager.viewFlipper(init: (@AnkoViewDslMarker ViewFlipper).() -> Unit): ViewFlipper {
    return ankoView(`$$Anko$Factories$Sdk25View`.VIEW_FLIPPER, theme = 0) { init() }
}

fun ViewManager.themedViewFlipper(theme: Int = 0): ViewFlipper = themedViewFlipper(theme) {}
inline fun ViewManager.themedViewFlipper(
    theme: Int = 0,
    init: (@AnkoViewDslMarker ViewFlipper).() -> Unit
): ViewFlipper {
    return ankoView(`$$Anko$Factories$Sdk25View`.VIEW_FLIPPER, theme) { init() }
}

fun Context.viewFlipper(): ViewFlipper = viewFlipper {}
inline fun Context.viewFlipper(init: (@AnkoViewDslMarker ViewFlipper).() -> Unit): ViewFlipper {
    return ankoView(`$$Anko$Factories$Sdk25View`.VIEW_FLIPPER, theme = 0) { init() }
}

fun Context.themedViewFlipper(theme: Int = 0): ViewFlipper = themedViewFlipper(theme) {}
inline fun Context.themedViewFlipper(theme: Int = 0, init: (@AnkoViewDslMarker ViewFlipper).() -> Unit): ViewFlipper {
    return ankoView(`$$Anko$Factories$Sdk25View`.VIEW_FLIPPER, theme) { init() }
}

fun Activity.viewFlipper(): ViewFlipper = viewFlipper {}
inline fun Activity.viewFlipper(init: (@AnkoViewDslMarker ViewFlipper).() -> Unit): ViewFlipper {
    return ankoView(`$$Anko$Factories$Sdk25View`.VIEW_FLIPPER, theme = 0) { init() }
}

fun Activity.themedViewFlipper(theme: Int = 0): ViewFlipper = themedViewFlipper(theme) {}
inline fun Activity.themedViewFlipper(theme: Int = 0, init: (@AnkoViewDslMarker ViewFlipper).() -> Unit): ViewFlipper {
    return ankoView(`$$Anko$Factories$Sdk25View`.VIEW_FLIPPER, theme) { init() }
}

@PublishedApi
internal object `$$Anko$Factories$Sdk25ViewGroup` {
    val ACTION_MENU_VIEW = { ctx: Context -> _ActionMenuView(ctx) }
    val FRAME_LAYOUT = { ctx: Context -> _FrameLayout(ctx) }
    val GRID_LAYOUT = { ctx: Context -> _GridLayout(ctx) }
    val GRID_VIEW = { ctx: Context -> _GridView(ctx) }
    val HORIZONTAL_SCROLL_VIEW = { ctx: Context -> _HorizontalScrollView(ctx) }
    val IMAGE_SWITCHER = { ctx: Context -> _ImageSwitcher(ctx) }
    val LINEAR_LAYOUT = { ctx: Context -> _LinearLayout(ctx) }
    val RADIO_GROUP = { ctx: Context -> _RadioGroup(ctx) }
    val RELATIVE_LAYOUT = { ctx: Context -> _RelativeLayout(ctx) }
    val SCROLL_VIEW = { ctx: Context -> _ScrollView(ctx) }
    val TABLE_LAYOUT = { ctx: Context -> _TableLayout(ctx) }
    val TABLE_ROW = { ctx: Context -> _TableRow(ctx) }
    val TEXT_SWITCHER = { ctx: Context -> _TextSwitcher(ctx) }
    val TOOLBAR = { ctx: Context -> _Toolbar(ctx) }
    val VIEW_ANIMATOR = { ctx: Context -> _ViewAnimator(ctx) }
    val VIEW_SWITCHER = { ctx: Context -> _ViewSwitcher(ctx) }
}

fun ViewManager.actionMenuView(): ActionMenuView = actionMenuView() {}
inline fun ViewManager.actionMenuView(init: (@AnkoViewDslMarker _ActionMenuView).() -> Unit): ActionMenuView {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.ACTION_MENU_VIEW, theme = 0) { init() }
}

fun ViewManager.themedActionMenuView(theme: Int = 0): ActionMenuView = themedActionMenuView(theme) {}
inline fun ViewManager.themedActionMenuView(theme: Int = 0, init: (@AnkoViewDslMarker _ActionMenuView).() -> Unit): ActionMenuView {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.ACTION_MENU_VIEW, theme) { init() }
}

fun Context.actionMenuView(): ActionMenuView = actionMenuView() {}
inline fun Context.actionMenuView(init: (@AnkoViewDslMarker _ActionMenuView).() -> Unit): ActionMenuView {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.ACTION_MENU_VIEW, theme = 0) { init() }
}

fun Context.themedActionMenuView(theme: Int = 0): ActionMenuView = themedActionMenuView(theme) {}
inline fun Context.themedActionMenuView(theme: Int = 0, init: (@AnkoViewDslMarker _ActionMenuView).() -> Unit): ActionMenuView {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.ACTION_MENU_VIEW, theme) { init() }
}

fun Activity.actionMenuView(): ActionMenuView = actionMenuView() {}
inline fun Activity.actionMenuView(init: (@AnkoViewDslMarker _ActionMenuView).() -> Unit): ActionMenuView {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.ACTION_MENU_VIEW, theme = 0) { init() }
}

fun Activity.themedActionMenuView(theme: Int = 0): ActionMenuView = themedActionMenuView(theme) {}
inline fun Activity.themedActionMenuView(theme: Int = 0, init: (@AnkoViewDslMarker _ActionMenuView).() -> Unit): ActionMenuView {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.ACTION_MENU_VIEW, theme) { init() }
}

fun ViewManager.frameLayout(): FrameLayout = frameLayout() {}
inline fun ViewManager.frameLayout(init: (@AnkoViewDslMarker _FrameLayout).() -> Unit): FrameLayout {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.FRAME_LAYOUT, theme = 0) { init() }
}

fun ViewManager.themedFrameLayout(theme: Int = 0): FrameLayout = themedFrameLayout(theme) {}
inline fun ViewManager.themedFrameLayout(theme: Int = 0, init: (@AnkoViewDslMarker _FrameLayout).() -> Unit): FrameLayout {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.FRAME_LAYOUT, theme) { init() }
}

fun Context.frameLayout(): FrameLayout = frameLayout() {}
inline fun Context.frameLayout(init: (@AnkoViewDslMarker _FrameLayout).() -> Unit): FrameLayout {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.FRAME_LAYOUT, theme = 0) { init() }
}

fun Context.themedFrameLayout(theme: Int = 0): FrameLayout = themedFrameLayout(theme) {}
inline fun Context.themedFrameLayout(theme: Int = 0, init: (@AnkoViewDslMarker _FrameLayout).() -> Unit): FrameLayout {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.FRAME_LAYOUT, theme) { init() }
}

fun Activity.frameLayout(): FrameLayout = frameLayout {}
inline fun Activity.frameLayout(init: (@AnkoViewDslMarker _FrameLayout).() -> Unit): FrameLayout {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.FRAME_LAYOUT, theme = 0) { init() }
}

fun Activity.themedFrameLayout(theme: Int = 0): FrameLayout = themedFrameLayout(theme) {}
inline fun Activity.themedFrameLayout(theme: Int = 0, init: (@AnkoViewDslMarker _FrameLayout).() -> Unit): FrameLayout {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.FRAME_LAYOUT, theme) { init() }
}

fun ViewManager.gridLayout(): GridLayout = gridLayout {}
inline fun ViewManager.gridLayout(init: (@AnkoViewDslMarker _GridLayout).() -> Unit): GridLayout {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.GRID_LAYOUT, theme = 0) { init() }
}

fun ViewManager.themedGridLayout(theme: Int = 0): GridLayout = themedGridLayout(theme) {}
inline fun ViewManager.themedGridLayout(theme: Int = 0, init: (@AnkoViewDslMarker _GridLayout).() -> Unit): GridLayout {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.GRID_LAYOUT, theme) { init() }
}

fun Context.gridLayout(): GridLayout = gridLayout {}
inline fun Context.gridLayout(init: (@AnkoViewDslMarker _GridLayout).() -> Unit): GridLayout {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.GRID_LAYOUT, theme = 0) { init() }
}

fun Context.themedGridLayout(theme: Int = 0): GridLayout = themedGridLayout(theme) {}
inline fun Context.themedGridLayout(theme: Int = 0, init: (@AnkoViewDslMarker _GridLayout).() -> Unit): GridLayout {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.GRID_LAYOUT, theme) { init() }
}

fun Activity.gridLayout(): GridLayout = gridLayout {}
inline fun Activity.gridLayout(init: (@AnkoViewDslMarker _GridLayout).() -> Unit): GridLayout {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.GRID_LAYOUT, theme = 0) { init() }
}

fun Activity.themedGridLayout(theme: Int = 0): GridLayout = themedGridLayout(theme) {}
inline fun Activity.themedGridLayout(theme: Int = 0, init: (@AnkoViewDslMarker _GridLayout).() -> Unit): GridLayout {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.GRID_LAYOUT, theme) { init() }
}

fun ViewManager.gridView(): GridView = gridView {}
inline fun ViewManager.gridView(init: (@AnkoViewDslMarker _GridView).() -> Unit): GridView {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.GRID_VIEW, theme = 0) { init() }
}

fun ViewManager.themedGridView(theme: Int = 0): GridView = themedGridView(theme) {}
inline fun ViewManager.themedGridView(theme: Int = 0, init: (@AnkoViewDslMarker _GridView).() -> Unit): GridView {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.GRID_VIEW, theme) { init() }
}

fun Context.gridView(): GridView = gridView {}
inline fun Context.gridView(init: (@AnkoViewDslMarker _GridView).() -> Unit): GridView {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.GRID_VIEW, theme = 0) { init() }
}

fun Context.themedGridView(theme: Int = 0): GridView = themedGridView(theme) {}
inline fun Context.themedGridView(theme: Int = 0, init: (@AnkoViewDslMarker _GridView).() -> Unit): GridView {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.GRID_VIEW, theme) { init() }
}

fun Activity.gridView(): GridView = gridView {}
inline fun Activity.gridView(init: (@AnkoViewDslMarker _GridView).() -> Unit): GridView {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.GRID_VIEW, theme = 0) { init() }
}

fun Activity.themedGridView(theme: Int = 0): GridView = themedGridView(theme) {}
inline fun Activity.themedGridView(theme: Int = 0, init: (@AnkoViewDslMarker _GridView).() -> Unit): GridView {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.GRID_VIEW, theme) { init() }
}

fun ViewManager.horizontalScrollView(): HorizontalScrollView = horizontalScrollView {}
inline fun ViewManager.horizontalScrollView(init: (@AnkoViewDslMarker _HorizontalScrollView).() -> Unit): HorizontalScrollView {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.HORIZONTAL_SCROLL_VIEW, theme = 0) { init() }
}

fun ViewManager.themedHorizontalScrollView(theme: Int = 0): HorizontalScrollView = themedHorizontalScrollView(theme) {}
inline fun ViewManager.themedHorizontalScrollView(
    theme: Int = 0,
    init: (@AnkoViewDslMarker _HorizontalScrollView).() -> Unit
): HorizontalScrollView {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.HORIZONTAL_SCROLL_VIEW, theme) { init() }
}

fun Context.horizontalScrollView(): HorizontalScrollView = horizontalScrollView {}
inline fun Context.horizontalScrollView(init: (@AnkoViewDslMarker _HorizontalScrollView).() -> Unit): HorizontalScrollView {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.HORIZONTAL_SCROLL_VIEW, theme = 0) { init() }
}

fun Context.themedHorizontalScrollView(theme: Int = 0): HorizontalScrollView = themedHorizontalScrollView(theme) {}
inline fun Context.themedHorizontalScrollView(
    theme: Int = 0,
    init: (@AnkoViewDslMarker _HorizontalScrollView).() -> Unit
): HorizontalScrollView {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.HORIZONTAL_SCROLL_VIEW, theme) { init() }
}

fun Activity.horizontalScrollView(): HorizontalScrollView = horizontalScrollView {}
inline fun Activity.horizontalScrollView(init: (@AnkoViewDslMarker _HorizontalScrollView).() -> Unit): HorizontalScrollView {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.HORIZONTAL_SCROLL_VIEW, theme = 0) { init() }
}

fun Activity.themedHorizontalScrollView(theme: Int = 0): HorizontalScrollView = themedHorizontalScrollView(theme) {}
inline fun Activity.themedHorizontalScrollView(
    theme: Int = 0,
    init: (@AnkoViewDslMarker _HorizontalScrollView).() -> Unit
): HorizontalScrollView {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.HORIZONTAL_SCROLL_VIEW, theme) { init() }
}

fun ViewManager.imageSwitcher(): ImageSwitcher = imageSwitcher {}
inline fun ViewManager.imageSwitcher(init: (@AnkoViewDslMarker _ImageSwitcher).() -> Unit): ImageSwitcher {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.IMAGE_SWITCHER, theme = 0) { init() }
}

fun ViewManager.themedImageSwitcher(theme: Int = 0): ImageSwitcher = themedImageSwitcher(theme) {}
inline fun ViewManager.themedImageSwitcher(theme: Int = 0, init: (@AnkoViewDslMarker _ImageSwitcher).() -> Unit): ImageSwitcher {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.IMAGE_SWITCHER, theme) { init() }
}

fun Context.imageSwitcher(): ImageSwitcher = imageSwitcher() {}
inline fun Context.imageSwitcher(init: (@AnkoViewDslMarker _ImageSwitcher).() -> Unit): ImageSwitcher {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.IMAGE_SWITCHER, theme = 0) { init() }
}

fun Context.themedImageSwitcher(theme: Int = 0): ImageSwitcher = themedImageSwitcher(theme) {}
inline fun Context.themedImageSwitcher(theme: Int = 0, init: (@AnkoViewDslMarker _ImageSwitcher).() -> Unit): ImageSwitcher {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.IMAGE_SWITCHER, theme) { init() }
}

fun Activity.imageSwitcher(): ImageSwitcher = imageSwitcher() {}
inline fun Activity.imageSwitcher(init: (@AnkoViewDslMarker _ImageSwitcher).() -> Unit): ImageSwitcher {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.IMAGE_SWITCHER, theme = 0) { init() }
}

fun Activity.themedImageSwitcher(theme: Int = 0): ImageSwitcher = themedImageSwitcher(theme) {}
inline fun Activity.themedImageSwitcher(theme: Int = 0, init: (@AnkoViewDslMarker _ImageSwitcher).() -> Unit): ImageSwitcher {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.IMAGE_SWITCHER, theme) { init() }
}

fun ViewManager.linearLayout(): LinearLayout = linearLayout() {}
inline fun ViewManager.linearLayout(init: (@AnkoViewDslMarker _LinearLayout).() -> Unit): LinearLayout {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.LINEAR_LAYOUT, theme = 0) { init() }
}

fun ViewManager.themedLinearLayout(theme: Int = 0): LinearLayout = themedLinearLayout(theme) {}
inline fun ViewManager.themedLinearLayout(theme: Int = 0, init: (@AnkoViewDslMarker _LinearLayout).() -> Unit): LinearLayout {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.LINEAR_LAYOUT, theme) { init() }
}

fun Context.linearLayout(): LinearLayout = linearLayout() {}
inline fun Context.linearLayout(init: (@AnkoViewDslMarker _LinearLayout).() -> Unit): LinearLayout {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.LINEAR_LAYOUT, theme = 0) { init() }
}

fun Context.themedLinearLayout(theme: Int = 0): LinearLayout = themedLinearLayout(theme) {}
inline fun Context.themedLinearLayout(theme: Int = 0, init: (@AnkoViewDslMarker _LinearLayout).() -> Unit): LinearLayout {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.LINEAR_LAYOUT, theme) { init() }
}

fun Activity.linearLayout(): LinearLayout = linearLayout() {}
inline fun Activity.linearLayout(init: (@AnkoViewDslMarker _LinearLayout).() -> Unit): LinearLayout {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.LINEAR_LAYOUT, theme = 0) { init() }
}

fun Activity.themedLinearLayout(theme: Int = 0): LinearLayout = themedLinearLayout(theme) {}
inline fun Activity.themedLinearLayout(theme: Int = 0, init: (@AnkoViewDslMarker _LinearLayout).() -> Unit): LinearLayout {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.LINEAR_LAYOUT, theme) { init() }
}

fun ViewManager.radioGroup(): RadioGroup = radioGroup {}
inline fun ViewManager.radioGroup(init: (@AnkoViewDslMarker _RadioGroup).() -> Unit): RadioGroup {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.RADIO_GROUP, theme = 0) { init() }
}

fun ViewManager.themedRadioGroup(theme: Int = 0): RadioGroup = themedRadioGroup(theme) {}
inline fun ViewManager.themedRadioGroup(theme: Int = 0, init: (@AnkoViewDslMarker _RadioGroup).() -> Unit): RadioGroup {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.RADIO_GROUP, theme) { init() }
}

fun Context.radioGroup(): RadioGroup = radioGroup {}
inline fun Context.radioGroup(init: (@AnkoViewDslMarker _RadioGroup).() -> Unit): RadioGroup {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.RADIO_GROUP, theme = 0) { init() }
}

fun Context.themedRadioGroup(theme: Int = 0): RadioGroup = themedRadioGroup(theme) {}
inline fun Context.themedRadioGroup(theme: Int = 0, init: (@AnkoViewDslMarker _RadioGroup).() -> Unit): RadioGroup {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.RADIO_GROUP, theme) { init() }
}

fun Activity.radioGroup(): RadioGroup = radioGroup() {}
inline fun Activity.radioGroup(init: (@AnkoViewDslMarker _RadioGroup).() -> Unit): RadioGroup {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.RADIO_GROUP, theme = 0) { init() }
}

fun Activity.themedRadioGroup(theme: Int = 0): RadioGroup = themedRadioGroup(theme) {}
inline fun Activity.themedRadioGroup(theme: Int = 0, init: (@AnkoViewDslMarker _RadioGroup).() -> Unit): RadioGroup {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.RADIO_GROUP, theme) { init() }
}

fun ViewManager.relativeLayout(): RelativeLayout = relativeLayout() {}
inline fun ViewManager.relativeLayout(init: (@AnkoViewDslMarker _RelativeLayout).() -> Unit): RelativeLayout {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.RELATIVE_LAYOUT, theme = 0) { init() }
}

fun ViewManager.themedRelativeLayout(theme: Int = 0): RelativeLayout = themedRelativeLayout(theme) {}
inline fun ViewManager.themedRelativeLayout(theme: Int = 0, init: (@AnkoViewDslMarker _RelativeLayout).() -> Unit): RelativeLayout {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.RELATIVE_LAYOUT, theme) { init() }
}

fun Context.relativeLayout(): RelativeLayout = relativeLayout {}
inline fun Context.relativeLayout(init: (@AnkoViewDslMarker _RelativeLayout).() -> Unit): RelativeLayout {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.RELATIVE_LAYOUT, theme = 0) { init() }
}

fun Context.themedRelativeLayout(theme: Int = 0): RelativeLayout = themedRelativeLayout(theme) {}
inline fun Context.themedRelativeLayout(theme: Int = 0, init: (@AnkoViewDslMarker _RelativeLayout).() -> Unit): RelativeLayout {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.RELATIVE_LAYOUT, theme) { init() }
}

fun Activity.relativeLayout(): RelativeLayout = relativeLayout {}
inline fun Activity.relativeLayout(init: (@AnkoViewDslMarker _RelativeLayout).() -> Unit): RelativeLayout {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.RELATIVE_LAYOUT, theme = 0) { init() }
}

fun Activity.themedRelativeLayout(theme: Int = 0): RelativeLayout = themedRelativeLayout(theme) {}
inline fun Activity.themedRelativeLayout(theme: Int = 0, init: (@AnkoViewDslMarker _RelativeLayout).() -> Unit): RelativeLayout {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.RELATIVE_LAYOUT, theme) { init() }
}

fun ViewManager.scrollView(): ScrollView = scrollView {}
inline fun ViewManager.scrollView(init: (@AnkoViewDslMarker _ScrollView).() -> Unit): ScrollView {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.SCROLL_VIEW, theme = 0) { init() }
}

fun ViewManager.themedScrollView(theme: Int = 0): ScrollView = themedScrollView(theme) {}
inline fun ViewManager.themedScrollView(theme: Int = 0, init: (@AnkoViewDslMarker _ScrollView).() -> Unit): ScrollView {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.SCROLL_VIEW, theme) { init() }
}

fun Context.scrollView(): ScrollView = scrollView {}
inline fun Context.scrollView(init: (@AnkoViewDslMarker _ScrollView).() -> Unit): ScrollView {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.SCROLL_VIEW, theme = 0) { init() }
}

fun Context.themedScrollView(theme: Int = 0): ScrollView = themedScrollView(theme) {}
inline fun Context.themedScrollView(theme: Int = 0, init: (@AnkoViewDslMarker _ScrollView).() -> Unit): ScrollView {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.SCROLL_VIEW, theme) { init() }
}

fun Activity.scrollView(): ScrollView = scrollView {}
inline fun Activity.scrollView(init: (@AnkoViewDslMarker _ScrollView).() -> Unit): ScrollView {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.SCROLL_VIEW, theme = 0) { init() }
}

fun Activity.themedScrollView(theme: Int = 0): ScrollView = themedScrollView(theme) {}
inline fun Activity.themedScrollView(theme: Int = 0, init: (@AnkoViewDslMarker _ScrollView).() -> Unit): ScrollView {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.SCROLL_VIEW, theme) { init() }
}

fun ViewManager.tableLayout(): TableLayout = tableLayout() {}
inline fun ViewManager.tableLayout(init: (@AnkoViewDslMarker _TableLayout).() -> Unit): TableLayout {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.TABLE_LAYOUT, theme = 0) { init() }
}

fun ViewManager.themedTableLayout(theme: Int = 0): TableLayout = themedTableLayout(theme) {}
inline fun ViewManager.themedTableLayout(theme: Int = 0, init: (@AnkoViewDslMarker _TableLayout).() -> Unit): TableLayout {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.TABLE_LAYOUT, theme) { init() }
}

fun Context.tableLayout(): TableLayout = tableLayout() {}
inline fun Context.tableLayout(init: (@AnkoViewDslMarker _TableLayout).() -> Unit): TableLayout {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.TABLE_LAYOUT, theme = 0) { init() }
}

fun Context.themedTableLayout(theme: Int = 0): TableLayout = themedTableLayout(theme) {}
inline fun Context.themedTableLayout(theme: Int = 0, init: (@AnkoViewDslMarker _TableLayout).() -> Unit): TableLayout {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.TABLE_LAYOUT, theme) { init() }
}

fun Activity.tableLayout(): TableLayout = tableLayout() {}
inline fun Activity.tableLayout(init: (@AnkoViewDslMarker _TableLayout).() -> Unit): TableLayout {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.TABLE_LAYOUT, theme = 0) { init() }
}

fun Activity.themedTableLayout(theme: Int = 0): TableLayout = themedTableLayout(theme) {}
inline fun Activity.themedTableLayout(theme: Int = 0, init: (@AnkoViewDslMarker _TableLayout).() -> Unit): TableLayout {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.TABLE_LAYOUT, theme) { init() }
}

fun ViewManager.tableRow(): TableRow = tableRow() {}
inline fun ViewManager.tableRow(init: (@AnkoViewDslMarker _TableRow).() -> Unit): TableRow {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.TABLE_ROW, theme = 0) { init() }
}

fun ViewManager.themedTableRow(theme: Int = 0): TableRow = themedTableRow(theme) {}
inline fun ViewManager.themedTableRow(theme: Int = 0, init: (@AnkoViewDslMarker _TableRow).() -> Unit): TableRow {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.TABLE_ROW, theme) { init() }
}

fun Context.tableRow(): TableRow = tableRow() {}
inline fun Context.tableRow(init: (@AnkoViewDslMarker _TableRow).() -> Unit): TableRow {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.TABLE_ROW, theme = 0) { init() }
}

fun Context.themedTableRow(theme: Int = 0): TableRow = themedTableRow(theme) {}
inline fun Context.themedTableRow(theme: Int = 0, init: (@AnkoViewDslMarker _TableRow).() -> Unit): TableRow {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.TABLE_ROW, theme) { init() }
}

fun Activity.tableRow(): TableRow = tableRow() {}
inline fun Activity.tableRow(init: (@AnkoViewDslMarker _TableRow).() -> Unit): TableRow {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.TABLE_ROW, theme = 0) { init() }
}

fun Activity.themedTableRow(theme: Int = 0): TableRow = themedTableRow(theme) {}
inline fun Activity.themedTableRow(theme: Int = 0, init: (@AnkoViewDslMarker _TableRow).() -> Unit): TableRow {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.TABLE_ROW, theme) { init() }
}

fun ViewManager.textSwitcher(): TextSwitcher = textSwitcher() {}
inline fun ViewManager.textSwitcher(init: (@AnkoViewDslMarker _TextSwitcher).() -> Unit): TextSwitcher {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.TEXT_SWITCHER, theme = 0) { init() }
}

fun ViewManager.themedTextSwitcher(theme: Int = 0): TextSwitcher = themedTextSwitcher(theme) {}
inline fun ViewManager.themedTextSwitcher(theme: Int = 0, init: (@AnkoViewDslMarker _TextSwitcher).() -> Unit): TextSwitcher {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.TEXT_SWITCHER, theme) { init() }
}

fun Context.textSwitcher(): TextSwitcher = textSwitcher {}
inline fun Context.textSwitcher(init: (@AnkoViewDslMarker _TextSwitcher).() -> Unit): TextSwitcher {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.TEXT_SWITCHER, theme = 0) { init() }
}

inline fun Context.themedTextSwitcher(theme: Int = 0): TextSwitcher = themedTextSwitcher(theme) {}
inline fun Context.themedTextSwitcher(theme: Int = 0, init: (@AnkoViewDslMarker _TextSwitcher).() -> Unit): TextSwitcher {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.TEXT_SWITCHER, theme) { init() }
}

fun Activity.textSwitcher(): TextSwitcher = textSwitcher {}
inline fun Activity.textSwitcher(init: (@AnkoViewDslMarker _TextSwitcher).() -> Unit): TextSwitcher {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.TEXT_SWITCHER, theme = 0) { init() }
}

fun Activity.themedTextSwitcher(theme: Int = 0): TextSwitcher = themedTextSwitcher(theme) {}
inline fun Activity.themedTextSwitcher(theme: Int = 0, init: (@AnkoViewDslMarker _TextSwitcher).() -> Unit): TextSwitcher {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.TEXT_SWITCHER, theme) { init() }
}

fun ViewManager.toolbar(): Toolbar = toolbar {}
inline fun ViewManager.toolbar(init: (@AnkoViewDslMarker _Toolbar).() -> Unit): Toolbar {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.TOOLBAR, theme = 0) { init() }
}

fun ViewManager.themedToolbar(theme: Int = 0): Toolbar = themedToolbar(theme) {}
inline fun ViewManager.themedToolbar(theme: Int = 0, init: (@AnkoViewDslMarker _Toolbar).() -> Unit): Toolbar {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.TOOLBAR, theme) { init() }
}

fun Context.toolbar(): Toolbar = toolbar {}
inline fun Context.toolbar(init: (@AnkoViewDslMarker _Toolbar).() -> Unit): Toolbar {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.TOOLBAR, theme = 0) { init() }
}

fun Context.themedToolbar(theme: Int = 0): Toolbar = themedToolbar(theme) {}
inline fun Context.themedToolbar(theme: Int = 0, init: (@AnkoViewDslMarker _Toolbar).() -> Unit): Toolbar {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.TOOLBAR, theme) { init() }
}

fun Activity.toolbar(): Toolbar = toolbar {}
inline fun Activity.toolbar(init: (@AnkoViewDslMarker _Toolbar).() -> Unit): Toolbar {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.TOOLBAR, theme = 0) { init() }
}

fun Activity.themedToolbar(theme: Int = 0): Toolbar = themedToolbar(theme) {}
inline fun Activity.themedToolbar(theme: Int = 0, init: (@AnkoViewDslMarker _Toolbar).() -> Unit): Toolbar {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.TOOLBAR, theme) { init() }
}

fun ViewManager.viewAnimator(): ViewAnimator = viewAnimator {}
inline fun ViewManager.viewAnimator(init: (@AnkoViewDslMarker _ViewAnimator).() -> Unit): ViewAnimator {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.VIEW_ANIMATOR, theme = 0) { init() }
}

fun ViewManager.themedViewAnimator(theme: Int = 0): ViewAnimator = themedViewAnimator(theme) {}
inline fun ViewManager.themedViewAnimator(theme: Int = 0, init: (@AnkoViewDslMarker _ViewAnimator).() -> Unit): ViewAnimator {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.VIEW_ANIMATOR, theme) { init() }
}

fun Context.viewAnimator(): ViewAnimator = viewAnimator {}
inline fun Context.viewAnimator(init: (@AnkoViewDslMarker _ViewAnimator).() -> Unit): ViewAnimator {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.VIEW_ANIMATOR, theme = 0) { init() }
}

fun Context.themedViewAnimator(theme: Int = 0): ViewAnimator = themedViewAnimator(theme) {}
inline fun Context.themedViewAnimator(theme: Int = 0, init: (@AnkoViewDslMarker _ViewAnimator).() -> Unit): ViewAnimator {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.VIEW_ANIMATOR, theme) { init() }
}

fun Activity.viewAnimator(): ViewAnimator = viewAnimator() {}
inline fun Activity.viewAnimator(init: (@AnkoViewDslMarker _ViewAnimator).() -> Unit): ViewAnimator {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.VIEW_ANIMATOR, theme = 0) { init() }
}

fun Activity.themedViewAnimator(theme: Int = 0): ViewAnimator = themedViewAnimator(theme) {}
inline fun Activity.themedViewAnimator(theme: Int = 0, init: (@AnkoViewDslMarker _ViewAnimator).() -> Unit): ViewAnimator {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.VIEW_ANIMATOR, theme) { init() }
}

fun ViewManager.viewSwitcher(): ViewSwitcher = viewSwitcher() {}
inline fun ViewManager.viewSwitcher(init: (@AnkoViewDslMarker _ViewSwitcher).() -> Unit): ViewSwitcher {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.VIEW_SWITCHER, theme = 0) { init() }
}

fun ViewManager.themedViewSwitcher(theme: Int = 0): ViewSwitcher = themedViewSwitcher(theme) {}
inline fun ViewManager.themedViewSwitcher(theme: Int = 0, init: (@AnkoViewDslMarker _ViewSwitcher).() -> Unit): ViewSwitcher {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.VIEW_SWITCHER, theme) { init() }
}

fun Context.viewSwitcher(): ViewSwitcher = viewSwitcher() {}
inline fun Context.viewSwitcher(init: (@AnkoViewDslMarker _ViewSwitcher).() -> Unit): ViewSwitcher {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.VIEW_SWITCHER, theme = 0) { init() }
}

fun Context.themedViewSwitcher(theme: Int = 0): ViewSwitcher = themedViewSwitcher(theme) {}
inline fun Context.themedViewSwitcher(theme: Int = 0, init: (@AnkoViewDslMarker _ViewSwitcher).() -> Unit): ViewSwitcher {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.VIEW_SWITCHER, theme) { init() }
}

fun Activity.viewSwitcher(): ViewSwitcher = viewSwitcher {}
inline fun Activity.viewSwitcher(init: (@AnkoViewDslMarker _ViewSwitcher).() -> Unit): ViewSwitcher {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.VIEW_SWITCHER, theme = 0) { init() }
}

fun Activity.themedViewSwitcher(theme: Int = 0): ViewSwitcher = themedViewSwitcher(theme) {}
inline fun Activity.themedViewSwitcher(theme: Int = 0, init: (@AnkoViewDslMarker _ViewSwitcher).() -> Unit): ViewSwitcher {
    return ankoView(`$$Anko$Factories$Sdk25ViewGroup`.VIEW_SWITCHER, theme) { init() }
}

