package e8;

import android.os.Message;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class c0 extends p4.a {

    /* renamed from: a, reason: collision with root package name */
    public final a f4798a;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface a {
        void L(boolean z10, boolean z11, Message message);

        void f0(t4.b bVar);
    }

    public c0(a aVar) {
        this.f4798a = aVar;
    }

    @Override // p4.a
    public boolean b(t4.b bVar) {
        this.f4798a.f0(bVar);
        return true;
    }

    @Override // p4.a
    public boolean e(t4.b bVar, boolean z10, boolean z11, Message message) {
        if (bVar != null && bVar.isShown() && message != null) {
            this.f4798a.L(z10, z11, message);
        }
        return true;
    }
}
