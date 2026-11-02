package k6;

import android.content.Context;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import k6.e;
import k6.g;
import k6.k;
import k6.n;
import l6.a;
import lc.d;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class f implements e.a {

    /* renamed from: a, reason: collision with root package name */
    public final Context f8137a;

    /* renamed from: b, reason: collision with root package name */
    public final List f8138b = new ArrayList(3);

    /* renamed from: c, reason: collision with root package name */
    public TextView.BufferType f8139c = TextView.BufferType.SPANNABLE;

    /* renamed from: d, reason: collision with root package name */
    public boolean f8140d = true;

    public f(Context context) {
        this.f8137a = context;
    }

    public static List b(List list) {
        return new p(list).e();
    }

    @Override // k6.e.a
    public e.a a(i iVar) {
        this.f8138b.add(iVar);
        return this;
    }

    @Override // k6.e.a
    public e build() {
        if (this.f8138b.isEmpty()) {
            throw new IllegalStateException("No plugins were added to this builder. Use #usePlugin method to add them");
        }
        List<i> listB = b(this.f8138b);
        d.b bVar = new d.b();
        a.C0095a c0095aI = l6.a.i(this.f8137a);
        g.b bVar2 = new g.b();
        n.a aVar = new n.a();
        k.a aVar2 = new k.a();
        for (i iVar : listB) {
            iVar.i(bVar);
            iVar.g(c0095aI);
            iVar.c(bVar2);
            iVar.b(aVar);
            iVar.f(aVar2);
        }
        g gVarH = bVar2.h(c0095aI.z(), aVar2.build());
        return new h(this.f8139c, null, bVar.f(), m.b(aVar, gVarH), gVarH, Collections.unmodifiableList(listB), this.f8140d);
    }
}
