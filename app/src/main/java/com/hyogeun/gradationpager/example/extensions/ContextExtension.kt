package com.hyogeun.gradationpager.example.extensions

import android.content.Context
import android.util.TypedValue

/**
 * Created by hyogeun.park on 2017. 11. 30..
 */
fun Context.convertDipToPx(dip:Float): Int {
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dip, this.resources.displayMetrics).toInt()
}