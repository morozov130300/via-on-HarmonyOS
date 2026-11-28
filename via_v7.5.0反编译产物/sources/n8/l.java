package n8;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.Window;
import java.util.function.Consumer;
import la.s;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Window f10717a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Drawable f10718b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f10719c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f10720d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f10721e = 80;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f10722f = 20;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Consumer f10723c;

        public a(Consumer consumer) {
            this.f10723c = consumer;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            l.this.f10717a.getWindowManager().addCrossWindowBlurEnabledListener(this.f10723c);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            l.this.f10717a.getWindowManager().removeCrossWindowBlurEnabledListener(this.f10723c);
            if (l.this.f10720d) {
                l.this.g(false);
            }
        }
    }

    public l(Window window) {
        this.f10717a = window;
    }

    public static boolean e() {
        return Build.VERSION.SDK_INT >= 31;
    }

    public void f() {
        if (e()) {
            Context context = this.f10717a.getContext();
            Drawable drawableE = com.tuyafeng.support.utils.f.e(context, com.tuyafeng.support.utils.e.b(context, w7.k.f13726f));
            this.f10718b = drawableE;
            if (drawableE == null) {
                return;
            }
            this.f10717a.setBackgroundDrawable(drawableE);
            if (this.f10719c) {
                this.f10717a.addFlags(4);
                this.f10717a.addFlags(2);
            }
            k();
        }
    }

    public final void g(boolean z10) {
        if (this.f10719c) {
            if (z10) {
                this.f10720d = true;
            }
            Activity activityA = com.tuyafeng.support.utils.f.a(this.f10717a.getContext());
            if (activityA == null) {
                return;
            }
            x8.l.e(activityA.getWindow().getDecorView(), z10);
            int i10 = s.j().e() ? 229 : 216;
            Drawable drawable = this.f10718b;
            if (!z10) {
                i10 = 255;
            }
            drawable.setAlpha(i10);
            this.f10717a.setDimAmount(z10 ? 0.2f : 0.4f);
        }
    }

    public void h(int i10) {
        this.f10721e = i10;
    }

    public void i(boolean z10) {
        this.f10719c = z10;
    }

    public void j(int i10) {
        this.f10722f = i10;
    }

    public final void k() {
        this.f10717a.getDecorView().addOnAttachStateChangeListener(new a(new Consumer() { // from class: n8.i
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f10716a.l(((Boolean) obj).booleanValue());
            }
        }));
    }

    public final void l(boolean z10) {
        if (!z10) {
            if (this.f10719c) {
                g(true);
                return;
            }
            return;
        }
        this.f10718b.setAlpha(s.j().e() ? 216 : 204);
        this.f10717a.setDimAmount(0.2f);
        if (e()) {
            this.f10717a.setBackgroundBlurRadius(this.f10721e);
            if (this.f10719c) {
                this.f10717a.getAttributes().setBlurBehindRadius(this.f10722f);
            }
            Window window = this.f10717a;
            window.setAttributes(window.getAttributes());
        }
    }
}
