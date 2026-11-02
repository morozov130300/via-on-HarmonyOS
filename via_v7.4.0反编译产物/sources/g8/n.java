package g8;

import java.util.List;
import z8.u1;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class n extends a6.k {
    public n(List list, List list2) {
        super(list, list2);
    }

    @Override // a6.k, androidx.recyclerview.widget.f.b
    public boolean a(int i10, int i11) {
        Object obj = this.f115a.get(i10);
        Object obj2 = this.f116b.get(i11);
        if (obj.getClass() != obj2.getClass()) {
            return false;
        }
        return obj instanceof a ? ((a) obj).a() == ((a) obj2).a() : obj instanceof g ? ((g) obj).a() == ((g) obj2).a() : obj instanceof m ? ((m) obj2).equals((m) obj) : super.a(i10, i11);
    }

    @Override // a6.k, androidx.recyclerview.widget.f.b
    public boolean b(int i10, int i11) {
        Object obj = this.f115a.get(i10);
        Object obj2 = this.f116b.get(i11);
        if (obj.getClass() != obj2.getClass()) {
            return false;
        }
        return obj instanceof m ? u1.a(((m) obj).b(), ((m) obj2).b()) : obj instanceof a ? ((a) obj).a() == ((a) obj2).a() : obj instanceof g ? ((g) obj).a() == ((g) obj2).a() : super.b(i10, i11);
    }
}
