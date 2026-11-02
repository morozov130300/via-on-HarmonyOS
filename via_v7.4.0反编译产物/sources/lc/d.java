package lc;

import hc.h;
import hc.m;
import hc.n;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kc.t;
import mc.e;
import n.g;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public final List f8488a;

    /* renamed from: b, reason: collision with root package name */
    public final List f8489b;

    /* renamed from: c, reason: collision with root package name */
    public final lc.c f8490c;

    /* renamed from: d, reason: collision with root package name */
    public final List f8491d;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final List f8492a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        public final List f8493b = new ArrayList();

        /* renamed from: c, reason: collision with root package name */
        public final List f8494c = new ArrayList();

        /* renamed from: d, reason: collision with root package name */
        public Set f8495d = h.r();

        /* renamed from: e, reason: collision with root package name */
        public lc.c f8496e;

        /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
        public class a implements lc.c {
            public a() {
            }

            @Override // lc.c
            public lc.a a(lc.b bVar) {
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
            this.f8492a.add(eVar);
            return this;
        }

        public b h(Iterable iterable) {
            if (iterable == null) {
                throw new NullPointerException("extensions must not be null");
            }
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                ec.a aVar = (ec.a) it.next();
                if (aVar instanceof c) {
                    ((c) aVar).a(this);
                }
            }
            return this;
        }

        public final lc.c i() {
            lc.c cVar = this.f8496e;
            return cVar != null ? cVar : new a();
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface c extends ec.a {
        void a(b bVar);
    }

    public d(b bVar) {
        this.f8488a = h.k(bVar.f8492a, bVar.f8495d);
        lc.c cVarI = bVar.i();
        this.f8490c = cVarI;
        this.f8491d = bVar.f8494c;
        List list = bVar.f8493b;
        this.f8489b = list;
        cVarI.a(new m(list, Collections.EMPTY_MAP));
    }

    public final h a() {
        return new h(this.f8488a, this.f8490c, this.f8489b);
    }

    public t b(String str) {
        if (str != null) {
            return c(a().t(str));
        }
        throw new NullPointerException("input must not be null");
    }

    public final t c(t tVar) {
        Iterator it = this.f8491d.iterator();
        if (!it.hasNext()) {
            return tVar;
        }
        g.a(it.next());
        throw null;
    }
}
