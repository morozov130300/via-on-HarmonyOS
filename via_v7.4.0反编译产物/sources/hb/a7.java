package hb;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tuyafeng.support.widget.z;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class a7 extends o8.h {

    /* renamed from: q0, reason: collision with root package name */
    public static final int f6468q0 = x.r.j();

    /* renamed from: r0, reason: collision with root package name */
    public static final int f6469r0 = x.r.j();

    /* renamed from: s0, reason: collision with root package name */
    public static final int f6470s0 = x.r.j();

    /* renamed from: o0, reason: collision with root package name */
    public com.tuyafeng.support.widget.z f6471o0;

    /* renamed from: p0, reason: collision with root package name */
    public w9.l f6472p0;

    public static /* synthetic */ void b3(a7 a7Var, View view) {
        a7Var.f6472p0.i(0);
        a7Var.d3();
    }

    public static /* synthetic */ void c3(a7 a7Var, View view) {
        a7Var.f6472p0.i(1);
        a7Var.e3();
    }

    @Override // o8.h, androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        w9.l lVarJ = pa.r.j();
        this.f6472p0 = lVarJ;
        if (bundle != null) {
            f3(lVarJ.k1() == 0);
        } else if (lVarJ.k1() == 0) {
            d3();
        } else {
            e3();
        }
    }

    @Override // o8.h
    public View Z2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        FrameLayout frameLayout = new FrameLayout(I());
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        frameLayout.setId(f6468q0);
        return frameLayout;
    }

    @Override // o8.h
    public void a3(com.tuyafeng.support.widget.z zVar) {
        super.a3(zVar);
        this.f6471o0 = zVar;
        z8.v3.a(zVar, x7.u.sd);
        zVar.c(new z.b(f6469r0, 1, null, Z0(x7.u.Hd)), new View.OnClickListener() { // from class: hb.y6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                a7.c3(this.f6845a, view);
            }
        });
        zVar.c(new z.b(f6470s0, 1, null, Z0(x7.u.qc)), new View.OnClickListener() { // from class: hb.z6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                a7.b3(this.f6866a, view);
            }
        });
    }

    public final void d3() {
        f3(true);
        z0().q().u(f6468q0, u.class, null, null).i();
    }

    public final void e3() {
        f3(false);
        z0().q().u(f6468q0, nb.n.class, null, null).i();
    }

    public final void f3(boolean z10) {
        this.f6471o0.j(f6470s0, !z10);
        this.f6471o0.j(f6469r0, z10);
    }
}
