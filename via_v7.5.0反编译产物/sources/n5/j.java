package n5;

import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f10616k = "j";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public o5.b f10617a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HandlerThread f10618b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Handler f10619c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public g f10620d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Handler f10621e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Rect f10622f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f10623g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Object f10624h = new Object();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Handler.Callback f10625i = new a();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final o5.i f10626j = new b();

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements Handler.Callback {
        public a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == p.f10646d) {
                j.this.g((w) message.obj);
                return true;
            }
            if (i10 != p.f10650h) {
                return true;
            }
            j.this.h();
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b implements o5.i {
        public b() {
        }

        @Override // o5.i
        public void a(Exception exc) {
            synchronized (j.this.f10624h) {
                try {
                    if (j.this.f10623g) {
                        j.this.f10619c.obtainMessage(p.f10650h).sendToTarget();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // o5.i
        public void b(w wVar) {
            synchronized (j.this.f10624h) {
                try {
                    if (j.this.f10623g) {
                        j.this.f10619c.obtainMessage(p.f10646d, wVar).sendToTarget();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public j(o5.b bVar, g gVar, Handler handler) {
        x.a();
        this.f10617a = bVar;
        this.f10620d = gVar;
        this.f10621e = handler;
    }

    public com.google.zxing.d f(w wVar) {
        if (this.f10622f == null) {
            return null;
        }
        return wVar.a();
    }

    public final void g(w wVar) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        wVar.b(this.f10622f);
        com.google.zxing.d dVarF = f(wVar);
        com.google.zxing.j jVarC = dVarF != null ? this.f10620d.c(dVarF) : null;
        if (jVarC != null) {
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            Log.d(f10616k, "Found barcode in " + (jCurrentTimeMillis2 - jCurrentTimeMillis) + " ms");
            if (this.f10621e != null) {
                Message messageObtain = Message.obtain(this.f10621e, p.f10648f, new d(jVarC, wVar));
                messageObtain.setData(new Bundle());
                messageObtain.sendToTarget();
            }
        } else {
            Handler handler = this.f10621e;
            if (handler != null) {
                Message.obtain(handler, p.f10647e).sendToTarget();
            }
        }
        if (this.f10621e != null) {
            Message.obtain(this.f10621e, p.f10649g, d.b(this.f10620d.d(), wVar)).sendToTarget();
        }
        h();
    }

    public final void h() {
        this.f10617a.p(this.f10626j);
    }

    public void i(Rect rect) {
        this.f10622f = rect;
    }

    public void j(g gVar) {
        this.f10620d = gVar;
    }

    public void k() {
        x.a();
        HandlerThread handlerThread = new HandlerThread(f10616k);
        this.f10618b = handlerThread;
        handlerThread.start();
        this.f10619c = new Handler(this.f10618b.getLooper(), this.f10625i);
        this.f10623g = true;
        h();
    }

    public void l() {
        x.a();
        synchronized (this.f10624h) {
            this.f10623g = false;
            this.f10619c.removeCallbacksAndMessages(null);
            this.f10618b.quit();
        }
    }
}
