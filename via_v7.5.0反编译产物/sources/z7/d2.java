package z7;

import androidx.lifecycle.LiveData;
import java.util.Objects;
import java.util.concurrent.Callable;
import mark.via.common.rx.AutoDisposeViewModel;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class d2 extends AutoDisposeViewModel {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final m9.c f15238f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final androidx.lifecycle.n f15239g = new androidx.lifecycle.n();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f15240h;

    public d2(m9.c cVar) {
        this.f15238f = cVar;
    }

    public LiveData m() {
        return this.f15239g;
    }

    public String n() {
        return this.f15240h;
    }

    public void o(final String str) {
        this.f15240h = str;
        autodispose2.r rVar = (autodispose2.r) r6.q.f(new Callable() { // from class: z7.c2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return d.b(this.f15225c.f15238f.j(), str);
            }
        }).k(a7.a.c()).i(q6.b.b()).l(s8.b.c(this));
        androidx.lifecycle.n nVar = this.f15239g;
        Objects.requireNonNull(nVar);
        rVar.a(new j0(nVar), new w7.e0());
    }

    public void p(String str) {
        this.f15240h = str;
    }
}
