package androidx.fragment.app;

import android.util.Log;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.l0;
import androidx.lifecycle.Lifecycle;
import java.io.PrintWriter;
import java.util.ArrayList;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class a extends l0 implements FragmentManager.n {

    /* renamed from: t, reason: collision with root package name */
    public final FragmentManager f819t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f820u;

    /* renamed from: v, reason: collision with root package name */
    public int f821v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f822w;

    public a(FragmentManager fragmentManager) {
        super(fragmentManager.z0(), fragmentManager.B0() != null ? fragmentManager.B0().r().getClassLoader() : null);
        this.f821v = -1;
        this.f822w = false;
        this.f819t = fragmentManager;
    }

    public void A(String str, PrintWriter printWriter) {
        B(str, printWriter, true);
    }

    public void B(String str, PrintWriter printWriter, boolean z10) {
        String str2;
        if (z10) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f897k);
            printWriter.print(" mIndex=");
            printWriter.print(this.f821v);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f820u);
            if (this.f894h != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f894h));
            }
            if (this.f890d != 0 || this.f891e != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f890d));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f891e));
            }
            if (this.f892f != 0 || this.f893g != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f892f));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f893g));
            }
            if (this.f898l != 0 || this.f899m != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f898l));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f899m);
            }
            if (this.f900n != 0 || this.f901o != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f900n));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f901o);
            }
        }
        if (this.f889c.isEmpty()) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Operations:");
        int size = this.f889c.size();
        for (int i10 = 0; i10 < size; i10++) {
            l0.a aVar = (l0.a) this.f889c.get(i10);
            switch (aVar.f906a) {
                case 0:
                    str2 = "NULL";
                    break;
                case 1:
                    str2 = "ADD";
                    break;
                case 2:
                    str2 = "REPLACE";
                    break;
                case WebSettingsBoundaryInterface.AttributionBehavior.APP_SOURCE_AND_APP_TRIGGER /* 3 */:
                    str2 = "REMOVE";
                    break;
                case 4:
                    str2 = "HIDE";
                    break;
                case 5:
                    str2 = "SHOW";
                    break;
                case 6:
                    str2 = "DETACH";
                    break;
                case 7:
                    str2 = "ATTACH";
                    break;
                case 8:
                    str2 = "SET_PRIMARY_NAV";
                    break;
                case 9:
                    str2 = "UNSET_PRIMARY_NAV";
                    break;
                case 10:
                    str2 = "OP_SET_MAX_LIFECYCLE";
                    break;
                default:
                    str2 = "cmd=" + aVar.f906a;
                    break;
            }
            printWriter.print(str);
            printWriter.print("  Op #");
            printWriter.print(i10);
            printWriter.print(": ");
            printWriter.print(str2);
            printWriter.print(" ");
            printWriter.println(aVar.f907b);
            if (z10) {
                if (aVar.f909d != 0 || aVar.f910e != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.f909d));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.f910e));
                }
                if (aVar.f911f != 0 || aVar.f912g != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.f911f));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.f912g));
                }
            }
        }
    }

    public void C() {
        int size = this.f889c.size();
        for (int i10 = 0; i10 < size; i10++) {
            l0.a aVar = (l0.a) this.f889c.get(i10);
            Fragment fragment = aVar.f907b;
            if (fragment != null) {
                fragment.f679w = this.f822w;
                fragment.M2(false);
                fragment.L2(this.f894h);
                fragment.O2(this.f902p, this.f903q);
            }
            switch (aVar.f906a) {
                case 1:
                    fragment.G2(aVar.f909d, aVar.f910e, aVar.f911f, aVar.f912g);
                    this.f819t.w1(fragment, false);
                    this.f819t.k(fragment);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f906a);
                case WebSettingsBoundaryInterface.AttributionBehavior.APP_SOURCE_AND_APP_TRIGGER /* 3 */:
                    fragment.G2(aVar.f909d, aVar.f910e, aVar.f911f, aVar.f912g);
                    this.f819t.n1(fragment);
                    break;
                case 4:
                    fragment.G2(aVar.f909d, aVar.f910e, aVar.f911f, aVar.f912g);
                    this.f819t.L0(fragment);
                    break;
                case 5:
                    fragment.G2(aVar.f909d, aVar.f910e, aVar.f911f, aVar.f912g);
                    this.f819t.w1(fragment, false);
                    this.f819t.C1(fragment);
                    break;
                case 6:
                    fragment.G2(aVar.f909d, aVar.f910e, aVar.f911f, aVar.f912g);
                    this.f819t.B(fragment);
                    break;
                case 7:
                    fragment.G2(aVar.f909d, aVar.f910e, aVar.f911f, aVar.f912g);
                    this.f819t.w1(fragment, false);
                    this.f819t.p(fragment);
                    break;
                case 8:
                    this.f819t.A1(fragment);
                    break;
                case 9:
                    this.f819t.A1(null);
                    break;
                case 10:
                    this.f819t.z1(fragment, aVar.f914i);
                    break;
            }
        }
    }

    public void D() {
        for (int size = this.f889c.size() - 1; size >= 0; size--) {
            l0.a aVar = (l0.a) this.f889c.get(size);
            Fragment fragment = aVar.f907b;
            if (fragment != null) {
                fragment.f679w = this.f822w;
                fragment.M2(true);
                fragment.L2(FragmentManager.s1(this.f894h));
                fragment.O2(this.f903q, this.f902p);
            }
            switch (aVar.f906a) {
                case 1:
                    fragment.G2(aVar.f909d, aVar.f910e, aVar.f911f, aVar.f912g);
                    this.f819t.w1(fragment, true);
                    this.f819t.n1(fragment);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f906a);
                case WebSettingsBoundaryInterface.AttributionBehavior.APP_SOURCE_AND_APP_TRIGGER /* 3 */:
                    fragment.G2(aVar.f909d, aVar.f910e, aVar.f911f, aVar.f912g);
                    this.f819t.k(fragment);
                    break;
                case 4:
                    fragment.G2(aVar.f909d, aVar.f910e, aVar.f911f, aVar.f912g);
                    this.f819t.C1(fragment);
                    break;
                case 5:
                    fragment.G2(aVar.f909d, aVar.f910e, aVar.f911f, aVar.f912g);
                    this.f819t.w1(fragment, true);
                    this.f819t.L0(fragment);
                    break;
                case 6:
                    fragment.G2(aVar.f909d, aVar.f910e, aVar.f911f, aVar.f912g);
                    this.f819t.p(fragment);
                    break;
                case 7:
                    fragment.G2(aVar.f909d, aVar.f910e, aVar.f911f, aVar.f912g);
                    this.f819t.w1(fragment, true);
                    this.f819t.B(fragment);
                    break;
                case 8:
                    this.f819t.A1(null);
                    break;
                case 9:
                    this.f819t.A1(fragment);
                    break;
                case 10:
                    this.f819t.z1(fragment, aVar.f913h);
                    break;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Fragment E(ArrayList arrayList, Fragment fragment) {
        Fragment fragment2 = fragment;
        int i10 = 0;
        while (i10 < this.f889c.size()) {
            l0.a aVar = (l0.a) this.f889c.get(i10);
            int i11 = aVar.f906a;
            if (i11 == 1) {
                arrayList.add(aVar.f907b);
            } else if (i11 == 2) {
                Fragment fragment3 = aVar.f907b;
                int i12 = fragment3.H;
                boolean z10 = false;
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    Fragment fragment4 = (Fragment) arrayList.get(size);
                    if (fragment4.H == i12) {
                        if (fragment4 == fragment3) {
                            z10 = true;
                        } else {
                            if (fragment4 == fragment2) {
                                this.f889c.add(i10, new l0.a(9, fragment4, true));
                                i10++;
                                fragment2 = null;
                            }
                            l0.a aVar2 = new l0.a(3, fragment4, true);
                            aVar2.f909d = aVar.f909d;
                            aVar2.f911f = aVar.f911f;
                            aVar2.f910e = aVar.f910e;
                            aVar2.f912g = aVar.f912g;
                            this.f889c.add(i10, aVar2);
                            arrayList.remove(fragment4);
                            i10++;
                        }
                    }
                }
                if (z10) {
                    this.f889c.remove(i10);
                    i10--;
                } else {
                    aVar.f906a = 1;
                    aVar.f908c = true;
                    arrayList.add(fragment3);
                }
            } else if (i11 == 3 || i11 == 6) {
                arrayList.remove(aVar.f907b);
                Fragment fragment5 = aVar.f907b;
                if (fragment5 == fragment2) {
                    this.f889c.add(i10, new l0.a(9, fragment5));
                    i10++;
                    fragment2 = null;
                }
            } else if (i11 != 7) {
                if (i11 == 8) {
                    this.f889c.add(i10, new l0.a(9, fragment2, true));
                    aVar.f908c = true;
                    i10++;
                    fragment2 = aVar.f907b;
                }
            }
            i10++;
        }
        return fragment2;
    }

    public String F() {
        return this.f897k;
    }

    public void G() {
        if (this.f905s != null) {
            for (int i10 = 0; i10 < this.f905s.size(); i10++) {
                ((Runnable) this.f905s.get(i10)).run();
            }
            this.f905s = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Fragment H(ArrayList arrayList, Fragment fragment) {
        for (int size = this.f889c.size() - 1; size >= 0; size--) {
            l0.a aVar = (l0.a) this.f889c.get(size);
            int i10 = aVar.f906a;
            if (i10 == 1) {
                arrayList.remove(aVar.f907b);
            } else if (i10 != 3) {
                switch (i10) {
                    case 6:
                        arrayList.add(aVar.f907b);
                        break;
                    case 8:
                        fragment = null;
                        break;
                    case 9:
                        fragment = aVar.f907b;
                        break;
                    case 10:
                        aVar.f914i = aVar.f913h;
                        break;
                }
            }
        }
        return fragment;
    }

    @Override // androidx.fragment.app.FragmentManager.n
    public boolean a(ArrayList arrayList, ArrayList arrayList2) {
        if (FragmentManager.O0(2)) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (!this.f895i) {
            return true;
        }
        this.f819t.j(this);
        return true;
    }

    @Override // androidx.fragment.app.l0
    public int i() {
        return z(false);
    }

    @Override // androidx.fragment.app.l0
    public int j() {
        return z(true);
    }

    @Override // androidx.fragment.app.l0
    public void k() {
        o();
        this.f819t.g0(this, false);
    }

    @Override // androidx.fragment.app.l0
    public void l() {
        o();
        this.f819t.g0(this, true);
    }

    @Override // androidx.fragment.app.l0
    public l0 n(Fragment fragment) {
        FragmentManager fragmentManager = fragment.C;
        if (fragmentManager == null || fragmentManager == this.f819t) {
            return super.n(fragment);
        }
        throw new IllegalStateException("Cannot detach Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    @Override // androidx.fragment.app.l0
    public void p(int i10, Fragment fragment, String str, int i11) {
        super.p(i10, fragment, str, i11);
        fragment.C = this.f819t;
    }

    @Override // androidx.fragment.app.l0
    public l0 q(Fragment fragment) {
        FragmentManager fragmentManager = fragment.C;
        if (fragmentManager == null || fragmentManager == this.f819t) {
            return super.q(fragment);
        }
        throw new IllegalStateException("Cannot hide Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    @Override // androidx.fragment.app.l0
    public boolean r() {
        return this.f889c.isEmpty();
    }

    @Override // androidx.fragment.app.l0
    public l0 s(Fragment fragment) {
        FragmentManager fragmentManager = fragment.C;
        if (fragmentManager == null || fragmentManager == this.f819t) {
            return super.s(fragment);
        }
        throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("BackStackEntry{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f821v >= 0) {
            sb2.append(" #");
            sb2.append(this.f821v);
        }
        if (this.f897k != null) {
            sb2.append(" ");
            sb2.append(this.f897k);
        }
        sb2.append("}");
        return sb2.toString();
    }

    @Override // androidx.fragment.app.l0
    public l0 w(Fragment fragment, Lifecycle.State state) {
        if (fragment.C != this.f819t) {
            throw new IllegalArgumentException("Cannot setMaxLifecycle for Fragment not attached to FragmentManager " + this.f819t);
        }
        if (state == Lifecycle.State.INITIALIZED && fragment.f658e > -1) {
            throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + state + " after the Fragment has been created");
        }
        if (state != Lifecycle.State.DESTROYED) {
            return super.w(fragment, state);
        }
        throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + state + ". Use remove() to remove the fragment from the FragmentManager and trigger its destruction.");
    }

    public void y(int i10) {
        if (this.f895i) {
            if (FragmentManager.O0(2)) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i10);
            }
            int size = this.f889c.size();
            for (int i11 = 0; i11 < size; i11++) {
                l0.a aVar = (l0.a) this.f889c.get(i11);
                Fragment fragment = aVar.f907b;
                if (fragment != null) {
                    fragment.B += i10;
                    if (FragmentManager.O0(2)) {
                        Log.v("FragmentManager", "Bump nesting of " + aVar.f907b + " to " + aVar.f907b.B);
                    }
                }
            }
        }
    }

    public int z(boolean z10) {
        if (this.f820u) {
            throw new IllegalStateException("commit already called");
        }
        if (FragmentManager.O0(2)) {
            Log.v("FragmentManager", "Commit: " + this);
            PrintWriter printWriter = new PrintWriter(new v0("FragmentManager"));
            A("  ", printWriter);
            printWriter.close();
        }
        this.f820u = true;
        if (this.f895i) {
            this.f821v = this.f819t.n();
        } else {
            this.f821v = -1;
        }
        this.f819t.d0(this, z10);
        return this.f821v;
    }
}
