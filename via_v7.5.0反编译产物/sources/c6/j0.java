package c6;

import com.tuyafeng.wormhole.HttpTextEncoding;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2037a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2038b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f2039c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f2040d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map f2041e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f2042f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final HttpTextEncoding f2043g;

    public j0(String url, String method, String str, int i10, Map headers, String str2, HttpTextEncoding responseEncoding) {
        kotlin.jvm.internal.h.f(url, "url");
        kotlin.jvm.internal.h.f(method, "method");
        kotlin.jvm.internal.h.f(headers, "headers");
        kotlin.jvm.internal.h.f(responseEncoding, "responseEncoding");
        this.f2037a = url;
        this.f2038b = method;
        this.f2039c = str;
        this.f2040d = i10;
        this.f2041e = headers;
        this.f2042f = str2;
        this.f2043g = responseEncoding;
        if (i10 <= 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
    }

    public final String a() {
        return this.f2042f;
    }

    public final Map b() {
        return this.f2041e;
    }

    public final String c() {
        return this.f2038b;
    }

    public final HttpTextEncoding d() {
        return this.f2043g;
    }

    public final int e() {
        return this.f2040d;
    }

    public final String f() {
        return this.f2037a;
    }

    public final String g() {
        return this.f2039c;
    }

    public /* synthetic */ j0(String str, String str2, String str3, int i10, Map map, String str4, HttpTextEncoding httpTextEncoding, int i11, kotlin.jvm.internal.f fVar) {
        this(str, (i11 & 2) != 0 ? "GET" : str2, (i11 & 4) != 0 ? null : str3, (i11 & 8) != 0 ? 30000 : i10, (i11 & 16) != 0 ? kotlin.collections.a.f() : map, (i11 & 32) == 0 ? str4 : null, (i11 & 64) != 0 ? HttpTextEncoding.UTF8 : httpTextEncoding);
    }
}
