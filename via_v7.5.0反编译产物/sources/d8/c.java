package d8;

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

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class c extends Fragment {

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public ViewGroup f3942o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public View f3943p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public int f3944q0 = 8388693;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public int f3945r0 = -2;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public int f3946s0 = -2;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public boolean f3947t0 = false;

    public static /* synthetic */ void S2(c cVar, int i10) {
        cVar.f3942o0.removeView(cVar.f3943p0);
        cVar.f3942o0.addView(cVar.f3943p0, new FrameLayout.LayoutParams(cVar.f3945r0, cVar.f3946s0, i10));
        int iE = v8.h.e(cVar.G());
        boolean z10 = (i10 & 80) == 80;
        com.tuyafeng.support.utils.x.P(cVar.f3943p0, new com.tuyafeng.support.utils.g().h(com.tuyafeng.support.utils.e.a(cVar.G(), w7.k.f13724d)).d(z10 ? iE : 0.0f, z10 ? 0.0f : iE).a());
        y.r.c(cVar.f3943p0).a(1.0f).d(120L).f();
    }

    public static /* synthetic */ void T2(c cVar) {
        View view;
        if (cVar.g1() && (view = cVar.f3943p0) != null && view.isAttachedToWindow()) {
            cVar.W2();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View A1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f3942o0 = new FrameLayout(G());
        this.f3943p0 = V2(layoutInflater, viewGroup, bundle);
        this.f3942o0.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f3942o0.addView(this.f3943p0, new FrameLayout.LayoutParams(this.f3945r0, this.f3946s0, this.f3944q0));
        int iE = v8.h.e(G());
        boolean z10 = (this.f3944q0 & 80) == 80;
        com.tuyafeng.support.utils.g gVarH = new com.tuyafeng.support.utils.g().h(com.tuyafeng.support.utils.e.a(G(), w7.k.f13724d));
        boolean z11 = this.f3947t0;
        com.tuyafeng.support.utils.x.P(this.f3943p0, gVarH.d((z11 || z10) ? iE : 0.0f, (z11 || !z10) ? iE : 0.0f).a());
        return this.f3942o0;
    }

    public CharSequence U2() {
        return X0(w7.u.f14066h1);
    }

    @Override // androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        y.r.Z(this.f3943p0, U2());
        this.f3943p0.post(new Runnable() { // from class: d8.a
            @Override // java.lang.Runnable
            public final void run() {
                c.T2(this.f3936c);
            }
        });
    }

    public abstract View V2(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle);

    public void W2() {
        com.tuyafeng.support.utils.x.L(this.f3943p0);
    }

    public void X2(final int i10) {
        if (this.f3944q0 == i10 || this.f3942o0 == null || this.f3943p0 == null) {
            return;
        }
        this.f3944q0 = i10;
        if (w0() != null) {
            w0().putInt("gravity", i10);
        }
        y.r.c(this.f3943p0).a(0.0f).d(120L).i(new Runnable() { // from class: d8.b
            @Override // java.lang.Runnable
            public final void run() {
                c.S2(this.f3938c, i10);
            }
        }).f();
    }

    @Override // androidx.fragment.app.Fragment
    public void t1(Context context) {
        super.t1(context);
        Bundle bundleW0 = w0();
        if (bundleW0 == null || bundleW0.isEmpty()) {
            return;
        }
        this.f3944q0 = bundleW0.getInt("gravity", this.f3944q0);
        this.f3945r0 = bundleW0.getInt("width", this.f3945r0);
        this.f3946s0 = bundleW0.getInt("height", this.f3946s0);
        this.f3947t0 = bundleW0.getBoolean("homepage", this.f3947t0);
    }

    @Override // androidx.fragment.app.Fragment
    public Animation x1(int i10, boolean z10, int i11) {
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public Animator y1(int i10, boolean z10, int i11) {
        ObjectAnimator objectAnimatorOfFloat;
        if (a1() == null) {
            return null;
        }
        boolean z11 = (this.f3944q0 & 80) == 80;
        ObjectAnimator objectAnimatorOfFloat2 = z10 ? ObjectAnimator.ofFloat(a1(), "alpha", 0.0f, 1.0f) : ObjectAnimator.ofFloat(a1(), "alpha", 1.0f, 0.0f);
        if (z10) {
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(a1(), "translationY", z11 ? 120.0f : -120.0f, 0.0f);
        } else {
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(a1(), "translationY", 0.0f, z11 ? 120.0f : -120.0f);
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(objectAnimatorOfFloat2).with(objectAnimatorOfFloat);
        animatorSet.setDuration(160L);
        animatorSet.setInterpolator(new AccelerateInterpolator());
        return animatorSet;
    }
}
