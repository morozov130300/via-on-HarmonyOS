package j6;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class a implements d {

    /* renamed from: a, reason: collision with root package name */
    public final Map f7576a;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    /* renamed from: j6.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC0090a {

        /* renamed from: a, reason: collision with root package name */
        public final LinkedHashMap f7577a;

        public AbstractC0090a(int i10) {
            this.f7577a = b.b(i10);
        }

        public AbstractC0090a a(Object obj, i7.a aVar) {
            this.f7577a.put(g.b(obj, "key"), g.b(aVar, "provider"));
            return this;
        }
    }

    public a(Map map) {
        this.f7576a = Collections.unmodifiableMap(map);
    }

    public final Map a() {
        return this.f7576a;
    }
}
