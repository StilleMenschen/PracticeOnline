package com.thirty_three.main;

import com.thirty_three.main.R;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

/**
 * 程序启动页面
 */
public class StartActivity extends Activity {
	/** 等待2000毫秒，即2秒 */
	private static final long SPLASH_DISPLAY_LENGHT = 2000;
	boolean isFirstIn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.start);

		// 读取SharedPreFerences中需要的数据,使用SharedPreFerences来记录程序启动的使用次数
		SharedPreferences preferences = getSharedPreferences("test", Activity.MODE_PRIVATE);
		// 取得相应的值,如果没有该值,说明还未写入,用true作为默认值
		isFirstIn = preferences.getBoolean("test", true);
		// 首次启动，进入导航页
		if (isFirstIn) {
			new Handler().postDelayed(new Runnable() {
				@Override
				public void run() {
					Intent intent = new Intent(StartActivity.this, NavigationActivity.class);
					startActivity(intent);
					finish();
					// 动画效果
					overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
				}
				// 延迟时间
			}, SPLASH_DISPLAY_LENGHT);
		}
		/* 不是首次启动，进入登录页 */
		else {
			new Handler().postDelayed(new Runnable() {
				@Override
				public void run() {
					Intent Intent = new Intent(StartActivity.this, LoginActivity.class);
					startActivity(Intent);
					finish();
					// 动画效果
					overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
				}
				// 延迟时间
			}, SPLASH_DISPLAY_LENGHT);
		}
	}
}
