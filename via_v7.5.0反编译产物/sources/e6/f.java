package e6;

import android.content.Context;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class f implements e.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f4221a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f4222b = new ArrayList(3);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView.BufferType f4223c = TextView.BufferType.SPANNABLE;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f4224d = true;

    public f(Context context) {
        this.f4221a = context;
    }

    public static List b(List list) {
        return new p(list).e();
    }

    @Override // e6.e.a
    public e.a a(i iVar) {
        this.f4222b.add(iVar);
        return this;
    }

    @Override // e6.e.a
    public e build() {
        if (this.f4222b.isEmpty()) {
            throw new IllegalStateException("No plugins were added to this builder. Use #usePlugin method to add them");
        }
        List<i> listB = b(this.f4222b);
        pc.d.b bVar = new pc.d.b();
        f6.a.C0068a c0068aI = f6.a.i(this.f4221a);
        g.b bVar2 = new g.b();
        n.a aVar = new n.a();
        k.a aVar2 = new k.a();
        for (i iVar : listB) {
            iVar.i(bVar);
            iVar.f(c0068aI);
            iVar.d(bVar2);
            iVar.g(aVar);
            iVar.e(aVar2);
        }
        g gVarH = bVar2.h(c0068aI.z(), aVar2.build());
        return new h(this.f4223c, null, bVar.f(), m.b(aVar, gVarH), gVarH, Collections.unmodifiableList(listB), this.f4224d);
    }
}
