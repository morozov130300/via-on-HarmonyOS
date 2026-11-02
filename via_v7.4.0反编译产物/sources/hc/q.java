package hc;

import java.util.List;
import kc.v;
import org.commonmark.internal.LinkReferenceDefinitionParser;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class q extends mc.a {

    /* renamed from: a, reason: collision with root package name */
    public final v f6959a = new v();

    /* renamed from: b, reason: collision with root package name */
    public LinkReferenceDefinitionParser f6960b = new LinkReferenceDefinitionParser();

    @Override // mc.a, mc.d
    public void b() {
        if (this.f6960b.d().length() == 0) {
            this.f6959a.l();
        }
    }

    @Override // mc.a, mc.d
    public boolean c() {
        return true;
    }

    @Override // mc.a, mc.d
    public void d(lc.a aVar) {
        CharSequence charSequenceD = this.f6960b.d();
        if (charSequenceD.length() > 0) {
            aVar.a(charSequenceD.toString(), this.f6959a);
        }
    }

    @Override // mc.d
    public kc.a e() {
        return this.f6959a;
    }

    @Override // mc.d
    public mc.c g(mc.h hVar) {
        return !hVar.a() ? mc.c.b(hVar.getIndex()) : mc.c.d();
    }

    @Override // mc.a, mc.d
    public void h(CharSequence charSequence) {
        this.f6960b.f(charSequence);
    }

    public CharSequence i() {
        return this.f6960b.d();
    }

    public List j() {
        return this.f6960b.c();
    }
}
