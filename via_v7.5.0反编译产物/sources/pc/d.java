package pc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import lc.h;
import lc.m;
import lc.n;
import n.g;
import oc.t;
import qc.e;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f11650a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f11651b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final pc.c f11652c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f11653d;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f11654a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List f11655b = new ArrayList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List f11656c = new ArrayList();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Set f11657d = h.r();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public pc.c f11658e;

        /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
        public class a implements pc.c {
            public a() {
            }

            @Override // pc.c
            public pc.a a(pc.b bVar) {
                return new n(bVar);
            }
        }

        public d f() {
            return new d(this);
        }

        public b g(e eVar) {
            if (eVar == null) {
                throw new NullPointerException("blockParserFactory must not be null");
            }
            this.f11654a.add(eVar);
            return this;
        }

        public b h(Iterable iterable) {
            if (iterable == null) {
                throw new NullPointerException("extensions must not be null");
            }
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                ic.a aVar = (ic.a) it.next();
                if (aVar instanceof c) {
                    ((c) aVar).a(this);
                }
            }
            return this;
        }

        public final pc.c i() {
            pc.c cVar = this.f11658e;
            return cVar != null ? cVar : new a();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface c extends ic.a {
        void a(b bVar);
    }

    public final h a() {
        return new h(this.f11650a, this.f11652c, this.f11651b);
    }

    public t b(String str) {
        if (str != null) {
            return c(a().t(str));
        }
        throw new NullPointerException("input must not be null");
    }

    public final t c(t tVar) {
        Iterator it = this.f11653d.iterator();
        if (!it.hasNext()) {
            return tVar;
        }
        g.a(it.next());
        throw null;
    }

    public d(b bVar) {
        this.f11650a = h.k(bVar.f11654a, bVar.f11657d);
        pc.c cVarI = bVar.i();
        this.f11652c = cVarI;
        this.f11653d = bVar.f11656c;
        List list = bVar.f11655b;
        this.f11651b = list;
        cVarI.a(new m(list, Collections.EMPTY_MAP));
    }
}
