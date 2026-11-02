package x;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public final Runnable f13465a;

    /* renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList f13466b = new CopyOnWriteArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final Map f13467c = new HashMap();

    public h(Runnable runnable) {
        this.f13465a = runnable;
    }

    public void a(i iVar) {
        this.f13466b.add(iVar);
        this.f13465a.run();
    }

    public void b(Menu menu, MenuInflater menuInflater) {
        Iterator it = this.f13466b.iterator();
        while (it.hasNext()) {
            ((i) it.next()).c(menu, menuInflater);
        }
    }

    public void c(Menu menu) {
        Iterator it = this.f13466b.iterator();
        while (it.hasNext()) {
            ((i) it.next()).b(menu);
        }
    }

    public boolean d(MenuItem menuItem) {
        Iterator it = this.f13466b.iterator();
        while (it.hasNext()) {
            if (((i) it.next()).a(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void e(Menu menu) {
        Iterator it = this.f13466b.iterator();
        while (it.hasNext()) {
            ((i) it.next()).d(menu);
        }
    }

    public void f(i iVar) {
        this.f13466b.remove(iVar);
        n.g.a(this.f13467c.remove(iVar));
        this.f13465a.run();
    }
}
