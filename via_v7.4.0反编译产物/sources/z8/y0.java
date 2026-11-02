package z8;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class y0 {
    public static Bitmap a(String str, int i10) {
        if (str == null || !new File(str).exists()) {
            return null;
        }
        return i.c(str, i10, i10);
    }

    public static String b(String str) {
        int iIndexOf = str.indexOf("://");
        int iIndexOf2 = iIndexOf >= 0 ? iIndexOf + 3 : str.indexOf(58) + 1;
        int iIndexOf3 = str.indexOf(47, iIndexOf2);
        if (iIndexOf3 < 0) {
            iIndexOf3 = str.indexOf(63, iIndexOf2);
        }
        if (iIndexOf3 < 0) {
            iIndexOf3 = str.length();
        }
        return str.substring(iIndexOf2, iIndexOf3);
    }

    public static Bitmap c(Context context, String str) {
        String strD = d(context, str);
        if (strD == null) {
            return null;
        }
        return a(strD, g6.y.h(context, 24.0f));
    }

    public static String d(Context context, String str) {
        if (context == null || str == null || str.isEmpty()) {
            return null;
        }
        String strB = b(str);
        if (strB.isEmpty()) {
            return null;
        }
        return c1.w(context, "favicons", v0.g(strB));
    }

    public static Bitmap e(Bitmap bitmap, int i10, int i11, int i12) {
        int i13;
        int i14;
        if (bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f10 = width;
        float f11 = height;
        float f12 = i11;
        float f13 = i10 / f12;
        if (f10 / f11 >= f13) {
            i14 = (int) (f13 * f11);
            i13 = height;
        } else {
            i13 = (int) (f10 / f13);
            i14 = width;
        }
        float fMin = Math.min(f12 / i13, 1.0f);
        if (fMin < 1.0f) {
            Matrix matrix = new Matrix();
            matrix.postScale(fMin, fMin);
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        } else {
            i11 = i13;
            i10 = i14;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i10, i11, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        RectF rectF = new RectF(new Rect(0, 0, i10, i11));
        canvas.drawColor(0);
        float f14 = i12;
        canvas.drawRoundRect(rectF, f14, f14, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, (i10 / 2.0f) - ((f10 * fMin) / 2.0f), (i11 / 2.0f) - ((f11 * fMin) / 2.0f), paint);
        canvas.save();
        return bitmapCreateBitmap;
    }

    public static boolean f(Bitmap bitmap, String str, int i10, int i11) throws IOException {
        Bitmap bitmapE;
        File file;
        File parentFile;
        if (bitmap != null && !bitmap.isRecycled() && str != null && !str.isEmpty() && (bitmapE = e(bitmap, i10, i10, i11)) != null && (parentFile = (file = new File(str)).getParentFile()) != null && ((parentFile.exists() || parentFile.mkdirs()) && (!file.exists() || file.delete()))) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                try {
                    bitmapE.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    return true;
                } finally {
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        return false;
    }

    public static boolean g(Context context, String str, Bitmap bitmap) {
        String strD = d(context, str);
        if (strD == null) {
            return false;
        }
        return f(bitmap, strD, g6.y.h(context, 24.0f), g6.y.h(context, 4.0f));
    }
}
