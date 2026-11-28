package f3;

import com.google.firebase.encoders.EncodingException;
import d3.f;
import d3.g;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class d implements e3.b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final d3.d f4436e = new d3.d() { // from class: f3.a
        @Override // d3.b
        public final void a(Object obj, Object obj2) {
            d.c(obj, (d3.e) obj2);
        }
    };

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final f f4437f = new f() { // from class: f3.b
        @Override // d3.b
        public final void a(Object obj, Object obj2) {
            ((g) obj2).e((String) obj);
        }
    };

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final f f4438g = new f() { // from class: f3.c
        @Override // d3.b
        public final void a(Object obj, Object obj2) {
            ((g) obj2).f(((Boolean) obj).booleanValue());
        }
    };

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final b f4439h = new b(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f4440a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f4441b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d3.d f4442c = f4436e;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f4443d = false;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements d3.a {
        public a() {
        }

        @Override // d3.a
        public void a(Object obj, Writer writer) {
            e eVar = new e(writer, d.this.f4440a, d.this.f4441b, d.this.f4442c, d.this.f4443d);
            eVar.i(obj, false);
            eVar.r();
        }

        @Override // d3.a
        public String b(Object obj) {
            StringWriter stringWriter = new StringWriter();
            try {
                a(obj, stringWriter);
            } catch (IOException unused) {
            }
            return stringWriter.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class b implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final DateFormat f4445a;

        static {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
            f4445a = simpleDateFormat;
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        }

        public b() {
        }

        @Override // d3.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Date date, g gVar) {
            gVar.e(f4445a.format(date));
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    public d() {
        m(String.class, f4437f);
        m(Boolean.class, f4438g);
        m(Date.class, f4439h);
    }

    public static /* synthetic */ void c(Object obj, d3.e eVar) {
        throw new EncodingException("Couldn't find encoder for type " + obj.getClass().getCanonicalName());
    }

    public d3.a i() {
        return new a();
    }

    public d j(e3.a aVar) {
        aVar.a(this);
        return this;
    }

    public d k(boolean z10) {
        this.f4443d = z10;
        return this;
    }

    @Override // e3.b
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public d a(Class cls, d3.d dVar) {
        this.f4440a.put(cls, dVar);
        this.f4441b.remove(cls);
        return this;
    }

    public d m(Class cls, f fVar) {
        this.f4441b.put(cls, fVar);
        this.f4440a.remove(cls);
        return this;
    }
}
