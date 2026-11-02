package f2;

import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class ma {

    /* renamed from: a, reason: collision with root package name */
    public com.google.android.gms.internal.measurement.u4 f5508a;

    /* renamed from: b, reason: collision with root package name */
    public List f5509b;

    /* renamed from: c, reason: collision with root package name */
    public List f5510c;

    /* renamed from: d, reason: collision with root package name */
    public long f5511d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ pa f5512e;

    public static final long b(com.google.android.gms.internal.measurement.j4 j4Var) {
        return ((j4Var.G() / 1000) / 60) / 60;
    }

    public final boolean a(long j10, com.google.android.gms.internal.measurement.j4 j4Var) {
        t1.f.h(j4Var);
        if (this.f5510c == null) {
            this.f5510c = new ArrayList();
        }
        if (this.f5509b == null) {
            this.f5509b = new ArrayList();
        }
        if (!this.f5510c.isEmpty() && b((com.google.android.gms.internal.measurement.j4) this.f5510c.get(0)) != b(j4Var)) {
            return false;
        }
        long jA = this.f5511d + j4Var.a();
        this.f5512e.U();
        if (jA >= Math.max(0, ((Integer) i3.f5315k.a(null)).intValue())) {
            return false;
        }
        this.f5511d = jA;
        this.f5510c.add(j4Var);
        this.f5509b.add(Long.valueOf(j10));
        int size = this.f5510c.size();
        this.f5512e.U();
        return size < Math.max(1, ((Integer) i3.f5317l.a(null)).intValue());
    }
}
