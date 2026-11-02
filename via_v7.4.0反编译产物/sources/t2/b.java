package t2;

import com.google.firebase.crashlytics.internal.common.CommonUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public final Map f12082a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final int f12083b;

    /* renamed from: c, reason: collision with root package name */
    public final int f12084c;

    public b(int i10, int i11) {
        this.f12083b = i10;
        this.f12084c = i11;
    }

    public static String c(String str, int i10) {
        if (str == null) {
            return str;
        }
        String strTrim = str.trim();
        return strTrim.length() > i10 ? strTrim.substring(0, i10) : strTrim;
    }

    public synchronized Map a() {
        return Collections.unmodifiableMap(new HashMap(this.f12082a));
    }

    public final String b(String str) {
        if (str != null) {
            return c(str, this.f12084c);
        }
        throw new IllegalArgumentException("Custom attribute key must not be null.");
    }

    public synchronized boolean d(String str, String str2) {
        String strB = b(str);
        if (this.f12082a.size() >= this.f12083b && !this.f12082a.containsKey(strB)) {
            p2.f.f().k("Ignored entry \"" + str + "\" when adding custom keys. Maximum allowable: " + this.f12083b);
            return false;
        }
        String strC = c(str2, this.f12084c);
        if (CommonUtils.B((String) this.f12082a.get(strB), strC)) {
            return false;
        }
        Map map = this.f12082a;
        if (str2 == null) {
            strC = "";
        }
        map.put(strB, strC);
        return true;
    }

    public synchronized void e(Map map) {
        try {
            int i10 = 0;
            for (Map.Entry entry : map.entrySet()) {
                String strB = b((String) entry.getKey());
                if (this.f12082a.size() < this.f12083b || this.f12082a.containsKey(strB)) {
                    String str = (String) entry.getValue();
                    this.f12082a.put(strB, str == null ? "" : c(str, this.f12084c));
                } else {
                    i10++;
                }
            }
            if (i10 > 0) {
                p2.f.f().k("Ignored " + i10 + " entries when adding custom keys. Maximum allowable: " + this.f12083b);
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
