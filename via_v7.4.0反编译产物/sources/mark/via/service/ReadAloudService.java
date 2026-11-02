package mark.via.service;

import android.app.Service;
import android.content.Intent;
import android.media.AudioDeviceCallback;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Build;
import android.os.IBinder;
import j8.c;
import j8.d;
import j8.e;
import j8.q;
import j8.s;
import j8.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mark.via.service.ReadAloudService;
import n.d1;
import org.simpleframework.xml.strategy.Name;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class ReadAloudService extends Service implements d {

    /* renamed from: e, reason: collision with root package name */
    public q f9992e;

    /* renamed from: j, reason: collision with root package name */
    public s f9993j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f9994k;

    /* renamed from: l, reason: collision with root package name */
    public List f9995l;

    /* renamed from: m, reason: collision with root package name */
    public AudioManager f9996m;

    /* renamed from: n, reason: collision with root package name */
    public AudioDeviceCallback f9997n = null;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a extends AudioDeviceCallback {
        public a() {
        }

        @Override // android.media.AudioDeviceCallback
        public void onAudioDevicesRemoved(AudioDeviceInfo[] audioDeviceInfoArr) {
            e.a(ReadAloudService.this.getApplicationContext(), null);
        }
    }

    public static /* synthetic */ void b(ReadAloudService readAloudService, boolean z10) {
        readAloudService.getClass();
        pc.a.a("stop service: %s", Boolean.valueOf(z10));
        try {
            d1.a(readAloudService, z10 ? 1 : 2);
            readAloudService.stopSelf();
        } catch (Exception e10) {
            pc.a.i(e10);
        }
    }

    @Override // j8.d
    public void a(t tVar) {
        g(tVar);
    }

    public final void c(Runnable runnable) {
        if (this.f9994k) {
            runnable.run();
            return;
        }
        if (this.f9995l == null) {
            this.f9995l = new ArrayList();
        }
        this.f9995l.add(runnable);
    }

    public final void d() {
        this.f9994k = true;
        List list = this.f9995l;
        if (list == null) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.f9995l.clear();
        this.f9995l = null;
    }

    public final void e(t tVar) {
        this.f9993j.b(this, tVar);
    }

    public final void f(final boolean z10) {
        c(new Runnable() { // from class: gb.d
            @Override // java.lang.Runnable
            public final void run() {
                ReadAloudService.b(this.f6310e, z10);
            }
        });
    }

    public final void g(t tVar) {
        this.f9993j.c(tVar);
        if (tVar.g()) {
            f(true);
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f9993j = new s(this);
        c cVarN = c.n(this);
        this.f9992e = cVarN;
        cVarN.b(this);
        AudioManager audioManager = (AudioManager) o.a.i(this, AudioManager.class);
        this.f9996m = audioManager;
        if (Build.VERSION.SDK_INT >= 23 && audioManager != null) {
            a aVar = new a();
            this.f9997n = aVar;
            this.f9996m.registerAudioDeviceCallback(aVar, null);
        }
        e(this.f9992e.e());
        d();
    }

    @Override // android.app.Service
    public void onDestroy() {
        AudioManager audioManager;
        AudioDeviceCallback audioDeviceCallback;
        if (Build.VERSION.SDK_INT >= 23 && (audioManager = this.f9996m) != null && (audioDeviceCallback = this.f9997n) != null) {
            audioManager.unregisterAudioDeviceCallback(audioDeviceCallback);
        }
        this.f9992e.d(this);
        super.onDestroy();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        super.onStartCommand(intent, i10, i11);
        String action = intent == null ? null : intent.getAction();
        if (action != null && this.f9992e != null) {
            pc.a.a("action: %s", action);
            switch (action) {
                case "mark.via.receiver.ReadAloudReceiver.PAUSE":
                    if (this.f9992e.h(intent.getStringExtra(Name.MARK))) {
                        f(false);
                        break;
                    }
                    break;
                case "mark.via.receiver.ReadAloudReceiver.PLAY":
                    t tVarF = this.f9992e.f(intent.getStringExtra(Name.MARK));
                    if (tVarF != null) {
                        int intExtra = intent.getIntExtra("index", -9999);
                        if (intExtra != -9999) {
                            tVarF.i(intExtra);
                        } else if (tVarF.g()) {
                            tVarF.i(0);
                        }
                        if (!tVarF.g() && this.f9992e.j(tVarF.b())) {
                            g(tVarF);
                            break;
                        }
                    }
                    break;
                case "mark.via.receiver.ReadAloudReceiver.STOP":
                    this.f9992e.c();
                    f(true);
                    break;
            }
        }
        return 1;
    }
}
