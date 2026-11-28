package g2;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class o5 implements Callable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f5161c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f5162e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ String f5163m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ z5 f5164n;

    public o5(z5 z5Var, String str, String str2, String str3) {
        this.f5164n = z5Var;
        this.f5161c = str;
        this.f5162e = str2;
        this.f5163m = str3;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() {
        this.f5164n.f5487d.e();
        return this.f5164n.f5487d.V().a0(this.f5161c, this.f5162e, this.f5163m);
    }
}
