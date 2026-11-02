package f2;

import java.util.concurrent.Callable;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class o5 implements Callable {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f5545e;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ String f5546j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ String f5547k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ z5 f5548l;

    public o5(z5 z5Var, String str, String str2, String str3) {
        this.f5548l = z5Var;
        this.f5545e = str;
        this.f5546j = str2;
        this.f5547k = str3;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() {
        this.f5548l.f5871d.e();
        return this.f5548l.f5871d.V().a0(this.f5545e, this.f5546j, this.f5547k);
    }
}
