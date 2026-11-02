package e8;

import android.graphics.Bitmap;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class k0 extends p4.a {

    /* renamed from: a, reason: collision with root package name */
    public final d8.g f4837a;

    /* renamed from: b, reason: collision with root package name */
    public final w9.l f4838b;

    /* renamed from: c, reason: collision with root package name */
    public final a f4839c;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface a {
        void j0(int i10);
    }

    public k0(d8.g gVar, w9.l lVar, a aVar) {
        this.f4837a = gVar;
        this.f4838b = lVar;
        this.f4839c = aVar;
    }

    public static /* synthetic */ void G(k0 k0Var, WeakReference weakReference, String str) {
        k0Var.getClass();
        t4.b bVar = (t4.b) weakReference.get();
        if (bVar == null) {
            return;
        }
        int iE = s4.b.e(bVar);
        if (iE == 0) {
            iE = g6.e.a(bVar.getContext(), x7.k.f13656b);
        }
        k0Var.f4837a.f(str, iE);
        bVar.setAccentColor(iE);
        if (bVar.isShown()) {
            k0Var.f4839c.j0(iE);
        }
    }

    @Override // p4.a
    public void D(t4.b bVar, int i10) {
        if (bVar == null || (i10 & 1) != 1) {
            return;
        }
        String url = bVar.getUrl();
        if (u9.d.l(u9.d.d(bVar.getContext(), url))) {
            this.f4839c.j0(0);
        } else {
            this.f4839c.j0(this.f4837a.d(url, x8.h.a(bVar.getContext())));
        }
    }

    public final void H(t4.b bVar, final String str) {
        if (bVar == null || str == null || str.isEmpty() || this.f4838b.d() || this.f4837a.a(str)) {
            return;
        }
        if (!i6.i0.f7006a.u(str)) {
            this.f4837a.f(str, 0);
            final WeakReference weakReference = new WeakReference(bVar);
            bVar.postDelayed(new Runnable() { // from class: e8.j0
                @Override // java.lang.Runnable
                public final void run() {
                    k0.G(this.f4833e, weakReference, str);
                }
            }, 200L);
        } else {
            int iA = x8.h.a(bVar.getContext());
            bVar.setAccentColor(iA);
            if (bVar.isShown()) {
                this.f4839c.j0(iA);
            }
        }
    }

    @Override // p4.a
    public void n(t4.b bVar, String str) {
        if (u9.d.m(bVar.getContext(), str)) {
            return;
        }
        H(bVar, str);
    }

    @Override // p4.a
    public void o(t4.b bVar, String str, Bitmap bitmap) {
        int iD = 0;
        if (u9.d.l(u9.d.d(bVar.getContext(), str))) {
            bVar.setAccentColor(0);
        } else {
            iD = this.f4837a.d(str, 0);
            if (iD != 0) {
                bVar.setAccentColor(iD);
            } else {
                iD = x8.h.a(bVar.getContext());
            }
        }
        if (bVar.isShown()) {
            this.f4839c.j0(iD);
        }
    }

    @Override // p4.a
    public void r(t4.b bVar, int i10) {
        if (i10 <= 70 || i10 > 100) {
            return;
        }
        String url = bVar.getUrl();
        if (!u9.d.m(bVar.getContext(), url) && this.f4837a.d(url, 0) == 0) {
            H(bVar, url);
        }
    }
}
