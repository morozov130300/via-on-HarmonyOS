package g2;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class n5 implements Callable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f5139c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f5140e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ String f5141m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ z5 f5142n;

    public n5(z5 z5Var, String str, String str2, String str3) {
        this.f5142n = z5Var;
        this.f5139c = str;
        this.f5140e = str2;
        this.f5141m = str3;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() {
        this.f5142n.f5487d.e();
        return this.f5142n.f5487d.V().a0(this.f5139c, this.f5140e, this.f5141m);
    }
}
