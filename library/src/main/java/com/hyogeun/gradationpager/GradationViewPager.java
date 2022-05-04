package com.hyogeun.gradationpager;

import android.content.Context;
import android.graphics.Color;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.util.AttributeSet;

/**
 * Created by hyogeun.park on 2017. 11. 30..
 */

public class GradationViewPager extends ViewPager {

    private int[] colors = new int[]{};
    private GradationPagerAdapter mAdapter;

    public GradationViewPager(Context context) {
        super(context);
        init();
    }

    public GradationViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        addOnPageChangeListener(mOnPageChangeListener);
    }

    public void setBackGroundColors(int[] colors) {
        this.colors = colors;
        setBackgroundColor(colors[colors.length-1]);
    }

    public int getBackGroundColors() {
        return colors == null ? 0 : colors.length;
    }

    @Override
    public void setAdapter(PagerAdapter adapter) {
        mAdapter = new GradationPagerAdapter(adapter);
        super.setAdapter(mAdapter);
        setCurrentItem(1);
    }

    private OnPageChangeListener mOnPageChangeListener = new OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            if(mAdapter != null) {
                int nextColor = colors[(mAdapter.getIndex(position) + 1) % colors.length];
                int currentColor = colors[(mAdapter.getIndex(position)) % colors.length];
                float currentRed = currentColor >> 16 & 0xff;
                float currentGreen = currentColor >> 8 & 0xff;
                float currentBlue = currentColor & 0xff;
                float nextRed = nextColor >> 16 & 0xff;
                float nextGreen = nextColor >> 8 & 0xff;
                float nextBlue = nextColor & 0xff;

                int newRed = (int) (currentRed + ((nextRed - currentRed) * positionOffset));
                int newGreen = (int) (currentGreen + ((nextGreen - currentGreen) * positionOffset));
                int newBlue = (int) (currentBlue + ((nextBlue - currentBlue) * positionOffset));
                setBackgroundColor(Color.rgb(newRed, newGreen, newBlue));
            }
        }

        @Override
        public void onPageSelected(int position) {
        }

        @Override
        public void onPageScrollStateChanged(int state) {
            if(state == SCROLL_STATE_IDLE) {
                int position = getCurrentItem();
                if(position == 0) {
                    setCurrentItem(colors.length, false);
                } else if(position == getAdapter().getCount()-1) {
                    setCurrentItem(1, false);
                }
            }
        }
    };
}
