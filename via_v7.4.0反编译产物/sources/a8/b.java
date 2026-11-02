package a8;

import androidx.recyclerview.widget.f;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class b extends f.b {

    /* renamed from: a, reason: collision with root package name */
    public final List f145a;

    /* renamed from: b, reason: collision with root package name */
    public final List f146b;

    public b(List list, List list2) {
        this.f145a = list;
        this.f146b = list2;
    }

    @Override // androidx.recyclerview.widget.f.b
    public boolean a(int i10, int i11) {
        return this.f145a.get(i10).equals(this.f146b.get(i11));
    }

    @Override // androidx.recyclerview.widget.f.b
    public boolean b(int i10, int i11) {
        Object obj = this.f145a.get(i10);
        Object obj2 = this.f146b.get(i11);
        if (obj.getClass() != obj2.getClass()) {
            return false;
        }
        return obj instanceof a ? z8.u1.a(((a) obj).a().b(), ((a) obj2).a().b()) : obj.equals(obj2);
    }

    @Override // androidx.recyclerview.widget.f.b
    public Object c(int i10, int i11) {
        if (this.f145a.get(i10).getClass() != this.f146b.get(i11).getClass()) {
            return null;
        }
        return new Object();
    }

    @Override // androidx.recyclerview.widget.f.b
    public int d() {
        return this.f146b.size();
    }

    @Override // androidx.recyclerview.widget.f.b
    public int e() {
        return this.f145a.size();
    }
}
