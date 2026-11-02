package p8;

import android.content.ActivityNotFoundException;
import android.net.Uri;
import androidx.fragment.app.Fragment;
import g6.n;
import x7.u;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public final Fragment f10983a;

    /* renamed from: b, reason: collision with root package name */
    public final androidx.activity.result.b f10984b;

    /* renamed from: c, reason: collision with root package name */
    public final androidx.activity.result.b f10985c = null;

    /* renamed from: d, reason: collision with root package name */
    public a f10986d;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface a {
        void a(Uri uri);
    }

    public f(Fragment fragment) {
        this.f10983a = fragment;
        this.f10984b = fragment.y2(new x5.c(), new androidx.activity.result.a() { // from class: p8.e
            @Override // androidx.activity.result.a
            public final void a(Object obj) {
                this.f10982a.c((Uri) obj);
            }
        });
    }

    public void b(String[] strArr, a aVar) {
        boolean z10;
        androidx.activity.result.b bVar;
        if (strArr == null || strArr.length == 0) {
            return;
        }
        this.f10986d = aVar;
        androidx.activity.result.b bVar2 = this.f10984b;
        if (bVar2 != null) {
            try {
                bVar2.a(strArr);
                z10 = true;
            } catch (ActivityNotFoundException e10) {
                pc.a.i(e10);
            }
        } else {
            z10 = false;
        }
        if (!z10 && (bVar = this.f10985c) != null) {
            try {
                bVar.a(strArr.length == 1 ? strArr[0] : "*/*");
            } catch (ActivityNotFoundException e11) {
                pc.a.i(e11);
            }
        }
        if (z10) {
            return;
        }
        n.q(this.f10983a.I(), u.xg);
    }

    public final void c(Uri uri) {
        a aVar = this.f10986d;
        if (aVar == null) {
            return;
        }
        aVar.a(uri);
        this.f10986d = null;
    }
}
