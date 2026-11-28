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
import x8.r3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class e0 extends LinearLayout {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f3730o = com.tuyafeng.support.utils.x.l();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f3731p = com.tuyafeng.support.utils.x.l();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f3732q = com.tuyafeng.support.utils.x.l();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Space f3733c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List f3734e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Paint f3735m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f3736n;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Activity activityA = com.tuyafeng.support.utils.f.a(view.getContext());
            if (activityA != null) {
                activityA.onBackPressed();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f3738a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f3739b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f3740c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Drawable f3741d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f3742e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f3743f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f3744g;

        public b(int i10, int i11, Drawable drawable, String str) {
            this(i10, i11, drawable, str, false, false);
        }

        public static b a(Drawable drawable, String str) {
            return new b(com.tuyafeng.support.utils.x.l(), 0, drawable, str);
        }

        public b(int i10, int i11, Drawable drawable, String str, boolean z10) {
            this(i10, i11, drawable, str, false, false, z10);
        }

        public b(int i10, int i11, Drawable drawable, String str, boolean z10, boolean z11) {
            this(i10, i11, drawable, str, z10, z11, true);
        }

        public b(int i10, int i11, Drawable drawable, String str, boolean z10, boolean z11, boolean z12) {
            this.f3738a = i10;
            this.f3739b = i11;
            this.f3741d = drawable;
            this.f3740c = str;
            this.f3742e = z11;
            this.f3743f = z10;
            this.f3744g = z12;
        }
    }

    public e0(Context context) {
        this(context, null);
    }

    private void setNavigationView(View view) {
        d(view);
    }

    public final void a(View view) {
        addView(view, indexOfChild(this.f3733c));
    }

    public void b(View view) {
        a(view);
    }

    public void c(b bVar, View.OnClickListener onClickListener) {
        if (findViewById(bVar.f3738a) != null) {
            throw new IllegalArgumentException("The menu item id must be unique");
        }
        this.f3734e.add(bVar);
        View viewF = f(bVar.f3741d, bVar.f3740c, onClickListener);
        viewF.setId(bVar.f3738a);
        viewF.setVisibility(bVar.f3744g ? 0 : 8);
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
            imageView.setColorFilter(com.tuyafeng.support.utils.e.a(getContext(), w7.k.f13729i));
            imageView.setContentDescription(str);
            view = imageView;
        } else {
            TextView textView = new TextView(getContext());
            textView.setTextSize(0, com.tuyafeng.support.utils.f.d(getContext(), w7.n.f13759l));
            textView.setTextColor(com.tuyafeng.support.utils.e.a(getContext(), w7.k.f13732l));
            textView.setText(str);
            textView.setSingleLine();
            textView.setMaxLines(1);
            textView.setLines(1);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setGravity(17);
            textView.setAllCaps(true);
            v8.g.d(textView);
            view = textView;
        }
        com.tuyafeng.support.utils.x.U(view, com.tuyafeng.support.utils.f.d(getContext(), w7.n.f13750c), 0);
        com.tuyafeng.support.utils.x.P(view, com.tuyafeng.support.utils.f.e(view.getContext(), w7.o.f13783d));
        view.setOnClickListener(onClickListener);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(drawable == null ? -2 : com.tuyafeng.support.utils.f.d(getContext(), w7.n.f13751d), -1);
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
        EditText editText = (EditText) findViewById(f3732q);
        if (editText != null) {
            return editText.getText().toString();
        }
        return null;
    }

    public final void h() {
        this.f3735m = new Paint(1);
        setWillNotDraw(false);
        setOrientation(0);
        this.f3733c = new Space(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, com.tuyafeng.support.utils.f.d(getContext(), w7.n.D));
        layoutParams.weight = 1.0f;
        this.f3733c.setLayoutParams(layoutParams);
        addView(this.f3733c);
        this.f3736n = com.tuyafeng.support.utils.f.b(getContext(), w7.m.f13739c);
    }

    public void i() {
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            if (childAt instanceof ImageView) {
                r3.n((ImageView) childAt);
            } else if (childAt instanceof TextView) {
                v8.g.l((TextView) childAt);
            }
        }
    }

    public void j(int i10, boolean z10) {
        for (b bVar : this.f3734e) {
            if (bVar.f3739b == i10) {
                k(bVar.f3738a, z10);
            }
        }
    }

    public void k(int i10, boolean z10) {
        View viewFindViewById = findViewById(i10);
        if (viewFindViewById != null) {
            if (z10 == (viewFindViewById.getVisibility() == 0)) {
                return;
            }
            viewFindViewById.setVisibility(z10 ? 0 : 8);
            for (b bVar : this.f3734e) {
                if (bVar.f3738a == i10) {
                    bVar.f3744g = z10;
                    return;
                }
            }
        }
    }

    public void l(Drawable drawable, String str) {
        m(drawable, str, new a());
    }

    public void m(Drawable drawable, String str, View.OnClickListener onClickListener) {
        int i10 = f3731p;
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
        this.f3735m.setColor(this.f3736n);
        this.f3735m.setStyle(Paint.Style.FILL);
        canvas.drawRect(0.0f, getMeasuredHeight() - 2, getMeasuredWidth(), getMeasuredHeight(), this.f3735m);
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
        if (i10 == this.f3736n) {
            return;
        }
        this.f3736n = i10;
        invalidate();
    }

    public void setSearchViewVisible(boolean z10) {
        View viewFindViewById = findViewById(f3732q);
        if (viewFindViewById != null) {
            if ((viewFindViewById.getVisibility() == 0) == z10) {
                return;
            }
            viewFindViewById.setVisibility(z10 ? 0 : 8);
        }
    }

    public void setTitle(CharSequence charSequence) {
        int i10 = f3730o;
        TextView textView = (TextView) findViewById(i10);
        if (textView == null) {
            textView = new TextView(getContext());
            textView.setTextSize(0, com.tuyafeng.support.utils.f.d(getContext(), w7.n.f13757j));
            textView.setTextColor(com.tuyafeng.support.utils.e.a(getContext(), w7.k.f13732l));
            textView.setSingleLine();
            textView.setMaxLines(1);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setGravity(16);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.gravity = 16;
            layoutParams.weight = 24.0f;
            textView.setLayoutParams(layoutParams);
            textView.setId(i10);
            r3.o(textView);
            v8.g.d(textView);
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

    public e0(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public e0(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f3734e = new ArrayList();
        h();
    }
}
