package com.google.android.gms.measurement;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import f2.k9;
import f2.l9;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
@TargetApi(24)
/* loaded from: classes.dex */
public final class AppMeasurementJobService extends JobService implements k9 {

    /* renamed from: e, reason: collision with root package name */
    public l9 f3947e;

    @Override // f2.k9
    public final boolean a(int i10) {
        throw new UnsupportedOperationException();
    }

    @Override // f2.k9
    public final void b(Intent intent) {
    }

    @Override // f2.k9
    public final void c(JobParameters jobParameters, boolean z10) {
        jobFinished(jobParameters, false);
    }

    public final l9 d() {
        if (this.f3947e == null) {
            this.f3947e = new l9(this);
        }
        return this.f3947e;
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

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        d().i(jobParameters);
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        d().j(intent);
        return true;
    }
}
