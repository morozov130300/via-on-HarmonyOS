package c6;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class a1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a1 f1956a = new a1();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List f1957b = e7.o.k("”", "」", "。", "，", "；", "？", "！", ". ", ", ", "; ", "? ", "! ", "} ", " ", ".");

    public final List a(List texts) {
        List listE;
        kotlin.jvm.internal.h.f(texts, "texts");
        ArrayList arrayList = new ArrayList();
        Iterator it = texts.iterator();
        while (it.hasNext()) {
            String strC = f1956a.c(kotlin.text.x.z((String) it.next(), "\u200b", "", false, 4, null));
            kotlin.jvm.internal.h.c(strC);
            int length = strC.length() - 1;
            int i10 = 0;
            boolean z10 = false;
            while (i10 <= length) {
                boolean z11 = kotlin.jvm.internal.h.h(strC.charAt(!z10 ? i10 : length), 32) <= 0;
                if (z10) {
                    if (!z11) {
                        break;
                    }
                    length--;
                } else if (z11) {
                    i10++;
                } else {
                    z10 = true;
                }
            }
            String string = strC.subSequence(i10, length + 1).toString();
            if (string.length() == 0) {
                listE = e7.o.h();
            } else {
                listE = string.length() < 256 ? e7.n.e(string) : f1956a.b(string);
            }
            e7.t.r(arrayList, listE);
        }
        return arrayList;
    }

    public final List b(String str) {
        Object obj;
        String str2;
        int i10;
        if (str == null || str.length() == 0) {
            return e7.o.h();
        }
        Iterator it = f1957b.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (kotlin.text.z.I(str, (String) next, false, 2, null)) {
                obj = next;
                break;
            }
        }
        String str3 = (String) obj;
        ArrayList arrayList = new ArrayList();
        int i11 = 0;
        while (i11 < str.length()) {
            int iMin = Math.min(i11 + 256, str.length());
            if (str3 != null) {
                str2 = str;
                int iT = kotlin.text.z.T(str2, str3, i11, false, 4, null);
                i10 = i11;
                while (iT >= 0 && iT - i10 < 64) {
                    iT = kotlin.text.z.T(str2, str3, str3.length() + iT, false, 4, null);
                }
                if (iT >= 0 && iT - i10 < 256) {
                    iMin = str3.length() + iT;
                }
            } else {
                str2 = str;
                i10 = i11;
            }
            if (iMin < str2.length() && Character.isHighSurrogate(str2.charAt(iMin - 1)) && Character.isLowSurrogate(str2.charAt(iMin))) {
                iMin--;
            }
            i11 = iMin;
            String strSubstring = str2.substring(i10, i11);
            kotlin.jvm.internal.h.e(strSubstring, "substring(...)");
            int length = strSubstring.length() - 1;
            int i12 = 0;
            boolean z10 = false;
            while (i12 <= length) {
                boolean z11 = kotlin.jvm.internal.h.h(strSubstring.charAt(!z10 ? i12 : length), 32) <= 0;
                if (z10) {
                    if (!z11) {
                        break;
                    }
                    length--;
                } else if (z11) {
                    i12++;
                } else {
                    z10 = true;
                }
            }
            String string = strSubstring.subSequence(i12, length + 1).toString();
            if (string.length() > 0) {
                arrayList.add(string);
            }
            str = str2;
        }
        return arrayList;
    }

    public final String c(String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(str.length());
        for (int i10 = 0; i10 < str.length(); i10++) {
            char cCharAt = str.charAt(i10);
            int i11 = cCharAt - 12032;
            if (i11 >= 0 && i11 < "一丨丶丿乙亅二亠人儿入八冂冖冫几凵刀力勹匕匚匸十卜卩厂厶又口口土士夂夊夕大女子宀寸小尢尸屮山巛工己巾干幺广廴廾弋弓彐彡彳心戈户手支攴文斗斤方无日曰月木欠止歹殳毋比毛氏气水火爪父爻爿片牙牛犬玄玉瓜瓦甘生用田疋疒癶白皮皿目矛矢石示禸禾穴立竹米糸缶网羊羽老而耒耳聿肉臣自至臼舌舛舟艮色艸虍虫血行衣襾見角言谷豆豕豸貝赤走足身車辛辰辵邑酉采里金長門阜隶隹雨青非面革韋韭音頁風飛食首香馬骨高髟鬥鬯鬲鬼魚鳥鹵鹿麥麻黃黍黑黹黽鼎鼓鼠鼻齊齒龍龜龠".length()) {
                cCharAt = "一丨丶丿乙亅二亠人儿入八冂冖冫几凵刀力勹匕匚匸十卜卩厂厶又口口土士夂夊夕大女子宀寸小尢尸屮山巛工己巾干幺广廴廾弋弓彐彡彳心戈户手支攴文斗斤方无日曰月木欠止歹殳毋比毛氏气水火爪父爻爿片牙牛犬玄玉瓜瓦甘生用田疋疒癶白皮皿目矛矢石示禸禾穴立竹米糸缶网羊羽老而耒耳聿肉臣自至臼舌舛舟艮色艸虍虫血行衣襾見角言谷豆豕豸貝赤走足身車辛辰辵邑酉采里金長門阜隶隹雨青非面革韋韭音頁風飛食首香馬骨高髟鬥鬯鬲鬼魚鳥鹵鹿麥麻黃黍黑黹黽鼎鼓鼠鼻齊齒龍龜龠".charAt(i11);
            }
            arrayList.add(Character.valueOf(cCharAt));
        }
        return e7.w.E(arrayList, "", null, null, 0, null, null, 62, null);
    }
}
