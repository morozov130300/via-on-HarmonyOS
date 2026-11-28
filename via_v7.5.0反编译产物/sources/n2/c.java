package n2;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10511a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set f10512b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set f10513c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f10514d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f10515e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final h f10516f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Set f10517g;

    public static b c(Class cls) {
        return new b(cls, new Class[0]);
    }

    public static b d(Class cls, Class... clsArr) {
        return new b(cls, clsArr);
    }

    public static b e(b0 b0Var) {
        return new b(b0Var, new b0[0]);
    }

    public static b f(b0 b0Var, b0... b0VarArr) {
        return new b(b0Var, b0VarArr);
    }

    public static c l(final Object obj, Class cls) {
        return m(cls).e(new h() { // from class: n2.a
            @Override // n2.h
            public final Object a(e eVar) {
                return c.b(obj, eVar);
            }
        }).c();
    }

    public static b m(Class cls) {
        return c(cls).f();
    }

    public static c q(final Object obj, Class cls, Class... clsArr) {
        return d(cls, clsArr).e(new h() { // from class: n2.b
            @Override // n2.h
            public final Object a(e eVar) {
                return c.a(obj, eVar);
            }
        }).c();
    }

    public Set g() {
        return this.f10513c;
    }

    public h h() {
        return this.f10516f;
    }

    public String i() {
        return this.f10511a;
    }

    public Set j() {
        return this.f10512b;
    }

    public Set k() {
        return this.f10517g;
    }

    public boolean n() {
        return this.f10514d == 1;
    }

    public boolean o() {
        return this.f10514d == 2;
    }

    public boolean p() {
        return this.f10515e == 0;
    }

    public c r(h hVar) {
        return new c(this.f10511a, this.f10512b, this.f10513c, this.f10514d, this.f10515e, hVar, this.f10517g);
    }

    public String toString() {
        return "Component<" + Arrays.toString(this.f10512b.toArray()) + ">{" + this.f10514d + ", type=" + this.f10515e + ", deps=" + Arrays.toString(this.f10513c.toArray()) + "}";
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f10518a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Set f10519b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Set f10520c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f10521d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f10522e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public h f10523f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Set f10524g;

        public b b(r rVar) {
            a0.c(rVar, "Null dependency");
            i(rVar.c());
            this.f10520c.add(rVar);
            return this;
        }

        public c c() {
            a0.d(this.f10523f != null, "Missing required property: factory.");
            return new c(this.f10518a, new HashSet(this.f10519b), new HashSet(this.f10520c), this.f10521d, this.f10522e, this.f10523f, this.f10524g);
        }

        public b d() {
            return h(2);
        }

        public b e(h hVar) {
            this.f10523f = (h) a0.c(hVar, "Null factory");
            return this;
        }

        public final b f() {
            this.f10522e = 1;
            return this;
        }

        public b g(String str) {
            this.f10518a = str;
            return this;
        }

        public final b h(int i10) {
            a0.d(this.f10521d == 0, "Instantiation type has already been set.");
            this.f10521d = i10;
            return this;
        }

        public final void i(b0 b0Var) {
            a0.a(!this.f10519b.contains(b0Var), "Components are not allowed to depend on interfaces they themselves provide.");
        }

        public b(Class cls, Class... clsArr) {
            this.f10518a = null;
            HashSet hashSet = new HashSet();
            this.f10519b = hashSet;
            this.f10520c = new HashSet();
            this.f10521d = 0;
            this.f10522e = 0;
            this.f10524g = new HashSet();
            a0.c(cls, "Null interface");
            hashSet.add(b0.b(cls));
            for (Class cls2 : clsArr) {
                a0.c(cls2, "Null interface");
                this.f10519b.add(b0.b(cls2));
            }
        }

        public b(b0 b0Var, b0... b0VarArr) {
            this.f10518a = null;
            HashSet hashSet = new HashSet();
            this.f10519b = hashSet;
            this.f10520c = new HashSet();
            this.f10521d = 0;
            this.f10522e = 0;
            this.f10524g = new HashSet();
            a0.c(b0Var, "Null interface");
            hashSet.add(b0Var);
            for (b0 b0Var2 : b0VarArr) {
                a0.c(b0Var2, "Null interface");
            }
            Collections.addAll(this.f10519b, b0VarArr);
        }
    }

    public c(String str, Set set, Set set2, int i10, int i11, h hVar, Set set3) {
        this.f10511a = str;
        this.f10512b = Collections.unmodifiableSet(set);
        this.f10513c = Collections.unmodifiableSet(set2);
        this.f10514d = i10;
        this.f10515e = i11;
        this.f10516f = hVar;
        this.f10517g = Collections.unmodifiableSet(set3);
    }

    public static /* synthetic */ Object a(Object obj, e eVar) {
        return obj;
    }

    public static /* synthetic */ Object b(Object obj, e eVar) {
        return obj;
    }
}
