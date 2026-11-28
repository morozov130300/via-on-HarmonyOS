package g2;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class fa implements x3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f4808a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ pa f4809b;

    public fa(pa paVar, String str) {
        this.f4809b = paVar;
        this.f4808a = str;
    }

    @Override // g2.x3
    public final void a(String str, int i10, Throwable th, byte[] bArr, Map map) {
        this.f4809b.p(i10, th, bArr, this.f4808a);
    }
}
