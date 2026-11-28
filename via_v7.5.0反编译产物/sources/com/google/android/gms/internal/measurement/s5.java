package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class s5 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static HashMap f3056f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static Object f3061k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static boolean f3062l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Uri f3051a = Uri.parse("content://com.google.android.gsf.gservices");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Uri f3052b = Uri.parse("content://com.google.android.gsf.gservices/prefix");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Pattern f3053c = Pattern.compile("^(1|true|t|on|yes|y)$", 2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Pattern f3054d = Pattern.compile("^(0|false|f|off|no|n)$", 2);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AtomicBoolean f3055e = new AtomicBoolean();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final HashMap f3057g = new HashMap(16, 1.0f);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final HashMap f3058h = new HashMap(16, 1.0f);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final HashMap f3059i = new HashMap(16, 1.0f);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final HashMap f3060j = new HashMap(16, 1.0f);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String[] f3063m = new String[0];

    public static String a(ContentResolver contentResolver, String str, String str2) {
        synchronized (s5.class) {
            try {
                String str3 = null;
                if (f3056f == null) {
                    f3055e.set(false);
                    f3056f = new HashMap(16, 1.0f);
                    f3061k = new Object();
                    f3062l = false;
                    contentResolver.registerContentObserver(f3051a, true, new q5(null));
                } else if (f3055e.getAndSet(false)) {
                    f3056f.clear();
                    f3057g.clear();
                    f3058h.clear();
                    f3059i.clear();
                    f3060j.clear();
                    f3061k = new Object();
                    f3062l = false;
                }
                Object obj = f3061k;
                if (f3056f.containsKey(str)) {
                    String str4 = (String) f3056f.get(str);
                    if (str4 != null) {
                        str3 = str4;
                    }
                    return str3;
                }
                int length = f3063m.length;
                Cursor cursorQuery = contentResolver.query(f3051a, null, null, new String[]{str}, null);
                if (cursorQuery == null) {
                    return null;
                }
                try {
                    if (!cursorQuery.moveToFirst()) {
                        c(obj, str, null);
                        cursorQuery.close();
                        return null;
                    }
                    String string = cursorQuery.getString(1);
                    cursorQuery.close();
                    if (string != null && string.equals(null)) {
                        string = null;
                    }
                    c(obj, str, string);
                    if (string != null) {
                        return string;
                    }
                    return null;
                } catch (Throwable th) {
                    cursorQuery.close();
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static void c(Object obj, String str, String str2) {
        synchronized (s5.class) {
            try {
                if (obj == f3061k) {
                    f3056f.put(str, str2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
