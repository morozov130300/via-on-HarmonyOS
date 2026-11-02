package f2;

import java.util.concurrent.Callable;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class l5 implements Callable {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f5451e;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ String f5452j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ String f5453k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ z5 f5454l;

    public l5(z5 z5Var, String str, String str2, String str3) {
        this.f5454l = z5Var;
        this.f5451e = str;
        this.f5452j = str2;
        this.f5453k = str3;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() {
        this.f5454l.f5871d.e();
        return this.f5454l.f5871d.V().d0(this.f5451e, this.f5452j, this.f5453k);
    }
}
