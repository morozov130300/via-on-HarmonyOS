package l1;

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

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class l implements m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f7436a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m1.d f7437b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SchedulerConfig f7438c;

    public l(Context context, m1.d dVar, SchedulerConfig schedulerConfig) {
        this.f7436a = context;
        this.f7437b = dVar;
        this.f7438c = schedulerConfig;
    }

    @Override // l1.m0
    public void a(e1.p pVar, int i10) {
        b(pVar, i10, false);
    }

    @Override // l1.m0
    public void b(e1.p pVar, int i10, boolean z10) {
        ComponentName componentName = new ComponentName(this.f7436a, (Class<?>) JobInfoSchedulerService.class);
        JobScheduler jobSchedulerA = c.a(this.f7436a.getSystemService("jobscheduler"));
        int iC = c(pVar);
        if (!z10 && d(jobSchedulerA, iC, i10)) {
            i1.a.b("JobInfoScheduler", "Upload for context %s is already scheduled. Returning...", pVar);
            return;
        }
        long jZ = this.f7437b.z(pVar);
        JobInfo.Builder builderC = this.f7438c.c(new JobInfo.Builder(iC, componentName), pVar.d(), jZ, i10);
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putInt("attemptNumber", i10);
        persistableBundle.putString("backendName", pVar.b());
        persistableBundle.putInt("priority", p1.a.a(pVar.d()));
        if (pVar.c() != null) {
            persistableBundle.putString("extras", Base64.encodeToString(pVar.c(), 0));
        }
        builderC.setExtras(persistableBundle);
        i1.a.c("JobInfoScheduler", "Scheduling upload for context %s with jobId=%d in %dms(Backend next call timestamp %d). Attempt %d", pVar, Integer.valueOf(iC), Long.valueOf(this.f7438c.g(pVar.d(), jZ, i10)), Long.valueOf(jZ), Integer.valueOf(i10));
        jobSchedulerA.schedule(builderC.build());
    }

    public int c(e1.p pVar) {
        Adler32 adler32 = new Adler32();
        adler32.update(this.f7436a.getPackageName().getBytes(Charset.forName("UTF-8")));
        adler32.update(pVar.b().getBytes(Charset.forName("UTF-8")));
        adler32.update(ByteBuffer.allocate(4).putInt(p1.a.a(pVar.d())).array());
        if (pVar.c() != null) {
            adler32.update(pVar.c());
        }
        return (int) adler32.getValue();
    }

    public final boolean d(JobScheduler jobScheduler, int i10, int i11) {
        Iterator it = jobScheduler.getAllPendingJobs().iterator();
        while (it.hasNext()) {
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
