package com.google.firebase.encoders.proto;

import c3.c;
import c3.d;
import c3.e;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.proto.Protobuf;
import f3.f;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class b implements e {

    /* renamed from: f, reason: collision with root package name */
    public static final Charset f4034f = Charset.forName("UTF-8");

    /* renamed from: g, reason: collision with root package name */
    public static final c f4035g = c.a("key").b(com.google.firebase.encoders.proto.a.b().c(1).a()).a();

    /* renamed from: h, reason: collision with root package name */
    public static final c f4036h = c.a("value").b(com.google.firebase.encoders.proto.a.b().c(2).a()).a();

    /* renamed from: i, reason: collision with root package name */
    public static final d f4037i = new d() { // from class: f3.c
        @Override // c3.b
        public final void a(Object obj, Object obj2) {
            com.google.firebase.encoders.proto.b.e((Map.Entry) obj, (c3.e) obj2);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public OutputStream f4038a;

    /* renamed from: b, reason: collision with root package name */
    public final Map f4039b;

    /* renamed from: c, reason: collision with root package name */
    public final Map f4040c;

    /* renamed from: d, reason: collision with root package name */
    public final d f4041d;

    /* renamed from: e, reason: collision with root package name */
    public final f f4042e = new f(this);

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f4043a;

        static {
            int[] iArr = new int[Protobuf.IntEncoding.values().length];
            f4043a = iArr;
            try {
                iArr[Protobuf.IntEncoding.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4043a[Protobuf.IntEncoding.SIGNED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4043a[Protobuf.IntEncoding.FIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public b(OutputStream outputStream, Map map, Map map2, d dVar) {
        this.f4038a = outputStream;
        this.f4039b = map;
        this.f4040c = map2;
        this.f4041d = dVar;
    }

    public static /* synthetic */ void e(Map.Entry entry, e eVar) {
        eVar.a(f4035g, entry.getKey());
        eVar.a(f4036h, entry.getValue());
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

    @Override // c3.e
    public e a(c cVar, Object obj) {
        return h(cVar, obj, true);
    }

    public e f(c cVar, double d10, boolean z10) throws IOException {
        if (z10 && d10 == 0.0d) {
            return this;
        }
        v((u(cVar) << 3) | 1);
        this.f4038a.write(o(8).putDouble(d10).array());
        return this;
    }

    public e g(c cVar, float f10, boolean z10) throws IOException {
        if (z10 && f10 == 0.0f) {
            return this;
        }
        v((u(cVar) << 3) | 5);
        this.f4038a.write(o(4).putFloat(f10).array());
        return this;
    }

    public e h(c cVar, Object obj, boolean z10) {
        if (obj != null) {
            if (obj instanceof CharSequence) {
                CharSequence charSequence = (CharSequence) obj;
                if (!z10 || charSequence.length() != 0) {
                    v((u(cVar) << 3) | 2);
                    byte[] bytes = charSequence.toString().getBytes(f4034f);
                    v(bytes.length);
                    this.f4038a.write(bytes);
                    return this;
                }
            } else if (obj instanceof Collection) {
                Iterator it = ((Collection) obj).iterator();
                while (it.hasNext()) {
                    h(cVar, it.next(), false);
                }
            } else if (obj instanceof Map) {
                Iterator it2 = ((Map) obj).entrySet().iterator();
                while (it2.hasNext()) {
                    q(f4037i, cVar, (Map.Entry) it2.next(), false);
                }
            } else {
                if (obj instanceof Double) {
                    return f(cVar, ((Double) obj).doubleValue(), z10);
                }
                if (obj instanceof Float) {
                    return g(cVar, ((Float) obj).floatValue(), z10);
                }
                if (obj instanceof Number) {
                    return l(cVar, ((Number) obj).longValue(), z10);
                }
                if (obj instanceof Boolean) {
                    return n(cVar, ((Boolean) obj).booleanValue(), z10);
                }
                if (!(obj instanceof byte[])) {
                    d dVar = (d) this.f4039b.get(obj.getClass());
                    if (dVar != null) {
                        return q(dVar, cVar, obj, z10);
                    }
                    c3.f fVar = (c3.f) this.f4040c.get(obj.getClass());
                    return fVar != null ? r(fVar, cVar, obj, z10) : obj instanceof f3.b ? c(cVar, ((f3.b) obj).getNumber()) : obj instanceof Enum ? c(cVar, ((Enum) obj).ordinal()) : q(this.f4041d, cVar, obj, z10);
                }
                byte[] bArr = (byte[]) obj;
                if (!z10 || bArr.length != 0) {
                    v((u(cVar) << 3) | 2);
                    v(bArr.length);
                    this.f4038a.write(bArr);
                    return this;
                }
            }
        }
        return this;
    }

    @Override // c3.e
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public b c(c cVar, int i10) {
        return j(cVar, i10, true);
    }

    public b j(c cVar, int i10, boolean z10) throws IOException {
        if (!z10 || i10 != 0) {
            Protobuf protobufT = t(cVar);
            int i11 = a.f4043a[protobufT.intEncoding().ordinal()];
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
                this.f4038a.write(o(4).putInt(i10).array());
                return this;
            }
        }
        return this;
    }

    @Override // c3.e
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public b b(c cVar, long j10) {
        return l(cVar, j10, true);
    }

    public b l(c cVar, long j10, boolean z10) throws IOException {
        if (!z10 || j10 != 0) {
            Protobuf protobufT = t(cVar);
            int i10 = a.f4043a[protobufT.intEncoding().ordinal()];
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
                this.f4038a.write(o(8).putLong(j10).array());
                return this;
            }
        }
        return this;
    }

    @Override // c3.e
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public b d(c cVar, boolean z10) {
        return n(cVar, z10, true);
    }

    public b n(c cVar, boolean z10, boolean z11) {
        return j(cVar, z10 ? 1 : 0, z11);
    }

    public final long p(d dVar, Object obj) throws IOException {
        f3.a aVar = new f3.a();
        try {
            OutputStream outputStream = this.f4038a;
            this.f4038a = aVar;
            try {
                dVar.a(obj, this);
                this.f4038a = outputStream;
                long jA = aVar.a();
                aVar.close();
                return jA;
            } catch (Throwable th) {
                this.f4038a = outputStream;
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

    public final b r(c3.f fVar, c cVar, Object obj, boolean z10) {
        this.f4042e.b(cVar, z10);
        fVar.a(obj, this.f4042e);
        return this;
    }

    public b s(Object obj) {
        if (obj == null) {
            return this;
        }
        d dVar = (d) this.f4039b.get(obj.getClass());
        if (dVar != null) {
            dVar.a(obj, this);
            return this;
        }
        throw new EncodingException("No encoder for " + obj.getClass());
    }

    public final void v(int i10) throws IOException {
        while ((i10 & (-128)) != 0) {
            this.f4038a.write((i10 & 127) | 128);
            i10 >>>= 7;
        }
        this.f4038a.write(i10 & 127);
    }

    public final void w(long j10) throws IOException {
        while (((-128) & j10) != 0) {
            this.f4038a.write((((int) j10) & 127) | 128);
            j10 >>>= 7;
        }
        this.f4038a.write(((int) j10) & 127);
    }
}
