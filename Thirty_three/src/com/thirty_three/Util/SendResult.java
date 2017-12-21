package com.thirty_three.Util;

import com.thirty_three.main.ResultActivity;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;

/**
 * ��Ŀ�ж�
 */
public class SendResult {
	/**
	 * ���췽��
	 * 
	 * @param context
	 *            Parent Activity
	 * @param one_topic
	 *            ��һ���
	 * @param two_topic
	 *            �ڶ����
	 * @param three_topic
	 *            �������
	 * @param four_topic
	 *            �������
	 * @param five_topic
	 *            �������
	 * @param testType
	 *            ��������(android or java)
	 */
	public SendResult(Activity context, String one_topic, String two_topic, String three_topic, String four_topic,
			String five_topic, int testType) {
		// ����Ŀ�����
		if (!one_topic.equals("") && !two_topic.equals("") && !three_topic.equals("") && four_topic.length() > 0
				&& five_topic.length() > 0) {
			Intent intents = new Intent(context, ResultActivity.class);
			// ʹ��Intent����ֵ
			intents.putExtra("flag", testType);
			intents.putExtra("one_topic", one_topic);
			intents.putExtra("two_topic", two_topic);
			intents.putExtra("three_topic", three_topic);
			intents.putExtra("four_topic", four_topic);
			intents.putExtra("five_topic", five_topic);
			// ����ҳ��
			context.startActivity(intents);
			// ������Activity
			context.finish();
		}
		/** �ж���Ŀ�Ƿ���� */
		else if (one_topic.equals("") && !two_topic.equals("") && !three_topic.equals("") && four_topic.length() > 0
				&& five_topic.length() > 0) {
			onToast(context, "��һ��û��Ŷ������");
		} else if (!one_topic.equals("") && two_topic.equals("") && !three_topic.equals("") && four_topic.length() > 0
				&& five_topic.length() > 0) {
			onToast(context, "�ڶ���û��Ŷ������");
		} else if (!one_topic.equals("") && !two_topic.equals("") && three_topic.equals("") && four_topic.length() > 0
				&& five_topic.length() > 0) {
			onToast(context, "������û��Ŷ������");
		} else if (!one_topic.equals("") && !two_topic.equals("") && !three_topic.equals("") && four_topic.length() == 0
				&& five_topic.length() > 0) {
			onToast(context, "������û��Ŷ������");
		} else if (!one_topic.equals("") && !two_topic.equals("") && !three_topic.equals("") && four_topic.length() > 0
				&& five_topic.length() == 0) {
			onToast(context, "������û��Ŷ������");
		} else if (!one_topic.equals("") && !two_topic.equals("") && !three_topic.equals("") && four_topic.length() == 0
				&& five_topic.length() == 0) {
			onToast(context, "��ѡ��û��Ŷ������");
		} else if (one_topic.equals("") && two_topic.equals("") && three_topic.equals("") && four_topic.length() == 0
				&& five_topic.length() == 0) {
			onToast(context, "�뽻�׾��𣿣���");
		} else {
			onToast(context, "����û����Ŷ������");
		}
	}

	private void onToast(Activity context, String text) {
		Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
	}
}
