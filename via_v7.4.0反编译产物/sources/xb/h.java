package xb;

import okhttp3.t;
import okhttp3.z;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class h extends z {

    /* renamed from: e, reason: collision with root package name */
    public final String f14339e;

    /* renamed from: j, reason: collision with root package name */
    public final long f14340j;

    /* renamed from: k, reason: collision with root package name */
    public final okio.e f14341k;

    public h(String str, long j10, okio.e eVar) {
        this.f14339e = str;
        this.f14340j = j10;
        this.f14341k = eVar;
    }

    @Override // okhttp3.z
    public long d() {
        return this.f14340j;
    }

    @Override // okhttp3.z
    public t f() {
        String str = this.f14339e;
        if (str != null) {
            return t.d(str);
        }
        return null;
    }

    @Override // okhttp3.z
    public okio.e i() {
        return this.f14341k;
    }
}
