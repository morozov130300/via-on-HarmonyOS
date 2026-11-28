package e1;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b1.b f4141a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f4142b;

    public h(b1.b bVar, byte[] bArr) {
        if (bVar == null) {
            throw new NullPointerException("encoding is null");
        }
        if (bArr == null) {
            throw new NullPointerException("bytes is null");
        }
        this.f4141a = bVar;
        this.f4142b = bArr;
    }

    public byte[] a() {
        return this.f4142b;
    }

    public b1.b b() {
        return this.f4141a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        if (this.f4141a.equals(hVar.f4141a)) {
            return Arrays.equals(this.f4142b, hVar.f4142b);
        }
        return false;
    }

    public int hashCode() {
        return ((this.f4141a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f4142b);
    }

    public String toString() {
        return "EncodedPayload{encoding=" + this.f4141a + ", bytes=[...]}";
    }
}
