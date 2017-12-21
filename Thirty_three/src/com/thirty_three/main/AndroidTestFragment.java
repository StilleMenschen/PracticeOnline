package com.thirty_three.main;

import com.thirty_three.Util.SendResult;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RadioGroup;

/**
 * android 题目
 */
public class AndroidTestFragment extends Fragment implements OnClickListener {
	// 父布局
	private View parentView;
	// 提交按钮
	private Button submit_android;
	// 单选按钮组
	private RadioGroup android_rg1, android_rg2, android_rg3;
	// 复选框
	private CheckBox cb4_a, cb4_b, cb4_c, cb4_d, cb5_a, cb5_b, cb5_c, cb5_d;
	// 单选题答案存储
	private String one_topic = "", two_topic = "", three_topic = "";
	// 多选题答案存储
	private String four_topic1 = "", four_topic2 = "", four_topic3 = "", four_topic4 = "", five_topic1 = "",
			five_topic2 = "", five_topic3 = "", five_topic4 = "", four_topic, five_topic;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		parentView = inflater.inflate(R.layout.androidtest, container, false);
		findViewId();
		listener();

		return parentView;
	}

	private void findViewId() {
		// 单选按钮组
		android_rg1 = (RadioGroup) parentView.findViewById(R.id.android_rg1);
		android_rg2 = (RadioGroup) parentView.findViewById(R.id.android_rg2);
		android_rg3 = (RadioGroup) parentView.findViewById(R.id.android_rg3);
		// 复选框
		cb4_a = (CheckBox) parentView.findViewById(R.id.androidtest_4_a);
		cb4_b = (CheckBox) parentView.findViewById(R.id.androidtest_4_b);
		cb4_c = (CheckBox) parentView.findViewById(R.id.androidtest_4_c);
		cb4_d = (CheckBox) parentView.findViewById(R.id.androidtest_4_d);
		cb5_a = (CheckBox) parentView.findViewById(R.id.androidtest_5_a);
		cb5_b = (CheckBox) parentView.findViewById(R.id.androidtest_5_b);
		cb5_c = (CheckBox) parentView.findViewById(R.id.androidtest_5_c);
		cb5_d = (CheckBox) parentView.findViewById(R.id.androidtest_5_d);
		// 提交按钮
		submit_android = (Button) parentView.findViewById(R.id.submit_android);
	}

	// 设置监听器
	private void listener() {
		// 单选按钮组
		android_rg1.setOnCheckedChangeListener(rgListener);
		android_rg2.setOnCheckedChangeListener(rgListener);
		android_rg3.setOnCheckedChangeListener(rgListener);
		// 复选框
		cb4_a.setOnCheckedChangeListener(listener);
		cb4_b.setOnCheckedChangeListener(listener);
		cb4_c.setOnCheckedChangeListener(listener);
		cb4_d.setOnCheckedChangeListener(listener);
		cb5_a.setOnCheckedChangeListener(listener);
		cb5_b.setOnCheckedChangeListener(listener);
		cb5_c.setOnCheckedChangeListener(listener);
		cb5_d.setOnCheckedChangeListener(listener);
		// 提交按钮
		submit_android.setOnClickListener(this);
	}

	/**
	 * 单选题
	 */
	private RadioGroup.OnCheckedChangeListener rgListener = new RadioGroup.OnCheckedChangeListener() {

		@Override
		public void onCheckedChanged(RadioGroup rg, int checkedId) {
			switch (checkedId) {
			// 第一题
			case R.id.android_rb1_a:
				one_topic = "A";
				break;
			case R.id.android_rb1_b:
				one_topic = "B";
				break;
			case R.id.android_rb1_c:
				one_topic = "C";
				break;
			case R.id.android_rb1_d:
				one_topic = "D";
				break;
			// 第二题
			case R.id.android_rb2_a:
				two_topic = "A";
				break;
			case R.id.android_rb2_b:
				two_topic = "B";
				break;
			case R.id.android_rb2_c:
				two_topic = "C";
				break;
			case R.id.android_rb2_d:
				two_topic = "D";
				break;
			// 第三题
			case R.id.android_rb3_a:
				three_topic = "A";
				break;
			case R.id.android_rb3_b:
				three_topic = "B";
				break;
			case R.id.android_rb3_c:
				three_topic = "C";
				break;
			case R.id.android_rb3_d:
				three_topic = "D";
				break;
			}
		}
	};

	/**
	 * 多选题
	 */
	private OnCheckedChangeListener listener = new OnCheckedChangeListener() {
		@Override
		public void onCheckedChanged(CompoundButton cb, boolean isChecked) {
			int cbid = cb.getId();
			switch (cbid) {
			// 多选题4
			case R.id.androidtest_4_a:
				four_topic1 = isChecked ? "A" : "";
				break;
			case R.id.androidtest_4_b:
				four_topic2 = isChecked ? "B" : "";
				break;
			case R.id.androidtest_4_c:
				four_topic3 = isChecked ? "C" : "";
				break;
			case R.id.androidtest_4_d:
				four_topic4 = isChecked ? "D" : "";
				break;
			// 多选题5
			case R.id.androidtest_5_a:
				five_topic1 = isChecked ? "A" : "";
				break;
			case R.id.androidtest_5_b:
				five_topic1 = isChecked ? "B" : "";
				break;
			case R.id.androidtest_5_c:
				five_topic1 = isChecked ? "C" : "";
				break;
			case R.id.androidtest_5_d:
				five_topic1 = isChecked ? "D" : "";
				break;
			}
		}
	};

	@Override
	public void onClick(View v) {
		// 父级Activity
		Activity activity = getActivity();
		// 拼接多选题答案
		four_topic = four_topic1 + four_topic2 + four_topic3 + four_topic4;
		five_topic = five_topic1 + five_topic2 + five_topic3 + five_topic4;
		// 获取结果
		new SendResult(activity, one_topic, two_topic, three_topic, four_topic, five_topic,
				ResultActivity.ANDROID_TEST);
	}

}
