package com.thirty_three.main;

import com.thirty_three.main.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

/**
 * 关于界面
 */
public class AboutActivity extends Activity {
	private ImageButton aboutImgBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about);
		// 查找布局中的返回按钮
		aboutImgBtn = (ImageButton) findViewById(R.id.about_back);
		// 设置单击事件监听器
		aboutImgBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();// 结束Activity
			}
		});
	}

	// 按键监听
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			finish();// 结束Activity
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

}
