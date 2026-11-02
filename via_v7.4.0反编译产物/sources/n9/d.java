package n9;

import android.net.Uri;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public Uri f10271a;

    /* renamed from: b, reason: collision with root package name */
    public String f10272b;

    /* renamed from: c, reason: collision with root package name */
    public String f10273c;

    /* renamed from: d, reason: collision with root package name */
    public long f10274d;

    /* renamed from: e, reason: collision with root package name */
    public long f10275e;

    public d(Uri uri) {
        this(uri, null, null, 0L);
    }

    public d(Uri uri, String str, String str2, long j10) {
        this.f10271a = uri;
        this.f10272b = str;
        this.f10273c = str2;
        this.f10275e = j10;
    }

    public Uri a() {
        return this.f10271a;
    }

    public long b() {
        return this.f10275e;
    }

    public String c() {
        return this.f10273c;
    }

    public String d() {
        return this.f10272b;
    }

    public long e() {
        return this.f10274d;
    }

    public String f() {
        return this.f10271a.toString();
    }

    public boolean g() {
        return this.f10273c.equals("application/pdf");
    }

    public void h(long j10) {
        this.f10275e = j10;
    }

    public void i(String str) {
        this.f10273c = str;
    }

    public void j(String str) {
        this.f10272b = str;
    }

    public void k(long j10) {
        this.f10274d = j10;
    }

    public String toString() {
        return "OfflinePage{fileUri=" + this.f10271a + ", name='" + this.f10272b + "', mimeType='" + this.f10273c + "', lastModified=" + this.f10275e + '}';
    }
}
