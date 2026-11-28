package m8;

import androidx.activity.o;
import androidx.fragment.app.Fragment;
import com.tuyafeng.support.utils.x;
import com.tuyafeng.support.widget.d0;
import x8.j3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class h extends o {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Fragment f7954d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public d0 f7955e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f7956f;

    public h(Fragment fragment) {
        super(true);
        this.f7954d = fragment;
    }

    @Override // androidx.activity.o
    public final void c() {
        if (this.f7956f) {
            this.f7955e.q();
            this.f7956f = false;
        }
    }

    @Override // androidx.activity.o
    public final void d() {
        if (!this.f7956f) {
            n();
            return;
        }
        this.f7956f = false;
        if (o()) {
            this.f7955e.r();
        } else {
            this.f7955e.y();
            n();
        }
    }

    @Override // androidx.activity.o
    public final void e(androidx.activity.b bVar) {
        if (this.f7956f) {
            this.f7955e.B(bVar.a());
        }
    }

    @Override // androidx.activity.o
    public final void f(androidx.activity.b bVar) {
        if (!this.f7956f && j3.g(this.f7954d.G()) && l() && this.f7954d.a1() != null) {
            d0 d0VarM = m();
            this.f7955e = d0VarM;
            this.f7956f = d0VarM != null && d0VarM.z();
        }
    }

    public boolean l() {
        return true;
    }

    public final d0 m() {
        d0 d0Var;
        for (Fragment fragmentK0 = this.f7954d; fragmentK0 != null; fragmentK0 = fragmentK0.K0()) {
            if (fragmentK0.a1() != null && (d0Var = (d0) fragmentK0.a1().findViewById(x.f3593a)) != null) {
                return d0Var;
            }
        }
        return null;
    }

    public abstract void n();

    public abstract boolean o();
}
