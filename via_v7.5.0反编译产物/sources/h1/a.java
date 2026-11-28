package h1;

import e1.m;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f5607e = new C0072a().b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f5608a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f5609b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f5610c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f5611d;

    /* JADX INFO: renamed from: h1.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class C0072a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public e f5612a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List f5613b = new ArrayList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public b f5614c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f5615d = "";

        public C0072a a(c cVar) {
            this.f5613b.add(cVar);
            return this;
        }

        public a b() {
            return new a(this.f5612a, Collections.unmodifiableList(this.f5613b), this.f5614c, this.f5615d);
        }

        public C0072a c(String str) {
            this.f5615d = str;
            return this;
        }

        public C0072a d(b bVar) {
            this.f5614c = bVar;
            return this;
        }

        public C0072a e(e eVar) {
            this.f5612a = eVar;
            return this;
        }
    }

    public a(e eVar, List list, b bVar, String str) {
        this.f5608a = eVar;
        this.f5609b = list;
        this.f5610c = bVar;
        this.f5611d = str;
    }

    public static C0072a e() {
        return new C0072a();
    }

    public String a() {
        return this.f5611d;
    }

    public b b() {
        return this.f5610c;
    }

    public List c() {
        return this.f5609b;
    }

    public e d() {
        return this.f5608a;
    }

    public byte[] f() {
        return m.a(this);
    }
}
