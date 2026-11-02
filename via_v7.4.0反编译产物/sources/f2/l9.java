package f2;

import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class l9 {

    /* renamed from: a, reason: collision with root package name */
    public final Context f5460a;

    public l9(Context context) {
        t1.f.h(context);
        this.f5460a = context;
    }

    public final int a(final Intent intent, int i10, final int i11) {
        h5 h5VarH = h5.H(this.f5460a, null, null);
        final v3 v3VarD = h5VarH.d();
        if (intent == null) {
            v3VarD.w().a("AppMeasurementService started with null intent");
            return 2;
        }
        String action = intent.getAction();
        h5VarH.b();
        v3VarD.v().c("Local AppMeasurementService called. startId, action", Integer.valueOf(i11), action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            h(new Runnable() { // from class: f2.i9
                @Override // java.lang.Runnable
                public final void run() {
                    this.f5357e.c(i11, v3VarD, intent);
                }
            });
        }
        return 2;
    }

    public final IBinder b(Intent intent) {
        if (intent == null) {
            k().r().a("onBind called with null intent");
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new z5(pa.f0(this.f5460a), null);
        }
        k().w().b("onBind received unknown action", action);
        return null;
    }

    public final /* synthetic */ void c(int i10, v3 v3Var, Intent intent) {
        if (((k9) this.f5460a).a(i10)) {
            v3Var.v().b("Local AppMeasurementService processed last upload request. StartId", Integer.valueOf(i10));
            k().v().a("Completed wakeful intent.");
            ((k9) this.f5460a).b(intent);
        }
    }

    public final /* synthetic */ void d(v3 v3Var, JobParameters jobParameters) {
        v3Var.v().a("AppMeasurementJobService processed last upload request.");
        ((k9) this.f5460a).c(jobParameters, false);
    }

    public final void e() {
        h5 h5VarH = h5.H(this.f5460a, null, null);
        v3 v3VarD = h5VarH.d();
        h5VarH.b();
        v3VarD.v().a("Local AppMeasurementService is starting up");
    }

    public final void f() {
        h5 h5VarH = h5.H(this.f5460a, null, null);
        v3 v3VarD = h5VarH.d();
        h5VarH.b();
        v3VarD.v().a("Local AppMeasurementService is shutting down");
    }

    public final void g(Intent intent) {
        if (intent == null) {
            k().r().a("onRebind called with null intent");
        } else {
            k().v().b("onRebind called. action", intent.getAction());
        }
    }

    public final void h(Runnable runnable) {
        pa paVarF0 = pa.f0(this.f5460a);
        paVarF0.f().z(new j9(this, paVarF0, runnable));
    }

    public final boolean i(final JobParameters jobParameters) {
        h5 h5VarH = h5.H(this.f5460a, null, null);
        final v3 v3VarD = h5VarH.d();
        String string = jobParameters.getExtras().getString("action");
        h5VarH.b();
        v3VarD.v().b("Local AppMeasurementJobService called. action", string);
        if (!"com.google.android.gms.measurement.UPLOAD".equals(string)) {
            return true;
        }
        h(new Runnable() { // from class: f2.h9
            @Override // java.lang.Runnable
            public final void run() {
                this.f5280e.d(v3VarD, jobParameters);
            }
        });
        return true;
    }

    public final boolean j(Intent intent) {
        if (intent == null) {
            k().r().a("onUnbind called with null intent");
            return true;
        }
        k().v().b("onUnbind called for intent. action", intent.getAction());
        return true;
    }

    public final v3 k() {
        return h5.H(this.f5460a, null, null).d();
    }
}
