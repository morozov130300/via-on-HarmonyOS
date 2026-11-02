package u2;

import u2.b0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class i extends b0.e.a {

    /* renamed from: a, reason: collision with root package name */
    public final String f12655a;

    /* renamed from: b, reason: collision with root package name */
    public final String f12656b;

    /* renamed from: c, reason: collision with root package name */
    public final String f12657c;

    /* renamed from: d, reason: collision with root package name */
    public final String f12658d;

    /* renamed from: e, reason: collision with root package name */
    public final String f12659e;

    /* renamed from: f, reason: collision with root package name */
    public final String f12660f;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class b extends b0.e.a.AbstractC0130a {

        /* renamed from: a, reason: collision with root package name */
        public String f12661a;

        /* renamed from: b, reason: collision with root package name */
        public String f12662b;

        /* renamed from: c, reason: collision with root package name */
        public String f12663c;

        /* renamed from: d, reason: collision with root package name */
        public String f12664d;

        /* renamed from: e, reason: collision with root package name */
        public String f12665e;

        /* renamed from: f, reason: collision with root package name */
        public String f12666f;

        @Override // u2.b0.e.a.AbstractC0130a
        public b0.e.a a() {
            String str = "";
            if (this.f12661a == null) {
                str = " identifier";
            }
            if (this.f12662b == null) {
                str = str + " version";
            }
            if (str.isEmpty()) {
                return new i(this.f12661a, this.f12662b, this.f12663c, null, this.f12664d, this.f12665e, this.f12666f);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // u2.b0.e.a.AbstractC0130a
        public b0.e.a.AbstractC0130a b(String str) {
            this.f12665e = str;
            return this;
        }

        @Override // u2.b0.e.a.AbstractC0130a
        public b0.e.a.AbstractC0130a c(String str) {
            this.f12666f = str;
            return this;
        }

        @Override // u2.b0.e.a.AbstractC0130a
        public b0.e.a.AbstractC0130a d(String str) {
            this.f12663c = str;
            return this;
        }

        @Override // u2.b0.e.a.AbstractC0130a
        public b0.e.a.AbstractC0130a e(String str) {
            if (str == null) {
                throw new NullPointerException("Null identifier");
            }
            this.f12661a = str;
            return this;
        }

        @Override // u2.b0.e.a.AbstractC0130a
        public b0.e.a.AbstractC0130a f(String str) {
            this.f12664d = str;
            return this;
        }

        @Override // u2.b0.e.a.AbstractC0130a
        public b0.e.a.AbstractC0130a g(String str) {
            if (str == null) {
                throw new NullPointerException("Null version");
            }
            this.f12662b = str;
            return this;
        }
    }

    public i(String str, String str2, String str3, b0.e.a.b bVar, String str4, String str5, String str6) {
        this.f12655a = str;
        this.f12656b = str2;
        this.f12657c = str3;
        this.f12658d = str4;
        this.f12659e = str5;
        this.f12660f = str6;
    }

    @Override // u2.b0.e.a
    public String b() {
        return this.f12659e;
    }

    @Override // u2.b0.e.a
    public String c() {
        return this.f12660f;
    }

    @Override // u2.b0.e.a
    public String d() {
        return this.f12657c;
    }

    @Override // u2.b0.e.a
    public String e() {
        return this.f12655a;
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof b0.e.a) {
            b0.e.a aVar = (b0.e.a) obj;
            if (this.f12655a.equals(aVar.e()) && this.f12656b.equals(aVar.h()) && ((str = this.f12657c) != null ? str.equals(aVar.d()) : aVar.d() == null)) {
                aVar.g();
                String str2 = this.f12658d;
                if (str2 != null ? str2.equals(aVar.f()) : aVar.f() == null) {
                    String str3 = this.f12659e;
                    if (str3 != null ? str3.equals(aVar.b()) : aVar.b() == null) {
                        String str4 = this.f12660f;
                        if (str4 != null ? str4.equals(aVar.c()) : aVar.c() == null) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // u2.b0.e.a
    public String f() {
        return this.f12658d;
    }

    @Override // u2.b0.e.a
    public b0.e.a.b g() {
        return null;
    }

    @Override // u2.b0.e.a
    public String h() {
        return this.f12656b;
    }

    public int hashCode() {
        int iHashCode = (((this.f12655a.hashCode() ^ 1000003) * 1000003) ^ this.f12656b.hashCode()) * 1000003;
        String str = this.f12657c;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * (-721379959);
        String str2 = this.f12658d;
        int iHashCode3 = (iHashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f12659e;
        int iHashCode4 = (iHashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.f12660f;
        return iHashCode4 ^ (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "Application{identifier=" + this.f12655a + ", version=" + this.f12656b + ", displayVersion=" + this.f12657c + ", organization=" + ((Object) null) + ", installationUuid=" + this.f12658d + ", developmentPlatform=" + this.f12659e + ", developmentPlatformVersion=" + this.f12660f + "}";
    }
}
