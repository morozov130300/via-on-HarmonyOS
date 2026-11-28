package h8;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5753a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5754b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f5755c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f5756d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f5757e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f5758f = false;

    public t(String str, String str2, String str3, List list, int i10) {
        this.f5753a = str;
        this.f5754b = str2;
        this.f5755c = str3;
        this.f5756d = list;
        this.f5757e = i10;
    }

    public int a() {
        return this.f5757e;
    }

    public String b() {
        return this.f5753a;
    }

    public String c(int i10) {
        List list = this.f5756d;
        if (list == null || i10 < 0 || i10 >= list.size()) {
            return null;
        }
        return (String) this.f5756d.get(i10);
    }

    public List d() {
        return this.f5756d;
    }

    public String e() {
        return this.f5755c;
    }

    public String f() {
        return this.f5754b;
    }

    public boolean g() {
        int i10;
        List list = this.f5756d;
        return list == null || (i10 = this.f5757e) < 0 || i10 >= list.size();
    }

    public boolean h() {
        return this.f5758f;
    }

    public void i(int i10) {
        this.f5757e = i10;
    }

    public void j(boolean z10) {
        this.f5758f = z10;
    }

    public String toString() {
        return "ReadAloudTask{id='" + this.f5753a + "', url='" + this.f5754b + "', title='" + this.f5755c + "', sentences=" + this.f5756d.size() + ", currentIndex=" + this.f5757e + ", isPlaying=" + this.f5758f + '}';
    }
}
