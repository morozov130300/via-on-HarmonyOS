package z8;

import android.content.ContentValues;
import android.content.Context;
import android.content.UriPermission;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import androidx.core.content.FileProvider;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.Set;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class b1 {
    public static boolean a(Context context, Uri uri) {
        if (uri != null && uri.getPath() != null && !uri.getPath().isEmpty()) {
            if (q(uri)) {
                try {
                    return new File(uri.getPath()).canWrite();
                } catch (Exception e10) {
                    e10.printStackTrace();
                    return false;
                }
            }
            for (UriPermission uriPermission : context.getContentResolver().getPersistedUriPermissions()) {
                if (uri.equals(uriPermission.getUri()) && uriPermission.isWritePermission()) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean b(Context context, Uri uri, Uri uri2) throws Throwable {
        OutputStream outputStream;
        boolean z10 = false;
        if (uri == null || uri2 == null || uri.getPath() == null || uri.getPath().isEmpty() || uri2.getPath() == null || uri2.getPath().isEmpty()) {
            pc.a.h("Can not rename null file or rename to null file", new Object[0]);
            return false;
        }
        if (uri.equals(uri2)) {
            pc.a.h("Can not rename file with itself", new Object[0]);
            return false;
        }
        OutputStream outputStreamL = null;
        try {
            InputStream inputStreamI = i(context, uri);
            try {
                outputStreamL = l(context, uri2);
                if (inputStreamI != 0 && outputStreamL != null) {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int i10 = inputStreamI.read(bArr);
                        if (i10 <= 0) {
                            break;
                        }
                        outputStreamL.write(bArr, 0, i10);
                        outputStreamL.flush();
                    }
                    z10 = true;
                }
                g6.j.a(inputStreamI);
                g6.j.a(outputStreamL);
                return z10;
            } catch (Exception e10) {
                e = e10;
                OutputStream outputStream2 = outputStreamL;
                outputStreamL = inputStreamI;
                outputStream = outputStream2;
                try {
                    pc.a.i(e);
                    g6.j.a(outputStreamL);
                    g6.j.a(outputStream);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    g6.j.a(outputStreamL);
                    g6.j.a(outputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                OutputStream outputStream3 = outputStreamL;
                outputStreamL = inputStreamI;
                outputStream = outputStream3;
                g6.j.a(outputStreamL);
                g6.j.a(outputStream);
                throw th;
            }
        } catch (Exception e11) {
            e = e11;
            outputStream = null;
        } catch (Throwable th3) {
            th = th3;
            outputStream = null;
        }
    }

    public static Uri c(Context context, String str, String str2, String str3) {
        b0.c cVarA;
        if (str == null || str.isEmpty() || str2 == null || str2.isEmpty()) {
            pc.a.h("Can not create a file with null or empty path", new Object[0]);
            return null;
        }
        if (str3 == null || str3.isEmpty()) {
            str3 = "application/octet-stream";
        }
        if (str.startsWith("content://")) {
            b0.c cVarD = b0.c.d(context, Uri.parse(str));
            if (cVarD != null && (cVarA = cVarD.a(str3, u(context, cVarD.f(), str2))) != null) {
                return cVarA.f();
            }
            pc.a.h("Can not create a file with path: %s", str);
            return null;
        }
        char cCharAt = str.charAt(0);
        char c10 = File.separatorChar;
        boolean z10 = cCharAt == c10;
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 29 || z10) {
            if (!z10) {
                str = Environment.getExternalStorageDirectory().getAbsolutePath() + c10 + str;
            }
            File file = new File(str, c1.K(str, str2));
            return i10 >= 24 ? FileProvider.f(context, "mark.via.provider", file) : Uri.fromFile(file);
        }
        Uri contentUri = MediaStore.Downloads.getContentUri("external");
        String strT = t(context, contentUri, str2, str);
        ContentValues contentValues = new ContentValues();
        contentValues.put("_display_name", strT);
        contentValues.put("mime_type", str3);
        contentValues.put("relative_path", str);
        try {
            return context.getApplicationContext().getContentResolver().insert(contentUri, contentValues);
        } catch (Exception e10) {
            pc.a.b(e10);
            return null;
        }
    }

    public static boolean d(Context context, Uri uri) throws IOException {
        OutputStream outputStreamL;
        if (uri != null && uri.getPath() != null) {
            if (!q(uri)) {
                if (!n(uri) || (outputStreamL = l(context, uri)) == null) {
                    return false;
                }
                g6.j.a(outputStreamL);
                return true;
            }
            File file = new File(uri.getPath());
            if (file.exists()) {
                return true;
            }
            try {
                return file.createNewFile();
            } catch (Exception e10) {
                pc.a.i(e10);
                return false;
            }
        }
        return false;
    }

    public static boolean e(Context context, Uri uri) {
        boolean z10 = false;
        if (context == null || uri == null) {
            return false;
        }
        if (q(uri)) {
            return uri.getPath() != null && new File(uri.getPath()).delete();
        }
        try {
        } catch (Exception e10) {
            pc.a.b(e10);
        }
        boolean z11 = context.getApplicationContext().getContentResolver().delete(uri, null, null) > 0;
        if (z11) {
            return z11;
        }
        b0.c cVarC = b0.c.c(context, uri);
        if (cVarC != null && cVarC.b()) {
            z10 = true;
        }
        return z10;
    }

    public static String f(Set set, String str, String str2, String str3) {
        int i10 = 1;
        while (set.contains(str3)) {
            str3 = str + " (" + i10 + ")." + str2;
            i10++;
        }
        return str3;
    }

    public static Set g(Context context, Uri uri, String str, String str2) {
        HashSet hashSet = new HashSet();
        String strReplace = str.replace("\\", "\\\\").replace("%", "\\%").replace("_", "\\_");
        String str3 = "relative_path = ? AND _display_name LIKE ? ESCAPE '\\'";
        if (!str2.endsWith("/")) {
            str2 = str2 + "/";
        }
        try {
            Cursor cursorQuery = context.getContentResolver().query(uri, new String[]{"_display_name"}, str3, new String[]{str2, strReplace + "%"}, null);
            if (cursorQuery != null) {
                try {
                    int columnIndex = cursorQuery.getColumnIndex("_display_name");
                    if (columnIndex >= 0) {
                        while (cursorQuery.moveToNext()) {
                            String string = cursorQuery.getString(columnIndex);
                            if (string != null) {
                                hashSet.add(string);
                            }
                        }
                    }
                } finally {
                }
            } else if (cursorQuery == null) {
                return hashSet;
            }
            cursorQuery.close();
            return hashSet;
        } catch (Exception e10) {
            pc.a.b(e10);
            return hashSet;
        }
    }

    public static Set h(Context context, Uri uri, String str) {
        HashSet hashSet = new HashSet();
        try {
            Cursor cursorQuery = context.getContentResolver().query(DocumentsContract.buildChildDocumentsUriUsingTree(uri, DocumentsContract.getDocumentId(uri)), new String[]{"_display_name"}, null, null, null);
            if (cursorQuery != null) {
                try {
                    int columnIndex = cursorQuery.getColumnIndex("_display_name");
                    if (columnIndex >= 0) {
                        while (cursorQuery.moveToNext()) {
                            String string = cursorQuery.getString(columnIndex);
                            if (string != null && string.startsWith(str)) {
                                hashSet.add(string);
                            }
                        }
                    }
                } finally {
                }
            } else if (cursorQuery == null) {
                return hashSet;
            }
            cursorQuery.close();
            return hashSet;
        } catch (Exception e10) {
            pc.a.b(e10);
            return hashSet;
        }
    }

    public static InputStream i(Context context, Uri uri) {
        if (uri == null) {
            pc.a.h("Can not get output stream from null", new Object[0]);
            return null;
        }
        if (q(uri)) {
            try {
                return new FileInputStream(uri.getPath());
            } catch (Exception e10) {
                pc.a.i(e10);
                return null;
            }
        }
        try {
            return context.getApplicationContext().getContentResolver().openInputStream(uri);
        } catch (Exception e11) {
            pc.a.i(e11);
            return null;
        }
    }

    public static long j(Context context, Uri uri) {
        long j10 = -1;
        if (uri == null) {
            return -1L;
        }
        if (q(uri)) {
            if (uri.getPath() == null) {
                return 0L;
            }
            return new File(uri.getPath()).length();
        }
        try {
            Cursor cursorQuery = context.getContentResolver().query(uri, new String[]{"_size"}, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        j10 = cursorQuery.getLong(0);
                    }
                } finally {
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return j10;
        } catch (Exception e10) {
            pc.a.i(e10);
            return j10;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String k(Context context, Uri uri) {
        Uri uri2;
        String string = null;
        if (uri == null) {
            return null;
        }
        if (q(uri)) {
            return uri.getLastPathSegment();
        }
        try {
            uri2 = uri;
            try {
                Cursor cursorQuery = context.getContentResolver().query(uri2, new String[]{"_display_name"}, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            string = cursorQuery.getString(0);
                        }
                    } finally {
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Exception e10) {
                e = e10;
                pc.a.i(e);
                if (string != null) {
                }
            }
        } catch (Exception e11) {
            e = e11;
            uri2 = uri;
        }
        return string != null ? uri2.getLastPathSegment() : string;
    }

    public static OutputStream l(Context context, Uri uri) {
        if (uri == null) {
            pc.a.h("Can not get output stream from null", new Object[0]);
            return null;
        }
        if (q(uri)) {
            try {
                return new FileOutputStream(uri.getPath());
            } catch (Exception e10) {
                pc.a.i(e10);
                return null;
            }
        }
        try {
            return context.getApplicationContext().getContentResolver().openOutputStream(uri);
        } catch (Exception e11) {
            pc.a.i(e11);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String m(Context context, Uri uri) {
        Uri uri2;
        b0.c cVarC;
        String string = null;
        if (uri == null) {
            return null;
        }
        if (q(uri)) {
            return uri.getPath();
        }
        try {
            uri2 = uri;
            try {
                Cursor cursorQuery = context.getContentResolver().query(uri2, new String[]{"_data"}, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            string = cursorQuery.getString(0);
                        }
                    } finally {
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Exception unused) {
                if (string == null) {
                }
                cVarC = b0.c.c(context, uri2);
                if (cVarC != null) {
                    cVarC = b0.c.d(context, uri2);
                }
                if (cVarC != null) {
                }
            }
        } catch (Exception unused2) {
            uri2 = uri;
        }
        if (string == null && !string.isEmpty()) {
            return string;
        }
        cVarC = b0.c.c(context, uri2);
        if (cVarC != null || cVarC.e() == null) {
            cVarC = b0.c.d(context, uri2);
        }
        return (cVarC != null || cVarC.e() == null) ? uri2.toString() : cVarC.e();
    }

    public static boolean n(Uri uri) {
        return uri != null && "content".equalsIgnoreCase(uri.getScheme());
    }

    public static boolean o(String str) {
        return str != null && str.startsWith("content://");
    }

    public static boolean p(Context context, Uri uri) throws IOException {
        if (uri != null && context != null) {
            if (q(uri)) {
                return uri.getPath() != null && new File(uri.getPath()).exists();
            }
            try {
                InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
                if (inputStreamOpenInputStream != null) {
                    inputStreamOpenInputStream.close();
                }
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static boolean q(Uri uri) {
        return uri != null && "file".equalsIgnoreCase(uri.getScheme());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean r(Context context, Uri uri, Uri uri2) throws Throwable {
        OutputStream outputStream;
        boolean z10 = false;
        if (uri == null || uri2 == null || uri.getPath() == null || uri.getPath().isEmpty() || uri2.getPath() == null || uri2.getPath().isEmpty()) {
            pc.a.h("Can not rename null file or rename to null file", new Object[0]);
            return false;
        }
        if (uri.equals(uri2)) {
            pc.a.h("Can not rename file with itself", new Object[0]);
            return false;
        }
        if (q(uri) && q(uri2)) {
            return new File(uri.getPath()).renameTo(new File(uri2.getPath()));
        }
        OutputStream outputStreamL = null;
        try {
            InputStream inputStreamI = i(context, uri);
            try {
                outputStreamL = l(context, uri2);
                if (inputStreamI != 0 && outputStreamL != null) {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int i10 = inputStreamI.read(bArr);
                        if (i10 <= 0) {
                            break;
                        }
                        outputStreamL.write(bArr, 0, i10);
                        outputStreamL.flush();
                    }
                    z10 = true;
                }
                g6.j.a(inputStreamI);
                g6.j.a(outputStreamL);
            } catch (Exception e10) {
                e = e10;
                outputStream = outputStreamL;
                outputStreamL = inputStreamI;
                try {
                    pc.a.i(e);
                    g6.j.a(outputStreamL);
                    g6.j.a(outputStream);
                    if (!z10) {
                    }
                    e(context, uri);
                    return z10;
                } catch (Throwable th) {
                    th = th;
                    g6.j.a(outputStreamL);
                    g6.j.a(outputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                outputStream = outputStreamL;
                outputStreamL = inputStreamI;
                g6.j.a(outputStreamL);
                g6.j.a(outputStream);
                throw th;
            }
        } catch (Exception e11) {
            e = e11;
            outputStream = null;
        } catch (Throwable th3) {
            th = th3;
            outputStream = null;
        }
        if (!z10) {
            uri = uri2;
        }
        e(context, uri);
        return z10;
    }

    public static boolean s(Context context, Uri uri, String str) {
        if (uri == null || uri.getPath() == null || uri.getPath().isEmpty() || str == null || str.isEmpty()) {
            pc.a.h("Can not rename null file or rename to null", new Object[0]);
            return false;
        }
        if (q(uri)) {
            return new File(uri.getPath()).renameTo(new File(new File(uri.getPath()).getParentFile(), str));
        }
        b0.c cVarC = b0.c.c(context, uri);
        if (cVarC != null) {
            try {
                if (cVarC.g(str)) {
                    return true;
                }
            } catch (Exception e10) {
                pc.a.b(e10);
            }
        }
        return false;
    }

    public static String t(Context context, Uri uri, String str, String str2) {
        int iLastIndexOf = str.lastIndexOf(46);
        if (iLastIndexOf > 0 && iLastIndexOf < str.length() - 1) {
            String strSubstring = str.substring(iLastIndexOf + 1);
            if (!i6.i0.f7006a.j(strSubstring)) {
                String strSubstring2 = str.substring(0, iLastIndexOf);
                return f(g(context, uri, strSubstring2, str2), strSubstring2, strSubstring, str);
            }
        }
        return str;
    }

    public static String u(Context context, Uri uri, String str) {
        int iLastIndexOf = str.lastIndexOf(46);
        if (iLastIndexOf > 0 && iLastIndexOf < str.length() - 1) {
            String strSubstring = str.substring(iLastIndexOf + 1);
            if (!i6.i0.f7006a.j(strSubstring)) {
                String strSubstring2 = str.substring(0, iLastIndexOf);
                return f(h(context, uri, strSubstring2), strSubstring2, strSubstring, str);
            }
        }
        return str;
    }
}
