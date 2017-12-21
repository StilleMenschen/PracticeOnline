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
 * java��Ŀ
 */
public class JavaTestFragment extends Fragment implements OnClickListener {
	// ������
	private View parentView;
	// �ύ��ť
	private Button submit_java;
	// ��ѡ��ť��
	private RadioGroup java_rg1, java_rg2, java_rg3;
	// ��ѡ��
	private CheckBox cb4_a, cb4_b, cb4_c, cb4_d, cb5_a, cb5_b, cb5_c, cb5_d;
	// ��ѡ���
	private String one_topic = "", two_topic = "", three_topic = "";
	// ��ѡ���
	private String four_topic1 = "", four_topic2 = "", four_topic3 = "", four_topic4 = "", five_topic1 = "",
			five_topic2 = "", five_topic3 = "", five_topic4 = "", four_topic, five_topic;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		parentView = inflater.inflate(R.layout.javatest, container, false);
		findViewId();
		listener();
		return parentView;
	}

	private void findViewId() {
		// ��ѡ��ť��
		java_rg1 = (RadioGroup) parentView.findViewById(R.id.java_rg1);
		java_rg2 = (RadioGroup) parentView.findViewById(R.id.java_rg2);
		java_rg3 = (RadioGroup) parentView.findViewById(R.id.java_rg3);
		// ��ѡ��
		cb4_a = (CheckBox) parentView.findViewById(R.id.javatest_4_a);
		cb4_b = (CheckBox) parentView.findViewById(R.id.javatest_4_b);
		cb4_c = (CheckBox) parentView.findViewById(R.id.javatest_4_c);
		cb4_d = (CheckBox) parentView.findViewById(R.id.javatest_4_d);
		cb5_a = (CheckBox) parentView.findViewById(R.id.javatest_5_a);
		cb5_b = (CheckBox) parentView.findViewById(R.id.javatest_5_b);
		cb5_c = (CheckBox) parentView.findViewById(R.id.javatest_5_c);
		cb5_d = (CheckBox) parentView.findViewById(R.id.javatest_5_d);
		// �ύ��ť
		submit_java = (Button) parentView.findViewById(R.id.submit_java);
	}

	private void listener() {
		// ������ѡ��ť��
		java_rg1.setOnCheckedChangeListener(rgListener);
		java_rg2.setOnCheckedChangeListener(rgListener);
		java_rg3.setOnCheckedChangeListener(rgListener);
		// ������ѡ��
		cb4_a.setOnCheckedChangeListener(listener);
		cb4_b.setOnCheckedChangeListener(listener);
		cb4_c.setOnCheckedChangeListener(listener);
		cb4_d.setOnCheckedChangeListener(listener);
		cb5_a.setOnCheckedChangeListener(listener);
		cb5_b.setOnCheckedChangeListener(listener);
		cb5_c.setOnCheckedChangeListener(listener);
		cb5_d.setOnCheckedChangeListener(listener);
		// �����ύ��ť
		submit_java.setOnClickListener(this);
	}

	/**
	 * ��ѡ��
	 */
	private RadioGroup.OnCheckedChangeListener rgListener = new RadioGroup.OnCheckedChangeListener() {

		@Override
		public void onCheckedChanged(RadioGroup rg, int checkedId) {
			switch (checkedId) {
			// ��һ��
			case R.id.java_rb1_a:
				one_topic = "A";
				break;
			case R.id.java_rb1_b:
				one_topic = "B";
				break;
			case R.id.java_rb1_c:
				one_topic = "C";
				break;
			case R.id.java_rb1_d:
				one_topic = "D";
				break;
			// �ڶ���
			case R.id.java_rb2_a:
				two_topic = "A";
				break;
			case R.id.java_rb2_b:
				two_topic = "B";
				break;
			case R.id.java_rb2_c:
				two_topic = "C";
				break;
			case R.id.java_rb2_d:
				two_topic = "D";
				break;
			// ������
			case R.id.java_rb3_a:
				three_topic = "A";
				break;
			case R.id.java_rb3_b:
				three_topic = "B";
				break;
			case R.id.java_rb3_c:
				three_topic = "C";
				break;
			case R.id.java_rb3_d:
				three_topic = "D";
				break;
			}
		}
	};

	/**
	 * ��ѡ��
	 */
	private OnCheckedChangeListener listener = new OnCheckedChangeListener() {

		@Override
		public void onCheckedChanged(CompoundButton cb, boolean isChecked) {
			int cbid = cb.getId();
			switch (cbid) {
			// ��ѡ��4
			case R.id.javatest_4_a:
				four_topic1 = isChecked ? "A" : "";
				break;
			case R.id.javatest_4_b:
				four_topic2 = isChecked ? "B" : "";
				break;
			case R.id.javatest_4_c:
				four_topic3 = isChecked ? "C" : "";
				break;
			case R.id.javatest_4_d:
				four_topic4 = isChecked ? "D" : "";
				break;
			// ��ѡ��5
			case R.id.javatest_5_a:
				five_topic1 = isChecked ? "A" : "";
				break;
			case R.id.javatest_5_b:
				five_topic1 = isChecked ? "B" : "";
				break;
			case R.id.javatest_5_c:
				five_topic1 = isChecked ? "C" : "";
				break;
			case R.id.javatest_5_d:
				five_topic1 = isChecked ? "D" : "";
				break;
			}
		}
	};

	@Override
	public void onClick(View v) {
		Activity activity = getActivity();
		four_topic = four_topic1 + four_topic2 + four_topic3 + four_topic4;
		five_topic = five_topic1 + five_topic2 + five_topic3 + five_topic4;
		// �ж���Ŀ
		new SendResult(activity, one_topic, two_topic, three_topic, four_topic, five_topic, ResultActivity.JAVA_TEST);
	}
}
