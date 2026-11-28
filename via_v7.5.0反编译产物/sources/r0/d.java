package r0;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f11881a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f11882b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f11883c;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f11886c = false;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f11884a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List f11885b = new ArrayList();

        public a a(String str) {
            this.f11885b.add(str);
            return this;
        }

        public a b() {
            return c("*");
        }

        public a c(String str) {
            this.f11884a.add(new b(str, "direct://"));
            return this;
        }

        public a d(String str) {
            this.f11884a.add(new b(str));
            return this;
        }

        public d e() {
            return new d(h(), f(), i());
        }

        public final List f() {
            return this.f11885b;
        }

        public a g() {
            return a("<local>");
        }

        public final List h() {
            return this.f11884a;
        }

        public final boolean i() {
            return this.f11886c;
        }

        public a j(boolean z10) {
            this.f11886c = z10;
            return this;
        }
    }

    public d(List list, List list2, boolean z10) {
        this.f11881a = list;
        this.f11882b = list2;
        this.f11883c = z10;
    }

    public List a() {
        return Collections.unmodifiableList(this.f11882b);
    }

    public List b() {
        return Collections.unmodifiableList(this.f11881a);
    }

    public boolean c() {
        return this.f11883c;
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f11887a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f11888b;

        public b(String str, String str2) {
            this.f11887a = str;
            this.f11888b = str2;
        }

        public String a() {
            return this.f11887a;
        }

        public String b() {
            return this.f11888b;
        }

        public b(String str) {
            this("*", str);
        }
    }
}
