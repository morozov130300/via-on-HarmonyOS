package f2;

import com.google.android.gms.measurement.internal.zzau;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class t5 implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzau f5696e;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ String f5697j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ z5 f5698k;

    public t5(z5 z5Var, zzau zzauVar, String str) {
        this.f5698k = z5Var;
        this.f5696e = zzauVar;
        this.f5697j = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5698k.f5871d.e();
        this.f5698k.f5871d.k(this.f5696e, this.f5697j);
    }
}
