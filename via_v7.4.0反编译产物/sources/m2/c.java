package m2;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final String f8547a;

    /* renamed from: b, reason: collision with root package name */
    public final Set f8548b;

    /* renamed from: c, reason: collision with root package name */
    public final Set f8549c;

    /* renamed from: d, reason: collision with root package name */
    public final int f8550d;

    /* renamed from: e, reason: collision with root package name */
    public final int f8551e;

    /* renamed from: f, reason: collision with root package name */
    public final h f8552f;

    /* renamed from: g, reason: collision with root package name */
    public final Set f8553g;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public String f8554a;

        /* renamed from: b, reason: collision with root package name */
        public final Set f8555b;

        /* renamed from: c, reason: collision with root package name */
        public final Set f8556c;

        /* renamed from: d, reason: collision with root package name */
        public int f8557d;

        /* renamed from: e, reason: collision with root package name */
        public int f8558e;

        /* renamed from: f, reason: collision with root package name */
        public h f8559f;

        /* renamed from: g, reason: collision with root package name */
        public final Set f8560g;

        public b(Class cls, Class... clsArr) {
            this.f8554a = null;
            HashSet hashSet = new HashSet();
            this.f8555b = hashSet;
            this.f8556c = new HashSet();
            this.f8557d = 0;
            this.f8558e = 0;
            this.f8560g = new HashSet();
            a0.c(cls, "Null interface");
            hashSet.add(b0.b(cls));
            for (Class cls2 : clsArr) {
                a0.c(cls2, "Null interface");
                this.f8555b.add(b0.b(cls2));
            }
        }

        public b(b0 b0Var, b0... b0VarArr) {
            this.f8554a = null;
            HashSet hashSet = new HashSet();
            this.f8555b = hashSet;
            this.f8556c = new HashSet();
            this.f8557d = 0;
            this.f8558e = 0;
            this.f8560g = new HashSet();
            a0.c(b0Var, "Null interface");
            hashSet.add(b0Var);
            for (b0 b0Var2 : b0VarArr) {
                a0.c(b0Var2, "Null interface");
            }
            Collections.addAll(this.f8555b, b0VarArr);
        }

        public b b(r rVar) {
            a0.c(rVar, "Null dependency");
            i(rVar.c());
            this.f8556c.add(rVar);
            return this;
        }

        public c c() {
            a0.d(this.f8559f != null, "Missing required property: factory.");
            return new c(this.f8554a, new HashSet(this.f8555b), new HashSet(this.f8556c), this.f8557d, this.f8558e, this.f8559f, this.f8560g);
        }

        public b d() {
            return h(2);
        }

        public b e(h hVar) {
            this.f8559f = (h) a0.c(hVar, "Null factory");
            return this;
        }

        public final b f() {
            this.f8558e = 1;
            return this;
        }

        public b g(String str) {
            this.f8554a = str;
            return this;
        }

        public final b h(int i10) {
            a0.d(this.f8557d == 0, "Instantiation type has already been set.");
            this.f8557d = i10;
            return this;
        }

        public final void i(b0 b0Var) {
            a0.a(!this.f8555b.contains(b0Var), "Components are not allowed to depend on interfaces they themselves provide.");
        }
    }

    public c(String str, Set set, Set set2, int i10, int i11, h hVar, Set set3) {
        this.f8547a = str;
        this.f8548b = Collections.unmodifiableSet(set);
        this.f8549c = Collections.unmodifiableSet(set2);
        this.f8550d = i10;
        this.f8551e = i11;
        this.f8552f = hVar;
        this.f8553g = Collections.unmodifiableSet(set3);
    }

    public static /* synthetic */ Object a(Object obj, e eVar) {
        return obj;
    }

    public static /* synthetic */ Object b(Object obj, e eVar) {
        return obj;
    }

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
        return m(cls).e(new h() { // from class: m2.a
            @Override // m2.h
            public final Object a(e eVar) {
                return c.b(obj, eVar);
            }
        }).c();
    }

    public static b m(Class cls) {
        return c(cls).f();
    }

    public static c q(final Object obj, Class cls, Class... clsArr) {
        return d(cls, clsArr).e(new h() { // from class: m2.b
            @Override // m2.h
            public final Object a(e eVar) {
                return c.a(obj, eVar);
            }
        }).c();
    }

    public Set g() {
        return this.f8549c;
    }

    public h h() {
        return this.f8552f;
    }

    public String i() {
        return this.f8547a;
    }

    public Set j() {
        return this.f8548b;
    }

    public Set k() {
        return this.f8553g;
    }

    public boolean n() {
        return this.f8550d == 1;
    }

    public boolean o() {
        return this.f8550d == 2;
    }

    public boolean p() {
        return this.f8551e == 0;
    }

    public c r(h hVar) {
        return new c(this.f8547a, this.f8548b, this.f8549c, this.f8550d, this.f8551e, hVar, this.f8553g);
    }

    public String toString() {
        return "Component<" + Arrays.toString(this.f8548b.toArray()) + ">{" + this.f8550d + ", type=" + this.f8551e + ", deps=" + Arrays.toString(this.f8549c.toArray()) + "}";
    }
}
