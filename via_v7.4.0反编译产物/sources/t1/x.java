package t1;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class x extends i {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ a f12081g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(a aVar, int i10, Bundle bundle) {
        super(aVar, i10, null);
        this.f12081g = aVar;
    }

    @Override // t1.i
    public final void f(ConnectionResult connectionResult) {
        if (this.f12081g.f() && a.U(this.f12081g)) {
            a.Q(this.f12081g, 16);
        } else {
            this.f12081g.f12014p.a(connectionResult);
            this.f12081g.y(connectionResult);
        }
    }

    @Override // t1.i
    public final boolean g() {
        this.f12081g.f12014p.a(ConnectionResult.f3278m);
        return true;
    }
}
