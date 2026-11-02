package b5;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class d {
    public static String a(String str) {
        return str.substring(0, str.lastIndexOf(File.separatorChar) + 1) + UUID.randomUUID().toString() + ".txt";
    }

    public static List b(String str, String str2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        String upperCase = str2.toUpperCase(Locale.ROOT);
        arrayList.add(new w4.c("https://easylist-downloads.adblockplus.org/easylist.txt", a(str), "Easylist", false));
        upperCase.getClass();
        switch (upperCase) {
            case "AR":
                arrayList.add(new w4.c("https://easylist-downloads.adblockplus.org/Liste_AR.txt", a(str), "Easylist Arbic", false));
                break;
            case "BG":
                arrayList.add(new w4.c("https://easylist-downloads.adblockplus.org/bulgarian_list.txt", a(str), "Easylist Bulgarian", false));
                break;
            case "CS":
            case "SK":
                arrayList.add(new w4.c("https://easylist-downloads.adblockplus.org/easylistczechslovak.txt", a(str), "Easylist Czech Slovak", false));
                break;
            case "DE":
                arrayList.add(new w4.c("https://raw.githubusercontent.com/AdguardTeam/FiltersRegistry/master/filters/filter_6_German/filter.txt", a(str), "Adguard filter (German)", false));
                break;
            case "ES":
            case "PT":
                arrayList.add(new w4.c("https://raw.githubusercontent.com/AdguardTeam/FiltersRegistry/master/filters/filter_9_Spanish/filter.txt", a(str), "Adguard filter (Spanish/Portuguese)", false));
                break;
            case "FR":
                arrayList.add(new w4.c("https://raw.githubusercontent.com/AdguardTeam/FiltersRegistry/master/filters/filter_16_French/filter.txt", a(str), "Adguard filter (French)", false));
                break;
            case "IN":
                arrayList.add(new w4.c("https://easylist-downloads.adblockplus.org/indianlist.txt", a(str), "Easylist Indian", false));
                arrayList.add(new w4.c("https://easylist-downloads.adblockplus.org/abpindo.txt", a(str), "Easylist Indonesian", false));
                break;
            case "IT":
                arrayList.add(new w4.c("https://easylist-downloads.adblockplus.org/easylistitaly.txt", a(str), "Easylist Italy", false));
                break;
            case "IW":
                arrayList.add(new w4.c("https://easylist-downloads.adblockplus.org/israellist.txt", a(str), "Easylist Heberw", false));
                break;
            case "JA":
                arrayList.add(new w4.c("https://raw.githubusercontent.com/AdguardTeam/FiltersRegistry/master/filters/filter_7_Japanese/filter.txt", a(str), "Adguard filter (Japanese)", false));
                break;
            case "KO":
                arrayList.add(new w4.c("https://easylist-downloads.adblockplus.org/koreanlist.txt", a(str), "Korean List", false));
                break;
            case "LT":
                arrayList.add(new w4.c("https://easylist-downloads.adblockplus.org/easylistlithuania.txt", a(str), "Easylist Lithuania", false));
                break;
            case "LV":
                arrayList.add(new w4.c("https://easylist-downloads.adblockplus.org/latvianlist.txt", a(str), "Easylist Latvian", false));
                break;
            case "NL":
                arrayList.add(new w4.c("https://raw.githubusercontent.com/AdguardTeam/FiltersRegistry/master/filters/filter_8_Dutch/filter.txt", a(str), "Adguard filter (Dutch)", false));
                break;
            case "PL":
                arrayList.add(new w4.c("https://easylist-downloads.adblockplus.org/easylistpolish.txt", a(str), "Easylist Polish", false));
                break;
            case "RO":
                arrayList.add(new w4.c("https://easylist-downloads.adblockplus.org/rolist.txt", a(str), "Romania List", false));
                break;
            case "RU":
                arrayList.add(new w4.c("https://raw.githubusercontent.com/AdguardTeam/FiltersRegistry/master/filters/filter_1_Russian/filter.txt", a(str), "Adguard filter (Russian)", false));
                break;
            case "TR":
                arrayList.add(new w4.c("https://raw.githubusercontent.com/AdguardTeam/FiltersRegistry/master/filters/filter_13_Turkish/filter.txt", a(str), "Adguard filter (Turkish)", false));
                break;
            case "VI":
                arrayList.add(new w4.c("https://easylist-downloads.adblockplus.org/abpvn.txt", a(str), "Vietnamese List", false));
                break;
            case "ZH":
                arrayList.add(new w4.c("https://easylist-downloads.adblockplus.org/easylistchina.txt", a(str), "Easylist China", false));
                arrayList.add(new w4.c("https://fastly.jsdelivr.net/gh/cjx82630/cjxlist/cjx-annoyance.txt", a(str), "CJX's Annoyance List", false));
                break;
        }
        arrayList.add(new w4.c("https://easylist-downloads.adblockplus.org/easyprivacy.txt", a(str), "Easylist Privacy", false));
        arrayList.add(new w4.c("https://easylist-downloads.adblockplus.org/antiadblockfilters.txt", a(str), "Easylist Warning Removal", false));
        return arrayList;
    }
}
