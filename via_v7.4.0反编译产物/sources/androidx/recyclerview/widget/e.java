package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class e extends u {

    /* renamed from: s, reason: collision with root package name */
    public static TimeInterpolator f1391s;

    /* renamed from: h, reason: collision with root package name */
    public ArrayList f1392h = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    public ArrayList f1393i = new ArrayList();

    /* renamed from: j, reason: collision with root package name */
    public ArrayList f1394j = new ArrayList();

    /* renamed from: k, reason: collision with root package name */
    public ArrayList f1395k = new ArrayList();

    /* renamed from: l, reason: collision with root package name */
    public ArrayList f1396l = new ArrayList();

    /* renamed from: m, reason: collision with root package name */
    public ArrayList f1397m = new ArrayList();

    /* renamed from: n, reason: collision with root package name */
    public ArrayList f1398n = new ArrayList();

    /* renamed from: o, reason: collision with root package name */
    public ArrayList f1399o = new ArrayList();

    /* renamed from: p, reason: collision with root package name */
    public ArrayList f1400p = new ArrayList();

    /* renamed from: q, reason: collision with root package name */
    public ArrayList f1401q = new ArrayList();

    /* renamed from: r, reason: collision with root package name */
    public ArrayList f1402r = new ArrayList();

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ ArrayList f1403e;

        public a(ArrayList arrayList) {
            this.f1403e = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.f1403e.iterator();
            while (it.hasNext()) {
                j jVar = (j) it.next();
                e.this.X(jVar.f1437a, jVar.f1438b, jVar.f1439c, jVar.f1440d, jVar.f1441e);
            }
            this.f1403e.clear();
            e.this.f1397m.remove(this.f1403e);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class b implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ ArrayList f1405e;

        public b(ArrayList arrayList) {
            this.f1405e = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.f1405e.iterator();
            while (it.hasNext()) {
                e.this.W((i) it.next());
            }
            this.f1405e.clear();
            e.this.f1398n.remove(this.f1405e);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class c implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ ArrayList f1407e;

        public c(ArrayList arrayList) {
            this.f1407e = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.f1407e.iterator();
            while (it.hasNext()) {
                e.this.V((RecyclerView.c0) it.next());
            }
            this.f1407e.clear();
            e.this.f1396l.remove(this.f1407e);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class d extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView.c0 f1409a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewPropertyAnimator f1410b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f1411c;

        public d(RecyclerView.c0 c0Var, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f1409a = c0Var;
            this.f1410b = viewPropertyAnimator;
            this.f1411c = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f1410b.setListener(null);
            this.f1411c.setAlpha(1.0f);
            e.this.K(this.f1409a);
            e.this.f1401q.remove(this.f1409a);
            e.this.a0();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            e.this.L(this.f1409a);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    /* renamed from: androidx.recyclerview.widget.e$e, reason: collision with other inner class name */
    public class C0021e extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView.c0 f1413a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f1414b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ViewPropertyAnimator f1415c;

        public C0021e(RecyclerView.c0 c0Var, View view, ViewPropertyAnimator viewPropertyAnimator) {
            this.f1413a = c0Var;
            this.f1414b = view;
            this.f1415c = viewPropertyAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f1414b.setAlpha(1.0f);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f1415c.setListener(null);
            e.this.E(this.f1413a);
            e.this.f1399o.remove(this.f1413a);
            e.this.a0();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            e.this.F(this.f1413a);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class f extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView.c0 f1417a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f1418b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f1419c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f1420d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ ViewPropertyAnimator f1421e;

        public f(RecyclerView.c0 c0Var, int i10, View view, int i11, ViewPropertyAnimator viewPropertyAnimator) {
            this.f1417a = c0Var;
            this.f1418b = i10;
            this.f1419c = view;
            this.f1420d = i11;
            this.f1421e = viewPropertyAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (this.f1418b != 0) {
                this.f1419c.setTranslationX(0.0f);
            }
            if (this.f1420d != 0) {
                this.f1419c.setTranslationY(0.0f);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f1421e.setListener(null);
            e.this.I(this.f1417a);
            e.this.f1400p.remove(this.f1417a);
            e.this.a0();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            e.this.J(this.f1417a);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class g extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f1423a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewPropertyAnimator f1424b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f1425c;

        public g(i iVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f1423a = iVar;
            this.f1424b = viewPropertyAnimator;
            this.f1425c = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f1424b.setListener(null);
            this.f1425c.setAlpha(1.0f);
            this.f1425c.setTranslationX(0.0f);
            this.f1425c.setTranslationY(0.0f);
            e.this.G(this.f1423a.f1431a, true);
            e.this.f1402r.remove(this.f1423a.f1431a);
            e.this.a0();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            e.this.H(this.f1423a.f1431a, true);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class h extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f1427a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewPropertyAnimator f1428b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f1429c;

        public h(i iVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f1427a = iVar;
            this.f1428b = viewPropertyAnimator;
            this.f1429c = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f1428b.setListener(null);
            this.f1429c.setAlpha(1.0f);
            this.f1429c.setTranslationX(0.0f);
            this.f1429c.setTranslationY(0.0f);
            e.this.G(this.f1427a.f1432b, false);
            e.this.f1402r.remove(this.f1427a.f1432b);
            e.this.a0();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            e.this.H(this.f1427a.f1432b, false);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class i {

        /* renamed from: a, reason: collision with root package name */
        public RecyclerView.c0 f1431a;

        /* renamed from: b, reason: collision with root package name */
        public RecyclerView.c0 f1432b;

        /* renamed from: c, reason: collision with root package name */
        public int f1433c;

        /* renamed from: d, reason: collision with root package name */
        public int f1434d;

        /* renamed from: e, reason: collision with root package name */
        public int f1435e;

        /* renamed from: f, reason: collision with root package name */
        public int f1436f;

        public i(RecyclerView.c0 c0Var, RecyclerView.c0 c0Var2) {
            this.f1431a = c0Var;
            this.f1432b = c0Var2;
        }

        public i(RecyclerView.c0 c0Var, RecyclerView.c0 c0Var2, int i10, int i11, int i12, int i13) {
            this(c0Var, c0Var2);
            this.f1433c = i10;
            this.f1434d = i11;
            this.f1435e = i12;
            this.f1436f = i13;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.f1431a + ", newHolder=" + this.f1432b + ", fromX=" + this.f1433c + ", fromY=" + this.f1434d + ", toX=" + this.f1435e + ", toY=" + this.f1436f + '}';
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class j {

        /* renamed from: a, reason: collision with root package name */
        public RecyclerView.c0 f1437a;

        /* renamed from: b, reason: collision with root package name */
        public int f1438b;

        /* renamed from: c, reason: collision with root package name */
        public int f1439c;

        /* renamed from: d, reason: collision with root package name */
        public int f1440d;

        /* renamed from: e, reason: collision with root package name */
        public int f1441e;

        public j(RecyclerView.c0 c0Var, int i10, int i11, int i12, int i13) {
            this.f1437a = c0Var;
            this.f1438b = i10;
            this.f1439c = i11;
            this.f1440d = i12;
            this.f1441e = i13;
        }
    }

    @Override // androidx.recyclerview.widget.u
    public boolean A(RecyclerView.c0 c0Var) {
        e0(c0Var);
        c0Var.f1219a.setAlpha(0.0f);
        this.f1393i.add(c0Var);
        return true;
    }

    @Override // androidx.recyclerview.widget.u
    public boolean B(RecyclerView.c0 c0Var, RecyclerView.c0 c0Var2, int i10, int i11, int i12, int i13) {
        if (c0Var == c0Var2) {
            return C(c0Var, i10, i11, i12, i13);
        }
        float translationX = c0Var.f1219a.getTranslationX();
        float translationY = c0Var.f1219a.getTranslationY();
        float alpha = c0Var.f1219a.getAlpha();
        e0(c0Var);
        int i14 = (int) ((i12 - i10) - translationX);
        int i15 = (int) ((i13 - i11) - translationY);
        c0Var.f1219a.setTranslationX(translationX);
        c0Var.f1219a.setTranslationY(translationY);
        c0Var.f1219a.setAlpha(alpha);
        if (c0Var2 != null) {
            e0(c0Var2);
            c0Var2.f1219a.setTranslationX(-i14);
            c0Var2.f1219a.setTranslationY(-i15);
            c0Var2.f1219a.setAlpha(0.0f);
        }
        this.f1395k.add(new i(c0Var, c0Var2, i10, i11, i12, i13));
        return true;
    }

    @Override // androidx.recyclerview.widget.u
    public boolean C(RecyclerView.c0 c0Var, int i10, int i11, int i12, int i13) {
        View view = c0Var.f1219a;
        int translationX = i10 + ((int) view.getTranslationX());
        int translationY = i11 + ((int) c0Var.f1219a.getTranslationY());
        e0(c0Var);
        int i14 = i12 - translationX;
        int i15 = i13 - translationY;
        if (i14 == 0 && i15 == 0) {
            I(c0Var);
            return false;
        }
        if (i14 != 0) {
            view.setTranslationX(-i14);
        }
        if (i15 != 0) {
            view.setTranslationY(-i15);
        }
        this.f1394j.add(new j(c0Var, translationX, translationY, i12, i13));
        return true;
    }

    @Override // androidx.recyclerview.widget.u
    public boolean D(RecyclerView.c0 c0Var) {
        e0(c0Var);
        this.f1392h.add(c0Var);
        return true;
    }

    public void V(RecyclerView.c0 c0Var) {
        View view = c0Var.f1219a;
        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.f1399o.add(c0Var);
        viewPropertyAnimatorAnimate.alpha(1.0f).setDuration(l()).setListener(new C0021e(c0Var, view, viewPropertyAnimatorAnimate)).start();
    }

    public void W(i iVar) {
        RecyclerView.c0 c0Var = iVar.f1431a;
        View view = c0Var == null ? null : c0Var.f1219a;
        RecyclerView.c0 c0Var2 = iVar.f1432b;
        View view2 = c0Var2 != null ? c0Var2.f1219a : null;
        if (view != null) {
            ViewPropertyAnimator duration = view.animate().setDuration(m());
            this.f1402r.add(iVar.f1431a);
            duration.translationX(iVar.f1435e - iVar.f1433c);
            duration.translationY(iVar.f1436f - iVar.f1434d);
            duration.alpha(0.0f).setListener(new g(iVar, duration, view)).start();
        }
        if (view2 != null) {
            ViewPropertyAnimator viewPropertyAnimatorAnimate = view2.animate();
            this.f1402r.add(iVar.f1432b);
            viewPropertyAnimatorAnimate.translationX(0.0f).translationY(0.0f).setDuration(m()).alpha(1.0f).setListener(new h(iVar, viewPropertyAnimatorAnimate, view2)).start();
        }
    }

    public void X(RecyclerView.c0 c0Var, int i10, int i11, int i12, int i13) {
        View view = c0Var.f1219a;
        int i14 = i12 - i10;
        int i15 = i13 - i11;
        if (i14 != 0) {
            view.animate().translationX(0.0f);
        }
        if (i15 != 0) {
            view.animate().translationY(0.0f);
        }
        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.f1400p.add(c0Var);
        viewPropertyAnimatorAnimate.setDuration(n()).setListener(new f(c0Var, i14, view, i15, viewPropertyAnimatorAnimate)).start();
    }

    public final void Y(RecyclerView.c0 c0Var) {
        View view = c0Var.f1219a;
        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.f1401q.add(c0Var);
        viewPropertyAnimatorAnimate.setDuration(o()).alpha(0.0f).setListener(new d(c0Var, viewPropertyAnimatorAnimate, view)).start();
    }

    public void Z(List list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            ((RecyclerView.c0) list.get(size)).f1219a.animate().cancel();
        }
    }

    public void a0() {
        if (p()) {
            return;
        }
        i();
    }

    public final void b0(List list, RecyclerView.c0 c0Var) {
        for (int size = list.size() - 1; size >= 0; size--) {
            i iVar = (i) list.get(size);
            if (d0(iVar, c0Var) && iVar.f1431a == null && iVar.f1432b == null) {
                list.remove(iVar);
            }
        }
    }

    public final void c0(i iVar) {
        RecyclerView.c0 c0Var = iVar.f1431a;
        if (c0Var != null) {
            d0(iVar, c0Var);
        }
        RecyclerView.c0 c0Var2 = iVar.f1432b;
        if (c0Var2 != null) {
            d0(iVar, c0Var2);
        }
    }

    public final boolean d0(i iVar, RecyclerView.c0 c0Var) {
        boolean z10 = false;
        if (iVar.f1432b == c0Var) {
            iVar.f1432b = null;
        } else {
            if (iVar.f1431a != c0Var) {
                return false;
            }
            iVar.f1431a = null;
            z10 = true;
        }
        c0Var.f1219a.setAlpha(1.0f);
        c0Var.f1219a.setTranslationX(0.0f);
        c0Var.f1219a.setTranslationY(0.0f);
        G(c0Var, z10);
        return true;
    }

    public final void e0(RecyclerView.c0 c0Var) {
        if (f1391s == null) {
            f1391s = new ValueAnimator().getInterpolator();
        }
        c0Var.f1219a.animate().setInterpolator(f1391s);
        j(c0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean g(RecyclerView.c0 c0Var, List list) {
        return !list.isEmpty() || super.g(c0Var, list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void j(RecyclerView.c0 c0Var) {
        View view = c0Var.f1219a;
        view.animate().cancel();
        int size = this.f1394j.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            if (((j) this.f1394j.get(size)).f1437a == c0Var) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                I(c0Var);
                this.f1394j.remove(size);
            }
        }
        b0(this.f1395k, c0Var);
        if (this.f1392h.remove(c0Var)) {
            view.setAlpha(1.0f);
            K(c0Var);
        }
        if (this.f1393i.remove(c0Var)) {
            view.setAlpha(1.0f);
            E(c0Var);
        }
        for (int size2 = this.f1398n.size() - 1; size2 >= 0; size2--) {
            ArrayList arrayList = (ArrayList) this.f1398n.get(size2);
            b0(arrayList, c0Var);
            if (arrayList.isEmpty()) {
                this.f1398n.remove(size2);
            }
        }
        for (int size3 = this.f1397m.size() - 1; size3 >= 0; size3--) {
            ArrayList arrayList2 = (ArrayList) this.f1397m.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                }
                if (((j) arrayList2.get(size4)).f1437a == c0Var) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    I(c0Var);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.f1397m.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = this.f1396l.size() - 1; size5 >= 0; size5--) {
            ArrayList arrayList3 = (ArrayList) this.f1396l.get(size5);
            if (arrayList3.remove(c0Var)) {
                view.setAlpha(1.0f);
                E(c0Var);
                if (arrayList3.isEmpty()) {
                    this.f1396l.remove(size5);
                }
            }
        }
        this.f1401q.remove(c0Var);
        this.f1399o.remove(c0Var);
        this.f1402r.remove(c0Var);
        this.f1400p.remove(c0Var);
        a0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void k() {
        int size = this.f1394j.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            j jVar = (j) this.f1394j.get(size);
            View view = jVar.f1437a.f1219a;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            I(jVar.f1437a);
            this.f1394j.remove(size);
        }
        for (int size2 = this.f1392h.size() - 1; size2 >= 0; size2--) {
            K((RecyclerView.c0) this.f1392h.get(size2));
            this.f1392h.remove(size2);
        }
        int size3 = this.f1393i.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.c0 c0Var = (RecyclerView.c0) this.f1393i.get(size3);
            c0Var.f1219a.setAlpha(1.0f);
            E(c0Var);
            this.f1393i.remove(size3);
        }
        for (int size4 = this.f1395k.size() - 1; size4 >= 0; size4--) {
            c0((i) this.f1395k.get(size4));
        }
        this.f1395k.clear();
        if (p()) {
            for (int size5 = this.f1397m.size() - 1; size5 >= 0; size5--) {
                ArrayList arrayList = (ArrayList) this.f1397m.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    j jVar2 = (j) arrayList.get(size6);
                    View view2 = jVar2.f1437a.f1219a;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    I(jVar2.f1437a);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.f1397m.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.f1396l.size() - 1; size7 >= 0; size7--) {
                ArrayList arrayList2 = (ArrayList) this.f1396l.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    RecyclerView.c0 c0Var2 = (RecyclerView.c0) arrayList2.get(size8);
                    c0Var2.f1219a.setAlpha(1.0f);
                    E(c0Var2);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.f1396l.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.f1398n.size() - 1; size9 >= 0; size9--) {
                ArrayList arrayList3 = (ArrayList) this.f1398n.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    c0((i) arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.f1398n.remove(arrayList3);
                    }
                }
            }
            Z(this.f1401q);
            Z(this.f1400p);
            Z(this.f1399o);
            Z(this.f1402r);
            i();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean p() {
        return (this.f1393i.isEmpty() && this.f1395k.isEmpty() && this.f1394j.isEmpty() && this.f1392h.isEmpty() && this.f1400p.isEmpty() && this.f1401q.isEmpty() && this.f1399o.isEmpty() && this.f1402r.isEmpty() && this.f1397m.isEmpty() && this.f1396l.isEmpty() && this.f1398n.isEmpty()) ? false : true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void v() {
        boolean zIsEmpty = this.f1392h.isEmpty();
        boolean zIsEmpty2 = this.f1394j.isEmpty();
        boolean zIsEmpty3 = this.f1395k.isEmpty();
        boolean zIsEmpty4 = this.f1393i.isEmpty();
        if (zIsEmpty && zIsEmpty2 && zIsEmpty4 && zIsEmpty3) {
            return;
        }
        Iterator it = this.f1392h.iterator();
        while (it.hasNext()) {
            Y((RecyclerView.c0) it.next());
        }
        this.f1392h.clear();
        if (!zIsEmpty2) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.f1394j);
            this.f1397m.add(arrayList);
            this.f1394j.clear();
            a aVar = new a(arrayList);
            if (zIsEmpty) {
                aVar.run();
            } else {
                x.r.Q(((j) arrayList.get(0)).f1437a.f1219a, aVar, o());
            }
        }
        if (!zIsEmpty3) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(this.f1395k);
            this.f1398n.add(arrayList2);
            this.f1395k.clear();
            b bVar = new b(arrayList2);
            if (zIsEmpty) {
                bVar.run();
            } else {
                x.r.Q(((i) arrayList2.get(0)).f1431a.f1219a, bVar, o());
            }
        }
        if (zIsEmpty4) {
            return;
        }
        ArrayList arrayList3 = new ArrayList();
        arrayList3.addAll(this.f1393i);
        this.f1396l.add(arrayList3);
        this.f1393i.clear();
        c cVar = new c(arrayList3);
        if (zIsEmpty && zIsEmpty2 && zIsEmpty3) {
            cVar.run();
        } else {
            x.r.Q(((RecyclerView.c0) arrayList3.get(0)).f1219a, cVar, (!zIsEmpty ? o() : 0L) + Math.max(!zIsEmpty2 ? n() : 0L, zIsEmpty3 ? 0L : m()));
        }
    }
}
