package k8;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import g6.y;
import x7.v;
import z8.l3;
import z8.n0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class a extends androidx.fragment.app.k {
    @Override // androidx.fragment.app.Fragment
    public void T1() {
        Window window;
        super.T1();
        Dialog dialogZ2 = Z2();
        if (dialogZ2 == null || (window = dialogZ2.getWindow()) == null) {
            return;
        }
        int iMin = Math.min(y.h(I(), 384.0f), y.p(I()) - y.h(I(), 72.0f));
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = iMin;
        attributes.gravity = 17;
        window.setAttributes(attributes);
        if (n0.c(I())) {
            l3.n(window, true);
        }
        z8.l.a(window, i3());
    }

    public int i3() {
        return 1;
    }

    @Override // androidx.fragment.app.k, androidx.fragment.app.Fragment
    public void y1(Bundle bundle) {
        super.y1(bundle);
        f3(1, v.f14256c);
    }
}
