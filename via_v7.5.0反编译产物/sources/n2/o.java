package n2;

import android.util.Log;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.InvalidRegistrarException;
import com.google.firebase.components.MissingDependencyException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class o implements e, c3.a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final j3.b f10545h = new j3.b() { // from class: n2.k
        @Override // j3.b
        public final Object get() {
            return Collections.EMPTY_SET;
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f10546a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f10547b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f10548c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f10549d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final t f10550e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicReference f10551f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final j f10552g;

    public static /* synthetic */ Object j(o oVar, c cVar) {
        oVar.getClass();
        return cVar.h().a(new c0(cVar, oVar));
    }

    public static b m(Executor executor) {
        return new b(executor);
    }

    public static List q(Iterable iterable) {
        ArrayList arrayList = new ArrayList();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    @Override // n2.e
    public /* synthetic */ Object a(Class cls) {
        return d.a(this, cls);
    }

    @Override // n2.e
    public j3.a b(b0 b0Var) {
        j3.b bVarF = f(b0Var);
        if (bVarF == null) {
            return z.e();
        }
        return bVarF instanceof z ? (z) bVarF : z.f(bVarF);
    }

    @Override // n2.e
    public /* synthetic */ Set c(b0 b0Var) {
        return d.f(this, b0Var);
    }

    @Override // n2.e
    public /* synthetic */ j3.b d(Class cls) {
        return d.d(this, cls);
    }

    @Override // n2.e
    public synchronized j3.b e(b0 b0Var) {
        v vVar = (v) this.f10548c.get(b0Var);
        if (vVar != null) {
            return vVar;
        }
        return f10545h;
    }

    @Override // n2.e
    public synchronized j3.b f(b0 b0Var) {
        a0.c(b0Var, "Null interface requested.");
        return (j3.b) this.f10547b.get(b0Var);
    }

    @Override // n2.e
    public /* synthetic */ Object g(b0 b0Var) {
        return d.b(this, b0Var);
    }

    @Override // n2.e
    public /* synthetic */ Set h(Class cls) {
        return d.e(this, cls);
    }

    @Override // n2.e
    public /* synthetic */ j3.a i(Class cls) {
        return d.c(this, cls);
    }

    public final void n(List list) {
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            Iterator it = this.f10549d.iterator();
            while (it.hasNext()) {
                try {
                    ComponentRegistrar componentRegistrar = (ComponentRegistrar) ((j3.b) it.next()).get();
                    if (componentRegistrar != null) {
                        list.addAll(this.f10552g.a(componentRegistrar));
                        it.remove();
                    }
                } catch (InvalidRegistrarException e10) {
                    it.remove();
                    Log.w("ComponentDiscovery", "Invalid component registrar.", e10);
                }
            }
            if (this.f10546a.isEmpty()) {
                q.a(list);
            } else {
                ArrayList arrayList2 = new ArrayList(this.f10546a.keySet());
                arrayList2.addAll(list);
                q.a(arrayList2);
            }
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                final c cVar = (c) it2.next();
                this.f10546a.put(cVar, new u(new j3.b() { // from class: n2.l
                    @Override // j3.b
                    public final Object get() {
                        return o.j(this.f10539a, cVar);
                    }
                }));
            }
            arrayList.addAll(t(list));
            arrayList.addAll(u());
            s();
        }
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            ((Runnable) it3.next()).run();
        }
        r();
    }

    public final void o(Map map, boolean z10) {
        for (Map.Entry entry : map.entrySet()) {
            c cVar = (c) entry.getKey();
            j3.b bVar = (j3.b) entry.getValue();
            if (cVar.n() || (cVar.o() && z10)) {
                bVar.get();
            }
        }
        this.f10550e.c();
    }

    public void p(boolean z10) {
        HashMap map;
        if (autodispose2.c.a(this.f10551f, null, Boolean.valueOf(z10))) {
            synchronized (this) {
                map = new HashMap(this.f10546a);
            }
            o(map, z10);
        }
    }

    public final void r() {
        Boolean bool = (Boolean) this.f10551f.get();
        if (bool != null) {
            o(this.f10546a, bool.booleanValue());
        }
    }

    public final void s() {
        for (c cVar : this.f10546a.keySet()) {
            for (r rVar : cVar.g()) {
                if (rVar.g() && !this.f10548c.containsKey(rVar.c())) {
                    this.f10548c.put(rVar.c(), v.b(Collections.EMPTY_SET));
                } else if (this.f10547b.containsKey(rVar.c())) {
                    continue;
                } else {
                    if (rVar.f()) {
                        throw new MissingDependencyException(String.format("Unsatisfied dependency for component %s: %s", cVar, rVar.c()));
                    }
                    if (!rVar.g()) {
                        this.f10547b.put(rVar.c(), z.e());
                    }
                }
            }
        }
    }

    public final List t(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (cVar.p()) {
                final j3.b bVar = (j3.b) this.f10546a.get(cVar);
                for (b0 b0Var : cVar.j()) {
                    if (this.f10547b.containsKey(b0Var)) {
                        final z zVar = (z) ((j3.b) this.f10547b.get(b0Var));
                        arrayList.add(new Runnable() { // from class: n2.m
                            @Override // java.lang.Runnable
                            public final void run() {
                                zVar.g(bVar);
                            }
                        });
                    } else {
                        this.f10547b.put(b0Var, bVar);
                    }
                }
            }
        }
        return arrayList;
    }

    public final List u() {
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        for (Map.Entry entry : this.f10546a.entrySet()) {
            c cVar = (c) entry.getKey();
            if (!cVar.p()) {
                j3.b bVar = (j3.b) entry.getValue();
                for (b0 b0Var : cVar.j()) {
                    if (!map.containsKey(b0Var)) {
                        map.put(b0Var, new HashSet());
                    }
                    ((Set) map.get(b0Var)).add(bVar);
                }
            }
        }
        for (Map.Entry entry2 : map.entrySet()) {
            if (this.f10548c.containsKey(entry2.getKey())) {
                final v vVar = (v) this.f10548c.get(entry2.getKey());
                for (final j3.b bVar2 : (Set) entry2.getValue()) {
                    arrayList.add(new Runnable() { // from class: n2.n
                        @Override // java.lang.Runnable
                        public final void run() {
                            vVar.a(bVar2);
                        }
                    });
                }
            } else {
                this.f10548c.put((b0) entry2.getKey(), v.b((Collection) entry2.getValue()));
            }
        }
        return arrayList;
    }

    public o(Executor executor, Iterable iterable, Collection collection, j jVar) {
        this.f10546a = new HashMap();
        this.f10547b = new HashMap();
        this.f10548c = new HashMap();
        this.f10551f = new AtomicReference();
        t tVar = new t(executor);
        this.f10550e = tVar;
        this.f10552g = jVar;
        ArrayList arrayList = new ArrayList();
        arrayList.add(c.q(tVar, t.class, h3.d.class, h3.c.class));
        arrayList.add(c.q(this, c3.a.class, new Class[0]));
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (cVar != null) {
                arrayList.add(cVar);
            }
        }
        this.f10549d = q(iterable);
        n(arrayList);
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Executor f10553a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List f10554b = new ArrayList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List f10555c = new ArrayList();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public j f10556d = j.f10538a;

        public b(Executor executor) {
            this.f10553a = executor;
        }

        public b b(c cVar) {
            this.f10555c.add(cVar);
            return this;
        }

        public b c(final ComponentRegistrar componentRegistrar) {
            this.f10554b.add(new j3.b() { // from class: n2.p
                @Override // j3.b
                public final Object get() {
                    return o.b.a(componentRegistrar);
                }
            });
            return this;
        }

        public b d(Collection collection) {
            this.f10554b.addAll(collection);
            return this;
        }

        public o e() {
            return new o(this.f10553a, this.f10554b, this.f10555c, this.f10556d);
        }

        public b f(j jVar) {
            this.f10556d = jVar;
            return this;
        }

        public static /* synthetic */ ComponentRegistrar a(ComponentRegistrar componentRegistrar) {
            return componentRegistrar;
        }
    }
}
