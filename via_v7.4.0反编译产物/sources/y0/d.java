package y0;

import com.burgstaller.okhttp.digest.fromhttpclient.BasicNameValuePair;
import java.util.ArrayList;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f14391a = new d();

    /* renamed from: b, reason: collision with root package name */
    public static final d f14392b = new d();

    /* renamed from: c, reason: collision with root package name */
    public static final char[] f14393c = {';', ','};

    public static boolean c(char c10, char[] cArr) {
        if (cArr != null) {
            for (char c11 : cArr) {
                if (c10 == c11) {
                    return true;
                }
            }
        }
        return false;
    }

    public g a(String str, String str2, j[] jVarArr) {
        return new b(str, str2, jVarArr);
    }

    public j b(String str, String str2) {
        return new BasicNameValuePair(str, str2);
    }

    public g[] d(e eVar, k kVar) {
        a.a(eVar, "Char array buffer");
        a.a(kVar, "Parser cursor");
        ArrayList arrayList = new ArrayList();
        while (!kVar.a()) {
            g gVarE = e(eVar, kVar);
            if (gVarE.getName().length() != 0 || gVarE.getValue() != null) {
                arrayList.add(gVarE);
            }
        }
        return (g[]) arrayList.toArray(new g[arrayList.size()]);
    }

    public g e(e eVar, k kVar) {
        a.a(eVar, "Char array buffer");
        a.a(kVar, "Parser cursor");
        j jVarF = f(eVar, kVar);
        return a(jVarF.getName(), jVarF.getValue(), (kVar.a() || eVar.b(kVar.b() + (-1)) == ',') ? null : h(eVar, kVar));
    }

    public j f(e eVar, k kVar) {
        return g(eVar, kVar, f14393c);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002e, code lost:
    
        r5 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public j g(e eVar, k kVar, char[] cArr) {
        boolean z10;
        boolean z11;
        String strE;
        char cB;
        a.a(eVar, "Char array buffer");
        a.a(kVar, "Parser cursor");
        int iB = kVar.b();
        int iB2 = kVar.b();
        int iC = kVar.c();
        while (true) {
            z10 = true;
            if (iB >= iC || (cB = eVar.b(iB)) == '=') {
                break;
            }
            if (c(cB, cArr)) {
                z11 = true;
                break;
            }
            iB++;
        }
        if (iB == iC) {
            strE = eVar.e(iB2, iC);
            z11 = true;
        } else {
            strE = eVar.e(iB2, iB);
            iB++;
        }
        if (z11) {
            kVar.d(iB);
            return b(strE, null);
        }
        int i10 = iB;
        boolean z12 = false;
        boolean z13 = false;
        while (true) {
            if (i10 >= iC) {
                z10 = z11;
                break;
            }
            char cB2 = eVar.b(i10);
            if (cB2 == '\"' && !z12) {
                z13 = !z13;
            }
            if (!z13 && !z12 && c(cB2, cArr)) {
                break;
            }
            z12 = !z12 && z13 && cB2 == '\\';
            i10++;
        }
        while (iB < i10 && f.a(eVar.b(iB))) {
            iB++;
        }
        int i11 = i10;
        while (i11 > iB && f.a(eVar.b(i11 - 1))) {
            i11--;
        }
        if (i11 - iB >= 2 && eVar.b(iB) == '\"' && eVar.b(i11 - 1) == '\"') {
            iB++;
            i11--;
        }
        String strD = eVar.d(iB, i11);
        if (z10) {
            i10++;
        }
        kVar.d(i10);
        return b(strE, strD);
    }

    public j[] h(e eVar, k kVar) {
        a.a(eVar, "Char array buffer");
        a.a(kVar, "Parser cursor");
        int iB = kVar.b();
        int iC = kVar.c();
        while (iB < iC && f.a(eVar.b(iB))) {
            iB++;
        }
        kVar.d(iB);
        if (kVar.a()) {
            return new j[0];
        }
        ArrayList arrayList = new ArrayList();
        while (!kVar.a()) {
            arrayList.add(f(eVar, kVar));
            if (eVar.b(kVar.b() - 1) == ',') {
                break;
            }
        }
        return (j[]) arrayList.toArray(new j[arrayList.size()]);
    }
}
