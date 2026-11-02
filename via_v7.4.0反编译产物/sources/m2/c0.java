package m2;

import com.google.firebase.components.DependencyException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class c0 implements e {

    /* renamed from: a, reason: collision with root package name */
    public final Set f8561a;

    /* renamed from: b, reason: collision with root package name */
    public final Set f8562b;

    /* renamed from: c, reason: collision with root package name */
    public final Set f8563c;

    /* renamed from: d, reason: collision with root package name */
    public final Set f8564d;

    /* renamed from: e, reason: collision with root package name */
    public final Set f8565e;

    /* renamed from: f, reason: collision with root package name */
    public final Set f8566f;

    /* renamed from: g, reason: collision with root package name */
    public final e f8567g;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class a implements g3.c {

        /* renamed from: a, reason: collision with root package name */
        public final Set f8568a;

        /* renamed from: b, reason: collision with root package name */
        public final g3.c f8569b;

        public a(Set set, g3.c cVar) {
            this.f8568a = set;
            this.f8569b = cVar;
        }
    }

    public c0(c cVar, e eVar) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        HashSet hashSet5 = new HashSet();
        for (r rVar : cVar.g()) {
            if (rVar.e()) {
                if (rVar.g()) {
                    hashSet4.add(rVar.c());
                } else {
                    hashSet.add(rVar.c());
                }
            } else if (rVar.d()) {
                hashSet3.add(rVar.c());
            } else if (rVar.g()) {
                hashSet5.add(rVar.c());
            } else {
                hashSet2.add(rVar.c());
            }
        }
        if (!cVar.k().isEmpty()) {
            hashSet.add(b0.b(g3.c.class));
        }
        this.f8561a = Collections.unmodifiableSet(hashSet);
        this.f8562b = Collections.unmodifiableSet(hashSet2);
        this.f8563c = Collections.unmodifiableSet(hashSet3);
        this.f8564d = Collections.unmodifiableSet(hashSet4);
        this.f8565e = Collections.unmodifiableSet(hashSet5);
        this.f8566f = cVar.k();
        this.f8567g = eVar;
    }

    @Override // m2.e
    public Object a(Class cls) {
        if (!this.f8561a.contains(b0.b(cls))) {
            throw new DependencyException(String.format("Attempting to request an undeclared dependency %s.", cls));
        }
        Object objA = this.f8567g.a(cls);
        return !cls.equals(g3.c.class) ? objA : new a(this.f8566f, (g3.c) objA);
    }

    @Override // m2.e
    public Set b(b0 b0Var) {
        if (this.f8564d.contains(b0Var)) {
            return this.f8567g.b(b0Var);
        }
        throw new DependencyException(String.format("Attempting to request an undeclared dependency Set<%s>.", b0Var));
    }

    @Override // m2.e
    public i3.b c(Class cls) {
        return g(b0.b(cls));
    }

    @Override // m2.e
    public i3.a d(b0 b0Var) {
        if (this.f8563c.contains(b0Var)) {
            return this.f8567g.d(b0Var);
        }
        throw new DependencyException(String.format("Attempting to request an undeclared dependency Deferred<%s>.", b0Var));
    }

    @Override // m2.e
    public /* synthetic */ Set e(Class cls) {
        return d.e(this, cls);
    }

    @Override // m2.e
    public Object f(b0 b0Var) {
        if (this.f8561a.contains(b0Var)) {
            return this.f8567g.f(b0Var);
        }
        throw new DependencyException(String.format("Attempting to request an undeclared dependency %s.", b0Var));
    }

    @Override // m2.e
    public i3.b g(b0 b0Var) {
        if (this.f8562b.contains(b0Var)) {
            return this.f8567g.g(b0Var);
        }
        throw new DependencyException(String.format("Attempting to request an undeclared dependency Provider<%s>.", b0Var));
    }

    @Override // m2.e
    public i3.b h(b0 b0Var) {
        if (this.f8565e.contains(b0Var)) {
            return this.f8567g.h(b0Var);
        }
        throw new DependencyException(String.format("Attempting to request an undeclared dependency Provider<Set<%s>>.", b0Var));
    }

    @Override // m2.e
    public i3.a i(Class cls) {
        return d(b0.b(cls));
    }
}
