package okhttp3;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class r {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final char[] f11312j = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11313a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f11314b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f11315c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f11316d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f11317e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List f11318f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List f11319g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f11320h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f11321i;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f11322a;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f11325d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final List f11327f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public List f11328g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f11329h;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f11323b = "";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f11324c = "";

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f11326e = -1;

        public a() {
            ArrayList arrayList = new ArrayList();
            this.f11327f = arrayList;
            arrayList.add("");
        }

        public static String c(String str, int i10, int i11) {
            return ub.c.d(r.s(str, i10, i11, false));
        }

        public static int k(String str, int i10, int i11) {
            try {
                int i12 = Integer.parseInt(r.a(str, i10, i11, "", false, false, false, true, null));
                if (i12 <= 0 || i12 > 65535) {
                    return -1;
                }
                return i12;
            } catch (NumberFormatException unused) {
            }
        }

        public static int n(String str, int i10, int i11) {
            while (i10 < i11) {
                char cCharAt = str.charAt(i10);
                if (cCharAt == ':') {
                    return i10;
                }
                if (cCharAt == '[') {
                    do {
                        i10++;
                        if (i10 >= i11) {
                            break;
                        }
                    } while (str.charAt(i10) != ']');
                }
                i10++;
            }
            return i11;
        }

        public static int u(String str, int i10, int i11) {
            if (i11 - i10 < 2) {
                return -1;
            }
            char cCharAt = str.charAt(i10);
            if ((cCharAt >= 'a' && cCharAt <= 'z') || (cCharAt >= 'A' && cCharAt <= 'Z')) {
                while (true) {
                    i10++;
                    if (i10 >= i11) {
                        break;
                    }
                    char cCharAt2 = str.charAt(i10);
                    if (cCharAt2 < 'a' || cCharAt2 > 'z') {
                        if (cCharAt2 < 'A' || cCharAt2 > 'Z') {
                            if (cCharAt2 < '0' || cCharAt2 > '9') {
                                if (cCharAt2 != '+' && cCharAt2 != '-' && cCharAt2 != '.') {
                                    if (cCharAt2 == ':') {
                                        return i10;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return -1;
        }

        public static int w(String str, int i10, int i11) {
            int i12 = 0;
            while (i10 < i11) {
                char cCharAt = str.charAt(i10);
                if (cCharAt != '\\' && cCharAt != '/') {
                    break;
                }
                i12++;
                i10++;
            }
            return i12;
        }

        public a a(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("name == null");
            }
            if (this.f11328g == null) {
                this.f11328g = new ArrayList();
            }
            this.f11328g.add(r.b(str, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, true));
            this.f11328g.add(str2 != null ? r.b(str2, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, true) : null);
            return this;
        }

        public r b() {
            if (this.f11322a == null) {
                throw new IllegalStateException("scheme == null");
            }
            if (this.f11325d != null) {
                return new r(this);
            }
            throw new IllegalStateException("host == null");
        }

        public int d() {
            int i10 = this.f11326e;
            return i10 != -1 ? i10 : r.d(this.f11322a);
        }

        public a e(String str) {
            this.f11328g = str != null ? r.z(r.b(str, " \"'<>#", true, false, true, true)) : null;
            return this;
        }

        public a f(String str) {
            this.f11329h = str != null ? r.b(str, "", false, false, false, false) : null;
            return this;
        }

        public a g(String str) {
            if (str == null) {
                throw new NullPointerException("host == null");
            }
            String strC = c(str, 0, str.length());
            if (strC != null) {
                this.f11325d = strC;
                return this;
            }
            throw new IllegalArgumentException("unexpected host: " + str);
        }

        public final boolean h(String str) {
            return str.equals(".") || str.equalsIgnoreCase("%2e");
        }

        public final boolean i(String str) {
            return str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        public a j(r rVar, String str) {
            int iO;
            String str2;
            int i10;
            String str3;
            String str4 = str;
            int iE = ub.c.E(str4, 0, str4.length());
            int iF = ub.c.F(str4, iE, str4.length());
            int iU = u(str4, iE, iF);
            if (iU != -1) {
                if (str4.regionMatches(true, iE, "https:", 0, 6)) {
                    this.f11322a = "https";
                    iE += 6;
                    str4 = str;
                } else {
                    str4 = str;
                    if (!str4.regionMatches(true, iE, "http:", 0, 5)) {
                        throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but was '" + str4.substring(0, iU) + "'");
                    }
                    this.f11322a = "http";
                    iE += 5;
                }
            } else {
                if (rVar == null) {
                    throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
                }
                this.f11322a = rVar.f11313a;
            }
            int iW = w(str4, iE, iF);
            char c10 = '#';
            if (iW >= 2 || rVar == null || !rVar.f11313a.equals(this.f11322a)) {
                int i11 = iE + iW;
                boolean z10 = false;
                boolean z11 = false;
                while (true) {
                    iO = ub.c.o(str4, i11, iF, "@/\\?#");
                    byte bCharAt = iO != iF ? str4.charAt(iO) : (byte) -1;
                    if (bCharAt == -1 || bCharAt == c10 || bCharAt == 47 || bCharAt == 92 || bCharAt == 63) {
                        break;
                    }
                    if (bCharAt != 64) {
                        str3 = str4;
                    } else {
                        if (z10) {
                            i10 = iO;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(this.f11324c);
                            sb2.append("%40");
                            str3 = str;
                            sb2.append(r.a(str3, i11, i10, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null));
                            this.f11324c = sb2.toString();
                        } else {
                            int iN = ub.c.n(str4, i11, iO, ':');
                            String strA = r.a(str, i11, iN, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                            if (z11) {
                                strA = this.f11323b + "%40" + strA;
                            }
                            this.f11323b = strA;
                            if (iN != iO) {
                                i10 = iO;
                                this.f11324c = r.a(str, iN + 1, i10, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                z10 = true;
                            } else {
                                i10 = iO;
                            }
                            str3 = str;
                            z11 = true;
                        }
                        i11 = i10 + 1;
                    }
                    str4 = str3;
                    c10 = '#';
                }
                str2 = str4;
                int i12 = i11;
                int iN2 = n(str2, i12, iO);
                int i13 = iN2 + 1;
                if (i13 < iO) {
                    this.f11325d = c(str2, i12, iN2);
                    int iK = k(str2, i13, iO);
                    this.f11326e = iK;
                    if (iK == -1) {
                        throw new IllegalArgumentException("Invalid URL port: \"" + str2.substring(i13, iO) + '\"');
                    }
                } else {
                    this.f11325d = c(str2, i12, iN2);
                    this.f11326e = r.d(this.f11322a);
                }
                if (this.f11325d == null) {
                    throw new IllegalArgumentException("Invalid URL host: \"" + str2.substring(i12, iN2) + '\"');
                }
                iE = iO;
            } else {
                this.f11323b = rVar.j();
                this.f11324c = rVar.f();
                this.f11325d = rVar.f11316d;
                this.f11326e = rVar.f11317e;
                this.f11327f.clear();
                this.f11327f.addAll(rVar.h());
                if (iE == iF || str4.charAt(iE) == '#') {
                    e(rVar.i());
                }
                str2 = str4;
            }
            int iO2 = ub.c.o(str2, iE, iF, "?#");
            s(str2, iE, iO2);
            if (iO2 < iF && str2.charAt(iO2) == '?') {
                int iN3 = ub.c.n(str2, iO2, iF, '#');
                this.f11328g = r.z(r.a(str2, iO2 + 1, iN3, " \"'<>#", true, false, true, true, null));
                iO2 = iN3;
            }
            if (iO2 < iF && str2.charAt(iO2) == '#') {
                this.f11329h = r.a(str2, iO2 + 1, iF, "", true, false, false, false, null);
            }
            return this;
        }

        public final void l() {
            List list = this.f11327f;
            if (!((String) list.remove(list.size() - 1)).isEmpty() || this.f11327f.isEmpty()) {
                this.f11327f.add("");
            } else {
                List list2 = this.f11327f;
                list2.set(list2.size() - 1, "");
            }
        }

        public a m(int i10) {
            if (i10 > 0 && i10 <= 65535) {
                this.f11326e = i10;
                return this;
            }
            throw new IllegalArgumentException("unexpected port: " + i10);
        }

        public final void o(String str, int i10, int i11, boolean z10, boolean z11) {
            String strA = r.a(str, i10, i11, " \"<>^`{}|/\\?#", z11, false, false, true, null);
            if (h(strA)) {
                return;
            }
            if (i(strA)) {
                l();
                return;
            }
            List list = this.f11327f;
            if (((String) list.get(list.size() - 1)).isEmpty()) {
                List list2 = this.f11327f;
                list2.set(list2.size() - 1, strA);
            } else {
                this.f11327f.add(strA);
            }
            if (z10) {
                this.f11327f.add("");
            }
        }

        public a p() {
            int size = this.f11327f.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.f11327f.set(i10, r.b((String) this.f11327f.get(i10), "[]", true, true, false, true));
            }
            List list = this.f11328g;
            if (list != null) {
                int size2 = list.size();
                for (int i11 = 0; i11 < size2; i11++) {
                    String str = (String) this.f11328g.get(i11);
                    if (str != null) {
                        this.f11328g.set(i11, r.b(str, "\\^`{|}", true, true, true, true));
                    }
                }
            }
            String str2 = this.f11329h;
            if (str2 != null) {
                this.f11329h = r.b(str2, " \"#<>\\^`{|}", true, true, false, false);
            }
            return this;
        }

        public final void q(String str) {
            for (int size = this.f11328g.size() - 2; size >= 0; size -= 2) {
                if (str.equals(this.f11328g.get(size))) {
                    this.f11328g.remove(size + 1);
                    this.f11328g.remove(size);
                    if (this.f11328g.isEmpty()) {
                        this.f11328g = null;
                        return;
                    }
                }
            }
        }

        public a r(String str) {
            if (str == null) {
                throw new NullPointerException("name == null");
            }
            if (this.f11328g == null) {
                return this;
            }
            q(r.b(str, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, true));
            return this;
        }

        public final void s(String str, int i10, int i11) {
            if (i10 == i11) {
                return;
            }
            char cCharAt = str.charAt(i10);
            if (cCharAt == '/' || cCharAt == '\\') {
                this.f11327f.clear();
                this.f11327f.add("");
                i10++;
            } else {
                List list = this.f11327f;
                list.set(list.size() - 1, "");
            }
            int i12 = i10;
            while (i12 < i11) {
                int iO = ub.c.o(str, i12, i11, "/\\");
                boolean z10 = iO < i11;
                String str2 = str;
                o(str2, i12, iO, z10, true);
                if (z10) {
                    iO++;
                }
                i12 = iO;
                str = str2;
            }
        }

        public a t(String str) {
            if (str == null) {
                throw new NullPointerException("scheme == null");
            }
            if (str.equalsIgnoreCase("http")) {
                this.f11322a = "http";
                return this;
            }
            if (str.equalsIgnoreCase("https")) {
                this.f11322a = "https";
                return this;
            }
            throw new IllegalArgumentException("unexpected scheme: " + str);
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            String str = this.f11322a;
            if (str != null) {
                sb2.append(str);
                sb2.append("://");
            } else {
                sb2.append("//");
            }
            if (!this.f11323b.isEmpty() || !this.f11324c.isEmpty()) {
                sb2.append(this.f11323b);
                if (!this.f11324c.isEmpty()) {
                    sb2.append(':');
                    sb2.append(this.f11324c);
                }
                sb2.append('@');
            }
            String str2 = this.f11325d;
            if (str2 != null) {
                if (str2.indexOf(58) != -1) {
                    sb2.append('[');
                    sb2.append(this.f11325d);
                    sb2.append(']');
                } else {
                    sb2.append(this.f11325d);
                }
            }
            if (this.f11326e != -1 || this.f11322a != null) {
                int iD = d();
                String str3 = this.f11322a;
                if (str3 == null || iD != r.d(str3)) {
                    sb2.append(':');
                    sb2.append(iD);
                }
            }
            r.r(sb2, this.f11327f);
            if (this.f11328g != null) {
                sb2.append('?');
                r.n(sb2, this.f11328g);
            }
            if (this.f11329h != null) {
                sb2.append('#');
                sb2.append(this.f11329h);
            }
            return sb2.toString();
        }

        public a v(String str, String str2) {
            r(str);
            a(str, str2);
            return this;
        }
    }

    public r(a aVar) {
        this.f11313a = aVar.f11322a;
        this.f11314b = t(aVar.f11323b, false);
        this.f11315c = t(aVar.f11324c, false);
        this.f11316d = aVar.f11325d;
        this.f11317e = aVar.d();
        this.f11318f = u(aVar.f11327f, false);
        List list = aVar.f11328g;
        this.f11319g = list != null ? u(list, true) : null;
        String str = aVar.f11329h;
        this.f11320h = str != null ? t(str, false) : null;
        this.f11321i = aVar.toString();
    }

    public static String a(String str, int i10, int i11, String str2, boolean z10, boolean z11, boolean z12, boolean z13, Charset charset) {
        int iCharCount = i10;
        while (iCharCount < i11) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (iCodePointAt < 32 || iCodePointAt == 127 || ((iCodePointAt >= 128 && z13) || str2.indexOf(iCodePointAt) != -1 || ((iCodePointAt == 37 && (!z10 || (z11 && !w(str, iCharCount, i11)))) || (iCodePointAt == 43 && z12)))) {
                okio.c cVar = new okio.c();
                cVar.g0(str, i10, iCharCount);
                c(cVar, str, iCharCount, i11, str2, z10, z11, z12, z13, charset);
                return cVar.q();
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
        return str.substring(i10, i11);
    }

    public static String b(String str, String str2, boolean z10, boolean z11, boolean z12, boolean z13) {
        return a(str, 0, str.length(), str2, z10, z11, z12, z13, null);
    }

    public static void c(okio.c cVar, String str, int i10, int i11, String str2, boolean z10, boolean z11, boolean z12, boolean z13, Charset charset) {
        okio.c cVar2 = null;
        while (i10 < i11) {
            int iCodePointAt = str.codePointAt(i10);
            if (!z10 || (iCodePointAt != 9 && iCodePointAt != 10 && iCodePointAt != 12 && iCodePointAt != 13)) {
                if (iCodePointAt == 43 && z12) {
                    cVar.H(z10 ? "+" : "%2B");
                } else if (iCodePointAt < 32 || iCodePointAt == 127 || ((iCodePointAt >= 128 && z13) || str2.indexOf(iCodePointAt) != -1 || (iCodePointAt == 37 && (!z10 || (z11 && !w(str, i10, i11)))))) {
                    if (cVar2 == null) {
                        cVar2 = new okio.c();
                    }
                    if (charset == null || charset.equals(ub.c.f12954j)) {
                        cVar2.h0(iCodePointAt);
                    } else {
                        cVar2.e0(str, i10, Character.charCount(iCodePointAt) + i10, charset);
                    }
                    while (!cVar2.C()) {
                        byte b10 = cVar2.readByte();
                        cVar.writeByte(37);
                        char[] cArr = f11312j;
                        cVar.writeByte(cArr[((b10 & 255) >> 4) & 15]);
                        cVar.writeByte(cArr[b10 & 15]);
                    }
                } else {
                    cVar.h0(iCodePointAt);
                }
            }
            i10 += Character.charCount(iCodePointAt);
        }
    }

    public static int d(String str) {
        if (str.equals("http")) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    public static r k(String str) {
        return new a().j(null, str).b();
    }

    public static void n(StringBuilder sb2, List list) {
        int size = list.size();
        for (int i10 = 0; i10 < size; i10 += 2) {
            String str = (String) list.get(i10);
            String str2 = (String) list.get(i10 + 1);
            if (i10 > 0) {
                sb2.append('&');
            }
            sb2.append(str);
            if (str2 != null) {
                sb2.append('=');
                sb2.append(str2);
            }
        }
    }

    public static r q(String str) {
        try {
            return k(str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static void r(StringBuilder sb2, List list) {
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            sb2.append('/');
            sb2.append((String) list.get(i10));
        }
    }

    public static String s(String str, int i10, int i11, boolean z10) {
        for (int i12 = i10; i12 < i11; i12++) {
            char cCharAt = str.charAt(i12);
            if (cCharAt == '%' || (cCharAt == '+' && z10)) {
                okio.c cVar = new okio.c();
                cVar.g0(str, i10, i12);
                v(cVar, str, i12, i11, z10);
                return cVar.q();
            }
        }
        return str.substring(i10, i11);
    }

    public static String t(String str, boolean z10) {
        return s(str, 0, str.length(), z10);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0039  */
    public static void v(okio.c cVar, String str, int i10, int i11, boolean z10) {
        int i12;
        while (i10 < i11) {
            int iCodePointAt = str.codePointAt(i10);
            if (iCodePointAt == 37 && (i12 = i10 + 2) < i11) {
                int iK = ub.c.k(str.charAt(i10 + 1));
                int iK2 = ub.c.k(str.charAt(i12));
                if (iK == -1 || iK2 == -1) {
                    cVar.h0(iCodePointAt);
                } else {
                    cVar.writeByte((iK << 4) + iK2);
                    i10 = i12;
                }
            } else if (iCodePointAt == 43 && z10) {
                cVar.writeByte(32);
            } else {
                cVar.h0(iCodePointAt);
            }
            i10 += Character.charCount(iCodePointAt);
        }
    }

    public static boolean w(String str, int i10, int i11) {
        int i12 = i10 + 2;
        return i12 < i11 && str.charAt(i10) == '%' && ub.c.k(str.charAt(i10 + 1)) != -1 && ub.c.k(str.charAt(i12)) != -1;
    }

    public static List z(String str) {
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        while (i10 <= str.length()) {
            int iIndexOf = str.indexOf(38, i10);
            if (iIndexOf == -1) {
                iIndexOf = str.length();
            }
            int iIndexOf2 = str.indexOf(61, i10);
            if (iIndexOf2 == -1 || iIndexOf2 > iIndexOf) {
                arrayList.add(str.substring(i10, iIndexOf));
                arrayList.add(null);
            } else {
                arrayList.add(str.substring(i10, iIndexOf2));
                arrayList.add(str.substring(iIndexOf2 + 1, iIndexOf));
            }
            i10 = iIndexOf + 1;
        }
        return arrayList;
    }

    public r A(String str) {
        a aVarP = p(str);
        if (aVarP != null) {
            return aVarP.b();
        }
        return null;
    }

    public String B() {
        return this.f11313a;
    }

    public String C() {
        if (ub.c.J(this.f11316d)) {
            return null;
        }
        return PublicSuffixDatabase.c().d(this.f11316d);
    }

    public URI D() {
        String string = o().p().toString();
        try {
            return new URI(string);
        } catch (URISyntaxException e10) {
            try {
                return URI.create(string.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
            } catch (Exception unused) {
                throw new RuntimeException(e10);
            }
        }
    }

    public String e() {
        if (this.f11320h == null) {
            return null;
        }
        return this.f11321i.substring(this.f11321i.indexOf(35) + 1);
    }

    public boolean equals(Object obj) {
        return (obj instanceof r) && ((r) obj).f11321i.equals(this.f11321i);
    }

    public String f() {
        if (this.f11315c.isEmpty()) {
            return "";
        }
        return this.f11321i.substring(this.f11321i.indexOf(58, this.f11313a.length() + 3) + 1, this.f11321i.indexOf(64));
    }

    public String g() {
        int iIndexOf = this.f11321i.indexOf(47, this.f11313a.length() + 3);
        String str = this.f11321i;
        return this.f11321i.substring(iIndexOf, ub.c.o(str, iIndexOf, str.length(), "?#"));
    }

    public List h() {
        int iIndexOf = this.f11321i.indexOf(47, this.f11313a.length() + 3);
        String str = this.f11321i;
        int iO = ub.c.o(str, iIndexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (iIndexOf < iO) {
            int i10 = iIndexOf + 1;
            int iN = ub.c.n(this.f11321i, i10, iO, '/');
            arrayList.add(this.f11321i.substring(i10, iN));
            iIndexOf = iN;
        }
        return arrayList;
    }

    public int hashCode() {
        return this.f11321i.hashCode();
    }

    public String i() {
        if (this.f11319g == null) {
            return null;
        }
        int iIndexOf = this.f11321i.indexOf(63) + 1;
        String str = this.f11321i;
        return this.f11321i.substring(iIndexOf, ub.c.n(str, iIndexOf, str.length(), '#'));
    }

    public String j() {
        if (this.f11314b.isEmpty()) {
            return "";
        }
        int length = this.f11313a.length() + 3;
        String str = this.f11321i;
        return this.f11321i.substring(length, ub.c.o(str, length, str.length(), ":@"));
    }

    public String l() {
        return this.f11316d;
    }

    public boolean m() {
        return this.f11313a.equals("https");
    }

    public a o() {
        a aVar = new a();
        aVar.f11322a = this.f11313a;
        aVar.f11323b = j();
        aVar.f11324c = f();
        aVar.f11325d = this.f11316d;
        aVar.f11326e = this.f11317e != d(this.f11313a) ? this.f11317e : -1;
        aVar.f11327f.clear();
        aVar.f11327f.addAll(h());
        aVar.e(i());
        aVar.f11329h = e();
        return aVar;
    }

    public a p(String str) {
        try {
            return new a().j(this, str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public String toString() {
        return this.f11321i;
    }

    public final List u(List list, boolean z10) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i10 = 0; i10 < size; i10++) {
            String str = (String) list.get(i10);
            arrayList.add(str != null ? t(str, z10) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    public int x() {
        return this.f11317e;
    }

    public String y() {
        if (this.f11319g == null) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        n(sb2, this.f11319g);
        return sb2.toString();
    }
}
