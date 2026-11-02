package u2;

import u2.b0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class e extends b0.c {

    /* renamed from: a, reason: collision with root package name */
    public final String f12621a;

    /* renamed from: b, reason: collision with root package name */
    public final String f12622b;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class b extends b0.c.a {

        /* renamed from: a, reason: collision with root package name */
        public String f12623a;

        /* renamed from: b, reason: collision with root package name */
        public String f12624b;

        @Override // u2.b0.c.a
        public b0.c a() {
            String str = "";
            if (this.f12623a == null) {
                str = " key";
            }
            if (this.f12624b == null) {
                str = str + " value";
            }
            if (str.isEmpty()) {
                return new e(this.f12623a, this.f12624b);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // u2.b0.c.a
        public b0.c.a b(String str) {
            if (str == null) {
                throw new NullPointerException("Null key");
            }
            this.f12623a = str;
            return this;
        }

        @Override // u2.b0.c.a
        public b0.c.a c(String str) {
            if (str == null) {
                throw new NullPointerException("Null value");
            }
            this.f12624b = str;
            return this;
        }
    }

    public e(String str, String str2) {
        this.f12621a = str;
        this.f12622b = str2;
    }

    @Override // u2.b0.c
    public String b() {
        return this.f12621a;
    }

    @Override // u2.b0.c
    public String c() {
        return this.f12622b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b0.c) {
            b0.c cVar = (b0.c) obj;
            if (this.f12621a.equals(cVar.b()) && this.f12622b.equals(cVar.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.f12621a.hashCode() ^ 1000003) * 1000003) ^ this.f12622b.hashCode();
    }

    public String toString() {
        return "CustomAttribute{key=" + this.f12621a + ", value=" + this.f12622b + "}";
    }
}
