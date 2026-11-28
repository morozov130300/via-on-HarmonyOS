package w4;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f13639a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String[] f13640b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f13641c;

    public a(String str, String[] strArr, int i10) {
        this.f13639a = str;
        this.f13640b = strArr;
        this.f13641c = i10;
    }

    public static a d(String str) {
        int iIndexOf;
        String[] strArrF;
        int iIndexOf2;
        if (str == null) {
            return null;
        }
        String strTrim = str.trim();
        if (strTrim.isEmpty()) {
            return null;
        }
        int i10 = 0;
        if (strTrim.charAt(0) == '!' || strTrim.contains("->m:") || strTrim.contains("#?#") || (iIndexOf = strTrim.indexOf(35)) < 0) {
            return null;
        }
        boolean zStartsWith = strTrim.startsWith("#@#", iIndexOf);
        if (!zStartsWith && !strTrim.startsWith("##", iIndexOf)) {
            return null;
        }
        if (iIndexOf != 0) {
            strArrF = b5.c.f(strTrim.substring(0, iIndexOf), ',');
            if (zStartsWith) {
                for (int i11 = 0; i11 < strArrF.length; i11++) {
                    if (strArrF[i11].charAt(0) != '~') {
                        strArrF[i11] = '~' + strArrF[i11];
                    }
                }
            }
        } else {
            if (zStartsWith) {
                return null;
            }
            strArrF = null;
        }
        int i12 = iIndexOf + (zStartsWith ? 3 : 2);
        if (i12 == strTrim.length() || strTrim.charAt(i12) == '^' || strTrim.indexOf("js(", i12) >= 0) {
            return null;
        }
        int iIndexOf3 = strTrim.indexOf(58, i12);
        if (iIndexOf3 > 0 && (iIndexOf2 = strTrim.indexOf(40, iIndexOf3)) > iIndexOf3) {
            String strSubstring = strTrim.substring(iIndexOf3, iIndexOf2 + 1);
            if (":has-text(...), :matches-attr(...), :matches-css(...), :matches-css-before(...), :matches-css-after(...), :matches-media(...), :matches-path(...), :min-text-length(n), :NOT(...), :others(...), :upward(...), :watch-attr(...), :xpath(...).:remove(), :style(arg), :remove-attr(arg), :remove-class(arg)".contains(strSubstring)) {
                return null;
            }
            if (":has(...)".contains(strSubstring)) {
                i10 = 1;
            }
        }
        String strE = e(strTrim.substring(i12));
        if (strE == null) {
            return null;
        }
        return new a(strE, strArrF, i10);
    }

    public static String e(String str) {
        if (str != null && !str.isEmpty()) {
            int length = str.length();
            int i10 = 0;
            char c10 = 0;
            int i11 = 0;
            int i12 = 0;
            boolean z10 = false;
            while (i10 < length) {
                char cCharAt = str.charAt(i10);
                if (cCharAt == '\\') {
                    i10++;
                    if (i10 >= length) {
                        return null;
                    }
                } else {
                    if (c10 != 0) {
                        if (cCharAt == c10) {
                            c10 = 0;
                        }
                    } else if (cCharAt == '\"' || cCharAt == '\'') {
                        c10 = cCharAt;
                    } else {
                        if (cCharAt == '{' || cCharAt == '}' || cCharAt == ';' || cCharAt == '!' || cCharAt == '&' || cCharAt == '?') {
                            return null;
                        }
                        if (cCharAt == '[') {
                            i11++;
                        } else if (cCharAt == ']') {
                            if (i11 == 0) {
                                return null;
                            }
                            i11--;
                        } else if (cCharAt == '(') {
                            i12++;
                        } else if (cCharAt == ')') {
                            if (i12 == 0) {
                                return null;
                            }
                            i12--;
                        } else {
                            if (cCharAt == '=' && i11 == 0) {
                                return null;
                            }
                            if (cCharAt == ',' && i11 == 0 && i12 == 0) {
                                if (!z10) {
                                    return null;
                                }
                                z10 = false;
                            }
                        }
                        if (!Character.isWhitespace(cCharAt)) {
                        }
                    }
                    i10++;
                }
                z10 = true;
                i10++;
            }
            if (c10 == 0 && i11 == 0 && i12 == 0 && z10) {
                return str;
            }
        }
        return null;
    }

    public String a() {
        return this.f13639a;
    }

    public String[] b() {
        return this.f13640b;
    }

    public boolean c(int i10) {
        return (this.f13641c & i10) == i10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            a aVar = (a) obj;
            String str = this.f13639a;
            if (((str == null && aVar.f13639a == null) || (str != null && str.equals(aVar.f13639a))) && Arrays.equals(this.f13640b, aVar.f13640b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.f13639a;
        return ((str == null ? 0 : str.hashCode()) * 31) + Arrays.hashCode(this.f13640b);
    }

    public String toString() {
        return "ElementFilter{content='" + this.f13639a + "', domains=" + Arrays.toString(this.f13640b) + '}';
    }
}
