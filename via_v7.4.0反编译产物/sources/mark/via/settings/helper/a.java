package mark.via.settings.helper;

import android.content.Context;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.ImageView;
import com.tuyafeng.support.widget.y;
import mark.via.common.widget.u0;
import mark.via.settings.helper.ToolbarsViewDelegate;
import pa.r;
import x7.o;
import x7.u;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class a extends ImageView {

    /* renamed from: e, reason: collision with root package name */
    public final ToolbarsViewDelegate.b f10018e;

    /* renamed from: j, reason: collision with root package name */
    public final int f10019j;

    /* renamed from: k, reason: collision with root package name */
    public final float f10020k;

    /* renamed from: l, reason: collision with root package name */
    public final int f10021l;

    /* renamed from: m, reason: collision with root package name */
    public float f10022m;

    /* renamed from: n, reason: collision with root package name */
    public float f10023n;

    /* renamed from: o, reason: collision with root package name */
    public int f10024o;

    /* renamed from: p, reason: collision with root package name */
    public int f10025p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f10026q;

    /* renamed from: r, reason: collision with root package name */
    public y f10027r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f10028s;

    public a(Context context, final ToolbarsViewDelegate.b bVar) {
        super(context);
        this.f10025p = -1;
        this.f10018e = bVar;
        this.f10019j = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f10020k = g6.y.h(context, 30.0f);
        this.f10021l = g6.y.h(context, 12.0f);
        int iH = g6.y.h(context, 10.0f);
        setPadding(iH, iH, iH, iH);
        setColorFilter(-1);
        setBackgroundResource(o.f13717d);
        setContentDescription(context.getString(u.f14018i5));
        setClickable(true);
        setFocusable(true);
        setOnClickListener(new View.OnClickListener() { // from class: ib.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                bVar.K(ToolbarsViewDelegate.GestureTarget.FAB);
            }
        });
        if (Build.VERSION.SDK_INT >= 21) {
            setElevation(g6.y.h(context, 12.0f));
        }
        e(0);
    }

    public static /* synthetic */ void b(a aVar, int i10) {
        aVar.c();
        if (aVar.isAttachedToWindow() && aVar.getVisibility() == 0) {
            aVar.f10018e.K(f(i10));
        }
    }

    public static ToolbarsViewDelegate.GestureTarget f(int i10) {
        if (i10 == 1) {
            return ToolbarsViewDelegate.GestureTarget.FAB_LEFT;
        }
        if (i10 == 2) {
            return ToolbarsViewDelegate.GestureTarget.FAB_RIGHT;
        }
        if (i10 == 4) {
            return ToolbarsViewDelegate.GestureTarget.FAB_UP;
        }
        if (i10 == 8) {
            return ToolbarsViewDelegate.GestureTarget.FAB_DOWN;
        }
        throw new IllegalArgumentException("Unknown FAB direction: " + i10);
    }

    public void c() {
        animate().withEndAction(null);
        animate().cancel();
        this.f10026q = false;
        this.f10024o = 0;
        setTranslationX(0.0f);
        setTranslationY(0.0f);
        e(0);
        d();
    }

    public final void d() {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(false);
        }
        y yVar = this.f10027r;
        if (yVar != null) {
            yVar.setGestureEnabled(this.f10028s);
            this.f10027r = null;
        }
    }

    public final void e(int i10) {
        if (this.f10025p != i10) {
            this.f10025p = i10;
            u0.a(this, i10, r.j());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        c();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            c();
            this.f10022m = motionEvent.getRawX();
            this.f10023n = motionEvent.getRawY();
            this.f10026q = true;
            getParent().requestDisallowInterceptTouchEvent(true);
            ViewParent parent = getParent();
            while (true) {
                if (parent == null) {
                    break;
                }
                if (parent instanceof y) {
                    y yVar = (y) parent;
                    this.f10027r = yVar;
                    this.f10028s = yVar.u();
                    this.f10027r.setGestureEnabled(false);
                    break;
                }
                parent = parent.getParent();
            }
            return true;
        }
        if (actionMasked == 1) {
            if (!this.f10026q) {
                return true;
            }
            final int i10 = this.f10025p;
            boolean z10 = this.f10024o == 0;
            this.f10026q = false;
            if (i10 == 0) {
                c();
                if (z10) {
                    performClick();
                }
            } else {
                d();
                animate().translationX(0.0f).translationY(0.0f).setDuration(180L).withEndAction(new Runnable() { // from class: ib.p
                    @Override // java.lang.Runnable
                    public final void run() {
                        mark.via.settings.helper.a.b(this.f7155e, i10);
                    }
                }).start();
            }
            return true;
        }
        if (actionMasked != 2) {
            if (actionMasked != 3 && actionMasked != 5) {
                return true;
            }
            c();
            return true;
        }
        if (!this.f10026q) {
            return true;
        }
        float rawX = motionEvent.getRawX() - this.f10022m;
        float rawY = motionEvent.getRawY() - this.f10023n;
        if (this.f10024o == 0 && Math.max(Math.abs(rawX), Math.abs(rawY)) > this.f10019j) {
            this.f10024o = Math.abs(rawX) > Math.abs(rawY) ? 1 : 2;
        }
        int i11 = this.f10024o;
        if (i11 != 1) {
            rawX = i11 == 2 ? rawY : 0.0f;
        }
        float f10 = rawX * 0.75f;
        e(Math.abs(f10) >= this.f10020k ? this.f10024o == 1 ? f10 > 0.0f ? 2 : 1 : f10 > 0.0f ? 8 : 4 : 0);
        float f11 = f10 / 0.8f;
        View view = (View) getParent();
        setTranslationX(this.f10024o == 1 ? Math.max(this.f10021l - getLeft(), Math.min((view.getWidth() - this.f10021l) - getRight(), f11)) : 0.0f);
        setTranslationY(this.f10024o == 2 ? Math.max(this.f10021l - getTop(), Math.min((view.getHeight() - this.f10021l) - getBottom(), f11)) : 0.0f);
        return true;
    }
}
