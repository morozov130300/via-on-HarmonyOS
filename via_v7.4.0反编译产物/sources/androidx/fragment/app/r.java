package androidx.fragment.app;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class r {

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final Animation f923a;

        /* renamed from: b, reason: collision with root package name */
        public final AnimatorSet f924b;

        public a(Animator animator) {
            this.f923a = null;
            AnimatorSet animatorSet = new AnimatorSet();
            this.f924b = animatorSet;
            animatorSet.play(animator);
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }

        public a(Animation animation) {
            this.f923a = animation;
            this.f924b = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class b extends AnimationSet implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        public final ViewGroup f925e;

        /* renamed from: j, reason: collision with root package name */
        public final View f926j;

        /* renamed from: k, reason: collision with root package name */
        public boolean f927k;

        /* renamed from: l, reason: collision with root package name */
        public boolean f928l;

        /* renamed from: m, reason: collision with root package name */
        public boolean f929m;

        public b(Animation animation, ViewGroup viewGroup, View view) {
            super(false);
            this.f929m = true;
            this.f925e = viewGroup;
            this.f926j = view;
            addAnimation(animation);
            viewGroup.post(this);
        }

        @Override // android.view.animation.AnimationSet, android.view.animation.Animation
        public boolean getTransformation(long j10, Transformation transformation) {
            this.f929m = true;
            if (this.f927k) {
                return !this.f928l;
            }
            if (!super.getTransformation(j10, transformation)) {
                this.f927k = true;
                x.o.a(this.f925e, this);
            }
            return true;
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j10, Transformation transformation, float f10) {
            this.f929m = true;
            if (this.f927k) {
                return !this.f928l;
            }
            if (!super.getTransformation(j10, transformation, f10)) {
                this.f927k = true;
                x.o.a(this.f925e, this);
            }
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f927k || !this.f929m) {
                this.f925e.endViewTransition(this.f926j);
                this.f928l = true;
            } else {
                this.f929m = false;
                this.f925e.post(this);
            }
        }
    }

    public static int a(Fragment fragment, boolean z10, boolean z11) {
        return z11 ? z10 ? fragment.P0() : fragment.Q0() : z10 ? fragment.B0() : fragment.E0();
    }

    public static a b(Context context, Fragment fragment, boolean z10, boolean z11) throws Resources.NotFoundException {
        int iL0 = fragment.L0();
        int iA = a(fragment, z10, z11);
        fragment.G2(0, 0, 0, 0);
        ViewGroup viewGroup = fragment.Q;
        if (viewGroup != null && viewGroup.getTag(d0.b.f4437c) != null) {
            fragment.Q.setTag(d0.b.f4437c, null);
        }
        ViewGroup viewGroup2 = fragment.Q;
        if (viewGroup2 != null && viewGroup2.getLayoutTransition() != null) {
            return null;
        }
        Animation animationZ1 = fragment.z1(iL0, z10, iA);
        if (animationZ1 != null) {
            return new a(animationZ1);
        }
        Animator animatorA1 = fragment.A1(iL0, z10, iA);
        if (animatorA1 != null) {
            return new a(animatorA1);
        }
        if (iA == 0 && iL0 != 0) {
            iA = d(context, iL0, z10);
        }
        if (iA != 0) {
            boolean zEquals = "anim".equals(context.getResources().getResourceTypeName(iA));
            if (zEquals) {
                try {
                    Animation animationLoadAnimation = AnimationUtils.loadAnimation(context, iA);
                    if (animationLoadAnimation != null) {
                        return new a(animationLoadAnimation);
                    }
                } catch (Resources.NotFoundException e10) {
                    throw e10;
                } catch (RuntimeException unused) {
                }
            } else {
                try {
                    Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(context, iA);
                    if (animatorLoadAnimator != null) {
                        return new a(animatorLoadAnimator);
                    }
                } catch (RuntimeException e11) {
                    if (zEquals) {
                        throw e11;
                    }
                    Animation animationLoadAnimation2 = AnimationUtils.loadAnimation(context, iA);
                    if (animationLoadAnimation2 != null) {
                        return new a(animationLoadAnimation2);
                    }
                }
            }
        }
        return null;
    }

    public static int c(Context context, int i10) throws Resources.NotFoundException {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(R.style.Animation.Activity, new int[]{i10});
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId;
    }

    public static int d(Context context, int i10, boolean z10) {
        if (i10 == 4097) {
            return z10 ? d0.a.f4433e : d0.a.f4434f;
        }
        if (i10 == 8194) {
            return z10 ? d0.a.f4429a : d0.a.f4430b;
        }
        if (i10 == 8197) {
            return z10 ? c(context, R.attr.activityCloseEnterAnimation) : c(context, R.attr.activityCloseExitAnimation);
        }
        if (i10 == 4099) {
            return z10 ? d0.a.f4431c : d0.a.f4432d;
        }
        if (i10 != 4100) {
            return -1;
        }
        return z10 ? c(context, R.attr.activityOpenEnterAnimation) : c(context, R.attr.activityOpenExitAnimation);
    }
}
