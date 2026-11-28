package w4;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class d implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f13649a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String[] f13650b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f13651c;

    public d() {
        this(null);
    }

    public static int a(int i10) {
        int i11 = 0;
        while (i10 > 0) {
            i10 &= i10 - 1;
            i11++;
        }
        return i11;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:157:0x022a  */
    /* JADX WARN: Code duplicated, block: B:159:0x0232  */
    /* JADX WARN: Code duplicated, block: B:160:0x0240  */
    /* JADX WARN: Code duplicated, block: B:164:0x024b  */
    /* JADX WARN: Code duplicated, block: B:165:0x024e  */
    /* JADX WARN: Code duplicated, block: B:166:0x0251  */
    /* JADX WARN: Code duplicated, block: B:167:0x0254  */
    /* JADX WARN: Code duplicated, block: B:168:0x0257  */
    /* JADX WARN: Code duplicated, block: B:169:0x025a  */
    /* JADX WARN: Code duplicated, block: B:170:0x025d  */
    /* JADX WARN: Code duplicated, block: B:171:0x0260  */
    /* JADX WARN: Code duplicated, block: B:172:0x0263  */
    /* JADX WARN: Code duplicated, block: B:173:0x0266 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:175:0x0269  */
    /* JADX WARN: Code duplicated, block: B:177:0x026f  */
    /* JADX WARN: Code duplicated, block: B:178:0x0271  */
    /* JADX WARN: Code duplicated, block: B:179:0x0274  */
    /* JADX WARN: Code duplicated, block: B:181:0x0278 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:182:0x027a  */
    /* JADX WARN: Code duplicated, block: B:184:0x027e  */
    /* JADX WARN: Code duplicated, block: B:186:0x0284  */
    /* JADX WARN: Code duplicated, block: B:197:0x0248 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:199:0x0285 A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    public static d i(String str) {
        String strTrim;
        int length;
        int i10;
        int i11;
        d dVar;
        int i12;
        if (str == null || (length = (strTrim = str.trim()).length()) < 5 || strTrim.charAt(0) == '!' || strTrim.indexOf(92) >= 0) {
            return null;
        }
        d dVar2 = new d();
        int iIndexOf = strTrim.indexOf(32);
        if (iIndexOf > 0) {
            if (!strTrim.startsWith("127.0.0.1")) {
                return null;
            }
            dVar2.j('|' + strTrim.substring(iIndexOf + 1).trim() + '^');
            return dVar2;
        }
        if (strTrim.charAt(0) == '@' && strTrim.charAt(1) == '@') {
            i10 = 2;
            i11 = 1;
        } else {
            i10 = 0;
            i11 = 0;
        }
        int iIndexOf2 = strTrim.indexOf(36, i10);
        int i13 = iIndexOf2 < 0 ? length : iIndexOf2;
        if (i13 - i10 > 1) {
            dVar = null;
            if (strTrim.charAt(i10) == '|') {
                int i14 = i10 + 1;
                i10 = (strTrim.charAt(i14) == '|' && strTrim.charAt(i10 + 2) == '*') ? i10 + 3 : i14;
            } else if (strTrim.charAt(i10) == '*') {
                i10++;
            }
            if (strTrim.charAt(i13 - 1) == '*') {
                i13--;
            }
        } else {
            dVar = null;
        }
        dVar2.j(i10 == i13 ? dVar : strTrim.substring(i10, i13));
        if (iIndexOf2 >= 0) {
            int i15 = iIndexOf2 + 1;
            boolean z10 = false;
            int i16 = 0;
            int i17 = 0;
            while (i15 < length) {
                int iIndexOf3 = strTrim.indexOf(44, i15);
                if (iIndexOf3 < 0) {
                    iIndexOf3 = length;
                }
                boolean z11 = strTrim.charAt(i15) == '~';
                if (z11) {
                    i15++;
                }
                String strSubstring = strTrim.substring(i15, iIndexOf3);
                strSubstring.getClass();
                byte b10 = -1;
                switch (strSubstring) {
                    case "background":
                        b10 = 0;
                    case "xmlhttprequest":
                        b10 = 1;
                    case "object":
                        b10 = 2;
                    case "third-party":
                        b10 = 3;
                    case "script":
                        b10 = 4;
                    case "webrtc":
                        b10 = 5;
                    case "genericblock":
                        b10 = 6;
                    case "websocket":
                        b10 = 7;
                    case "elemhide":
                        b10 = 8;
                    case "csp":
                        b10 = 9;
                    case "dtd":
                        b10 = 10;
                    case "xbl":
                        b10 = 11;
                    case "font":
                        b10 = 12;
                    case "ping":
                        b10 = 13;
                    case "image":
                        b10 = 14;
                    case "media":
                        b10 = 15;
                    case "other":
                        b10 = 16;
                    case "popup":
                        b10 = 17;
                    case "stylesheet":
                        b10 = 18;
                    case "object-subrequest":
                        b10 = 19;
                    case "document":
                        b10 = 20;
                    case "generichide":
                        b10 = 21;
                    case "subdocument":
                        b10 = 22;
                    default:
                        switch (b10) {
                            case 0:
                            case 14:
                                i17 = 64;
                                if (i17 <= 0) {
                                    if (z11) {
                                        if ((i16 & 32752) == 0) {
                                            i16 = 32752;
                                        }
                                        i16 &= i17 ^ (-1);
                                    } else {
                                        i16 |= i17;
                                    }
                                }
                                i15 = iIndexOf3 + 1;
                                break;
                            case 1:
                                i17 = 16384;
                                if (i17 <= 0) {
                                    if (z11) {
                                        if ((i16 & 32752) == 0) {
                                            i16 = 32752;
                                        }
                                        i16 &= i17 ^ (-1);
                                    } else {
                                        i16 |= i17;
                                    }
                                }
                                i15 = iIndexOf3 + 1;
                                break;
                            case 2:
                            case 5:
                            case 6:
                            case 8:
                            case 9:
                            case 13:
                            case 19:
                            case 21:
                                z10 = true;
                                i17 = 0;
                                if (i17 <= 0) {
                                    if (z11) {
                                        if ((i16 & 32752) == 0) {
                                            i16 = 32752;
                                        }
                                        i16 &= i17 ^ (-1);
                                    } else {
                                        i16 |= i17;
                                    }
                                }
                                i15 = iIndexOf3 + 1;
                                break;
                            case 3:
                                i11 |= z11 ? 4 : 2;
                                if (i17 <= 0) {
                                    if (z11) {
                                        if ((i16 & 32752) == 0) {
                                            i16 = 32752;
                                        }
                                        i16 &= i17 ^ (-1);
                                    } else {
                                        i16 |= i17;
                                    }
                                }
                                i15 = iIndexOf3 + 1;
                                break;
                            case 4:
                                i17 = 32;
                                if (i17 <= 0) {
                                    if (z11) {
                                        if ((i16 & 32752) == 0) {
                                            i16 = 32752;
                                        }
                                        i16 &= i17 ^ (-1);
                                    } else {
                                        i16 |= i17;
                                    }
                                }
                                i15 = iIndexOf3 + 1;
                                break;
                            case 7:
                                i17 = 8192;
                                if (i17 <= 0) {
                                    if (z11) {
                                        if ((i16 & 32752) == 0) {
                                            i16 = 32752;
                                        }
                                        i16 &= i17 ^ (-1);
                                    } else {
                                        i16 |= i17;
                                    }
                                }
                                i15 = iIndexOf3 + 1;
                                break;
                            case 10:
                            case 11:
                            case 16:
                                i17 = 16;
                                if (i17 <= 0) {
                                    if (z11) {
                                        if ((i16 & 32752) == 0) {
                                            i16 = 32752;
                                        }
                                        i16 &= i17 ^ (-1);
                                    } else {
                                        i16 |= i17;
                                    }
                                }
                                i15 = iIndexOf3 + 1;
                                break;
                            case 12:
                                i17 = 2048;
                                if (i17 <= 0) {
                                    if (z11) {
                                        if ((i16 & 32752) == 0) {
                                            i16 = 32752;
                                        }
                                        i16 &= i17 ^ (-1);
                                    } else {
                                        i16 |= i17;
                                    }
                                }
                                i15 = iIndexOf3 + 1;
                                break;
                            case 15:
                                i17 = 1024;
                                if (i17 <= 0) {
                                    if (z11) {
                                        if ((i16 & 32752) == 0) {
                                            i16 = 32752;
                                        }
                                        i16 &= i17 ^ (-1);
                                    } else {
                                        i16 |= i17;
                                    }
                                }
                                i15 = iIndexOf3 + 1;
                                break;
                            case 17:
                                i17 = 4096;
                                if (i17 <= 0) {
                                    if (z11) {
                                        if ((i16 & 32752) == 0) {
                                            i16 = 32752;
                                        }
                                        i16 &= i17 ^ (-1);
                                    } else {
                                        i16 |= i17;
                                    }
                                }
                                i15 = iIndexOf3 + 1;
                                break;
                            case 18:
                                i17 = 128;
                                if (i17 <= 0) {
                                    if (z11) {
                                        if ((i16 & 32752) == 0) {
                                            i16 = 32752;
                                        }
                                        i16 &= i17 ^ (-1);
                                    } else {
                                        i16 |= i17;
                                    }
                                }
                                i15 = iIndexOf3 + 1;
                                break;
                            case 20:
                                i17 = 512;
                                if (i17 <= 0) {
                                    if (z11) {
                                        if ((i16 & 32752) == 0) {
                                            i16 = 32752;
                                        }
                                        i16 &= i17 ^ (-1);
                                    } else {
                                        i16 |= i17;
                                    }
                                }
                                i15 = iIndexOf3 + 1;
                                break;
                            case 22:
                                i17 = 256;
                                if (i17 <= 0) {
                                    if (z11) {
                                        if ((i16 & 32752) == 0) {
                                            i16 = 32752;
                                        }
                                        i16 &= i17 ^ (-1);
                                    } else {
                                        i16 |= i17;
                                    }
                                }
                                i15 = iIndexOf3 + 1;
                                break;
                            default:
                                if (strTrim.startsWith("domain=", i15)) {
                                    dVar2.k(b5.c.f(strTrim.substring(i15 + 7, iIndexOf3), '|'));
                                } else {
                                    if (strTrim.indexOf(61, i15) > 0) {
                                        return dVar;
                                    }
                                    z10 = true;
                                }
                                i17 = 0;
                                if (i17 <= 0) {
                                    if (z11) {
                                        if ((i16 & 32752) == 0) {
                                            i16 = 32752;
                                        }
                                        i16 &= i17 ^ (-1);
                                    } else {
                                        i16 |= i17;
                                    }
                                }
                                i15 = iIndexOf3 + 1;
                                break;
                        }
                }
            }
            if (z10 && i16 == 0) {
                return dVar;
            }
            i12 = i16;
        } else {
            i12 = 0;
        }
        dVar2.l(i12 | i11);
        return dVar2;
    }

    public String b() {
        return this.f13649a;
    }

    public String[] c() {
        return this.f13650b;
    }

    public int d() {
        return this.f13651c;
    }

    public int e() {
        return this.f13651c & 32752;
    }

    public boolean equals(Object obj) {
        String str;
        if (this == obj) {
            return true;
        }
        if (obj != null && d.class == obj.getClass()) {
            d dVar = (d) obj;
            if (this.f13651c == dVar.f13651c && ((((str = this.f13649a) == null && dVar.f13649a == null) || (str != null && str.equals(dVar.f13649a))) && Arrays.equals(this.f13650b, dVar.f13650b))) {
                return true;
            }
        }
        return false;
    }

    public int f() {
        return this.f13651c & 6;
    }

    public boolean g() {
        return (this.f13651c & 1) != 0;
    }

    public boolean h(String str, String str2, int i10, boolean z10) {
        if (e() != 0 && (i10 & e()) == 0) {
            return false;
        }
        if (f() != 0) {
            if (((f() & 2) == 0) == z10) {
                return false;
            }
        }
        String[] strArr = this.f13650b;
        if (strArr != null && strArr.length > 0) {
            if (str2 != null && !str2.isEmpty()) {
                boolean z11 = false;
                for (String str3 : this.f13650b) {
                    if (!str3.isEmpty()) {
                        if (str3.charAt(0) != '~') {
                            if (str2.contains(str3)) {
                                z11 = true;
                                break;
                            }
                        } else {
                            if (str2.contains(str3.substring(1))) {
                                return false;
                            }
                            z11 = true;
                        }
                    }
                }
                if (!z11) {
                    return false;
                }
            } else if (this.f13650b[0].charAt(0) != '~') {
                return false;
            }
        }
        String str4 = this.f13649a;
        if (str4 == null || str4.isEmpty()) {
            return true;
        }
        for (int i11 = 0; i11 < this.f13649a.length(); i11++) {
            char cCharAt = this.f13649a.charAt(i11);
            if (cCharAt == '*' || cCharAt == '^' || cCharAt == '|') {
                return b5.c.u(b5.c.w(this.f13649a), str);
            }
        }
        return str.contains(this.f13649a);
    }

    public int hashCode() {
        String str = this.f13649a;
        return ((((str == null ? 0 : str.hashCode()) * 31) + this.f13651c) * 31) + Arrays.hashCode(this.f13650b);
    }

    public void j(String str) {
        this.f13649a = str;
    }

    public void k(String[] strArr) {
        this.f13650b = strArr;
    }

    public void l(int i10) {
        this.f13651c = i10;
    }

    public String m() {
        String[] strArr;
        StringBuilder sb2 = new StringBuilder();
        if (g()) {
            sb2.append('@');
            sb2.append('@');
        }
        if (b() != null) {
            if (b().startsWith("|") || b().startsWith("http://") || b().startsWith("https://")) {
                sb2.append('|');
                sb2.append(b());
            } else {
                sb2.append(b());
            }
        }
        if ((this.f13651c & (-2)) != 0 || ((strArr = this.f13650b) != null && strArr.length > 0)) {
            sb2.append('$');
        }
        int iE = e();
        boolean z10 = a(iE) > 5;
        if (iE != 0) {
            int[] iArr = {32, 16, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384};
            String[] strArr2 = {"script", "other", "image", "stylesheet", "subdocument", "document", "media", "font", "popup", "websocket", "xmlhttprequest"};
            for (int i10 = 0; i10 < 11; i10++) {
                if (z10 && (iArr[i10] & iE) == 0) {
                    sb2.append('~');
                    sb2.append(strArr2[i10]);
                    sb2.append(',');
                }
                if (!z10) {
                    int i11 = iArr[i10];
                    if ((iE & i11) == i11) {
                        sb2.append(strArr2[i10]);
                        sb2.append(',');
                    }
                }
            }
        }
        if ((this.f13651c & 2) == 2) {
            sb2.append("third-party,");
        }
        if ((this.f13651c & 4) == 4) {
            sb2.append("~third-party,");
        }
        if (this.f13650b != null) {
            sb2.append("domain=");
            for (int i12 = 0; i12 < this.f13650b.length; i12++) {
                if (i12 != 0) {
                    sb2.append('|');
                }
                sb2.append(this.f13650b[i12]);
            }
        }
        return sb2.toString();
    }

    public String toString() {
        return "Filter{content='" + this.f13649a + "', domains=" + Arrays.toString(this.f13650b) + ", flags=0x" + Integer.toHexString(this.f13651c) + ", isException=" + g() + '}';
    }

    public d(String str) {
        this(str, 0);
    }

    public d(String str, int i10) {
        this(str, null, i10);
    }

    public d(String str, String[] strArr, int i10) {
        this.f13649a = str;
        this.f13650b = strArr;
        this.f13651c = i10;
    }
}
