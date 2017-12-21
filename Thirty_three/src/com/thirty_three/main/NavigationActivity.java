package com.thirty_three.main;

import java.util.ArrayList;
import java.util.List;

import com.thirty_three.adapter.GuideAdapter;
import com.thirty_three.main.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * ��ʼ�����򵼺�ҳ
 */
public class NavigationActivity extends Activity implements OnPageChangeListener {
	boolean isFirstIn;
	private ViewPager viewPager;// ������ҳ
	private List<View> list;
	// �ײ�С��ͼƬ
	private ImageView[] dots;
	// ��¼��ǰѡ��λ��
	private int currentIndex;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// ��ǵ�ǰActivity����ռ����Ļ
		int flag = WindowManager.LayoutParams.FLAG_FULLSCREEN;
		getWindow().setFlags(flag, flag);
		// ���ز����ļ�
		setContentView(R.layout.navigation);
		// ��ʼ����ҳ��
		initView();
		// ��ʼ��СԲ��
		initDots();
	}

	/**
	 * ��ҳ��
	 */
	@SuppressLint("InflateParams")
	private void initView() {
		viewPager = (ViewPager) findViewById(R.id.vp1);
		// ʹ��LayoutInflater�����벼��
		LayoutInflater inflater = LayoutInflater.from(NavigationActivity.this);
		// ��ʼ������ͼƬ�б�
		View start_one = inflater.inflate(R.layout.start_one, null);
		View start_two = inflater.inflate(R.layout.start_two, null);
		View start_three = inflater.inflate(R.layout.start_three, null);
		View start_four = inflater.inflate(R.layout.start_four, null);
		// Ϊ����ҳ�����һҳ�еİ�ť���¼�
		Button btnStart = (Button) start_four.findViewById(R.id.tiyan);
		btnStart.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// ʹ��SharedPreferences����¼�Ƿ��״�����APP
				SharedPreferences preferences = getSharedPreferences("test", Activity.MODE_PRIVATE);
				Editor editor = preferences.edit();
				// д��һ������ֵ
				editor.putBoolean("test", false);
				// �ύ�޸�
				editor.commit();
				Intent intent = new Intent(NavigationActivity.this, LoginActivity.class);
				startActivity(intent);
				finish();
			}

		});
		list = new ArrayList<View>();
		// �洢��������
		list.add(start_one);
		list.add(start_two);
		list.add(start_three);
		list.add(start_four);
		// ��ʼ��������
		GuideAdapter adapter = new GuideAdapter(list);
		viewPager.setAdapter(adapter);
		viewPager.setOnPageChangeListener(this);
	}

	/**
	 * Բ��
	 */
	private void initDots() {
		// װ��СԲ������Բ���
		LinearLayout ll = (LinearLayout) findViewById(R.id.ll);
		// �Ȼ�ȡСԲ������
		int size = list.size();
		// ��ʼ��ImageView�������С
		dots = new ImageView[size];
		// ѭ��ȡ��С��ͼƬ
		for (int i = 0; i < size; i++) {
			dots[i] = (ImageView) ll.getChildAt(i);
			dots[i].setEnabled(true);// ����Ϊ��ɫ
		}
		// ���õ�ǰҳ������
		currentIndex = 0;
		// ����Ϊ��ɫ����ѡ��״̬
		dots[currentIndex].setEnabled(false);
	}

	// ����position����СԲ�����
	private void setCurrentDot(int position) {
		// �жϹ�����λ���Ƿ񳬳����鷶Χ���뵱ǰ��ͬ����ҳ��λ��δ�����仯��
		if (position < 0 || position > list.size() - 1 || currentIndex == position) {
			return;// ֱ�ӽ�������ִ�з����еĺ����Ĳ���
		}
		// ����ѡ�е��µ�СԲ�����
		dots[position].setEnabled(false);
		// ����֮ǰ��СԲ���û�
		dots[currentIndex].setEnabled(true);
		// ��¼�µ�СԲ��λ��
		currentIndex = position;
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
	}

	@Override
	public void onPageSelected(int arg0) {
		// ҳ��ı�ʱ��ͬ���л�СԲ�����ʾ״̬
		setCurrentDot(arg0);
	}
}
