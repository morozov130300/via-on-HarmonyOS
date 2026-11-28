package mark.via.settings.search;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.j;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import g8.m;
import hb.w7;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mark.via.settings.helper.FabPreferenceViewDelegate;
import v5.q;
import w7.k;
import w7.n;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class SettingsSearchLocator {

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class Pending extends RecyclerView.i implements androidx.lifecycle.h {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Fragment f10356c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final RecyclerView f10357e;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final t5.f f10358m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final Bundle f10359n;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public ViewTreeObserver f10361p;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public boolean f10364s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public boolean f10365t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public ValueAnimator f10366u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public RecyclerView.n f10367v;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final List f10360o = new ArrayList();

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final ViewTreeObserver.OnPreDrawListener f10362q = new ViewTreeObserver.OnPreDrawListener() { // from class: mark.via.settings.search.d
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public final boolean onPreDraw() {
                return SettingsSearchLocator.Pending.o(this.f10383c);
            }
        };

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f10363r = -1;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public final Runnable f10368w = new Runnable() { // from class: mark.via.settings.search.e
            @Override // java.lang.Runnable
            public final void run() {
                this.f10384c.v();
            }
        };

        /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
        public class a extends RecyclerView.n {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ RectF f10369a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ float f10370b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Paint f10371c;

            public a(RectF rectF, float f10, Paint paint) {
                this.f10369a = rectF;
                this.f10370b = f10;
                this.f10371c = paint;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.n
            public void k(Canvas canvas, RecyclerView recyclerView, RecyclerView.a0 a0Var) {
                RecyclerView.d0 d0VarC0 = recyclerView.c0(Pending.this.f10363r);
                if (d0VarC0 == null || Pending.this.f10363r >= Pending.this.f10358m.H().size()) {
                    return;
                }
                Pending pending = Pending.this;
                if (pending.w(pending.f10358m.H().get(Pending.this.f10363r))) {
                    View view = d0VarC0.f1138a;
                    this.f10369a.set(view.getLeft() + view.getTranslationX(), view.getTop() + view.getTranslationY(), view.getRight() + view.getTranslationX(), view.getBottom() + view.getTranslationY());
                    RectF rectF = this.f10369a;
                    float f10 = this.f10370b;
                    canvas.drawRoundRect(rectF, f10, f10, this.f10371c);
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
        public class b extends AnimatorListenerAdapter {
            public b() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Pending.this.u();
            }
        }

        public Pending(Fragment fragment, RecyclerView recyclerView, Bundle bundle) {
            this.f10356c = fragment;
            this.f10357e = recyclerView;
            this.f10359n = bundle;
            this.f10358m = (t5.f) recyclerView.getAdapter();
        }

        public static /* synthetic */ void n(Pending pending, Paint paint, ValueAnimator valueAnimator) {
            pending.getClass();
            paint.setAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
            pending.f10357e.invalidate();
        }

        public static /* synthetic */ boolean o(Pending pending) {
            pending.B();
            return true;
        }

        private void x() {
            this.f10357e.removeCallbacks(this.f10368w);
            this.f10357e.post(this.f10368w);
        }

        public final void A() {
            ViewTreeObserver viewTreeObserver = this.f10361p;
            if (viewTreeObserver == null) {
                return;
            }
            if (viewTreeObserver.isAlive()) {
                this.f10361p.removeOnPreDrawListener(this.f10362q);
            } else {
                this.f10357e.getViewTreeObserver().removeOnPreDrawListener(this.f10362q);
            }
            this.f10361p = null;
        }

        public final void B() {
            if (this.f10364s || this.f10363r < 0 || this.f10357e.getAdapter() != this.f10358m || this.f10359n.getBoolean("settings_search_consumed") || this.f10363r >= this.f10358m.H().size() || !w(this.f10358m.H().get(this.f10363r))) {
                return;
            }
            Iterator it = this.f10360o.iterator();
            while (it.hasNext()) {
                if (!((Lifecycle) it.next()).b().isAtLeast(Lifecycle.State.RESUMED)) {
                    return;
                }
            }
            RecyclerView.d0 d0VarC0 = this.f10357e.c0(this.f10363r);
            if (d0VarC0 == null || this.f10357e.A0() || this.f10357e.isLayoutRequested() || !d0VarC0.f1138a.isLaidOut() || d0VarC0.f1138a.isLayoutRequested()) {
                return;
            }
            this.f10359n.putBoolean("settings_search_consumed", true);
            Fragment fragmentK0 = this.f10356c.K0();
            if (fragmentK0 != null && (this.f10359n.containsKey("settings_search_section") || this.f10359n.containsKey("settings_search_sync_mode"))) {
                Bundle bundleW0 = fragmentK0.w0();
                if (SettingsSearchLocator.c(bundleW0) && bundleW0.getInt("settings_search_target") == this.f10359n.getInt("settings_search_target")) {
                    bundleW0.putBoolean("settings_search_consumed", true);
                }
            }
            z();
            A();
            final Paint paint = new Paint(1);
            paint.setColor(com.tuyafeng.support.utils.e.a(this.f10356c.G(), k.f13727g));
            paint.setAlpha(85);
            a aVar = new a(new RectF(), this.f10357e.getResources().getDimension(n.f13763p), paint);
            this.f10367v = aVar;
            this.f10357e.k(aVar);
            ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(85, 25, 85, 0);
            this.f10366u = valueAnimatorOfInt;
            valueAnimatorOfInt.setDuration(1800L);
            this.f10366u.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: mark.via.settings.search.f
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    SettingsSearchLocator.Pending.n(this.f10385a, paint, valueAnimator);
                }
            });
            this.f10366u.addListener(new b());
            this.f10366u.start();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void a() {
            x();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void d(int i10, int i11) {
            x();
        }

        @Override // androidx.lifecycle.h
        public void e(j jVar, Lifecycle.Event event) {
            if (event == Lifecycle.Event.ON_DESTROY) {
                u();
            } else if (event == Lifecycle.Event.ON_RESUME) {
                this.f10357e.invalidate();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void k(int i10, int i11) {
            x();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void l(int i10, int i11, int i12) {
            x();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void m(int i10, int i11) {
            x();
        }

        public final void u() {
            if (this.f10364s) {
                return;
            }
            this.f10364s = true;
            Iterator it = this.f10360o.iterator();
            while (it.hasNext()) {
                ((Lifecycle) it.next()).c(this);
            }
            this.f10360o.clear();
            this.f10357e.removeCallbacks(this.f10368w);
            A();
            z();
            ValueAnimator valueAnimator = this.f10366u;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            RecyclerView.n nVar = this.f10367v;
            if (nVar != null) {
                this.f10357e.d1(nVar);
            }
        }

        public final void v() {
            if (this.f10364s || this.f10359n.getBoolean("settings_search_consumed")) {
                return;
            }
            this.f10363r = -1;
            for (int i10 = 0; i10 < this.f10358m.H().size(); i10++) {
                if (w(this.f10358m.H().get(i10))) {
                    this.f10363r = i10;
                    break;
                }
            }
            if (this.f10363r < 0) {
                return;
            }
            RecyclerView.o layoutManager = this.f10357e.getLayoutManager();
            if (layoutManager instanceof LinearLayoutManager) {
                ((LinearLayoutManager) layoutManager).B2(this.f10363r, 0);
            } else {
                this.f10357e.p1(this.f10363r);
            }
            this.f10357e.invalidate();
        }

        public final boolean w(Object obj) {
            return !((this.f10356c instanceof w7) && (obj instanceof v5.g)) && SettingsSearchLocator.d(obj) == this.f10359n.getInt("settings_search_target");
        }

        public void y() {
            this.f10358m.E(this);
            this.f10365t = true;
            ViewTreeObserver viewTreeObserver = this.f10357e.getViewTreeObserver();
            this.f10361p = viewTreeObserver;
            viewTreeObserver.addOnPreDrawListener(this.f10362q);
            for (Fragment fragmentK0 = this.f10356c; fragmentK0 != null; fragmentK0 = fragmentK0.K0()) {
                Lifecycle lifecycleH0 = fragmentK0.b1().h0();
                this.f10360o.add(lifecycleH0);
                lifecycleH0.a(this);
            }
            x();
        }

        public final void z() {
            if (this.f10365t) {
                this.f10358m.G(this);
                this.f10365t = false;
            }
        }
    }

    public static void b(Fragment fragment, RecyclerView recyclerView) {
        Bundle bundleW0 = fragment.w0();
        if (c(bundleW0) && (recyclerView.getAdapter() instanceof t5.f)) {
            new Pending(fragment, recyclerView, bundleW0).y();
        }
    }

    public static boolean c(Bundle bundle) {
        return (bundle == null || !bundle.containsKey("settings_search_target") || bundle.getBoolean("settings_search_consumed")) ? false : true;
    }

    public static int d(Object obj) {
        if (obj instanceof q) {
            return ((q) obj).c();
        }
        if (obj instanceof v5.e) {
            return ((v5.e) obj).d();
        }
        if (obj instanceof m) {
            return ((m) obj).b();
        }
        if (obj instanceof f9.a) {
            return ((f9.a) obj).b();
        }
        if (obj instanceof FabPreferenceViewDelegate.Item) {
            return -10002;
        }
        if (obj instanceof e8.g) {
            return -10003;
        }
        return obj instanceof String ? -10001 : Integer.MIN_VALUE;
    }
}
