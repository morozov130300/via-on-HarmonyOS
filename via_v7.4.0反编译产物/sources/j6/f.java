package j6;

import j6.a;
import java.util.Map;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class f extends j6.a {

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class b extends a.AbstractC0090a {
        public b(int i10) {
            super(i10);
        }

        public f b() {
            return new f(this.f7577a);
        }

        public b c(Object obj, i7.a aVar) {
            super.a(obj, aVar);
            return this;
        }
    }

    public f(Map map) {
        super(map);
    }

    public static b b(int i10) {
        return new b(i10);
    }

    @Override // i7.a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Map get() {
        return a();
    }
}
