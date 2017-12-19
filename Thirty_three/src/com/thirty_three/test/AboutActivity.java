package com.thirty_three.test;



import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
/**
 * 关于界面
 * 
 *
 */
public class AboutActivity extends Activity {
	private ImageButton about;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about);
		about = (ImageButton) findViewById(R.id.about_back);
		about.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				
				AboutActivity.this.finish();
			}
		});
	}
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if(keyCode == KeyEvent.KEYCODE_BACK) {
			AboutActivity.this.finish();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}
}
