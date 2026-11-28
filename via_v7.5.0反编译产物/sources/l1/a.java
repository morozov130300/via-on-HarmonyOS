package l1;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.util.Base64;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.AlarmManagerSchedulerBroadcastReceiver;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class a implements m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f7393a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m1.d f7394b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AlarmManager f7395c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SchedulerConfig f7396d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final o1.a f7397e;

    public a(Context context, m1.d dVar, o1.a aVar, SchedulerConfig schedulerConfig) {
        this(context, dVar, (AlarmManager) context.getSystemService("alarm"), aVar, schedulerConfig);
    }

    @Override // l1.m0
    public void a(e1.p pVar, int i10) {
        b(pVar, i10, false);
    }

    @Override // l1.m0
    public void b(e1.p pVar, int i10, boolean z10) {
        Uri.Builder builder = new Uri.Builder();
        builder.appendQueryParameter("backendName", pVar.b());
        builder.appendQueryParameter("priority", String.valueOf(p1.a.a(pVar.d())));
        if (pVar.c() != null) {
            builder.appendQueryParameter("extras", Base64.encodeToString(pVar.c(), 0));
        }
        Intent intent = new Intent(this.f7393a, (Class<?>) AlarmManagerSchedulerBroadcastReceiver.class);
        intent.setData(builder.build());
        intent.putExtra("attemptNumber", i10);
        if (!z10 && c(intent)) {
            i1.a.b("AlarmManagerScheduler", "Upload for context %s is already scheduled. Returning...", pVar);
            return;
        }
        long jZ = this.f7394b.z(pVar);
        long jG = this.f7396d.g(pVar.d(), jZ, i10);
        i1.a.c("AlarmManagerScheduler", "Scheduling upload for context %s in %dms(Backend next call timestamp %d). Attempt %d", pVar, Long.valueOf(jG), Long.valueOf(jZ), Integer.valueOf(i10));
        this.f7395c.set(3, this.f7397e.a() + jG, PendingIntent.getBroadcast(this.f7393a, 0, intent, Build.VERSION.SDK_INT >= 23 ? 67108864 : 0));
    }

    public boolean c(Intent intent) {
        return PendingIntent.getBroadcast(this.f7393a, 0, intent, Build.VERSION.SDK_INT >= 23 ? 603979776 : 536870912) != null;
    }

    public a(Context context, m1.d dVar, AlarmManager alarmManager, o1.a aVar, SchedulerConfig schedulerConfig) {
        this.f7393a = context;
        this.f7394b = dVar;
        this.f7395c = alarmManager;
        this.f7397e = aVar;
        this.f7396d = schedulerConfig;
    }
}
