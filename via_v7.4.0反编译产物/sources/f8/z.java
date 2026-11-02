package f8;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import mark.via.download.b1;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class z extends c {

    /* renamed from: t0, reason: collision with root package name */
    public static final int f6058t0 = g6.y.l();

    /* renamed from: s0, reason: collision with root package name */
    public FrameLayout f6059s0;

    @Override // f8.c
    public CharSequence W2() {
        return Z0(x7.u.C);
    }

    @Override // f8.c, androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) {
        super.X1(view, bundle);
        this.f6059s0.setClickable(true);
        this.f6059s0.setFocusable(false);
        z0().q().u(f6058t0, b1.class, b1.l4(false), null).i();
    }

    @Override // f8.c
    public View X2(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FrameLayout frameLayout = (FrameLayout) new h6.a(new FrameLayout(I()), new FrameLayout.LayoutParams(-1, -1)).o(f6058t0).l();
        this.f6059s0 = frameLayout;
        return frameLayout;
    }
}
