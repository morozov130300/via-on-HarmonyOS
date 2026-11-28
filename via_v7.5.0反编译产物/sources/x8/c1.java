package x8;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.webkit.URLUtil;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class c1 {
    public static String A(Context context, String str) {
        if (!URLUtil.isContentUrl(str)) {
            return null;
        }
        Uri uri = Uri.parse(str);
        String strK = b1.k(context, uri);
        if (strK == null || strK.isEmpty()) {
            strK = UUID.randomUUID() + ".html";
        }
        String strB = B(context);
        if (strB == null) {
            return null;
        }
        return b(context, uri, new File(strB, strK));
    }

    public static String B(Context context) {
        return x(context, "opened");
    }

    public static String C(Context context, Uri uri) {
        if (uri == null) {
            return "";
        }
        if (!uri.toString().startsWith("file://")) {
            return DocumentsContract.isDocumentUri(context, uri) ? s(context, uri) : m(context, uri);
        }
        String string = uri.toString();
        return string.substring(string.indexOf("file://") + 7);
    }

    public static String D(Context context) {
        return x(context, "offline");
    }

    public static String E(Context context) {
        return x(context, "settings");
    }

    public static String F(Context context) {
        return x(context, "skins");
    }

    public static String G(Context context, String str) {
        return y(context, "skins", str);
    }

    public static String H(Context context) {
        return z(context, "subscribed.txt");
    }

    public static String I(Context context) {
        return x(context, "tabs");
    }

    public static String J(Context context, String str) {
        return y(context, "tabs", str);
    }

    public static String K(String str, String str2) {
        int iLastIndexOf = str2.lastIndexOf(46);
        return iLastIndexOf < 0 ? L(str, str2, "") : L(str, str2.substring(0, iLastIndexOf), str2.substring(iLastIndexOf));
    }

    public static String L(String str, String str2, String str3) {
        if (!str.endsWith("/")) {
            str = str + "/";
        }
        File file = new File(str);
        boolean zExists = file.exists();
        if (!zExists) {
            zExists = file.mkdirs();
        }
        String str4 = str2 + str3;
        if (zExists) {
            File file2 = new File(file, str4);
            int i10 = 0;
            while (file2.exists()) {
                i10++;
                str4 = str2 + " (" + i10 + ")" + str3;
                file2 = new File(file, str4);
            }
        }
        return str4;
    }

    public static boolean M(Context context, String str) {
        if (context.getFilesDir().exists()) {
            return new File(context.getFilesDir(), str).exists();
        }
        return false;
    }

    public static boolean N(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            if (file.isDirectory()) {
                return true;
            }
            if (!file.delete()) {
                return false;
            }
        }
        return file.mkdirs();
    }

    public static String O(File file) throws Throwable {
        BufferedReader bufferedReader = null;
        if (file == null || !file.isFile()) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
                while (true) {
                    try {
                        String line = bufferedReader2.readLine();
                        if (line == null) {
                            break;
                        }
                        sb2.append(line);
                        sb2.append("\n");
                    } catch (Exception e10) {
                        e = e10;
                        bufferedReader = bufferedReader2;
                        e.printStackTrace();
                        com.tuyafeng.support.utils.j.a(bufferedReader);
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        com.tuyafeng.support.utils.j.a(bufferedReader);
                        throw th;
                    }
                }
                com.tuyafeng.support.utils.j.a(bufferedReader2);
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e11) {
            e = e11;
        }
        return sb2.toString().trim();
    }

    public static List P(File file) throws Throwable {
        BufferedReader bufferedReader = null;
        if (file == null || !file.isFile()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
                while (true) {
                    try {
                        String line = bufferedReader2.readLine();
                        if (line == null) {
                            com.tuyafeng.support.utils.j.a(bufferedReader2);
                            return arrayList;
                        }
                        String strTrim = line.trim();
                        if (!strTrim.isEmpty()) {
                            arrayList.add(strTrim);
                        }
                    } catch (Exception e10) {
                        e = e10;
                        bufferedReader = bufferedReader2;
                        e.printStackTrace();
                        com.tuyafeng.support.utils.j.a(bufferedReader);
                        return arrayList;
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        com.tuyafeng.support.utils.j.a(bufferedReader);
                        throw th;
                    }
                }
            } catch (Exception e11) {
                e = e11;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean Q(File file, String str) throws Throwable {
        OutputStreamWriter outputStreamWriter = null;
        try {
            try {
                OutputStreamWriter outputStreamWriter2 = new OutputStreamWriter(new FileOutputStream(file), k8.a.f7218a);
                try {
                    outputStreamWriter2.write(str);
                    try {
                        outputStreamWriter2.close();
                        return true;
                    } catch (Exception e10) {
                        tc.a.b(e10);
                        return true;
                    }
                } catch (Exception e11) {
                    e = e11;
                    outputStreamWriter = outputStreamWriter2;
                    tc.a.b(e);
                    if (outputStreamWriter == null) {
                        return false;
                    }
                    try {
                        outputStreamWriter.close();
                        return false;
                    } catch (Exception e12) {
                        tc.a.b(e12);
                        return false;
                    }
                } catch (Throwable th) {
                    th = th;
                    outputStreamWriter = outputStreamWriter2;
                    if (outputStreamWriter != null) {
                        try {
                            outputStreamWriter.close();
                        } catch (Exception e13) {
                            tc.a.b(e13);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e14) {
            e = e14;
        }
    }

    public static boolean R(File file, List list) throws Throwable {
        OutputStreamWriter outputStreamWriter = null;
        try {
            try {
                OutputStreamWriter outputStreamWriter2 = new OutputStreamWriter(new FileOutputStream(file), k8.a.f7218a);
                try {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        String str = (String) it.next();
                        if (!str.isEmpty()) {
                            outputStreamWriter2.write(str);
                            outputStreamWriter2.write(10);
                        }
                    }
                    com.tuyafeng.support.utils.j.a(outputStreamWriter2);
                    return true;
                } catch (Exception e10) {
                    e = e10;
                    outputStreamWriter = outputStreamWriter2;
                    tc.a.b(e);
                    com.tuyafeng.support.utils.j.a(outputStreamWriter);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    outputStreamWriter = outputStreamWriter2;
                    com.tuyafeng.support.utils.j.a(outputStreamWriter);
                    throw th;
                }
            } catch (Exception e11) {
                e = e11;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0048, code lost:
    
        if (r4.delete() == false) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean a(java.io.File r3, java.io.File r4) {
        /*
            r0 = 0
            if (r3 == 0) goto L93
            boolean r1 = r3.canRead()
            if (r1 == 0) goto L93
            boolean r1 = r3.exists()
            if (r1 == 0) goto L93
            if (r4 != 0) goto L13
            goto L93
        L13:
            boolean r1 = r4.exists()
            if (r1 == 0) goto L4b
            boolean r1 = r4.canRead()
            if (r1 == 0) goto L4a
            boolean r1 = r4.canWrite()
            if (r1 != 0) goto L26
            goto L4a
        L26:
            boolean r1 = r4.isDirectory()
            if (r1 == 0) goto L44
            java.io.File r1 = new java.io.File
            java.lang.String r2 = r3.getName()
            r1.<init>(r4, r2)
            boolean r4 = r1.exists()
            if (r4 == 0) goto L42
            boolean r4 = r1.delete()
            if (r4 != 0) goto L42
            return r0
        L42:
            r4 = r1
            goto L4b
        L44:
            boolean r1 = r4.delete()
            if (r1 != 0) goto L4b
        L4a:
            return r0
        L4b:
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream     // Catch: java.lang.Exception -> L7a
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Exception -> L7a
            r2.<init>(r3)     // Catch: java.lang.Exception -> L7a
            r1.<init>(r2)     // Catch: java.lang.Exception -> L7a
            java.io.BufferedOutputStream r3 = new java.io.BufferedOutputStream     // Catch: java.lang.Throwable -> L7c
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L7c
            r2.<init>(r4)     // Catch: java.lang.Throwable -> L7c
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L7c
            r4 = 1024(0x400, float:1.435E-42)
            byte[] r4 = new byte[r4]     // Catch: java.lang.Throwable -> L70
        L63:
            int r2 = r1.read(r4)     // Catch: java.lang.Throwable -> L70
            if (r2 <= 0) goto L72
            r3.write(r4, r0, r2)     // Catch: java.lang.Throwable -> L70
            r3.flush()     // Catch: java.lang.Throwable -> L70
            goto L63
        L70:
            r4 = move-exception
            goto L7e
        L72:
            r3.close()     // Catch: java.lang.Throwable -> L7c
            r3 = 1
            r1.close()     // Catch: java.lang.Exception -> L7a
            return r3
        L7a:
            r3 = move-exception
            goto L90
        L7c:
            r3 = move-exception
            goto L87
        L7e:
            r3.close()     // Catch: java.lang.Throwable -> L82
            goto L86
        L82:
            r3 = move-exception
            r4.addSuppressed(r3)     // Catch: java.lang.Throwable -> L7c
        L86:
            throw r4     // Catch: java.lang.Throwable -> L7c
        L87:
            r1.close()     // Catch: java.lang.Throwable -> L8b
            goto L8f
        L8b:
            r4 = move-exception
            r3.addSuppressed(r4)     // Catch: java.lang.Exception -> L7a
        L8f:
            throw r3     // Catch: java.lang.Exception -> L7a
        L90:
            r3.printStackTrace()
        L93:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: x8.c1.a(java.io.File, java.io.File):boolean");
    }

    public static String b(Context context, Uri uri, File file) {
        String path = null;
        if (uri != null && uri.getAuthority() != null && file != null) {
            try {
                InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
                try {
                    File fileE = e(inputStreamOpenInputStream, file);
                    if (fileE != null) {
                        path = fileE.getPath();
                    }
                    if (inputStreamOpenInputStream == null) {
                        return path;
                    }
                    inputStreamOpenInputStream.close();
                    return path;
                } catch (Throwable th) {
                    if (inputStreamOpenInputStream != null) {
                        try {
                            inputStreamOpenInputStream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            } catch (IOException e10) {
                tc.a.e(e10);
            }
        }
        return path;
    }

    public static boolean c(File file) {
        if (file == null) {
            return false;
        }
        if (!file.exists()) {
            return file.mkdirs();
        }
        if (file.isDirectory()) {
            return true;
        }
        return file.delete() && file.mkdirs();
    }

    public static boolean d(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        return c(new File(str));
    }

    public static File e(InputStream inputStream, File file) {
        if (inputStream == null || !d(file.getParent()) || (file.exists() && !file.delete())) {
            return null;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[8192];
                while (true) {
                    int i10 = inputStream.read(bArr);
                    if (i10 != -1) {
                        fileOutputStream.write(bArr, 0, i10);
                    } else {
                        fileOutputStream.flush();
                        try {
                            fileOutputStream.close();
                            return file;
                        } catch (IOException e10) {
                            e = e10;
                        }
                    }
                    e = e;
                    file = null;
                    tc.a.e(e);
                    return file;
                }
            } catch (Throwable th) {
                try {
                    fileOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException e11) {
            e = e11;
            file = null;
        }
    }

    public static boolean f(File file) {
        File[] fileArrListFiles;
        if (file == null || !file.exists()) {
            return true;
        }
        if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
            for (File file2 : fileArrListFiles) {
                if (!f(file2)) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    public static boolean g(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return f(new File(str));
    }

    public static void h(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        File file = new File(str);
        if (file.isDirectory()) {
            return;
        }
        N(file);
    }

    public static long i(File file, File file2) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        try {
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file2));
            long j10 = 1;
            while (true) {
                try {
                    int i10 = bufferedInputStream.read();
                    if (i10 == -1) {
                        if (bufferedInputStream2.read() == -1) {
                            j10 = -1;
                        }
                        bufferedInputStream2.close();
                        bufferedInputStream.close();
                        return j10;
                    }
                    if (i10 != bufferedInputStream2.read()) {
                        bufferedInputStream2.close();
                        bufferedInputStream.close();
                        return j10;
                    }
                    j10++;
                } catch (Throwable th) {
                    try {
                        bufferedInputStream2.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
                try {
                    bufferedInputStream.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th;
            }
        } catch (Throwable th4) {
            bufferedInputStream.close();
            throw th4;
        }
    }

    public static String j(Context context, String str) {
        File externalCacheDir = context.getExternalCacheDir();
        if (externalCacheDir == null) {
            externalCacheDir = context.getCacheDir();
        }
        File file = new File(externalCacheDir, str);
        if (file.exists() || file.mkdirs()) {
            return file.toString();
        }
        return null;
    }

    public static String k(Context context, String str, String str2) {
        File externalCacheDir = context.getExternalCacheDir();
        if (externalCacheDir == null) {
            externalCacheDir = context.getCacheDir();
        }
        File file = new File(externalCacheDir, str);
        if (file.exists() || file.mkdirs()) {
            return new File(file, str2).getAbsolutePath();
        }
        return null;
    }

    public static String l(Context context) {
        return x(context, "content");
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0044  */
    /* JADX WARN: Code duplicated, block: B:37:? A[RETURN, SYNTHETIC] */
    public static String m(Context context, Uri uri) {
        Exception exc;
        String string;
        String[] strArr = {"_data"};
        try {
            Cursor cursorQuery = context.getContentResolver().query(uri, strArr, null, null, null);
            if (cursorQuery != null) {
                try {
                    cursorQuery.moveToFirst();
                    string = cursorQuery.getString(cursorQuery.getColumnIndex(strArr[0]));
                } catch (Throwable th) {
                    try {
                        cursorQuery.close();
                        throw th;
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                        throw th;
                    }
                }
            } else {
                string = "";
            }
            if (cursorQuery != null) {
                try {
                    cursorQuery.close();
                } catch (Exception e10) {
                    exc = e10;
                    exc.printStackTrace();
                }
            }
        } catch (Exception e11) {
            exc = e11;
            string = "";
            exc.printStackTrace();
            if (string == null) {
                return "";
            }
            return string;
        }
        if (string == null) {
            return "";
        }
        return string;
    }

    public static String n(String str) {
        if (str != null) {
            String strTrim = str.trim();
            if (!strTrim.isEmpty()) {
                String strReplaceAll = strTrim.replaceAll("[\\\\:*?\"<>|]", "");
                do {
                    strReplaceAll = strReplaceAll.replace("//", "/");
                } while (strReplaceAll.indexOf("//") >= 0);
                return strReplaceAll;
            }
        }
        return "";
    }

    public static String o(String str) {
        if (str == null) {
            return "";
        }
        String strTrim = str.trim();
        if (strTrim.isEmpty()) {
            return "";
        }
        String strReplaceAll = strTrim.replaceAll("[/\\\\:*?\"<>|]", "-");
        if (strReplaceAll.length() > 200) {
            strReplaceAll = strReplaceAll.substring(0, 200);
        }
        try {
            if (strReplaceAll.getBytes("UTF-8").length <= 200) {
                return strReplaceAll;
            }
            int length = strReplaceAll.length();
            int i10 = 0;
            while (i10 < length) {
                int i11 = ((i10 + length) + 1) / 2;
                if (strReplaceAll.substring(0, i11).getBytes("UTF-8").length <= 200) {
                    i10 = i11;
                } else {
                    length = i11 - 1;
                }
            }
            return strReplaceAll.substring(0, i10);
        } catch (UnsupportedEncodingException e10) {
            tc.a.j(e10);
            return strReplaceAll;
        }
    }

    public static String p(Context context) {
        return z(context, "custom.txt");
    }

    public static String q(String str) {
        String absolutePath;
        if (Build.VERSION.SDK_INT >= 29) {
            absolutePath = File.separator + "sdcard";
        } else {
            absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        }
        String str2 = absolutePath + File.separator;
        if (str == null || str.isEmpty()) {
            return str2;
        }
        return str2 + str;
    }

    public static String r(String str, String str2) {
        StringBuilder sb2 = new StringBuilder();
        if (str == null || str.isEmpty() || str.charAt(0) != File.separatorChar) {
            if (Build.VERSION.SDK_INT >= 29) {
                sb2.append(File.separatorChar);
                sb2.append("sdcard");
            } else {
                sb2.append(Environment.getExternalStorageDirectory().getAbsolutePath());
            }
            sb2.append(File.separatorChar);
        }
        if (str != null && !str.isEmpty()) {
            sb2.append(str);
            char cCharAt = str.charAt(str.length() - 1);
            char c10 = File.separatorChar;
            if (cCharAt != c10) {
                sb2.append(c10);
            }
        }
        if (str2 != null && !str2.isEmpty()) {
            sb2.append(str2);
        }
        return sb2.toString();
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0049  */
    public static String s(Context context, Uri uri) {
        String string;
        try {
            String[] strArr = {"_data"};
            Cursor cursorQuery = context.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, strArr, "_id=?", new String[]{DocumentsContract.getDocumentId(uri).split(":")[1]}, null);
            if (cursorQuery != null) {
                try {
                    int columnIndexOrThrow = cursorQuery.getColumnIndexOrThrow(strArr[0]);
                    if (cursorQuery.moveToFirst()) {
                        string = cursorQuery.getString(columnIndexOrThrow);
                    } else {
                        string = "";
                    }
                } catch (Throwable th) {
                    try {
                        cursorQuery.close();
                        throw th;
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                        throw th;
                    }
                }
            } else {
                string = "";
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return string == null ? "" : string;
        } catch (Exception e10) {
            e10.printStackTrace();
            return "";
        }
    }

    public static String t(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int iLastIndexOf = str.lastIndexOf(46);
        if (iLastIndexOf < 0 || iLastIndexOf == str.length() - 1) {
            return null;
        }
        return str.substring(iLastIndexOf + 1);
    }

    public static long u(String str) {
        if (str == null || str.isEmpty()) {
            return 0L;
        }
        return new File(str).lastModified();
    }

    public static List v(String str) {
        ArrayList arrayList = new ArrayList();
        if (str != null && !str.isEmpty()) {
            File file = new File(str);
            if (file.exists() && !file.isDirectory()) {
                try {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    while (true) {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        if (!line.isEmpty()) {
                            arrayList.add(line);
                        }
                    }
                    bufferedReader.close();
                    inputStreamReader.close();
                    fileInputStream.close();
                } catch (IOException unused) {
                }
            }
        }
        return arrayList;
    }

    public static String w(String str) {
        int length;
        if (str == null || str.isEmpty()) {
            return null;
        }
        char c10 = File.separatorChar;
        int iLastIndexOf = str.lastIndexOf(c10);
        if (iLastIndexOf < 0) {
            return str;
        }
        if (iLastIndexOf == str.length() - 1) {
            iLastIndexOf = Math.max(0, str.lastIndexOf(c10, iLastIndexOf - 1));
            length = iLastIndexOf;
        } else {
            length = str.length();
        }
        return str.substring(iLastIndexOf + 1, length);
    }

    public static String x(Context context, String str) {
        File externalFilesDir = context.getExternalFilesDir(str);
        if (externalFilesDir == null) {
            externalFilesDir = new File(context.getFilesDir(), str);
        }
        if (externalFilesDir.exists() || externalFilesDir.mkdirs()) {
            return externalFilesDir.toString();
        }
        return null;
    }

    public static String y(Context context, String str, String str2) {
        File externalFilesDir = context.getExternalFilesDir(str);
        if (externalFilesDir == null) {
            externalFilesDir = new File(context.getFilesDir(), str);
        }
        if (externalFilesDir.exists() || externalFilesDir.mkdirs()) {
            return new File(externalFilesDir, str2).toString();
        }
        return null;
    }

    public static String z(Context context, String str) {
        return (str == null || str.isEmpty()) ? x(context, "filters") : y(context, "filters", str);
    }
}
