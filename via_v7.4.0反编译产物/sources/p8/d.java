package p8;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import androidx.fragment.app.Fragment;
import z8.b1;
import z8.c1;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public final Fragment f10977a;

    /* renamed from: b, reason: collision with root package name */
    public final androidx.activity.result.b f10978b;

    /* renamed from: c, reason: collision with root package name */
    public final androidx.activity.result.b f10979c;

    /* renamed from: d, reason: collision with root package name */
    public Runnable f10980d = null;

    /* renamed from: e, reason: collision with root package name */
    public a f10981e = null;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface a {
        void a(Uri uri, String str);
    }

    public d(final Fragment fragment, String str) {
        androidx.activity.result.b bVarY2 = null;
        this.f10977a = fragment;
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 23 && i10 <= 28) {
            bVarY2 = fragment.y2(new e.g(), new androidx.activity.result.a() { // from class: p8.a
                @Override // androidx.activity.result.a
                public final void a(Object obj) {
                    d.c(this.f10972a, fragment, (Boolean) obj);
                }
            });
        }
        this.f10978b = bVarY2;
        this.f10979c = fragment.y2(new x5.b(str), new androidx.activity.result.a() { // from class: p8.b
            @Override // androidx.activity.result.a
            public final void a(Object obj) {
                this.f10974a.f((Uri) obj, null);
            }
        });
    }

    public static /* synthetic */ void b(d dVar, String str) {
        Context contextI = dVar.f10977a.I();
        Uri uriC = b1.c(contextI, Environment.DIRECTORY_DOWNLOADS, str, l5.c.c(c1.r(str), "application/octet-stream"));
        if (uriC == null) {
            return;
        }
        dVar.f(uriC, c1.q(Environment.DIRECTORY_DOWNLOADS, b1.k(contextI, uriC)));
    }

    public static /* synthetic */ void c(d dVar, Fragment fragment, Boolean bool) {
        dVar.getClass();
        if (bool.booleanValue()) {
            dVar.g();
        } else {
            z8.f.m(fragment.I());
        }
    }

    public void d(String str, a aVar) {
        this.f10981e = aVar;
        try {
            this.f10979c.a(str);
        } catch (ActivityNotFoundException e10) {
            pc.a.i(e10);
            e(str);
        }
    }

    public final void e(final String str) {
        Runnable runnable = new Runnable() { // from class: p8.c
            @Override // java.lang.Runnable
            public final void run() {
                d.b(this.f10975e, str);
            }
        };
        this.f10980d = runnable;
        androidx.activity.result.b bVar = this.f10978b;
        if (bVar == null) {
            runnable.run();
        } else {
            bVar.a("android.permission.WRITE_EXTERNAL_STORAGE");
        }
    }

    public final void f(Uri uri, String str) {
        a aVar = this.f10981e;
        if (aVar == null) {
            return;
        }
        aVar.a(uri, str);
        this.f10981e = null;
    }

    public final void g() {
        Runnable runnable = this.f10980d;
        if (runnable != null) {
            runnable.run();
            this.f10980d = null;
        }
    }
}
