package hc;

import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kc.t;
import kc.w;
import kc.y;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class n implements lc.a {

    /* renamed from: i, reason: collision with root package name */
    public static final Pattern f6926i = Pattern.compile("^[!\"#\\$%&'\\(\\)\\*\\+,\\-\\./:;<=>\\?@\\[\\\\\\]\\^_`\\{\\|\\}~\\p{Pc}\\p{Pd}\\p{Pe}\\p{Pf}\\p{Pi}\\p{Po}\\p{Ps}]");

    /* renamed from: j, reason: collision with root package name */
    public static final Pattern f6927j = Pattern.compile("^(?:<[A-Za-z][A-Za-z0-9-]*(?:\\s+[a-zA-Z_:][a-zA-Z0-9:._-]*(?:\\s*=\\s*(?:[^\"'=<>`\\x00-\\x20]+|'[^']*'|\"[^\"]*\"))?)*\\s*/?>|</[A-Za-z][A-Za-z0-9-]*\\s*[>]|<!---->|<!--(?:-?[^>-])(?:-?[^-])*-->|[<][?].*?[?][>]|<![A-Z]+\\s+[^>]*>|<!\\[CDATA\\[[\\s\\S]*?\\]\\]>)", 2);

    /* renamed from: k, reason: collision with root package name */
    public static final Pattern f6928k = Pattern.compile("^[!\"#$%&'()*+,./:;<=>?@\\[\\\\\\]^_`{|}~-]");

    /* renamed from: l, reason: collision with root package name */
    public static final Pattern f6929l = Pattern.compile("^&(?:#x[a-f0-9]{1,6}|#[0-9]{1,7}|[a-z][a-z0-9]{1,31});", 2);

    /* renamed from: m, reason: collision with root package name */
    public static final Pattern f6930m = Pattern.compile("`+");

    /* renamed from: n, reason: collision with root package name */
    public static final Pattern f6931n = Pattern.compile("^`+");

    /* renamed from: o, reason: collision with root package name */
    public static final Pattern f6932o = Pattern.compile("^<([a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*)>");

    /* renamed from: p, reason: collision with root package name */
    public static final Pattern f6933p = Pattern.compile("^<[a-zA-Z][a-zA-Z0-9.+-]{1,31}:[^<>\u0000- ]*>");

    /* renamed from: q, reason: collision with root package name */
    public static final Pattern f6934q = Pattern.compile("^ *(?:\n *)?");

    /* renamed from: r, reason: collision with root package name */
    public static final Pattern f6935r = Pattern.compile("^[\\p{Zs}\t\r\n\f]");

    /* renamed from: s, reason: collision with root package name */
    public static final Pattern f6936s = Pattern.compile("\\s+");

    /* renamed from: t, reason: collision with root package name */
    public static final Pattern f6937t = Pattern.compile(" *$");

    /* renamed from: a, reason: collision with root package name */
    public final BitSet f6938a;

    /* renamed from: b, reason: collision with root package name */
    public final BitSet f6939b;

    /* renamed from: c, reason: collision with root package name */
    public final Map f6940c;

    /* renamed from: d, reason: collision with root package name */
    public final lc.b f6941d;

    /* renamed from: e, reason: collision with root package name */
    public String f6942e;

    /* renamed from: f, reason: collision with root package name */
    public int f6943f;

    /* renamed from: g, reason: collision with root package name */
    public f f6944g;

    /* renamed from: h, reason: collision with root package name */
    public e f6945h;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f6946a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f6947b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f6948c;

        public a(int i10, boolean z10, boolean z11) {
            this.f6946a = i10;
            this.f6948c = z10;
            this.f6947b = z11;
        }
    }

    public n(lc.b bVar) {
        Map mapF = f(bVar.b());
        this.f6940c = mapF;
        BitSet bitSetE = e(mapF.keySet());
        this.f6939b = bitSetE;
        this.f6938a = g(bitSetE);
        this.f6941d = bVar;
    }

    public static void c(char c10, nc.a aVar, Map map) {
        if (((nc.a) map.put(Character.valueOf(c10), aVar)) == null) {
            return;
        }
        throw new IllegalArgumentException("Delimiter processor conflict with delimiter char '" + c10 + "'");
    }

    public static void d(Iterable iterable, Map map) {
        r rVar;
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            nc.a aVar = (nc.a) it.next();
            char cE = aVar.e();
            char c10 = aVar.c();
            if (cE == c10) {
                nc.a aVar2 = (nc.a) map.get(Character.valueOf(cE));
                if (aVar2 == null || aVar2.e() != aVar2.c()) {
                    c(cE, aVar, map);
                } else {
                    if (aVar2 instanceof r) {
                        rVar = (r) aVar2;
                    } else {
                        r rVar2 = new r(cE);
                        rVar2.f(aVar2);
                        rVar = rVar2;
                    }
                    rVar.f(aVar);
                    map.put(Character.valueOf(cE), rVar);
                }
            } else {
                c(cE, aVar, map);
                c(c10, aVar, map);
            }
        }
    }

    public static BitSet e(Set set) {
        BitSet bitSet = new BitSet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            bitSet.set(((Character) it.next()).charValue());
        }
        return bitSet;
    }

    public static Map f(List list) {
        HashMap map = new HashMap();
        d(Arrays.asList(new ic.a(), new ic.c()), map);
        d(list, map);
        return map;
    }

    public static BitSet g(BitSet bitSet) {
        BitSet bitSet2 = new BitSet();
        bitSet2.or(bitSet);
        bitSet2.set(10);
        bitSet2.set(96);
        bitSet2.set(91);
        bitSet2.set(93);
        bitSet2.set(92);
        bitSet2.set(33);
        bitSet2.set(60);
        bitSet2.set(38);
        return bitSet2;
    }

    public final t A() {
        int i10 = this.f6943f;
        int length = this.f6942e.length();
        while (true) {
            int i11 = this.f6943f;
            if (i11 == length || this.f6938a.get(this.f6942e.charAt(i11))) {
                break;
            }
            this.f6943f++;
        }
        int i12 = this.f6943f;
        if (i10 != i12) {
            return M(this.f6942e, i10, i12);
        }
        return null;
    }

    public final char B() {
        if (this.f6943f < this.f6942e.length()) {
            return this.f6942e.charAt(this.f6943f);
        }
        return (char) 0;
    }

    public final void C(f fVar) {
        boolean z10;
        HashMap map = new HashMap();
        f fVar2 = this.f6944g;
        while (fVar2 != null) {
            f fVar3 = fVar2.f6889e;
            if (fVar3 == fVar) {
                break;
            } else {
                fVar2 = fVar3;
            }
        }
        while (fVar2 != null) {
            char c10 = fVar2.f6886b;
            nc.a aVar = (nc.a) this.f6940c.get(Character.valueOf(c10));
            if (!fVar2.f6888d || aVar == null) {
                fVar2 = fVar2.f6890f;
            } else {
                char cE = aVar.e();
                f fVar4 = fVar2.f6889e;
                int iB = 0;
                boolean z11 = false;
                while (fVar4 != null && fVar4 != fVar && fVar4 != map.get(Character.valueOf(c10))) {
                    if (fVar4.f6887c && fVar4.f6886b == cE) {
                        iB = aVar.b(fVar4, fVar2);
                        z11 = true;
                        if (iB > 0) {
                            z10 = true;
                            break;
                        }
                    }
                    fVar4 = fVar4.f6889e;
                }
                z10 = z11;
                z11 = false;
                if (z11) {
                    y yVar = fVar4.f6885a;
                    y yVar2 = fVar2.f6885a;
                    fVar4.f6891g -= iB;
                    fVar2.f6891g -= iB;
                    yVar.n(yVar.m().substring(0, yVar.m().length() - iB));
                    yVar2.n(yVar2.m().substring(0, yVar2.m().length() - iB));
                    G(fVar4, fVar2);
                    k(yVar, yVar2);
                    aVar.a(yVar, yVar2, iB);
                    if (fVar4.f6891g == 0) {
                        E(fVar4);
                    }
                    if (fVar2.f6891g == 0) {
                        f fVar5 = fVar2.f6890f;
                        E(fVar2);
                        fVar2 = fVar5;
                    }
                } else {
                    if (!z10) {
                        map.put(Character.valueOf(c10), fVar2.f6889e);
                        if (!fVar2.f6887c) {
                            F(fVar2);
                        }
                    }
                    fVar2 = fVar2.f6890f;
                }
            }
        }
        while (true) {
            f fVar6 = this.f6944g;
            if (fVar6 == null || fVar6 == fVar) {
                return;
            } else {
                F(fVar6);
            }
        }
    }

    public final void D(f fVar) {
        f fVar2 = fVar.f6889e;
        if (fVar2 != null) {
            fVar2.f6890f = fVar.f6890f;
        }
        f fVar3 = fVar.f6890f;
        if (fVar3 == null) {
            this.f6944g = fVar2;
        } else {
            fVar3.f6889e = fVar2;
        }
    }

    public final void E(f fVar) {
        fVar.f6885a.l();
        D(fVar);
    }

    public final void F(f fVar) {
        D(fVar);
    }

    public final void G(f fVar, f fVar2) {
        f fVar3 = fVar2.f6889e;
        while (fVar3 != null && fVar3 != fVar) {
            f fVar4 = fVar3.f6889e;
            F(fVar3);
            fVar3 = fVar4;
        }
    }

    public final void H() {
        this.f6945h = this.f6945h.f6881d;
    }

    public void I(String str) {
        this.f6942e = str;
        this.f6943f = 0;
        this.f6944g = null;
        this.f6945h = null;
    }

    public final a J(nc.a aVar, char c10) {
        boolean z10;
        int i10 = this.f6943f;
        boolean z11 = false;
        int i11 = 0;
        while (B() == c10) {
            i11++;
            this.f6943f++;
        }
        if (i11 < aVar.d()) {
            this.f6943f = i10;
            return null;
        }
        String strSubstring = i10 == 0 ? "\n" : this.f6942e.substring(i10 - 1, i10);
        char cB = B();
        String strValueOf = cB != 0 ? String.valueOf(cB) : "\n";
        Pattern pattern = f6926i;
        boolean zMatches = pattern.matcher(strSubstring).matches();
        Pattern pattern2 = f6935r;
        boolean zMatches2 = pattern2.matcher(strSubstring).matches();
        boolean zMatches3 = pattern.matcher(strValueOf).matches();
        boolean zMatches4 = pattern2.matcher(strValueOf).matches();
        boolean z12 = !zMatches4 && (!zMatches3 || zMatches2 || zMatches);
        boolean z13 = !zMatches2 && (!zMatches || zMatches4 || zMatches3);
        if (c10 == '_') {
            z10 = z12 && (!z13 || zMatches);
            if (z13 && (!z12 || zMatches3)) {
                z11 = true;
            }
        } else {
            boolean z14 = z12 && c10 == aVar.e();
            if (z13 && c10 == aVar.c()) {
                z11 = true;
            }
            z10 = z14;
        }
        this.f6943f = i10;
        return new a(i11, z10, z11);
    }

    public final void K() {
        h(f6934q);
    }

    public final y L(String str) {
        return new y(str);
    }

    public final y M(String str, int i10, int i11) {
        return new y(str.substring(i10, i11));
    }

    @Override // lc.a
    public void a(String str, t tVar) {
        I(str.trim());
        t tVarU = null;
        while (true) {
            tVarU = u(tVarU);
            if (tVarU == null) {
                C(null);
                i(tVar);
                return;
            }
            tVar.b(tVarU);
        }
    }

    public final void b(e eVar) {
        e eVar2 = this.f6945h;
        if (eVar2 != null) {
            eVar2.f6884g = true;
        }
        this.f6945h = eVar;
    }

    public final String h(Pattern pattern) {
        if (this.f6943f >= this.f6942e.length()) {
            return null;
        }
        Matcher matcher = pattern.matcher(this.f6942e);
        matcher.region(this.f6943f, this.f6942e.length());
        if (!matcher.find()) {
            return null;
        }
        this.f6943f = matcher.end();
        return matcher.group();
    }

    public final void i(t tVar) {
        if (tVar.c() == tVar.d()) {
            return;
        }
        l(tVar.c(), tVar.d());
    }

    public final void j(y yVar, y yVar2, int i10) {
        if (yVar == null || yVar2 == null || yVar == yVar2) {
            return;
        }
        StringBuilder sb2 = new StringBuilder(i10);
        sb2.append(yVar.m());
        t tVarE = yVar.e();
        t tVarE2 = yVar2.e();
        while (tVarE != tVarE2) {
            sb2.append(((y) tVarE).m());
            t tVarE3 = tVarE.e();
            tVarE.l();
            tVarE = tVarE3;
        }
        yVar.n(sb2.toString());
    }

    public final void k(t tVar, t tVar2) {
        if (tVar == tVar2 || tVar.e() == tVar2) {
            return;
        }
        l(tVar.e(), tVar2.g());
    }

    public final void l(t tVar, t tVar2) {
        y yVar = null;
        y yVar2 = null;
        int length = 0;
        while (tVar != null) {
            if (tVar instanceof y) {
                yVar2 = (y) tVar;
                if (yVar == null) {
                    yVar = yVar2;
                }
                length += yVar2.m().length();
            } else {
                j(yVar, yVar2, length);
                yVar = null;
                yVar2 = null;
                length = 0;
            }
            if (tVar == tVar2) {
                break;
            } else {
                tVar = tVar.e();
            }
        }
        j(yVar, yVar2, length);
    }

    public final t m() {
        String strH = h(f6932o);
        if (strH != null) {
            String strSubstring = strH.substring(1, strH.length() - 1);
            kc.p pVar = new kc.p("mailto:" + strSubstring, null);
            pVar.b(new y(strSubstring));
            return pVar;
        }
        String strH2 = h(f6933p);
        if (strH2 == null) {
            return null;
        }
        String strSubstring2 = strH2.substring(1, strH2.length() - 1);
        kc.p pVar2 = new kc.p(strSubstring2, null);
        pVar2.b(new y(strSubstring2));
        return pVar2;
    }

    public final t n() {
        this.f6943f++;
        if (B() == '\n') {
            kc.j jVar = new kc.j();
            this.f6943f++;
            return jVar;
        }
        if (this.f6943f < this.f6942e.length()) {
            Pattern pattern = f6928k;
            String str = this.f6942e;
            int i10 = this.f6943f;
            if (pattern.matcher(str.substring(i10, i10 + 1)).matches()) {
                String str2 = this.f6942e;
                int i11 = this.f6943f;
                y yVarM = M(str2, i11, i11 + 1);
                this.f6943f++;
                return yVarM;
            }
        }
        return L("\\");
    }

    public final t o() {
        String strH;
        String strH2 = h(f6931n);
        if (strH2 == null) {
            return null;
        }
        int i10 = this.f6943f;
        do {
            strH = h(f6930m);
            if (strH == null) {
                this.f6943f = i10;
                return L(strH2);
            }
        } while (!strH.equals(strH2));
        kc.d dVar = new kc.d();
        String strReplace = this.f6942e.substring(i10, this.f6943f - strH2.length()).replace('\n', ' ');
        if (strReplace.length() >= 3 && strReplace.charAt(0) == ' ' && strReplace.charAt(strReplace.length() - 1) == ' ' && jc.d.e(strReplace)) {
            strReplace = strReplace.substring(1, strReplace.length() - 1);
        }
        dVar.n(strReplace);
        return dVar;
    }

    public final t p() {
        int i10 = this.f6943f;
        this.f6943f = i10 + 1;
        if (B() != '[') {
            return L("!");
        }
        this.f6943f++;
        y yVarL = L("![");
        b(e.a(yVarL, i10 + 1, this.f6945h, this.f6944g));
        return yVarL;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final t q() {
        String strM;
        String strO;
        boolean z10;
        boolean z11 = true;
        int i10 = this.f6943f + 1;
        this.f6943f = i10;
        e eVar = this.f6945h;
        if (eVar == null) {
            return L("]");
        }
        if (!eVar.f6883f) {
            H();
            return L("]");
        }
        String strSubstring = null;
        if (B() == '(') {
            this.f6943f++;
            K();
            strM = v();
            if (strM != null) {
                K();
                Pattern pattern = f6936s;
                String str = this.f6942e;
                int i11 = this.f6943f;
                if (pattern.matcher(str.substring(i11 - 1, i11)).matches()) {
                    strO = x();
                    K();
                } else {
                    strO = null;
                }
                if (B() == ')') {
                    this.f6943f++;
                    z10 = true;
                    if (z10) {
                        int i12 = this.f6943f;
                        w();
                        int i13 = this.f6943f - i12;
                        if (i13 > 2) {
                            strSubstring = this.f6942e.substring(i12, i13 + i12);
                        } else if (!eVar.f6884g) {
                            strSubstring = this.f6942e.substring(eVar.f6879b, i10);
                        }
                        if (strSubstring != null) {
                            kc.q qVarA = this.f6941d.a(jc.a.c(strSubstring));
                            if (qVarA != null) {
                                strM = qVarA.m();
                                strO = qVarA.o();
                            } else {
                                z11 = z10;
                            }
                        }
                    }
                    if (z11) {
                        this.f6943f = i10;
                        H();
                        return L("]");
                    }
                    t nVar = eVar.f6880c ? new kc.n(strM, strO) : new kc.p(strM, strO);
                    t tVarE = eVar.f6878a.e();
                    while (tVarE != null) {
                        t tVarE2 = tVarE.e();
                        nVar.b(tVarE);
                        tVarE = tVarE2;
                    }
                    C(eVar.f6882e);
                    i(nVar);
                    eVar.f6878a.l();
                    H();
                    if (!eVar.f6880c) {
                        for (e eVar2 = this.f6945h; eVar2 != null; eVar2 = eVar2.f6881d) {
                            if (!eVar2.f6880c) {
                                eVar2.f6883f = false;
                            }
                        }
                    }
                    return nVar;
                }
                this.f6943f = i10;
            } else {
                strO = null;
            }
        } else {
            strM = null;
            strO = null;
        }
        z10 = false;
        if (z10) {
        }
        if (z11) {
        }
    }

    public final t r(nc.a aVar, char c10) {
        a aVarJ = J(aVar, c10);
        if (aVarJ == null) {
            return null;
        }
        int i10 = aVarJ.f6946a;
        int i11 = this.f6943f;
        int i12 = i11 + i10;
        this.f6943f = i12;
        y yVarM = M(this.f6942e, i11, i12);
        f fVar = new f(yVarM, c10, aVarJ.f6948c, aVarJ.f6947b, this.f6944g);
        this.f6944g = fVar;
        fVar.f6891g = i10;
        fVar.f6892h = i10;
        f fVar2 = fVar.f6889e;
        if (fVar2 != null) {
            fVar2.f6890f = fVar;
        }
        return yVarM;
    }

    public final t s() {
        String strH = h(f6929l);
        if (strH != null) {
            return L(jc.b.a(strH));
        }
        return null;
    }

    public final t t() {
        String strH = h(f6927j);
        if (strH == null) {
            return null;
        }
        kc.m mVar = new kc.m();
        mVar.m(strH);
        return mVar;
    }

    public final t u(t tVar) {
        t tVarY;
        char cB = B();
        if (cB == 0) {
            return null;
        }
        if (cB == '\n') {
            tVarY = y(tVar);
        } else if (cB == '!') {
            tVarY = p();
        } else if (cB == '&') {
            tVarY = s();
        } else if (cB == '<') {
            tVarY = m();
            if (tVarY == null) {
                tVarY = t();
            }
        } else if (cB != '`') {
            switch (cB) {
                case '[':
                    tVarY = z();
                    break;
                case ModuleDescriptor.MODULE_VERSION /* 92 */:
                    tVarY = n();
                    break;
                case ']':
                    tVarY = q();
                    break;
                default:
                    if (!this.f6939b.get(cB)) {
                        tVarY = A();
                        break;
                    } else {
                        tVarY = r((nc.a) this.f6940c.get(Character.valueOf(cB)), cB);
                        break;
                    }
            }
        } else {
            tVarY = o();
        }
        if (tVarY != null) {
            return tVarY;
        }
        this.f6943f++;
        return L(String.valueOf(cB));
    }

    public final String v() {
        int iA = jc.c.a(this.f6942e, this.f6943f);
        if (iA == -1) {
            return null;
        }
        String strSubstring = B() == '<' ? this.f6942e.substring(this.f6943f + 1, iA - 1) : this.f6942e.substring(this.f6943f, iA);
        this.f6943f = iA;
        return jc.a.e(strSubstring);
    }

    public int w() {
        if (this.f6943f < this.f6942e.length() && this.f6942e.charAt(this.f6943f) == '[') {
            int i10 = this.f6943f + 1;
            int iC = jc.c.c(this.f6942e, i10);
            int i11 = iC - i10;
            if (iC != -1 && i11 <= 999 && iC < this.f6942e.length() && this.f6942e.charAt(iC) == ']') {
                this.f6943f = iC + 1;
                return i11 + 2;
            }
        }
        return 0;
    }

    public final String x() {
        int iD = jc.c.d(this.f6942e, this.f6943f);
        if (iD == -1) {
            return null;
        }
        String strSubstring = this.f6942e.substring(this.f6943f + 1, iD - 1);
        this.f6943f = iD;
        return jc.a.e(strSubstring);
    }

    public final t y(t tVar) {
        this.f6943f++;
        if (tVar instanceof y) {
            y yVar = (y) tVar;
            if (yVar.m().endsWith(" ")) {
                String strM = yVar.m();
                Matcher matcher = f6937t.matcher(strM);
                int iEnd = matcher.find() ? matcher.end() - matcher.start() : 0;
                if (iEnd > 0) {
                    yVar.n(strM.substring(0, strM.length() - iEnd));
                }
                return iEnd >= 2 ? new kc.j() : new w();
            }
        }
        return new w();
    }

    public final t z() {
        int i10 = this.f6943f;
        this.f6943f = i10 + 1;
        y yVarL = L("[");
        b(e.b(yVarL, i10, this.f6945h, this.f6944g));
        return yVarL;
    }
}
