package f2;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class i7 implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Boolean f5352e;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ o7 f5353j;

    public i7(o7 o7Var, Boolean bool) {
        this.f5353j = o7Var;
        this.f5352e = bool;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5353j.O(this.f5352e, true);
    }
}
