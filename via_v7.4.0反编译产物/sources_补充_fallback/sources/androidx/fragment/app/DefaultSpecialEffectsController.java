package androidx.fragment.app;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class DefaultSpecialEffectsController extends androidx.fragment.app.SpecialEffectsController {

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class TransitionEffect extends androidx.fragment.app.SpecialEffectsController.b {

        /* renamed from: d, reason: collision with root package name */
        public final java.util.List f617d;

        /* renamed from: e, reason: collision with root package name */
        public final androidx.fragment.app.SpecialEffectsController.Operation f618e;

        /* renamed from: f, reason: collision with root package name */
        public final androidx.fragment.app.SpecialEffectsController.Operation f619f;

        /* renamed from: g, reason: collision with root package name */
        public final androidx.fragment.app.t0 f620g;

        /* renamed from: h, reason: collision with root package name */
        public final java.lang.Object f621h;

        /* renamed from: i, reason: collision with root package name */
        public final java.util.ArrayList f622i;

        /* renamed from: j, reason: collision with root package name */
        public final java.util.ArrayList f623j;

        /* renamed from: k, reason: collision with root package name */
        public final k.a f624k;

        /* renamed from: l, reason: collision with root package name */
        public final java.util.ArrayList f625l;

        /* renamed from: m, reason: collision with root package name */
        public final java.util.ArrayList f626m;

        /* renamed from: n, reason: collision with root package name */
        public final k.a f627n;

        /* renamed from: o, reason: collision with root package name */
        public final k.a f628o;

        /* renamed from: p, reason: collision with root package name */
        public final boolean f629p;

        /* renamed from: q, reason: collision with root package name */
        public final u.i f630q;

        /* renamed from: r, reason: collision with root package name */
        public java.lang.Object f631r;

        public TransitionEffect(java.util.List r2, androidx.fragment.app.SpecialEffectsController.Operation r3, androidx.fragment.app.SpecialEffectsController.Operation r4, androidx.fragment.app.t0 r5, java.lang.Object r6, java.util.ArrayList r7, java.util.ArrayList r8, k.a r9, java.util.ArrayList r10, java.util.ArrayList r11, k.a r12, k.a r13, boolean r14) {
                r1 = this;
                java.lang.String r0 = "transitionInfos"
                kotlin.jvm.internal.h.f(r2, r0)
                java.lang.String r0 = "transitionImpl"
                kotlin.jvm.internal.h.f(r5, r0)
                java.lang.String r0 = "sharedElementFirstOutViews"
                kotlin.jvm.internal.h.f(r7, r0)
                java.lang.String r0 = "sharedElementLastInViews"
                kotlin.jvm.internal.h.f(r8, r0)
                java.lang.String r0 = "sharedElementNameMapping"
                kotlin.jvm.internal.h.f(r9, r0)
                java.lang.String r0 = "enteringNames"
                kotlin.jvm.internal.h.f(r10, r0)
                java.lang.String r0 = "exitingNames"
                kotlin.jvm.internal.h.f(r11, r0)
                java.lang.String r0 = "firstOutViews"
                kotlin.jvm.internal.h.f(r12, r0)
                java.lang.String r0 = "lastInViews"
                kotlin.jvm.internal.h.f(r13, r0)
                r1.<init>()
                r1.f617d = r2
                r1.f618e = r3
                r1.f619f = r4
                r1.f620g = r5
                r1.f621h = r6
                r1.f622i = r7
                r1.f623j = r8
                r1.f624k = r9
                r1.f625l = r10
                r1.f626m = r11
                r1.f627n = r12
                r1.f628o = r13
                r1.f629p = r14
                u.i r2 = new u.i
                r2.<init>()
                r1.f630q = r2
                return
        }

        public static final void A(androidx.fragment.app.SpecialEffectsController.Operation r2, androidx.fragment.app.DefaultSpecialEffectsController.TransitionEffect r3) {
                java.lang.String r0 = "$operation"
                kotlin.jvm.internal.h.f(r2, r0)
                java.lang.String r0 = "this$0"
                kotlin.jvm.internal.h.f(r3, r0)
                r0 = 2
                boolean r0 = androidx.fragment.app.FragmentManager.O0(r0)
                if (r0 == 0) goto L2c
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "Transition for operation "
                r0.append(r1)
                r0.append(r2)
                java.lang.String r1 = " has completed"
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                java.lang.String r1 = "FragmentManager"
                android.util.Log.v(r1, r0)
            L2c:
                r2.f(r3)
                return
        }

        public static /* synthetic */ void h(androidx.fragment.app.SpecialEffectsController.Operation r0, androidx.fragment.app.SpecialEffectsController.Operation r1, androidx.fragment.app.DefaultSpecialEffectsController.TransitionEffect r2) {
                p(r0, r1, r2)
                return
        }

        public static /* synthetic */ void i(androidx.fragment.app.t0 r0, android.view.View r1, android.graphics.Rect r2) {
                q(r0, r1, r2)
                return
        }

        public static /* synthetic */ void j(java.util.ArrayList r0) {
                r(r0)
                return
        }

        public static /* synthetic */ void k(kotlin.jvm.internal.Ref$ObjectRef r0) {
                z(r0)
                return
        }

        public static /* synthetic */ void l(androidx.fragment.app.SpecialEffectsController.Operation r0, androidx.fragment.app.DefaultSpecialEffectsController.TransitionEffect r1) {
                y(r0, r1)
                return
        }

        public static /* synthetic */ void m(androidx.fragment.app.SpecialEffectsController.Operation r0, androidx.fragment.app.DefaultSpecialEffectsController.TransitionEffect r1) {
                A(r0, r1)
                return
        }

        public static final void p(androidx.fragment.app.SpecialEffectsController.Operation r2, androidx.fragment.app.SpecialEffectsController.Operation r3, androidx.fragment.app.DefaultSpecialEffectsController.TransitionEffect r4) {
                java.lang.String r0 = "this$0"
                kotlin.jvm.internal.h.f(r4, r0)
                androidx.fragment.app.Fragment r2 = r2.i()
                androidx.fragment.app.Fragment r3 = r3.i()
                boolean r0 = r4.f629p
                k.a r4 = r4.f628o
                r1 = 0
                androidx.fragment.app.m0.a(r2, r3, r0, r4, r1)
                return
        }

        public static final void q(androidx.fragment.app.t0 r1, android.view.View r2, android.graphics.Rect r3) {
                java.lang.String r0 = "$impl"
                kotlin.jvm.internal.h.f(r1, r0)
                java.lang.String r0 = "$lastInEpicenterRect"
                kotlin.jvm.internal.h.f(r3, r0)
                r1.k(r2, r3)
                return
        }

        public static final void r(java.util.ArrayList r1) {
                java.lang.String r0 = "$transitioningViews"
                kotlin.jvm.internal.h.f(r1, r0)
                r0 = 4
                androidx.fragment.app.m0.d(r1, r0)
                return
        }

        public static final void y(androidx.fragment.app.SpecialEffectsController.Operation r2, androidx.fragment.app.DefaultSpecialEffectsController.TransitionEffect r3) {
                java.lang.String r0 = "$operation"
                kotlin.jvm.internal.h.f(r2, r0)
                java.lang.String r0 = "this$0"
                kotlin.jvm.internal.h.f(r3, r0)
                r0 = 2
                boolean r0 = androidx.fragment.app.FragmentManager.O0(r0)
                if (r0 == 0) goto L2c
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "Transition for operation "
                r0.append(r1)
                r0.append(r2)
                java.lang.String r1 = " has completed"
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                java.lang.String r1 = "FragmentManager"
                android.util.Log.v(r1, r0)
            L2c:
                r2.f(r3)
                return
        }

        public static final void z(kotlin.jvm.internal.Ref$ObjectRef r1) {
                java.lang.String r0 = "$seekCancelLambda"
                kotlin.jvm.internal.h.f(r1, r0)
                T r1 = r1.element
                q7.a r1 = (q7.a) r1
                if (r1 == 0) goto Le
                r1.invoke()
            Le:
                return
        }

        public final void B(java.util.ArrayList r9, android.view.ViewGroup r10, q7.a r11) {
                r8 = this;
                r0 = 4
                androidx.fragment.app.m0.d(r9, r0)
                androidx.fragment.app.t0 r0 = r8.f620g
                java.util.ArrayList r1 = r8.f623j
                java.util.ArrayList r6 = r0.q(r1)
                r0 = 2
                boolean r0 = androidx.fragment.app.FragmentManager.O0(r0)
                if (r0 == 0) goto L90
                java.lang.String r0 = ">>>>> Beginning transition <<<<<"
                java.lang.String r1 = "FragmentManager"
                android.util.Log.v(r1, r0)
                java.lang.String r0 = ">>>>> SharedElementFirstOutViews <<<<<"
                android.util.Log.v(r1, r0)
                java.util.ArrayList r0 = r8.f622i
                java.util.Iterator r0 = r0.iterator()
            L25:
                boolean r2 = r0.hasNext()
                java.lang.String r3 = " Name: "
                java.lang.String r4 = "View: "
                if (r2 == 0) goto L57
                java.lang.Object r2 = r0.next()
                java.lang.String r5 = "sharedElementFirstOutViews"
                kotlin.jvm.internal.h.e(r2, r5)
                android.view.View r2 = (android.view.View) r2
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                r5.append(r4)
                r5.append(r2)
                r5.append(r3)
                java.lang.String r2 = x.r.A(r2)
                r5.append(r2)
                java.lang.String r2 = r5.toString()
                android.util.Log.v(r1, r2)
                goto L25
            L57:
                java.lang.String r0 = ">>>>> SharedElementLastInViews <<<<<"
                android.util.Log.v(r1, r0)
                java.util.ArrayList r0 = r8.f623j
                java.util.Iterator r0 = r0.iterator()
            L62:
                boolean r2 = r0.hasNext()
                if (r2 == 0) goto L90
                java.lang.Object r2 = r0.next()
                java.lang.String r5 = "sharedElementLastInViews"
                kotlin.jvm.internal.h.e(r2, r5)
                android.view.View r2 = (android.view.View) r2
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                r5.append(r4)
                r5.append(r2)
                r5.append(r3)
                java.lang.String r2 = x.r.A(r2)
                r5.append(r2)
                java.lang.String r2 = r5.toString()
                android.util.Log.v(r1, r2)
                goto L62
            L90:
                r11.invoke()
                androidx.fragment.app.t0 r2 = r8.f620g
                java.util.ArrayList r4 = r8.f622i
                java.util.ArrayList r5 = r8.f623j
                k.a r7 = r8.f624k
                r3 = r10
                r2.y(r3, r4, r5, r6, r7)
                r10 = 0
                androidx.fragment.app.m0.d(r9, r10)
                androidx.fragment.app.t0 r9 = r8.f620g
                java.lang.Object r10 = r8.f621h
                java.util.ArrayList r11 = r8.f622i
                java.util.ArrayList r0 = r8.f623j
                r9.A(r10, r11, r0)
                return
        }

        public final void C(java.lang.Object r1) {
                r0 = this;
                r0.f631r = r1
                return
        }

        @Override // androidx.fragment.app.SpecialEffectsController.b
        public boolean b() {
                r4 = this;
                androidx.fragment.app.t0 r0 = r4.f620g
                boolean r0 = r0.m()
                if (r0 == 0) goto L4e
                java.util.List r0 = r4.f617d
                boolean r1 = androidx.activity.p.a(r0)
                if (r1 == 0) goto L17
                boolean r1 = r0.isEmpty()
                if (r1 == 0) goto L17
                goto L40
            L17:
                java.util.Iterator r0 = r0.iterator()
            L1b:
                boolean r1 = r0.hasNext()
                if (r1 == 0) goto L40
                java.lang.Object r1 = r0.next()
                androidx.fragment.app.DefaultSpecialEffectsController$g r1 = (androidx.fragment.app.DefaultSpecialEffectsController.g) r1
                int r2 = android.os.Build.VERSION.SDK_INT
                r3 = 34
                if (r2 < r3) goto L4e
                java.lang.Object r2 = r1.f()
                if (r2 == 0) goto L4e
                androidx.fragment.app.t0 r2 = r4.f620g
                java.lang.Object r1 = r1.f()
                boolean r1 = r2.n(r1)
                if (r1 == 0) goto L4e
                goto L1b
            L40:
                java.lang.Object r0 = r4.f621h
                if (r0 == 0) goto L4c
                androidx.fragment.app.t0 r1 = r4.f620g
                boolean r0 = r1.n(r0)
                if (r0 == 0) goto L4e
            L4c:
                r0 = 1
                return r0
            L4e:
                r0 = 0
                return r0
        }

        @Override // androidx.fragment.app.SpecialEffectsController.b
        public void c(android.view.ViewGroup r2) {
                r1 = this;
                java.lang.String r0 = "container"
                kotlin.jvm.internal.h.f(r2, r0)
                u.i r2 = r1.f630q
                r2.a()
                return
        }

        @Override // androidx.fragment.app.SpecialEffectsController.b
        public void d(android.view.ViewGroup r12) {
                r11 = this;
                java.lang.String r0 = "container"
                kotlin.jvm.internal.h.f(r12, r0)
                boolean r0 = r12.isLaidOut()
                java.lang.String r1 = "FragmentManager"
                r2 = 2
                if (r0 != 0) goto L4e
                java.util.List r0 = r11.f617d
                java.util.Iterator r0 = r0.iterator()
            L14:
                boolean r3 = r0.hasNext()
                if (r3 == 0) goto L105
                java.lang.Object r3 = r0.next()
                androidx.fragment.app.DefaultSpecialEffectsController$g r3 = (androidx.fragment.app.DefaultSpecialEffectsController.g) r3
                androidx.fragment.app.SpecialEffectsController$Operation r4 = r3.a()
                boolean r5 = androidx.fragment.app.FragmentManager.O0(r2)
                if (r5 == 0) goto L46
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                java.lang.String r6 = "SpecialEffectsController: Container "
                r5.append(r6)
                r5.append(r12)
                java.lang.String r6 = " has not been laid out. Completing operation "
                r5.append(r6)
                r5.append(r4)
                java.lang.String r4 = r5.toString()
                android.util.Log.v(r1, r4)
            L46:
                androidx.fragment.app.SpecialEffectsController$Operation r3 = r3.a()
                r3.f(r11)
                goto L14
            L4e:
                java.lang.Object r0 = r11.f631r
                java.lang.String r3 = " to "
                if (r0 == 0) goto L81
                androidx.fragment.app.t0 r12 = r11.f620g
                kotlin.jvm.internal.h.c(r0)
                r12.c(r0)
                boolean r12 = androidx.fragment.app.FragmentManager.O0(r2)
                if (r12 == 0) goto L105
                java.lang.StringBuilder r12 = new java.lang.StringBuilder
                r12.<init>()
                java.lang.String r0 = "Ending execution of operations from "
                r12.append(r0)
                androidx.fragment.app.SpecialEffectsController$Operation r0 = r11.f618e
                r12.append(r0)
                r12.append(r3)
                androidx.fragment.app.SpecialEffectsController$Operation r0 = r11.f619f
                r12.append(r0)
                java.lang.String r12 = r12.toString()
                android.util.Log.v(r1, r12)
                return
            L81:
                androidx.fragment.app.SpecialEffectsController$Operation r0 = r11.f619f
                androidx.fragment.app.SpecialEffectsController$Operation r4 = r11.f618e
                kotlin.Pair r0 = r11.o(r12, r0, r4)
                java.lang.Object r4 = r0.component1()
                java.util.ArrayList r4 = (java.util.ArrayList) r4
                java.lang.Object r0 = r0.component2()
                java.util.List r5 = r11.f617d
                java.util.ArrayList r6 = new java.util.ArrayList
                r7 = 10
                int r7 = k7.m.j(r5, r7)
                r6.<init>(r7)
                java.util.Iterator r5 = r5.iterator()
            La4:
                boolean r7 = r5.hasNext()
                if (r7 == 0) goto Lb8
                java.lang.Object r7 = r5.next()
                androidx.fragment.app.DefaultSpecialEffectsController$g r7 = (androidx.fragment.app.DefaultSpecialEffectsController.g) r7
                androidx.fragment.app.SpecialEffectsController$Operation r7 = r7.a()
                r6.add(r7)
                goto La4
            Lb8:
                java.util.Iterator r5 = r6.iterator()
            Lbc:
                boolean r6 = r5.hasNext()
                if (r6 == 0) goto Ld9
                java.lang.Object r6 = r5.next()
                androidx.fragment.app.SpecialEffectsController$Operation r6 = (androidx.fragment.app.SpecialEffectsController.Operation) r6
                androidx.fragment.app.t0 r7 = r11.f620g
                androidx.fragment.app.Fragment r8 = r6.i()
                u.i r9 = r11.f630q
                androidx.fragment.app.f r10 = new androidx.fragment.app.f
                r10.<init>(r6, r11)
                r7.w(r8, r0, r9, r10)
                goto Lbc
            Ld9:
                androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect$onCommit$4 r5 = new androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect$onCommit$4
                r5.<init>(r11, r12, r0)
                r11.B(r4, r12, r5)
                boolean r12 = androidx.fragment.app.FragmentManager.O0(r2)
                if (r12 == 0) goto L105
                java.lang.StringBuilder r12 = new java.lang.StringBuilder
                r12.<init>()
                java.lang.String r0 = "Completed executing operations from "
                r12.append(r0)
                androidx.fragment.app.SpecialEffectsController$Operation r0 = r11.f618e
                r12.append(r0)
                r12.append(r3)
                androidx.fragment.app.SpecialEffectsController$Operation r0 = r11.f619f
                r12.append(r0)
                java.lang.String r12 = r12.toString()
                android.util.Log.v(r1, r12)
            L105:
                return
        }

        @Override // androidx.fragment.app.SpecialEffectsController.b
        public void e(androidx.activity.b r2, android.view.ViewGroup r3) {
                r1 = this;
                java.lang.String r0 = "backEvent"
                kotlin.jvm.internal.h.f(r2, r0)
                java.lang.String r0 = "container"
                kotlin.jvm.internal.h.f(r3, r0)
                java.lang.Object r3 = r1.f631r
                if (r3 == 0) goto L17
                androidx.fragment.app.t0 r0 = r1.f620g
                float r2 = r2.a()
                r0.t(r3, r2)
            L17:
                return
        }

        @Override // androidx.fragment.app.SpecialEffectsController.b
        public void f(android.view.ViewGroup r11) {
                r10 = this;
                java.lang.String r0 = "container"
                kotlin.jvm.internal.h.f(r11, r0)
                boolean r0 = r11.isLaidOut()
                java.lang.String r1 = "FragmentManager"
                if (r0 != 0) goto L47
                java.util.List r0 = r10.f617d
                java.util.Iterator r0 = r0.iterator()
            L13:
                boolean r2 = r0.hasNext()
                if (r2 == 0) goto L100
                java.lang.Object r2 = r0.next()
                androidx.fragment.app.DefaultSpecialEffectsController$g r2 = (androidx.fragment.app.DefaultSpecialEffectsController.g) r2
                androidx.fragment.app.SpecialEffectsController$Operation r2 = r2.a()
                r3 = 2
                boolean r3 = androidx.fragment.app.FragmentManager.O0(r3)
                if (r3 == 0) goto L13
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r4 = "SpecialEffectsController: Container "
                r3.append(r4)
                r3.append(r11)
                java.lang.String r4 = " has not been laid out. Skipping onStart for operation "
                r3.append(r4)
                r3.append(r2)
                java.lang.String r2 = r3.toString()
                android.util.Log.v(r1, r2)
                goto L13
            L47:
                boolean r0 = r10.x()
                if (r0 == 0) goto L86
                java.lang.Object r0 = r10.f621h
                if (r0 == 0) goto L86
                boolean r0 = r10.b()
                if (r0 != 0) goto L86
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r2 = "Ignoring shared elements transition "
                r0.append(r2)
                java.lang.Object r2 = r10.f621h
                r0.append(r2)
                java.lang.String r2 = " between "
                r0.append(r2)
                androidx.fragment.app.SpecialEffectsController$Operation r2 = r10.f618e
                r0.append(r2)
                java.lang.String r2 = " and "
                r0.append(r2)
                androidx.fragment.app.SpecialEffectsController$Operation r2 = r10.f619f
                r0.append(r2)
                java.lang.String r2 = " as neither fragment has set a Transition. In order to run a SharedElementTransition, you must also set either an enter or exit transition on a fragment involved in the transaction. The sharedElementTransition will run after the back gesture has been committed."
                r0.append(r2)
                java.lang.String r0 = r0.toString()
                android.util.Log.i(r1, r0)
            L86:
                boolean r0 = r10.b()
                if (r0 == 0) goto L100
                boolean r0 = r10.x()
                if (r0 == 0) goto L100
                kotlin.jvm.internal.Ref$ObjectRef r0 = new kotlin.jvm.internal.Ref$ObjectRef
                r0.<init>()
                androidx.fragment.app.SpecialEffectsController$Operation r1 = r10.f619f
                androidx.fragment.app.SpecialEffectsController$Operation r2 = r10.f618e
                kotlin.Pair r1 = r10.o(r11, r1, r2)
                java.lang.Object r2 = r1.component1()
                java.util.ArrayList r2 = (java.util.ArrayList) r2
                java.lang.Object r5 = r1.component2()
                java.util.List r1 = r10.f617d
                java.util.ArrayList r3 = new java.util.ArrayList
                r4 = 10
                int r4 = k7.m.j(r1, r4)
                r3.<init>(r4)
                java.util.Iterator r1 = r1.iterator()
            Lba:
                boolean r4 = r1.hasNext()
                if (r4 == 0) goto Lce
                java.lang.Object r4 = r1.next()
                androidx.fragment.app.DefaultSpecialEffectsController$g r4 = (androidx.fragment.app.DefaultSpecialEffectsController.g) r4
                androidx.fragment.app.SpecialEffectsController$Operation r4 = r4.a()
                r3.add(r4)
                goto Lba
            Lce:
                java.util.Iterator r1 = r3.iterator()
            Ld2:
                boolean r3 = r1.hasNext()
                if (r3 == 0) goto Lf8
                java.lang.Object r3 = r1.next()
                androidx.fragment.app.SpecialEffectsController$Operation r3 = (androidx.fragment.app.SpecialEffectsController.Operation) r3
                androidx.fragment.app.d r7 = new androidx.fragment.app.d
                r7.<init>(r0)
                r4 = r3
                androidx.fragment.app.t0 r3 = r10.f620g
                r6 = r4
                androidx.fragment.app.Fragment r4 = r6.i()
                r8 = r6
                u.i r6 = r10.f630q
                r9 = r8
                androidx.fragment.app.e r8 = new androidx.fragment.app.e
                r8.<init>(r9, r10)
                r3.x(r4, r5, r6, r7, r8)
                goto Ld2
            Lf8:
                androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect$onStart$4 r1 = new androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect$onStart$4
                r1.<init>(r10, r11, r5, r0)
                r10.B(r2, r11, r1)
            L100:
                return
        }

        public final void n(java.util.ArrayList r5, android.view.View r6) {
                r4 = this;
                boolean r0 = r6 instanceof android.view.ViewGroup
                if (r0 == 0) goto L33
                r0 = r6
                android.view.ViewGroup r0 = (android.view.ViewGroup) r0
                boolean r1 = x.u.a(r0)
                if (r1 == 0) goto L17
                boolean r0 = r5.contains(r6)
                if (r0 != 0) goto L3c
                r5.add(r6)
                return
            L17:
                int r6 = r0.getChildCount()
                r1 = 0
            L1c:
                if (r1 >= r6) goto L3c
                android.view.View r2 = r0.getChildAt(r1)
                int r3 = r2.getVisibility()
                if (r3 != 0) goto L30
                java.lang.String r3 = "child"
                kotlin.jvm.internal.h.e(r2, r3)
                r4.n(r5, r2)
            L30:
                int r1 = r1 + 1
                goto L1c
            L33:
                boolean r0 = r5.contains(r6)
                if (r0 != 0) goto L3c
                r5.add(r6)
            L3c:
                return
        }

        public final kotlin.Pair o(android.view.ViewGroup r31, androidx.fragment.app.SpecialEffectsController.Operation r32, androidx.fragment.app.SpecialEffectsController.Operation r33) {
                r30 = this;
                r0 = r30
                r1 = r31
                r2 = r32
                r3 = r33
                android.view.View r4 = new android.view.View
                android.content.Context r5 = r1.getContext()
                r4.<init>(r5)
                android.graphics.Rect r5 = new android.graphics.Rect
                r5.<init>()
                java.util.List r6 = r0.f617d
                java.util.Iterator r6 = r6.iterator()
                r8 = 0
                r9 = 0
                r10 = 0
            L1f:
                boolean r11 = r6.hasNext()
                if (r11 == 0) goto Ldd
                java.lang.Object r11 = r6.next()
                androidx.fragment.app.DefaultSpecialEffectsController$g r11 = (androidx.fragment.app.DefaultSpecialEffectsController.g) r11
                boolean r11 = r11.g()
                if (r11 == 0) goto L1f
                if (r3 == 0) goto L1f
                if (r2 == 0) goto L1f
                k.a r11 = r0.f624k
                boolean r11 = r11.isEmpty()
                if (r11 != 0) goto L1f
                java.lang.Object r11 = r0.f621h
                if (r11 == 0) goto L1f
                androidx.fragment.app.Fragment r11 = r2.i()
                androidx.fragment.app.Fragment r12 = r3.i()
                boolean r13 = r0.f629p
                k.a r14 = r0.f627n
                r15 = 1
                androidx.fragment.app.m0.a(r11, r12, r13, r14, r15)
                androidx.fragment.app.g r11 = new androidx.fragment.app.g
                r11.<init>(r2, r3, r0)
                x.o.a(r1, r11)
                java.util.ArrayList r11 = r0.f622i
                k.a r12 = r0.f627n
                java.util.Collection r12 = r12.values()
                r11.addAll(r12)
                java.util.ArrayList r11 = r0.f626m
                boolean r11 = r11.isEmpty()
                if (r11 != 0) goto L88
                java.util.ArrayList r9 = r0.f626m
                java.lang.Object r9 = r9.get(r8)
                java.lang.String r11 = "exitingNames[0]"
                kotlin.jvm.internal.h.e(r9, r11)
                java.lang.String r9 = (java.lang.String) r9
                k.a r11 = r0.f627n
                java.lang.Object r9 = r11.get(r9)
                android.view.View r9 = (android.view.View) r9
                androidx.fragment.app.t0 r11 = r0.f620g
                java.lang.Object r12 = r0.f621h
                r11.v(r12, r9)
            L88:
                java.util.ArrayList r11 = r0.f623j
                k.a r12 = r0.f628o
                java.util.Collection r12 = r12.values()
                r11.addAll(r12)
                java.util.ArrayList r11 = r0.f625l
                boolean r11 = r11.isEmpty()
                if (r11 != 0) goto Lbd
                java.util.ArrayList r11 = r0.f625l
                java.lang.Object r11 = r11.get(r8)
                java.lang.String r12 = "enteringNames[0]"
                kotlin.jvm.internal.h.e(r11, r12)
                java.lang.String r11 = (java.lang.String) r11
                k.a r12 = r0.f628o
                java.lang.Object r11 = r12.get(r11)
                android.view.View r11 = (android.view.View) r11
                if (r11 == 0) goto Lbd
                androidx.fragment.app.t0 r10 = r0.f620g
                androidx.fragment.app.h r12 = new androidx.fragment.app.h
                r12.<init>(r10, r11, r5)
                x.o.a(r1, r12)
                r10 = 1
            Lbd:
                androidx.fragment.app.t0 r11 = r0.f620g
                java.lang.Object r12 = r0.f621h
                java.util.ArrayList r13 = r0.f622i
                r11.z(r12, r4, r13)
                androidx.fragment.app.t0 r14 = r0.f620g
                java.lang.Object r15 = r0.f621h
                r19 = 0
                java.util.ArrayList r11 = r0.f623j
                r16 = 0
                r17 = 0
                r18 = 0
                r20 = r15
                r21 = r11
                r14.s(r15, r16, r17, r18, r19, r20, r21)
                goto L1f
            Ldd:
                java.util.ArrayList r6 = new java.util.ArrayList
                r6.<init>()
                java.util.List r11 = r0.f617d
                java.util.Iterator r11 = r11.iterator()
                r12 = 0
                r13 = 0
            Lea:
                boolean r14 = r11.hasNext()
                r16 = 2
                java.lang.String r15 = "FragmentManager"
                if (r14 == 0) goto L25b
                java.lang.Object r14 = r11.next()
                androidx.fragment.app.DefaultSpecialEffectsController$g r14 = (androidx.fragment.app.DefaultSpecialEffectsController.g) r14
                androidx.fragment.app.SpecialEffectsController$Operation r7 = r14.a()
                androidx.fragment.app.t0 r8 = r0.f620g
                r19 = r10
                java.lang.Object r10 = r14.f()
                java.lang.Object r8 = r8.h(r10)
                if (r8 == 0) goto L256
                java.util.ArrayList r10 = new java.util.ArrayList
                r10.<init>()
                r28 = r11
                androidx.fragment.app.Fragment r11 = r7.i()
                android.view.View r11 = r11.R
                r29 = r14
                java.lang.String r14 = "operation.fragment.mView"
                kotlin.jvm.internal.h.e(r11, r14)
                r0.n(r10, r11)
                java.lang.Object r11 = r0.f621h
                if (r11 == 0) goto L140
                if (r7 == r3) goto L12b
                if (r7 != r2) goto L140
            L12b:
                if (r7 != r3) goto L137
                java.util.ArrayList r11 = r0.f622i
                java.util.Set r11 = k7.t.A(r11)
                r10.removeAll(r11)
                goto L140
            L137:
                java.util.ArrayList r11 = r0.f623j
                java.util.Set r11 = k7.t.A(r11)
                r10.removeAll(r11)
            L140:
                boolean r11 = r10.isEmpty()
                if (r11 == 0) goto L14c
                androidx.fragment.app.t0 r11 = r0.f620g
                r11.a(r8, r4)
                goto L193
            L14c:
                androidx.fragment.app.t0 r11 = r0.f620g
                r11.b(r8, r10)
                androidx.fragment.app.t0 r11 = r0.f620g
                r26 = 0
                r27 = 0
                r24 = 0
                r25 = 0
                r22 = r8
                r21 = r8
                r23 = r10
                r20 = r11
                r20.s(r21, r22, r23, r24, r25, r26, r27)
                androidx.fragment.app.SpecialEffectsController$Operation$State r11 = r7.h()
                androidx.fragment.app.SpecialEffectsController$Operation$State r14 = androidx.fragment.app.SpecialEffectsController.Operation.State.GONE
                if (r11 != r14) goto L193
                r11 = 0
                r7.r(r11)
                java.util.ArrayList r14 = new java.util.ArrayList
                r14.<init>(r10)
                androidx.fragment.app.Fragment r11 = r7.i()
                android.view.View r11 = r11.R
                r14.remove(r11)
                androidx.fragment.app.t0 r11 = r0.f620g
                androidx.fragment.app.Fragment r2 = r7.i()
                android.view.View r2 = r2.R
                r11.r(r8, r2, r14)
                androidx.fragment.app.i r2 = new androidx.fragment.app.i
                r2.<init>(r10)
                x.o.a(r1, r2)
            L193:
                androidx.fragment.app.SpecialEffectsController$Operation$State r2 = r7.h()
                androidx.fragment.app.SpecialEffectsController$Operation$State r7 = androidx.fragment.app.SpecialEffectsController.Operation.State.VISIBLE
                java.lang.String r11 = "View: "
                java.lang.String r14 = "transitioningViews"
                if (r2 != r7) goto L1ee
                r6.addAll(r10)
                if (r19 == 0) goto L1a9
                androidx.fragment.app.t0 r2 = r0.f620g
                r2.u(r8, r5)
            L1a9:
                boolean r2 = androidx.fragment.app.FragmentManager.O0(r16)
                if (r2 == 0) goto L238
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r7 = "Entering Transition: "
                r2.append(r7)
                r2.append(r8)
                java.lang.String r2 = r2.toString()
                android.util.Log.v(r15, r2)
                java.lang.String r2 = ">>>>> EnteringViews <<<<<"
                android.util.Log.v(r15, r2)
                java.util.Iterator r2 = r10.iterator()
            L1cc:
                boolean r7 = r2.hasNext()
                if (r7 == 0) goto L238
                java.lang.Object r7 = r2.next()
                kotlin.jvm.internal.h.e(r7, r14)
                android.view.View r7 = (android.view.View) r7
                java.lang.StringBuilder r10 = new java.lang.StringBuilder
                r10.<init>()
                r10.append(r11)
                r10.append(r7)
                java.lang.String r7 = r10.toString()
                android.util.Log.v(r15, r7)
                goto L1cc
            L1ee:
                androidx.fragment.app.t0 r2 = r0.f620g
                r2.v(r8, r9)
                boolean r2 = androidx.fragment.app.FragmentManager.O0(r16)
                if (r2 == 0) goto L238
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r7 = "Exiting Transition: "
                r2.append(r7)
                r2.append(r8)
                java.lang.String r2 = r2.toString()
                android.util.Log.v(r15, r2)
                java.lang.String r2 = ">>>>> ExitingViews <<<<<"
                android.util.Log.v(r15, r2)
                java.util.Iterator r2 = r10.iterator()
            L216:
                boolean r7 = r2.hasNext()
                if (r7 == 0) goto L238
                java.lang.Object r7 = r2.next()
                kotlin.jvm.internal.h.e(r7, r14)
                android.view.View r7 = (android.view.View) r7
                java.lang.StringBuilder r10 = new java.lang.StringBuilder
                r10.<init>()
                r10.append(r11)
                r10.append(r7)
                java.lang.String r7 = r10.toString()
                android.util.Log.v(r15, r7)
                goto L216
            L238:
                boolean r2 = r29.h()
                if (r2 == 0) goto L24e
                androidx.fragment.app.t0 r2 = r0.f620g
                r7 = 0
                java.lang.Object r12 = r2.p(r12, r8, r7)
            L245:
                r2 = r32
                r10 = r19
                r11 = r28
            L24b:
                r8 = 0
                goto Lea
            L24e:
                r7 = 0
                androidx.fragment.app.t0 r2 = r0.f620g
                java.lang.Object r13 = r2.p(r13, r8, r7)
                goto L245
            L256:
                r2 = r32
                r10 = r19
                goto L24b
            L25b:
                androidx.fragment.app.t0 r1 = r0.f620g
                java.lang.Object r2 = r0.f621h
                java.lang.Object r1 = r1.o(r12, r13, r2)
                boolean r2 = androidx.fragment.app.FragmentManager.O0(r16)
                if (r2 == 0) goto L27d
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "Final merged transition: "
                r2.append(r3)
                r2.append(r1)
                java.lang.String r2 = r2.toString()
                android.util.Log.v(r15, r2)
            L27d:
                kotlin.Pair r2 = new kotlin.Pair
                r2.<init>(r6, r1)
                return r2
        }

        public final java.lang.Object s() {
                r1 = this;
                java.lang.Object r0 = r1.f631r
                return r0
        }

        public final androidx.fragment.app.SpecialEffectsController.Operation t() {
                r1 = this;
                androidx.fragment.app.SpecialEffectsController$Operation r0 = r1.f618e
                return r0
        }

        public final androidx.fragment.app.SpecialEffectsController.Operation u() {
                r1 = this;
                androidx.fragment.app.SpecialEffectsController$Operation r0 = r1.f619f
                return r0
        }

        public final androidx.fragment.app.t0 v() {
                r1 = this;
                androidx.fragment.app.t0 r0 = r1.f620g
                return r0
        }

        public final java.util.List w() {
                r1 = this;
                java.util.List r0 = r1.f617d
                return r0
        }

        public final boolean x() {
                r3 = this;
                java.util.List r0 = r3.f617d
                boolean r1 = androidx.activity.p.a(r0)
                r2 = 1
                if (r1 == 0) goto L10
                boolean r1 = r0.isEmpty()
                if (r1 == 0) goto L10
                return r2
            L10:
                java.util.Iterator r0 = r0.iterator()
            L14:
                boolean r1 = r0.hasNext()
                if (r1 == 0) goto L2e
                java.lang.Object r1 = r0.next()
                androidx.fragment.app.DefaultSpecialEffectsController$g r1 = (androidx.fragment.app.DefaultSpecialEffectsController.g) r1
                androidx.fragment.app.SpecialEffectsController$Operation r1 = r1.a()
                androidx.fragment.app.Fragment r1 = r1.i()
                boolean r1 = r1.f678v
                if (r1 != 0) goto L14
                r0 = 0
                return r0
            L2e:
                return r2
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class a extends androidx.fragment.app.SpecialEffectsController.b {

        /* renamed from: d, reason: collision with root package name */
        public final androidx.fragment.app.DefaultSpecialEffectsController.b f632d;

        /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
        /* renamed from: androidx.fragment.app.DefaultSpecialEffectsController$a$a, reason: collision with other inner class name */
        public static final class AnimationAnimationListenerC0012a implements android.view.animation.Animation.AnimationListener {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ androidx.fragment.app.SpecialEffectsController.Operation f633a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ android.view.ViewGroup f634b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ android.view.View f635c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ androidx.fragment.app.DefaultSpecialEffectsController.a f636d;

            public AnimationAnimationListenerC0012a(androidx.fragment.app.SpecialEffectsController.Operation r1, android.view.ViewGroup r2, android.view.View r3, androidx.fragment.app.DefaultSpecialEffectsController.a r4) {
                    r0 = this;
                    r0.f633a = r1
                    r0.f634b = r2
                    r0.f635c = r3
                    r0.f636d = r4
                    r0.<init>()
                    return
            }

            public static /* synthetic */ void a(android.view.ViewGroup r0, android.view.View r1, androidx.fragment.app.DefaultSpecialEffectsController.a r2) {
                    b(r0, r1, r2)
                    return
            }

            public static final void b(android.view.ViewGroup r1, android.view.View r2, androidx.fragment.app.DefaultSpecialEffectsController.a r3) {
                    java.lang.String r0 = "$container"
                    kotlin.jvm.internal.h.f(r1, r0)
                    java.lang.String r0 = "this$0"
                    kotlin.jvm.internal.h.f(r3, r0)
                    r1.endViewTransition(r2)
                    androidx.fragment.app.DefaultSpecialEffectsController$b r1 = r3.h()
                    androidx.fragment.app.SpecialEffectsController$Operation r1 = r1.a()
                    r1.f(r3)
                    return
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(android.view.animation.Animation r4) {
                    r3 = this;
                    java.lang.String r0 = "animation"
                    kotlin.jvm.internal.h.f(r4, r0)
                    android.view.ViewGroup r4 = r3.f634b
                    android.view.View r0 = r3.f635c
                    androidx.fragment.app.DefaultSpecialEffectsController$a r1 = r3.f636d
                    androidx.fragment.app.c r2 = new androidx.fragment.app.c
                    r2.<init>(r4, r0, r1)
                    r4.post(r2)
                    r4 = 2
                    boolean r4 = androidx.fragment.app.FragmentManager.O0(r4)
                    if (r4 == 0) goto L37
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder
                    r4.<init>()
                    java.lang.String r0 = "Animation from operation "
                    r4.append(r0)
                    androidx.fragment.app.SpecialEffectsController$Operation r0 = r3.f633a
                    r4.append(r0)
                    java.lang.String r0 = " has ended."
                    r4.append(r0)
                    java.lang.String r4 = r4.toString()
                    java.lang.String r0 = "FragmentManager"
                    android.util.Log.v(r0, r4)
                L37:
                    return
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(android.view.animation.Animation r2) {
                    r1 = this;
                    java.lang.String r0 = "animation"
                    kotlin.jvm.internal.h.f(r2, r0)
                    return
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(android.view.animation.Animation r2) {
                    r1 = this;
                    java.lang.String r0 = "animation"
                    kotlin.jvm.internal.h.f(r2, r0)
                    r2 = 2
                    boolean r2 = androidx.fragment.app.FragmentManager.O0(r2)
                    if (r2 == 0) goto L29
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                    r2.<init>()
                    java.lang.String r0 = "Animation from operation "
                    r2.append(r0)
                    androidx.fragment.app.SpecialEffectsController$Operation r0 = r1.f633a
                    r2.append(r0)
                    java.lang.String r0 = " has reached onAnimationStart."
                    r2.append(r0)
                    java.lang.String r2 = r2.toString()
                    java.lang.String r0 = "FragmentManager"
                    android.util.Log.v(r0, r2)
                L29:
                    return
            }
        }

        public a(androidx.fragment.app.DefaultSpecialEffectsController.b r2) {
                r1 = this;
                java.lang.String r0 = "animationInfo"
                kotlin.jvm.internal.h.f(r2, r0)
                r1.<init>()
                r1.f632d = r2
                return
        }

        @Override // androidx.fragment.app.SpecialEffectsController.b
        public void c(android.view.ViewGroup r3) {
                r2 = this;
                java.lang.String r0 = "container"
                kotlin.jvm.internal.h.f(r3, r0)
                androidx.fragment.app.DefaultSpecialEffectsController$b r0 = r2.f632d
                androidx.fragment.app.SpecialEffectsController$Operation r0 = r0.a()
                androidx.fragment.app.Fragment r1 = r0.i()
                android.view.View r1 = r1.R
                r1.clearAnimation()
                r3.endViewTransition(r1)
                androidx.fragment.app.DefaultSpecialEffectsController$b r3 = r2.f632d
                androidx.fragment.app.SpecialEffectsController$Operation r3 = r3.a()
                r3.f(r2)
                r3 = 2
                boolean r3 = androidx.fragment.app.FragmentManager.O0(r3)
                if (r3 == 0) goto L42
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r1 = "Animation from operation "
                r3.append(r1)
                r3.append(r0)
                java.lang.String r0 = " has been cancelled."
                r3.append(r0)
                java.lang.String r3 = r3.toString()
                java.lang.String r0 = "FragmentManager"
                android.util.Log.v(r0, r3)
            L42:
                return
        }

        @Override // androidx.fragment.app.SpecialEffectsController.b
        public void d(android.view.ViewGroup r6) {
                r5 = this;
                java.lang.String r0 = "container"
                kotlin.jvm.internal.h.f(r6, r0)
                androidx.fragment.app.DefaultSpecialEffectsController$b r0 = r5.f632d
                boolean r0 = r0.b()
                if (r0 == 0) goto L17
                androidx.fragment.app.DefaultSpecialEffectsController$b r6 = r5.f632d
                androidx.fragment.app.SpecialEffectsController$Operation r6 = r6.a()
                r6.f(r5)
                return
            L17:
                android.content.Context r0 = r6.getContext()
                androidx.fragment.app.DefaultSpecialEffectsController$b r1 = r5.f632d
                androidx.fragment.app.SpecialEffectsController$Operation r1 = r1.a()
                androidx.fragment.app.Fragment r2 = r1.i()
                android.view.View r2 = r2.R
                androidx.fragment.app.DefaultSpecialEffectsController$b r3 = r5.f632d
                java.lang.String r4 = "context"
                kotlin.jvm.internal.h.e(r0, r4)
                androidx.fragment.app.r$a r0 = r3.c(r0)
                java.lang.String r3 = "Required value was null."
                if (r0 == 0) goto L8b
                android.view.animation.Animation r0 = r0.f923a
                if (r0 == 0) goto L85
                androidx.fragment.app.SpecialEffectsController$Operation$State r3 = r1.h()
                androidx.fragment.app.SpecialEffectsController$Operation$State r4 = androidx.fragment.app.SpecialEffectsController.Operation.State.REMOVED
                if (r3 == r4) goto L4f
                r2.startAnimation(r0)
                androidx.fragment.app.DefaultSpecialEffectsController$b r6 = r5.f632d
                androidx.fragment.app.SpecialEffectsController$Operation r6 = r6.a()
                r6.f(r5)
                return
            L4f:
                r6.startViewTransition(r2)
                androidx.fragment.app.r$b r3 = new androidx.fragment.app.r$b
                r3.<init>(r0, r6, r2)
                androidx.fragment.app.DefaultSpecialEffectsController$a$a r0 = new androidx.fragment.app.DefaultSpecialEffectsController$a$a
                r0.<init>(r1, r6, r2, r5)
                r3.setAnimationListener(r0)
                r2.startAnimation(r3)
                r6 = 2
                boolean r6 = androidx.fragment.app.FragmentManager.O0(r6)
                if (r6 == 0) goto L84
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                java.lang.String r0 = "Animation from operation "
                r6.append(r0)
                r6.append(r1)
                java.lang.String r0 = " has started."
                r6.append(r0)
                java.lang.String r6 = r6.toString()
                java.lang.String r0 = "FragmentManager"
                android.util.Log.v(r0, r6)
            L84:
                return
            L85:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                r6.<init>(r3)
                throw r6
            L8b:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                r6.<init>(r3)
                throw r6
        }

        public final androidx.fragment.app.DefaultSpecialEffectsController.b h() {
                r1 = this;
                androidx.fragment.app.DefaultSpecialEffectsController$b r0 = r1.f632d
                return r0
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class b extends androidx.fragment.app.DefaultSpecialEffectsController.f {

        /* renamed from: b, reason: collision with root package name */
        public final boolean f637b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f638c;

        /* renamed from: d, reason: collision with root package name */
        public androidx.fragment.app.r.a f639d;

        public b(androidx.fragment.app.SpecialEffectsController.Operation r2, boolean r3) {
                r1 = this;
                java.lang.String r0 = "operation"
                kotlin.jvm.internal.h.f(r2, r0)
                r1.<init>(r2)
                r1.f637b = r3
                return
        }

        public final androidx.fragment.app.r.a c(android.content.Context r5) {
                r4 = this;
                java.lang.String r0 = "context"
                kotlin.jvm.internal.h.f(r5, r0)
                boolean r0 = r4.f638c
                if (r0 == 0) goto Lc
                androidx.fragment.app.r$a r5 = r4.f639d
                return r5
            Lc:
                androidx.fragment.app.SpecialEffectsController$Operation r0 = r4.a()
                androidx.fragment.app.Fragment r0 = r0.i()
                androidx.fragment.app.SpecialEffectsController$Operation r1 = r4.a()
                androidx.fragment.app.SpecialEffectsController$Operation$State r1 = r1.h()
                androidx.fragment.app.SpecialEffectsController$Operation$State r2 = androidx.fragment.app.SpecialEffectsController.Operation.State.VISIBLE
                r3 = 1
                if (r1 != r2) goto L23
                r1 = 1
                goto L24
            L23:
                r1 = 0
            L24:
                boolean r2 = r4.f637b
                androidx.fragment.app.r$a r5 = androidx.fragment.app.r.b(r5, r0, r1, r2)
                r4.f639d = r5
                r4.f638c = r3
                return r5
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class c extends androidx.fragment.app.SpecialEffectsController.b {

        /* renamed from: d, reason: collision with root package name */
        public final androidx.fragment.app.DefaultSpecialEffectsController.b f640d;

        /* renamed from: e, reason: collision with root package name */
        public android.animation.AnimatorSet f641e;

        /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
        public static final class a extends android.animation.AnimatorListenerAdapter {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ android.view.ViewGroup f642a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ android.view.View f643b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ boolean f644c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ androidx.fragment.app.SpecialEffectsController.Operation f645d;

            /* renamed from: e, reason: collision with root package name */
            public final /* synthetic */ androidx.fragment.app.DefaultSpecialEffectsController.c f646e;

            public a(android.view.ViewGroup r1, android.view.View r2, boolean r3, androidx.fragment.app.SpecialEffectsController.Operation r4, androidx.fragment.app.DefaultSpecialEffectsController.c r5) {
                    r0 = this;
                    r0.f642a = r1
                    r0.f643b = r2
                    r0.f644c = r3
                    r0.f645d = r4
                    r0.f646e = r5
                    r0.<init>()
                    return
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator r3) {
                    r2 = this;
                    java.lang.String r0 = "anim"
                    kotlin.jvm.internal.h.f(r3, r0)
                    android.view.ViewGroup r3 = r2.f642a
                    android.view.View r0 = r2.f643b
                    r3.endViewTransition(r0)
                    boolean r3 = r2.f644c
                    if (r3 == 0) goto L22
                    androidx.fragment.app.SpecialEffectsController$Operation r3 = r2.f645d
                    androidx.fragment.app.SpecialEffectsController$Operation$State r3 = r3.h()
                    android.view.View r0 = r2.f643b
                    java.lang.String r1 = "viewToAnimate"
                    kotlin.jvm.internal.h.e(r0, r1)
                    android.view.ViewGroup r1 = r2.f642a
                    r3.applyState(r0, r1)
                L22:
                    androidx.fragment.app.DefaultSpecialEffectsController$c r3 = r2.f646e
                    androidx.fragment.app.DefaultSpecialEffectsController$b r3 = r3.h()
                    androidx.fragment.app.SpecialEffectsController$Operation r3 = r3.a()
                    androidx.fragment.app.DefaultSpecialEffectsController$c r0 = r2.f646e
                    r3.f(r0)
                    r3 = 2
                    boolean r3 = androidx.fragment.app.FragmentManager.O0(r3)
                    if (r3 == 0) goto L55
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder
                    r3.<init>()
                    java.lang.String r0 = "Animator from operation "
                    r3.append(r0)
                    androidx.fragment.app.SpecialEffectsController$Operation r0 = r2.f645d
                    r3.append(r0)
                    java.lang.String r0 = " has ended."
                    r3.append(r0)
                    java.lang.String r3 = r3.toString()
                    java.lang.String r0 = "FragmentManager"
                    android.util.Log.v(r0, r3)
                L55:
                    return
            }
        }

        public c(androidx.fragment.app.DefaultSpecialEffectsController.b r2) {
                r1 = this;
                java.lang.String r0 = "animatorInfo"
                kotlin.jvm.internal.h.f(r2, r0)
                r1.<init>()
                r1.f640d = r2
                return
        }

        @Override // androidx.fragment.app.SpecialEffectsController.b
        public boolean b() {
                r1 = this;
                r0 = 1
                return r0
        }

        @Override // androidx.fragment.app.SpecialEffectsController.b
        public void c(android.view.ViewGroup r4) {
                r3 = this;
                java.lang.String r0 = "container"
                kotlin.jvm.internal.h.f(r4, r0)
                android.animation.AnimatorSet r4 = r3.f641e
                if (r4 != 0) goto L13
                androidx.fragment.app.DefaultSpecialEffectsController$b r4 = r3.f640d
                androidx.fragment.app.SpecialEffectsController$Operation r4 = r4.a()
                r4.f(r3)
                return
            L13:
                androidx.fragment.app.DefaultSpecialEffectsController$b r0 = r3.f640d
                androidx.fragment.app.SpecialEffectsController$Operation r0 = r0.a()
                boolean r1 = r0.n()
                if (r1 == 0) goto L2b
                int r1 = android.os.Build.VERSION.SDK_INT
                r2 = 26
                if (r1 < r2) goto L2e
                androidx.fragment.app.DefaultSpecialEffectsController$e r1 = androidx.fragment.app.DefaultSpecialEffectsController.e.f648a
                r1.a(r4)
                goto L2e
            L2b:
                r4.end()
            L2e:
                r4 = 2
                boolean r4 = androidx.fragment.app.FragmentManager.O0(r4)
                if (r4 == 0) goto L63
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                java.lang.String r1 = "Animator from operation "
                r4.append(r1)
                r4.append(r0)
                java.lang.String r1 = " has been canceled"
                r4.append(r1)
                boolean r0 = r0.n()
                if (r0 == 0) goto L50
                java.lang.String r0 = " with seeking."
                goto L52
            L50:
                java.lang.String r0 = "."
            L52:
                r4.append(r0)
                r0 = 32
                r4.append(r0)
                java.lang.String r4 = r4.toString()
                java.lang.String r0 = "FragmentManager"
                android.util.Log.v(r0, r4)
            L63:
                return
        }

        @Override // androidx.fragment.app.SpecialEffectsController.b
        public void d(android.view.ViewGroup r3) {
                r2 = this;
                java.lang.String r0 = "container"
                kotlin.jvm.internal.h.f(r3, r0)
                androidx.fragment.app.DefaultSpecialEffectsController$b r3 = r2.f640d
                androidx.fragment.app.SpecialEffectsController$Operation r3 = r3.a()
                android.animation.AnimatorSet r0 = r2.f641e
                if (r0 != 0) goto L19
                androidx.fragment.app.DefaultSpecialEffectsController$b r3 = r2.f640d
                androidx.fragment.app.SpecialEffectsController$Operation r3 = r3.a()
                r3.f(r2)
                return
            L19:
                r0.start()
                r0 = 2
                boolean r0 = androidx.fragment.app.FragmentManager.O0(r0)
                if (r0 == 0) goto L3e
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "Animator from operation "
                r0.append(r1)
                r0.append(r3)
                java.lang.String r3 = " has started."
                r0.append(r3)
                java.lang.String r3 = r0.toString()
                java.lang.String r0 = "FragmentManager"
                android.util.Log.v(r0, r3)
            L3e:
                return
        }

        @Override // androidx.fragment.app.SpecialEffectsController.b
        public void e(androidx.activity.b r13, android.view.ViewGroup r14) {
                r12 = this;
                java.lang.String r0 = "backEvent"
                kotlin.jvm.internal.h.f(r13, r0)
                java.lang.String r0 = "container"
                kotlin.jvm.internal.h.f(r14, r0)
                androidx.fragment.app.DefaultSpecialEffectsController$b r14 = r12.f640d
                androidx.fragment.app.SpecialEffectsController$Operation r14 = r14.a()
                android.animation.AnimatorSet r0 = r12.f641e
                if (r0 != 0) goto L1e
                androidx.fragment.app.DefaultSpecialEffectsController$b r13 = r12.f640d
                androidx.fragment.app.SpecialEffectsController$Operation r13 = r13.a()
                r13.f(r12)
                return
            L1e:
                int r1 = android.os.Build.VERSION.SDK_INT
                r2 = 34
                if (r1 < r2) goto L95
                androidx.fragment.app.Fragment r1 = r14.i()
                boolean r1 = r1.f678v
                if (r1 == 0) goto L95
                r1 = 2
                boolean r2 = androidx.fragment.app.FragmentManager.O0(r1)
                java.lang.String r3 = "FragmentManager"
                if (r2 == 0) goto L49
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r4 = "Adding BackProgressCallbacks for Animators to operation "
                r2.append(r4)
                r2.append(r14)
                java.lang.String r2 = r2.toString()
                android.util.Log.v(r3, r2)
            L49:
                androidx.fragment.app.DefaultSpecialEffectsController$d r2 = androidx.fragment.app.DefaultSpecialEffectsController.d.f647a
                long r4 = r2.a(r0)
                float r13 = r13.a()
                float r2 = (float) r4
                float r13 = r13 * r2
                long r6 = (long) r13
                r8 = 0
                r10 = 1
                int r13 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                if (r13 != 0) goto L60
                r6 = r10
            L60:
                int r13 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
                if (r13 != 0) goto L66
                long r6 = r4 - r10
            L66:
                boolean r13 = androidx.fragment.app.FragmentManager.O0(r1)
                if (r13 == 0) goto L90
                java.lang.StringBuilder r13 = new java.lang.StringBuilder
                r13.<init>()
                java.lang.String r1 = "Setting currentPlayTime to "
                r13.append(r1)
                r13.append(r6)
                java.lang.String r1 = " for Animator "
                r13.append(r1)
                r13.append(r0)
                java.lang.String r1 = " on operation "
                r13.append(r1)
                r13.append(r14)
                java.lang.String r13 = r13.toString()
                android.util.Log.v(r3, r13)
            L90:
                androidx.fragment.app.DefaultSpecialEffectsController$e r13 = androidx.fragment.app.DefaultSpecialEffectsController.e.f648a
                r13.b(r0, r6)
            L95:
                return
        }

        @Override // androidx.fragment.app.SpecialEffectsController.b
        public void f(android.view.ViewGroup r8) {
                r7 = this;
                java.lang.String r0 = "container"
                kotlin.jvm.internal.h.f(r8, r0)
                androidx.fragment.app.DefaultSpecialEffectsController$b r0 = r7.f640d
                boolean r0 = r0.b()
                if (r0 == 0) goto Lf
                r6 = r7
                goto L59
            Lf:
                android.content.Context r0 = r8.getContext()
                androidx.fragment.app.DefaultSpecialEffectsController$b r1 = r7.f640d
                java.lang.String r2 = "context"
                kotlin.jvm.internal.h.e(r0, r2)
                androidx.fragment.app.r$a r0 = r1.c(r0)
                if (r0 == 0) goto L23
                android.animation.AnimatorSet r0 = r0.f924b
                goto L24
            L23:
                r0 = 0
            L24:
                r7.f641e = r0
                androidx.fragment.app.DefaultSpecialEffectsController$b r0 = r7.f640d
                androidx.fragment.app.SpecialEffectsController$Operation r5 = r0.a()
                androidx.fragment.app.Fragment r0 = r5.i()
                androidx.fragment.app.SpecialEffectsController$Operation$State r1 = r5.h()
                androidx.fragment.app.SpecialEffectsController$Operation$State r2 = androidx.fragment.app.SpecialEffectsController.Operation.State.GONE
                if (r1 != r2) goto L3b
                r1 = 1
                r4 = 1
                goto L3d
            L3b:
                r1 = 0
                r4 = 0
            L3d:
                android.view.View r3 = r0.R
                r8.startViewTransition(r3)
                android.animation.AnimatorSet r0 = r7.f641e
                if (r0 == 0) goto L51
                androidx.fragment.app.DefaultSpecialEffectsController$c$a r1 = new androidx.fragment.app.DefaultSpecialEffectsController$c$a
                r6 = r7
                r2 = r8
                r1.<init>(r2, r3, r4, r5, r6)
                r0.addListener(r1)
                goto L52
            L51:
                r6 = r7
            L52:
                android.animation.AnimatorSet r8 = r6.f641e
                if (r8 == 0) goto L59
                r8.setTarget(r3)
            L59:
                return
        }

        public final androidx.fragment.app.DefaultSpecialEffectsController.b h() {
                r1 = this;
                androidx.fragment.app.DefaultSpecialEffectsController$b r0 = r1.f640d
                return r0
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public static final androidx.fragment.app.DefaultSpecialEffectsController.d f647a = null;

        static {
                androidx.fragment.app.DefaultSpecialEffectsController$d r0 = new androidx.fragment.app.DefaultSpecialEffectsController$d
                r0.<init>()
                androidx.fragment.app.DefaultSpecialEffectsController.d.f647a = r0
                return
        }

        public d() {
                r0 = this;
                r0.<init>()
                return
        }

        public final long a(android.animation.AnimatorSet r3) {
                r2 = this;
                java.lang.String r0 = "animatorSet"
                kotlin.jvm.internal.h.f(r3, r0)
                long r0 = r3.getTotalDuration()
                return r0
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class e {

        /* renamed from: a, reason: collision with root package name */
        public static final androidx.fragment.app.DefaultSpecialEffectsController.e f648a = null;

        static {
                androidx.fragment.app.DefaultSpecialEffectsController$e r0 = new androidx.fragment.app.DefaultSpecialEffectsController$e
                r0.<init>()
                androidx.fragment.app.DefaultSpecialEffectsController.e.f648a = r0
                return
        }

        public e() {
                r0 = this;
                r0.<init>()
                return
        }

        public final void a(android.animation.AnimatorSet r2) {
                r1 = this;
                java.lang.String r0 = "animatorSet"
                kotlin.jvm.internal.h.f(r2, r0)
                r2.reverse()
                return
        }

        public final void b(android.animation.AnimatorSet r2, long r3) {
                r1 = this;
                java.lang.String r0 = "animatorSet"
                kotlin.jvm.internal.h.f(r2, r0)
                r2.setCurrentPlayTime(r3)
                return
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        public final androidx.fragment.app.SpecialEffectsController.Operation f649a;

        public f(androidx.fragment.app.SpecialEffectsController.Operation r2) {
                r1 = this;
                java.lang.String r0 = "operation"
                kotlin.jvm.internal.h.f(r2, r0)
                r1.<init>()
                r1.f649a = r2
                return
        }

        public final androidx.fragment.app.SpecialEffectsController.Operation a() {
                r1 = this;
                androidx.fragment.app.SpecialEffectsController$Operation r0 = r1.f649a
                return r0
        }

        public final boolean b() {
                r3 = this;
                androidx.fragment.app.SpecialEffectsController$Operation r0 = r3.f649a
                androidx.fragment.app.Fragment r0 = r0.i()
                android.view.View r0 = r0.R
                if (r0 == 0) goto L11
                androidx.fragment.app.SpecialEffectsController$Operation$State$a r1 = androidx.fragment.app.SpecialEffectsController.Operation.State.Companion
                androidx.fragment.app.SpecialEffectsController$Operation$State r0 = r1.a(r0)
                goto L12
            L11:
                r0 = 0
            L12:
                androidx.fragment.app.SpecialEffectsController$Operation r1 = r3.f649a
                androidx.fragment.app.SpecialEffectsController$Operation$State r1 = r1.h()
                if (r0 == r1) goto L23
                androidx.fragment.app.SpecialEffectsController$Operation$State r2 = androidx.fragment.app.SpecialEffectsController.Operation.State.VISIBLE
                if (r0 == r2) goto L21
                if (r1 == r2) goto L21
                goto L23
            L21:
                r0 = 0
                return r0
            L23:
                r0 = 1
                return r0
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class g extends androidx.fragment.app.DefaultSpecialEffectsController.f {

        /* renamed from: b, reason: collision with root package name */
        public final java.lang.Object f650b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f651c;

        /* renamed from: d, reason: collision with root package name */
        public final java.lang.Object f652d;

        public g(androidx.fragment.app.SpecialEffectsController.Operation r3, boolean r4, boolean r5) {
                r2 = this;
                java.lang.String r0 = "operation"
                kotlin.jvm.internal.h.f(r3, r0)
                r2.<init>(r3)
                androidx.fragment.app.SpecialEffectsController$Operation$State r0 = r3.h()
                androidx.fragment.app.SpecialEffectsController$Operation$State r1 = androidx.fragment.app.SpecialEffectsController.Operation.State.VISIBLE
                if (r0 != r1) goto L20
                androidx.fragment.app.Fragment r0 = r3.i()
                if (r4 == 0) goto L1b
                java.lang.Object r0 = r0.S0()
                goto L2f
            L1b:
                java.lang.Object r0 = r0.C0()
                goto L2f
            L20:
                androidx.fragment.app.Fragment r0 = r3.i()
                if (r4 == 0) goto L2b
                java.lang.Object r0 = r0.U0()
                goto L2f
            L2b:
                java.lang.Object r0 = r0.F0()
            L2f:
                r2.f650b = r0
                androidx.fragment.app.SpecialEffectsController$Operation$State r0 = r3.h()
                if (r0 != r1) goto L4b
                if (r4 == 0) goto L42
                androidx.fragment.app.Fragment r0 = r3.i()
                boolean r0 = r0.w0()
                goto L4c
            L42:
                androidx.fragment.app.Fragment r0 = r3.i()
                boolean r0 = r0.v0()
                goto L4c
            L4b:
                r0 = 1
            L4c:
                r2.f651c = r0
                if (r5 == 0) goto L64
                if (r4 == 0) goto L5b
                androidx.fragment.app.Fragment r3 = r3.i()
                java.lang.Object r3 = r3.W0()
                goto L65
            L5b:
                androidx.fragment.app.Fragment r3 = r3.i()
                java.lang.Object r3 = r3.V0()
                goto L65
            L64:
                r3 = 0
            L65:
                r2.f652d = r3
                return
        }

        public final androidx.fragment.app.t0 c() {
                r2 = this;
                java.lang.Object r0 = r2.f650b
                androidx.fragment.app.t0 r0 = r2.d(r0)
                java.lang.Object r1 = r2.f652d
                androidx.fragment.app.t0 r1 = r2.d(r1)
                if (r0 == 0) goto L4a
                if (r1 == 0) goto L4a
                if (r0 != r1) goto L13
                goto L4a
            L13:
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "Mixing framework transitions and AndroidX transitions is not allowed. Fragment "
                r0.append(r1)
                androidx.fragment.app.SpecialEffectsController$Operation r1 = r2.a()
                androidx.fragment.app.Fragment r1 = r1.i()
                r0.append(r1)
                java.lang.String r1 = " returned Transition "
                r0.append(r1)
                java.lang.Object r1 = r2.f650b
                r0.append(r1)
                java.lang.String r1 = " which uses a different Transition  type than its shared element transition "
                r0.append(r1)
                java.lang.Object r1 = r2.f652d
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
                java.lang.String r0 = r0.toString()
                r1.<init>(r0)
                throw r1
            L4a:
                if (r0 != 0) goto L4d
                return r1
            L4d:
                return r0
        }

        public final androidx.fragment.app.t0 d(java.lang.Object r4) {
                r3 = this;
                if (r4 != 0) goto L4
                r4 = 0
                return r4
            L4:
                androidx.fragment.app.t0 r0 = androidx.fragment.app.m0.f917b
                if (r0 == 0) goto Lf
                boolean r1 = r0.g(r4)
                if (r1 == 0) goto Lf
                return r0
            Lf:
                androidx.fragment.app.t0 r0 = androidx.fragment.app.m0.f918c
                if (r0 == 0) goto L1a
                boolean r1 = r0.g(r4)
                if (r1 == 0) goto L1a
                return r0
            L1a:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Transition "
                r1.append(r2)
                r1.append(r4)
                java.lang.String r4 = " for fragment "
                r1.append(r4)
                androidx.fragment.app.SpecialEffectsController$Operation r4 = r3.a()
                androidx.fragment.app.Fragment r4 = r4.i()
                r1.append(r4)
                java.lang.String r4 = " is not a valid framework Transition or AndroidX Transition"
                r1.append(r4)
                java.lang.String r4 = r1.toString()
                r0.<init>(r4)
                throw r0
        }

        public final java.lang.Object e() {
                r1 = this;
                java.lang.Object r0 = r1.f652d
                return r0
        }

        public final java.lang.Object f() {
                r1 = this;
                java.lang.Object r0 = r1.f650b
                return r0
        }

        public final boolean g() {
                r1 = this;
                java.lang.Object r0 = r1.f652d
                if (r0 == 0) goto L6
                r0 = 1
                return r0
            L6:
                r0 = 0
                return r0
        }

        public final boolean h() {
                r1 = this;
                boolean r0 = r1.f651c
                return r0
        }
    }

    public DefaultSpecialEffectsController(android.view.ViewGroup r2) {
            r1 = this;
            java.lang.String r0 = "container"
            kotlin.jvm.internal.h.f(r2, r0)
            r1.<init>(r2)
            return
    }

    public static /* synthetic */ void C(androidx.fragment.app.DefaultSpecialEffectsController r0, androidx.fragment.app.SpecialEffectsController.Operation r1) {
            E(r0, r1)
            return
    }

    public static final void E(androidx.fragment.app.DefaultSpecialEffectsController r1, androidx.fragment.app.SpecialEffectsController.Operation r2) {
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.h.f(r1, r0)
            java.lang.String r0 = "$operation"
            kotlin.jvm.internal.h.f(r2, r0)
            r1.c(r2)
            return
    }

    public final void D(java.util.List r11) {
            r10 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r2 = r11.iterator()
        Le:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L26
            java.lang.Object r3 = r2.next()
            androidx.fragment.app.DefaultSpecialEffectsController$b r3 = (androidx.fragment.app.DefaultSpecialEffectsController.b) r3
            androidx.fragment.app.SpecialEffectsController$Operation r3 = r3.a()
            java.util.List r3 = r3.g()
            k7.q.l(r1, r3)
            goto Le
        L26:
            boolean r1 = r1.isEmpty()
            java.util.Iterator r11 = r11.iterator()
            r2 = 0
            r3 = 0
        L30:
            boolean r4 = r11.hasNext()
            java.lang.String r5 = "FragmentManager"
            r6 = 2
            if (r4 == 0) goto La2
            java.lang.Object r4 = r11.next()
            androidx.fragment.app.DefaultSpecialEffectsController$b r4 = (androidx.fragment.app.DefaultSpecialEffectsController.b) r4
            android.view.ViewGroup r7 = r10.t()
            android.content.Context r7 = r7.getContext()
            androidx.fragment.app.SpecialEffectsController$Operation r8 = r4.a()
            java.lang.String r9 = "context"
            kotlin.jvm.internal.h.e(r7, r9)
            androidx.fragment.app.r$a r7 = r4.c(r7)
            if (r7 != 0) goto L57
            goto L30
        L57:
            android.animation.AnimatorSet r7 = r7.f924b
            if (r7 != 0) goto L5f
            r0.add(r4)
            goto L30
        L5f:
            androidx.fragment.app.Fragment r7 = r8.i()
            java.util.List r9 = r8.g()
            boolean r9 = r9.isEmpty()
            if (r9 != 0) goto L8d
            boolean r4 = androidx.fragment.app.FragmentManager.O0(r6)
            if (r4 == 0) goto L30
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = "Ignoring Animator set on "
            r4.append(r6)
            r4.append(r7)
            java.lang.String r6 = " as this Fragment was involved in a Transition."
            r4.append(r6)
            java.lang.String r4 = r4.toString()
            android.util.Log.v(r5, r4)
            goto L30
        L8d:
            androidx.fragment.app.SpecialEffectsController$Operation$State r3 = r8.h()
            androidx.fragment.app.SpecialEffectsController$Operation$State r5 = androidx.fragment.app.SpecialEffectsController.Operation.State.GONE
            if (r3 != r5) goto L98
            r8.r(r2)
        L98:
            androidx.fragment.app.DefaultSpecialEffectsController$c r3 = new androidx.fragment.app.DefaultSpecialEffectsController$c
            r3.<init>(r4)
            r8.b(r3)
            r3 = 1
            goto L30
        La2:
            java.util.Iterator r11 = r0.iterator()
        La6:
            boolean r0 = r11.hasNext()
            if (r0 == 0) goto L105
            java.lang.Object r0 = r11.next()
            androidx.fragment.app.DefaultSpecialEffectsController$b r0 = (androidx.fragment.app.DefaultSpecialEffectsController.b) r0
            androidx.fragment.app.SpecialEffectsController$Operation r2 = r0.a()
            androidx.fragment.app.Fragment r4 = r2.i()
            java.lang.String r7 = "Ignoring Animation set on "
            if (r1 != 0) goto Ldc
            boolean r0 = androidx.fragment.app.FragmentManager.O0(r6)
            if (r0 == 0) goto La6
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r7)
            r0.append(r4)
            java.lang.String r2 = " as Animations cannot run alongside Transitions."
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            android.util.Log.v(r5, r0)
            goto La6
        Ldc:
            if (r3 == 0) goto Lfc
            boolean r0 = androidx.fragment.app.FragmentManager.O0(r6)
            if (r0 == 0) goto La6
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r7)
            r0.append(r4)
            java.lang.String r2 = " as Animations cannot run alongside Animators."
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            android.util.Log.v(r5, r0)
            goto La6
        Lfc:
            androidx.fragment.app.DefaultSpecialEffectsController$a r4 = new androidx.fragment.app.DefaultSpecialEffectsController$a
            r4.<init>(r0)
            r2.b(r4)
            goto La6
        L105:
            return
    }

    public final void F(java.util.List r21, boolean r22, androidx.fragment.app.SpecialEffectsController.Operation r23, androidx.fragment.app.SpecialEffectsController.Operation r24) {
            r20 = this;
            r0 = r20
            r3 = r23
            r4 = r24
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r2 = r21.iterator()
        Lf:
            boolean r5 = r2.hasNext()
            if (r5 == 0) goto L26
            java.lang.Object r5 = r2.next()
            r6 = r5
            androidx.fragment.app.DefaultSpecialEffectsController$g r6 = (androidx.fragment.app.DefaultSpecialEffectsController.g) r6
            boolean r6 = r6.b()
            if (r6 != 0) goto Lf
            r1.add(r5)
            goto Lf
        L26:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Iterator r1 = r1.iterator()
        L2f:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L46
            java.lang.Object r5 = r1.next()
            r6 = r5
            androidx.fragment.app.DefaultSpecialEffectsController$g r6 = (androidx.fragment.app.DefaultSpecialEffectsController.g) r6
            androidx.fragment.app.t0 r6 = r6.c()
            if (r6 == 0) goto L2f
            r2.add(r5)
            goto L2f
        L46:
            java.util.Iterator r1 = r2.iterator()
            r6 = 0
        L4b:
            boolean r7 = r1.hasNext()
            if (r7 == 0) goto L96
            java.lang.Object r7 = r1.next()
            androidx.fragment.app.DefaultSpecialEffectsController$g r7 = (androidx.fragment.app.DefaultSpecialEffectsController.g) r7
            androidx.fragment.app.t0 r8 = r7.c()
            if (r6 == 0) goto L94
            if (r8 != r6) goto L60
            goto L94
        L60:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Mixing framework transitions and AndroidX transitions is not allowed. Fragment "
            r1.append(r2)
            androidx.fragment.app.SpecialEffectsController$Operation r2 = r7.a()
            androidx.fragment.app.Fragment r2 = r2.i()
            r1.append(r2)
            java.lang.String r2 = " returned Transition "
            r1.append(r2)
            java.lang.Object r2 = r7.f()
            r1.append(r2)
            java.lang.String r2 = " which uses a different Transition type than other Fragments."
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r1 = r1.toString()
            r2.<init>(r1)
            throw r2
        L94:
            r6 = r8
            goto L4b
        L96:
            if (r6 != 0) goto L9a
            goto L2df
        L9a:
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            k.a r9 = new k.a
            r9.<init>()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            k.a r12 = new k.a
            r12.<init>()
            k.a r13 = new k.a
            r13.<init>()
            java.util.Iterator r11 = r2.iterator()
            r14 = r10
            r10 = r1
            r1 = r11
            r11 = r14
        Lc5:
            r14 = 0
        Lc6:
            boolean r15 = r1.hasNext()
            if (r15 == 0) goto L299
            java.lang.Object r15 = r1.next()
            androidx.fragment.app.DefaultSpecialEffectsController$g r15 = (androidx.fragment.app.DefaultSpecialEffectsController.g) r15
            boolean r16 = r15.g()
            if (r16 == 0) goto L294
            if (r3 == 0) goto L294
            if (r4 == 0) goto L294
            java.lang.Object r10 = r15.e()
            java.lang.Object r10 = r6.h(r10)
            java.lang.Object r14 = r6.B(r10)
            androidx.fragment.app.Fragment r10 = r4.i()
            java.util.ArrayList r11 = r10.X0()
            java.lang.String r10 = "lastIn.fragment.sharedElementSourceNames"
            kotlin.jvm.internal.h.e(r11, r10)
            androidx.fragment.app.Fragment r10 = r3.i()
            java.util.ArrayList r10 = r10.X0()
            java.lang.String r15 = "firstOut.fragment.sharedElementSourceNames"
            kotlin.jvm.internal.h.e(r10, r15)
            androidx.fragment.app.Fragment r15 = r3.i()
            java.util.ArrayList r15 = r15.Y0()
            java.lang.String r5 = "firstOut.fragment.sharedElementTargetNames"
            kotlin.jvm.internal.h.e(r15, r5)
            int r5 = r15.size()
            r16 = 0
            r17 = r1
            r1 = 0
        L118:
            if (r1 >= r5) goto L137
            r18 = r2
            java.lang.Object r2 = r15.get(r1)
            int r2 = r11.indexOf(r2)
            r19 = r5
            r5 = -1
            if (r2 == r5) goto L130
            java.lang.Object r5 = r10.get(r1)
            r11.set(r2, r5)
        L130:
            int r1 = r1 + 1
            r2 = r18
            r5 = r19
            goto L118
        L137:
            r18 = r2
            androidx.fragment.app.Fragment r1 = r4.i()
            java.util.ArrayList r10 = r1.Y0()
            java.lang.String r1 = "lastIn.fragment.sharedElementTargetNames"
            kotlin.jvm.internal.h.e(r10, r1)
            if (r22 != 0) goto L15c
            androidx.fragment.app.Fragment r1 = r3.i()
            r1.G0()
            androidx.fragment.app.Fragment r1 = r4.i()
            r1.D0()
            r1 = 0
            kotlin.Pair r2 = j7.d.a(r1, r1)
            goto L16f
        L15c:
            r1 = 0
            androidx.fragment.app.Fragment r2 = r3.i()
            r2.D0()
            androidx.fragment.app.Fragment r2 = r4.i()
            r2.G0()
            kotlin.Pair r2 = j7.d.a(r1, r1)
        L16f:
            java.lang.Object r5 = r2.component1()
            n.g.a(r5)
            java.lang.Object r2 = r2.component2()
            n.g.a(r2)
            int r2 = r11.size()
            r5 = 0
        L182:
            if (r5 >= r2) goto L1a5
            java.lang.Object r15 = r11.get(r5)
            java.lang.String r1 = "exitingNames[i]"
            kotlin.jvm.internal.h.e(r15, r1)
            java.lang.String r15 = (java.lang.String) r15
            java.lang.Object r1 = r10.get(r5)
            r16 = r2
            java.lang.String r2 = "enteringNames[i]"
            kotlin.jvm.internal.h.e(r1, r2)
            java.lang.String r1 = (java.lang.String) r1
            r9.put(r15, r1)
            int r5 = r5 + 1
            r2 = r16
            r1 = 0
            goto L182
        L1a5:
            r1 = 2
            boolean r1 = androidx.fragment.app.FragmentManager.O0(r1)
            java.lang.String r2 = "FragmentManager"
            if (r1 == 0) goto L208
            java.lang.String r1 = ">>> entering view names <<<"
            android.util.Log.v(r2, r1)
            java.util.Iterator r1 = r10.iterator()
        L1b7:
            boolean r5 = r1.hasNext()
            java.lang.String r15 = "Name: "
            if (r5 == 0) goto L1dc
            java.lang.Object r5 = r1.next()
            java.lang.String r5 = (java.lang.String) r5
            r16 = r1
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r15)
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            android.util.Log.v(r2, r1)
            r1 = r16
            goto L1b7
        L1dc:
            java.lang.String r1 = ">>> exiting view names <<<"
            android.util.Log.v(r2, r1)
            java.util.Iterator r1 = r11.iterator()
        L1e5:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L208
            java.lang.Object r5 = r1.next()
            java.lang.String r5 = (java.lang.String) r5
            r16 = r1
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r15)
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            android.util.Log.v(r2, r1)
            r1 = r16
            goto L1e5
        L208:
            androidx.fragment.app.Fragment r1 = r3.i()
            android.view.View r1 = r1.R
            java.lang.String r5 = "firstOut.fragment.mView"
            kotlin.jvm.internal.h.e(r1, r5)
            r0.G(r12, r1)
            r12.n(r11)
            java.util.Set r1 = r12.keySet()
            r9.n(r1)
            androidx.fragment.app.Fragment r1 = r4.i()
            android.view.View r1 = r1.R
            java.lang.String r5 = "lastIn.fragment.mView"
            kotlin.jvm.internal.h.e(r1, r5)
            r0.G(r13, r1)
            r13.n(r10)
            java.util.Collection r1 = r9.values()
            r13.n(r1)
            androidx.fragment.app.m0.c(r9, r13)
            java.util.Set r1 = r9.keySet()
            java.lang.String r5 = "sharedElementNameMapping.keys"
            kotlin.jvm.internal.h.e(r1, r5)
            r0.H(r12, r1)
            java.util.Collection r1 = r9.values()
            java.lang.String r5 = "sharedElementNameMapping.values"
            kotlin.jvm.internal.h.e(r1, r5)
            r0.H(r13, r1)
            boolean r1 = r9.isEmpty()
            if (r1 == 0) goto L28e
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r5 = "Ignoring shared elements transition "
            r1.append(r5)
            r1.append(r14)
            java.lang.String r5 = " between "
            r1.append(r5)
            r1.append(r3)
            java.lang.String r5 = " and "
            r1.append(r5)
            r1.append(r4)
            java.lang.String r5 = " as there are no matching elements in both the entering and exiting fragment. In order to run a SharedElementTransition, both fragments involved must have the element."
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            android.util.Log.i(r2, r1)
            r7.clear()
            r8.clear()
            r1 = r17
            r2 = r18
            goto Lc5
        L28e:
            r1 = r17
            r2 = r18
            goto Lc6
        L294:
            r17 = r1
            r18 = r2
            goto L28e
        L299:
            r18 = r2
            if (r14 != 0) goto L2bc
            boolean r1 = r18.isEmpty()
            if (r1 == 0) goto L2a4
            return
        L2a4:
            java.util.Iterator r1 = r18.iterator()
        L2a8:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L2bb
            java.lang.Object r2 = r1.next()
            androidx.fragment.app.DefaultSpecialEffectsController$g r2 = (androidx.fragment.app.DefaultSpecialEffectsController.g) r2
            java.lang.Object r2 = r2.f()
            if (r2 != 0) goto L2bc
            goto L2a8
        L2bb:
            return
        L2bc:
            androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect r1 = new androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect
            r5 = r6
            r6 = r14
            r2 = r18
            r14 = r22
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            java.util.Iterator r2 = r2.iterator()
        L2cb:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L2df
            java.lang.Object r3 = r2.next()
            androidx.fragment.app.DefaultSpecialEffectsController$g r3 = (androidx.fragment.app.DefaultSpecialEffectsController.g) r3
            androidx.fragment.app.SpecialEffectsController$Operation r3 = r3.a()
            r3.b(r1)
            goto L2cb
        L2df:
            return
    }

    public final void G(java.util.Map r5, android.view.View r6) {
            r4 = this;
            java.lang.String r0 = x.r.A(r6)
            if (r0 == 0) goto L9
            r5.put(r0, r6)
        L9:
            boolean r0 = r6 instanceof android.view.ViewGroup
            if (r0 == 0) goto L2b
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6
            int r0 = r6.getChildCount()
            r1 = 0
        L14:
            if (r1 >= r0) goto L2b
            android.view.View r2 = r6.getChildAt(r1)
            int r3 = r2.getVisibility()
            if (r3 != 0) goto L28
            java.lang.String r3 = "child"
            kotlin.jvm.internal.h.e(r2, r3)
            r4.G(r5, r2)
        L28:
            int r1 = r1 + 1
            goto L14
        L2b:
            return
    }

    public final void H(k.a r2, java.util.Collection r3) {
            r1 = this;
            java.util.Set r2 = r2.entrySet()
            java.lang.String r0 = "entries"
            kotlin.jvm.internal.h.e(r2, r0)
            androidx.fragment.app.DefaultSpecialEffectsController$retainMatchingViews$1 r0 = new androidx.fragment.app.DefaultSpecialEffectsController$retainMatchingViews$1
            r0.<init>(r3)
            k7.q.n(r2, r0)
            return
    }

    public final void I(java.util.List r5) {
            r4 = this;
            java.lang.Object r0 = k7.t.u(r5)
            androidx.fragment.app.SpecialEffectsController$Operation r0 = (androidx.fragment.app.SpecialEffectsController.Operation) r0
            androidx.fragment.app.Fragment r0 = r0.i()
            java.util.Iterator r5 = r5.iterator()
        Le:
            boolean r1 = r5.hasNext()
            if (r1 == 0) goto L4b
            java.lang.Object r1 = r5.next()
            androidx.fragment.app.SpecialEffectsController$Operation r1 = (androidx.fragment.app.SpecialEffectsController.Operation) r1
            androidx.fragment.app.Fragment r2 = r1.i()
            androidx.fragment.app.Fragment$i r2 = r2.U
            androidx.fragment.app.Fragment$i r3 = r0.U
            int r3 = r3.f702c
            r2.f702c = r3
            androidx.fragment.app.Fragment r2 = r1.i()
            androidx.fragment.app.Fragment$i r2 = r2.U
            androidx.fragment.app.Fragment$i r3 = r0.U
            int r3 = r3.f703d
            r2.f703d = r3
            androidx.fragment.app.Fragment r2 = r1.i()
            androidx.fragment.app.Fragment$i r2 = r2.U
            androidx.fragment.app.Fragment$i r3 = r0.U
            int r3 = r3.f704e
            r2.f704e = r3
            androidx.fragment.app.Fragment r1 = r1.i()
            androidx.fragment.app.Fragment$i r1 = r1.U
            androidx.fragment.app.Fragment$i r2 = r0.U
            int r2 = r2.f705f
            r1.f705f = r2
            goto Le
        L4b:
            return
    }

    @Override // androidx.fragment.app.SpecialEffectsController
    public void d(java.util.List r9, boolean r10) {
            r8 = this;
            java.lang.String r0 = "operations"
            kotlin.jvm.internal.h.f(r9, r0)
            java.util.Iterator r0 = r9.iterator()
        L9:
            boolean r1 = r0.hasNext()
            r2 = 0
            java.lang.String r3 = "operation.fragment.mView"
            if (r1 == 0) goto L33
            java.lang.Object r1 = r0.next()
            r4 = r1
            androidx.fragment.app.SpecialEffectsController$Operation r4 = (androidx.fragment.app.SpecialEffectsController.Operation) r4
            androidx.fragment.app.SpecialEffectsController$Operation$State$a r5 = androidx.fragment.app.SpecialEffectsController.Operation.State.Companion
            androidx.fragment.app.Fragment r6 = r4.i()
            android.view.View r6 = r6.R
            kotlin.jvm.internal.h.e(r6, r3)
            androidx.fragment.app.SpecialEffectsController$Operation$State r5 = r5.a(r6)
            androidx.fragment.app.SpecialEffectsController$Operation$State r6 = androidx.fragment.app.SpecialEffectsController.Operation.State.VISIBLE
            if (r5 != r6) goto L9
            androidx.fragment.app.SpecialEffectsController$Operation$State r4 = r4.h()
            if (r4 == r6) goto L9
            goto L34
        L33:
            r1 = r2
        L34:
            androidx.fragment.app.SpecialEffectsController$Operation r1 = (androidx.fragment.app.SpecialEffectsController.Operation) r1
            int r0 = r9.size()
            java.util.ListIterator r0 = r9.listIterator(r0)
        L3e:
            boolean r4 = r0.hasPrevious()
            if (r4 == 0) goto L65
            java.lang.Object r4 = r0.previous()
            r5 = r4
            androidx.fragment.app.SpecialEffectsController$Operation r5 = (androidx.fragment.app.SpecialEffectsController.Operation) r5
            androidx.fragment.app.SpecialEffectsController$Operation$State$a r6 = androidx.fragment.app.SpecialEffectsController.Operation.State.Companion
            androidx.fragment.app.Fragment r7 = r5.i()
            android.view.View r7 = r7.R
            kotlin.jvm.internal.h.e(r7, r3)
            androidx.fragment.app.SpecialEffectsController$Operation$State r6 = r6.a(r7)
            androidx.fragment.app.SpecialEffectsController$Operation$State r7 = androidx.fragment.app.SpecialEffectsController.Operation.State.VISIBLE
            if (r6 == r7) goto L3e
            androidx.fragment.app.SpecialEffectsController$Operation$State r5 = r5.h()
            if (r5 != r7) goto L3e
            r2 = r4
        L65:
            androidx.fragment.app.SpecialEffectsController$Operation r2 = (androidx.fragment.app.SpecialEffectsController.Operation) r2
            r0 = 2
            boolean r0 = androidx.fragment.app.FragmentManager.O0(r0)
            if (r0 == 0) goto L8c
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "Executing operations from "
            r0.append(r3)
            r0.append(r1)
            java.lang.String r3 = " to "
            r0.append(r3)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.String r3 = "FragmentManager"
            android.util.Log.v(r3, r0)
        L8c:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            r8.I(r9)
            java.util.Iterator r9 = r9.iterator()
        L9d:
            boolean r4 = r9.hasNext()
            if (r4 == 0) goto Lcd
            java.lang.Object r4 = r9.next()
            androidx.fragment.app.SpecialEffectsController$Operation r4 = (androidx.fragment.app.SpecialEffectsController.Operation) r4
            androidx.fragment.app.DefaultSpecialEffectsController$b r5 = new androidx.fragment.app.DefaultSpecialEffectsController$b
            r5.<init>(r4, r10)
            r0.add(r5)
            androidx.fragment.app.DefaultSpecialEffectsController$g r5 = new androidx.fragment.app.DefaultSpecialEffectsController$g
            r6 = 0
            r7 = 1
            if (r10 == 0) goto Lbb
            if (r4 != r1) goto Lbe
        Lb9:
            r6 = 1
            goto Lbe
        Lbb:
            if (r4 != r2) goto Lbe
            goto Lb9
        Lbe:
            r5.<init>(r4, r10, r6)
            r3.add(r5)
            androidx.fragment.app.b r5 = new androidx.fragment.app.b
            r5.<init>(r8, r4)
            r4.a(r5)
            goto L9d
        Lcd:
            r8.F(r3, r10, r1, r2)
            r8.D(r0)
            return
    }
}
