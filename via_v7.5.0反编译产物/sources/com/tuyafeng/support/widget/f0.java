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

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class f0 extends LinearLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Paint f3745c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Space f3746e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public List f3747m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public List f3748n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public c f3749o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f3750p;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f3751a;

        public a(b bVar) {
            this.f3751a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (f0.this.f3749o != null) {
                f0.this.f3749o.a(view, this.f3751a);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f3753a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f3754b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f3755c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f3756d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f3757e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f3758f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f3759g;

        public b(int i10, String str) {
            this.f3753a = i10;
            this.f3755c = str;
        }

        public int a() {
            return this.f3753a;
        }

        public int b() {
            return this.f3754b;
        }

        public String c() {
            return this.f3755c;
        }

        public boolean d() {
            return this.f3757e;
        }

        public boolean e() {
            return this.f3758f;
        }

        public boolean f() {
            return this.f3756d;
        }

        public boolean g() {
            return this.f3759g;
        }

        public void h(boolean z10) {
            this.f3757e = z10;
        }

        public void i(boolean z10) {
            this.f3758f = z10;
        }

        public void j(boolean z10) {
            this.f3756d = z10;
        }

        public void k(boolean z10) {
            this.f3759g = z10;
        }

        public void l(String str) {
            this.f3755c = str;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface c {
        void a(View view, b bVar);
    }

    public f0(Context context) {
        this(context, null);
    }

    public void b(b bVar) {
        int iA;
        if (bVar == null) {
            return;
        }
        if (this.f3747m == null) {
            this.f3747m = new ArrayList();
        }
        TextView textView = new TextView(getContext());
        h(textView, bVar);
        Iterator it = this.f3747m.iterator();
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
        addView(textView, indexOfChild(iA == -1 ? this.f3746e : findViewById(iA)));
        this.f3747m.add(bVar);
    }

    public void c(b bVar) {
        int iA;
        if (bVar == null) {
            return;
        }
        if (this.f3748n == null) {
            this.f3748n = new ArrayList();
        }
        TextView textView = new TextView(getContext());
        h(textView, bVar);
        Iterator it = this.f3748n.iterator();
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
        addView(textView, iA == -1 ? indexOfChild(this.f3746e) + 1 : indexOfChild(findViewById(iA)));
        this.f3748n.add(bVar);
    }

    public final void d(TextView textView, b bVar) {
        textView.setTextColor(e(com.tuyafeng.support.utils.e.a(getContext(), w7.k.f13732l), bVar.e() ? com.tuyafeng.support.utils.f.b(getContext(), w7.m.f13737a) : v8.h.j(getContext())));
    }

    public final ColorStateList e(int i10, int i11) {
        return new ColorStateList(new int[][]{new int[]{-16842910}, new int[]{R.attr.state_enabled, R.attr.state_selected}, new int[0]}, new int[]{(16777215 & i10) | Integer.MIN_VALUE, i11, i10});
    }

    public TextView f(int i10) {
        return (TextView) findViewById(i10);
    }

    public final void g() {
        this.f3745c = new Paint(1);
        setOrientation(0);
        this.f3746e = new Space(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, com.tuyafeng.support.utils.f.d(getContext(), w7.n.E));
        if (this.f3750p == 0) {
            layoutParams.weight = 1.0f;
        }
        this.f3746e.setLayoutParams(layoutParams);
        addView(this.f3746e);
        setWillNotDraw(false);
    }

    public final void h(TextView textView, b bVar) {
        if (textView == null || bVar == null) {
            return;
        }
        boolean z10 = this.f3750p == 1;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(z10 ? 0 : -2, -2);
        if (z10) {
            layoutParams.weight = 1.0f;
        }
        textView.setLayoutParams(layoutParams);
        textView.setId(bVar.a());
        textView.setBackgroundResource(w7.o.f13783d);
        textView.setText(bVar.c());
        textView.setEnabled(!bVar.f());
        textView.setSelected(bVar.d());
        d(textView, bVar);
        textView.setVisibility(bVar.g() ? 8 : 0);
        int iH = com.tuyafeng.support.utils.x.h(getContext(), 16.0f);
        textView.setPadding(iH, 0, iH, 0);
        textView.setMinHeight(com.tuyafeng.support.utils.x.h(getContext(), 48.0f));
        textView.setGravity(17);
        textView.setOnClickListener(new a(bVar));
        v8.g.d(textView);
    }

    public void i() {
        List<b> list = this.f3747m;
        if (list != null) {
            for (b bVar : list) {
                d(f(bVar.a()), bVar);
            }
        }
        List<b> list2 = this.f3748n;
        if (list2 != null) {
            for (b bVar2 : list2) {
                d(f(bVar2.a()), bVar2);
            }
        }
    }

    public void j(b bVar) {
        if (bVar == null) {
            return;
        }
        k((TextView) findViewById(bVar.a()), bVar);
    }

    public final void k(TextView textView, b bVar) {
        if (textView == null || bVar == null) {
            return;
        }
        textView.setText(bVar.c());
        textView.setEnabled(!bVar.f());
        textView.setSelected(bVar.d());
        textView.setVisibility(bVar.g() ? 8 : 0);
    }

    public void l(b... bVarArr) {
        for (b bVar : bVarArr) {
            j(bVar);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f3745c.setColor(com.tuyafeng.support.utils.f.b(getContext(), w7.m.f13739c));
        this.f3745c.setStyle(Paint.Style.FILL);
        canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), 2.0f, this.f3745c);
    }

    public void setOnActionClickListener(c cVar) {
        this.f3749o = cVar;
    }

    public void setStyle(int i10) {
        if (i10 == this.f3750p) {
            return;
        }
        boolean z10 = i10 == 1;
        this.f3750p = i10;
        ((LinearLayout.LayoutParams) this.f3746e.getLayoutParams()).weight = 0.0f;
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

    public f0(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public f0(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f3750p = 0;
        g();
    }
}
