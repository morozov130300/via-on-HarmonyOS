package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.os.UserManager;
import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class u5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static UserManager f3120a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f3121b = !b();

    /* JADX WARN: Code duplicated, block: B:33:0x0054 A[Catch: all -> 0x0015, TryCatch #0 {all -> 0x0015, blocks: (B:9:0x000f, B:11:0x0013, B:18:0x001d, B:20:0x0021, B:21:0x002b, B:35:0x0058, B:36:0x005a, B:24:0x0031, B:26:0x0037, B:33:0x0054, B:31:0x0046), top: B:42:0x000f, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:35:0x0058 A[Catch: all -> 0x0015, TryCatch #0 {all -> 0x0015, blocks: (B:9:0x000f, B:11:0x0013, B:18:0x001d, B:20:0x0021, B:21:0x002b, B:35:0x0058, B:36:0x005a, B:24:0x0031, B:26:0x0037, B:33:0x0054, B:31:0x0046), top: B:42:0x000f, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:38:0x005d A[RETURN] */
    public static boolean a(Context context) {
        boolean z10;
        if (b() && !f3121b) {
            synchronized (u5.class) {
                try {
                    if (!f3121b) {
                        int i10 = 1;
                        while (true) {
                            if (i10 <= 2) {
                                if (f3120a == null) {
                                    f3120a = (UserManager) context.getSystemService(UserManager.class);
                                }
                                UserManager userManager = f3120a;
                                if (userManager == null) {
                                    z10 = true;
                                } else {
                                    try {
                                        z10 = userManager.isUserUnlocked() || !userManager.isUserRunning(Process.myUserHandle());
                                        if (z10) {
                                            f3120a = null;
                                        }
                                    } catch (NullPointerException e10) {
                                        Log.w("DirectBootUtils", "Failed to check if user is unlocked.", e10);
                                        f3120a = null;
                                        i10++;
                                    }
                                }
                                if (z10) {
                                    f3121b = true;
                                }
                                if (!z10) {
                                    return true;
                                }
                            }
                            if (z10) {
                                f3120a = null;
                            }
                            if (z10) {
                                f3121b = true;
                            }
                            if (!z10) {
                                return true;
                            }
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return false;
    }

    public static boolean b() {
        return Build.VERSION.SDK_INT >= 24;
    }
}
