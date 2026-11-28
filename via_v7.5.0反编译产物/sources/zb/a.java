package zb;

import okio.ByteString;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ByteString f15547d = ByteString.encodeUtf8(":");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ByteString f15548e = ByteString.encodeUtf8(":status");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ByteString f15549f = ByteString.encodeUtf8(":method");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ByteString f15550g = ByteString.encodeUtf8(":path");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ByteString f15551h = ByteString.encodeUtf8(":scheme");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ByteString f15552i = ByteString.encodeUtf8(":authority");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ByteString f15553a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ByteString f15554b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f15555c;

    /* JADX INFO: renamed from: zb.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface InterfaceC0166a {
    }

    public a(String str, String str2) {
        this(ByteString.encodeUtf8(str), ByteString.encodeUtf8(str2));
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (this.f15553a.equals(aVar.f15553a) && this.f15554b.equals(aVar.f15554b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((527 + this.f15553a.hashCode()) * 31) + this.f15554b.hashCode();
    }

    public String toString() {
        return ub.c.r("%s: %s", this.f15553a.utf8(), this.f15554b.utf8());
    }

    public a(ByteString byteString, String str) {
        this(byteString, ByteString.encodeUtf8(str));
    }

    public a(ByteString byteString, ByteString byteString2) {
        this.f15553a = byteString;
        this.f15554b = byteString2;
        this.f15555c = byteString.size() + 32 + byteString2.size();
    }
}
