package va;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class d1 {
    public static String a(String str) {
        if (str == null) {
            return "";
        }
        int length = str.length();
        StringBuilder sb2 = null;
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt = str.charAt(i10);
            if (cCharAt == ',' || cCharAt == '\"' || cCharAt == '\n' || cCharAt == '\r') {
                if (sb2 == null) {
                    sb2 = new StringBuilder();
                    sb2.append('\"');
                    sb2.append(str.substring(0, i10));
                }
                if (cCharAt == '\"') {
                    sb2.append("\"");
                }
            }
            if (sb2 != null) {
                sb2.append(cCharAt);
            }
        }
        if (sb2 == null) {
            return str;
        }
        sb2.append('\"');
        return sb2.toString();
    }

    public static String b(v9.f fVar) {
        if (fVar == null || g6.p.f(fVar.e()) || g6.p.f(fVar.c())) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(a(fVar.c()));
        sb2.append(',');
        String strG = fVar.g();
        if (strG == null || !strG.contains(fVar.c())) {
            strG = "https://" + fVar.c() + "/";
        }
        sb2.append(a(strG));
        sb2.append(',');
        sb2.append(a(fVar.h()));
        sb2.append(',');
        sb2.append(a(fVar.e()));
        sb2.append(',');
        sb2.append(a(fVar.d()));
        return sb2.toString();
    }

    public static int c(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        String strD = d(str);
        if ("name,url,username,password,note".equals(strD)) {
            return 1;
        }
        if ("\"url\",\"username\",\"password\",\"httprealm\",\"formactionorigin\",\"guid\",\"timecreated\",\"timelastused\",\"timepasswordchanged\"".equals(strD)) {
            return 2;
        }
        if ("title,url,username,password,notes,otpauth".equals(strD)) {
            return 3;
        }
        if ("title,url,username,password".equals(strD) || "name,url,username,password".equals(strD)) {
            return 4;
        }
        if ("collections,type,name,notes,fields,reprompt,login_uri,login_username,login_password,login_totp".equals(strD)) {
            return 5;
        }
        if ("folder,favorite,type,name,notes,fields,reprompt,login_uri,login_username,login_password,login_totp".equals(strD)) {
            return 6;
        }
        return "title,username,password,url,notes,totp".equals(strD) ? 7 : 0;
    }

    public static String d(String str) {
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < str.length(); i10++) {
            char cCharAt = str.charAt(i10);
            if (!i6.f.f6990a.e(cCharAt)) {
                sb2.append(Character.toLowerCase(cCharAt));
            }
        }
        return sb2.toString();
    }

    public static String e(String str) {
        i6.i0 i0Var = i6.i0.f7006a;
        if (i0Var.s(str)) {
            return i0Var.e(str);
        }
        return null;
    }

    public static v9.f f(String str) {
        List listO = o(str);
        if (listO.size() == 11 && "login".equals(listO.get(2))) {
            v9.f fVar = new v9.f();
            String strN = n((String) listO.get(7));
            fVar.k(e(strN));
            fVar.m((String) listO.get(9));
            if (!g6.p.f(fVar.c()) && !g6.p.f(fVar.e())) {
                fVar.j(UUID.randomUUID().toString());
                fVar.o(strN);
                fVar.p((String) listO.get(8));
                fVar.l((String) listO.get(4));
                fVar.i(System.currentTimeMillis());
                fVar.n(fVar.a());
                return fVar;
            }
        }
        return null;
    }

    public static v9.f g(String str) {
        List listO = o(str);
        if (listO.size() == 10 && "login".equals(listO.get(1))) {
            v9.f fVar = new v9.f();
            String strN = n((String) listO.get(6));
            fVar.k(e(strN));
            fVar.m((String) listO.get(8));
            if (!g6.p.f(fVar.c()) && !g6.p.f(fVar.e())) {
                fVar.j(UUID.randomUUID().toString());
                fVar.o(strN);
                fVar.p((String) listO.get(7));
                fVar.l((String) listO.get(3));
                fVar.i(System.currentTimeMillis());
                fVar.n(fVar.a());
                return fVar;
            }
        }
        return null;
    }

    public static v9.f h(String str) {
        List listO = o(str);
        if (listO.size() < 4) {
            return null;
        }
        v9.f fVar = new v9.f();
        String strE = (String) listO.get(0);
        String str2 = (String) listO.get(1);
        if (strE.contains("/")) {
            i6.i0 i0Var = i6.i0.f7006a;
            if (!str2.isEmpty()) {
                strE = str2;
            }
            strE = i0Var.e(strE);
        }
        fVar.k(strE);
        fVar.m((String) listO.get(3));
        if (g6.p.f(fVar.c()) || g6.p.f(fVar.e())) {
            return null;
        }
        fVar.j(UUID.randomUUID().toString());
        fVar.o(str2);
        fVar.p((String) listO.get(2));
        if (listO.size() > 4) {
            fVar.l((String) listO.get(4));
        }
        fVar.i(System.currentTimeMillis());
        fVar.n(fVar.a());
        return fVar;
    }

    public static v9.f i(String str, int i10) {
        switch (i10) {
            case 1:
                return h(str);
            case 2:
                return j(str);
            case WebSettingsBoundaryInterface.AttributionBehavior.APP_SOURCE_AND_APP_TRIGGER /* 3 */:
                return m(str);
            case 4:
                return l(str);
            case 5:
                return g(str);
            case 6:
                return f(str);
            case 7:
                return k(str);
            default:
                return null;
        }
    }

    public static v9.f j(String str) {
        List listO = o(str);
        if (listO.size() != 9) {
            return null;
        }
        v9.f fVar = new v9.f();
        String str2 = (String) listO.get(0);
        fVar.k(e(str2));
        fVar.m((String) listO.get(2));
        if (g6.p.f(fVar.c()) || g6.p.f(fVar.e())) {
            return null;
        }
        fVar.j(UUID.randomUUID().toString());
        fVar.o(str2);
        fVar.p((String) listO.get(1));
        fVar.i(System.currentTimeMillis());
        fVar.n(fVar.a());
        return fVar;
    }

    public static v9.f k(String str) {
        List listO = o(str);
        if (listO.size() != 6) {
            return null;
        }
        v9.f fVar = new v9.f();
        String str2 = (String) listO.get(3);
        fVar.k(e(str2));
        fVar.m((String) listO.get(2));
        if (g6.p.f(fVar.c()) || g6.p.f(fVar.e())) {
            return null;
        }
        fVar.j(UUID.randomUUID().toString());
        fVar.o(str2);
        fVar.p((String) listO.get(1));
        fVar.l((String) listO.get(4));
        fVar.i(System.currentTimeMillis());
        fVar.n(fVar.a());
        return fVar;
    }

    public static v9.f l(String str) {
        List listO = o(str);
        if (listO.size() != 4) {
            return null;
        }
        v9.f fVar = new v9.f();
        String str2 = (String) listO.get(1);
        fVar.k(e(str2));
        fVar.m((String) listO.get(3));
        if (g6.p.f(fVar.c()) || g6.p.f(fVar.e())) {
            return null;
        }
        fVar.j(UUID.randomUUID().toString());
        fVar.o(str2);
        fVar.p((String) listO.get(2));
        fVar.i(System.currentTimeMillis());
        fVar.n(fVar.a());
        return fVar;
    }

    public static v9.f m(String str) {
        List listO = o(str);
        if (listO.size() != 6) {
            return null;
        }
        v9.f fVar = new v9.f();
        String str2 = (String) listO.get(1);
        fVar.k(e(str2));
        fVar.m((String) listO.get(3));
        if (g6.p.f(fVar.c()) || g6.p.f(fVar.e())) {
            return null;
        }
        fVar.j(UUID.randomUUID().toString());
        fVar.o(str2);
        fVar.p((String) listO.get(2));
        fVar.l((String) listO.get(4));
        fVar.i(System.currentTimeMillis());
        fVar.n(fVar.a());
        return fVar;
    }

    public static String n(String str) {
        for (String str2 : g6.p.o(str, ',')) {
            if (i6.i0.f7006a.s(str2)) {
                return str2;
            }
        }
        return null;
    }

    public static List o(String str) {
        int i10;
        ArrayList arrayList = new ArrayList();
        StringBuilder sb2 = new StringBuilder();
        int i11 = 0;
        boolean z10 = false;
        while (i11 < str.length()) {
            char cCharAt = str.charAt(i11);
            if (cCharAt == '\"') {
                if (z10 && (i10 = i11 + 1) < str.length() && str.charAt(i10) == '\"') {
                    sb2.append('\"');
                    i11 = i10;
                } else {
                    z10 = !z10;
                }
            } else if (cCharAt != ',' || z10) {
                sb2.append(cCharAt);
            } else {
                arrayList.add(sb2.toString());
                sb2.setLength(0);
            }
            i11++;
        }
        arrayList.add(sb2.toString());
        return arrayList;
    }
}
