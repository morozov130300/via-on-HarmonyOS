package d1;

import java.util.Arrays;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final a1.b f4509a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f4510b;

    public h(a1.b bVar, byte[] bArr) {
        if (bVar == null) {
            throw new NullPointerException("encoding is null");
        }
        if (bArr == null) {
            throw new NullPointerException("bytes is null");
        }
        this.f4509a = bVar;
        this.f4510b = bArr;
    }

    public byte[] a() {
        return this.f4510b;
    }

    public a1.b b() {
        return this.f4509a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        if (this.f4509a.equals(hVar.f4509a)) {
            return Arrays.equals(this.f4510b, hVar.f4510b);
        }
        return false;
    }

    public int hashCode() {
        return ((this.f4509a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f4510b);
    }

    public String toString() {
        return "EncodedPayload{encoding=" + this.f4509a + ", bytes=[...]}";
    }
}
