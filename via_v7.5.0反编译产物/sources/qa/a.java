package qa;

import android.util.Base64;
import android.webkit.MimeTypeMap;
import c6.b2;
import c6.l1;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import ra.e;
import x.h;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f11845a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f11846b = Collections.synchronizedMap(new LinkedHashMap());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f11847c = UUID.randomUUID().toString();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final l1 f11848d = new l1();

    /* JADX INFO: renamed from: qa.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class C0115a implements Comparator {
        public C0115a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(ra.c cVar, ra.c cVar2) {
            if (cVar.j() != cVar2.j()) {
                return cVar2.j() ? 1 : -1;
            }
            if (cVar.a() == cVar2.a()) {
                return 0;
            }
            return cVar.a() < cVar2.a() ? 1 : -1;
        }
    }

    public a(d dVar) {
        this.f11845a = dVar;
    }

    @Override // qa.c
    public boolean A(String str, int i10) {
        ra.d dVarO = O(str);
        return (dVarO == null || (dVarO.c() & i10) == 0) ? false : true;
    }

    @Override // qa.c
    public String B(int i10) {
        ra.d dVarG = g(i10);
        if (dVarG == null) {
            return null;
        }
        return dVarG.h();
    }

    @Override // qa.c
    public boolean C(String str) {
        if (str != null && !str.isEmpty()) {
            for (ra.d dVar : R()) {
                if (!dVar.j() && dVar.v(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // qa.c
    public List D(String str, int i10, boolean z10) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (ra.d dVar : R()) {
            if (dVar.k() && (z10 || dVar.j())) {
                if ((dVar.g() & i10) != 0 && dVar.v(str)) {
                    tc.a.a("run script: " + dVar.d() + ":" + dVar.h() + ", run at: " + i10 + ", for: " + str.substring(0, Math.min(str.length(), 50)), new Object[0]);
                    arrayList.add(dVar);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    @Override // qa.c
    public String E(String str, String str2) {
        String strP = P(str, str2);
        byte[] bArrM = M(strP);
        String mimeTypeFromExtension = null;
        if (bArrM == null) {
            return null;
        }
        if (bArrM.length == 0) {
            return "";
        }
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(strP);
        if (fileExtensionFromUrl != null && !fileExtensionFromUrl.isEmpty()) {
            mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl);
        }
        if (mimeTypeFromExtension == null) {
            mimeTypeFromExtension = "application/octet-stream";
        }
        return "data:" + mimeTypeFromExtension + ";base64," + Base64.encodeToString(bArrM, 2);
    }

    @Override // qa.c
    public String F(String str, String str2) {
        byte[] bArrM = M(P(str, str2));
        if (bArrM == null) {
            return null;
        }
        if (bArrM.length == 0) {
            return "";
        }
        try {
            return new String(bArrM, "UTF-8");
        } catch (UnsupportedEncodingException e10) {
            e10.printStackTrace();
            return "";
        }
    }

    @Override // qa.c
    public synchronized String G(ra.d dVar) {
        try {
            if (g(dVar.d()) == dVar && dVar.k()) {
                String strValueOf = String.valueOf(dVar.d());
                String strB = this.f11848d.b(strValueOf);
                if (strB != null) {
                    return strB;
                }
                String strI = dVar.j() ? dVar.i() : f(dVar.d());
                if (strI != null && !strI.isEmpty()) {
                    ArrayList arrayList = new ArrayList();
                    boolean z10 = true;
                    if (dVar.e() != null) {
                        for (String str : dVar.e()) {
                            String strN = N(str);
                            if (strN == null || strN.isEmpty()) {
                                z10 = false;
                            }
                            if (strN == null) {
                                strN = "";
                            }
                            arrayList.add(strN);
                        }
                    }
                    String strA = b2.f1963a.a(dVar.h(), this.f11847c, dVar.c(), dVar.b(), arrayList, strI);
                    if (z10) {
                        this.f11848d.c(strValueOf, strA);
                    }
                    return strA;
                }
                return null;
            }
            return null;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // qa.c
    public List H(String str) {
        ArrayList arrayList = new ArrayList();
        for (ra.d dVar : R()) {
            if (str == null || str.isEmpty() || dVar.v(str)) {
                ra.c cVarK = k(dVar.d());
                if (cVarK != null) {
                    arrayList.add(cVarK);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        if (arrayList.size() == 1) {
            return arrayList;
        }
        Collections.sort(arrayList, new C0115a());
        return arrayList;
    }

    @Override // qa.c
    public boolean I() {
        return K(R());
    }

    @Override // qa.c
    public boolean J(String str) {
        ra.d dVarO = O(str);
        if (dVarO == null) {
            return true;
        }
        return K(Collections.singletonList(dVarO));
    }

    public final boolean K(List list) {
        Iterator it = i(list).iterator();
        boolean z10 = true;
        while (it.hasNext()) {
            if (!L((String) it.next())) {
                z10 = false;
            }
        }
        return z10;
    }

    public final boolean L(String str) {
        if (str == null || str.isEmpty() || !"http".equals(str.substring(0, Math.min(4, str.length())).toLowerCase(Locale.ROOT))) {
            return true;
        }
        boolean zW = this.f11845a.W(str);
        synchronized (this) {
            try {
                for (ra.d dVar : R()) {
                    if (dVar.e() != null && Arrays.asList(dVar.e()).contains(str)) {
                        this.f11848d.d(String.valueOf(dVar.d()));
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zW;
    }

    public final byte[] M(String str) {
        byte[] bArrT = this.f11845a.t(str);
        ua.d dVarE = ua.d.e(str);
        return (bArrT == null || dVarE == null || dVarE.b(bArrT)) ? bArrT : new byte[0];
    }

    public final String N(String str) {
        ua.d dVarE = ua.d.e(str);
        if (dVarE == null) {
            return this.f11845a.x(str);
        }
        byte[] bArrT = this.f11845a.t(str);
        if (bArrT == null) {
            return null;
        }
        return dVarE.b(bArrT) ? new String(bArrT, StandardCharsets.UTF_8) : "";
    }

    public ra.d O(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        synchronized (this.f11846b) {
            try {
                for (ra.d dVar : this.f11846b.values()) {
                    if (str.equals(dVar.h())) {
                        return dVar;
                    }
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final String P(String str, String str2) {
        ra.d dVarO;
        if (str == null || str.isEmpty() || str2 == null || str2.isEmpty() || (dVarO = O(str)) == null) {
            return null;
        }
        return (String) dVarO.f().get(str2);
    }

    public synchronized void Q() {
        List<ra.d> listJ = this.f11845a.J();
        synchronized (this.f11846b) {
            try {
                this.f11846b.clear();
                for (ra.d dVar : listJ) {
                    this.f11846b.put(Integer.valueOf(dVar.d()), dVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f11848d.a();
    }

    public final List R() {
        ArrayList arrayList;
        synchronized (this.f11846b) {
            arrayList = new ArrayList(this.f11846b.values());
        }
        return arrayList;
    }

    @Override // qa.c
    public synchronized int a(ra.a aVar) {
        int iA;
        iA = this.f11845a.a(aVar);
        if (iA > 0) {
            this.f11848d.d(String.valueOf(iA));
            aVar.g(iA);
            this.f11846b.put(Integer.valueOf(aVar.b()), ra.d.l(aVar.a()));
        }
        return iA;
    }

    @Override // qa.c
    public void b(String str, String str2) {
        this.f11845a.b(str, str2);
    }

    @Override // qa.c
    public void c(String str, String str2, String str3) {
        this.f11845a.c(str, str2, str3);
    }

    @Override // qa.c
    public String d() {
        return this.f11847c;
    }

    @Override // qa.c
    public String e(String str, String str2) {
        return this.f11845a.e(str, str2);
    }

    @Override // qa.c
    public String f(int i10) {
        if (i10 < 0) {
            return null;
        }
        return this.f11845a.f(i10);
    }

    @Override // qa.c
    public ra.d g(int i10) {
        return (ra.d) this.f11846b.get(Integer.valueOf(i10));
    }

    @Override // qa.c
    public ra.c h(String str, String str2) {
        return this.f11845a.h(str, str2);
    }

    public final Set i(List list) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ra.d dVar = (ra.d) it.next();
            if (dVar.e() != null) {
                Collections.addAll(linkedHashSet, dVar.e());
            }
            linkedHashSet.addAll(dVar.f().values());
        }
        return linkedHashSet;
    }

    @Override // qa.c
    public String[] j(String str) {
        return this.f11845a.j(str);
    }

    @Override // qa.c
    public ra.c k(int i10) {
        return this.f11845a.k(i10);
    }

    @Override // qa.c
    public synchronized boolean l(int i10, boolean z10) {
        if (!this.f11845a.l(i10, z10)) {
            return false;
        }
        ra.d dVarG = g(i10);
        if (dVarG != null) {
            dVarG.o(z10);
        }
        return true;
    }

    @Override // qa.c
    public synchronized boolean m(int i10, e eVar) {
        if (!this.f11845a.m(i10, eVar)) {
            return false;
        }
        ra.d dVarG = this.f11845a.g(i10);
        if (dVarG == null) {
            this.f11846b.remove(Integer.valueOf(i10));
            return false;
        }
        this.f11846b.put(Integer.valueOf(i10), dVarG);
        return true;
    }

    @Override // qa.c
    public e n(int i10) {
        return this.f11845a.n(i10);
    }

    @Override // qa.c
    public e o(int i10) {
        return this.f11845a.o(i10);
    }

    @Override // qa.c
    public synchronized boolean p(int i10, ra.a aVar) {
        if (!this.f11845a.p(i10, aVar)) {
            return false;
        }
        this.f11848d.d(String.valueOf(i10));
        aVar.g(i10);
        this.f11846b.put(Integer.valueOf(aVar.b()), ra.d.l(aVar.a()));
        return true;
    }

    @Override // qa.c
    public List q() {
        return this.f11845a.q();
    }

    @Override // qa.c
    public ra.c r(String str) {
        return this.f11845a.r(str);
    }

    @Override // qa.c
    public synchronized boolean s(int i10) {
        if (!this.f11845a.s(i10)) {
            return false;
        }
        String strB = B(i10);
        this.f11846b.remove(Integer.valueOf(i10));
        this.f11848d.d(String.valueOf(i10));
        this.f11845a.v(strB);
        return true;
    }

    @Override // qa.c
    public boolean t(int i10) {
        ra.d dVarG = g(i10);
        return dVarG != null && dVarG.k();
    }

    @Override // qa.c
    public boolean u() {
        return this.f11845a.u(i(R()));
    }

    @Override // qa.c
    public synchronized void v(ra.a aVar, int i10, h hVar) {
        this.f11846b.put(Integer.valueOf(aVar.b()), ra.d.m(aVar.a(), i10, hVar));
        this.f11848d.d(String.valueOf(aVar.b()));
    }

    @Override // qa.c
    public synchronized boolean w(int i10, boolean z10) {
        ra.d dVarG = g(i10);
        if (dVarG == null) {
            return false;
        }
        dVarG.o(z10);
        return true;
    }

    @Override // qa.c
    public boolean x(int i10) {
        ra.d dVarG = g(i10);
        return dVarG != null && dVarG.a() == 0;
    }

    @Override // qa.c
    public boolean y(String str) {
        return L(str);
    }

    @Override // qa.c
    public String z(String str) {
        return this.f11845a.w(str);
    }
}
