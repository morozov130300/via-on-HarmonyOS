package ib;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class f extends t5.d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f6357c = com.tuyafeng.support.utils.x.l();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f6358d = com.tuyafeng.support.utils.x.l();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f6359e = com.tuyafeng.support.utils.x.l();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f6360a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d f6361b;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends p5.c {
        public a() {
        }

        @Override // p5.c
        public void a(View view) {
            if (f.this.f6360a != null) {
                f.this.f6360a.a(view);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b implements View.OnLongClickListener {
        public b() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            return f.this.f6361b != null && f.this.f6361b.a(view);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface c {
        void a(View view);
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface d {
        boolean a(View view);
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class e extends TextView {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ValueAnimator f6364c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Matrix f6365e;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public LinearGradient f6366m;

        public e(Context context) {
            super(context);
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.f6364c = valueAnimatorOfFloat;
            this.f6365e = new Matrix();
            valueAnimatorOfFloat.setDuration(850L);
            valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ib.g
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.f6367a.invalidate();
                }
            });
        }

        public void c() {
            int currentTextColor = getCurrentTextColor();
            this.f6366m = new LinearGradient(0.0f, 0.0f, getTextSize() * 3.0f, 0.0f, currentTextColor | (-16777216), currentTextColor & 16777215, Shader.TileMode.CLAMP);
            this.f6364c.start();
        }

        @Override // android.view.View
        public void onDetachedFromWindow() {
            this.f6364c.cancel();
            super.onDetachedFromWindow();
        }

        @Override // android.widget.TextView, android.view.View
        public void onDraw(Canvas canvas) {
            if (!this.f6364c.isRunning()) {
                super.onDraw(canvas);
                return;
            }
            float textSize = getTextSize() * 3.0f;
            float lineLeft = getLayout().getLineCount() == 1 ? getLayout().getLineLeft(0) : 0.0f;
            this.f6365e.setTranslate((lineLeft - textSize) + ((((getLayout().getLineCount() == 1 ? getLayout().getLineRight(0) : getWidth()) - lineLeft) + textSize) * this.f6364c.getAnimatedFraction()), 0.0f);
            this.f6366m.setLocalMatrix(this.f6365e);
            getPaint().setShader(this.f6366m);
            super.onDraw(canvas);
            getPaint().setShader(null);
        }
    }

    public static /* synthetic */ void i(e eVar, ib.a aVar, View view) {
        eVar.f6364c.cancel();
        boolean zE = aVar.e();
        eVar.setText(aVar.d());
        if (zE) {
            eVar.c();
        }
    }

    public static /* synthetic */ void j(Context context, e eVar) {
        eVar.setGravity(17);
        v8.g.m(eVar, v8.h.q(context));
        eVar.setTextColor(v8.h.o(context));
        eVar.setTypeface(Typeface.create("sans-serif-condensed", 0));
    }

    public static /* synthetic */ void k(LinearLayout linearLayout) {
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
    }

    public static /* synthetic */ void l(Context context, TextView textView) {
        textView.setGravity(17);
        v8.g.l(textView);
        v8.g.m(textView, v8.h.r(context));
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        v8.g.d(textView);
    }

    @Override // t5.d
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public void b(w5.g gVar, final ib.a aVar) {
        int i10 = f6357c;
        gVar.X(i10, aVar.c());
        final e eVar = (e) gVar.P(f6358d);
        eVar.f6364c.cancel();
        eVar.setText(aVar.d());
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: ib.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.i(eVar, aVar, view);
            }
        };
        gVar.P(i10).setOnClickListener(onClickListener);
        eVar.setOnClickListener(onClickListener);
        int i11 = f6359e;
        gVar.W(i11, aVar.b());
        gVar.U(i11, aVar.a());
        gVar.P(i11).setOnClickListener(new a());
        gVar.P(i11).setOnLongClickListener(new b());
    }

    @Override // t5.d
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public w5.g d(final Context context, ViewGroup viewGroup) {
        LinearLayout linearLayout = (LinearLayout) new b6.a(new LinearLayout(context), new LinearLayout.LayoutParams(-1, -2)).S(com.tuyafeng.support.utils.x.h(context, 24.0f)).V(new b6.a.InterfaceC0033a() { // from class: ib.c
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                f.k((LinearLayout) obj);
            }
        }).l();
        ImageView imageView = (ImageView) new b6.a(new ImageView(context), new LinearLayout.LayoutParams(com.tuyafeng.support.utils.x.h(context, 60.0f), com.tuyafeng.support.utils.x.h(context, 60.0f))).o(f6359e).l();
        TextView textView = (TextView) new b6.a(new TextView(context), new LinearLayout.LayoutParams(-1, -2)).o(f6357c).A(com.tuyafeng.support.utils.x.h(context, 12.0f)).V(new b6.a.InterfaceC0033a() { // from class: ib.d
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                f.l(context, (TextView) obj);
            }
        }).l();
        e eVar = (e) new b6.a(new e(context), new LinearLayout.LayoutParams(-1, -2)).o(f6358d).A(com.tuyafeng.support.utils.x.h(context, 2.0f)).V(new b6.a.InterfaceC0033a() { // from class: ib.e
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                f.j(context, (f.e) obj);
            }
        }).l();
        linearLayout.addView(imageView);
        linearLayout.addView(textView);
        linearLayout.addView(eVar);
        return new w5.g(linearLayout);
    }

    public void q(c cVar) {
        this.f6360a = cVar;
    }

    public void r(d dVar) {
        this.f6361b = dVar;
    }
}
