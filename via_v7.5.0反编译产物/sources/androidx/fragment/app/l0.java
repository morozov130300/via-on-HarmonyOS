package androidx.fragment.app;

import android.os.Bundle;
import android.view.ViewGroup;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.lifecycle.Lifecycle;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v f788a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ClassLoader f789b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f791d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f792e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f793f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f794g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f795h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f796i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f798k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f799l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public CharSequence f800m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f801n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public CharSequence f802o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ArrayList f803p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ArrayList f804q;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ArrayList f806s;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ArrayList f790c = new ArrayList();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f797j = true;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f805r = false;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f807a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Fragment f808b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f809c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f810d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f811e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f812f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f813g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Lifecycle.State f814h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Lifecycle.State f815i;

        public a() {
        }

        public a(int i10, Fragment fragment) {
            this.f807a = i10;
            this.f808b = fragment;
            this.f809c = false;
            Lifecycle.State state = Lifecycle.State.RESUMED;
            this.f814h = state;
            this.f815i = state;
        }

        public a(int i10, Fragment fragment, boolean z10) {
            this.f807a = i10;
            this.f808b = fragment;
            this.f809c = z10;
            Lifecycle.State state = Lifecycle.State.RESUMED;
            this.f814h = state;
            this.f815i = state;
        }

        public a(int i10, Fragment fragment, Lifecycle.State state) {
            this.f807a = i10;
            this.f808b = fragment;
            this.f809c = false;
            this.f814h = fragment.f561d0;
            this.f815i = state;
        }
    }

    public l0(v vVar, ClassLoader classLoader) {
        this.f788a = vVar;
        this.f789b = classLoader;
    }

    public l0 b(int i10, Fragment fragment, String str) {
        p(i10, fragment, str, 1);
        return this;
    }

    public final l0 c(int i10, Class cls, Bundle bundle, String str) {
        return b(i10, m(cls, bundle), str);
    }

    public l0 d(ViewGroup viewGroup, Fragment fragment, String str) {
        fragment.S = viewGroup;
        return b(viewGroup.getId(), fragment, str);
    }

    public l0 e(Fragment fragment, String str) {
        p(0, fragment, str, 1);
        return this;
    }

    public void f(a aVar) {
        this.f790c.add(aVar);
        aVar.f810d = this.f791d;
        aVar.f811e = this.f792e;
        aVar.f812f = this.f793f;
        aVar.f813g = this.f794g;
    }

    public l0 g(String str) {
        if (!this.f797j) {
            throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
        }
        this.f796i = true;
        this.f798k = str;
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
        v vVar = this.f788a;
        if (vVar == null) {
            throw new IllegalStateException("Creating a Fragment requires that this FragmentTransaction was built with FragmentManager.beginTransaction()");
        }
        ClassLoader classLoader = this.f789b;
        if (classLoader == null) {
            throw new IllegalStateException("The FragmentManager must be attached to itshost to create a Fragment");
        }
        Fragment fragmentA = vVar.a(classLoader, cls.getName());
        if (bundle != null) {
            fragmentA.F2(bundle);
        }
        return fragmentA;
    }

    public l0 n(Fragment fragment) {
        f(new a(6, fragment));
        return this;
    }

    public l0 o() {
        if (this.f796i) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        this.f797j = false;
        return this;
    }

    public void p(int i10, Fragment fragment, String str, int i11) {
        String str2 = fragment.f560c0;
        if (str2 != null) {
            FragmentStrictMode.f(fragment, str2);
        }
        Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            String str3 = fragment.K;
            if (str3 != null && !str.equals(str3)) {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.K + " now " + str);
            }
            fragment.K = str;
        }
        if (i10 != 0) {
            if (i10 == -1) {
                throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
            }
            int i12 = fragment.I;
            if (i12 != 0 && i12 != i10) {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.I + " now " + i10);
            }
            fragment.I = i10;
            fragment.J = i10;
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
        this.f791d = i10;
        this.f792e = i11;
        this.f793f = i12;
        this.f794g = i13;
        return this;
    }

    public l0 w(Fragment fragment, Lifecycle.State state) {
        f(new a(10, fragment, state));
        return this;
    }

    public l0 x(boolean z10) {
        this.f805r = z10;
        return this;
    }
}
