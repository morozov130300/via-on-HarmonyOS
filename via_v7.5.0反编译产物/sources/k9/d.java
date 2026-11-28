package k9;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import x8.n;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class d implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m9.c f7223a;

    public d(m9.c cVar) {
        this.f7223a = cVar;
    }

    @Override // k9.b
    public List a(c cVar) {
        File fileA = cVar.a("bookmarks.html");
        if (fileA == null) {
            return Collections.EMPTY_LIST;
        }
        x.d dVarA = x.d.a(this.f7223a.j(), this.f7223a.u());
        if (((List) dVarA.f14455a).isEmpty() && ((List) dVarA.f14456b).isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileA);
            try {
                if (n.g(fileOutputStream, dVarA) > 0) {
                    arrayList.add(new a(fileA));
                }
                fileOutputStream.close();
                return arrayList;
            } catch (Throwable th) {
                try {
                    fileOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException e10) {
            tc.a.j(e10);
            return arrayList;
        }
    }

    /* JADX WARN: Code duplicated, block: B:55:0x00cc  */
    @Override // k9.b
    public void b(c cVar, int i10) {
        x.d dVar;
        File fileA = cVar.a("bookmarks.html");
        if (fileA == null || !fileA.isFile()) {
            return;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(fileA);
            try {
                x.d dVarF = n.f(fileInputStream);
                if (dVarF != null && (((List) dVarF.f14455a).size() > 0 || ((List) dVarF.f14456b).size() > 0)) {
                    boolean z10 = i10 == 1;
                    if (!z10 && i10 == 2) {
                        int size = this.f7223a.u().size();
                        int size2 = ((List) dVarF.f14456b).size();
                        z10 = size2 > size || size - size2 < size / 2;
                    }
                    long jB = cVar.b("bookmarks.html") / 1000;
                    if (i10 == 2 && z10 && jB != 0) {
                        List listU = this.f7223a.u();
                        for (int size3 = listU.size() - 1; size3 >= 0; size3--) {
                            if (((m9.b) listU.get(size3)).f() < jB) {
                                listU.remove(size3);
                            }
                        }
                        ArrayList arrayList = new ArrayList();
                        Iterator it = listU.iterator();
                        while (it.hasNext()) {
                            String strB = ((m9.b) it.next()).b();
                            while (strB != null && !"".equals(strB)) {
                                m9.a aVarE = this.f7223a.e(strB);
                                if (aVarE == null) {
                                    break;
                                }
                                arrayList.add(aVarE);
                                strB = aVarE.d();
                            }
                        }
                        if (listU.isEmpty()) {
                            dVar = null;
                        } else {
                            dVar = new x.d(arrayList, listU);
                        }
                    } else {
                        dVar = null;
                    }
                    if (z10) {
                        this.f7223a.v();
                        this.f7223a.l();
                    }
                    this.f7223a.A(dVarF);
                    if (dVar != null) {
                        this.f7223a.A(dVar);
                    }
                    u9.n.e().q(true);
                }
                fileInputStream.close();
            } catch (Throwable th) {
                try {
                    fileInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException e10) {
            tc.a.j(e10);
        }
    }
}
