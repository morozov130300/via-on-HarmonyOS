package p8;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.Window;
import java.util.function.Consumer;
import pa.r;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    public final Window f10988a;

    /* renamed from: b, reason: collision with root package name */
    public Drawable f10989b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f10990c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f10991d = false;

    /* renamed from: e, reason: collision with root package name */
    public int f10992e = 80;

    /* renamed from: f, reason: collision with root package name */
    public int f10993f = 20;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a implements View.OnAttachStateChangeListener {

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Consumer f10994e;

        public a(Consumer consumer) {
            this.f10994e = consumer;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            l.this.f10988a.getWindowManager().addCrossWindowBlurEnabledListener(this.f10994e);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            l.this.f10988a.getWindowManager().removeCrossWindowBlurEnabledListener(this.f10994e);
            if (l.this.f10991d) {
                l.this.g(false);
            }
        }
    }

    public l(Window window) {
        this.f10988a = window;
    }

    public static boolean e() {
        return Build.VERSION.SDK_INT >= 31;
    }

    public void f() {
        if (e()) {
            Context context = this.f10988a.getContext();
            Drawable drawableE = g6.f.e(context, g6.e.b(context, x7.k.f13659e));
            this.f10989b = drawableE;
            if (drawableE == null) {
                return;
            }
            this.f10988a.setBackgroundDrawable(drawableE);
            if (this.f10990c) {
                this.f10988a.addFlags(4);
                this.f10988a.addFlags(2);
            }
            k();
        }
    }

    public final void g(boolean z10) {
        if (this.f10990c) {
            if (z10) {
                this.f10991d = true;
            }
            Activity activityA = g6.f.a(this.f10988a.getContext());
            if (activityA == null) {
                return;
            }
            z8.l.e(activityA.getWindow().getDecorView(), z10);
            int i10 = r.j().d() ? 229 : 216;
            Drawable drawable = this.f10989b;
            if (!z10) {
                i10 = 255;
            }
            drawable.setAlpha(i10);
            this.f10988a.setDimAmount(z10 ? 0.2f : 0.4f);
        }
    }

    public void h(int i10) {
        this.f10992e = i10;
    }

    public void i(boolean z10) {
        this.f10990c = z10;
    }

    public void j(int i10) {
        this.f10993f = i10;
    }

    public final void k() {
        this.f10988a.getDecorView().addOnAttachStateChangeListener(new a(new Consumer() { // from class: p8.i
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f10987a.l(((Boolean) obj).booleanValue());
            }
        }));
    }

    public final void l(boolean z10) {
        if (!z10) {
            if (this.f10990c) {
                g(true);
                return;
            }
            return;
        }
        this.f10989b.setAlpha(r.j().d() ? 216 : 204);
        this.f10988a.setDimAmount(0.2f);
        if (e()) {
            this.f10988a.setBackgroundBlurRadius(this.f10992e);
            if (this.f10990c) {
                this.f10988a.getAttributes().setBlurBehindRadius(this.f10993f);
            }
            Window window = this.f10988a;
            window.setAttributes(window.getAttributes());
        }
    }
}
