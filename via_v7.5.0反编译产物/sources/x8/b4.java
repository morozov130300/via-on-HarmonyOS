package x8;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class b4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f14543a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Activity f14544b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public q5.k f14545c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f14546d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public HttpURLConnection f14548f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f14547e = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Handler f14549g = new Handler();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Runnable f14550h = new a();

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b4.this.f14545c.s()) {
                b4.e(b4.this);
                if (b4.this.f14547e < 5) {
                    b4.this.f14549g.postDelayed(this, 1000L);
                    return;
                }
                if (b4.this.f14548f != null) {
                    b4.this.f14548f.disconnect();
                }
                h.c(b4.this.f14544b, new Runnable() { // from class: x8.a4
                    @Override // java.lang.Runnable
                    public final void run() {
                        b4.this.m(2);
                    }
                });
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface b {
        void a();
    }

    public b4(Context context) {
        this.f14543a = context;
        this.f14544b = (Activity) context;
        j();
    }

    public static /* synthetic */ void a(final b4 b4Var, Map map, String str) {
        b4Var.getClass();
        byte[] bytes = k(map).toString().getBytes(k8.a.f7218a);
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            b4Var.f14548f = httpURLConnection;
            httpURLConnection.setConnectTimeout(3000);
            b4Var.f14548f.setDoInput(true);
            b4Var.f14548f.setDoOutput(true);
            b4Var.f14548f.setRequestMethod("POST");
            b4Var.f14548f.setUseCaches(false);
            b4Var.f14548f.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            b4Var.f14548f.setRequestProperty("Content-Length", String.valueOf(bytes.length));
            b4Var.f14548f.getOutputStream().write(bytes);
            int responseCode = b4Var.f14548f.getResponseCode();
            tc.a.a("Response: %d", Integer.valueOf(responseCode));
            final int i10 = responseCode == 200 ? 0 : 1;
            h.c(b4Var.f14544b, new Runnable() { // from class: x8.z3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f14660c.m(i10);
                }
            });
        } catch (IOException unused) {
        } finally {
            HttpURLConnection httpURLConnection2 = b4Var.f14548f;
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
        }
    }

    public static /* synthetic */ int e(b4 b4Var) {
        int i10 = b4Var.f14547e;
        b4Var.f14547e = i10 + 1;
        return i10;
    }

    public static StringBuffer k(Map map) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            for (Map.Entry entry : map.entrySet()) {
                stringBuffer.append((String) entry.getKey());
                stringBuffer.append("=");
                stringBuffer.append((String) entry.getValue());
                stringBuffer.append("&");
            }
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            return stringBuffer;
        } catch (Exception e10) {
            e10.printStackTrace();
            return stringBuffer;
        }
    }

    public final void j() {
        this.f14545c = q5.k.l(this.f14543a).Z(w7.u.si).u(false).v(false);
    }

    public void l(b bVar) {
        this.f14546d = bVar;
    }

    public final void m(int i10) {
        this.f14545c.o();
        if (i10 != 0) {
            if (i10 != 2) {
                com.tuyafeng.support.utils.n.m(this.f14544b, this.f14543a.getResources().getString(w7.u.I3), this.f14543a.getResources().getString(w7.u.C2));
                return;
            } else {
                com.tuyafeng.support.utils.n.m(this.f14544b, this.f14543a.getResources().getString(w7.u.I3), this.f14543a.getResources().getString(w7.u.I2));
                return;
            }
        }
        b bVar = this.f14546d;
        if (bVar != null) {
            bVar.a();
        } else {
            com.tuyafeng.support.utils.n.m(this.f14544b, this.f14543a.getResources().getString(w7.u.I3), this.f14543a.getResources().getString(w7.u.Kh));
        }
    }

    public final void n(final String str, final Map map) {
        h.b(new Runnable() { // from class: x8.y3
            @Override // java.lang.Runnable
            public final void run() {
                b4.a(this.f14656c, map, str);
            }
        });
    }

    public void o(String str, Map map) {
        if (z.A(this.f14543a) != 0) {
            this.f14545c.h0();
            this.f14549g.postDelayed(this.f14550h, 1000L);
            n(str, map);
        }
    }
}
