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
 * ������
 */
public class MainActivity extends FragmentActivity implements onMenuOpenedListener {
	// ���ؼ����µ���ʱ����
	private long waitTime = 2000;
	private long touchTime = 0;
	// ������ҳ
	private ViewPager viewPager;
	// ����ҳ��
	private RadioGroup radioGroup;
	// Menu�˵�
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
		// ҳ�������
		viewPager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int id) {
				// ViewPager�е�Tabҳ�ı�ʱ��ͬ���ı䵥ѡ��ť��ѡ��״̬
				switch (id) {
				case FragmentAdapter.TAB_ANDROID:// Android����
					radioGroup.check(R.id.home_android);
					break;
				case FragmentAdapter.TAB_JAVA:// Java����
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
		// ��ѡ��ť�������
		radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				switch (checkedId) {
				case R.id.home_android:// Android����
					viewPager.setCurrentItem(FragmentAdapter.TAB_ANDROID);
					break;
				case R.id.home_java:// Java����
					viewPager.setCurrentItem(FragmentAdapter.TAB_JAVA);
					break;
				}
			}
		});
	}

	@Override
	public void openMenu() {
		menuWindow = new SelectPicPopupWindow(MainActivity.this, itemsOnClick);
		// �˵����ڵĸ�����
		View parent = findViewById(R.id.main);
		// ��ʾλ��(�ײ�|ˮƽ����)
		menuWindow.showAtLocation(parent, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
	}
	
	@Override
	public boolean onMenuOpened(int featureId, Menu menu) {
		openMenu();
		return false;
	}

	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		menu.add("Menu");// Menu����
		return super.onPrepareOptionsMenu(menu);
	}

	// Ϊ�����˵�����ʵ�ּ�����
	private OnClickListener itemsOnClick = new OnClickListener() {
		public void onClick(View v) {
			menuWindow.dismiss();// �ص��˵�
			Intent intent;
			int vid = v.getId();
			switch (vid) {
			case R.id.help:// ����
				intent = new Intent(MainActivity.this, HelpActivity.class);
				startActivity(intent);
				break;
			case R.id.exit:// �˳�
				finish();
				break;
			case R.id.cancel:// �˳���¼
				intent = new Intent(MainActivity.this, LoginActivity.class);
				startActivity(intent);
				finish();
				break;
			case R.id.about:// ����
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
				Toast.makeText(this, "�ٰ�һ���˳�", Toast.LENGTH_SHORT).show();
				touchTime = System.currentTimeMillis();
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
