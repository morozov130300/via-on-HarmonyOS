package z8;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class w3 {
    public static boolean a(String str, String str2, String str3) {
        if (str3 != null && !str3.isEmpty() && str2 != null && !str2.isEmpty() && c1.d(str)) {
            File file = new File(str2);
            if (file.exists() && !file.isDirectory() && c(file)) {
                File file2 = new File(str, r(str3) + ".png");
                if ((!file2.exists() || file2.delete()) && file.renameTo(file2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void b(String str, String str2, String str3) throws Throwable {
        boolean zG;
        if (str == null || str.isEmpty() || str2 == null || str2.isEmpty() || str3 == null || str3.isEmpty() || !c1.d(str)) {
            return;
        }
        File file = new File(str, r(str3) + ".png");
        if (file.exists()) {
            return;
        }
        try {
            file.createNewFile();
        } catch (Exception unused) {
        }
        try {
            zG = g(str2, file);
        } catch (Exception e10) {
            e10.printStackTrace();
            zG = false;
        }
        if (zG) {
            c(file);
        } else {
            file.delete();
        }
    }

    public static boolean c(File file) throws IOException {
        if (file.exists() && !file.isDirectory()) {
            try {
                Bitmap bitmapS = s(BitmapFactory.decodeStream(new FileInputStream(file)), 144, 144);
                if (bitmapS == null) {
                    return false;
                }
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                bitmapS.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                bitmapS.recycle();
                return true;
            } catch (Exception e10) {
                pc.a.d(e10);
            }
        }
        return false;
    }

    public static boolean d(String str) {
        return c1.g(str);
    }

    public static boolean e(String str, String str2) {
        if (str2 == null || str2.isEmpty()) {
            return false;
        }
        File file = new File(str, r(str2) + ".png");
        return !file.exists() || file.delete();
    }

    public static boolean f(String str, Set set) {
        File[] fileArrListFiles;
        File file = new File(str);
        if (!file.isDirectory() || set == null || set.isEmpty() || (fileArrListFiles = file.listFiles()) == null || fileArrListFiles.length == 0) {
            return true;
        }
        HashSet hashSet = new HashSet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            if (str2 != null && !str2.isEmpty()) {
                hashSet.add(r(str2) + ".png");
            }
        }
        int i10 = 0;
        for (File file2 : fileArrListFiles) {
            if (file2.isFile() && !hashSet.contains(file2.getName()) && file2.delete()) {
                i10++;
            }
        }
        return i10 > 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.net.HttpURLConnection, java.net.URLConnection] */
    public static boolean g(String str, File file) throws Throwable {
        boolean z10 = false;
        FileOutputStream fileOutputStream = null;
        try {
            try {
                str = (HttpURLConnection) new URL(str).openConnection();
                try {
                    str.setRequestMethod("GET");
                    if (str.getResponseCode() != 200) {
                        g6.j.a(null);
                    } else {
                        FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                        try {
                            InputStream inputStream = str.getInputStream();
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int i10 = inputStream.read(bArr);
                                if (i10 <= 0) {
                                    break;
                                }
                                fileOutputStream2.write(bArr, 0, i10);
                            }
                            z10 = true;
                            str.disconnect();
                            g6.j.a(fileOutputStream2);
                        } catch (Exception e10) {
                            e = e10;
                            fileOutputStream = fileOutputStream2;
                            e.printStackTrace();
                            g6.j.a(fileOutputStream);
                            if (str != 0) {
                                str.disconnect();
                            }
                            return z10;
                        } catch (Throwable th) {
                            th = th;
                            fileOutputStream = fileOutputStream2;
                            g6.j.a(fileOutputStream);
                            if (str != 0) {
                                str.disconnect();
                            }
                            throw th;
                        }
                    }
                    str.disconnect();
                    return z10;
                } catch (Exception e11) {
                    e = e11;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e12) {
            e = e12;
            str = 0;
        } catch (Throwable th3) {
            th = th3;
            str = 0;
        }
    }

    public static Bitmap h(Context context, String str, int i10, int i11, int i12, int i13, int i14) {
        float f10 = context.getResources().getDisplayMetrics().density;
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i12, i13, Bitmap.Config.ARGB_8888);
        bitmapCreateBitmap.eraseColor(0);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(i11);
        float f11 = i14;
        canvas.drawRoundRect(new RectF(new Rect(0, 0, i12, i13)), f11, f11, paint);
        paint.setColor(i10);
        paint.setTextSize(Math.max((int) (f10 * 16.0f), i12 / 4));
        paint.getTextBounds(str, 0, str.length(), new Rect());
        canvas.drawText(str, (bitmapCreateBitmap.getWidth() - r5.width()) / 2, (bitmapCreateBitmap.getHeight() + r5.height()) / 2, paint);
        return bitmapCreateBitmap;
    }

    public static Bitmap i(String str, String str2, int i10, int i11, int i12) {
        if (str2 != null && !str2.isEmpty()) {
            File file = new File(str, str2);
            if (file.exists() && !file.isDirectory()) {
                try {
                    return t(BitmapFactory.decodeStream(new FileInputStream(file)), i10, i11, i12);
                } catch (Exception e10) {
                    pc.a.d(e10);
                }
            }
        }
        return null;
    }

    public static Drawable j(String str, String str2, int i10, int i11, int i12) {
        return k(str, r(str2) + ".png", i10, i11, i12);
    }

    public static Drawable k(String str, String str2, int i10, int i11, int i12) {
        Bitmap bitmapI = i(str, str2, i10, i11, i12);
        if (bitmapI == null) {
            return null;
        }
        return new BitmapDrawable(bitmapI);
    }

    public static String l(String str, String str2) {
        return new File(str, r(str2) + ".png").getAbsolutePath();
    }

    public static String m(Context context) {
        return new File(context.getFilesDir(), "icon").getAbsolutePath();
    }

    public static String n(String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(".");
        String str2 = File.separator;
        sb2.append(str2);
        sb2.append("icon");
        sb2.append(str2);
        sb2.append(r(str));
        sb2.append(".png");
        return sb2.toString();
    }

    public static Drawable o(int i10, int i11) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i11);
        gradientDrawable.setCornerRadius(i10);
        return gradientDrawable;
    }

    public static Drawable p(Context context, int i10) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(549503168);
        gradientDrawable.setCornerRadius(i10);
        gradientDrawable.setStroke(g6.y.h(context, 1.0f), 1073741824, g6.y.h(context, 4.0f), g6.y.h(context, 4.0f));
        Drawable drawableA = lb.b.a(context, x7.o.f13747n, x7.u.Rd);
        if (drawableA != null) {
            drawableA.setColorFilter(g6.e.a(context, x7.k.f13664j), PorterDuff.Mode.SRC_IN);
        }
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{gradientDrawable, drawableA});
        int iH = g6.y.h(context, 12.0f);
        layerDrawable.setLayerInset(1, iH, iH, iH, iH);
        return layerDrawable;
    }

    public static Bitmap q(Context context, String str, String str2) {
        int iF = w8.e.f(context);
        int iC = Build.VERSION.SDK_INT >= 26 ? 0 : (int) (((pa.r.j().X2().c() / 127.0f) * iF) / 2.0f);
        Bitmap bitmapI = i(m(context), r(str) + ".png", iF, iF, iC);
        if (bitmapI != null) {
            return bitmapI;
        }
        i6.i0 i0Var = i6.i0.f7006a;
        return h(context, (str2 == null || str2.isEmpty()) ? i0Var.b(i0Var.f(str)) : g6.p.a(str2), -1, b0.y(str), iF, iF, iC);
    }

    public static String r(String str) {
        if (str == null || str.isEmpty()) {
            return "untitled";
        }
        if (i6.i0.f7006a.s(str)) {
            int iIndexOf = str.indexOf("://") + 3;
            int iIndexOf2 = str.indexOf(47, iIndexOf);
            if (iIndexOf2 < 0) {
                iIndexOf2 = str.indexOf(63, iIndexOf);
            }
            if (iIndexOf2 < 0) {
                iIndexOf2 = str.length();
            }
            if (iIndexOf2 > iIndexOf) {
                return str.substring(iIndexOf, iIndexOf2).toLowerCase(Locale.ROOT);
            }
        }
        return v0.g(str.toLowerCase(Locale.ROOT));
    }

    public static Bitmap s(Bitmap bitmap, int i10, int i11) {
        int i12;
        int i13;
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
            i13 = (int) (f13 * f11);
            i12 = height;
        } else {
            i12 = (int) (f10 / f13);
            i13 = width;
        }
        float fMin = Math.min(f12 / i12, 1.0f);
        if (fMin < 1.0f) {
            Matrix matrix = new Matrix();
            matrix.postScale(fMin, fMin);
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        } else {
            i11 = i12;
            i10 = i13;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i10, i11, Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint(2);
        paint.setAntiAlias(true);
        canvas.drawColor(-1);
        canvas.drawBitmap(bitmap, (i10 / 2.0f) - ((f10 * fMin) / 2.0f), (i11 / 2.0f) - ((f11 * fMin) / 2.0f), paint);
        canvas.save();
        bitmap.recycle();
        return bitmapCreateBitmap;
    }

    public static Bitmap t(Bitmap bitmap, int i10, int i11, int i12) {
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
        bitmap.recycle();
        return bitmapCreateBitmap;
    }
}
