package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Base64;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;
import d1.p;
import d1.t;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class JobInfoSchedulerService extends JobService {
    public static /* synthetic */ void a(JobInfoSchedulerService jobInfoSchedulerService, JobParameters jobParameters) {
        jobInfoSchedulerService.getClass();
        jobInfoSchedulerService.jobFinished(jobParameters, false);
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(final JobParameters jobParameters) {
        String string = jobParameters.getExtras().getString("backendName");
        String string2 = jobParameters.getExtras().getString("extras");
        int i10 = jobParameters.getExtras().getInt("priority");
        int i11 = jobParameters.getExtras().getInt("attemptNumber");
        t.f(getApplicationContext());
        p.a aVarD = p.a().b(string).d(o1.a.b(i10));
        if (string2 != null) {
            aVarD.c(Base64.decode(string2, 0));
        }
        t.c().e().m(aVarD.a(), i11, new Runnable() { // from class: k1.q
            @Override // java.lang.Runnable
            public final void run() {
                JobInfoSchedulerService.a(this.f8096e, jobParameters);
            }
        });
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}
