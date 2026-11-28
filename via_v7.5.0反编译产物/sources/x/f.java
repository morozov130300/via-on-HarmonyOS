package x;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class f implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object[] f14457a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f14458b;

    public f(int i10) {
        if (i10 <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
        this.f14457a = new Object[i10];
    }

    @Override // x.e
    public boolean a(Object obj) {
        if (c(obj)) {
            throw new IllegalStateException("Already in the pool!");
        }
        int i10 = this.f14458b;
        Object[] objArr = this.f14457a;
        if (i10 >= objArr.length) {
            return false;
        }
        objArr[i10] = obj;
        this.f14458b = i10 + 1;
        return true;
    }

    @Override // x.e
    public Object b() {
        int i10 = this.f14458b;
        if (i10 <= 0) {
            return null;
        }
        int i11 = i10 - 1;
        Object[] objArr = this.f14457a;
        Object obj = objArr[i11];
        objArr[i11] = null;
        this.f14458b = i10 - 1;
        return obj;
    }

    public final boolean c(Object obj) {
        for (int i10 = 0; i10 < this.f14458b; i10++) {
            if (this.f14457a[i10] == obj) {
                return true;
            }
        }
        return false;
    }
}
