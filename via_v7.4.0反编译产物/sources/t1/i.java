package t1;

import android.app.PendingIntent;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class i extends t {

    /* renamed from: d, reason: collision with root package name */
    public final int f12052d;

    /* renamed from: e, reason: collision with root package name */
    public final Bundle f12053e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ a f12054f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(a aVar, int i10, Bundle bundle) {
        super(aVar, Boolean.TRUE);
        this.f12054f = aVar;
        this.f12052d = i10;
        this.f12053e = bundle;
    }

    @Override // t1.t
    public final /* bridge */ /* synthetic */ void a(Object obj) {
        if (this.f12052d != 0) {
            this.f12054f.V(1, null);
            Bundle bundle = this.f12053e;
            f(new ConnectionResult(this.f12052d, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null));
        } else {
            if (g()) {
                return;
            }
            this.f12054f.V(1, null);
            f(new ConnectionResult(8, null));
        }
    }

    @Override // t1.t
    public final void b() {
    }

    public abstract void f(ConnectionResult connectionResult);

    public abstract boolean g();
}
