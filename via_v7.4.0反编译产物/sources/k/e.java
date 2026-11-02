package k;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f7985a;

    /* renamed from: b, reason: collision with root package name */
    public int f7986b;

    /* renamed from: c, reason: collision with root package name */
    public int f7987c;

    /* renamed from: d, reason: collision with root package name */
    public int f7988d;

    /* renamed from: e, reason: collision with root package name */
    public int f7989e;

    /* renamed from: f, reason: collision with root package name */
    public int f7990f;

    /* renamed from: g, reason: collision with root package name */
    public int f7991g;

    /* renamed from: h, reason: collision with root package name */
    public int f7992h;

    public e(int i10) {
        if (i10 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.f7987c = i10;
        this.f7985a = new LinkedHashMap(0, 0.75f, true);
    }

    public Object a(Object obj) {
        return null;
    }

    public void b(boolean z10, Object obj, Object obj2, Object obj3) {
    }

    public final void c() {
        j(-1);
    }

    public final Object d(Object obj) {
        Object objPut;
        if (obj == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            try {
                Object obj2 = this.f7985a.get(obj);
                if (obj2 != null) {
                    this.f7991g++;
                    return obj2;
                }
                this.f7992h++;
                Object objA = a(obj);
                if (objA == null) {
                    return null;
                }
                synchronized (this) {
                    try {
                        this.f7989e++;
                        objPut = this.f7985a.put(obj, objA);
                        if (objPut != null) {
                            this.f7985a.put(obj, objPut);
                        } else {
                            this.f7986b += g(obj, objA);
                        }
                    } finally {
                    }
                }
                if (objPut != null) {
                    b(false, obj, objA, objPut);
                    return objPut;
                }
                j(this.f7987c);
                return objA;
            } finally {
            }
        }
    }

    public final Object e(Object obj, Object obj2) {
        Object objPut;
        if (obj == null || obj2 == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            try {
                this.f7988d++;
                this.f7986b += g(obj, obj2);
                objPut = this.f7985a.put(obj, obj2);
                if (objPut != null) {
                    this.f7986b -= g(obj, objPut);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (objPut != null) {
            b(false, obj, objPut, obj2);
        }
        j(this.f7987c);
        return objPut;
    }

    public final Object f(Object obj) {
        Object objRemove;
        if (obj == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            try {
                objRemove = this.f7985a.remove(obj);
                if (objRemove != null) {
                    this.f7986b -= g(obj, objRemove);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (objRemove != null) {
            b(false, obj, objRemove, null);
        }
        return objRemove;
    }

    public final int g(Object obj, Object obj2) {
        int iH = h(obj, obj2);
        if (iH >= 0) {
            return iH;
        }
        throw new IllegalStateException("Negative size: " + obj + "=" + obj2);
    }

    public int h(Object obj, Object obj2) {
        return 1;
    }

    public final synchronized Map i() {
        return new LinkedHashMap(this.f7985a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0073, code lost:
    
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void j(int i10) {
        Object key;
        Object value;
        while (true) {
            synchronized (this) {
                try {
                    if (this.f7986b < 0 || (this.f7985a.isEmpty() && this.f7986b != 0)) {
                        break;
                    }
                    if (this.f7986b <= i10 || this.f7985a.isEmpty()) {
                        break;
                    }
                    Map.Entry entry = (Map.Entry) this.f7985a.entrySet().iterator().next();
                    key = entry.getKey();
                    value = entry.getValue();
                    this.f7985a.remove(key);
                    this.f7986b -= g(key, value);
                    this.f7990f++;
                } finally {
                }
            }
            b(true, key, value, null);
        }
    }

    public final synchronized String toString() {
        int i10;
        int i11;
        try {
            i10 = this.f7991g;
            i11 = this.f7992h + i10;
        } catch (Throwable th) {
            throw th;
        }
        return String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.f7987c), Integer.valueOf(this.f7991g), Integer.valueOf(this.f7992h), Integer.valueOf(i11 != 0 ? (i10 * 100) / i11 : 0));
    }
}
