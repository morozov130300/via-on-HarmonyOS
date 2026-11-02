package e5;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class e implements g {

    /* renamed from: a, reason: collision with root package name */
    public final f f4771a = new d();

    /* renamed from: b, reason: collision with root package name */
    public final Executor f4772b = Executors.newSingleThreadExecutor();

    /* renamed from: c, reason: collision with root package name */
    public final Executor f4773c = new h();

    @Override // e5.g
    public Executor a() {
        return this.f4773c;
    }

    @Override // e5.g
    public f b() {
        return this.f4771a;
    }
}
