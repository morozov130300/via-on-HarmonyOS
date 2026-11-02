package k2;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzjb;
import e2.a;
import f2.g6;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class c implements a.InterfaceC0065a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f8116a;

    public c(d dVar) {
        this.f8116a = dVar;
    }

    @Override // f2.k6
    public final void a(String str, String str2, Bundle bundle, long j10) {
        if (this.f8116a.f8117a.contains(str2)) {
            Bundle bundle2 = new Bundle();
            zzjb zzjbVar = b.f8110a;
            String strA = g6.a(str2);
            if (strA != null) {
                str2 = strA;
            }
            bundle2.putString("events", str2);
            this.f8116a.f8118b.a(2, bundle2);
        }
    }
}
