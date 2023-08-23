/*
 * Copyright 2016 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

@file:Suppress("unused", "NOTHING_TO_INLINE")

package org.jetbrains.anko

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.res.AssetManager
import android.content.res.Configuration
import android.content.res.Resources
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment

inline val AnkoContext<*>.resources: Resources
    get() = ctx.resources

inline val AnkoContext<*>.assets: AssetManager
    get() = ctx.assets

inline val Fragment.act: Activity
    get() = requireActivity()

inline val Fragment.ctx: Context
    get() = requireActivity()

/**
 * Returns the content view of this Activity if set, null otherwise.
 */
inline val Activity.contentView: View?
    get() = findOptional<ViewGroup>(android.R.id.content)?.getChildAt(0)

inline fun <reified T : View> View.find(@IdRes id: Int): T = findViewById(id)
inline fun <reified T : View> Activity.find(@IdRes id: Int): T = findViewById(id)
inline fun <reified T : View> Dialog.find(@IdRes id: Int): T = findViewById(id)

inline fun <reified T : View> View.findOptional(@IdRes id: Int): T? = findViewById(id) as? T
inline fun <reified T : View> Activity.findOptional(@IdRes id: Int): T? = findViewById(id) as? T
inline fun <reified T : View> Dialog.findOptional(@IdRes id: Int): T? = findViewById(id) as? T

inline val Context.displayMetrics: android.util.DisplayMetrics
    get() = resources.displayMetrics

inline val Context.configuration: Configuration
    get() = resources.configuration

inline val AnkoContext<*>.displayMetrics: android.util.DisplayMetrics
    get() = ctx.resources.displayMetrics

inline val AnkoContext<*>.configuration: Configuration
    get() = ctx.resources.configuration

inline val Configuration.portrait: Boolean
    get() = orientation == Configuration.ORIENTATION_PORTRAIT

inline val Configuration.landscape: Boolean
    get() = orientation == Configuration.ORIENTATION_LANDSCAPE

inline val Configuration.long: Boolean
    get() = (screenLayout and Configuration.SCREENLAYOUT_LONG_YES) != 0
