package o4;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import r4.d;
import r4.f;
import r4.g;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class c implements a {

    /* renamed from: a, reason: collision with root package name */
    public final Context f10357a;

    /* renamed from: b, reason: collision with root package name */
    public final List f10358b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final p4.b f10359c = new p4.b();

    /* renamed from: d, reason: collision with root package name */
    public final List f10360d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    public int f10361e = -1;

    /* renamed from: f, reason: collision with root package name */
    public int f10362f = 1;

    public c(Context context) {
        this.f10357a = context;
    }

    @Override // o4.a
    public void a() {
        r4.a aVarD = d();
        if (aVarD != null) {
            aVarD.a();
            aVarD.x();
        }
    }

    @Override // o4.a
    public boolean b(int i10) {
        int size = this.f10360d.size();
        if (i10 < 0 || i10 >= size) {
            return false;
        }
        int i11 = this.f10361e;
        if (i10 == i11) {
            j(i11 > 0 ? i11 - 1 : i11 < size - 1 ? i11 + 1 : -1);
        }
        int i12 = this.f10361e;
        if (i10 < i12) {
            this.f10361e = i12 - 1;
        }
        ((r4.a) this.f10360d.remove(i10)).h();
        v(i10);
        return true;
    }

    @Override // o4.a
    public List c() {
        return this.f10360d;
    }

    @Override // o4.a
    public r4.a d() {
        return k(this.f10361e);
    }

    @Override // o4.a
    public int e(int i10) {
        int size = this.f10360d.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (((r4.a) this.f10360d.get(i11)).getId() == i10) {
                return i11;
            }
        }
        return -1;
    }

    @Override // o4.a
    public void f() {
        r4.a aVarD = d();
        if (aVarD != null) {
            aVarD.f();
            aVarD.y();
        }
    }

    @Override // o4.a
    public r4.a g(g gVar, int i10, boolean z10) {
        if (i10 < 0) {
            i10 += this.f10360d.size() + 1;
        }
        if (i10 < 0 || i10 > this.f10360d.size()) {
            return null;
        }
        int i11 = this.f10362f;
        this.f10362f = i11 + 1;
        d dVarA = new d.b(i11).c(this.f10359c).b(this.f10357a).d(gVar).a();
        this.f10360d.add(i10, dVarA);
        t(i10);
        int i12 = this.f10361e;
        if (i10 <= i12) {
            this.f10361e = i12 + 1;
        }
        if (z10) {
            j(i10);
            return dVarA;
        }
        dVarA.k();
        return dVarA;
    }

    @Override // o4.a
    public void h() {
        this.f10359c.I();
        Iterator it = this.f10360d.iterator();
        while (it.hasNext()) {
            ((r4.a) it.next()).h();
        }
        this.f10360d.clear();
    }

    @Override // o4.a
    public int i() {
        return this.f10360d.size();
    }

    @Override // o4.a
    public boolean j(int i10) {
        int i11;
        if (i10 == this.f10361e) {
            return false;
        }
        r4.a aVarD = d();
        if (aVarD != null) {
            i11 = this.f10361e;
            aVarD.k();
            s(i11);
        } else {
            i11 = -1;
        }
        this.f10361e = i10;
        if (i10 < 0 || i10 >= this.f10360d.size()) {
            w(i11, this.f10361e);
            return false;
        }
        ((r4.a) this.f10360d.get(i10)).z();
        s(this.f10361e);
        w(i11, this.f10361e);
        return true;
    }

    @Override // o4.a
    public r4.a k(int i10) {
        if (i10 < 0 || i10 >= this.f10360d.size()) {
            return null;
        }
        return (r4.a) this.f10360d.get(i10);
    }

    @Override // o4.a
    public void l(p4.a aVar) {
        this.f10359c.G(aVar);
    }

    @Override // o4.a
    public int m() {
        return this.f10361e;
    }

    @Override // o4.a
    public r4.a n(int i10) {
        return k(e(i10));
    }

    @Override // o4.a
    public void o(f fVar) {
        this.f10358b.remove(fVar);
    }

    @Override // o4.a
    public boolean p(int i10, int i11) {
        if (i10 == i11 || i10 >= this.f10360d.size() || i10 < 0 || i11 < 0 || i11 >= this.f10360d.size()) {
            return false;
        }
        List list = this.f10360d;
        list.add(i11, list.remove(i10));
        int i12 = this.f10361e;
        if (i10 == i12) {
            this.f10361e = i11;
        } else if ((i10 >= i12 || i11 >= i12) && (i10 <= i12 || i11 <= i12)) {
            this.f10361e = i12 + (i10 < i11 ? -1 : 1);
        }
        u(i10, i11, this.f10361e);
        return true;
    }

    @Override // o4.a
    public t4.b q(int i10) {
        for (r4.a aVar : this.f10360d) {
            if (aVar.p() != null && i10 == aVar.p().getId()) {
                return aVar.p();
            }
        }
        return null;
    }

    @Override // o4.a
    public void r(f fVar) {
        this.f10358b.add(fVar);
    }

    public final void s(int i10) {
        if (i10 < 0 || i10 >= this.f10360d.size()) {
            return;
        }
        Iterator it = this.f10358b.iterator();
        while (it.hasNext()) {
            ((f) it.next()).f((r4.a) this.f10360d.get(i10), i10);
        }
    }

    public final void t(int i10) {
        if (i10 < 0 || i10 >= this.f10360d.size()) {
            return;
        }
        Iterator it = this.f10358b.iterator();
        while (it.hasNext()) {
            ((f) it.next()).b0((r4.a) this.f10360d.get(i10), i10);
        }
    }

    public final void u(int i10, int i11, int i12) {
        Iterator it = this.f10358b.iterator();
        while (it.hasNext()) {
            ((f) it.next()).G(i10, i11, i12);
        }
    }

    public final void v(int i10) {
        if (i10 < 0 || i10 > this.f10360d.size()) {
            return;
        }
        Iterator it = this.f10358b.iterator();
        while (it.hasNext()) {
            ((f) it.next()).H(i10);
        }
    }

    public final void w(int i10, int i11) {
        Iterator it = this.f10358b.iterator();
        while (it.hasNext()) {
            ((f) it.next()).a0(i10, i11);
        }
    }
}
