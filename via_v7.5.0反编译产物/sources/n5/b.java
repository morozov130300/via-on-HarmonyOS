package n5;

import android.graphics.Bitmap;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class b {
    public Bitmap a(t3.b bVar) {
        int iM = bVar.m();
        int iK = bVar.k();
        int[] iArr = new int[iM * iK];
        for (int i10 = 0; i10 < iK; i10++) {
            int i11 = i10 * iM;
            for (int i12 = 0; i12 < iM; i12++) {
                iArr[i11 + i12] = bVar.i(i12, i10) ? -16777216 : -1;
            }
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iM, iK, Bitmap.Config.ARGB_8888);
        bitmapCreateBitmap.setPixels(iArr, 0, iM, 0, 0, iM, iK);
        return bitmapCreateBitmap;
    }

    public t3.b b(String str, BarcodeFormat barcodeFormat, int i10, int i11, Map map) throws WriterException {
        try {
            return new com.google.zxing.f().a(str, barcodeFormat, i10, i11, map);
        } catch (WriterException e10) {
            throw e10;
        } catch (Exception e11) {
            throw new WriterException(e11);
        }
    }

    public Bitmap c(String str, BarcodeFormat barcodeFormat, int i10, int i11, Map map) {
        return a(b(str, barcodeFormat, i10, i11, map));
    }
}
