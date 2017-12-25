package com.thirty_three.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * ��¼����
 */
public class LoginActivity extends Activity {
	// ��¼��ť
	private Button btnlogin;
	// �û��������������
	private EditText username, passwor;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		findViewId();
		listener();
	}

	private void findViewId() {
		btnlogin = (Button) findViewById(R.id.login_activity_login);
		username = (EditText) findViewById(R.id.username);
		passwor = (EditText) findViewById(R.id.password);
		username.setText("admin");
		passwor.setText("123456");
	}

	private void listener() {
		btnlogin.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String user = username.getText().toString().trim();
				String pass = passwor.getText().toString().trim();

				/* �û���Ϊ�� */
				if (user.equals("")) {
					onToast(R.string.user_isnotnull);
				} else {
					/* ����Ϊ�� */
					if (pass.equals("")) {
						onToast(R.string.pass_isnotnull);
					} else {
						if ("admin".equals(user) && "123456".equals(pass)) {
							Intent intent = new Intent(LoginActivity.this, MainActivity.class);
							startActivity(intent);
							finish();
						} else if ("admin".equals(user) && !"123456".equals(pass)) {
							onToast(R.string.pass_miss);
						} else {
							onToast(R.string.login_lose);
						}
					}
				}
			}

			private void onToast(int sid) {
				Toast.makeText(getApplicationContext(), sid, Toast.LENGTH_SHORT).show();
			}

		});
	}

	// ���ذ�ť����
	@Override
	public void onBackPressed() {
		super.onBackPressed();
		finish();
	}
}
