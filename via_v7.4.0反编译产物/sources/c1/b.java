package c1;

import c1.a;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class b extends c1.a {

    /* renamed from: a, reason: collision with root package name */
    public final Integer f2218a;

    /* renamed from: b, reason: collision with root package name */
    public final String f2219b;

    /* renamed from: c, reason: collision with root package name */
    public final String f2220c;

    /* renamed from: d, reason: collision with root package name */
    public final String f2221d;

    /* renamed from: e, reason: collision with root package name */
    public final String f2222e;

    /* renamed from: f, reason: collision with root package name */
    public final String f2223f;

    /* renamed from: g, reason: collision with root package name */
    public final String f2224g;

    /* renamed from: h, reason: collision with root package name */
    public final String f2225h;

    /* renamed from: i, reason: collision with root package name */
    public final String f2226i;

    /* renamed from: j, reason: collision with root package name */
    public final String f2227j;

    /* renamed from: k, reason: collision with root package name */
    public final String f2228k;

    /* renamed from: l, reason: collision with root package name */
    public final String f2229l;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    /* renamed from: c1.b$b, reason: collision with other inner class name */
    public static final class C0041b extends a.AbstractC0040a {

        /* renamed from: a, reason: collision with root package name */
        public Integer f2230a;

        /* renamed from: b, reason: collision with root package name */
        public String f2231b;

        /* renamed from: c, reason: collision with root package name */
        public String f2232c;

        /* renamed from: d, reason: collision with root package name */
        public String f2233d;

        /* renamed from: e, reason: collision with root package name */
        public String f2234e;

        /* renamed from: f, reason: collision with root package name */
        public String f2235f;

        /* renamed from: g, reason: collision with root package name */
        public String f2236g;

        /* renamed from: h, reason: collision with root package name */
        public String f2237h;

        /* renamed from: i, reason: collision with root package name */
        public String f2238i;

        /* renamed from: j, reason: collision with root package name */
        public String f2239j;

        /* renamed from: k, reason: collision with root package name */
        public String f2240k;

        /* renamed from: l, reason: collision with root package name */
        public String f2241l;

        @Override // c1.a.AbstractC0040a
        public c1.a a() {
            return new b(this.f2230a, this.f2231b, this.f2232c, this.f2233d, this.f2234e, this.f2235f, this.f2236g, this.f2237h, this.f2238i, this.f2239j, this.f2240k, this.f2241l);
        }

        @Override // c1.a.AbstractC0040a
        public a.AbstractC0040a b(String str) {
            this.f2241l = str;
            return this;
        }

        @Override // c1.a.AbstractC0040a
        public a.AbstractC0040a c(String str) {
            this.f2239j = str;
            return this;
        }

        @Override // c1.a.AbstractC0040a
        public a.AbstractC0040a d(String str) {
            this.f2233d = str;
            return this;
        }

        @Override // c1.a.AbstractC0040a
        public a.AbstractC0040a e(String str) {
            this.f2237h = str;
            return this;
        }

        @Override // c1.a.AbstractC0040a
        public a.AbstractC0040a f(String str) {
            this.f2232c = str;
            return this;
        }

        @Override // c1.a.AbstractC0040a
        public a.AbstractC0040a g(String str) {
            this.f2238i = str;
            return this;
        }

        @Override // c1.a.AbstractC0040a
        public a.AbstractC0040a h(String str) {
            this.f2236g = str;
            return this;
        }

        @Override // c1.a.AbstractC0040a
        public a.AbstractC0040a i(String str) {
            this.f2240k = str;
            return this;
        }

        @Override // c1.a.AbstractC0040a
        public a.AbstractC0040a j(String str) {
            this.f2231b = str;
            return this;
        }

        @Override // c1.a.AbstractC0040a
        public a.AbstractC0040a k(String str) {
            this.f2235f = str;
            return this;
        }

        @Override // c1.a.AbstractC0040a
        public a.AbstractC0040a l(String str) {
            this.f2234e = str;
            return this;
        }

        @Override // c1.a.AbstractC0040a
        public a.AbstractC0040a m(Integer num) {
            this.f2230a = num;
            return this;
        }
    }

    public b(Integer num, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        this.f2218a = num;
        this.f2219b = str;
        this.f2220c = str2;
        this.f2221d = str3;
        this.f2222e = str4;
        this.f2223f = str5;
        this.f2224g = str6;
        this.f2225h = str7;
        this.f2226i = str8;
        this.f2227j = str9;
        this.f2228k = str10;
        this.f2229l = str11;
    }

    @Override // c1.a
    public String b() {
        return this.f2229l;
    }

    @Override // c1.a
    public String c() {
        return this.f2227j;
    }

    @Override // c1.a
    public String d() {
        return this.f2221d;
    }

    @Override // c1.a
    public String e() {
        return this.f2225h;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof c1.a) {
            c1.a aVar = (c1.a) obj;
            Integer num = this.f2218a;
            if (num != null ? num.equals(aVar.m()) : aVar.m() == null) {
                String str = this.f2219b;
                if (str != null ? str.equals(aVar.j()) : aVar.j() == null) {
                    String str2 = this.f2220c;
                    if (str2 != null ? str2.equals(aVar.f()) : aVar.f() == null) {
                        String str3 = this.f2221d;
                        if (str3 != null ? str3.equals(aVar.d()) : aVar.d() == null) {
                            String str4 = this.f2222e;
                            if (str4 != null ? str4.equals(aVar.l()) : aVar.l() == null) {
                                String str5 = this.f2223f;
                                if (str5 != null ? str5.equals(aVar.k()) : aVar.k() == null) {
                                    String str6 = this.f2224g;
                                    if (str6 != null ? str6.equals(aVar.h()) : aVar.h() == null) {
                                        String str7 = this.f2225h;
                                        if (str7 != null ? str7.equals(aVar.e()) : aVar.e() == null) {
                                            String str8 = this.f2226i;
                                            if (str8 != null ? str8.equals(aVar.g()) : aVar.g() == null) {
                                                String str9 = this.f2227j;
                                                if (str9 != null ? str9.equals(aVar.c()) : aVar.c() == null) {
                                                    String str10 = this.f2228k;
                                                    if (str10 != null ? str10.equals(aVar.i()) : aVar.i() == null) {
                                                        String str11 = this.f2229l;
                                                        if (str11 != null ? str11.equals(aVar.b()) : aVar.b() == null) {
                                                            return true;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // c1.a
    public String f() {
        return this.f2220c;
    }

    @Override // c1.a
    public String g() {
        return this.f2226i;
    }

    @Override // c1.a
    public String h() {
        return this.f2224g;
    }

    public int hashCode() {
        Integer num = this.f2218a;
        int iHashCode = ((num == null ? 0 : num.hashCode()) ^ 1000003) * 1000003;
        String str = this.f2219b;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.f2220c;
        int iHashCode3 = (iHashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f2221d;
        int iHashCode4 = (iHashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.f2222e;
        int iHashCode5 = (iHashCode4 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.f2223f;
        int iHashCode6 = (iHashCode5 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        String str6 = this.f2224g;
        int iHashCode7 = (iHashCode6 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        String str7 = this.f2225h;
        int iHashCode8 = (iHashCode7 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
        String str8 = this.f2226i;
        int iHashCode9 = (iHashCode8 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
        String str9 = this.f2227j;
        int iHashCode10 = (iHashCode9 ^ (str9 == null ? 0 : str9.hashCode())) * 1000003;
        String str10 = this.f2228k;
        int iHashCode11 = (iHashCode10 ^ (str10 == null ? 0 : str10.hashCode())) * 1000003;
        String str11 = this.f2229l;
        return iHashCode11 ^ (str11 != null ? str11.hashCode() : 0);
    }

    @Override // c1.a
    public String i() {
        return this.f2228k;
    }

    @Override // c1.a
    public String j() {
        return this.f2219b;
    }

    @Override // c1.a
    public String k() {
        return this.f2223f;
    }

    @Override // c1.a
    public String l() {
        return this.f2222e;
    }

    @Override // c1.a
    public Integer m() {
        return this.f2218a;
    }

    public String toString() {
        return "AndroidClientInfo{sdkVersion=" + this.f2218a + ", model=" + this.f2219b + ", hardware=" + this.f2220c + ", device=" + this.f2221d + ", product=" + this.f2222e + ", osBuild=" + this.f2223f + ", manufacturer=" + this.f2224g + ", fingerprint=" + this.f2225h + ", locale=" + this.f2226i + ", country=" + this.f2227j + ", mccMnc=" + this.f2228k + ", applicationBuild=" + this.f2229l + "}";
    }
}
