package com.thirty_three.adapter;

import java.util.List;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

/**
 * PagerAdapter������
 */
public class GuideAdapter extends PagerAdapter {
	// �洢����ҳ��ͼ������
	private final List<View> views;

	public GuideAdapter(List<View> views) {
		this.views = views;
	}

	// ��ȡ����ָ��λ�õ�Ԫ��
	public View getItem(int position) {
		return views.get(position);
	}

	// ��ȡ���鳤��
	@Override
	public int getCount() {
		return views.size();
	}

	// PagerAdapterֻ����������ͼ�������������ͼ�����˻���ķ�Χ���ͻ���������������ͼƬ����
	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView(getItem(position));
	}

	// ��Ҫ��ʾ����ͼ���Խ��л����ʱ�򣬻�����������������ʾǰ�ĳ�ʼ����
	// ��Ҫ��ʾ��View���뵽ViewGroup�У�Ȼ����Ϊ����ֵ���ؼ���
	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		View view = getItem(position);
		container.addView(view);// ��ӵ���������
		return view;
	}

	// �ж���ʾ���Ƿ���ͬһ����ͼ��������������ȽϷ���
	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0 == arg1;
	}
}
