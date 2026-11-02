package f8;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class c extends Fragment {

    /* renamed from: m0, reason: collision with root package name */
    public ViewGroup f5966m0;

    /* renamed from: n0, reason: collision with root package name */
    public View f5967n0;

    /* renamed from: o0, reason: collision with root package name */
    public int f5968o0 = 8388693;

    /* renamed from: p0, reason: collision with root package name */
    public int f5969p0 = -2;

    /* renamed from: q0, reason: collision with root package name */
    public int f5970q0 = -2;

    /* renamed from: r0, reason: collision with root package name */
    public boolean f5971r0 = false;

    public static /* synthetic */ void U2(c cVar, int i10) {
        cVar.f5966m0.removeView(cVar.f5967n0);
        cVar.f5966m0.addView(cVar.f5967n0, new FrameLayout.LayoutParams(cVar.f5969p0, cVar.f5970q0, i10));
        int iE = x8.h.e(cVar.I());
        boolean z10 = (i10 & 80) == 80;
        g6.y.O(cVar.f5967n0, new g6.g().h(g6.e.a(cVar.I(), x7.k.f13657c)).d(z10 ? iE : 0.0f, z10 ? 0.0f : iE).a());
        x.r.c(cVar.f5967n0).a(1.0f).d(120L).f();
    }

    public static /* synthetic */ void V2(c cVar) {
        View view;
        if (cVar.i1() && (view = cVar.f5967n0) != null && view.isAttachedToWindow()) {
            cVar.Y2();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public Animator A1(int i10, boolean z10, int i11) {
        ObjectAnimator objectAnimatorOfFloat;
        if (c1() == null) {
            return null;
        }
        boolean z11 = (this.f5968o0 & 80) == 80;
        ObjectAnimator objectAnimatorOfFloat2 = z10 ? ObjectAnimator.ofFloat(c1(), "alpha", 0.0f, 1.0f) : ObjectAnimator.ofFloat(c1(), "alpha", 1.0f, 0.0f);
        if (z10) {
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(c1(), "translationY", z11 ? 120.0f : -120.0f, 0.0f);
        } else {
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(c1(), "translationY", 0.0f, z11 ? 120.0f : -120.0f);
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(objectAnimatorOfFloat2).with(objectAnimatorOfFloat);
        animatorSet.setDuration(160L);
        animatorSet.setInterpolator(new AccelerateInterpolator());
        return animatorSet;
    }

    @Override // androidx.fragment.app.Fragment
    public View C1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f5966m0 = new FrameLayout(I());
        this.f5967n0 = X2(layoutInflater, viewGroup, bundle);
        this.f5966m0.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f5966m0.addView(this.f5967n0, new FrameLayout.LayoutParams(this.f5969p0, this.f5970q0, this.f5968o0));
        int iE = x8.h.e(I());
        boolean z10 = (this.f5968o0 & 80) == 80;
        g6.g gVarH = new g6.g().h(g6.e.a(I(), x7.k.f13657c));
        boolean z11 = this.f5971r0;
        g6.y.O(this.f5967n0, gVarH.d((z11 || z10) ? iE : 0.0f, (z11 || !z10) ? iE : 0.0f).a());
        return this.f5966m0;
    }

    public CharSequence W2() {
        return Z0(x7.u.f13958e1);
    }

    @Override // androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        x.r.Y(this.f5967n0, W2());
        this.f5967n0.post(new Runnable() { // from class: f8.a
            @Override // java.lang.Runnable
            public final void run() {
                c.V2(this.f5961e);
            }
        });
    }

    public abstract View X2(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle);

    public void Y2() {
        g6.y.K(this.f5967n0);
    }

    public void Z2(final int i10) {
        if (this.f5968o0 == i10 || this.f5966m0 == null || this.f5967n0 == null) {
            return;
        }
        this.f5968o0 = i10;
        if (y0() != null) {
            y0().putInt("gravity", i10);
        }
        x.r.c(this.f5967n0).a(0.0f).d(120L).i(new Runnable() { // from class: f8.b
            @Override // java.lang.Runnable
            public final void run() {
                c.U2(this.f5963e, i10);
            }
        }).f();
    }

    @Override // androidx.fragment.app.Fragment
    public void v1(Context context) {
        super.v1(context);
        Bundle bundleY0 = y0();
        if (bundleY0 == null || bundleY0.isEmpty()) {
            return;
        }
        this.f5968o0 = bundleY0.getInt("gravity", this.f5968o0);
        this.f5969p0 = bundleY0.getInt("width", this.f5969p0);
        this.f5970q0 = bundleY0.getInt("height", this.f5970q0);
        this.f5971r0 = bundleY0.getBoolean("homepage", this.f5971r0);
    }

    @Override // androidx.fragment.app.Fragment
    public Animation z1(int i10, boolean z10, int i11) {
        return null;
    }
}
