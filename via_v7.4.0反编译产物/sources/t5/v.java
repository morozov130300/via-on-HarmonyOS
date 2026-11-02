package t5;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class v implements Comparable {

    /* renamed from: e, reason: collision with root package name */
    public final int f12247e;

    /* renamed from: j, reason: collision with root package name */
    public final int f12248j;

    public v(int i10, int i11) {
        this.f12247e = i10;
        this.f12248j = i11;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(v vVar) {
        int i10 = this.f12248j * this.f12247e;
        int i11 = vVar.f12248j * vVar.f12247e;
        if (i11 < i10) {
            return 1;
        }
        return i11 > i10 ? -1 : 0;
    }

    public v b() {
        return new v(this.f12248j, this.f12247e);
    }

    public v c(v vVar) {
        int i10 = this.f12247e;
        int i11 = vVar.f12248j;
        int i12 = i10 * i11;
        int i13 = vVar.f12247e;
        int i14 = this.f12248j;
        return i12 <= i13 * i14 ? new v(i13, (i14 * i13) / i10) : new v((i10 * i11) / i14, i11);
    }

    public v d(v vVar) {
        int i10 = this.f12247e;
        int i11 = vVar.f12248j;
        int i12 = i10 * i11;
        int i13 = vVar.f12247e;
        int i14 = this.f12248j;
        return i12 >= i13 * i14 ? new v(i13, (i14 * i13) / i10) : new v((i10 * i11) / i14, i11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            v vVar = (v) obj;
            if (this.f12247e == vVar.f12247e && this.f12248j == vVar.f12248j) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (this.f12247e * 31) + this.f12248j;
    }

    public String toString() {
        return this.f12247e + "x" + this.f12248j;
    }
}
