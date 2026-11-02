package okhttp3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class j {

    /* renamed from: j, reason: collision with root package name */
    public static final Pattern f10667j = Pattern.compile("(\\d{2,4})[^\\d]*");

    /* renamed from: k, reason: collision with root package name */
    public static final Pattern f10668k = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");

    /* renamed from: l, reason: collision with root package name */
    public static final Pattern f10669l = Pattern.compile("(\\d{1,2})[^\\d]*");

    /* renamed from: m, reason: collision with root package name */
    public static final Pattern f10670m = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* renamed from: a, reason: collision with root package name */
    public final String f10671a;

    /* renamed from: b, reason: collision with root package name */
    public final String f10672b;

    /* renamed from: c, reason: collision with root package name */
    public final long f10673c;

    /* renamed from: d, reason: collision with root package name */
    public final String f10674d;

    /* renamed from: e, reason: collision with root package name */
    public final String f10675e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f10676f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f10677g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f10678h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f10679i;

    public j(String str, String str2, long j10, String str3, String str4, boolean z10, boolean z11, boolean z12, boolean z13) {
        this.f10671a = str;
        this.f10672b = str2;
        this.f10673c = j10;
        this.f10674d = str3;
        this.f10675e = str4;
        this.f10676f = z10;
        this.f10677g = z11;
        this.f10679i = z12;
        this.f10678h = z13;
    }

    public static int a(String str, int i10, int i11, boolean z10) {
        while (i10 < i11) {
            char cCharAt = str.charAt(i10);
            if (((cCharAt < ' ' && cCharAt != '\t') || cCharAt >= '\u007f' || (cCharAt >= '0' && cCharAt <= '9') || ((cCharAt >= 'a' && cCharAt <= 'z') || ((cCharAt >= 'A' && cCharAt <= 'Z') || cCharAt == ':'))) == (!z10)) {
                return i10;
            }
            i10++;
        }
        return i11;
    }

    public static boolean b(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        return str.endsWith(str2) && str.charAt((str.length() - str2.length()) - 1) == '.' && !ub.c.J(str);
    }

    public static j d(long j10, r rVar, String str) throws NumberFormatException {
        long j11;
        String str2;
        int length = str.length();
        char c10 = ';';
        int iN = ub.c.n(str, 0, length, ';');
        int iN2 = ub.c.n(str, 0, iN, '=');
        String strG = null;
        if (iN2 == iN) {
            return null;
        }
        String strI = ub.c.I(str, 0, iN2);
        if (strI.isEmpty() || ub.c.x(strI) != -1) {
            return null;
        }
        String strI2 = ub.c.I(str, iN2 + 1, iN);
        if (ub.c.x(strI2) != -1) {
            return null;
        }
        int i10 = iN + 1;
        String strSubstring = null;
        long jH = 253402300799999L;
        long jI = -1;
        boolean z10 = false;
        boolean z11 = false;
        boolean z12 = true;
        boolean z13 = false;
        while (i10 < length) {
            int iN3 = ub.c.n(str, i10, length, c10);
            int iN4 = ub.c.n(str, i10, iN3, '=');
            String strI3 = ub.c.I(str, i10, iN4);
            String strI4 = iN4 < iN3 ? ub.c.I(str, iN4 + 1, iN3) : "";
            if (strI3.equalsIgnoreCase("expires")) {
                try {
                    jH = h(strI4, 0, strI4.length());
                    z13 = true;
                } catch (NumberFormatException | IllegalArgumentException unused) {
                }
            } else if (strI3.equalsIgnoreCase("max-age")) {
                jI = i(strI4);
                z13 = true;
            } else if (strI3.equalsIgnoreCase("domain")) {
                strG = g(strI4);
                z12 = false;
            } else if (strI3.equalsIgnoreCase("path")) {
                strSubstring = strI4;
            } else if (strI3.equalsIgnoreCase("secure")) {
                z10 = true;
            } else if (strI3.equalsIgnoreCase("httponly")) {
                z11 = true;
            }
            i10 = iN3 + 1;
            c10 = ';';
        }
        if (jI == Long.MIN_VALUE) {
            j11 = Long.MIN_VALUE;
        } else if (jI != -1) {
            long j12 = j10 + (jI <= 9223372036854775L ? jI * 1000 : Long.MAX_VALUE);
            j11 = (j12 < j10 || j12 > 253402300799999L) ? 253402300799999L : j12;
        } else {
            j11 = jH;
        }
        String strL = rVar.l();
        if (strG == null) {
            str2 = strL;
        } else {
            if (!b(strL, strG)) {
                return null;
            }
            str2 = strG;
        }
        if (strL.length() != str2.length() && PublicSuffixDatabase.c().d(str2) == null) {
            return null;
        }
        if (strSubstring == null || !strSubstring.startsWith("/")) {
            String strG2 = rVar.g();
            int iLastIndexOf = strG2.lastIndexOf(47);
            strSubstring = iLastIndexOf != 0 ? strG2.substring(0, iLastIndexOf) : "/";
        }
        return new j(strI, strI2, j11, str2, strSubstring, z10, z11, z12, z13);
    }

    public static j e(r rVar, String str) {
        return d(System.currentTimeMillis(), rVar, str);
    }

    public static List f(r rVar, q qVar) {
        List listL = qVar.l("Set-Cookie");
        int size = listL.size();
        ArrayList arrayList = null;
        for (int i10 = 0; i10 < size; i10++) {
            j jVarE = e(rVar, (String) listL.get(i10));
            if (jVarE != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(jVarE);
            }
        }
        return arrayList != null ? Collections.unmodifiableList(arrayList) : Collections.EMPTY_LIST;
    }

    public static String g(String str) {
        if (str.endsWith(".")) {
            throw new IllegalArgumentException();
        }
        if (str.startsWith(".")) {
            str = str.substring(1);
        }
        String strD = ub.c.d(str);
        if (strD != null) {
            return strD;
        }
        throw new IllegalArgumentException();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0081  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long h(String str, int i10, int i11) throws NumberFormatException {
        int iA = a(str, i10, i11, false);
        Matcher matcher = f10670m.matcher(str);
        int i12 = -1;
        int i13 = -1;
        int i14 = -1;
        int iIndexOf = -1;
        int i15 = -1;
        int i16 = -1;
        while (iA < i11) {
            int iA2 = a(str, iA + 1, i11, true);
            matcher.region(iA, iA2);
            if (i13 == -1 && matcher.usePattern(f10670m).matches()) {
                i13 = Integer.parseInt(matcher.group(1));
                i15 = Integer.parseInt(matcher.group(2));
                i16 = Integer.parseInt(matcher.group(3));
            } else if (i14 == -1 && matcher.usePattern(f10669l).matches()) {
                i14 = Integer.parseInt(matcher.group(1));
            } else if (iIndexOf == -1) {
                Pattern pattern = f10668k;
                if (matcher.usePattern(pattern).matches()) {
                    iIndexOf = pattern.pattern().indexOf(matcher.group(1).toLowerCase(Locale.US)) / 4;
                } else if (i12 == -1 && matcher.usePattern(f10667j).matches()) {
                    i12 = Integer.parseInt(matcher.group(1));
                }
            }
            iA = a(str, iA2 + 1, i11, false);
        }
        if (i12 >= 70 && i12 <= 99) {
            i12 += 1900;
        }
        if (i12 >= 0 && i12 <= 69) {
            i12 += 2000;
        }
        if (i12 < 1601) {
            throw new IllegalArgumentException();
        }
        if (iIndexOf == -1) {
            throw new IllegalArgumentException();
        }
        if (i14 < 1 || i14 > 31) {
            throw new IllegalArgumentException();
        }
        if (i13 < 0 || i13 > 23) {
            throw new IllegalArgumentException();
        }
        if (i15 < 0 || i15 > 59) {
            throw new IllegalArgumentException();
        }
        if (i16 < 0 || i16 > 59) {
            throw new IllegalArgumentException();
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar(ub.c.f12950p);
        gregorianCalendar.setLenient(false);
        gregorianCalendar.set(1, i12);
        gregorianCalendar.set(2, iIndexOf - 1);
        gregorianCalendar.set(5, i14);
        gregorianCalendar.set(11, i13);
        gregorianCalendar.set(12, i15);
        gregorianCalendar.set(13, i16);
        gregorianCalendar.set(14, 0);
        return gregorianCalendar.getTimeInMillis();
    }

    public static long i(String str) throws NumberFormatException {
        try {
            long j10 = Long.parseLong(str);
            if (j10 <= 0) {
                return Long.MIN_VALUE;
            }
            return j10;
        } catch (NumberFormatException e10) {
            if (str.matches("-?\\d+")) {
                return str.startsWith("-") ? Long.MIN_VALUE : Long.MAX_VALUE;
            }
            throw e10;
        }
    }

    public String c() {
        return this.f10671a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return jVar.f10671a.equals(this.f10671a) && jVar.f10672b.equals(this.f10672b) && jVar.f10674d.equals(this.f10674d) && jVar.f10675e.equals(this.f10675e) && jVar.f10673c == this.f10673c && jVar.f10676f == this.f10676f && jVar.f10677g == this.f10677g && jVar.f10678h == this.f10678h && jVar.f10679i == this.f10679i;
    }

    public int hashCode() {
        int iHashCode = (((((((527 + this.f10671a.hashCode()) * 31) + this.f10672b.hashCode()) * 31) + this.f10674d.hashCode()) * 31) + this.f10675e.hashCode()) * 31;
        long j10 = this.f10673c;
        return ((((((((iHashCode + ((int) (j10 ^ (j10 >>> 32)))) * 31) + (!this.f10676f ? 1 : 0)) * 31) + (!this.f10677g ? 1 : 0)) * 31) + (!this.f10678h ? 1 : 0)) * 31) + (!this.f10679i ? 1 : 0);
    }

    public String j(boolean z10) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f10671a);
        sb2.append('=');
        sb2.append(this.f10672b);
        if (this.f10678h) {
            if (this.f10673c == Long.MIN_VALUE) {
                sb2.append("; max-age=0");
            } else {
                sb2.append("; expires=");
                sb2.append(xb.d.a(new Date(this.f10673c)));
            }
        }
        if (!this.f10679i) {
            sb2.append("; domain=");
            if (z10) {
                sb2.append(".");
            }
            sb2.append(this.f10674d);
        }
        sb2.append("; path=");
        sb2.append(this.f10675e);
        if (this.f10676f) {
            sb2.append("; secure");
        }
        if (this.f10677g) {
            sb2.append("; httponly");
        }
        return sb2.toString();
    }

    public String k() {
        return this.f10672b;
    }

    public String toString() {
        return j(false);
    }
}
