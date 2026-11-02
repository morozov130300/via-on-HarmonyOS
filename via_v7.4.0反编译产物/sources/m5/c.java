package m5;

import java.util.HashMap;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public HashMap f8628a;

    public void a(long j10, String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        if (this.f8628a == null) {
            this.f8628a = new HashMap();
        }
        this.f8628a.put(Long.valueOf(j10), str);
    }

    public String b(long j10) {
        HashMap map = this.f8628a;
        if (map == null) {
            return null;
        }
        return (String) map.get(Long.valueOf(j10));
    }

    public void c(long j10) {
        HashMap map = this.f8628a;
        if (map == null) {
            return;
        }
        map.remove(Long.valueOf(j10));
    }
}
