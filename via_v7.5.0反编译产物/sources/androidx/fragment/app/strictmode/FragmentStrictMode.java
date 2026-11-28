package androidx.fragment.app.strictmode;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import e7.c0;
import e7.w;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class FragmentStrictMode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FragmentStrictMode f847a = new FragmentStrictMode();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static b f848b = b.f851d;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public enum Flag {
        PENALTY_LOG,
        PENALTY_DEATH,
        DETECT_FRAGMENT_REUSE,
        DETECT_FRAGMENT_TAG_USAGE,
        DETECT_WRONG_NESTED_HIERARCHY,
        DETECT_RETAIN_INSTANCE_USAGE,
        DETECT_SET_USER_VISIBLE_HINT,
        DETECT_TARGET_FRAGMENT_USAGE,
        DETECT_WRONG_FRAGMENT_CONTAINER
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface a {
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f850c = new a(null);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final b f851d = new b(c0.d(), null, kotlin.collections.a.f());

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Set f852a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map f853b;

        /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
        public static final class a {
            public /* synthetic */ a(f fVar) {
                this();
            }

            public a() {
            }
        }

        public b(Set flags, a aVar, Map allowedViolations) {
            h.f(flags, "flags");
            h.f(allowedViolations, "allowedViolations");
            this.f852a = flags;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : allowedViolations.entrySet()) {
                linkedHashMap.put((String) entry.getKey(), (Set) entry.getValue());
            }
            this.f853b = linkedHashMap;
        }

        public final Set a() {
            return this.f852a;
        }

        public final a b() {
            return null;
        }

        public final Map c() {
            return this.f853b;
        }
    }

    public static final void d(String str, Violation violation) {
        h.f(violation, "$violation");
        Log.e("FragmentStrictMode", "Policy violation with PENALTY_DEATH in " + str, violation);
        throw violation;
    }

    public static final void f(Fragment fragment, String previousFragmentId) {
        h.f(fragment, "fragment");
        h.f(previousFragmentId, "previousFragmentId");
        FragmentReuseViolation fragmentReuseViolation = new FragmentReuseViolation(fragment, previousFragmentId);
        FragmentStrictMode fragmentStrictMode = f847a;
        fragmentStrictMode.e(fragmentReuseViolation);
        b bVarB = fragmentStrictMode.b(fragment);
        if (bVarB.a().contains(Flag.DETECT_FRAGMENT_REUSE) && fragmentStrictMode.l(bVarB, fragment.getClass(), fragmentReuseViolation.getClass())) {
            fragmentStrictMode.c(bVarB, fragmentReuseViolation);
        }
    }

    public static final void g(Fragment fragment, ViewGroup viewGroup) {
        h.f(fragment, "fragment");
        FragmentTagUsageViolation fragmentTagUsageViolation = new FragmentTagUsageViolation(fragment, viewGroup);
        FragmentStrictMode fragmentStrictMode = f847a;
        fragmentStrictMode.e(fragmentTagUsageViolation);
        b bVarB = fragmentStrictMode.b(fragment);
        if (bVarB.a().contains(Flag.DETECT_FRAGMENT_TAG_USAGE) && fragmentStrictMode.l(bVarB, fragment.getClass(), fragmentTagUsageViolation.getClass())) {
            fragmentStrictMode.c(bVarB, fragmentTagUsageViolation);
        }
    }

    public static final void h(Fragment fragment) {
        h.f(fragment, "fragment");
        GetTargetFragmentUsageViolation getTargetFragmentUsageViolation = new GetTargetFragmentUsageViolation(fragment);
        FragmentStrictMode fragmentStrictMode = f847a;
        fragmentStrictMode.e(getTargetFragmentUsageViolation);
        b bVarB = fragmentStrictMode.b(fragment);
        if (bVarB.a().contains(Flag.DETECT_TARGET_FRAGMENT_USAGE) && fragmentStrictMode.l(bVarB, fragment.getClass(), getTargetFragmentUsageViolation.getClass())) {
            fragmentStrictMode.c(bVarB, getTargetFragmentUsageViolation);
        }
    }

    public static final void i(Fragment fragment, ViewGroup container) {
        h.f(fragment, "fragment");
        h.f(container, "container");
        WrongFragmentContainerViolation wrongFragmentContainerViolation = new WrongFragmentContainerViolation(fragment, container);
        FragmentStrictMode fragmentStrictMode = f847a;
        fragmentStrictMode.e(wrongFragmentContainerViolation);
        b bVarB = fragmentStrictMode.b(fragment);
        if (bVarB.a().contains(Flag.DETECT_WRONG_FRAGMENT_CONTAINER) && fragmentStrictMode.l(bVarB, fragment.getClass(), wrongFragmentContainerViolation.getClass())) {
            fragmentStrictMode.c(bVarB, wrongFragmentContainerViolation);
        }
    }

    public static final void j(Fragment fragment, Fragment expectedParentFragment, int i10) {
        h.f(fragment, "fragment");
        h.f(expectedParentFragment, "expectedParentFragment");
        WrongNestedHierarchyViolation wrongNestedHierarchyViolation = new WrongNestedHierarchyViolation(fragment, expectedParentFragment, i10);
        FragmentStrictMode fragmentStrictMode = f847a;
        fragmentStrictMode.e(wrongNestedHierarchyViolation);
        b bVarB = fragmentStrictMode.b(fragment);
        if (bVarB.a().contains(Flag.DETECT_WRONG_NESTED_HIERARCHY) && fragmentStrictMode.l(bVarB, fragment.getClass(), wrongNestedHierarchyViolation.getClass())) {
            fragmentStrictMode.c(bVarB, wrongNestedHierarchyViolation);
        }
    }

    public final b b(Fragment fragment) {
        while (fragment != null) {
            if (fragment.g1()) {
                FragmentManager fragmentManagerL0 = fragment.L0();
                h.e(fragmentManagerL0, "declaringFragment.parentFragmentManager");
                if (fragmentManagerL0.H0() != null) {
                    b bVarH0 = fragmentManagerL0.H0();
                    h.c(bVarH0);
                    return bVarH0;
                }
            }
            fragment = fragment.K0();
        }
        return f848b;
    }

    public final void c(b bVar, final Violation violation) {
        Fragment fragment = violation.getFragment();
        final String name = fragment.getClass().getName();
        if (bVar.a().contains(Flag.PENALTY_LOG)) {
            Log.d("FragmentStrictMode", "Policy violation in " + name, violation);
        }
        bVar.b();
        if (bVar.a().contains(Flag.PENALTY_DEATH)) {
            k(fragment, new Runnable() { // from class: f0.a
                @Override // java.lang.Runnable
                public final void run() {
                    FragmentStrictMode.d(name, violation);
                }
            });
        }
    }

    public final void e(Violation violation) {
        if (FragmentManager.O0(3)) {
            Log.d("FragmentManager", "StrictMode violation in " + violation.getFragment().getClass().getName(), violation);
        }
    }

    public final void k(Fragment fragment, Runnable runnable) {
        if (!fragment.g1()) {
            runnable.run();
            return;
        }
        Handler handlerS = fragment.L0().B0().s();
        if (h.a(handlerS.getLooper(), Looper.myLooper())) {
            runnable.run();
        } else {
            handlerS.post(runnable);
        }
    }

    public final boolean l(b bVar, Class cls, Class cls2) {
        Set set = (Set) bVar.c().get(cls.getName());
        if (set == null) {
            return true;
        }
        if (h.a(cls2.getSuperclass(), Violation.class) || !w.v(set, cls2.getSuperclass())) {
            return !set.contains(cls2);
        }
        return false;
    }
}
