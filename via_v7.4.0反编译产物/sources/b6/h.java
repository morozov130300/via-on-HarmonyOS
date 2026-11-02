package b6;

import androidx.recyclerview.widget.f;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class h extends f.b {

    /* renamed from: a, reason: collision with root package name */
    public final List f1841a;

    /* renamed from: b, reason: collision with root package name */
    public final List f1842b;

    public h(List list, List list2) {
        this.f1841a = list;
        this.f1842b = list2;
    }

    @Override // androidx.recyclerview.widget.f.b
    public boolean a(int i10, int i11) {
        return true;
    }

    @Override // androidx.recyclerview.widget.f.b
    public boolean b(int i10, int i11) {
        return ((String) this.f1841a.get(i10)).equals((String) this.f1842b.get(i11));
    }

    @Override // androidx.recyclerview.widget.f.b
    public Object c(int i10, int i11) {
        return new Object();
    }

    @Override // androidx.recyclerview.widget.f.b
    public int d() {
        return this.f1842b.size();
    }

    @Override // androidx.recyclerview.widget.f.b
    public int e() {
        return this.f1841a.size();
    }
}
