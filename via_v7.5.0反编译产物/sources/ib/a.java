package ib;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6334a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f6335b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f6336c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f6337d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f6338e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f6339f;

    public a(String str, String str2, String str3, String str4, int i10) {
        this.f6334a = str;
        this.f6335b = str2;
        this.f6336c = str3;
        this.f6337d = str4;
        this.f6338e = i10;
    }

    public String a() {
        return this.f6337d;
    }

    public int b() {
        return this.f6338e;
    }

    public String c() {
        return this.f6334a;
    }

    public String d() {
        return this.f6339f ? this.f6336c : this.f6335b;
    }

    public boolean e() {
        boolean z10 = !this.f6339f;
        this.f6339f = z10;
        return z10;
    }
}
