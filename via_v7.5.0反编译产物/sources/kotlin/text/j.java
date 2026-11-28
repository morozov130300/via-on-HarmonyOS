package kotlin.text;

import java.util.Iterator;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class j implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Matcher f7353a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CharSequence f7354b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h f7355c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List f7356d;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a extends e7.c {
        public a() {
        }

        @Override // e7.b, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof String) {
                return g((String) obj);
            }
            return false;
        }

        public /* bridge */ boolean g(String str) {
            return super.contains(str);
        }

        @Override // e7.b
        public int getSize() {
            return j.this.d().groupCount() + 1;
        }

        @Override // e7.c, java.util.List
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public String get(int i10) {
            String strGroup = j.this.d().group(i10);
            return strGroup == null ? "" : strGroup;
        }

        @Override // e7.c, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof String) {
                return k((String) obj);
            }
            return -1;
        }

        public /* bridge */ int k(String str) {
            return super.indexOf(str);
        }

        @Override // e7.c, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof String) {
                return n((String) obj);
            }
            return -1;
        }

        public /* bridge */ int n(String str) {
            return super.lastIndexOf(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class b extends e7.b implements h {
        public b() {
        }

        public static final g n(b bVar, int i10) {
            return bVar.k(i10);
        }

        @Override // e7.b, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj == null ? true : obj instanceof g) {
                return h((g) obj);
            }
            return false;
        }

        @Override // e7.b
        public int getSize() {
            return j.this.d().groupCount() + 1;
        }

        public /* bridge */ boolean h(g gVar) {
            return super.contains(gVar);
        }

        @Override // e7.b, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return u7.m.i(e7.w.u(e7.o.i(this)), new p7.l() { // from class: kotlin.text.k
                @Override // p7.l
                public final Object invoke(Object obj) {
                    return j.b.n(this.f7359c, ((Integer) obj).intValue());
                }
            }).iterator();
        }

        public g k(int i10) {
            s7.c cVarI = m.i(j.this.d(), i10);
            if (cVarI.o().intValue() < 0) {
                return null;
            }
            String strGroup = j.this.d().group(i10);
            kotlin.jvm.internal.h.e(strGroup, "group(...)");
            return new g(strGroup, cVarI);
        }
    }

    public j(Matcher matcher, CharSequence input) {
        kotlin.jvm.internal.h.f(matcher, "matcher");
        kotlin.jvm.internal.h.f(input, "input");
        this.f7353a = matcher;
        this.f7354b = input;
        this.f7355c = new b();
    }

    @Override // kotlin.text.i
    public List a() {
        if (this.f7356d == null) {
            this.f7356d = new a();
        }
        List list = this.f7356d;
        kotlin.jvm.internal.h.c(list);
        return list;
    }

    @Override // kotlin.text.i
    public s7.c b() {
        return m.h(d());
    }

    public final MatchResult d() {
        return this.f7353a;
    }

    @Override // kotlin.text.i
    public String getValue() {
        String strGroup = d().group();
        kotlin.jvm.internal.h.e(strGroup, "group(...)");
        return strGroup;
    }

    @Override // kotlin.text.i
    public i next() {
        int iEnd = d().end() + (d().end() == d().start() ? 1 : 0);
        if (iEnd > this.f7354b.length()) {
            return null;
        }
        Matcher matcher = this.f7353a.pattern().matcher(this.f7354b);
        kotlin.jvm.internal.h.e(matcher, "matcher(...)");
        return m.f(matcher, iEnd, this.f7354b);
    }
}
