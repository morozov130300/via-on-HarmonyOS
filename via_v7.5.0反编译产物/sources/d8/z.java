package d8;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import mark.via.download.m1;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class z extends c {

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public static final int f4008v0 = com.tuyafeng.support.utils.x.l();

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public FrameLayout f4009u0;

    @Override // d8.c
    public CharSequence U2() {
        return X0(w7.u.D);
    }

    @Override // d8.c, androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        super.V1(view, bundle);
        this.f4009u0.setClickable(true);
        this.f4009u0.setFocusable(false);
        x0().q().u(f4008v0, m1.class, m1.o4(false), null).i();
    }

    @Override // d8.c
    public View V2(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FrameLayout frameLayout = (FrameLayout) new b6.a(new FrameLayout(G()), new FrameLayout.LayoutParams(-1, -1)).o(f4008v0).l();
        this.f4009u0 = frameLayout;
        return frameLayout;
    }
}
