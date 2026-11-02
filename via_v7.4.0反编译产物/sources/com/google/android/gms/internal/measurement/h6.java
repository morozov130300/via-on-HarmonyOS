package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.StrictMode;
import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class h6 {

    /* renamed from: a, reason: collision with root package name */
    public static volatile zzii f3528a;

    /* JADX WARN: Removed duplicated region for block: B:18:0x0030 A[Catch: all -> 0x001c, TryCatch #5 {all -> 0x001c, all -> 0x0067, blocks: (B:4:0x0003, B:6:0x0007, B:8:0x0013, B:18:0x0030, B:75:0x0178, B:13:0x001f, B:15:0x0027, B:20:0x0037, B:22:0x003d, B:24:0x0043, B:25:0x0047, B:74:0x0173, B:76:0x017b, B:77:0x017e, B:78:0x017f, B:26:0x004b, B:28:0x004f, B:29:0x005c, B:31:0x0062, B:37:0x007b, B:39:0x0081, B:40:0x0085, B:61:0x0144, B:62:0x0147, B:70:0x0168, B:69:0x0153, B:71:0x0169, B:72:0x016e, B:73:0x016f, B:34:0x006a, B:36:0x0070), top: B:94:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static zzii a(Context context) {
        zzii zziiVar;
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads;
        zzii zziiVarZzc;
        zzii zziiVarZzc2;
        synchronized (h6.class) {
            try {
                zziiVar = f3528a;
                if (zziiVar == null) {
                    String str = Build.TYPE;
                    String str2 = Build.TAGS;
                    if (str.equals("eng") || str.equals("userdebug")) {
                        if (str2.contains("dev-keys") || str2.contains("test-keys")) {
                            if (u5.b() && !context.isDeviceProtectedStorage()) {
                                context = context.createDeviceProtectedStorageContext();
                            }
                            threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
                            StrictMode.allowThreadDiskWrites();
                            try {
                                File file = new File(context.getDir("phenotype_hermetic", 0), "overrides.txt");
                                zziiVarZzc = file.exists() ? zzii.zzd(file) : zzii.zzc();
                            } catch (RuntimeException e10) {
                                Log.e("HermeticFileOverrides", "no data dir", e10);
                                zziiVarZzc = zzii.zzc();
                            }
                            if (zziiVarZzc.zzb()) {
                                Object objZza = zziiVarZzc.zza();
                                try {
                                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream((File) objZza)));
                                    try {
                                        k.g gVar = new k.g();
                                        HashMap map = new HashMap();
                                        while (true) {
                                            String line = bufferedReader.readLine();
                                            if (line == null) {
                                                break;
                                            }
                                            String[] strArrSplit = line.split(" ", 3);
                                            if (strArrSplit.length != 3) {
                                                Log.e("HermeticFileOverrides", "Invalid: " + line);
                                            } else {
                                                String str3 = new String(strArrSplit[0]);
                                                String strDecode = Uri.decode(new String(strArrSplit[1]));
                                                String strDecode2 = (String) map.get(strArrSplit[2]);
                                                if (strDecode2 == null) {
                                                    String str4 = new String(strArrSplit[2]);
                                                    strDecode2 = Uri.decode(str4);
                                                    if (strDecode2.length() < 1024 || strDecode2 == str4) {
                                                        map.put(str4, strDecode2);
                                                    }
                                                }
                                                if (!gVar.containsKey(str3)) {
                                                    gVar.put(str3, new k.g());
                                                }
                                                ((k.g) gVar.get(str3)).put(strDecode, strDecode2);
                                            }
                                        }
                                        Log.w("HermeticFileOverrides", "Parsed " + objZza.toString() + " for Android package " + context.getPackageName());
                                        z5 z5Var = new z5(gVar);
                                        bufferedReader.close();
                                        zziiVarZzc2 = zzii.zzd(z5Var);
                                    } finally {
                                        try {
                                            bufferedReader.close();
                                        } catch (Throwable th) {
                                            try {
                                                Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th);
                                            } catch (Exception unused) {
                                            }
                                        }
                                    }
                                } catch (IOException e11) {
                                    throw new RuntimeException(e11);
                                }
                            } else {
                                zziiVarZzc2 = zzii.zzc();
                            }
                            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                        } else {
                            zziiVarZzc2 = zzii.zzc();
                        }
                        zziiVar = zziiVarZzc2;
                        f3528a = zziiVar;
                    }
                }
            } catch (Throwable th2) {
                StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                throw th2;
            } finally {
            }
        }
        return zziiVar;
    }
}
