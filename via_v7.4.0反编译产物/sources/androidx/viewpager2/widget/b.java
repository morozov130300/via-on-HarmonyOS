package androidx.viewpager2.widget;

import androidx.viewpager2.widget.ViewPager2;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class b extends ViewPager2.i {

    /* renamed from: a, reason: collision with root package name */
    public final List f1705a;

    public b(int i10) {
        this.f1705a = new ArrayList(i10);
    }

    @Override // androidx.viewpager2.widget.ViewPager2.i
    public void a(int i10) {
        try {
            Iterator it = this.f1705a.iterator();
            while (it.hasNext()) {
                ((ViewPager2.i) it.next()).a(i10);
            }
        } catch (ConcurrentModificationException e10) {
            f(e10);
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2.i
    public void b(int i10, float f10, int i11) {
        try {
            Iterator it = this.f1705a.iterator();
            while (it.hasNext()) {
                ((ViewPager2.i) it.next()).b(i10, f10, i11);
            }
        } catch (ConcurrentModificationException e10) {
            f(e10);
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2.i
    public void c(int i10) {
        try {
            Iterator it = this.f1705a.iterator();
            while (it.hasNext()) {
                ((ViewPager2.i) it.next()).c(i10);
            }
        } catch (ConcurrentModificationException e10) {
            f(e10);
        }
    }

    public void d(ViewPager2.i iVar) {
        this.f1705a.add(iVar);
    }

    public void e(ViewPager2.i iVar) {
        this.f1705a.remove(iVar);
    }

    public final void f(ConcurrentModificationException concurrentModificationException) {
        throw new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", concurrentModificationException);
    }
}
