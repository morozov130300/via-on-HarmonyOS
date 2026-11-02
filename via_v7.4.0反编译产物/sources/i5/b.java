package i5;

import android.webkit.CookieManager;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class b implements Runnable {

    /* renamed from: n, reason: collision with root package name */
    public static final String f6973n = "b";

    /* renamed from: e, reason: collision with root package name */
    public URL f6974e;

    /* renamed from: j, reason: collision with root package name */
    public a f6975j;

    /* renamed from: k, reason: collision with root package name */
    public int f6976k = 20000;

    /* renamed from: l, reason: collision with root package name */
    public int f6977l = 20000;

    /* renamed from: m, reason: collision with root package name */
    public boolean f6978m = false;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface a {
        void a();

        void b(String str, boolean z10);

        void c(HttpURLConnection httpURLConnection, int i10, String str);

        void d(HttpURLConnection httpURLConnection);

        void e(IOException iOException);
    }

    public b(String str) {
        this.f6974e = new URL(str);
    }

    public void a(boolean z10) {
        this.f6978m = z10;
    }

    public void b(a aVar) {
        this.f6975j = aVar;
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        boolean z10;
        HttpURLConnection httpURLConnection;
        int responseCode;
        int i10 = 0;
        while (true) {
            boolean z11 = false;
            while (true) {
                int i11 = i10 + 1;
                if (i10 >= 5) {
                    a aVar = this.f6975j;
                    if (aVar != null) {
                        aVar.a();
                        return;
                    }
                    return;
                }
                HttpURLConnection httpURLConnection2 = null;
                try {
                    try {
                        z10 = true;
                        d5.a.b(f6973n, "request url: %s", this.f6974e);
                        httpURLConnection = (HttpURLConnection) this.f6974e.openConnection();
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        try {
                            httpURLConnection.setInstanceFollowRedirects(false);
                            httpURLConnection.setConnectTimeout(this.f6976k);
                            httpURLConnection.setReadTimeout(this.f6977l);
                            httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
                            try {
                                String cookie = CookieManager.getInstance().getCookie(this.f6974e.toString());
                                if (cookie != null) {
                                    httpURLConnection.setRequestProperty("Cookie", cookie);
                                }
                            } catch (Exception unused) {
                            }
                            if (z11) {
                                httpURLConnection.setRequestProperty("Range", "bytes=0-");
                            }
                            l5.b.c(httpURLConnection);
                            a aVar2 = this.f6975j;
                            if (aVar2 != null) {
                                aVar2.d(httpURLConnection);
                            }
                            responseCode = httpURLConnection.getResponseCode();
                            if (responseCode != 307 && responseCode != 308) {
                                switch (responseCode) {
                                    case 301:
                                    case 302:
                                    case 303:
                                        break;
                                    default:
                                        if (z11) {
                                            if (responseCode == 200 || responseCode == 206) {
                                                break;
                                            } else {
                                                httpURLConnection.disconnect();
                                                i10 = i11;
                                            }
                                        } else if (!this.f6978m) {
                                            break;
                                        } else {
                                            boolean z12 = httpURLConnection.getHeaderField("Content-Length") == null;
                                            if (!"chunked".equals(httpURLConnection.getHeaderField("Transfer-Encoding")) || !z12) {
                                                break;
                                            } else {
                                                httpURLConnection.disconnect();
                                                i10 = i11;
                                                z11 = true;
                                            }
                                        }
                                        break;
                                }
                            }
                            URL url = new URL(this.f6974e, httpURLConnection.getHeaderField("Location"));
                            this.f6974e = url;
                            a aVar3 = this.f6975j;
                            if (aVar3 != null) {
                                String string = url.toString();
                                if (responseCode != 301 && responseCode != 308) {
                                    z10 = false;
                                }
                                aVar3.b(string, z10);
                            }
                            httpURLConnection.disconnect();
                            i10 = i11;
                        } catch (IOException e10) {
                            e = e10;
                            httpURLConnection2 = httpURLConnection;
                            d5.a.c(f6973n, e.getMessage(), e);
                            a aVar4 = this.f6975j;
                            if (aVar4 != null) {
                                aVar4.e(e);
                            }
                            if (httpURLConnection2 != null) {
                                httpURLConnection2.disconnect();
                                return;
                            }
                            return;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        httpURLConnection2 = httpURLConnection;
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                        throw th;
                    }
                } catch (IOException e11) {
                    e = e11;
                }
            }
        }
        a aVar5 = this.f6975j;
        if (aVar5 != null) {
            aVar5.c(httpURLConnection, responseCode, httpURLConnection.getResponseMessage());
        }
        httpURLConnection.disconnect();
    }
}
