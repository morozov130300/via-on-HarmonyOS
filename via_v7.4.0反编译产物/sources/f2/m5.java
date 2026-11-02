package f2;

import java.util.concurrent.Callable;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class m5 implements Callable {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f5484e;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ String f5485j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ String f5486k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ z5 f5487l;

    public m5(z5 z5Var, String str, String str2, String str3) {
        this.f5487l = z5Var;
        this.f5484e = str;
        this.f5485j = str2;
        this.f5486k = str3;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() {
        this.f5487l.f5871d.e();
        return this.f5487l.f5871d.V().d0(this.f5484e, this.f5485j, this.f5486k);
    }
}
