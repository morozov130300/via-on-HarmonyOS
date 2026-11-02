package u2;

import java.util.Arrays;
import u2.b0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class g extends b0.d.b {

    /* renamed from: a, reason: collision with root package name */
    public final String f12629a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f12630b;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class b extends b0.d.b.a {

        /* renamed from: a, reason: collision with root package name */
        public String f12631a;

        /* renamed from: b, reason: collision with root package name */
        public byte[] f12632b;

        @Override // u2.b0.d.b.a
        public b0.d.b a() {
            String str = "";
            if (this.f12631a == null) {
                str = " filename";
            }
            if (this.f12632b == null) {
                str = str + " contents";
            }
            if (str.isEmpty()) {
                return new g(this.f12631a, this.f12632b);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // u2.b0.d.b.a
        public b0.d.b.a b(byte[] bArr) {
            if (bArr == null) {
                throw new NullPointerException("Null contents");
            }
            this.f12632b = bArr;
            return this;
        }

        @Override // u2.b0.d.b.a
        public b0.d.b.a c(String str) {
            if (str == null) {
                throw new NullPointerException("Null filename");
            }
            this.f12631a = str;
            return this;
        }
    }

    public g(String str, byte[] bArr) {
        this.f12629a = str;
        this.f12630b = bArr;
    }

    @Override // u2.b0.d.b
    public byte[] b() {
        return this.f12630b;
    }

    @Override // u2.b0.d.b
    public String c() {
        return this.f12629a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b0.d.b) {
            b0.d.b bVar = (b0.d.b) obj;
            if (this.f12629a.equals(bVar.c())) {
                if (Arrays.equals(this.f12630b, bVar instanceof g ? ((g) bVar).f12630b : bVar.b())) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.f12629a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f12630b);
    }

    public String toString() {
        return "File{filename=" + this.f12629a + ", contents=" + Arrays.toString(this.f12630b) + "}";
    }
}
