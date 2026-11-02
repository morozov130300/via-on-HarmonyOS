package z8;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class g1 {
    public static String a(String str, String str2) {
        if (str != null && !str.isEmpty()) {
            if (str.startsWith("zh-")) {
                return (str.startsWith("zh-Hant") || str.equals("zh-TW")) ? "\u4e2d\u6587(\u7e41\u9ad4)" : "\u4e2d\u6587(\u7b80\u4f53)";
            }
            Locale localeD = u.k.c(str).d(0);
            String displayLanguage = localeD.getDisplayLanguage(localeD);
            String displayCountry = localeD.getDisplayCountry(localeD);
            if (!displayCountry.isEmpty()) {
                displayLanguage = displayLanguage + "(" + displayCountry + ")";
            }
            if (!str.equals(displayLanguage)) {
                return displayLanguage;
            }
        }
        return str2;
    }

    public static Map b() {
        HashMap map = new HashMap();
        map.put("en", "English");
        map.put("zh-CN", "\u4e2d\u6587(\u7b80\u4f53)");
        map.put("zh-TW", "\u4e2d\u6587(\u7e41\u9ad4)");
        if (!c0.i()) {
            return map;
        }
        map.put("ar", "\u0627\u0644\u0639\u0631\u0628\u064a\u0629");
        map.put("az", "az\u0259rbaycan");
        map.put("be", "\u0431\u0435\u043b\u0430\u0440\u0443\u0441\u043a\u0430\u044f");
        map.put("bn", "\u09ac\u09be\u0982\u09b2\u09be");
        map.put("cs", "\u010de\u0161tina");
        map.put("da", "Dansk");
        map.put("de", "Deutsch");
        map.put("es", "espa\u00f1ol");
        map.put("fa", "\u0641\u0627\u0631\u0633\u06cc");
        map.put("fil", "Filipino");
        map.put("fr", "fran\u00e7ais");
        map.put("hi", "\u0939\u093f\u0928\u094d\u0926\u0940");
        map.put("hr", "hrvatski");
        map.put("hu", "magyar");
        map.put("in", "Indonesia");
        map.put("it", "italiano");
        map.put("ja", "\u65e5\u672c\u8a9e");
        map.put("ko", "\ud55c\uad6d\uc5b4");
        map.put("lt", "lietuvi\u0173");
        map.put("ne", "\u0928\u0947\u092a\u093e\u0932\u0940");
        map.put("pl", "polski");
        map.put("pt", "portugu\u00eas");
        map.put("pt-BR", "portugu\u00eas(Brasil)");
        map.put("ro", "rom\u00e2n\u0103");
        map.put("ru", "\u0440\u0443\u0441\u0441\u043a\u0438\u0439");
        map.put("sk", "sloven\u010dina");
        map.put("sl", "sloven\u0161\u010dina");
        map.put("ta", "\u0ba4\u0bae\u0bbf\u0bb4\u0bcd");
        map.put("tr", "T\u00fcrk\u00e7e");
        map.put("uk", "\u0443\u043a\u0440\u0430\u0457\u043d\u0441\u044c\u043a\u0430");
        map.put("uz", "o\u2018zbek");
        map.put("vi", "Ti\u1ebfng Vi\u1ec7t");
        map.put("th", "\u0e20\u0e32\u0e29\u0e32\u0e44\u0e17\u0e22");
        return map;
    }
}
