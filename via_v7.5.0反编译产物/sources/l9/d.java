package l9;

import android.net.Uri;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Uri f7525a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f7526b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f7527c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f7528d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f7529e;

    public d(Uri uri) {
        this(uri, null, null, 0L);
    }

    public Uri a() {
        return this.f7525a;
    }

    public long b() {
        return this.f7529e;
    }

    public String c() {
        return this.f7527c;
    }

    public String d() {
        return this.f7526b;
    }

    public long e() {
        return this.f7528d;
    }

    public String f() {
        return this.f7525a.toString();
    }

    public boolean g() {
        return this.f7527c.equals("application/pdf");
    }

    public void h(long j10) {
        this.f7529e = j10;
    }

    public void i(String str) {
        this.f7527c = str;
    }

    public void j(String str) {
        this.f7526b = str;
    }

    public void k(long j10) {
        this.f7528d = j10;
    }

    public String toString() {
        return "OfflinePage{fileUri=" + this.f7525a + ", name='" + this.f7526b + "', mimeType='" + this.f7527c + "', lastModified=" + this.f7529e + '}';
    }

    public d(Uri uri, String str, String str2, long j10) {
        this.f7525a = uri;
        this.f7526b = str;
        this.f7527c = str2;
        this.f7529e = j10;
    }
}
