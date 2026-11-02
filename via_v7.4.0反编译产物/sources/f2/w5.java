package f2;

import java.util.concurrent.Callable;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class w5 implements Callable {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f5787e;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ z5 f5788j;

    public w5(z5 z5Var, String str) {
        this.f5788j = z5Var;
        this.f5787e = str;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() {
        this.f5788j.f5871d.e();
        return this.f5788j.f5871d.V().c0(this.f5787e);
    }
}
