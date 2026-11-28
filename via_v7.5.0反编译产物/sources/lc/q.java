package lc;

import java.util.List;
import oc.v;
import org.commonmark.internal.LinkReferenceDefinitionParser;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class q extends qc.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v f7737a = new v();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LinkReferenceDefinitionParser f7738b = new LinkReferenceDefinitionParser();

    @Override // qc.a, qc.d
    public void c() {
        if (this.f7738b.d().length() == 0) {
            this.f7737a.l();
        }
    }

    @Override // qc.a, qc.d
    public void d(pc.a aVar) {
        CharSequence charSequenceD = this.f7738b.d();
        if (charSequenceD.length() > 0) {
            aVar.a(charSequenceD.toString(), this.f7737a);
        }
    }

    @Override // qc.a, qc.d
    public boolean e() {
        return true;
    }

    @Override // qc.d
    public oc.a f() {
        return this.f7737a;
    }

    @Override // qc.d
    public qc.c g(qc.h hVar) {
        return !hVar.a() ? qc.c.b(hVar.getIndex()) : qc.c.d();
    }

    @Override // qc.a, qc.d
    public void h(CharSequence charSequence) {
        this.f7738b.f(charSequence);
    }

    public CharSequence i() {
        return this.f7738b.d();
    }

    public List j() {
        return this.f7738b.c();
    }
}
