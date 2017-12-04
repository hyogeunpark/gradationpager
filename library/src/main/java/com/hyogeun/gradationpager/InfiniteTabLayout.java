package com.hyogeun.gradationpager;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

/**
 * Created by hyogeun.park on 2017. 11. 30..
 */

public class InfiniteTabLayout extends TabLayout {

    private ViewPager mViewPager;
    private boolean isForce = false;
    private boolean isOutBounds = false;

    public InfiniteTabLayout(Context context) {
        super(context);
    }

    public InfiniteTabLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public InfiniteTabLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void createTab(ViewPager viewPager, PagerAdapter adapter) {
        if(viewPager == null) {
            throw new NullPointerException("viewpager is null");
        } else if(adapter == null) {
            throw  new NullPointerException("pager adapter is null");
        }
        for (int i = 0; i < adapter.getCount(); i++) {
            addTab(newTab().setText(adapter.getPageTitle(i)));
        }
        mViewPager = viewPager;
        mViewPager.addOnPageChangeListener(mOnPageChangeListener);
        addOnTabSelectedListener(mOnTabSelectedListener);
        getTabAt(0).select();
    }

    private OnTabSelectedListener mOnTabSelectedListener = new OnTabSelectedListener() {
        @Override
        public void onTabSelected(final Tab tab) {
            if (mViewPager == null) {
                throw new NullPointerException("viewpager is null");
            }
            if (isForce) {
                isForce = false;
                return;
            }
            mViewPager.postDelayed(new Runnable() {
                @Override
                public void run() {
                    isForce = true;
                    mViewPager.setCurrentItem(tab.getPosition() + 1);
                }
            }, 30);
        }

        @Override
        public void onTabUnselected(Tab tab) {

        }

        @Override
        public void onTabReselected(Tab tab) {

        }
    };

    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            if (mViewPager.getAdapter() == null) {
                throw new NullPointerException("viewpager must attach pager adapter");
            }
            if(isForce) {
                isForce = false;
                return;
            }
            if(isOutBounds) {
                isOutBounds = false;
                return;
            }
            if (mViewPager.getAdapter() instanceof GradationPagerAdapter && getTabCount() > 0) {
                isOutBounds =  position == 0 || position == mViewPager.getAdapter().getCount()-1;
                forceSelectTab(((GradationPagerAdapter) mViewPager.getAdapter()).getIndex(position));
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    private void forceSelectTab(int position) {
        if (getTabAt(position) == null) {
            throw new NullPointerException(String.format("getTabAt(%d) is null", position));
        }
        isForce = true;
        getTabAt(position).select();
    }
}

