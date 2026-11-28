package c6;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x f2131a = new x();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final h1 f2132b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile h1 f2133c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile boolean f2134d;

    static {
        h1 h1Var = new h1(kotlin.collections.a.f());
        f2132b = h1Var;
        f2133c = h1Var;
    }

    public final String a(String uid, String userAgent) {
        String strB;
        h1 h1VarD;
        kotlin.jvm.internal.h.f(uid, "uid");
        kotlin.jvm.internal.h.f(userAgent, "userAgent");
        k0 k0VarC = l0.a(new j0("https://" + (f2134d ? "c.viayoo.com" : "us-c.viayoo.com") + "/api/frontend", "POST", userAgent, 0, kotlin.collections.a.g(d7.f.a("Content-Type", "application/json"), d7.f.a("Authorization", "default:production.5ae8018a613c7b4ef6297b23aaf7d5d18d16cac9a6636ae20d378aa2")), k.a(e7.a0.d(d7.f.a("userId", uid))), null, 72, null)).c();
        if (k0VarC == null || (strB = k0VarC.b()) == null || k0VarC.a() != 200 || (h1VarD = d(strB)) == null) {
            return null;
        }
        f2133c = h1VarD;
        return strB;
    }

    public final boolean b() {
        return f2134d;
    }

    public final h1 c() {
        return f2133c;
    }

    public final h1 d(String body) {
        Object obj;
        kotlin.jvm.internal.h.f(body, "body");
        Map mapD = k.d(body);
        Object obj2 = mapD != null ? mapD.get("toggles") : null;
        List list = obj2 instanceof List ? (List) obj2 : null;
        if (list == null) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Object obj3 : list) {
            Map map = obj3 instanceof Map ? (Map) obj3 : null;
            if (map != null) {
                Object obj4 = map.get("name");
                String str = obj4 instanceof String ? (String) obj4 : null;
                if (str != null) {
                    String lowerCase = str.toLowerCase(Locale.ROOT);
                    kotlin.jvm.internal.h.e(lowerCase, "toLowerCase(...)");
                    if (lowerCase != null && lowerCase.length() != 0 && linkedHashSet.add(lowerCase) && kotlin.text.x.s(String.valueOf(map.get("enabled")), "true", true)) {
                        Object obj5 = map.get("variant");
                        Map map2 = obj5 instanceof Map ? (Map) obj5 : null;
                        if (map2 != null) {
                            Object obj6 = map2.get("payload");
                            Map map3 = obj6 instanceof Map ? (Map) obj6 : null;
                            String string = (map3 == null || (obj = map3.get("value")) == null) ? null : obj.toString();
                            Object obj7 = map2.get("name");
                            String str2 = obj7 instanceof String ? (String) obj7 : null;
                            if (string != null && string.length() != 0) {
                                linkedHashMap.put(lowerCase, string);
                            } else if (str2 != null && str2.length() != 0 && (!kotlin.jvm.internal.h.a(str2, "disabled") || kotlin.text.x.s(String.valueOf(map2.get("enabled")), "true", true))) {
                                linkedHashMap.put(lowerCase, str2);
                            }
                        }
                    }
                }
            }
        }
        if (list.isEmpty()) {
            return f2132b;
        }
        if (linkedHashSet.isEmpty()) {
            return null;
        }
        return new h1(linkedHashMap);
    }

    public final boolean e(String str, long j10, long j11) {
        h1 h1VarD;
        if (str != null && (h1VarD = d(str)) != null) {
            f2133c = h1VarD;
            if (h1VarD != f2132b && j10 > 0) {
                long j12 = j11 - j10;
                if (0 <= j12 && j12 < 60001) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void f(boolean z10) {
        f2134d = z10;
    }
}
