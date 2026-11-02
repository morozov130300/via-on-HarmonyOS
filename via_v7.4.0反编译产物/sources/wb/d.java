package wb;

import java.util.LinkedHashSet;
import java.util.Set;
import okhttp3.a0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final Set f13426a = new LinkedHashSet();

    public synchronized void a(a0 a0Var) {
        this.f13426a.remove(a0Var);
    }

    public synchronized void b(a0 a0Var) {
        this.f13426a.add(a0Var);
    }

    public synchronized boolean c(a0 a0Var) {
        return this.f13426a.contains(a0Var);
    }
}
