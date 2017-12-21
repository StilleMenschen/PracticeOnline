package com.thirty_three.main;

import com.thirty_three.main.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

/**
 * ���ڽ���
 */
public class AboutActivity extends Activity {
	private ImageButton aboutImgBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about);
		// ���Ҳ����еķ��ذ�ť
		aboutImgBtn = (ImageButton) findViewById(R.id.about_back);
		// ���õ����¼�������
		aboutImgBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();// ����Activity
			}
		});
	}

	// ��������
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			finish();// ����Activity
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

}
