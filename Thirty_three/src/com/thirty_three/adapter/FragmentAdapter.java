package com.thirty_three.adapter;

import com.thirty_three.test.AndroidTestFragment;
import com.thirty_three.test.JavaTestFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * fragmentPagerAdapter适配器
 */
public class FragmentAdapter extends FragmentPagerAdapter {
	private static final int TAB_ANDROID = 0;
	private static final int TAB_JAVA = 1;

	public FragmentAdapter(FragmentManager fm) {
		super(fm);
	}

	public final static int TAB_COUNT = 2;

	// 获取要滑动的控件的数量
	@Override
	public int getCount() {
		// return list.size();
		return TAB_COUNT;
	}

	@Override
	public Fragment getItem(int id) {

		switch (id) {
		case TAB_ANDROID:
			new AndroidTestFragment();
			return new AndroidTestFragment();
		case TAB_JAVA:
			new JavaTestFragment();
			return new JavaTestFragment();
		}
		return null;
	}

}
