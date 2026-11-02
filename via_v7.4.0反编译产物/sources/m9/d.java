package m9;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import w9.n;
import z8.p;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class d implements b {

    /* renamed from: a, reason: collision with root package name */
    public final o9.c f8682a;

    public d(o9.c cVar) {
        this.f8682a = cVar;
    }

    @Override // m9.b
    public List a(c cVar) throws IOException {
        File fileA = cVar.a("bookmarks.html");
        if (fileA == null) {
            return Collections.EMPTY_LIST;
        }
        w.d dVarA = w.d.a(this.f8682a.k(), this.f8682a.u());
        if (((List) dVarA.f13207a).isEmpty() && ((List) dVarA.f13208b).isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileA);
            try {
                if (p.r(fileOutputStream, dVarA) > 0) {
                    arrayList.add(new a(fileA));
                }
                fileOutputStream.close();
                return arrayList;
            } finally {
            }
        } catch (IOException e10) {
            pc.a.i(e10);
            return arrayList;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00cf A[Catch: all -> 0x0030, TryCatch #0 {all -> 0x0030, blocks: (B:8:0x0015, B:10:0x001b, B:12:0x0025, B:24:0x003f, B:26:0x0053, B:30:0x005a, B:35:0x006b, B:37:0x0078, B:39:0x0086, B:40:0x0089, B:41:0x008c, B:42:0x0095, B:44:0x009b, B:46:0x00a7, B:48:0x00af, B:51:0x00b8, B:52:0x00c0, B:54:0x00c6, B:57:0x00cf, B:58:0x00d9, B:60:0x00e0, B:61:0x00e5), top: B:73:0x0015, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00e0 A[Catch: all -> 0x0030, TryCatch #0 {all -> 0x0030, blocks: (B:8:0x0015, B:10:0x001b, B:12:0x0025, B:24:0x003f, B:26:0x0053, B:30:0x005a, B:35:0x006b, B:37:0x0078, B:39:0x0086, B:40:0x0089, B:41:0x008c, B:42:0x0095, B:44:0x009b, B:46:0x00a7, B:48:0x00af, B:51:0x00b8, B:52:0x00c0, B:54:0x00c6, B:57:0x00cf, B:58:0x00d9, B:60:0x00e0, B:61:0x00e5), top: B:73:0x0015, outer: #2 }] */
    @Override // m9.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(c cVar, int i10) throws IOException {
        w.d dVar;
        File fileA = cVar.a("bookmarks.html");
        if (fileA == null || !fileA.isFile()) {
            return;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(fileA);
            try {
                w.d dVarQ = p.q(fileInputStream);
                if (dVarQ != null && (((List) dVarQ.f13207a).size() > 0 || ((List) dVarQ.f13208b).size() > 0)) {
                    boolean z10 = i10 == 1;
                    if (!z10 && i10 == 2) {
                        int size = this.f8682a.u().size();
                        int size2 = ((List) dVarQ.f13208b).size();
                        z10 = size2 > size || size - size2 < size / 2;
                    }
                    long jB = cVar.b("bookmarks.html") / 1000;
                    if (i10 == 2 && z10 && jB != 0) {
                        List listU = this.f8682a.u();
                        for (int size3 = listU.size() - 1; size3 >= 0; size3--) {
                            if (((o9.b) listU.get(size3)).f() < jB) {
                                listU.remove(size3);
                            }
                        }
                        ArrayList arrayList = new ArrayList();
                        Iterator it = listU.iterator();
                        while (it.hasNext()) {
                            String strB = ((o9.b) it.next()).b();
                            while (strB != null && !"".equals(strB)) {
                                o9.a aVarF = this.f8682a.f(strB);
                                if (aVarF == null) {
                                    break;
                                }
                                arrayList.add(aVarF);
                                strB = aVarF.d();
                            }
                        }
                        if (!listU.isEmpty()) {
                            dVar = new w.d(arrayList, listU);
                        }
                        if (z10) {
                        }
                        this.f8682a.z(dVarQ);
                        if (dVar != null) {
                        }
                        n.e().s(true);
                    } else {
                        dVar = null;
                        if (z10) {
                            this.f8682a.v();
                            this.f8682a.l();
                        }
                        this.f8682a.z(dVarQ);
                        if (dVar != null) {
                            this.f8682a.z(dVar);
                        }
                        n.e().s(true);
                    }
                }
                fileInputStream.close();
            } finally {
            }
        } catch (IOException e10) {
            pc.a.i(e10);
        }
    }
}
