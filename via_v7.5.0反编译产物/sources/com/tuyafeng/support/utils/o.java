package com.tuyafeng.support.utils;

import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import x8.l0;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f3586a;

    public static boolean a(String str) {
        String str2 = f3586a;
        if (str2 != null) {
            return str2.equals(str);
        }
        if (!TextUtils.isEmpty(b("ro.miui.ui.version.name")) || !TextUtils.isEmpty(b("ro.mi.os.version.name"))) {
            f3586a = "MIUI";
        } else if (!TextUtils.isEmpty(b("ro.build.version.emui"))) {
            f3586a = "EMUI";
        } else if (!TextUtils.isEmpty(b("ro.build.version.opporom"))) {
            f3586a = "OPPO";
        } else if (!TextUtils.isEmpty(b("ro.vivo.os.version"))) {
            f3586a = "VIVO";
        } else if (!TextUtils.isEmpty(b("ro.smartisan.version"))) {
            f3586a = "SMARTISAN";
        } else if (l0.b() != null && l0.b().toUpperCase(Locale.ROOT).contains("FLYME")) {
            f3586a = "FLYME";
        } else if (l0.c() != null) {
            f3586a = l0.c().toUpperCase(Locale.ROOT);
        } else {
            f3586a = "UNKNOWN";
            try {
                Class<?> cls = Class.forName("com.huawei.system.BuildEx");
                if ("HARMONY".toLowerCase(Locale.ROOT).equals(cls.getMethod("getOsBrand", null).invoke(cls, null))) {
                    f3586a = "HARMONY";
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        return f3586a.equals(str);
    }

    public static String b(String str) throws Throwable {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        line = null;
        String line = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
            try {
                line = bufferedReader.readLine();
            } catch (IOException unused) {
                if (bufferedReader != null) {
                }
                return line;
            } catch (Throwable th) {
                th = th;
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e10) {
                        e10.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (IOException unused2) {
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            bufferedReader.close();
        } catch (IOException e11) {
            e11.printStackTrace();
        }
        return line;
    }

    public static boolean c(String str) {
        return str.equalsIgnoreCase(l0.a()) || str.equalsIgnoreCase(l0.c());
    }

    public static boolean d() {
        return a("EMUI");
    }

    public static boolean e() {
        return a("HARMONY");
    }

    public static boolean f() {
        return c("HONOR");
    }

    public static boolean g() {
        return c("HUAWEI");
    }

    public static boolean h() {
        return c("OnePlus");
    }

    public static boolean i() {
        return c("OPPO");
    }
}
