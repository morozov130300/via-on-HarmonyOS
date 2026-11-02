package h0;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.h;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public final Map f6317a = new LinkedHashMap();

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    /* renamed from: h0.a$a, reason: collision with other inner class name */
    public static final class C0074a extends a {

        /* renamed from: b, reason: collision with root package name */
        public static final C0074a f6318b = new C0074a();

        @Override // h0.a
        public Object a(b key) {
            h.f(key, "key");
            return null;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface b {
    }

    public abstract Object a(b bVar);

    public final Map b() {
        return this.f6317a;
    }
}
