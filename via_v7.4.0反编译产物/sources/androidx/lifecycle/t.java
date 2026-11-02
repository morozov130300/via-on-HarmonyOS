package androidx.lifecycle;

import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import androidx.savedstate.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class t {

    /* renamed from: f, reason: collision with root package name */
    public static final a f1060f = new a(null);

    /* renamed from: g, reason: collision with root package name */
    public static final Class[] f1061g;

    /* renamed from: a, reason: collision with root package name */
    public final Map f1062a;

    /* renamed from: b, reason: collision with root package name */
    public final Map f1063b;

    /* renamed from: c, reason: collision with root package name */
    public final Map f1064c;

    /* renamed from: d, reason: collision with root package name */
    public final Map f1065d;

    /* renamed from: e, reason: collision with root package name */
    public final a.c f1066e;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }

        public final t a(Bundle bundle, Bundle bundle2) {
            if (bundle == null) {
                if (bundle2 == null) {
                    return new t();
                }
                HashMap map = new HashMap();
                for (String key : bundle2.keySet()) {
                    kotlin.jvm.internal.h.e(key, "key");
                    map.put(key, bundle2.get(key));
                }
                return new t(map);
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
            return new t(linkedHashMap);
        }

        public final boolean b(Object obj) {
            if (obj == null) {
                return true;
            }
            for (Class cls : t.f1061g) {
                kotlin.jvm.internal.h.c(cls);
                if (cls.isInstance(obj)) {
                    return true;
                }
            }
            return false;
        }
    }

    static {
        int i10 = Build.VERSION.SDK_INT;
        Class cls = Integer.TYPE;
        f1061g = new Class[]{Boolean.TYPE, boolean[].class, Double.TYPE, double[].class, cls, int[].class, Long.TYPE, long[].class, String.class, String[].class, Binder.class, Bundle.class, Byte.TYPE, byte[].class, Character.TYPE, char[].class, CharSequence.class, CharSequence[].class, ArrayList.class, Float.TYPE, float[].class, Parcelable.class, Parcelable[].class, Serializable.class, Short.TYPE, short[].class, SparseArray.class, i10 >= 21 ? q.a() : cls, i10 >= 21 ? r.a() : cls};
    }

    public t() {
        this.f1062a = new LinkedHashMap();
        this.f1063b = new LinkedHashMap();
        this.f1064c = new LinkedHashMap();
        this.f1065d = new LinkedHashMap();
        this.f1066e = new a.c() { // from class: androidx.lifecycle.s
            @Override // androidx.savedstate.a.c
            public final Bundle b() {
                return t.d(this.f1059a);
            }
        };
    }

    public t(Map initialState) {
        kotlin.jvm.internal.h.f(initialState, "initialState");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.f1062a = linkedHashMap;
        this.f1063b = new LinkedHashMap();
        this.f1064c = new LinkedHashMap();
        this.f1065d = new LinkedHashMap();
        this.f1066e = new a.c() { // from class: androidx.lifecycle.s
            @Override // androidx.savedstate.a.c
            public final Bundle b() {
                return t.d(this.f1059a);
            }
        };
        linkedHashMap.putAll(initialState);
    }

    public static final Bundle d(t this$0) {
        kotlin.jvm.internal.h.f(this$0, "this$0");
        for (Map.Entry entry : kotlin.collections.a.i(this$0.f1063b).entrySet()) {
            this$0.e((String) entry.getKey(), ((a.c) entry.getValue()).b());
        }
        Set<String> setKeySet = this$0.f1062a.keySet();
        ArrayList arrayList = new ArrayList(setKeySet.size());
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        for (String str : setKeySet) {
            arrayList.add(str);
            arrayList2.add(this$0.f1062a.get(str));
        }
        return u.h.a(j7.d.a("keys", arrayList), j7.d.a("values", arrayList2));
    }

    public final a.c c() {
        return this.f1066e;
    }

    public final void e(String key, Object obj) {
        kotlin.jvm.internal.h.f(key, "key");
        if (!f1060f.b(obj)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Can't put value with type ");
            kotlin.jvm.internal.h.c(obj);
            sb2.append(obj.getClass());
            sb2.append(" into saved state");
            throw new IllegalArgumentException(sb2.toString());
        }
        Object obj2 = this.f1064c.get(key);
        l lVar = obj2 instanceof l ? (l) obj2 : null;
        if (lVar != null) {
            lVar.m(obj);
        } else {
            this.f1062a.put(key, obj);
        }
        n.g.a(this.f1065d.get(key));
    }
}
