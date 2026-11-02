package hc;

import java.util.ArrayList;
import java.util.List;
import kc.v;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class l extends mc.a {

    /* renamed from: a, reason: collision with root package name */
    public final kc.o f6922a = new kc.o();

    /* renamed from: b, reason: collision with root package name */
    public final List f6923b = new ArrayList();

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class a extends mc.b {
        @Override // mc.e
        public mc.f a(mc.h hVar, mc.g gVar) {
            return (hVar.b() < jc.d.f7963a || hVar.a() || (hVar.d().e() instanceof v)) ? mc.f.c() : mc.f.d(new l()).a(hVar.e() + jc.d.f7963a);
        }
    }

    @Override // mc.a, mc.d
    public void b() {
        int size = this.f6923b.size() - 1;
        while (size >= 0 && jc.d.f((CharSequence) this.f6923b.get(size))) {
            size--;
        }
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < size + 1; i10++) {
            sb2.append((CharSequence) this.f6923b.get(i10));
            sb2.append('\n');
        }
        this.f6922a.o(sb2.toString());
    }

    @Override // mc.d
    public kc.a e() {
        return this.f6922a;
    }

    @Override // mc.d
    public mc.c g(mc.h hVar) {
        return hVar.b() >= jc.d.f7963a ? mc.c.a(hVar.e() + jc.d.f7963a) : hVar.a() ? mc.c.b(hVar.c()) : mc.c.d();
    }

    @Override // mc.a, mc.d
    public void h(CharSequence charSequence) {
        this.f6923b.add(charSequence);
    }
}
