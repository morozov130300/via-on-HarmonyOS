package lc;

import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class m implements pc.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f7702a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f7703b;

    public m(List list, Map map) {
        this.f7702a = list;
        this.f7703b = map;
    }

    @Override // pc.b
    public oc.q a(String str) {
        return (oc.q) this.f7703b.get(str);
    }

    @Override // pc.b
    public List b() {
        return this.f7702a;
    }
}
