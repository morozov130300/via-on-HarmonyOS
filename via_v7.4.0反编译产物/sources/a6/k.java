package a6;

import androidx.recyclerview.widget.f;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class k extends f.b {

    /* renamed from: a, reason: collision with root package name */
    public final List f115a;

    /* renamed from: b, reason: collision with root package name */
    public final List f116b;

    public k(List list, List list2) {
        this.f115a = list;
        this.f116b = list2;
    }

    @Override // androidx.recyclerview.widget.f.b
    public boolean a(int i10, int i11) {
        return this.f115a.get(i10).equals(this.f116b.get(i11));
    }

    @Override // androidx.recyclerview.widget.f.b
    public boolean b(int i10, int i11) {
        Object obj = this.f115a.get(i10);
        Object obj2 = this.f116b.get(i11);
        if (obj.getClass() != obj2.getClass()) {
            return false;
        }
        if (obj instanceof q) {
            return ((q) obj).c() == ((q) obj2).c();
        }
        if (obj instanceof e) {
            return ((e) obj).d() == ((e) obj2).d();
        }
        if (obj instanceof l) {
            return true;
        }
        return obj.equals(obj2);
    }

    @Override // androidx.recyclerview.widget.f.b
    public Object c(int i10, int i11) {
        if (this.f115a.get(i10).getClass() != this.f116b.get(i11).getClass()) {
            return null;
        }
        return new Object();
    }

    @Override // androidx.recyclerview.widget.f.b
    public int d() {
        return this.f116b.size();
    }

    @Override // androidx.recyclerview.widget.f.b
    public int e() {
        return this.f115a.size();
    }
}
