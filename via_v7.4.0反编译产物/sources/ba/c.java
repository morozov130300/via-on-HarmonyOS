package ba;

import i6.i;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
import x9.k;
import z8.b4;
import z8.v0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class c {
    public static b a(b bVar, b bVar2) {
        if (bVar == null || !bVar.s()) {
            return bVar2;
        }
        if (bVar2 == null || !bVar2.s()) {
            return bVar;
        }
        a aVar = new a();
        aVar.S(true);
        if (bVar.j() == -1000) {
            aVar.e0(bVar2.j());
            aVar.Q(bVar2.c(null));
        } else {
            aVar.e0(bVar.j());
            aVar.Q(bVar.c(null));
        }
        aVar.V(bVar.e());
        aVar.T(bVar.d());
        if (!aVar.C() && bVar2.C()) {
            aVar.Z(bVar2.B(false));
        }
        if (!aVar.y() && bVar2.y()) {
            aVar.X(bVar2.x(false));
        }
        if (!aVar.q() && bVar2.q()) {
            aVar.R(bVar2.p(false));
        }
        if (!aVar.m() && bVar2.m()) {
            aVar.M(bVar2.l(false));
        }
        if (!aVar.A() && bVar2.A()) {
            aVar.R(bVar2.z(false));
        }
        if (aVar.b() == 0 && bVar2.b() != 0) {
            aVar.O(bVar2.b());
        }
        if (bVar.i(0) != 0) {
            aVar.d0(bVar.i(0));
            return aVar;
        }
        aVar.d0(bVar2.i(0));
        return aVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0096  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void b(int i10, int[] iArr) {
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        if (iArr == null || iArr.length < 2 || i10 == 0 || (i11 = i10 >> 2) == 0) {
            return;
        }
        if ((i10 & 3) != 0) {
            i12 = (i10 & 2) != 0 ? 1 : 0;
            int i18 = (i10 & 1) != 0 ? 1 : 0;
            if ((i11 & 3) != 0) {
                i12 |= (i11 & 2) != 0 ? 2 : 0;
                i18 |= (i11 & 1) != 0 ? 2 : 0;
            }
            i13 = i10 >> 4;
            if ((i13 & 3) != 0) {
                i12 |= (i13 & 2) != 0 ? 4 : 0;
                i18 |= (i13 & 1) != 0 ? 0 : 4;
            }
            i14 = i10 >> 6;
            if ((i14 & 3) != 0) {
                i12 |= (i14 & 2) != 0 ? 8 : 0;
                i18 |= (i14 & 1) == 0 ? 0 : 8;
            }
            i15 = i10 >> 8;
            if ((i15 & 3) != 0) {
                i12 |= (i15 & 2) != 0 ? 16 : 0;
                i18 |= (i15 & 1) == 0 ? 0 : 16;
            }
            i16 = i10 >> 10;
            if ((i16 & 3) != 0) {
                i12 |= (i16 & 2) != 0 ? 32 : 0;
                i18 |= (i16 & 1) == 0 ? 0 : 32;
            }
            i17 = i10 >> 12;
            if ((i17 & 3) != 0) {
                if (i17 == 3) {
                    i12 |= 128;
                    i18 |= 128;
                } else {
                    i12 |= 64;
                    i18 |= i17 == 2 ? 64 : 0;
                }
            }
            iArr[0] = i12;
            iArr[1] = i18;
        }
        i12 = 0;
        if ((i11 & 3) != 0) {
        }
        i13 = i10 >> 4;
        if ((i13 & 3) != 0) {
        }
        i14 = i10 >> 6;
        if ((i14 & 3) != 0) {
        }
        i15 = i10 >> 8;
        if ((i15 & 3) != 0) {
        }
        i16 = i10 >> 10;
        if ((i16 & 3) != 0) {
        }
        i17 = i10 >> 12;
        if ((i17 & 3) != 0) {
        }
        iArr[0] = i12;
        iArr[1] = i18;
    }

    public static a c(b bVar) {
        a aVar = new a();
        aVar.Q(bVar.c(null));
        aVar.e0(bVar.j());
        aVar.T(bVar.d());
        aVar.V(bVar.e());
        aVar.d0(bVar.i(0));
        return aVar;
    }

    public static String d(String str) {
        return v0.h(str);
    }

    public static String e(String str) {
        String strD = d(str);
        return (strD == null || strD.isEmpty() || strD.equals(str)) ? str : String.format(Locale.ROOT, "%s (%s)", str, strD);
    }

    public static String f(String str) {
        return i.f7005a.b(str);
    }

    public static b g(JSONObject jSONObject) {
        if (!jSONObject.has("flag")) {
            return null;
        }
        a aVar = new a();
        w.d dVarC = k.c(jSONObject.optInt("uac"), jSONObject.optString("ua"));
        aVar.e0(((Integer) dVarC.f13207a).intValue());
        if (b4.f(((Integer) dVarC.f13207a).intValue())) {
            aVar.Q((String) dVarC.f13208b);
        }
        int[] iArr = new int[2];
        b(jSONObject.optInt("flag", 0), iArr);
        aVar.T(iArr[0]);
        aVar.V(iArr[1]);
        return aVar;
    }

    public static b h(JSONObject jSONObject) {
        if (!jSONObject.has("uastring") && !jSONObject.has("uachoice")) {
            return null;
        }
        a aVar = new a();
        aVar.e0(jSONObject.optInt("uachoice", -1000));
        aVar.Q(jSONObject.optString("uastring", ""));
        int[] iArr = new int[2];
        b(jSONObject.optInt("flag", 0), iArr);
        aVar.T(iArr[0]);
        aVar.V(iArr[1]);
        return aVar;
    }

    public static b i(JSONObject jSONObject) {
        if (!jSONObject.has("flags")) {
            return null;
        }
        a aVar = new a();
        aVar.e0(jSONObject.optInt("uachoice", -1000));
        aVar.Q(jSONObject.optString("uastring", ""));
        aVar.T(jSONObject.optInt("enabled", 0));
        aVar.d0(jSONObject.optInt("textsize", 0));
        aVar.V(jSONObject.optInt("flags", 0));
        return aVar;
    }

    public static b j(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return null;
        }
        b bVarI = i(jSONObject);
        if (bVarI != null) {
            return bVarI;
        }
        b bVarH = h(jSONObject);
        return bVarH != null ? bVarH : g(jSONObject);
    }

    public static b k(String str) {
        if (str != null && !str.isEmpty()) {
            try {
                return j(new JSONObject(str));
            } catch (JSONException e10) {
                pc.a.i(e10);
            }
        }
        return null;
    }

    public static JSONObject l(b bVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            String strC = bVar.c(null);
            if (strC != null && !strC.isEmpty()) {
                jSONObject.put("uastring", strC);
            }
            if (bVar.j() != -1000) {
                jSONObject.put("uachoice", bVar.j());
            }
            if (bVar.d() != 0) {
                jSONObject.put("enabled", bVar.d());
            }
            if (bVar.i(0) != 0) {
                jSONObject.put("textsize", bVar.i(0));
            }
            jSONObject.put("flags", bVar.e());
            return jSONObject;
        } catch (JSONException e10) {
            pc.a.i(e10);
            return jSONObject;
        }
    }

    public static String m(b bVar) {
        return l(bVar).toString();
    }
}
