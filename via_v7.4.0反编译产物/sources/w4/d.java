package w4;

import java.util.Arrays;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class d implements b {

    /* renamed from: a, reason: collision with root package name */
    public String f13260a;

    /* renamed from: b, reason: collision with root package name */
    public String[] f13261b;

    /* renamed from: c, reason: collision with root package name */
    public int f13262c;

    public d() {
        this(null);
    }

    public d(String str) {
        this(str, 0);
    }

    public d(String str, int i10) {
        this(str, null, i10);
    }

    public d(String str, String[] strArr, int i10) {
        this.f13260a = str;
        this.f13261b = strArr;
        this.f13262c = i10;
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
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:157:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x025a  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0271  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0285 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
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
            Object obj = null;
            if (strTrim.charAt(i10) == '|') {
                int i14 = i10 + 1;
                i10 = (strTrim.charAt(i14) == '|' && strTrim.charAt(i10 + 2) == '*') ? i10 + 3 : i14;
            } else if (strTrim.charAt(i10) == '*') {
                i10++;
            }
            dVar = obj;
            if (strTrim.charAt(i13 - 1) == '*') {
                i13--;
                dVar = obj;
            }
        } else {
            dVar = 0;
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
                char c10 = '\uffff';
                switch (strSubstring.hashCode()) {
                    case -1332194002:
                        if (strSubstring.equals("background")) {
                            c10 = 0;
                        }
                        switch (c10) {
                            case 0:
                            case 14:
                                i17 = 64;
                                if (i17 > 0) {
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
                            case 1:
                                i17 = 16384;
                                if (i17 > 0) {
                                }
                                i15 = iIndexOf3 + 1;
                                break;
                            case 2:
                            case 5:
                            case 6:
                            case '\b':
                            case '\t':
                            case '\r':
                            case 19:
                            case 21:
                                z10 = true;
                                i17 = 0;
                                if (i17 > 0) {
                                }
                                i15 = iIndexOf3 + 1;
                                break;
                            case WebSettingsBoundaryInterface.AttributionBehavior.APP_SOURCE_AND_APP_TRIGGER /* 3 */:
                                i11 |= z11 ? 4 : 2;
                                if (i17 > 0) {
                                }
                                i15 = iIndexOf3 + 1;
                                break;
                            case 4:
                                i17 = 32;
                                if (i17 > 0) {
                                }
                                i15 = iIndexOf3 + 1;
                                break;
                            case 7:
                                i17 = 8192;
                                if (i17 > 0) {
                                }
                                i15 = iIndexOf3 + 1;
                                break;
                            case '\n':
                            case 11:
                            case 16:
                                i17 = 16;
                                if (i17 > 0) {
                                }
                                i15 = iIndexOf3 + 1;
                                break;
                            case '\f':
                                i17 = 2048;
                                if (i17 > 0) {
                                }
                                i15 = iIndexOf3 + 1;
                                break;
                            case 15:
                                i17 = 1024;
                                if (i17 > 0) {
                                }
                                i15 = iIndexOf3 + 1;
                                break;
                            case 17:
                                i17 = 4096;
                                if (i17 > 0) {
                                }
                                i15 = iIndexOf3 + 1;
                                break;
                            case 18:
                                i17 = 128;
                                if (i17 > 0) {
                                }
                                i15 = iIndexOf3 + 1;
                                break;
                            case 20:
                                i17 = 512;
                                if (i17 > 0) {
                                }
                                i15 = iIndexOf3 + 1;
                                break;
                            case 22:
                                i17 = 256;
                                if (i17 > 0) {
                                }
                                i15 = iIndexOf3 + 1;
                                break;
                            default:
                                if (strTrim.startsWith("domain=", i15)) {
                                    dVar2.k(b5.c.f(strTrim.substring(i15 + 7, iIndexOf3), '|'));
                                    i17 = 0;
                                    if (i17 > 0) {
                                    }
                                    i15 = iIndexOf3 + 1;
                                } else {
                                    if (strTrim.indexOf(61, i15) > 0) {
                                        return dVar;
                                    }
                                    z10 = true;
                                    i17 = 0;
                                    if (i17 > 0) {
                                    }
                                    i15 = iIndexOf3 + 1;
                                }
                                break;
                        }
                    case -1112093552:
                        if (strSubstring.equals("xmlhttprequest")) {
                            c10 = 1;
                        }
                        switch (c10) {
                        }
                    case -1023368385:
                        if (strSubstring.equals("object")) {
                            c10 = 2;
                        }
                        switch (c10) {
                        }
                    case -991966464:
                        if (strSubstring.equals("third-party")) {
                            c10 = 3;
                        }
                        switch (c10) {
                        }
                    case -907685685:
                        if (strSubstring.equals("script")) {
                            c10 = 4;
                        }
                        switch (c10) {
                        }
                    case -791789939:
                        if (strSubstring.equals("webrtc")) {
                            c10 = 5;
                        }
                        switch (c10) {
                        }
                    case -260159210:
                        if (strSubstring.equals("genericblock")) {
                            c10 = 6;
                        }
                        switch (c10) {
                        }
                    case -229565497:
                        if (strSubstring.equals("websocket")) {
                            c10 = 7;
                        }
                        switch (c10) {
                        }
                    case -8255151:
                        if (strSubstring.equals("elemhide")) {
                            c10 = '\b';
                        }
                        switch (c10) {
                        }
                    case 98816:
                        if (strSubstring.equals("csp")) {
                            c10 = '\t';
                        }
                        switch (c10) {
                        }
                    case 99796:
                        if (strSubstring.equals("dtd")) {
                            c10 = '\n';
                        }
                        switch (c10) {
                        }
                    case 118466:
                        if (strSubstring.equals("xbl")) {
                            c10 = 11;
                        }
                        switch (c10) {
                        }
                    case 3148879:
                        if (strSubstring.equals("font")) {
                            c10 = '\f';
                        }
                        switch (c10) {
                        }
                    case 3441010:
                        if (strSubstring.equals("ping")) {
                            c10 = '\r';
                        }
                        switch (c10) {
                        }
                    case 100313435:
                        if (strSubstring.equals("image")) {
                            c10 = 14;
                        }
                        switch (c10) {
                        }
                    case 103772132:
                        if (strSubstring.equals("media")) {
                            c10 = 15;
                        }
                        switch (c10) {
                        }
                    case 106069776:
                        if (strSubstring.equals("other")) {
                            c10 = 16;
                        }
                        switch (c10) {
                        }
                    case 106852524:
                        if (strSubstring.equals("popup")) {
                            c10 = 17;
                        }
                        switch (c10) {
                        }
                    case 158213710:
                        if (strSubstring.equals("stylesheet")) {
                            c10 = 18;
                        }
                        switch (c10) {
                        }
                    case 268257181:
                        if (strSubstring.equals("object-subrequest")) {
                            c10 = 19;
                        }
                        switch (c10) {
                        }
                    case 861720859:
                        if (strSubstring.equals("document")) {
                            c10 = 20;
                        }
                        switch (c10) {
                        }
                    case 1100161945:
                        if (strSubstring.equals("generichide")) {
                            c10 = 21;
                        }
                        switch (c10) {
                        }
                    case 2111590235:
                        if (strSubstring.equals("subdocument")) {
                            c10 = 22;
                        }
                        switch (c10) {
                        }
                    default:
                        switch (c10) {
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
        return this.f13260a;
    }

    public String[] c() {
        return this.f13261b;
    }

    public int d() {
        return this.f13262c;
    }

    public int e() {
        return this.f13262c & 32752;
    }

    public boolean equals(Object obj) {
        String str;
        if (this == obj) {
            return true;
        }
        if (obj != null && d.class == obj.getClass()) {
            d dVar = (d) obj;
            if (this.f13262c == dVar.f13262c && ((((str = this.f13260a) == null && dVar.f13260a == null) || (str != null && str.equals(dVar.f13260a))) && Arrays.equals(this.f13261b, dVar.f13261b))) {
                return true;
            }
        }
        return false;
    }

    public int f() {
        return this.f13262c & 6;
    }

    public boolean g() {
        return (this.f13262c & 1) != 0;
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
        String[] strArr = this.f13261b;
        if (strArr != null && strArr.length > 0) {
            if (str2 != null && !str2.isEmpty()) {
                String[] strArr2 = this.f13261b;
                int length = strArr2.length;
                int i11 = 0;
                boolean z11 = false;
                while (true) {
                    if (i11 >= length) {
                        break;
                    }
                    String str3 = strArr2[i11];
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
                    i11++;
                }
                if (!z11) {
                    return false;
                }
            } else if (this.f13261b[0].charAt(0) != '~') {
                return false;
            }
        }
        String str4 = this.f13260a;
        if (str4 == null || str4.isEmpty()) {
            return true;
        }
        for (int i12 = 0; i12 < this.f13260a.length(); i12++) {
            char cCharAt = this.f13260a.charAt(i12);
            if (cCharAt == '*' || cCharAt == '^' || cCharAt == '|') {
                return b5.c.u(b5.c.w(this.f13260a), str);
            }
        }
        return str.contains(this.f13260a);
    }

    public int hashCode() {
        String str = this.f13260a;
        return ((((str == null ? 0 : str.hashCode()) * 31) + this.f13262c) * 31) + Arrays.hashCode(this.f13261b);
    }

    public void j(String str) {
        this.f13260a = str;
    }

    public void k(String[] strArr) {
        this.f13261b = strArr;
    }

    public void l(int i10) {
        this.f13262c = i10;
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
        if ((this.f13262c & (-2)) != 0 || ((strArr = this.f13261b) != null && strArr.length > 0)) {
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
        if ((this.f13262c & 2) == 2) {
            sb2.append("third-party,");
        }
        if ((this.f13262c & 4) == 4) {
            sb2.append("~third-party,");
        }
        if (this.f13261b != null) {
            sb2.append("domain=");
            for (int i12 = 0; i12 < this.f13261b.length; i12++) {
                if (i12 != 0) {
                    sb2.append('|');
                }
                sb2.append(this.f13261b[i12]);
            }
        }
        return sb2.toString();
    }

    public String toString() {
        return "Filter{content='" + this.f13260a + "', domains=" + Arrays.toString(this.f13261b) + ", flags=0x" + Integer.toHexString(this.f13262c) + ", isException=" + g() + '}';
    }
}
