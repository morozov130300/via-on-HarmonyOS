package z0;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public char[] f15122a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f15123b;

    public e(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException("Buffer capacity may not be negative");
        }
        this.f15122a = new char[i10];
    }

    public void a(String str) {
        if (str == null) {
            str = "null";
        }
        int length = str.length();
        int i10 = this.f15123b + length;
        if (i10 > this.f15122a.length) {
            c(i10);
        }
        str.getChars(0, length, this.f15122a, this.f15123b);
        this.f15123b = i10;
    }

    public char b(int i10) {
        return this.f15122a[i10];
    }

    public final void c(int i10) {
        char[] cArr = new char[Math.max(this.f15122a.length << 1, i10)];
        System.arraycopy(this.f15122a, 0, cArr, 0, this.f15123b);
        this.f15122a = cArr;
    }

    public String d(int i10, int i11) {
        if (i10 < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (i11 > this.f15123b) {
            throw new IndexOutOfBoundsException();
        }
        if (i10 <= i11) {
            return new String(this.f15122a, i10, i11 - i10);
        }
        throw new IndexOutOfBoundsException();
    }

    public String e(int i10, int i11) {
        if (i10 < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (i11 > this.f15123b) {
            throw new IndexOutOfBoundsException();
        }
        if (i10 > i11) {
            throw new IndexOutOfBoundsException();
        }
        while (i10 < i11 && f.a(this.f15122a[i10])) {
            i10++;
        }
        while (i11 > i10 && f.a(this.f15122a[i11 - 1])) {
            i11--;
        }
        return new String(this.f15122a, i10, i11 - i10);
    }

    public String toString() {
        return new String(this.f15122a, 0, this.f15123b);
    }
}
