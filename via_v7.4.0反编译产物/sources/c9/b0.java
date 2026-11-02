package c9;

import androidx.recyclerview.widget.f;
import java.util.List;
import z8.u1;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class b0 extends f.b {

    /* renamed from: a, reason: collision with root package name */
    public final List f2975a;

    /* renamed from: b, reason: collision with root package name */
    public final List f2976b;

    public b0(List list, List list2) {
        this.f2975a = list;
        this.f2976b = list2;
    }

    @Override // androidx.recyclerview.widget.f.b
    public boolean a(int i10, int i11) {
        Object obj = this.f2975a.get(i10);
        Object obj2 = this.f2976b.get(i11);
        if (obj.getClass() != obj2.getClass()) {
            return false;
        }
        return obj instanceof a0 ? u1.a(((a0) obj).a(), ((a0) obj2).a()) : this.f2975a.get(i10).equals(this.f2976b.get(i11));
    }

    @Override // androidx.recyclerview.widget.f.b
    public boolean b(int i10, int i11) {
        Object obj = this.f2975a.get(i10);
        Object obj2 = this.f2976b.get(i11);
        if (obj.getClass() != obj2.getClass()) {
            return false;
        }
        return obj instanceof a0 ? u1.a(((a0) obj).getId(), ((a0) obj2).getId()) : obj.equals(obj2);
    }

    @Override // androidx.recyclerview.widget.f.b
    public Object c(int i10, int i11) {
        if (this.f2975a.get(i10).getClass() != this.f2976b.get(i11).getClass()) {
            return null;
        }
        return new Object();
    }

    @Override // androidx.recyclerview.widget.f.b
    public int d() {
        return this.f2976b.size();
    }

    @Override // androidx.recyclerview.widget.f.b
    public int e() {
        return this.f2975a.size();
    }
}
