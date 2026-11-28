package mark.via.download;

import android.content.ContentValues;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class t1 {
    public static void c(g5.c cVar) {
        okhttp3.r rVarQ = okhttp3.r.q(cVar.t());
        if (rVarQ == null) {
            return;
        }
        if ("dl.dropboxusercontent.com".equals(rVarQ.l()) || rVarQ.l().endsWith(".dl.dropboxusercontent.com")) {
            if (cVar.o() == null) {
                return;
            } else {
                rVarQ = okhttp3.r.q(cVar.o());
            }
        }
        if (rVarQ != null) {
            if ("www.dropbox.com".equals(rVarQ.l()) || "dropbox.com".equals(rVarQ.l())) {
                if (rVarQ.g().startsWith("/scl/fi/") || rVarQ.g().startsWith("/s/")) {
                    cVar.T(rVarQ.o().r("raw").v("dl", "1").f(null).b().toString());
                    cVar.I(true);
                    cVar.x(1);
                }
            }
        }
    }

    public static String d(String str, String str2) {
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

    public static boolean e(String str) {
        return str == null || str.isEmpty();
    }

    public static void f(g5.c cVar) {
        if (cVar == null || cVar.t() == null || !g5.b.b(cVar.q())) {
            return;
        }
        tc.a.i("Failed to download: %s, referer: %s", cVar.t(), cVar.t().equals(cVar.o()) ? null : cVar.o());
        if (cVar.e() == null) {
            return;
        }
        tc.a.j(cVar.e());
    }

    public static void g(Context context, final Uri uri) {
        if (context == null || uri == null) {
            return;
        }
        if (com.tuyafeng.support.utils.o.i() || com.tuyafeng.support.utils.o.h()) {
            final Context applicationContext = context.getApplicationContext();
            r6.a.e(new u6.a() { // from class: mark.via.download.r1
                @Override // u6.a
                public final void run() {
                    t1.h(applicationContext, uri);
                }
            }).h(a7.a.c()).f(new u6.a() { // from class: mark.via.download.s1
                @Override // u6.a
                public final void run() {
                    t1.a();
                }
            }, new w7.e0());
        }
        if (!x8.b1.q(uri) || uri.getPath() == null) {
            return;
        }
        MediaScannerConnection.scanFile(context, new String[]{uri.getPath()}, null, null);
    }

    public static void h(Context context, Uri uri) {
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
                        } catch (Throwable th) {
                            try {
                                parcelFileDescriptorOpenFileDescriptor.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                            throw th;
                        }
                    } else if (parcelFileDescriptorOpenFileDescriptor == null) {
                        return;
                    }
                    parcelFileDescriptorOpenFileDescriptor.close();
                } catch (Exception e10) {
                    tc.a.k(e10, "Failed to update image metadata for uri: %s", uri);
                }
            }
        }
    }

    public static int i(Context context, g5.c cVar, String str) {
        String str2;
        if (cVar == null || e(cVar.m()) || e(cVar.l())) {
            return 2;
        }
        if (x8.b1.p(context, cVar.f())) {
            return 0;
        }
        Uri uriC = x8.b1.c(context, cVar.m(), cVar.l(), cVar.k());
        if (uriC == null) {
            String strL = cVar.l();
            int iIndexOf = strL.indexOf(46);
            String str3 = "_" + Long.toHexString(System.currentTimeMillis());
            if (iIndexOf > 0) {
                str2 = strL.substring(0, iIndexOf) + str3 + strL.substring(iIndexOf);
            } else {
                str2 = strL + str3;
            }
            Uri uriC2 = x8.b1.c(context, cVar.m(), str2, cVar.k());
            if (uriC2 != null || str == null || str.equals(cVar.m())) {
                uriC = uriC2;
            } else {
                uriC = x8.b1.c(context, str, strL, cVar.k());
                if (uriC == null) {
                    uriC = x8.b1.c(context, str, str2, cVar.k());
                }
                if (uriC != null) {
                    cVar.L(str);
                }
            }
        }
        if (uriC == null) {
            return 3;
        }
        x8.b1.d(context, uriC);
        cVar.C(uriC);
        String strK = x8.b1.k(context, uriC);
        if (strK == null) {
            strK = cVar.l();
        }
        if (strK == null) {
            strK = "Unknown";
        }
        cVar.K(strK);
        return 1;
    }

    public static /* synthetic */ void a() {
    }
}
