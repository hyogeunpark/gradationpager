package com.hyogeun.gradationpager.example.adapter

import androidx.viewpager.widget.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.hyogeun.gradationpager.example.R
import java.util.*

/**
 * Created by hyogeun.park on 2017. 11. 30..
 */
class ImagePagerAdapter: PagerAdapter() {

    private val mTitle:ArrayList<String> = ArrayList(Arrays.asList("Bus", "Car", "Subway", "Walk", "Flight"))
    private val mExample:ArrayList<String> = ArrayList(Arrays.asList("[일반] People are sitting on the bus.\n버스에 사람들이 앉아 있다.(출처: YBM)",
            "[일반] I'm looking for a used car.\n중고차를 찾고 있습니다.(출처: 능률교육)",
            "[일반] The people are looking at a subway map.\n사람들이 지하철 노선표를 보고 있다.(출처: YBM)",
            "[일반] The woman is helping the boy walk up the stairs.\n여자는 소년이 계단을 걸어올라가도록 돕고 있다.(출처: YBM)",
            "[일반] His friends used every means to put him to flight.\n그를 도주시키려고 그의 친구들이 모든 수단을 썼다.(출처: YBM)"))
    private val mResId:IntArray = intArrayOf(R.mipmap.ic_directions_bus_white, R.mipmap.ic_directions_car_white, R.mipmap.ic_directions_subway_white, R.mipmap.ic_directions_walk_white, R.mipmap.ic_flight_white)

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = LayoutInflater.from(container.context).inflate(R.layout.pager_transform, container, false)
        val ivIcon:ImageView = view.findViewById(R.id.transform_icon)
        val tvName:TextView = view.findViewById(R.id.transform_name)
        val tvExample:TextView = view.findViewById(R.id.transform_example)
        tvName.text = mTitle[position]
        tvExample.text = mExample[position]
        ivIcon.setImageResource(mResId[position])
        container.addView(view)
        return view
    }


    override fun isViewFromObject(view: View, `object`: Any): Boolean = (view == `object`)

    override fun getCount(): Int = mResId.size

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun getPageTitle(position: Int): CharSequence {
        return mTitle[position]
    }
}