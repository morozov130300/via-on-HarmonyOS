package b8;

import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static g f1785b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f1786a = new HashMap();

    public static g c() {
        if (f1785b == null) {
            f1785b = new g();
        }
        return f1785b;
    }

    public boolean a(String str) {
        String strB = b(str);
        return (strB == null || strB.isEmpty() || !this.f1786a.containsKey(strB)) ? false : true;
    }

    public final String b(String str) {
        int iIndexOf;
        int iMin;
        if (str == null || str.length() < 3 || (iIndexOf = str.indexOf("://")) <= 0) {
            return "";
        }
        if (iIndexOf > 12 && "view-source:".equalsIgnoreCase(str.substring(0, 12))) {
            return "S";
        }
        if (iIndexOf == 4 && "file".equalsIgnoreCase(str.substring(0, iIndexOf))) {
            iMin = str.lastIndexOf(63);
            if (iMin < 0) {
                iMin = str.length();
            }
        } else {
            int i10 = iIndexOf + 3;
            int iIndexOf2 = str.indexOf(47, i10);
            if (iIndexOf2 < 0) {
                iIndexOf2 = str.indexOf(63, i10);
            }
            if (iIndexOf2 < 0) {
                iIndexOf2 = str.length();
            }
            iMin = Math.min(iIndexOf2, iIndexOf + 128);
        }
        return str.substring(iIndexOf + 3, iMin);
    }

    public int d(String str, int i10) {
        Integer num;
        String strB = b(str);
        return (strB == null || strB.isEmpty() || this.f1786a.isEmpty() || (num = (Integer) this.f1786a.get(strB)) == null) ? i10 : num.intValue();
    }

    public void e(String str) {
        String strB = b(str);
        if (strB == null || strB.isEmpty() || this.f1786a.isEmpty()) {
            return;
        }
        this.f1786a.remove(strB);
    }

    public void f(String str, int i10) {
        String strB = b(str);
        if (strB == null || strB.isEmpty()) {
            return;
        }
        this.f1786a.put(strB, Integer.valueOf(i10));
    }
}
