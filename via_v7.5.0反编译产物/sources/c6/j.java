package c6;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2034a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2035b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f2036c;

    public j(String url, String title, long j10) {
        kotlin.jvm.internal.h.f(url, "url");
        kotlin.jvm.internal.h.f(title, "title");
        this.f2034a = url;
        this.f2035b = title;
        this.f2036c = j10;
    }

    public final String a() {
        return this.f2035b;
    }

    public final String b() {
        return this.f2034a;
    }

    public final long c() {
        return this.f2036c;
    }
}
