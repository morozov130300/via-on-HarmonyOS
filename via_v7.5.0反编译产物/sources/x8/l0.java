package x8;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.SparseArray;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SparseArray f14594a = new SparseArray();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f14595b = Build.VERSION.SDK_INT;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f14596c = false;

    public static String a() {
        SparseArray sparseArray = f14594a;
        String str = (String) sparseArray.get(1);
        if (str != null) {
            return str;
        }
        String str2 = Build.BRAND;
        sparseArray.put(1, str2);
        return str2;
    }

    public static String b() {
        SparseArray sparseArray = f14594a;
        String str = (String) sparseArray.get(6);
        if (str != null) {
            return str;
        }
        String str2 = Build.DISPLAY;
        sparseArray.put(6, str2);
        return str2;
    }

    public static String c() {
        SparseArray sparseArray = f14594a;
        String str = (String) sparseArray.get(7);
        if (str != null) {
            return str;
        }
        String str2 = Build.MANUFACTURER;
        sparseArray.put(7, str2);
        return str2;
    }

    public static String d() {
        SparseArray sparseArray = f14594a;
        String str = (String) sparseArray.get(2);
        if (str != null) {
            return str;
        }
        String str2 = Build.MODEL;
        sparseArray.put(2, str2);
        return str2;
    }

    public static String e() {
        SparseArray sparseArray = f14594a;
        String str = (String) sparseArray.get(3);
        if (str != null) {
            return str;
        }
        String str2 = Build.PRODUCT;
        sparseArray.put(3, str2);
        return str2;
    }

    public static String f() {
        SparseArray sparseArray = f14594a;
        String strJoin = (String) sparseArray.get(4);
        if (strJoin == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                strJoin = TextUtils.join(" ", Build.SUPPORTED_ABIS);
            } else {
                strJoin = Build.CPU_ABI + " " + Build.CPU_ABI2;
            }
            sparseArray.put(4, strJoin);
        }
        return strJoin;
    }

    public static String g() {
        SparseArray sparseArray = f14594a;
        String str = (String) sparseArray.get(5);
        if (str != null) {
            return str;
        }
        String str2 = Build.VERSION.RELEASE;
        sparseArray.put(5, str2);
        return str2;
    }

    public static boolean h(Context context) {
        PackageManager packageManager;
        if (context == null || (packageManager = context.getPackageManager()) == null) {
            return true;
        }
        return packageManager.hasSystemFeature("android.hardware.camera.any");
    }

    public static boolean i(Context context) {
        PackageManager packageManager;
        if (context == null || (packageManager = context.getPackageManager()) == null) {
            return true;
        }
        return packageManager.hasSystemFeature("android.hardware.camera.flash");
    }

    public static boolean j() {
        return f14596c;
    }

    public static void k(boolean z10) {
        f14596c = z10;
    }
}
