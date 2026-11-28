package z0;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f15128a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f15129b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f15130c;

    public k(int i10, int i11) {
        if (i10 < 0) {
            throw new IndexOutOfBoundsException("Lower bound cannot be negative");
        }
        if (i10 > i11) {
            throw new IndexOutOfBoundsException("Lower bound cannot be greater then upper bound");
        }
        this.f15128a = i10;
        this.f15129b = i11;
        this.f15130c = i10;
    }

    public boolean a() {
        return this.f15130c >= this.f15129b;
    }

    public int b() {
        return this.f15130c;
    }

    public int c() {
        return this.f15129b;
    }

    public void d(int i10) {
        if (i10 < this.f15128a) {
            throw new IndexOutOfBoundsException();
        }
        if (i10 > this.f15129b) {
            throw new IndexOutOfBoundsException();
        }
        this.f15130c = i10;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(16);
        sb2.append('[');
        sb2.append(Integer.toString(this.f15128a));
        sb2.append('>');
        sb2.append(Integer.toString(this.f15130c));
        sb2.append('>');
        sb2.append(Integer.toString(this.f15129b));
        sb2.append(']');
        return sb2.toString();
    }
}
