package i5;

import android.webkit.CookieManager;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class b implements Runnable {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f6242s = "b";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Executor f6243c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f6244e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public FutureTask f6245m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public URL f6246n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public InterfaceC0075b f6247o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f6248p = 20000;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f6249q = 20000;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f6250r = false;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ HttpURLConnection f6251c;

        public a(HttpURLConnection httpURLConnection) {
            this.f6251c = httpURLConnection;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f6251c.disconnect();
        }
    }

    /* JADX INFO: renamed from: i5.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface InterfaceC0075b {
        void a();

        void b(String str, boolean z10);

        void c(HttpURLConnection httpURLConnection, int i10, String str);

        void d(HttpURLConnection httpURLConnection);

        void e(IOException iOException);
    }

    public b(String str, Executor executor) {
        this.f6246n = new URL(str);
        this.f6243c = executor;
    }

    public synchronized void a() {
        if (this.f6244e) {
            return;
        }
        this.f6244e = true;
        FutureTask futureTask = this.f6245m;
        if (futureTask != null) {
            this.f6243c.execute(futureTask);
        }
    }

    public final synchronized void b() {
        if (this.f6244e) {
            throw new InterruptedIOException("Download cancelled");
        }
    }

    public void c(InterfaceC0075b interfaceC0075b) {
        this.f6247o = interfaceC0075b;
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        FutureTask futureTask;
        HttpURLConnection httpURLConnection;
        int responseCode;
        boolean z10;
        boolean z11 = false;
        int i10 = 0;
        while (true) {
            boolean z12 = false;
            while (true) {
                i10++;
                if (i10 >= 5) {
                    InterfaceC0075b interfaceC0075b = this.f6247o;
                    if (interfaceC0075b != null) {
                        interfaceC0075b.a();
                        return;
                    }
                    return;
                }
                try {
                    d5.a.b(f6242s, "request url: %s", this.f6246n);
                    b();
                    httpURLConnection = (HttpURLConnection) this.f6246n.openConnection();
                    futureTask = new FutureTask(new a(httpURLConnection), null);
                    try {
                        try {
                            httpURLConnection.setInstanceFollowRedirects(false);
                            httpURLConnection.setConnectTimeout(this.f6248p);
                            httpURLConnection.setReadTimeout(this.f6249q);
                            httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
                            try {
                                String cookie = CookieManager.getInstance().getCookie(this.f6246n.toString());
                                if (cookie != null) {
                                    httpURLConnection.setRequestProperty("Cookie", cookie);
                                }
                                while (true) {
                                    try {
                                        futureTask.get();
                                    } catch (InterruptedException unused) {
                                        z10 = true;
                                    } catch (ExecutionException e10) {
                                        d5.a.c(f6242s, "Could not disconnect", e10.getCause());
                                    }
                                    if (z10) {
                                        Thread.currentThread().interrupt();
                                    }
                                }
                            } catch (Exception unused2) {
                            }
                            if (z12) {
                                httpURLConnection.setRequestProperty("Range", "bytes=0-");
                            }
                            l5.b.c(httpURLConnection);
                            InterfaceC0075b interfaceC0075b2 = this.f6247o;
                            if (interfaceC0075b2 != null) {
                                interfaceC0075b2.d(httpURLConnection);
                            }
                            synchronized (this) {
                                b();
                                this.f6245m = futureTask;
                            }
                            b();
                            responseCode = httpURLConnection.getResponseCode();
                            b();
                            if (responseCode != 307 && responseCode != 308) {
                                switch (responseCode) {
                                    case 301:
                                    case 302:
                                    case 303:
                                        break;
                                    default:
                                        if (!z12) {
                                            if (this.f6250r) {
                                                boolean z13 = httpURLConnection.getHeaderField("Content-Length") == null;
                                                if ("chunked".equals(httpURLConnection.getHeaderField("Transfer-Encoding")) && z13) {
                                                    synchronized (this) {
                                                        this.f6245m = null;
                                                        break;
                                                    }
                                                    futureTask.run();
                                                    boolean z14 = false;
                                                    while (true) {
                                                        try {
                                                            futureTask.get();
                                                        } catch (InterruptedException unused3) {
                                                            z14 = true;
                                                        } catch (ExecutionException e11) {
                                                            d5.a.c(f6242s, "Could not disconnect", e11.getCause());
                                                        }
                                                        if (z14) {
                                                            Thread.currentThread().interrupt();
                                                        }
                                                        z12 = true;
                                                    }
                                                }
                                            }
                                        } else if (responseCode != 200 && responseCode != 206) {
                                            synchronized (this) {
                                                this.f6245m = null;
                                                break;
                                            }
                                            futureTask.run();
                                            boolean z15 = false;
                                            while (true) {
                                                try {
                                                    futureTask.get();
                                                } catch (InterruptedException unused4) {
                                                    z15 = true;
                                                } catch (ExecutionException e12) {
                                                    d5.a.c(f6242s, "Could not disconnect", e12.getCause());
                                                }
                                                if (z15) {
                                                    Thread.currentThread().interrupt();
                                                }
                                                i10 = i10;
                                            }
                                        }
                                        break;
                                }
                            }
                            URL url = new URL(this.f6246n, httpURLConnection.getHeaderField("Location"));
                            this.f6246n = url;
                            InterfaceC0075b interfaceC0075b3 = this.f6247o;
                            if (interfaceC0075b3 != null) {
                                interfaceC0075b3.b(url.toString(), responseCode == 301 || responseCode == 308);
                            }
                            synchronized (this) {
                                this.f6245m = null;
                            }
                            futureTask.run();
                            z10 = false;
                        } catch (Throwable th) {
                            th = th;
                            synchronized (this) {
                                this.f6245m = null;
                            }
                            if (futureTask != null) {
                                futureTask.run();
                                while (true) {
                                    try {
                                        futureTask.get();
                                    } catch (InterruptedException unused5) {
                                        z11 = true;
                                    } catch (ExecutionException e13) {
                                        d5.a.c(f6242s, "Could not disconnect", e13.getCause());
                                    }
                                    if (z11) {
                                        Thread.currentThread().interrupt();
                                    }
                                }
                            }
                            throw th;
                        }
                    } catch (IOException e14) {
                        e = e14;
                        d5.a.c(f6242s, e.getMessage(), e);
                        InterfaceC0075b interfaceC0075b4 = this.f6247o;
                        if (interfaceC0075b4 != null) {
                            interfaceC0075b4.e(e);
                        }
                        synchronized (this) {
                            this.f6245m = null;
                        }
                        if (futureTask == null) {
                            return;
                        }
                        futureTask.run();
                        while (true) {
                            try {
                                futureTask.get();
                            } catch (InterruptedException unused6) {
                                z11 = true;
                            } catch (ExecutionException e15) {
                                d5.a.c(f6242s, "Could not disconnect", e15.getCause());
                            }
                            if (!z11) {
                                return;
                            }
                        }
                    }
                } catch (IOException e16) {
                    e = e16;
                    futureTask = null;
                } catch (Throwable th2) {
                    th = th2;
                    futureTask = null;
                }
            }
        }
        InterfaceC0075b interfaceC0075b5 = this.f6247o;
        if (interfaceC0075b5 != null) {
            interfaceC0075b5.c(httpURLConnection, responseCode, httpURLConnection.getResponseMessage());
        }
        synchronized (this) {
            this.f6245m = null;
        }
        futureTask.run();
        while (true) {
            try {
                futureTask.get();
            } catch (InterruptedException unused7) {
                z11 = true;
            } catch (ExecutionException e17) {
                d5.a.c(f6242s, "Could not disconnect", e17.getCause());
            }
            if (!z11) {
                return;
            }
            Thread.currentThread().interrupt();
            return;
        }
    }
}
