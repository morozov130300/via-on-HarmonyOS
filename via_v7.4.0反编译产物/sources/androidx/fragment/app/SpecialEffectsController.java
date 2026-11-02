package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.jvm.internal.Ref$BooleanRef;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class SpecialEffectsController {

    /* renamed from: f, reason: collision with root package name */
    public static final a f793f = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final ViewGroup f794a;

    /* renamed from: b, reason: collision with root package name */
    public final List f795b;

    /* renamed from: c, reason: collision with root package name */
    public final List f796c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f797d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f798e;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class Operation {

        /* renamed from: a, reason: collision with root package name */
        public State f799a;

        /* renamed from: b, reason: collision with root package name */
        public LifecycleImpact f800b;

        /* renamed from: c, reason: collision with root package name */
        public final Fragment f801c;

        /* renamed from: d, reason: collision with root package name */
        public final List f802d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f803e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f804f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f805g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f806h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f807i;

        /* renamed from: j, reason: collision with root package name */
        public final List f808j;

        /* renamed from: k, reason: collision with root package name */
        public final List f809k;

        /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
        public enum LifecycleImpact {
            NONE,
            ADDING,
            REMOVING
        }

        /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
        public enum State {
            REMOVED,
            VISIBLE,
            GONE,
            INVISIBLE;

            public static final a Companion = new a(null);

            /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
            public static final class a {
                public a() {
                }

                public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
                    this();
                }

                public final State a(View view) {
                    kotlin.jvm.internal.h.f(view, "<this>");
                    return (view.getAlpha() == 0.0f && view.getVisibility() == 0) ? State.INVISIBLE : b(view.getVisibility());
                }

                public final State b(int i10) {
                    if (i10 == 0) {
                        return State.VISIBLE;
                    }
                    if (i10 == 4) {
                        return State.INVISIBLE;
                    }
                    if (i10 == 8) {
                        return State.GONE;
                    }
                    throw new IllegalArgumentException("Unknown visibility " + i10);
                }
            }

            /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
            public /* synthetic */ class b {

                /* renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f812a;

                static {
                    int[] iArr = new int[State.values().length];
                    try {
                        iArr[State.REMOVED.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[State.VISIBLE.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[State.GONE.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[State.INVISIBLE.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    f812a = iArr;
                }
            }

            public static final State from(int i10) {
                return Companion.b(i10);
            }

            public final void applyState(View view, ViewGroup container) {
                kotlin.jvm.internal.h.f(view, "view");
                kotlin.jvm.internal.h.f(container, "container");
                int i10 = b.f812a[ordinal()];
                if (i10 == 1) {
                    ViewParent parent = view.getParent();
                    ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
                    if (viewGroup != null) {
                        if (FragmentManager.O0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Removing view " + view + " from container " + viewGroup);
                        }
                        viewGroup.removeView(view);
                        return;
                    }
                    return;
                }
                if (i10 == 2) {
                    if (FragmentManager.O0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to VISIBLE");
                    }
                    ViewParent parent2 = view.getParent();
                    if ((parent2 instanceof ViewGroup ? (ViewGroup) parent2 : null) == null) {
                        if (FragmentManager.O0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Adding view " + view + " to Container " + container);
                        }
                        container.addView(view);
                    }
                    view.setVisibility(0);
                    return;
                }
                if (i10 == 3) {
                    if (FragmentManager.O0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to GONE");
                    }
                    view.setVisibility(8);
                    return;
                }
                if (i10 != 4) {
                    return;
                }
                if (FragmentManager.O0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to INVISIBLE");
                }
                view.setVisibility(4);
            }
        }

        /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
        public /* synthetic */ class a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f813a;

            static {
                int[] iArr = new int[LifecycleImpact.values().length];
                try {
                    iArr[LifecycleImpact.ADDING.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[LifecycleImpact.REMOVING.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[LifecycleImpact.NONE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                f813a = iArr;
            }
        }

        public Operation(State finalState, LifecycleImpact lifecycleImpact, Fragment fragment) {
            kotlin.jvm.internal.h.f(finalState, "finalState");
            kotlin.jvm.internal.h.f(lifecycleImpact, "lifecycleImpact");
            kotlin.jvm.internal.h.f(fragment, "fragment");
            this.f799a = finalState;
            this.f800b = lifecycleImpact;
            this.f801c = fragment;
            this.f802d = new ArrayList();
            this.f807i = true;
            ArrayList arrayList = new ArrayList();
            this.f808j = arrayList;
            this.f809k = arrayList;
        }

        public final void a(Runnable listener) {
            kotlin.jvm.internal.h.f(listener, "listener");
            this.f802d.add(listener);
        }

        public final void b(b effect) {
            kotlin.jvm.internal.h.f(effect, "effect");
            this.f808j.add(effect);
        }

        public final void c(ViewGroup container) {
            kotlin.jvm.internal.h.f(container, "container");
            this.f806h = false;
            if (this.f803e) {
                return;
            }
            this.f803e = true;
            if (this.f808j.isEmpty()) {
                e();
                return;
            }
            Iterator it = k7.t.x(this.f809k).iterator();
            while (it.hasNext()) {
                ((b) it.next()).a(container);
            }
        }

        public final void d(ViewGroup container, boolean z10) {
            kotlin.jvm.internal.h.f(container, "container");
            if (this.f803e) {
                return;
            }
            if (z10) {
                this.f805g = true;
            }
            c(container);
        }

        public void e() {
            this.f806h = false;
            if (this.f804f) {
                return;
            }
            if (FragmentManager.O0(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: " + this + " has called complete.");
            }
            this.f804f = true;
            Iterator it = this.f802d.iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
        }

        public final void f(b effect) {
            kotlin.jvm.internal.h.f(effect, "effect");
            if (this.f808j.remove(effect) && this.f808j.isEmpty()) {
                e();
            }
        }

        public final List g() {
            return this.f809k;
        }

        public final State h() {
            return this.f799a;
        }

        public final Fragment i() {
            return this.f801c;
        }

        public final LifecycleImpact j() {
            return this.f800b;
        }

        public final boolean k() {
            return this.f807i;
        }

        public final boolean l() {
            return this.f803e;
        }

        public final boolean m() {
            return this.f804f;
        }

        public final boolean n() {
            return this.f805g;
        }

        public final boolean o() {
            return this.f806h;
        }

        public final void p(State finalState, LifecycleImpact lifecycleImpact) {
            kotlin.jvm.internal.h.f(finalState, "finalState");
            kotlin.jvm.internal.h.f(lifecycleImpact, "lifecycleImpact");
            int i10 = a.f813a[lifecycleImpact.ordinal()];
            if (i10 == 1) {
                if (this.f799a == State.REMOVED) {
                    if (FragmentManager.O0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f801c + " mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = " + this.f800b + " to ADDING.");
                    }
                    this.f799a = State.VISIBLE;
                    this.f800b = LifecycleImpact.ADDING;
                    this.f807i = true;
                    return;
                }
                return;
            }
            if (i10 == 2) {
                if (FragmentManager.O0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f801c + " mFinalState = " + this.f799a + " -> REMOVED. mLifecycleImpact  = " + this.f800b + " to REMOVING.");
                }
                this.f799a = State.REMOVED;
                this.f800b = LifecycleImpact.REMOVING;
                this.f807i = true;
                return;
            }
            if (i10 == 3 && this.f799a != State.REMOVED) {
                if (FragmentManager.O0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f801c + " mFinalState = " + this.f799a + " -> " + finalState + '.');
                }
                this.f799a = finalState;
            }
        }

        public void q() {
            this.f806h = true;
        }

        public final void r(boolean z10) {
            this.f807i = z10;
        }

        public String toString() {
            return "Operation {" + Integer.toHexString(System.identityHashCode(this)) + "} {finalState = " + this.f799a + " lifecycleImpact = " + this.f800b + " fragment = " + this.f801c + '}';
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }

        public final SpecialEffectsController a(ViewGroup container, FragmentManager fragmentManager) {
            kotlin.jvm.internal.h.f(container, "container");
            kotlin.jvm.internal.h.f(fragmentManager, "fragmentManager");
            y0 y0VarG0 = fragmentManager.G0();
            kotlin.jvm.internal.h.e(y0VarG0, "fragmentManager.specialEffectsControllerFactory");
            return b(container, y0VarG0);
        }

        public final SpecialEffectsController b(ViewGroup container, y0 factory) {
            kotlin.jvm.internal.h.f(container, "container");
            kotlin.jvm.internal.h.f(factory, "factory");
            Object tag = container.getTag(d0.b.f4436b);
            if (tag instanceof SpecialEffectsController) {
                return (SpecialEffectsController) tag;
            }
            SpecialEffectsController specialEffectsControllerA = factory.a(container);
            kotlin.jvm.internal.h.e(specialEffectsControllerA, "factory.createController(container)");
            container.setTag(d0.b.f4436b, specialEffectsControllerA);
            return specialEffectsControllerA;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f814a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f815b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f816c;

        public final void a(ViewGroup container) {
            kotlin.jvm.internal.h.f(container, "container");
            if (!this.f816c) {
                c(container);
            }
            this.f816c = true;
        }

        public boolean b() {
            return this.f814a;
        }

        public abstract void c(ViewGroup viewGroup);

        public abstract void d(ViewGroup viewGroup);

        public void e(androidx.activity.b backEvent, ViewGroup container) {
            kotlin.jvm.internal.h.f(backEvent, "backEvent");
            kotlin.jvm.internal.h.f(container, "container");
        }

        public void f(ViewGroup container) {
            kotlin.jvm.internal.h.f(container, "container");
        }

        public final void g(ViewGroup container) {
            kotlin.jvm.internal.h.f(container, "container");
            if (!this.f815b) {
                f(container);
            }
            this.f815b = true;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class c extends Operation {

        /* renamed from: l, reason: collision with root package name */
        public final j0 f817l;

        /* JADX WARN: Illegal instructions before constructor call */
        public c(Operation.State finalState, Operation.LifecycleImpact lifecycleImpact, j0 fragmentStateManager) {
            kotlin.jvm.internal.h.f(finalState, "finalState");
            kotlin.jvm.internal.h.f(lifecycleImpact, "lifecycleImpact");
            kotlin.jvm.internal.h.f(fragmentStateManager, "fragmentStateManager");
            Fragment fragmentK = fragmentStateManager.k();
            kotlin.jvm.internal.h.e(fragmentK, "fragmentStateManager.fragment");
            super(finalState, lifecycleImpact, fragmentK);
            this.f817l = fragmentStateManager;
        }

        @Override // androidx.fragment.app.SpecialEffectsController.Operation
        public void e() {
            super.e();
            i().f678v = false;
            this.f817l.m();
        }

        @Override // androidx.fragment.app.SpecialEffectsController.Operation
        public void q() {
            if (o()) {
                return;
            }
            super.q();
            if (j() != Operation.LifecycleImpact.ADDING) {
                if (j() == Operation.LifecycleImpact.REMOVING) {
                    Fragment fragmentK = this.f817l.k();
                    kotlin.jvm.internal.h.e(fragmentK, "fragmentStateManager.fragment");
                    View viewC2 = fragmentK.C2();
                    kotlin.jvm.internal.h.e(viewC2, "fragment.requireView()");
                    if (FragmentManager.O0(2)) {
                        Log.v("FragmentManager", "Clearing focus " + viewC2.findFocus() + " on view " + viewC2 + " for Fragment " + fragmentK);
                    }
                    viewC2.clearFocus();
                    return;
                }
                return;
            }
            Fragment fragmentK2 = this.f817l.k();
            kotlin.jvm.internal.h.e(fragmentK2, "fragmentStateManager.fragment");
            View viewFindFocus = fragmentK2.R.findFocus();
            if (viewFindFocus != null) {
                fragmentK2.I2(viewFindFocus);
                if (FragmentManager.O0(2)) {
                    Log.v("FragmentManager", "requestFocus: Saved focused view " + viewFindFocus + " for Fragment " + fragmentK2);
                }
            }
            View viewC22 = i().C2();
            kotlin.jvm.internal.h.e(viewC22, "this.fragment.requireView()");
            if (viewC22.getParent() == null) {
                this.f817l.b();
                viewC22.setAlpha(0.0f);
            }
            if (viewC22.getAlpha() == 0.0f && viewC22.getVisibility() == 0) {
                viewC22.setVisibility(4);
            }
            viewC22.setAlpha(fragmentK2.R0());
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public /* synthetic */ class d {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f818a;

        static {
            int[] iArr = new int[Operation.LifecycleImpact.values().length];
            try {
                iArr[Operation.LifecycleImpact.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f818a = iArr;
        }
    }

    public SpecialEffectsController(ViewGroup container) {
        kotlin.jvm.internal.h.f(container, "container");
        this.f794a = container;
        this.f795b = new ArrayList();
        this.f796c = new ArrayList();
    }

    public static final void h(SpecialEffectsController this$0, c operation) {
        kotlin.jvm.internal.h.f(this$0, "this$0");
        kotlin.jvm.internal.h.f(operation, "$operation");
        if (this$0.f795b.contains(operation)) {
            Operation.State stateH = operation.h();
            View view = operation.i().R;
            kotlin.jvm.internal.h.e(view, "operation.fragment.mView");
            stateH.applyState(view, this$0.f794a);
        }
    }

    public static final void i(SpecialEffectsController this$0, c operation) {
        kotlin.jvm.internal.h.f(this$0, "this$0");
        kotlin.jvm.internal.h.f(operation, "$operation");
        this$0.f795b.remove(operation);
        this$0.f796c.remove(operation);
    }

    public static final SpecialEffectsController u(ViewGroup viewGroup, FragmentManager fragmentManager) {
        return f793f.a(viewGroup, fragmentManager);
    }

    public static final SpecialEffectsController v(ViewGroup viewGroup, y0 y0Var) {
        return f793f.b(viewGroup, y0Var);
    }

    public final void A() {
        for (Operation operation : this.f795b) {
            if (operation.j() == Operation.LifecycleImpact.ADDING) {
                View viewC2 = operation.i().C2();
                kotlin.jvm.internal.h.e(viewC2, "fragment.requireView()");
                operation.p(Operation.State.Companion.b(viewC2.getVisibility()), Operation.LifecycleImpact.NONE);
            }
        }
    }

    public final void B(boolean z10) {
        this.f797d = z10;
    }

    public final void c(Operation operation) {
        kotlin.jvm.internal.h.f(operation, "operation");
        if (operation.k()) {
            Operation.State stateH = operation.h();
            View viewC2 = operation.i().C2();
            kotlin.jvm.internal.h.e(viewC2, "operation.fragment.requireView()");
            stateH.applyState(viewC2, this.f794a);
            operation.r(false);
        }
    }

    public abstract void d(List list, boolean z10);

    public void e(List operations) {
        kotlin.jvm.internal.h.f(operations, "operations");
        ArrayList arrayList = new ArrayList();
        Iterator it = operations.iterator();
        while (it.hasNext()) {
            k7.q.l(arrayList, ((Operation) it.next()).g());
        }
        List listX = k7.t.x(k7.t.A(arrayList));
        int size = listX.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((b) listX.get(i10)).d(this.f794a);
        }
        int size2 = operations.size();
        for (int i11 = 0; i11 < size2; i11++) {
            c((Operation) operations.get(i11));
        }
        List listX2 = k7.t.x(operations);
        int size3 = listX2.size();
        for (int i12 = 0; i12 < size3; i12++) {
            Operation operation = (Operation) listX2.get(i12);
            if (operation.g().isEmpty()) {
                operation.e();
            }
        }
    }

    public final void f() {
        if (FragmentManager.O0(3)) {
            Log.d("FragmentManager", "SpecialEffectsController: Completing Back ");
        }
        z(this.f796c);
        e(this.f796c);
    }

    public final void g(Operation.State state, Operation.LifecycleImpact lifecycleImpact, j0 j0Var) {
        synchronized (this.f795b) {
            try {
                Fragment fragmentK = j0Var.k();
                kotlin.jvm.internal.h.e(fragmentK, "fragmentStateManager.fragment");
                Operation operationO = o(fragmentK);
                if (operationO == null) {
                    if (j0Var.k().f678v) {
                        Fragment fragmentK2 = j0Var.k();
                        kotlin.jvm.internal.h.e(fragmentK2, "fragmentStateManager.fragment");
                        operationO = p(fragmentK2);
                    } else {
                        operationO = null;
                    }
                }
                if (operationO != null) {
                    operationO.p(state, lifecycleImpact);
                    return;
                }
                final c cVar = new c(state, lifecycleImpact, j0Var);
                this.f795b.add(cVar);
                cVar.a(new Runnable() { // from class: androidx.fragment.app.w0
                    @Override // java.lang.Runnable
                    public final void run() {
                        SpecialEffectsController.h(this.f979e, cVar);
                    }
                });
                cVar.a(new Runnable() { // from class: androidx.fragment.app.x0
                    @Override // java.lang.Runnable
                    public final void run() {
                        SpecialEffectsController.i(this.f984e, cVar);
                    }
                });
                j7.f fVar = j7.f.f7594a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void j(Operation.State finalState, j0 fragmentStateManager) {
        kotlin.jvm.internal.h.f(finalState, "finalState");
        kotlin.jvm.internal.h.f(fragmentStateManager, "fragmentStateManager");
        if (FragmentManager.O0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing add operation for fragment " + fragmentStateManager.k());
        }
        g(finalState, Operation.LifecycleImpact.ADDING, fragmentStateManager);
    }

    public final void k(j0 fragmentStateManager) {
        kotlin.jvm.internal.h.f(fragmentStateManager, "fragmentStateManager");
        if (FragmentManager.O0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing hide operation for fragment " + fragmentStateManager.k());
        }
        g(Operation.State.GONE, Operation.LifecycleImpact.NONE, fragmentStateManager);
    }

    public final void l(j0 fragmentStateManager) {
        kotlin.jvm.internal.h.f(fragmentStateManager, "fragmentStateManager");
        if (FragmentManager.O0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing remove operation for fragment " + fragmentStateManager.k());
        }
        g(Operation.State.REMOVED, Operation.LifecycleImpact.REMOVING, fragmentStateManager);
    }

    public final void m(j0 fragmentStateManager) {
        kotlin.jvm.internal.h.f(fragmentStateManager, "fragmentStateManager");
        if (FragmentManager.O0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing show operation for fragment " + fragmentStateManager.k());
        }
        g(Operation.State.VISIBLE, Operation.LifecycleImpact.NONE, fragmentStateManager);
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x0162  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void n() {
        boolean z10;
        if (this.f798e) {
            return;
        }
        if (!this.f794a.isAttachedToWindow()) {
            q();
            this.f797d = false;
            return;
        }
        synchronized (this.f795b) {
            try {
                if (this.f795b.isEmpty()) {
                    List<Operation> listZ = k7.t.z(this.f796c);
                    this.f796c.clear();
                    for (Operation operation : listZ) {
                        if (FragmentManager.O0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Cancelling operation " + operation + " with no incoming pendingOperations");
                        }
                        operation.d(this.f794a, false);
                        if (!operation.m()) {
                            this.f796c.add(operation);
                        }
                    }
                } else {
                    List<Operation> listZ2 = k7.t.z(this.f796c);
                    this.f796c.clear();
                    for (Operation operation2 : listZ2) {
                        if (FragmentManager.O0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Cancelling operation " + operation2);
                        }
                        operation2.d(this.f794a, operation2.i().f678v);
                        if (!operation2.m()) {
                            this.f796c.add(operation2);
                        }
                    }
                    A();
                    List<Operation> listZ3 = k7.t.z(this.f795b);
                    if (listZ3.isEmpty()) {
                        return;
                    }
                    this.f795b.clear();
                    this.f796c.addAll(listZ3);
                    if (FragmentManager.O0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Executing pending operations");
                    }
                    d(listZ3, this.f797d);
                    Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
                    boolean z11 = true;
                    ref$BooleanRef.element = true;
                    boolean z12 = true;
                    for (Operation operation3 : listZ3) {
                        List listG = operation3.g();
                        if (androidx.activity.p.a(listG) && listG.isEmpty()) {
                            z10 = true;
                        } else {
                            Iterator it = listG.iterator();
                            while (it.hasNext()) {
                                if (!((b) it.next()).b()) {
                                    z10 = false;
                                    break;
                                }
                            }
                            z10 = true;
                        }
                        ref$BooleanRef.element = z10;
                        if (!operation3.i().f678v) {
                            z12 = false;
                        }
                    }
                    if (ref$BooleanRef.element) {
                        ArrayList arrayList = new ArrayList();
                        Iterator it2 = listZ3.iterator();
                        while (it2.hasNext()) {
                            k7.q.l(arrayList, ((Operation) it2.next()).g());
                        }
                        if (arrayList.isEmpty()) {
                            z11 = false;
                        }
                        ref$BooleanRef.element = z11;
                        if (!z12) {
                            z(listZ3);
                            e(listZ3);
                        } else if (z11) {
                            z(listZ3);
                            int size = listZ3.size();
                            for (int i10 = 0; i10 < size; i10++) {
                                c((Operation) listZ3.get(i10));
                            }
                        }
                        this.f797d = false;
                        if (FragmentManager.O0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Finished executing pending operations");
                        }
                    }
                }
                j7.f fVar = j7.f.f7594a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final Operation o(Fragment fragment) {
        Object next;
        Iterator it = this.f795b.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            Operation operation = (Operation) next;
            if (kotlin.jvm.internal.h.a(operation.i(), fragment) && !operation.l()) {
                break;
            }
        }
        return (Operation) next;
    }

    public final Operation p(Fragment fragment) {
        Object next;
        Iterator it = this.f796c.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            Operation operation = (Operation) next;
            if (kotlin.jvm.internal.h.a(operation.i(), fragment) && !operation.l()) {
                break;
            }
        }
        return (Operation) next;
    }

    public final void q() {
        if (FragmentManager.O0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Forcing all operations to complete");
        }
        boolean zIsAttachedToWindow = this.f794a.isAttachedToWindow();
        synchronized (this.f795b) {
            try {
                A();
                z(this.f795b);
                for (Operation operation : k7.t.z(this.f796c)) {
                    if (FragmentManager.O0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: " + (zIsAttachedToWindow ? "" : "Container " + this.f794a + " is not attached to window. ") + "Cancelling running operation " + operation);
                    }
                    operation.c(this.f794a);
                }
                for (Operation operation2 : k7.t.z(this.f795b)) {
                    if (FragmentManager.O0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: " + (zIsAttachedToWindow ? "" : "Container " + this.f794a + " is not attached to window. ") + "Cancelling pending operation " + operation2);
                    }
                    operation2.c(this.f794a);
                }
                j7.f fVar = j7.f.f7594a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void r() {
        if (this.f798e) {
            if (FragmentManager.O0(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: Forcing postponed operations");
            }
            this.f798e = false;
            n();
        }
    }

    public final Operation.LifecycleImpact s(j0 fragmentStateManager) {
        kotlin.jvm.internal.h.f(fragmentStateManager, "fragmentStateManager");
        Fragment fragmentK = fragmentStateManager.k();
        kotlin.jvm.internal.h.e(fragmentK, "fragmentStateManager.fragment");
        Operation operationO = o(fragmentK);
        Operation.LifecycleImpact lifecycleImpactJ = operationO != null ? operationO.j() : null;
        Operation operationP = p(fragmentK);
        Operation.LifecycleImpact lifecycleImpactJ2 = operationP != null ? operationP.j() : null;
        int i10 = lifecycleImpactJ == null ? -1 : d.f818a[lifecycleImpactJ.ordinal()];
        return (i10 == -1 || i10 == 1) ? lifecycleImpactJ2 : lifecycleImpactJ;
    }

    public final ViewGroup t() {
        return this.f794a;
    }

    public final boolean w() {
        return !this.f795b.isEmpty();
    }

    public final void x() {
        Object objPrevious;
        synchronized (this.f795b) {
            try {
                A();
                List list = this.f795b;
                ListIterator listIterator = list.listIterator(list.size());
                while (true) {
                    if (!listIterator.hasPrevious()) {
                        objPrevious = null;
                        break;
                    }
                    objPrevious = listIterator.previous();
                    Operation operation = (Operation) objPrevious;
                    Operation.State.a aVar = Operation.State.Companion;
                    View view = operation.i().R;
                    kotlin.jvm.internal.h.e(view, "operation.fragment.mView");
                    Operation.State stateA = aVar.a(view);
                    Operation.State stateH = operation.h();
                    Operation.State state = Operation.State.VISIBLE;
                    if (stateH == state && stateA != state) {
                        break;
                    }
                }
                Operation operation2 = (Operation) objPrevious;
                Fragment fragmentI = operation2 != null ? operation2.i() : null;
                this.f798e = fragmentI != null ? fragmentI.n1() : false;
                j7.f fVar = j7.f.f7594a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void y(androidx.activity.b backEvent) {
        kotlin.jvm.internal.h.f(backEvent, "backEvent");
        if (FragmentManager.O0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Processing Progress " + backEvent.a());
        }
        List list = this.f796c;
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            k7.q.l(arrayList, ((Operation) it.next()).g());
        }
        List listX = k7.t.x(k7.t.A(arrayList));
        int size = listX.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((b) listX.get(i10)).e(backEvent, this.f794a);
        }
    }

    public final void z(List list) {
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((Operation) list.get(i10)).q();
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            k7.q.l(arrayList, ((Operation) it.next()).g());
        }
        List listX = k7.t.x(k7.t.A(arrayList));
        int size2 = listX.size();
        for (int i11 = 0; i11 < size2; i11++) {
            ((b) listX.get(i11)).g(this.f794a);
        }
    }
}
