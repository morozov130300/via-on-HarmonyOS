package c9;

import androidx.recyclerview.widget.f;
import java.util.List;
import z8.u1;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class t extends f.b {

    /* renamed from: a, reason: collision with root package name */
    public final List f3042a;

    /* renamed from: b, reason: collision with root package name */
    public final List f3043b;

    public t(List list, List list2) {
        this.f3042a = list;
        this.f3043b = list2;
    }

    @Override // androidx.recyclerview.widget.f.b
    public boolean a(int i10, int i11) {
        Object obj = this.f3042a.get(i10);
        Object obj2 = this.f3043b.get(i11);
        if (obj.getClass() != obj2.getClass()) {
            return false;
        }
        if (!(obj instanceof p9.r)) {
            return this.f3042a.get(i10).equals(this.f3043b.get(i11));
        }
        p9.r rVar = (p9.r) obj;
        p9.r rVar2 = (p9.r) obj2;
        return rVar.f() == rVar2.f() && u1.a(rVar.d(), rVar2.d()) && u1.a(rVar.e(), rVar2.e());
    }

    @Override // androidx.recyclerview.widget.f.b
    public boolean b(int i10, int i11) {
        Object obj = this.f3042a.get(i10);
        Object obj2 = this.f3043b.get(i11);
        if (obj.getClass() != obj2.getClass()) {
            return false;
        }
        return obj instanceof p9.r ? u1.a(((p9.r) obj).c(), ((p9.r) obj2).c()) : obj.equals(obj2);
    }

    @Override // androidx.recyclerview.widget.f.b
    public Object c(int i10, int i11) {
        if (this.f3042a.get(i10).getClass() != this.f3043b.get(i11).getClass()) {
            return null;
        }
        return new Object();
    }

    @Override // androidx.recyclerview.widget.f.b
    public int d() {
        return this.f3043b.size();
    }

    @Override // androidx.recyclerview.widget.f.b
    public int e() {
        return this.f3042a.size();
    }
}
