package g2;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class l5 implements Callable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f5067c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f5068e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ String f5069m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ z5 f5070n;

    public l5(z5 z5Var, String str, String str2, String str3) {
        this.f5070n = z5Var;
        this.f5067c = str;
        this.f5068e = str2;
        this.f5069m = str3;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() {
        this.f5070n.f5487d.e();
        return this.f5070n.f5487d.V().d0(this.f5067c, this.f5068e, this.f5069m);
    }
}
