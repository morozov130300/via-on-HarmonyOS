package androidx.activity.result;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.f;
import androidx.lifecycle.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.random.Random;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class ActivityResultRegistry {

    /* renamed from: a, reason: collision with root package name */
    public final Map f512a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final Map f513b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final Map f514c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public ArrayList f515d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    public final transient Map f516e = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    public final Map f517f = new HashMap();

    /* renamed from: g, reason: collision with root package name */
    public final Bundle f518g = new Bundle();

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a extends androidx.activity.result.b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f523a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e.a f524b;

        public a(String str, e.a aVar) {
            this.f523a = str;
            this.f524b = aVar;
        }

        @Override // androidx.activity.result.b
        public void b(Object obj, n.b bVar) throws Exception {
            Integer num = (Integer) ActivityResultRegistry.this.f513b.get(this.f523a);
            if (num != null) {
                ActivityResultRegistry.this.f515d.add(this.f523a);
                try {
                    ActivityResultRegistry.this.f(num.intValue(), this.f524b, obj, bVar);
                    return;
                } catch (Exception e10) {
                    ActivityResultRegistry.this.f515d.remove(this.f523a);
                    throw e10;
                }
            }
            throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + this.f524b + " and input " + obj + ". You must ensure the ActivityResultLauncher is registered before calling launch().");
        }

        @Override // androidx.activity.result.b
        public void c() {
            ActivityResultRegistry.this.l(this.f523a);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class b extends androidx.activity.result.b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f526a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e.a f527b;

        public b(String str, e.a aVar) {
            this.f526a = str;
            this.f527b = aVar;
        }

        @Override // androidx.activity.result.b
        public void b(Object obj, n.b bVar) throws Exception {
            Integer num = (Integer) ActivityResultRegistry.this.f513b.get(this.f526a);
            if (num != null) {
                ActivityResultRegistry.this.f515d.add(this.f526a);
                try {
                    ActivityResultRegistry.this.f(num.intValue(), this.f527b, obj, bVar);
                    return;
                } catch (Exception e10) {
                    ActivityResultRegistry.this.f515d.remove(this.f526a);
                    throw e10;
                }
            }
            throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + this.f527b + " and input " + obj + ". You must ensure the ActivityResultLauncher is registered before calling launch().");
        }

        @Override // androidx.activity.result.b
        public void c() {
            ActivityResultRegistry.this.l(this.f526a);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final androidx.activity.result.a f529a;

        /* renamed from: b, reason: collision with root package name */
        public final e.a f530b;

        public c(androidx.activity.result.a aVar, e.a aVar2) {
            this.f529a = aVar;
            this.f530b = aVar2;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public final Lifecycle f531a;

        /* renamed from: b, reason: collision with root package name */
        public final ArrayList f532b = new ArrayList();

        public d(Lifecycle lifecycle) {
            this.f531a = lifecycle;
        }

        public void a(f fVar) {
            this.f531a.a(fVar);
            this.f532b.add(fVar);
        }

        public void b() {
            Iterator it = this.f532b.iterator();
            while (it.hasNext()) {
                this.f531a.c((f) it.next());
            }
            this.f532b.clear();
        }
    }

    public final void a(int i10, String str) {
        this.f512a.put(Integer.valueOf(i10), str);
        this.f513b.put(str, Integer.valueOf(i10));
    }

    public final boolean b(int i10, int i11, Intent intent) {
        String str = (String) this.f512a.get(Integer.valueOf(i10));
        if (str == null) {
            return false;
        }
        d(str, i11, intent, (c) this.f516e.get(str));
        return true;
    }

    public final boolean c(int i10, Object obj) {
        androidx.activity.result.a aVar;
        String str = (String) this.f512a.get(Integer.valueOf(i10));
        if (str == null) {
            return false;
        }
        c cVar = (c) this.f516e.get(str);
        if (cVar == null || (aVar = cVar.f529a) == null) {
            this.f518g.remove(str);
            this.f517f.put(str, obj);
            return true;
        }
        if (!this.f515d.remove(str)) {
            return true;
        }
        aVar.a(obj);
        return true;
    }

    public final void d(String str, int i10, Intent intent, c cVar) {
        if (cVar == null || cVar.f529a == null || !this.f515d.contains(str)) {
            this.f517f.remove(str);
            this.f518g.putParcelable(str, new ActivityResult(i10, intent));
        } else {
            cVar.f529a.a(cVar.f530b.c(i10, intent));
            this.f515d.remove(str);
        }
    }

    public final int e() {
        int iNextInt = Random.Default.nextInt(2147418112);
        while (true) {
            int i10 = iNextInt + 65536;
            if (!this.f512a.containsKey(Integer.valueOf(i10))) {
                return i10;
            }
            iNextInt = Random.Default.nextInt(2147418112);
        }
    }

    public abstract void f(int i10, e.a aVar, Object obj, n.b bVar);

    public final void g(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
        ArrayList<String> stringArrayList = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
        if (stringArrayList == null || integerArrayList == null) {
            return;
        }
        this.f515d = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
        this.f518g.putAll(bundle.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT"));
        for (int i10 = 0; i10 < stringArrayList.size(); i10++) {
            String str = stringArrayList.get(i10);
            if (this.f513b.containsKey(str)) {
                Integer num = (Integer) this.f513b.remove(str);
                if (!this.f518g.containsKey(str)) {
                    this.f512a.remove(num);
                }
            }
            a(integerArrayList.get(i10).intValue(), stringArrayList.get(i10));
        }
    }

    public final void h(Bundle bundle) {
        bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList<>(this.f513b.values()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList<>(this.f513b.keySet()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList<>(this.f515d));
        bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", (Bundle) this.f518g.clone());
    }

    public final androidx.activity.result.b i(final String str, h hVar, final e.a aVar, final androidx.activity.result.a aVar2) {
        Lifecycle lifecycleK0 = hVar.k0();
        if (lifecycleK0.b().isAtLeast(Lifecycle.State.STARTED)) {
            throw new IllegalStateException("LifecycleOwner " + hVar + " is attempting to register while current state is " + lifecycleK0.b() + ". LifecycleOwners must call register before they are STARTED.");
        }
        k(str);
        d dVar = (d) this.f514c.get(str);
        if (dVar == null) {
            dVar = new d(lifecycleK0);
        }
        dVar.a(new f() { // from class: androidx.activity.result.ActivityResultRegistry.1
            @Override // androidx.lifecycle.f
            public void a(h hVar2, Lifecycle.Event event) {
                if (!Lifecycle.Event.ON_START.equals(event)) {
                    if (Lifecycle.Event.ON_STOP.equals(event)) {
                        ActivityResultRegistry.this.f516e.remove(str);
                        return;
                    } else {
                        if (Lifecycle.Event.ON_DESTROY.equals(event)) {
                            ActivityResultRegistry.this.l(str);
                            return;
                        }
                        return;
                    }
                }
                ActivityResultRegistry.this.f516e.put(str, new c(aVar2, aVar));
                if (ActivityResultRegistry.this.f517f.containsKey(str)) {
                    Object obj = ActivityResultRegistry.this.f517f.get(str);
                    ActivityResultRegistry.this.f517f.remove(str);
                    aVar2.a(obj);
                }
                ActivityResult activityResult = (ActivityResult) ActivityResultRegistry.this.f518g.getParcelable(str);
                if (activityResult != null) {
                    ActivityResultRegistry.this.f518g.remove(str);
                    aVar2.a(aVar.c(activityResult.b(), activityResult.a()));
                }
            }
        });
        this.f514c.put(str, dVar);
        return new a(str, aVar);
    }

    public final androidx.activity.result.b j(String str, e.a aVar, androidx.activity.result.a aVar2) {
        k(str);
        this.f516e.put(str, new c(aVar2, aVar));
        if (this.f517f.containsKey(str)) {
            Object obj = this.f517f.get(str);
            this.f517f.remove(str);
            aVar2.a(obj);
        }
        ActivityResult activityResult = (ActivityResult) this.f518g.getParcelable(str);
        if (activityResult != null) {
            this.f518g.remove(str);
            aVar2.a(aVar.c(activityResult.b(), activityResult.a()));
        }
        return new b(str, aVar);
    }

    public final void k(String str) {
        if (((Integer) this.f513b.get(str)) != null) {
            return;
        }
        a(e(), str);
    }

    public final void l(String str) {
        Integer num;
        if (!this.f515d.contains(str) && (num = (Integer) this.f513b.remove(str)) != null) {
            this.f512a.remove(num);
        }
        this.f516e.remove(str);
        if (this.f517f.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + this.f517f.get(str));
            this.f517f.remove(str);
        }
        if (this.f518g.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + this.f518g.getParcelable(str));
            this.f518g.remove(str);
        }
        d dVar = (d) this.f514c.get(str);
        if (dVar != null) {
            dVar.b();
            this.f514c.remove(str);
        }
    }
}
