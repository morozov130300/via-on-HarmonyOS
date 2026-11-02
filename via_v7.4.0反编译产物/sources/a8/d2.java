package a8;

import androidx.lifecycle.LiveData;
import java.util.Objects;
import java.util.concurrent.Callable;
import mark.via.common.rx.AutoDisposeViewModel;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class d2 extends AutoDisposeViewModel {

    /* renamed from: f, reason: collision with root package name */
    public final o9.c f166f;

    /* renamed from: g, reason: collision with root package name */
    public final androidx.lifecycle.l f167g = new androidx.lifecycle.l();

    /* renamed from: h, reason: collision with root package name */
    public String f168h;

    public d2(o9.c cVar) {
        this.f166f = cVar;
    }

    public LiveData m() {
        return this.f167g;
    }

    public String n() {
        return this.f168h;
    }

    public void o(final String str) {
        this.f168h = str;
        autodispose2.r rVar = (autodispose2.r) x6.o.g(new Callable() { // from class: a8.c2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return d.b(this.f153e.f166f.k(), str);
            }
        }).l(g7.a.c()).j(w6.b.b()).m(u8.b.c(this));
        androidx.lifecycle.l lVar = this.f167g;
        Objects.requireNonNull(lVar);
        rVar.a(new j0(lVar), new x7.g0());
    }

    public void p(String str) {
        this.f168h = str;
    }
}
