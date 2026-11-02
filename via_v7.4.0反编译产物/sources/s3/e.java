package s3;

import com.google.zxing.NotFoundException;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class e extends i {
    @Override // s3.i
    public b c(b bVar, int i10, int i11, k kVar) throws NotFoundException {
        if (i10 <= 0 || i11 <= 0) {
            throw NotFoundException.getNotFoundInstance();
        }
        b bVar2 = new b(i10, i11);
        int i12 = i10 * 2;
        float[] fArr = new float[i12];
        for (int i13 = 0; i13 < i11; i13++) {
            float f10 = i13 + 0.5f;
            for (int i14 = 0; i14 < i12; i14 += 2) {
                fArr[i14] = (i14 / 2) + 0.5f;
                fArr[i14 + 1] = f10;
            }
            kVar.f(fArr);
            i.a(bVar, fArr);
            for (int i15 = 0; i15 < i12; i15 += 2) {
                try {
                    if (bVar.e((int) fArr[i15], (int) fArr[i15 + 1])) {
                        bVar2.n(i15 / 2, i13);
                    }
                } catch (ArrayIndexOutOfBoundsException unused) {
                    throw NotFoundException.getNotFoundInstance();
                }
            }
        }
        return bVar2;
    }
}
