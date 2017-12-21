package com.thirty_three.adapter;

import java.util.List;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

/**
 * PagerAdapter适配器
 */
public class GuideAdapter extends PagerAdapter {
	// 存储导航页视图的数组
	private final List<View> views;

	public GuideAdapter(List<View> views) {
		this.views = views;
	}

	// 获取数组指定位置的元素
	public View getItem(int position) {
		return views.get(position);
	}

	// 获取数组长度
	@Override
	public int getCount() {
		return views.size();
	}

	// PagerAdapter只缓存三个视图，如果滑动的视图超出了缓存的范围，就会调用这个方法，将图片销毁
	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView(getItem(position));
	}

	// 当要显示的视图可以进行缓存的时候，会调用这个方法进行显示前的初始化，
	// 将要显示的View加入到ViewGroup中，然后作为返回值返回即可
	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		View view = getItem(position);
		container.addView(view);// 添加到父布局中
		return view;
	}

	// 判断显示的是否是同一个视图，将两个参数相比较返回
	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0 == arg1;
	}
}
