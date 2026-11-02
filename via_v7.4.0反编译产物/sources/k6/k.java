package k6;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import k6.j;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class k implements j {

    /* renamed from: a, reason: collision with root package name */
    public final Map f8161a;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class a implements j.a {

        /* renamed from: a, reason: collision with root package name */
        public final Map f8162a = new HashMap(3);

        @Override // k6.j.a
        public j.a a(Class cls, s sVar) {
            if (sVar == null) {
                this.f8162a.remove(cls);
                return this;
            }
            this.f8162a.put(cls, sVar);
            return this;
        }

        @Override // k6.j.a
        public j build() {
            return new k(Collections.unmodifiableMap(this.f8162a));
        }
    }

    public k(Map map) {
        this.f8161a = map;
    }

    @Override // k6.j
    public s a(Class cls) {
        return (s) this.f8161a.get(cls);
    }
}
