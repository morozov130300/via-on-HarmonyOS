package q0;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final List f11208a;

    /* renamed from: b, reason: collision with root package name */
    public final String f11209b;

    /* renamed from: c, reason: collision with root package name */
    public final String f11210c;

    /* renamed from: d, reason: collision with root package name */
    public final String f11211d;

    /* renamed from: e, reason: collision with root package name */
    public final String f11212e;

    /* renamed from: f, reason: collision with root package name */
    public final String f11213f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f11214g;

    /* renamed from: h, reason: collision with root package name */
    public int f11215h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f11216i;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final String f11217a;

        /* renamed from: b, reason: collision with root package name */
        public final String f11218b;

        /* renamed from: c, reason: collision with root package name */
        public final String f11219c;

        /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            public String f11220a;

            /* renamed from: b, reason: collision with root package name */
            public String f11221b;

            /* renamed from: c, reason: collision with root package name */
            public String f11222c;

            public b a() {
                String str;
                String str2;
                String str3 = this.f11220a;
                if (str3 == null || str3.trim().isEmpty() || (str = this.f11221b) == null || str.trim().isEmpty() || (str2 = this.f11222c) == null || str2.trim().isEmpty()) {
                    throw new IllegalStateException("Brand name, major version and full version should not be null or blank.");
                }
                return new b(this.f11220a, this.f11221b, this.f11222c);
            }

            public a b(String str) {
                if (str.trim().isEmpty()) {
                    throw new IllegalArgumentException("Brand should not be blank.");
                }
                this.f11220a = str;
                return this;
            }

            public a c(String str) {
                if (str.trim().isEmpty()) {
                    throw new IllegalArgumentException("FullVersion should not be blank.");
                }
                this.f11222c = str;
                return this;
            }

            public a d(String str) {
                if (str.trim().isEmpty()) {
                    throw new IllegalArgumentException("MajorVersion should not be blank.");
                }
                this.f11221b = str;
                return this;
            }
        }

        public b(String str, String str2, String str3) {
            this.f11217a = str;
            this.f11218b = str2;
            this.f11219c = str3;
        }

        public String a() {
            return this.f11217a;
        }

        public String b() {
            return this.f11219c;
        }

        public String c() {
            return this.f11218b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return Objects.equals(this.f11217a, bVar.f11217a) && Objects.equals(this.f11218b, bVar.f11218b) && Objects.equals(this.f11219c, bVar.f11219c);
        }

        public int hashCode() {
            return Objects.hash(this.f11217a, this.f11218b, this.f11219c);
        }

        public String toString() {
            return this.f11217a + "," + this.f11218b + "," + this.f11219c;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class c {

        /* renamed from: b, reason: collision with root package name */
        public String f11224b;

        /* renamed from: c, reason: collision with root package name */
        public String f11225c;

        /* renamed from: d, reason: collision with root package name */
        public String f11226d;

        /* renamed from: e, reason: collision with root package name */
        public String f11227e;

        /* renamed from: f, reason: collision with root package name */
        public String f11228f;

        /* renamed from: a, reason: collision with root package name */
        public List f11223a = new ArrayList();

        /* renamed from: g, reason: collision with root package name */
        public boolean f11229g = true;

        /* renamed from: h, reason: collision with root package name */
        public int f11230h = 0;

        /* renamed from: i, reason: collision with root package name */
        public boolean f11231i = false;

        public d a() {
            return new d(this.f11223a, this.f11224b, this.f11225c, this.f11226d, this.f11227e, this.f11228f, this.f11229g, this.f11230h, this.f11231i);
        }

        public c b(String str) {
            this.f11227e = str;
            return this;
        }

        public c c(int i10) {
            this.f11230h = i10;
            return this;
        }

        public c d(List list) {
            this.f11223a = list;
            return this;
        }

        public c e(String str) {
            if (str == null) {
                this.f11224b = null;
                return this;
            }
            if (str.trim().isEmpty()) {
                throw new IllegalArgumentException("Full version should not be blank.");
            }
            this.f11224b = str;
            return this;
        }

        public c f(boolean z10) {
            this.f11229g = z10;
            return this;
        }

        public c g(String str) {
            this.f11228f = str;
            return this;
        }

        public c h(String str) {
            if (str == null) {
                this.f11225c = null;
                return this;
            }
            if (str.trim().isEmpty()) {
                throw new IllegalArgumentException("Platform should not be blank.");
            }
            this.f11225c = str;
            return this;
        }

        public c i(String str) {
            this.f11226d = str;
            return this;
        }

        public c j(boolean z10) {
            this.f11231i = z10;
            return this;
        }
    }

    public d(List list, String str, String str2, String str3, String str4, String str5, boolean z10, int i10, boolean z11) {
        this.f11208a = list;
        this.f11209b = str;
        this.f11210c = str2;
        this.f11211d = str3;
        this.f11212e = str4;
        this.f11213f = str5;
        this.f11214g = z10;
        this.f11215h = i10;
        this.f11216i = z11;
    }

    public String a() {
        return this.f11212e;
    }

    public int b() {
        return this.f11215h;
    }

    public List c() {
        return this.f11208a;
    }

    public String d() {
        return this.f11209b;
    }

    public String e() {
        return this.f11213f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f11214g == dVar.f11214g && this.f11215h == dVar.f11215h && this.f11216i == dVar.f11216i && Objects.equals(this.f11208a, dVar.f11208a) && Objects.equals(this.f11209b, dVar.f11209b) && Objects.equals(this.f11210c, dVar.f11210c) && Objects.equals(this.f11211d, dVar.f11211d) && Objects.equals(this.f11212e, dVar.f11212e) && Objects.equals(this.f11213f, dVar.f11213f);
    }

    public String f() {
        return this.f11210c;
    }

    public String g() {
        return this.f11211d;
    }

    public boolean h() {
        return this.f11214g;
    }

    public int hashCode() {
        return Objects.hash(this.f11208a, this.f11209b, this.f11210c, this.f11211d, this.f11212e, this.f11213f, Boolean.valueOf(this.f11214g), Integer.valueOf(this.f11215h), Boolean.valueOf(this.f11216i));
    }

    public boolean i() {
        return this.f11216i;
    }
}
