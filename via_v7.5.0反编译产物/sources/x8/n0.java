package x8;

import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class n0 {
    /* JADX WARN: Code duplicated, block: B:18:0x003a A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:20:0x003c  */
    public static /* synthetic */ boolean a(androidx.fragment.app.k kVar, DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
        ViewGroup viewGroup;
        if (keyEvent.getAction() != 0) {
            return false;
        }
        switch (i10) {
            case 19:
            case 20:
            case 21:
            case 22:
                List<Fragment> listA0 = kVar.x0().A0();
                if (listA0.isEmpty()) {
                    return false;
                }
                for (Fragment fragment : listA0) {
                    if (fragment.o1()) {
                        viewGroup = (ViewGroup) fragment.a1();
                        if (viewGroup == null) {
                            return false;
                        }
                        return com.tuyafeng.support.utils.x.A(viewGroup, i10);
                    }
                }
                viewGroup = null;
                if (viewGroup == null) {
                    return false;
                }
                return com.tuyafeng.support.utils.x.A(viewGroup, i10);
            default:
                return false;
        }
    }

    public static void b(final androidx.fragment.app.k kVar) {
        if (kVar == null || kVar.X2() == null) {
            return;
        }
        kVar.X2().setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: x8.m0
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
                return n0.a(kVar, dialogInterface, i10, keyEvent);
            }
        });
    }

    public static boolean c(Context context) {
        if (!h3.i(context)) {
            return false;
        }
        if (l0.j()) {
            return (com.tuyafeng.support.utils.o.e() || com.tuyafeng.support.utils.o.d()) ? false : true;
        }
        return true;
    }
}
