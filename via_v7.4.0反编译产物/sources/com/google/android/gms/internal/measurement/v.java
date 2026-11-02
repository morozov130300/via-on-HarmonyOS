package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.simpleframework.xml.strategy.Name;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class v implements Iterable, r {

    /* renamed from: e, reason: collision with root package name */
    public final String f3831e;

    public v(String str) {
        if (str == null) {
            throw new IllegalArgumentException("StringValue cannot be null.");
        }
        this.f3831e = str;
    }

    @Override // com.google.android.gms.internal.measurement.r
    public final r c() {
        return new v(this.f3831e);
    }

    @Override // com.google.android.gms.internal.measurement.r
    public final Double e() {
        if (this.f3831e.isEmpty()) {
            return Double.valueOf(0.0d);
        }
        try {
            return Double.valueOf(this.f3831e);
        } catch (NumberFormatException unused) {
            return Double.valueOf(Double.NaN);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof v) {
            return this.f3831e.equals(((v) obj).f3831e);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.r
    public final String f() {
        return this.f3831e;
    }

    @Override // com.google.android.gms.internal.measurement.r
    public final Boolean g() {
        return Boolean.valueOf(!this.f3831e.isEmpty());
    }

    @Override // com.google.android.gms.internal.measurement.r
    public final Iterator h() {
        return new t(this);
    }

    public final int hashCode() {
        return this.f3831e.hashCode();
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new u(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:116:0x02f6  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0397  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x03eb  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0405  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0421  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0484  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x049e  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x04ee  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x050a  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0549  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x0597  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x05b3  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x05c4  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c6 A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x023b  */
    @Override // com.google.android.gms.internal.measurement.r
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final r o(String str, q4 q4Var, List list) {
        String str2;
        String str3;
        String str4;
        String strF;
        int i10;
        v vVar;
        double dMin;
        double dMin2;
        int i11;
        int i12;
        int i13;
        q4 q4Var2;
        if ("charAt".equals(str) || "concat".equals(str) || "hasOwnProperty".equals(str) || "indexOf".equals(str) || "lastIndexOf".equals(str) || "match".equals(str) || "replace".equals(str) || "search".equals(str) || "slice".equals(str) || "split".equals(str) || "substring".equals(str) || "toLowerCase".equals(str) || "toLocaleLowerCase".equals(str) || "toString".equals(str) || "toUpperCase".equals(str)) {
            str2 = "toLocaleUpperCase";
        } else {
            str2 = "toLocaleUpperCase";
            if (!str2.equals(str)) {
                str3 = "hasOwnProperty";
                str4 = "trim";
                if (!str4.equals(str)) {
                    throw new IllegalArgumentException(String.format("%s is not a String function", str));
                }
            }
            strF = "undefined";
            switch (str.hashCode()) {
                case -1789698943:
                    String str5 = str3;
                    if (str.equals(str5)) {
                        r5.h(str5, 1, list);
                        String str6 = this.f3831e;
                        r rVarB = q4Var.b((r) list.get(0));
                        if (Name.LENGTH.equals(rVarB.f())) {
                            return r.f3719g;
                        }
                        double dDoubleValue = rVarB.e().doubleValue();
                        return (dDoubleValue != Math.floor(dDoubleValue) || (i10 = (int) dDoubleValue) < 0 || i10 >= str6.length()) ? r.f3720h : r.f3719g;
                    }
                    throw new IllegalArgumentException("Command not supported");
                case -1776922004:
                    if (str.equals("toString")) {
                        r5.h("toString", 0, list);
                        return this;
                    }
                    throw new IllegalArgumentException("Command not supported");
                case -1464939364:
                    if (str.equals("toLocaleLowerCase")) {
                        r5.h("toLocaleLowerCase", 0, list);
                        return new v(this.f3831e.toLowerCase());
                    }
                    throw new IllegalArgumentException("Command not supported");
                case -1361633751:
                    if (str.equals("charAt")) {
                        r5.j("charAt", 1, list);
                        int iA = !list.isEmpty() ? (int) r5.a(q4Var.b((r) list.get(0)).e().doubleValue()) : 0;
                        String str7 = this.f3831e;
                        return (iA < 0 || iA >= str7.length()) ? r.f3721i : new v(String.valueOf(str7.charAt(iA)));
                    }
                    throw new IllegalArgumentException("Command not supported");
                case -1354795244:
                    vVar = this;
                    if (str.equals("concat")) {
                        if (!list.isEmpty()) {
                            StringBuilder sb2 = new StringBuilder(vVar.f3831e);
                            for (int i14 = 0; i14 < list.size(); i14++) {
                                sb2.append(q4Var.b((r) list.get(i14)).f());
                            }
                            return new v(sb2.toString());
                        }
                        return vVar;
                    }
                    throw new IllegalArgumentException("Command not supported");
                case -1137582698:
                    if (str.equals("toLowerCase")) {
                        r5.h("toLowerCase", 0, list);
                        return new v(this.f3831e.toLowerCase(Locale.ENGLISH));
                    }
                    throw new IllegalArgumentException("Command not supported");
                case -906336856:
                    if (str.equals("search")) {
                        r5.j("search", 1, list);
                        return Pattern.compile(list.isEmpty() ? "undefined" : q4Var.b((r) list.get(0)).f()).matcher(this.f3831e).find() ? new j(Double.valueOf(r1.start())) : new j(Double.valueOf(-1.0d));
                    }
                    throw new IllegalArgumentException("Command not supported");
                case -726908483:
                    if (str.equals(str2)) {
                        r5.h(str2, 0, list);
                        return new v(this.f3831e.toUpperCase());
                    }
                    throw new IllegalArgumentException("Command not supported");
                case -467511597:
                    if (str.equals("lastIndexOf")) {
                        r5.j("lastIndexOf", 2, list);
                        String str8 = this.f3831e;
                        String strF2 = list.size() > 0 ? q4Var.b((r) list.get(0)).f() : "undefined";
                        return new j(Double.valueOf(str8.lastIndexOf(strF2, (int) (Double.isNaN(list.size() < 2 ? Double.NaN : q4Var.b((r) list.get(1)).e().doubleValue()) ? Double.POSITIVE_INFINITY : r5.a(r3)))));
                    }
                    throw new IllegalArgumentException("Command not supported");
                case -399551817:
                    if (str.equals("toUpperCase")) {
                        r5.h("toUpperCase", 0, list);
                        return new v(this.f3831e.toUpperCase(Locale.ENGLISH));
                    }
                    throw new IllegalArgumentException("Command not supported");
                case 3568674:
                    if (str.equals(str4)) {
                        r5.h("toUpperCase", 0, list);
                        return new v(this.f3831e.trim());
                    }
                    throw new IllegalArgumentException("Command not supported");
                case 103668165:
                    if (str.equals("match")) {
                        r5.j("match", 1, list);
                        Matcher matcher = Pattern.compile(list.size() <= 0 ? "" : q4Var.b((r) list.get(0)).f()).matcher(this.f3831e);
                        return matcher.find() ? new f(Arrays.asList(new v(matcher.group()))) : r.f3715b;
                    }
                    throw new IllegalArgumentException("Command not supported");
                case 109526418:
                    if (str.equals("slice")) {
                        r5.j("slice", 2, list);
                        String str9 = this.f3831e;
                        double dA = r5.a(!list.isEmpty() ? q4Var.b((r) list.get(0)).e().doubleValue() : 0.0d);
                        if (dA < 0.0d) {
                            double length = str9.length();
                            Double.isNaN(length);
                            dMin = Math.max(length + dA, 0.0d);
                        } else {
                            dMin = Math.min(dA, str9.length());
                        }
                        double dA2 = r5.a(list.size() > 1 ? q4Var.b((r) list.get(1)).e().doubleValue() : str9.length());
                        if (dA2 < 0.0d) {
                            double length2 = str9.length();
                            Double.isNaN(length2);
                            dMin2 = Math.max(length2 + dA2, 0.0d);
                        } else {
                            dMin2 = Math.min(dA2, str9.length());
                        }
                        int i15 = (int) dMin;
                        return new v(str9.substring(i15, Math.max(0, ((int) dMin2) - i15) + i15));
                    }
                    throw new IllegalArgumentException("Command not supported");
                case 109648666:
                    if (str.equals("split")) {
                        r5.j("split", 2, list);
                        String str10 = this.f3831e;
                        if (str10.length() == 0) {
                            return new f(Arrays.asList(this));
                        }
                        ArrayList arrayList = new ArrayList();
                        if (list.isEmpty()) {
                            arrayList.add(this);
                        } else {
                            String strF3 = q4Var.b((r) list.get(0)).f();
                            long jD = list.size() > 1 ? r5.d(q4Var.b((r) list.get(1)).e().doubleValue()) : 2147483647L;
                            if (jD == 0) {
                                return new f();
                            }
                            String[] strArrSplit = str10.split(Pattern.quote(strF3), ((int) jD) + 1);
                            int length3 = strArrSplit.length;
                            if (!strF3.isEmpty() || length3 <= 0) {
                                i11 = length3;
                                i12 = 0;
                            } else {
                                boolean zIsEmpty = strArrSplit[0].isEmpty();
                                i11 = length3 - 1;
                                i12 = zIsEmpty;
                                if (!strArrSplit[i11].isEmpty()) {
                                    i11 = length3;
                                    i12 = zIsEmpty;
                                }
                            }
                            if (length3 > jD) {
                                i11--;
                            }
                            while (i12 < i11) {
                                arrayList.add(new v(strArrSplit[i12]));
                                i12++;
                            }
                        }
                        return new f(arrayList);
                    }
                    throw new IllegalArgumentException("Command not supported");
                case 530542161:
                    if (str.equals("substring")) {
                        r5.j("substring", 2, list);
                        String str11 = this.f3831e;
                        int iA2 = !list.isEmpty() ? (int) r5.a(q4Var.b((r) list.get(0)).e().doubleValue()) : 0;
                        int iA3 = list.size() > 1 ? (int) r5.a(q4Var.b((r) list.get(1)).e().doubleValue()) : str11.length();
                        int iMin = Math.min(Math.max(iA2, 0), str11.length());
                        int iMin2 = Math.min(Math.max(iA3, 0), str11.length());
                        return new v(str11.substring(Math.min(iMin, iMin2), Math.max(iMin, iMin2)));
                    }
                    throw new IllegalArgumentException("Command not supported");
                case 1094496948:
                    vVar = this;
                    if (str.equals("replace")) {
                        r5.j("replace", 2, list);
                        r rVarA = r.f3714a;
                        if (!list.isEmpty()) {
                            strF = q4Var.b((r) list.get(0)).f();
                            if (list.size() > 1) {
                                rVarA = q4Var.b((r) list.get(1));
                            }
                        }
                        String str12 = strF;
                        String str13 = vVar.f3831e;
                        int iIndexOf = str13.indexOf(str12);
                        if (iIndexOf >= 0) {
                            if (rVarA instanceof k) {
                                i13 = 0;
                                rVarA = ((k) rVarA).a(q4Var, Arrays.asList(new v(str12), new j(Double.valueOf(iIndexOf)), vVar));
                            } else {
                                i13 = 0;
                            }
                            return new v(str13.substring(i13, iIndexOf) + rVarA.f() + str13.substring(iIndexOf + str12.length()));
                        }
                        return vVar;
                    }
                    throw new IllegalArgumentException("Command not supported");
                case 1943291465:
                    if (str.equals("indexOf")) {
                        r5.j("indexOf", 2, list);
                        String str14 = this.f3831e;
                        if (list.size() <= 0) {
                            q4Var2 = q4Var;
                        } else {
                            q4Var2 = q4Var;
                            strF = q4Var2.b((r) list.get(0)).f();
                        }
                        return new j(Double.valueOf(str14.indexOf(strF, (int) r5.a(list.size() < 2 ? 0.0d : q4Var2.b((r) list.get(1)).e().doubleValue()))));
                    }
                default:
                    throw new IllegalArgumentException("Command not supported");
            }
        }
        str3 = "hasOwnProperty";
        str4 = "trim";
        strF = "undefined";
        switch (str.hashCode()) {
            case -1789698943:
                break;
            case -1776922004:
                break;
            case -1464939364:
                break;
            case -1361633751:
                break;
            case -1354795244:
                break;
            case -1137582698:
                break;
            case -906336856:
                break;
            case -726908483:
                break;
            case -467511597:
                break;
            case -399551817:
                break;
            case 3568674:
                break;
            case 103668165:
                break;
            case 109526418:
                break;
            case 109648666:
                break;
            case 530542161:
                break;
            case 1094496948:
                break;
            case 1943291465:
                break;
        }
    }

    public final String toString() {
        return "\"" + this.f3831e + "\"";
    }
}
