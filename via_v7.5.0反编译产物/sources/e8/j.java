package e8;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tuyafeng.support.utils.x;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class j extends t5.d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f4298d = {0, -462365, -4133433, -11908531, -15592942};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f4299a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f4300b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f4301c;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface a {
        void a(int i10);
    }

    public static /* synthetic */ void i(j jVar, View view) {
        jVar.getClass();
        Object tag = view.getTag();
        if (tag instanceof Integer) {
            int iIntValue = ((Integer) tag).intValue();
            a aVar = jVar.f4299a;
            if (aVar != null) {
                aVar.a(iIntValue);
            }
            jVar.q((LinearLayout) view.getParent(), com.tuyafeng.support.utils.a.c(f4298d, iIntValue));
        }
    }

    public static /* synthetic */ void j(j jVar, int i10, Context context, View view) {
        jVar.getClass();
        view.setTag(Integer.valueOf(i10));
        x.P(view, jVar.k(context, i10, false));
    }

    public final Drawable k(Context context, int i10, boolean z10) {
        if (i10 != 0 && this.f4301c) {
            i10 = x.G(i10, -16777216, 0.3f);
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        float fE = v8.h.e(context);
        gradientDrawable.setCornerRadii(new float[]{fE, fE, fE, fE, fE, fE, fE, fE});
        gradientDrawable.setColor(i10);
        gradientDrawable.setStroke(x.h(context, 2.0f), z10 ? v8.h.j(context) : com.tuyafeng.support.utils.f.b(context, w7.m.f13739c));
        return gradientDrawable;
    }

    public final View l(final Context context, final int i10) {
        return new b6.a(new View(context), new LinearLayout.LayoutParams(0, x.h(context, 42.0f))).W(1.0f).x(1, 8).V(new b6.a.InterfaceC0033a() { // from class: e8.h
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                j.j(this.f4294a, i10, context, (View) obj);
            }
        }).l();
    }

    @Override // t5.d
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public void b(w5.g gVar, g gVar2) {
        LinearLayout linearLayout = (LinearLayout) gVar.f1138a;
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: e8.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                j.i(this.f4297a, view);
            }
        };
        int childCount = linearLayout.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            linearLayout.getChildAt(i10).setOnClickListener(onClickListener);
        }
        q(linearLayout, com.tuyafeng.support.utils.a.c(f4298d, gVar2.a()));
    }

    @Override // t5.d
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public w5.g d(Context context, ViewGroup viewGroup) {
        LinearLayout linearLayout = (LinearLayout) new b6.a(new LinearLayout(context), new FrameLayout.LayoutParams(-1, -2)).p(16).N(1, 8).T(1, 12).l();
        for (int i10 : f4298d) {
            linearLayout.addView(l(context, i10));
        }
        return new w5.g(linearLayout);
    }

    public void o(boolean z10) {
        this.f4301c = z10;
    }

    public void p(a aVar) {
        this.f4299a = aVar;
    }

    public final void q(LinearLayout linearLayout, int i10) {
        View childAt;
        View childAt2;
        if (this.f4300b == i10) {
            return;
        }
        Context context = linearLayout.getContext();
        int i11 = this.f4300b;
        this.f4300b = i10;
        if (i11 >= 0 && i11 < f4298d.length && (childAt2 = linearLayout.getChildAt(i11)) != null) {
            x.P(childAt2, k(context, ((Integer) childAt2.getTag()).intValue(), false));
        }
        int i12 = this.f4300b;
        if (i12 < 0 || i12 >= f4298d.length || (childAt = linearLayout.getChildAt(i12)) == null) {
            return;
        }
        x.P(childAt, k(context, ((Integer) childAt.getTag()).intValue(), true));
    }
}
