package m5;

import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HashMap f7878a;

    public void a(long j10, String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        if (this.f7878a == null) {
            this.f7878a = new HashMap();
        }
        this.f7878a.put(Long.valueOf(j10), str);
    }

    public String b(long j10) {
        HashMap map = this.f7878a;
        if (map == null) {
            return null;
        }
        return (String) map.get(Long.valueOf(j10));
    }

    public void c(long j10) {
        HashMap map = this.f7878a;
        if (map == null) {
            return;
        }
        map.remove(Long.valueOf(j10));
    }
}
