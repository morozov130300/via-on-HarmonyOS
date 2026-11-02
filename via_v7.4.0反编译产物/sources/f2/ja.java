package f2;

import android.os.Bundle;
import com.google.android.gms.measurement.internal.zzau;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class ja implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f5392e;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ String f5393j = "_err";

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Bundle f5394k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ ka f5395l;

    public ja(ka kaVar, String str, String str2, Bundle bundle) {
        this.f5395l = kaVar;
        this.f5392e = str;
        this.f5394k = bundle;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5395l.f5424a.k((zzau) t1.f.h(this.f5395l.f5424a.h0().y0(this.f5392e, this.f5393j, this.f5394k, "auto", this.f5395l.f5424a.a().a(), false, true)), this.f5392e);
    }
}
