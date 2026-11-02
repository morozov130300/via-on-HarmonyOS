package z8;

import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class n0 {
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
                List listA0 = kVar.z0().A0();
                if (listA0.isEmpty()) {
                    return false;
                }
                Iterator it = listA0.iterator();
                while (true) {
                    if (it.hasNext()) {
                        Fragment fragment = (Fragment) it.next();
                        if (fragment.q1()) {
                            viewGroup = (ViewGroup) fragment.c1();
                        }
                    } else {
                        viewGroup = null;
                    }
                }
                if (viewGroup == null) {
                    return false;
                }
                return g6.y.A(viewGroup, i10);
            default:
                return false;
        }
    }

    public static void b(final androidx.fragment.app.k kVar) {
        if (kVar == null || kVar.Z2() == null) {
            return;
        }
        kVar.Z2().setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: z8.m0
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
                return n0.a(kVar, dialogInterface, i10, keyEvent);
            }
        });
    }

    public static boolean c(Context context) {
        if (!l3.f(context)) {
            return false;
        }
        if (l0.j()) {
            return (g6.o.e() || g6.o.d()) ? false : true;
        }
        return true;
    }
}
