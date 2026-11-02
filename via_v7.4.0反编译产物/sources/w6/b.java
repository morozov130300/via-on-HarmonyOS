package w6;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Callable;
import w6.b;
import x6.n;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final n f13340a = v6.a.d(new Callable() { // from class: w6.a
        @Override // java.util.concurrent.Callable
        public final Object call() {
            return b.a.f13341a;
        }
    });

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final n f13341a = new d(new Handler(Looper.getMainLooper()), true);
    }

    public static n b() {
        return v6.a.e(f13340a);
    }
}
