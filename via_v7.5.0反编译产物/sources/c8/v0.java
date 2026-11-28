package c8;

import android.os.Message;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class v0 extends q4.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f2288a;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface a {
        void J(boolean z10, boolean z11, Message message);

        void c0(t4.b bVar);
    }

    public v0(a aVar) {
        this.f2288a = aVar;
    }

    @Override // q4.a
    public boolean b(t4.b bVar) {
        this.f2288a.c0(bVar);
        return true;
    }

    @Override // q4.a
    public boolean e(t4.b bVar, boolean z10, boolean z11, Message message) {
        if (bVar != null && bVar.isShown() && message != null) {
            this.f2288a.J(z10, z11, message);
        }
        return true;
    }
}
