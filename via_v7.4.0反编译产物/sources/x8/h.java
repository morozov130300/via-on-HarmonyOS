package x8;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.animation.Interpolator;
import g6.y;
import x7.k;
import x7.m;
import x7.n;
import z8.l;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class h {
    public static int a(Context context) {
        return g6.e.a(context, k.f13656b);
    }

    public static Interpolator b() {
        return z.b.a(0.2f, 0.2f, 0.8f, 0.8f);
    }

    public static int c(Context context) {
        return l.d() ? g6.e.a(context, k.f13656b) : g6.e.a(context, k.f13657c);
    }

    public static Drawable d(Context context) {
        return g6.f.e(context, g6.e.b(context, k.f13658d));
    }

    public static int e(Context context) {
        return g6.f.d(context, n.f13697p);
    }

    public static Drawable f(Context context) throws Resources.NotFoundException {
        int iJ = j(context);
        float dimension = context.getResources().getDimension(n.f13697p);
        int iH = y.h(context, 1.0f);
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
        return context == null ? i11 : g6.e.a(context, i10);
    }

    public static int i(Context context, int i10, int i11) {
        return context == null ? i11 : g6.f.d(context, i10);
    }

    public static int j(Context context) {
        return g6.e.a(context, k.f13660f);
    }

    public static int k(Context context) {
        return g6.e.a(context, k.f13661g);
    }

    public static int l(Context context) {
        return h(context, k.f13662h, -12303292);
    }

    public static int m(Context context) {
        return g6.e.a(context, k.f13663i);
    }

    public static Drawable n(Context context) {
        int iB = g6.f.b(context, m.f13680j);
        int iJ = j(context);
        int iH = y.h(context, 5.0f);
        int iH2 = y.h(context, 2.0f);
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

    public static int o(Context context) {
        return h(context, k.f13664j, -7829368);
    }

    public static int p(Context context) {
        return h(context, k.f13665k, -16777216);
    }

    public static int q(Context context) {
        return h(context, k.f13666l, -12303292);
    }

    public static int r(Context context) {
        return i(context, n.f13693l, 32);
    }

    public static int s(Context context) {
        return i(context, n.f13691j, 48);
    }

    public static int t(Context context) {
        return i(context, n.f13692k, 64);
    }

    public static int u(Context context) {
        return i(context, n.f13694m, 24);
    }

    public static int v(Context context) {
        return i(context, n.f13695n, 16);
    }

    public static Drawable w(Context context) {
        return new g6.g().h(j(context)).c(y.h(context, 6.0f)).g(y.h(context, 12.0f), y.h(context, 12.0f)).a();
    }

    public static Drawable x(Context context) {
        int iH = y.h(context, 2.0f);
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
