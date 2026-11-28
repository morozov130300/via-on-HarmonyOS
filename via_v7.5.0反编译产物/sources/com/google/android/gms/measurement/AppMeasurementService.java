package com.google.android.gms.measurement;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;
import g0.a;
import g2.k9;
import g2.l9;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class AppMeasurementService extends Service implements k9 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public l9 f3248c;

    private final l9 d() {
        if (this.f3248c == null) {
            this.f3248c = new l9(this);
        }
        return this.f3248c;
    }

    @Override // g2.k9
    public final boolean a(int i10) {
        return stopSelfResult(i10);
    }

    @Override // g2.k9
    public final void b(Intent intent) {
        a.b(intent);
    }

    @Override // g2.k9
    public final void c(JobParameters jobParameters, boolean z10) {
        throw new UnsupportedOperationException();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return d().b(intent);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        d().e();
    }

    @Override // android.app.Service
    public void onDestroy() {
        d().f();
        super.onDestroy();
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
        d().g(intent);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        d().a(intent, i10, i11);
        return 2;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        d().j(intent);
        return true;
    }
}
