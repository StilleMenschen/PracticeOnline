package com.thirty_three.Util;

import com.thirty_three.main.ResultActivity;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;

/**
 * 题目判断
 */
public class SendResult {
	/**
	 * 构造方法
	 * 
	 * @param context
	 *            Parent Activity
	 * @param one_topic
	 *            第一题答案
	 * @param two_topic
	 *            第二题答案
	 * @param three_topic
	 *            第三题答案
	 * @param four_topic
	 *            第四题答案
	 * @param five_topic
	 *            第五题答案
	 * @param testType
	 *            测试类型(android or java)
	 */
	public SendResult(Activity context, String one_topic, String two_topic, String three_topic, String four_topic,
			String five_topic, int testType) {
		// 若题目完成了
		if (!one_topic.equals("") && !two_topic.equals("") && !three_topic.equals("") && four_topic.length() > 0
				&& five_topic.length() > 0) {
			Intent intents = new Intent(context, ResultActivity.class);
			// 使用Intent来传值
			intents.putExtra("flag", testType);
			intents.putExtra("one_topic", one_topic);
			intents.putExtra("two_topic", two_topic);
			intents.putExtra("three_topic", three_topic);
			intents.putExtra("four_topic", four_topic);
			intents.putExtra("five_topic", five_topic);
			// 启动页面
			context.startActivity(intents);
			// 结束掉Activity
			context.finish();
		}
		/** 判断题目是否完成 */
		else if (one_topic.equals("") && !two_topic.equals("") && !three_topic.equals("") && four_topic.length() > 0
				&& five_topic.length() > 0) {
			onToast(context, "第一题没做哦！！！");
		} else if (!one_topic.equals("") && two_topic.equals("") && !three_topic.equals("") && four_topic.length() > 0
				&& five_topic.length() > 0) {
			onToast(context, "第二题没做哦！！！");
		} else if (!one_topic.equals("") && !two_topic.equals("") && three_topic.equals("") && four_topic.length() > 0
				&& five_topic.length() > 0) {
			onToast(context, "第三题没做哦！！！");
		} else if (!one_topic.equals("") && !two_topic.equals("") && !three_topic.equals("") && four_topic.length() == 0
				&& five_topic.length() > 0) {
			onToast(context, "第四题没做哦！！！");
		} else if (!one_topic.equals("") && !two_topic.equals("") && !three_topic.equals("") && four_topic.length() > 0
				&& five_topic.length() == 0) {
			onToast(context, "第五题没做哦！！！");
		} else if (!one_topic.equals("") && !two_topic.equals("") && !three_topic.equals("") && four_topic.length() == 0
				&& five_topic.length() == 0) {
			onToast(context, "多选题没做哦！！！");
		} else if (one_topic.equals("") && two_topic.equals("") && three_topic.equals("") && four_topic.length() == 0
				&& five_topic.length() == 0) {
			onToast(context, "想交白卷吗？？？");
		} else {
			onToast(context, "有题没做完哦！！！");
		}
	}

	private void onToast(Activity context, String text) {
		Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
	}
}
