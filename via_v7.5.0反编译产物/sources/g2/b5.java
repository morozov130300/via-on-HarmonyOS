package g2;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class b5 extends FutureTask implements Comparable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f4666c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f4667e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f4668m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ e5 f4669n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b5(e5 e5Var, Runnable runnable, boolean z10, String str) {
        super(runnable, null);
        this.f4669n = e5Var;
        u1.f.h(str);
        long andIncrement = e5.f4727l.getAndIncrement();
        this.f4666c = andIncrement;
        this.f4668m = str;
        this.f4667e = z10;
        if (andIncrement == Long.MAX_VALUE) {
            e5Var.f4646a.d().r().a("Tasks index overflow");
        }
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        b5 b5Var = (b5) obj;
        boolean z10 = this.f4667e;
        if (z10 != b5Var.f4667e) {
            return !z10 ? 1 : -1;
        }
        long j10 = this.f4666c;
        long j11 = b5Var.f4666c;
        if (j10 < j11) {
            return -1;
        }
        if (j10 > j11) {
            return 1;
        }
        this.f4669n.f4646a.d().t().b("Two tasks share the same index. index", Long.valueOf(this.f4666c));
        return 0;
    }

    @Override // java.util.concurrent.FutureTask
    public final void setException(Throwable th) {
        this.f4669n.f4646a.d().r().b(this.f4668m, th);
        super.setException(th);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b5(e5 e5Var, Callable callable, boolean z10, String str) {
        super(callable);
        this.f4669n = e5Var;
        u1.f.h("Task exception on worker thread");
        long andIncrement = e5.f4727l.getAndIncrement();
        this.f4666c = andIncrement;
        this.f4668m = "Task exception on worker thread";
        this.f4667e = z10;
        if (andIncrement == Long.MAX_VALUE) {
            e5Var.f4646a.d().r().a("Tasks index overflow");
        }
    }
}
