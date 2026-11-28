package oa;

import android.webkit.URLUtil;
import c6.b2;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class a implements k1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final qa.c f10978a;

    public a(qa.c cVar) {
        this.f10978a = cVar;
    }

    public final String a(String str) {
        int iIndexOf;
        if (str == null || str.isEmpty() || !URLUtil.isNetworkUrl(str) || (iIndexOf = str.indexOf("://")) < 0) {
            return "";
        }
        int i10 = iIndexOf + 3;
        int iIndexOf2 = str.indexOf(47, i10);
        if (iIndexOf2 < 0) {
            iIndexOf2 = str.length();
        }
        return str.substring(i10, iIndexOf2).toLowerCase(Locale.ROOT);
    }

    @Override // oa.k1
    public String d() {
        return this.f10978a.d();
    }

    @Override // oa.k1
    public boolean e(String str, int i10, boolean z10, boolean z11, k1.a aVar) {
        boolean z12 = false;
        if (str != null && !str.isEmpty() && !str.startsWith("file://") && this.f10978a != null) {
            if (z11 && z10 && (i10 == 1 || i10 == 2)) {
                String strA = a(str);
                if (strA.contains("greasyfork.org") || strA.contains("userscript.zone") || strA.contains("openuserjs.org") || strA.contains("sleazyfork.org")) {
                    aVar.a(b2.f1963a.f(d()));
                }
            }
            List<ra.d> listD = this.f10978a.D(str, i10, z11);
            if (listD != null && !listD.isEmpty()) {
                for (ra.d dVar : listD) {
                    if (z10 || (dVar.b() & 2) == 0) {
                        String strG = this.f10978a.G(dVar);
                        if (strG != null) {
                            aVar.a(strG);
                            z12 = true;
                        }
                    }
                }
            }
        }
        return z12;
    }

    @Override // oa.k1
    public qa.c f() {
        return this.f10978a;
    }
}
