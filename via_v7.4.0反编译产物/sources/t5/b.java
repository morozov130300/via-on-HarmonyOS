package t5;

import android.graphics.Bitmap;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import java.util.Map;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class b {
    public Bitmap a(s3.b bVar) {
        int iM = bVar.m();
        int iJ = bVar.j();
        int[] iArr = new int[iM * iJ];
        for (int i10 = 0; i10 < iJ; i10++) {
            int i11 = i10 * iM;
            for (int i12 = 0; i12 < iM; i12++) {
                iArr[i11 + i12] = bVar.e(i12, i10) ? -16777216 : -1;
            }
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iM, iJ, Bitmap.Config.ARGB_8888);
        bitmapCreateBitmap.setPixels(iArr, 0, iM, 0, 0, iM, iJ);
        return bitmapCreateBitmap;
    }

    public s3.b b(String str, BarcodeFormat barcodeFormat, int i10, int i11, Map map) throws WriterException {
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
