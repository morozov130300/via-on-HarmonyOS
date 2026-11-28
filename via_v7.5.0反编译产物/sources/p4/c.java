package p4;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import r4.d;
import r4.f;
import r4.g;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class c implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f11574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t4.b.e f11575b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f11576c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final q4.b f11577d = new q4.b();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List f11578e = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f11579f = -1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f11580g = 1;

    public c(Context context, t4.b.e eVar) {
        this.f11574a = context;
        this.f11575b = eVar;
    }

    @Override // p4.a
    public void a() {
        r4.a aVarD = d();
        if (aVarD != null) {
            aVarD.a();
            aVarD.w();
        }
    }

    @Override // p4.a
    public boolean b(int i10) {
        int i11;
        int size = this.f11578e.size();
        if (i10 < 0 || i10 >= size) {
            return false;
        }
        int i12 = this.f11579f;
        if (i10 == i12) {
            if (i12 > 0) {
                i11 = i12 - 1;
            } else {
                i11 = i12 < size - 1 ? i12 + 1 : -1;
            }
            j(i11);
        }
        int i13 = this.f11579f;
        if (i10 < i13) {
            this.f11579f = i13 - 1;
        }
        ((r4.a) this.f11578e.remove(i10)).h();
        v(i10);
        return true;
    }

    @Override // p4.a
    public List c() {
        return this.f11578e;
    }

    @Override // p4.a
    public r4.a d() {
        return k(this.f11579f);
    }

    @Override // p4.a
    public int e(int i10) {
        int size = this.f11578e.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (((r4.a) this.f11578e.get(i11)).getId() == i10) {
                return i11;
            }
        }
        return -1;
    }

    @Override // p4.a
    public void f() {
        r4.a aVarD = d();
        if (aVarD != null) {
            aVarD.f();
            aVarD.x();
        }
    }

    @Override // p4.a
    public r4.a g(g gVar, int i10, boolean z10) {
        if (i10 < 0) {
            i10 += this.f11578e.size() + 1;
        }
        if (i10 < 0 || i10 > this.f11578e.size()) {
            return null;
        }
        int i11 = this.f11580g;
        this.f11580g = i11 + 1;
        d dVarA = new d.b(i11).c(this.f11577d).b(this.f11574a).e(this.f11575b).d(gVar).a();
        this.f11578e.add(i10, dVarA);
        t(i10);
        int i12 = this.f11579f;
        if (i10 <= i12) {
            this.f11579f = i12 + 1;
        }
        if (z10) {
            j(i10);
            return dVarA;
        }
        dVarA.j();
        return dVarA;
    }

    @Override // p4.a
    public void h() {
        this.f11577d.L();
        Iterator it = this.f11578e.iterator();
        while (it.hasNext()) {
            ((r4.a) it.next()).h();
        }
        this.f11578e.clear();
    }

    @Override // p4.a
    public int i() {
        return this.f11578e.size();
    }

    @Override // p4.a
    public boolean j(int i10) {
        int i11;
        if (i10 == this.f11579f) {
            return false;
        }
        r4.a aVarD = d();
        if (aVarD != null) {
            i11 = this.f11579f;
            aVarD.j();
            s(i11);
        } else {
            i11 = -1;
        }
        this.f11579f = i10;
        if (i10 < 0 || i10 >= this.f11578e.size()) {
            w(i11, this.f11579f);
            return false;
        }
        ((r4.a) this.f11578e.get(i10)).y();
        s(this.f11579f);
        w(i11, this.f11579f);
        return true;
    }

    @Override // p4.a
    public r4.a k(int i10) {
        if (i10 < 0 || i10 >= this.f11578e.size()) {
            return null;
        }
        return (r4.a) this.f11578e.get(i10);
    }

    @Override // p4.a
    public int l() {
        return this.f11579f;
    }

    @Override // p4.a
    public r4.a m(int i10) {
        return k(e(i10));
    }

    @Override // p4.a
    public void n(q4.a aVar) {
        this.f11577d.J(aVar);
    }

    @Override // p4.a
    public void o(f fVar) {
        this.f11576c.remove(fVar);
    }

    @Override // p4.a
    public boolean p(int i10, int i11) {
        if (i10 == i11 || i10 >= this.f11578e.size() || i10 < 0 || i11 < 0 || i11 >= this.f11578e.size()) {
            return false;
        }
        List list = this.f11578e;
        list.add(i11, list.remove(i10));
        int i12 = this.f11579f;
        if (i10 == i12) {
            this.f11579f = i11;
        } else if ((i10 >= i12 || i11 >= i12) && (i10 <= i12 || i11 <= i12)) {
            this.f11579f = i12 + (i10 < i11 ? -1 : 1);
        }
        u(i10, i11, this.f11579f);
        return true;
    }

    @Override // p4.a
    public t4.b q(int i10) {
        for (r4.a aVar : this.f11578e) {
            if (aVar.o() != null && i10 == aVar.o().getId()) {
                return aVar.o();
            }
        }
        return null;
    }

    @Override // p4.a
    public void r(f fVar) {
        this.f11576c.add(fVar);
    }

    public final void s(int i10) {
        if (i10 < 0 || i10 >= this.f11578e.size()) {
            return;
        }
        Iterator it = this.f11576c.iterator();
        while (it.hasNext()) {
            ((f) it.next()).f((r4.a) this.f11578e.get(i10), i10);
        }
    }

    public final void t(int i10) {
        if (i10 < 0 || i10 >= this.f11578e.size()) {
            return;
        }
        Iterator it = this.f11576c.iterator();
        while (it.hasNext()) {
            ((f) it.next()).Y((r4.a) this.f11578e.get(i10), i10);
        }
    }

    public final void u(int i10, int i11, int i12) {
        Iterator it = this.f11576c.iterator();
        while (it.hasNext()) {
            ((f) it.next()).E(i10, i11, i12);
        }
    }

    public final void v(int i10) {
        if (i10 < 0 || i10 > this.f11578e.size()) {
            return;
        }
        Iterator it = this.f11576c.iterator();
        while (it.hasNext()) {
            ((f) it.next()).F(i10);
        }
    }

    public final void w(int i10, int i11) {
        Iterator it = this.f11576c.iterator();
        while (it.hasNext()) {
            ((f) it.next()).W(i10, i11);
        }
    }
}
