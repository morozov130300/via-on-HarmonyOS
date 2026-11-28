package xb;

import okhttp3.t;
import okhttp3.z;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class h extends z {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f14685c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f14686e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final okio.e f14687m;

    public h(String str, long j10, okio.e eVar) {
        this.f14685c = str;
        this.f14686e = j10;
        this.f14687m = eVar;
    }

    @Override // okhttp3.z
    public long c() {
        return this.f14686e;
    }

    @Override // okhttp3.z
    public t e() {
        String str = this.f14685c;
        if (str != null) {
            return t.d(str);
        }
        return null;
    }

    @Override // okhttp3.z
    public okio.e h() {
        return this.f14687m;
    }
}
