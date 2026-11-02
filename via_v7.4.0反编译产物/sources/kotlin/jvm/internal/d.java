package kotlin.jvm.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import k7.l;
import k7.x;
import kotlin.Pair;
import q7.m;
import q7.n;
import q7.o;
import q7.p;
import q7.q;
import q7.r;
import q7.s;
import q7.t;
import q7.u;
import q7.v;
import q7.w;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class d implements u7.c, c {

    /* renamed from: j, reason: collision with root package name */
    public static final a f8294j = new a(null);

    /* renamed from: k, reason: collision with root package name */
    public static final Map f8295k;

    /* renamed from: l, reason: collision with root package name */
    public static final HashMap f8296l;

    /* renamed from: m, reason: collision with root package name */
    public static final HashMap f8297m;

    /* renamed from: n, reason: collision with root package name */
    public static final HashMap f8298n;

    /* renamed from: o, reason: collision with root package name */
    public static final Map f8299o;

    /* renamed from: e, reason: collision with root package name */
    public final Class f8300e;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    static {
        int i10 = 0;
        List listF = l.f(q7.a.class, q7.l.class, p.class, q.class, r.class, s.class, t.class, u.class, v.class, w.class, q7.b.class, q7.c.class, q7.d.class, q7.e.class, q7.f.class, q7.g.class, q7.h.class, q7.i.class, q7.j.class, q7.k.class, m.class, n.class, o.class);
        ArrayList arrayList = new ArrayList(k7.m.j(listF, 10));
        for (Object obj : listF) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                l.i();
            }
            arrayList.add(j7.d.a((Class) obj, Integer.valueOf(i10)));
            i10 = i11;
        }
        f8295k = kotlin.collections.a.g(arrayList);
        HashMap map = new HashMap();
        map.put("boolean", "kotlin.Boolean");
        map.put("char", "kotlin.Char");
        map.put("byte", "kotlin.Byte");
        map.put("short", "kotlin.Short");
        map.put("int", "kotlin.Int");
        map.put("float", "kotlin.Float");
        map.put("long", "kotlin.Long");
        map.put("double", "kotlin.Double");
        f8296l = map;
        HashMap map2 = new HashMap();
        map2.put("java.lang.Boolean", "kotlin.Boolean");
        map2.put("java.lang.Character", "kotlin.Char");
        map2.put("java.lang.Byte", "kotlin.Byte");
        map2.put("java.lang.Short", "kotlin.Short");
        map2.put("java.lang.Integer", "kotlin.Int");
        map2.put("java.lang.Float", "kotlin.Float");
        map2.put("java.lang.Long", "kotlin.Long");
        map2.put("java.lang.Double", "kotlin.Double");
        f8297m = map2;
        HashMap map3 = new HashMap();
        map3.put("java.lang.Object", "kotlin.Any");
        map3.put("java.lang.String", "kotlin.String");
        map3.put("java.lang.CharSequence", "kotlin.CharSequence");
        map3.put("java.lang.Throwable", "kotlin.Throwable");
        map3.put("java.lang.Cloneable", "kotlin.Cloneable");
        map3.put("java.lang.Number", "kotlin.Number");
        map3.put("java.lang.Comparable", "kotlin.Comparable");
        map3.put("java.lang.Enum", "kotlin.Enum");
        map3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        map3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        map3.put("java.util.Iterator", "kotlin.collections.Iterator");
        map3.put("java.util.Collection", "kotlin.collections.Collection");
        map3.put("java.util.List", "kotlin.collections.List");
        map3.put("java.util.Set", "kotlin.collections.Set");
        map3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        map3.put("java.util.Map", "kotlin.collections.Map");
        map3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        map3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        map3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        map3.putAll(map);
        map3.putAll(map2);
        Collection<String> collectionValues = map.values();
        h.e(collectionValues, "primitiveFqNames.values");
        for (String kotlinName : collectionValues) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("kotlin.jvm.internal.");
            h.e(kotlinName, "kotlinName");
            sb2.append(v7.m.H(kotlinName, '.', null, 2, null));
            sb2.append("CompanionObject");
            Pair pairA = j7.d.a(sb2.toString(), kotlinName + ".Companion");
            map3.put(pairA.getFirst(), pairA.getSecond());
        }
        for (Map.Entry entry : f8295k.entrySet()) {
            map3.put(((Class) entry.getKey()).getName(), "kotlin.Function" + ((Number) entry.getValue()).intValue());
        }
        f8298n = map3;
        LinkedHashMap linkedHashMap = new LinkedHashMap(x.a(map3.size()));
        for (Map.Entry entry2 : map3.entrySet()) {
            linkedHashMap.put(entry2.getKey(), v7.m.H((String) entry2.getValue(), '.', null, 2, null));
        }
        f8299o = linkedHashMap;
    }

    public d(Class jClass) {
        h.f(jClass, "jClass");
        this.f8300e = jClass;
    }

    @Override // kotlin.jvm.internal.c
    public Class a() {
        return this.f8300e;
    }

    public boolean equals(Object obj) {
        return (obj instanceof d) && h.a(p7.a.b(this), p7.a.b((u7.c) obj));
    }

    public int hashCode() {
        return p7.a.b(this).hashCode();
    }

    public String toString() {
        return a().toString() + " (Kotlin reflection is not available)";
    }
}
