package mark.via.settings.search;

import android.content.Context;
import b9.q;
import c9.k;
import c9.x;
import g8.s;
import g8.w;
import hb.b2;
import hb.b4;
import hb.b6;
import hb.c8;
import hb.i6;
import hb.l7;
import hb.n0;
import hb.o4;
import hb.o5;
import hb.u;
import hb.v4;
import hb.w7;
import hb.z;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import jb.c1;
import jb.e0;
import jb.f3;
import jb.i;
import jb.i0;
import jb.j2;
import jb.k5;
import jb.n1;
import jb.q3;
import jb.r0;
import jb.t;
import jb.u2;
import jb.u3;
import jb.v5;
import jb.y1;
import jb.y4;
import jb.z5;
import nb.n;
import oa.f1;
import va.e1;
import y7.t0;
import y8.o;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class c {
    public static List a(Context context) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(b4.e4(context));
        arrayList.addAll(u.k3(context));
        arrayList.addAll(n.h3(context));
        arrayList.addAll(w7.s3(context));
        arrayList.addAll(y7.d.j3(context));
        arrayList.addAll(t0.F3(context));
        arrayList.addAll(y4.l3(context));
        arrayList.addAll(k5.t3(context));
        arrayList.addAll(v5.r3(context));
        arrayList.addAll(r0.q3(context));
        arrayList.addAll(n1.r3(context));
        arrayList.addAll(y1.q3(context));
        arrayList.addAll(i0.h3(context));
        arrayList.addAll(u3.h3(context));
        arrayList.addAll(i.q3(context));
        arrayList.addAll(e0.q3(context));
        arrayList.addAll(f3.q3(context));
        arrayList.addAll(j2.q3(context));
        arrayList.addAll(t.q3(context));
        arrayList.addAll(u2.q3(context));
        arrayList.addAll(q3.q3(context));
        arrayList.addAll(z5.g3(context));
        arrayList.addAll(c1.q3(context));
        arrayList.addAll(e1.r3(context));
        arrayList.addAll(o4.m3(context));
        arrayList.addAll(o5.l3(context));
        arrayList.addAll(l7.p3(context));
        arrayList.addAll(s.r3(context));
        arrayList.addAll(w.i3(context));
        arrayList.addAll(b6.k3(context));
        arrayList.addAll(i6.q3(context));
        arrayList.addAll(o.j3(context));
        arrayList.addAll(v4.o3(context));
        arrayList.addAll(c8.g3(context));
        arrayList.addAll(q.t3(context));
        arrayList.addAll(c9.t.h3(context));
        arrayList.addAll(c9.u.Z2(context));
        arrayList.addAll(c9.h.h3(context));
        arrayList.addAll(k.Z2(context));
        arrayList.addAll(x.b3(context));
        arrayList.addAll(hb.y4.g3(context));
        arrayList.addAll(z.i3(context));
        arrayList.addAll(f1.b4(context));
        if (la.s.j().t().f()) {
            arrayList.addAll(b2.i3(context));
        }
        arrayList.addAll(hb.d.i3(context));
        arrayList.addAll(n0.q3(context));
        return b(arrayList);
    }

    public static List b(List list) {
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (hashSet.add(bVar.b())) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }
}
