package com.tuyafeng.support.utils;

import android.R;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3572a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float[] f3573b = new float[8];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3574c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3575d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f3576e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f3577f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f3578g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int[] f3579h = new int[2];

    public Drawable a() {
        int i10 = this.f3575d;
        if (i10 == 0 && this.f3576e == 0) {
            return b(this.f3572a, this.f3574c, this.f3573b, this.f3579h, this.f3577f, this.f3578g);
        }
        if (Build.VERSION.SDK_INT >= 21 && i10 != 0) {
            GradientDrawable gradientDrawableB = b(this.f3572a, -16777216, this.f3573b, this.f3579h, this.f3577f, this.f3578g);
            return new RippleDrawable(ColorStateList.valueOf(this.f3575d), b(this.f3572a, this.f3574c, this.f3573b, this.f3579h, this.f3577f, this.f3578g), gradientDrawableB);
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        int i11 = this.f3575d;
        if (i11 != 0) {
            stateListDrawable.addState(new int[]{R.attr.state_enabled, R.attr.state_pressed}, b(this.f3572a, i11, this.f3573b, this.f3579h, this.f3577f, this.f3578g));
        }
        int i12 = this.f3576e;
        if (i12 != 0) {
            stateListDrawable.addState(new int[]{R.attr.state_enabled, R.attr.state_focused}, b(this.f3572a, i12, this.f3573b, this.f3579h, this.f3577f, this.f3578g));
        }
        stateListDrawable.addState(new int[]{R.attr.state_enabled}, b(this.f3572a, this.f3574c, this.f3573b, this.f3579h, this.f3577f, this.f3578g));
        return stateListDrawable;
    }

    public final GradientDrawable b(int i10, int i11, float[] fArr, int[] iArr, int i12, int i13) {
        int i14;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(i10);
        gradientDrawable.setColor(i11);
        if (fArr != null) {
            gradientDrawable.setCornerRadii(fArr);
        }
        if (iArr != null && ((i14 = iArr[0]) != 0 || iArr[1] != 0)) {
            gradientDrawable.setSize(i14, iArr[1]);
        }
        if (i13 > 0) {
            gradientDrawable.setStroke(i13, i12);
        }
        return gradientDrawable;
    }

    public g c(float f10) {
        return e(f10, f10, f10, f10);
    }

    public g d(float f10, float f11) {
        return e(f10, f10, f11, f11);
    }

    public g e(float f10, float f11, float f12, float f13) {
        float[] fArr = this.f3573b;
        fArr[0] = f10;
        fArr[1] = f10;
        fArr[2] = f11;
        fArr[3] = f11;
        fArr[4] = f12;
        fArr[5] = f12;
        fArr[6] = f13;
        fArr[7] = f13;
        return this;
    }

    public g f(int i10) {
        this.f3572a = i10;
        return this;
    }

    public g g(int i10, int i11) {
        int[] iArr = this.f3579h;
        iArr[0] = i10;
        iArr[1] = i11;
        return this;
    }

    public g h(int i10) {
        this.f3574c = i10;
        return this;
    }

    public g i(int i10) {
        this.f3576e = i10;
        return this;
    }

    public g j(int i10) {
        this.f3575d = i10;
        return this;
    }

    public g k(int i10) {
        this.f3577f = i10;
        return this;
    }

    public g l(int i10) {
        this.f3578g = i10;
        return this;
    }
}
