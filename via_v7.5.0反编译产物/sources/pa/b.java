package pa;

import android.os.Build;
import android.util.Base64;
import android.webkit.WebSettings;
import android.webkit.WebView;
import c6.b2;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import oa.k1;
import org.json.JSONException;
import org.json.JSONObject;
import ua.e;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JSONObject f11599a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f11600b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public JSONObject f11601c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f11602d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f11603e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f11604f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f11605g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f11606h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f11607i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f11608j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f11609k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f11610l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f11611m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f11612n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f11613o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public JSONObject f11614p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f11615q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f11616r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f11617s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f11618t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f11619u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f11620v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final WebView f11621w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final k1.a f11622x;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends Thread {
        public a() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            b.this.f();
        }
    }

    /* JADX INFO: renamed from: pa.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class RunnableC0112b implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ WeakReference f11624c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f11625e;

        public RunnableC0112b(WeakReference weakReference, String str) {
            this.f11624c = weakReference;
            this.f11625e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            WebView webView = (WebView) this.f11624c.get();
            if (webView == null) {
                return;
            }
            if (b.this.f11622x != null) {
                b.this.f11622x.a(this.f11625e);
            } else {
                webView.evaluateJavascript(this.f11625e, null);
            }
        }
    }

    public b(WebView webView, String str, k1.a aVar) {
        this.f11621w = webView;
        this.f11622x = aVar;
        this.f11619u = false;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f11602d = jSONObject.optString("method", "GET").toUpperCase(Locale.ROOT);
            this.f11615q = jSONObject.getString("url");
            this.f11619u = true;
            this.f11599a = jSONObject.optJSONObject("context");
            this.f11600b = jSONObject.optString("data");
            this.f11601c = jSONObject.optJSONObject("headers");
            this.f11603e = jSONObject.optString("responseType");
            this.f11604f = jSONObject.optString("onerror");
            this.f11605g = jSONObject.optString("onload");
            this.f11606h = jSONObject.optString("onloadstart");
            this.f11607i = jSONObject.optString("onprogress");
            this.f11608j = jSONObject.optString("onreadystatechange");
            this.f11609k = jSONObject.optString("ontimeout");
            this.f11610l = jSONObject.optString("overrideMimeType");
            this.f11612n = jSONObject.optBoolean("synchronous");
            this.f11613o = jSONObject.optInt("timeout");
            this.f11614p = jSONObject.optJSONObject("upload");
            this.f11616r = jSONObject.optString("user");
            this.f11611m = jSONObject.optString("password");
            this.f11617s = jSONObject.optString("cookie");
            this.f11618t = jSONObject.optBoolean("anonymous", false);
            if (webView == null) {
                this.f11620v = null;
            } else if (Build.VERSION.SDK_INT > 19) {
                this.f11620v = WebSettings.getDefaultUserAgent(webView.getContext());
            } else {
                this.f11620v = webView.getSettings().getUserAgentString();
            }
        } catch (JSONException unused) {
            tc.a.a("Invalid GM XHR request JSON", new Object[0]);
        }
    }

    public c c() {
        if (this.f11619u) {
            return (this.f11612n && this.f11622x == null) ? f() : e();
        }
        return null;
    }

    public final void d(String str, c cVar, boolean z10) {
        String[] strArr = z10 ? new String[]{this.f11608j, str} : new String[]{str};
        int i10 = 0;
        for (String str2 : strArr) {
            if (str2 != null && !str2.isEmpty()) {
                i10++;
            }
        }
        if (i10 == 0) {
            return;
        }
        if (cVar != null) {
            String str3 = this.f11607i;
            cVar.d(str3 != null && str3.equals(str));
        }
        p(b2.f1963a.l(strArr, cVar == null ? null : cVar.o()));
    }

    public final c e() {
        c cVar = new c(this.f11599a);
        new a().start();
        return cVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final c f() {
        boolean z10;
        c cVar;
        c cVar2;
        String str;
        String str2;
        boolean z11;
        String contentType;
        String upperCase;
        int iIndexOf;
        String strEncodeToString;
        Object obj;
        String str3;
        String str4;
        c cVar3 = new c(this.f11599a);
        try {
            URL url = new URL(this.f11615q);
            tc.a.a("request: " + this.f11615q, new Object[0]);
            byte[] bArrN = n();
            try {
                try {
                    try {
                        cVar3.f(1);
                        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                        httpURLConnection.setRequestMethod(this.f11602d);
                        i(cVar3);
                        if (this.f11600b != null && bArrN != null) {
                            httpURLConnection.setDoOutput(true);
                            httpURLConnection.setDoInput(true);
                            httpURLConnection.setRequestProperty("Content-Length", String.valueOf(bArrN.length));
                            httpURLConnection.setRequestProperty("Content-Type", this.f11600b.indexOf(61) > 0 ? "application/x-www-form-urlencoded;charset=UTF-8" : "text/plain;charset=UTF-8");
                        }
                        String str5 = this.f11616r;
                        int i10 = 2;
                        if (str5 != null && !str5.isEmpty() && (str4 = this.f11611m) != null && !str4.isEmpty()) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Basic ");
                            sb2.append(Base64.encodeToString((this.f11616r + ":" + this.f11611m).getBytes("UTF-8"), 2));
                            httpURLConnection.setRequestProperty("Authorization", sb2.toString());
                        }
                        Map mapO = o();
                        if (mapO != null) {
                            str = null;
                            str2 = null;
                            for (Map.Entry entry : mapO.entrySet()) {
                                cVar = null;
                                try {
                                    if ("cookie".equalsIgnoreCase((String) entry.getKey())) {
                                        str2 = (String) entry.getValue();
                                    } else if ("user-agent".equalsIgnoreCase((String) entry.getKey())) {
                                        str = (String) entry.getValue();
                                    } else {
                                        httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                                    }
                                } catch (UnsupportedEncodingException unused) {
                                    tc.a.a("Unable to get UTF-8 bytes for HTTP Basic Auth username/password", new Object[0]);
                                    return cVar;
                                }
                            }
                            cVar2 = null;
                        } else {
                            cVar2 = null;
                            str = null;
                            str2 = null;
                        }
                        if (str != null || ((str3 = this.f11620v) != null && !str3.isEmpty())) {
                            if (str == null) {
                                str = this.f11620v;
                            }
                            httpURLConnection.setRequestProperty("User-Agent", str);
                        }
                        if (!this.f11618t) {
                            StringBuilder sb3 = new StringBuilder();
                            if (str2 != null && !str2.isEmpty()) {
                                if (sb3.length() > 0) {
                                    sb3.append(';');
                                }
                                sb3.append(str2);
                            }
                            String str6 = this.f11617s;
                            if (str6 != null && !str6.isEmpty()) {
                                if (sb3.length() > 0) {
                                    sb3.append(';');
                                }
                                sb3.append(this.f11617s);
                            }
                            if (sb3.length() > 0) {
                                httpURLConnection.setRequestProperty("Cookie", sb3.toString());
                            }
                        }
                        if (!this.f11610l.isEmpty()) {
                            httpURLConnection.setRequestProperty("Content-Type", this.f11610l);
                        }
                        httpURLConnection.setConnectTimeout(this.f11613o);
                        httpURLConnection.setReadTimeout(this.f11613o);
                        httpURLConnection.connect();
                        if (bArrN != null) {
                            try {
                                OutputStream outputStream = httpURLConnection.getOutputStream();
                                outputStream.write(bArrN);
                                outputStream.flush();
                                outputStream.close();
                                cVar3.b(true);
                                cVar3.m(bArrN.length);
                                cVar3.c(bArrN.length);
                                cVar3.e(true);
                                m(cVar3);
                                cVar3.e(false);
                            } catch (IOException e10) {
                                e = e10;
                                z10 = true;
                                tc.a.a("GM XHR transport failed (%s)", e.getClass().getSimpleName());
                                if (!z10) {
                                    cVar3.f(4);
                                    g(cVar3);
                                }
                                return cVar3;
                            }
                        }
                        int responseCode = httpURLConnection.getResponseCode();
                        cVar3.k(responseCode);
                        cVar3.l(httpURLConnection.getResponseMessage());
                        cVar3.a(httpURLConnection.getURL().toString());
                        cVar3.f(2);
                        k(cVar3);
                        if (responseCode >= 200 && responseCode < 300) {
                            StringBuilder sb4 = new StringBuilder();
                            for (Map.Entry<String, List<String>> entry2 : httpURLConnection.getHeaderFields().entrySet()) {
                                if (entry2.getKey() != null && !entry2.getKey().isEmpty()) {
                                    sb4.append(entry2.getKey().toLowerCase(Locale.ROOT));
                                    sb4.append(": ");
                                    if (entry2.getValue() != null && !entry2.getValue().isEmpty()) {
                                        if (entry2.getValue().size() == 1) {
                                            sb4.append(entry2.getValue().get(0));
                                        } else {
                                            int size = entry2.getValue().size();
                                            for (int i11 = 0; i11 < size; i11++) {
                                                sb4.append(entry2.getValue().get(i11));
                                                if (i11 != size - 1) {
                                                    sb4.append("; ");
                                                }
                                            }
                                        }
                                    }
                                    sb4.append("\r\n");
                                }
                            }
                            cVar3.h(sb4.toString());
                            int contentLength = httpURLConnection.getContentLength();
                            cVar3.b(contentLength > 0);
                            cVar3.m(contentLength > 0 ? contentLength : -1);
                            cVar3.f(3);
                            k(cVar3);
                            if (!"HEAD".equalsIgnoreCase(this.f11602d)) {
                                InputStream inputStream = httpURLConnection.getInputStream();
                                StringBuilder sb5 = new StringBuilder();
                                boolean z12 = "blob".equals(this.f11603e) || "stream".equals(this.f11603e) || "arraybuffer".equals(this.f11603e);
                                long j10 = 0;
                                if (z12) {
                                    byte[] bArr = new byte[6144];
                                    byte[] bArrCopyOf = new byte[0];
                                    BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                                    sb5.append("data:");
                                    String contentType2 = httpURLConnection.getContentType();
                                    int iIndexOf2 = contentType2 == null ? -1 : contentType2.indexOf(59);
                                    if (iIndexOf2 > 0) {
                                        contentType2 = contentType2.substring(0, iIndexOf2);
                                    }
                                    if (contentType2 == null) {
                                        contentType2 = "text/plain";
                                    }
                                    sb5.append(contentType2);
                                    sb5.append(";base64,");
                                    String str7 = cVar2;
                                    int i12 = 0;
                                    while (true) {
                                        int i13 = bufferedInputStream.read(bArr, 0, 6144);
                                        if (i13 <= 0) {
                                            z11 = false;
                                            break;
                                        }
                                        if (i12 >= 8388608) {
                                            z11 = true;
                                            break;
                                        }
                                        if (bArrCopyOf.length == 0) {
                                            strEncodeToString = Base64.encodeToString(bArr, 0, i13, i10);
                                        } else {
                                            bArrCopyOf = Arrays.copyOf(bArrCopyOf, bArrCopyOf.length + i13);
                                            System.arraycopy(bArr, 0, bArrCopyOf, bArrCopyOf.length - i13, i13);
                                            strEncodeToString = Base64.encodeToString(bArrCopyOf, 0, bArrCopyOf.length, i10);
                                        }
                                        if (strEncodeToString.indexOf(61) < 0) {
                                            if (bArrCopyOf.length > 0) {
                                                bArrCopyOf = new byte[0];
                                            }
                                            sb5.append(strEncodeToString);
                                            obj = cVar2;
                                        } else {
                                            obj = strEncodeToString;
                                            if (bArrCopyOf.length == 0) {
                                                bArrCopyOf = Arrays.copyOf(bArr, i13);
                                                obj = strEncodeToString;
                                            }
                                        }
                                        i12 += i13;
                                        if (i12 > 0 && contentLength > 0) {
                                            cVar3.c(i12);
                                            long j11 = i12;
                                            if (j11 - j10 > 32768) {
                                                j(cVar3);
                                            }
                                            j10 = j11;
                                        }
                                        i10 = 2;
                                        str7 = obj;
                                    }
                                    if (str7 != 0) {
                                        sb5.append(str7);
                                    }
                                    bufferedInputStream.close();
                                } else {
                                    String contentEncoding = httpURLConnection.getContentEncoding();
                                    if (contentEncoding == null && (contentType = httpURLConnection.getContentType()) != null && !contentType.isEmpty() && (iIndexOf = (upperCase = contentType.toUpperCase(Locale.ROOT)).indexOf("CHARSET=")) >= 0) {
                                        int i14 = iIndexOf + 8;
                                        int iIndexOf3 = i14 < 0 ? -1 : upperCase.indexOf(59, i14);
                                        if (iIndexOf3 < 0) {
                                            iIndexOf3 = upperCase.length();
                                        }
                                        int i15 = iIndexOf3;
                                        if (i15 > i14) {
                                            contentEncoding = upperCase.substring(i14, i15);
                                        }
                                    }
                                    char[] cArr = new char[4096];
                                    e eVar = new e(inputStream, contentEncoding);
                                    int i16 = 0;
                                    while (true) {
                                        int i17 = eVar.read(cArr, 0, 4096);
                                        if (i17 <= 0) {
                                            z11 = false;
                                            break;
                                        }
                                        if (i16 >= 8388608) {
                                            z11 = true;
                                            break;
                                        }
                                        sb5.append(cArr, 0, i17);
                                        i16 += i17;
                                        if (i16 > 0) {
                                            cVar3.c(i16);
                                            long j12 = i16;
                                            if (j12 - j10 > 32768) {
                                                j(cVar3);
                                            }
                                            j10 = j12;
                                        }
                                    }
                                    eVar.close();
                                }
                                if (z11) {
                                    tc.a.a("Response is too large", new Object[0]);
                                    g(cVar3);
                                    return cVar2;
                                }
                                j(cVar3);
                                cVar3.j(this.f11603e);
                                if (z12) {
                                    cVar3.g(sb5.toString());
                                } else {
                                    cVar3.i(sb5.toString());
                                }
                            }
                            httpURLConnection.disconnect();
                            cVar3.f(4);
                            h(cVar3);
                            return cVar3;
                        }
                        tc.a.a("GM XHR HTTP error: %d", Integer.valueOf(responseCode));
                        httpURLConnection.disconnect();
                        g(cVar3);
                        return cVar3;
                    } catch (SocketTimeoutException unused2) {
                        tc.a.a("GM XHR timed out", new Object[0]);
                        l(cVar3);
                        return cVar3;
                    }
                } catch (UnsupportedEncodingException unused3) {
                    cVar = null;
                }
            } catch (IOException e11) {
                e = e11;
                z10 = false;
            }
        } catch (Exception unused4) {
            tc.a.a("Invalid GM XHR URL", new Object[0]);
            g(cVar3);
            return cVar3;
        }
    }

    public final void g(c cVar) {
        d(this.f11604f, cVar, true);
    }

    public final void h(c cVar) {
        d(this.f11605g, cVar, true);
    }

    public final void i(c cVar) {
        d(this.f11606h, cVar, true);
    }

    public final void j(c cVar) {
        d(this.f11607i, cVar, false);
    }

    public final void k(c cVar) {
        d(this.f11608j, cVar, false);
    }

    public final void l(c cVar) {
        d(this.f11609k, null, false);
    }

    public final void m(c cVar) {
        JSONObject jSONObject = this.f11614p;
        d((jSONObject == null || jSONObject.length() == 0) ? null : this.f11614p.optString("onprogress"), cVar, false);
    }

    public byte[] n() {
        String str = this.f11600b;
        if (str != null && !str.isEmpty()) {
            try {
                return this.f11600b.getBytes("UTF-8");
            } catch (UnsupportedEncodingException unused) {
                tc.a.a("Unsupported GM XHR request encoding", new Object[0]);
            }
        }
        return null;
    }

    public Map o() {
        if (this.f11601c == null) {
            return null;
        }
        HashMap map = new HashMap();
        Iterator<String> itKeys = this.f11601c.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            try {
                map.put(next, this.f11601c.getString(next));
            } catch (JSONException unused) {
                return null;
            }
        }
        return map;
    }

    public final void p(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        this.f11621w.post(new RunnableC0112b(new WeakReference(this.f11621w), str));
    }
}
