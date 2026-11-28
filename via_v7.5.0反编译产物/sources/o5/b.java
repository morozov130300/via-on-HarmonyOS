package o5;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import com.tuyafeng.scanner.camera.CameraSettings;
import n5.p;
import n5.v;
import n5.x;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f10933n = "b";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public o5.d f10934a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public o5.c f10935b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.tuyafeng.scanner.camera.b f10936c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Handler f10937d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public o5.f f10938e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Handler f10941h;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f10939f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f10940g = true;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public CameraSettings f10942i = new CameraSettings();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Runnable f10943j = new c();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Runnable f10944k = new d();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Runnable f10945l = new e();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Runnable f10946m = new f();

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f10947c;

        public a(boolean z10) {
            this.f10947c = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.f10936c.t(this.f10947c);
        }
    }

    /* JADX INFO: renamed from: o5.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class RunnableC0107b implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ i f10949c;

        /* JADX INFO: renamed from: o5.b$b$a */
        /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f10936c.m(RunnableC0107b.this.f10949c);
            }
        }

        public RunnableC0107b(i iVar) {
            this.f10949c = iVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f10939f) {
                b.this.f10934a.c(new a());
            } else {
                Log.d(b.f10933n, "Camera is closed, not requesting preview");
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Log.d(b.f10933n, "Opening camera");
                b.this.f10936c.l();
            } catch (Exception e10) {
                b.this.n(e10);
                Log.e(b.f10933n, "Failed to open camera", e10);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Log.d(b.f10933n, "Configuring camera");
                b.this.f10936c.e();
                if (b.this.f10937d != null) {
                    b.this.f10937d.obtainMessage(p.f10651i, b.this.m()).sendToTarget();
                }
            } catch (Exception e10) {
                b.this.n(e10);
                Log.e(b.f10933n, "Failed to configure camera", e10);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Log.d(b.f10933n, "Starting preview");
                b.this.f10936c.s(b.this.f10935b);
                b.this.f10936c.u();
            } catch (Exception e10) {
                b.this.n(e10);
                Log.e(b.f10933n, "Failed to start preview", e10);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Log.d(b.f10933n, "Closing camera");
                b.this.f10936c.v();
                b.this.f10936c.d();
            } catch (Exception e10) {
                Log.e(b.f10933n, "Failed to close camera", e10);
            }
            b.this.f10940g = true;
            b.this.f10937d.sendEmptyMessage(p.f10644b);
            b.this.f10934a.b();
        }
    }

    public b(Context context) {
        x.a();
        this.f10934a = o5.d.d();
        com.tuyafeng.scanner.camera.b bVar = new com.tuyafeng.scanner.camera.b(context);
        this.f10936c = bVar;
        bVar.o(this.f10942i);
        this.f10941h = new Handler();
    }

    public void j() {
        x.a();
        if (this.f10939f) {
            this.f10934a.c(this.f10946m);
        } else {
            this.f10940g = true;
        }
        this.f10939f = false;
    }

    public void k() {
        x.a();
        w();
        this.f10934a.c(this.f10944k);
    }

    public o5.f l() {
        return this.f10938e;
    }

    public final v m() {
        return this.f10936c.h();
    }

    public final void n(Exception exc) {
        Handler handler = this.f10937d;
        if (handler != null) {
            handler.obtainMessage(p.f10645c, exc).sendToTarget();
        }
    }

    public void o() {
        x.a();
        this.f10939f = true;
        this.f10940g = false;
        this.f10934a.e(this.f10943j);
    }

    public void p(i iVar) {
        this.f10941h.post(new RunnableC0107b(iVar));
    }

    public void q(CameraSettings cameraSettings) {
        if (this.f10939f) {
            return;
        }
        this.f10942i = cameraSettings;
        this.f10936c.o(cameraSettings);
    }

    public void r(o5.f fVar) {
        this.f10938e = fVar;
        this.f10936c.q(fVar);
    }

    public void s(Handler handler) {
        this.f10937d = handler;
    }

    public void t(o5.c cVar) {
        this.f10935b = cVar;
    }

    public void u(boolean z10) {
        x.a();
        if (this.f10939f) {
            this.f10934a.c(new a(z10));
        }
    }

    public void v() {
        x.a();
        w();
        this.f10934a.c(this.f10945l);
    }

    public final void w() {
        if (!this.f10939f) {
            throw new IllegalStateException("CameraInstance is not open");
        }
    }
}
