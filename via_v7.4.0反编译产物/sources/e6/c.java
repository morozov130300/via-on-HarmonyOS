package e6;

import androidx.recyclerview.widget.RecyclerView;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class c extends RecyclerView.t {

    /* renamed from: a, reason: collision with root package name */
    public boolean f4783a = false;

    /* renamed from: b, reason: collision with root package name */
    public int f4784b = 1;

    /* renamed from: c, reason: collision with root package name */
    public a f4785c = null;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface a {
        void a();
    }

    public static /* synthetic */ void c(c cVar, WeakReference weakReference) {
        int i10;
        cVar.getClass();
        if (((RecyclerView) weakReference.get()) == null || (i10 = cVar.f4784b) == 0 || i10 == 2 || cVar.f4785c == null) {
            return;
        }
        cVar.e(0);
        cVar.f4785c.a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.t
    public void a(RecyclerView recyclerView, int i10) {
        int i11;
        super.a(recyclerView, i10);
        this.f4783a = i10 != 0;
        if (this.f4785c == null || (i11 = this.f4784b) == 0 || i11 == 2 || recyclerView.canScrollVertically(1) || i10 != 0) {
            return;
        }
        e(0);
        this.f4785c.a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.t
    public void b(RecyclerView recyclerView, int i10, int i11) {
        int i12;
        super.b(recyclerView, i10, i11);
        if (this.f4783a || i11 == 0 || this.f4785c == null || (i12 = this.f4784b) == 0 || i12 == 2 || recyclerView.canScrollVertically(1)) {
            return;
        }
        final WeakReference weakReference = new WeakReference(recyclerView);
        recyclerView.post(new Runnable() { // from class: e6.b
            @Override // java.lang.Runnable
            public final void run() {
                c.c(this.f4781e, weakReference);
            }
        });
    }

    public void d(a aVar) {
        this.f4785c = aVar;
    }

    public void e(int i10) {
        this.f4784b = i10;
    }
}
