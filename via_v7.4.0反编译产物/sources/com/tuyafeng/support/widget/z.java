package com.tuyafeng.support.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import z8.r3;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class z extends LinearLayout {

    /* renamed from: m, reason: collision with root package name */
    public static final int f4412m = g6.y.l();

    /* renamed from: n, reason: collision with root package name */
    public static final int f4413n = g6.y.l();

    /* renamed from: o, reason: collision with root package name */
    public static final int f4414o = g6.y.l();

    /* renamed from: e, reason: collision with root package name */
    public Space f4415e;

    /* renamed from: j, reason: collision with root package name */
    public final List f4416j;

    /* renamed from: k, reason: collision with root package name */
    public Paint f4417k;

    /* renamed from: l, reason: collision with root package name */
    public int f4418l;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Activity activityA = g6.f.a(view.getContext());
            if (activityA != null) {
                activityA.onBackPressed();
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f4420a;

        /* renamed from: b, reason: collision with root package name */
        public final int f4421b;

        /* renamed from: c, reason: collision with root package name */
        public final String f4422c;

        /* renamed from: d, reason: collision with root package name */
        public final Drawable f4423d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f4424e;

        /* renamed from: f, reason: collision with root package name */
        public final boolean f4425f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f4426g;

        public b(int i10, int i11, Drawable drawable, String str) {
            this(i10, i11, drawable, str, false, false);
        }

        public b(int i10, int i11, Drawable drawable, String str, boolean z10) {
            this(i10, i11, drawable, str, false, false, z10);
        }

        public b(int i10, int i11, Drawable drawable, String str, boolean z10, boolean z11) {
            this(i10, i11, drawable, str, z10, z11, true);
        }

        public b(int i10, int i11, Drawable drawable, String str, boolean z10, boolean z11, boolean z12) {
            this.f4420a = i10;
            this.f4421b = i11;
            this.f4423d = drawable;
            this.f4422c = str;
            this.f4424e = z11;
            this.f4425f = z10;
            this.f4426g = z12;
        }

        public static b a(Drawable drawable, String str) {
            return new b(g6.y.l(), 0, drawable, str);
        }
    }

    public z(Context context) {
        this(context, null);
    }

    public z(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public z(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f4416j = new ArrayList();
        h();
    }

    private void setNavigationView(View view) {
        d(view);
    }

    public final void a(View view) {
        addView(view, indexOfChild(this.f4415e));
    }

    public void b(View view) {
        a(view);
    }

    public void c(b bVar, View.OnClickListener onClickListener) {
        if (findViewById(bVar.f4420a) != null) {
            throw new IllegalArgumentException("The menu item id must be unique");
        }
        this.f4416j.add(bVar);
        View viewF = f(bVar.f4423d, bVar.f4422c, onClickListener);
        viewF.setId(bVar.f4420a);
        viewF.setVisibility(bVar.f4426g ? 0 : 8);
        e(viewF);
    }

    public final void d(View view) {
        addView(view, 0);
    }

    public final void e(View view) {
        addView(view);
    }

    public final View f(Drawable drawable, String str, View.OnClickListener onClickListener) {
        View view;
        if (drawable != null) {
            ImageView imageView = new ImageView(getContext());
            imageView.setImageDrawable(drawable);
            imageView.setColorFilter(g6.e.a(getContext(), x7.k.f13662h));
            imageView.setContentDescription(str);
            view = imageView;
        } else {
            TextView textView = new TextView(getContext());
            textView.setTextSize(0, g6.f.d(getContext(), x7.n.f13693l));
            textView.setTextColor(g6.e.a(getContext(), x7.k.f13665k));
            textView.setText(str);
            textView.setSingleLine();
            textView.setMaxLines(1);
            textView.setLines(1);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setGravity(17);
            textView.setAllCaps(true);
            x8.g.d(textView);
            view = textView;
        }
        g6.y.T(view, g6.f.d(getContext(), x7.n.f13684c), 0);
        g6.y.O(view, g6.f.e(view.getContext(), x7.o.f13720e));
        view.setOnClickListener(onClickListener);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(drawable == null ? -2 : g6.f.d(getContext(), x7.n.f13685d), -1);
        int iG = (int) g(1.0f);
        layoutParams.leftMargin = iG;
        layoutParams.rightMargin = iG;
        layoutParams.topMargin = iG;
        layoutParams.bottomMargin = iG;
        view.setLayoutParams(layoutParams);
        return view;
    }

    public final float g(float f10) {
        return TypedValue.applyDimension(1, f10, getResources().getDisplayMetrics());
    }

    public String getSearchViewContent() {
        EditText editText = (EditText) findViewById(f4414o);
        if (editText != null) {
            return editText.getText().toString();
        }
        return null;
    }

    public final void h() {
        this.f4417k = new Paint(1);
        setWillNotDraw(false);
        setOrientation(0);
        this.f4415e = new Space(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, g6.f.d(getContext(), x7.n.B));
        layoutParams.weight = 1.0f;
        this.f4415e.setLayoutParams(layoutParams);
        addView(this.f4415e);
        this.f4418l = g6.f.b(getContext(), x7.m.f13673c);
    }

    public void i(int i10, boolean z10) {
        for (b bVar : this.f4416j) {
            if (bVar.f4421b == i10) {
                j(bVar.f4420a, z10);
            }
        }
    }

    public void j(int i10, boolean z10) {
        View viewFindViewById = findViewById(i10);
        if (viewFindViewById != null) {
            if (z10 == (viewFindViewById.getVisibility() == 0)) {
                return;
            }
            viewFindViewById.setVisibility(z10 ? 0 : 8);
            for (b bVar : this.f4416j) {
                if (bVar.f4420a == i10) {
                    bVar.f4426g = z10;
                    return;
                }
            }
        }
    }

    public void k(Drawable drawable, String str) {
        l(drawable, str, new a());
    }

    public void l(Drawable drawable, String str, View.OnClickListener onClickListener) {
        int i10 = f4413n;
        View viewFindViewById = findViewById(i10);
        if (viewFindViewById == null) {
            View viewF = f(drawable, str, onClickListener);
            viewF.setId(i10);
            setNavigationView(viewF);
        } else {
            if (viewFindViewById instanceof ImageView) {
                ((ImageView) viewFindViewById).setImageDrawable(drawable);
                viewFindViewById.setContentDescription(str);
            } else if (viewFindViewById instanceof TextView) {
                ((TextView) viewFindViewById).setText(str);
            }
            viewFindViewById.setOnClickListener(onClickListener);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f4417k.setColor(this.f4418l);
        this.f4417k.setStyle(Paint.Style.FILL);
        canvas.drawRect(0.0f, getMeasuredHeight() - 2, getMeasuredWidth(), getMeasuredHeight(), this.f4417k);
    }

    public void setContentColor(int i10) {
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt != null) {
                if (childAt instanceof TextView) {
                    ((TextView) childAt).setTextColor(i10);
                } else if (childAt instanceof ImageView) {
                    ((ImageView) childAt).setColorFilter(i10);
                }
            }
        }
    }

    public void setDividerColor(int i10) {
        if (i10 == this.f4418l) {
            return;
        }
        this.f4418l = i10;
        invalidate();
    }

    public void setSearchViewVisible(boolean z10) {
        View viewFindViewById = findViewById(f4414o);
        if (viewFindViewById != null) {
            if ((viewFindViewById.getVisibility() == 0) == z10) {
                return;
            }
            viewFindViewById.setVisibility(z10 ? 0 : 8);
        }
    }

    public void setTitle(CharSequence charSequence) {
        int i10 = f4412m;
        TextView textView = (TextView) findViewById(i10);
        if (textView == null) {
            textView = new TextView(getContext());
            textView.setTextSize(0, g6.f.d(getContext(), x7.n.f13691j));
            textView.setTextColor(g6.e.a(getContext(), x7.k.f13665k));
            textView.setSingleLine();
            textView.setMaxLines(1);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setGravity(16);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.gravity = 16;
            layoutParams.weight = 24.0f;
            textView.setLayoutParams(layoutParams);
            textView.setId(i10);
            r3.n(textView);
            x8.g.d(textView);
            textView.setTypeface(textView.getTypeface(), 1);
            a(textView);
        }
        if (charSequence == null) {
            textView.setVisibility(8);
        } else {
            textView.setText(charSequence);
            textView.setVisibility(0);
        }
    }
}
