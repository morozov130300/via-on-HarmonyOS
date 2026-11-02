package u2;

import u2.b0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class d extends b0.a.AbstractC0128a {

    /* renamed from: a, reason: collision with root package name */
    public final String f12615a;

    /* renamed from: b, reason: collision with root package name */
    public final String f12616b;

    /* renamed from: c, reason: collision with root package name */
    public final String f12617c;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class b extends b0.a.AbstractC0128a.AbstractC0129a {

        /* renamed from: a, reason: collision with root package name */
        public String f12618a;

        /* renamed from: b, reason: collision with root package name */
        public String f12619b;

        /* renamed from: c, reason: collision with root package name */
        public String f12620c;

        @Override // u2.b0.a.AbstractC0128a.AbstractC0129a
        public b0.a.AbstractC0128a a() {
            String str = "";
            if (this.f12618a == null) {
                str = " arch";
            }
            if (this.f12619b == null) {
                str = str + " libraryName";
            }
            if (this.f12620c == null) {
                str = str + " buildId";
            }
            if (str.isEmpty()) {
                return new d(this.f12618a, this.f12619b, this.f12620c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // u2.b0.a.AbstractC0128a.AbstractC0129a
        public b0.a.AbstractC0128a.AbstractC0129a b(String str) {
            if (str == null) {
                throw new NullPointerException("Null arch");
            }
            this.f12618a = str;
            return this;
        }

        @Override // u2.b0.a.AbstractC0128a.AbstractC0129a
        public b0.a.AbstractC0128a.AbstractC0129a c(String str) {
            if (str == null) {
                throw new NullPointerException("Null buildId");
            }
            this.f12620c = str;
            return this;
        }

        @Override // u2.b0.a.AbstractC0128a.AbstractC0129a
        public b0.a.AbstractC0128a.AbstractC0129a d(String str) {
            if (str == null) {
                throw new NullPointerException("Null libraryName");
            }
            this.f12619b = str;
            return this;
        }
    }

    public d(String str, String str2, String str3) {
        this.f12615a = str;
        this.f12616b = str2;
        this.f12617c = str3;
    }

    @Override // u2.b0.a.AbstractC0128a
    public String b() {
        return this.f12615a;
    }

    @Override // u2.b0.a.AbstractC0128a
    public String c() {
        return this.f12617c;
    }

    @Override // u2.b0.a.AbstractC0128a
    public String d() {
        return this.f12616b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b0.a.AbstractC0128a) {
            b0.a.AbstractC0128a abstractC0128a = (b0.a.AbstractC0128a) obj;
            if (this.f12615a.equals(abstractC0128a.b()) && this.f12616b.equals(abstractC0128a.d()) && this.f12617c.equals(abstractC0128a.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f12615a.hashCode() ^ 1000003) * 1000003) ^ this.f12616b.hashCode()) * 1000003) ^ this.f12617c.hashCode();
    }

    public String toString() {
        return "BuildIdMappingForArch{arch=" + this.f12615a + ", libraryName=" + this.f12616b + ", buildId=" + this.f12617c + "}";
    }
}
