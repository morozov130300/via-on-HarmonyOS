package a6;

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
import com.tuyafeng.support.utils.x;
import w7.k;
import w7.m;
import w7.o;
import x8.r3;
import y.k0;
import y.r;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f69a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewGroup f70b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f71c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f72d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f73e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f74f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f75g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f76h;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends p5.c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View.OnClickListener f77c;

        public a(View.OnClickListener onClickListener) {
            this.f77c = onClickListener;
        }

        @Override // p5.c
        public void a(View view) {
            h.this.f74f = true;
            View.OnClickListener onClickListener = this.f77c;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
            h.this.l();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f79a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ViewGroup f80b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Drawable f81c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f82d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f83e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f84f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public View.OnClickListener f85g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public View.OnLongClickListener f86h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public c f87i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f88j;

        public b(Context context) {
            this.f79a = context;
        }

        public h a() {
            Activity activityA;
            if (this.f80b == null && (activityA = com.tuyafeng.support.utils.f.a(this.f79a)) != null) {
                this.f80b = (ViewGroup) activityA.findViewById(R.id.content);
            }
            return new h(this.f79a, this.f80b, this.f81c, this.f82d, this.f83e, this.f84f, this.f85g, this.f86h, this.f87i, this.f88j, null);
        }

        public b b(int i10) {
            return d(this.f79a.getString(i10));
        }

        public b c(int i10, View.OnClickListener onClickListener) {
            return b(i10).e(onClickListener);
        }

        public b d(String str) {
            this.f84f = str;
            return this;
        }

        public b e(View.OnClickListener onClickListener) {
            this.f85g = onClickListener;
            return this;
        }

        public b f(View.OnLongClickListener onLongClickListener) {
            this.f86h = onLongClickListener;
            return this;
        }

        public b g(c cVar) {
            this.f87i = cVar;
            return this;
        }

        public b h(String str) {
            this.f82d = str;
            return this;
        }

        public b i(ViewGroup viewGroup) {
            this.f80b = viewGroup;
            return this;
        }

        public b j(boolean z10) {
            this.f83e = z10;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface c {
        void onCancel();
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
        textView.setMinWidth(x.h(context, 56.0f));
        textView.setTextColor(v8.h.j(context));
        v8.g.m(textView, v8.h.q(context));
        textView.setMaxWidth(x.h(context, 200.0f));
        textView.setGravity(17);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setAllCaps(true);
        textView.setText(str);
        textView.setOnClickListener(hVar.new a(onClickListener));
        textView.setOnLongClickListener(new View.OnLongClickListener() { // from class: a6.g
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return h.f(onLongClickListener, view);
            }
        });
    }

    public static /* synthetic */ k0 d(h hVar, View view, k0 k0Var) {
        hVar.getClass();
        r.f fVarF = k0Var.f(k0.m.c());
        int i10 = fVarF.f11878d - fVarF.f11876b;
        if (i10 == hVar.f76h) {
            return k0Var;
        }
        hVar.f76h = i10;
        int iMin = i10 <= 0 ? hVar.f75g : Math.min(hVar.f75g, x.h(view.getContext(), 32.0f)) + i10;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        marginLayoutParams.bottomMargin = iMin;
        view.setLayoutParams(marginLayoutParams);
        return k0Var;
    }

    public static /* synthetic */ void e(Context context, Drawable drawable, ImageView imageView) {
        r3.m(imageView, com.tuyafeng.support.utils.e.a(context, k.f13734n));
        imageView.setImageDrawable(drawable);
    }

    public static /* synthetic */ boolean f(View.OnLongClickListener onLongClickListener, View view) {
        return onLongClickListener != null && onLongClickListener.onLongClick(view);
    }

    public static /* synthetic */ void g(Context context, String str, boolean z10, TextView textView) {
        textView.setTextColor(com.tuyafeng.support.utils.e.a(context, k.f13734n));
        v8.g.m(textView, v8.h.q(context));
        textView.setMaxWidth(x.h(context, 360.0f));
        textView.setText(str);
        if (z10) {
            textView.setSingleLine();
            textView.setEllipsize(TextUtils.TruncateAt.END);
        }
    }

    public void j() {
        c cVar = this.f72d;
        if (cVar == null || this.f74f) {
            return;
        }
        cVar.onCancel();
    }

    public final View k(final Context context, final Drawable drawable, final String str, final boolean z10, final String str2, final View.OnClickListener onClickListener, final View.OnLongClickListener onLongClickListener) {
        LinearLayout linearLayout = (LinearLayout) new b6.a(new LinearLayout(context), new FrameLayout.LayoutParams(-2, -2)).N(1, 16).B(1, 16).t(0, this.f75g).x(1, 16).p(81).j(str).e(new com.tuyafeng.support.utils.g().h(com.tuyafeng.support.utils.f.b(context, m.f13745i)).c(x.h(context, 30.0f)).a()).V(new b6.a.InterfaceC0033a() { // from class: a6.a
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                h.a((LinearLayout) obj);
            }
        }).l();
        if (drawable != null) {
            linearLayout.addView((ImageView) new b6.a(new ImageView(context), new LinearLayout.LayoutParams(-2, -2)).Y(1, 22).n(1, 22).v(1, 4).V(new b6.a.InterfaceC0033a() { // from class: a6.b
                @Override // b6.a.InterfaceC0033a
                public final void a(Object obj) {
                    h.e(context, drawable, (ImageView) obj);
                }
            }).l());
        }
        linearLayout.addView((TextView) new b6.a(new TextView(context), new LinearLayout.LayoutParams(0, -2)).W(1.0f).T(1, 14).N(1, 4).V(new b6.a.InterfaceC0033a() { // from class: a6.c
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                h.g(context, str, z10, (TextView) obj);
            }
        }).l());
        if (str2 != null) {
            linearLayout.addView((TextView) new b6.a(new TextView(context), new LinearLayout.LayoutParams(-2, -2)).d(o.f13783d).F(1, 8).V(new b6.a.InterfaceC0033a() { // from class: a6.d
                @Override // b6.a.InterfaceC0033a
                public final void a(Object obj) {
                    h.c(this.f61a, context, str2, onClickListener, onLongClickListener, (TextView) obj);
                }
            }).l());
        }
        v8.g.f(linearLayout);
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
        r.e0(view, new y.m() { // from class: a6.e
            @Override // y.m
            public final k0 a(View view2, k0 k0Var) {
                return h.d(this.f66a, view2, k0Var);
            }
        });
        view.post(new Runnable() { // from class: a6.f
            @Override // java.lang.Runnable
            public final void run() {
                r.V(view);
            }
        });
    }

    public int n() {
        return this.f73e;
    }

    public ViewGroup o() {
        return this.f70b;
    }

    public View p() {
        return this.f71c;
    }

    public boolean q() {
        return this.f69a == null || this.f70b == null || this.f71c == null;
    }

    public boolean r() {
        View view = this.f71c;
        return view != null && view.isShown();
    }

    public void s() {
        ViewGroup viewGroup = this.f70b;
        if (viewGroup == null || !viewGroup.isShown()) {
            return;
        }
        i.e().a(this);
    }

    public h(Context context, ViewGroup viewGroup, Drawable drawable, String str, boolean z10, String str2, View.OnClickListener onClickListener, View.OnLongClickListener onLongClickListener, c cVar, int i10) {
        h hVar;
        this.f74f = false;
        this.f76h = 0;
        this.f69a = context;
        this.f70b = viewGroup;
        if (context == null || viewGroup == null || TextUtils.isEmpty(str)) {
            hVar = this;
            hVar.f75g = Math.max(0, i10);
            hVar.f71c = null;
        } else {
            this.f75g = i10 <= 0 ? x.h(context, 120.0f) : i10;
            hVar = this;
            hVar.f71c = hVar.k(context, drawable, str, z10, str2, onClickListener, onLongClickListener);
        }
        hVar.f72d = cVar;
        hVar.f73e = TextUtils.isEmpty(str2) ? 1600 : 3500;
    }
}
