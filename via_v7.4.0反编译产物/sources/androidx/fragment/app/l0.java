package androidx.fragment.app;

import android.os.Bundle;
import android.view.ViewGroup;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.lifecycle.Lifecycle;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class l0 {

    /* renamed from: a, reason: collision with root package name */
    public final v f887a;

    /* renamed from: b, reason: collision with root package name */
    public final ClassLoader f888b;

    /* renamed from: d, reason: collision with root package name */
    public int f890d;

    /* renamed from: e, reason: collision with root package name */
    public int f891e;

    /* renamed from: f, reason: collision with root package name */
    public int f892f;

    /* renamed from: g, reason: collision with root package name */
    public int f893g;

    /* renamed from: h, reason: collision with root package name */
    public int f894h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f895i;

    /* renamed from: k, reason: collision with root package name */
    public String f897k;

    /* renamed from: l, reason: collision with root package name */
    public int f898l;

    /* renamed from: m, reason: collision with root package name */
    public CharSequence f899m;

    /* renamed from: n, reason: collision with root package name */
    public int f900n;

    /* renamed from: o, reason: collision with root package name */
    public CharSequence f901o;

    /* renamed from: p, reason: collision with root package name */
    public ArrayList f902p;

    /* renamed from: q, reason: collision with root package name */
    public ArrayList f903q;

    /* renamed from: s, reason: collision with root package name */
    public ArrayList f905s;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList f889c = new ArrayList();

    /* renamed from: j, reason: collision with root package name */
    public boolean f896j = true;

    /* renamed from: r, reason: collision with root package name */
    public boolean f904r = false;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public int f906a;

        /* renamed from: b, reason: collision with root package name */
        public Fragment f907b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f908c;

        /* renamed from: d, reason: collision with root package name */
        public int f909d;

        /* renamed from: e, reason: collision with root package name */
        public int f910e;

        /* renamed from: f, reason: collision with root package name */
        public int f911f;

        /* renamed from: g, reason: collision with root package name */
        public int f912g;

        /* renamed from: h, reason: collision with root package name */
        public Lifecycle.State f913h;

        /* renamed from: i, reason: collision with root package name */
        public Lifecycle.State f914i;

        public a() {
        }

        public a(int i10, Fragment fragment) {
            this.f906a = i10;
            this.f907b = fragment;
            this.f908c = false;
            Lifecycle.State state = Lifecycle.State.RESUMED;
            this.f913h = state;
            this.f914i = state;
        }

        public a(int i10, Fragment fragment, Lifecycle.State state) {
            this.f906a = i10;
            this.f907b = fragment;
            this.f908c = false;
            this.f913h = fragment.f655b0;
            this.f914i = state;
        }

        public a(int i10, Fragment fragment, boolean z10) {
            this.f906a = i10;
            this.f907b = fragment;
            this.f908c = z10;
            Lifecycle.State state = Lifecycle.State.RESUMED;
            this.f913h = state;
            this.f914i = state;
        }
    }

    public l0(v vVar, ClassLoader classLoader) {
        this.f887a = vVar;
        this.f888b = classLoader;
    }

    public l0 b(int i10, Fragment fragment, String str) {
        p(i10, fragment, str, 1);
        return this;
    }

    public final l0 c(int i10, Class cls, Bundle bundle, String str) {
        return b(i10, m(cls, bundle), str);
    }

    public l0 d(ViewGroup viewGroup, Fragment fragment, String str) {
        fragment.Q = viewGroup;
        return b(viewGroup.getId(), fragment, str);
    }

    public l0 e(Fragment fragment, String str) {
        p(0, fragment, str, 1);
        return this;
    }

    public void f(a aVar) {
        this.f889c.add(aVar);
        aVar.f909d = this.f890d;
        aVar.f910e = this.f891e;
        aVar.f911f = this.f892f;
        aVar.f912g = this.f893g;
    }

    public l0 g(String str) {
        if (!this.f896j) {
            throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
        }
        this.f895i = true;
        this.f897k = str;
        return this;
    }

    public l0 h(Fragment fragment) {
        f(new a(7, fragment));
        return this;
    }

    public abstract int i();

    public abstract int j();

    public abstract void k();

    public abstract void l();

    public final Fragment m(Class cls, Bundle bundle) {
        v vVar = this.f887a;
        if (vVar == null) {
            throw new IllegalStateException("Creating a Fragment requires that this FragmentTransaction was built with FragmentManager.beginTransaction()");
        }
        ClassLoader classLoader = this.f888b;
        if (classLoader == null) {
            throw new IllegalStateException("The FragmentManager must be attached to itshost to create a Fragment");
        }
        Fragment fragmentA = vVar.a(classLoader, cls.getName());
        if (bundle != null) {
            fragmentA.H2(bundle);
        }
        return fragmentA;
    }

    public l0 n(Fragment fragment) {
        f(new a(6, fragment));
        return this;
    }

    public l0 o() {
        if (this.f895i) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        this.f896j = false;
        return this;
    }

    public void p(int i10, Fragment fragment, String str, int i11) {
        String str2 = fragment.f654a0;
        if (str2 != null) {
            FragmentStrictMode.f(fragment, str2);
        }
        Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            String str3 = fragment.I;
            if (str3 != null && !str.equals(str3)) {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.I + " now " + str);
            }
            fragment.I = str;
        }
        if (i10 != 0) {
            if (i10 == -1) {
                throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
            }
            int i12 = fragment.G;
            if (i12 != 0 && i12 != i10) {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.G + " now " + i10);
            }
            fragment.G = i10;
            fragment.H = i10;
        }
        f(new a(i11, fragment));
    }

    public l0 q(Fragment fragment) {
        f(new a(4, fragment));
        return this;
    }

    public abstract boolean r();

    public l0 s(Fragment fragment) {
        f(new a(3, fragment));
        return this;
    }

    public l0 t(int i10, Fragment fragment, String str) {
        if (i10 == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        p(i10, fragment, str, 2);
        return this;
    }

    public final l0 u(int i10, Class cls, Bundle bundle, String str) {
        return t(i10, m(cls, bundle), str);
    }

    public l0 v(int i10, int i11, int i12, int i13) {
        this.f890d = i10;
        this.f891e = i11;
        this.f892f = i12;
        this.f893g = i13;
        return this;
    }

    public l0 w(Fragment fragment, Lifecycle.State state) {
        f(new a(10, fragment, state));
        return this;
    }

    public l0 x(boolean z10) {
        this.f904r = z10;
        return this;
    }
}
