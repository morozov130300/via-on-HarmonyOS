package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import g.b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class i extends Lifecycle {

    /* renamed from: j, reason: collision with root package name */
    public static final a f1043j = new a(null);

    /* renamed from: b, reason: collision with root package name */
    public final boolean f1044b;

    /* renamed from: c, reason: collision with root package name */
    public g.a f1045c;

    /* renamed from: d, reason: collision with root package name */
    public Lifecycle.State f1046d;

    /* renamed from: e, reason: collision with root package name */
    public final WeakReference f1047e;

    /* renamed from: f, reason: collision with root package name */
    public int f1048f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f1049g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f1050h;

    /* renamed from: i, reason: collision with root package name */
    public ArrayList f1051i;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }

        public final Lifecycle.State a(Lifecycle.State state1, Lifecycle.State state) {
            kotlin.jvm.internal.h.f(state1, "state1");
            return (state == null || state.compareTo(state1) >= 0) ? state1 : state;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public Lifecycle.State f1052a;

        /* renamed from: b, reason: collision with root package name */
        public f f1053b;

        public b(g gVar, Lifecycle.State initialState) {
            kotlin.jvm.internal.h.f(initialState, "initialState");
            kotlin.jvm.internal.h.c(gVar);
            this.f1053b = j.f(gVar);
            this.f1052a = initialState;
        }

        public final void a(h hVar, Lifecycle.Event event) {
            kotlin.jvm.internal.h.f(event, "event");
            Lifecycle.State targetState = event.getTargetState();
            this.f1052a = i.f1043j.a(this.f1052a, targetState);
            f fVar = this.f1053b;
            kotlin.jvm.internal.h.c(hVar);
            fVar.a(hVar, event);
            this.f1052a = targetState;
        }

        public final Lifecycle.State b() {
            return this.f1052a;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public i(h provider) {
        this(provider, true);
        kotlin.jvm.internal.h.f(provider, "provider");
    }

    public i(h hVar, boolean z10) {
        this.f1044b = z10;
        this.f1045c = new g.a();
        this.f1046d = Lifecycle.State.INITIALIZED;
        this.f1051i = new ArrayList();
        this.f1047e = new WeakReference(hVar);
    }

    @Override // androidx.lifecycle.Lifecycle
    public void a(g observer) {
        h hVar;
        kotlin.jvm.internal.h.f(observer, "observer");
        f("addObserver");
        Lifecycle.State state = this.f1046d;
        Lifecycle.State state2 = Lifecycle.State.DESTROYED;
        if (state != state2) {
            state2 = Lifecycle.State.INITIALIZED;
        }
        b bVar = new b(observer, state2);
        if (((b) this.f1045c.n(observer, bVar)) == null && (hVar = (h) this.f1047e.get()) != null) {
            boolean z10 = this.f1048f != 0 || this.f1049g;
            Lifecycle.State stateE = e(observer);
            this.f1048f++;
            while (bVar.b().compareTo(stateE) < 0 && this.f1045c.contains(observer)) {
                m(bVar.b());
                Lifecycle.Event eventC = Lifecycle.Event.Companion.c(bVar.b());
                if (eventC == null) {
                    throw new IllegalStateException("no event up from " + bVar.b());
                }
                bVar.a(hVar, eventC);
                l();
                stateE = e(observer);
            }
            if (!z10) {
                o();
            }
            this.f1048f--;
        }
    }

    @Override // androidx.lifecycle.Lifecycle
    public Lifecycle.State b() {
        return this.f1046d;
    }

    @Override // androidx.lifecycle.Lifecycle
    public void c(g observer) {
        kotlin.jvm.internal.h.f(observer, "observer");
        f("removeObserver");
        this.f1045c.o(observer);
    }

    public final void d(h hVar) {
        Iterator itDescendingIterator = this.f1045c.descendingIterator();
        kotlin.jvm.internal.h.e(itDescendingIterator, "observerMap.descendingIterator()");
        while (itDescendingIterator.hasNext() && !this.f1050h) {
            Map.Entry entry = (Map.Entry) itDescendingIterator.next();
            kotlin.jvm.internal.h.e(entry, "next()");
            g gVar = (g) entry.getKey();
            b bVar = (b) entry.getValue();
            while (bVar.b().compareTo(this.f1046d) > 0 && !this.f1050h && this.f1045c.contains(gVar)) {
                Lifecycle.Event eventA = Lifecycle.Event.Companion.a(bVar.b());
                if (eventA == null) {
                    throw new IllegalStateException("no event down from " + bVar.b());
                }
                m(eventA.getTargetState());
                bVar.a(hVar, eventA);
                l();
            }
        }
    }

    public final Lifecycle.State e(g gVar) {
        b bVar;
        Map.Entry entryP = this.f1045c.p(gVar);
        Lifecycle.State state = null;
        Lifecycle.State stateB = (entryP == null || (bVar = (b) entryP.getValue()) == null) ? null : bVar.b();
        if (!this.f1051i.isEmpty()) {
            state = (Lifecycle.State) this.f1051i.get(r0.size() - 1);
        }
        a aVar = f1043j;
        return aVar.a(aVar.a(this.f1046d, stateB), state);
    }

    public final void f(String str) {
        if (!this.f1044b || f.c.f().b()) {
            return;
        }
        throw new IllegalStateException(("Method " + str + " must be called on the main thread").toString());
    }

    public final void g(h hVar) {
        b.d dVarG = this.f1045c.g();
        kotlin.jvm.internal.h.e(dVarG, "observerMap.iteratorWithAdditions()");
        while (dVarG.hasNext() && !this.f1050h) {
            Map.Entry entry = (Map.Entry) dVarG.next();
            g gVar = (g) entry.getKey();
            b bVar = (b) entry.getValue();
            while (bVar.b().compareTo(this.f1046d) < 0 && !this.f1050h && this.f1045c.contains(gVar)) {
                m(bVar.b());
                Lifecycle.Event eventC = Lifecycle.Event.Companion.c(bVar.b());
                if (eventC == null) {
                    throw new IllegalStateException("no event up from " + bVar.b());
                }
                bVar.a(hVar, eventC);
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
        if (this.f1045c.size() == 0) {
            return true;
        }
        Map.Entry entryC = this.f1045c.c();
        kotlin.jvm.internal.h.c(entryC);
        Lifecycle.State stateB = ((b) entryC.getValue()).b();
        Map.Entry entryH = this.f1045c.h();
        kotlin.jvm.internal.h.c(entryH);
        Lifecycle.State stateB2 = ((b) entryH.getValue()).b();
        return stateB == stateB2 && this.f1046d == stateB2;
    }

    public void j(Lifecycle.State state) {
        kotlin.jvm.internal.h.f(state, "state");
        f("markState");
        n(state);
    }

    public final void k(Lifecycle.State state) {
        Lifecycle.State state2 = this.f1046d;
        if (state2 == state) {
            return;
        }
        if (state2 == Lifecycle.State.INITIALIZED && state == Lifecycle.State.DESTROYED) {
            throw new IllegalStateException(("no event down from " + this.f1046d + " in component " + this.f1047e.get()).toString());
        }
        this.f1046d = state;
        if (this.f1049g || this.f1048f != 0) {
            this.f1050h = true;
            return;
        }
        this.f1049g = true;
        o();
        this.f1049g = false;
        if (this.f1046d == Lifecycle.State.DESTROYED) {
            this.f1045c = new g.a();
        }
    }

    public final void l() {
        this.f1051i.remove(r0.size() - 1);
    }

    public final void m(Lifecycle.State state) {
        this.f1051i.add(state);
    }

    public void n(Lifecycle.State state) {
        kotlin.jvm.internal.h.f(state, "state");
        f("setCurrentState");
        k(state);
    }

    public final void o() {
        h hVar = (h) this.f1047e.get();
        if (hVar == null) {
            throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is already garbage collected. It is too late to change lifecycle state.");
        }
        while (!i()) {
            this.f1050h = false;
            Lifecycle.State state = this.f1046d;
            Map.Entry entryC = this.f1045c.c();
            kotlin.jvm.internal.h.c(entryC);
            if (state.compareTo(((b) entryC.getValue()).b()) < 0) {
                d(hVar);
            }
            Map.Entry entryH = this.f1045c.h();
            if (!this.f1050h && entryH != null && this.f1046d.compareTo(((b) entryH.getValue()).b()) > 0) {
                g(hVar);
            }
        }
        this.f1050h = false;
    }
}
