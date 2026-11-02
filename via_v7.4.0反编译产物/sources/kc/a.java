package kc;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class a extends t {
    @Override // kc.t
    public void j(t tVar) {
        if (!(tVar instanceof a)) {
            throw new IllegalArgumentException("Parent of block must also be block (can not be inline)");
        }
        super.j(tVar);
    }

    @Override // kc.t
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public a f() {
        return (a) super.f();
    }
}
