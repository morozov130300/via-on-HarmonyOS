package f2;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class b5 extends FutureTask implements Comparable {

    /* renamed from: e, reason: collision with root package name */
    public final long f5050e;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f5051j;

    /* renamed from: k, reason: collision with root package name */
    public final String f5052k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ e5 f5053l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b5(e5 e5Var, Runnable runnable, boolean z10, String str) {
        super(runnable, null);
        this.f5053l = e5Var;
        t1.f.h(str);
        long andIncrement = e5.f5111l.getAndIncrement();
        this.f5050e = andIncrement;
        this.f5052k = str;
        this.f5051j = z10;
        if (andIncrement == Long.MAX_VALUE) {
            e5Var.f5030a.d().r().a("Tasks index overflow");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b5(e5 e5Var, Callable callable, boolean z10, String str) {
        super(callable);
        this.f5053l = e5Var;
        t1.f.h("Task exception on worker thread");
        long andIncrement = e5.f5111l.getAndIncrement();
        this.f5050e = andIncrement;
        this.f5052k = "Task exception on worker thread";
        this.f5051j = z10;
        if (andIncrement == Long.MAX_VALUE) {
            e5Var.f5030a.d().r().a("Tasks index overflow");
        }
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        b5 b5Var = (b5) obj;
        boolean z10 = this.f5051j;
        if (z10 != b5Var.f5051j) {
            return !z10 ? 1 : -1;
        }
        long j10 = this.f5050e;
        long j11 = b5Var.f5050e;
        if (j10 < j11) {
            return -1;
        }
        if (j10 > j11) {
            return 1;
        }
        this.f5053l.f5030a.d().t().b("Two tasks share the same index. index", Long.valueOf(this.f5050e));
        return 0;
    }

    @Override // java.util.concurrent.FutureTask
    public final void setException(Throwable th) {
        this.f5053l.f5030a.d().r().b(this.f5052k, th);
        super.setException(th);
    }
}
