package com.google.firebase.crashlytics.internal.common;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Debug;
import android.os.StatFs;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;
import q2.f;
import t2.e;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class CommonUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f3310a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f3311b = -1;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public enum Architecture {
        X86_32,
        X86_64,
        ARM_UNKNOWN,
        PPC,
        PPC64,
        ARMV6,
        ARMV7,
        UNKNOWN,
        ARMV7S,
        ARM64;


        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Map f3312c;

        static {
            Architecture architecture = X86_32;
            Architecture architecture2 = ARMV6;
            Architecture architecture3 = ARMV7;
            Architecture architecture4 = ARM64;
            HashMap map = new HashMap(4);
            f3312c = map;
            map.put("armeabi-v7a", architecture3);
            map.put("armeabi", architecture2);
            map.put("arm64-v8a", architecture4);
            map.put("x86", architecture);
        }

        public static Architecture getValue() {
            String str = Build.CPU_ABI;
            if (TextUtils.isEmpty(str)) {
                f.f().i("Architecture#getValue()::Build.CPU_ABI returned null or empty");
                return UNKNOWN;
            }
            Architecture architecture = (Architecture) f3312c.get(str.toLowerCase(Locale.US));
            return architecture == null ? UNKNOWN : architecture;
        }
    }

    public static boolean A() {
        boolean z10 = z();
        String str = Build.TAGS;
        if ((z10 || str == null || !str.contains("test-keys")) && !new File("/system/app/Superuser.apk").exists()) {
            return !z10 && new File("/system/xbin/su").exists();
        }
        return true;
    }

    public static boolean B(String str, String str2) {
        if (str == null) {
            return str2 == null;
        }
        return str.equals(str2);
    }

    public static String C(String str) {
        return u(str, "SHA-1");
    }

    public static String D(InputStream inputStream) {
        Scanner scannerUseDelimiter = new Scanner(inputStream).useDelimiter("\\A");
        return scannerUseDelimiter.hasNext() ? scannerUseDelimiter.next() : "";
    }

    public static long a(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    public static long b(String str) {
        StatFs statFs = new StatFs(str);
        long blockSize = statFs.getBlockSize();
        return (((long) statFs.getBlockCount()) * blockSize) - (blockSize * ((long) statFs.getAvailableBlocks()));
    }

    public static boolean c(Context context) {
        if (!d(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return true;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    public static boolean d(Context context, String str) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }

    public static void e(Closeable closeable, String str) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e10) {
                f.f().e(str, e10);
            }
        }
    }

    public static void f(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e10) {
                throw e10;
            } catch (Exception unused) {
            }
        }
    }

    public static long g(String str, String str2, int i10) {
        return Long.parseLong(str.split(str2)[0].trim()) * ((long) i10);
    }

    public static String h(String... strArr) {
        if (strArr != null && strArr.length != 0) {
            ArrayList arrayList = new ArrayList();
            for (String str : strArr) {
                if (str != null) {
                    arrayList.add(str.replace("-", "").toLowerCase(Locale.US));
                }
            }
            Collections.sort(arrayList);
            StringBuilder sb2 = new StringBuilder();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                sb2.append((String) it.next());
            }
            String string = sb2.toString();
            if (string.length() > 0) {
                return C(string);
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.Closeable] */
    public static String i(File file, String str) throws Throwable {
        BufferedReader bufferedReader;
        ?? Exists = file.exists();
        ?? r10 = 0;
        String str2 = null;
        try {
            if (Exists != 0) {
                try {
                    bufferedReader = new BufferedReader(new FileReader(file), 1024);
                    while (true) {
                        try {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                break;
                            }
                            String[] strArrSplit = Pattern.compile("\\s*:\\s*").split(line, 2);
                            if (strArrSplit.length > 1 && strArrSplit[0].equals(str)) {
                                str2 = strArrSplit[1];
                                break;
                            }
                        } catch (Exception e10) {
                            e = e10;
                            f.f().e("Error parsing " + file, e);
                            e(bufferedReader, "Failed to close system file reader.");
                            return null;
                        }
                    }
                    e(bufferedReader, "Failed to close system file reader.");
                    return str2;
                } catch (Exception e11) {
                    e = e11;
                    bufferedReader = null;
                } catch (Throwable th) {
                    th = th;
                    e(r10, "Failed to close system file reader.");
                    throw th;
                }
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            r10 = Exists;
        }
    }

    public static ActivityManager.RunningAppProcessInfo j(String str, Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.processName.equals(str)) {
                return runningAppProcessInfo;
            }
        }
        return null;
    }

    public static boolean k(Context context, String str, boolean z10) {
        Resources resources;
        if (context != null && (resources = context.getResources()) != null) {
            int iR = r(context, str, "bool");
            if (iR > 0) {
                return resources.getBoolean(iR);
            }
            int iR2 = r(context, str, "string");
            if (iR2 > 0) {
                return Boolean.parseBoolean(context.getString(iR2));
            }
        }
        return z10;
    }

    public static List l(Context context) {
        ArrayList arrayList = new ArrayList();
        int iR = r(context, "com.google.firebase.crashlytics.build_ids_lib", "array");
        int iR2 = r(context, "com.google.firebase.crashlytics.build_ids_arch", "array");
        int iR3 = r(context, "com.google.firebase.crashlytics.build_ids_build_id", "array");
        if (iR == 0 || iR2 == 0 || iR3 == 0) {
            f.f().b(String.format("Could not find resources: %d %d %d", Integer.valueOf(iR), Integer.valueOf(iR2), Integer.valueOf(iR3)));
            return arrayList;
        }
        String[] stringArray = context.getResources().getStringArray(iR);
        String[] stringArray2 = context.getResources().getStringArray(iR2);
        String[] stringArray3 = context.getResources().getStringArray(iR3);
        if (stringArray.length != stringArray3.length || stringArray2.length != stringArray3.length) {
            f.f().b(String.format("Lengths did not match: %d %d %d", Integer.valueOf(stringArray.length), Integer.valueOf(stringArray2.length), Integer.valueOf(stringArray3.length)));
            return arrayList;
        }
        for (int i10 = 0; i10 < stringArray3.length; i10++) {
            arrayList.add(new e(stringArray[i10], stringArray2[i10], stringArray3[i10]));
        }
        return arrayList;
    }

    public static int m() {
        return Architecture.getValue().ordinal();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    public static int n() {
        boolean z10 = z();
        ?? r10 = z10;
        if (A()) {
            r10 = (z10 ? 1 : 0) | 2;
        }
        return y() ? r10 | 4 : r10;
    }

    public static String o(Context context) {
        int iR = r(context, "com.google.firebase.crashlytics.mapping_file_id", "string");
        if (iR == 0) {
            iR = r(context, "com.crashlytics.android.build_id", "string");
        }
        if (iR != 0) {
            return context.getResources().getString(iR);
        }
        return null;
    }

    public static boolean p(Context context) {
        return (z() || ((SensorManager) context.getSystemService("sensor")).getDefaultSensor(8) == null) ? false : true;
    }

    public static String q(Context context) {
        int i10 = context.getApplicationContext().getApplicationInfo().icon;
        if (i10 <= 0) {
            return context.getPackageName();
        }
        try {
            String resourcePackageName = context.getResources().getResourcePackageName(i10);
            return "android".equals(resourcePackageName) ? context.getPackageName() : resourcePackageName;
        } catch (Resources.NotFoundException unused) {
            return context.getPackageName();
        }
    }

    public static int r(Context context, String str, String str2) {
        return context.getResources().getIdentifier(str, str2, q(context));
    }

    public static SharedPreferences s(Context context) {
        return context.getSharedPreferences("com.google.firebase.crashlytics", 0);
    }

    public static synchronized long t() {
        try {
            if (f3311b == -1) {
                String strI = i(new File("/proc/meminfo"), "MemTotal");
                long jG = 0;
                if (!TextUtils.isEmpty(strI)) {
                    String upperCase = strI.toUpperCase(Locale.US);
                    try {
                        if (upperCase.endsWith("KB")) {
                            jG = g(upperCase, "KB", 1024);
                        } else if (upperCase.endsWith("MB")) {
                            jG = g(upperCase, "MB", 1048576);
                        } else if (upperCase.endsWith("GB")) {
                            jG = g(upperCase, "GB", 1073741824);
                        } else {
                            f.f().k("Unexpected meminfo format while computing RAM: " + upperCase);
                        }
                    } catch (NumberFormatException e10) {
                        f.f().e("Unexpected meminfo format while computing RAM: " + upperCase, e10);
                    }
                }
                f3311b = jG;
            }
        } catch (Throwable th) {
            throw th;
        }
        return f3311b;
    }

    public static String u(String str, String str2) {
        return v(str.getBytes(), str2);
    }

    public static String v(byte[] bArr, String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            messageDigest.update(bArr);
            return w(messageDigest.digest());
        } catch (NoSuchAlgorithmException e10) {
            f.f().e("Could not create hashing algorithm: " + str + ", returning empty string.", e10);
            return "";
        }
    }

    public static String w(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i10 = 0; i10 < bArr.length; i10++) {
            byte b10 = bArr[i10];
            int i11 = i10 * 2;
            char[] cArr2 = f3310a;
            cArr[i11] = cArr2[(b10 & 255) >>> 4];
            cArr[i11 + 1] = cArr2[b10 & 15];
        }
        return new String(cArr);
    }

    public static boolean x(Context context) {
        return (context.getApplicationInfo().flags & 2) != 0;
    }

    public static boolean y() {
        return Debug.isDebuggerConnected() || Debug.waitingForDebugger();
    }

    public static boolean z() {
        if (Build.PRODUCT.contains("sdk")) {
            return true;
        }
        String str = Build.HARDWARE;
        return str.contains("goldfish") || str.contains("ranchu");
    }
}
