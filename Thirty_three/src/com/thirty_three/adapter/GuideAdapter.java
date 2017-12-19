package com.thirty_three.adapter;

import java.util.List;

import com.thirty_three.test.LoginActivity;
import com.thirty_three.test.R;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * PagerAdapter  ≈‰∆˜
 * 
 */
public class GuideAdapter extends PagerAdapter {
	private final List<View> views;
	private final Activity activity;

	public GuideAdapter(Activity activity, List<View> views) {
		this.activity = activity;
		this.views = views;
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

		((ViewPager) container).addView(views.get(position), 0);
		if (position == views.size() - 1) {
			Button imageViewStart = (Button) container.findViewById(R.id.tiyan);
			imageViewStart.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					SharedPreferences preferences = activity.getSharedPreferences("test", 0);
					Editor editor = preferences.edit();
					editor.putBoolean("test", false);
					editor.commit();
					Intent intent = new Intent(activity, LoginActivity.class);
					activity.startActivity(intent);
					activity.finish();
				}

			});
		}
		return views.get(position);
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
