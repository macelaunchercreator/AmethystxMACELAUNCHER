package com.kdt.mcgui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;


import net.kdt.pojavlaunch.R;

import fr.spse.extended_view.ExtendedButton;

public class LauncherMenuButton extends ExtendedButton {

    public LauncherMenuButton(@NonNull Context context) {
        super(context);
        setSettings();
    }
    public LauncherMenuButton(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setSettings();
    }


    /** Set style stuff */
    private void setSettings(){
        Resources resources = getContext().getResources();

        // Amethyst look: tighter padding, smaller icon, light text on dark cards
        int padding = resources.getDimensionPixelSize(R.dimen._16sdp);
        setCompoundDrawablePadding(resources.getDimensionPixelSize(R.dimen._12sdp));
        setPaddingRelative(padding, 0, padding, 0);
        setGravity(Gravity.CENTER_VERTICAL);

        setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimensionPixelSize(R.dimen._12ssp));
        setTextColor(0xFFEDE7FF);
        setAllCaps(false);

        // Keep labels on one line so side-by-side cards stay tidy on narrow screens
        setSingleLine(true);
        setEllipsize(TextUtils.TruncateAt.END);

        // Set drawable size
        int[] sizes = getExtendedViewData().getSizeCompounds();
        sizes[0] = resources.getDimensionPixelSize(R.dimen._24sdp);
        getExtendedViewData().setSizeCompounds(sizes);
        postProcessDrawables();
    }
}
