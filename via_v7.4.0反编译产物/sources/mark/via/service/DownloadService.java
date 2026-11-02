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
import mark.via.download.d;
import mark.via.download.i1;
import mark.via.service.DownloadService;
import n.h;
import org.simpleframework.xml.strategy.Name;
import x7.u;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class DownloadService extends Service implements c, a {

    /* renamed from: m, reason: collision with root package name */
    public static final int f9987m;

    /* renamed from: e, reason: collision with root package name */
    public c5.a f9988e;

    /* renamed from: j, reason: collision with root package name */
    public d f9989j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f9990k;

    /* renamed from: l, reason: collision with root package name */
    public List f9991l;

    static {
        f9987m = Build.VERSION.SDK_INT >= 23 ? 201326592 : 134217728;
    }

    public static /* synthetic */ void a(DownloadService downloadService) {
        downloadService.getClass();
        try {
            downloadService.stopForeground(true);
            downloadService.stopSelf();
        } catch (Exception e10) {
            pc.a.i(e10);
        }
    }

    @Override // j5.c
    public void J(g5.c cVar, int i10, int i11) {
        f(cVar);
        if (b.a(i11) || b.c(i11) || b.f(i11)) {
            i1.e(cVar);
            if (this.f9988e.o()) {
                return;
            }
            e();
        }
    }

    public final void b(Runnable runnable) {
        if (this.f9990k) {
            runnable.run();
            return;
        }
        if (this.f9991l == null) {
            this.f9991l = new ArrayList();
        }
        this.f9991l.add(runnable);
    }

    public final void c() {
        this.f9990k = true;
        List list = this.f9991l;
        if (list == null) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.f9991l.clear();
        this.f9991l = null;
    }

    public final void d() {
        Intent intent = new Intent(this, (Class<?>) Shell.class);
        intent.setAction("mark.via.DOWNLOADER");
        intent.setPackage(getPackageName());
        h.d dVarM = new h.d(getApplicationContext(), "mark.via.FORGROUND").n(R.drawable.stat_sys_download_done).g(PendingIntent.getActivity(this, 0, intent, f9987m)).i(getString(u.f13930c1)).h(getString(u.f13944d1)).m(true);
        if (Build.VERSION.SDK_INT >= 21) {
            dVarM.f("progress");
        }
        startForeground(1, dVarM.b());
    }

    public final void e() {
        b(new Runnable() { // from class: gb.a
            @Override // java.lang.Runnable
            public final void run() {
                DownloadService.a(this.f6309e);
            }
        });
    }

    public final void f(g5.c cVar) {
        d dVar = this.f9989j;
        if (dVar == null) {
            return;
        }
        dVar.h(cVar);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        c5.b bVarR = c5.b.r(this);
        this.f9988e = bVarR;
        bVarR.d(this);
        this.f9988e.e(this);
        d dVarE = d.e(this);
        this.f9989j = dVarE;
        dVarE.g();
        d();
        c();
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.f9988e.c(this);
        this.f9988e.f(this);
        super.onDestroy();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        c5.a aVar;
        super.onStartCommand(intent, i10, i11);
        String action = intent == null ? null : intent.getAction();
        if (action != null && (aVar = this.f9988e) != null) {
            switch (action) {
                case "mark.via.receiver.DownloadReceiver.RESUME_ALL":
                    if (aVar.k()) {
                        e();
                        break;
                    }
                    break;
                case "mark.via.receiver.DownloadReceiver.PAUSE_ALL":
                    if (!aVar.q()) {
                        e();
                        break;
                    }
                    break;
                case "mark.via.receiver.DownloadReceiver.PAUSE":
                case "mark.via.receiver.DownloadReceiver.RESUME":
                    long longExtra = intent.getLongExtra(Name.MARK, 0L);
                    if (longExtra > 0) {
                        boolean zEquals = "mark.via.receiver.DownloadReceiver.PAUSE".equals(action);
                        c5.a aVar2 = this.f9988e;
                        boolean zP = zEquals ? aVar2.p(longExtra) : aVar2.g(longExtra);
                        if (zEquals && zP && !this.f9988e.o()) {
                            e();
                            break;
                        }
                    }
                    break;
                case "mark.via.receiver.DownloadReceiver.REDOWNLOAD":
                    long longExtra2 = intent.getLongExtra(Name.MARK, 0L);
                    if (longExtra2 > 0) {
                        this.f9988e.m(longExtra2);
                        break;
                    }
                    break;
            }
        }
        return 1;
    }

    @Override // j5.a
    public void v(g5.c cVar, long j10, long j11) {
        f(cVar);
    }
}
