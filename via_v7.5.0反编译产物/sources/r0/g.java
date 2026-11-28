package r0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import s0.v;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Set f11890k = Collections.unmodifiableSet(new HashSet(Arrays.asList("Desktop", "Automotive", "Mobile", "Tablet", "XR", "EInk", "Watch")));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f11891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f11892b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f11893c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f11894d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f11895e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f11896f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f11897g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f11898h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f11899i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List f11900j;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f11901a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f11902b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f11903c;

        /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public String f11904a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public String f11905b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public String f11906c;

            public b a() {
                String str;
                String str2;
                String str3 = this.f11904a;
                if (str3 == null || str3.trim().isEmpty() || (str = this.f11905b) == null || str.trim().isEmpty() || (str2 = this.f11906c) == null || str2.trim().isEmpty()) {
                    throw new IllegalStateException("Brand name, major version and full version should not be null or blank.");
                }
                return new b(this.f11904a, this.f11905b, this.f11906c);
            }

            public a b(String str) {
                if (str.trim().isEmpty()) {
                    throw new IllegalArgumentException("Brand should not be blank.");
                }
                this.f11904a = str;
                return this;
            }

            public a c(String str) {
                if (str.trim().isEmpty()) {
                    throw new IllegalArgumentException("FullVersion should not be blank.");
                }
                this.f11906c = str;
                return this;
            }

            public a d(String str) {
                if (str.trim().isEmpty()) {
                    throw new IllegalArgumentException("MajorVersion should not be blank.");
                }
                this.f11905b = str;
                return this;
            }
        }

        public String a() {
            return this.f11901a;
        }

        public String b() {
            return this.f11903c;
        }

        public String c() {
            return this.f11902b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return Objects.equals(this.f11901a, bVar.f11901a) && Objects.equals(this.f11902b, bVar.f11902b) && Objects.equals(this.f11903c, bVar.f11903c);
        }

        public int hashCode() {
            return Objects.hash(this.f11901a, this.f11902b, this.f11903c);
        }

        public String toString() {
            return this.f11901a + "," + this.f11902b + "," + this.f11903c;
        }

        public b(String str, String str2, String str3) {
            this.f11901a = str;
            this.f11902b = str2;
            this.f11903c = str3;
        }
    }

    public String b() {
        return this.f11895e;
    }

    public int c() {
        return this.f11898h;
    }

    public List d() {
        return this.f11891a;
    }

    public List e() {
        return this.f11900j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return this.f11897g == gVar.f11897g && this.f11898h == gVar.f11898h && this.f11899i == gVar.f11899i && Objects.equals(this.f11891a, gVar.f11891a) && Objects.equals(this.f11892b, gVar.f11892b) && Objects.equals(this.f11893c, gVar.f11893c) && Objects.equals(this.f11894d, gVar.f11894d) && Objects.equals(this.f11895e, gVar.f11895e) && Objects.equals(this.f11896f, gVar.f11896f) && Objects.equals(this.f11900j, gVar.f11900j);
    }

    public String f() {
        return this.f11892b;
    }

    public String g() {
        return this.f11896f;
    }

    public String h() {
        return this.f11893c;
    }

    public int hashCode() {
        return Objects.hash(this.f11891a, this.f11892b, this.f11893c, this.f11894d, this.f11895e, this.f11896f, Boolean.valueOf(this.f11897g), Integer.valueOf(this.f11898h), Boolean.valueOf(this.f11899i), this.f11900j);
    }

    public String i() {
        return this.f11894d;
    }

    public boolean j() {
        return this.f11897g;
    }

    public boolean k() {
        return this.f11899i;
    }

    public g(List list, String str, String str2, String str3, String str4, String str5, boolean z10, int i10, boolean z11, List list2) {
        this.f11891a = list;
        this.f11892b = str;
        this.f11893c = str2;
        this.f11894d = str3;
        this.f11895e = str4;
        this.f11896f = str5;
        this.f11897g = z10;
        this.f11898h = i10;
        this.f11899i = z11;
        this.f11900j = list2;
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List f11907a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f11908b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f11909c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f11910d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f11911e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f11912f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f11913g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f11914h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f11915i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public List f11916j;

        public c() {
            this.f11907a = new ArrayList();
            this.f11913g = true;
            this.f11914h = 0;
            this.f11915i = false;
            this.f11916j = new ArrayList();
        }

        public g a() {
            return new g(this.f11907a, this.f11908b, this.f11909c, this.f11910d, this.f11911e, this.f11912f, this.f11913g, this.f11914h, this.f11915i, this.f11916j);
        }

        public c b(String str) {
            this.f11911e = str;
            return this;
        }

        public c c(int i10) {
            this.f11914h = i10;
            return this;
        }

        public c d(List list) {
            this.f11907a = list;
            return this;
        }

        public c e(List list) {
            if (!v.f12158d0.d()) {
                throw v.a();
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (!g.f11890k.contains(str)) {
                    throw new IllegalArgumentException("Invalid form factor: " + str);
                }
            }
            this.f11916j = list;
            return this;
        }

        public c f(String str) {
            if (str == null) {
                this.f11908b = null;
                return this;
            }
            if (str.trim().isEmpty()) {
                throw new IllegalArgumentException("Full version should not be blank.");
            }
            this.f11908b = str;
            return this;
        }

        public c g(boolean z10) {
            this.f11913g = z10;
            return this;
        }

        public c h(String str) {
            this.f11912f = str;
            return this;
        }

        public c i(String str) {
            if (str == null) {
                this.f11909c = null;
                return this;
            }
            if (str.trim().isEmpty()) {
                throw new IllegalArgumentException("Platform should not be blank.");
            }
            this.f11909c = str;
            return this;
        }

        public c j(String str) {
            this.f11910d = str;
            return this;
        }

        public c k(boolean z10) {
            this.f11915i = z10;
            return this;
        }

        public c(g gVar) {
            this.f11907a = new ArrayList();
            this.f11913g = true;
            this.f11914h = 0;
            this.f11915i = false;
            this.f11916j = new ArrayList();
            this.f11907a = gVar.d();
            this.f11908b = gVar.f();
            this.f11909c = gVar.h();
            this.f11910d = gVar.i();
            this.f11911e = gVar.b();
            this.f11912f = gVar.g();
            this.f11913g = gVar.j();
            this.f11914h = gVar.c();
            this.f11915i = gVar.k();
            this.f11916j = gVar.e();
        }
    }
}
