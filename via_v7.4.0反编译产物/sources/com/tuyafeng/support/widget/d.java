package com.tuyafeng.support.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class d extends TextView {

    /* renamed from: e, reason: collision with root package name */
    public float f4339e;

    /* renamed from: j, reason: collision with root package name */
    public float f4340j;

    /* renamed from: k, reason: collision with root package name */
    public int f4341k;

    public d(Context context) {
        this(context, null);
    }

    public d(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public d(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, x7.w.f14273l);
        this.f4339e = typedArrayObtainStyledAttributes.getDimension(x7.w.f14276o, 0.0f);
        this.f4340j = typedArrayObtainStyledAttributes.getDimension(x7.w.f14274m, 0.0f);
        this.f4341k = typedArrayObtainStyledAttributes.getColor(x7.w.f14275n, 0);
        typedArrayObtainStyledAttributes.recycle();
        e();
    }

    public final int a(Drawable drawable) {
        if (drawable == null) {
            return 0;
        }
        float f10 = this.f4340j;
        return f10 > 0.0f ? (int) f10 : this.f4339e > 0.0f ? drawable.getIntrinsicWidth() <= 0 ? (int) this.f4339e : (int) (drawable.getIntrinsicHeight() * (this.f4339e / drawable.getIntrinsicWidth())) : drawable.getIntrinsicHeight();
    }

    public final int b(Drawable drawable) {
        if (drawable == null) {
            return 0;
        }
        float f10 = this.f4339e;
        return f10 > 0.0f ? (int) f10 : this.f4340j > 0.0f ? drawable.getIntrinsicHeight() <= 0 ? (int) this.f4340j : (int) (drawable.getIntrinsicWidth() * (this.f4340j / drawable.getIntrinsicHeight())) : drawable.getIntrinsicWidth();
    }

    public final void c(Drawable drawable, int i10, int i11, int i12) {
        if (drawable == null) {
            return;
        }
        if (i10 != 0) {
            g6.h.a(drawable, i10);
        }
        drawable.setBounds(0, 0, i11, i12);
    }

    public void d(float f10, float f11) {
        this.f4340j = f11;
        this.f4339e = f10;
        e();
    }

    public final void e() {
        if (this.f4339e > 0.0f || this.f4340j > 0.0f) {
            Drawable[] compoundDrawables = getCompoundDrawables();
            setCompoundDrawablesWithIntrinsicBounds(compoundDrawables[0], compoundDrawables[1], compoundDrawables[2], compoundDrawables[3]);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        c(drawable, this.f4341k, b(drawable), a(drawable));
        c(drawable3, this.f4341k, b(drawable3), a(drawable3));
        c(drawable2, this.f4341k, b(drawable2), a(drawable2));
        c(drawable4, this.f4341k, b(drawable4), a(drawable4));
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        c(drawable, this.f4341k, b(drawable), a(drawable));
        c(drawable3, this.f4341k, b(drawable3), a(drawable3));
        c(drawable2, this.f4341k, b(drawable2), a(drawable2));
        c(drawable4, this.f4341k, b(drawable4), a(drawable4));
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
    }

    public void setDrawableTint(int i10) {
        if (this.f4341k == i10) {
            return;
        }
        this.f4341k = i10;
        e();
    }
}
