package com.google.firebase.encoders.proto;

import com.google.firebase.encoders.EncodingException;
import d3.c;
import d3.d;
import d3.e;
import g3.f;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class b implements e {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Charset f3331f = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final c f3332g = c.a("key").b(com.google.firebase.encoders.proto.a.b().c(1).a()).a();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final c f3333h = c.a("value").b(com.google.firebase.encoders.proto.a.b().c(2).a()).a();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final d f3334i = new d() { // from class: g3.c
        @Override // d3.b
        public final void a(Object obj, Object obj2) {
            com.google.firebase.encoders.proto.b.e((Map.Entry) obj, (d3.e) obj2);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public OutputStream f3335a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f3336b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f3337c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d f3338d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final f f3339e = new f(this);

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3340a;

        static {
            int[] iArr = new int[Protobuf.IntEncoding.values().length];
            f3340a = iArr;
            try {
                iArr[Protobuf.IntEncoding.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3340a[Protobuf.IntEncoding.SIGNED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3340a[Protobuf.IntEncoding.FIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public b(OutputStream outputStream, Map map, Map map2, d dVar) {
        this.f3335a = outputStream;
        this.f3336b = map;
        this.f3337c = map2;
        this.f3338d = dVar;
    }

    public static /* synthetic */ void e(Map.Entry entry, e eVar) {
        eVar.d(f3332g, entry.getKey());
        eVar.d(f3333h, entry.getValue());
    }

    public static ByteBuffer o(int i10) {
        return ByteBuffer.allocate(i10).order(ByteOrder.LITTLE_ENDIAN);
    }

    public static Protobuf t(c cVar) {
        Protobuf protobuf = (Protobuf) cVar.c(Protobuf.class);
        if (protobuf != null) {
            return protobuf;
        }
        throw new EncodingException("Field has no @Protobuf config");
    }

    public static int u(c cVar) {
        Protobuf protobuf = (Protobuf) cVar.c(Protobuf.class);
        if (protobuf != null) {
            return protobuf.tag();
        }
        throw new EncodingException("Field has no @Protobuf config");
    }

    @Override // d3.e
    public e d(c cVar, Object obj) {
        return n(cVar, obj, true);
    }

    @Override // d3.e
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public b a(c cVar, int i10) {
        return g(cVar, i10, true);
    }

    public b g(c cVar, int i10, boolean z10) throws IOException {
        if (!z10 || i10 != 0) {
            Protobuf protobufT = t(cVar);
            int i11 = a.f3340a[protobufT.intEncoding().ordinal()];
            if (i11 == 1) {
                v(protobufT.tag() << 3);
                v(i10);
                return this;
            }
            if (i11 == 2) {
                v(protobufT.tag() << 3);
                v((i10 << 1) ^ (i10 >> 31));
                return this;
            }
            if (i11 == 3) {
                v((protobufT.tag() << 3) | 5);
                this.f3335a.write(o(4).putInt(i10).array());
                return this;
            }
        }
        return this;
    }

    @Override // d3.e
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public b b(c cVar, long j10) {
        return i(cVar, j10, true);
    }

    public b i(c cVar, long j10, boolean z10) throws IOException {
        if (!z10 || j10 != 0) {
            Protobuf protobufT = t(cVar);
            int i10 = a.f3340a[protobufT.intEncoding().ordinal()];
            if (i10 == 1) {
                v(protobufT.tag() << 3);
                w(j10);
                return this;
            }
            if (i10 == 2) {
                v(protobufT.tag() << 3);
                w((j10 >> 63) ^ (j10 << 1));
                return this;
            }
            if (i10 == 3) {
                v((protobufT.tag() << 3) | 1);
                this.f3335a.write(o(8).putLong(j10).array());
                return this;
            }
        }
        return this;
    }

    @Override // d3.e
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public b c(c cVar, boolean z10) {
        return k(cVar, z10, true);
    }

    public b k(c cVar, boolean z10, boolean z11) {
        return g(cVar, z10 ? 1 : 0, z11);
    }

    public e l(c cVar, double d10, boolean z10) throws IOException {
        if (z10 && d10 == 0.0d) {
            return this;
        }
        v((u(cVar) << 3) | 1);
        this.f3335a.write(o(8).putDouble(d10).array());
        return this;
    }

    public e m(c cVar, float f10, boolean z10) throws IOException {
        if (z10 && f10 == 0.0f) {
            return this;
        }
        v((u(cVar) << 3) | 5);
        this.f3335a.write(o(4).putFloat(f10).array());
        return this;
    }

    public e n(c cVar, Object obj, boolean z10) {
        if (obj != null) {
            if (obj instanceof CharSequence) {
                CharSequence charSequence = (CharSequence) obj;
                if (!z10 || charSequence.length() != 0) {
                    v((u(cVar) << 3) | 2);
                    byte[] bytes = charSequence.toString().getBytes(f3331f);
                    v(bytes.length);
                    this.f3335a.write(bytes);
                    return this;
                }
            } else if (obj instanceof Collection) {
                Iterator it = ((Collection) obj).iterator();
                while (it.hasNext()) {
                    n(cVar, it.next(), false);
                }
            } else if (obj instanceof Map) {
                Iterator it2 = ((Map) obj).entrySet().iterator();
                while (it2.hasNext()) {
                    q(f3334i, cVar, (Map.Entry) it2.next(), false);
                }
            } else {
                if (obj instanceof Double) {
                    return l(cVar, ((Double) obj).doubleValue(), z10);
                }
                if (obj instanceof Float) {
                    return m(cVar, ((Float) obj).floatValue(), z10);
                }
                if (obj instanceof Number) {
                    return i(cVar, ((Number) obj).longValue(), z10);
                }
                if (obj instanceof Boolean) {
                    return k(cVar, ((Boolean) obj).booleanValue(), z10);
                }
                if (!(obj instanceof byte[])) {
                    d dVar = (d) this.f3336b.get(obj.getClass());
                    if (dVar != null) {
                        return q(dVar, cVar, obj, z10);
                    }
                    d3.f fVar = (d3.f) this.f3337c.get(obj.getClass());
                    if (fVar != null) {
                        return r(fVar, cVar, obj, z10);
                    }
                    if (obj instanceof g3.b) {
                        return a(cVar, ((g3.b) obj).getNumber());
                    }
                    return obj instanceof Enum ? a(cVar, ((Enum) obj).ordinal()) : q(this.f3338d, cVar, obj, z10);
                }
                byte[] bArr = (byte[]) obj;
                if (!z10 || bArr.length != 0) {
                    v((u(cVar) << 3) | 2);
                    v(bArr.length);
                    this.f3335a.write(bArr);
                    return this;
                }
            }
        }
        return this;
    }

    public final long p(d dVar, Object obj) throws IOException {
        g3.a aVar = new g3.a();
        try {
            OutputStream outputStream = this.f3335a;
            this.f3335a = aVar;
            try {
                dVar.a(obj, this);
                this.f3335a = outputStream;
                long jA = aVar.a();
                aVar.close();
                return jA;
            } catch (Throwable th) {
                this.f3335a = outputStream;
                throw th;
            }
        } catch (Throwable th2) {
            try {
                aVar.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    public final b q(d dVar, c cVar, Object obj, boolean z10) throws IOException {
        long jP = p(dVar, obj);
        if (z10 && jP == 0) {
            return this;
        }
        v((u(cVar) << 3) | 2);
        w(jP);
        dVar.a(obj, this);
        return this;
    }

    public final b r(d3.f fVar, c cVar, Object obj, boolean z10) {
        this.f3339e.b(cVar, z10);
        fVar.a(obj, this.f3339e);
        return this;
    }

    public b s(Object obj) {
        if (obj == null) {
            return this;
        }
        d dVar = (d) this.f3336b.get(obj.getClass());
        if (dVar != null) {
            dVar.a(obj, this);
            return this;
        }
        throw new EncodingException("No encoder for " + obj.getClass());
    }

    public final void v(int i10) throws IOException {
        while ((i10 & (-128)) != 0) {
            this.f3335a.write((i10 & 127) | 128);
            i10 >>>= 7;
        }
        this.f3335a.write(i10 & 127);
    }

    public final void w(long j10) throws IOException {
        while (((-128) & j10) != 0) {
            this.f3335a.write((((int) j10) & 127) | 128);
            j10 >>>= 7;
        }
        this.f3335a.write(((int) j10) & 127);
    }
}
