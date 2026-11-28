package mark.via.common.widget;

import android.animation.ObjectAnimator;
import android.util.Property;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class GestureTouchEvent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f9837a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f9838b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f9839c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f9840d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public State f9841e = State.IGNORED;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f9842f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f9843g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f9844h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f9845i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f9846j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f9847k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f9848l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f9849m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f9850n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f9851o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f9852p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f9853q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f9854r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f9855s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f9856t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f9857u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public ObjectAnimator f9858v;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public enum State {
        IGNORED,
        DETECTING,
        AWAITING_HORIZONTAL,
        HORIZONTAL,
        VERTICAL_PENDING,
        VERTICAL_DRAGGING
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f9860a;

        static {
            int[] iArr = new int[State.values().length];
            f9860a = iArr;
            try {
                iArr[State.DETECTING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9860a[State.AWAITING_HORIZONTAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f9860a[State.HORIZONTAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f9860a[State.VERTICAL_PENDING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f9860a[State.VERTICAL_DRAGGING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface b {
        boolean a();

        void b();

        void c(View view, int i10);

        boolean d(View view);

        void e(boolean z10);

        int f(View view);

        boolean g();

        void h(int i10);

        void i(float f10);

        void j(boolean z10);

        boolean k(View view);

        int l();

        float m();
    }

    public GestureTouchEvent(View view, b bVar) {
        if (view == null || bVar == null) {
            throw new IllegalArgumentException("indicator and callback must not be null");
        }
        this.f9837a = view;
        this.f9838b = bVar;
        this.f9839c = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        this.f9840d = com.tuyafeng.support.utils.x.h(view.getContext(), 4.0f);
        view.setVisibility(0);
    }

    public final void a() {
        this.f9841e = State.IGNORED;
        this.f9842f = null;
        this.f9843g = false;
        this.f9853q = false;
    }

    public final void b(View view, MotionEvent motionEvent, float f10, float f11) {
        float f12 = f10 - this.f9845i;
        float f13 = f11 - this.f9846j;
        if (Math.abs(f12) >= Math.abs(f13)) {
            c(view, motionEvent, f10, f11);
            return;
        }
        if (Math.abs(f12) > this.f9839c || Math.abs(f13) > this.f9839c) {
            if (!this.f9843g || !this.f9838b.k(view)) {
                a();
                return;
            }
            if (f13 >= 0.0f ? this.f9838b.m() > 0.0f : this.f9838b.m() < 1.0f) {
                n(f11);
                d(f10, f11);
            } else {
                this.f9841e = State.VERTICAL_PENDING;
                this.f9849m = f10;
                this.f9850n = f11;
            }
        }
    }

    public final void c(View view, MotionEvent motionEvent, float f10, float f11) {
        float f12 = f10 - this.f9845i;
        float f13 = f11 - this.f9846j;
        if (this.f9841e != State.DETECTING || Math.abs(f12) > this.f9840d || Math.abs(f13) > this.f9840d) {
            int i10 = f12 > 0.0f ? 1 : 2;
            if ((this.f9844h & i10) != i10) {
                a();
                return;
            }
            if (!this.f9838b.d(view)) {
                this.f9841e = State.AWAITING_HORIZONTAL;
                this.f9847k = f10;
                this.f9848l = f11;
                this.f9857u = motionEvent.getEventTime();
                return;
            }
            float fMax = Math.max(1L, motionEvent.getEventTime() - this.f9857u);
            float f14 = (f10 - this.f9847k) / fMax;
            if (Math.abs(f14) <= Math.abs((f11 - this.f9848l) / fMax) || Math.abs(f14) <= 0.5f || Math.abs(f12) <= Math.abs(f13) + this.f9840d) {
                a();
            } else {
                m(view, i10, f12);
            }
        }
    }

    public final void d(float f10, float f11) {
        int iL = this.f9838b.l();
        float f12 = f11 - this.f9848l;
        if (iL > 0) {
            b bVar = this.f9838b;
            bVar.i(bVar.m() - (f12 / iL));
            if (f12 != 0.0f && (f12 >= 0.0f ? this.f9838b.m() <= 0.0f : this.f9838b.m() >= 1.0f)) {
                boolean z10 = this.f9838b.m() <= 0.0f;
                this.f9838b.e(z10);
                if (!z10 && !this.f9838b.g()) {
                    a();
                    return;
                } else {
                    this.f9841e = State.VERTICAL_PENDING;
                    this.f9849m = f10;
                    this.f9850n = f11;
                }
            }
        }
        this.f9848l = f11;
    }

    public final void e() {
        ObjectAnimator objectAnimatorOfFloat;
        float fAbs;
        int iAbs = Math.abs(this.f9855s);
        int i10 = this.f9854r;
        if (iAbs < i10) {
            fAbs = i10 == 0 ? 0.0f : Math.abs(this.f9855s) / this.f9854r;
            View view = this.f9837a;
            Property property = View.TRANSLATION_X;
            int i11 = this.f9856t;
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) property, this.f9855s + i11, i11);
        } else {
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f9837a, (Property<View, Float>) View.ALPHA, 1.0f, 0.0f);
            this.f9838b.h(this.f9855s <= 0 ? 2 : 1);
            fAbs = 1.0f;
        }
        this.f9858v = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration((long) (fAbs * 300.0f));
        objectAnimatorOfFloat.start();
    }

    public final void f(View view, MotionEvent motionEvent) {
        State state;
        if (this.f9842f != view || (state = this.f9841e) == State.IGNORED) {
            return;
        }
        if ((state == State.VERTICAL_PENDING || state == State.VERTICAL_DRAGGING) && !this.f9838b.k(view)) {
            i();
            return;
        }
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        int i10 = a.f9860a[this.f9841e.ordinal()];
        if (i10 == 1) {
            b(view, motionEvent, rawX, rawY);
            return;
        }
        if (i10 == 2) {
            c(view, motionEvent, rawX, rawY);
            return;
        }
        if (i10 == 3) {
            o(rawX);
            return;
        }
        if (i10 != 4) {
            if (i10 != 5) {
                return;
            }
            d(rawX, rawY);
        } else if (!k(rawX, rawY)) {
            p(rawX, rawY);
        } else {
            n(rawY);
            d(rawX, rawY);
        }
    }

    public void g(View view, MotionEvent motionEvent) {
        if (view == null || motionEvent == null) {
            return;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            l(view, motionEvent);
            return;
        }
        if (actionMasked == 1) {
            h();
            return;
        }
        if (actionMasked == 2) {
            f(view, motionEvent);
            return;
        }
        if (actionMasked != 3) {
            if (actionMasked != 5) {
                return;
            }
            i();
        } else {
            State state = this.f9841e;
            if (state == State.VERTICAL_DRAGGING || state == State.VERTICAL_PENDING) {
                h();
            } else {
                i();
            }
        }
    }

    public final void h() {
        State state = this.f9841e;
        if (state == State.HORIZONTAL) {
            e();
        } else if (state == State.VERTICAL_DRAGGING) {
            float f10 = this.f9852p;
            this.f9838b.j(f10 >= 1.0f || (f10 > 0.0f && this.f9838b.m() < 0.5f));
        }
        a();
    }

    public void i() {
        if (this.f9853q) {
            this.f9838b.j(this.f9851o);
        }
        j();
        a();
    }

    public final void j() {
        ObjectAnimator objectAnimator = this.f9858v;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            this.f9858v = null;
        }
        this.f9855s = 0;
        this.f9837a.setAlpha(1.0f);
        this.f9837a.setTranslationX(0.0f);
    }

    public final boolean k(float f10, float f11) {
        float f12 = f10 - this.f9849m;
        float f13 = f11 - this.f9850n;
        if (this.f9838b.m() >= 1.0f) {
            if (f13 <= 0.0f) {
                return false;
            }
        } else if (f13 >= 0.0f) {
            return false;
        }
        return Math.abs(f13) > ((float) this.f9839c) && Math.abs(f13) > Math.abs(f12);
    }

    public final void l(View view, MotionEvent motionEvent) {
        j();
        this.f9842f = view;
        this.f9845i = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        this.f9846j = rawY;
        float f10 = this.f9845i;
        this.f9847k = f10;
        this.f9848l = rawY;
        this.f9849m = f10;
        this.f9850n = rawY;
        this.f9857u = motionEvent.getEventTime();
        this.f9844h = this.f9838b.f(view);
        boolean zK = this.f9838b.k(view);
        this.f9843g = zK;
        this.f9853q = false;
        this.f9841e = (this.f9844h != 0 || zK) ? State.DETECTING : State.IGNORED;
    }

    public final void m(View view, int i10, float f10) {
        int iMax = Math.max(this.f9837a.getWidth(), this.f9837a.getMeasuredWidth());
        if (iMax <= 0) {
            a();
            return;
        }
        this.f9841e = State.HORIZONTAL;
        this.f9854r = (iMax * 4) / 5;
        this.f9856t = f10 > 0.0f ? -10 : view.getWidth() + iMax + 10;
        this.f9855s = 0;
        this.f9838b.c(this.f9837a, i10);
        this.f9837a.setTranslationX(this.f9856t);
        o(this.f9845i + f10);
    }

    public final void n(float f10) {
        this.f9841e = State.VERTICAL_DRAGGING;
        if (!this.f9853q) {
            this.f9851o = this.f9838b.a();
            this.f9852p = this.f9838b.m();
            this.f9853q = true;
        }
        float f11 = this.f9850n;
        this.f9848l = f11 + Math.copySign(this.f9839c, f10 - f11);
        this.f9838b.b();
    }

    public final void o(float f10) {
        int i10 = (((int) (f10 - this.f9847k)) * 8) / 10;
        this.f9847k = f10;
        int i11 = this.f9855s;
        int i12 = i11 + i10;
        int i13 = this.f9854r;
        if (i12 > i13 && i10 > 0) {
            i10 = i13 - i11;
        } else if (i11 + i10 < (-i13) && i10 < 0) {
            i10 = (-i13) - i11;
        }
        if ((i11 > 0 && i11 + i10 <= 0) || (i11 < 0 && i11 + i10 >= 0)) {
            i10 = 0;
        }
        int i14 = i11 + i10;
        this.f9855s = i14;
        this.f9837a.setTranslationX(this.f9856t + i14);
    }

    public final void p(float f10, float f11) {
        if (this.f9838b.m() >= 1.0f) {
            if (f11 >= this.f9850n) {
                return;
            }
        } else if (f11 <= this.f9850n) {
            return;
        }
        this.f9849m = f10;
        this.f9850n = f11;
    }
}
