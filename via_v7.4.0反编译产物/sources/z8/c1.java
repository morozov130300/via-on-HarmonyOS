package z8;

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
import java.io.BufferedOutputStream;
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

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class c1 {
    public static String A(Context context, Uri uri) {
        if (uri == null) {
            return "";
        }
        if (!uri.toString().startsWith("file://")) {
            return DocumentsContract.isDocumentUri(context, uri) ? B(context, uri) : C(context, uri);
        }
        String string = uri.toString();
        return string.substring(string.indexOf("file://") + 7);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String B(Context context, Uri uri) {
        String string;
        try {
            String[] strArr = {"_data"};
            Cursor cursorQuery = context.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, strArr, "_id=?", new String[]{DocumentsContract.getDocumentId(uri).split(":")[1]}, null);
            if (cursorQuery != null) {
                try {
                    string = cursorQuery.moveToFirst() ? cursorQuery.getString(cursorQuery.getColumnIndexOrThrow(strArr[0])) : "";
                } finally {
                }
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

    /* JADX WARN: Removed duplicated region for block: B:26:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String C(Context context, Uri uri) {
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
                    if (string == null) {
                    }
                }
            }
        } catch (Exception e11) {
            exc = e11;
            string = "";
            exc.printStackTrace();
            if (string == null) {
            }
        }
        return string == null ? "" : string;
    }

    public static String D(Context context) {
        return v(context, "offline");
    }

    public static String E(Context context) {
        return v(context, "settings");
    }

    public static String F(Context context) {
        return v(context, "skins");
    }

    public static String G(Context context, String str) {
        return w(context, "skins", str);
    }

    public static String H(Context context) {
        return x(context, "subscribed.txt");
    }

    public static String I(Context context) {
        return v(context, "tabs");
    }

    public static String J(Context context, String str) {
        return w(context, "tabs", str);
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
                        g6.j.a(bufferedReader);
                        return sb2.toString().trim();
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        g6.j.a(bufferedReader);
                        throw th;
                    }
                }
                g6.j.a(bufferedReader2);
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
                            g6.j.a(bufferedReader2);
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
                        g6.j.a(bufferedReader);
                        return arrayList;
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        g6.j.a(bufferedReader);
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
        OutputStreamWriter outputStreamWriter;
        OutputStreamWriter outputStreamWriter2 = null;
        try {
            try {
                outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), m8.a.f8676a);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e10) {
            e = e10;
        }
        try {
            outputStreamWriter.write(str);
            try {
                outputStreamWriter.close();
                return true;
            } catch (Exception e11) {
                pc.a.b(e11);
                return true;
            }
        } catch (Exception e12) {
            e = e12;
            outputStreamWriter2 = outputStreamWriter;
            pc.a.b(e);
            if (outputStreamWriter2 == null) {
                return false;
            }
            try {
                outputStreamWriter2.close();
                return false;
            } catch (Exception e13) {
                pc.a.b(e13);
                return false;
            }
        } catch (Throwable th2) {
            th = th2;
            outputStreamWriter2 = outputStreamWriter;
            if (outputStreamWriter2 != null) {
                try {
                    outputStreamWriter2.close();
                } catch (Exception e14) {
                    pc.a.b(e14);
                }
            }
            throw th;
        }
    }

    public static boolean R(File file, List list) throws Throwable {
        OutputStreamWriter outputStreamWriter;
        OutputStreamWriter outputStreamWriter2 = null;
        try {
            try {
                outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), m8.a.f8676a);
            } catch (Exception e10) {
                e = e10;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (!str.isEmpty()) {
                    outputStreamWriter.write(str);
                    outputStreamWriter.write(10);
                }
            }
            g6.j.a(outputStreamWriter);
            return true;
        } catch (Exception e11) {
            e = e11;
            outputStreamWriter2 = outputStreamWriter;
            pc.a.b(e);
            g6.j.a(outputStreamWriter2);
            return false;
        } catch (Throwable th2) {
            th = th2;
            outputStreamWriter2 = outputStreamWriter;
            g6.j.a(outputStreamWriter2);
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0048, code lost:
    
        if (r4.delete() == false) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(File file, File file2) throws IOException {
        if (file != null && file.canRead() && file.exists() && file2 != null) {
            if (file2.exists()) {
                if (file2.canRead() && file2.canWrite()) {
                    if (file2.isDirectory()) {
                        File file3 = new File(file2, file.getName());
                        if (file3.exists() && !file3.delete()) {
                            return false;
                        }
                        file2 = file3;
                    }
                }
                return false;
            }
            try {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                try {
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int i10 = bufferedInputStream.read(bArr);
                            if (i10 <= 0) {
                                bufferedOutputStream.close();
                                bufferedInputStream.close();
                                return true;
                            }
                            bufferedOutputStream.write(bArr, 0, i10);
                            bufferedOutputStream.flush();
                        }
                    } finally {
                    }
                } finally {
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        return false;
    }

    public static String b(Context context, Uri uri, File file) throws IOException {
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
                } finally {
                }
            } catch (IOException e10) {
                pc.a.d(e10);
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

    public static File e(InputStream inputStream, File file) throws IOException {
        if (inputStream == null || !d(file.getParent()) || (file.exists() && !file.delete())) {
            return null;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[8192];
                while (true) {
                    int i10 = inputStream.read(bArr);
                    if (i10 == -1) {
                        fileOutputStream.flush();
                        try {
                            fileOutputStream.close();
                            return file;
                        } catch (IOException e10) {
                            e = e10;
                            pc.a.d(e);
                            return file;
                        }
                    }
                    fileOutputStream.write(bArr, 0, i10);
                }
            } finally {
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

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0035, code lost:
    
        if (r6.read() != (-1)) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0037, code lost:
    
        r3 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0039, code lost:
    
        r6.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003c, code lost:
    
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003f, code lost:
    
        return r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long i(File file, File file2) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        try {
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file2));
            long j10 = 1;
            while (true) {
                try {
                    int i10 = bufferedInputStream.read();
                    if (i10 == -1) {
                        break;
                    }
                    if (i10 != bufferedInputStream2.read()) {
                        bufferedInputStream2.close();
                        bufferedInputStream.close();
                        return j10;
                    }
                    j10++;
                } finally {
                }
            }
        } catch (Throwable th) {
            try {
                bufferedInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
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
        return v(context, "content");
    }

    public static String m(String str) {
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

    public static String n(String str) {
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
            pc.a.i(e10);
            return strReplaceAll;
        }
    }

    public static String o(Context context) {
        return x(context, "custom.txt");
    }

    public static String p(String str) {
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

    public static String q(String str, String str2) {
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

    public static String r(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int iLastIndexOf = str.lastIndexOf(46);
        if (iLastIndexOf < 0 || iLastIndexOf == str.length() - 1) {
            return null;
        }
        return str.substring(iLastIndexOf + 1);
    }

    public static long s(String str) {
        if (str == null || str.isEmpty()) {
            return 0L;
        }
        return new File(str).lastModified();
    }

    public static List t(String str) throws IOException {
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

    public static String u(String str) {
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

    public static String v(Context context, String str) {
        File externalFilesDir = context.getExternalFilesDir(str);
        if (externalFilesDir == null) {
            externalFilesDir = new File(context.getFilesDir(), str);
        }
        if (externalFilesDir.exists() || externalFilesDir.mkdirs()) {
            return externalFilesDir.toString();
        }
        return null;
    }

    public static String w(Context context, String str, String str2) {
        File externalFilesDir = context.getExternalFilesDir(str);
        if (externalFilesDir == null) {
            externalFilesDir = new File(context.getFilesDir(), str);
        }
        if (externalFilesDir.exists() || externalFilesDir.mkdirs()) {
            return new File(externalFilesDir, str2).toString();
        }
        return null;
    }

    public static String x(Context context, String str) {
        return (str == null || str.isEmpty()) ? v(context, "filters") : w(context, "filters", str);
    }

    public static String y(Context context, String str) {
        if (!URLUtil.isContentUrl(str)) {
            return null;
        }
        Uri uri = Uri.parse(str);
        String strK = b1.k(context, uri);
        if (strK == null || strK.isEmpty()) {
            strK = UUID.randomUUID() + ".html";
        }
        String strZ = z(context);
        if (strZ == null) {
            return null;
        }
        return b(context, uri, new File(strZ, strK));
    }

    public static String z(Context context) {
        return v(context, "opened");
    }
}
