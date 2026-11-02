package p3;

import com.google.firebase.components.ComponentRegistrar;
import java.util.ArrayList;
import java.util.List;
import m2.e;
import m2.h;
import m2.j;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class b implements j {
    public static /* synthetic */ Object b(String str, m2.c cVar, e eVar) {
        try {
            c.b(str);
            return cVar.h().a(eVar);
        } finally {
            c.a();
        }
    }

    @Override // m2.j
    public List a(ComponentRegistrar componentRegistrar) {
        ArrayList arrayList = new ArrayList();
        for (final m2.c cVarR : componentRegistrar.getComponents()) {
            final String strI = cVarR.i();
            if (strI != null) {
                cVarR = cVarR.r(new h() { // from class: p3.a
                    @Override // m2.h
                    public final Object a(e eVar) {
                        return b.b(strI, cVarR, eVar);
                    }
                });
            }
            arrayList.add(cVarR);
        }
        return arrayList;
    }
}
