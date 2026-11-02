package cb;

import androidx.recyclerview.widget.f;
import java.util.List;
import z8.u1;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class c extends f.b {

    /* renamed from: a, reason: collision with root package name */
    public final List f3073a;

    /* renamed from: b, reason: collision with root package name */
    public final List f3074b;

    public c(List list, List list2) {
        this.f3073a = list;
        this.f3074b = list2;
    }

    @Override // androidx.recyclerview.widget.f.b
    public boolean a(int i10, int i11) {
        Object obj = this.f3073a.get(i10);
        Object obj2 = this.f3074b.get(i11);
        if (obj.getClass() != obj2.getClass()) {
            return false;
        }
        if (!(obj instanceof a)) {
            return obj.equals(obj2);
        }
        a aVar = (a) obj;
        a aVar2 = (a) obj2;
        return aVar.g() == aVar2.g() && (aVar.g() || u1.a(aVar.b().g(), aVar2.b().g())) && u1.a(aVar.f(), aVar2.f()) && aVar.c() == aVar2.c();
    }

    @Override // androidx.recyclerview.widget.f.b
    public boolean b(int i10, int i11) {
        Object obj = this.f3073a.get(i10);
        Object obj2 = this.f3074b.get(i11);
        if (obj.getClass() != obj2.getClass()) {
            return false;
        }
        if (!(obj instanceof a)) {
            return obj.equals(obj2);
        }
        a aVar = (a) obj;
        a aVar2 = (a) obj2;
        return aVar.g() == aVar2.g() && u1.a(aVar.d(), aVar2.d());
    }

    @Override // androidx.recyclerview.widget.f.b
    public int d() {
        return this.f3074b.size();
    }

    @Override // androidx.recyclerview.widget.f.b
    public int e() {
        return this.f3073a.size();
    }
}
