package c9;

import androidx.recyclerview.widget.f;
import java.util.List;
import z8.u1;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class p extends f.b {

    /* renamed from: a, reason: collision with root package name */
    public final List f3036a;

    /* renamed from: b, reason: collision with root package name */
    public final List f3037b;

    public p(List list, List list2) {
        this.f3036a = list;
        this.f3037b = list2;
    }

    @Override // androidx.recyclerview.widget.f.b
    public boolean a(int i10, int i11) {
        Object obj = this.f3036a.get(i10);
        Object obj2 = this.f3037b.get(i11);
        if (obj.getClass() != obj2.getClass()) {
            return false;
        }
        if (obj instanceof a) {
            return u1.a(((a) obj).getTitle(), ((a) obj2).getTitle());
        }
        if (!(obj instanceof q)) {
            return this.f3036a.get(i10).equals(this.f3037b.get(i11));
        }
        q qVar = (q) obj;
        q qVar2 = (q) obj2;
        return qVar.b() == qVar2.b() && u1.a(qVar.a().e(), qVar2.a().e());
    }

    @Override // androidx.recyclerview.widget.f.b
    public boolean b(int i10, int i11) {
        Object obj = this.f3036a.get(i10);
        Object obj2 = this.f3037b.get(i11);
        if (obj.getClass() != obj2.getClass()) {
            return false;
        }
        if (obj instanceof a) {
            return true;
        }
        return obj instanceof q ? u1.a(((q) obj).a().d(), ((q) obj2).a().d()) : obj.equals(obj2);
    }

    @Override // androidx.recyclerview.widget.f.b
    public Object c(int i10, int i11) {
        if (this.f3036a.get(i10).getClass() != this.f3037b.get(i11).getClass()) {
            return null;
        }
        return new Object();
    }

    @Override // androidx.recyclerview.widget.f.b
    public int d() {
        return this.f3037b.size();
    }

    @Override // androidx.recyclerview.widget.f.b
    public int e() {
        return this.f3036a.size();
    }
}
