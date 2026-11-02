package k1;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.PersistableBundle;
import android.util.Base64;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.zip.Adler32;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class l implements m0 {

    /* renamed from: a, reason: collision with root package name */
    public final Context f8089a;

    /* renamed from: b, reason: collision with root package name */
    public final l1.d f8090b;

    /* renamed from: c, reason: collision with root package name */
    public final SchedulerConfig f8091c;

    public l(Context context, l1.d dVar, SchedulerConfig schedulerConfig) {
        this.f8089a = context;
        this.f8090b = dVar;
        this.f8091c = schedulerConfig;
    }

    @Override // k1.m0
    public void a(d1.p pVar, int i10, boolean z10) {
        ComponentName componentName = new ComponentName(this.f8089a, (Class<?>) JobInfoSchedulerService.class);
        JobScheduler jobSchedulerA = c.a(this.f8089a.getSystemService("jobscheduler"));
        int iC = c(pVar);
        if (!z10 && d(jobSchedulerA, iC, i10)) {
            h1.a.b("JobInfoScheduler", "Upload for context %s is already scheduled. Returning...", pVar);
            return;
        }
        long jT = this.f8090b.T(pVar);
        JobInfo.Builder builderC = this.f8091c.c(new JobInfo.Builder(iC, componentName), pVar.d(), jT, i10);
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putInt("attemptNumber", i10);
        persistableBundle.putString("backendName", pVar.b());
        persistableBundle.putInt("priority", o1.a.a(pVar.d()));
        if (pVar.c() != null) {
            persistableBundle.putString("extras", Base64.encodeToString(pVar.c(), 0));
        }
        builderC.setExtras(persistableBundle);
        h1.a.c("JobInfoScheduler", "Scheduling upload for context %s with jobId=%d in %dms(Backend next call timestamp %d). Attempt %d", pVar, Integer.valueOf(iC), Long.valueOf(this.f8091c.g(pVar.d(), jT, i10)), Long.valueOf(jT), Integer.valueOf(i10));
        jobSchedulerA.schedule(builderC.build());
    }

    @Override // k1.m0
    public void b(d1.p pVar, int i10) {
        a(pVar, i10, false);
    }

    public int c(d1.p pVar) {
        Adler32 adler32 = new Adler32();
        adler32.update(this.f8089a.getPackageName().getBytes(Charset.forName("UTF-8")));
        adler32.update(pVar.b().getBytes(Charset.forName("UTF-8")));
        adler32.update(ByteBuffer.allocate(4).putInt(o1.a.a(pVar.d())).array());
        if (pVar.c() != null) {
            adler32.update(pVar.c());
        }
        return (int) adler32.getValue();
    }

    public final boolean d(JobScheduler jobScheduler, int i10, int i11) {
        Iterator it = jobScheduler.getAllPendingJobs().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            JobInfo jobInfoA = h.a(it.next());
            int i12 = jobInfoA.getExtras().getInt("attemptNumber");
            if (jobInfoA.getId() == i10) {
                if (i12 >= i11) {
                    return true;
                }
            }
        }
        return false;
    }
}
