package q1;

import java.util.concurrent.Callable;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class a0 extends c0 {

    /* renamed from: f, reason: collision with root package name */
    public final Callable f11236f;

    public /* synthetic */ a0(Callable callable, z zVar) {
        super();
        this.f11236f = callable;
    }

    @Override // q1.c0
    public final String a() {
        try {
            return (String) this.f11236f.call();
        } catch (Exception e10) {
            throw new RuntimeException(e10);
        }
    }
}
