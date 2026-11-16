package com.kdt.mcgui;

import android.content.*;
import android.graphics.*;
import android.util.*;

import androidx.core.content.res.ResourcesCompat;

import net.kdt.pojavlaunch.R;

public class MineButton extends androidx.appcompat.widget.AppCompatButton {

	private static final String ANDROID_NS = "http://schemas.android.com/apk/res/android";

	// If a layout sets its own background / text color (like the green Play button), keep it
	private boolean mHasCustomBackground = false;
	private boolean mHasCustomTextColor = false;

	public MineButton(Context ctx) {
		this(ctx, null);
	}

	public MineButton(Context ctx, AttributeSet attrs) {
		super(ctx, attrs);
		if (attrs != null) {
			mHasCustomBackground = attrs.getAttributeValue(ANDROID_NS, "background") != null;
			mHasCustomTextColor = attrs.getAttributeValue(ANDROID_NS, "textColor") != null;
		}
		init();
	}

	public void init() {
		setTypeface(ResourcesCompat.getFont(getContext(), R.font.noto_sans_bold));
		if (!mHasCustomBackground) {
			// Default Amethyst look: rounded purple button
			setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.amethyst_bg_button, null));
		}
		if (!mHasCustomTextColor) {
			setTextColor(Color.WHITE);
		}
		setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimensionPixelSize(R.dimen._13ssp));
	}

}
