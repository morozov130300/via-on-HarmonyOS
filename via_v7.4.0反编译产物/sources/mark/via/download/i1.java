package mark.via.download;

import android.content.ContentValues;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import java.io.IOException;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class i1 {
    public static /* synthetic */ void a() {
    }

    public static String c(String str, String str2) {
        int iLastIndexOf;
        int iIndexOf;
        String strD = l5.a.d(str);
        if (strD != null) {
            return strD;
        }
        String strDecode = Uri.decode(str);
        if (strDecode != null && !strDecode.isEmpty()) {
            int iIndexOf2 = strDecode.indexOf(63);
            if (iIndexOf2 > 0) {
                strDecode = strDecode.substring(0, iIndexOf2);
            }
            if (!strDecode.endsWith("/") && (iLastIndexOf = strDecode.lastIndexOf(47) + 1) > 0 && (iIndexOf = strDecode.indexOf(46, iLastIndexOf)) > 0) {
                return l5.c.c(strDecode.substring(iIndexOf + 1), str2);
            }
        }
        return str2;
    }

    public static boolean d(String str) {
        return str == null || str.isEmpty();
    }

    public static void e(g5.c cVar) {
        if (cVar == null || cVar.t() == null || !g5.b.b(cVar.q())) {
            return;
        }
        pc.a.h("Failed to download: %s, referer: %s", cVar.t(), cVar.t().equals(cVar.o()) ? null : cVar.o());
        if (cVar.e() == null) {
            return;
        }
        pc.a.i(cVar.e());
    }

    public static void f(Context context, final Uri uri) {
        if (context == null || uri == null) {
            return;
        }
        if (g6.o.i() || g6.o.h()) {
            final Context applicationContext = context.getApplicationContext();
            x6.a.e(new a7.a() { // from class: mark.via.download.g1
                @Override // a7.a
                public final void run() throws IOException {
                    i1.g(applicationContext, uri);
                }
            }).h(g7.a.c()).f(new a7.a() { // from class: mark.via.download.h1
                @Override // a7.a
                public final void run() {
                    i1.a();
                }
            }, new x7.g0());
        }
        if (!z8.b1.q(uri) || uri.getPath() == null) {
            return;
        }
        MediaScannerConnection.scanFile(context, new String[]{uri.getPath()}, null, null);
    }

    public static void g(Context context, Uri uri) throws IOException {
        if (context == null || uri == null || Build.VERSION.SDK_INT < 29) {
            return;
        }
        Uri contentUri = MediaStore.Downloads.getContentUri("external");
        if (contentUri.getScheme().equals(uri.getScheme()) && contentUri.getAuthority().equals(uri.getAuthority()) && uri.getPath() != null) {
            if (uri.getPath().startsWith(contentUri.getPath() + "/")) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                try {
                    ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "r");
                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                        try {
                            BitmapFactory.decodeFileDescriptor(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor(), null, options);
                            ContentValues contentValues = new ContentValues();
                            int i10 = options.outWidth;
                            if (i10 > 0 && options.outHeight > 0) {
                                contentValues.put("width", Integer.valueOf(i10));
                                contentValues.put("height", Integer.valueOf(options.outHeight));
                            }
                            long statSize = parcelFileDescriptorOpenFileDescriptor.getStatSize();
                            if (statSize >= 0) {
                                contentValues.put("_size", Long.valueOf(statSize));
                            }
                            if (contentValues.size() > 0) {
                                context.getContentResolver().update(uri, contentValues, null, null);
                            }
                        } finally {
                        }
                    } else if (parcelFileDescriptorOpenFileDescriptor == null) {
                        return;
                    }
                    parcelFileDescriptorOpenFileDescriptor.close();
                } catch (Exception e10) {
                    pc.a.j(e10, "Failed to update image metadata for uri: %s", uri);
                }
            }
        }
    }

    public static int h(Context context, g5.c cVar, String str) throws IOException {
        String str2;
        if (cVar == null || d(cVar.m()) || d(cVar.l())) {
            return 2;
        }
        if (z8.b1.p(context, cVar.f())) {
            return 0;
        }
        Uri uriC = z8.b1.c(context, cVar.m(), cVar.l(), cVar.k());
        if (uriC == null) {
            String strL = cVar.l();
            int iIndexOf = strL.indexOf(46);
            String str3 = "_" + Long.toHexString(System.currentTimeMillis());
            if (iIndexOf > 0) {
                str2 = strL.substring(0, iIndexOf) + str3 + strL.substring(iIndexOf);
            } else {
                str2 = strL + str3;
            }
            Uri uriC2 = z8.b1.c(context, cVar.m(), str2, cVar.k());
            if (uriC2 != null || str == null || str.equals(cVar.m())) {
                uriC = uriC2;
            } else {
                uriC = z8.b1.c(context, str, strL, cVar.k());
                if (uriC == null) {
                    uriC = z8.b1.c(context, str, str2, cVar.k());
                }
                if (uriC != null) {
                    cVar.K(str);
                }
            }
        }
        if (uriC == null) {
            return 3;
        }
        z8.b1.d(context, uriC);
        cVar.C(uriC);
        String strK = z8.b1.k(context, uriC);
        if (strK == null) {
            strK = cVar.l();
        }
        if (strK == null) {
            strK = "Unknown";
        }
        cVar.J(strK);
        return 1;
    }
}
