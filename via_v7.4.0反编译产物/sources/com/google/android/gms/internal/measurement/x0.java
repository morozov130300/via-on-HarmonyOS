package com.google.android.gms.internal.measurement;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.Context;
import android.os.Build;
import android.os.UserHandle;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class x0 {

    /* renamed from: a, reason: collision with root package name */
    public static final Method f3877a;

    /* renamed from: b, reason: collision with root package name */
    public static final Method f3878b;

    static {
        Method declaredMethod;
        Method declaredMethod2 = null;
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                declaredMethod = o.e.a().getDeclaredMethod("scheduleAsPackage", w0.a(), String.class, Integer.TYPE, String.class);
            } catch (NoSuchMethodException unused) {
                if (Log.isLoggable("JobSchedulerCompat", 6)) {
                    Log.e("JobSchedulerCompat", "No scheduleAsPackage method available, falling back to schedule");
                }
            }
        } else {
            declaredMethod = null;
        }
        f3877a = declaredMethod;
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                declaredMethod2 = UserHandle.class.getDeclaredMethod("myUserId", null);
            } catch (NoSuchMethodException unused2) {
                if (Log.isLoggable("JobSchedulerCompat", 6)) {
                    Log.e("JobSchedulerCompat", "No myUserId method available");
                }
            }
        }
        f3878b = declaredMethod2;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int a(Context context, JobInfo jobInfo, String str, String str2) {
        Integer num;
        int iIntValue;
        JobScheduler jobSchedulerA = k1.c.a(context.getSystemService("jobscheduler"));
        jobSchedulerA.getClass();
        if (f3877a == null || context.checkSelfPermission("android.permission.UPDATE_DEVICE_STATS") != 0) {
            return jobSchedulerA.schedule(jobInfo);
        }
        Method method = f3878b;
        if (method != null) {
            try {
                num = (Integer) method.invoke(UserHandle.class, null);
            } catch (IllegalAccessException | InvocationTargetException e10) {
                if (Log.isLoggable("JobSchedulerCompat", 6)) {
                    Log.e("JobSchedulerCompat", "myUserId invocation illegal", e10);
                }
            }
            iIntValue = num != null ? num.intValue() : 0;
        }
        Method method2 = f3877a;
        if (method2 != null) {
            try {
                Integer num2 = (Integer) method2.invoke(jobSchedulerA, jobInfo, "com.google.android.gms", Integer.valueOf(iIntValue), "UploadAlarm");
                if (num2 != null) {
                    return num2.intValue();
                }
                return 0;
            } catch (IllegalAccessException | InvocationTargetException e11) {
                Log.e("UploadAlarm", "error calling scheduleAsPackage", e11);
            }
        }
        return jobSchedulerA.schedule(jobInfo);
    }
}
