package k;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f7085a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f7086b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f7087c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f7088d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f7089e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f7090f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f7091g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f7092h;

    public e(int i10) {
        if (i10 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.f7087c = i10;
        this.f7085a = new LinkedHashMap(0, 0.75f, true);
    }

    public Object a(Object obj) {
        return null;
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
                Object obj2 = this.f7085a.get(obj);
                if (obj2 != null) {
                    this.f7091g++;
                    return obj2;
                }
                this.f7092h++;
                Object objA = a(obj);
                if (objA == null) {
                    return null;
                }
                synchronized (this) {
                    try {
                        this.f7089e++;
                        objPut = this.f7085a.put(obj, objA);
                        if (objPut != null) {
                            this.f7085a.put(obj, objPut);
                        } else {
                            this.f7086b += g(obj, objA);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (objPut != null) {
                    b(false, obj, objA, objPut);
                    return objPut;
                }
                j(this.f7087c);
                return objA;
            } catch (Throwable th2) {
                throw th2;
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
                this.f7088d++;
                this.f7086b += g(obj, obj2);
                objPut = this.f7085a.put(obj, obj2);
                if (objPut != null) {
                    this.f7086b -= g(obj, objPut);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (objPut != null) {
            b(false, obj, objPut, obj2);
        }
        j(this.f7087c);
        return objPut;
    }

    public final Object f(Object obj) {
        Object objRemove;
        if (obj == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            try {
                objRemove = this.f7085a.remove(obj);
                if (objRemove != null) {
                    this.f7086b -= g(obj, objRemove);
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
        return new LinkedHashMap(this.f7085a);
    }

    public void j(int i10) {
        Object key;
        Object value;
        while (true) {
            synchronized (this) {
                try {
                    if (this.f7086b < 0 || (this.f7085a.isEmpty() && this.f7086b != 0)) {
                        break;
                    }
                    if (this.f7086b > i10 && !this.f7085a.isEmpty()) {
                        Map.Entry entry = (Map.Entry) this.f7085a.entrySet().iterator().next();
                        key = entry.getKey();
                        value = entry.getValue();
                        this.f7085a.remove(key);
                        this.f7086b -= g(key, value);
                        this.f7090f++;
                    }
                    return;
                } catch (Throwable th) {
                    throw th;
                }
            }
            b(true, key, value, null);
        }
        throw new IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
    }

    public final synchronized String toString() {
        int i10;
        int i11;
        try {
            i10 = this.f7091g;
            i11 = this.f7092h + i10;
        } catch (Throwable th) {
            throw th;
        }
        return String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.f7087c), Integer.valueOf(this.f7091g), Integer.valueOf(this.f7092h), Integer.valueOf(i11 != 0 ? (i10 * 100) / i11 : 0));
    }

    public void b(boolean z10, Object obj, Object obj2, Object obj3) {
    }
}
