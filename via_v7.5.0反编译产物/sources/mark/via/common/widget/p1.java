package mark.via.common.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class p1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PopupWindow f10021a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayout f10022b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f10023c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FrameLayout f10024d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Runnable f10025e = new Runnable() { // from class: mark.via.common.widget.n1
        @Override // java.lang.Runnable
        public final void run() {
            this.f10012c.i();
        }
    };

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public AnimatorSet f10026f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public AnimatorSet f10027g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public AnimatorSet f10028h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public AnimatorSet f10029i;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f10030a;

        public a(View view) {
            this.f10030a = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            p1.this.f10024d.getChildAt(1).setVisibility(4);
            this.f10030a.performHapticFeedback(3);
        }
    }

    public p1(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        this.f10022b = linearLayout;
        linearLayout.setGravity(16);
        linearLayout.setLayoutDirection(0);
        linearLayout.setPadding(g(20), g(14), g(20), g(14));
        linearLayout.setImportantForAccessibility(4);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(o.a.c(context, w7.m.f13745i));
        gradientDrawable.setCornerRadius(g(30));
        linearLayout.setBackground(gradientDrawable);
        TextView textViewK = k(context);
        this.f10023c = textViewK;
        textViewK.setTextDirection(3);
        FrameLayout frameLayout = new FrameLayout(context);
        this.f10024d = frameLayout;
        frameLayout.setLayoutDirection(com.tuyafeng.support.utils.l.d(context) ? 1 : 0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams.rightMargin = g(12);
        linearLayout.addView(frameLayout, layoutParams);
        linearLayout.addView(textViewK, new LinearLayout.LayoutParams(-2, -2));
        FrameLayout frameLayout2 = new FrameLayout(context);
        frameLayout2.setPadding(0, 0, 0, 20);
        frameLayout2.setClipToPadding(false);
        frameLayout2.addView(linearLayout, new FrameLayout.LayoutParams(-1, -2));
        PopupWindow popupWindow = new PopupWindow((View) frameLayout2, 0, 0, false);
        this.f10021a = popupWindow;
        popupWindow.setTouchable(false);
        popupWindow.setInputMethodMode(2);
        popupWindow.setBackgroundDrawable(null);
        popupWindow.setAnimationStyle(0);
    }

    public final void c(int i10, r4.a aVar) {
        LinearLayout linearLayout;
        Context context = this.f10022b.getContext();
        if (i10 < this.f10024d.getChildCount()) {
            linearLayout = (LinearLayout) this.f10024d.getChildAt(i10);
        } else {
            linearLayout = new LinearLayout(context);
            linearLayout.setBaselineAligned(false);
            linearLayout.setGravity(16);
            linearLayout.addView(new ImageView(context), new LinearLayout.LayoutParams(g(20), g(20)));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
            layoutParams.setMarginStart(g(8));
            linearLayout.addView(k(context), layoutParams);
            this.f10024d.addView(linearLayout, new FrameLayout.LayoutParams(-1, -2, 16));
        }
        if (Integer.valueOf(aVar.getId()).equals(linearLayout.getTag())) {
            return;
        }
        linearLayout.setTag(Integer.valueOf(aVar.getId()));
        x8.y0.i((ImageView) linearLayout.getChildAt(0), aVar.t() != null ? aVar.t() : x8.x0.c().d(context, aVar.getUrl()), com.tuyafeng.support.utils.e.f(lb.g.c(context, w7.o.I1, w7.u.Rf), com.tuyafeng.support.utils.e.a(context, w7.k.f13734n)));
        String strF = x8.z.F(aVar.getTitle(), aVar.getUrl());
        if (TextUtils.isEmpty(strF)) {
            strF = aVar.getUrl();
        }
        TextView textView = (TextView) linearLayout.getChildAt(1);
        if (TextUtils.isEmpty(strF)) {
            strF = context.getString(w7.u.Ah);
        }
        textView.setText(strF);
    }

    public final void d() {
        AnimatorSet animatorSet = this.f10028h;
        if (animatorSet != null) {
            animatorSet.removeAllListeners();
            this.f10028h.cancel();
            this.f10028h = null;
        }
        AnimatorSet animatorSet2 = this.f10026f;
        if (animatorSet2 != null) {
            animatorSet2.removeAllListeners();
            this.f10026f.cancel();
            this.f10026f = null;
        }
    }

    public final void e() {
        AnimatorSet animatorSet = this.f10029i;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.f10029i = null;
            this.f10024d.getChildAt(0).setAlpha(1.0f);
            this.f10024d.getChildAt(1).setAlpha(1.0f);
            this.f10024d.getChildAt(1).setVisibility(4);
        }
    }

    public void f() {
        this.f10022b.removeCallbacks(this.f10025e);
        d();
        AnimatorSet animatorSet = this.f10027g;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.f10027g = null;
        }
        e();
        this.f10021a.dismiss();
        for (int i10 = 0; i10 < this.f10024d.getChildCount(); i10++) {
            this.f10024d.getChildAt(i10).setTag(null);
        }
    }

    public final int g(int i10) {
        return com.tuyafeng.support.utils.x.h(this.f10022b.getContext(), i10);
    }

    public void h(View view, List list, int i10) {
        p1 p1Var;
        if (this.f10021a.isShowing()) {
            if (list.size() < 2 || i10 < 0 || i10 >= list.size()) {
                f();
                return;
            }
            if (this.f10029i != null && Integer.valueOf(((r4.a) list.get(i10)).getId()).equals(this.f10024d.getChildAt(1).getTag())) {
                this.f10022b.removeCallbacks(this.f10025e);
                this.f10022b.postDelayed(this.f10025e, 500L);
                return;
            }
            e();
            View childAt = this.f10024d.getChildAt(0);
            if (!Integer.valueOf(((r4.a) list.get(i10)).getId()).equals(childAt.getTag()) || childAt.getTranslationX() == 0.0f) {
                p1Var = this;
                p1Var.l(view, list, i10, 0, 0.0f);
            } else {
                d();
                this.f10023c.setText((i10 + 1) + "/" + list.size());
                float width = (-Math.signum(childAt.getTranslationX())) * ((float) (this.f10024d.getWidth() + g(24)));
                AnimatorSet animatorSet = new AnimatorSet();
                this.f10026f = animatorSet;
                animatorSet.playTogether(ObjectAnimator.ofFloat(childAt, "translationX", 0.0f), ObjectAnimator.ofFloat(childAt, "alpha", 1.0f), ObjectAnimator.ofFloat(this.f10024d.getChildAt(1), "translationX", width), ObjectAnimator.ofFloat(this.f10024d.getChildAt(1), "alpha", 0.0f));
                this.f10026f.setDuration(120L);
                this.f10026f.setInterpolator(new DecelerateInterpolator());
                this.f10026f.addListener(new a(view));
                this.f10026f.start();
                p1Var = this;
            }
            p1Var.f10022b.removeCallbacks(p1Var.f10025e);
            p1Var.f10022b.postDelayed(p1Var.f10025e, 500L);
        }
    }

    public final void i() {
        AnimatorSet animatorSet = this.f10027g;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        this.f10028h = a6.i.d(this.f10022b, new Runnable() { // from class: mark.via.common.widget.o1
            @Override // java.lang.Runnable
            public final void run() {
                this.f10019c.f();
            }
        });
    }

    public boolean j() {
        return this.f10021a.isShowing();
    }

    public final TextView k(Context context) {
        TextView textView = new TextView(context);
        textView.setSingleLine(true);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        v8.g.m(textView, v8.h.q(context));
        textView.setTypeface(v8.g.i());
        textView.setTextColor(com.tuyafeng.support.utils.e.a(context, w7.k.f13734n));
        return textView;
    }

    /* JADX WARN: Code duplicated, block: B:115:0x02c7  */
    /* JADX WARN: Code duplicated, block: B:116:0x02c9  */
    /* JADX WARN: Code duplicated, block: B:118:0x02d5  */
    /* JADX WARN: Code duplicated, block: B:119:0x02dd  */
    /* JADX WARN: Code duplicated, block: B:122:0x0304  */
    /* JADX WARN: Code duplicated, block: B:124:0x030c  */
    public boolean l(View view, List list, int i10, int i11, float f10) {
        int i12;
        y.k0 k0VarY;
        int i13;
        int iG;
        int width;
        int iMax;
        this.f10022b.removeCallbacks(this.f10025e);
        if (this.f10026f != null || this.f10028h != null) {
            d();
            AnimatorSet animatorSet = this.f10027g;
            if (animatorSet == null || !animatorSet.isRunning()) {
                this.f10022b.setAlpha(1.0f);
                this.f10022b.setTranslationY(0.0f);
            }
        }
        if (list.size() < 2 || i10 < 0 || i10 >= list.size()) {
            f();
            return false;
        }
        int i14 = i10 + i11;
        int size = (list.size() + i14) % list.size();
        boolean z10 = i11 != 0 && Math.abs(f10) > 1.0f;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(z10 ? size + 1 : i10 + 1);
        sb2.append("/");
        sb2.append(list.size());
        String string = sb2.toString();
        boolean z11 = z10 && !(this.f10021a.isShowing() && string.contentEquals(this.f10023c.getText()));
        if (!string.contentEquals(this.f10023c.getText())) {
            this.f10023c.setText(string);
        }
        boolean z12 = this.f10021a.isShowing() && Integer.valueOf(((r4.a) list.get(i10)).getId()).equals(this.f10024d.getChildAt(0).getTag());
        float translationX = z12 ? this.f10024d.getChildAt(0).getTranslationX() : 0.0f;
        if (!z12 && this.f10029i != null) {
            e();
            this.f10024d.getChildAt(0).setTranslationX(0.0f);
        }
        c(0, (r4.a) list.get(i10));
        c(1, (r4.a) list.get(size));
        View viewFindViewById = view.getRootView().findViewById(R.id.content);
        if (viewFindViewById == null) {
            viewFindViewById = view.getRootView();
        }
        Rect rect = new Rect();
        viewFindViewById.getWindowVisibleDisplayFrame(rect);
        int iMin = Math.min(g(300), Math.min(viewFindViewById.getWidth(), rect.width()) - g(96));
        if (this.f10022b.isLayoutRequested() || this.f10022b.getWidth() != iMin) {
            this.f10022b.measure(View.MeasureSpec.makeMeasureSpec(iMin, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
            LinearLayout linearLayout = this.f10022b;
            linearLayout.layout(0, 0, iMin, linearLayout.getMeasuredHeight());
        }
        int measuredHeight = this.f10022b.getMeasuredHeight();
        float fSignum = Math.signum(f10) * (com.tuyafeng.support.utils.l.d(view.getContext()) ? -1 : 1);
        float fMin = (i11 == 0 || (!z10 && translationX * fSignum < 0.0f)) ? 0.0f : Math.min(1.0f, Math.max(0.0f, (Math.abs(f10) - 0.15f) / 0.85f));
        boolean z13 = z11 | (translationX != 0.0f && fMin == 0.0f);
        View childAt = this.f10024d.getChildAt(0);
        View childAt2 = this.f10024d.getChildAt(1);
        boolean z14 = i14 < 0 || i14 >= list.size();
        if (z14 && z10) {
            if (z13 || this.f10029i == null) {
                e();
                if (!this.f10021a.isShowing()) {
                    childAt.setTranslationX(g(24) * fSignum);
                    childAt.setAlpha(1.0f);
                }
                childAt2.setVisibility(0);
                childAt2.setAlpha(0.0f);
                childAt2.setTranslationX((-fSignum) * g(24));
                AnimatorSet animatorSet2 = new AnimatorSet();
                animatorSet2.playTogether(ObjectAnimator.ofFloat(childAt, "translationX", fSignum * g(40)), ObjectAnimator.ofFloat(childAt, "alpha", 0.0f));
                animatorSet2.setDuration(90L);
                AnimatorSet animatorSet3 = new AnimatorSet();
                animatorSet3.playTogether(ObjectAnimator.ofFloat(childAt2, "translationX", 0.0f), ObjectAnimator.ofFloat(childAt2, "alpha", 1.0f));
                animatorSet3.setDuration(150L);
                AnimatorSet animatorSet4 = new AnimatorSet();
                this.f10029i = animatorSet4;
                animatorSet4.playSequentially(animatorSet2, animatorSet3);
                this.f10029i.setInterpolator(new DecelerateInterpolator());
                this.f10029i.start();
            } else {
                i12 = 2;
            }
            int[] iArr = new int[i12];
            viewFindViewById.getLocationInWindow(iArr);
            k0VarY = y.r.y(viewFindViewById);
            if (k0VarY == null) {
                i13 = 0;
            } else {
                i13 = k0VarY.f(y.k0.m.c()).f11878d;
            }
            if (i13 > 0) {
                iG = i13 + g(32);
            } else {
                iG = g(120);
            }
            width = iArr[0] + ((viewFindViewById.getWidth() - iMin) / 2);
            iMax = iArr[1] + Math.max(0, (viewFindViewById.getHeight() - iG) - measuredHeight);
            if (this.f10021a.isShowing()) {
                this.f10021a.update(width, iMax, iMin, measuredHeight + 20);
                return z13;
            }
            this.f10022b.setAlpha(1.0f);
            this.f10022b.setTranslationY(0.0f);
            this.f10021a.setWidth(iMin);
            this.f10021a.setHeight(measuredHeight + 20);
            this.f10021a.showAtLocation(view, 51, width, iMax);
            this.f10027g = a6.i.c(this.f10022b);
            return z13;
        }
        e();
        int width2 = this.f10024d.getWidth() + g(24);
        childAt.setTranslationX(fSignum * fMin * (z14 ? g(24) : width2));
        childAt.setAlpha(z14 ? 1.0f : 1.0f - fMin);
        childAt2.setAlpha(fMin);
        childAt2.setTranslationX(fSignum * (fMin - 1.0f) * width2);
        childAt2.setVisibility((z14 || fMin == 0.0f) ? 4 : 0);
        i12 = 2;
        int[] iArr2 = new int[i12];
        viewFindViewById.getLocationInWindow(iArr2);
        k0VarY = y.r.y(viewFindViewById);
        if (k0VarY == null) {
            i13 = 0;
        } else {
            i13 = k0VarY.f(y.k0.m.c()).f11878d;
        }
        if (i13 > 0) {
            iG = i13 + g(32);
        } else {
            iG = g(120);
        }
        width = iArr2[0] + ((viewFindViewById.getWidth() - iMin) / 2);
        iMax = iArr2[1] + Math.max(0, (viewFindViewById.getHeight() - iG) - measuredHeight);
        if (this.f10021a.isShowing()) {
            this.f10021a.update(width, iMax, iMin, measuredHeight + 20);
            return z13;
        }
        this.f10022b.setAlpha(1.0f);
        this.f10022b.setTranslationY(0.0f);
        this.f10021a.setWidth(iMin);
        this.f10021a.setHeight(measuredHeight + 20);
        this.f10021a.showAtLocation(view, 51, width, iMax);
        this.f10027g = a6.i.c(this.f10022b);
        return z13;
    }
}
