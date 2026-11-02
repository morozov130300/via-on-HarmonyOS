package s3;

import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f11818a;

    /* renamed from: b, reason: collision with root package name */
    public int f11819b;

    /* renamed from: c, reason: collision with root package name */
    public final String f11820c;

    /* renamed from: d, reason: collision with root package name */
    public final List f11821d;

    /* renamed from: e, reason: collision with root package name */
    public final String f11822e;

    /* renamed from: f, reason: collision with root package name */
    public Object f11823f;

    /* renamed from: g, reason: collision with root package name */
    public final int f11824g;

    /* renamed from: h, reason: collision with root package name */
    public final int f11825h;

    /* renamed from: i, reason: collision with root package name */
    public final int f11826i;

    public d(byte[] bArr, String str, List list, String str2, int i10, int i11, int i12) {
        this.f11818a = bArr;
        this.f11819b = bArr == null ? 0 : bArr.length * 8;
        this.f11820c = str;
        this.f11821d = list;
        this.f11822e = str2;
        this.f11824g = i11;
        this.f11825h = i10;
        this.f11826i = i12;
    }

    public List a() {
        return this.f11821d;
    }

    public String b() {
        return this.f11822e;
    }

    public Object c() {
        return this.f11823f;
    }

    public byte[] d() {
        return this.f11818a;
    }

    public int e() {
        return this.f11824g;
    }

    public int f() {
        return this.f11825h;
    }

    public int g() {
        return this.f11826i;
    }

    public String h() {
        return this.f11820c;
    }

    public boolean i() {
        return this.f11824g >= 0 && this.f11825h >= 0;
    }

    public void j(Object obj) {
        this.f11823f = obj;
    }
}
