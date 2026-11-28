package q3;

import com.google.firebase.components.ComponentRegistrar;
import java.util.ArrayList;
import java.util.List;
import n2.e;
import n2.h;
import n2.j;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class b implements j {
    public static /* synthetic */ Object b(String str, n2.c cVar, e eVar) {
        try {
            c.b(str);
            return cVar.h().a(eVar);
        } finally {
            c.a();
        }
    }

    @Override // n2.j
    public List a(ComponentRegistrar componentRegistrar) {
        ArrayList arrayList = new ArrayList();
        for (final n2.c cVarR : componentRegistrar.getComponents()) {
            final String strI = cVarR.i();
            if (strI != null) {
                cVarR = cVarR.r(new h() { // from class: q3.a
                    @Override // n2.h
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
