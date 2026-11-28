package c6;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class i1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i1 f2033a = new i1();

    public final i0 a(String url, String str, int i10, String str2, String locale) {
        kotlin.jvm.internal.h.f(url, "url");
        kotlin.jvm.internal.h.f(locale, "locale");
        if (url.length() == 0) {
            return null;
        }
        if (i10 == 0 && (str2 == null || str2.length() == 0)) {
            return null;
        }
        Map mapH = kotlin.collections.a.h(d7.f.a("url", url), d7.f.a("reason", Integer.valueOf(i10)), d7.f.a("locale", locale));
        if (str != null && str.length() != 0) {
            mapH.put("title", str);
        }
        if (str2 != null && str2.length() != 0) {
            mapH.put("note", str2);
        }
        return l0.a(new j0("https://ra.viayoo.com/report_abuse", "POST", null, 0, kotlin.collections.a.g(d7.f.a("Content-Type", "application/json; charset=UTF-8"), d7.f.a("Authorization", "Bearer tk_o4s4ghe1tqu60mj0ljy5im762ebrr")), k.a(mapH), null, 76, null));
    }

    public final int b(int i10) {
        if (i10 == 0) {
            return 1;
        }
        if (i10 != 1) {
            return i10 != 2 ? 0 : 4;
        }
        return 2;
    }
}
