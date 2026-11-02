package j9;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import g6.y;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import z8.c1;
import z8.i;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class a {
    public static void a(Context context) {
        File[] fileArrListFiles;
        String strL = c1.l(context);
        if (strL == null || strL.isEmpty()) {
            return;
        }
        File file = new File(strL);
        if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
            for (File file2 : fileArrListFiles) {
                String name = file2.getName();
                if (file2.isFile() && ("background.jpg".equals(name) || (name.startsWith("background-") && (name.endsWith(".jpeg") || name.endsWith(".jpg"))))) {
                    file2.delete();
                }
            }
        }
    }

    public static String b(Context context) {
        return new File(c1.l(context), "background.jpg").getAbsolutePath();
    }

    public static String[] c(Context context, String str) {
        String[] strArr = new String[0];
        if (str == null || str.isEmpty()) {
            pc.a.h("Can not process with null or empty path", new Object[0]);
            return strArr;
        }
        File file = new File(str);
        if (!file.exists() || file.isDirectory()) {
            pc.a.h("Can not process with invalid file: %s", str);
            return strArr;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        int iMax = Math.max(y.s(context), y.q(context));
        options.inSampleSize = i.a(options.outWidth, options.outHeight, iMax, iMax);
        options.inJustDecodeBounds = false;
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(str, options);
        if (bitmapDecodeFile == null) {
            pc.a.h("Can not process with null bitmap", new Object[0]);
            return strArr;
        }
        a(context);
        String strB = b(context);
        if (d(bitmapDecodeFile, strB)) {
            strArr = new String[]{strB};
        } else {
            pc.a.h("Can not save bitmap to %s", strB);
        }
        bitmapDecodeFile.recycle();
        return strArr;
    }

    public static boolean d(Bitmap bitmap, String str) throws IOException {
        File file;
        File parentFile;
        if (bitmap != null && str != null && !str.isEmpty() && (parentFile = (file = new File(str)).getParentFile()) != null && ((parentFile.exists() || parentFile.mkdirs()) && (!file.exists() || file.delete()))) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                try {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 92, fileOutputStream);
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
}
