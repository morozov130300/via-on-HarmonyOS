package y0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public char[] f14394a;

    /* renamed from: b, reason: collision with root package name */
    public int f14395b;

    public e(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException("Buffer capacity may not be negative");
        }
        this.f14394a = new char[i10];
    }

    public void a(String str) {
        if (str == null) {
            str = "null";
        }
        int length = str.length();
        int i10 = this.f14395b + length;
        if (i10 > this.f14394a.length) {
            c(i10);
        }
        str.getChars(0, length, this.f14394a, this.f14395b);
        this.f14395b = i10;
    }

    public char b(int i10) {
        return this.f14394a[i10];
    }

    public final void c(int i10) {
        char[] cArr = new char[Math.max(this.f14394a.length << 1, i10)];
        System.arraycopy(this.f14394a, 0, cArr, 0, this.f14395b);
        this.f14394a = cArr;
    }

    public String d(int i10, int i11) {
        if (i10 < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (i11 > this.f14395b) {
            throw new IndexOutOfBoundsException();
        }
        if (i10 <= i11) {
            return new String(this.f14394a, i10, i11 - i10);
        }
        throw new IndexOutOfBoundsException();
    }

    public String e(int i10, int i11) {
        if (i10 < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (i11 > this.f14395b) {
            throw new IndexOutOfBoundsException();
        }
        if (i10 > i11) {
            throw new IndexOutOfBoundsException();
        }
        while (i10 < i11 && f.a(this.f14394a[i10])) {
            i10++;
        }
        while (i11 > i10 && f.a(this.f14394a[i11 - 1])) {
            i11--;
        }
        return new String(this.f14394a, i10, i11 - i10);
    }

    public String toString() {
        return new String(this.f14394a, 0, this.f14395b);
    }
}
