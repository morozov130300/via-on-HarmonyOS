package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.simpleframework.xml.strategy.Name;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class v implements Iterable, r {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f3130c;

    public v(String str) {
        if (str == null) {
            throw new IllegalArgumentException("StringValue cannot be null.");
        }
        this.f3130c = str;
    }

    @Override // com.google.android.gms.internal.measurement.r
    public final r c() {
        return new v(this.f3130c);
    }

    @Override // com.google.android.gms.internal.measurement.r
    public final Double e() {
        if (this.f3130c.isEmpty()) {
            return Double.valueOf(0.0d);
        }
        try {
            return Double.valueOf(this.f3130c);
        } catch (NumberFormatException unused) {
            return Double.valueOf(Double.NaN);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof v) {
            return this.f3130c.equals(((v) obj).f3130c);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.r
    public final String f() {
        return this.f3130c;
    }

    @Override // com.google.android.gms.internal.measurement.r
    public final Boolean g() {
        return Boolean.valueOf(!this.f3130c.isEmpty());
    }

    @Override // com.google.android.gms.internal.measurement.r
    public final Iterator h() {
        return new t(this);
    }

    public final int hashCode() {
        return this.f3130c.hashCode();
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new u(this);
    }

    /* JADX WARN: Code duplicated, block: B:100:0x02a8  */
    /* JADX WARN: Code duplicated, block: B:102:0x02ae  */
    /* JADX WARN: Code duplicated, block: B:108:0x02d8  */
    /* JADX WARN: Code duplicated, block: B:111:0x02df  */
    /* JADX WARN: Code duplicated, block: B:113:0x02e3 A[LOOP:0: B:112:0x02e1->B:113:0x02e3, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:116:0x02f6  */
    /* JADX WARN: Code duplicated, block: B:118:0x0302  */
    /* JADX WARN: Code duplicated, block: B:120:0x030d  */
    /* JADX WARN: Code duplicated, block: B:121:0x0321  */
    /* JADX WARN: Code duplicated, block: B:124:0x032b  */
    /* JADX WARN: Code duplicated, block: B:125:0x033b  */
    /* JADX WARN: Code duplicated, block: B:128:0x034b  */
    /* JADX WARN: Code duplicated, block: B:129:0x035e  */
    /* JADX WARN: Code duplicated, block: B:132:0x036d  */
    /* JADX WARN: Code duplicated, block: B:133:0x037b  */
    /* JADX WARN: Code duplicated, block: B:136:0x0397  */
    /* JADX WARN: Code duplicated, block: B:138:0x03a3  */
    /* JADX WARN: Code duplicated, block: B:140:0x03af  */
    /* JADX WARN: Code duplicated, block: B:141:0x03b2  */
    /* JADX WARN: Code duplicated, block: B:144:0x03cf  */
    /* JADX WARN: Code duplicated, block: B:146:0x03e8  */
    /* JADX WARN: Code duplicated, block: B:148:0x03eb  */
    /* JADX WARN: Code duplicated, block: B:150:0x03f6  */
    /* JADX WARN: Code duplicated, block: B:152:0x0405  */
    /* JADX WARN: Code duplicated, block: B:154:0x0410  */
    /* JADX WARN: Code duplicated, block: B:156:0x0421  */
    /* JADX WARN: Code duplicated, block: B:158:0x042d  */
    /* JADX WARN: Code duplicated, block: B:161:0x043b  */
    /* JADX WARN: Code duplicated, block: B:164:0x0451  */
    /* JADX WARN: Code duplicated, block: B:165:0x0454  */
    /* JADX WARN: Code duplicated, block: B:168:0x046d  */
    /* JADX WARN: Code duplicated, block: B:169:0x0470  */
    /* JADX WARN: Code duplicated, block: B:172:0x0484  */
    /* JADX WARN: Code duplicated, block: B:174:0x048e  */
    /* JADX WARN: Code duplicated, block: B:176:0x049e  */
    /* JADX WARN: Code duplicated, block: B:178:0x04aa  */
    /* JADX WARN: Code duplicated, block: B:180:0x04b4  */
    /* JADX WARN: Code duplicated, block: B:183:0x04d3  */
    /* JADX WARN: Code duplicated, block: B:185:0x04e2  */
    /* JADX WARN: Code duplicated, block: B:187:0x04ee  */
    /* JADX WARN: Code duplicated, block: B:189:0x04f8  */
    /* JADX WARN: Code duplicated, block: B:191:0x050a  */
    /* JADX WARN: Code duplicated, block: B:193:0x0516  */
    /* JADX WARN: Code duplicated, block: B:195:0x051c  */
    /* JADX WARN: Code duplicated, block: B:198:0x052a A[LOOP:1: B:196:0x0524->B:198:0x052a, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:202:0x0549  */
    /* JADX WARN: Code duplicated, block: B:204:0x0557  */
    /* JADX WARN: Code duplicated, block: B:206:0x0561  */
    /* JADX WARN: Code duplicated, block: B:207:0x057a  */
    /* JADX WARN: Code duplicated, block: B:217:0x0597  */
    /* JADX WARN: Code duplicated, block: B:219:0x05a3  */
    /* JADX WARN: Code duplicated, block: B:221:0x05b3  */
    /* JADX WARN: Code duplicated, block: B:223:0x05c0  */
    /* JADX WARN: Code duplicated, block: B:225:0x05c4  */
    /* JADX WARN: Code duplicated, block: B:227:0x05d3  */
    /* JADX WARN: Code duplicated, block: B:229:0x05ef  */
    /* JADX WARN: Code duplicated, block: B:231:0x05f2  */
    /* JADX WARN: Code duplicated, block: B:43:0x00c6 A[FALL_THROUGH] */
    /* JADX WARN: Code duplicated, block: B:44:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:46:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:48:0x00df  */
    /* JADX WARN: Code duplicated, block: B:50:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:53:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:54:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:57:0x0126  */
    /* JADX WARN: Code duplicated, block: B:59:0x0132  */
    /* JADX WARN: Code duplicated, block: B:61:0x013d  */
    /* JADX WARN: Code duplicated, block: B:63:0x0153  */
    /* JADX WARN: Code duplicated, block: B:66:0x0167  */
    /* JADX WARN: Code duplicated, block: B:68:0x016b  */
    /* JADX WARN: Code duplicated, block: B:69:0x0191  */
    /* JADX WARN: Code duplicated, block: B:72:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:74:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:76:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:77:0x01eb  */
    /* JADX WARN: Code duplicated, block: B:80:0x01f3  */
    /* JADX WARN: Code duplicated, block: B:82:0x020c  */
    /* JADX WARN: Code duplicated, block: B:85:0x023b  */
    /* JADX WARN: Code duplicated, block: B:87:0x0247  */
    /* JADX WARN: Code duplicated, block: B:89:0x0252  */
    /* JADX WARN: Code duplicated, block: B:91:0x0262  */
    /* JADX WARN: Code duplicated, block: B:93:0x026e  */
    /* JADX WARN: Code duplicated, block: B:94:0x0273  */
    /* JADX WARN: Code duplicated, block: B:96:0x0288  */
    /* JADX WARN: Code duplicated, block: B:97:0x029f  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.r
    public final r o(String str, q4 q4Var, List list) {
        String str2;
        String str3;
        String strF;
        String str4;
        r rVarB;
        int i10;
        int iA;
        v vVar;
        StringBuilder sb2;
        int i11;
        double dDoubleValue;
        double dA;
        String strF2;
        String str5;
        double dDoubleValue2;
        double dA2;
        double dMin;
        double length;
        double dA3;
        double dMin2;
        String str6;
        ArrayList arrayList;
        String strF3;
        long jD;
        String[] strArrSplit;
        int length2;
        int i12;
        int i13;
        String str7;
        int iA2;
        int length3;
        r rVarA;
        String str8;
        String str9;
        int iIndexOf;
        int i14;
        q4 q4Var2;
        double dDoubleValue3;
        if ("charAt".equals(str) || "concat".equals(str) || "hasOwnProperty".equals(str) || "indexOf".equals(str) || "lastIndexOf".equals(str) || "match".equals(str) || "replace".equals(str) || "search".equals(str) || "slice".equals(str) || "split".equals(str) || "substring".equals(str) || "toLowerCase".equals(str) || "toLocaleLowerCase".equals(str) || "toString".equals(str) || "toUpperCase".equals(str)) {
            str2 = "toLocaleUpperCase";
        } else {
            str2 = "toLocaleUpperCase";
            if (!str2.equals(str)) {
                str3 = "trim";
                if (!str3.equals(str)) {
                    throw new IllegalArgumentException(String.format("%s is not a String function", str));
                }
            }
            strF = "undefined";
            switch (str.hashCode()) {
                case -1789698943:
                    if (str.equals("hasOwnProperty")) {
                        r5.h("hasOwnProperty", 1, list);
                        str4 = this.f3130c;
                        rVarB = q4Var.b((r) list.get(0));
                        if (Name.LENGTH.equals(rVarB.f())) {
                            return r.f3018h;
                        }
                        double dDoubleValue4 = rVarB.e().doubleValue();
                        return (dDoubleValue4 == Math.floor(dDoubleValue4) || (i10 = (int) dDoubleValue4) < 0 || i10 >= str4.length()) ? r.f3019i : r.f3018h;
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
                        return new v(this.f3130c.toLowerCase());
                    }
                    throw new IllegalArgumentException("Command not supported");
                case -1361633751:
                    if (str.equals("charAt")) {
                        r5.j("charAt", 1, list);
                        if (list.isEmpty()) {
                            iA = 0;
                        } else {
                            iA = (int) r5.a(q4Var.b((r) list.get(0)).e().doubleValue());
                        }
                        String str10 = this.f3130c;
                        return (iA >= 0 || iA >= str10.length()) ? r.f3020j : new v(String.valueOf(str10.charAt(iA)));
                    }
                    throw new IllegalArgumentException("Command not supported");
                case -1354795244:
                    vVar = this;
                    if (str.equals("concat")) {
                        if (!list.isEmpty()) {
                            sb2 = new StringBuilder(vVar.f3130c);
                            for (i11 = 0; i11 < list.size(); i11++) {
                                sb2.append(q4Var.b((r) list.get(i11)).f());
                            }
                            return new v(sb2.toString());
                        }
                        return vVar;
                    }
                    throw new IllegalArgumentException("Command not supported");
                case -1137582698:
                    if (str.equals("toLowerCase")) {
                        r5.h("toLowerCase", 0, list);
                        return new v(this.f3130c.toLowerCase(Locale.ENGLISH));
                    }
                    throw new IllegalArgumentException("Command not supported");
                case -906336856:
                    if (str.equals("search")) {
                        r5.j("search", 1, list);
                        Matcher matcher = Pattern.compile(list.isEmpty() ? "undefined" : q4Var.b((r) list.get(0)).f()).matcher(this.f3130c);
                        return matcher.find() ? new j(Double.valueOf(matcher.start())) : new j(Double.valueOf(-1.0d));
                    }
                    throw new IllegalArgumentException("Command not supported");
                case -726908483:
                    if (str.equals(str2)) {
                        r5.h(str2, 0, list);
                        return new v(this.f3130c.toUpperCase());
                    }
                    throw new IllegalArgumentException("Command not supported");
                case -467511597:
                    if (str.equals("lastIndexOf")) {
                        r5.j("lastIndexOf", 2, list);
                        String str11 = this.f3130c;
                        String strF4 = list.size() > 0 ? q4Var.b((r) list.get(0)).f() : "undefined";
                        if (list.size() < 2) {
                            dDoubleValue = Double.NaN;
                        } else {
                            dDoubleValue = q4Var.b((r) list.get(1)).e().doubleValue();
                        }
                        if (Double.isNaN(dDoubleValue)) {
                            dA = Double.POSITIVE_INFINITY;
                        } else {
                            dA = r5.a(dDoubleValue);
                        }
                        return new j(Double.valueOf(str11.lastIndexOf(strF4, (int) dA)));
                    }
                    throw new IllegalArgumentException("Command not supported");
                case -399551817:
                    if (str.equals("toUpperCase")) {
                        r5.h("toUpperCase", 0, list);
                        return new v(this.f3130c.toUpperCase(Locale.ENGLISH));
                    }
                    throw new IllegalArgumentException("Command not supported");
                case 3568674:
                    if (str.equals(str3)) {
                        r5.h("toUpperCase", 0, list);
                        return new v(this.f3130c.trim());
                    }
                    throw new IllegalArgumentException("Command not supported");
                case 103668165:
                    if (str.equals("match")) {
                        r5.j("match", 1, list);
                        String str12 = this.f3130c;
                        if (list.size() <= 0) {
                            strF2 = "";
                        } else {
                            strF2 = q4Var.b((r) list.get(0)).f();
                        }
                        Matcher matcher2 = Pattern.compile(strF2).matcher(str12);
                        return matcher2.find() ? new f(Arrays.asList(new v(matcher2.group()))) : r.f3014b;
                    }
                    throw new IllegalArgumentException("Command not supported");
                case 109526418:
                    if (str.equals("slice")) {
                        r5.j("slice", 2, list);
                        str5 = this.f3130c;
                        if (list.isEmpty()) {
                            dDoubleValue2 = 0.0d;
                        } else {
                            dDoubleValue2 = q4Var.b((r) list.get(0)).e().doubleValue();
                        }
                        dA2 = r5.a(dDoubleValue2);
                        if (dA2 < 0.0d) {
                            double length4 = str5.length();
                            Double.isNaN(length4);
                            dMin = Math.max(length4 + dA2, 0.0d);
                        } else {
                            dMin = Math.min(dA2, str5.length());
                        }
                        if (list.size() > 1) {
                            length = q4Var.b((r) list.get(1)).e().doubleValue();
                        } else {
                            length = str5.length();
                        }
                        dA3 = r5.a(length);
                        if (dA3 < 0.0d) {
                            double length5 = str5.length();
                            Double.isNaN(length5);
                            dMin2 = Math.max(length5 + dA3, 0.0d);
                        } else {
                            dMin2 = Math.min(dA3, str5.length());
                        }
                        int i15 = (int) dMin;
                        return new v(str5.substring(i15, Math.max(0, ((int) dMin2) - i15) + i15));
                    }
                    throw new IllegalArgumentException("Command not supported");
                case 109648666:
                    if (str.equals("split")) {
                        r5.j("split", 2, list);
                        str6 = this.f3130c;
                        if (str6.length() == 0) {
                            return new f(Arrays.asList(this));
                        }
                        arrayList = new ArrayList();
                        if (list.isEmpty()) {
                            arrayList.add(this);
                        } else {
                            strF3 = q4Var.b((r) list.get(0)).f();
                            if (list.size() > 1) {
                                jD = r5.d(q4Var.b((r) list.get(1)).e().doubleValue());
                            } else {
                                jD = 2147483647L;
                            }
                            if (jD == 0) {
                                return new f();
                            }
                            strArrSplit = str6.split(Pattern.quote(strF3), ((int) jD) + 1);
                            length2 = strArrSplit.length;
                            if (strF3.isEmpty() || length2 <= 0) {
                                i12 = length2;
                                i13 = 0;
                            } else {
                                boolean zIsEmpty = strArrSplit[0].isEmpty();
                                i12 = length2 - 1;
                                i13 = zIsEmpty;
                                if (!strArrSplit[i12].isEmpty()) {
                                    i12 = length2;
                                    i13 = zIsEmpty;
                                }
                            }
                            if (length2 > jD) {
                                i12--;
                            }
                            while (i13 < i12) {
                                arrayList.add(new v(strArrSplit[i13]));
                                i13++;
                            }
                        }
                        return new f(arrayList);
                    }
                    throw new IllegalArgumentException("Command not supported");
                case 530542161:
                    if (str.equals("substring")) {
                        r5.j("substring", 2, list);
                        str7 = this.f3130c;
                        if (list.isEmpty()) {
                            iA2 = 0;
                        } else {
                            iA2 = (int) r5.a(q4Var.b((r) list.get(0)).e().doubleValue());
                        }
                        if (list.size() > 1) {
                            length3 = (int) r5.a(q4Var.b((r) list.get(1)).e().doubleValue());
                        } else {
                            length3 = str7.length();
                        }
                        int iMin = Math.min(Math.max(iA2, 0), str7.length());
                        int iMin2 = Math.min(Math.max(length3, 0), str7.length());
                        return new v(str7.substring(Math.min(iMin, iMin2), Math.max(iMin, iMin2)));
                    }
                    throw new IllegalArgumentException("Command not supported");
                case 1094496948:
                    vVar = this;
                    if (str.equals("replace")) {
                        r5.j("replace", 2, list);
                        rVarA = r.f3013a;
                        if (!list.isEmpty()) {
                            strF = q4Var.b((r) list.get(0)).f();
                            if (list.size() > 1) {
                                rVarA = q4Var.b((r) list.get(1));
                            }
                        }
                        str8 = strF;
                        str9 = vVar.f3130c;
                        iIndexOf = str9.indexOf(str8);
                        if (iIndexOf >= 0) {
                            if (rVarA instanceof k) {
                                i14 = 0;
                                rVarA = ((k) rVarA).a(q4Var, Arrays.asList(new v(str8), new j(Double.valueOf(iIndexOf)), vVar));
                            } else {
                                i14 = 0;
                            }
                            return new v(str9.substring(i14, iIndexOf) + rVarA.f() + str9.substring(iIndexOf + str8.length()));
                        }
                        return vVar;
                    }
                    throw new IllegalArgumentException("Command not supported");
                case 1943291465:
                    if (str.equals("indexOf")) {
                        r5.j("indexOf", 2, list);
                        String str13 = this.f3130c;
                        if (list.size() <= 0) {
                            q4Var2 = q4Var;
                        } else {
                            q4Var2 = q4Var;
                            strF = q4Var2.b((r) list.get(0)).f();
                        }
                        String str14 = strF;
                        if (list.size() < 2) {
                            dDoubleValue3 = 0.0d;
                        } else {
                            dDoubleValue3 = q4Var2.b((r) list.get(1)).e().doubleValue();
                        }
                        return new j(Double.valueOf(str13.indexOf(str14, (int) r5.a(dDoubleValue3))));
                    }
                default:
                    throw new IllegalArgumentException("Command not supported");
            }
        }
        str3 = "trim";
        strF = "undefined";
        switch (str.hashCode()) {
            case -1789698943:
                if (str.equals("hasOwnProperty")) {
                    r5.h("hasOwnProperty", 1, list);
                    str4 = this.f3130c;
                    rVarB = q4Var.b((r) list.get(0));
                    if (Name.LENGTH.equals(rVarB.f())) {
                        return r.f3018h;
                    }
                    double dDoubleValue5 = rVarB.e().doubleValue();
                    if (dDoubleValue5 == Math.floor(dDoubleValue5)) {
                    }
                    break;
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
                    return new v(this.f3130c.toLowerCase());
                }
                throw new IllegalArgumentException("Command not supported");
            case -1361633751:
                if (str.equals("charAt")) {
                    r5.j("charAt", 1, list);
                    if (list.isEmpty()) {
                        iA = (int) r5.a(q4Var.b((r) list.get(0)).e().doubleValue());
                    } else {
                        iA = 0;
                    }
                    String str15 = this.f3130c;
                    if (iA >= 0) {
                    }
                    break;
                }
                throw new IllegalArgumentException("Command not supported");
            case -1354795244:
                vVar = this;
                if (str.equals("concat")) {
                    if (!list.isEmpty()) {
                        sb2 = new StringBuilder(vVar.f3130c);
                        while (i11 < list.size()) {
                            sb2.append(q4Var.b((r) list.get(i11)).f());
                        }
                        return new v(sb2.toString());
                    }
                    return vVar;
                }
                throw new IllegalArgumentException("Command not supported");
            case -1137582698:
                if (str.equals("toLowerCase")) {
                    r5.h("toLowerCase", 0, list);
                    return new v(this.f3130c.toLowerCase(Locale.ENGLISH));
                }
                throw new IllegalArgumentException("Command not supported");
            case -906336856:
                if (str.equals("search")) {
                    r5.j("search", 1, list);
                    Matcher matcher3 = Pattern.compile(list.isEmpty() ? "undefined" : q4Var.b((r) list.get(0)).f()).matcher(this.f3130c);
                    if (matcher3.find()) {
                    }
                }
                throw new IllegalArgumentException("Command not supported");
            case -726908483:
                if (str.equals(str2)) {
                    r5.h(str2, 0, list);
                    return new v(this.f3130c.toUpperCase());
                }
                throw new IllegalArgumentException("Command not supported");
            case -467511597:
                if (str.equals("lastIndexOf")) {
                    r5.j("lastIndexOf", 2, list);
                    String str16 = this.f3130c;
                    String strF5 = list.size() > 0 ? q4Var.b((r) list.get(0)).f() : "undefined";
                    if (list.size() < 2) {
                        dDoubleValue = Double.NaN;
                    } else {
                        dDoubleValue = q4Var.b((r) list.get(1)).e().doubleValue();
                    }
                    if (Double.isNaN(dDoubleValue)) {
                        dA = Double.POSITIVE_INFINITY;
                    } else {
                        dA = r5.a(dDoubleValue);
                    }
                    return new j(Double.valueOf(str16.lastIndexOf(strF5, (int) dA)));
                }
                throw new IllegalArgumentException("Command not supported");
            case -399551817:
                if (str.equals("toUpperCase")) {
                    r5.h("toUpperCase", 0, list);
                    return new v(this.f3130c.toUpperCase(Locale.ENGLISH));
                }
                throw new IllegalArgumentException("Command not supported");
            case 3568674:
                if (str.equals(str3)) {
                    r5.h("toUpperCase", 0, list);
                    return new v(this.f3130c.trim());
                }
                throw new IllegalArgumentException("Command not supported");
            case 103668165:
                if (str.equals("match")) {
                    r5.j("match", 1, list);
                    String str17 = this.f3130c;
                    if (list.size() <= 0) {
                        strF2 = "";
                    } else {
                        strF2 = q4Var.b((r) list.get(0)).f();
                    }
                    Matcher matcher4 = Pattern.compile(strF2).matcher(str17);
                    if (matcher4.find()) {
                    }
                }
                throw new IllegalArgumentException("Command not supported");
            case 109526418:
                if (str.equals("slice")) {
                    r5.j("slice", 2, list);
                    str5 = this.f3130c;
                    if (list.isEmpty()) {
                        dDoubleValue2 = q4Var.b((r) list.get(0)).e().doubleValue();
                    } else {
                        dDoubleValue2 = 0.0d;
                    }
                    dA2 = r5.a(dDoubleValue2);
                    if (dA2 < 0.0d) {
                        double length6 = str5.length();
                        Double.isNaN(length6);
                        dMin = Math.max(length6 + dA2, 0.0d);
                    } else {
                        dMin = Math.min(dA2, str5.length());
                    }
                    if (list.size() > 1) {
                        length = q4Var.b((r) list.get(1)).e().doubleValue();
                    } else {
                        length = str5.length();
                    }
                    dA3 = r5.a(length);
                    if (dA3 < 0.0d) {
                        double length7 = str5.length();
                        Double.isNaN(length7);
                        dMin2 = Math.max(length7 + dA3, 0.0d);
                    } else {
                        dMin2 = Math.min(dA3, str5.length());
                    }
                    int i16 = (int) dMin;
                    return new v(str5.substring(i16, Math.max(0, ((int) dMin2) - i16) + i16));
                }
                throw new IllegalArgumentException("Command not supported");
            case 109648666:
                if (str.equals("split")) {
                    r5.j("split", 2, list);
                    str6 = this.f3130c;
                    if (str6.length() == 0) {
                        return new f(Arrays.asList(this));
                    }
                    arrayList = new ArrayList();
                    if (list.isEmpty()) {
                        arrayList.add(this);
                    } else {
                        strF3 = q4Var.b((r) list.get(0)).f();
                        if (list.size() > 1) {
                            jD = r5.d(q4Var.b((r) list.get(1)).e().doubleValue());
                        } else {
                            jD = 2147483647L;
                        }
                        if (jD == 0) {
                            return new f();
                        }
                        strArrSplit = str6.split(Pattern.quote(strF3), ((int) jD) + 1);
                        length2 = strArrSplit.length;
                        if (strF3.isEmpty()) {
                            i12 = length2;
                            i13 = 0;
                        } else {
                            i12 = length2;
                            i13 = 0;
                        }
                        if (length2 > jD) {
                            i12--;
                        }
                        while (i13 < i12) {
                            arrayList.add(new v(strArrSplit[i13]));
                            i13++;
                        }
                    }
                    return new f(arrayList);
                }
                throw new IllegalArgumentException("Command not supported");
            case 530542161:
                if (str.equals("substring")) {
                    r5.j("substring", 2, list);
                    str7 = this.f3130c;
                    if (list.isEmpty()) {
                        iA2 = (int) r5.a(q4Var.b((r) list.get(0)).e().doubleValue());
                    } else {
                        iA2 = 0;
                    }
                    if (list.size() > 1) {
                        length3 = (int) r5.a(q4Var.b((r) list.get(1)).e().doubleValue());
                    } else {
                        length3 = str7.length();
                    }
                    int iMin3 = Math.min(Math.max(iA2, 0), str7.length());
                    int iMin4 = Math.min(Math.max(length3, 0), str7.length());
                    return new v(str7.substring(Math.min(iMin3, iMin4), Math.max(iMin3, iMin4)));
                }
                throw new IllegalArgumentException("Command not supported");
            case 1094496948:
                vVar = this;
                if (str.equals("replace")) {
                    r5.j("replace", 2, list);
                    rVarA = r.f3013a;
                    if (!list.isEmpty()) {
                        strF = q4Var.b((r) list.get(0)).f();
                        if (list.size() > 1) {
                            rVarA = q4Var.b((r) list.get(1));
                        }
                    }
                    str8 = strF;
                    str9 = vVar.f3130c;
                    iIndexOf = str9.indexOf(str8);
                    if (iIndexOf >= 0) {
                        if (rVarA instanceof k) {
                            i14 = 0;
                            rVarA = ((k) rVarA).a(q4Var, Arrays.asList(new v(str8), new j(Double.valueOf(iIndexOf)), vVar));
                        } else {
                            i14 = 0;
                        }
                        return new v(str9.substring(i14, iIndexOf) + rVarA.f() + str9.substring(iIndexOf + str8.length()));
                    }
                    return vVar;
                }
                throw new IllegalArgumentException("Command not supported");
            case 1943291465:
                if (str.equals("indexOf")) {
                    r5.j("indexOf", 2, list);
                    String str18 = this.f3130c;
                    if (list.size() <= 0) {
                        q4Var2 = q4Var;
                    } else {
                        q4Var2 = q4Var;
                        strF = q4Var2.b((r) list.get(0)).f();
                    }
                    String str19 = strF;
                    if (list.size() < 2) {
                        dDoubleValue3 = 0.0d;
                    } else {
                        dDoubleValue3 = q4Var2.b((r) list.get(1)).e().doubleValue();
                    }
                    return new j(Double.valueOf(str18.indexOf(str19, (int) r5.a(dDoubleValue3))));
                }
            default:
                throw new IllegalArgumentException("Command not supported");
        }
    }

    public final String toString() {
        return "\"" + this.f3130c + "\"";
    }
}
