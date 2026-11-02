package zb;

import okio.ByteString;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: d, reason: collision with root package name */
    public static final ByteString f14810d = ByteString.encodeUtf8(":");

    /* renamed from: e, reason: collision with root package name */
    public static final ByteString f14811e = ByteString.encodeUtf8(":status");

    /* renamed from: f, reason: collision with root package name */
    public static final ByteString f14812f = ByteString.encodeUtf8(":method");

    /* renamed from: g, reason: collision with root package name */
    public static final ByteString f14813g = ByteString.encodeUtf8(":path");

    /* renamed from: h, reason: collision with root package name */
    public static final ByteString f14814h = ByteString.encodeUtf8(":scheme");

    /* renamed from: i, reason: collision with root package name */
    public static final ByteString f14815i = ByteString.encodeUtf8(":authority");

    /* renamed from: a, reason: collision with root package name */
    public final ByteString f14816a;

    /* renamed from: b, reason: collision with root package name */
    public final ByteString f14817b;

    /* renamed from: c, reason: collision with root package name */
    public final int f14818c;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    /* renamed from: zb.a$a, reason: collision with other inner class name */
    public interface InterfaceC0161a {
    }

    public a(String str, String str2) {
        this(ByteString.encodeUtf8(str), ByteString.encodeUtf8(str2));
    }

    public a(ByteString byteString, String str) {
        this(byteString, ByteString.encodeUtf8(str));
    }

    public a(ByteString byteString, ByteString byteString2) {
        this.f14816a = byteString;
        this.f14817b = byteString2;
        this.f14818c = byteString.size() + 32 + byteString2.size();
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (this.f14816a.equals(aVar.f14816a) && this.f14817b.equals(aVar.f14817b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((527 + this.f14816a.hashCode()) * 31) + this.f14817b.hashCode();
    }

    public String toString() {
        return ub.c.r("%s: %s", this.f14816a.utf8(), this.f14817b.utf8());
    }
}
