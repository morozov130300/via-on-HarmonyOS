package f8;

import android.R;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import h6.a;
import mark.via.common.widget.l1;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class o extends LinearLayout {

    /* renamed from: e, reason: collision with root package name */
    public static final int f6007e = g6.y.l();

    /* renamed from: j, reason: collision with root package name */
    public static final int f6008j = g6.y.l();

    /* renamed from: k, reason: collision with root package name */
    public static final int f6009k = g6.y.l();

    /* renamed from: l, reason: collision with root package name */
    public static final int f6010l = g6.y.l();

    /* renamed from: m, reason: collision with root package name */
    public static final int f6011m = g6.y.l();

    public o(Context context) {
        this(context, null);
    }

    public o(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public o(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        f();
    }

    public static /* synthetic */ void a(Context context, ImageView imageView) {
        imageView.setClickable(true);
        imageView.setFocusable(true);
        imageView.setContentDescription(context.getString(x7.u.G5));
        imageView.setImageDrawable(lb.b.a(context, x7.o.P0, x7.u.kf));
        imageView.setColorFilter(g6.e.a(context, x7.k.f13662h));
    }

    public static /* synthetic */ void b(Context context, ImageView imageView) {
        imageView.setClickable(true);
        imageView.setFocusable(true);
        imageView.setContentDescription(context.getString(R.string.cancel));
        imageView.setImageDrawable(lb.b.a(context, x7.o.f13783z, x7.u.Ud));
        imageView.setColorFilter(g6.e.a(context, x7.k.f13662h));
    }

    public static /* synthetic */ void c(Context context, ImageView imageView) {
        imageView.setClickable(true);
        imageView.setFocusable(true);
        imageView.setContentDescription(context.getString(x7.u.F5));
        imageView.setImageDrawable(lb.b.a(context, x7.o.G0, x7.u.bf));
        imageView.setColorFilter(g6.e.a(context, x7.k.f13662h));
    }

    public static /* synthetic */ void d(Context context, TextView textView) {
        textView.setTextSize(0, x8.h.u(context));
        textView.setTextColor(g6.e.a(context, x7.k.f13666l));
        textView.setGravity(16);
    }

    public static /* synthetic */ void e(Context context, l1 l1Var) {
        EditText editText = l1Var.getEditText();
        editText.setHint(x7.u.F);
        if (Build.VERSION.SDK_INT >= 26) {
            editText.setImportantForAutofill(2);
        }
        editText.setInputType(1);
        editText.setSelectAllOnFocus(true);
        editText.setTextColor(g6.e.a(context, x7.k.f13665k));
        editText.setHintTextColor(g6.e.a(context, x7.k.f13666l));
        editText.setTextSize(0, x8.h.r(context));
    }

    public final void f() {
        final Context context = getContext();
        setPadding(g6.y.h(context, 16.0f), 0, g6.y.h(context, 16.0f), 0);
        setGravity(16);
        l1 l1Var = (l1) new h6.a(new l1(context), new LinearLayout.LayoutParams(0, -2)).W(1.0f).e(g6.f.e(context, x7.o.f13729h)).S(g6.y.h(context, 8.0f)).M(g6.y.h(context, 4.0f)).V(new a.InterfaceC0076a() { // from class: f8.j
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                o.e(context, (l1) obj);
            }
        }).l();
        l1Var.getEditText().setId(f6007e);
        View view = (TextView) new h6.a(new TextView(context), new LinearLayout.LayoutParams(-2, -1)).o(f6008j).E(g6.y.h(context, 4.0f)).V(new a.InterfaceC0076a() { // from class: f8.k
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                o.d(context, (TextView) obj);
            }
        }).l();
        int iD = g6.f.d(context, x7.n.f13685d);
        int iD2 = g6.f.d(context, x7.n.f13684c);
        View view2 = (ImageView) new h6.a(new ImageView(context), new LinearLayout.LayoutParams(iD, iD)).o(f6010l).e(g6.f.e(context, x7.o.f13720e)).E(iD2).V(new a.InterfaceC0076a() { // from class: f8.l
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                o.a(context, (ImageView) obj);
            }
        }).l();
        View view3 = (ImageView) new h6.a(new ImageView(context), new LinearLayout.LayoutParams(iD, iD)).o(f6009k).e(g6.f.e(context, x7.o.f13720e)).E(iD2).V(new a.InterfaceC0076a() { // from class: f8.m
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                o.c(context, (ImageView) obj);
            }
        }).l();
        View view4 = (ImageView) new h6.a(new ImageView(context), new LinearLayout.LayoutParams(iD, iD)).o(f6011m).e(g6.f.e(context, x7.o.f13720e)).E(iD2).V(new a.InterfaceC0076a() { // from class: f8.n
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                o.b(context, (ImageView) obj);
            }
        }).l();
        addView(l1Var);
        addView(view);
        addView(view2);
        addView(view3);
        addView(view4);
    }
}
