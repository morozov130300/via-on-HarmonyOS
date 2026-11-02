package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.os.UserManager;
import android.util.Log;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class u5 {

    /* renamed from: a, reason: collision with root package name */
    public static UserManager f3821a;

    /* renamed from: b, reason: collision with root package name */
    public static volatile boolean f3822b = !b();

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0041, code lost:
    
        r8 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0054 A[Catch: all -> 0x0015, TryCatch #0 {all -> 0x0015, NullPointerException -> 0x0045, blocks: (B:9:0x000f, B:11:0x0013, B:18:0x001d, B:20:0x0021, B:21:0x002b, B:35:0x0058, B:36:0x005a, B:24:0x0031, B:26:0x0037, B:33:0x0054, B:31:0x0046), top: B:42:0x000f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(Context context) {
        int i10;
        boolean z10;
        if (b() && !f3822b) {
            synchronized (u5.class) {
                try {
                    if (!f3822b) {
                        i10 = 1;
                        while (true) {
                            if (i10 <= 2) {
                                if (f3821a == null) {
                                    f3821a = (UserManager) context.getSystemService(UserManager.class);
                                }
                                UserManager userManager = f3821a;
                                if (userManager != null) {
                                    if (userManager.isUserUnlocked()) {
                                        break;
                                    }
                                    if (!userManager.isUserRunning(Process.myUserHandle())) {
                                        break;
                                    }
                                    if (z10) {
                                        f3821a = null;
                                    }
                                } else {
                                    z10 = true;
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                        z10 = false;
                        if (z10) {
                        }
                        if (z10) {
                            f3822b = true;
                        }
                        if (!z10) {
                            return true;
                        }
                    }
                } catch (NullPointerException e10) {
                    Log.w("DirectBootUtils", "Failed to check if user is unlocked.", e10);
                    f3821a = null;
                    i10++;
                } finally {
                }
            }
        }
        return false;
    }

    public static boolean b() {
        return Build.VERSION.SDK_INT >= 24;
    }
}
