package f6;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import g6.y;
import h6.a;
import x.k0;
import x.r;
import x7.k;
import x7.m;
import x7.o;
import z8.r3;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public final Context f5914a;

    /* renamed from: b, reason: collision with root package name */
    public final ViewGroup f5915b;

    /* renamed from: c, reason: collision with root package name */
    public final View f5916c;

    /* renamed from: d, reason: collision with root package name */
    public final c f5917d;

    /* renamed from: e, reason: collision with root package name */
    public final int f5918e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f5919f;

    /* renamed from: g, reason: collision with root package name */
    public int f5920g;

    /* renamed from: h, reason: collision with root package name */
    public int f5921h;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a extends v5.c {

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View.OnClickListener f5922c;

        public a(View.OnClickListener onClickListener) {
            this.f5922c = onClickListener;
        }

        @Override // v5.c
        public void a(View view) {
            h.this.f5919f = true;
            View.OnClickListener onClickListener = this.f5922c;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
            h.this.l();
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final Context f5924a;

        /* renamed from: b, reason: collision with root package name */
        public ViewGroup f5925b;

        /* renamed from: c, reason: collision with root package name */
        public Drawable f5926c;

        /* renamed from: d, reason: collision with root package name */
        public String f5927d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f5928e;

        /* renamed from: f, reason: collision with root package name */
        public String f5929f;

        /* renamed from: g, reason: collision with root package name */
        public View.OnClickListener f5930g;

        /* renamed from: h, reason: collision with root package name */
        public View.OnLongClickListener f5931h;

        /* renamed from: i, reason: collision with root package name */
        public c f5932i;

        /* renamed from: j, reason: collision with root package name */
        public int f5933j;

        public b(Context context) {
            this.f5924a = context;
        }

        public h a() {
            Activity activityA;
            if (this.f5925b == null && (activityA = g6.f.a(this.f5924a)) != null) {
                this.f5925b = (ViewGroup) activityA.findViewById(R.id.content);
            }
            return new h(this.f5924a, this.f5925b, this.f5926c, this.f5927d, this.f5928e, this.f5929f, this.f5930g, this.f5931h, this.f5932i, this.f5933j, null);
        }

        public b b(int i10) {
            return d(this.f5924a.getString(i10));
        }

        public b c(int i10, View.OnClickListener onClickListener) {
            return b(i10).e(onClickListener);
        }

        public b d(String str) {
            this.f5929f = str;
            return this;
        }

        public b e(View.OnClickListener onClickListener) {
            this.f5930g = onClickListener;
            return this;
        }

        public b f(View.OnLongClickListener onLongClickListener) {
            this.f5931h = onLongClickListener;
            return this;
        }

        public b g(c cVar) {
            this.f5932i = cVar;
            return this;
        }

        public b h(String str) {
            this.f5927d = str;
            return this;
        }

        public b i(ViewGroup viewGroup) {
            this.f5925b = viewGroup;
            return this;
        }

        public b j(boolean z10) {
            this.f5928e = z10;
            return this;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface c {
        void onCancel();
    }

    public h(Context context, ViewGroup viewGroup, Drawable drawable, String str, boolean z10, String str2, View.OnClickListener onClickListener, View.OnLongClickListener onLongClickListener, c cVar, int i10) {
        h hVar;
        this.f5919f = false;
        this.f5921h = 0;
        this.f5914a = context;
        this.f5915b = viewGroup;
        if (context == null || viewGroup == null || TextUtils.isEmpty(str)) {
            hVar = this;
            hVar.f5920g = Math.max(0, i10);
            hVar.f5916c = null;
        } else {
            this.f5920g = i10 <= 0 ? y.h(context, 120.0f) : i10;
            hVar = this;
            hVar.f5916c = hVar.k(context, drawable, str, z10, str2, onClickListener, onLongClickListener);
        }
        hVar.f5917d = cVar;
        hVar.f5918e = TextUtils.isEmpty(str2) ? 1600 : 3500;
    }

    public /* synthetic */ h(Context context, ViewGroup viewGroup, Drawable drawable, String str, boolean z10, String str2, View.OnClickListener onClickListener, View.OnLongClickListener onLongClickListener, c cVar, int i10, a aVar) {
        this(context, viewGroup, drawable, str, z10, str2, onClickListener, onLongClickListener, cVar, i10);
    }

    public static /* synthetic */ void a(LinearLayout linearLayout) {
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
    }

    public static /* synthetic */ void c(h hVar, Context context, String str, View.OnClickListener onClickListener, final View.OnLongClickListener onLongClickListener, TextView textView) {
        hVar.getClass();
        textView.setMinWidth(y.h(context, 56.0f));
        textView.setTextColor(x8.h.j(context));
        x8.g.m(textView, x8.h.r(context));
        textView.setMaxWidth(y.h(context, 200.0f));
        textView.setGravity(17);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setAllCaps(true);
        textView.setText(str);
        textView.setOnClickListener(hVar.new a(onClickListener));
        textView.setOnLongClickListener(new View.OnLongClickListener() { // from class: f6.g
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return h.f(onLongClickListener, view);
            }
        });
    }

    public static /* synthetic */ k0 d(h hVar, View view, k0 k0Var) {
        hVar.getClass();
        r.f fVarF = k0Var.f(k0.m.c());
        int i10 = fVarF.f11468d - fVarF.f11466b;
        if (i10 == hVar.f5921h) {
            return k0Var;
        }
        hVar.f5921h = i10;
        int iMin = i10 <= 0 ? hVar.f5920g : Math.min(hVar.f5920g, y.h(view.getContext(), 32.0f)) + i10;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        marginLayoutParams.bottomMargin = iMin;
        view.setLayoutParams(marginLayoutParams);
        return k0Var;
    }

    public static /* synthetic */ void e(Context context, Drawable drawable, ImageView imageView) {
        r3.l(imageView, g6.e.a(context, k.f13667m));
        imageView.setImageDrawable(drawable);
    }

    public static /* synthetic */ boolean f(View.OnLongClickListener onLongClickListener, View view) {
        return onLongClickListener != null && onLongClickListener.onLongClick(view);
    }

    public static /* synthetic */ void g(Context context, String str, boolean z10, TextView textView) {
        textView.setTextColor(g6.e.a(context, k.f13667m));
        x8.g.m(textView, x8.h.r(context));
        textView.setMaxWidth(y.h(context, 360.0f));
        textView.setText(str);
        if (z10) {
            textView.setSingleLine();
            textView.setEllipsize(TextUtils.TruncateAt.END);
        }
    }

    public void j() {
        c cVar = this.f5917d;
        if (cVar == null || this.f5919f) {
            return;
        }
        cVar.onCancel();
    }

    public final View k(final Context context, final Drawable drawable, final String str, final boolean z10, final String str2, final View.OnClickListener onClickListener, final View.OnLongClickListener onLongClickListener) {
        LinearLayout linearLayout = (LinearLayout) new h6.a(new LinearLayout(context), new FrameLayout.LayoutParams(-2, -2)).N(1, 16).B(1, 16).t(0, this.f5920g).x(1, 16).p(81).j(str).e(new g6.g().h(g6.f.b(context, m.f13679i)).c(y.h(context, 30.0f)).a()).V(new a.InterfaceC0076a() { // from class: f6.a
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                h.a((LinearLayout) obj);
            }
        }).l();
        if (drawable != null) {
            linearLayout.addView((ImageView) new h6.a(new ImageView(context), new LinearLayout.LayoutParams(-2, -2)).Y(1, 22).n(1, 22).v(1, 4).V(new a.InterfaceC0076a() { // from class: f6.b
                @Override // h6.a.InterfaceC0076a
                public final void a(Object obj) {
                    h.e(context, drawable, (ImageView) obj);
                }
            }).l());
        }
        linearLayout.addView((TextView) new h6.a(new TextView(context), new LinearLayout.LayoutParams(0, -2)).W(1.0f).T(1, 14).N(1, 4).V(new a.InterfaceC0076a() { // from class: f6.c
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                h.g(context, str, z10, (TextView) obj);
            }
        }).l());
        if (str2 != null) {
            linearLayout.addView((TextView) new h6.a(new TextView(context), new LinearLayout.LayoutParams(-2, -2)).d(o.f13720e).F(1, 8).V(new a.InterfaceC0076a() { // from class: f6.d
                @Override // h6.a.InterfaceC0076a
                public final void a(Object obj) {
                    h.c(this.f5906a, context, str2, onClickListener, onLongClickListener, (TextView) obj);
                }
            }).l());
        }
        x8.g.f(linearLayout);
        m(linearLayout);
        return linearLayout;
    }

    public final void l() {
        i.e().f(true);
    }

    public final void m(final View view) {
        if (Build.VERSION.SDK_INT < 21) {
            return;
        }
        r.d0(view, new x.m() { // from class: f6.e
            @Override // x.m
            public final k0 a(View view2, k0 k0Var) {
                return h.d(this.f5911a, view2, k0Var);
            }
        });
        view.post(new Runnable() { // from class: f6.f
            @Override // java.lang.Runnable
            public final void run() {
                r.U(view);
            }
        });
    }

    public int n() {
        return this.f5918e;
    }

    public ViewGroup o() {
        return this.f5915b;
    }

    public View p() {
        return this.f5916c;
    }

    public boolean q() {
        return this.f5914a == null || this.f5915b == null || this.f5916c == null;
    }

    public boolean r() {
        View view = this.f5916c;
        return view != null && view.isShown();
    }

    public void s() {
        ViewGroup viewGroup = this.f5915b;
        if (viewGroup == null || !viewGroup.isShown()) {
            return;
        }
        i.e().a(this);
    }
}
