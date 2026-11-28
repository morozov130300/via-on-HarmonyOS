package c6;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class v0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v0 f2112a = new v0();

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f2113a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f2114b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f2115c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f2116d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f2117e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f2118f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f2119g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean f2120h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final boolean f2121i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final boolean f2122j;

        public a(List header) {
            kotlin.jvm.internal.h.f(header, "header");
            this.f2113a = header.size();
            boolean zContains = header.contains("login_uri");
            this.f2114b = zContains;
            int iIndexOf = header.indexOf(zContains ? "login_uri" : "url");
            this.f2115c = iIndexOf;
            int iIndexOf2 = header.indexOf(zContains ? "login_username" : "username");
            this.f2116d = iIndexOf2;
            int iIndexOf3 = header.indexOf(zContains ? "login_password" : "password");
            this.f2117e = iIndexOf3;
            Integer numValueOf = Integer.valueOf(header.indexOf("note"));
            numValueOf = numValueOf.intValue() < 0 ? null : numValueOf;
            this.f2118f = numValueOf != null ? numValueOf.intValue() : header.indexOf("notes");
            this.f2119g = zContains ? header.indexOf("type") : -1;
            boolean zA = kotlin.jvm.internal.h.a(e7.w.E(header, ",", null, null, 0, null, null, 62, null), "name,url,username,password,note");
            this.f2120h = zA;
            this.f2121i = iIndexOf >= 0 && iIndexOf2 >= 0 && iIndexOf3 >= 0;
            this.f2122j = zA || zContains || header.contains("title") || header.contains("name") || header.contains("httprealm");
        }

        public final boolean a(int i10) {
            if (i10 != this.f2113a) {
                return this.f2120h && i10 >= 4;
            }
            return true;
        }

        public final w0 b(List fields) {
            String string;
            String strF;
            kotlin.jvm.internal.h.f(fields, "fields");
            int i10 = this.f2119g;
            if ((i10 >= 0 && !kotlin.jvm.internal.h.a(fields.get(i10), "login")) || ((CharSequence) fields.get(this.f2117e)).length() == 0) {
                return null;
            }
            if (this.f2114b) {
                Iterator it = kotlin.text.z.n0((CharSequence) fields.get(this.f2115c), new char[]{','}, false, 0, 6, null).iterator();
                do {
                    if (!it.hasNext()) {
                        string = null;
                        break;
                    }
                    string = kotlin.text.z.v0((String) it.next()).toString();
                    if (!a2.f1958a.t(string)) {
                        string = null;
                    }
                } while (string == null);
                if (string == null) {
                    return null;
                }
            } else {
                string = (String) fields.get(this.f2115c);
            }
            String str = string;
            if (this.f2120h && !kotlin.text.z.H((CharSequence) fields.get(0), '/', false, 2, null)) {
                strF = (String) fields.get(0);
            } else if (this.f2120h) {
                strF = a2.f1958a.f(str.length() == 0 ? (String) fields.get(0) : str);
            } else {
                a2 a2Var = a2.f1958a;
                if (!a2Var.t(str)) {
                    return null;
                }
                strF = a2Var.f(str);
            }
            String str2 = strF;
            if (str2.length() == 0) {
                return null;
            }
            return new w0(str2, str, (String) fields.get(this.f2116d), (String) fields.get(this.f2117e), (String) e7.w.z(fields, this.f2118f));
        }

        public final boolean c() {
            return this.f2122j;
        }

        public final boolean d() {
            return this.f2121i;
        }
    }

    public static final CharSequence c(String it) {
        kotlin.jvm.internal.h.f(it, "it");
        for (int i10 = 0; i10 < it.length(); i10++) {
            char cCharAt = it.charAt(i10);
            if (cCharAt == ',' || cCharAt == '\"' || cCharAt == '\r' || cCharAt == '\n') {
                return '\"' + kotlin.text.x.z(it, "\"", "\"\"", false, 4, null) + '\"';
            }
        }
        return it;
    }

    public final String b(String str, String str2, String str3, String str4, String str5) {
        if (str == null || str.length() == 0 || str4 == null || str4.length() == 0) {
            return null;
        }
        if (str2 == null || !kotlin.text.z.I(str2, str, false, 2, null)) {
            str2 = "https://" + str + '/';
        }
        if (str3 == null) {
            str3 = "";
        }
        if (str5 == null) {
            str5 = "";
        }
        return e7.w.E(e7.o.k(str, str2, str3, str4, str5), ",", null, null, 0, null, new p7.l() { // from class: c6.u0
            @Override // p7.l
            public final Object invoke(Object obj) {
                return v0.c((String) obj);
            }
        }, 30, null);
    }

    public final List d(p7.a next) throws IOException {
        kotlin.jvm.internal.h.f(next, "next");
        ArrayList arrayList = new ArrayList();
        ArrayList<String> arrayList2 = new ArrayList();
        StringBuilder sb2 = new StringBuilder();
        int iIntValue = ((Number) next.invoke()).intValue();
        if (iIntValue == 65279) {
            iIntValue = ((Number) next.invoke()).intValue();
        }
        a aVar = null;
        while (true) {
            if (iIntValue == 34) {
                iIntValue = ((Number) next.invoke()).intValue();
                while (iIntValue >= 0) {
                    if (iIntValue != 34 || (iIntValue = ((Number) next.invoke()).intValue()) == 34) {
                        sb2.append((char) iIntValue);
                        iIntValue = ((Number) next.invoke()).intValue();
                    }
                }
                return null;
            }
            while (iIntValue >= 0 && iIntValue != 44 && iIntValue != 13 && iIntValue != 10) {
                if (iIntValue == 34) {
                    return null;
                }
                sb2.append((char) iIntValue);
                iIntValue = ((Number) next.invoke()).intValue();
            }
            String string = sb2.toString();
            kotlin.jvm.internal.h.e(string, "toString(...)");
            arrayList2.add(string);
            kotlin.text.t.j(sb2);
            if (iIntValue == 44) {
                iIntValue = ((Number) next.invoke()).intValue();
            } else {
                if (iIntValue >= 0 && iIntValue != 13 && iIntValue != 10) {
                    return null;
                }
                if (aVar == null) {
                    ArrayList arrayList3 = new ArrayList(e7.p.o(arrayList2, 10));
                    for (String str : arrayList2) {
                        w wVar = w.f2124a;
                        StringBuilder sb3 = new StringBuilder();
                        for (int i10 = 0; i10 < str.length(); i10++) {
                            char cCharAt = str.charAt(i10);
                            if (!wVar.e(cCharAt)) {
                                sb3.append(cCharAt);
                            }
                        }
                        String lowerCase = sb3.toString().toLowerCase(Locale.ROOT);
                        kotlin.jvm.internal.h.e(lowerCase, "toLowerCase(...)");
                        arrayList3.add(lowerCase);
                    }
                    a aVar2 = new a(arrayList3);
                    if (!aVar2.d()) {
                        return null;
                    }
                    aVar = aVar2;
                } else if (arrayList2.size() > 1 || ((CharSequence) arrayList2.get(0)).length() > 0) {
                    if (aVar.a(arrayList2.size())) {
                        w0 w0VarB = aVar.b(arrayList2);
                        if (w0VarB != null) {
                            arrayList.add(w0VarB);
                        }
                    } else if (!aVar.c()) {
                        return null;
                    }
                }
                arrayList2.clear();
                if (iIntValue < 0) {
                    return arrayList;
                }
                if (iIntValue != 13 || (iIntValue = ((Number) next.invoke()).intValue()) == 10) {
                    iIntValue = ((Number) next.invoke()).intValue();
                }
            }
        }
    }
}
