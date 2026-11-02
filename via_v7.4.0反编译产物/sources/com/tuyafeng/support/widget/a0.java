package com.tuyafeng.support.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class a0 extends LinearLayout {

    /* renamed from: e, reason: collision with root package name */
    public Paint f4306e;

    /* renamed from: j, reason: collision with root package name */
    public Space f4307j;

    /* renamed from: k, reason: collision with root package name */
    public List f4308k;

    /* renamed from: l, reason: collision with root package name */
    public List f4309l;

    /* renamed from: m, reason: collision with root package name */
    public c f4310m;

    /* renamed from: n, reason: collision with root package name */
    public int f4311n;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f4312a;

        public a(b bVar) {
            this.f4312a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a0.this.f4310m != null) {
                a0.this.f4310m.a(view, this.f4312a);
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f4314a;

        /* renamed from: b, reason: collision with root package name */
        public int f4315b;

        /* renamed from: c, reason: collision with root package name */
        public String f4316c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f4317d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f4318e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f4319f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f4320g;

        public b(int i10, String str) {
            this.f4314a = i10;
            this.f4316c = str;
        }

        public int a() {
            return this.f4314a;
        }

        public int b() {
            return this.f4315b;
        }

        public String c() {
            return this.f4316c;
        }

        public boolean d() {
            return this.f4318e;
        }

        public boolean e() {
            return this.f4319f;
        }

        public boolean f() {
            return this.f4317d;
        }

        public boolean g() {
            return this.f4320g;
        }

        public void h(boolean z10) {
            this.f4318e = z10;
        }

        public void i(boolean z10) {
            this.f4319f = z10;
        }

        public void j(boolean z10) {
            this.f4317d = z10;
        }

        public void k(boolean z10) {
            this.f4320g = z10;
        }

        public void l(String str) {
            this.f4316c = str;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface c {
        void a(View view, b bVar);
    }

    public a0(Context context) {
        this(context, null);
    }

    public a0(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public a0(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f4311n = 0;
        f();
    }

    public void b(b bVar) {
        int iA;
        if (bVar == null) {
            return;
        }
        if (this.f4308k == null) {
            this.f4308k = new ArrayList();
        }
        TextView textView = new TextView(getContext());
        g(textView, bVar);
        Iterator it = this.f4308k.iterator();
        while (true) {
            if (!it.hasNext()) {
                iA = -1;
                break;
            }
            b bVar2 = (b) it.next();
            if (bVar.b() < bVar2.b()) {
                iA = bVar2.a();
                break;
            }
        }
        addView(textView, indexOfChild(iA == -1 ? this.f4307j : findViewById(iA)));
        this.f4308k.add(bVar);
    }

    public void c(b bVar) {
        int iA;
        if (bVar == null) {
            return;
        }
        if (this.f4309l == null) {
            this.f4309l = new ArrayList();
        }
        TextView textView = new TextView(getContext());
        g(textView, bVar);
        Iterator it = this.f4309l.iterator();
        while (true) {
            if (!it.hasNext()) {
                iA = -1;
                break;
            }
            b bVar2 = (b) it.next();
            if (bVar.b() < bVar2.b()) {
                iA = bVar2.a();
                break;
            }
        }
        addView(textView, iA == -1 ? indexOfChild(this.f4307j) + 1 : indexOfChild(findViewById(iA)));
        this.f4309l.add(bVar);
    }

    public final ColorStateList d(int i10, int i11) {
        return new ColorStateList(new int[][]{new int[]{-16842910}, new int[]{R.attr.state_enabled, R.attr.state_selected}, new int[0]}, new int[]{(16777215 & i10) | Integer.MIN_VALUE, i11, i10});
    }

    public TextView e(int i10) {
        return (TextView) findViewById(i10);
    }

    public final void f() {
        this.f4306e = new Paint(1);
        setOrientation(0);
        this.f4307j = new Space(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, g6.f.d(getContext(), x7.n.C));
        if (this.f4311n == 0) {
            layoutParams.weight = 1.0f;
        }
        this.f4307j.setLayoutParams(layoutParams);
        addView(this.f4307j);
        setWillNotDraw(false);
    }

    public final void g(TextView textView, b bVar) {
        if (textView == null || bVar == null) {
            return;
        }
        boolean z10 = this.f4311n == 1;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(z10 ? 0 : -2, -2);
        if (z10) {
            layoutParams.weight = 1.0f;
        }
        textView.setLayoutParams(layoutParams);
        textView.setId(bVar.a());
        textView.setBackgroundResource(x7.o.f13720e);
        textView.setText(bVar.c());
        textView.setEnabled(!bVar.f());
        textView.setSelected(bVar.d());
        textView.setTextColor(d(g6.e.a(getContext(), x7.k.f13665k), bVar.e() ? g6.f.b(getContext(), x7.m.f13671a) : x8.h.j(getContext())));
        textView.setVisibility(bVar.g() ? 8 : 0);
        int iH = g6.y.h(getContext(), 16.0f);
        textView.setPadding(iH, 0, iH, 0);
        textView.setMinHeight(g6.y.h(getContext(), 48.0f));
        textView.setGravity(17);
        textView.setOnClickListener(new a(bVar));
        x8.g.d(textView);
    }

    public void h(b bVar) {
        if (bVar == null) {
            return;
        }
        i((TextView) findViewById(bVar.a()), bVar);
    }

    public final void i(TextView textView, b bVar) {
        if (textView == null || bVar == null) {
            return;
        }
        textView.setText(bVar.c());
        textView.setEnabled(!bVar.f());
        textView.setSelected(bVar.d());
        textView.setVisibility(bVar.g() ? 8 : 0);
    }

    public void j(b... bVarArr) {
        for (b bVar : bVarArr) {
            h(bVar);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f4306e.setColor(g6.f.b(getContext(), x7.m.f13673c));
        this.f4306e.setStyle(Paint.Style.FILL);
        canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), 2.0f, this.f4306e);
    }

    public void setOnActionClickListener(c cVar) {
        this.f4310m = cVar;
    }

    public void setStyle(int i10) {
        if (i10 == this.f4311n) {
            return;
        }
        boolean z10 = i10 == 1;
        this.f4311n = i10;
        ((LinearLayout.LayoutParams) this.f4307j.getLayoutParams()).weight = 0.0f;
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (z10) {
                if (childAt instanceof Space) {
                    ((LinearLayout.LayoutParams) childAt.getLayoutParams()).weight = 0.0f;
                } else {
                    childAt.getLayoutParams().width = 0;
                    ((LinearLayout.LayoutParams) childAt.getLayoutParams()).weight = 1.0f;
                }
            } else if (childAt instanceof Space) {
                ((LinearLayout.LayoutParams) childAt.getLayoutParams()).weight = 1.0f;
            } else {
                ((LinearLayout.LayoutParams) childAt.getLayoutParams()).weight = 0.0f;
                childAt.getLayoutParams().width = -2;
            }
        }
    }
}
