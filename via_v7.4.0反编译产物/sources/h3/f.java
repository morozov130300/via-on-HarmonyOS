package h3;

import android.content.Context;
import android.util.Base64OutputStream;
import java.io.ByteArrayOutputStream;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.zip.GZIPOutputStream;
import m2.b0;
import org.json.JSONArray;
import org.json.JSONObject;
import u.u;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class f implements i, j {

    /* renamed from: a, reason: collision with root package name */
    public final i3.b f6366a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f6367b;

    /* renamed from: c, reason: collision with root package name */
    public final i3.b f6368c;

    /* renamed from: d, reason: collision with root package name */
    public final Set f6369d;

    /* renamed from: e, reason: collision with root package name */
    public final Executor f6370e;

    public f(final Context context, final String str, Set set, i3.b bVar, Executor executor) {
        this(new i3.b() { // from class: h3.c
            @Override // i3.b
            public final Object get() {
                return f.c(context, str);
            }
        }, set, executor, bVar, context);
    }

    public f(i3.b bVar, Set set, Executor executor, i3.b bVar2, Context context) {
        this.f6366a = bVar;
        this.f6369d = set;
        this.f6370e = executor;
        this.f6368c = bVar2;
        this.f6367b = context;
    }

    public static /* synthetic */ String b(f fVar) {
        String string;
        synchronized (fVar) {
            try {
                q qVar = (q) fVar.f6366a.get();
                List listC = qVar.c();
                qVar.b();
                JSONArray jSONArray = new JSONArray();
                for (int i10 = 0; i10 < listC.size(); i10++) {
                    r rVar = (r) listC.get(i10);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("agent", rVar.c());
                    jSONObject.put("dates", new JSONArray((Collection) rVar.b()));
                    jSONArray.put(jSONObject);
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("heartbeats", jSONArray);
                jSONObject2.put("version", "2");
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                Base64OutputStream base64OutputStream = new Base64OutputStream(byteArrayOutputStream, 11);
                try {
                    GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(base64OutputStream);
                    try {
                        gZIPOutputStream.write(jSONObject2.toString().getBytes("UTF-8"));
                        gZIPOutputStream.close();
                        base64OutputStream.close();
                        string = byteArrayOutputStream.toString("UTF-8");
                    } finally {
                    }
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return string;
    }

    public static /* synthetic */ q c(Context context, String str) {
        return new q(context, str);
    }

    public static /* synthetic */ f d(b0 b0Var, m2.e eVar) {
        return new f((Context) eVar.a(Context.class), ((h2.e) eVar.a(h2.e.class)).o(), eVar.e(g.class), eVar.c(o3.i.class), (Executor) eVar.f(b0Var));
    }

    public static /* synthetic */ Void e(f fVar) {
        synchronized (fVar) {
            ((q) fVar.f6366a.get()).g(System.currentTimeMillis(), ((o3.i) fVar.f6368c.get()).a());
        }
        return null;
    }

    public static m2.c f() {
        final b0 b0VarA = b0.a(l2.a.class, Executor.class);
        return m2.c.d(f.class, i.class, j.class).b(m2.r.i(Context.class)).b(m2.r.i(h2.e.class)).b(m2.r.l(g.class)).b(m2.r.k(o3.i.class)).b(m2.r.j(b0VarA)).e(new m2.h() { // from class: h3.b
            @Override // m2.h
            public final Object a(m2.e eVar) {
                return f.d(b0VarA, eVar);
            }
        }).c();
    }

    @Override // h3.i
    public g2.f a() {
        return !u.a(this.f6367b) ? g2.i.e("") : g2.i.c(this.f6370e, new Callable() { // from class: h3.d
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return f.b(this.f6364e);
            }
        });
    }

    public g2.f g() {
        if (this.f6369d.size() > 0 && u.a(this.f6367b)) {
            return g2.i.c(this.f6370e, new Callable() { // from class: h3.e
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return f.e(this.f6365e);
                }
            });
        }
        return g2.i.e(null);
    }
}
