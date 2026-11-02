package f3;

import com.google.firebase.encoders.EncodingException;
import f3.e;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public final Map f5885a;

    /* renamed from: b, reason: collision with root package name */
    public final Map f5886b;

    /* renamed from: c, reason: collision with root package name */
    public final c3.d f5887c;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class a implements d3.b {

        /* renamed from: d, reason: collision with root package name */
        public static final c3.d f5888d = new c3.d() { // from class: f3.d
            @Override // c3.b
            public final void a(Object obj, Object obj2) {
                e.a.b(obj, (c3.e) obj2);
            }
        };

        /* renamed from: a, reason: collision with root package name */
        public final Map f5889a = new HashMap();

        /* renamed from: b, reason: collision with root package name */
        public final Map f5890b = new HashMap();

        /* renamed from: c, reason: collision with root package name */
        public c3.d f5891c = f5888d;

        public static /* synthetic */ void b(Object obj, c3.e eVar) {
            throw new EncodingException("Couldn't find encoder for type " + obj.getClass().getCanonicalName());
        }

        public e c() {
            return new e(new HashMap(this.f5889a), new HashMap(this.f5890b), this.f5891c);
        }

        public a d(d3.a aVar) {
            aVar.a(this);
            return this;
        }

        @Override // d3.b
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public a a(Class cls, c3.d dVar) {
            this.f5889a.put(cls, dVar);
            this.f5890b.remove(cls);
            return this;
        }
    }

    public e(Map map, Map map2, c3.d dVar) {
        this.f5885a = map;
        this.f5886b = map2;
        this.f5887c = dVar;
    }

    public static a a() {
        return new a();
    }

    public void b(Object obj, OutputStream outputStream) {
        new com.google.firebase.encoders.proto.b(outputStream, this.f5885a, this.f5886b, this.f5887c).s(obj);
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
