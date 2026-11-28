package q;

import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadLocal f11674a = new ThreadLocal();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final WeakHashMap f11675b = new WeakHashMap(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f11676c = new Object();

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class a {
        public static int a(Resources resources, int i10, Resources.Theme theme) {
            return resources.getColor(i10, theme);
        }

        public static ColorStateList b(Resources resources, int i10, Resources.Theme theme) {
            return resources.getColorStateList(i10, theme);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ColorStateList f11677a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Configuration f11678b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f11679c;

        public b(ColorStateList colorStateList, Configuration configuration, Resources.Theme theme) {
            this.f11677a = colorStateList;
            this.f11678b = configuration;
            this.f11679c = theme == null ? 0 : theme.hashCode();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Resources f11680a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Resources.Theme f11681b;

        public c(Resources resources, Resources.Theme theme) {
            this.f11680a = resources;
            this.f11681b = theme;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && c.class == obj.getClass()) {
                c cVar = (c) obj;
                if (this.f11680a.equals(cVar.f11680a) && x.c.a(this.f11681b, cVar.f11681b)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return x.c.b(this.f11680a, this.f11681b);
        }
    }

    public static void a(c cVar, int i10, ColorStateList colorStateList, Resources.Theme theme) {
        synchronized (f11676c) {
            try {
                WeakHashMap weakHashMap = f11675b;
                SparseArray sparseArray = (SparseArray) weakHashMap.get(cVar);
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    weakHashMap.put(cVar, sparseArray);
                }
                sparseArray.append(i10, new b(colorStateList, cVar.f11680a.getConfiguration(), theme));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x003c, code lost:
    
        if (r2.f11679c == r5.hashCode()) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.content.res.ColorStateList b(q.e.c r5, int r6) {
        /*
            java.lang.Object r0 = q.e.f11676c
            monitor-enter(r0)
            java.util.WeakHashMap r1 = q.e.f11675b     // Catch: java.lang.Throwable -> L32
            java.lang.Object r1 = r1.get(r5)     // Catch: java.lang.Throwable -> L32
            android.util.SparseArray r1 = (android.util.SparseArray) r1     // Catch: java.lang.Throwable -> L32
            if (r1 == 0) goto L45
            int r2 = r1.size()     // Catch: java.lang.Throwable -> L32
            if (r2 <= 0) goto L45
            java.lang.Object r2 = r1.get(r6)     // Catch: java.lang.Throwable -> L32
            q.e$b r2 = (q.e.b) r2     // Catch: java.lang.Throwable -> L32
            if (r2 == 0) goto L45
            android.content.res.Configuration r3 = r2.f11678b     // Catch: java.lang.Throwable -> L32
            android.content.res.Resources r4 = r5.f11680a     // Catch: java.lang.Throwable -> L32
            android.content.res.Configuration r4 = r4.getConfiguration()     // Catch: java.lang.Throwable -> L32
            boolean r3 = r3.equals(r4)     // Catch: java.lang.Throwable -> L32
            if (r3 == 0) goto L42
            android.content.res.Resources$Theme r5 = r5.f11681b     // Catch: java.lang.Throwable -> L32
            if (r5 != 0) goto L34
            int r3 = r2.f11679c     // Catch: java.lang.Throwable -> L32
            if (r3 == 0) goto L3e
            goto L34
        L32:
            r5 = move-exception
            goto L48
        L34:
            if (r5 == 0) goto L42
            int r3 = r2.f11679c     // Catch: java.lang.Throwable -> L32
            int r5 = r5.hashCode()     // Catch: java.lang.Throwable -> L32
            if (r3 != r5) goto L42
        L3e:
            android.content.res.ColorStateList r5 = r2.f11677a     // Catch: java.lang.Throwable -> L32
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L32
            return r5
        L42:
            r1.remove(r6)     // Catch: java.lang.Throwable -> L32
        L45:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L32
            r5 = 0
            return r5
        L48:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L32
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: q.e.b(q.e$c, int):android.content.res.ColorStateList");
    }

    public static ColorStateList c(Resources resources, int i10, Resources.Theme theme) {
        c cVar = new c(resources, theme);
        ColorStateList colorStateListB = b(cVar, i10);
        if (colorStateListB != null) {
            return colorStateListB;
        }
        ColorStateList colorStateListE = e(resources, i10, theme);
        if (colorStateListE == null) {
            return Build.VERSION.SDK_INT >= 23 ? a.b(resources, i10, theme) : resources.getColorStateList(i10);
        }
        a(cVar, i10, colorStateListE, theme);
        return colorStateListE;
    }

    public static TypedValue d() {
        ThreadLocal threadLocal = f11674a;
        TypedValue typedValue = (TypedValue) threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }

    public static ColorStateList e(Resources resources, int i10, Resources.Theme theme) {
        if (f(resources, i10)) {
            return null;
        }
        try {
            return q.c.a(resources, resources.getXml(i10), theme);
        } catch (Exception e10) {
            Log.w("ResourcesCompat", "Failed to inflate ColorStateList, leaving it to the framework", e10);
            return null;
        }
    }

    public static boolean f(Resources resources, int i10) {
        TypedValue typedValueD = d();
        resources.getValue(i10, typedValueD, true);
        int i11 = typedValueD.type;
        return i11 >= 28 && i11 <= 31;
    }
}
