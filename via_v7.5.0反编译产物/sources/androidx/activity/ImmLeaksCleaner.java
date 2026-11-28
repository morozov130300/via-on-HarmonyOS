package androidx.activity;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.lifecycle.Lifecycle;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
final class ImmLeaksCleaner implements androidx.lifecycle.h {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f360e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static Field f361m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static Field f362n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static Field f363o;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Activity f364c;

    public ImmLeaksCleaner(Activity activity) {
        this.f364c = activity;
    }

    public static void a() {
        try {
            f360e = 2;
            Field declaredField = InputMethodManager.class.getDeclaredField("mServedView");
            f362n = declaredField;
            declaredField.setAccessible(true);
            Field declaredField2 = InputMethodManager.class.getDeclaredField("mNextServedView");
            f363o = declaredField2;
            declaredField2.setAccessible(true);
            Field declaredField3 = InputMethodManager.class.getDeclaredField("mH");
            f361m = declaredField3;
            declaredField3.setAccessible(true);
            f360e = 1;
        } catch (NoSuchFieldException unused) {
        }
    }

    @Override // androidx.lifecycle.h
    public void e(androidx.lifecycle.j jVar, Lifecycle.Event event) {
        if (event != Lifecycle.Event.ON_DESTROY) {
            return;
        }
        if (f360e == 0) {
            a();
        }
        if (f360e == 1) {
            InputMethodManager inputMethodManager = (InputMethodManager) this.f364c.getSystemService("input_method");
            try {
                Object obj = f361m.get(inputMethodManager);
                if (obj == null) {
                    return;
                }
                synchronized (obj) {
                    try {
                        try {
                            try {
                                View view = (View) f362n.get(inputMethodManager);
                                if (view == null) {
                                    return;
                                }
                                if (view.isAttachedToWindow()) {
                                    return;
                                }
                                try {
                                    f363o.set(inputMethodManager, null);
                                    inputMethodManager.isActive();
                                } catch (IllegalAccessException unused) {
                                }
                            } catch (ClassCastException unused2) {
                            }
                        } catch (IllegalAccessException unused3) {
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (IllegalAccessException unused4) {
            }
        }
    }
}
