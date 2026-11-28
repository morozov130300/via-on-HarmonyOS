package mark.via.settings.search;

import a1.i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String[] f10374a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f10375b;

    /* JADX INFO: renamed from: mark.via.settings.search.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class C0098a extends i {
        @Override // a1.i
        public Map c() {
            HashMap map = new HashMap();
            map.put("长按", new String[]{"CHANG", "AN"});
            map.put("调试", new String[]{"TIAO", "SHI"});
            map.put("弹出", new String[]{"TAN", "CHU"});
            map.put("收藏", new String[]{"SHOU", "CANG"});
            map.put("隐藏", new String[]{"YIN", "CANG"});
            map.put("重置", new String[]{"CHONG", "ZHI"});
            return map;
        }
    }

    static {
        a1.c.a(new C0098a());
    }

    public a(String[] strArr, boolean z10) {
        this.f10374a = strArr;
        this.f10375b = z10;
    }

    public static void a(Set set, String str, boolean z10) {
        int i10;
        int i11;
        if (str == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        int i12 = -1;
        boolean z11 = false;
        for (int i13 = 0; i13 < str.length(); i13++) {
            char cCharAt = str.charAt(i13);
            boolean zE = a1.c.e(cCharAt);
            if (zE || !Character.isLetterOrDigit(cCharAt)) {
                if (i12 >= 0) {
                    arrayList.add(str.substring(i12, i13).toLowerCase(Locale.ROOT));
                    i12 = -1;
                }
                if (zE) {
                    arrayList.add(String.valueOf(cCharAt));
                    z11 = true;
                }
            } else {
                if (i12 >= 0 && Character.isUpperCase(cCharAt)) {
                    char cCharAt2 = str.charAt(i13 - 1);
                    if (Character.isLowerCase(cCharAt2) || (Character.isUpperCase(cCharAt2) && (i11 = i13 + 1) < str.length() && Character.isLowerCase(str.charAt(i11)))) {
                        arrayList.add(str.substring(i12, i13).toLowerCase(Locale.ROOT));
                        i12 = i13;
                    }
                }
                if (i12 < 0) {
                    i12 = i13;
                }
            }
        }
        if (i12 >= 0) {
            arrayList.add(str.substring(i12).toLowerCase(Locale.ROOT));
        }
        if (arrayList.isEmpty()) {
            return;
        }
        String[] strArr = (String[]) arrayList.toArray(new String[0]);
        set.add(new a(strArr, z10));
        if (z11) {
            String[] strArr2 = (String[]) strArr.clone();
            int i14 = 0;
            while (i14 < strArr.length) {
                if (b(strArr[i14])) {
                    StringBuilder sb2 = new StringBuilder();
                    int i15 = i14;
                    while (true) {
                        i10 = i15 + 1;
                        sb2.append(strArr[i15]);
                        if (i10 >= strArr.length || !b(strArr[i10])) {
                            break;
                        } else {
                            i15 = i10;
                        }
                    }
                    String[] strArrSplit = b.h(a1.c.g(sb2.toString(), " ")).split(" ");
                    System.arraycopy(strArrSplit, 0, strArr2, i14, strArrSplit.length);
                    i14 = i10;
                } else {
                    i14++;
                }
            }
            set.add(new a(strArr2, z10));
        }
    }

    public static boolean b(String str) {
        return str.length() == 1 && a1.c.e(str.charAt(0));
    }

    public boolean c(String str) {
        if (str.isEmpty()) {
            return false;
        }
        for (int i10 = 0; i10 < this.f10374a.length; i10++) {
            int i11 = 0;
            for (int i12 = i10; i12 < this.f10374a.length; i12++) {
                if (this.f10375b && d(i12, str, i11)) {
                    return true;
                }
                String str2 = this.f10374a[i12];
                int iMin = Math.min(str2.length(), str.length() - i11);
                if (!str2.regionMatches(0, str, i11, iMin)) {
                    break;
                }
                i11 += iMin;
                if (i11 == str.length()) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean d(int i10, String str, int i11) {
        if (str.length() - i11 > this.f10374a.length - i10) {
            return false;
        }
        while (i11 < str.length()) {
            if (this.f10374a[i10].charAt(0) != str.charAt(i11)) {
                return false;
            }
            i10++;
            i11++;
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f10375b == aVar.f10375b && Arrays.equals(this.f10374a, aVar.f10374a);
    }

    public int hashCode() {
        return (Arrays.hashCode(this.f10374a) * 31) + (this.f10375b ? 1 : 0);
    }
}
