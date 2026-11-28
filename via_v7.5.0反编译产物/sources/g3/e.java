package g3;

import com.google.firebase.encoders.EncodingException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f5501a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f5502b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d3.d f5503c;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a implements e3.b {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final d3.d f5504d = new d3.d() { // from class: g3.d
            @Override // d3.b
            public final void a(Object obj, Object obj2) {
                e.a.b(obj, (d3.e) obj2);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map f5505a = new HashMap();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map f5506b = new HashMap();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public d3.d f5507c = f5504d;

        public static /* synthetic */ void b(Object obj, d3.e eVar) {
            throw new EncodingException("Couldn't find encoder for type " + obj.getClass().getCanonicalName());
        }

        public e c() {
            return new e(new HashMap(this.f5505a), new HashMap(this.f5506b), this.f5507c);
        }

        public a d(e3.a aVar) {
            aVar.a(this);
            return this;
        }

        @Override // e3.b
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public a a(Class cls, d3.d dVar) {
            this.f5505a.put(cls, dVar);
            this.f5506b.remove(cls);
            return this;
        }
    }

    public e(Map map, Map map2, d3.d dVar) {
        this.f5501a = map;
        this.f5502b = map2;
        this.f5503c = dVar;
    }

    public static a a() {
        return new a();
    }

    public void b(Object obj, OutputStream outputStream) {
        new com.google.firebase.encoders.proto.b(outputStream, this.f5501a, this.f5502b, this.f5503c).s(obj);
    }

    public byte[] c(Object obj) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            b(obj, byteArrayOutputStream);
        } catch (IOException unused) {
        }
        return byteArrayOutputStream.toByteArray();
    }
}
