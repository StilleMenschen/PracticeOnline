package com.thirty_three.adapter;

import com.thirty_three.main.AndroidTestFragment;
import com.thirty_three.main.JavaTestFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * fragmentPagerAdapter������
 */
public class FragmentAdapter extends FragmentPagerAdapter {
	private static final int TAB_ANDROID = 0;// Android����Fragment����
	private static final int TAB_JAVA = 1;// Java����Fragment����
	public final static int TAB_COUNT = 2;// ������ҳ������

	public FragmentAdapter(FragmentManager fm) {
		super(fm);// ��FragmentManager��������
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
			AndroidTestFragment androidTest = new AndroidTestFragment();
			return androidTest;
		case TAB_JAVA:// ������������Java����
			JavaTestFragment javaTest = new JavaTestFragment();
			return javaTest;
		}
		return null;
	}

}
