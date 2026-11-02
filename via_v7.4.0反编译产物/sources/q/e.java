package q;

import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static final ThreadLocal f11180a = new ThreadLocal();

    /* renamed from: b, reason: collision with root package name */
    public static final WeakHashMap f11181b = new WeakHashMap(0);

    /* renamed from: c, reason: collision with root package name */
    public static final Object f11182c = new Object();

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class a {
        public static int a(Resources resources, int i10, Resources.Theme theme) {
            return resources.getColor(i10, theme);
        }

        public static ColorStateList b(Resources resources, int i10, Resources.Theme theme) {
            return resources.getColorStateList(i10, theme);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final ColorStateList f11183a;

        /* renamed from: b, reason: collision with root package name */
        public final Configuration f11184b;

        /* renamed from: c, reason: collision with root package name */
        public final int f11185c;

        public b(ColorStateList colorStateList, Configuration configuration, Resources.Theme theme) {
            this.f11183a = colorStateList;
            this.f11184b = configuration;
            this.f11185c = theme == null ? 0 : theme.hashCode();
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final Resources f11186a;

        /* renamed from: b, reason: collision with root package name */
        public final Resources.Theme f11187b;

        public c(Resources resources, Resources.Theme theme) {
            this.f11186a = resources;
            this.f11187b = theme;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && c.class == obj.getClass()) {
                c cVar = (c) obj;
                if (this.f11186a.equals(cVar.f11186a) && w.c.a(this.f11187b, cVar.f11187b)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return w.c.b(this.f11186a, this.f11187b);
        }
    }

    public static void a(c cVar, int i10, ColorStateList colorStateList, Resources.Theme theme) {
        synchronized (f11182c) {
            try {
                WeakHashMap weakHashMap = f11181b;
                SparseArray sparseArray = (SparseArray) weakHashMap.get(cVar);
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    weakHashMap.put(cVar, sparseArray);
                }
                sparseArray.append(i10, new b(colorStateList, cVar.f11186a.getConfiguration(), theme));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x003c, code lost:
    
        if (r2.f11185c == r5.hashCode()) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ColorStateList b(c cVar, int i10) {
        b bVar;
        synchronized (f11182c) {
            try {
                SparseArray sparseArray = (SparseArray) f11181b.get(cVar);
                if (sparseArray != null && sparseArray.size() > 0 && (bVar = (b) sparseArray.get(i10)) != null) {
                    if (bVar.f11184b.equals(cVar.f11186a.getConfiguration())) {
                        Resources.Theme theme = cVar.f11187b;
                        if (theme != null || bVar.f11185c != 0) {
                            if (theme != null) {
                            }
                        }
                        return bVar.f11183a;
                    }
                    sparseArray.remove(i10);
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
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
        ThreadLocal threadLocal = f11180a;
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

    public static boolean f(Resources resources, int i10) throws Resources.NotFoundException {
        TypedValue typedValueD = d();
        resources.getValue(i10, typedValueD, true);
        int i11 = typedValueD.type;
        return i11 >= 28 && i11 <= 31;
    }
}
