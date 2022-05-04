package com.hyogeun.gradationpager.example

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hyogeun.gradationpager.GradationViewPager
import com.hyogeun.gradationpager.example.adapter.ImagePagerAdapter

/**
 * Created by hyogeun.park on 2017. 11. 30..
 */
class ViewPagerActivity: AppCompatActivity() {

    companion object {
        fun createInstance(context:Context) {
            context.startActivity(Intent(context, ViewPagerActivity::class.java))
        }
    }

    private val mColor:IntArray = intArrayOf(Color.rgb(248, 143, 179), Color.rgb(128, 203, 196), Color.rgb(255, 166, 166), Color.rgb(123, 197, 216), Color.rgb(79, 195, 247))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager)
        val viewPager: GradationViewPager = findViewById(R.id.viewpager)
        viewPager.adapter = ImagePagerAdapter()
        viewPager.setBackGroundColors(mColor)
    }
}