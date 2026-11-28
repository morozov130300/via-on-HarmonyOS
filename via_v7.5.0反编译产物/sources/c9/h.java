package c9;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import mark.via.common.widget.LinearLayoutPagerManager;
import w7.a0;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class h extends j {

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public g9.a f2317u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public t5.f f2318v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public d9.a f2319w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public List f2320x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public final androidx.activity.result.b f2321y0 = w2(new s5.e(), new androidx.activity.result.a() { // from class: c9.a
        @Override // androidx.activity.result.a
        public final void a(Object obj) {
            h hVar = this.f2309a;
            ((autodispose2.m) x8.b.c(hVar.G(), (Uri) obj, "bg", ".png").k(q6.b.b()).p(s8.b.a(hVar.b1()))).a(new u6.f() { // from class: c9.d
                @Override // u6.f
                public final void accept(Object obj2) {
                    h.c3(hVar, (String) obj2);
                }
            }, new a0());
        }
    });

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends RecyclerView.y {
        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public boolean c(RecyclerView recyclerView, MotionEvent motionEvent) {
            if (motionEvent.getActionMasked() != 0 || recyclerView.getAdapter() != h.this.f2318v0) {
                return false;
            }
            recyclerView.getParent().requestDisallowInterceptTouchEvent(true);
            return false;
        }
    }

    public static /* synthetic */ void Z2(h hVar, String str) {
        h9.a.a(hVar.G());
        h9.a.c(hVar.G(), str);
        b9.t tVar = hVar.f2324o0;
        Objects.requireNonNull(tVar);
        x8.h.d(hVar, new g(tVar));
    }

    public static /* synthetic */ void c3(final h hVar, final String str) {
        hVar.getClass();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 8;
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(str, options);
        int i10 = 0;
        if (bitmapDecodeFile == null || bitmapDecodeFile.getWidth() == 0 || bitmapDecodeFile.getHeight() == 0) {
            hVar.f2325p0.e0(-1);
            hVar.f2325p0.H1(null);
            hVar.f2317u0.e(false);
            hVar.f2317u0.h(0);
            hVar.f2324o0.r(hVar.f2317u0, false);
            x8.h.b(new Runnable() { // from class: c9.e
                @Override // java.lang.Runnable
                public final void run() {
                    h.e3(this.f2313c);
                }
            });
        } else {
            int pixel = bitmapDecodeFile.getPixel(0, 0);
            u9.l lVar = hVar.f2325p0;
            if (pixel == 0) {
                pixel = -16777216;
            }
            lVar.e0(pixel);
            hVar.f2325p0.H1(str);
            hVar.f2317u0.e(false);
            hVar.f2324o0.r(hVar.f2317u0, false);
            x8.h.b(new Runnable() { // from class: c9.f
                @Override // java.lang.Runnable
                public final void run() {
                    h.Z2(this.f2314c, str);
                }
            });
            i10 = 1;
        }
        u9.n.e().u(true).t(true);
        hVar.f2324o0.p();
        hVar.f2319w0.t(hVar.f2318v0, i10);
        hVar.l3();
        hVar.k3();
    }

    public static /* synthetic */ void e3(h hVar) {
        h9.a.a(hVar.G());
        b9.t tVar = hVar.f2324o0;
        Objects.requireNonNull(tVar);
        x8.h.d(hVar, new g(tVar));
    }

    public static List h3(Context context) {
        Bundle bundle = new Bundle();
        bundle.putInt("settings_search_section", w7.p.f13901q0);
        mark.via.settings.search.h hVar = new mark.via.settings.search.h(context, b9.q.class, bundle, w7.u.Kc, w7.u.fd);
        hVar.c("custom.background.1", 1, w7.u.fd, new String[0]);
        if (!com.tuyafeng.support.utils.p.f(la.s.j().d())) {
            hVar.c("custom.background.3", 3, w7.u.Xf, new String[0]);
            hVar.c("custom.background.2", 2, w7.u.f14214r9, new String[0]);
        }
        return hVar.f();
    }

    @Override // c9.j
    public List T2() {
        e9.a aVarO;
        boolean zC;
        boolean z10;
        int iA;
        ArrayList arrayList = new ArrayList();
        d9.a aVar = this.f2319w0;
        if (aVar != null && (aVarO = aVar.o()) != null) {
            String strX0 = X0(w7.u.f14110k3);
            if (aVarO instanceof e9.c) {
                strX0 = X0(w7.u.f14220s1);
                zC = com.tuyafeng.support.utils.x.C(this.f2325p0.f0());
                z10 = true;
            } else {
                if (!(aVarO instanceof e9.b) || (iA = ((e9.b) aVarO).a()) == 0) {
                    zC = true;
                } else {
                    strX0 = X0(w7.u.f14206r1);
                    zC = com.tuyafeng.support.utils.x.C(iA);
                }
                z10 = false;
            }
            if (this.f2317u0.c()) {
                zC = this.f2317u0.d();
            }
            arrayList.add(f9.a.f(1).d(X0(w7.u.fd)).c(strX0).b(com.tuyafeng.support.utils.f.e(G(), w7.o.f13825r)).a());
            if (z10) {
                arrayList.add(f9.a.g(3).e(X0(w7.u.Xf), X0(w7.u.Yf)).c(X0(w7.u.Xf), X0(w7.u.Zf)).d(zC).b(com.tuyafeng.support.utils.f.e(G(), w7.o.f13848y1)).a());
                arrayList.add(f9.a.e(2).g(X0(w7.u.f14214r9)).b(com.tuyafeng.support.utils.f.e(G(), w7.o.f13828s)).d(0, 80).c(this.f2317u0.b()).f("%d%%").a());
                return arrayList;
            }
        }
        return arrayList;
    }

    @Override // c9.j
    public void U2(f9.a aVar, int i10) {
        super.U2(aVar, i10);
        int iB = aVar.b();
        if (iB == 1) {
            j3();
            return;
        }
        if (iB == 2) {
            this.f2317u0.h(((f9.b) aVar).j());
            this.f2324o0.r(this.f2317u0, true);
        } else {
            if (iB != 3) {
                return;
            }
            this.f2317u0.e(true);
            this.f2317u0.g(((f9.d) aVar).h());
            this.f2324o0.r(this.f2317u0, true);
        }
    }

    @Override // c9.j, androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        e9.a bVar;
        super.V1(view, bundle);
        String strD = this.f2325p0.d();
        if (strD == null || strD.isEmpty()) {
            int iF0 = this.f2325p0.f0();
            if (iF0 == -1) {
                iF0 = 0;
            }
            bVar = new e9.b(iF0, "Selected");
        } else {
            bVar = new e9.c();
        }
        this.f2320x0 = g3();
        this.f2318v0 = new t5.f(this.f2320x0);
        d9.a aVar = new d9.a(this.f2320x0);
        this.f2319w0 = aVar;
        aVar.u(bVar);
        this.f2319w0.j(new t5.g() { // from class: c9.b
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                this.f2310a.i3((e9.a) obj, i10);
            }
        });
        this.f2318v0.K(e9.a.class, this.f2319w0);
        this.f2326q0.n(new a());
        if ((w0() == null || !w0().containsKey("settings_search_target")) && !(bVar instanceof e9.c)) {
            this.f2326q0.post(new Runnable() { // from class: c9.c
                @Override // java.lang.Runnable
                public final void run() {
                    this.f2311c.j3();
                }
            });
        } else {
            l3();
        }
    }

    public final List g3() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new e9.b(0, X0(w7.u.f14110k3)));
        arrayList.add(new e9.c());
        arrayList.add(new e9.b(-13928247, "Classic blue"));
        arrayList.add(new e9.b(-13287859, "Indigo"));
        arrayList.add(new e9.b(-7707309, "Leather"));
        arrayList.add(new e9.b(-4162752, "Walnut"));
        arrayList.add(new e9.b(-1919870, "Birch"));
        arrayList.add(new e9.b(-11776948, "Limestone"));
        arrayList.add(new e9.b(-3848376, "Red"));
        arrayList.add(new e9.b(-482746, "Orange"));
        arrayList.add(new e9.b(-79799, "Yellow"));
        arrayList.add(new e9.b(-4931980, "Green"));
        arrayList.add(new e9.b(-9780028, "Cyan"));
        arrayList.add(new e9.b(-10391622, "Blue"));
        arrayList.add(new e9.b(-6592854, "Purple"));
        arrayList.add(new e9.b(-3432857, "Brown"));
        arrayList.add(new e9.b(-6578261, "Light grey"));
        arrayList.add(new e9.b(-9876171, "Maroon"));
        arrayList.add(new e9.b(-6801101, "Light Pink"));
        arrayList.add(new e9.b(-2519416, "Carnation"));
        arrayList.add(new e9.b(-2121393, "Hay"));
        arrayList.add(new e9.b(-10790341, "Tawny"));
        arrayList.add(new e9.b(-4480632, "Light brown"));
        arrayList.add(new e9.b(-10727322, "Deep purple"));
        return arrayList;
    }

    public final void i3(e9.a aVar, int i10) {
        if (aVar instanceof e9.c) {
            try {
                this.f2321y0.a(null);
                return;
            } catch (ActivityNotFoundException e10) {
                tc.a.e(e10);
                return;
            }
        }
        if (i10 == this.f2319w0.p() || !(aVar instanceof e9.b)) {
            return;
        }
        int iA = ((e9.b) aVar).a();
        h9.a.a(G());
        this.f2325p0.H1("");
        u9.l lVar = this.f2325p0;
        if (iA == 0) {
            iA = -1;
        }
        lVar.e0(iA);
        this.f2317u0.e(false);
        this.f2317u0.h(0);
        u9.n.e().u(true).t(true);
        this.f2324o0.r(this.f2317u0, false);
        this.f2324o0.w();
        this.f2324o0.p();
        this.f2319w0.t(this.f2318v0, i10);
        l3();
    }

    public final void j3() {
        RecyclerView recyclerView;
        if (this.f2318v0 == null || (recyclerView = this.f2326q0) == null || recyclerView.getLayoutManager() == null) {
            return;
        }
        int iCeil = (int) Math.ceil(this.f2326q0.getWidth() / com.tuyafeng.support.utils.x.h(G(), 56.0f));
        ((LinearLayoutPagerManager) this.f2326q0.getLayoutManager()).O2(Math.max(1, iCeil));
        this.f2326q0.setAdapter(this.f2318v0);
        this.f2326q0.p1(Math.max(0, this.f2319w0.p() - (iCeil / 2)));
    }

    public final void k3() {
        RecyclerView recyclerView;
        if (this.f2327r0 == null || (recyclerView = this.f2326q0) == null || recyclerView.getLayoutManager() == null) {
            return;
        }
        ((LinearLayoutPagerManager) this.f2326q0.getLayoutManager()).O2(5);
        this.f2326q0.setAdapter(this.f2327r0);
    }

    public final void l3() {
        Y2();
    }

    @Override // c9.j, androidx.fragment.app.Fragment
    public void w1(Bundle bundle) {
        super.w1(bundle);
        this.f2317u0 = this.f2324o0.k();
    }
}
