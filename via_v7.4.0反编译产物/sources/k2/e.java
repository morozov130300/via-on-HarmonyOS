package k2;

import android.os.Bundle;
import e2.a;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class e implements a.InterfaceC0065a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f8121a;

    public e(f fVar) {
        this.f8121a = fVar;
    }

    @Override // f2.k6
    public final void a(String str, String str2, Bundle bundle, long j10) {
        if (str == null || !b.c(str2)) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("name", str2);
        bundle2.putLong("timestampInMillis", j10);
        bundle2.putBundle("params", bundle);
        this.f8121a.f8122a.a(3, bundle2);
    }
}
