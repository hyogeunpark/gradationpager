package com.hyogeun.gradationpager.example

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.example_viewpager -> ViewPagerActivity.createInstance(this)
            R.id.example_viewpager_with_tab -> ViewPagerWithTabActivity.createInstance(this)
        }
    }
}
