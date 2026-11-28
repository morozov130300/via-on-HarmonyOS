package nb;

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
import autodispose2.r;
import hb.a7;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import mark.via.common.widget.v0;
import mark.via.settings.search.SettingsSearchLocator;
import v5.p;
import v5.q;
import v5.s;
import w7.e0;
import w7.u;
import x8.r3;
import x8.t1;
import x8.u3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class n extends m8.a {

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public RecyclerView f10840o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public u9.l f10841p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public pb.b f10842q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public t5.f f10843r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public long f10844s0;

    public static /* synthetic */ void S2(n nVar, List list) {
        nVar.getClass();
        if (list.isEmpty()) {
            com.tuyafeng.support.utils.n.s(nVar.G(), nVar.X0(u.Od));
            nVar.i3();
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            sb2.append(((rb.f) it.next()).a());
            sb2.append("\n");
        }
        com.tuyafeng.support.utils.n.m(nVar.G(), nVar.X0(u.Pd), sb2.toString().trim());
    }

    public static /* synthetic */ List U2(n nVar, int i10) {
        if (i10 == 1) {
            return nVar.f10842q0.e(true);
        }
        if (i10 == 2) {
            return nVar.f10842q0.b(true);
        }
        if (i10 == 3) {
            return nVar.f10842q0.g(true);
        }
        if (i10 == 4) {
            return nVar.f10842q0.c(true);
        }
        nVar.getClass();
        return new ArrayList();
    }

    public static /* synthetic */ void V2(v0 v0Var) {
        r3.e(v0Var);
        r3.i(v0Var);
    }

    public static /* synthetic */ boolean Y2(n nVar, View view, int i10, v5.a aVar) {
        nVar.n3();
        return true;
    }

    public static /* synthetic */ void Z2(final n nVar, AdapterView adapterView, View view, int i10, long j10) {
        if (i10 == 0) {
            com.tuyafeng.support.utils.n.e(nVar.G(), u.Ag, u.Vd, new q5.k.m() { // from class: nb.c
                @Override // q5.k.m
                public final void a(View view2, q5.k.p pVar) {
                    this.f10825a.p3(2);
                }
            });
            return;
        }
        if (i10 == 1) {
            com.tuyafeng.support.utils.n.e(nVar.G(), u.Ag, u.Td, new q5.k.m() { // from class: nb.d
                @Override // q5.k.m
                public final void a(View view2, q5.k.p pVar) {
                    this.f10826a.p3(4);
                }
            });
        } else if (i10 != 2) {
            nVar.getClass();
        } else {
            nVar.p3(1);
        }
    }

    public static /* synthetic */ void b3(n nVar, qb.f fVar, qb.a aVar, String str, Bundle bundle) {
        nVar.getClass();
        qb.f fVarA = qb.g.a(bundle);
        if (fVarA != null) {
            boolean z10 = (fVar != null && t1.a(fVar.c(), fVarA.c()) && t1.a(fVar.f(), fVarA.f())) ? false : true;
            String strG3 = (aVar == null || z10) ? nVar.g3() : aVar.d();
            if (z10 && aVar != null) {
                while (aVar.d().equals(strG3)) {
                    strG3 = nVar.g3();
                }
            }
            nVar.f10842q0.f(new qb.a(strG3, 1, aVar == null ? 81 : aVar.c(), fVarA));
            nVar.o3(nVar.f3());
        }
        nVar.L0().x("syncingDialogResult");
    }

    public static /* synthetic */ void e3(n nVar, qb.a aVar, int i10, View view, q5.k.p pVar) {
        nVar.getClass();
        int[] iArr = pVar.f11817a;
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
        nVar.f10842q0.f(aVar2);
        nVar.i3();
        if (i10 <= 0 || i11 <= 0) {
            return;
        }
        nVar.p3(i10);
    }

    private List f3() {
        String strX0;
        qb.a aVarD = this.f10842q0.d();
        qb.f fVar = (aVarD == null || !(aVarD.e() instanceof qb.f)) ? null : (qb.f) aVarD.e();
        ArrayList arrayList = new ArrayList();
        int i10 = 1;
        int i11 = 0;
        boolean z10 = fVar == null || fVar.a();
        if (z10) {
            arrayList.add(new v5.a(2, X0(u.Xd), X0(u.Z8), lb.g.a(G(), w7.o.V0, u.Ef), X0(u.Id), false, false));
        } else {
            long jA = this.f10842q0.a();
            if (fVar.f() == null || fVar.f().isEmpty()) {
                strX0 = X0(u.Xd);
            } else {
                int iMax = Math.max(0, fVar.f().length() - 3);
                if (iMax > 0) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(fVar.f().substring(0, fVar.f().length() - iMax));
                    while (iMax > 0) {
                        sb2.append('*');
                        iMax--;
                    }
                    strX0 = Y0(u.Yd, sb2.toString());
                } else {
                    strX0 = Y0(u.Yd, fVar.f());
                }
            }
            arrayList.add(new v5.a(2, strX0, jA == 0 ? X0(u.f14141m6) : Y0(u.Zd, u3.a(G(), jA)), lb.g.a(G(), w7.o.V0, u.Ef), X0(u.Id), true));
        }
        arrayList.add(new v5.l(X0(u.f14150n1)));
        arrayList.add(new v5.n(3, X0(u.f14150n1), (String) null, aVarD != null && aVarD.g(), z10));
        int iB = aVarD == null ? 0 : aVarD.b();
        String[] strArr = new String[5];
        if (iB > 0) {
            if ((iB & 64) == 64) {
                strArr[0] = X0(u.Ld);
            } else {
                i10 = 0;
            }
            if ((iB & 16) == 16) {
                i11 = i10 + 1;
                strArr[i10] = X0(u.Kd);
            } else {
                i11 = i10;
            }
            if ((iB & 32) == 32) {
                strArr[i11] = X0(u.Nd);
                i11++;
            }
        }
        arrayList.add(new q(4, X0(u.Jd), i11 == 0 ? X0(u.Md) : TextUtils.join(X0(u.f14263v3), Arrays.copyOf(strArr, i11)), z10));
        arrayList.add(new q(5, X0(u.Qd), null, z10));
        return arrayList;
    }

    public static List h3(Context context) {
        Bundle bundle = new Bundle();
        bundle.putInt("settings_search_sync_mode", 1);
        mark.via.settings.search.h hVar = new mark.via.settings.search.h(context, a7.class, bundle, u.Fc, u.Id, u.Xd);
        hVar.c("mark.via.syncing.SyncingFragment.2", 2, u.Xd, new String[0]);
        hVar.c("mark.via.syncing.SyncingFragment.3", 3, u.f14150n1, new String[0]);
        hVar.c("mark.via.syncing.SyncingFragment.4", 4, u.Jd, new String[0]);
        hVar.c("mark.via.syncing.SyncingFragment.5", 5, u.Qd, new String[0]);
        return hVar.f();
    }

    private void i3() {
        o3(f3());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j3(View view, int i10, v5.n nVar) {
        qb.a aVarD;
        if (nVar.c() != 3 || (aVarD = this.f10842q0.d()) == null) {
            return;
        }
        nVar.j(!nVar.i());
        aVarD.h(nVar.i());
        this.f10842q0.f(aVarD);
        this.f10843r0.m(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k3(View view, int i10, q qVar) {
        if (qVar.c() == 4) {
            l3(1);
        } else if (qVar.c() == 5) {
            n3();
        }
    }

    private void o3(List list) {
        androidx.recyclerview.widget.f.e eVarB = androidx.recyclerview.widget.f.b(new v5.k(this.f10843r0.H(), list));
        this.f10843r0.M(list);
        eVarB.c(this.f10843r0);
    }

    @Override // androidx.fragment.app.Fragment
    public View A1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        RecyclerView recyclerView = (RecyclerView) new b6.a(new v0(G()), new FrameLayout.LayoutParams(-1, -1)).V(new b6.a.InterfaceC0033a() { // from class: nb.k
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                n.V2((v0) obj);
            }
        }).l();
        this.f10840o0 = recyclerView;
        return recyclerView;
    }

    @Override // androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        this.f10840o0.setLayoutManager(new LinearLayoutManager(G()));
        this.f10840o0.setItemAnimator(new androidx.recyclerview.widget.e());
        this.f10843r0 = new t5.f(Collections.EMPTY_LIST);
        v5.c cVar = new v5.c();
        cVar.j(new t5.g() { // from class: nb.a
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                this.f10823a.m3();
            }
        });
        cVar.q(new v5.c.InterfaceC0150c() { // from class: nb.e
            @Override // v5.c.InterfaceC0150c
            public final void a(View view2, int i10, v5.a aVar) {
                this.f10827a.p3(1);
            }
        });
        cVar.r(new v5.c.d() { // from class: nb.f
            @Override // v5.c.d
            public final boolean a(View view2, int i10, v5.a aVar) {
                return n.Y2(this.f10828a, view2, i10, aVar);
            }
        });
        this.f10843r0.K(v5.a.class, cVar);
        p pVar = new p();
        pVar.j(new t5.g() { // from class: nb.g
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                this.f10829a.j3(view2, i10, (v5.n) obj);
            }
        });
        this.f10843r0.K(v5.n.class, pVar);
        s sVar = new s();
        sVar.j(new t5.g() { // from class: nb.h
            @Override // t5.g
            public final void a(View view2, int i10, Object obj) {
                this.f10830a.k3(view2, i10, (q) obj);
            }
        });
        this.f10843r0.K(q.class, sVar);
        this.f10843r0.K(v5.l.class, new v5.m());
        this.f10840o0.setAdapter(this.f10843r0);
        SettingsSearchLocator.b(this, this.f10840o0);
        i3();
    }

    public final String g3() {
        StringBuilder sb2 = new StringBuilder();
        Random random = new Random();
        for (int i10 = 0; i10 < 4; i10++) {
            sb2.append("abcdefghijklmnopqrstuvwxyz".charAt(random.nextInt(26)));
        }
        return sb2.toString();
    }

    public final void l3(final int i10) {
        final qb.a aVarD = this.f10842q0.d();
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
        q5.k.l(G()).g0(X0(u.Jd)).M(new String[]{X0(u.Ld), X0(u.Kd), X0(u.Nd)}, Arrays.copyOf(iArr, i11)).X(R.string.ok, new q5.k.m() { // from class: nb.l
            @Override // q5.k.m
            public final void a(View view, q5.k.p pVar) {
                n.e3(this.f10835a, aVarD, i10, view, pVar);
            }
        }).P(R.string.cancel, null).h0();
    }

    public final void m3() {
        final qb.a aVarD = this.f10842q0.d();
        qb.e eVarE = aVarD == null ? null : aVarD.e();
        final qb.f fVar = eVarE instanceof qb.f ? (qb.f) eVarE : null;
        i0().K().z1("syncingDialogResult", this, new i0() { // from class: nb.j
            @Override // androidx.fragment.app.i0
            public final void a(String str, Bundle bundle) {
                n.b3(this.f10832a, fVar, aVarD, str, bundle);
            }
        });
        ob.l.l3(fVar).g3(x0(), ob.l.class.getSimpleName());
    }

    public final void n3() {
        q5.k.l(G()).f0(u.Qd).G(new String[]{X0(u.Wd), X0(u.Ud), X0(u.Rd)}, new AdapterView.OnItemClickListener() { // from class: nb.i
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                n.Z2(this.f10831a, adapterView, view, i10, j10);
            }
        }).h0();
    }

    public final void p3(final int i10) {
        if (this.f10842q0.d() == null || System.currentTimeMillis() - this.f10844s0 < 1000) {
            return;
        }
        this.f10844s0 = System.currentTimeMillis();
        if (this.f10842q0.d().b() == 0) {
            l3(i10);
        } else {
            ((r) r6.q.f(new Callable() { // from class: nb.m
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return n.U2(this.f10838c, i10);
                }
            }).k(a7.a.c()).i(q6.b.b()).l(s8.b.a(b1()))).a(new u6.f() { // from class: nb.b
                @Override // u6.f
                public final void accept(Object obj) {
                    n.S2(this.f10824c, (List) obj);
                }
            }, new e0());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void t1(Context context) {
        super.t1(context);
        la.s.b(context).i(this);
    }
}
