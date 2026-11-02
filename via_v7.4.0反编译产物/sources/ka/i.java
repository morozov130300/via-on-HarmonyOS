package ka;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class i {
    public static List a(List... listArr) {
        List list = null;
        for (List list2 : listArr) {
            if (list2 != null && list2.size() != 0) {
                if (list == null) {
                    list = list2;
                } else {
                    list.addAll(list2);
                }
            }
        }
        return list;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0072 A[PHI: r1 r4
  0x0072: PHI (r1v6 java.lang.StringBuilder) = 
  (r1v3 java.lang.StringBuilder)
  (r1v4 java.lang.StringBuilder)
  (r1v14 java.lang.StringBuilder)
  (r1v15 java.lang.StringBuilder)
 binds: [B:37:0x0083, B:42:0x008c, B:29:0x0071, B:24:0x0064] A[DONT_GENERATE, DONT_INLINE]
  0x0072: PHI (r4v5 java.net.HttpURLConnection) = 
  (r4v3 java.net.HttpURLConnection)
  (r4v4 java.net.HttpURLConnection)
  (r4v7 java.net.HttpURLConnection)
  (r4v7 java.net.HttpURLConnection)
 binds: [B:37:0x0083, B:42:0x008c, B:29:0x0071, B:24:0x0064] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String b(String str, String str2) throws Throwable {
        HttpURLConnection httpURLConnection;
        StringBuilder sb2;
        HttpURLConnection httpURLConnection2 = null;
        if (str == null || str.isEmpty()) {
            return null;
        }
        if (str2 == null || str2.isEmpty()) {
            str2 = "UTF-8";
        }
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                try {
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0");
                    httpURLConnection.setConnectTimeout(3000);
                    httpURLConnection.connect();
                    if (httpURLConnection.getResponseCode() == 200) {
                        sb2 = new StringBuilder();
                        try {
                            InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream(), str2);
                            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                            while (true) {
                                String line = bufferedReader.readLine();
                                if (line == null) {
                                    break;
                                }
                                sb2.append(line.trim());
                            }
                            bufferedReader.close();
                            inputStreamReader.close();
                        } catch (InterruptedIOException unused) {
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            if (sb2 != null) {
                            }
                        } catch (Exception e10) {
                            e = e10;
                            pc.a.b(e);
                            if (httpURLConnection != null) {
                            }
                            if (sb2 != null) {
                            }
                        }
                    } else {
                        sb2 = null;
                    }
                } catch (Throwable th) {
                    th = th;
                    httpURLConnection2 = httpURLConnection;
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    throw th;
                }
            } catch (InterruptedIOException unused2) {
                sb2 = null;
            } catch (Exception e11) {
                e = e11;
                sb2 = null;
            }
        } catch (InterruptedIOException unused3) {
            httpURLConnection = null;
            sb2 = null;
        } catch (Exception e12) {
            e = e12;
            httpURLConnection = null;
            sb2 = null;
        } catch (Throwable th2) {
            th = th2;
        }
        httpURLConnection.disconnect();
        if (sb2 != null) {
            return sb2.toString();
        }
        return null;
    }
}
