package na;

import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    public List f10291a;

    /* renamed from: b, reason: collision with root package name */
    public int f10292b;

    public k() {
        this(null, 0);
    }

    public k(List list, int i10) {
        this.f10291a = list;
        this.f10292b = i10;
    }

    public int a() {
        return this.f10292b;
    }

    public List b() {
        return this.f10291a;
    }

    public boolean c() {
        List list = this.f10291a;
        return list == null || list.isEmpty();
    }

    public void d(int i10) {
        this.f10292b = i10;
    }

    public void e(List list) {
        this.f10291a = list;
    }
}
