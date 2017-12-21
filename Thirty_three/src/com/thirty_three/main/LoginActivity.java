package com.thirty_three.main;

import com.thirty_three.main.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * µÇÂ¼½çÃæ
 *
 */
public class LoginActivity extends Activity {
	private Button login;
	private EditText username, passwor;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		findViewId();
		listener();
	}

	private void findViewId() {
		login = (Button) findViewById(R.id.login_activity_login);
		username = (EditText) findViewById(R.id.username);
		passwor = (EditText) findViewById(R.id.password);
		username.setText("admin");
		passwor.setText("123456");
	}

	private void listener() {
		login.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				String user = username.getText().toString().trim();
				String pass = passwor.getText().toString().trim();
				if (!user.trim().equals("") && !pass.trim().equals("")) {

					if ("admin".equals(user) && "123456".equals(pass)) {
						Intent intent = new Intent(LoginActivity.this, MainActivity.class);
						startActivity(intent);
						finish();
					} else if ("admin".equals(user) && !"123456".equals(pass)) {
						Toast.makeText(getApplicationContext(), R.string.pass_miss, Toast.LENGTH_SHORT).show();
					} else {
						Toast.makeText(getApplicationContext(), R.string.login_lose, Toast.LENGTH_SHORT).show();
					}
				} else if (user.equals("") && !pass.equals("")) {
					Toast.makeText(getApplicationContext(), R.string.user_isnotnull, Toast.LENGTH_SHORT).show();

				} else if (!user.equals("") && pass.equals("")) {
					Toast.makeText(getApplicationContext(), R.string.pass_isnotnull, Toast.LENGTH_SHORT).show();
				} else {
					Toast.makeText(getApplicationContext(), R.string.user_pass_isnotnull, Toast.LENGTH_SHORT).show();
				}

			}
		});
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {

		if (keyCode == KeyEvent.KEYCODE_BACK) {
			finish();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}
}
