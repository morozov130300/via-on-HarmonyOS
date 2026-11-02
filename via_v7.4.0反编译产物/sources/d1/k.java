package d1;

import java.util.concurrent.Executor;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class k implements f1.b {

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final k f4511a = new k();
    }

    public static k a() {
        return a.f4511a;
    }

    public static Executor b() {
        return (Executor) f1.d.c(j.a(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // i7.a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Executor get() {
        return b();
    }
}
