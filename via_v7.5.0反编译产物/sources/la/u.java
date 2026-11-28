package la;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class u implements d6.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c7.a f7602a;

    public u(c7.a aVar) {
        this.f7602a = aVar;
    }

    public static u a(c7.a aVar) {
        return new u(aVar);
    }

    public static t c(Map map) {
        return new t(map);
    }

    @Override // c7.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public t get() {
        return c((Map) this.f7602a.get());
    }
}
