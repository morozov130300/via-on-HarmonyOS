package j1;

import android.content.Context;
import android.os.Build;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import k1.l;
import k1.m0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class h {
    public static m0 a(Context context, l1.d dVar, SchedulerConfig schedulerConfig, n1.a aVar) {
        return Build.VERSION.SDK_INT >= 21 ? new l(context, dVar, schedulerConfig) : new k1.a(context, dVar, aVar, schedulerConfig);
    }
}
