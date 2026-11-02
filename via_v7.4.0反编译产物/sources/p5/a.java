package p5;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import android.webkit.MimeTypeMap;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import r5.e;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class a implements c {

    /* renamed from: c, reason: collision with root package name */
    public static final String f10961c = "a";

    /* renamed from: a, reason: collision with root package name */
    public final d f10962a;

    /* renamed from: b, reason: collision with root package name */
    public final q5.b f10963b = new q5.a();

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    /* renamed from: p5.a$a, reason: collision with other inner class name */
    public class C0110a implements Comparator {
        public C0110a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(r5.c cVar, r5.c cVar2) {
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
        this.f10962a = dVar;
    }

    public static String c(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder();
        for (byte b10 : bArr) {
            sb2.append(String.format("%02x", Byte.valueOf(b10)));
        }
        return sb2.toString();
    }

    @Override // p5.c
    public boolean A(String str, int i10) {
        r5.d dVarD = this.f10963b.d(str);
        return (dVarD == null || (dVarD.c() & i10) == 0) ? false : true;
    }

    @Override // p5.c
    public String B(int i10) {
        r5.d dVarA = this.f10963b.a(i10);
        if (dVarA == null) {
            return null;
        }
        return dVarA.h();
    }

    @Override // p5.c
    public boolean C(String str) {
        if (str != null && !str.isEmpty()) {
            for (r5.d dVar : this.f10963b.c()) {
                if (dVar.d() >= 0 && dVar.v(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // p5.c
    public String D(String str, String str2) {
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

    @Override // p5.c
    public String E(String str, String str2) {
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

    @Override // p5.c
    public List F(String str, int i10) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (r5.d dVar : this.f10963b.c()) {
            if (dVar.i() && (dVar.g() & i10) != 0 && dVar.v(str)) {
                s5.d.a(f10961c, "run script: " + dVar.d() + ":" + dVar.h() + ", run at: " + i10 + ", for: " + str.substring(0, Math.min(str.length(), 50)));
                arrayList.add(dVar);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    @Override // p5.c
    public List G(String str) {
        int[] iArr = new int[this.f10963b.c().size()];
        int i10 = 0;
        for (r5.d dVar : this.f10963b.c()) {
            if (str == null || str.isEmpty() || dVar.v(str)) {
                iArr[i10] = dVar.d();
                i10++;
            }
        }
        if (i10 <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < i10; i11++) {
            r5.c cVarK = k(iArr[i11]);
            if (cVarK != null) {
                arrayList.add(cVarK);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        if (arrayList.size() == 1) {
            return arrayList;
        }
        Collections.sort(arrayList, new C0110a());
        return arrayList;
    }

    @Override // p5.c
    public String H(String str) {
        return N(str);
    }

    @Override // p5.c
    public boolean I() {
        Iterator it = this.f10963b.c().iterator();
        int i10 = 0;
        while (it.hasNext()) {
            if (!e((r5.d) it.next())) {
                i10++;
            }
        }
        return i10 == 0;
    }

    @Override // p5.c
    public boolean J(String str) {
        r5.d dVarD = this.f10963b.d(str);
        if (dVarD == null) {
            return true;
        }
        return e(dVarD);
    }

    public final boolean K(String str) {
        if (str == null || str.isEmpty() || !"http".equals(str.substring(0, Math.min(4, str.length())).toLowerCase(Locale.ROOT))) {
            return true;
        }
        return this.f10962a.W(str);
    }

    public final String L(String str) {
        if ("md5".equals(str)) {
            return "MD5";
        }
        if ("sha256".equals(str)) {
            return "SHA-256";
        }
        return null;
    }

    public final byte[] M(String str) {
        Pair pairO;
        byte[] bArrT = this.f10962a.t(str);
        return (bArrT == null || bArrT.length <= 0 || (pairO = O(str)) == null || S(pairO, bArrT)) ? bArrT : new byte[0];
    }

    public final String N(String str) {
        Pair pairO;
        String strX = this.f10962a.x(str);
        return (strX == null || strX.isEmpty() || (pairO = O(str)) == null || R(pairO, strX)) ? strX : "";
    }

    public final Pair O(String str) {
        int iLastIndexOf = str == null ? -1 : str.lastIndexOf(35);
        if (iLastIndexOf <= 0 || !str.contains("://")) {
            return null;
        }
        int i10 = iLastIndexOf + 1;
        String[] strArr = {"md5", "sha256"};
        int[] iArr = {32, 64};
        int i11 = 0;
        int iIndexOf = 0;
        while (i11 < 2) {
            iIndexOf = str.indexOf(strArr[i11], i10);
            if (iIndexOf >= 0) {
                int length = iIndexOf + strArr[i11].length();
                if (str.length() > length && (str.charAt(length) == '=' || str.charAt(length) == '-')) {
                    iIndexOf = length + 1;
                    break;
                }
                iIndexOf = -1;
            }
            i11++;
        }
        if (iIndexOf < 0) {
            return null;
        }
        int iIndexOf2 = str.indexOf(44, iIndexOf);
        if (iIndexOf2 < 0) {
            iIndexOf2 = str.indexOf(59, iIndexOf);
        }
        if (iIndexOf2 < 0) {
            iIndexOf2 = str.length();
        }
        if (iIndexOf2 <= iIndexOf + 1) {
            return null;
        }
        String strSubstring = str.substring(iIndexOf, iIndexOf2);
        if (iArr[i11] != strSubstring.length()) {
            try {
                strSubstring = c(Base64.decode(strSubstring.getBytes("UTF-8"), 0));
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        return new Pair(strArr[i11], strSubstring);
    }

    public final String P(String str, String str2) {
        r5.d dVarD;
        if (str == null || str.isEmpty() || str2 == null || str2.isEmpty() || (dVarD = this.f10963b.d(str)) == null) {
            return null;
        }
        int length = dVarD.f().length;
        for (int i10 = 0; i10 < length; i10++) {
            if (str2.equals(dVarD.f()[i10][0])) {
                return dVarD.f()[i10][1];
            }
        }
        return null;
    }

    public void Q() {
        this.f10963b.e(this.f10962a.s());
    }

    public final boolean R(Pair pair, String str) {
        String strL = L((String) pair.first);
        if (strL == null) {
            return true;
        }
        try {
            return ((String) pair.second).equalsIgnoreCase(c(MessageDigest.getInstance(strL).digest(str.getBytes("UTF-8"))));
        } catch (Exception e10) {
            e10.printStackTrace();
            return true;
        }
    }

    public final boolean S(Pair pair, byte[] bArr) {
        String strL = L((String) pair.first);
        if (strL == null) {
            return true;
        }
        try {
            return ((String) pair.second).equalsIgnoreCase(c(MessageDigest.getInstance(strL).digest(bArr)));
        } catch (Exception e10) {
            e10.printStackTrace();
            return true;
        }
    }

    @Override // p5.c
    public void a(String str, String str2) {
        this.f10962a.a(str, str2);
    }

    @Override // p5.c
    public boolean b(int i10, e eVar) {
        if (!this.f10962a.b(i10, eVar)) {
            return false;
        }
        this.f10963b.f(this.f10962a.J(i10));
        return true;
    }

    @Override // p5.c
    public void d(String str, String str2, String str3) {
        this.f10962a.d(str, str2, str3);
    }

    public final boolean e(r5.d dVar) {
        int i10;
        if (dVar == null) {
            return false;
        }
        if (dVar.e() != null) {
            i10 = 0;
            for (String str : dVar.e()) {
                if (!K(str)) {
                    i10++;
                }
            }
        } else {
            i10 = 0;
        }
        if (dVar.f() != null) {
            for (int i11 = 0; i11 < dVar.f().length; i11++) {
                if (!K(dVar.f()[i11][1])) {
                    i10++;
                }
            }
        }
        return i10 <= 0;
    }

    @Override // p5.c
    public String f(String str, String str2) {
        return this.f10962a.f(str, str2);
    }

    @Override // p5.c
    public String g(int i10) {
        r5.d dVarA = this.f10963b.a(i10);
        String str = f10961c;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("get source code: ");
        sb2.append(i10);
        sb2.append(", pattern: ");
        sb2.append(dVarA == null ? "null" : dVarA.h());
        s5.d.a(str, sb2.toString());
        return dVarA != null ? dVarA.a() : this.f10962a.g(i10);
    }

    @Override // p5.c
    public int h(r5.a aVar) {
        int iH = this.f10962a.h(aVar);
        if (iH > 0) {
            aVar.h(iH);
            this.f10963b.f(aVar.a());
        }
        return iH;
    }

    @Override // p5.c
    public r5.c i(String str, String str2) {
        return this.f10962a.i(str, str2);
    }

    @Override // p5.c
    public String[] j(String str) {
        return this.f10962a.j(str);
    }

    @Override // p5.c
    public r5.c k(int i10) {
        return this.f10962a.k(i10);
    }

    @Override // p5.c
    public boolean l(int i10, boolean z10) {
        if (!this.f10962a.l(i10, z10)) {
            return false;
        }
        r5.d dVarA = this.f10963b.a(i10);
        if (dVarA == null) {
            return true;
        }
        dVarA.l(z10);
        return true;
    }

    @Override // p5.c
    public e m(int i10) {
        return this.f10962a.m(i10);
    }

    @Override // p5.c
    public e n(int i10) {
        return this.f10962a.n(i10);
    }

    @Override // p5.c
    public List o() {
        return this.f10962a.o();
    }

    @Override // p5.c
    public boolean p(int i10, r5.a aVar) {
        if (!this.f10962a.p(i10, aVar)) {
            return false;
        }
        aVar.h(i10);
        this.f10963b.f(aVar.a());
        return true;
    }

    @Override // p5.c
    public r5.c q(String str) {
        return this.f10962a.q(str);
    }

    @Override // p5.c
    public boolean r(int i10) {
        if (!this.f10962a.r(i10)) {
            return false;
        }
        String strB = B(i10);
        this.f10963b.b(i10);
        this.f10962a.v(strB);
        return true;
    }

    @Override // p5.c
    public boolean s(int i10) {
        r5.d dVarA = this.f10963b.a(i10);
        return dVarA != null && dVarA.i();
    }

    @Override // p5.c
    public boolean t() {
        HashSet hashSet = new HashSet();
        for (r5.d dVar : this.f10963b.c()) {
            if (dVar.e() != null) {
                Collections.addAll(hashSet, dVar.e());
            }
            if (dVar.f() != null) {
                for (String[] strArr : dVar.f()) {
                    if (strArr.length > 1) {
                        hashSet.add(strArr[1]);
                    }
                }
            }
        }
        return this.f10962a.u(hashSet);
    }

    @Override // p5.c
    public boolean u(int i10, boolean z10) {
        r5.d dVarA = this.f10963b.a(i10);
        if (dVarA == null) {
            return false;
        }
        dVarA.l(z10);
        return true;
    }

    @Override // p5.c
    public int v(r5.a aVar) {
        if (aVar == null || aVar.a() == null || this.f10963b.f(aVar.a()) == null) {
            return 0;
        }
        return aVar.c();
    }

    @Override // p5.c
    public boolean w(int i10) {
        r5.d dVarA = this.f10963b.a(i10);
        return dVarA != null && TextUtils.isEmpty(dVarA.a());
    }

    @Override // p5.c
    public boolean x(String str) {
        return K(str);
    }

    @Override // p5.c
    public String y(String str) {
        return this.f10962a.w(str);
    }

    @Override // p5.c
    public r5.d z(int i10) {
        return this.f10963b.a(i10);
    }
}
