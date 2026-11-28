package t3;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f12486a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f12487b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f12488c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f12489d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f12490e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Object f12491f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f12492g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f12493h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f12494i;

    public d(byte[] bArr, String str, List list, String str2, int i10, int i11, int i12) {
        this.f12486a = bArr;
        this.f12487b = bArr == null ? 0 : bArr.length * 8;
        this.f12488c = str;
        this.f12489d = list;
        this.f12490e = str2;
        this.f12492g = i11;
        this.f12493h = i10;
        this.f12494i = i12;
    }

    public List a() {
        return this.f12489d;
    }

    public String b() {
        return this.f12490e;
    }

    public Object c() {
        return this.f12491f;
    }

    public byte[] d() {
        return this.f12486a;
    }

    public int e() {
        return this.f12492g;
    }

    public int f() {
        return this.f12493h;
    }

    public int g() {
        return this.f12494i;
    }

    public String h() {
        return this.f12488c;
    }

    public boolean i() {
        return this.f12492g >= 0 && this.f12493h >= 0;
    }

    public void j(Object obj) {
        this.f12491f = obj;
    }
}
