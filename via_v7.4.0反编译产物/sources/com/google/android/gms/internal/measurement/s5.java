package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class s5 {

    /* renamed from: f, reason: collision with root package name */
    public static HashMap f3757f;

    /* renamed from: k, reason: collision with root package name */
    public static Object f3762k;

    /* renamed from: l, reason: collision with root package name */
    public static boolean f3763l;

    /* renamed from: a, reason: collision with root package name */
    public static final Uri f3752a = Uri.parse("content://com.google.android.gsf.gservices");

    /* renamed from: b, reason: collision with root package name */
    public static final Uri f3753b = Uri.parse("content://com.google.android.gsf.gservices/prefix");

    /* renamed from: c, reason: collision with root package name */
    public static final Pattern f3754c = Pattern.compile("^(1|true|t|on|yes|y)$", 2);

    /* renamed from: d, reason: collision with root package name */
    public static final Pattern f3755d = Pattern.compile("^(0|false|f|off|no|n)$", 2);

    /* renamed from: e, reason: collision with root package name */
    public static final AtomicBoolean f3756e = new AtomicBoolean();

    /* renamed from: g, reason: collision with root package name */
    public static final HashMap f3758g = new HashMap(16, 1.0f);

    /* renamed from: h, reason: collision with root package name */
    public static final HashMap f3759h = new HashMap(16, 1.0f);

    /* renamed from: i, reason: collision with root package name */
    public static final HashMap f3760i = new HashMap(16, 1.0f);

    /* renamed from: j, reason: collision with root package name */
    public static final HashMap f3761j = new HashMap(16, 1.0f);

    /* renamed from: m, reason: collision with root package name */
    public static final String[] f3764m = new String[0];

    public static String a(ContentResolver contentResolver, String str, String str2) {
        synchronized (s5.class) {
            try {
                String str3 = null;
                if (f3757f == null) {
                    f3756e.set(false);
                    f3757f = new HashMap(16, 1.0f);
                    f3762k = new Object();
                    f3763l = false;
                    contentResolver.registerContentObserver(f3752a, true, new q5(null));
                } else if (f3756e.getAndSet(false)) {
                    f3757f.clear();
                    f3758g.clear();
                    f3759h.clear();
                    f3760i.clear();
                    f3761j.clear();
                    f3762k = new Object();
                    f3763l = false;
                }
                Object obj = f3762k;
                if (f3757f.containsKey(str)) {
                    String str4 = (String) f3757f.get(str);
                    if (str4 != null) {
                        str3 = str4;
                    }
                    return str3;
                }
                int length = f3764m.length;
                Cursor cursorQuery = contentResolver.query(f3752a, null, null, new String[]{str}, null);
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
            } finally {
            }
        }
    }

    public static void c(Object obj, String str, String str2) {
        synchronized (s5.class) {
            try {
                if (obj == f3762k) {
                    f3757f.put(str, str2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
