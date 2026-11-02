package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.fragment.app.DefaultSpecialEffectsController;
import androidx.fragment.app.SpecialEffectsController;
import androidx.fragment.app.r;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$ObjectRef;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class DefaultSpecialEffectsController extends SpecialEffectsController {

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class TransitionEffect extends SpecialEffectsController.b {

        /* renamed from: d, reason: collision with root package name */
        public final List f617d;

        /* renamed from: e, reason: collision with root package name */
        public final SpecialEffectsController.Operation f618e;

        /* renamed from: f, reason: collision with root package name */
        public final SpecialEffectsController.Operation f619f;

        /* renamed from: g, reason: collision with root package name */
        public final t0 f620g;

        /* renamed from: h, reason: collision with root package name */
        public final Object f621h;

        /* renamed from: i, reason: collision with root package name */
        public final ArrayList f622i;

        /* renamed from: j, reason: collision with root package name */
        public final ArrayList f623j;

        /* renamed from: k, reason: collision with root package name */
        public final k.a f624k;

        /* renamed from: l, reason: collision with root package name */
        public final ArrayList f625l;

        /* renamed from: m, reason: collision with root package name */
        public final ArrayList f626m;

        /* renamed from: n, reason: collision with root package name */
        public final k.a f627n;

        /* renamed from: o, reason: collision with root package name */
        public final k.a f628o;

        /* renamed from: p, reason: collision with root package name */
        public final boolean f629p;

        /* renamed from: q, reason: collision with root package name */
        public final u.i f630q;

        /* renamed from: r, reason: collision with root package name */
        public Object f631r;

        public TransitionEffect(List transitionInfos, SpecialEffectsController.Operation operation, SpecialEffectsController.Operation operation2, t0 transitionImpl, Object obj, ArrayList sharedElementFirstOutViews, ArrayList sharedElementLastInViews, k.a sharedElementNameMapping, ArrayList enteringNames, ArrayList exitingNames, k.a firstOutViews, k.a lastInViews, boolean z10) {
            kotlin.jvm.internal.h.f(transitionInfos, "transitionInfos");
            kotlin.jvm.internal.h.f(transitionImpl, "transitionImpl");
            kotlin.jvm.internal.h.f(sharedElementFirstOutViews, "sharedElementFirstOutViews");
            kotlin.jvm.internal.h.f(sharedElementLastInViews, "sharedElementLastInViews");
            kotlin.jvm.internal.h.f(sharedElementNameMapping, "sharedElementNameMapping");
            kotlin.jvm.internal.h.f(enteringNames, "enteringNames");
            kotlin.jvm.internal.h.f(exitingNames, "exitingNames");
            kotlin.jvm.internal.h.f(firstOutViews, "firstOutViews");
            kotlin.jvm.internal.h.f(lastInViews, "lastInViews");
            this.f617d = transitionInfos;
            this.f618e = operation;
            this.f619f = operation2;
            this.f620g = transitionImpl;
            this.f621h = obj;
            this.f622i = sharedElementFirstOutViews;
            this.f623j = sharedElementLastInViews;
            this.f624k = sharedElementNameMapping;
            this.f625l = enteringNames;
            this.f626m = exitingNames;
            this.f627n = firstOutViews;
            this.f628o = lastInViews;
            this.f629p = z10;
            this.f630q = new u.i();
        }

        public static final void A(SpecialEffectsController.Operation operation, TransitionEffect this$0) {
            kotlin.jvm.internal.h.f(operation, "$operation");
            kotlin.jvm.internal.h.f(this$0, "this$0");
            if (FragmentManager.O0(2)) {
                Log.v("FragmentManager", "Transition for operation " + operation + " has completed");
            }
            operation.f(this$0);
        }

        public static final void p(SpecialEffectsController.Operation operation, SpecialEffectsController.Operation operation2, TransitionEffect this$0) {
            kotlin.jvm.internal.h.f(this$0, "this$0");
            m0.a(operation.i(), operation2.i(), this$0.f629p, this$0.f628o, false);
        }

        public static final void q(t0 impl, View view, Rect lastInEpicenterRect) {
            kotlin.jvm.internal.h.f(impl, "$impl");
            kotlin.jvm.internal.h.f(lastInEpicenterRect, "$lastInEpicenterRect");
            impl.k(view, lastInEpicenterRect);
        }

        public static final void r(ArrayList transitioningViews) {
            kotlin.jvm.internal.h.f(transitioningViews, "$transitioningViews");
            m0.d(transitioningViews, 4);
        }

        public static final void y(SpecialEffectsController.Operation operation, TransitionEffect this$0) {
            kotlin.jvm.internal.h.f(operation, "$operation");
            kotlin.jvm.internal.h.f(this$0, "this$0");
            if (FragmentManager.O0(2)) {
                Log.v("FragmentManager", "Transition for operation " + operation + " has completed");
            }
            operation.f(this$0);
        }

        public static final void z(Ref$ObjectRef seekCancelLambda) {
            kotlin.jvm.internal.h.f(seekCancelLambda, "$seekCancelLambda");
            q7.a aVar = (q7.a) seekCancelLambda.element;
            if (aVar != null) {
                aVar.invoke();
            }
        }

        public final void B(ArrayList arrayList, ViewGroup viewGroup, q7.a aVar) {
            m0.d(arrayList, 4);
            ArrayList arrayListQ = this.f620g.q(this.f623j);
            if (FragmentManager.O0(2)) {
                Log.v("FragmentManager", ">>>>> Beginning transition <<<<<");
                Log.v("FragmentManager", ">>>>> SharedElementFirstOutViews <<<<<");
                Iterator it = this.f622i.iterator();
                while (it.hasNext()) {
                    Object sharedElementFirstOutViews = it.next();
                    kotlin.jvm.internal.h.e(sharedElementFirstOutViews, "sharedElementFirstOutViews");
                    View view = (View) sharedElementFirstOutViews;
                    Log.v("FragmentManager", "View: " + view + " Name: " + x.r.A(view));
                }
                Log.v("FragmentManager", ">>>>> SharedElementLastInViews <<<<<");
                Iterator it2 = this.f623j.iterator();
                while (it2.hasNext()) {
                    Object sharedElementLastInViews = it2.next();
                    kotlin.jvm.internal.h.e(sharedElementLastInViews, "sharedElementLastInViews");
                    View view2 = (View) sharedElementLastInViews;
                    Log.v("FragmentManager", "View: " + view2 + " Name: " + x.r.A(view2));
                }
            }
            aVar.invoke();
            this.f620g.y(viewGroup, this.f622i, this.f623j, arrayListQ, this.f624k);
            m0.d(arrayList, 0);
            this.f620g.A(this.f621h, this.f622i, this.f623j);
        }

        public final void C(Object obj) {
            this.f631r = obj;
        }

        @Override // androidx.fragment.app.SpecialEffectsController.b
        public boolean b() {
            if (!this.f620g.m()) {
                return false;
            }
            List<g> list = this.f617d;
            if (!androidx.activity.p.a(list) || !list.isEmpty()) {
                for (g gVar : list) {
                    if (Build.VERSION.SDK_INT < 34 || gVar.f() == null || !this.f620g.n(gVar.f())) {
                        return false;
                    }
                }
            }
            Object obj = this.f621h;
            return obj == null || this.f620g.n(obj);
        }

        @Override // androidx.fragment.app.SpecialEffectsController.b
        public void c(ViewGroup container) {
            kotlin.jvm.internal.h.f(container, "container");
            this.f630q.a();
        }

        @Override // androidx.fragment.app.SpecialEffectsController.b
        public void d(final ViewGroup container) {
            kotlin.jvm.internal.h.f(container, "container");
            if (!container.isLaidOut()) {
                for (g gVar : this.f617d) {
                    SpecialEffectsController.Operation operationA = gVar.a();
                    if (FragmentManager.O0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Container " + container + " has not been laid out. Completing operation " + operationA);
                    }
                    gVar.a().f(this);
                }
                return;
            }
            Object obj = this.f631r;
            if (obj != null) {
                t0 t0Var = this.f620g;
                kotlin.jvm.internal.h.c(obj);
                t0Var.c(obj);
                if (FragmentManager.O0(2)) {
                    Log.v("FragmentManager", "Ending execution of operations from " + this.f618e + " to " + this.f619f);
                    return;
                }
                return;
            }
            Pair pairO = o(container, this.f619f, this.f618e);
            ArrayList arrayList = (ArrayList) pairO.component1();
            final Object objComponent2 = pairO.component2();
            List list = this.f617d;
            ArrayList<SpecialEffectsController.Operation> arrayList2 = new ArrayList(k7.m.j(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(((g) it.next()).a());
            }
            for (final SpecialEffectsController.Operation operation : arrayList2) {
                this.f620g.w(operation.i(), objComponent2, this.f630q, new Runnable() { // from class: androidx.fragment.app.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        DefaultSpecialEffectsController.TransitionEffect.y(operation, this);
                    }
                });
            }
            B(arrayList, container, new q7.a() { // from class: androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect$onCommit$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // q7.a
                public /* bridge */ /* synthetic */ Object invoke() {
                    m5invoke();
                    return j7.f.f7594a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m5invoke() {
                    this.this$0.v().e(container, objComponent2);
                }
            });
            if (FragmentManager.O0(2)) {
                Log.v("FragmentManager", "Completed executing operations from " + this.f618e + " to " + this.f619f);
            }
        }

        @Override // androidx.fragment.app.SpecialEffectsController.b
        public void e(androidx.activity.b backEvent, ViewGroup container) {
            kotlin.jvm.internal.h.f(backEvent, "backEvent");
            kotlin.jvm.internal.h.f(container, "container");
            Object obj = this.f631r;
            if (obj != null) {
                this.f620g.t(obj, backEvent.a());
            }
        }

        @Override // androidx.fragment.app.SpecialEffectsController.b
        public void f(final ViewGroup container) {
            kotlin.jvm.internal.h.f(container, "container");
            if (!container.isLaidOut()) {
                Iterator it = this.f617d.iterator();
                while (it.hasNext()) {
                    SpecialEffectsController.Operation operationA = ((g) it.next()).a();
                    if (FragmentManager.O0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Container " + container + " has not been laid out. Skipping onStart for operation " + operationA);
                    }
                }
                return;
            }
            if (x() && this.f621h != null && !b()) {
                Log.i("FragmentManager", "Ignoring shared elements transition " + this.f621h + " between " + this.f618e + " and " + this.f619f + " as neither fragment has set a Transition. In order to run a SharedElementTransition, you must also set either an enter or exit transition on a fragment involved in the transaction. The sharedElementTransition will run after the back gesture has been committed.");
            }
            if (b() && x()) {
                final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                Pair pairO = o(container, this.f619f, this.f618e);
                ArrayList arrayList = (ArrayList) pairO.component1();
                final Object objComponent2 = pairO.component2();
                List list = this.f617d;
                ArrayList<SpecialEffectsController.Operation> arrayList2 = new ArrayList(k7.m.j(list, 10));
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(((g) it2.next()).a());
                }
                for (final SpecialEffectsController.Operation operation : arrayList2) {
                    this.f620g.x(operation.i(), objComponent2, this.f630q, new Runnable() { // from class: androidx.fragment.app.d
                        @Override // java.lang.Runnable
                        public final void run() {
                            DefaultSpecialEffectsController.TransitionEffect.z(ref$ObjectRef);
                        }
                    }, new Runnable() { // from class: androidx.fragment.app.e
                        @Override // java.lang.Runnable
                        public final void run() {
                            DefaultSpecialEffectsController.TransitionEffect.A(operation, this);
                        }
                    });
                }
                B(arrayList, container, new q7.a() { // from class: androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect$onStart$4

                    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
                    /* renamed from: androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect$onStart$4$2, reason: invalid class name */
                    public static final class AnonymousClass2 extends Lambda implements q7.a {
                        final /* synthetic */ ViewGroup $container;
                        final /* synthetic */ DefaultSpecialEffectsController.TransitionEffect this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        public AnonymousClass2(DefaultSpecialEffectsController.TransitionEffect transitionEffect, ViewGroup viewGroup) {
                            super(0);
                            this.this$0 = transitionEffect;
                            this.$container = viewGroup;
                        }

                        public static final void b(DefaultSpecialEffectsController.TransitionEffect this$0, ViewGroup container) {
                            kotlin.jvm.internal.h.f(this$0, "this$0");
                            kotlin.jvm.internal.h.f(container, "$container");
                            Iterator it = this$0.w().iterator();
                            while (it.hasNext()) {
                                SpecialEffectsController.Operation operationA = ((DefaultSpecialEffectsController.g) it.next()).a();
                                View viewC1 = operationA.i().c1();
                                if (viewC1 != null) {
                                    operationA.h().applyState(viewC1, container);
                                }
                            }
                        }

                        @Override // q7.a
                        public /* bridge */ /* synthetic */ Object invoke() {
                            m7invoke();
                            return j7.f.f7594a;
                        }

                        /* renamed from: invoke, reason: collision with other method in class */
                        public final void m7invoke() {
                            if (FragmentManager.O0(2)) {
                                Log.v("FragmentManager", "Animating to start");
                            }
                            t0 t0VarV = this.this$0.v();
                            Object objS = this.this$0.s();
                            kotlin.jvm.internal.h.c(objS);
                            final DefaultSpecialEffectsController.TransitionEffect transitionEffect = this.this$0;
                            final ViewGroup viewGroup = this.$container;
                            t0VarV.d(objS, 
                            /*  JADX ERROR: Method code generation error
                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0026: INVOKE 
                                  (r0v3 't0VarV' androidx.fragment.app.t0)
                                  (r1v1 'objS' java.lang.Object)
                                  (wrap:java.lang.Runnable:0x0023: CONSTRUCTOR 
                                  (r2v0 'transitionEffect' androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect A[DONT_INLINE])
                                  (r3v0 'viewGroup' android.view.ViewGroup A[DONT_INLINE])
                                 A[MD:(androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect, android.view.ViewGroup):void (m), WRAPPED] call: androidx.fragment.app.j.<init>(androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect, android.view.ViewGroup):void type: CONSTRUCTOR)
                                 VIRTUAL call: androidx.fragment.app.t0.d(java.lang.Object, java.lang.Runnable):void A[MD:(java.lang.Object, java.lang.Runnable):void (m)] in method: androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect$onStart$4.2.invoke():void, file: classes.dex
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                                	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:298)
                                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:277)
                                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:410)
                                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1604)
                                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                                	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:297)
                                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:286)
                                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:270)
                                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:161)
                                	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:310)
                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:299)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1604)
                                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                                	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:297)
                                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:286)
                                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:845)
                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1143)
                                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:910)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                                	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:298)
                                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:277)
                                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:410)
                                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1604)
                                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                                	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:297)
                                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:286)
                                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:270)
                                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:161)
                                	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:310)
                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:299)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1604)
                                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                                	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:297)
                                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:286)
                                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:270)
                                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:161)
                                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:103)
                                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                                	at jadx.core.ProcessClass.process(ProcessClass.java:79)
                                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:117)
                                	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:403)
                                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:391)
                                	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:341)
                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: androidx.fragment.app.j, state: NOT_LOADED
                                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:306)
                                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:807)
                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1143)
                                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:910)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                	... 115 more
                                */
                            /*
                                this = this;
                                r0 = 2
                                boolean r0 = androidx.fragment.app.FragmentManager.O0(r0)
                                if (r0 == 0) goto Le
                                java.lang.String r0 = "FragmentManager"
                                java.lang.String r1 = "Animating to start"
                                android.util.Log.v(r0, r1)
                            Le:
                                androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect r0 = r5.this$0
                                androidx.fragment.app.t0 r0 = r0.v()
                                androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect r1 = r5.this$0
                                java.lang.Object r1 = r1.s()
                                kotlin.jvm.internal.h.c(r1)
                                androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect r2 = r5.this$0
                                android.view.ViewGroup r3 = r5.$container
                                androidx.fragment.app.j r4 = new androidx.fragment.app.j
                                r4.<init>(r2, r3)
                                r0.d(r1, r4)
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect$onStart$4.AnonymousClass2.m7invoke():void");
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // q7.a
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m6invoke();
                        return j7.f.f7594a;
                    }

                    /* JADX WARN: Type inference failed for: r1v6, types: [T, androidx.fragment.app.DefaultSpecialEffectsController$TransitionEffect$onStart$4$2] */
                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m6invoke() {
                        DefaultSpecialEffectsController.TransitionEffect transitionEffect = this.this$0;
                        transitionEffect.C(transitionEffect.v().j(container, objComponent2));
                        boolean z10 = this.this$0.s() != null;
                        Object obj = objComponent2;
                        ViewGroup viewGroup = container;
                        if (!z10) {
                            throw new IllegalStateException(("Unable to start transition " + obj + " for container " + viewGroup + '.').toString());
                        }
                        ref$ObjectRef.element = new AnonymousClass2(this.this$0, viewGroup);
                        if (FragmentManager.O0(2)) {
                            Log.v("FragmentManager", "Started executing operations from " + this.this$0.t() + " to " + this.this$0.u());
                        }
                    }
                });
            }
        }

        public final void n(ArrayList arrayList, View view) {
            if (!(view instanceof ViewGroup)) {
                if (arrayList.contains(view)) {
                    return;
                }
                arrayList.add(view);
                return;
            }
            ViewGroup viewGroup = (ViewGroup) view;
            if (x.u.a(viewGroup)) {
                if (arrayList.contains(view)) {
                    return;
                }
                arrayList.add(view);
                return;
            }
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View child = viewGroup.getChildAt(i10);
                if (child.getVisibility() == 0) {
                    kotlin.jvm.internal.h.e(child, "child");
                    n(arrayList, child);
                }
            }
        }

        public final Pair o(ViewGroup viewGroup, SpecialEffectsController.Operation operation, final SpecialEffectsController.Operation operation2) {
            final SpecialEffectsController.Operation operation3 = operation;
            View view = new View(viewGroup.getContext());
            final Rect rect = new Rect();
            Iterator it = this.f617d.iterator();
            View view2 = null;
            boolean z10 = false;
            while (it.hasNext()) {
                if (((g) it.next()).g() && operation2 != null && operation3 != null && !this.f624k.isEmpty() && this.f621h != null) {
                    m0.a(operation3.i(), operation2.i(), this.f629p, this.f627n, true);
                    x.o.a(viewGroup, new Runnable() { // from class: androidx.fragment.app.g
                        @Override // java.lang.Runnable
                        public final void run() {
                            DefaultSpecialEffectsController.TransitionEffect.p(operation3, operation2, this);
                        }
                    });
                    this.f622i.addAll(this.f627n.values());
                    if (!this.f626m.isEmpty()) {
                        Object obj = this.f626m.get(0);
                        kotlin.jvm.internal.h.e(obj, "exitingNames[0]");
                        view2 = (View) this.f627n.get((String) obj);
                        this.f620g.v(this.f621h, view2);
                    }
                    this.f623j.addAll(this.f628o.values());
                    if (!this.f625l.isEmpty()) {
                        Object obj2 = this.f625l.get(0);
                        kotlin.jvm.internal.h.e(obj2, "enteringNames[0]");
                        final View view3 = (View) this.f628o.get((String) obj2);
                        if (view3 != null) {
                            final t0 t0Var = this.f620g;
                            x.o.a(viewGroup, new Runnable() { // from class: androidx.fragment.app.h
                                @Override // java.lang.Runnable
                                public final void run() {
                                    DefaultSpecialEffectsController.TransitionEffect.q(t0Var, view3, rect);
                                }
                            });
                            z10 = true;
                        }
                    }
                    this.f620g.z(this.f621h, view, this.f622i);
                    t0 t0Var2 = this.f620g;
                    Object obj3 = this.f621h;
                    t0Var2.s(obj3, null, null, null, null, obj3, this.f623j);
                }
            }
            ArrayList arrayList = new ArrayList();
            Iterator it2 = this.f617d.iterator();
            Object objP = null;
            Object objP2 = null;
            while (it2.hasNext()) {
                g gVar = (g) it2.next();
                SpecialEffectsController.Operation operationA = gVar.a();
                boolean z11 = z10;
                Object objH = this.f620g.h(gVar.f());
                if (objH != null) {
                    final ArrayList arrayList2 = new ArrayList();
                    Iterator it3 = it2;
                    View view4 = operationA.i().R;
                    kotlin.jvm.internal.h.e(view4, "operation.fragment.mView");
                    n(arrayList2, view4);
                    if (this.f621h != null && (operationA == operation2 || operationA == operation3)) {
                        if (operationA == operation2) {
                            arrayList2.removeAll(k7.t.A(this.f622i));
                        } else {
                            arrayList2.removeAll(k7.t.A(this.f623j));
                        }
                    }
                    if (arrayList2.isEmpty()) {
                        this.f620g.a(objH, view);
                    } else {
                        this.f620g.b(objH, arrayList2);
                        this.f620g.s(objH, objH, arrayList2, null, null, null, null);
                        if (operationA.h() == SpecialEffectsController.Operation.State.GONE) {
                            operationA.r(false);
                            ArrayList arrayList3 = new ArrayList(arrayList2);
                            arrayList3.remove(operationA.i().R);
                            this.f620g.r(objH, operationA.i().R, arrayList3);
                            x.o.a(viewGroup, new Runnable() { // from class: androidx.fragment.app.i
                                @Override // java.lang.Runnable
                                public final void run() {
                                    DefaultSpecialEffectsController.TransitionEffect.r(arrayList2);
                                }
                            });
                        }
                    }
                    if (operationA.h() == SpecialEffectsController.Operation.State.VISIBLE) {
                        arrayList.addAll(arrayList2);
                        if (z11) {
                            this.f620g.u(objH, rect);
                        }
                        if (FragmentManager.O0(2)) {
                            Log.v("FragmentManager", "Entering Transition: " + objH);
                            Log.v("FragmentManager", ">>>>> EnteringViews <<<<<");
                            Iterator it4 = arrayList2.iterator();
                            while (it4.hasNext()) {
                                Object transitioningViews = it4.next();
                                kotlin.jvm.internal.h.e(transitioningViews, "transitioningViews");
                                Log.v("FragmentManager", "View: " + ((View) transitioningViews));
                            }
                        }
                    } else {
                        this.f620g.v(objH, view2);
                        if (FragmentManager.O0(2)) {
                            Log.v("FragmentManager", "Exiting Transition: " + objH);
                            Log.v("FragmentManager", ">>>>> ExitingViews <<<<<");
                            Iterator it5 = arrayList2.iterator();
                            while (it5.hasNext()) {
                                Object transitioningViews2 = it5.next();
                                kotlin.jvm.internal.h.e(transitioningViews2, "transitioningViews");
                                Log.v("FragmentManager", "View: " + ((View) transitioningViews2));
                            }
                        }
                    }
                    if (gVar.h()) {
                        objP = this.f620g.p(objP, objH, null);
                    } else {
                        objP2 = this.f620g.p(objP2, objH, null);
                    }
                    operation3 = operation;
                    z10 = z11;
                    it2 = it3;
                } else {
                    operation3 = operation;
                    z10 = z11;
                }
            }
            Object objO = this.f620g.o(objP, objP2, this.f621h);
            if (FragmentManager.O0(2)) {
                Log.v("FragmentManager", "Final merged transition: " + objO);
            }
            return new Pair(arrayList, objO);
        }

        public final Object s() {
            return this.f631r;
        }

        public final SpecialEffectsController.Operation t() {
            return this.f618e;
        }

        public final SpecialEffectsController.Operation u() {
            return this.f619f;
        }

        public final t0 v() {
            return this.f620g;
        }

        public final List w() {
            return this.f617d;
        }

        public final boolean x() {
            List list = this.f617d;
            if (androidx.activity.p.a(list) && list.isEmpty()) {
                return true;
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (!((g) it.next()).a().i().f678v) {
                    return false;
                }
            }
            return true;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class a extends SpecialEffectsController.b {

        /* renamed from: d, reason: collision with root package name */
        public final b f632d;

        /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
        /* renamed from: androidx.fragment.app.DefaultSpecialEffectsController$a$a, reason: collision with other inner class name */
        public static final class AnimationAnimationListenerC0012a implements Animation.AnimationListener {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ SpecialEffectsController.Operation f633a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ViewGroup f634b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ View f635c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ a f636d;

            public AnimationAnimationListenerC0012a(SpecialEffectsController.Operation operation, ViewGroup viewGroup, View view, a aVar) {
                this.f633a = operation;
                this.f634b = viewGroup;
                this.f635c = view;
                this.f636d = aVar;
            }

            public static final void b(ViewGroup container, View view, a this$0) {
                kotlin.jvm.internal.h.f(container, "$container");
                kotlin.jvm.internal.h.f(this$0, "this$0");
                container.endViewTransition(view);
                this$0.h().a().f(this$0);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                kotlin.jvm.internal.h.f(animation, "animation");
                final ViewGroup viewGroup = this.f634b;
                final View view = this.f635c;
                final a aVar = this.f636d;
                viewGroup.post(new Runnable() { // from class: androidx.fragment.app.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        DefaultSpecialEffectsController.a.AnimationAnimationListenerC0012a.b(viewGroup, view, aVar);
                    }
                });
                if (FragmentManager.O0(2)) {
                    Log.v("FragmentManager", "Animation from operation " + this.f633a + " has ended.");
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                kotlin.jvm.internal.h.f(animation, "animation");
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                kotlin.jvm.internal.h.f(animation, "animation");
                if (FragmentManager.O0(2)) {
                    Log.v("FragmentManager", "Animation from operation " + this.f633a + " has reached onAnimationStart.");
                }
            }
        }

        public a(b animationInfo) {
            kotlin.jvm.internal.h.f(animationInfo, "animationInfo");
            this.f632d = animationInfo;
        }

        @Override // androidx.fragment.app.SpecialEffectsController.b
        public void c(ViewGroup container) {
            kotlin.jvm.internal.h.f(container, "container");
            SpecialEffectsController.Operation operationA = this.f632d.a();
            View view = operationA.i().R;
            view.clearAnimation();
            container.endViewTransition(view);
            this.f632d.a().f(this);
            if (FragmentManager.O0(2)) {
                Log.v("FragmentManager", "Animation from operation " + operationA + " has been cancelled.");
            }
        }

        @Override // androidx.fragment.app.SpecialEffectsController.b
        public void d(ViewGroup container) throws Resources.NotFoundException {
            kotlin.jvm.internal.h.f(container, "container");
            if (this.f632d.b()) {
                this.f632d.a().f(this);
                return;
            }
            Context context = container.getContext();
            SpecialEffectsController.Operation operationA = this.f632d.a();
            View view = operationA.i().R;
            b bVar = this.f632d;
            kotlin.jvm.internal.h.e(context, "context");
            r.a aVarC = bVar.c(context);
            if (aVarC == null) {
                throw new IllegalStateException("Required value was null.");
            }
            Animation animation = aVarC.f923a;
            if (animation == null) {
                throw new IllegalStateException("Required value was null.");
            }
            if (operationA.h() != SpecialEffectsController.Operation.State.REMOVED) {
                view.startAnimation(animation);
                this.f632d.a().f(this);
                return;
            }
            container.startViewTransition(view);
            r.b bVar2 = new r.b(animation, container, view);
            bVar2.setAnimationListener(new AnimationAnimationListenerC0012a(operationA, container, view, this));
            view.startAnimation(bVar2);
            if (FragmentManager.O0(2)) {
                Log.v("FragmentManager", "Animation from operation " + operationA + " has started.");
            }
        }

        public final b h() {
            return this.f632d;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class b extends f {

        /* renamed from: b, reason: collision with root package name */
        public final boolean f637b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f638c;

        /* renamed from: d, reason: collision with root package name */
        public r.a f639d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(SpecialEffectsController.Operation operation, boolean z10) {
            super(operation);
            kotlin.jvm.internal.h.f(operation, "operation");
            this.f637b = z10;
        }

        public final r.a c(Context context) throws Resources.NotFoundException {
            kotlin.jvm.internal.h.f(context, "context");
            if (this.f638c) {
                return this.f639d;
            }
            r.a aVarB = r.b(context, a().i(), a().h() == SpecialEffectsController.Operation.State.VISIBLE, this.f637b);
            this.f639d = aVarB;
            this.f638c = true;
            return aVarB;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class c extends SpecialEffectsController.b {

        /* renamed from: d, reason: collision with root package name */
        public final b f640d;

        /* renamed from: e, reason: collision with root package name */
        public AnimatorSet f641e;

        /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
        public static final class a extends AnimatorListenerAdapter {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ViewGroup f642a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ View f643b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ boolean f644c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ SpecialEffectsController.Operation f645d;

            /* renamed from: e, reason: collision with root package name */
            public final /* synthetic */ c f646e;

            public a(ViewGroup viewGroup, View view, boolean z10, SpecialEffectsController.Operation operation, c cVar) {
                this.f642a = viewGroup;
                this.f643b = view;
                this.f644c = z10;
                this.f645d = operation;
                this.f646e = cVar;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator anim) {
                kotlin.jvm.internal.h.f(anim, "anim");
                this.f642a.endViewTransition(this.f643b);
                if (this.f644c) {
                    SpecialEffectsController.Operation.State stateH = this.f645d.h();
                    View viewToAnimate = this.f643b;
                    kotlin.jvm.internal.h.e(viewToAnimate, "viewToAnimate");
                    stateH.applyState(viewToAnimate, this.f642a);
                }
                this.f646e.h().a().f(this.f646e);
                if (FragmentManager.O0(2)) {
                    Log.v("FragmentManager", "Animator from operation " + this.f645d + " has ended.");
                }
            }
        }

        public c(b animatorInfo) {
            kotlin.jvm.internal.h.f(animatorInfo, "animatorInfo");
            this.f640d = animatorInfo;
        }

        @Override // androidx.fragment.app.SpecialEffectsController.b
        public boolean b() {
            return true;
        }

        @Override // androidx.fragment.app.SpecialEffectsController.b
        public void c(ViewGroup container) {
            kotlin.jvm.internal.h.f(container, "container");
            AnimatorSet animatorSet = this.f641e;
            if (animatorSet == null) {
                this.f640d.a().f(this);
                return;
            }
            SpecialEffectsController.Operation operationA = this.f640d.a();
            if (!operationA.n()) {
                animatorSet.end();
            } else if (Build.VERSION.SDK_INT >= 26) {
                e.f648a.a(animatorSet);
            }
            if (FragmentManager.O0(2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Animator from operation ");
                sb2.append(operationA);
                sb2.append(" has been canceled");
                sb2.append(operationA.n() ? " with seeking." : ".");
                sb2.append(' ');
                Log.v("FragmentManager", sb2.toString());
            }
        }

        @Override // androidx.fragment.app.SpecialEffectsController.b
        public void d(ViewGroup container) {
            kotlin.jvm.internal.h.f(container, "container");
            SpecialEffectsController.Operation operationA = this.f640d.a();
            AnimatorSet animatorSet = this.f641e;
            if (animatorSet == null) {
                this.f640d.a().f(this);
                return;
            }
            animatorSet.start();
            if (FragmentManager.O0(2)) {
                Log.v("FragmentManager", "Animator from operation " + operationA + " has started.");
            }
        }

        @Override // androidx.fragment.app.SpecialEffectsController.b
        public void e(androidx.activity.b backEvent, ViewGroup container) {
            kotlin.jvm.internal.h.f(backEvent, "backEvent");
            kotlin.jvm.internal.h.f(container, "container");
            SpecialEffectsController.Operation operationA = this.f640d.a();
            AnimatorSet animatorSet = this.f641e;
            if (animatorSet == null) {
                this.f640d.a().f(this);
                return;
            }
            if (Build.VERSION.SDK_INT < 34 || !operationA.i().f678v) {
                return;
            }
            if (FragmentManager.O0(2)) {
                Log.v("FragmentManager", "Adding BackProgressCallbacks for Animators to operation " + operationA);
            }
            long jA = d.f647a.a(animatorSet);
            long jA2 = (long) (backEvent.a() * jA);
            if (jA2 == 0) {
                jA2 = 1;
            }
            if (jA2 == jA) {
                jA2 = jA - 1;
            }
            if (FragmentManager.O0(2)) {
                Log.v("FragmentManager", "Setting currentPlayTime to " + jA2 + " for Animator " + animatorSet + " on operation " + operationA);
            }
            e.f648a.b(animatorSet, jA2);
        }

        @Override // androidx.fragment.app.SpecialEffectsController.b
        public void f(ViewGroup container) throws Resources.NotFoundException {
            c cVar;
            kotlin.jvm.internal.h.f(container, "container");
            if (this.f640d.b()) {
                return;
            }
            Context context = container.getContext();
            b bVar = this.f640d;
            kotlin.jvm.internal.h.e(context, "context");
            r.a aVarC = bVar.c(context);
            this.f641e = aVarC != null ? aVarC.f924b : null;
            SpecialEffectsController.Operation operationA = this.f640d.a();
            Fragment fragmentI = operationA.i();
            boolean z10 = operationA.h() == SpecialEffectsController.Operation.State.GONE;
            View view = fragmentI.R;
            container.startViewTransition(view);
            AnimatorSet animatorSet = this.f641e;
            if (animatorSet != null) {
                cVar = this;
                animatorSet.addListener(new a(container, view, z10, operationA, cVar));
            } else {
                cVar = this;
            }
            AnimatorSet animatorSet2 = cVar.f641e;
            if (animatorSet2 != null) {
                animatorSet2.setTarget(view);
            }
        }

        public final b h() {
            return this.f640d;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public static final d f647a = new d();

        public final long a(AnimatorSet animatorSet) {
            kotlin.jvm.internal.h.f(animatorSet, "animatorSet");
            return animatorSet.getTotalDuration();
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class e {

        /* renamed from: a, reason: collision with root package name */
        public static final e f648a = new e();

        public final void a(AnimatorSet animatorSet) {
            kotlin.jvm.internal.h.f(animatorSet, "animatorSet");
            animatorSet.reverse();
        }

        public final void b(AnimatorSet animatorSet, long j10) {
            kotlin.jvm.internal.h.f(animatorSet, "animatorSet");
            animatorSet.setCurrentPlayTime(j10);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        public final SpecialEffectsController.Operation f649a;

        public f(SpecialEffectsController.Operation operation) {
            kotlin.jvm.internal.h.f(operation, "operation");
            this.f649a = operation;
        }

        public final SpecialEffectsController.Operation a() {
            return this.f649a;
        }

        public final boolean b() {
            View view = this.f649a.i().R;
            SpecialEffectsController.Operation.State stateA = view != null ? SpecialEffectsController.Operation.State.Companion.a(view) : null;
            SpecialEffectsController.Operation.State stateH = this.f649a.h();
            if (stateA == stateH) {
                return true;
            }
            SpecialEffectsController.Operation.State state = SpecialEffectsController.Operation.State.VISIBLE;
            return (stateA == state || stateH == state) ? false : true;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class g extends f {

        /* renamed from: b, reason: collision with root package name */
        public final Object f650b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f651c;

        /* renamed from: d, reason: collision with root package name */
        public final Object f652d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(SpecialEffectsController.Operation operation, boolean z10, boolean z11) {
            Object objU0;
            super(operation);
            kotlin.jvm.internal.h.f(operation, "operation");
            SpecialEffectsController.Operation.State stateH = operation.h();
            SpecialEffectsController.Operation.State state = SpecialEffectsController.Operation.State.VISIBLE;
            if (stateH == state) {
                Fragment fragmentI = operation.i();
                objU0 = z10 ? fragmentI.S0() : fragmentI.C0();
            } else {
                Fragment fragmentI2 = operation.i();
                objU0 = z10 ? fragmentI2.U0() : fragmentI2.F0();
            }
            this.f650b = objU0;
            this.f651c = operation.h() == state ? z10 ? operation.i().w0() : operation.i().v0() : true;
            this.f652d = z11 ? z10 ? operation.i().W0() : operation.i().V0() : null;
        }

        public final t0 c() {
            t0 t0VarD = d(this.f650b);
            t0 t0VarD2 = d(this.f652d);
            if (t0VarD == null || t0VarD2 == null || t0VarD == t0VarD2) {
                return t0VarD == null ? t0VarD2 : t0VarD;
            }
            throw new IllegalArgumentException(("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + a().i() + " returned Transition " + this.f650b + " which uses a different Transition  type than its shared element transition " + this.f652d).toString());
        }

        public final t0 d(Object obj) {
            if (obj == null) {
                return null;
            }
            t0 t0Var = m0.f917b;
            if (t0Var != null && t0Var.g(obj)) {
                return t0Var;
            }
            t0 t0Var2 = m0.f918c;
            if (t0Var2 != null && t0Var2.g(obj)) {
                return t0Var2;
            }
            throw new IllegalArgumentException("Transition " + obj + " for fragment " + a().i() + " is not a valid framework Transition or AndroidX Transition");
        }

        public final Object e() {
            return this.f652d;
        }

        public final Object f() {
            return this.f650b;
        }

        public final boolean g() {
            return this.f652d != null;
        }

        public final boolean h() {
            return this.f651c;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultSpecialEffectsController(ViewGroup container) {
        super(container);
        kotlin.jvm.internal.h.f(container, "container");
    }

    public static final void E(DefaultSpecialEffectsController this$0, SpecialEffectsController.Operation operation) {
        kotlin.jvm.internal.h.f(this$0, "this$0");
        kotlin.jvm.internal.h.f(operation, "$operation");
        this$0.c(operation);
    }

    public final void D(List list) throws Resources.NotFoundException {
        ArrayList<b> arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            k7.q.l(arrayList2, ((b) it.next()).a().g());
        }
        boolean zIsEmpty = arrayList2.isEmpty();
        Iterator it2 = list.iterator();
        boolean z10 = false;
        while (it2.hasNext()) {
            b bVar = (b) it2.next();
            Context context = t().getContext();
            SpecialEffectsController.Operation operationA = bVar.a();
            kotlin.jvm.internal.h.e(context, "context");
            r.a aVarC = bVar.c(context);
            if (aVarC != null) {
                if (aVarC.f924b == null) {
                    arrayList.add(bVar);
                } else {
                    Fragment fragmentI = operationA.i();
                    if (operationA.g().isEmpty()) {
                        if (operationA.h() == SpecialEffectsController.Operation.State.GONE) {
                            operationA.r(false);
                        }
                        operationA.b(new c(bVar));
                        z10 = true;
                    } else if (FragmentManager.O0(2)) {
                        Log.v("FragmentManager", "Ignoring Animator set on " + fragmentI + " as this Fragment was involved in a Transition.");
                    }
                }
            }
        }
        for (b bVar2 : arrayList) {
            SpecialEffectsController.Operation operationA2 = bVar2.a();
            Fragment fragmentI2 = operationA2.i();
            if (zIsEmpty) {
                if (!z10) {
                    operationA2.b(new a(bVar2));
                } else if (FragmentManager.O0(2)) {
                    Log.v("FragmentManager", "Ignoring Animation set on " + fragmentI2 + " as Animations cannot run alongside Animators.");
                }
            } else if (FragmentManager.O0(2)) {
                Log.v("FragmentManager", "Ignoring Animation set on " + fragmentI2 + " as Animations cannot run alongside Transitions.");
            }
        }
    }

    public final void F(List list, boolean z10, SpecialEffectsController.Operation operation, SpecialEffectsController.Operation operation2) {
        Object objB;
        Iterator it;
        ArrayList arrayList;
        Pair pairA;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : list) {
            if (!((g) obj).b()) {
                arrayList2.add(obj);
            }
        }
        ArrayList<g> arrayList3 = new ArrayList();
        for (Object obj2 : arrayList2) {
            if (((g) obj2).c() != null) {
                arrayList3.add(obj2);
            }
        }
        t0 t0Var = null;
        for (g gVar : arrayList3) {
            t0 t0VarC = gVar.c();
            if (t0Var != null && t0VarC != t0Var) {
                throw new IllegalArgumentException(("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + gVar.a().i() + " returned Transition " + gVar.f() + " which uses a different Transition type than other Fragments.").toString());
            }
            t0Var = t0VarC;
        }
        if (t0Var == null) {
            return;
        }
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        k.a aVar = new k.a();
        ArrayList arrayList6 = new ArrayList();
        ArrayList arrayList7 = new ArrayList();
        k.a aVar2 = new k.a();
        k.a aVar3 = new k.a();
        ArrayList arrayListY0 = arrayList6;
        Iterator it2 = arrayList3.iterator();
        ArrayList arrayListX0 = arrayList7;
        loop3: while (true) {
            objB = null;
            while (it2.hasNext()) {
                g gVar2 = (g) it2.next();
                if (gVar2.g() && operation != null && operation2 != null) {
                    objB = t0Var.B(t0Var.h(gVar2.e()));
                    arrayListX0 = operation2.i().X0();
                    kotlin.jvm.internal.h.e(arrayListX0, "lastIn.fragment.sharedElementSourceNames");
                    ArrayList arrayListX02 = operation.i().X0();
                    kotlin.jvm.internal.h.e(arrayListX02, "firstOut.fragment.sharedElementSourceNames");
                    ArrayList arrayListY02 = operation.i().Y0();
                    kotlin.jvm.internal.h.e(arrayListY02, "firstOut.fragment.sharedElementTargetNames");
                    int size = arrayListY02.size();
                    it = it2;
                    int i10 = 0;
                    while (i10 < size) {
                        ArrayList arrayList8 = arrayList3;
                        int iIndexOf = arrayListX0.indexOf(arrayListY02.get(i10));
                        int i11 = size;
                        if (iIndexOf != -1) {
                            arrayListX0.set(iIndexOf, arrayListX02.get(i10));
                        }
                        i10++;
                        arrayList3 = arrayList8;
                        size = i11;
                    }
                    arrayList = arrayList3;
                    arrayListY0 = operation2.i().Y0();
                    kotlin.jvm.internal.h.e(arrayListY0, "lastIn.fragment.sharedElementTargetNames");
                    if (z10) {
                        operation.i().D0();
                        operation2.i().G0();
                        pairA = j7.d.a(null, null);
                    } else {
                        operation.i().G0();
                        operation2.i().D0();
                        pairA = j7.d.a(null, null);
                    }
                    n.g.a(pairA.component1());
                    n.g.a(pairA.component2());
                    int i12 = 0;
                    for (int size2 = arrayListX0.size(); i12 < size2; size2 = size2) {
                        Object obj3 = arrayListX0.get(i12);
                        kotlin.jvm.internal.h.e(obj3, "exitingNames[i]");
                        Object obj4 = arrayListY0.get(i12);
                        kotlin.jvm.internal.h.e(obj4, "enteringNames[i]");
                        aVar.put((String) obj3, (String) obj4);
                        i12++;
                    }
                    if (FragmentManager.O0(2)) {
                        Log.v("FragmentManager", ">>> entering view names <<<");
                        for (Iterator it3 = arrayListY0.iterator(); it3.hasNext(); it3 = it3) {
                            Log.v("FragmentManager", "Name: " + ((String) it3.next()));
                        }
                        Log.v("FragmentManager", ">>> exiting view names <<<");
                        for (Iterator it4 = arrayListX0.iterator(); it4.hasNext(); it4 = it4) {
                            Log.v("FragmentManager", "Name: " + ((String) it4.next()));
                        }
                    }
                    View view = operation.i().R;
                    kotlin.jvm.internal.h.e(view, "firstOut.fragment.mView");
                    G(aVar2, view);
                    aVar2.n(arrayListX0);
                    aVar.n(aVar2.keySet());
                    View view2 = operation2.i().R;
                    kotlin.jvm.internal.h.e(view2, "lastIn.fragment.mView");
                    G(aVar3, view2);
                    aVar3.n(arrayListY0);
                    aVar3.n(aVar.values());
                    m0.c(aVar, aVar3);
                    Collection collectionKeySet = aVar.keySet();
                    kotlin.jvm.internal.h.e(collectionKeySet, "sharedElementNameMapping.keys");
                    H(aVar2, collectionKeySet);
                    Collection collectionValues = aVar.values();
                    kotlin.jvm.internal.h.e(collectionValues, "sharedElementNameMapping.values");
                    H(aVar3, collectionValues);
                    if (aVar.isEmpty()) {
                        break;
                    }
                } else {
                    it = it2;
                    arrayList = arrayList3;
                }
                it2 = it;
                arrayList3 = arrayList;
            }
            Log.i("FragmentManager", "Ignoring shared elements transition " + objB + " between " + operation + " and " + operation2 + " as there are no matching elements in both the entering and exiting fragment. In order to run a SharedElementTransition, both fragments involved must have the element.");
            arrayList4.clear();
            arrayList5.clear();
            it2 = it;
            arrayList3 = arrayList;
        }
        ArrayList arrayList9 = arrayList3;
        if (objB == null) {
            if (arrayList9.isEmpty()) {
                return;
            }
            Iterator it5 = arrayList9.iterator();
            while (it5.hasNext()) {
                if (((g) it5.next()).f() == null) {
                }
            }
            return;
        }
        TransitionEffect transitionEffect = new TransitionEffect(arrayList9, operation, operation2, t0Var, objB, arrayList4, arrayList5, aVar, arrayListY0, arrayListX0, aVar2, aVar3, z10);
        Iterator it6 = arrayList9.iterator();
        while (it6.hasNext()) {
            ((g) it6.next()).a().b(transitionEffect);
        }
    }

    public final void G(Map map, View view) {
        String strA = x.r.A(view);
        if (strA != null) {
            map.put(strA, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View child = viewGroup.getChildAt(i10);
                if (child.getVisibility() == 0) {
                    kotlin.jvm.internal.h.e(child, "child");
                    G(map, child);
                }
            }
        }
    }

    public final void H(k.a aVar, final Collection collection) {
        Set entries = aVar.entrySet();
        kotlin.jvm.internal.h.e(entries, "entries");
        k7.q.n(entries, new q7.l() { // from class: androidx.fragment.app.DefaultSpecialEffectsController$retainMatchingViews$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // q7.l
            public final Boolean invoke(Map.Entry<String, View> entry) {
                kotlin.jvm.internal.h.f(entry, "entry");
                return Boolean.valueOf(k7.t.o(collection, x.r.A(entry.getValue())));
            }
        });
    }

    public final void I(List list) {
        Fragment fragmentI = ((SpecialEffectsController.Operation) k7.t.u(list)).i();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            SpecialEffectsController.Operation operation = (SpecialEffectsController.Operation) it.next();
            operation.i().U.f702c = fragmentI.U.f702c;
            operation.i().U.f703d = fragmentI.U.f703d;
            operation.i().U.f704e = fragmentI.U.f704e;
            operation.i().U.f705f = fragmentI.U.f705f;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00b9  */
    @Override // androidx.fragment.app.SpecialEffectsController
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d(List operations, boolean z10) throws Resources.NotFoundException {
        Object obj;
        Object next;
        kotlin.jvm.internal.h.f(operations, "operations");
        Iterator it = operations.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            SpecialEffectsController.Operation operation = (SpecialEffectsController.Operation) next;
            SpecialEffectsController.Operation.State.a aVar = SpecialEffectsController.Operation.State.Companion;
            View view = operation.i().R;
            kotlin.jvm.internal.h.e(view, "operation.fragment.mView");
            SpecialEffectsController.Operation.State stateA = aVar.a(view);
            SpecialEffectsController.Operation.State state = SpecialEffectsController.Operation.State.VISIBLE;
            if (stateA == state && operation.h() != state) {
                break;
            }
        }
        SpecialEffectsController.Operation operation2 = (SpecialEffectsController.Operation) next;
        ListIterator listIterator = operations.listIterator(operations.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                break;
            }
            Object objPrevious = listIterator.previous();
            SpecialEffectsController.Operation operation3 = (SpecialEffectsController.Operation) objPrevious;
            SpecialEffectsController.Operation.State.a aVar2 = SpecialEffectsController.Operation.State.Companion;
            View view2 = operation3.i().R;
            kotlin.jvm.internal.h.e(view2, "operation.fragment.mView");
            SpecialEffectsController.Operation.State stateA2 = aVar2.a(view2);
            SpecialEffectsController.Operation.State state2 = SpecialEffectsController.Operation.State.VISIBLE;
            if (stateA2 != state2 && operation3.h() == state2) {
                obj = objPrevious;
                break;
            }
        }
        SpecialEffectsController.Operation operation4 = (SpecialEffectsController.Operation) obj;
        if (FragmentManager.O0(2)) {
            Log.v("FragmentManager", "Executing operations from " + operation2 + " to " + operation4);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        I(operations);
        Iterator it2 = operations.iterator();
        while (it2.hasNext()) {
            final SpecialEffectsController.Operation operation5 = (SpecialEffectsController.Operation) it2.next();
            arrayList.add(new b(operation5, z10));
            boolean z11 = false;
            if (z10) {
                if (operation5 == operation2) {
                    z11 = true;
                }
            } else if (operation5 == operation4) {
            }
            arrayList2.add(new g(operation5, z10, z11));
            operation5.a(new Runnable() { // from class: androidx.fragment.app.b
                @Override // java.lang.Runnable
                public final void run() {
                    DefaultSpecialEffectsController.E(this.f824e, operation5);
                }
            });
        }
        F(arrayList2, z10, operation2, operation4);
        D(arrayList);
    }
}
