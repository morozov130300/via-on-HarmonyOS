package r0;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i[] f11917a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f11918b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f11919c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f11920d;

    public h(String str, i[] iVarArr) {
        this.f11918b = str;
        this.f11919c = null;
        this.f11917a = iVarArr;
        this.f11920d = 0;
    }

    public final void a(int i10) {
        if (i10 == this.f11920d) {
            return;
        }
        throw new IllegalStateException("Wrong data accessor type detected. " + e(this.f11920d) + " expected, but got " + e(i10));
    }

    public byte[] b() {
        a(1);
        Objects.requireNonNull(this.f11919c);
        return this.f11919c;
    }

    public String c() {
        a(0);
        return this.f11918b;
    }

    public int d() {
        return this.f11920d;
    }

    public final String e(int i10) {
        if (i10 != 0) {
            return i10 != 1 ? "Unknown" : "ArrayBuffer";
        }
        return "String";
    }

    public h(byte[] bArr, i[] iVarArr) {
        Objects.requireNonNull(bArr);
        this.f11919c = bArr;
        this.f11918b = null;
        this.f11917a = iVarArr;
        this.f11920d = 1;
    }
}
