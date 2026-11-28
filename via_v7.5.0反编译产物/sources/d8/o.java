package d8;

import android.R;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import mark.via.common.widget.l1;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class o extends LinearLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f3978c = com.tuyafeng.support.utils.x.l();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f3979e = com.tuyafeng.support.utils.x.l();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f3980m = com.tuyafeng.support.utils.x.l();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f3981n = com.tuyafeng.support.utils.x.l();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f3982o = com.tuyafeng.support.utils.x.l();

    public o(Context context) {
        this(context, null);
    }

    public static /* synthetic */ void a(Context context, ImageView imageView) {
        imageView.setClickable(true);
        imageView.setFocusable(true);
        imageView.setContentDescription(context.getString(w7.u.S5));
        imageView.setImageDrawable(lb.g.a(context, w7.o.N0, w7.u.Bf));
        imageView.setColorFilter(com.tuyafeng.support.utils.e.a(context, w7.k.f13729i));
    }

    public static /* synthetic */ void b(Context context, ImageView imageView) {
        imageView.setClickable(true);
        imageView.setFocusable(true);
        imageView.setContentDescription(context.getString(R.string.cancel));
        imageView.setImageDrawable(lb.g.a(context, w7.o.f13846y, w7.u.je));
        imageView.setColorFilter(com.tuyafeng.support.utils.e.a(context, w7.k.f13729i));
    }

    public static /* synthetic */ void c(Context context, ImageView imageView) {
        imageView.setClickable(true);
        imageView.setFocusable(true);
        imageView.setContentDescription(context.getString(w7.u.R5));
        imageView.setImageDrawable(lb.g.a(context, w7.o.E0, w7.u.sf));
        imageView.setColorFilter(com.tuyafeng.support.utils.e.a(context, w7.k.f13729i));
    }

    public static /* synthetic */ void d(Context context, TextView textView) {
        textView.setTextSize(0, v8.h.t(context));
        textView.setTextColor(com.tuyafeng.support.utils.e.a(context, w7.k.f13733m));
        textView.setGravity(16);
    }

    public static /* synthetic */ void e(Context context, l1 l1Var) {
        EditText editText = l1Var.getEditText();
        editText.setHint(w7.u.G);
        if (Build.VERSION.SDK_INT >= 26) {
            editText.setImportantForAutofill(2);
        }
        editText.setInputType(1);
        editText.setSelectAllOnFocus(true);
        editText.setTextColor(com.tuyafeng.support.utils.e.a(context, w7.k.f13732l));
        editText.setHintTextColor(com.tuyafeng.support.utils.e.a(context, w7.k.f13733m));
        editText.setTextSize(0, v8.h.q(context));
    }

    public final void f() {
        final Context context = getContext();
        setPadding(com.tuyafeng.support.utils.x.h(context, 16.0f), 0, com.tuyafeng.support.utils.x.h(context, 16.0f), 0);
        setGravity(16);
        l1 l1Var = (l1) new b6.a(new l1(context), new LinearLayout.LayoutParams(0, -2)).W(1.0f).e(com.tuyafeng.support.utils.f.e(context, w7.o.f13792g)).S(com.tuyafeng.support.utils.x.h(context, 8.0f)).M(com.tuyafeng.support.utils.x.h(context, 4.0f)).V(new b6.a.InterfaceC0033a() { // from class: d8.j
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                o.e(context, (l1) obj);
            }
        }).l();
        l1Var.getEditText().setId(f3978c);
        View view = (TextView) new b6.a(new TextView(context), new LinearLayout.LayoutParams(-2, -1)).o(f3979e).E(com.tuyafeng.support.utils.x.h(context, 4.0f)).V(new b6.a.InterfaceC0033a() { // from class: d8.k
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                o.d(context, (TextView) obj);
            }
        }).l();
        int iD = com.tuyafeng.support.utils.f.d(context, w7.n.f13751d);
        int iD2 = com.tuyafeng.support.utils.f.d(context, w7.n.f13750c);
        View view2 = (ImageView) new b6.a(new ImageView(context), new LinearLayout.LayoutParams(iD, iD)).o(f3981n).e(com.tuyafeng.support.utils.f.e(context, w7.o.f13783d)).E(iD2).V(new b6.a.InterfaceC0033a() { // from class: d8.l
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                o.a(context, (ImageView) obj);
            }
        }).l();
        View view3 = (ImageView) new b6.a(new ImageView(context), new LinearLayout.LayoutParams(iD, iD)).o(f3980m).e(com.tuyafeng.support.utils.f.e(context, w7.o.f13783d)).E(iD2).V(new b6.a.InterfaceC0033a() { // from class: d8.m
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                o.c(context, (ImageView) obj);
            }
        }).l();
        View view4 = (ImageView) new b6.a(new ImageView(context), new LinearLayout.LayoutParams(iD, iD)).o(f3982o).e(com.tuyafeng.support.utils.f.e(context, w7.o.f13783d)).E(iD2).V(new b6.a.InterfaceC0033a() { // from class: d8.n
            @Override // b6.a.InterfaceC0033a
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

    public o(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public o(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        f();
    }
}
