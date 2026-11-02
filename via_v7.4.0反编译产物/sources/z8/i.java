package z8;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class i {
    public static int a(int i10, int i11, int i12, int i13) {
        int i14 = 1;
        if (i10 > 0 && i11 > 0 && i12 > 0 && i13 > 0) {
            if (i11 <= i13 && i10 <= i12) {
                return 1;
            }
            int i15 = i11 / 2;
            int i16 = i10 / 2;
            while (i15 / i14 >= i13 && i16 / i14 >= i12) {
                i14 *= 2;
            }
        }
        return i14;
    }

    public static Bitmap b(Bitmap bitmap, int i10, int i11) {
        if (bitmap != null && !bitmap.isRecycled() && i11 > 0 && i10 > 0) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (height > 0 && width > 0) {
                float f10 = i10 / i11;
                float f11 = width;
                float f12 = height;
                if (f11 / f12 > f10) {
                    int iMin = Math.min((int) (f12 * f10), width);
                    Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, (width - iMin) / 2, 0, iMin, height);
                    return height > i11 ? Bitmap.createScaledBitmap(bitmapCreateBitmap, i10, i11, true) : bitmapCreateBitmap;
                }
                int iMin2 = Math.min((int) (f11 / f10), height);
                Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(bitmap, 0, (height - iMin2) / 2, width, iMin2);
                return width > i10 ? Bitmap.createScaledBitmap(bitmapCreateBitmap2, i10, i11, true) : bitmapCreateBitmap2;
            }
        }
        return null;
    }

    public static Bitmap c(String str, int i10, int i11) {
        if (str == null || str.isEmpty() || i11 <= 0 || i10 <= 0) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inSampleSize = a(options.outWidth, options.outHeight, i10, i11);
        options.inJustDecodeBounds = false;
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(str, options);
        if (bitmapDecodeFile == null) {
            return null;
        }
        return b(bitmapDecodeFile, i10, i11);
    }
}
