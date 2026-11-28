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

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class r {
    public static int a(Fragment fragment, boolean z10, boolean z11) {
        if (z11) {
            return z10 ? fragment.N0() : fragment.O0();
        }
        return z10 ? fragment.z0() : fragment.C0();
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0071 A[Catch: RuntimeException -> 0x0077, TRY_LEAVE, TryCatch #0 {RuntimeException -> 0x0077, blocks: (B:32:0x006b, B:34:0x0071), top: B:45:0x006b }] */
    public static a b(Context context, Fragment fragment, boolean z10, boolean z11) {
        Animator animatorLoadAnimator;
        int iJ0 = fragment.J0();
        int iA = a(fragment, z10, z11);
        fragment.E2(0, 0, 0, 0);
        ViewGroup viewGroup = fragment.S;
        if (viewGroup != null && viewGroup.getTag(e0.b.f4069c) != null) {
            fragment.S.setTag(e0.b.f4069c, null);
        }
        ViewGroup viewGroup2 = fragment.S;
        if (viewGroup2 != null && viewGroup2.getLayoutTransition() != null) {
            return null;
        }
        Animation animationX1 = fragment.x1(iJ0, z10, iA);
        if (animationX1 != null) {
            return new a(animationX1);
        }
        Animator animatorY1 = fragment.y1(iJ0, z10, iA);
        if (animatorY1 != null) {
            return new a(animatorY1);
        }
        if (iA == 0 && iJ0 != 0) {
            iA = d(context, iJ0, z10);
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
                    try {
                        animatorLoadAnimator = AnimatorInflater.loadAnimator(context, iA);
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
            } else {
                animatorLoadAnimator = AnimatorInflater.loadAnimator(context, iA);
                if (animatorLoadAnimator != null) {
                    return new a(animatorLoadAnimator);
                }
            }
        }
        return null;
    }

    public static int c(Context context, int i10) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(R.style.Animation.Activity, new int[]{i10});
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId;
    }

    public static int d(Context context, int i10, boolean z10) {
        if (i10 == 4097) {
            return z10 ? e0.a.f4065e : e0.a.f4066f;
        }
        if (i10 == 8194) {
            return z10 ? e0.a.f4061a : e0.a.f4062b;
        }
        if (i10 == 8197) {
            return z10 ? c(context, R.attr.activityCloseEnterAnimation) : c(context, R.attr.activityCloseExitAnimation);
        }
        if (i10 == 4099) {
            return z10 ? e0.a.f4063c : e0.a.f4064d;
        }
        if (i10 != 4100) {
            return -1;
        }
        return z10 ? c(context, R.attr.activityOpenEnterAnimation) : c(context, R.attr.activityOpenExitAnimation);
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Animation f824a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AnimatorSet f825b;

        public a(Animation animation) {
            this.f824a = animation;
            this.f825b = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }

        public a(Animator animator) {
            this.f824a = null;
            AnimatorSet animatorSet = new AnimatorSet();
            this.f825b = animatorSet;
            animatorSet.play(animator);
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class b extends AnimationSet implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ViewGroup f826c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final View f827e;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f828m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f829n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f830o;

        public b(Animation animation, ViewGroup viewGroup, View view) {
            super(false);
            this.f830o = true;
            this.f826c = viewGroup;
            this.f827e = view;
            addAnimation(animation);
            viewGroup.post(this);
        }

        @Override // android.view.animation.AnimationSet, android.view.animation.Animation
        public boolean getTransformation(long j10, Transformation transformation) {
            this.f830o = true;
            if (this.f828m) {
                return !this.f829n;
            }
            if (!super.getTransformation(j10, transformation)) {
                this.f828m = true;
                y.o.a(this.f826c, this);
            }
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f828m || !this.f830o) {
                this.f826c.endViewTransition(this.f827e);
                this.f829n = true;
            } else {
                this.f830o = false;
                this.f826c.post(this);
            }
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j10, Transformation transformation, float f10) {
            this.f830o = true;
            if (this.f828m) {
                return !this.f829n;
            }
            if (!super.getTransformation(j10, transformation, f10)) {
                this.f828m = true;
                y.o.a(this.f826c, this);
            }
            return true;
        }
    }
}
