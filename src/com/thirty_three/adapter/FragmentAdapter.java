package com.thirty_three.adapter;

import com.thirty_three.Util.onMenuOpenedListener;
import com.thirty_three.main.AndroidTestFragment;
import com.thirty_three.main.JavaTestFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * fragmentPagerAdapter������
 */
public class FragmentAdapter extends FragmentPagerAdapter {
	public static final int TAB_ANDROID = 0;// Android����Fragment����
	public static final int TAB_JAVA = 1;// Java����Fragment����
	public static final int TAB_COUNT = 2;// ������ҳ������
	private onMenuOpenedListener listener;

	public FragmentAdapter(FragmentManager fm, onMenuOpenedListener menuOpenedListener) {
		super(fm);// ��FragmentManager��������
		listener = menuOpenedListener;
	}

	// ��ȡҪ�����Ŀؼ�������
	@Override
	public int getCount() {
		return TAB_COUNT;
	}

	@Override
	public Fragment getItem(int id) {
		// ����Id���ض�Ӧ��Fragment
		switch (id) {
		case TAB_ANDROID:// ����������Android����
			AndroidTestFragment androidTest = new AndroidTestFragment(listener);
			return androidTest;
		case TAB_JAVA:// ������������Java����
			JavaTestFragment javaTest = new JavaTestFragment(listener);
			return javaTest;
		}
		return null;
	}

}
