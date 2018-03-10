package com.apphou;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

public class MainActivity extends Activity {
	private TextView exitLogIn;
	View user_activity;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		user_activity = LayoutInflater.from(this).inflate(R.layout.setting,
				null);
		setContentView(user_activity);
		exitLogIn = (TextView) findViewById(R.id.exitLogIn);
		exitLogIn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				shouPop();
			}
		});
	}

	/**
	 * ��ʾ�����POP �Ƴ�
	 */
	PopupWindow mPopupWindow;

	public void shouPop() {
		// Animation mScaleAnimation = new ScaleAnimation(1.0f, 0.9f, 1.0f,
		// 0.9f,
		// // �����Ļ��0.0��1.0�Ĵ�С//����
		// Animation.ZORDER_BOTTOM, 1.0f, Animation.RESTART, 1.0f);
		// mScaleAnimation.setDuration(1000);
		// mScaleAnimation.setFillAfter(true);
		// user_activity.startAnimation(mScaleAnimation);
		final Animation mScaleAnimation = AnimationUtils.loadAnimation(this,
				R.anim.ddddddddddd);
		mScaleAnimation.setDuration(800);
		mScaleAnimation.setFillAfter(true);
		user_activity.startAnimation(mScaleAnimation);
		LayoutInflater inflater = (LayoutInflater) this
				.getSystemService(LAYOUT_INFLATER_SERVICE);
		View layout = inflater.inflate(R.layout.istuichu, null);
		layout.getBackground().setAlpha(220);
		Button queding = (Button) layout.findViewById(R.id.queding);
		Button quxiao = (Button) layout.findViewById(R.id.quxiao);
		queding.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mPopupWindow.dismiss();
			}
		});
		quxiao.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mPopupWindow.dismiss();
				user_activity.clearAnimation();
			}
		});
		mPopupWindow = showPop(LayoutParams.FILL_PARENT, 0, false,
				Gravity.BOTTOM, layout, layout);
	}

	public PopupWindow showPop(int witch, int hight_bottom, boolean isDown,
			int gravity, View... view) {
		PopupWindow mPopupWindow = new PopupWindow(view[0], witch,
				LayoutParams.FILL_PARENT);
		mPopupWindow.setOutsideTouchable(true);
		mPopupWindow.setFocusable(true);
		mPopupWindow.setTouchable(true);
		mPopupWindow.setBackgroundDrawable(new BitmapDrawable());// ����հ�ʱpopupwindow�ر�
		int[] location = new int[2];
		try {
			view[1].getLocationOnScreen(location);
//			mPopupWindow.setAnimationStyle(R.style.PopupAnimation);
			mPopupWindow.showAtLocation(view[1], gravity, 10, hight_bottom);
			mPopupWindow.update();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mPopupWindow;
	}
}
