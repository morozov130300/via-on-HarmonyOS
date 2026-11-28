package v8;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.animation.Interpolator;
import com.tuyafeng.support.utils.x;
import w7.k;
import w7.m;
import w7.n;
import x8.l;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class h {
    public static int a(Context context) {
        return com.tuyafeng.support.utils.e.a(context, k.f13723c);
    }

    public static Interpolator b() {
        return a0.b.a(0.2f, 0.2f, 0.8f, 0.8f);
    }

    public static int c(Context context) {
        return l.d() ? com.tuyafeng.support.utils.e.a(context, k.f13723c) : com.tuyafeng.support.utils.e.a(context, k.f13724d);
    }

    public static Drawable d(Context context) {
        return com.tuyafeng.support.utils.f.e(context, com.tuyafeng.support.utils.e.b(context, k.f13725e));
    }

    public static int e(Context context) {
        return com.tuyafeng.support.utils.f.d(context, n.f13763p);
    }

    public static Drawable f(Context context) {
        int iJ = j(context);
        float dimension = context.getResources().getDimension(n.f13763p);
        int iH = x.h(context, 1.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(dimension);
        gradientDrawable.setStroke(iH, 813727872);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        gradientDrawable2.setCornerRadius(dimension);
        gradientDrawable2.setStroke(iH, iJ);
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        gradientDrawable3.setShape(0);
        gradientDrawable3.setCornerRadius(dimension);
        gradientDrawable3.setColor(813727872);
        GradientDrawable gradientDrawable4 = new GradientDrawable();
        gradientDrawable4.setShape(0);
        gradientDrawable4.setCornerRadius(dimension);
        gradientDrawable4.setStroke(iH * 3, 1619034240);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{-16842919, -16842913, -16842912, -16842908}, gradientDrawable);
        stateListDrawable.addState(new int[]{-16842919, R.attr.state_checked, -16842908}, gradientDrawable2);
        stateListDrawable.addState(new int[]{-16842919, R.attr.state_selected, -16842908}, gradientDrawable2);
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, gradientDrawable3);
        stateListDrawable.addState(new int[]{R.attr.state_focused}, gradientDrawable4);
        return stateListDrawable;
    }

    public static ColorStateList g(Context context, int i10) {
        return new ColorStateList(new int[][]{new int[]{R.attr.state_enabled, R.attr.state_selected}, new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[0]}, new int[]{j(context), j(context), i10});
    }

    public static int h(Context context, int i10, int i11) {
        return context == null ? i11 : com.tuyafeng.support.utils.e.a(context, i10);
    }

    public static int i(Context context, int i10, int i11) {
        return context == null ? i11 : com.tuyafeng.support.utils.f.d(context, i10);
    }

    public static int j(Context context) {
        return com.tuyafeng.support.utils.e.a(context, k.f13727g);
    }

    public static int k(Context context) {
        return com.tuyafeng.support.utils.e.a(context, k.f13728h);
    }

    public static int l(Context context) {
        return h(context, k.f13729i, -12303292);
    }

    public static Drawable m(Context context) {
        int iB = com.tuyafeng.support.utils.f.b(context, m.f13746j);
        int iJ = j(context);
        int iH = x.h(context, 5.0f);
        int iH2 = x.h(context, 2.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        float f10 = iH;
        gradientDrawable.setCornerRadius(f10);
        gradientDrawable.setColor(iB);
        gradientDrawable.setSize(0, iH2);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setCornerRadius(f10);
        gradientDrawable2.setColor(iJ);
        gradientDrawable2.setSize(0, iH2);
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{gradientDrawable, new ClipDrawable(gradientDrawable2, 3, 1)});
        layerDrawable.setId(0, R.id.background);
        layerDrawable.setId(1, R.id.progress);
        return layerDrawable;
    }

    public static int n(Context context) {
        return h(context, k.f13731k, -7829368);
    }

    public static int o(Context context) {
        return h(context, k.f13732l, -16777216);
    }

    public static int p(Context context) {
        return h(context, k.f13733m, -12303292);
    }

    public static int q(Context context) {
        return i(context, n.f13759l, 32);
    }

    public static int r(Context context) {
        return i(context, n.f13757j, 48);
    }

    public static int s(Context context) {
        return i(context, n.f13758k, 64);
    }

    public static int t(Context context) {
        return i(context, n.f13760m, 24);
    }

    public static int u(Context context) {
        return i(context, n.f13761n, 16);
    }

    public static Drawable v(Context context) {
        return new com.tuyafeng.support.utils.g().h(j(context)).c(x.h(context, 6.0f)).g(x.h(context, 12.0f), x.h(context, 12.0f)).a();
    }

    public static Drawable w(Context context) {
        int iH = x.h(context, 2.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(0);
        GradientDrawable gradientDrawable2 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{-10894619, -5863456});
        gradientDrawable2.setCornerRadius(iH);
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{gradientDrawable, new ClipDrawable(gradientDrawable2, 3, 1)});
        layerDrawable.setId(0, R.id.background);
        layerDrawable.setId(1, R.id.progress);
        return layerDrawable;
    }
}
