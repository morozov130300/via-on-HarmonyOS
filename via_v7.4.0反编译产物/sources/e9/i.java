package e9;

import android.content.ActivityNotFoundException;
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
import x7.c0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class i extends k {

    /* renamed from: s0, reason: collision with root package name */
    public i9.a f4901s0;

    /* renamed from: t0, reason: collision with root package name */
    public y5.f f4902t0;

    /* renamed from: u0, reason: collision with root package name */
    public f9.a f4903u0;

    /* renamed from: v0, reason: collision with root package name */
    public List f4904v0;

    /* renamed from: w0, reason: collision with root package name */
    public final androidx.activity.result.b f4905w0 = y2(new x5.e(), new androidx.activity.result.a() { // from class: e9.a
        @Override // androidx.activity.result.a
        public final void a(Object obj) {
            i iVar = this.f4893a;
            ((autodispose2.m) z8.b.c(iVar.I(), (Uri) obj, "bg", ".png").k(w6.b.b()).p(u8.b.a(iVar.d1()))).a(new a7.e() { // from class: e9.e
                @Override // a7.e
                public final void accept(Object obj2) {
                    i.e3(iVar, (String) obj2);
                }
            }, new c0());
        }
    });

    public static /* synthetic */ void b3(i iVar, String str) {
        j9.a.a(iVar.I());
        j9.a.c(iVar.I(), str);
        d9.t tVar = iVar.f4907m0;
        Objects.requireNonNull(tVar);
        z8.h.d(iVar, new h(tVar));
    }

    public static /* synthetic */ void e3(final i iVar, final String str) {
        iVar.getClass();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 8;
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(str, options);
        int i10 = 0;
        if (bitmapDecodeFile == null || bitmapDecodeFile.getWidth() == 0 || bitmapDecodeFile.getHeight() == 0) {
            iVar.f4908n0.b0(-1);
            iVar.f4908n0.F1(null);
            iVar.f4901s0.e(false);
            iVar.f4901s0.h(0);
            iVar.f4907m0.r(iVar.f4901s0, false);
            z8.h.b(new Runnable() { // from class: e9.f
                @Override // java.lang.Runnable
                public final void run() {
                    i.h3(this.f4897e);
                }
            });
        } else {
            int pixel = bitmapDecodeFile.getPixel(0, 0);
            w9.l lVar = iVar.f4908n0;
            if (pixel == 0) {
                pixel = -16777216;
            }
            lVar.b0(pixel);
            iVar.f4908n0.F1(str);
            iVar.f4901s0.e(false);
            iVar.f4907m0.r(iVar.f4901s0, false);
            z8.h.b(new Runnable() { // from class: e9.g
                @Override // java.lang.Runnable
                public final void run() {
                    i.b3(this.f4898e, str);
                }
            });
            i10 = 1;
        }
        w9.n.e().w(true).v(true);
        iVar.f4907m0.p();
        iVar.f4903u0.t(iVar.f4902t0, i10);
        iVar.m3();
        iVar.l3();
    }

    public static /* synthetic */ boolean f3(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            view.getParent().requestDisallowInterceptTouchEvent(view.canScrollHorizontally(-1));
            return false;
        }
        if (action != 1) {
            return false;
        }
        view.getParent().requestDisallowInterceptTouchEvent(false);
        return false;
    }

    public static /* synthetic */ void h3(i iVar) {
        j9.a.a(iVar.I());
        d9.t tVar = iVar.f4907m0;
        Objects.requireNonNull(tVar);
        z8.h.d(iVar, new h(tVar));
    }

    @Override // e9.k
    public List V2() {
        g9.a aVarO;
        boolean zC;
        boolean z10;
        int iA;
        ArrayList arrayList = new ArrayList();
        f9.a aVar = this.f4903u0;
        if (aVar != null && (aVarO = aVar.o()) != null) {
            String strZ0 = Z0(x7.u.Y2);
            if (aVarO instanceof g9.c) {
                strZ0 = Z0(x7.u.f14098o1);
                zC = g6.y.C(this.f4908n0.c0());
                z10 = true;
            } else {
                if (!(aVarO instanceof g9.b) || (iA = ((g9.b) aVarO).a()) == 0) {
                    zC = true;
                } else {
                    strZ0 = Z0(x7.u.f14084n1);
                    zC = g6.y.C(iA);
                }
                z10 = false;
            }
            if (this.f4901s0.c()) {
                zC = this.f4901s0.d();
            }
            arrayList.add(h9.a.f(1).d(Z0(x7.u.Qc)).c(strZ0).b(g6.f.e(I(), x7.o.f13762s)).a());
            if (z10) {
                arrayList.add(h9.a.g(3).e(Z0(x7.u.Hf), Z0(x7.u.If)).c(Z0(x7.u.Hf), Z0(x7.u.Jf)).d(zC).b(g6.f.e(I(), x7.o.A1)).a());
                arrayList.add(h9.a.e(2).g(Z0(x7.u.f13994g9)).b(g6.f.e(I(), x7.o.f13765t)).d(0, 80).c(this.f4901s0.b()).f("%d%%").a());
                return arrayList;
            }
        }
        return arrayList;
    }

    @Override // e9.k
    public void W2(h9.a aVar, int i10) {
        super.W2(aVar, i10);
        int iB = aVar.b();
        if (iB == 1) {
            k3();
            return;
        }
        if (iB == 2) {
            this.f4901s0.h(((h9.b) aVar).j());
            this.f4907m0.r(this.f4901s0, true);
        } else {
            if (iB != 3) {
                return;
            }
            this.f4901s0.e(true);
            this.f4901s0.g(((h9.d) aVar).h());
            this.f4907m0.r(this.f4901s0, true);
        }
    }

    @Override // e9.k, androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        g9.a bVar;
        super.X1(view, bundle);
        String strC = this.f4908n0.c();
        if (strC == null || strC.isEmpty()) {
            int iC0 = this.f4908n0.c0();
            if (iC0 == -1) {
                iC0 = 0;
            }
            bVar = new g9.b(iC0, "Selected");
        } else {
            bVar = new g9.c();
        }
        this.f4904v0 = i3();
        this.f4902t0 = new y5.f(this.f4904v0);
        f9.a aVar = new f9.a(this.f4904v0);
        this.f4903u0 = aVar;
        aVar.u(bVar);
        this.f4903u0.j(new y5.g() { // from class: e9.b
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                this.f4894a.j3((g9.a) obj, i10);
            }
        });
        this.f4902t0.K(g9.a.class, this.f4903u0);
        this.f4909o0.setOnTouchListener(new View.OnTouchListener() { // from class: e9.c
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                return i.f3(view2, motionEvent);
            }
        });
        if (bVar instanceof g9.c) {
            m3();
        } else {
            this.f4909o0.post(new Runnable() { // from class: e9.d
                @Override // java.lang.Runnable
                public final void run() {
                    this.f4895e.k3();
                }
            });
        }
    }

    public final List i3() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new g9.b(0, Z0(x7.u.Y2)));
        arrayList.add(new g9.c());
        arrayList.add(new g9.b(-13928247, "Classic blue"));
        arrayList.add(new g9.b(-13287859, "Indigo"));
        arrayList.add(new g9.b(-7707309, "Leather"));
        arrayList.add(new g9.b(-4162752, "Walnut"));
        arrayList.add(new g9.b(-1919870, "Birch"));
        arrayList.add(new g9.b(-11776948, "Limestone"));
        arrayList.add(new g9.b(-3848376, "Red"));
        arrayList.add(new g9.b(-482746, "Orange"));
        arrayList.add(new g9.b(-79799, "Yellow"));
        arrayList.add(new g9.b(-4931980, "Green"));
        arrayList.add(new g9.b(-9780028, "Cyan"));
        arrayList.add(new g9.b(-10391622, "Blue"));
        arrayList.add(new g9.b(-6592854, "Purple"));
        arrayList.add(new g9.b(-3432857, "Brown"));
        arrayList.add(new g9.b(-6578261, "Light grey"));
        arrayList.add(new g9.b(-9876171, "Maroon"));
        arrayList.add(new g9.b(-6801101, "Light Pink"));
        arrayList.add(new g9.b(-2519416, "Carnation"));
        arrayList.add(new g9.b(-2121393, "Hay"));
        arrayList.add(new g9.b(-10790341, "Tawny"));
        arrayList.add(new g9.b(-4480632, "Light brown"));
        arrayList.add(new g9.b(-10727322, "Deep purple"));
        return arrayList;
    }

    public final void j3(g9.a aVar, int i10) {
        if (aVar instanceof g9.c) {
            try {
                this.f4905w0.a(null);
                return;
            } catch (ActivityNotFoundException e10) {
                pc.a.d(e10);
                return;
            }
        }
        if (i10 == this.f4903u0.p() || !(aVar instanceof g9.b)) {
            return;
        }
        int iA = ((g9.b) aVar).a();
        j9.a.a(I());
        this.f4908n0.F1("");
        w9.l lVar = this.f4908n0;
        if (iA == 0) {
            iA = -1;
        }
        lVar.b0(iA);
        this.f4901s0.e(false);
        this.f4901s0.h(0);
        w9.n.e().w(true).v(true);
        this.f4907m0.r(this.f4901s0, false);
        this.f4907m0.w();
        this.f4907m0.p();
        this.f4903u0.t(this.f4902t0, i10);
        m3();
    }

    public final void k3() {
        RecyclerView recyclerView;
        if (this.f4902t0 == null || (recyclerView = this.f4909o0) == null || recyclerView.getLayoutManager() == null) {
            return;
        }
        int iCeil = (int) Math.ceil(this.f4909o0.getWidth() / g6.y.h(I(), 56.0f));
        ((LinearLayoutPagerManager) this.f4909o0.getLayoutManager()).O2(Math.max(1, iCeil));
        this.f4909o0.setAdapter(this.f4902t0);
        this.f4909o0.p1(Math.max(0, this.f4903u0.p() - (iCeil / 2)));
    }

    public final void l3() {
        RecyclerView recyclerView;
        if (this.f4910p0 == null || (recyclerView = this.f4909o0) == null || recyclerView.getLayoutManager() == null) {
            return;
        }
        ((LinearLayoutPagerManager) this.f4909o0.getLayoutManager()).O2(5);
        this.f4909o0.setAdapter(this.f4910p0);
    }

    public final void m3() {
        a3();
    }

    @Override // e9.k, androidx.fragment.app.Fragment
    public void y1(Bundle bundle) {
        super.y1(bundle);
        this.f4901s0 = this.f4907m0.k();
    }
}
