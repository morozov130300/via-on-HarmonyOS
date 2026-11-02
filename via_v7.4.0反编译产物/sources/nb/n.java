package nb;

import a6.c;
import a6.p;
import a6.q;
import a6.s;
import android.R;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import androidx.fragment.app.i0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.f;
import autodispose2.r;
import h6.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import mark.via.common.widget.v0;
import w5.k;
import x7.g0;
import x7.u;
import z8.r3;
import z8.u1;
import z8.u3;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class n extends o8.a {

    /* renamed from: m0, reason: collision with root package name */
    public RecyclerView f10310m0;

    /* renamed from: n0, reason: collision with root package name */
    public w9.l f10311n0;

    /* renamed from: o0, reason: collision with root package name */
    public pb.b f10312o0;

    /* renamed from: p0, reason: collision with root package name */
    public y5.f f10313p0;

    /* renamed from: q0, reason: collision with root package name */
    public long f10314q0;

    public static /* synthetic */ void U2(n nVar, List list) {
        nVar.getClass();
        if (list.isEmpty()) {
            g6.n.s(nVar.I(), nVar.Z0(u.yd));
            nVar.j3();
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            sb2.append(((rb.f) it.next()).a());
            sb2.append("\n");
        }
        g6.n.m(nVar.I(), nVar.Z0(u.zd), sb2.toString().trim());
    }

    public static /* synthetic */ List W2(n nVar, int i10) {
        if (i10 == 1) {
            return nVar.f10312o0.e(true);
        }
        if (i10 == 2) {
            return nVar.f10312o0.b(true);
        }
        if (i10 == 3) {
            return nVar.f10312o0.g(true);
        }
        if (i10 == 4) {
            return nVar.f10312o0.c(true);
        }
        nVar.getClass();
        return new ArrayList();
    }

    public static /* synthetic */ void X2(v0 v0Var) {
        r3.d(v0Var);
        r3.h(v0Var);
    }

    public static /* synthetic */ boolean a3(n nVar, View view, int i10, a6.a aVar) {
        nVar.o3();
        return true;
    }

    public static /* synthetic */ void b3(final n nVar, AdapterView adapterView, View view, int i10, long j10) {
        if (i10 == 0) {
            g6.n.e(nVar.I(), u.lg, u.Fd, new k.m() { // from class: nb.c
                @Override // w5.k.m
                public final void a(View view2, k.p pVar) {
                    this.f10294a.q3(2);
                }
            });
            return;
        }
        if (i10 == 1) {
            g6.n.e(nVar.I(), u.lg, u.Dd, new k.m() { // from class: nb.d
                @Override // w5.k.m
                public final void a(View view2, k.p pVar) {
                    this.f10295a.q3(4);
                }
            });
        } else if (i10 != 2) {
            nVar.getClass();
        } else {
            nVar.q3(1);
        }
    }

    public static /* synthetic */ void d3(n nVar, qb.f fVar, qb.a aVar, String str, Bundle bundle) {
        nVar.getClass();
        qb.f fVarA = qb.g.a(bundle);
        if (fVarA != null) {
            boolean z10 = (fVar != null && u1.a(fVar.c(), fVarA.c()) && u1.a(fVar.f(), fVarA.f())) ? false : true;
            String strI3 = (aVar == null || z10) ? nVar.i3() : aVar.d();
            if (z10 && aVar != null) {
                while (aVar.d().equals(strI3)) {
                    strI3 = nVar.i3();
                }
            }
            nVar.f10312o0.f(new qb.a(strI3, 1, aVar == null ? 81 : aVar.c(), fVarA));
            nVar.p3(nVar.h3());
        }
        nVar.N0().x("syncingDialogResult");
    }

    public static /* synthetic */ void g3(n nVar, qb.a aVar, int i10, View view, k.p pVar) {
        nVar.getClass();
        int[] iArr = pVar.f13337a;
        int i11 = 0;
        if (iArr != null && iArr.length > 0) {
            int length = iArr.length;
            int i12 = 0;
            while (i11 < length) {
                int i13 = iArr[i11];
                if (i13 == 0) {
                    i12 |= 64;
                } else if (i13 == 1) {
                    i12 |= 16;
                } else if (i13 == 2) {
                    i12 |= 32;
                }
                i11++;
            }
            i11 = i12;
        }
        qb.a aVar2 = new qb.a(aVar);
        aVar2.i(i11);
        nVar.f10312o0.f(aVar2);
        nVar.j3();
        if (i10 <= 0 || i11 <= 0) {
            return;
        }
        nVar.q3(i10);
    }

    private List h3() {
        String strZ0;
        qb.a aVarD = this.f10312o0.d();
        qb.f fVar = (aVarD == null || !(aVarD.e() instanceof qb.f)) ? null : (qb.f) aVarD.e();
        ArrayList arrayList = new ArrayList();
        int i10 = 1;
        int i11 = 0;
        boolean z10 = fVar == null || fVar.a();
        if (z10) {
            arrayList.add(new a6.a(2, Z0(u.Hd), Z0(u.N8), lb.b.a(I(), x7.o.X0, u.nf), Z0(u.sd), false, false));
        } else {
            long jA = this.f10312o0.a();
            if (fVar.f() == null || fVar.f().isEmpty()) {
                strZ0 = Z0(u.Hd);
            } else {
                int iMax = Math.max(0, fVar.f().length() - 3);
                if (iMax > 0) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(fVar.f().substring(0, fVar.f().length() - iMax));
                    while (iMax > 0) {
                        sb2.append('*');
                        iMax--;
                    }
                    strZ0 = a1(u.Id, sb2.toString());
                } else {
                    strZ0 = a1(u.Id, fVar.f());
                }
            }
            arrayList.add(new a6.a(2, strZ0, jA == 0 ? Z0(u.f13907a6) : a1(u.Jd, u3.a(I(), jA)), lb.b.a(I(), x7.o.X0, u.nf), Z0(u.sd), true));
        }
        arrayList.add(new a6.l(Z0(u.f14042k1)));
        arrayList.add(new a6.n(3, Z0(u.f14042k1), (String) null, aVarD != null && aVarD.g(), z10));
        int iB = aVarD == null ? 0 : aVarD.b();
        String[] strArr = new String[5];
        if (iB > 0) {
            if ((iB & 64) == 64) {
                strArr[0] = Z0(u.vd);
            } else {
                i10 = 0;
            }
            if ((iB & 16) == 16) {
                i11 = i10 + 1;
                strArr[i10] = Z0(u.ud);
            } else {
                i11 = i10;
            }
            if ((iB & 32) == 32) {
                strArr[i11] = Z0(u.xd);
                i11++;
            }
        }
        arrayList.add(new q(4, Z0(u.td), i11 == 0 ? Z0(u.wd) : TextUtils.join(Z0(u.f14030j3), Arrays.copyOf(strArr, i11)), z10));
        arrayList.add(new q(5, Z0(u.Ad), null, z10));
        return arrayList;
    }

    private void j3() {
        p3(h3());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k3(View view, int i10, a6.n nVar) {
        qb.a aVarD;
        if (nVar.c() != 3 || (aVarD = this.f10312o0.d()) == null) {
            return;
        }
        nVar.j(!nVar.i());
        aVarD.h(nVar.i());
        this.f10312o0.f(aVarD);
        this.f10313p0.m(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l3(View view, int i10, q qVar) {
        if (qVar.c() == 4) {
            m3(1);
        } else if (qVar.c() == 5) {
            o3();
        }
    }

    private void p3(List list) {
        f.e eVarB = androidx.recyclerview.widget.f.b(new a6.k(this.f10313p0.H(), list));
        this.f10313p0.M(list);
        eVarB.c(this.f10313p0);
    }

    @Override // androidx.fragment.app.Fragment
    public View C1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        RecyclerView recyclerView = (RecyclerView) new h6.a(new v0(I()), new FrameLayout.LayoutParams(-1, -1)).V(new a.InterfaceC0076a() { // from class: nb.a
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                n.X2((v0) obj);
            }
        }).l();
        this.f10310m0 = recyclerView;
        return recyclerView;
    }

    @Override // androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        this.f10310m0.setLayoutManager(new LinearLayoutManager(I()));
        this.f10310m0.setItemAnimator(new androidx.recyclerview.widget.e());
        this.f10313p0 = new y5.f(Collections.EMPTY_LIST);
        a6.c cVar = new a6.c();
        cVar.j(new y5.g() { // from class: nb.e
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                this.f10296a.n3();
            }
        });
        cVar.q(new c.InterfaceC0004c() { // from class: nb.f
            @Override // a6.c.InterfaceC0004c
            public final void a(View view2, int i10, a6.a aVar) {
                this.f10297a.q3(1);
            }
        });
        cVar.r(new c.d() { // from class: nb.g
            @Override // a6.c.d
            public final boolean a(View view2, int i10, a6.a aVar) {
                return n.a3(this.f10298a, view2, i10, aVar);
            }
        });
        this.f10313p0.K(a6.a.class, cVar);
        p pVar = new p();
        pVar.j(new y5.g() { // from class: nb.h
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                this.f10299a.k3(view2, i10, (a6.n) obj);
            }
        });
        this.f10313p0.K(a6.n.class, pVar);
        s sVar = new s();
        sVar.j(new y5.g() { // from class: nb.i
            @Override // y5.g
            public final void a(View view2, int i10, Object obj) {
                this.f10300a.l3(view2, i10, (q) obj);
            }
        });
        this.f10313p0.K(q.class, sVar);
        this.f10313p0.K(a6.l.class, new a6.m());
        this.f10310m0.setAdapter(this.f10313p0);
        j3();
    }

    public final String i3() {
        StringBuilder sb2 = new StringBuilder();
        Random random = new Random();
        for (int i10 = 0; i10 < 4; i10++) {
            sb2.append("abcdefghijklmnopqrstuvwxyz".charAt(random.nextInt(26)));
        }
        return sb2.toString();
    }

    public final void m3(final int i10) {
        final qb.a aVarD = this.f10312o0.d();
        if (aVarD == null) {
            return;
        }
        int iB = aVarD.b();
        int[] iArr = new int[3];
        int i11 = 0;
        if ((iB & 64) == 64) {
            iArr[0] = 0;
            i11 = 1;
        }
        if ((iB & 16) == 16) {
            iArr[i11] = 1;
            i11++;
        }
        if ((iB & 32) == 32) {
            iArr[i11] = 2;
            i11++;
        }
        w5.k.l(I()).e0(Z0(u.td)).L(new String[]{Z0(u.vd), Z0(u.ud), Z0(u.xd)}, Arrays.copyOf(iArr, i11)).V(R.string.ok, new k.m() { // from class: nb.l
            @Override // w5.k.m
            public final void a(View view, k.p pVar) {
                n.g3(this.f10305a, aVarD, i10, view, pVar);
            }
        }).N(R.string.cancel, null).f0();
    }

    public final void n3() {
        final qb.a aVarD = this.f10312o0.d();
        qb.e eVarE = aVarD == null ? null : aVarD.e();
        final qb.f fVar = eVarE instanceof qb.f ? (qb.f) eVarE : null;
        l0().L().y1("syncingDialogResult", this, new i0() { // from class: nb.k
            @Override // androidx.fragment.app.i0
            public final void a(String str, Bundle bundle) {
                n.d3(this.f10302a, fVar, aVarD, str, bundle);
            }
        });
        ob.l.l3(fVar).h3(z0(), ob.l.class.getSimpleName());
    }

    public final void o3() {
        w5.k.l(I()).d0(u.Ad).F(new String[]{Z0(u.Gd), Z0(u.Ed), Z0(u.Bd)}, new AdapterView.OnItemClickListener() { // from class: nb.j
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                n.b3(this.f10301a, adapterView, view, i10, j10);
            }
        }).f0();
    }

    public final void q3(final int i10) {
        if (this.f10312o0.d() == null || System.currentTimeMillis() - this.f10314q0 < 1000) {
            return;
        }
        this.f10314q0 = System.currentTimeMillis();
        if (this.f10312o0.d().b() == 0) {
            m3(i10);
        } else {
            ((r) x6.o.g(new Callable() { // from class: nb.m
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return n.W2(this.f10308e, i10);
                }
            }).l(g7.a.c()).j(w6.b.b()).m(u8.b.a(d1()))).a(new a7.e() { // from class: nb.b
                @Override // a7.e
                public final void accept(Object obj) {
                    n.U2(this.f10293e, (List) obj);
                }
            }, new g0());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void v1(Context context) {
        super.v1(context);
        pa.r.b(context).j(this);
    }
}
