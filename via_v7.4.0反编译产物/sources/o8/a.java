package o8;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class a extends Fragment implements b {
    @Override // androidx.fragment.app.Fragment
    public void O1() {
        View viewC1 = c1();
        if (viewC1 != null) {
            viewC1.setImportantForAccessibility(4);
        }
        super.O1();
    }

    @Override // androidx.fragment.app.Fragment
    public void T1() {
        super.T1();
        View viewC1 = c1();
        if (viewC1 != null) {
            viewC1.setImportantForAccessibility(0);
        }
    }

    @Override // o8.b
    public void d0(boolean z10) {
        if (c1() == null) {
            return;
        }
        FragmentManager fragmentManagerN0 = N0();
        fragmentManagerN0.q().n(this).i();
        fragmentManagerN0.q().h(this).i();
    }
}
