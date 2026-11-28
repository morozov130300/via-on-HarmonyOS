package y9;

import c6.b0;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
import v9.k;
import x8.c4;
import x8.v0;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
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

    /* JADX WARN: Code duplicated, block: B:22:0x0027  */
    /* JADX WARN: Code duplicated, block: B:24:0x002b  */
    /* JADX WARN: Code duplicated, block: B:25:0x002d  */
    /* JADX WARN: Code duplicated, block: B:28:0x0032  */
    /* JADX WARN: Code duplicated, block: B:29:0x0034  */
    /* JADX WARN: Code duplicated, block: B:33:0x003c  */
    /* JADX WARN: Code duplicated, block: B:35:0x0041  */
    /* JADX WARN: Code duplicated, block: B:36:0x0043  */
    /* JADX WARN: Code duplicated, block: B:40:0x0049  */
    /* JADX WARN: Code duplicated, block: B:44:0x0051  */
    /* JADX WARN: Code duplicated, block: B:46:0x0057  */
    /* JADX WARN: Code duplicated, block: B:47:0x005a  */
    /* JADX WARN: Code duplicated, block: B:51:0x0060  */
    /* JADX WARN: Code duplicated, block: B:55:0x0068  */
    /* JADX WARN: Code duplicated, block: B:57:0x006e  */
    /* JADX WARN: Code duplicated, block: B:58:0x0071  */
    /* JADX WARN: Code duplicated, block: B:62:0x0077  */
    /* JADX WARN: Code duplicated, block: B:66:0x007f  */
    /* JADX WARN: Code duplicated, block: B:68:0x0085  */
    /* JADX WARN: Code duplicated, block: B:69:0x0088  */
    /* JADX WARN: Code duplicated, block: B:73:0x008e  */
    /* JADX WARN: Code duplicated, block: B:77:0x0096  */
    /* JADX WARN: Code duplicated, block: B:79:0x0099  */
    /* JADX WARN: Code duplicated, block: B:80:0x009e  */
    /* JADX WARN: Code duplicated, block: B:82:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:83:0x00a5  */
    /* JADX WARN: Instruction removed from duplicated block: B:33:0x003c, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:44:0x0051, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:55:0x0068, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:66:0x007f, please report this as an issue */
    public static void b(int i10, int[] iArr) {
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        if (iArr == null || iArr.length < 2 || i10 == 0 || (i11 = i10 >> 2) == 0) {
            return;
        }
        if ((i10 & 3) != 0) {
            i12 = (i10 & 2) != 0 ? 1 : 0;
            i13 = (i10 & 1) != 0 ? 1 : 0;
            if ((i11 & 3) != 0) {
                if ((i11 & 2) != 0) {
                    i24 = 2;
                } else {
                    i24 = 0;
                }
                i12 |= i24;
                if ((i11 & 1) != 0) {
                    i25 = 2;
                } else {
                    i25 = 0;
                }
                i13 |= i25;
            }
            i14 = i10 >> 4;
            if ((i14 & 3) != 0) {
                if ((i14 & 2) != 0) {
                    i23 = 4;
                } else {
                    i23 = 0;
                }
                i12 |= i23;
                i13 |= (i14 & 1) != 0 ? 0 : 4;
            }
            i15 = i10 >> 6;
            if ((i15 & 3) != 0) {
                if ((i15 & 2) != 0) {
                    i22 = 8;
                } else {
                    i22 = 0;
                }
                i12 |= i22;
                i13 |= (i15 & 1) == 0 ? 0 : 8;
            }
            i16 = i10 >> 8;
            if ((i16 & 3) != 0) {
                if ((i16 & 2) != 0) {
                    i21 = 16;
                } else {
                    i21 = 0;
                }
                i12 |= i21;
                i13 |= (i16 & 1) == 0 ? 0 : 16;
            }
            i17 = i10 >> 10;
            if ((i17 & 3) != 0) {
                if ((i17 & 2) != 0) {
                    i20 = 32;
                } else {
                    i20 = 0;
                }
                i12 |= i20;
                i13 |= (i17 & 1) == 0 ? 0 : 32;
            }
            i18 = i10 >> 12;
            if ((i18 & 3) != 0) {
                if (i18 == 3) {
                    i12 |= 128;
                    i13 |= 128;
                } else {
                    i12 |= 64;
                    if (i18 == 2) {
                        i19 = 64;
                    } else {
                        i19 = 0;
                    }
                    i13 |= i19;
                }
            }
            iArr[0] = i12;
            iArr[1] = i13;
        }
        i12 = 0;
        if ((i11 & 3) != 0) {
            if ((i11 & 2) != 0) {
                i24 = 2;
            } else {
                i24 = 0;
            }
            i12 |= i24;
            if ((i11 & 1) != 0) {
                i25 = 2;
            } else {
                i25 = 0;
            }
            i13 |= i25;
        }
        i14 = i10 >> 4;
        if ((i14 & 3) != 0) {
            if ((i14 & 2) != 0) {
                i23 = 4;
            } else {
                i23 = 0;
            }
            i12 |= i23;
            i13 |= (i14 & 1) != 0 ? 0 : 4;
        }
        i15 = i10 >> 6;
        if ((i15 & 3) != 0) {
            if ((i15 & 2) != 0) {
                i22 = 8;
            } else {
                i22 = 0;
            }
            i12 |= i22;
            i13 |= (i15 & 1) == 0 ? 0 : 8;
        }
        i16 = i10 >> 8;
        if ((i16 & 3) != 0) {
            if ((i16 & 2) != 0) {
                i21 = 16;
            } else {
                i21 = 0;
            }
            i12 |= i21;
            i13 |= (i16 & 1) == 0 ? 0 : 16;
        }
        i17 = i10 >> 10;
        if ((i17 & 3) != 0) {
            if ((i17 & 2) != 0) {
                i20 = 32;
            } else {
                i20 = 0;
            }
            i12 |= i20;
            i13 |= (i17 & 1) == 0 ? 0 : 32;
        }
        i18 = i10 >> 12;
        if ((i18 & 3) != 0) {
            if (i18 == 3) {
                i12 |= 128;
                i13 |= 128;
            } else {
                i12 |= 64;
                if (i18 == 2) {
                    i19 = 64;
                } else {
                    i19 = 0;
                }
                i13 |= i19;
            }
        }
        iArr[0] = i12;
        iArr[1] = i13;
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
        return b0.f1960a.e(str);
    }

    public static b g(JSONObject jSONObject) {
        if (!jSONObject.has("flag")) {
            return null;
        }
        a aVar = new a();
        x.d dVarC = k.c(jSONObject.optInt("uac"), jSONObject.optString("ua"));
        aVar.e0(((Integer) dVarC.f14455a).intValue());
        if (c4.g(((Integer) dVarC.f14455a).intValue())) {
            aVar.Q((String) dVarC.f14456b);
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
                tc.a.j(e10);
            }
        }
        return null;
    }

    public static JSONObject l(b bVar) {
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
            tc.a.j(e10);
            return jSONObject;
        }
    }

    public static String m(b bVar) {
        return l(bVar).toString();
    }
}
