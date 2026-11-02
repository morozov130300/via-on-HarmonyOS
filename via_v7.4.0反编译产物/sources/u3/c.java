package u3;

import com.google.zxing.common.reedsolomon.ReedSolomonException;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final a f12814a;

    public c(a aVar) {
        this.f12814a = aVar;
    }

    public void a(int[] iArr, int i10) throws ReedSolomonException {
        b bVar = new b(this.f12814a, iArr);
        int[] iArr2 = new int[i10];
        boolean z10 = true;
        for (int i11 = 0; i11 < i10; i11++) {
            a aVar = this.f12814a;
            int iC = bVar.c(aVar.c(aVar.d() + i11));
            iArr2[(i10 - 1) - i11] = iC;
            if (iC != 0) {
                z10 = false;
            }
        }
        if (z10) {
            return;
        }
        b[] bVarArrD = d(this.f12814a.b(i10, 1), new b(this.f12814a, iArr2), i10);
        b bVar2 = bVarArrD[0];
        b bVar3 = bVarArrD[1];
        int[] iArrB = b(bVar2);
        int[] iArrC = c(bVar3, iArrB);
        for (int i12 = 0; i12 < iArrB.length; i12++) {
            int length = (iArr.length - 1) - this.f12814a.i(iArrB[i12]);
            if (length < 0) {
                throw new ReedSolomonException("Bad error location");
            }
            iArr[length] = a.a(iArr[length], iArrC[i12]);
        }
    }

    public final int[] b(b bVar) throws ReedSolomonException {
        int iF = bVar.f();
        if (iF == 1) {
            return new int[]{bVar.d(1)};
        }
        int[] iArr = new int[iF];
        int i10 = 0;
        for (int i11 = 1; i11 < this.f12814a.f() && i10 < iF; i11++) {
            if (bVar.c(i11) == 0) {
                iArr[i10] = this.f12814a.h(i11);
                i10++;
            }
        }
        if (i10 == iF) {
            return iArr;
        }
        throw new ReedSolomonException("Error locator degree does not match number of roots");
    }

    public final int[] c(b bVar, int[] iArr) {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        for (int i10 = 0; i10 < length; i10++) {
            int iH = this.f12814a.h(iArr[i10]);
            int iJ = 1;
            for (int i11 = 0; i11 < length; i11++) {
                if (i10 != i11) {
                    int iJ2 = this.f12814a.j(iArr[i11], iH);
                    iJ = this.f12814a.j(iJ, (iJ2 & 1) == 0 ? iJ2 | 1 : iJ2 & (-2));
                }
            }
            iArr2[i10] = this.f12814a.j(bVar.c(iH), this.f12814a.h(iJ));
            if (this.f12814a.d() != 0) {
                iArr2[i10] = this.f12814a.j(iArr2[i10], iH);
            }
        }
        return iArr2;
    }

    public final b[] d(b bVar, b bVar2, int i10) throws ReedSolomonException {
        if (bVar.f() < bVar2.f()) {
            bVar2 = bVar;
            bVar = bVar2;
        }
        b bVarG = this.f12814a.g();
        b bVarE = this.f12814a.e();
        do {
            b bVar3 = bVar2;
            bVar2 = bVar;
            bVar = bVar3;
            b bVar4 = bVarE;
            b bVar5 = bVarG;
            bVarG = bVar4;
            if (bVar.f() * 2 < i10) {
                int iD = bVarG.d(0);
                if (iD == 0) {
                    throw new ReedSolomonException("sigmaTilde(0) was zero");
                }
                int iH = this.f12814a.h(iD);
                return new b[]{bVarG.h(iH), bVar.h(iH)};
            }
            if (bVar.g()) {
                throw new ReedSolomonException("r_{i-1} was zero");
            }
            b bVarG2 = this.f12814a.g();
            int iH2 = this.f12814a.h(bVar.d(bVar.f()));
            while (bVar2.f() >= bVar.f() && !bVar2.g()) {
                int iF = bVar2.f() - bVar.f();
                int iJ = this.f12814a.j(bVar2.d(bVar2.f()), iH2);
                bVarG2 = bVarG2.a(this.f12814a.b(iF, iJ));
                bVar2 = bVar2.a(bVar.j(iF, iJ));
            }
            bVarE = bVarG2.i(bVarG).a(bVar5);
        } while (bVar2.f() < bVar.f());
        throw new IllegalStateException("Division algorithm failed to reduce polynomial? r: " + bVar2 + ", rLast: " + bVar);
    }
}
