package i8;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import com.tuyafeng.support.utils.x;
import w7.v;
import x8.h3;
import x8.n0;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class a extends androidx.fragment.app.k {
    @Override // androidx.fragment.app.Fragment
    public void R1() {
        Window window;
        super.R1();
        Dialog dialogX2 = X2();
        if (dialogX2 == null || (window = dialogX2.getWindow()) == null) {
            return;
        }
        int iMin = Math.min(x.h(G(), 384.0f), x.p(G()) - x.h(G(), 72.0f));
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = iMin;
        attributes.gravity = 17;
        window.setAttributes(attributes);
        if (n0.c(G())) {
            h3.q(window, true);
        }
        x8.l.a(window, i3());
    }

    public int i3() {
        return 1;
    }

    @Override // androidx.fragment.app.k, androidx.fragment.app.Fragment
    public void w1(Bundle bundle) {
        super.w1(bundle);
        e3(1, v.f14326c);
    }
}
