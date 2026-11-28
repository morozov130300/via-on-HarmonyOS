package androidx.lifecycle;

import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class v {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f975f = new a(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Class[] f976g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f977a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f978b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f979c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map f980d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final androidx.savedstate.a.c f981e;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }

        public final v a(Bundle bundle, Bundle bundle2) {
            if (bundle == null) {
                if (bundle2 == null) {
                    return new v();
                }
                HashMap map = new HashMap();
                for (String key : bundle2.keySet()) {
                    kotlin.jvm.internal.h.e(key, "key");
                    map.put(key, bundle2.get(key));
                }
                return new v(map);
            }
            ArrayList parcelableArrayList = bundle.getParcelableArrayList("keys");
            ArrayList parcelableArrayList2 = bundle.getParcelableArrayList("values");
            if (parcelableArrayList == null || parcelableArrayList2 == null || parcelableArrayList.size() != parcelableArrayList2.size()) {
                throw new IllegalStateException("Invalid bundle passed as restored state");
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int size = parcelableArrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                Object obj = parcelableArrayList.get(i10);
                kotlin.jvm.internal.h.d(obj, "null cannot be cast to non-null type kotlin.String");
                linkedHashMap.put((String) obj, parcelableArrayList2.get(i10));
            }
            return new v(linkedHashMap);
        }

        public final boolean b(Object obj) {
            if (obj == null) {
                return true;
            }
            for (Class cls : v.f976g) {
                kotlin.jvm.internal.h.c(cls);
                if (cls.isInstance(obj)) {
                    return true;
                }
            }
            return false;
        }

        public a() {
        }
    }

    static {
        int i10 = Build.VERSION.SDK_INT;
        Class cls = Integer.TYPE;
        f976g = new Class[]{Boolean.TYPE, boolean[].class, Double.TYPE, double[].class, cls, int[].class, Long.TYPE, long[].class, String.class, String[].class, Binder.class, Bundle.class, Byte.TYPE, byte[].class, Character.TYPE, char[].class, CharSequence.class, CharSequence[].class, ArrayList.class, Float.TYPE, float[].class, Parcelable.class, Parcelable[].class, Serializable.class, Short.TYPE, short[].class, SparseArray.class, i10 >= 21 ? s.a() : cls, i10 >= 21 ? t.a() : cls};
    }

    public v(Map initialState) {
        kotlin.jvm.internal.h.f(initialState, "initialState");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.f977a = linkedHashMap;
        this.f978b = new LinkedHashMap();
        this.f979c = new LinkedHashMap();
        this.f980d = new LinkedHashMap();
        this.f981e = new androidx.savedstate.a.c() { // from class: androidx.lifecycle.u
            @Override // androidx.savedstate.a.c
            public final Bundle b() {
                return v.d(this.f974a);
            }
        };
        linkedHashMap.putAll(initialState);
    }

    public static final Bundle d(v this$0) {
        kotlin.jvm.internal.h.f(this$0, "this$0");
        for (Map.Entry entry : kotlin.collections.a.n(this$0.f978b).entrySet()) {
            this$0.e((String) entry.getKey(), ((androidx.savedstate.a.c) entry.getValue()).b());
        }
        Set<String> setKeySet = this$0.f977a.keySet();
        ArrayList arrayList = new ArrayList(setKeySet.size());
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        for (String str : setKeySet) {
            arrayList.add(str);
            arrayList2.add(this$0.f977a.get(str));
        }
        return v.h.a(d7.f.a("keys", arrayList), d7.f.a("values", arrayList2));
    }

    public final androidx.savedstate.a.c c() {
        return this.f981e;
    }

    public final void e(String key, Object obj) {
        kotlin.jvm.internal.h.f(key, "key");
        if (!f975f.b(obj)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Can't put value with type ");
            kotlin.jvm.internal.h.c(obj);
            sb2.append(obj.getClass());
            sb2.append(" into saved state");
            throw new IllegalArgumentException(sb2.toString());
        }
        Object obj2 = this.f979c.get(key);
        n nVar = obj2 instanceof n ? (n) obj2 : null;
        if (nVar != null) {
            nVar.m(obj);
        } else {
            this.f977a.put(key, obj);
        }
        n.g.a(this.f980d.get(key));
    }

    public v() {
        this.f977a = new LinkedHashMap();
        this.f978b = new LinkedHashMap();
        this.f979c = new LinkedHashMap();
        this.f980d = new LinkedHashMap();
        this.f981e = new androidx.savedstate.a.c() { // from class: androidx.lifecycle.u
            @Override // androidx.savedstate.a.c
            public final Bundle b() {
                return v.d(this.f974a);
            }
        };
    }
}
