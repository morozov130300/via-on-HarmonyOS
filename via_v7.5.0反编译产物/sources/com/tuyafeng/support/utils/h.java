package com.tuyafeng.support.utils;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class h {
    public static void a(Drawable drawable, int i10) {
        b(drawable, i10, PorterDuff.Mode.SRC_IN);
    }

    public static void b(Drawable drawable, int i10, PorterDuff.Mode mode) {
        if (drawable == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            drawable.setColorFilter(new PorterDuffColorFilter(i10, mode));
        } else {
            drawable.setColorFilter(i10, mode);
        }
    }
}
