package u2;

import u2.b0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class v extends b0.e.AbstractC0143e {

    /* renamed from: a, reason: collision with root package name */
    public final int f12769a;

    /* renamed from: b, reason: collision with root package name */
    public final String f12770b;

    /* renamed from: c, reason: collision with root package name */
    public final String f12771c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f12772d;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class b extends b0.e.AbstractC0143e.a {

        /* renamed from: a, reason: collision with root package name */
        public Integer f12773a;

        /* renamed from: b, reason: collision with root package name */
        public String f12774b;

        /* renamed from: c, reason: collision with root package name */
        public String f12775c;

        /* renamed from: d, reason: collision with root package name */
        public Boolean f12776d;

        @Override // u2.b0.e.AbstractC0143e.a
        public b0.e.AbstractC0143e a() {
            String str = "";
            if (this.f12773a == null) {
                str = " platform";
            }
            if (this.f12774b == null) {
                str = str + " version";
            }
            if (this.f12775c == null) {
                str = str + " buildVersion";
            }
            if (this.f12776d == null) {
                str = str + " jailbroken";
            }
            if (str.isEmpty()) {
                return new v(this.f12773a.intValue(), this.f12774b, this.f12775c, this.f12776d.booleanValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // u2.b0.e.AbstractC0143e.a
        public b0.e.AbstractC0143e.a b(String str) {
            if (str == null) {
                throw new NullPointerException("Null buildVersion");
            }
            this.f12775c = str;
            return this;
        }

        @Override // u2.b0.e.AbstractC0143e.a
        public b0.e.AbstractC0143e.a c(boolean z10) {
            this.f12776d = Boolean.valueOf(z10);
            return this;
        }

        @Override // u2.b0.e.AbstractC0143e.a
        public b0.e.AbstractC0143e.a d(int i10) {
            this.f12773a = Integer.valueOf(i10);
            return this;
        }

        @Override // u2.b0.e.AbstractC0143e.a
        public b0.e.AbstractC0143e.a e(String str) {
            if (str == null) {
                throw new NullPointerException("Null version");
            }
            this.f12774b = str;
            return this;
        }
    }

    public v(int i10, String str, String str2, boolean z10) {
        this.f12769a = i10;
        this.f12770b = str;
        this.f12771c = str2;
        this.f12772d = z10;
    }

    @Override // u2.b0.e.AbstractC0143e
    public String b() {
        return this.f12771c;
    }

    @Override // u2.b0.e.AbstractC0143e
    public int c() {
        return this.f12769a;
    }

    @Override // u2.b0.e.AbstractC0143e
    public String d() {
        return this.f12770b;
    }

    @Override // u2.b0.e.AbstractC0143e
    public boolean e() {
        return this.f12772d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b0.e.AbstractC0143e) {
            b0.e.AbstractC0143e abstractC0143e = (b0.e.AbstractC0143e) obj;
            if (this.f12769a == abstractC0143e.c() && this.f12770b.equals(abstractC0143e.d()) && this.f12771c.equals(abstractC0143e.b()) && this.f12772d == abstractC0143e.e()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((((this.f12769a ^ 1000003) * 1000003) ^ this.f12770b.hashCode()) * 1000003) ^ this.f12771c.hashCode()) * 1000003) ^ (this.f12772d ? 1231 : 1237);
    }

    public String toString() {
        return "OperatingSystem{platform=" + this.f12769a + ", version=" + this.f12770b + ", buildVersion=" + this.f12771c + ", jailbroken=" + this.f12772d + "}";
    }
}
