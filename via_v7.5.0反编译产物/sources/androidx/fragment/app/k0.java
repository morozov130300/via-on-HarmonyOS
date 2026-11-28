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

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f783a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f784b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap f785c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public g0 f786d;

    public void A(g0 g0Var) {
        this.f786d = g0Var;
    }

    public Bundle B(String str, Bundle bundle) {
        return bundle != null ? (Bundle) this.f785c.put(str, bundle) : (Bundle) this.f785c.remove(str);
    }

    public void a(Fragment fragment) {
        if (this.f783a.contains(fragment)) {
            throw new IllegalStateException("Fragment already added: " + fragment);
        }
        synchronized (this.f783a) {
            this.f783a.add(fragment);
        }
        fragment.f581v = true;
    }

    public void b() {
        this.f784b.values().removeAll(Collections.singleton(null));
    }

    public boolean c(String str) {
        return this.f784b.get(str) != null;
    }

    public void d(int i10) {
        for (j0 j0Var : this.f784b.values()) {
            if (j0Var != null) {
                j0Var.t(i10);
            }
        }
    }

    public void e(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2 = str + "    ";
        if (!this.f784b.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Active Fragments:");
            for (j0 j0Var : this.f784b.values()) {
                printWriter.print(str);
                if (j0Var != null) {
                    Fragment fragmentK = j0Var.k();
                    printWriter.println(fragmentK);
                    fragmentK.o0(str2, fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println("null");
                }
            }
        }
        int size = this.f783a.size();
        if (size > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i10 = 0; i10 < size; i10++) {
                Fragment fragment = (Fragment) this.f783a.get(i10);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i10);
                printWriter.print(": ");
                printWriter.println(fragment.toString());
            }
        }
    }

    public Fragment f(String str) {
        j0 j0Var = (j0) this.f784b.get(str);
        if (j0Var != null) {
            return j0Var.k();
        }
        return null;
    }

    public Fragment g(int i10) {
        for (int size = this.f783a.size() - 1; size >= 0; size--) {
            Fragment fragment = (Fragment) this.f783a.get(size);
            if (fragment != null && fragment.I == i10) {
                return fragment;
            }
        }
        for (j0 j0Var : this.f784b.values()) {
            if (j0Var != null) {
                Fragment fragmentK = j0Var.k();
                if (fragmentK.I == i10) {
                    return fragmentK;
                }
            }
        }
        return null;
    }

    public Fragment h(String str) {
        if (str != null) {
            for (int size = this.f783a.size() - 1; size >= 0; size--) {
                Fragment fragment = (Fragment) this.f783a.get(size);
                if (fragment != null && str.equals(fragment.K)) {
                    return fragment;
                }
            }
        }
        if (str == null) {
            return null;
        }
        for (j0 j0Var : this.f784b.values()) {
            if (j0Var != null) {
                Fragment fragmentK = j0Var.k();
                if (str.equals(fragmentK.K)) {
                    return fragmentK;
                }
            }
        }
        return null;
    }

    public Fragment i(String str) {
        Fragment fragmentQ0;
        for (j0 j0Var : this.f784b.values()) {
            if (j0Var != null && (fragmentQ0 = j0Var.k().q0(str)) != null) {
                return fragmentQ0;
            }
        }
        return null;
    }

    public int j(Fragment fragment) {
        View view;
        View view2;
        ViewGroup viewGroup = fragment.S;
        if (viewGroup == null) {
            return -1;
        }
        int iIndexOf = this.f783a.indexOf(fragment);
        for (int i10 = iIndexOf - 1; i10 >= 0; i10--) {
            Fragment fragment2 = (Fragment) this.f783a.get(i10);
            if (fragment2.S == viewGroup && (view2 = fragment2.T) != null) {
                return viewGroup.indexOfChild(view2) + 1;
            }
        }
        while (true) {
            iIndexOf++;
            if (iIndexOf >= this.f783a.size()) {
                return -1;
            }
            Fragment fragment3 = (Fragment) this.f783a.get(iIndexOf);
            if (fragment3.S == viewGroup && (view = fragment3.T) != null) {
                return viewGroup.indexOfChild(view);
            }
        }
    }

    public List k() {
        ArrayList arrayList = new ArrayList();
        for (j0 j0Var : this.f784b.values()) {
            if (j0Var != null) {
                arrayList.add(j0Var);
            }
        }
        return arrayList;
    }

    public List l() {
        ArrayList arrayList = new ArrayList();
        for (j0 j0Var : this.f784b.values()) {
            if (j0Var != null) {
                arrayList.add(j0Var.k());
            } else {
                arrayList.add(null);
            }
        }
        return arrayList;
    }

    public HashMap m() {
        return this.f785c;
    }

    public j0 n(String str) {
        return (j0) this.f784b.get(str);
    }

    public List o() {
        ArrayList arrayList;
        if (this.f783a.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        synchronized (this.f783a) {
            arrayList = new ArrayList(this.f783a);
        }
        return arrayList;
    }

    public g0 p() {
        return this.f786d;
    }

    public Bundle q(String str) {
        return (Bundle) this.f785c.get(str);
    }

    public void r(j0 j0Var) {
        Fragment fragmentK = j0Var.k();
        if (c(fragmentK.f575p)) {
            return;
        }
        this.f784b.put(fragmentK.f575p, j0Var);
        if (fragmentK.O) {
            if (fragmentK.N) {
                this.f786d.j(fragmentK);
            } else {
                this.f786d.t(fragmentK);
            }
            fragmentK.O = false;
        }
        if (FragmentManager.O0(2)) {
            Log.v("FragmentManager", "Added fragment to active set " + fragmentK);
        }
    }

    public void s(j0 j0Var) {
        Fragment fragmentK = j0Var.k();
        if (fragmentK.N) {
            this.f786d.t(fragmentK);
        }
        if (this.f784b.get(fragmentK.f575p) == j0Var && ((j0) this.f784b.put(fragmentK.f575p, null)) != null && FragmentManager.O0(2)) {
            Log.v("FragmentManager", "Removed fragment from active set " + fragmentK);
        }
    }

    public void t() {
        Iterator it = this.f783a.iterator();
        while (it.hasNext()) {
            j0 j0Var = (j0) this.f784b.get(((Fragment) it.next()).f575p);
            if (j0Var != null) {
                j0Var.m();
            }
        }
        for (j0 j0Var2 : this.f784b.values()) {
            if (j0Var2 != null) {
                j0Var2.m();
                Fragment fragmentK = j0Var2.k();
                if (fragmentK.f582w && !fragmentK.j1()) {
                    if (fragmentK.f584y && !this.f785c.containsKey(fragmentK.f575p)) {
                        B(fragmentK.f575p, j0Var2.r());
                    }
                    s(j0Var2);
                }
            }
        }
    }

    public void u(Fragment fragment) {
        synchronized (this.f783a) {
            this.f783a.remove(fragment);
        }
        fragment.f581v = false;
    }

    public void v() {
        this.f784b.clear();
    }

    public void w(List list) {
        this.f783a.clear();
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
        this.f785c.clear();
        this.f785c.putAll(map);
    }

    public ArrayList y() {
        ArrayList arrayList = new ArrayList(this.f784b.size());
        for (j0 j0Var : this.f784b.values()) {
            if (j0Var != null) {
                Fragment fragmentK = j0Var.k();
                B(fragmentK.f575p, j0Var.r());
                arrayList.add(fragmentK.f575p);
                if (FragmentManager.O0(2)) {
                    Log.v("FragmentManager", "Saved state of " + fragmentK + ": " + fragmentK.f562e);
                }
            }
        }
        return arrayList;
    }

    public ArrayList z() {
        synchronized (this.f783a) {
            try {
                if (this.f783a.isEmpty()) {
                    return null;
                }
                ArrayList arrayList = new ArrayList(this.f783a.size());
                for (Fragment fragment : this.f783a) {
                    arrayList.add(fragment.f575p);
                    if (FragmentManager.O0(2)) {
                        Log.v("FragmentManager", "saveAllState: adding fragment (" + fragment.f575p + "): " + fragment);
                    }
                }
                return arrayList;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
