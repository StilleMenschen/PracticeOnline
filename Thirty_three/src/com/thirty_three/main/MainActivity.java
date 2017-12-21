package com.thirty_three.main;

import com.thirty_three.Util.SelectPicPopupWindow;
import com.thirty_three.adapter.FragmentAdapter;
import com.thirty_three.main.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioButton;
import android.widget.Toast;

/**
 * ������
 */
public class MainActivity extends FragmentActivity implements OnClickListener {

	private static final int TAB_ANDROID = 0;
	private static final int TAB_JAVA = 1;
	private long waitTime = 2000;
	private long touchTime = 0;
	private ViewPager viewPager;// ������ҳ
	private RadioButton home_android, home_java;
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
		home_android = (RadioButton) findViewById(R.id.home_android);
		home_java = (RadioButton) findViewById(R.id.home_java);

		home_android.setOnClickListener(this);
		home_java.setOnClickListener(this);

		viewPager.setAdapter(new FragmentAdapter(getSupportFragmentManager()));
	}

	private void addListener() {
		viewPager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int id) {
				switch (id) {
				case TAB_ANDROID:
					home_android.setChecked(true);
					break;
				case TAB_JAVA:
					home_java.setChecked(true);
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
	}

	/**
	 * RadioRutton����¼�ʵ��
	 */
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.home_android:
			viewPager.setCurrentItem(TAB_ANDROID);
			break;
		case R.id.home_java:
			viewPager.setCurrentItem(TAB_JAVA);
			break;
		}
	}

	@Override
	public boolean onMenuOpened(int featureId, Menu menu) {

		menuWindow = new SelectPicPopupWindow(MainActivity.this, itemsOnClick);
		// ��ʾ����
		menuWindow.showAtLocation(findViewById(R.id.main), Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);

		return false;
	}

	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		menu.add("menu");
		return super.onPrepareOptionsMenu(menu);
	}

	// ��������ʵ�ּ�����
	private OnClickListener itemsOnClick = new OnClickListener() {

		public void onClick(View v) {
			menuWindow.dismiss();
			switch (v.getId()) {
			case R.id.help:
				Intent intent1 = new Intent(MainActivity.this, HelpActivity.class);
				startActivity(intent1);
				break;
			case R.id.exit:
				finish();
				break;
			case R.id.cancel:
				Intent intent = new Intent(MainActivity.this, LoginActivity.class);
				startActivity(intent);
				finish();
				break;
			case R.id.about:
				Intent intents = new Intent(MainActivity.this, AboutActivity.class);
				startActivity(intents);
				break;
			}
		}
	};

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {

		if (event.getAction() == KeyEvent.ACTION_DOWN && KeyEvent.KEYCODE_BACK == keyCode) {
			long currentTime = System.currentTimeMillis();
			if ((currentTime - touchTime) >= waitTime) {
				Toast.makeText(this, "�ٰ�һ���˳�", Toast.LENGTH_SHORT).show();
				touchTime = currentTime;
			} else {
				finish();
				// �˳���ͨ������PID�رս���
				int pid = android.os.Process.myPid();
				android.os.Process.killProcess(pid);
			}
			return true;
		}
		return super.onKeyDown(keyCode, event);

	}
}