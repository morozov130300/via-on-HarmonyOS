package androidx.fragment.app;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class k0 {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f882a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f883b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f884c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public g0 f885d;

    public void A(g0 g0Var) {
        this.f885d = g0Var;
    }

    public Bundle B(String str, Bundle bundle) {
        return bundle != null ? (Bundle) this.f884c.put(str, bundle) : (Bundle) this.f884c.remove(str);
    }

    public void a(Fragment fragment) {
        if (this.f882a.contains(fragment)) {
            throw new IllegalStateException("Fragment already added: " + fragment);
        }
        synchronized (this.f882a) {
            this.f882a.add(fragment);
        }
        fragment.f676t = true;
    }

    public void b() {
        this.f883b.values().removeAll(Collections.singleton(null));
    }

    public boolean c(String str) {
        return this.f883b.get(str) != null;
    }

    public void d(int i10) {
        for (j0 j0Var : this.f883b.values()) {
            if (j0Var != null) {
                j0Var.t(i10);
            }
        }
    }

    public void e(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2 = str + "    ";
        if (!this.f883b.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Active Fragments:");
            for (j0 j0Var : this.f883b.values()) {
                printWriter.print(str);
                if (j0Var != null) {
                    Fragment fragmentK = j0Var.k();
                    printWriter.println(fragmentK);
                    fragmentK.q0(str2, fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println("null");
                }
            }
        }
        int size = this.f882a.size();
        if (size > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i10 = 0; i10 < size; i10++) {
                Fragment fragment = (Fragment) this.f882a.get(i10);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i10);
                printWriter.print(": ");
                printWriter.println(fragment.toString());
            }
        }
    }

    public Fragment f(String str) {
        j0 j0Var = (j0) this.f883b.get(str);
        if (j0Var != null) {
            return j0Var.k();
        }
        return null;
    }

    public Fragment g(int i10) {
        for (int size = this.f882a.size() - 1; size >= 0; size--) {
            Fragment fragment = (Fragment) this.f882a.get(size);
            if (fragment != null && fragment.G == i10) {
                return fragment;
            }
        }
        for (j0 j0Var : this.f883b.values()) {
            if (j0Var != null) {
                Fragment fragmentK = j0Var.k();
                if (fragmentK.G == i10) {
                    return fragmentK;
                }
            }
        }
        return null;
    }

    public Fragment h(String str) {
        if (str != null) {
            for (int size = this.f882a.size() - 1; size >= 0; size--) {
                Fragment fragment = (Fragment) this.f882a.get(size);
                if (fragment != null && str.equals(fragment.I)) {
                    return fragment;
                }
            }
        }
        if (str == null) {
            return null;
        }
        for (j0 j0Var : this.f883b.values()) {
            if (j0Var != null) {
                Fragment fragmentK = j0Var.k();
                if (str.equals(fragmentK.I)) {
                    return fragmentK;
                }
            }
        }
        return null;
    }

    public Fragment i(String str) {
        Fragment fragmentS0;
        for (j0 j0Var : this.f883b.values()) {
            if (j0Var != null && (fragmentS0 = j0Var.k().s0(str)) != null) {
                return fragmentS0;
            }
        }
        return null;
    }

    public int j(Fragment fragment) {
        View view;
        View view2;
        ViewGroup viewGroup = fragment.Q;
        if (viewGroup == null) {
            return -1;
        }
        int iIndexOf = this.f882a.indexOf(fragment);
        for (int i10 = iIndexOf - 1; i10 >= 0; i10--) {
            Fragment fragment2 = (Fragment) this.f882a.get(i10);
            if (fragment2.Q == viewGroup && (view2 = fragment2.R) != null) {
                return viewGroup.indexOfChild(view2) + 1;
            }
        }
        while (true) {
            iIndexOf++;
            if (iIndexOf >= this.f882a.size()) {
                return -1;
            }
            Fragment fragment3 = (Fragment) this.f882a.get(iIndexOf);
            if (fragment3.Q == viewGroup && (view = fragment3.R) != null) {
                return viewGroup.indexOfChild(view);
            }
        }
    }

    public List k() {
        ArrayList arrayList = new ArrayList();
        for (j0 j0Var : this.f883b.values()) {
            if (j0Var != null) {
                arrayList.add(j0Var);
            }
        }
        return arrayList;
    }

    public List l() {
        ArrayList arrayList = new ArrayList();
        for (j0 j0Var : this.f883b.values()) {
            if (j0Var != null) {
                arrayList.add(j0Var.k());
            } else {
                arrayList.add(null);
            }
        }
        return arrayList;
    }

    public HashMap m() {
        return this.f884c;
    }

    public j0 n(String str) {
        return (j0) this.f883b.get(str);
    }

    public List o() {
        ArrayList arrayList;
        if (this.f882a.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        synchronized (this.f882a) {
            arrayList = new ArrayList(this.f882a);
        }
        return arrayList;
    }

    public g0 p() {
        return this.f885d;
    }

    public Bundle q(String str) {
        return (Bundle) this.f884c.get(str);
    }

    public void r(j0 j0Var) {
        Fragment fragmentK = j0Var.k();
        if (c(fragmentK.f670n)) {
            return;
        }
        this.f883b.put(fragmentK.f670n, j0Var);
        if (fragmentK.M) {
            if (fragmentK.L) {
                this.f885d.j(fragmentK);
            } else {
                this.f885d.t(fragmentK);
            }
            fragmentK.M = false;
        }
        if (FragmentManager.O0(2)) {
            Log.v("FragmentManager", "Added fragment to active set " + fragmentK);
        }
    }

    public void s(j0 j0Var) {
        Fragment fragmentK = j0Var.k();
        if (fragmentK.L) {
            this.f885d.t(fragmentK);
        }
        if (this.f883b.get(fragmentK.f670n) == j0Var && ((j0) this.f883b.put(fragmentK.f670n, null)) != null && FragmentManager.O0(2)) {
            Log.v("FragmentManager", "Removed fragment from active set " + fragmentK);
        }
    }

    public void t() {
        Iterator it = this.f882a.iterator();
        while (it.hasNext()) {
            j0 j0Var = (j0) this.f883b.get(((Fragment) it.next()).f670n);
            if (j0Var != null) {
                j0Var.m();
            }
        }
        for (j0 j0Var2 : this.f883b.values()) {
            if (j0Var2 != null) {
                j0Var2.m();
                Fragment fragmentK = j0Var2.k();
                if (fragmentK.f677u && !fragmentK.l1()) {
                    if (fragmentK.f679w && !this.f884c.containsKey(fragmentK.f670n)) {
                        B(fragmentK.f670n, j0Var2.r());
                    }
                    s(j0Var2);
                }
            }
        }
    }

    public void u(Fragment fragment) {
        synchronized (this.f882a) {
            this.f882a.remove(fragment);
        }
        fragment.f676t = false;
    }

    public void v() {
        this.f883b.clear();
    }

    public void w(List list) {
        this.f882a.clear();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                Fragment fragmentF = f(str);
                if (fragmentF == null) {
                    throw new IllegalStateException("No instantiated fragment for (" + str + ")");
                }
                if (FragmentManager.O0(2)) {
                    Log.v("FragmentManager", "restoreSaveState: added (" + str + "): " + fragmentF);
                }
                a(fragmentF);
            }
        }
    }

    public void x(HashMap map) {
        this.f884c.clear();
        this.f884c.putAll(map);
    }

    public ArrayList y() {
        ArrayList arrayList = new ArrayList(this.f883b.size());
        for (j0 j0Var : this.f883b.values()) {
            if (j0Var != null) {
                Fragment fragmentK = j0Var.k();
                B(fragmentK.f670n, j0Var.r());
                arrayList.add(fragmentK.f670n);
                if (FragmentManager.O0(2)) {
                    Log.v("FragmentManager", "Saved state of " + fragmentK + ": " + fragmentK.f664j);
                }
            }
        }
        return arrayList;
    }

    public ArrayList z() {
        synchronized (this.f882a) {
            try {
                if (this.f882a.isEmpty()) {
                    return null;
                }
                ArrayList arrayList = new ArrayList(this.f882a.size());
                Iterator it = this.f882a.iterator();
                while (it.hasNext()) {
                    Fragment fragment = (Fragment) it.next();
                    arrayList.add(fragment.f670n);
                    if (FragmentManager.O0(2)) {
                        Log.v("FragmentManager", "saveAllState: adding fragment (" + fragment.f670n + "): " + fragment);
                    }
                }
                return arrayList;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
