package o5;

import android.os.Build;
import android.util.Base64;
import android.webkit.WebSettings;
import android.webkit.WebView;
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
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;
import s5.d;
import s5.f;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class b {

    /* renamed from: y, reason: collision with root package name */
    public static final String f10368y = "b";

    /* renamed from: a, reason: collision with root package name */
    public JSONObject f10369a;

    /* renamed from: b, reason: collision with root package name */
    public String f10370b;

    /* renamed from: c, reason: collision with root package name */
    public JSONObject f10371c;

    /* renamed from: d, reason: collision with root package name */
    public String f10372d;

    /* renamed from: e, reason: collision with root package name */
    public String f10373e;

    /* renamed from: f, reason: collision with root package name */
    public String f10374f;

    /* renamed from: g, reason: collision with root package name */
    public String f10375g;

    /* renamed from: h, reason: collision with root package name */
    public String f10376h;

    /* renamed from: i, reason: collision with root package name */
    public String f10377i;

    /* renamed from: j, reason: collision with root package name */
    public String f10378j;

    /* renamed from: k, reason: collision with root package name */
    public String f10379k;

    /* renamed from: l, reason: collision with root package name */
    public String f10380l;

    /* renamed from: m, reason: collision with root package name */
    public String f10381m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f10382n;

    /* renamed from: o, reason: collision with root package name */
    public int f10383o;

    /* renamed from: p, reason: collision with root package name */
    public JSONObject f10384p;

    /* renamed from: q, reason: collision with root package name */
    public String f10385q;

    /* renamed from: r, reason: collision with root package name */
    public String f10386r;

    /* renamed from: s, reason: collision with root package name */
    public String f10387s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f10388t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f10389u;

    /* renamed from: v, reason: collision with root package name */
    public String f10390v;

    /* renamed from: w, reason: collision with root package name */
    public final WebView f10391w;

    /* renamed from: x, reason: collision with root package name */
    public final n5.c f10392x;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a extends Thread {
        public a() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() throws IOException {
            b.this.e();
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    /* renamed from: o5.b$b, reason: collision with other inner class name */
    public class RunnableC0103b implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ WeakReference f10394e;

        /* renamed from: j, reason: collision with root package name */
        public final /* synthetic */ String f10395j;

        public RunnableC0103b(WeakReference weakReference, String str) {
            this.f10394e = weakReference;
            this.f10395j = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            WebView webView = (WebView) this.f10394e.get();
            if (webView == null) {
                return;
            }
            webView.evaluateJavascript(this.f10395j, null);
        }
    }

    public b(WebView webView, String str, n5.c cVar) {
        this.f10391w = webView;
        Objects.requireNonNull(cVar, "userScriptProvider");
        this.f10392x = cVar;
        this.f10389u = false;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f10372d = jSONObject.optString("method", "GET").toUpperCase(Locale.ROOT);
            this.f10385q = jSONObject.getString("url");
            this.f10389u = true;
            this.f10369a = jSONObject.optJSONObject("context");
            this.f10370b = jSONObject.optString("data");
            this.f10371c = jSONObject.optJSONObject("headers");
            this.f10373e = jSONObject.optString("responseType");
            this.f10374f = jSONObject.optString("onerror");
            this.f10375g = jSONObject.optString("onload");
            this.f10376h = jSONObject.optString("onloadstart");
            this.f10377i = jSONObject.optString("onprogress");
            this.f10378j = jSONObject.optString("onreadystatechange");
            this.f10379k = jSONObject.optString("ontimeout");
            this.f10380l = jSONObject.optString("overrideMimeType");
            this.f10382n = jSONObject.optBoolean("synchronous");
            this.f10383o = jSONObject.optInt("timeout");
            this.f10384p = jSONObject.optJSONObject("upload");
            this.f10386r = jSONObject.optString("user");
            this.f10381m = jSONObject.optString("password");
            this.f10387s = jSONObject.optString("cookie");
            this.f10388t = jSONObject.optBoolean("anonymous", false);
            if (webView == null) {
                this.f10390v = null;
            } else if (Build.VERSION.SDK_INT > 19) {
                this.f10390v = WebSettings.getDefaultUserAgent(webView.getContext());
            } else {
                this.f10390v = webView.getSettings().getUserAgentString();
            }
        } catch (JSONException e10) {
            d.c(f10368y, "JSON parsing exception:" + e10.getMessage());
        }
    }

    public c b() {
        if (this.f10389u) {
            return this.f10382n ? e() : d();
        }
        return null;
    }

    public final void c(String str, c cVar, boolean z10) {
        String[] strArr = z10 ? new String[]{this.f10378j, str} : new String[]{str};
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
            String str3 = this.f10377i;
            cVar.d(str3 != null && str3.equals(str));
        }
        o(this.f10392x.d(strArr, cVar == null ? null : cVar.o()));
    }

    public final c d() {
        c cVar = new c(this.f10369a);
        new a().start();
        return cVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:225:0x047f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final c e() throws IOException {
        c cVar;
        c cVar2;
        String str;
        String str2;
        boolean z10;
        boolean z11;
        String contentType;
        String upperCase;
        int iIndexOf;
        String strEncodeToString;
        c cVar3;
        c cVar4;
        String str3;
        String str4;
        c cVar5 = new c(this.f10369a);
        try {
            URL url = new URL(this.f10385q);
            d.a(f10368y, "request: " + this.f10385q);
            byte[] bArrM = m();
            boolean z12 = true;
            int i10 = 0;
            try {
                try {
                    try {
                        cVar5.f(1);
                        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                        httpURLConnection.setRequestMethod(this.f10372d);
                        h(cVar5);
                        if (this.f10370b != null && bArrM != null) {
                            try {
                                httpURLConnection.setDoOutput(true);
                                httpURLConnection.setDoInput(true);
                                httpURLConnection.setRequestProperty("Content-Length", String.valueOf(bArrM.length));
                                httpURLConnection.setRequestProperty("Content-Type", this.f10370b.indexOf(61) > 0 ? "application/x-www-form-urlencoded;charset=UTF-8" : "text/plain;charset=UTF-8");
                            } catch (IOException e10) {
                                e = e10;
                                z12 = false;
                                d.c(f10368y, "Exception issuing GM_xmlhttpRequest for: " + this.f10385q + ": " + e.getMessage());
                                if (!z12) {
                                    cVar5.f(4);
                                    f(cVar5);
                                }
                                return cVar5;
                            }
                        }
                        String str5 = this.f10386r;
                        if (str5 != null && !str5.isEmpty() && (str4 = this.f10381m) != null && !str4.isEmpty()) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Basic ");
                            sb2.append(Base64.encodeToString((this.f10386r + ":" + this.f10381m).getBytes("UTF-8"), 2));
                            httpURLConnection.setRequestProperty("Authorization", sb2.toString());
                        }
                        Map mapN = n();
                        if (mapN != null) {
                            str = null;
                            str2 = null;
                            for (Map.Entry entry : mapN.entrySet()) {
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
                                    d.c(f10368y, "Unable to get UTF-8 bytes for HTTP Basic Auth username/password");
                                    return cVar;
                                }
                            }
                            cVar2 = null;
                        } else {
                            cVar2 = null;
                            str = null;
                            str2 = null;
                        }
                        if (str != null || ((str3 = this.f10390v) != null && !str3.isEmpty())) {
                            if (str == null) {
                                str = this.f10390v;
                            }
                            httpURLConnection.setRequestProperty("User-Agent", str);
                        }
                        if (!this.f10388t) {
                            StringBuilder sb3 = new StringBuilder();
                            if (str2 != null && !str2.isEmpty()) {
                                if (sb3.length() > 0) {
                                    sb3.append(';');
                                }
                                sb3.append(str2);
                            }
                            String str6 = this.f10387s;
                            if (str6 != null && !str6.isEmpty()) {
                                if (sb3.length() > 0) {
                                    sb3.append(';');
                                }
                                sb3.append(this.f10387s);
                            }
                            if (sb3.length() > 0) {
                                httpURLConnection.setRequestProperty("Cookie", sb3.toString());
                            }
                        }
                        if (!this.f10380l.isEmpty()) {
                            httpURLConnection.setRequestProperty("Content-Type", this.f10380l);
                        }
                        httpURLConnection.setConnectTimeout(this.f10383o);
                        httpURLConnection.setReadTimeout(this.f10383o);
                        httpURLConnection.connect();
                        if (bArrM != null) {
                            try {
                                OutputStream outputStream = httpURLConnection.getOutputStream();
                                outputStream.write(bArrM);
                                outputStream.flush();
                                outputStream.close();
                                cVar5.b(true);
                                cVar5.m(bArrM.length);
                                cVar5.c(bArrM.length);
                                cVar5.e(true);
                                l(cVar5);
                                cVar5.e(false);
                            } catch (IOException e11) {
                                e = e11;
                                d.c(f10368y, "Exception issuing GM_xmlhttpRequest for: " + this.f10385q + ": " + e.getMessage());
                                if (!z12) {
                                }
                                return cVar5;
                            }
                        }
                        int responseCode = httpURLConnection.getResponseCode();
                        cVar5.k(responseCode);
                        cVar5.l(httpURLConnection.getResponseMessage());
                        cVar5.a(httpURLConnection.getURL().toString());
                        cVar5.f(2);
                        j(cVar5);
                        if (responseCode < 200 || responseCode >= 300) {
                            d.c(f10368y, "HTTP error from url: " + this.f10385q + ", HTTP Response " + httpURLConnection.getResponseCode());
                            httpURLConnection.disconnect();
                            f(cVar5);
                            return cVar5;
                        }
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
                        cVar5.h(sb4.toString());
                        int contentLength = httpURLConnection.getContentLength();
                        cVar5.b(contentLength > 0);
                        cVar5.m(contentLength > 0 ? contentLength : -1);
                        cVar5.f(3);
                        j(cVar5);
                        if (!"HEAD".equalsIgnoreCase(this.f10372d)) {
                            InputStream inputStream = httpURLConnection.getInputStream();
                            StringBuilder sb5 = new StringBuilder();
                            boolean z13 = "blob".equals(this.f10373e) || "stream".equals(this.f10373e) || "arraybuffer".equals(this.f10373e);
                            long j10 = 0;
                            if (z13) {
                                int i12 = 6144;
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
                                int i13 = 0;
                                while (true) {
                                    int i14 = bufferedInputStream.read(bArr, i10, i12);
                                    if (i14 <= 0) {
                                        z11 = false;
                                        break;
                                    }
                                    if (i13 >= 8388608) {
                                        z11 = true;
                                        break;
                                    }
                                    if (bArrCopyOf.length == 0) {
                                        strEncodeToString = Base64.encodeToString(bArr, i10, i14, 2);
                                    } else {
                                        bArrCopyOf = Arrays.copyOf(bArrCopyOf, bArrCopyOf.length + i14);
                                        System.arraycopy(bArr, i10, bArrCopyOf, bArrCopyOf.length - i14, i14);
                                        strEncodeToString = Base64.encodeToString(bArrCopyOf, i10, bArrCopyOf.length, 2);
                                    }
                                    String str8 = strEncodeToString;
                                    if (str8.indexOf(61) < 0) {
                                        if (bArrCopyOf.length > 0) {
                                            bArrCopyOf = new byte[i10];
                                        }
                                        sb5.append(str8);
                                        cVar3 = cVar2;
                                    } else {
                                        cVar3 = str8;
                                        if (bArrCopyOf.length == 0) {
                                            bArrCopyOf = Arrays.copyOf(bArr, i14);
                                            cVar3 = str8;
                                        }
                                    }
                                    i13 += i14;
                                    if (i13 <= 0 || contentLength <= 0) {
                                        cVar4 = cVar3;
                                    } else {
                                        cVar5.c(i13);
                                        cVar4 = cVar3;
                                        long j11 = i13;
                                        if (j11 - j10 > 32768) {
                                            i(cVar5);
                                        }
                                        j10 = j11;
                                    }
                                    str7 = cVar4;
                                    i12 = 6144;
                                    i10 = 0;
                                }
                                if (str7 != 0) {
                                    sb5.append(str7);
                                }
                                bufferedInputStream.close();
                            } else {
                                String contentEncoding = httpURLConnection.getContentEncoding();
                                if (contentEncoding == null && (contentType = httpURLConnection.getContentType()) != null && !contentType.isEmpty() && (iIndexOf = (upperCase = contentType.toUpperCase(Locale.ROOT)).indexOf("CHARSET=")) >= 0) {
                                    int i15 = iIndexOf + 8;
                                    int iIndexOf3 = i15 < 0 ? -1 : upperCase.indexOf(59, i15);
                                    if (iIndexOf3 < 0) {
                                        iIndexOf3 = upperCase.length();
                                    }
                                    int i16 = iIndexOf3;
                                    if (i16 > i15) {
                                        contentEncoding = upperCase.substring(i15, i16);
                                    }
                                }
                                char[] cArr = new char[4096];
                                f fVar = new f(inputStream, contentEncoding);
                                int i17 = 0;
                                while (true) {
                                    int i18 = fVar.read(cArr, 0, 4096);
                                    if (i18 <= 0) {
                                        z10 = false;
                                        break;
                                    }
                                    if (i17 >= 8388608) {
                                        z10 = true;
                                        break;
                                    }
                                    sb5.append(cArr, 0, i18);
                                    i17 += i18;
                                    if (i17 > 0) {
                                        cVar5.c(i17);
                                        long j12 = i17;
                                        if (j12 - j10 > 32768) {
                                            i(cVar5);
                                        }
                                        j10 = j12;
                                    }
                                }
                                fVar.close();
                                z11 = z10;
                            }
                            if (z11) {
                                d.f(f10368y, "Response is too large");
                                f(cVar5);
                                return cVar2;
                            }
                            i(cVar5);
                            cVar5.j(this.f10373e);
                            if (z13) {
                                cVar5.g(sb5.toString());
                            } else {
                                cVar5.i(sb5.toString());
                            }
                        }
                        httpURLConnection.disconnect();
                        cVar5.f(4);
                        g(cVar5);
                        return cVar5;
                    } catch (SocketTimeoutException e12) {
                        d.c(f10368y, "Timeout issuing GM_xmlhttpRequest for: " + this.f10385q + ": " + e12.getMessage());
                        k(cVar5);
                        return cVar5;
                    }
                } catch (UnsupportedEncodingException unused2) {
                    cVar = null;
                }
            } catch (IOException e13) {
                e = e13;
            }
        } catch (Exception unused3) {
            d.c(f10368y, "URL is invalid: " + this.f10385q);
            f(cVar5);
            return cVar5;
        }
    }

    public final void f(c cVar) {
        c(this.f10374f, cVar, true);
    }

    public final void g(c cVar) {
        c(this.f10375g, cVar, true);
    }

    public final void h(c cVar) {
        c(this.f10376h, cVar, true);
    }

    public final void i(c cVar) {
        c(this.f10377i, cVar, false);
    }

    public final void j(c cVar) {
        c(this.f10378j, cVar, false);
    }

    public final void k(c cVar) {
        c(this.f10379k, null, false);
    }

    public final void l(c cVar) {
        JSONObject jSONObject = this.f10384p;
        c((jSONObject == null || jSONObject.length() == 0) ? null : this.f10384p.optString("onprogress"), cVar, false);
    }

    public byte[] m() {
        String str = this.f10370b;
        if (str != null && !str.isEmpty()) {
            try {
                return this.f10370b.getBytes("UTF-8");
            } catch (UnsupportedEncodingException unused) {
                d.c(f10368y, "Unable to get UTF-8 bytes from string data: " + this.f10370b);
            }
        }
        return null;
    }

    public Map n() {
        if (this.f10371c == null) {
            return null;
        }
        HashMap map = new HashMap();
        Iterator<String> itKeys = this.f10371c.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            try {
                map.put(next, this.f10371c.getString(next));
            } catch (JSONException unused) {
                return null;
            }
        }
        return map;
    }

    public final void o(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        this.f10391w.post(new RunnableC0103b(new WeakReference(this.f10391w), str));
    }
}
