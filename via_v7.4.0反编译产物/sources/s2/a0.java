package s2;

import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class a0 {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicInteger f11663a = new AtomicInteger();

    /* renamed from: b, reason: collision with root package name */
    public final AtomicInteger f11664b = new AtomicInteger();

    public void a() {
        this.f11664b.getAndIncrement();
    }

    public void b() {
        this.f11663a.getAndIncrement();
    }

    public void c() {
        this.f11664b.set(0);
    }
}
