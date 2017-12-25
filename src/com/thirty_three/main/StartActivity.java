package com.thirty_three.main;

import com.thirty_three.main.R;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

/**
 * ��������ҳ��
 */
public class StartActivity extends Activity {
	/** �ȴ�2000���룬��2�� */
	private static final long SPLASH_DISPLAY_LENGHT = 2000;
	boolean isFirstIn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.start);

		// ��ȡSharedPreFerences����Ҫ������,ʹ��SharedPreFerences����¼����������ʹ�ô���
		SharedPreferences preferences = getSharedPreferences("test", Activity.MODE_PRIVATE);
		// ȡ����Ӧ��ֵ,���û�и�ֵ,˵����δд��,��true��ΪĬ��ֵ
		isFirstIn = preferences.getBoolean("test", true);
		// �״����������뵼��ҳ
		if (isFirstIn) {
			new Handler().postDelayed(new Runnable() {
				@Override
				public void run() {
					Intent intent = new Intent(StartActivity.this, NavigationActivity.class);
					startActivity(intent);
					finish();
					// ����Ч��
					overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
				}
				// �ӳ�ʱ��
			}, SPLASH_DISPLAY_LENGHT);
		}
		/* �����״������������¼ҳ */
		else {
			new Handler().postDelayed(new Runnable() {
				@Override
				public void run() {
					Intent Intent = new Intent(StartActivity.this, LoginActivity.class);
					startActivity(Intent);
					finish();
					// ����Ч��
					overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
				}
				// �ӳ�ʱ��
			}, SPLASH_DISPLAY_LENGHT);
		}
	}
}
