package eb;

import androidx.lifecycle.LiveData;
import java.util.List;
import java.util.concurrent.Callable;
import mark.via.common.rx.AutoDisposeViewModel;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class b0 extends AutoDisposeViewModel {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ea.g f4331f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final androidx.lifecycle.n f4332g = new androidx.lifecycle.n();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final androidx.lifecycle.n f4333h = new androidx.lifecycle.n();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f4334i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f4335j;

    public b0(ea.g gVar) {
        this.f4331f = gVar;
    }

    public static /* synthetic */ void l(b0 b0Var, List list) {
        b0Var.f4332g.m(list);
        b0Var.f4333h.m(Boolean.valueOf(list.isEmpty()));
    }

    public static /* synthetic */ boolean m(b0 b0Var, long j10, List list) {
        return j10 == b0Var.f4335j;
    }

    public static /* synthetic */ void o(b0 b0Var, List list) {
        b0Var.f4334i = true;
        b0Var.f4332g.m(list);
        b0Var.f4333h.m(Boolean.valueOf(list.isEmpty()));
    }

    public static /* synthetic */ boolean q(b0 b0Var, long j10, List list) {
        return j10 == b0Var.f4335j;
    }

    public LiveData r() {
        return this.f4332g;
    }

    public void s() {
        this.f4335j++;
    }

    public LiveData t() {
        return this.f4333h;
    }

    public void u() {
        final long j10 = this.f4335j + 1;
        this.f4335j = j10;
        ((autodispose2.m) r6.q.f(new Callable() { // from class: eb.y
            @Override // java.util.concurrent.Callable
            public final Object call() {
                b0 b0Var = this.f4384c;
                return b0Var.f4331f.b(b0Var.f4334i);
            }
        }).k(a7.a.c()).i(q6.b.b()).d(new u6.i() { // from class: eb.z
            @Override // u6.i
            public final boolean test(Object obj) {
                return b0.q(this.f4385c, j10, (List) obj);
            }
        }).p(s8.b.c(this))).a(new u6.f() { // from class: eb.a0
            @Override // u6.f
            public final void accept(Object obj) {
                b0.o(this.f4329c, (List) obj);
            }
        }, new w7.a0());
    }

    public l9.d v(int i10) {
        List list = (List) this.f4332g.e();
        if (list == null || i10 < 0 || i10 >= list.size()) {
            return null;
        }
        l9.d dVar = (l9.d) list.remove(i10);
        this.f4331f.a(dVar);
        if (list.isEmpty()) {
            this.f4333h.m(Boolean.TRUE);
        }
        return dVar;
    }

    public void w(final String str) {
        if (str == null || str.length() == 0) {
            u();
            return;
        }
        final long j10 = this.f4335j + 1;
        this.f4335j = j10;
        ((autodispose2.m) r6.q.f(new Callable() { // from class: eb.v
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f4379c.f4331f.c(str);
            }
        }).k(a7.a.c()).i(q6.b.b()).d(new u6.i() { // from class: eb.w
            @Override // u6.i
            public final boolean test(Object obj) {
                return b0.m(this.f4381c, j10, (List) obj);
            }
        }).p(s8.b.c(this))).a(new u6.f() { // from class: eb.x
            @Override // u6.f
            public final void accept(Object obj) {
                b0.l(this.f4383c, (List) obj);
            }
        }, new w7.a0());
    }
}
