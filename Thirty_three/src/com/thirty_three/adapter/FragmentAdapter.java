package com.thirty_three.adapter;

import com.thirty_three.main.AndroidTestFragment;
import com.thirty_three.main.JavaTestFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * fragmentPagerAdapter适配器
 */
public class FragmentAdapter extends FragmentPagerAdapter {
	private static final int TAB_ANDROID = 0;// Android测试Fragment索引
	private static final int TAB_JAVA = 1;// Java测试Fragment索引
	public final static int TAB_COUNT = 2;// 测试题页面总数

	public FragmentAdapter(FragmentManager fm) {
		super(fm);// 将FragmentManager传给父类
	}

	// 获取要滑动的控件的数量
	@Override
	public int getCount() {
		return TAB_COUNT;
	}

	@Override
	public Fragment getItem(int id) {
		// 根据Id返回对应的Fragment
		switch (id) {
		case TAB_ANDROID:// 如果请求的是Android测试
			AndroidTestFragment androidTest = new AndroidTestFragment();
			return androidTest;
		case TAB_JAVA:// 如果过请求的是Java测试
			JavaTestFragment javaTest = new JavaTestFragment();
			return javaTest;
		}
		return null;
	}

}
