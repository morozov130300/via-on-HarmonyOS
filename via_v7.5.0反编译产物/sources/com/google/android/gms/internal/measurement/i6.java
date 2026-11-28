package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.os.Build;
import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class i6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile zzii f2853a = zzii.zzc();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f2854b = new Object();

    /* JADX WARN: Code duplicated, block: B:29:0x0079 A[Catch: all -> 0x004b, TRY_LEAVE, TryCatch #1 {all -> 0x004b, blocks: (B:12:0x0035, B:14:0x003d, B:15:0x0049, B:19:0x004d, B:21:0x0059, B:25:0x0069, B:27:0x006f, B:34:0x008a, B:35:0x0094, B:29:0x0079, B:30:0x007d, B:31:0x0083), top: B:43:0x0035 }] */
    /* JADX WARN: Code duplicated, block: B:33:0x0089  */
    public static boolean a(Context context, Uri uri) {
        String authority = uri.getAuthority();
        boolean z10 = false;
        if (!"com.google.android.gms.phenotype".equals(authority)) {
            Log.e("PhenotypeClientHelper", String.valueOf(authority).concat(" is an unsupported authority. Only com.google.android.gms.phenotype authority is supported."));
            return false;
        }
        if (f2853a.zzb()) {
            return ((Boolean) f2853a.zza()).booleanValue();
        }
        synchronized (f2854b) {
            try {
                if (f2853a.zzb()) {
                    return ((Boolean) f2853a.zza()).booleanValue();
                }
                if (!"com.google.android.gms".equals(context.getPackageName())) {
                    ProviderInfo providerInfoResolveContentProvider = context.getPackageManager().resolveContentProvider("com.google.android.gms.phenotype", Build.VERSION.SDK_INT < 29 ? 0 : 268435456);
                    if (providerInfoResolveContentProvider != null && "com.google.android.gms".equals(providerInfoResolveContentProvider.packageName)) {
                        try {
                            if ((context.getPackageManager().getApplicationInfo("com.google.android.gms", 0).flags & 129) != 0) {
                                z10 = true;
                            }
                        } catch (PackageManager.NameNotFoundException unused) {
                        }
                    }
                } else if ((context.getPackageManager().getApplicationInfo("com.google.android.gms", 0).flags & 129) != 0) {
                    z10 = true;
                }
                f2853a = zzii.zzd(Boolean.valueOf(z10));
                return ((Boolean) f2853a.zza()).booleanValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
