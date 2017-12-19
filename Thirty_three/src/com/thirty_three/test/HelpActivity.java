package com.thirty_three.test;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

/**
 * ����ҳ
 *
 */
public class HelpActivity extends Activity {
	private ImageButton help;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.help);
		help = (ImageButton) findViewById(R.id.help_back);
		help.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				HelpActivity.this.finish();
			}
		});
	}

	// ���ؼ�
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			HelpActivity.this.finish();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}
}
