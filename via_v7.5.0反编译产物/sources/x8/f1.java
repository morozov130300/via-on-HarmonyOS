package x8;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class f1 {
    public static String a(String str, String str2) {
        if (str != null && !str.isEmpty()) {
            if (str.startsWith("zh-")) {
                return (str.startsWith("zh-Hant") || str.equals("zh-TW")) ? "中文(繁體)" : "中文(简体)";
            }
            Locale localeD = v.k.c(str).d(0);
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
        map.put("zh-CN", "中文(简体)");
        map.put("zh-TW", "中文(繁體)");
        if (!a0.h()) {
            return map;
        }
        map.put("ar", "العربية");
        map.put("az", "azərbaycan");
        map.put("be", "беларуская");
        map.put("bn", "বাংলা");
        map.put("cs", "čeština");
        map.put("da", "Dansk");
        map.put("de", "Deutsch");
        map.put("es", "español");
        map.put("fa", "فارسی");
        map.put("fil", "Filipino");
        map.put("fr", "français");
        map.put("hi", "हिन्दी");
        map.put("hr", "hrvatski");
        map.put("hu", "magyar");
        map.put("in", "Indonesia");
        map.put("it", "italiano");
        map.put("ja", "日本語");
        map.put("ko", "한국어");
        map.put("lt", "lietuvių");
        map.put("mr", "मराठी");
        map.put("ne", "नेपाली");
        map.put("pl", "polski");
        map.put("pt", "português");
        map.put("pt-BR", "português(Brasil)");
        map.put("ro", "română");
        map.put("ru", "русский");
        map.put("sk", "slovenčina");
        map.put("sl", "slovenščina");
        map.put("ta", "தமிழ்");
        map.put("tr", "Türkçe");
        map.put("uk", "українська");
        map.put("ur", "اردو");
        map.put("uz", "o‘zbek");
        map.put("vi", "Tiếng Việt");
        map.put("th", "ภาษาไทย");
        return map;
    }
}
