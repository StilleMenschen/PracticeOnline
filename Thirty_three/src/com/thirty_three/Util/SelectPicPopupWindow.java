package com.thirty_three.Util;

import com.thirty_three.main.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.PopupWindow;

/**
 * �Զ���˵�
 */
public class SelectPicPopupWindow extends PopupWindow {

	public static Activity at;
	private Button help, exit, cancle, about;
	private View mMenuView;

	public SelectPicPopupWindow() {
	}

	@SuppressLint("InflateParams")
	public SelectPicPopupWindow(Activity context, OnClickListener itemsOnClick) {
		super(context);
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mMenuView = inflater.inflate(R.layout.menu, null);
		findViewId();
		listener(itemsOnClick);

		// ����SelectPicPopupWindow��View
		setContentView(mMenuView);
		// ���õ�������Ŀ�
		setWidth(LayoutParams.MATCH_PARENT);
		// ���õ�������ĸ�
		setHeight(LayoutParams.WRAP_CONTENT);
		// ���õ�������ɵ��
		setFocusable(true);
		// ���õ������嶯��Ч��
		setAnimationStyle(R.style.AnimBottom);
		// ��ɫΪ��͸��
		ColorDrawable dw = new ColorDrawable(0x00000000);
		// ����SelectPicPopupWindow��������ı���
		setBackgroundDrawable(dw);
		// ��������
		mMenuView.setOnTouchListener(new OnTouchListener() {

			public boolean onTouch(View v, MotionEvent event) {
				int height = mMenuView.findViewById(R.id.pop_layout).getTop();
				int action = event.getAction();
				int y = (int) event.getY();
				if (action == MotionEvent.ACTION_UP) {
					if (y < height) {
						dismiss();
					}
				}
				v.performClick();
				return true;
			}
		});

	}

	private void findViewId() {
		help = (Button) mMenuView.findViewById(R.id.help);
		exit = (Button) mMenuView.findViewById(R.id.exit);
		cancle = (Button) mMenuView.findViewById(R.id.cancel);
		about = (Button) mMenuView.findViewById(R.id.about);
	}

	private void listener(OnClickListener onClickListener) {
		help.setOnClickListener(onClickListener);
		exit.setOnClickListener(onClickListener);
		cancle.setOnClickListener(onClickListener);
		about.setOnClickListener(onClickListener);
	}

}
