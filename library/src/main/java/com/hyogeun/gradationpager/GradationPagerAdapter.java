package com.hyogeun.gradationpager;

import android.database.DataSetObserver;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by hyogeun.park on 2017. 11. 30..
 */

public class GradationPagerAdapter extends PagerAdapter {

    private PagerAdapter mAdapter;

    public GradationPagerAdapter(PagerAdapter adapter) {
        mAdapter = adapter;
    }

    @Override
    public int getCount() {
        return mAdapter.getCount() + 2;
    }

    private int getOriginCount() {
        return mAdapter.getCount();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        return mAdapter.instantiateItem(container, getIndex(position));
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    public int getIndex(int position) {
        if(position == 0) {
            return getOriginCount()-1;
        } else if(position == getCount()-1) {
            return 0;
        } else {
            return position-1;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mAdapter.getPageTitle(getIndex(position));
    }

    @Override
    public float getPageWidth(int position) {
        return mAdapter.getPageWidth(getIndex(position));
    }

    @Override
    public boolean equals(Object obj) {
        return mAdapter.equals(obj);
    }

    @Override
    public int hashCode() {
        return mAdapter.hashCode();
    }

    @Override
    public String toString() {
        return mAdapter.toString();
    }

    @Override
    public int getItemPosition(Object object) {
        return mAdapter.getItemPosition(object);
    }

    @Override
    public Parcelable saveState() {
        return mAdapter.saveState();
    }

    @Override
    public void finishUpdate(ViewGroup container) {
        mAdapter.finishUpdate(container);
    }

    @Override
    public void notifyDataSetChanged() {
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {
        mAdapter.registerDataSetObserver(observer);
    }

    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {
        mAdapter.restoreState(state, loader);
    }

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        mAdapter.setPrimaryItem(container, getIndex(position), object);
    }

    @Override
    public void startUpdate(ViewGroup container) {
        mAdapter.startUpdate(container);
    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {
        mAdapter.unregisterDataSetObserver(observer);
    }

    // deprecated
    /*@Override
    public void startUpdate(View container) {
        mAdapter.startUpdate(container);
    }

    @Override
    public void setPrimaryItem(View container, int position, Object object) {
        mAdapter.setPrimaryItem(container, getIndex(position), object);
    }

    @Override
    public void finishUpdate(View container) {
        mAdapter.finishUpdate(container);
    }

    @Override
    public Object instantiateItem(View container, int position) {
        return mAdapter.instantiateItem(container, getIndex(position));
    }

    @Override
    public void destroyItem(View container, int position, Object object) {
        mAdapter.destroyItem(container, getIndex(position), object);
    }*/
}

