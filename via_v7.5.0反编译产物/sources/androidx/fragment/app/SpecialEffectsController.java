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

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class SpecialEffectsController {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f696f = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f697a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f698b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f699c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f700d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f701e;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class Operation {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public State f702a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public LifecycleImpact f703b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Fragment f704c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List f705d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f706e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f707f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f708g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f709h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f710i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final List f711j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final List f712k;

        /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
        public enum LifecycleImpact {
            NONE,
            ADDING,
            REMOVING
        }

        /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
        public enum State {
            REMOVED,
            VISIBLE,
            GONE,
            INVISIBLE;

            public static final a Companion = new a(null);

            /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
            public static final class a {
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

                public a() {
                }
            }

            /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
            public /* synthetic */ class b {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f715a;

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
                    f715a = iArr;
                }
            }

            public static final State from(int i10) {
                return Companion.b(i10);
            }

            public final void applyState(View view, ViewGroup container) {
                kotlin.jvm.internal.h.f(view, "view");
                kotlin.jvm.internal.h.f(container, "container");
                int i10 = b.f715a[ordinal()];
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

        /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f716a;

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
                f716a = iArr;
            }
        }

        public Operation(State finalState, LifecycleImpact lifecycleImpact, Fragment fragment) {
            kotlin.jvm.internal.h.f(finalState, "finalState");
            kotlin.jvm.internal.h.f(lifecycleImpact, "lifecycleImpact");
            kotlin.jvm.internal.h.f(fragment, "fragment");
            this.f702a = finalState;
            this.f703b = lifecycleImpact;
            this.f704c = fragment;
            this.f705d = new ArrayList();
            this.f710i = true;
            ArrayList arrayList = new ArrayList();
            this.f711j = arrayList;
            this.f712k = arrayList;
        }

        public final void a(Runnable listener) {
            kotlin.jvm.internal.h.f(listener, "listener");
            this.f705d.add(listener);
        }

        public final void b(b effect) {
            kotlin.jvm.internal.h.f(effect, "effect");
            this.f711j.add(effect);
        }

        public final void c(ViewGroup container) {
            kotlin.jvm.internal.h.f(container, "container");
            this.f709h = false;
            if (this.f706e) {
                return;
            }
            this.f706e = true;
            if (this.f711j.isEmpty()) {
                e();
                return;
            }
            Iterator it = e7.w.M(this.f712k).iterator();
            while (it.hasNext()) {
                ((b) it.next()).a(container);
            }
        }

        public final void d(ViewGroup container, boolean z10) {
            kotlin.jvm.internal.h.f(container, "container");
            if (this.f706e) {
                return;
            }
            if (z10) {
                this.f708g = true;
            }
            c(container);
        }

        public void e() {
            this.f709h = false;
            if (this.f707f) {
                return;
            }
            if (FragmentManager.O0(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: " + this + " has called complete.");
            }
            this.f707f = true;
            Iterator it = this.f705d.iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
        }

        public final void f(b effect) {
            kotlin.jvm.internal.h.f(effect, "effect");
            if (this.f711j.remove(effect) && this.f711j.isEmpty()) {
                e();
            }
        }

        public final List g() {
            return this.f712k;
        }

        public final State h() {
            return this.f702a;
        }

        public final Fragment i() {
            return this.f704c;
        }

        public final LifecycleImpact j() {
            return this.f703b;
        }

        public final boolean k() {
            return this.f710i;
        }

        public final boolean l() {
            return this.f706e;
        }

        public final boolean m() {
            return this.f707f;
        }

        public final boolean n() {
            return this.f708g;
        }

        public final boolean o() {
            return this.f709h;
        }

        public final void p(State finalState, LifecycleImpact lifecycleImpact) {
            kotlin.jvm.internal.h.f(finalState, "finalState");
            kotlin.jvm.internal.h.f(lifecycleImpact, "lifecycleImpact");
            int i10 = a.f716a[lifecycleImpact.ordinal()];
            if (i10 == 1) {
                if (this.f702a == State.REMOVED) {
                    if (FragmentManager.O0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f704c + " mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = " + this.f703b + " to ADDING.");
                    }
                    this.f702a = State.VISIBLE;
                    this.f703b = LifecycleImpact.ADDING;
                    this.f710i = true;
                    return;
                }
                return;
            }
            if (i10 == 2) {
                if (FragmentManager.O0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f704c + " mFinalState = " + this.f702a + " -> REMOVED. mLifecycleImpact  = " + this.f703b + " to REMOVING.");
                }
                this.f702a = State.REMOVED;
                this.f703b = LifecycleImpact.REMOVING;
                this.f710i = true;
                return;
            }
            if (i10 == 3 && this.f702a != State.REMOVED) {
                if (FragmentManager.O0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f704c + " mFinalState = " + this.f702a + " -> " + finalState + '.');
                }
                this.f702a = finalState;
            }
        }

        public void q() {
            this.f709h = true;
        }

        public final void r(boolean z10) {
            this.f710i = z10;
        }

        public String toString() {
            return "Operation {" + Integer.toHexString(System.identityHashCode(this)) + "} {finalState = " + this.f702a + " lifecycleImpact = " + this.f703b + " fragment = " + this.f704c + '}';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a {
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
            Object tag = container.getTag(e0.b.f4068b);
            if (tag instanceof SpecialEffectsController) {
                return (SpecialEffectsController) tag;
            }
            SpecialEffectsController specialEffectsControllerA = factory.a(container);
            kotlin.jvm.internal.h.e(specialEffectsControllerA, "factory.createController(container)");
            container.setTag(e0.b.f4068b, specialEffectsControllerA);
            return specialEffectsControllerA;
        }

        public a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f717a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f718b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f719c;

        public final void a(ViewGroup container) {
            kotlin.jvm.internal.h.f(container, "container");
            if (!this.f719c) {
                c(container);
            }
            this.f719c = true;
        }

        public boolean b() {
            return this.f717a;
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
            if (!this.f718b) {
                f(container);
            }
            this.f718b = true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class c extends Operation {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final j0 f720l;

        /* JADX WARN: Illegal instructions before constructor call */
        public c(Operation.State finalState, Operation.LifecycleImpact lifecycleImpact, j0 fragmentStateManager) {
            kotlin.jvm.internal.h.f(finalState, "finalState");
            kotlin.jvm.internal.h.f(lifecycleImpact, "lifecycleImpact");
            kotlin.jvm.internal.h.f(fragmentStateManager, "fragmentStateManager");
            Fragment fragmentK = fragmentStateManager.k();
            kotlin.jvm.internal.h.e(fragmentK, "fragmentStateManager.fragment");
            super(finalState, lifecycleImpact, fragmentK);
            this.f720l = fragmentStateManager;
        }

        @Override // androidx.fragment.app.SpecialEffectsController.Operation
        public void e() {
            super.e();
            i().f583x = false;
            this.f720l.m();
        }

        @Override // androidx.fragment.app.SpecialEffectsController.Operation
        public void q() {
            if (o()) {
                return;
            }
            super.q();
            if (j() != Operation.LifecycleImpact.ADDING) {
                if (j() == Operation.LifecycleImpact.REMOVING) {
                    Fragment fragmentK = this.f720l.k();
                    kotlin.jvm.internal.h.e(fragmentK, "fragmentStateManager.fragment");
                    View viewA2 = fragmentK.A2();
                    kotlin.jvm.internal.h.e(viewA2, "fragment.requireView()");
                    if (FragmentManager.O0(2)) {
                        Log.v("FragmentManager", "Clearing focus " + viewA2.findFocus() + " on view " + viewA2 + " for Fragment " + fragmentK);
                    }
                    viewA2.clearFocus();
                    return;
                }
                return;
            }
            Fragment fragmentK2 = this.f720l.k();
            kotlin.jvm.internal.h.e(fragmentK2, "fragmentStateManager.fragment");
            View viewFindFocus = fragmentK2.T.findFocus();
            if (viewFindFocus != null) {
                fragmentK2.G2(viewFindFocus);
                if (FragmentManager.O0(2)) {
                    Log.v("FragmentManager", "requestFocus: Saved focused view " + viewFindFocus + " for Fragment " + fragmentK2);
                }
            }
            View viewA3 = i().A2();
            kotlin.jvm.internal.h.e(viewA3, "this.fragment.requireView()");
            if (viewA3.getParent() == null) {
                this.f720l.b();
                viewA3.setAlpha(0.0f);
            }
            if (viewA3.getAlpha() == 0.0f && viewA3.getVisibility() == 0) {
                viewA3.setVisibility(4);
            }
            viewA3.setAlpha(fragmentK2.P0());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f721a;

        static {
            int[] iArr = new int[Operation.LifecycleImpact.values().length];
            try {
                iArr[Operation.LifecycleImpact.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f721a = iArr;
        }
    }

    public SpecialEffectsController(ViewGroup container) {
        kotlin.jvm.internal.h.f(container, "container");
        this.f697a = container;
        this.f698b = new ArrayList();
        this.f699c = new ArrayList();
    }

    public static final void h(SpecialEffectsController this$0, c operation) {
        kotlin.jvm.internal.h.f(this$0, "this$0");
        kotlin.jvm.internal.h.f(operation, "$operation");
        if (this$0.f698b.contains(operation)) {
            Operation.State stateH = operation.h();
            View view = operation.i().T;
            kotlin.jvm.internal.h.e(view, "operation.fragment.mView");
            stateH.applyState(view, this$0.f697a);
        }
    }

    public static final void i(SpecialEffectsController this$0, c operation) {
        kotlin.jvm.internal.h.f(this$0, "this$0");
        kotlin.jvm.internal.h.f(operation, "$operation");
        this$0.f698b.remove(operation);
        this$0.f699c.remove(operation);
    }

    public static final SpecialEffectsController u(ViewGroup viewGroup, FragmentManager fragmentManager) {
        return f696f.a(viewGroup, fragmentManager);
    }

    public static final SpecialEffectsController v(ViewGroup viewGroup, y0 y0Var) {
        return f696f.b(viewGroup, y0Var);
    }

    public final void A() {
        for (Operation operation : this.f698b) {
            if (operation.j() == Operation.LifecycleImpact.ADDING) {
                View viewA2 = operation.i().A2();
                kotlin.jvm.internal.h.e(viewA2, "fragment.requireView()");
                operation.p(Operation.State.Companion.b(viewA2.getVisibility()), Operation.LifecycleImpact.NONE);
            }
        }
    }

    public final void B(boolean z10) {
        this.f700d = z10;
    }

    public final void c(Operation operation) {
        kotlin.jvm.internal.h.f(operation, "operation");
        if (operation.k()) {
            Operation.State stateH = operation.h();
            View viewA2 = operation.i().A2();
            kotlin.jvm.internal.h.e(viewA2, "operation.fragment.requireView()");
            stateH.applyState(viewA2, this.f697a);
            operation.r(false);
        }
    }

    public abstract void d(List list, boolean z10);

    public void e(List operations) {
        kotlin.jvm.internal.h.f(operations, "operations");
        ArrayList arrayList = new ArrayList();
        Iterator it = operations.iterator();
        while (it.hasNext()) {
            e7.t.r(arrayList, ((Operation) it.next()).g());
        }
        List listM = e7.w.M(e7.w.P(arrayList));
        int size = listM.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((b) listM.get(i10)).d(this.f697a);
        }
        int size2 = operations.size();
        for (int i11 = 0; i11 < size2; i11++) {
            c((Operation) operations.get(i11));
        }
        List listM2 = e7.w.M(operations);
        int size3 = listM2.size();
        for (int i12 = 0; i12 < size3; i12++) {
            Operation operation = (Operation) listM2.get(i12);
            if (operation.g().isEmpty()) {
                operation.e();
            }
        }
    }

    public final void f() {
        if (FragmentManager.O0(3)) {
            Log.d("FragmentManager", "SpecialEffectsController: Completing Back ");
        }
        z(this.f699c);
        e(this.f699c);
    }

    public final void g(Operation.State state, Operation.LifecycleImpact lifecycleImpact, j0 j0Var) {
        synchronized (this.f698b) {
            try {
                Fragment fragmentK = j0Var.k();
                kotlin.jvm.internal.h.e(fragmentK, "fragmentStateManager.fragment");
                Operation operationO = o(fragmentK);
                if (operationO == null) {
                    if (j0Var.k().f583x) {
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
                this.f698b.add(cVar);
                cVar.a(new Runnable() { // from class: androidx.fragment.app.w0
                    @Override // java.lang.Runnable
                    public final void run() {
                        SpecialEffectsController.h(this.f880c, cVar);
                    }
                });
                cVar.a(new Runnable() { // from class: androidx.fragment.app.x0
                    @Override // java.lang.Runnable
                    public final void run() {
                        SpecialEffectsController.i(this.f885c, cVar);
                    }
                });
                d7.h hVar = d7.h.f3935a;
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

    /* JADX WARN: Code duplicated, block: B:66:0x0162  */
    public final void n() {
        boolean z10;
        if (this.f701e) {
            return;
        }
        if (!this.f697a.isAttachedToWindow()) {
            q();
            this.f700d = false;
            return;
        }
        synchronized (this.f698b) {
            try {
                if (this.f698b.isEmpty()) {
                    List<Operation> listO = e7.w.O(this.f699c);
                    this.f699c.clear();
                    for (Operation operation : listO) {
                        if (FragmentManager.O0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Cancelling operation " + operation + " with no incoming pendingOperations");
                        }
                        operation.d(this.f697a, false);
                        if (!operation.m()) {
                            this.f699c.add(operation);
                        }
                    }
                } else {
                    List<Operation> listO2 = e7.w.O(this.f699c);
                    this.f699c.clear();
                    for (Operation operation2 : listO2) {
                        if (FragmentManager.O0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Cancelling operation " + operation2);
                        }
                        operation2.d(this.f697a, operation2.i().f583x);
                        if (!operation2.m()) {
                            this.f699c.add(operation2);
                        }
                    }
                    A();
                    List<Operation> listO3 = e7.w.O(this.f698b);
                    if (listO3.isEmpty()) {
                        return;
                    }
                    this.f698b.clear();
                    this.f699c.addAll(listO3);
                    if (FragmentManager.O0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Executing pending operations");
                    }
                    d(listO3, this.f700d);
                    Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
                    boolean z11 = true;
                    ref$BooleanRef.element = true;
                    boolean z12 = true;
                    for (Operation operation3 : listO3) {
                        List listG = operation3.g();
                        if (!androidx.activity.p.a(listG) || !listG.isEmpty()) {
                            Iterator it = listG.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    if (!((b) it.next()).b()) {
                                        z10 = false;
                                        break;
                                    }
                                } else {
                                    z10 = true;
                                    break;
                                }
                            }
                        } else {
                            z10 = true;
                            break;
                        }
                        ref$BooleanRef.element = z10;
                        if (!operation3.i().f583x) {
                            z12 = false;
                        }
                    }
                    if (ref$BooleanRef.element) {
                        ArrayList arrayList = new ArrayList();
                        Iterator it2 = listO3.iterator();
                        while (it2.hasNext()) {
                            e7.t.r(arrayList, ((Operation) it2.next()).g());
                        }
                        if (arrayList.isEmpty()) {
                            z11 = false;
                        }
                    } else {
                        z11 = false;
                    }
                    ref$BooleanRef.element = z11;
                    if (!z12) {
                        z(listO3);
                        e(listO3);
                    } else if (z11) {
                        z(listO3);
                        int size = listO3.size();
                        for (int i10 = 0; i10 < size; i10++) {
                            c((Operation) listO3.get(i10));
                        }
                    }
                    this.f700d = false;
                    if (FragmentManager.O0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Finished executing pending operations");
                    }
                }
                d7.h hVar = d7.h.f3935a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final Operation o(Fragment fragment) {
        Object next;
        Iterator it = this.f698b.iterator();
        while (it.hasNext()) {
            next = it.next();
            Operation operation = (Operation) next;
            if (kotlin.jvm.internal.h.a(operation.i(), fragment) && !operation.l()) {
                return (Operation) next;
            }
        }
        next = null;
        return (Operation) next;
    }

    public final Operation p(Fragment fragment) {
        Object next;
        Iterator it = this.f699c.iterator();
        while (it.hasNext()) {
            next = it.next();
            Operation operation = (Operation) next;
            if (kotlin.jvm.internal.h.a(operation.i(), fragment) && !operation.l()) {
                return (Operation) next;
            }
        }
        next = null;
        return (Operation) next;
    }

    public final void q() {
        if (FragmentManager.O0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Forcing all operations to complete");
        }
        boolean zIsAttachedToWindow = this.f697a.isAttachedToWindow();
        synchronized (this.f698b) {
            try {
                A();
                z(this.f698b);
                for (Operation operation : e7.w.O(this.f699c)) {
                    if (FragmentManager.O0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: " + (zIsAttachedToWindow ? "" : "Container " + this.f697a + " is not attached to window. ") + "Cancelling running operation " + operation);
                    }
                    operation.c(this.f697a);
                }
                for (Operation operation2 : e7.w.O(this.f698b)) {
                    if (FragmentManager.O0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: " + (zIsAttachedToWindow ? "" : "Container " + this.f697a + " is not attached to window. ") + "Cancelling pending operation " + operation2);
                    }
                    operation2.c(this.f697a);
                }
                d7.h hVar = d7.h.f3935a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void r() {
        if (this.f701e) {
            if (FragmentManager.O0(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: Forcing postponed operations");
            }
            this.f701e = false;
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
        int i10 = lifecycleImpactJ == null ? -1 : d.f721a[lifecycleImpactJ.ordinal()];
        return (i10 == -1 || i10 == 1) ? lifecycleImpactJ2 : lifecycleImpactJ;
    }

    public final ViewGroup t() {
        return this.f697a;
    }

    public final boolean w() {
        return !this.f698b.isEmpty();
    }

    public final void x() {
        Object objPrevious;
        synchronized (this.f698b) {
            try {
                A();
                List list = this.f698b;
                ListIterator listIterator = list.listIterator(list.size());
                while (true) {
                    if (!listIterator.hasPrevious()) {
                        objPrevious = null;
                        break;
                    }
                    objPrevious = listIterator.previous();
                    Operation operation = (Operation) objPrevious;
                    Operation.State.a aVar = Operation.State.Companion;
                    View view = operation.i().T;
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
                this.f701e = fragmentI != null ? fragmentI.l1() : false;
                d7.h hVar = d7.h.f3935a;
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
        List list = this.f699c;
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            e7.t.r(arrayList, ((Operation) it.next()).g());
        }
        List listM = e7.w.M(e7.w.P(arrayList));
        int size = listM.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((b) listM.get(i10)).e(backEvent, this.f697a);
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
            e7.t.r(arrayList, ((Operation) it.next()).g());
        }
        List listM = e7.w.M(e7.w.P(arrayList));
        int size2 = listM.size();
        for (int i11 = 0; i11 < size2; i11++) {
            ((b) listM.get(i11)).g(this.f697a);
        }
    }
}
