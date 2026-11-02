package z8;

import android.database.AbstractWindowedCursor;
import android.database.Cursor;
import android.database.CursorWindow;
import android.os.Build;
import java.lang.reflect.Field;
import java.util.ArrayList;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class i0 {
    public static void a(Cursor cursor, int i10) {
        if (Build.VERSION.SDK_INT < 28 || !(cursor instanceof AbstractWindowedCursor)) {
            return;
        }
        ((AbstractWindowedCursor) cursor).setWindow(new CursorWindow("test", i10));
    }

    public static void b(int i10) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        if (Build.VERSION.SDK_INT >= 28) {
            return;
        }
        try {
            Field declaredField = CursorWindow.class.getDeclaredField("sCursorWindowSize");
            declaredField.setAccessible(true);
            declaredField.set(null, Integer.valueOf(i10));
        } catch (Exception e10) {
            pc.a.i(e10);
        }
    }

    public static String c(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        int length = str.length();
        StringBuilder sb2 = null;
        int i10 = 0;
        while (i10 < length) {
            int iCodePointAt = str.codePointAt(i10);
            int iCharCount = Character.charCount(iCodePointAt);
            if (iCodePointAt == 95 || iCodePointAt == 37) {
                if (sb2 == null) {
                    sb2 = new StringBuilder();
                    sb2.append(str.substring(0, i10));
                }
                sb2.append('\\');
                sb2.appendCodePoint(iCodePointAt);
            } else if (sb2 != null) {
                sb2.appendCodePoint(iCodePointAt);
            }
            i10 += iCharCount;
        }
        if (sb2 == null) {
            return null;
        }
        return sb2.toString();
    }

    public static w.d d(String str, String str2, String str3) {
        String str4;
        String[] strArr;
        if (str == null || str.isEmpty()) {
            return null;
        }
        String strC = c(str);
        String str5 = strC == null ? "" : " escape '\\'";
        if (strC != null) {
            str = strC;
        }
        if (i6.i0.f7006a.s(str)) {
            str4 = str3 + " like ?" + str5;
            strArr = new String[]{str + "%"};
        } else {
            String str6 = "%_" + str + "%";
            str4 = str3 + " like ?" + str5 + " or " + str2 + " like ?" + str5 + " or " + str2 + " like ?" + str5;
            strArr = new String[]{str6, str6, str + "%"};
        }
        return new w.d(str4, strArr);
    }

    public static String e(int i10) {
        if (i10 <= 0) {
            throw new IllegalArgumentException("count can smaller than 0");
        }
        StringBuilder sb2 = new StringBuilder("(?");
        int i11 = i10 - 1;
        while (true) {
            int i12 = i11 - 1;
            if (i11 <= 0) {
                sb2.append(")");
                return sb2.toString();
            }
            sb2.append(", ?");
            i11 = i12;
        }
    }

    public static String[] f(String str) {
        String strSubstring;
        if (str == null || str.isEmpty()) {
            throw new NullPointerException("seed can not be null");
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        int iIndexOf = str.indexOf("://");
        int iIndexOf2 = iIndexOf > 0 ? str.indexOf(47, iIndexOf + 3) : -1;
        String str2 = null;
        if (iIndexOf > 0 && str.charAt(str.length() - 1) == '/' && iIndexOf2 == str.length() - 1) {
            strSubstring = str.substring(0, str.length() - 1);
            arrayList.add(strSubstring);
        } else {
            strSubstring = null;
        }
        if (iIndexOf > 0) {
            int i10 = iIndexOf + 3;
            if (str.indexOf("xn--", i10) > 0) {
                int length = iIndexOf2 >= 0 ? iIndexOf2 : str.length();
                str2 = str.substring(0, i10) + v0.h(str.substring(i10, length)) + str.substring(length);
                arrayList.add(str2);
                if (strSubstring != null) {
                    arrayList.add(str2.substring(0, str2.length() - 1));
                }
            }
        }
        if (iIndexOf2 > 0 && strSubstring == null) {
            String strSubstring2 = str.substring(iIndexOf2);
            if (strSubstring2.indexOf(37) >= 0) {
                arrayList.add(str.substring(0, iIndexOf2) + v0.i(strSubstring2));
                if (str2 != null) {
                    arrayList.add(str2.substring(0, str2.indexOf(47, iIndexOf + 3)) + v0.i(strSubstring2));
                }
            }
        }
        String[] strArr = new String[arrayList.size()];
        int size = arrayList.size();
        for (int i11 = 0; i11 < size; i11++) {
            strArr[i11] = (String) arrayList.get(i11);
        }
        return strArr;
    }
}
