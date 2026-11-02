package s3;

import com.google.zxing.NotFoundException;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class i {

    /* renamed from: a, reason: collision with root package name */
    public static i f11835a = new e();

    /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0076  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(b bVar, float[] fArr) {
        int iM = bVar.m();
        int iJ = bVar.j();
        int length = fArr.length - 1;
        boolean z10 = true;
        for (int i10 = 0; i10 < length && z10; i10 += 2) {
            int i11 = (int) fArr[i10];
            int i12 = i10 + 1;
            int i13 = (int) fArr[i12];
            if (i11 < -1 || i11 > iM || i13 < -1 || i13 > iJ) {
                throw NotFoundException.getNotFoundInstance();
            }
            if (i11 == -1) {
                fArr[i10] = 0.0f;
            } else if (i11 == iM) {
                fArr[i10] = iM - 1;
            } else {
                z10 = false;
                if (i13 != -1) {
                    fArr[i12] = 0.0f;
                } else if (i13 == iJ) {
                    fArr[i12] = iJ - 1;
                }
                z10 = true;
            }
            z10 = true;
            if (i13 != -1) {
            }
            z10 = true;
        }
        boolean z11 = true;
        for (int length2 = fArr.length - 2; length2 >= 0 && z11; length2 -= 2) {
            int i14 = (int) fArr[length2];
            int i15 = length2 + 1;
            int i16 = (int) fArr[i15];
            if (i14 < -1 || i14 > iM || i16 < -1 || i16 > iJ) {
                throw NotFoundException.getNotFoundInstance();
            }
            if (i14 == -1) {
                fArr[length2] = 0.0f;
            } else if (i14 == iM) {
                fArr[length2] = iM - 1;
            } else {
                z11 = false;
                if (i16 != -1) {
                    fArr[i15] = 0.0f;
                } else if (i16 == iJ) {
                    fArr[i15] = iJ - 1;
                }
                z11 = true;
            }
            z11 = true;
            if (i16 != -1) {
            }
            z11 = true;
        }
    }

    public static i b() {
        return f11835a;
    }

    public abstract b c(b bVar, int i10, int i11, k kVar);
}
