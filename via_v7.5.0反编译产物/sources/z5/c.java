package z5;

import androidx.recyclerview.widget.RecyclerView;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class c extends RecyclerView.t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f15191a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f15192b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f15193c = null;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface a {
        void a();
    }

    public static /* synthetic */ void c(c cVar, WeakReference weakReference) {
        int i10;
        cVar.getClass();
        if (((RecyclerView) weakReference.get()) == null || (i10 = cVar.f15192b) == 0 || i10 == 2 || cVar.f15193c == null) {
            return;
        }
        cVar.e(0);
        cVar.f15193c.a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.t
    public void a(RecyclerView recyclerView, int i10) {
        int i11;
        super.a(recyclerView, i10);
        this.f15191a = i10 != 0;
        if (this.f15193c == null || (i11 = this.f15192b) == 0 || i11 == 2 || recyclerView.canScrollVertically(1) || i10 != 0) {
            return;
        }
        e(0);
        this.f15193c.a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.t
    public void b(RecyclerView recyclerView, int i10, int i11) {
        int i12;
        super.b(recyclerView, i10, i11);
        if (this.f15191a || i11 == 0 || this.f15193c == null || (i12 = this.f15192b) == 0 || i12 == 2 || recyclerView.canScrollVertically(1)) {
            return;
        }
        final WeakReference weakReference = new WeakReference(recyclerView);
        recyclerView.post(new Runnable() { // from class: z5.b
            @Override // java.lang.Runnable
            public final void run() {
                c.c(this.f15189c, weakReference);
            }
        });
    }

    public void d(a aVar) {
        this.f15193c = aVar;
    }

    public void e(int i10) {
        this.f15192b = i10;
    }
}
