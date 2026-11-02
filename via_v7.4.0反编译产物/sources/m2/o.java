package m2;

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
import m2.o;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class o implements e, b3.a {

    /* renamed from: h, reason: collision with root package name */
    public static final i3.b f8581h = new i3.b() { // from class: m2.k
        @Override // i3.b
        public final Object get() {
            return Collections.EMPTY_SET;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public final Map f8582a;

    /* renamed from: b, reason: collision with root package name */
    public final Map f8583b;

    /* renamed from: c, reason: collision with root package name */
    public final Map f8584c;

    /* renamed from: d, reason: collision with root package name */
    public final List f8585d;

    /* renamed from: e, reason: collision with root package name */
    public final t f8586e;

    /* renamed from: f, reason: collision with root package name */
    public final AtomicReference f8587f;

    /* renamed from: g, reason: collision with root package name */
    public final j f8588g;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final Executor f8589a;

        /* renamed from: b, reason: collision with root package name */
        public final List f8590b = new ArrayList();

        /* renamed from: c, reason: collision with root package name */
        public final List f8591c = new ArrayList();

        /* renamed from: d, reason: collision with root package name */
        public j f8592d = j.f8574a;

        public b(Executor executor) {
            this.f8589a = executor;
        }

        public static /* synthetic */ ComponentRegistrar a(ComponentRegistrar componentRegistrar) {
            return componentRegistrar;
        }

        public b b(c cVar) {
            this.f8591c.add(cVar);
            return this;
        }

        public b c(final ComponentRegistrar componentRegistrar) {
            this.f8590b.add(new i3.b() { // from class: m2.p
                @Override // i3.b
                public final Object get() {
                    return o.b.a(componentRegistrar);
                }
            });
            return this;
        }

        public b d(Collection collection) {
            this.f8590b.addAll(collection);
            return this;
        }

        public o e() {
            return new o(this.f8589a, this.f8590b, this.f8591c, this.f8592d);
        }

        public b f(j jVar) {
            this.f8592d = jVar;
            return this;
        }
    }

    public o(Executor executor, Iterable iterable, Collection collection, j jVar) {
        this.f8582a = new HashMap();
        this.f8583b = new HashMap();
        this.f8584c = new HashMap();
        this.f8587f = new AtomicReference();
        t tVar = new t(executor);
        this.f8586e = tVar;
        this.f8588g = jVar;
        ArrayList arrayList = new ArrayList();
        arrayList.add(c.q(tVar, t.class, g3.d.class, g3.c.class));
        arrayList.add(c.q(this, b3.a.class, new Class[0]));
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (cVar != null) {
                arrayList.add(cVar);
            }
        }
        this.f8585d = q(iterable);
        n(arrayList);
    }

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

    @Override // m2.e
    public /* synthetic */ Object a(Class cls) {
        return d.a(this, cls);
    }

    @Override // m2.e
    public /* synthetic */ Set b(b0 b0Var) {
        return d.f(this, b0Var);
    }

    @Override // m2.e
    public /* synthetic */ i3.b c(Class cls) {
        return d.d(this, cls);
    }

    @Override // m2.e
    public i3.a d(b0 b0Var) {
        i3.b bVarG = g(b0Var);
        return bVarG == null ? z.e() : bVarG instanceof z ? (z) bVarG : z.f(bVarG);
    }

    @Override // m2.e
    public /* synthetic */ Set e(Class cls) {
        return d.e(this, cls);
    }

    @Override // m2.e
    public /* synthetic */ Object f(b0 b0Var) {
        return d.b(this, b0Var);
    }

    @Override // m2.e
    public synchronized i3.b g(b0 b0Var) {
        a0.c(b0Var, "Null interface requested.");
        return (i3.b) this.f8583b.get(b0Var);
    }

    @Override // m2.e
    public synchronized i3.b h(b0 b0Var) {
        v vVar = (v) this.f8584c.get(b0Var);
        if (vVar != null) {
            return vVar;
        }
        return f8581h;
    }

    @Override // m2.e
    public /* synthetic */ i3.a i(Class cls) {
        return d.c(this, cls);
    }

    public final void n(List list) {
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            Iterator it = this.f8585d.iterator();
            while (it.hasNext()) {
                try {
                    ComponentRegistrar componentRegistrar = (ComponentRegistrar) ((i3.b) it.next()).get();
                    if (componentRegistrar != null) {
                        list.addAll(this.f8588g.a(componentRegistrar));
                        it.remove();
                    }
                } catch (InvalidRegistrarException e10) {
                    it.remove();
                    Log.w("ComponentDiscovery", "Invalid component registrar.", e10);
                }
            }
            if (this.f8582a.isEmpty()) {
                q.a(list);
            } else {
                ArrayList arrayList2 = new ArrayList(this.f8582a.keySet());
                arrayList2.addAll(list);
                q.a(arrayList2);
            }
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                final c cVar = (c) it2.next();
                this.f8582a.put(cVar, new u(new i3.b() { // from class: m2.l
                    @Override // i3.b
                    public final Object get() {
                        return o.j(this.f8575a, cVar);
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
            i3.b bVar = (i3.b) entry.getValue();
            if (cVar.n() || (cVar.o() && z10)) {
                bVar.get();
            }
        }
        this.f8586e.c();
    }

    public void p(boolean z10) {
        HashMap map;
        if (autodispose2.c.a(this.f8587f, null, Boolean.valueOf(z10))) {
            synchronized (this) {
                map = new HashMap(this.f8582a);
            }
            o(map, z10);
        }
    }

    public final void r() {
        Boolean bool = (Boolean) this.f8587f.get();
        if (bool != null) {
            o(this.f8582a, bool.booleanValue());
        }
    }

    public final void s() {
        for (c cVar : this.f8582a.keySet()) {
            for (r rVar : cVar.g()) {
                if (rVar.g() && !this.f8584c.containsKey(rVar.c())) {
                    this.f8584c.put(rVar.c(), v.b(Collections.EMPTY_SET));
                } else if (this.f8583b.containsKey(rVar.c())) {
                    continue;
                } else {
                    if (rVar.f()) {
                        throw new MissingDependencyException(String.format("Unsatisfied dependency for component %s: %s", cVar, rVar.c()));
                    }
                    if (!rVar.g()) {
                        this.f8583b.put(rVar.c(), z.e());
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
                final i3.b bVar = (i3.b) this.f8582a.get(cVar);
                for (b0 b0Var : cVar.j()) {
                    if (this.f8583b.containsKey(b0Var)) {
                        final z zVar = (z) ((i3.b) this.f8583b.get(b0Var));
                        arrayList.add(new Runnable() { // from class: m2.m
                            @Override // java.lang.Runnable
                            public final void run() {
                                zVar.g(bVar);
                            }
                        });
                    } else {
                        this.f8583b.put(b0Var, bVar);
                    }
                }
            }
        }
        return arrayList;
    }

    public final List u() {
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        for (Map.Entry entry : this.f8582a.entrySet()) {
            c cVar = (c) entry.getKey();
            if (!cVar.p()) {
                i3.b bVar = (i3.b) entry.getValue();
                for (b0 b0Var : cVar.j()) {
                    if (!map.containsKey(b0Var)) {
                        map.put(b0Var, new HashSet());
                    }
                    ((Set) map.get(b0Var)).add(bVar);
                }
            }
        }
        for (Map.Entry entry2 : map.entrySet()) {
            if (this.f8584c.containsKey(entry2.getKey())) {
                final v vVar = (v) this.f8584c.get(entry2.getKey());
                for (final i3.b bVar2 : (Set) entry2.getValue()) {
                    arrayList.add(new Runnable() { // from class: m2.n
                        @Override // java.lang.Runnable
                        public final void run() {
                            vVar.a(bVar2);
                        }
                    });
                }
            } else {
                this.f8584c.put((b0) entry2.getKey(), v.b((Collection) entry2.getValue()));
            }
        }
        return arrayList;
    }
}
