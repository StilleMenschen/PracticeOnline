package com.thirty_three.main;

import com.thirty_three.Util.SelectPicPopupWindow;
import com.thirty_three.Util.onMenuOpenedListener;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 题目对错判断
 */
public class ResultActivity extends Activity implements onMenuOpenedListener {

	// 标记试题类型
	public static final int ANDROID_TEST = 0x0010;
	public static final int JAVA_TEST = 0x0011;

	private long waitTime = 2000;
	private long touchTime = 0;
	// 按钮
	private Button show_result, one_again;
	// 菜单按钮
	private View btn_result_menu;
	// 结果显示
	private TextView titlt, present1, present2, present3, present4, present5, right_wrong1, right_wrong2, right_wrong3,
			right_wrong4, right_wrong5, result1, result2, result3, result4, result5, score1, score2, score3, score4,
			score5, total_score;
	// 结果存储
	private String one_topic, two_topic, three_topic, four_topic, five_topic, answer1, answer2, answer3, answer4,
			answer5;
	// 测试类型
	int label;
	// 计分
	private int result_score1, result_score2, result_score3, result_score4, result_score5;
	private char a[], b[];
	private boolean flag, mark;
	private SelectPicPopupWindow menuWindow;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.result);
		findViewId();
		Listener();
		getResult();
		init();
	}

	private void findViewId() {
		// 页面标题
		titlt = (TextView) findViewById(R.id.result_title);
		// 用户的答案
		present1 = (TextView) findViewById(R.id.present1);
		present2 = (TextView) findViewById(R.id.present2);
		present3 = (TextView) findViewById(R.id.present3);
		present4 = (TextView) findViewById(R.id.present4);
		present5 = (TextView) findViewById(R.id.present5);
		// 对错显示
		right_wrong1 = (TextView) findViewById(R.id.right_wrong1);
		right_wrong2 = (TextView) findViewById(R.id.right_wrong2);
		right_wrong3 = (TextView) findViewById(R.id.right_wrong3);
		right_wrong4 = (TextView) findViewById(R.id.right_wrong4);
		right_wrong5 = (TextView) findViewById(R.id.right_wrong5);
		// 正确答案
		result1 = (TextView) findViewById(R.id.result1);
		result2 = (TextView) findViewById(R.id.result2);
		result3 = (TextView) findViewById(R.id.result3);
		result4 = (TextView) findViewById(R.id.result4);
		result5 = (TextView) findViewById(R.id.result5);
		// 得分
		score1 = (TextView) findViewById(R.id.score1);
		score2 = (TextView) findViewById(R.id.score2);
		score3 = (TextView) findViewById(R.id.score3);
		score4 = (TextView) findViewById(R.id.score4);
		score5 = (TextView) findViewById(R.id.score5);
		// 总分
		total_score = (TextView) findViewById(R.id.total_score);
		// 显示答案按钮
		show_result = (Button) findViewById(R.id.show_result);
		// 重做按钮
		one_again = (Button) findViewById(R.id.one_again);
		// 菜单按钮
		btn_result_menu = findViewById(R.id.btn_result_menu);
	}

	private void Listener() {
		show_result.setOnClickListener(buttonListener);
		one_again.setOnClickListener(buttonListener);
		btn_result_menu.setOnClickListener(buttonListener);
	}

	private void getResult() {
		Intent intents = getIntent();
		label = intents.getIntExtra("flag", 0);
		one_topic = intents.getStringExtra("one_topic");
		two_topic = intents.getStringExtra("two_topic");
		three_topic = intents.getStringExtra("three_topic");
		four_topic = intents.getStringExtra("four_topic");
		five_topic = intents.getStringExtra("five_topic");
	}

	// 判断测试类型
	private void init() {
		switch (label) {
		case ANDROID_TEST:
			androidJudge();
			break;
		case JAVA_TEST:
			javaJudge();
			break;
		}
	}

	/**
	 * android结果处理
	 */
	private void androidJudge() {
		// 标题
		titlt.setText(R.string.android_test_result);
		// 答案
		answer1 = "B";
		answer2 = "D";
		answer3 = "A";
		answer4 = "BC";
		answer5 = "ABCD";
		Judge();
	}

	/**
	 * java结果处理
	 */
	private void javaJudge() {
		// 标题
		titlt.setText(R.string.java_test_result);
		// 答案
		answer1 = "A";
		answer2 = "C";
		answer3 = "B";
		answer4 = "ABC";
		answer5 = "BCD";
		Judge();
	}

	/**
	 * 判断对错
	 */
	private void Judge() {
		// 显示用户所选的答案
		present1.setText(one_topic);
		present2.setText(two_topic);
		present3.setText(three_topic);
		present4.setText(four_topic);
		present5.setText(five_topic);
		// 单选
		if (one_topic.equals(answer1)) {
			right_wrong1.setText("√");
			result_score1 = 20;
		} else if (!one_topic.equals(answer1)) {
			right_wrong1.setText("×");
			result_score1 = 0;
		}
		if (two_topic.equals(answer2)) {
			right_wrong2.setText("√");
			result_score2 = 20;
		} else if (!two_topic.equals(answer2)) {
			right_wrong2.setText("×");
			result_score2 = 0;
		}
		if (three_topic.equals(answer3)) {
			right_wrong3.setText("√");
			result_score3 = 20;
		} else if (!three_topic.equals(answer3)) {
			right_wrong3.setText("×");
			result_score3 = 0;
		}
		// 多选
		if (four_topic.equals(answer4)) {// 全对
			right_wrong4.setText("√");
			result_score4 = 20;
		} else if (!four_topic.equals(answer4)) {// 不是全对
			// 选多了
			if (four_topic.length() > answer4.length()) {
				right_wrong4.setText("×");
				result_score4 = 0;
			}
			/* 选少了 */
			else if (four_topic.length() < answer4.length()) {
				a = new char[four_topic.length()];
				for (int i = 0; i < four_topic.length(); i++) {
					a[i] = four_topic.charAt(i);
				}
				flag = true;
				for (int i = 0; i < a.length; i++) {
					// 逐个对比字符
					if (!answer4.contains((a[i] + ""))) {
						// 如果过用户答案在结果中找不到，则结束
						flag = false;
						break;
					}
				}
				// 选对了部分答案
				if (flag) {
					right_wrong4.setText("√");
					result_score4 = 10;
				} else {
					right_wrong4.setText("×");
					result_score4 = 0;
				}

			}
			/* 未知情况 */
			else {
				right_wrong4.setText("×");
				result_score4 = 0;
			}
		}
		if (five_topic.equals(answer5)) {
			right_wrong5.setText("√");
			result_score5 = 20;
		} else if (!five_topic.equals(answer5)) {
			if (five_topic.length() > answer5.length()) {
				right_wrong5.setText("×");
				result_score5 = 0;
			} else if (five_topic.length() < answer5.length()) {
				b = new char[five_topic.length()];
				for (int i = 0; i < five_topic.length(); i++) {
					b[i] = five_topic.charAt(i);
				}
				mark = true;
				for (int i = 0; i < b.length; i++) {
					if (!answer5.contains((b[i] + ""))) {
						mark = false;
						break;
					}
				}
				if (mark) {
					right_wrong5.setText("√");
					result_score5 = 10;
				} else {
					right_wrong5.setText("×");
					result_score5 = 0;
				}

			} else {
				right_wrong5.setText("×");
				result_score5 = 0;
			}
		}
	}

	private OnClickListener buttonListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			int vid = v.getId();
			switch (vid) {
			case R.id.show_result:// 显示得分
				result1.setText(answer1);
				result2.setText(answer2);
				result3.setText(answer3);
				result4.setText(answer4);
				result5.setText(answer5);
				score1.setText(result_score1 + "");
				score2.setText(result_score2 + "");
				score3.setText(result_score3 + "");
				score4.setText(result_score4 + "");
				score5.setText(result_score5 + "");
				// 计算总分
				int total = result_score1 + result_score2 + result_score3 + result_score4 + result_score5;
				total_score.setText(total + "");
				break;
			case R.id.one_again:// 重新做题
				Intent intent = new Intent(getApplicationContext(), MainActivity.class);
				startActivity(intent);
				finish();
				break;
			case R.id.btn_result_menu:
				openMenu();
				break;
			}
		}
	};

	@Override
	public void openMenu() {
		menuWindow = new SelectPicPopupWindow(ResultActivity.this, itemsOnClick);
		// 菜单所在的父布局
		View parent = findViewById(R.id.result_lin);
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
		menu.add("Menu");// 菜单标题
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
				intent = new Intent(ResultActivity.this, HelpActivity.class);
				startActivity(intent);
				break;
			case R.id.exit:// 退出
				finish();
				break;
			case R.id.cancel:// 退出登录
				intent = new Intent(ResultActivity.this, LoginActivity.class);
				startActivity(intent);
				finish();
				break;
			case R.id.about:// 关于
				intent = new Intent(ResultActivity.this, AboutActivity.class);
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
				Toast.makeText(ResultActivity.this, "再按一次退出", Toast.LENGTH_SHORT).show();
				touchTime = System.currentTimeMillis();
			} else {
				finish();
				// 退出后关闭进程
				int pid = android.os.Process.myPid();
				android.os.Process.killProcess(pid);
			}
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}
}
