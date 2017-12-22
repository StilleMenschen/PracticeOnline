package com.thirty_three.main;

import com.thirty_three.Util.SelectPicPopupWindow;
import com.thirty_three.Util.onMenuOpenedListener;
import com.thirty_three.adapter.FragmentAdapter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

/**
 * 主界面
 */
public class MainActivity extends FragmentActivity implements onMenuOpenedListener {
	// 返回键按下的延时计算
	private long waitTime = 2000;
	private long touchTime = 0;
	// 滑动的页
	private ViewPager viewPager;
	// 试题页面
	private RadioGroup radioGroup;
	// Menu菜单
	private SelectPicPopupWindow menuWindow;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		findView();
		addListener();
	}

	private void findView() {
		viewPager = (ViewPager) findViewById(R.id.viewpager);
		radioGroup = (RadioGroup) findViewById(R.id.home_group);
		FragmentManager manager = getSupportFragmentManager();
		FragmentAdapter adapter = new FragmentAdapter(manager, this);
		viewPager.setAdapter(adapter);
	}

	private void addListener() {
		// 页面监听器
		viewPager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int id) {
				// ViewPager中的Tab页改变时，同步改变单选按钮的选中状态
				switch (id) {
				case FragmentAdapter.TAB_ANDROID:// Android测试
					radioGroup.check(R.id.home_android);
					break;
				case FragmentAdapter.TAB_JAVA:// Java测试
					radioGroup.check(R.id.home_java);
					break;
				}
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
			}
		});
		// 单选按钮组监听器
		radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				switch (checkedId) {
				case R.id.home_android:// Android测试
					viewPager.setCurrentItem(FragmentAdapter.TAB_ANDROID);
					break;
				case R.id.home_java:// Java测试
					viewPager.setCurrentItem(FragmentAdapter.TAB_JAVA);
					break;
				}
			}
		});
	}

	@Override
	public void openMenu() {
		menuWindow = new SelectPicPopupWindow(MainActivity.this, itemsOnClick);
		// 菜单所在的父布局
		View parent = findViewById(R.id.main);
		// 显示位置(底部|水平居中)
		menuWindow.showAtLocation(parent, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
	}
	
	@Override
	public boolean onMenuOpened(int featureId, Menu menu) {
		openMenu();
		return false;
	}

	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		menu.add("Menu");// Menu标题
		return super.onPrepareOptionsMenu(menu);
	}

	// 为弹出菜单窗口实现监听类
	private OnClickListener itemsOnClick = new OnClickListener() {
		public void onClick(View v) {
			menuWindow.dismiss();// 关掉菜单
			Intent intent;
			int vid = v.getId();
			switch (vid) {
			case R.id.help:// 帮助
				intent = new Intent(MainActivity.this, HelpActivity.class);
				startActivity(intent);
				break;
			case R.id.exit:// 退出
				finish();
				break;
			case R.id.cancel:// 退出登录
				intent = new Intent(MainActivity.this, LoginActivity.class);
				startActivity(intent);
				finish();
				break;
			case R.id.about:// 关于
				intent = new Intent(MainActivity.this, AboutActivity.class);
				startActivity(intent);
				break;
			}
		}
	};

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		int action = event.getAction();
		if (action == KeyEvent.ACTION_DOWN && KeyEvent.KEYCODE_BACK == keyCode) {
			long currentTime = System.currentTimeMillis();
			if ((currentTime - touchTime) >= waitTime) {
				Toast.makeText(this, "再按一次退出", Toast.LENGTH_SHORT).show();
				touchTime = System.currentTimeMillis();
			} else {
				finish();
				// 退出后通过进程PID关闭进程
				int pid = android.os.Process.myPid();
				android.os.Process.killProcess(pid);
			}
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}
}
