package n8;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import androidx.fragment.app.Fragment;
import x8.b1;
import x8.c1;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Fragment f10707a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.activity.result.b f10708b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final androidx.activity.result.b f10709c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Runnable f10710d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f10711e = null;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface a {
        void a(Uri uri, String str);
    }

    public d(final Fragment fragment, String str) {
        androidx.activity.result.b bVarW2 = null;
        this.f10707a = fragment;
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 23 && i10 <= 28) {
            bVarW2 = fragment.w2(new e.g(), new androidx.activity.result.a() { // from class: n8.a
                @Override // androidx.activity.result.a
                public final void a(Object obj) {
                    d.c(this.f10702a, fragment, (Boolean) obj);
                }
            });
        }
        this.f10708b = bVarW2;
        this.f10709c = fragment.w2(new s5.b(str), new androidx.activity.result.a() { // from class: n8.b
            @Override // androidx.activity.result.a
            public final void a(Object obj) {
                this.f10704a.f((Uri) obj, null);
            }
        });
    }

    public static /* synthetic */ void b(d dVar, String str) {
        Context contextG = dVar.f10707a.G();
        Uri uriC = b1.c(contextG, Environment.DIRECTORY_DOWNLOADS, str, l5.c.c(c1.t(str), "application/octet-stream"));
        if (uriC == null) {
            return;
        }
        dVar.f(uriC, c1.r(Environment.DIRECTORY_DOWNLOADS, b1.k(contextG, uriC)));
    }

    public static /* synthetic */ void c(d dVar, Fragment fragment, Boolean bool) {
        dVar.getClass();
        if (bool.booleanValue()) {
            dVar.g();
        } else {
            x8.f.m(fragment.G());
        }
    }

    public void d(String str, a aVar) {
        this.f10711e = aVar;
        try {
            this.f10709c.a(str);
        } catch (ActivityNotFoundException e10) {
            tc.a.j(e10);
            e(str);
        }
    }

    public final void e(final String str) {
        Runnable runnable = new Runnable() { // from class: n8.c
            @Override // java.lang.Runnable
            public final void run() {
                d.b(this.f10705c, str);
            }
        };
        this.f10710d = runnable;
        androidx.activity.result.b bVar = this.f10708b;
        if (bVar == null) {
            runnable.run();
        } else {
            bVar.a("android.permission.WRITE_EXTERNAL_STORAGE");
        }
    }

    public final void f(Uri uri, String str) {
        a aVar = this.f10711e;
        if (aVar == null) {
            return;
        }
        aVar.a(uri, str);
        this.f10711e = null;
    }

    public final void g() {
        Runnable runnable = this.f10710d;
        if (runnable != null) {
            runnable.run();
            this.f10710d = null;
        }
    }
}
