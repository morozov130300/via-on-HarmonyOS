package k1;

import android.content.Context;
import android.os.Build;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import l1.l;
import l1.m0;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class h {
    public static m0 a(Context context, m1.d dVar, SchedulerConfig schedulerConfig, o1.a aVar) {
        return Build.VERSION.SDK_INT >= 21 ? new l(context, dVar, schedulerConfig) : new l1.a(context, dVar, aVar, schedulerConfig);
    }
}
