package o8;

import androidx.activity.o;
import androidx.fragment.app.Fragment;
import com.tuyafeng.support.widget.y;
import z8.n3;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class i extends o {

    /* renamed from: d, reason: collision with root package name */
    public final Fragment f10466d;

    /* renamed from: e, reason: collision with root package name */
    public y f10467e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f10468f;

    public i(Fragment fragment) {
        super(true);
        this.f10466d = fragment;
    }

    @Override // androidx.activity.o
    public final void c() {
        if (this.f10468f) {
            this.f10467e.q();
            this.f10468f = false;
        }
    }

    @Override // androidx.activity.o
    public final void d() {
        if (!this.f10468f) {
            n();
            return;
        }
        this.f10468f = false;
        if (o()) {
            this.f10467e.r();
        } else {
            this.f10467e.y();
            n();
        }
    }

    @Override // androidx.activity.o
    public final void e(androidx.activity.b bVar) {
        if (this.f10468f) {
            this.f10467e.A(bVar.a());
        }
    }

    @Override // androidx.activity.o
    public final void f(androidx.activity.b bVar) {
        if (!this.f10468f && n3.g(this.f10466d.I()) && l() && this.f10466d.c1() != null) {
            y yVarM = m();
            this.f10467e = yVarM;
            this.f10468f = yVarM != null && yVarM.z();
        }
    }

    public boolean l() {
        return true;
    }

    public final y m() {
        y yVar;
        for (Fragment fragmentM0 = this.f10466d; fragmentM0 != null; fragmentM0 = fragmentM0.M0()) {
            if (fragmentM0.c1() != null && (yVar = (y) fragmentM0.c1().findViewById(g6.y.f6242a)) != null) {
                return yVar;
            }
        }
        return null;
    }

    public abstract void n();

    public abstract boolean o();
}
