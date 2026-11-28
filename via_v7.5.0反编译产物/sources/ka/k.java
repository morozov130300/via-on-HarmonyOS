package ka;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List f7262a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f7263b;

    public k() {
        this(null, 0);
    }

    public int a() {
        return this.f7263b;
    }

    public List b() {
        return this.f7262a;
    }

    public boolean c() {
        List list = this.f7262a;
        return list == null || list.isEmpty();
    }

    public void d(int i10) {
        this.f7263b = i10;
    }

    public void e(List list) {
        this.f7262a = list;
    }

    public k(List list, int i10) {
        this.f7262a = list;
        this.f7263b = i10;
    }
}
