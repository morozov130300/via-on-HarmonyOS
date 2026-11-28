package okhttp3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String[] f11310a;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f11311a = new ArrayList(20);

        public a a(String str, String str2) {
            q.a(str);
            q.b(str2, str);
            return c(str, str2);
        }

        public a b(String str) {
            int iIndexOf = str.indexOf(":", 1);
            if (iIndexOf != -1) {
                return c(str.substring(0, iIndexOf), str.substring(iIndexOf + 1));
            }
            return str.startsWith(":") ? c("", str.substring(1)) : c("", str);
        }

        public a c(String str, String str2) {
            this.f11311a.add(str);
            this.f11311a.add(str2.trim());
            return this;
        }

        public q d() {
            return new q(this);
        }

        public a e(String str) {
            int i10 = 0;
            while (i10 < this.f11311a.size()) {
                if (str.equalsIgnoreCase((String) this.f11311a.get(i10))) {
                    this.f11311a.remove(i10);
                    this.f11311a.remove(i10);
                    i10 -= 2;
                }
                i10 += 2;
            }
            return this;
        }

        public a f(String str, String str2) {
            q.a(str);
            q.b(str2, str);
            e(str);
            c(str, str2);
            return this;
        }
    }

    public q(a aVar) {
        List list = aVar.f11311a;
        this.f11310a = (String[]) list.toArray(new String[list.size()]);
    }

    public static void a(String str) {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (str.isEmpty()) {
            throw new IllegalArgumentException("name is empty");
        }
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt = str.charAt(i10);
            if (cCharAt <= ' ' || cCharAt >= 127) {
                throw new IllegalArgumentException(ub.c.r("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(cCharAt), Integer.valueOf(i10), str));
            }
        }
    }

    public static void b(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("value for name " + str2 + " == null");
        }
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt = str.charAt(i10);
            if ((cCharAt <= 31 && cCharAt != '\t') || cCharAt >= 127) {
                throw new IllegalArgumentException(ub.c.r("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(cCharAt), Integer.valueOf(i10), str2, str));
            }
        }
    }

    public static String d(String[] strArr, String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    public static q h(Map map) {
        if (map == null) {
            throw new NullPointerException("headers == null");
        }
        String[] strArr = new String[map.size() * 2];
        int i10 = 0;
        for (Map.Entry entry : map.entrySet()) {
            if (entry.getKey() == null || entry.getValue() == null) {
                throw new IllegalArgumentException("Headers cannot be null");
            }
            String strTrim = ((String) entry.getKey()).trim();
            String strTrim2 = ((String) entry.getValue()).trim();
            a(strTrim);
            b(strTrim2, strTrim);
            strArr[i10] = strTrim;
            strArr[i10 + 1] = strTrim2;
            i10 += 2;
        }
        return new q(strArr);
    }

    public static q i(String... strArr) {
        if (strArr == null) {
            throw new NullPointerException("namesAndValues == null");
        }
        if (strArr.length % 2 != 0) {
            throw new IllegalArgumentException("Expected alternating header names and values");
        }
        String[] strArr2 = (String[]) strArr.clone();
        for (int i10 = 0; i10 < strArr2.length; i10++) {
            String str = strArr2[i10];
            if (str == null) {
                throw new IllegalArgumentException("Headers cannot be null");
            }
            strArr2[i10] = str.trim();
        }
        for (int i11 = 0; i11 < strArr2.length; i11 += 2) {
            String str2 = strArr2[i11];
            String str3 = strArr2[i11 + 1];
            a(str2);
            b(str3, str2);
        }
        return new q(strArr2);
    }

    public String c(String str) {
        return d(this.f11310a, str);
    }

    public String e(int i10) {
        return this.f11310a[i10 * 2];
    }

    public boolean equals(Object obj) {
        return (obj instanceof q) && Arrays.equals(((q) obj).f11310a, this.f11310a);
    }

    public Set f() {
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        int iJ = j();
        for (int i10 = 0; i10 < iJ; i10++) {
            treeSet.add(e(i10));
        }
        return Collections.unmodifiableSet(treeSet);
    }

    public a g() {
        a aVar = new a();
        Collections.addAll(aVar.f11311a, this.f11310a);
        return aVar;
    }

    public int hashCode() {
        return Arrays.hashCode(this.f11310a);
    }

    public int j() {
        return this.f11310a.length / 2;
    }

    public String k(int i10) {
        return this.f11310a[(i10 * 2) + 1];
    }

    public List l(String str) {
        int iJ = j();
        ArrayList arrayList = null;
        for (int i10 = 0; i10 < iJ; i10++) {
            if (str.equalsIgnoreCase(e(i10))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(k(i10));
            }
        }
        return arrayList != null ? Collections.unmodifiableList(arrayList) : Collections.EMPTY_LIST;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        int iJ = j();
        for (int i10 = 0; i10 < iJ; i10++) {
            sb2.append(e(i10));
            sb2.append(": ");
            sb2.append(k(i10));
            sb2.append("\n");
        }
        return sb2.toString();
    }

    public q(String[] strArr) {
        this.f11310a = strArr;
    }
}
