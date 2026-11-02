package t5;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.util.HashMap;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class z {

    /* renamed from: a, reason: collision with root package name */
    public static final b f12270a = new b();

    public static Bitmap a(String str, int i10) {
        return b(str, i10, null);
    }

    public static Bitmap b(String str, int i10, Bitmap bitmap) {
        try {
            HashMap map = new HashMap();
            map.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
            map.put(EncodeHintType.MARGIN, 1);
            Bitmap bitmapC = f12270a.c(str, BarcodeFormat.QR_CODE, i10, i10, map);
            if (bitmap != null && bitmap.getHeight() > 0 && bitmap.getWidth() > 0) {
                Canvas canvas = new Canvas(bitmapC);
                Paint paint = new Paint(1);
                paint.setColor(-1);
                int iMin = str.length() < 128 ? Math.min(i10 / 5, 84) : Math.min(i10 / 7, 52);
                if (Math.min(iMin / bitmap.getHeight(), 1.0f) < 1.0f) {
                    bitmap = Bitmap.createScaledBitmap(bitmap, iMin, iMin, true);
                } else {
                    iMin = bitmap.getHeight();
                }
                float f10 = (i10 - iMin) >> 1;
                canvas.drawBitmap(bitmap, f10, f10, paint);
                canvas.save();
            }
            return bitmapC;
        } catch (WriterException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static String c(Bitmap bitmap) {
        com.google.zxing.j jVarA;
        if (bitmap == null) {
            return "";
        }
        int[] iArr = new int[bitmap.getWidth() * bitmap.getHeight()];
        bitmap.getPixels(iArr, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
        com.google.zxing.b bVar = new com.google.zxing.b(new s3.j(new com.google.zxing.h(bitmap.getWidth(), bitmap.getHeight(), iArr)));
        try {
            try {
                z3.a aVar = new z3.a();
                HashMap map = new HashMap();
                map.put(DecodeHintType.CHARACTER_SET, "utf-8");
                map.put(DecodeHintType.TRY_HARDER, Boolean.TRUE);
                map.put(DecodeHintType.POSSIBLE_FORMATS, BarcodeFormat.QR_CODE);
                jVarA = aVar.a(bVar, map);
                if (!bitmap.isRecycled()) {
                    bitmap.recycle();
                }
            } catch (Exception e10) {
                e10.printStackTrace();
                if (!bitmap.isRecycled()) {
                    bitmap.recycle();
                }
                jVarA = null;
            }
            return jVarA == null ? "" : jVarA.f();
        } finally {
        }
    }
}
