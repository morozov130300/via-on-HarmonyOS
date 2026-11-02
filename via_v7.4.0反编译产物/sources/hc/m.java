package hc;

import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class m implements lc.b {

    /* renamed from: a, reason: collision with root package name */
    public final List f6924a;

    /* renamed from: b, reason: collision with root package name */
    public final Map f6925b;

    public m(List list, Map map) {
        this.f6924a = list;
        this.f6925b = map;
    }

    @Override // lc.b
    public kc.q a(String str) {
        return (kc.q) this.f6925b.get(str);
    }

    @Override // lc.b
    public List b() {
        return this.f6924a;
    }
}
