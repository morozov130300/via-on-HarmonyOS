package o8;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tuyafeng.support.widget.z;
import g6.y;
import h6.a;
import mark.via.common.widget.v0;
import z8.l3;
import z8.r3;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class g extends h {

    /* renamed from: o0, reason: collision with root package name */
    public boolean f10457o0 = false;

    /* renamed from: p0, reason: collision with root package name */
    public View f10458p0;

    /* renamed from: q0, reason: collision with root package name */
    public RecyclerView f10459q0;

    public static /* synthetic */ void b3(v0 v0Var) {
        r3.d(v0Var);
        r3.h(v0Var);
    }

    @Override // o8.h
    public void U2() {
        this.f10459q0.setClipToPadding(false);
        LinearLayout linearLayout = this.f10460m0;
        l3.c(linearLayout, (View) y.k(linearLayout, z.class), this.f10459q0);
    }

    @Override // o8.h
    public View Z2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        this.f10459q0 = (RecyclerView) new h6.a(new v0(I()), new FrameLayout.LayoutParams(-1, -1)).V(new a.InterfaceC0076a() { // from class: o8.f
            @Override // h6.a.InterfaceC0076a
            public final void a(Object obj) {
                g.b3((v0) obj);
            }
        }).l();
        FrameLayout frameLayout = new FrameLayout(I());
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(this.f10459q0);
        return frameLayout;
    }

    public View c3() {
        return r3.b(I());
    }

    public final View d3() {
        if (this.f10458p0 == null) {
            this.f10458p0 = c3();
            ((ViewGroup) this.f10459q0.getParent()).addView(this.f10458p0);
        }
        return this.f10458p0;
    }

    public void e3(boolean z10) {
        if (z10 == this.f10457o0) {
            return;
        }
        if (z10) {
            d3().setVisibility(0);
            this.f10459q0.setVisibility(8);
        } else {
            View view = this.f10458p0;
            if (view != null) {
                view.setVisibility(8);
            }
            this.f10459q0.setVisibility(0);
        }
        this.f10457o0 = z10;
        f3(z10);
    }

    public void f3(boolean z10) {
    }
}
