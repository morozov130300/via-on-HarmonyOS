package g2;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class ma {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.google.android.gms.internal.measurement.u4 f5124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f5125b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List f5126c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f5127d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ pa f5128e;

    public /* synthetic */ ma(pa paVar, la laVar) {
        this.f5128e = paVar;
    }

    public static final long b(com.google.android.gms.internal.measurement.j4 j4Var) {
        return ((j4Var.G() / 1000) / 60) / 60;
    }

    public final boolean a(long j10, com.google.android.gms.internal.measurement.j4 j4Var) {
        u1.f.h(j4Var);
        if (this.f5126c == null) {
            this.f5126c = new ArrayList();
        }
        if (this.f5125b == null) {
            this.f5125b = new ArrayList();
        }
        if (!this.f5126c.isEmpty() && b((com.google.android.gms.internal.measurement.j4) this.f5126c.get(0)) != b(j4Var)) {
            return false;
        }
        long jA = this.f5127d + ((long) j4Var.a());
        this.f5128e.U();
        if (jA >= Math.max(0, ((Integer) i3.f4931k.a(null)).intValue())) {
            return false;
        }
        this.f5127d = jA;
        this.f5126c.add(j4Var);
        this.f5125b.add(Long.valueOf(j10));
        int size = this.f5126c.size();
        this.f5128e.U();
        return size < Math.max(1, ((Integer) i3.f4933l.a(null)).intValue());
    }
}
