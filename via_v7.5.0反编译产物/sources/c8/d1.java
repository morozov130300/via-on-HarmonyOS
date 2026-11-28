package c8;

import android.graphics.Bitmap;
import c6.a2;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class d1 extends q4.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b8.g f2185a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u9.l f2186b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f2187c;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface a {
        void f0(int i10);
    }

    public d1(b8.g gVar, u9.l lVar, a aVar) {
        this.f2185a = gVar;
        this.f2186b = lVar;
        this.f2187c = aVar;
    }

    public static /* synthetic */ void J(d1 d1Var, WeakReference weakReference, String str) {
        d1Var.getClass();
        t4.b bVar = (t4.b) weakReference.get();
        if (bVar == null) {
            return;
        }
        int iE = s4.b.e(bVar);
        if (iE == 0) {
            iE = com.tuyafeng.support.utils.e.a(bVar.getContext(), w7.k.f13723c);
        }
        d1Var.f2185a.f(str, iE);
        bVar.setAccentColor(iE);
        if (bVar.isShown()) {
            d1Var.f2187c.f0(iE);
        }
    }

    @Override // q4.a
    public void G(t4.b bVar, int i10) {
        if (bVar == null || (i10 & 1) != 1) {
            return;
        }
        String url = bVar.getUrl();
        if (s9.d.k(s9.d.c(bVar.getContext(), url))) {
            this.f2187c.f0(0);
            return;
        }
        int iD = this.f2185a.d(url, v8.h.a(bVar.getContext()));
        if (iD == 0) {
            iD = v8.h.a(bVar.getContext());
        }
        this.f2187c.f0(iD);
    }

    public final void K(t4.b bVar, final String str) {
        if (bVar == null || str == null || str.isEmpty() || this.f2186b.e() || this.f2185a.a(str)) {
            return;
        }
        if (!a2.f1958a.v(str)) {
            this.f2185a.f(str, 0);
            final WeakReference weakReference = new WeakReference(bVar);
            bVar.postDelayed(new Runnable() { // from class: c8.c1
                @Override // java.lang.Runnable
                public final void run() {
                    d1.J(this.f2170c, weakReference, str);
                }
            }, 200L);
        } else {
            int iA = v8.h.a(bVar.getContext());
            bVar.setAccentColor(iA);
            if (bVar.isShown()) {
                this.f2187c.f0(iA);
            }
        }
    }

    @Override // q4.a
    public void o(t4.b bVar, String str) {
        if (s9.d.l(bVar.getContext(), str)) {
            return;
        }
        K(bVar, str);
    }

    @Override // q4.a
    public void p(t4.b bVar, String str, Bitmap bitmap) {
        int iD = 0;
        if (s9.d.k(s9.d.c(bVar.getContext(), str))) {
            bVar.setAccentColor(0);
        } else {
            iD = this.f2185a.d(str, 0);
            if (iD != 0) {
                bVar.setAccentColor(iD);
            } else {
                iD = v8.h.a(bVar.getContext());
            }
        }
        if (bVar.isShown()) {
            this.f2187c.f0(iD);
        }
    }

    @Override // q4.a
    public void t(t4.b bVar, int i10) {
        if (i10 <= 70 || i10 > 100) {
            return;
        }
        String url = bVar.getUrl();
        if (!s9.d.l(bVar.getContext(), url) && this.f2185a.d(url, 0) == 0) {
            K(bVar, url);
        }
    }
}
