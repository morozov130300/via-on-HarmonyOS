package ma;

import java.util.List;
import ka.h;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class e implements h {

    /* renamed from: a, reason: collision with root package name */
    public f f8707a = null;

    @Override // ka.h
    public List a(String str, int i10, int i11) {
        f fVar = this.f8707a;
        if (fVar == null || (i11 & 16) == 0) {
            return null;
        }
        return fVar.a(str, i10);
    }

    public final f b(int i10) {
        if (i10 == 1) {
            return new c();
        }
        if (i10 == 2) {
            return new a();
        }
        if (i10 == 3) {
            return new b();
        }
        if (i10 != 4) {
            return null;
        }
        return new d();
    }

    public List c(String str, int i10, int i11, int i12) {
        f fVarB = b(i12);
        if (fVarB == null || (i11 & 16) == 0) {
            return null;
        }
        return fVarB.a(str, i10);
    }

    public void d(int i10) {
        e(b(i10));
    }

    public void e(f fVar) {
        this.f8707a = fVar;
    }
}
