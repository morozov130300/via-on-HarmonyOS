package com.tuyafeng.support.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class d extends TextView {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f3707c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f3708e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f3709m;

    public d(Context context) {
        this(context, null);
    }

    public final int a(Drawable drawable) {
        if (drawable == null) {
            return 0;
        }
        float f10 = this.f3708e;
        if (f10 > 0.0f) {
            return (int) f10;
        }
        if (this.f3707c > 0.0f) {
            return drawable.getIntrinsicWidth() <= 0 ? (int) this.f3707c : (int) (drawable.getIntrinsicHeight() * (this.f3707c / drawable.getIntrinsicWidth()));
        }
        return drawable.getIntrinsicHeight();
    }

    public final int b(Drawable drawable) {
        if (drawable == null) {
            return 0;
        }
        float f10 = this.f3707c;
        if (f10 > 0.0f) {
            return (int) f10;
        }
        if (this.f3708e > 0.0f) {
            return drawable.getIntrinsicHeight() <= 0 ? (int) this.f3708e : (int) (drawable.getIntrinsicWidth() * (this.f3708e / drawable.getIntrinsicHeight()));
        }
        return drawable.getIntrinsicWidth();
    }

    public final void c(Drawable drawable, int i10, int i11, int i12) {
        if (drawable == null) {
            return;
        }
        if (i10 != 0) {
            com.tuyafeng.support.utils.h.a(drawable, i10);
        }
        drawable.setBounds(0, 0, i11, i12);
    }

    public void d(float f10, float f11) {
        this.f3708e = f11;
        this.f3707c = f10;
        e();
    }

    public final void e() {
        if (this.f3707c > 0.0f || this.f3708e > 0.0f) {
            Drawable[] compoundDrawables = getCompoundDrawables();
            setCompoundDrawablesWithIntrinsicBounds(compoundDrawables[0], compoundDrawables[1], compoundDrawables[2], compoundDrawables[3]);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        c(drawable, this.f3709m, b(drawable), a(drawable));
        c(drawable3, this.f3709m, b(drawable3), a(drawable3));
        c(drawable2, this.f3709m, b(drawable2), a(drawable2));
        c(drawable4, this.f3709m, b(drawable4), a(drawable4));
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        c(drawable, this.f3709m, b(drawable), a(drawable));
        c(drawable3, this.f3709m, b(drawable3), a(drawable3));
        c(drawable2, this.f3709m, b(drawable2), a(drawable2));
        c(drawable4, this.f3709m, b(drawable4), a(drawable4));
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
    }

    public void setDrawableTint(int i10) {
        if (this.f3709m == i10) {
            return;
        }
        this.f3709m = i10;
        e();
    }

    public d(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public d(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, w7.w.f14342l);
        this.f3707c = typedArrayObtainStyledAttributes.getDimension(w7.w.f14345o, 0.0f);
        this.f3708e = typedArrayObtainStyledAttributes.getDimension(w7.w.f14343m, 0.0f);
        this.f3709m = typedArrayObtainStyledAttributes.getColor(w7.w.f14344n, 0);
        typedArrayObtainStyledAttributes.recycle();
        e();
    }
}
