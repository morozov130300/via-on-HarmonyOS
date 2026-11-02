package c8;

import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class mc {

    /* renamed from: a, reason: collision with root package name */
    public final Map f2684a = new HashMap();

    public void a(String str, int i10) {
        if (str == null || str.isEmpty()) {
            return;
        }
        e(str, i10 | c(str));
    }

    public void b(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        this.f2684a.remove(str);
    }

    public int c(String str) {
        Integer num;
        if (str == null || str.isEmpty() || (num = (Integer) this.f2684a.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    public void d(String str, int i10) {
        if (str == null || str.isEmpty()) {
            return;
        }
        e(str, (i10 ^ (-1)) & c(str));
    }

    public void e(String str, int i10) {
        if (str == null || str.isEmpty()) {
            return;
        }
        if (i10 == 0) {
            b(str);
        } else {
            this.f2684a.put(str, Integer.valueOf(i10));
        }
    }
}
