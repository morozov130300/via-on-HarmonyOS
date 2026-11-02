package mark.via.common.widget;

import android.animation.ObjectAnimator;
import android.util.Property;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class GestureTouchEvent {

    /* renamed from: a, reason: collision with root package name */
    public final View f9546a;

    /* renamed from: b, reason: collision with root package name */
    public final b f9547b;

    /* renamed from: c, reason: collision with root package name */
    public final int f9548c;

    /* renamed from: d, reason: collision with root package name */
    public final int f9549d;

    /* renamed from: e, reason: collision with root package name */
    public State f9550e = State.IGNORED;

    /* renamed from: f, reason: collision with root package name */
    public View f9551f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f9552g;

    /* renamed from: h, reason: collision with root package name */
    public int f9553h;

    /* renamed from: i, reason: collision with root package name */
    public float f9554i;

    /* renamed from: j, reason: collision with root package name */
    public float f9555j;

    /* renamed from: k, reason: collision with root package name */
    public float f9556k;

    /* renamed from: l, reason: collision with root package name */
    public float f9557l;

    /* renamed from: m, reason: collision with root package name */
    public float f9558m;

    /* renamed from: n, reason: collision with root package name */
    public float f9559n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f9560o;

    /* renamed from: p, reason: collision with root package name */
    public float f9561p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f9562q;

    /* renamed from: r, reason: collision with root package name */
    public int f9563r;

    /* renamed from: s, reason: collision with root package name */
    public int f9564s;

    /* renamed from: t, reason: collision with root package name */
    public int f9565t;

    /* renamed from: u, reason: collision with root package name */
    public long f9566u;

    /* renamed from: v, reason: collision with root package name */
    public ObjectAnimator f9567v;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public enum State {
        IGNORED,
        DETECTING,
        AWAITING_HORIZONTAL,
        HORIZONTAL,
        VERTICAL_PENDING,
        VERTICAL_DRAGGING
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f9569a;

        static {
            int[] iArr = new int[State.values().length];
            f9569a = iArr;
            try {
                iArr[State.DETECTING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9569a[State.AWAITING_HORIZONTAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f9569a[State.HORIZONTAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f9569a[State.VERTICAL_PENDING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f9569a[State.VERTICAL_DRAGGING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
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
        this.f9546a = view;
        this.f9547b = bVar;
        this.f9548c = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        this.f9549d = g6.y.h(view.getContext(), 4.0f);
        view.setVisibility(0);
    }

    public final void a() {
        this.f9550e = State.IGNORED;
        this.f9551f = null;
        this.f9552g = false;
        this.f9562q = false;
    }

    public final void b(View view, MotionEvent motionEvent, float f10, float f11) {
        float f12 = f10 - this.f9554i;
        float f13 = f11 - this.f9555j;
        if (Math.abs(f12) >= Math.abs(f13)) {
            c(view, motionEvent, f10, f11);
            return;
        }
        if (Math.abs(f12) > this.f9548c || Math.abs(f13) > this.f9548c) {
            if (!this.f9552g || !this.f9547b.k(view)) {
                a();
                return;
            }
            if (f13 >= 0.0f ? this.f9547b.m() > 0.0f : this.f9547b.m() < 1.0f) {
                n(f11);
                d(f10, f11);
            } else {
                this.f9550e = State.VERTICAL_PENDING;
                this.f9558m = f10;
                this.f9559n = f11;
            }
        }
    }

    public final void c(View view, MotionEvent motionEvent, float f10, float f11) {
        float f12 = f10 - this.f9554i;
        float f13 = f11 - this.f9555j;
        if (this.f9550e != State.DETECTING || Math.abs(f12) > this.f9549d || Math.abs(f13) > this.f9549d) {
            int i10 = f12 > 0.0f ? 1 : 2;
            if ((this.f9553h & i10) != i10) {
                a();
                return;
            }
            if (!this.f9547b.d(view)) {
                this.f9550e = State.AWAITING_HORIZONTAL;
                this.f9556k = f10;
                this.f9557l = f11;
                this.f9566u = motionEvent.getEventTime();
                return;
            }
            float fMax = Math.max(1L, motionEvent.getEventTime() - this.f9566u);
            float f14 = (f10 - this.f9556k) / fMax;
            if (Math.abs(f14) <= Math.abs((f11 - this.f9557l) / fMax) || Math.abs(f14) <= 0.5f || Math.abs(f12) <= Math.abs(f13) + this.f9549d) {
                a();
            } else {
                m(view, i10, f12);
            }
        }
    }

    public final void d(float f10, float f11) {
        int iL = this.f9547b.l();
        float f12 = f11 - this.f9557l;
        if (iL > 0) {
            b bVar = this.f9547b;
            bVar.i(bVar.m() - (f12 / iL));
            if (f12 != 0.0f && (f12 >= 0.0f ? this.f9547b.m() <= 0.0f : this.f9547b.m() >= 1.0f)) {
                boolean z10 = this.f9547b.m() <= 0.0f;
                this.f9547b.e(z10);
                if (!z10 && !this.f9547b.g()) {
                    a();
                    return;
                } else {
                    this.f9550e = State.VERTICAL_PENDING;
                    this.f9558m = f10;
                    this.f9559n = f11;
                }
            }
        }
        this.f9557l = f11;
    }

    public final void e() {
        ObjectAnimator objectAnimatorOfFloat;
        float fAbs;
        int iAbs = Math.abs(this.f9564s);
        int i10 = this.f9563r;
        if (iAbs < i10) {
            fAbs = i10 == 0 ? 0.0f : Math.abs(this.f9564s) / this.f9563r;
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f9546a, (Property<View, Float>) View.TRANSLATION_X, this.f9564s + r5, this.f9565t);
        } else {
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f9546a, (Property<View, Float>) View.ALPHA, 1.0f, 0.0f);
            this.f9547b.h(this.f9564s <= 0 ? 2 : 1);
            fAbs = 1.0f;
        }
        this.f9567v = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration((long) (fAbs * 300.0f));
        objectAnimatorOfFloat.start();
    }

    public final void f(View view, MotionEvent motionEvent) {
        State state;
        if (this.f9551f != view || (state = this.f9550e) == State.IGNORED) {
            return;
        }
        if ((state == State.VERTICAL_PENDING || state == State.VERTICAL_DRAGGING) && !this.f9547b.k(view)) {
            i();
            return;
        }
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        int i10 = a.f9569a[this.f9550e.ordinal()];
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
        } else if (actionMasked == 3 || actionMasked == 5) {
            i();
        }
    }

    public final void h() {
        State state = this.f9550e;
        if (state == State.HORIZONTAL) {
            e();
        } else if (state == State.VERTICAL_DRAGGING) {
            float f10 = this.f9561p;
            this.f9547b.j(f10 >= 1.0f || (f10 > 0.0f && this.f9547b.m() < 0.5f));
        }
        a();
    }

    public void i() {
        if (this.f9562q) {
            this.f9547b.j(this.f9560o);
        }
        j();
        a();
    }

    public final void j() {
        ObjectAnimator objectAnimator = this.f9567v;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            this.f9567v = null;
        }
        this.f9564s = 0;
        this.f9546a.setAlpha(1.0f);
        this.f9546a.setTranslationX(0.0f);
    }

    public final boolean k(float f10, float f11) {
        float f12 = f10 - this.f9558m;
        float f13 = f11 - this.f9559n;
        if (this.f9547b.m() >= 1.0f) {
            if (f13 <= 0.0f) {
                return false;
            }
        } else if (f13 >= 0.0f) {
            return false;
        }
        return Math.abs(f13) > ((float) this.f9548c) && Math.abs(f13) > Math.abs(f12);
    }

    public final void l(View view, MotionEvent motionEvent) {
        j();
        this.f9551f = view;
        this.f9554i = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        this.f9555j = rawY;
        float f10 = this.f9554i;
        this.f9556k = f10;
        this.f9557l = rawY;
        this.f9558m = f10;
        this.f9559n = rawY;
        this.f9566u = motionEvent.getEventTime();
        this.f9553h = this.f9547b.f(view);
        boolean zK = this.f9547b.k(view);
        this.f9552g = zK;
        this.f9562q = false;
        this.f9550e = (this.f9553h != 0 || zK) ? State.DETECTING : State.IGNORED;
    }

    public final void m(View view, int i10, float f10) {
        int iMax = Math.max(this.f9546a.getWidth(), this.f9546a.getMeasuredWidth());
        if (iMax <= 0) {
            a();
            return;
        }
        this.f9550e = State.HORIZONTAL;
        this.f9563r = (iMax * 4) / 5;
        this.f9565t = f10 > 0.0f ? -10 : view.getWidth() + iMax + 10;
        this.f9564s = 0;
        this.f9547b.c(this.f9546a, i10);
        this.f9546a.setTranslationX(this.f9565t);
        o(this.f9554i + f10);
    }

    public final void n(float f10) {
        this.f9550e = State.VERTICAL_DRAGGING;
        if (!this.f9562q) {
            this.f9560o = this.f9547b.a();
            this.f9561p = this.f9547b.m();
            this.f9562q = true;
        }
        float f11 = this.f9559n;
        this.f9557l = f11 + Math.copySign(this.f9548c, f10 - f11);
        this.f9547b.b();
    }

    public final void o(float f10) {
        int i10 = (((int) (f10 - this.f9556k)) * 8) / 10;
        this.f9556k = f10;
        int i11 = this.f9564s;
        int i12 = i11 + i10;
        int i13 = this.f9563r;
        if (i12 > i13 && i10 > 0) {
            i10 = i13 - i11;
        } else if (i11 + i10 < (-i13) && i10 < 0) {
            i10 = (-i13) - i11;
        }
        if ((i11 > 0 && i11 + i10 <= 0) || (i11 < 0 && i11 + i10 >= 0)) {
            i10 = 0;
        }
        this.f9564s = i11 + i10;
        this.f9546a.setTranslationX(this.f9565t + r5);
    }

    public final void p(float f10, float f11) {
        if (this.f9547b.m() >= 1.0f) {
            if (f11 >= this.f9559n) {
                return;
            }
        } else if (f11 <= this.f9559n) {
            return;
        }
        this.f9558m = f10;
        this.f9559n = f11;
    }
}
