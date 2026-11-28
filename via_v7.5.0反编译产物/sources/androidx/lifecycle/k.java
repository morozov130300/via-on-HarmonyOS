package androidx.lifecycle;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class k extends Lifecycle {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f958j = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f959b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public g.a f960c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Lifecycle.State f961d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final WeakReference f962e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f963f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f964g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f965h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ArrayList f966i;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }

        public final Lifecycle.State a(Lifecycle.State state1, Lifecycle.State state) {
            kotlin.jvm.internal.h.f(state1, "state1");
            return (state == null || state.compareTo(state1) >= 0) ? state1 : state;
        }

        public a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Lifecycle.State f967a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public h f968b;

        public b(i iVar, Lifecycle.State initialState) {
            kotlin.jvm.internal.h.f(initialState, "initialState");
            kotlin.jvm.internal.h.c(iVar);
            this.f968b = l.f(iVar);
            this.f967a = initialState;
        }

        public final void a(j jVar, Lifecycle.Event event) {
            kotlin.jvm.internal.h.f(event, "event");
            Lifecycle.State targetState = event.getTargetState();
            this.f967a = k.f958j.a(this.f967a, targetState);
            h hVar = this.f968b;
            kotlin.jvm.internal.h.c(jVar);
            hVar.e(jVar, event);
            this.f967a = targetState;
        }

        public final Lifecycle.State b() {
            return this.f967a;
        }
    }

    public k(j jVar, boolean z10) {
        this.f959b = z10;
        this.f960c = new g.a();
        this.f961d = Lifecycle.State.INITIALIZED;
        this.f966i = new ArrayList();
        this.f962e = new WeakReference(jVar);
    }

    @Override // androidx.lifecycle.Lifecycle
    public void a(i observer) {
        j jVar;
        kotlin.jvm.internal.h.f(observer, "observer");
        f("addObserver");
        Lifecycle.State state = this.f961d;
        Lifecycle.State state2 = Lifecycle.State.DESTROYED;
        if (state != state2) {
            state2 = Lifecycle.State.INITIALIZED;
        }
        b bVar = new b(observer, state2);
        if (((b) this.f960c.n(observer, bVar)) == null && (jVar = (j) this.f962e.get()) != null) {
            boolean z10 = this.f963f != 0 || this.f964g;
            Lifecycle.State stateE = e(observer);
            this.f963f++;
            while (bVar.b().compareTo(stateE) < 0 && this.f960c.contains(observer)) {
                m(bVar.b());
                Lifecycle.Event eventC = Lifecycle.Event.Companion.c(bVar.b());
                if (eventC == null) {
                    throw new IllegalStateException("no event up from " + bVar.b());
                }
                bVar.a(jVar, eventC);
                l();
                stateE = e(observer);
            }
            if (!z10) {
                o();
            }
            this.f963f--;
        }
    }

    @Override // androidx.lifecycle.Lifecycle
    public Lifecycle.State b() {
        return this.f961d;
    }

    @Override // androidx.lifecycle.Lifecycle
    public void c(i observer) {
        kotlin.jvm.internal.h.f(observer, "observer");
        f("removeObserver");
        this.f960c.o(observer);
    }

    public final void d(j jVar) {
        Iterator itDescendingIterator = this.f960c.descendingIterator();
        kotlin.jvm.internal.h.e(itDescendingIterator, "observerMap.descendingIterator()");
        while (itDescendingIterator.hasNext() && !this.f965h) {
            Map.Entry entry = (Map.Entry) itDescendingIterator.next();
            kotlin.jvm.internal.h.e(entry, "next()");
            i iVar = (i) entry.getKey();
            b bVar = (b) entry.getValue();
            while (bVar.b().compareTo(this.f961d) > 0 && !this.f965h && this.f960c.contains(iVar)) {
                Lifecycle.Event eventA = Lifecycle.Event.Companion.a(bVar.b());
                if (eventA == null) {
                    throw new IllegalStateException("no event down from " + bVar.b());
                }
                m(eventA.getTargetState());
                bVar.a(jVar, eventA);
                l();
            }
        }
    }

    public final Lifecycle.State e(i iVar) {
        b bVar;
        Map.Entry entryP = this.f960c.p(iVar);
        Lifecycle.State state = null;
        Lifecycle.State stateB = (entryP == null || (bVar = (b) entryP.getValue()) == null) ? null : bVar.b();
        if (!this.f966i.isEmpty()) {
            ArrayList arrayList = this.f966i;
            state = (Lifecycle.State) arrayList.get(arrayList.size() - 1);
        }
        a aVar = f958j;
        return aVar.a(aVar.a(this.f961d, stateB), state);
    }

    public final void f(String str) {
        if (!this.f959b || f.c.f().b()) {
            return;
        }
        throw new IllegalStateException(("Method " + str + " must be called on the main thread").toString());
    }

    public final void g(j jVar) {
        g.b.d dVarG = this.f960c.g();
        kotlin.jvm.internal.h.e(dVarG, "observerMap.iteratorWithAdditions()");
        while (dVarG.hasNext() && !this.f965h) {
            Map.Entry entry = (Map.Entry) dVarG.next();
            i iVar = (i) entry.getKey();
            b bVar = (b) entry.getValue();
            while (bVar.b().compareTo(this.f961d) < 0 && !this.f965h && this.f960c.contains(iVar)) {
                m(bVar.b());
                Lifecycle.Event eventC = Lifecycle.Event.Companion.c(bVar.b());
                if (eventC == null) {
                    throw new IllegalStateException("no event up from " + bVar.b());
                }
                bVar.a(jVar, eventC);
                l();
            }
        }
    }

    public void h(Lifecycle.Event event) {
        kotlin.jvm.internal.h.f(event, "event");
        f("handleLifecycleEvent");
        k(event.getTargetState());
    }

    public final boolean i() {
        if (this.f960c.size() == 0) {
            return true;
        }
        Map.Entry entryC = this.f960c.c();
        kotlin.jvm.internal.h.c(entryC);
        Lifecycle.State stateB = ((b) entryC.getValue()).b();
        Map.Entry entryH = this.f960c.h();
        kotlin.jvm.internal.h.c(entryH);
        Lifecycle.State stateB2 = ((b) entryH.getValue()).b();
        return stateB == stateB2 && this.f961d == stateB2;
    }

    public void j(Lifecycle.State state) {
        kotlin.jvm.internal.h.f(state, "state");
        f("markState");
        n(state);
    }

    public final void k(Lifecycle.State state) {
        Lifecycle.State state2 = this.f961d;
        if (state2 == state) {
            return;
        }
        if (state2 == Lifecycle.State.INITIALIZED && state == Lifecycle.State.DESTROYED) {
            throw new IllegalStateException(("no event down from " + this.f961d + " in component " + this.f962e.get()).toString());
        }
        this.f961d = state;
        if (this.f964g || this.f963f != 0) {
            this.f965h = true;
            return;
        }
        this.f964g = true;
        o();
        this.f964g = false;
        if (this.f961d == Lifecycle.State.DESTROYED) {
            this.f960c = new g.a();
        }
    }

    public final void l() {
        ArrayList arrayList = this.f966i;
        arrayList.remove(arrayList.size() - 1);
    }

    public final void m(Lifecycle.State state) {
        this.f966i.add(state);
    }

    public void n(Lifecycle.State state) {
        kotlin.jvm.internal.h.f(state, "state");
        f("setCurrentState");
        k(state);
    }

    public final void o() {
        j jVar = (j) this.f962e.get();
        if (jVar == null) {
            throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is already garbage collected. It is too late to change lifecycle state.");
        }
        while (!i()) {
            this.f965h = false;
            Lifecycle.State state = this.f961d;
            Map.Entry entryC = this.f960c.c();
            kotlin.jvm.internal.h.c(entryC);
            if (state.compareTo(((b) entryC.getValue()).b()) < 0) {
                d(jVar);
            }
            Map.Entry entryH = this.f960c.h();
            if (!this.f965h && entryH != null && this.f961d.compareTo(((b) entryH.getValue()).b()) > 0) {
                g(jVar);
            }
        }
        this.f965h = false;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public k(j provider) {
        this(provider, true);
        kotlin.jvm.internal.h.f(provider, "provider");
    }
}
