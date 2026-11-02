package ib;

import java.util.List;
import z8.u1;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class f extends a6.k {
    public f(List list, List list2) {
        super(list, list2);
    }

    @Override // a6.k, androidx.recyclerview.widget.f.b
    public boolean a(int i10, int i11) {
        Object obj = this.f115a.get(i10);
        if (obj.getClass() == this.f116b.get(i11).getClass() && !(obj instanceof w4.c)) {
            return super.a(i10, i11);
        }
        return false;
    }

    @Override // a6.k, androidx.recyclerview.widget.f.b
    public boolean b(int i10, int i11) {
        Object obj = this.f115a.get(i10);
        Object obj2 = this.f116b.get(i11);
        if (obj.getClass() != obj2.getClass()) {
            return false;
        }
        return obj instanceof w4.c ? u1.a(((w4.c) obj).e(), ((w4.c) obj2).e()) : super.b(i10, i11);
    }
}
