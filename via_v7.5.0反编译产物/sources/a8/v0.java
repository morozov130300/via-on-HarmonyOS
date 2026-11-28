package a8;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import x8.r3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class v0 extends t5.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f197c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f198d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f199e = true;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface a {
        void a(String str);
    }

    public v0(a aVar) {
        this.f197c = aVar;
    }

    public static /* synthetic */ void l(v0 v0Var, t0 t0Var, View view) {
        if (v0Var.f199e) {
            v0Var.f197c.a(t0Var.a().b());
        }
    }

    public void m(int i10) {
        if (this.f198d >= 0 || i10 == 0) {
            return;
        }
        this.f198d = 14 - (i10 <= 6 ? 0 : Math.min((i10 - 6) / 2, 8));
    }

    @Override // t5.d
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public void b(w5.g gVar, final t0 t0Var) {
        String string;
        super.b(gVar, t0Var);
        Context contextO = gVar.O();
        LinearLayout linearLayout = (LinearLayout) gVar.f1138a;
        ImageView imageView = (ImageView) linearLayout.getChildAt(0);
        TextView textView = (TextView) linearLayout.getChildAt(1);
        String string2 = t0Var.a().b().isEmpty() ? contextO.getString(w7.u.Eb) : t0Var.a().e();
        textView.setText(string2);
        int iH = com.tuyafeng.support.utils.x.h(contextO, this.f198d);
        linearLayout.setMinimumHeight(com.tuyafeng.support.utils.f.d(contextO, w7.n.f13753f) + (iH * 2));
        y.r.f0(textView, com.tuyafeng.support.utils.x.h(contextO, 3.0f), iH, 0, iH);
        y.r.f0(linearLayout, com.tuyafeng.support.utils.x.h(contextO, (Math.min(9, t0Var.b()) * 16) + 3), 0, com.tuyafeng.support.utils.x.h(contextO, 16.0f), 0);
        linearLayout.setSelected(t0Var.c());
        com.tuyafeng.support.utils.x.P(linearLayout, t0Var.c() ? new ColorDrawable(com.tuyafeng.support.utils.f.b(contextO, w7.m.f13738b)) : com.tuyafeng.support.utils.f.e(contextO, w7.o.f13786e));
        boolean zE = t0Var.e();
        imageView.setImageDrawable(lb.g.a(contextO, zE ? w7.o.f13790f0 : w7.o.f13784d0, zE ? w7.u.ve : w7.u.te));
        imageView.setOnClickListener(new View.OnClickListener() { // from class: a8.u0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                v0.l(this.f194a, t0Var, view);
            }
        });
        imageView.setFocusable(this.f199e);
        y.r.c0(imageView, this.f199e ? 1 : 2);
        if (this.f199e) {
            string = contextO.getString(t0Var.e() ? w7.u.f14302y3 : w7.u.A3, string2);
        } else {
            string = null;
        }
        imageView.setContentDescription(string);
        com.tuyafeng.support.utils.x.P(imageView, this.f199e ? com.tuyafeng.support.utils.f.e(contextO, w7.o.f13783d) : null);
    }

    @Override // t5.d
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public w5.g d(Context context, ViewGroup viewGroup) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        ImageView imageView = new ImageView(context);
        int iH = com.tuyafeng.support.utils.x.h(context, 48.0f);
        int iH2 = com.tuyafeng.support.utils.x.h(context, 13.0f);
        imageView.setPadding(iH2, 0, iH2, 0);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        androidx.core.widget.b.a(imageView, ColorStateList.valueOf(com.tuyafeng.support.utils.e.a(context, w7.k.f13732l)));
        linearLayout.addView(imageView, new LinearLayout.LayoutParams(iH, -1));
        TextView textView = new TextView(context);
        textView.setGravity(16);
        textView.setTextColor(com.tuyafeng.support.utils.e.a(context, w7.k.f13732l));
        textView.setTextSize(0, v8.h.q(context));
        r3.q(textView);
        r3.o(textView);
        v8.g.d(textView);
        linearLayout.addView(textView, new LinearLayout.LayoutParams(0, -2, 1.0f));
        return new w5.g(linearLayout);
    }

    public boolean p(boolean z10) {
        boolean z11 = this.f199e != z10;
        this.f199e = z10;
        return z11;
    }
}
