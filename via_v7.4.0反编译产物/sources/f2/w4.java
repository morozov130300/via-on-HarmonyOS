package f2;

import com.google.android.gms.internal.measurement.ge;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class w4 implements ge {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ y4 f5786a;

    public w4(y4 y4Var) {
        this.f5786a = y4Var;
    }

    @Override // com.google.android.gms.internal.measurement.ge
    public final void a(int i10, String str, List list, boolean z10, boolean z11) {
        int i11 = i10 - 1;
        t3 t3VarU = i11 != 0 ? i11 != 1 ? i11 != 3 ? i11 != 4 ? this.f5786a.f5030a.d().u() : z10 ? this.f5786a.f5030a.d().y() : !z11 ? this.f5786a.f5030a.d().x() : this.f5786a.f5030a.d().w() : this.f5786a.f5030a.d().v() : z10 ? this.f5786a.f5030a.d().t() : !z11 ? this.f5786a.f5030a.d().s() : this.f5786a.f5030a.d().r() : this.f5786a.f5030a.d().q();
        int size = list.size();
        if (size == 1) {
            t3VarU.b(str, list.get(0));
            return;
        }
        if (size == 2) {
            t3VarU.c(str, list.get(0), list.get(1));
        } else if (size != 3) {
            t3VarU.a(str);
        } else {
            t3VarU.d(str, list.get(0), list.get(1), list.get(2));
        }
    }
}
