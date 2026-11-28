package com.tuyafeng.support.utils;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.TypedValue;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class e {
    public static int a(Context context, int i10) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i10, typedValue, true)) {
            return typedValue.data;
        }
        return 0;
    }

    public static int b(Context context, int i10) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i10, typedValue, true)) {
            return typedValue.resourceId;
        }
        return -1;
    }

    public static String c(Context context, int i10, int i11) {
        String[] stringArray;
        try {
            stringArray = context.getResources().getStringArray(i10);
        } catch (Exception e10) {
            e10.printStackTrace();
            stringArray = null;
        }
        return d(stringArray, i11);
    }

    public static String d(String[] strArr, int i10) {
        return (strArr == null || i10 < 0 || i10 >= strArr.length) ? "" : strArr[i10];
    }

    public static boolean e(String[] strArr, int i10) {
        if (strArr == null || strArr.length < i10) {
            return true;
        }
        for (int i11 = 0; i11 < i10; i11++) {
            if (TextUtils.isEmpty(strArr[i11])) {
                return true;
            }
        }
        return false;
    }

    public static Drawable f(Drawable drawable, int i10) {
        if (drawable != null) {
            drawable.setColorFilter(i10, PorterDuff.Mode.SRC_IN);
        }
        return drawable;
    }
}
