package g2;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.PersistableBundle;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class z9 extends ba {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AlarmManager f5495d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public n f5496e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Integer f5497f;

    public z9(pa paVar) {
        super(paVar);
        this.f5495d = (AlarmManager) this.f4646a.c().getSystemService("alarm");
    }

    private final void r() {
        JobScheduler jobSchedulerA = l1.c.a(this.f4646a.c().getSystemService("jobscheduler"));
        if (jobSchedulerA != null) {
            jobSchedulerA.cancel(o());
        }
    }

    @Override // g2.ba
    public final boolean l() {
        AlarmManager alarmManager = this.f5495d;
        if (alarmManager != null) {
            alarmManager.cancel(p());
        }
        if (Build.VERSION.SDK_INT < 24) {
            return false;
        }
        r();
        return false;
    }

    public final void m() {
        i();
        this.f4646a.d().v().a("Unscheduling upload");
        AlarmManager alarmManager = this.f5495d;
        if (alarmManager != null) {
            alarmManager.cancel(p());
        }
        q().b();
        if (Build.VERSION.SDK_INT >= 24) {
            r();
        }
    }

    public final void n(long j10) {
        i();
        this.f4646a.b();
        Context contextC = this.f4646a.c();
        if (!wa.a0(contextC)) {
            this.f4646a.d().q().a("Receiver not registered/enabled");
        }
        if (!wa.b0(contextC, false)) {
            this.f4646a.d().q().a("Service not registered/enabled");
        }
        m();
        this.f4646a.d().v().b("Scheduling upload, millis", Long.valueOf(j10));
        long jB = this.f4646a.a().b() + j10;
        this.f4646a.z();
        if (j10 < Math.max(0L, ((Long) i3.f4961z.a(null)).longValue()) && !q().e()) {
            q().d(j10);
        }
        this.f4646a.b();
        if (Build.VERSION.SDK_INT < 24) {
            AlarmManager alarmManager = this.f5495d;
            if (alarmManager != null) {
                this.f4646a.z();
                alarmManager.setInexactRepeating(2, jB, Math.max(((Long) i3.f4951u.a(null)).longValue(), j10), p());
                return;
            }
            return;
        }
        Context contextC2 = this.f4646a.c();
        ComponentName componentName = new ComponentName(contextC2, "com.google.android.gms.measurement.AppMeasurementJobService");
        int iO = o();
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString("action", "com.google.android.gms.measurement.UPLOAD");
        com.google.android.gms.internal.measurement.x0.a(contextC2, new JobInfo.Builder(iO, componentName).setMinimumLatency(j10).setOverrideDeadline(j10 + j10).setExtras(persistableBundle).build(), "com.google.android.gms", "UploadAlarm");
    }

    public final int o() {
        if (this.f5497f == null) {
            this.f5497f = Integer.valueOf("measurement".concat(String.valueOf(this.f4646a.c().getPackageName())).hashCode());
        }
        return this.f5497f.intValue();
    }

    public final PendingIntent p() {
        Context contextC = this.f4646a.c();
        return PendingIntent.getBroadcast(contextC, 0, new Intent().setClassName(contextC, "com.google.android.gms.measurement.AppMeasurementReceiver").setAction("com.google.android.gms.measurement.UPLOAD"), com.google.android.gms.internal.measurement.u0.f3105a);
    }

    public final n q() {
        if (this.f5496e == null) {
            this.f5496e = new w9(this, this.f4655b.b0());
        }
        return this.f5496e;
    }
}
