package z8;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.LocaleList;
import android.text.TextUtils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import org.simpleframework.xml.strategy.Name;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class t1 {

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class a {
        public static LocaleList a(String str, LocaleList localeList) {
            return LocaleList.forLanguageTags(String.format("%1$s,%2$s", str, localeList.toLanguageTags().replaceFirst(String.format("(^|,)%1$s$|%1$s,", str), "")));
        }

        public static void b(Context context, Configuration configuration, String str) {
            configuration.setLocales(a(str, context.getResources().getConfiguration().getLocales()));
        }

        public static void c(Configuration configuration) {
            LocaleList.setDefault(configuration.getLocales());
        }
    }

    public static Locale a(String str) {
        if (str == null || str.isEmpty()) {
            return Locale.ROOT;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            return j(Locale.forLanguageTag(str));
        }
        String[] strArrSplit = str.split("-");
        if (strArrSplit.length == 0) {
            return new Locale("");
        }
        String strH = h(strArrSplit[0]);
        if (strH.length() != 2 && strH.length() != 3) {
            return new Locale("");
        }
        if (strArrSplit.length == 1) {
            return new Locale(strH);
        }
        String str2 = strArrSplit[1];
        return (str2.length() == 2 || str2.length() == 3) ? new Locale(strH, str2) : new Locale(strH);
    }

    public static String b(Context context) {
        return m(n(c(context)));
    }

    public static Locale c(Context context) {
        return Build.VERSION.SDK_INT >= 24 ? context.getResources().getConfiguration().getLocales().get(0) : context.getResources().getConfiguration().locale;
    }

    public static String d() {
        return e(System.currentTimeMillis());
    }

    public static String e(long j10) {
        Locale locale = Locale.getDefault();
        String country = locale.getCountry();
        return new SimpleDateFormat("US".equals(country) ? "MMddyyyy" : "UK".equals(country) ? "ddMMyyyy" : "yyyyMMdd", locale).format(new Date(j10));
    }

    public static String f() {
        return Build.VERSION.SDK_INT >= 24 ? o(LocaleList.getAdjustedDefault()) : g();
    }

    public static String g() {
        return Build.VERSION.SDK_INT >= 24 ? n(LocaleList.getAdjustedDefault().get(0)) : n(Locale.getDefault());
    }

    public static String h(String str) {
        return (str == null || str.isEmpty()) ? "" : !str.equals("fil") ? !str.equals("und") ? str : "" : "tl";
    }

    public static String i(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        switch (str) {
            case "in":
                return Name.MARK;
            case "iw":
                return "he";
            case "ji":
                return "yi";
            case "jw":
                return "jv";
            case "tl":
                return "fil";
            default:
                return str;
        }
    }

    public static Locale j(Locale locale) {
        String language = locale.getLanguage();
        String strH = h(language);
        return strH.equals(language) ? locale : Build.VERSION.SDK_INT >= 21 ? new Locale.Builder().setLocale(locale).setLanguage(strH).build() : new Locale(strH, locale.getCountry(), locale.getVariant());
    }

    public static Locale k(Locale locale) {
        String language = locale.getLanguage();
        String strI = i(language);
        return strI.equals(language) ? locale : Build.VERSION.SDK_INT >= 21 ? new Locale.Builder().setLocale(locale).setLanguage(strI).build() : new Locale(strI, locale.getCountry(), locale.getVariant());
    }

    public static void l(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 24) {
            a.c(configuration);
        } else {
            Locale.setDefault(configuration.locale);
        }
    }

    public static String m(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        int iIndexOf = str.indexOf(45);
        return iIndexOf < 0 ? str : str.substring(0, iIndexOf);
    }

    public static String n(Locale locale) {
        if (locale == null) {
            return "";
        }
        String strI = i(locale.getLanguage());
        String country = locale.getCountry();
        if (strI.equals("no") && country.equals("NO") && locale.getVariant().equals("NY")) {
            return "nn-NO";
        }
        if (country.isEmpty()) {
            return strI;
        }
        return strI + "-" + country;
    }

    public static String o(LocaleList localeList) {
        if (localeList == null || localeList.isEmpty()) {
            return "";
        }
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < localeList.size(); i10++) {
            arrayList.add(n(k(localeList.get(i10))));
        }
        return TextUtils.join(",", arrayList);
    }

    public static void p(Context context, Configuration configuration, String str) {
        if (Build.VERSION.SDK_INT >= 24) {
            a.b(context, configuration, str);
        } else {
            configuration.setLocale(a(str));
        }
    }
}
