package ua;

import android.util.Base64;
import c6.a2;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    /* JADX WARN: Code duplicated, block: B:51:0x00ae  */
    public static boolean a(String str, File file) throws Throwable {
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
                        tc.a.a("download failed, error code: " + responseCode, new Object[0]);
                        httpURLConnection2.disconnect();
                        return false;
                    }
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnection2.getInputStream());
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        try {
                            byte[] bArr = new byte[8192];
                            while (true) {
                                int i10 = bufferedInputStream.read(bArr);
                                if (i10 == -1) {
                                    fileOutputStream.getFD().sync();
                                    fileOutputStream.close();
                                    bufferedInputStream.close();
                                    httpURLConnection2.disconnect();
                                    return true;
                                }
                                fileOutputStream.write(bArr, 0, i10);
                                try {
                                    bufferedInputStream.close();
                                } catch (Throwable th) {
                                    th.addSuppressed(th);
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable th3) {
                                th2.addSuppressed(th3);
                            }
                            throw th2;
                        }
                    } catch (Throwable th4) {
                        bufferedInputStream.close();
                        throw th4;
                    }
                } catch (Exception e10) {
                    e = e10;
                    httpURLConnection = httpURLConnection2;
                    try {
                        tc.a.d("Userscript resource download failed (%s)", e.getClass().getSimpleName());
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        return false;
                    } catch (Throwable th5) {
                        th = th5;
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    httpURLConnection = httpURLConnection2;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th;
                }
            } catch (Throwable th7) {
                th = th7;
            }
        } catch (Exception e11) {
            e = e11;
        }
    }

    public static boolean b(String str, File file) {
        if (str != null && !str.isEmpty() && file != null) {
            d dVarE = d.e(str);
            if (file.length() > 0 && file.lastModified() > System.currentTimeMillis() - TimeUnit.DAYS.toMillis(15L) && (dVarE == null || dVarE.a(file))) {
                return true;
            }
            File parentFile = file.getAbsoluteFile().getParentFile();
            if (!parentFile.isDirectory() && !parentFile.mkdirs() && !parentFile.isDirectory()) {
                return false;
            }
            try {
                File fileCreateTempFile = File.createTempFile(file.getName() + ".", ".tmp", parentFile);
                for (int i10 = 0; i10 < 3; i10++) {
                    if (i10 > 0) {
                        try {
                            try {
                                Thread.sleep(1000L);
                                String strB = a2.f1958a.b(str);
                                if (strB != null) {
                                    str = strB;
                                }
                            } catch (InterruptedException unused) {
                                Thread.currentThread().interrupt();
                                if (fileCreateTempFile.exists() && !fileCreateTempFile.delete()) {
                                    tc.a.i("Cannot remove temporary userscript resource", new Object[0]);
                                }
                                return false;
                            }
                        } catch (Throwable th) {
                            if (fileCreateTempFile.exists() && !fileCreateTempFile.delete()) {
                                tc.a.i("Cannot remove temporary userscript resource", new Object[0]);
                            }
                            throw th;
                        }
                    }
                    if (a(str, fileCreateTempFile) && (dVarE == null || dVarE.a(fileCreateTempFile))) {
                        boolean zRenameTo = fileCreateTempFile.renameTo(file);
                        if (fileCreateTempFile.exists() && !fileCreateTempFile.delete()) {
                            tc.a.i("Cannot remove temporary userscript resource", new Object[0]);
                        }
                        return zRenameTo;
                    }
                }
                if (fileCreateTempFile.exists() && !fileCreateTempFile.delete()) {
                    tc.a.i("Cannot remove temporary userscript resource", new Object[0]);
                }
                return false;
            } catch (IOException e10) {
                tc.a.i("Cannot create userscript resource file (%s)", e10.getClass().getSimpleName());
            }
        }
        return false;
    }

    public static String c(String str) throws Throwable {
        String strD = d(str);
        if (strD != null && !strD.isEmpty()) {
            return strD;
        }
        String strB = a2.f1958a.b(str);
        if (strB != null) {
            return d(strB);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 6, insn: 0x0041: MOVE (r4 I:??[OBJECT, ARRAY]) = (r6 I:??[OBJECT, ARRAY]) (LINE:66), block:B:12:0x0041 */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r8v4, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r8v6, types: [java.net.HttpURLConnection, java.net.URLConnection] */
    public static String d(String str) throws Throwable {
        e eVar;
        Reader reader;
        StringBuilder sb2 = new StringBuilder();
        char[] cArr = new char[4096];
        Reader reader2 = null;
        try {
            try {
                str = (HttpURLConnection) new URL(str).openConnection();
                try {
                    str.setReadTimeout(5000);
                    str.setRequestMethod("GET");
                    str.setUseCaches(false);
                    str.connect();
                    eVar = new e(str.getInputStream(), str.getContentEncoding());
                    while (true) {
                        try {
                            int i10 = eVar.read(cArr, 0, 4096);
                            if (i10 == -1) {
                                try {
                                    break;
                                } catch (Exception unused) {
                                }
                            } else if (i10 > 0) {
                                sb2.append(cArr, 0, i10);
                            }
                        } catch (Exception e10) {
                            e = e10;
                            tc.a.d("Userscript download failed (%s)", e.getClass().getSimpleName());
                            if (eVar != null) {
                                try {
                                    eVar.close();
                                } catch (Exception unused2) {
                                }
                            }
                            if (str != 0) {
                                str.disconnect();
                            }
                            return null;
                        }
                    }
                    eVar.close();
                    str.disconnect();
                    return sb2.toString();
                } catch (Exception e11) {
                    e = e11;
                    eVar = null;
                } catch (Throwable th) {
                    th = th;
                    if (reader2 != null) {
                        try {
                            reader2.close();
                        } catch (Exception unused3) {
                        }
                    }
                    if (str == 0) {
                        throw th;
                    }
                    str.disconnect();
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                reader2 = reader;
            }
        } catch (Exception e12) {
            e = e12;
            str = 0;
            eVar = null;
        } catch (Throwable th3) {
            th = th3;
            str = 0;
        }
    }

    public static byte[] e(String str) {
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

    public static String f(String str) {
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

    public static String g(File file) {
        if (file != null && file.exists()) {
            StringBuilder sb2 = new StringBuilder();
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                while (true) {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            bufferedReader.close();
                            return sb2.toString();
                        }
                        sb2.append(line);
                        sb2.append("\n");
                    } catch (Throwable th) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                    e.printStackTrace();
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        return null;
    }

    public static byte[] h(File file) {
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
}
