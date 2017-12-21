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
 * 初始化程序导航页
 */
public class NavigationActivity extends Activity implements OnPageChangeListener {
	boolean isFirstIn;
	private ViewPager viewPager;// 滑动的页
	private List<View> list;
	// 底部小点图片
	private ImageView[] dots;
	// 记录当前选中位置
	private int currentIndex;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// 标记当前Activity窗口占满屏幕
		int flag = WindowManager.LayoutParams.FLAG_FULLSCREEN;
		getWindow().setFlags(flag, flag);
		// 加载布局文件
		setContentView(R.layout.navigation);
		// 初始化主页面
		initView();
		// 初始化小圆点
		initDots();
	}

	/**
	 * 主页面
	 */
	@SuppressLint("InflateParams")
	private void initView() {
		viewPager = (ViewPager) findViewById(R.id.vp1);
		// 使用LayoutInflater来载入布局
		LayoutInflater inflater = LayoutInflater.from(NavigationActivity.this);
		// 初始化引导图片列表
		View start_one = inflater.inflate(R.layout.start_one, null);
		View start_two = inflater.inflate(R.layout.start_two, null);
		View start_three = inflater.inflate(R.layout.start_three, null);
		View start_four = inflater.inflate(R.layout.start_four, null);
		// 为导航页的最后一页中的按钮绑定事件
		Button btnStart = (Button) start_four.findViewById(R.id.tiyan);
		btnStart.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// 使用SharedPreferences来记录是否首次启动APP
				SharedPreferences preferences = getSharedPreferences("test", Activity.MODE_PRIVATE);
				Editor editor = preferences.edit();
				// 写入一个布尔值
				editor.putBoolean("test", false);
				// 提交修改
				editor.commit();
				Intent intent = new Intent(NavigationActivity.this, LoginActivity.class);
				startActivity(intent);
				finish();
			}

		});
		list = new ArrayList<View>();
		// 存储到数组中
		list.add(start_one);
		list.add(start_two);
		list.add(start_three);
		list.add(start_four);
		// 初始化适配器
		GuideAdapter adapter = new GuideAdapter(list);
		viewPager.setAdapter(adapter);
		viewPager.setOnPageChangeListener(this);
	}

	/**
	 * 圆点
	 */
	private void initDots() {
		// 装下小圆点的线性布局
		LinearLayout ll = (LinearLayout) findViewById(R.id.ll);
		// 先获取小圆点总数
		int size = list.size();
		// 初始化ImageView的数组大小
		dots = new ImageView[size];
		// 循环取得小点图片
		for (int i = 0; i < size; i++) {
			dots[i] = (ImageView) ll.getChildAt(i);
			dots[i].setEnabled(true);// 都设为灰色
		}
		// 设置当前页的索引
		currentIndex = 0;
		// 设置为白色，即选中状态
		dots[currentIndex].setEnabled(false);
	}

	// 根据position设置小圆点高亮
	private void setCurrentDot(int position) {
		// 判断滚动的位置是否超出数组范围或与当前相同（即页面位置未发生变化）
		if (position < 0 || position > list.size() - 1 || currentIndex == position) {
			return;// 直接结束，不执行方法中的后续的操作
		}
		// 设置选中的新的小圆点高亮
		dots[position].setEnabled(false);
		// 设置之前的小圆点置灰
		dots[currentIndex].setEnabled(true);
		// 记录新的小圆点位置
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
		// 页面改变时，同步切换小圆点的显示状态
		setCurrentDot(arg0);
	}
}
