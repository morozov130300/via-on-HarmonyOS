package eb;

import androidx.lifecycle.LiveData;
import java.util.List;
import java.util.concurrent.Callable;
import mark.via.common.rx.AutoDisposeViewModel;
import x7.c0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class y extends AutoDisposeViewModel {

    /* renamed from: f, reason: collision with root package name */
    public final ha.g f4991f;

    /* renamed from: g, reason: collision with root package name */
    public final androidx.lifecycle.l f4992g = new androidx.lifecycle.l();

    /* renamed from: h, reason: collision with root package name */
    public final androidx.lifecycle.l f4993h = new androidx.lifecycle.l();

    /* renamed from: i, reason: collision with root package name */
    public boolean f4994i = false;

    public y(ha.g gVar) {
        this.f4991f = gVar;
    }

    public static /* synthetic */ void m(y yVar, List list) {
        yVar.f4994i = true;
        yVar.f4992g.m(list);
        yVar.f4993h.m(Boolean.valueOf(list.isEmpty()));
    }

    public static /* synthetic */ void o(y yVar, List list) {
        yVar.f4992g.m(list);
        yVar.f4993h.m(Boolean.valueOf(list.isEmpty()));
    }

    public LiveData p() {
        return this.f4992g;
    }

    public LiveData q() {
        return this.f4993h;
    }

    public void r() {
        ((autodispose2.r) x6.o.g(new Callable() { // from class: eb.w
            @Override // java.util.concurrent.Callable
            public final Object call() {
                y yVar = this.f4989e;
                return yVar.f4991f.b(yVar.f4994i);
            }
        }).l(g7.a.c()).j(w6.b.b()).m(u8.b.c(this))).a(new a7.e() { // from class: eb.x
            @Override // a7.e
            public final void accept(Object obj) {
                y.m(this.f4990e, (List) obj);
            }
        }, new c0());
    }

    public n9.d s(int i10) {
        List list = (List) this.f4992g.e();
        if (list == null || i10 < 0 || i10 >= list.size()) {
            return null;
        }
        n9.d dVar = (n9.d) list.remove(i10);
        this.f4991f.a(dVar);
        if (list.isEmpty()) {
            this.f4993h.m(Boolean.TRUE);
        }
        return dVar;
    }

    public void t(final String str) {
        if (str == null || str.length() == 0) {
            r();
        } else {
            ((autodispose2.r) x6.o.g(new Callable() { // from class: eb.u
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.f4986e.f4991f.c(str);
                }
            }).l(g7.a.c()).j(w6.b.b()).m(u8.b.c(this))).a(new a7.e() { // from class: eb.v
                @Override // a7.e
                public final void accept(Object obj) {
                    y.o(this.f4988e, (List) obj);
                }
            }, new c0());
        }
    }
}
