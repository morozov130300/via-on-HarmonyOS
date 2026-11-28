package n5;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class v implements Comparable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f10676c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f10677e;

    public v(int i10, int i11) {
        this.f10676c = i10;
        this.f10677e = i11;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(v vVar) {
        int i10 = this.f10677e * this.f10676c;
        int i11 = vVar.f10677e * vVar.f10676c;
        if (i11 < i10) {
            return 1;
        }
        return i11 > i10 ? -1 : 0;
    }

    public v d() {
        return new v(this.f10677e, this.f10676c);
    }

    public v e(v vVar) {
        int i10 = this.f10676c;
        int i11 = vVar.f10677e;
        int i12 = i10 * i11;
        int i13 = vVar.f10676c;
        int i14 = this.f10677e;
        return i12 <= i13 * i14 ? new v(i13, (i14 * i13) / i10) : new v((i10 * i11) / i14, i11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            v vVar = (v) obj;
            if (this.f10676c == vVar.f10676c && this.f10677e == vVar.f10677e) {
                return true;
            }
        }
        return false;
    }

    public v f(v vVar) {
        int i10 = this.f10676c;
        int i11 = vVar.f10677e;
        int i12 = i10 * i11;
        int i13 = vVar.f10676c;
        int i14 = this.f10677e;
        return i12 >= i13 * i14 ? new v(i13, (i14 * i13) / i10) : new v((i10 * i11) / i14, i11);
    }

    public int hashCode() {
        return (this.f10676c * 31) + this.f10677e;
    }

    public String toString() {
        return this.f10676c + "x" + this.f10677e;
    }
}
