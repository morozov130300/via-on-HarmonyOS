package c6;

import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f2031a = new i();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set f2032b = e7.c0.f("meta", "settings", "settingsData", "siteConf", "filters", "script");

    public final boolean a(String name) {
        kotlin.jvm.internal.h.f(name, "name");
        if (name.length() > 0 && !kotlin.jvm.internal.h.a(name, ".") && !kotlin.jvm.internal.h.a(name, "..")) {
            for (int i10 = 0; i10 < name.length(); i10++) {
                char cCharAt = name.charAt(i10);
                if (cCharAt != '/' && cCharAt != '\\' && cCharAt >= ' ') {
                }
            }
            return true;
        }
        return false;
    }

    public final int b(int i10, int i11, int i12) {
        return (i10 & (i12 ^ (-1))) | (i11 & i12);
    }

    public final h c(String line) {
        Integer numK;
        kotlin.jvm.internal.h.f(line, "line");
        Map mapD = k.d(line);
        if (mapD == null) {
            return null;
        }
        Object obj = mapD.get("url");
        String str = obj instanceof String ? (String) obj : null;
        if (str == null) {
            return null;
        }
        Object obj2 = mapD.get("title");
        String str2 = obj2 instanceof String ? (String) obj2 : null;
        if (str2 == null || (numK = kotlin.text.w.k(String.valueOf(mapD.get("order")))) == null) {
            return null;
        }
        int iIntValue = numK.intValue();
        if (str.length() == 0) {
            return null;
        }
        return new h(str, str2, iIntValue);
    }

    public final j d(String line) {
        long jLongValue;
        kotlin.jvm.internal.h.f(line, "line");
        Map mapD = k.d(line);
        if (mapD == null) {
            return null;
        }
        Object obj = mapD.get("url");
        String str = obj instanceof String ? (String) obj : null;
        if (str == null) {
            return null;
        }
        Object obj2 = mapD.get("title");
        String str2 = obj2 instanceof String ? (String) obj2 : null;
        if (str2 == null) {
            return null;
        }
        Object obj3 = mapD.get("updated_at");
        if (str.length() == 0) {
            return null;
        }
        if (obj3 == null) {
            jLongValue = 0;
        } else {
            Long lM = kotlin.text.w.m(obj3.toString());
            if (lM == null) {
                return null;
            }
            jLongValue = lM.longValue();
        }
        return new j(str, str2, jLongValue);
    }

    public final m e(l record) {
        Object objB;
        kotlin.jvm.internal.h.f(record, "record");
        String strA = record.a();
        if (strA == null || !f2032b.contains(strA) || (objB = record.b(strA)) == null) {
            return null;
        }
        return new m(strA, objB);
    }

    public final int f(int i10, boolean z10) {
        int i11 = 129231 & i10;
        int i12 = 98304 | i11;
        if (z10) {
            return 129025 | i11;
        }
        if ((i10 & 6144) != 0) {
            i12 = i11 | 104448;
        }
        return (i10 & 24576) != 0 ? i12 | 24576 : i12;
    }

    public final String g(String url, String title, int i10) {
        kotlin.jvm.internal.h.f(url, "url");
        kotlin.jvm.internal.h.f(title, "title");
        return k.a(kotlin.collections.a.g(d7.f.a("title", title), d7.f.a("url", url), d7.f.a("order", Integer.valueOf(i10))));
    }

    public final String h(String url, String title, long j10) {
        kotlin.jvm.internal.h.f(url, "url");
        kotlin.jvm.internal.h.f(title, "title");
        return k.a(kotlin.collections.a.g(d7.f.a("title", title), d7.f.a("url", url), d7.f.a("updated_at", Long.valueOf(j10))));
    }
}
