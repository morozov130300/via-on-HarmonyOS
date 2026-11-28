package n2;

import com.google.firebase.components.DependencyException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class c0 implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f10525a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set f10526b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set f10527c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set f10528d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set f10529e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Set f10530f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final e f10531g;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class a implements h3.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Set f10532a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final h3.c f10533b;

        public a(Set set, h3.c cVar) {
            this.f10532a = set;
            this.f10533b = cVar;
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
            hashSet.add(b0.b(h3.c.class));
        }
        this.f10525a = Collections.unmodifiableSet(hashSet);
        this.f10526b = Collections.unmodifiableSet(hashSet2);
        this.f10527c = Collections.unmodifiableSet(hashSet3);
        this.f10528d = Collections.unmodifiableSet(hashSet4);
        this.f10529e = Collections.unmodifiableSet(hashSet5);
        this.f10530f = cVar.k();
        this.f10531g = eVar;
    }

    @Override // n2.e
    public Object a(Class cls) {
        if (!this.f10525a.contains(b0.b(cls))) {
            throw new DependencyException(String.format("Attempting to request an undeclared dependency %s.", cls));
        }
        Object objA = this.f10531g.a(cls);
        return !cls.equals(h3.c.class) ? objA : new a(this.f10530f, (h3.c) objA);
    }

    @Override // n2.e
    public j3.a b(b0 b0Var) {
        if (this.f10527c.contains(b0Var)) {
            return this.f10531g.b(b0Var);
        }
        throw new DependencyException(String.format("Attempting to request an undeclared dependency Deferred<%s>.", b0Var));
    }

    @Override // n2.e
    public Set c(b0 b0Var) {
        if (this.f10528d.contains(b0Var)) {
            return this.f10531g.c(b0Var);
        }
        throw new DependencyException(String.format("Attempting to request an undeclared dependency Set<%s>.", b0Var));
    }

    @Override // n2.e
    public j3.b d(Class cls) {
        return f(b0.b(cls));
    }

    @Override // n2.e
    public j3.b e(b0 b0Var) {
        if (this.f10529e.contains(b0Var)) {
            return this.f10531g.e(b0Var);
        }
        throw new DependencyException(String.format("Attempting to request an undeclared dependency Provider<Set<%s>>.", b0Var));
    }

    @Override // n2.e
    public j3.b f(b0 b0Var) {
        if (this.f10526b.contains(b0Var)) {
            return this.f10531g.f(b0Var);
        }
        throw new DependencyException(String.format("Attempting to request an undeclared dependency Provider<%s>.", b0Var));
    }

    @Override // n2.e
    public Object g(b0 b0Var) {
        if (this.f10525a.contains(b0Var)) {
            return this.f10531g.g(b0Var);
        }
        throw new DependencyException(String.format("Attempting to request an undeclared dependency %s.", b0Var));
    }

    @Override // n2.e
    public /* synthetic */ Set h(Class cls) {
        return d.e(this, cls);
    }

    @Override // n2.e
    public j3.a i(Class cls) {
        return b(b0.b(cls));
    }
}
