package y0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    public final int f14400a;

    /* renamed from: b, reason: collision with root package name */
    public final int f14401b;

    /* renamed from: c, reason: collision with root package name */
    public int f14402c;

    public k(int i10, int i11) {
        if (i10 < 0) {
            throw new IndexOutOfBoundsException("Lower bound cannot be negative");
        }
        if (i10 > i11) {
            throw new IndexOutOfBoundsException("Lower bound cannot be greater then upper bound");
        }
        this.f14400a = i10;
        this.f14401b = i11;
        this.f14402c = i10;
    }

    public boolean a() {
        return this.f14402c >= this.f14401b;
    }

    public int b() {
        return this.f14402c;
    }

    public int c() {
        return this.f14401b;
    }

    public void d(int i10) {
        if (i10 < this.f14400a) {
            throw new IndexOutOfBoundsException();
        }
        if (i10 > this.f14401b) {
            throw new IndexOutOfBoundsException();
        }
        this.f14402c = i10;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(16);
        sb2.append('[');
        sb2.append(Integer.toString(this.f14400a));
        sb2.append('>');
        sb2.append(Integer.toString(this.f14402c));
        sb2.append('>');
        sb2.append(Integer.toString(this.f14401b));
        sb2.append(']');
        return sb2.toString();
    }
}
