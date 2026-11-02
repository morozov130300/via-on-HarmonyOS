package u3;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final a f12812a;

    /* renamed from: b, reason: collision with root package name */
    public final int[] f12813b;

    public b(a aVar, int[] iArr) {
        if (iArr.length == 0) {
            throw new IllegalArgumentException();
        }
        this.f12812a = aVar;
        int length = iArr.length;
        int i10 = 1;
        if (length <= 1 || iArr[0] != 0) {
            this.f12813b = iArr;
            return;
        }
        while (i10 < length && iArr[i10] == 0) {
            i10++;
        }
        if (i10 == length) {
            this.f12813b = new int[]{0};
            return;
        }
        int[] iArr2 = new int[length - i10];
        this.f12813b = iArr2;
        System.arraycopy(iArr, i10, iArr2, 0, iArr2.length);
    }

    public b a(b bVar) {
        if (!this.f12812a.equals(bVar.f12812a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (g()) {
            return bVar;
        }
        if (bVar.g()) {
            return this;
        }
        int[] iArr = this.f12813b;
        int[] iArr2 = bVar.f12813b;
        if (iArr.length <= iArr2.length) {
            iArr = iArr2;
            iArr2 = iArr;
        }
        int[] iArr3 = new int[iArr.length];
        int length = iArr.length - iArr2.length;
        System.arraycopy(iArr, 0, iArr3, 0, length);
        for (int i10 = length; i10 < iArr.length; i10++) {
            iArr3[i10] = a.a(iArr2[i10 - length], iArr[i10]);
        }
        return new b(this.f12812a, iArr3);
    }

    public b[] b(b bVar) {
        if (!this.f12812a.equals(bVar.f12812a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (bVar.g()) {
            throw new IllegalArgumentException("Divide by 0");
        }
        b bVarG = this.f12812a.g();
        int iH = this.f12812a.h(bVar.d(bVar.f()));
        b bVarA = this;
        while (bVarA.f() >= bVar.f() && !bVarA.g()) {
            int iF = bVarA.f() - bVar.f();
            int iJ = this.f12812a.j(bVarA.d(bVarA.f()), iH);
            b bVarJ = bVar.j(iF, iJ);
            bVarG = bVarG.a(this.f12812a.b(iF, iJ));
            bVarA = bVarA.a(bVarJ);
        }
        return new b[]{bVarG, bVarA};
    }

    public int c(int i10) {
        if (i10 == 0) {
            return d(0);
        }
        if (i10 == 1) {
            int iA = 0;
            for (int i11 : this.f12813b) {
                iA = a.a(iA, i11);
            }
            return iA;
        }
        int[] iArr = this.f12813b;
        int iA2 = iArr[0];
        int length = iArr.length;
        for (int i12 = 1; i12 < length; i12++) {
            iA2 = a.a(this.f12812a.j(i10, iA2), this.f12813b[i12]);
        }
        return iA2;
    }

    public int d(int i10) {
        return this.f12813b[(r0.length - 1) - i10];
    }

    public int[] e() {
        return this.f12813b;
    }

    public int f() {
        return this.f12813b.length - 1;
    }

    public boolean g() {
        return this.f12813b[0] == 0;
    }

    public b h(int i10) {
        if (i10 == 0) {
            return this.f12812a.g();
        }
        if (i10 == 1) {
            return this;
        }
        int length = this.f12813b.length;
        int[] iArr = new int[length];
        for (int i11 = 0; i11 < length; i11++) {
            iArr[i11] = this.f12812a.j(this.f12813b[i11], i10);
        }
        return new b(this.f12812a, iArr);
    }

    public b i(b bVar) {
        if (!this.f12812a.equals(bVar.f12812a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (g() || bVar.g()) {
            return this.f12812a.g();
        }
        int[] iArr = this.f12813b;
        int length = iArr.length;
        int[] iArr2 = bVar.f12813b;
        int length2 = iArr2.length;
        int[] iArr3 = new int[(length + length2) - 1];
        for (int i10 = 0; i10 < length; i10++) {
            int i11 = iArr[i10];
            for (int i12 = 0; i12 < length2; i12++) {
                int i13 = i10 + i12;
                iArr3[i13] = a.a(iArr3[i13], this.f12812a.j(i11, iArr2[i12]));
            }
        }
        return new b(this.f12812a, iArr3);
    }

    public b j(int i10, int i11) {
        if (i10 < 0) {
            throw new IllegalArgumentException();
        }
        if (i11 == 0) {
            return this.f12812a.g();
        }
        int length = this.f12813b.length;
        int[] iArr = new int[i10 + length];
        for (int i12 = 0; i12 < length; i12++) {
            iArr[i12] = this.f12812a.j(this.f12813b[i12], i11);
        }
        return new b(this.f12812a, iArr);
    }

    public String toString() {
        if (g()) {
            return "0";
        }
        StringBuilder sb2 = new StringBuilder(f() * 8);
        for (int iF = f(); iF >= 0; iF--) {
            int iD = d(iF);
            if (iD != 0) {
                if (iD < 0) {
                    if (iF == f()) {
                        sb2.append("-");
                    } else {
                        sb2.append(" - ");
                    }
                    iD = -iD;
                } else if (sb2.length() > 0) {
                    sb2.append(" + ");
                }
                if (iF == 0 || iD != 1) {
                    int i10 = this.f12812a.i(iD);
                    if (i10 == 0) {
                        sb2.append('1');
                    } else if (i10 == 1) {
                        sb2.append('a');
                    } else {
                        sb2.append("a^");
                        sb2.append(i10);
                    }
                }
                if (iF != 0) {
                    if (iF == 1) {
                        sb2.append('x');
                    } else {
                        sb2.append("x^");
                        sb2.append(iF);
                    }
                }
            }
        }
        return sb2.toString();
    }
}
