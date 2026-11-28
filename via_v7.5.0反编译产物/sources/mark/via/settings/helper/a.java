package mark.via.settings.helper;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.ImageView;
import com.tuyafeng.support.utils.n;
import com.tuyafeng.support.utils.x;
import com.tuyafeng.support.widget.d0;
import hb.w4;
import la.s;
import mark.via.common.widget.u0;
import u9.l;
import w7.o;
import w7.u;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class a extends ImageView {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FabPreferenceViewDelegate.a f10345c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f10346e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final float f10347m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f10348n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f10349o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f10350p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f10351q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f10352r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f10353s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public d0 f10354t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f10355u;

    public a(final Context context, FabPreferenceViewDelegate.a aVar) {
        super(context);
        this.f10352r = -1;
        this.f10345c = aVar;
        this.f10346e = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f10347m = x.h(context, 30.0f);
        this.f10348n = x.h(context, 12.0f);
        int iH = x.h(context, 8.0f);
        setPadding(iH, iH, iH, iH);
        setColorFilter(-1);
        setBackgroundResource(o.f13780c);
        setContentDescription(context.getString(u.f14224s5));
        setFocusable(true);
        setOnClickListener(new View.OnClickListener() { // from class: ib.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                mark.via.settings.helper.a.b(context, view);
            }
        });
        e(0);
    }

    public static /* synthetic */ void a(a aVar, int i10) {
        aVar.c();
        if (aVar.isAttachedToWindow() && aVar.getVisibility() == 0) {
            aVar.f10345c.a(i10);
        }
    }

    public static /* synthetic */ void b(Context context, View view) {
        l lVarJ = s.j();
        n.s(context, context.getString(u.f14210r5, w4.b(context, lVarJ.j2()), w4.b(context, lVarJ.A2()), w4.b(context, lVarJ.x0()), w4.b(context, lVarJ.e1())));
    }

    public void c() {
        animate().withEndAction(null);
        animate().cancel();
        this.f10353s = false;
        this.f10351q = 0;
        setTranslationX(0.0f);
        setTranslationY(0.0f);
        e(0);
        d();
    }

    public final void d() {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(false);
        }
        d0 d0Var = this.f10354t;
        if (d0Var != null) {
            d0Var.setGestureEnabled(this.f10355u);
            this.f10354t = null;
        }
    }

    public final void e(int i10) {
        if (this.f10352r != i10) {
            this.f10352r = i10;
            u0.a(this, i10, s.j());
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
        int i10 = 0;
        if (actionMasked == 0) {
            c();
            this.f10349o = motionEvent.getRawX();
            this.f10350p = motionEvent.getRawY();
            this.f10353s = true;
            getParent().requestDisallowInterceptTouchEvent(true);
            for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
                if (parent instanceof d0) {
                    d0 d0Var = (d0) parent;
                    this.f10354t = d0Var;
                    this.f10355u = d0Var.u();
                    this.f10354t.setGestureEnabled(false);
                    break;
                }
            }
            return true;
        }
        if (actionMasked == 1) {
            if (!this.f10353s) {
                return true;
            }
            final int i11 = this.f10352r;
            boolean z10 = this.f10351q == 0;
            this.f10353s = false;
            if (i11 == 0) {
                c();
                if (z10) {
                    performClick();
                }
            } else {
                d();
                animate().translationX(0.0f).translationY(0.0f).setDuration(180L).withEndAction(new Runnable() { // from class: ib.p
                    @Override // java.lang.Runnable
                    public final void run() {
                        mark.via.settings.helper.a.a(this.f6387c, i11);
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
        if (!this.f10353s) {
            return true;
        }
        float rawX = motionEvent.getRawX() - this.f10349o;
        float rawY = motionEvent.getRawY() - this.f10350p;
        if (this.f10351q == 0 && Math.max(Math.abs(rawX), Math.abs(rawY)) > this.f10346e) {
            this.f10351q = Math.abs(rawX) > Math.abs(rawY) ? 1 : 2;
        }
        int i12 = this.f10351q;
        if (i12 != 1) {
            rawX = i12 == 2 ? rawY : 0.0f;
        }
        float f10 = rawX * 0.75f;
        if (Math.abs(f10) >= this.f10347m) {
            i10 = this.f10351q == 1 ? f10 > 0.0f ? 2 : 1 : f10 > 0.0f ? 8 : 4;
        }
        e(i10);
        View view = (View) getParent();
        setTranslationX(this.f10351q == 1 ? Math.max(this.f10348n - getLeft(), Math.min((view.getWidth() - this.f10348n) - getRight(), f10)) : 0.0f);
        setTranslationY(this.f10351q == 2 ? Math.max(this.f10348n - getTop(), Math.min((view.getHeight() - this.f10348n) - getBottom(), f10)) : 0.0f);
        return true;
    }
}
