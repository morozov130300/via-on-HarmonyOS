package com.tuyafeng.support.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class c extends LinearLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3687c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f3688e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f3689m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f3690n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f3691o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int[] f3692p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int[] f3693q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Drawable f3694r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f3695s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f3696t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f3697u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public b f3698v;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f3699a;

        public a(int i10) {
            this.f3699a = i10;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.setHighlighted(this.f3699a);
            if (c.this.f3698v != null) {
                c.this.f3698v.a(this.f3699a);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface b {
        void a(int i10);
    }

    public c(Context context) {
        this(context, null);
    }

    public final void b(Context context, AttributeSet attributeSet, int i10, int i11) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, w7.w.f14332b);
        this.f3688e = typedArrayObtainStyledAttributes.getColor(w7.w.f14335e, 0);
        this.f3697u = typedArrayObtainStyledAttributes.getDimensionPixelSize(w7.w.f14341k, 14);
        this.f3689m = typedArrayObtainStyledAttributes.getColor(w7.w.f14340j, -16777216);
        this.f3690n = typedArrayObtainStyledAttributes.getColor(w7.w.f14337g, -16776961);
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        this.f3691o = typedArrayObtainStyledAttributes.getDimensionPixelSize(w7.w.f14339i, (int) TypedValue.applyDimension(1, 6.0f, displayMetrics));
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(w7.w.f14336f, (int) TypedValue.applyDimension(1, 48.0f, displayMetrics));
        this.f3695s = dimensionPixelSize;
        this.f3696t = typedArrayObtainStyledAttributes.getDimensionPixelSize(w7.w.f14334d, dimensionPixelSize);
        Arrays.fill(this.f3692p, typedArrayObtainStyledAttributes.getDimensionPixelSize(w7.w.f14339i, (int) TypedValue.applyDimension(1, 12.0f, displayMetrics)));
        Arrays.fill(this.f3693q, typedArrayObtainStyledAttributes.getDimensionPixelSize(w7.w.f14338h, (int) TypedValue.applyDimension(1, 4.0f, displayMetrics)));
        this.f3694r = typedArrayObtainStyledAttributes.getDrawable(w7.w.f14333c);
        typedArrayObtainStyledAttributes.recycle();
    }

    public void c(int i10, int[] iArr, int i11) {
        d(getContext().getResources().getStringArray(i10), iArr, i11);
    }

    public void d(String[] strArr, int[] iArr, int i10) {
        int length = iArr.length;
        Drawable[] drawableArr = new Drawable[length];
        for (int i11 = 0; i11 < length; i11++) {
            drawableArr[i11] = com.tuyafeng.support.utils.f.e(getContext(), iArr[i11]);
        }
        e(strArr, drawableArr, i10);
    }

    public void e(String[] strArr, Drawable[] drawableArr, int i10) {
        removeAllViews();
        this.f3687c = i10;
        int length = strArr.length;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        int[] iArr = this.f3693q;
        layoutParams.leftMargin = iArr[0];
        layoutParams.topMargin = iArr[1];
        layoutParams.rightMargin = iArr[2];
        layoutParams.bottomMargin = iArr[3];
        layoutParams.weight = 1.0f;
        if (this.f3695s == 0) {
            this.f3695s = this.f3696t;
        }
        if (this.f3696t == 0) {
            this.f3696t = this.f3695s;
        }
        int i11 = 0;
        while (i11 < length) {
            Drawable drawable = drawableArr[i11];
            drawable.setBounds(0, 0, this.f3695s, this.f3696t);
            TextView textView = new TextView(getContext());
            textView.setText(strArr[i11]);
            textView.setCompoundDrawables(null, drawable, null, null);
            textView.setGravity(17);
            textView.setTextSize(0, this.f3697u);
            int[] iArr2 = this.f3692p;
            textView.setPadding(iArr2[0], iArr2[1], iArr2[2], iArr2[3]);
            textView.setCompoundDrawablePadding(this.f3691o);
            textView.setLayoutParams(layoutParams);
            textView.setMaxLines(1);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setBackground(this.f3694r.mutate().getConstantState().newDrawable());
            textView.setClickable(true);
            textView.setFocusable(true);
            textView.setOnClickListener(new a(i11));
            f(textView, i11 == i10);
            addView(textView);
            i11++;
        }
    }

    public final void f(TextView textView, boolean z10) {
        if (textView == null) {
            return;
        }
        textView.setTextColor(z10 ? this.f3690n : this.f3689m);
        textView.setTypeface(Typeface.defaultFromStyle(z10 ? 1 : 0));
        Drawable drawable = textView.getCompoundDrawables()[1];
        if (drawable != null) {
            int i10 = this.f3688e;
            if (i10 == 0) {
                drawable.setColorFilter(null);
                return;
            }
            if (z10) {
                i10 = this.f3690n;
            }
            drawable.setColorFilter(i10, PorterDuff.Mode.SRC_ATOP);
        }
    }

    public int getHighlighted() {
        return this.f3687c;
    }

    public void setHighlightChangedListener(b bVar) {
        this.f3698v = bVar;
    }

    public void setHighlighted(int i10) {
        int i11 = this.f3687c;
        if (i10 == i11) {
            return;
        }
        f((TextView) getChildAt(i11), false);
        f((TextView) getChildAt(i10), true);
        this.f3687c = i10;
    }

    public void setItemBackground(Drawable drawable) {
        this.f3694r = drawable;
    }

    public void setItemBackgroundResource(int i10) {
        if (i10 == 0) {
            return;
        }
        this.f3694r = com.tuyafeng.support.utils.f.e(getContext(), i10);
    }

    public void setItemDrawablePadding(int i10) {
        this.f3691o = i10;
    }

    public void setItemDrawableTint(int i10) {
        this.f3688e = i10;
    }

    public void setItemDrawableWidth(int i10) {
        this.f3695s = i10;
    }

    public void setItemDrawaleHeight(int i10) {
        this.f3696t = i10;
    }

    public void setItemHighlightColor(int i10) {
        this.f3690n = i10;
    }

    public void setItemTextColor(int i10) {
        this.f3689m = i10;
    }

    public void setItemTextSize(int i10) {
        this.f3697u = i10;
    }

    public c(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public c(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f3687c = -1;
        this.f3692p = new int[4];
        this.f3693q = new int[4];
        b(context, attributeSet, i10, 0);
    }
}
