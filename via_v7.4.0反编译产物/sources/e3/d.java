package e3;

import c3.f;
import c3.g;
import com.google.firebase.encoders.EncodingException;
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

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class d implements d3.b {

    /* renamed from: e, reason: collision with root package name */
    public static final c3.d f4720e = new c3.d() { // from class: e3.a
        @Override // c3.b
        public final void a(Object obj, Object obj2) {
            d.c(obj, (c3.e) obj2);
        }
    };

    /* renamed from: f, reason: collision with root package name */
    public static final f f4721f = new f() { // from class: e3.b
        @Override // c3.b
        public final void a(Object obj, Object obj2) {
            ((g) obj2).e((String) obj);
        }
    };

    /* renamed from: g, reason: collision with root package name */
    public static final f f4722g = new f() { // from class: e3.c
        @Override // c3.b
        public final void a(Object obj, Object obj2) {
            ((g) obj2).f(((Boolean) obj).booleanValue());
        }
    };

    /* renamed from: h, reason: collision with root package name */
    public static final b f4723h = new b(null);

    /* renamed from: a, reason: collision with root package name */
    public final Map f4724a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final Map f4725b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public c3.d f4726c = f4720e;

    /* renamed from: d, reason: collision with root package name */
    public boolean f4727d = false;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a implements c3.a {
        public a() {
        }

        @Override // c3.a
        public void a(Object obj, Writer writer) {
            e eVar = new e(writer, d.this.f4724a, d.this.f4725b, d.this.f4726c, d.this.f4727d);
            eVar.i(obj, false);
            eVar.r();
        }

        @Override // c3.a
        public String b(Object obj) {
            StringWriter stringWriter = new StringWriter();
            try {
                a(obj, stringWriter);
            } catch (IOException unused) {
            }
            return stringWriter.toString();
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class b implements f {

        /* renamed from: a, reason: collision with root package name */
        public static final DateFormat f4729a;

        static {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
            f4729a = simpleDateFormat;
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        }

        public b() {
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        @Override // c3.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Date date, g gVar) {
            gVar.e(f4729a.format(date));
        }
    }

    public d() {
        m(String.class, f4721f);
        m(Boolean.class, f4722g);
        m(Date.class, f4723h);
    }

    public static /* synthetic */ void c(Object obj, c3.e eVar) {
        throw new EncodingException("Couldn't find encoder for type " + obj.getClass().getCanonicalName());
    }

    public c3.a i() {
        return new a();
    }

    public d j(d3.a aVar) {
        aVar.a(this);
        return this;
    }

    public d k(boolean z10) {
        this.f4727d = z10;
        return this;
    }

    @Override // d3.b
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public d a(Class cls, c3.d dVar) {
        this.f4724a.put(cls, dVar);
        this.f4725b.remove(cls);
        return this;
    }

    public d m(Class cls, f fVar) {
        this.f4725b.put(cls, fVar);
        this.f4724a.remove(cls);
        return this;
    }
}
