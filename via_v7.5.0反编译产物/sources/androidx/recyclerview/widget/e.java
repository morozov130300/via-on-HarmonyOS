package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class e extends u {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static TimeInterpolator f1292s;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ArrayList f1293h = new ArrayList();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ArrayList f1294i = new ArrayList();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ArrayList f1295j = new ArrayList();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ArrayList f1296k = new ArrayList();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ArrayList f1297l = new ArrayList();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ArrayList f1298m = new ArrayList();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ArrayList f1299n = new ArrayList();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ArrayList f1300o = new ArrayList();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ArrayList f1301p = new ArrayList();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ArrayList f1302q = new ArrayList();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ArrayList f1303r = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ArrayList f1304c;

        public a(ArrayList arrayList) {
            this.f1304c = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (j jVar : this.f1304c) {
                e.this.X(jVar.f1338a, jVar.f1339b, jVar.f1340c, jVar.f1341d, jVar.f1342e);
            }
            this.f1304c.clear();
            e.this.f1298m.remove(this.f1304c);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ArrayList f1306c;

        public b(ArrayList arrayList) {
            this.f1306c = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.f1306c.iterator();
            while (it.hasNext()) {
                e.this.W((i) it.next());
            }
            this.f1306c.clear();
            e.this.f1299n.remove(this.f1306c);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class c implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ArrayList f1308c;

        public c(ArrayList arrayList) {
            this.f1308c = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.f1308c.iterator();
            while (it.hasNext()) {
                e.this.V((RecyclerView.d0) it.next());
            }
            this.f1308c.clear();
            e.this.f1297l.remove(this.f1308c);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class d extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView.d0 f1310a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewPropertyAnimator f1311b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f1312c;

        public d(RecyclerView.d0 d0Var, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f1310a = d0Var;
            this.f1311b = viewPropertyAnimator;
            this.f1312c = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f1311b.setListener(null);
            this.f1312c.setAlpha(1.0f);
            e.this.K(this.f1310a);
            e.this.f1302q.remove(this.f1310a);
            e.this.a0();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            e.this.L(this.f1310a);
        }
    }

    /* JADX INFO: renamed from: androidx.recyclerview.widget.e$e, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class C0020e extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView.d0 f1314a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f1315b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ViewPropertyAnimator f1316c;

        public C0020e(RecyclerView.d0 d0Var, View view, ViewPropertyAnimator viewPropertyAnimator) {
            this.f1314a = d0Var;
            this.f1315b = view;
            this.f1316c = viewPropertyAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f1315b.setAlpha(1.0f);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f1316c.setListener(null);
            e.this.E(this.f1314a);
            e.this.f1300o.remove(this.f1314a);
            e.this.a0();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            e.this.F(this.f1314a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class f extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView.d0 f1318a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f1319b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f1320c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f1321d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ ViewPropertyAnimator f1322e;

        public f(RecyclerView.d0 d0Var, int i10, View view, int i11, ViewPropertyAnimator viewPropertyAnimator) {
            this.f1318a = d0Var;
            this.f1319b = i10;
            this.f1320c = view;
            this.f1321d = i11;
            this.f1322e = viewPropertyAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (this.f1319b != 0) {
                this.f1320c.setTranslationX(0.0f);
            }
            if (this.f1321d != 0) {
                this.f1320c.setTranslationY(0.0f);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f1322e.setListener(null);
            e.this.I(this.f1318a);
            e.this.f1301p.remove(this.f1318a);
            e.this.a0();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            e.this.J(this.f1318a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class g extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f1324a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewPropertyAnimator f1325b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f1326c;

        public g(i iVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f1324a = iVar;
            this.f1325b = viewPropertyAnimator;
            this.f1326c = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f1325b.setListener(null);
            this.f1326c.setAlpha(1.0f);
            this.f1326c.setTranslationX(0.0f);
            this.f1326c.setTranslationY(0.0f);
            e.this.G(this.f1324a.f1332a, true);
            e.this.f1303r.remove(this.f1324a.f1332a);
            e.this.a0();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            e.this.H(this.f1324a.f1332a, true);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class h extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f1328a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewPropertyAnimator f1329b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f1330c;

        public h(i iVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f1328a = iVar;
            this.f1329b = viewPropertyAnimator;
            this.f1330c = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f1329b.setListener(null);
            this.f1330c.setAlpha(1.0f);
            this.f1330c.setTranslationX(0.0f);
            this.f1330c.setTranslationY(0.0f);
            e.this.G(this.f1328a.f1333b, false);
            e.this.f1303r.remove(this.f1328a.f1333b);
            e.this.a0();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            e.this.H(this.f1328a.f1333b, false);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RecyclerView.d0 f1338a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f1339b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f1340c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f1341d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f1342e;

        public j(RecyclerView.d0 d0Var, int i10, int i11, int i12, int i13) {
            this.f1338a = d0Var;
            this.f1339b = i10;
            this.f1340c = i11;
            this.f1341d = i12;
            this.f1342e = i13;
        }
    }

    @Override // androidx.recyclerview.widget.u
    public boolean A(RecyclerView.d0 d0Var) {
        e0(d0Var);
        d0Var.f1138a.setAlpha(0.0f);
        this.f1294i.add(d0Var);
        return true;
    }

    @Override // androidx.recyclerview.widget.u
    public boolean B(RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2, int i10, int i11, int i12, int i13) {
        if (d0Var == d0Var2) {
            return C(d0Var, i10, i11, i12, i13);
        }
        float translationX = d0Var.f1138a.getTranslationX();
        float translationY = d0Var.f1138a.getTranslationY();
        float alpha = d0Var.f1138a.getAlpha();
        e0(d0Var);
        int i14 = (int) ((i12 - i10) - translationX);
        int i15 = (int) ((i13 - i11) - translationY);
        d0Var.f1138a.setTranslationX(translationX);
        d0Var.f1138a.setTranslationY(translationY);
        d0Var.f1138a.setAlpha(alpha);
        if (d0Var2 != null) {
            e0(d0Var2);
            d0Var2.f1138a.setTranslationX(-i14);
            d0Var2.f1138a.setTranslationY(-i15);
            d0Var2.f1138a.setAlpha(0.0f);
        }
        this.f1296k.add(new i(d0Var, d0Var2, i10, i11, i12, i13));
        return true;
    }

    @Override // androidx.recyclerview.widget.u
    public boolean C(RecyclerView.d0 d0Var, int i10, int i11, int i12, int i13) {
        View view = d0Var.f1138a;
        int translationX = i10 + ((int) view.getTranslationX());
        int translationY = i11 + ((int) d0Var.f1138a.getTranslationY());
        e0(d0Var);
        int i14 = i12 - translationX;
        int i15 = i13 - translationY;
        if (i14 == 0 && i15 == 0) {
            I(d0Var);
            return false;
        }
        if (i14 != 0) {
            view.setTranslationX(-i14);
        }
        if (i15 != 0) {
            view.setTranslationY(-i15);
        }
        this.f1295j.add(new j(d0Var, translationX, translationY, i12, i13));
        return true;
    }

    @Override // androidx.recyclerview.widget.u
    public boolean D(RecyclerView.d0 d0Var) {
        e0(d0Var);
        this.f1293h.add(d0Var);
        return true;
    }

    public void V(RecyclerView.d0 d0Var) {
        View view = d0Var.f1138a;
        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.f1300o.add(d0Var);
        viewPropertyAnimatorAnimate.alpha(1.0f).setDuration(l()).setListener(new C0020e(d0Var, view, viewPropertyAnimatorAnimate)).start();
    }

    public void W(i iVar) {
        RecyclerView.d0 d0Var = iVar.f1332a;
        View view = d0Var == null ? null : d0Var.f1138a;
        RecyclerView.d0 d0Var2 = iVar.f1333b;
        View view2 = d0Var2 != null ? d0Var2.f1138a : null;
        if (view != null) {
            ViewPropertyAnimator duration = view.animate().setDuration(m());
            this.f1303r.add(iVar.f1332a);
            duration.translationX(iVar.f1336e - iVar.f1334c);
            duration.translationY(iVar.f1337f - iVar.f1335d);
            duration.alpha(0.0f).setListener(new g(iVar, duration, view)).start();
        }
        if (view2 != null) {
            ViewPropertyAnimator viewPropertyAnimatorAnimate = view2.animate();
            this.f1303r.add(iVar.f1333b);
            viewPropertyAnimatorAnimate.translationX(0.0f).translationY(0.0f).setDuration(m()).alpha(1.0f).setListener(new h(iVar, viewPropertyAnimatorAnimate, view2)).start();
        }
    }

    public void X(RecyclerView.d0 d0Var, int i10, int i11, int i12, int i13) {
        View view = d0Var.f1138a;
        int i14 = i12 - i10;
        int i15 = i13 - i11;
        if (i14 != 0) {
            view.animate().translationX(0.0f);
        }
        if (i15 != 0) {
            view.animate().translationY(0.0f);
        }
        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.f1301p.add(d0Var);
        viewPropertyAnimatorAnimate.setDuration(n()).setListener(new f(d0Var, i14, view, i15, viewPropertyAnimatorAnimate)).start();
    }

    public final void Y(RecyclerView.d0 d0Var) {
        View view = d0Var.f1138a;
        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.f1302q.add(d0Var);
        viewPropertyAnimatorAnimate.setDuration(o()).alpha(0.0f).setListener(new d(d0Var, viewPropertyAnimatorAnimate, view)).start();
    }

    public void Z(List list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            ((RecyclerView.d0) list.get(size)).f1138a.animate().cancel();
        }
    }

    public void a0() {
        if (p()) {
            return;
        }
        i();
    }

    public final void b0(List list, RecyclerView.d0 d0Var) {
        for (int size = list.size() - 1; size >= 0; size--) {
            i iVar = (i) list.get(size);
            if (d0(iVar, d0Var) && iVar.f1332a == null && iVar.f1333b == null) {
                list.remove(iVar);
            }
        }
    }

    public final void c0(i iVar) {
        RecyclerView.d0 d0Var = iVar.f1332a;
        if (d0Var != null) {
            d0(iVar, d0Var);
        }
        RecyclerView.d0 d0Var2 = iVar.f1333b;
        if (d0Var2 != null) {
            d0(iVar, d0Var2);
        }
    }

    public final boolean d0(i iVar, RecyclerView.d0 d0Var) {
        boolean z10 = false;
        if (iVar.f1333b == d0Var) {
            iVar.f1333b = null;
        } else {
            if (iVar.f1332a != d0Var) {
                return false;
            }
            iVar.f1332a = null;
            z10 = true;
        }
        d0Var.f1138a.setAlpha(1.0f);
        d0Var.f1138a.setTranslationX(0.0f);
        d0Var.f1138a.setTranslationY(0.0f);
        G(d0Var, z10);
        return true;
    }

    public final void e0(RecyclerView.d0 d0Var) {
        if (f1292s == null) {
            f1292s = new ValueAnimator().getInterpolator();
        }
        d0Var.f1138a.animate().setInterpolator(f1292s);
        j(d0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean g(RecyclerView.d0 d0Var, List list) {
        return !list.isEmpty() || super.g(d0Var, list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void j(RecyclerView.d0 d0Var) {
        View view = d0Var.f1138a;
        view.animate().cancel();
        int size = this.f1295j.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            if (((j) this.f1295j.get(size)).f1338a == d0Var) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                I(d0Var);
                this.f1295j.remove(size);
            }
        }
        b0(this.f1296k, d0Var);
        if (this.f1293h.remove(d0Var)) {
            view.setAlpha(1.0f);
            K(d0Var);
        }
        if (this.f1294i.remove(d0Var)) {
            view.setAlpha(1.0f);
            E(d0Var);
        }
        for (int size2 = this.f1299n.size() - 1; size2 >= 0; size2--) {
            ArrayList arrayList = (ArrayList) this.f1299n.get(size2);
            b0(arrayList, d0Var);
            if (arrayList.isEmpty()) {
                this.f1299n.remove(size2);
            }
        }
        for (int size3 = this.f1298m.size() - 1; size3 >= 0; size3--) {
            ArrayList arrayList2 = (ArrayList) this.f1298m.get(size3);
            for (int size4 = arrayList2.size() - 1; size4 >= 0; size4--) {
                if (((j) arrayList2.get(size4)).f1338a == d0Var) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    I(d0Var);
                    arrayList2.remove(size4);
                    if (!arrayList2.isEmpty()) {
                        break;
                    }
                    this.f1298m.remove(size3);
                    break;
                }
            }
        }
        for (int size5 = this.f1297l.size() - 1; size5 >= 0; size5--) {
            ArrayList arrayList3 = (ArrayList) this.f1297l.get(size5);
            if (arrayList3.remove(d0Var)) {
                view.setAlpha(1.0f);
                E(d0Var);
                if (arrayList3.isEmpty()) {
                    this.f1297l.remove(size5);
                }
            }
        }
        this.f1302q.remove(d0Var);
        this.f1300o.remove(d0Var);
        this.f1303r.remove(d0Var);
        this.f1301p.remove(d0Var);
        a0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void k() {
        int size = this.f1295j.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            j jVar = (j) this.f1295j.get(size);
            View view = jVar.f1338a.f1138a;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            I(jVar.f1338a);
            this.f1295j.remove(size);
        }
        for (int size2 = this.f1293h.size() - 1; size2 >= 0; size2--) {
            K((RecyclerView.d0) this.f1293h.get(size2));
            this.f1293h.remove(size2);
        }
        int size3 = this.f1294i.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.d0 d0Var = (RecyclerView.d0) this.f1294i.get(size3);
            d0Var.f1138a.setAlpha(1.0f);
            E(d0Var);
            this.f1294i.remove(size3);
        }
        for (int size4 = this.f1296k.size() - 1; size4 >= 0; size4--) {
            c0((i) this.f1296k.get(size4));
        }
        this.f1296k.clear();
        if (p()) {
            for (int size5 = this.f1298m.size() - 1; size5 >= 0; size5--) {
                ArrayList arrayList = (ArrayList) this.f1298m.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    j jVar2 = (j) arrayList.get(size6);
                    View view2 = jVar2.f1338a.f1138a;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    I(jVar2.f1338a);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.f1298m.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.f1297l.size() - 1; size7 >= 0; size7--) {
                ArrayList arrayList2 = (ArrayList) this.f1297l.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    RecyclerView.d0 d0Var2 = (RecyclerView.d0) arrayList2.get(size8);
                    d0Var2.f1138a.setAlpha(1.0f);
                    E(d0Var2);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.f1297l.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.f1299n.size() - 1; size9 >= 0; size9--) {
                ArrayList arrayList3 = (ArrayList) this.f1299n.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    c0((i) arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.f1299n.remove(arrayList3);
                    }
                }
            }
            Z(this.f1302q);
            Z(this.f1301p);
            Z(this.f1300o);
            Z(this.f1303r);
            i();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean p() {
        return (this.f1294i.isEmpty() && this.f1296k.isEmpty() && this.f1295j.isEmpty() && this.f1293h.isEmpty() && this.f1301p.isEmpty() && this.f1302q.isEmpty() && this.f1300o.isEmpty() && this.f1303r.isEmpty() && this.f1298m.isEmpty() && this.f1297l.isEmpty() && this.f1299n.isEmpty()) ? false : true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void v() {
        boolean zIsEmpty = this.f1293h.isEmpty();
        boolean zIsEmpty2 = this.f1295j.isEmpty();
        boolean zIsEmpty3 = this.f1296k.isEmpty();
        boolean zIsEmpty4 = this.f1294i.isEmpty();
        if (zIsEmpty && zIsEmpty2 && zIsEmpty4 && zIsEmpty3) {
            return;
        }
        Iterator it = this.f1293h.iterator();
        while (it.hasNext()) {
            Y((RecyclerView.d0) it.next());
        }
        this.f1293h.clear();
        if (!zIsEmpty2) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.f1295j);
            this.f1298m.add(arrayList);
            this.f1295j.clear();
            a aVar = new a(arrayList);
            if (zIsEmpty) {
                aVar.run();
            } else {
                y.r.R(((j) arrayList.get(0)).f1338a.f1138a, aVar, o());
            }
        }
        if (!zIsEmpty3) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(this.f1296k);
            this.f1299n.add(arrayList2);
            this.f1296k.clear();
            b bVar = new b(arrayList2);
            if (zIsEmpty) {
                bVar.run();
            } else {
                y.r.R(((i) arrayList2.get(0)).f1332a.f1138a, bVar, o());
            }
        }
        if (zIsEmpty4) {
            return;
        }
        ArrayList arrayList3 = new ArrayList();
        arrayList3.addAll(this.f1294i);
        this.f1297l.add(arrayList3);
        this.f1294i.clear();
        c cVar = new c(arrayList3);
        if (zIsEmpty && zIsEmpty2 && zIsEmpty3) {
            cVar.run();
        } else {
            y.r.R(((RecyclerView.d0) arrayList3.get(0)).f1138a, cVar, (!zIsEmpty ? o() : 0L) + Math.max(!zIsEmpty2 ? n() : 0L, zIsEmpty3 ? 0L : m()));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RecyclerView.d0 f1332a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public RecyclerView.d0 f1333b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f1334c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f1335d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f1336e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f1337f;

        public i(RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2) {
            this.f1332a = d0Var;
            this.f1333b = d0Var2;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.f1332a + ", newHolder=" + this.f1333b + ", fromX=" + this.f1334c + ", fromY=" + this.f1335d + ", toX=" + this.f1336e + ", toY=" + this.f1337f + '}';
        }

        public i(RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2, int i10, int i11, int i12, int i13) {
            this(d0Var, d0Var2);
            this.f1334c = i10;
            this.f1335d = i11;
            this.f1336e = i12;
            this.f1337f = i13;
        }
    }
}
