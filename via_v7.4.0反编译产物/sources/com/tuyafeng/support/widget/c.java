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

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class c extends LinearLayout {

    /* renamed from: e, reason: collision with root package name */
    public int f4325e;

    /* renamed from: j, reason: collision with root package name */
    public int f4326j;

    /* renamed from: k, reason: collision with root package name */
    public int f4327k;

    /* renamed from: l, reason: collision with root package name */
    public int f4328l;

    /* renamed from: m, reason: collision with root package name */
    public int f4329m;

    /* renamed from: n, reason: collision with root package name */
    public final int[] f4330n;

    /* renamed from: o, reason: collision with root package name */
    public final int[] f4331o;

    /* renamed from: p, reason: collision with root package name */
    public Drawable f4332p;

    /* renamed from: q, reason: collision with root package name */
    public int f4333q;

    /* renamed from: r, reason: collision with root package name */
    public int f4334r;

    /* renamed from: s, reason: collision with root package name */
    public int f4335s;

    /* renamed from: t, reason: collision with root package name */
    public b f4336t;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f4337a;

        public a(int i10) {
            this.f4337a = i10;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.setHighlighted(this.f4337a);
            if (c.this.f4336t != null) {
                c.this.f4336t.a(this.f4337a);
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface b {
        void a(int i10);
    }

    public c(Context context) {
        this(context, null);
    }

    public c(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public c(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f4325e = -1;
        this.f4330n = new int[4];
        this.f4331o = new int[4];
        b(context, attributeSet, i10, 0);
    }

    public final void b(Context context, AttributeSet attributeSet, int i10, int i11) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, x7.w.f14263b);
        this.f4326j = typedArrayObtainStyledAttributes.getColor(x7.w.f14266e, 0);
        this.f4335s = typedArrayObtainStyledAttributes.getDimensionPixelSize(x7.w.f14272k, 14);
        this.f4327k = typedArrayObtainStyledAttributes.getColor(x7.w.f14271j, -16777216);
        this.f4328l = typedArrayObtainStyledAttributes.getColor(x7.w.f14268g, -16776961);
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        this.f4329m = typedArrayObtainStyledAttributes.getDimensionPixelSize(x7.w.f14270i, (int) TypedValue.applyDimension(1, 6.0f, displayMetrics));
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(x7.w.f14267f, (int) TypedValue.applyDimension(1, 48.0f, displayMetrics));
        this.f4333q = dimensionPixelSize;
        this.f4334r = typedArrayObtainStyledAttributes.getDimensionPixelSize(x7.w.f14265d, dimensionPixelSize);
        Arrays.fill(this.f4330n, typedArrayObtainStyledAttributes.getDimensionPixelSize(x7.w.f14270i, (int) TypedValue.applyDimension(1, 12.0f, displayMetrics)));
        Arrays.fill(this.f4331o, typedArrayObtainStyledAttributes.getDimensionPixelSize(x7.w.f14269h, (int) TypedValue.applyDimension(1, 4.0f, displayMetrics)));
        this.f4332p = typedArrayObtainStyledAttributes.getDrawable(x7.w.f14264c);
        typedArrayObtainStyledAttributes.recycle();
    }

    public void c(int i10, int[] iArr, int i11) {
        d(getContext().getResources().getStringArray(i10), iArr, i11);
    }

    public void d(String[] strArr, int[] iArr, int i10) {
        int length = iArr.length;
        Drawable[] drawableArr = new Drawable[length];
        for (int i11 = 0; i11 < length; i11++) {
            drawableArr[i11] = g6.f.e(getContext(), iArr[i11]);
        }
        e(strArr, drawableArr, i10);
    }

    public void e(String[] strArr, Drawable[] drawableArr, int i10) {
        removeAllViews();
        this.f4325e = i10;
        int length = strArr.length;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        int[] iArr = this.f4331o;
        layoutParams.leftMargin = iArr[0];
        layoutParams.topMargin = iArr[1];
        layoutParams.rightMargin = iArr[2];
        layoutParams.bottomMargin = iArr[3];
        layoutParams.weight = 1.0f;
        if (this.f4333q == 0) {
            this.f4333q = this.f4334r;
        }
        if (this.f4334r == 0) {
            this.f4334r = this.f4333q;
        }
        int i11 = 0;
        while (i11 < length) {
            Drawable drawable = drawableArr[i11];
            drawable.setBounds(0, 0, this.f4333q, this.f4334r);
            TextView textView = new TextView(getContext());
            textView.setText(strArr[i11]);
            textView.setCompoundDrawables(null, drawable, null, null);
            textView.setGravity(17);
            textView.setTextSize(0, this.f4335s);
            int[] iArr2 = this.f4330n;
            textView.setPadding(iArr2[0], iArr2[1], iArr2[2], iArr2[3]);
            textView.setCompoundDrawablePadding(this.f4329m);
            textView.setLayoutParams(layoutParams);
            textView.setMaxLines(1);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setBackground(this.f4332p.mutate().getConstantState().newDrawable());
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
        textView.setTextColor(z10 ? this.f4328l : this.f4327k);
        textView.setTypeface(Typeface.defaultFromStyle(z10 ? 1 : 0));
        Drawable drawable = textView.getCompoundDrawables()[1];
        if (drawable != null) {
            int i10 = this.f4326j;
            if (i10 == 0) {
                drawable.setColorFilter(null);
                return;
            }
            if (z10) {
                i10 = this.f4328l;
            }
            drawable.setColorFilter(i10, PorterDuff.Mode.SRC_ATOP);
        }
    }

    public int getHighlighted() {
        return this.f4325e;
    }

    public void setHighlightChangedListener(b bVar) {
        this.f4336t = bVar;
    }

    public void setHighlighted(int i10) {
        int i11 = this.f4325e;
        if (i10 == i11) {
            return;
        }
        f((TextView) getChildAt(i11), false);
        f((TextView) getChildAt(i10), true);
        this.f4325e = i10;
    }

    public void setItemBackground(Drawable drawable) {
        this.f4332p = drawable;
    }

    public void setItemBackgroundResource(int i10) {
        if (i10 == 0) {
            return;
        }
        this.f4332p = g6.f.e(getContext(), i10);
    }

    public void setItemDrawablePadding(int i10) {
        this.f4329m = i10;
    }

    public void setItemDrawableTint(int i10) {
        this.f4326j = i10;
    }

    public void setItemDrawableWidth(int i10) {
        this.f4333q = i10;
    }

    public void setItemDrawaleHeight(int i10) {
        this.f4334r = i10;
    }

    public void setItemHighlightColor(int i10) {
        this.f4328l = i10;
    }

    public void setItemTextColor(int i10) {
        this.f4327k = i10;
    }

    public void setItemTextSize(int i10) {
        this.f4335s = i10;
    }
}
