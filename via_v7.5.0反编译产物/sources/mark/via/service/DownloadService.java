package mark.via.service;

import android.R;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import g5.b;
import j5.a;
import j5.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mark.via.Shell;
import mark.via.download.n;
import mark.via.download.t1;
import mark.via.service.DownloadService;
import n.h;
import org.simpleframework.xml.strategy.Name;
import w7.u;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class DownloadService extends Service implements c, a {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f10330o;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c5.a f10331c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public n f10332e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f10333m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public List f10334n;

    static {
        f10330o = Build.VERSION.SDK_INT >= 23 ? 201326592 : 134217728;
    }

    public static /* synthetic */ void a(DownloadService downloadService) {
        downloadService.getClass();
        try {
            downloadService.stopForeground(true);
            downloadService.stopSelf();
        } catch (Exception e10) {
            tc.a.j(e10);
        }
    }

    @Override // j5.c
    public void I(g5.c cVar, int i10, int i11) {
        f(cVar);
        if (b.a(i11) || b.c(i11) || b.f(i11)) {
            t1.f(cVar);
            if (this.f10331c.n()) {
                return;
            }
            e();
        }
    }

    public final void b(Runnable runnable) {
        if (this.f10333m) {
            runnable.run();
            return;
        }
        if (this.f10334n == null) {
            this.f10334n = new ArrayList();
        }
        this.f10334n.add(runnable);
    }

    public final void c() {
        this.f10333m = true;
        List list = this.f10334n;
        if (list == null) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.f10334n.clear();
        this.f10334n = null;
    }

    public final void d() {
        Intent intent = new Intent(this, (Class<?>) Shell.class);
        intent.setAction("mark.via.DOWNLOADER");
        intent.setPackage(getPackageName());
        h.d dVarM = new h.d(getApplicationContext(), "mark.via.FORGROUND").n(R.drawable.stat_sys_download_done).g(PendingIntent.getActivity(this, 0, intent, f10330o)).i(getString(u.f14038f1)).h(getString(u.f14052g1)).m(true);
        if (Build.VERSION.SDK_INT >= 21) {
            dVarM.f("progress");
        }
        startForeground(1, dVarM.b());
    }

    public final void e() {
        b(new Runnable() { // from class: gb.a
            @Override // java.lang.Runnable
            public final void run() {
                DownloadService.a(this.f5603c);
            }
        });
    }

    public final void f(g5.c cVar) {
        n nVar = this.f10332e;
        if (nVar == null) {
            return;
        }
        nVar.h(cVar);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        c5.b bVarR = c5.b.r(this);
        this.f10331c = bVarR;
        bVarR.d(this);
        this.f10331c.e(this);
        n nVarE = n.e(this);
        this.f10332e = nVarE;
        nVarE.g();
        d();
        c();
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.f10331c.c(this);
        this.f10331c.f(this);
        super.onDestroy();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        c5.a aVar;
        super.onStartCommand(intent, i10, i11);
        String action = intent == null ? null : intent.getAction();
        if (action != null && (aVar = this.f10331c) != null) {
            switch (action) {
                case "mark.via.receiver.DownloadReceiver.RESUME_ALL":
                    if (aVar.k()) {
                        e();
                        break;
                    }
                    break;
                case "mark.via.receiver.DownloadReceiver.PAUSE_ALL":
                    if (!aVar.p()) {
                        e();
                        break;
                    }
                    break;
                case "mark.via.receiver.DownloadReceiver.PAUSE":
                case "mark.via.receiver.DownloadReceiver.RESUME":
                    long longExtra = intent.getLongExtra(Name.MARK, 0L);
                    if (longExtra > 0) {
                        boolean zEquals = "mark.via.receiver.DownloadReceiver.PAUSE".equals(action);
                        c5.a aVar2 = this.f10331c;
                        boolean zO = zEquals ? aVar2.o(longExtra) : aVar2.g(longExtra);
                        if (zEquals && zO && !this.f10331c.n()) {
                            e();
                        }
                        break;
                    }
                    break;
                case "mark.via.receiver.DownloadReceiver.REDOWNLOAD":
                    long longExtra2 = intent.getLongExtra(Name.MARK, 0L);
                    if (longExtra2 > 0) {
                        this.f10331c.l(longExtra2);
                        break;
                    }
                    break;
            }
        }
        return 1;
    }

    @Override // j5.a
    public void u(g5.c cVar, long j10, long j11) {
        f(cVar);
    }
}
