package g2;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class m5 implements Callable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f5100c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f5101e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ String f5102m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ z5 f5103n;

    public m5(z5 z5Var, String str, String str2, String str3) {
        this.f5103n = z5Var;
        this.f5100c = str;
        this.f5101e = str2;
        this.f5102m = str3;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() {
        this.f5103n.f5487d.e();
        return this.f5103n.f5487d.V().d0(this.f5100c, this.f5101e, this.f5102m);
    }
}
