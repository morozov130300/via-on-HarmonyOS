package y;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f14709a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList f14710b = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f14711c = new HashMap();

    public h(Runnable runnable) {
        this.f14709a = runnable;
    }

    public void a(i iVar) {
        this.f14710b.add(iVar);
        this.f14709a.run();
    }

    public void b(Menu menu, MenuInflater menuInflater) {
        Iterator it = this.f14710b.iterator();
        while (it.hasNext()) {
            ((i) it.next()).c(menu, menuInflater);
        }
    }

    public void c(Menu menu) {
        Iterator it = this.f14710b.iterator();
        while (it.hasNext()) {
            ((i) it.next()).b(menu);
        }
    }

    public boolean d(MenuItem menuItem) {
        Iterator it = this.f14710b.iterator();
        while (it.hasNext()) {
            if (((i) it.next()).a(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void e(Menu menu) {
        Iterator it = this.f14710b.iterator();
        while (it.hasNext()) {
            ((i) it.next()).d(menu);
        }
    }

    public void f(i iVar) {
        this.f14710b.remove(iVar);
        n.g.a(this.f14711c.remove(iVar));
        this.f14709a.run();
    }
}
