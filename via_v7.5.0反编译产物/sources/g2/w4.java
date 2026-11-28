package g2;

import com.google.android.gms.internal.measurement.ge;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class w4 implements ge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ y4 f5402a;

    public w4(y4 y4Var) {
        this.f5402a = y4Var;
    }

    @Override // com.google.android.gms.internal.measurement.ge
    public final void a(int i10, String str, List list, boolean z10, boolean z11) {
        t3 t3VarQ;
        int i11 = i10 - 1;
        if (i11 == 0) {
            t3VarQ = this.f5402a.f4646a.d().q();
        } else if (i11 != 1) {
            if (i11 == 3) {
                t3VarQ = this.f5402a.f4646a.d().v();
            } else if (i11 != 4) {
                t3VarQ = this.f5402a.f4646a.d().u();
            } else if (z10) {
                t3VarQ = this.f5402a.f4646a.d().y();
            } else {
                t3VarQ = !z11 ? this.f5402a.f4646a.d().x() : this.f5402a.f4646a.d().w();
            }
        } else if (z10) {
            t3VarQ = this.f5402a.f4646a.d().t();
        } else {
            t3VarQ = !z11 ? this.f5402a.f4646a.d().s() : this.f5402a.f4646a.d().r();
        }
        int size = list.size();
        if (size == 1) {
            t3VarQ.b(str, list.get(0));
            return;
        }
        if (size == 2) {
            t3VarQ.c(str, list.get(0), list.get(1));
        } else if (size != 3) {
            t3VarQ.a(str);
        } else {
            t3VarQ.d(str, list.get(0), list.get(1), list.get(2));
        }
    }
}
