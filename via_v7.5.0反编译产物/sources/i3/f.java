package i3;

import android.content.Context;
import android.util.Base64OutputStream;
import java.io.ByteArrayOutputStream;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.zip.GZIPOutputStream;
import n2.b0;
import org.json.JSONArray;
import org.json.JSONObject;
import v.u;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class f implements i, j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j3.b f6235a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f6236b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j3.b f6237c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set f6238d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Executor f6239e;

    public f(final Context context, final String str, Set set, j3.b bVar, Executor executor) {
        this(new j3.b() { // from class: i3.c
            @Override // j3.b
            public final Object get() {
                return f.c(context, str);
            }
        }, set, executor, bVar, context);
    }

    public static /* synthetic */ String b(f fVar) {
        String string;
        synchronized (fVar) {
            try {
                q qVar = (q) fVar.f6235a.get();
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
                    } catch (Throwable th) {
                        try {
                            gZIPOutputStream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    try {
                        base64OutputStream.close();
                    } catch (Throwable th4) {
                        th3.addSuppressed(th4);
                    }
                    throw th3;
                }
            } catch (Throwable th5) {
                throw th5;
            }
        }
        return string;
    }

    public static /* synthetic */ q c(Context context, String str) {
        return new q(context, str);
    }

    public static /* synthetic */ f d(b0 b0Var, n2.e eVar) {
        return new f((Context) eVar.a(Context.class), ((i2.e) eVar.a(i2.e.class)).o(), eVar.h(g.class), eVar.d(p3.i.class), (Executor) eVar.g(b0Var));
    }

    public static /* synthetic */ Void e(f fVar) {
        synchronized (fVar) {
            ((q) fVar.f6235a.get()).g(System.currentTimeMillis(), ((p3.i) fVar.f6237c.get()).a());
        }
        return null;
    }

    public static n2.c f() {
        final b0 b0VarA = b0.a(m2.a.class, Executor.class);
        return n2.c.d(f.class, i.class, j.class).b(n2.r.i(Context.class)).b(n2.r.i(i2.e.class)).b(n2.r.l(g.class)).b(n2.r.k(p3.i.class)).b(n2.r.j(b0VarA)).e(new n2.h() { // from class: i3.b
            @Override // n2.h
            public final Object a(n2.e eVar) {
                return f.d(b0VarA, eVar);
            }
        }).c();
    }

    @Override // i3.i
    public h2.f a() {
        return !u.a(this.f6236b) ? h2.i.e("") : h2.i.c(this.f6239e, new Callable() { // from class: i3.d
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return f.b(this.f6233c);
            }
        });
    }

    public h2.f g() {
        if (this.f6238d.size() <= 0) {
            return h2.i.e(null);
        }
        return !u.a(this.f6236b) ? h2.i.e(null) : h2.i.c(this.f6239e, new Callable() { // from class: i3.e
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return f.e(this.f6234c);
            }
        });
    }

    public f(j3.b bVar, Set set, Executor executor, j3.b bVar2, Context context) {
        this.f6235a = bVar;
        this.f6238d = set;
        this.f6239e = executor;
        this.f6237c = bVar2;
        this.f6236b = context;
    }
}
