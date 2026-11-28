package androidx.fragment.app;

import android.util.Log;
import androidx.lifecycle.Lifecycle;
import java.io.PrintWriter;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class a extends l0 implements FragmentManager.n {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final FragmentManager f722t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f723u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f724v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f725w;

    public a(FragmentManager fragmentManager) {
        super(fragmentManager.z0(), fragmentManager.B0() != null ? fragmentManager.B0().q().getClassLoader() : null);
        this.f724v = -1;
        this.f725w = false;
        this.f722t = fragmentManager;
    }

    public void A(String str, PrintWriter printWriter) {
        B(str, printWriter, true);
    }

    public void B(String str, PrintWriter printWriter, boolean z10) {
        String str2;
        if (z10) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f798k);
            printWriter.print(" mIndex=");
            printWriter.print(this.f724v);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f723u);
            if (this.f795h != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f795h));
            }
            if (this.f791d != 0 || this.f792e != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f791d));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f792e));
            }
            if (this.f793f != 0 || this.f794g != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f793f));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f794g));
            }
            if (this.f799l != 0 || this.f800m != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f799l));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f800m);
            }
            if (this.f801n != 0 || this.f802o != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f801n));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f802o);
            }
        }
        if (this.f790c.isEmpty()) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Operations:");
        int size = this.f790c.size();
        for (int i10 = 0; i10 < size; i10++) {
            l0.a aVar = (l0.a) this.f790c.get(i10);
            switch (aVar.f807a) {
                case 0:
                    str2 = "NULL";
                    break;
                case 1:
                    str2 = "ADD";
                    break;
                case 2:
                    str2 = "REPLACE";
                    break;
                case 3:
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
                    str2 = "cmd=" + aVar.f807a;
                    break;
            }
            printWriter.print(str);
            printWriter.print("  Op #");
            printWriter.print(i10);
            printWriter.print(": ");
            printWriter.print(str2);
            printWriter.print(" ");
            printWriter.println(aVar.f808b);
            if (z10) {
                if (aVar.f810d != 0 || aVar.f811e != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.f810d));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.f811e));
                }
                if (aVar.f812f != 0 || aVar.f813g != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.f812f));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.f813g));
                }
            }
        }
    }

    public void C() {
        int size = this.f790c.size();
        for (int i10 = 0; i10 < size; i10++) {
            l0.a aVar = (l0.a) this.f790c.get(i10);
            Fragment fragment = aVar.f808b;
            if (fragment != null) {
                fragment.f584y = this.f725w;
                fragment.K2(false);
                fragment.J2(this.f795h);
                fragment.M2(this.f803p, this.f804q);
            }
            switch (aVar.f807a) {
                case 1:
                    fragment.E2(aVar.f810d, aVar.f811e, aVar.f812f, aVar.f813g);
                    this.f722t.x1(fragment, false);
                    this.f722t.k(fragment);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f807a);
                case 3:
                    fragment.E2(aVar.f810d, aVar.f811e, aVar.f812f, aVar.f813g);
                    this.f722t.n1(fragment);
                    break;
                case 4:
                    fragment.E2(aVar.f810d, aVar.f811e, aVar.f812f, aVar.f813g);
                    this.f722t.L0(fragment);
                    break;
                case 5:
                    fragment.E2(aVar.f810d, aVar.f811e, aVar.f812f, aVar.f813g);
                    this.f722t.x1(fragment, false);
                    this.f722t.D1(fragment);
                    break;
                case 6:
                    fragment.E2(aVar.f810d, aVar.f811e, aVar.f812f, aVar.f813g);
                    this.f722t.B(fragment);
                    break;
                case 7:
                    fragment.E2(aVar.f810d, aVar.f811e, aVar.f812f, aVar.f813g);
                    this.f722t.x1(fragment, false);
                    this.f722t.p(fragment);
                    break;
                case 8:
                    this.f722t.B1(fragment);
                    break;
                case 9:
                    this.f722t.B1(null);
                    break;
                case 10:
                    this.f722t.A1(fragment, aVar.f815i);
                    break;
            }
        }
    }

    public void D() {
        for (int size = this.f790c.size() - 1; size >= 0; size--) {
            l0.a aVar = (l0.a) this.f790c.get(size);
            Fragment fragment = aVar.f808b;
            if (fragment != null) {
                fragment.f584y = this.f725w;
                fragment.K2(true);
                fragment.J2(FragmentManager.t1(this.f795h));
                fragment.M2(this.f804q, this.f803p);
            }
            switch (aVar.f807a) {
                case 1:
                    fragment.E2(aVar.f810d, aVar.f811e, aVar.f812f, aVar.f813g);
                    this.f722t.x1(fragment, true);
                    this.f722t.n1(fragment);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f807a);
                case 3:
                    fragment.E2(aVar.f810d, aVar.f811e, aVar.f812f, aVar.f813g);
                    this.f722t.k(fragment);
                    break;
                case 4:
                    fragment.E2(aVar.f810d, aVar.f811e, aVar.f812f, aVar.f813g);
                    this.f722t.D1(fragment);
                    break;
                case 5:
                    fragment.E2(aVar.f810d, aVar.f811e, aVar.f812f, aVar.f813g);
                    this.f722t.x1(fragment, true);
                    this.f722t.L0(fragment);
                    break;
                case 6:
                    fragment.E2(aVar.f810d, aVar.f811e, aVar.f812f, aVar.f813g);
                    this.f722t.p(fragment);
                    break;
                case 7:
                    fragment.E2(aVar.f810d, aVar.f811e, aVar.f812f, aVar.f813g);
                    this.f722t.x1(fragment, true);
                    this.f722t.B(fragment);
                    break;
                case 8:
                    this.f722t.B1(null);
                    break;
                case 9:
                    this.f722t.B1(fragment);
                    break;
                case 10:
                    this.f722t.A1(fragment, aVar.f814h);
                    break;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00b6  */
    public Fragment E(ArrayList arrayList, Fragment fragment) {
        Fragment fragment2 = fragment;
        int i10 = 0;
        while (i10 < this.f790c.size()) {
            l0.a aVar = (l0.a) this.f790c.get(i10);
            int i11 = aVar.f807a;
            if (i11 == 1) {
                arrayList.add(aVar.f808b);
            } else if (i11 == 2) {
                Fragment fragment3 = aVar.f808b;
                int i12 = fragment3.J;
                boolean z10 = false;
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    Fragment fragment4 = (Fragment) arrayList.get(size);
                    if (fragment4.J == i12) {
                        if (fragment4 == fragment3) {
                            z10 = true;
                        } else {
                            if (fragment4 == fragment2) {
                                this.f790c.add(i10, new l0.a(9, fragment4, true));
                                i10++;
                                fragment2 = null;
                            }
                            l0.a aVar2 = new l0.a(3, fragment4, true);
                            aVar2.f810d = aVar.f810d;
                            aVar2.f812f = aVar.f812f;
                            aVar2.f811e = aVar.f811e;
                            aVar2.f813g = aVar.f813g;
                            this.f790c.add(i10, aVar2);
                            arrayList.remove(fragment4);
                            i10++;
                        }
                    }
                }
                if (z10) {
                    this.f790c.remove(i10);
                    i10--;
                } else {
                    aVar.f807a = 1;
                    aVar.f809c = true;
                    arrayList.add(fragment3);
                }
            } else if (i11 == 3 || i11 == 6) {
                arrayList.remove(aVar.f808b);
                Fragment fragment5 = aVar.f808b;
                if (fragment5 == fragment2) {
                    this.f790c.add(i10, new l0.a(9, fragment5));
                    i10++;
                    fragment2 = null;
                }
            } else if (i11 == 7) {
                arrayList.add(aVar.f808b);
            } else if (i11 == 8) {
                this.f790c.add(i10, new l0.a(9, fragment2, true));
                aVar.f809c = true;
                i10++;
                fragment2 = aVar.f808b;
            }
            i10++;
        }
        return fragment2;
    }

    public String F() {
        return this.f798k;
    }

    public void G() {
        if (this.f806s != null) {
            for (int i10 = 0; i10 < this.f806s.size(); i10++) {
                ((Runnable) this.f806s.get(i10)).run();
            }
            this.f806s = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0027  */
    /* JADX WARN: Code duplicated, block: B:14:0x002d  */
    public Fragment H(ArrayList arrayList, Fragment fragment) {
        for (int size = this.f790c.size() - 1; size >= 0; size--) {
            l0.a aVar = (l0.a) this.f790c.get(size);
            int i10 = aVar.f807a;
            if (i10 == 1) {
                arrayList.remove(aVar.f808b);
            } else if (i10 != 3) {
                switch (i10) {
                    case 6:
                        arrayList.add(aVar.f808b);
                        break;
                    case 7:
                        arrayList.remove(aVar.f808b);
                        break;
                    case 8:
                        fragment = null;
                        break;
                    case 9:
                        fragment = aVar.f808b;
                        break;
                    case 10:
                        aVar.f815i = aVar.f814h;
                        break;
                }
            } else {
                arrayList.add(aVar.f808b);
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
        if (!this.f796i) {
            return true;
        }
        this.f722t.j(this);
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
        this.f722t.g0(this, false);
    }

    @Override // androidx.fragment.app.l0
    public void l() {
        o();
        this.f722t.g0(this, true);
    }

    @Override // androidx.fragment.app.l0
    public l0 n(Fragment fragment) {
        FragmentManager fragmentManager = fragment.E;
        if (fragmentManager == null || fragmentManager == this.f722t) {
            return super.n(fragment);
        }
        throw new IllegalStateException("Cannot detach Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    @Override // androidx.fragment.app.l0
    public void p(int i10, Fragment fragment, String str, int i11) {
        super.p(i10, fragment, str, i11);
        fragment.E = this.f722t;
    }

    @Override // androidx.fragment.app.l0
    public l0 q(Fragment fragment) {
        FragmentManager fragmentManager = fragment.E;
        if (fragmentManager == null || fragmentManager == this.f722t) {
            return super.q(fragment);
        }
        throw new IllegalStateException("Cannot hide Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    @Override // androidx.fragment.app.l0
    public boolean r() {
        return this.f790c.isEmpty();
    }

    @Override // androidx.fragment.app.l0
    public l0 s(Fragment fragment) {
        FragmentManager fragmentManager = fragment.E;
        if (fragmentManager == null || fragmentManager == this.f722t) {
            return super.s(fragment);
        }
        throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("BackStackEntry{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f724v >= 0) {
            sb2.append(" #");
            sb2.append(this.f724v);
        }
        if (this.f798k != null) {
            sb2.append(" ");
            sb2.append(this.f798k);
        }
        sb2.append("}");
        return sb2.toString();
    }

    @Override // androidx.fragment.app.l0
    public l0 w(Fragment fragment, Lifecycle.State state) {
        if (fragment.E != this.f722t) {
            throw new IllegalArgumentException("Cannot setMaxLifecycle for Fragment not attached to FragmentManager " + this.f722t);
        }
        if (state == Lifecycle.State.INITIALIZED && fragment.f559c > -1) {
            throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + state + " after the Fragment has been created");
        }
        if (state != Lifecycle.State.DESTROYED) {
            return super.w(fragment, state);
        }
        throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + state + ". Use remove() to remove the fragment from the FragmentManager and trigger its destruction.");
    }

    public void y(int i10) {
        if (this.f796i) {
            if (FragmentManager.O0(2)) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i10);
            }
            int size = this.f790c.size();
            for (int i11 = 0; i11 < size; i11++) {
                l0.a aVar = (l0.a) this.f790c.get(i11);
                Fragment fragment = aVar.f808b;
                if (fragment != null) {
                    fragment.D += i10;
                    if (FragmentManager.O0(2)) {
                        Log.v("FragmentManager", "Bump nesting of " + aVar.f808b + " to " + aVar.f808b.D);
                    }
                }
            }
        }
    }

    public int z(boolean z10) {
        if (this.f723u) {
            throw new IllegalStateException("commit already called");
        }
        if (FragmentManager.O0(2)) {
            Log.v("FragmentManager", "Commit: " + this);
            PrintWriter printWriter = new PrintWriter(new v0("FragmentManager"));
            A("  ", printWriter);
            printWriter.close();
        }
        this.f723u = true;
        if (this.f796i) {
            this.f724v = this.f722t.n();
        } else {
            this.f724v = -1;
        }
        this.f722t.d0(this, z10);
        return this.f724v;
    }
}
