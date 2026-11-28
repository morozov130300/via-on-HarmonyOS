package kotlin.jvm.internal;

import e7.a0;
import e7.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.text.z;
import p7.m;
import p7.n;
import p7.p;
import p7.q;
import p7.r;
import p7.s;
import p7.t;
import p7.u;
import p7.v;
import p7.w;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class d implements t7.c, c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f7308e = new a(null);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Map f7309m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final HashMap f7310n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final HashMap f7311o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final HashMap f7312p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Map f7313q;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Class f7314c;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a {
        public /* synthetic */ a(f fVar) {
            this();
        }

        public a() {
        }
    }

    static {
        int i10 = 0;
        List listK = o.k(p7.a.class, p7.l.class, p.class, q.class, r.class, s.class, t.class, u.class, v.class, w.class, p7.b.class, p7.c.class, p7.d.class, p7.e.class, p7.f.class, p7.g.class, p7.h.class, p7.i.class, p7.j.class, p7.k.class, m.class, n.class, p7.o.class);
        ArrayList arrayList = new ArrayList(e7.p.o(listK, 10));
        for (Object obj : listK) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                o.n();
            }
            arrayList.add(d7.f.a((Class) obj, Integer.valueOf(i10)));
            i10 = i11;
        }
        f7309m = kotlin.collections.a.l(arrayList);
        HashMap map = new HashMap();
        map.put("boolean", "kotlin.Boolean");
        map.put("char", "kotlin.Char");
        map.put("byte", "kotlin.Byte");
        map.put("short", "kotlin.Short");
        map.put("int", "kotlin.Int");
        map.put("float", "kotlin.Float");
        map.put("long", "kotlin.Long");
        map.put("double", "kotlin.Double");
        f7310n = map;
        HashMap map2 = new HashMap();
        map2.put("java.lang.Boolean", "kotlin.Boolean");
        map2.put("java.lang.Character", "kotlin.Char");
        map2.put("java.lang.Byte", "kotlin.Byte");
        map2.put("java.lang.Short", "kotlin.Short");
        map2.put("java.lang.Integer", "kotlin.Int");
        map2.put("java.lang.Float", "kotlin.Float");
        map2.put("java.lang.Long", "kotlin.Long");
        map2.put("java.lang.Double", "kotlin.Double");
        f7311o = map2;
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
        h.e(collectionValues, "<get-values>(...)");
        for (String str : collectionValues) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("kotlin.jvm.internal.");
            h.c(str);
            sb2.append(z.s0(str, '.', null, 2, null));
            sb2.append("CompanionObject");
            Pair pairA = d7.f.a(sb2.toString(), str + ".Companion");
            map3.put(pairA.getFirst(), pairA.getSecond());
        }
        for (Map.Entry entry : f7309m.entrySet()) {
            map3.put(((Class) entry.getKey()).getName(), "kotlin.Function" + ((Number) entry.getValue()).intValue());
        }
        f7312p = map3;
        LinkedHashMap linkedHashMap = new LinkedHashMap(a0.c(map3.size()));
        for (Map.Entry entry2 : map3.entrySet()) {
            Object key = entry2.getKey();
            String str2 = (String) entry2.getValue();
            h.c(str2);
            linkedHashMap.put(key, z.s0(str2, '.', null, 2, null));
        }
        f7313q = linkedHashMap;
    }

    public d(Class jClass) {
        h.f(jClass, "jClass");
        this.f7314c = jClass;
    }

    @Override // kotlin.jvm.internal.c
    public Class a() {
        return this.f7314c;
    }

    public boolean equals(Object obj) {
        return (obj instanceof d) && h.a(o7.a.b(this), o7.a.b((t7.c) obj));
    }

    public int hashCode() {
        return o7.a.b(this).hashCode();
    }

    public String toString() {
        return a() + " (Kotlin reflection is not available)";
    }
}
