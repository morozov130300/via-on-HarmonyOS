package m8;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tuyafeng.support.utils.x;
import com.tuyafeng.support.widget.e0;
import mark.via.common.widget.v0;
import x8.h3;
import x8.r3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class f extends g {

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public boolean f7944r0 = false;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public View f7945s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public RecyclerView f7946t0;

    public static /* synthetic */ void a3(v0 v0Var) {
        r3.e(v0Var);
        r3.i(v0Var);
    }

    @Override // m8.g
    public void S2() {
        this.f7946t0.setClipToPadding(false);
        LinearLayout linearLayout = this.f7947o0;
        h3.f(linearLayout, (View) x.k(linearLayout, e0.class), this.f7946t0);
    }

    @Override // m8.g
    public View Y2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        this.f7946t0 = (RecyclerView) new b6.a(new v0(G()), new FrameLayout.LayoutParams(-1, -1)).V(new b6.a.InterfaceC0033a() { // from class: m8.e
            @Override // b6.a.InterfaceC0033a
            public final void a(Object obj) {
                f.a3((v0) obj);
            }
        }).l();
        FrameLayout frameLayout = new FrameLayout(G());
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(this.f7946t0);
        return frameLayout;
    }

    public View b3() {
        return r3.b(G());
    }

    public final View c3() {
        if (this.f7945s0 == null) {
            this.f7945s0 = b3();
            ((ViewGroup) this.f7946t0.getParent()).addView(this.f7945s0);
        }
        return this.f7945s0;
    }

    public void d3(boolean z10) {
        if (z10 == this.f7944r0) {
            return;
        }
        if (z10) {
            c3().setVisibility(0);
            this.f7946t0.setVisibility(8);
        } else {
            View view = this.f7945s0;
            if (view != null) {
                view.setVisibility(8);
            }
            this.f7946t0.setVisibility(0);
        }
        this.f7944r0 = z10;
        e3(z10);
    }

    public void e3(boolean z10) {
    }
}
