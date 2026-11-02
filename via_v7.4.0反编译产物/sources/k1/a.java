package k1;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.util.Base64;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.AlarmManagerSchedulerBroadcastReceiver;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class a implements m0 {

    /* renamed from: a, reason: collision with root package name */
    public final Context f8046a;

    /* renamed from: b, reason: collision with root package name */
    public final l1.d f8047b;

    /* renamed from: c, reason: collision with root package name */
    public AlarmManager f8048c;

    /* renamed from: d, reason: collision with root package name */
    public final SchedulerConfig f8049d;

    /* renamed from: e, reason: collision with root package name */
    public final n1.a f8050e;

    public a(Context context, l1.d dVar, AlarmManager alarmManager, n1.a aVar, SchedulerConfig schedulerConfig) {
        this.f8046a = context;
        this.f8047b = dVar;
        this.f8048c = alarmManager;
        this.f8050e = aVar;
        this.f8049d = schedulerConfig;
    }

    public a(Context context, l1.d dVar, n1.a aVar, SchedulerConfig schedulerConfig) {
        this(context, dVar, (AlarmManager) context.getSystemService("alarm"), aVar, schedulerConfig);
    }

    @Override // k1.m0
    public void a(d1.p pVar, int i10, boolean z10) {
        Uri.Builder builder = new Uri.Builder();
        builder.appendQueryParameter("backendName", pVar.b());
        builder.appendQueryParameter("priority", String.valueOf(o1.a.a(pVar.d())));
        if (pVar.c() != null) {
            builder.appendQueryParameter("extras", Base64.encodeToString(pVar.c(), 0));
        }
        Intent intent = new Intent(this.f8046a, (Class<?>) AlarmManagerSchedulerBroadcastReceiver.class);
        intent.setData(builder.build());
        intent.putExtra("attemptNumber", i10);
        if (!z10 && c(intent)) {
            h1.a.b("AlarmManagerScheduler", "Upload for context %s is already scheduled. Returning...", pVar);
            return;
        }
        long jT = this.f8047b.T(pVar);
        long jG = this.f8049d.g(pVar.d(), jT, i10);
        h1.a.c("AlarmManagerScheduler", "Scheduling upload for context %s in %dms(Backend next call timestamp %d). Attempt %d", pVar, Long.valueOf(jG), Long.valueOf(jT), Integer.valueOf(i10));
        this.f8048c.set(3, this.f8050e.a() + jG, PendingIntent.getBroadcast(this.f8046a, 0, intent, Build.VERSION.SDK_INT >= 23 ? 67108864 : 0));
    }

    @Override // k1.m0
    public void b(d1.p pVar, int i10) {
        a(pVar, i10, false);
    }

    public boolean c(Intent intent) {
        return PendingIntent.getBroadcast(this.f8046a, 0, intent, Build.VERSION.SDK_INT >= 23 ? 603979776 : 536870912) != null;
    }
}
