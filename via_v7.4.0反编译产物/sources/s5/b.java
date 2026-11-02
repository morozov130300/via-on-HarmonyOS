package s5;

import android.util.Base64;
import android.util.Log;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Locale;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final String f11852a = "s5.b";

    public static void a(Closeable closeable) throws IOException {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException e10) {
            d.f(f11852a, e10.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e8 A[PHI: r1 r2 r3
  0x00e8: PHI (r1v8 java.net.HttpURLConnection) = 
  (r1v5 java.net.HttpURLConnection)
  (r1v6 java.net.HttpURLConnection)
  (r1v7 java.net.HttpURLConnection)
  (r1v10 java.net.HttpURLConnection)
 binds: [B:78:0x00e6, B:85:0x00ff, B:90:0x0115, B:88:0x010b] A[DONT_GENERATE, DONT_INLINE]
  0x00e8: PHI (r2v11 java.lang.Object) = (r2v39 java.lang.Object), (r2v40 java.lang.Object), (r2v41 java.lang.Object), (r2v42 java.lang.Object) binds: [B:78:0x00e6, B:85:0x00ff, B:90:0x0115, B:88:0x010b] A[DONT_GENERATE, DONT_INLINE]
  0x00e8: PHI (r3v10 java.io.FileOutputStream) = 
  (r3v7 java.io.FileOutputStream)
  (r3v8 java.io.FileOutputStream)
  (r3v9 java.io.FileOutputStream)
  (r3v12 java.io.FileOutputStream)
 binds: [B:78:0x00e6, B:85:0x00ff, B:90:0x0115, B:88:0x010b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v12, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v30, types: [java.io.BufferedInputStream, java.io.Closeable, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v32, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v34 */
    /* JADX WARN: Type inference failed for: r2v35 */
    /* JADX WARN: Type inference failed for: r2v36 */
    /* JADX WARN: Type inference failed for: r2v37 */
    /* JADX WARN: Type inference failed for: r2v38 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.io.Closeable] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean b(String str, File file) throws Throwable {
        ?? bufferedInputStream;
        FileOutputStream fileOutputStream;
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        if (str == null || str.isEmpty() || file == null) {
            return false;
        }
        File parentFile = file.getParentFile();
        if (parentFile != null && (bufferedInputStream = parentFile.exists()) == 0 && !parentFile.mkdirs()) {
            return false;
        }
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
                try {
                    httpURLConnection2.setRequestMethod("GET");
                    httpURLConnection2.setRequestProperty("User-Agent", "Mozilla/5.0 (Linux; Android 10; Mobile) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Mobile Safari/537.36");
                    httpURLConnection2.setConnectTimeout(10000);
                    httpURLConnection2.setReadTimeout(30000);
                    int responseCode = httpURLConnection2.getResponseCode();
                    if (responseCode != 200) {
                        d.a(f11852a, "download failed, error code: " + responseCode);
                        httpURLConnection2.disconnect();
                        a(null);
                        a(null);
                        return false;
                    }
                    bufferedInputStream = new BufferedInputStream(httpURLConnection2.getInputStream());
                    try {
                        fileOutputStream = new FileOutputStream(file);
                    } catch (FileNotFoundException e10) {
                        e = e10;
                        fileOutputStream = null;
                    } catch (MalformedURLException e11) {
                        e = e11;
                        fileOutputStream = null;
                    } catch (IOException e12) {
                        e = e12;
                        fileOutputStream = null;
                    } catch (Exception e13) {
                        e = e13;
                        fileOutputStream = null;
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = null;
                    }
                    try {
                        byte[] bArr = new byte[8192];
                        while (true) {
                            int i10 = bufferedInputStream.read(bArr);
                            if (i10 == -1) {
                                httpURLConnection2.disconnect();
                                a(bufferedInputStream);
                                a(fileOutputStream);
                                return true;
                            }
                            fileOutputStream.write(bArr, 0, i10);
                        }
                    } catch (FileNotFoundException e14) {
                        e = e14;
                        httpURLConnection = httpURLConnection2;
                        obj4 = bufferedInputStream;
                        d.c(f11852a, Log.getStackTraceString(e));
                        bufferedInputStream = obj4;
                        if (httpURLConnection != null) {
                            obj5 = obj4;
                            httpURLConnection.disconnect();
                            bufferedInputStream = obj5;
                        }
                        a(bufferedInputStream);
                        a(fileOutputStream);
                        return false;
                    } catch (MalformedURLException e15) {
                        e = e15;
                        httpURLConnection = httpURLConnection2;
                        obj3 = bufferedInputStream;
                        d.c(f11852a, Log.getStackTraceString(e));
                        bufferedInputStream = obj3;
                        obj5 = obj3;
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                            bufferedInputStream = obj5;
                        }
                        a(bufferedInputStream);
                        a(fileOutputStream);
                        return false;
                    } catch (IOException e16) {
                        e = e16;
                        httpURLConnection = httpURLConnection2;
                        obj2 = bufferedInputStream;
                        d.c(f11852a, Log.getStackTraceString(e));
                        bufferedInputStream = obj2;
                        if (httpURLConnection != null) {
                            obj5 = obj2;
                            httpURLConnection.disconnect();
                            bufferedInputStream = obj5;
                        }
                        a(bufferedInputStream);
                        a(fileOutputStream);
                        return false;
                    } catch (Exception e17) {
                        e = e17;
                        httpURLConnection = httpURLConnection2;
                        obj = bufferedInputStream;
                        d.c(f11852a, Log.getStackTraceString(e));
                        bufferedInputStream = obj;
                        obj5 = obj;
                        if (httpURLConnection != null) {
                        }
                        a(bufferedInputStream);
                        a(fileOutputStream);
                        return false;
                    } catch (Throwable th2) {
                        th = th2;
                        httpURLConnection = httpURLConnection2;
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        a(bufferedInputStream);
                        a(fileOutputStream);
                        throw th;
                    }
                } catch (FileNotFoundException e18) {
                    e = e18;
                    bufferedInputStream = 0;
                    fileOutputStream = null;
                } catch (MalformedURLException e19) {
                    e = e19;
                    bufferedInputStream = 0;
                    fileOutputStream = null;
                } catch (IOException e20) {
                    e = e20;
                    bufferedInputStream = 0;
                    fileOutputStream = null;
                } catch (Exception e21) {
                    e = e21;
                    bufferedInputStream = 0;
                    fileOutputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    bufferedInputStream = 0;
                    fileOutputStream = null;
                }
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (FileNotFoundException e22) {
            e = e22;
            obj4 = null;
            fileOutputStream = null;
        } catch (MalformedURLException e23) {
            e = e23;
            obj3 = null;
            fileOutputStream = null;
        } catch (IOException e24) {
            e = e24;
            obj2 = null;
            fileOutputStream = null;
        } catch (Exception e25) {
            e = e25;
            obj = null;
            fileOutputStream = null;
        } catch (Throwable th5) {
            th = th5;
            bufferedInputStream = 0;
            fileOutputStream = null;
        }
    }

    public static boolean c(String str, File file) {
        if (str == null || str.isEmpty() || file == null) {
            return false;
        }
        if (b(str, file)) {
            return true;
        }
        String strF = f(str);
        return strF == null ? b(str, file) : b(strF, file);
    }

    public static String d(String str) throws Throwable {
        String strE = e(str);
        if (strE != null && !strE.isEmpty()) {
            return strE;
        }
        String strF = f(str);
        if (strF != null) {
            return e(strF);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 7, insn: 0x0041: MOVE (r5 I:??[OBJECT, ARRAY]) = (r7 I:??[OBJECT, ARRAY]), block:B:12:0x0041 */
    /* JADX WARN: Removed duplicated region for block: B:118:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00ca A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x00ed A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v10, types: [java.net.HttpURLConnection, java.net.URLConnection] */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r9v6, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r9v7, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r9v8, types: [java.net.HttpURLConnection] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String e(String str) throws Throwable {
        f fVar;
        f fVar2;
        InputStream errorStream;
        StringBuilder sb2 = new StringBuilder();
        char[] cArr = new char[4096];
        f fVar3 = null;
        try {
            try {
                str = (HttpURLConnection) new URL(str).openConnection();
            } catch (Throwable th) {
                th = th;
                fVar3 = fVar2;
            }
        } catch (MalformedURLException e10) {
            e = e10;
            str = 0;
            fVar = null;
        } catch (IOException e11) {
            e = e11;
            str = 0;
            fVar = null;
        } catch (Exception e12) {
            e = e12;
            str = 0;
            fVar = null;
        } catch (Throwable th2) {
            th = th2;
            str = 0;
        }
        try {
            str.setReadTimeout(5000);
            str.setRequestMethod("GET");
            str.setUseCaches(false);
            str.connect();
            fVar = new f(str.getInputStream(), str.getContentEncoding());
            while (true) {
                try {
                    int i10 = fVar.read(cArr, 0, 4096);
                    if (i10 == -1) {
                        try {
                            break;
                        } catch (Exception unused) {
                        }
                    } else if (i10 > 0) {
                        sb2.append(cArr, 0, i10);
                    }
                } catch (MalformedURLException e13) {
                    e = e13;
                    d.c(f11852a, Log.getStackTraceString(e));
                    if (fVar != null) {
                        try {
                            fVar.close();
                        } catch (Exception unused2) {
                        }
                    }
                    if (str != 0) {
                        str.disconnect();
                    }
                    return null;
                } catch (IOException e14) {
                    e = e14;
                    d.c(f11852a, Log.getStackTraceString(e));
                    if (str != 0) {
                        try {
                            errorStream = str.getErrorStream();
                        } catch (Exception unused3) {
                            if (fVar != null) {
                                try {
                                    fVar.close();
                                } catch (Exception unused4) {
                                }
                            }
                            if (str != 0) {
                                str.disconnect();
                            }
                            return null;
                        }
                    } else {
                        errorStream = null;
                    }
                    if (errorStream != null) {
                        f fVar4 = new f(errorStream, null);
                        try {
                            StringBuilder sb3 = new StringBuilder();
                            while (true) {
                                int i11 = fVar4.read(cArr, 0, 4096);
                                if (i11 == -1) {
                                    break;
                                }
                                if (i11 > 0) {
                                    sb3.append(cArr, 0, i11);
                                }
                            }
                            fVar4.close();
                            d.c(f11852a, sb3.toString());
                        } catch (Exception unused5) {
                        } catch (Throwable th3) {
                            th = th3;
                            fVar3 = fVar4;
                            if (fVar3 != null) {
                                try {
                                    fVar3.close();
                                } catch (Exception unused6) {
                                }
                            }
                            if (str != 0) {
                                throw th;
                            }
                            str.disconnect();
                            throw th;
                        }
                        fVar = fVar4;
                    }
                    if (fVar != null) {
                    }
                    if (str != 0) {
                    }
                    return null;
                } catch (Exception e15) {
                    e = e15;
                    d.c(f11852a, Log.getStackTraceString(e));
                    if (fVar != null) {
                        try {
                            fVar.close();
                        } catch (Exception unused7) {
                        }
                    }
                    if (str != 0) {
                        str.disconnect();
                    }
                    return null;
                }
            }
            fVar.close();
            str.disconnect();
            return sb2.toString();
        } catch (MalformedURLException e16) {
            e = e16;
            fVar = null;
        } catch (IOException e17) {
            e = e17;
            fVar = null;
        } catch (Exception e18) {
            e = e18;
            fVar = null;
        } catch (Throwable th4) {
            th = th4;
            if (fVar3 != null) {
            }
            if (str != 0) {
            }
        }
    }

    public static String f(String str) {
        if (str != null && !str.isEmpty() && !str.startsWith("https://fastly.jsdelivr.net/")) {
            if (str.startsWith("https://cdn.jsdelivr.net/") && str.length() > 25) {
                return "https://fastly.jsdelivr.net/" + str.substring(25);
            }
            if (str.startsWith("https://raw.githubusercontent.com/") && str.length() > 34) {
                int iIndexOf = str.indexOf(47, 34);
                if (iIndexOf >= 0) {
                    iIndexOf = str.indexOf(47, iIndexOf + 1);
                }
                if (iIndexOf <= 0) {
                    return null;
                }
                return "https://fastly.jsdelivr.net/gh/" + str.substring(34, iIndexOf) + '@' + str.substring(iIndexOf + 1);
            }
            if (str.startsWith("https://github.com/") && str.length() > 19) {
                int iIndexOf2 = str.indexOf("/blob/", 19);
                if (iIndexOf2 < 0 || iIndexOf2 >= str.length() - 6) {
                    return null;
                }
                return "https://fastly.jsdelivr.net/gh/" + str.substring(19, iIndexOf2) + '@' + str.substring(iIndexOf2 + 6);
            }
            if (str.startsWith("https://unpkg.com/") && str.length() > 18) {
                return "https://fastly.jsdelivr.net/npm/" + str.substring(18);
            }
        }
        return null;
    }

    public static byte[] g(String str) throws UnsupportedEncodingException {
        if (str == null || str.length() <= 5 || !"data".equals(str.substring(0, 4).toLowerCase(Locale.ROOT))) {
            return new byte[0];
        }
        int iIndexOf = str.indexOf(44);
        if (iIndexOf < 0) {
            return new byte[0];
        }
        boolean z10 = str.lastIndexOf(";base64", iIndexOf) > 0;
        try {
            String strDecode = URLDecoder.decode(str.substring(iIndexOf + 1), "UTF-8");
            return !z10 ? strDecode.getBytes("UTF-8") : Base64.decode(strDecode.getBytes("UTF-8"), 0);
        } catch (Exception e10) {
            e10.printStackTrace();
            return new byte[0];
        }
    }

    public static String h(String str) throws UnsupportedEncodingException {
        int iIndexOf;
        if (str == null || str.length() <= 5 || !"data".equals(str.substring(0, 4).toLowerCase(Locale.ROOT)) || (iIndexOf = str.indexOf(44)) < 0) {
            return null;
        }
        boolean z10 = str.lastIndexOf(";base64", iIndexOf) > 0;
        try {
            String strDecode = URLDecoder.decode(str.substring(iIndexOf + 1), "UTF-8");
            return !z10 ? strDecode : new String(Base64.decode(strDecode.getBytes("UTF-8"), 0), "UTF-8");
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static String i(File file) throws IOException {
        if (file == null || !file.exists()) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                sb2.append(line);
                sb2.append("\n");
            }
            bufferedReader.close();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return sb2.toString();
    }

    public static byte[] j(File file) throws IOException {
        if (file == null || !file.exists()) {
            return null;
        }
        byte[] bArr = new byte[4096];
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int i10 = bufferedInputStream.read(bArr, 0, 4096);
                if (i10 == -1) {
                    bufferedInputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
                if (i10 > 0) {
                    byteArrayOutputStream.write(bArr, 0, i10);
                }
            }
        } catch (Exception e10) {
            e10.printStackTrace();
            return new byte[0];
        }
    }

    public static String k(String str, String str2) {
        URL url;
        if (str.length() > 5 && "data:".equalsIgnoreCase(str.substring(0, 5))) {
            return str;
        }
        if (str2 == null) {
            url = null;
        } else {
            try {
                url = new URL(str2);
            } catch (Exception unused) {
                return null;
            }
        }
        return new URL(url, str).toURI().toString();
    }
}
