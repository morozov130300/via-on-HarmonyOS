package pa;

import java.util.Map;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class t implements j6.d {

    /* renamed from: a, reason: collision with root package name */
    public final i7.a f11151a;

    public t(i7.a aVar) {
        this.f11151a = aVar;
    }

    public static t a(i7.a aVar) {
        return new t(aVar);
    }

    public static s c(Map map) {
        return new s(map);
    }

    @Override // i7.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public s get() {
        return c((Map) this.f11151a.get());
    }
}
