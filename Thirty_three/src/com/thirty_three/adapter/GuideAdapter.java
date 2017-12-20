package com.thirty_three.adapter;

import java.util.List;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

/**
 * PagerAdapter  ≈‰∆˜
 */
public class GuideAdapter extends PagerAdapter {
	private final List<View> views;

	public GuideAdapter(List<View> views) {
		this.views = views;
	}

	public View getItem(int position) {
		return views.get(position);
	}

	@Override
	public int getCount() {
		return views.size();
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView(views.get(position));
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		ViewPager pager = (ViewPager) container;
		View view = getItem(position);
		pager.addView(view, 0);
		return view;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return null;
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0 == arg1;
	}
}
