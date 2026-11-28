package f3;

import android.util.Base64;
import android.util.JsonWriter;
import com.google.firebase.encoders.EncodingException;
import d3.f;
import d3.g;
import java.io.IOException;
import java.io.Writer;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class e implements d3.e, g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f4446a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f4447b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final JsonWriter f4448c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map f4449d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map f4450e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final d3.d f4451f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f4452g;

    public e(Writer writer, Map map, Map map2, d3.d dVar, boolean z10) {
        this.f4448c = new JsonWriter(writer);
        this.f4449d = map;
        this.f4450e = map2;
        this.f4451f = dVar;
        this.f4452g = z10;
    }

    @Override // d3.e
    public d3.e a(d3.c cVar, int i10) {
        return k(cVar.b(), i10);
    }

    @Override // d3.e
    public d3.e b(d3.c cVar, long j10) {
        return l(cVar.b(), j10);
    }

    @Override // d3.e
    public d3.e c(d3.c cVar, boolean z10) {
        return n(cVar.b(), z10);
    }

    @Override // d3.e
    public d3.e d(d3.c cVar, Object obj) {
        return m(cVar.b(), obj);
    }

    public e g(int i10) throws IOException {
        v();
        this.f4448c.value(i10);
        return this;
    }

    public e h(long j10) throws IOException {
        v();
        this.f4448c.value(j10);
        return this;
    }

    public e i(Object obj, boolean z10) {
        int i10 = 0;
        if (z10 && q(obj)) {
            throw new EncodingException(String.format("%s cannot be encoded inline", obj == null ? null : obj.getClass()));
        }
        if (obj == null) {
            this.f4448c.nullValue();
            return this;
        }
        if (obj instanceof Number) {
            this.f4448c.value((Number) obj);
            return this;
        }
        if (!obj.getClass().isArray()) {
            if (obj instanceof Collection) {
                this.f4448c.beginArray();
                Iterator it = ((Collection) obj).iterator();
                while (it.hasNext()) {
                    i(it.next(), false);
                }
                this.f4448c.endArray();
                return this;
            }
            if (obj instanceof Map) {
                this.f4448c.beginObject();
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    Object key = entry.getKey();
                    try {
                        m((String) key, entry.getValue());
                    } catch (ClassCastException e10) {
                        throw new EncodingException(String.format("Only String keys are currently supported in maps, got %s of type %s instead.", key, key.getClass()), e10);
                    }
                }
                this.f4448c.endObject();
                return this;
            }
            d3.d dVar = (d3.d) this.f4449d.get(obj.getClass());
            if (dVar != null) {
                return s(dVar, obj, z10);
            }
            f fVar = (f) this.f4450e.get(obj.getClass());
            if (fVar != null) {
                fVar.a(obj, this);
                return this;
            }
            if (!(obj instanceof Enum)) {
                return s(this.f4451f, obj, z10);
            }
            e(((Enum) obj).name());
            return this;
        }
        if (obj instanceof byte[]) {
            return p((byte[]) obj);
        }
        this.f4448c.beginArray();
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            int length = iArr.length;
            while (i10 < length) {
                this.f4448c.value(iArr[i10]);
                i10++;
            }
        } else if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            int length2 = jArr.length;
            while (i10 < length2) {
                h(jArr[i10]);
                i10++;
            }
        } else if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            int length3 = dArr.length;
            while (i10 < length3) {
                this.f4448c.value(dArr[i10]);
                i10++;
            }
        } else if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            int length4 = zArr.length;
            while (i10 < length4) {
                this.f4448c.value(zArr[i10]);
                i10++;
            }
        } else if (obj instanceof Number[]) {
            for (Number number : (Number[]) obj) {
                i(number, false);
            }
        } else {
            for (Object obj2 : (Object[]) obj) {
                i(obj2, false);
            }
        }
        this.f4448c.endArray();
        return this;
    }

    @Override // d3.g
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public e e(String str) throws IOException {
        v();
        this.f4448c.value(str);
        return this;
    }

    public e k(String str, int i10) throws IOException {
        v();
        this.f4448c.name(str);
        return g(i10);
    }

    public e l(String str, long j10) throws IOException {
        v();
        this.f4448c.name(str);
        return h(j10);
    }

    public e m(String str, Object obj) {
        return this.f4452g ? u(str, obj) : t(str, obj);
    }

    public e n(String str, boolean z10) throws IOException {
        v();
        this.f4448c.name(str);
        return f(z10);
    }

    @Override // d3.g
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public e f(boolean z10) throws IOException {
        v();
        this.f4448c.value(z10);
        return this;
    }

    public e p(byte[] bArr) throws IOException {
        v();
        if (bArr == null) {
            this.f4448c.nullValue();
            return this;
        }
        this.f4448c.value(Base64.encodeToString(bArr, 2));
        return this;
    }

    public final boolean q(Object obj) {
        return obj == null || obj.getClass().isArray() || (obj instanceof Collection) || (obj instanceof Date) || (obj instanceof Enum) || (obj instanceof Number);
    }

    public void r() {
        v();
        this.f4448c.flush();
    }

    public e s(d3.d dVar, Object obj, boolean z10) throws IOException {
        if (!z10) {
            this.f4448c.beginObject();
        }
        dVar.a(obj, this);
        if (!z10) {
            this.f4448c.endObject();
        }
        return this;
    }

    public final e t(String str, Object obj) throws IOException {
        v();
        this.f4448c.name(str);
        if (obj != null) {
            return i(obj, false);
        }
        this.f4448c.nullValue();
        return this;
    }

    public final e u(String str, Object obj) throws IOException {
        if (obj == null) {
            return this;
        }
        v();
        this.f4448c.name(str);
        return i(obj, false);
    }

    public final void v() throws IOException {
        if (!this.f4447b) {
            throw new IllegalStateException("Parent context used since this context was created. Cannot use this context anymore.");
        }
        e eVar = this.f4446a;
        if (eVar != null) {
            eVar.v();
            this.f4446a.f4447b = false;
            this.f4446a = null;
            this.f4448c.endObject();
        }
    }
}
