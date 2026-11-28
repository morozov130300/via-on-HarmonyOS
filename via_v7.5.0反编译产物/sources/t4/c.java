package t4;

import android.os.Bundle;
import android.webkit.WebBackForwardList;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12539a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public t4.b f12540b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Bundle f12541c = new Bundle();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f12542d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f12543e;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ WeakReference f12544c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ long f12545e;

        public a(WeakReference weakReference, long j10) {
            this.f12544c = weakReference;
            this.f12545e = j10;
        }

        @Override // java.lang.Runnable
        public void run() {
            t4.b bVar = (t4.b) this.f12544c.get();
            if (bVar == null || bVar.getScrollY() > 1000) {
                return;
            }
            long j10 = this.f12545e;
            bVar.scrollTo((int) j10, (int) (j10 >>> 32));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface b {
        t4.b a();

        void b(t4.b bVar, String str);
    }

    public c(int i10, b bVar) {
        this.f12539a = i10;
        this.f12543e = bVar;
    }

    public t4.b a() {
        t4.b bVar = this.f12540b;
        if (bVar != null) {
            return bVar;
        }
        t4.b bVarB = b();
        this.f12540b = bVarB;
        bVarB.setId(this.f12539a);
        k();
        return this.f12540b;
    }

    public final t4.b b() {
        return this.f12543e.a();
    }

    public final void c() {
        t4.b bVar = this.f12540b;
        if (bVar == null) {
            return;
        }
        s4.b.a(bVar);
        this.f12540b = null;
    }

    public t4.b d() {
        return this.f12540b;
    }

    public long e() {
        return this.f12542d;
    }

    public Bundle f() {
        if (this.f12540b != null) {
            l();
        }
        return this.f12541c;
    }

    public String g() {
        t4.b bVar = this.f12540b;
        if (bVar != null) {
            return bVar.getUrl();
        }
        Bundle bundle = this.f12541c;
        if (bundle != null) {
            return bundle.getString("url", null);
        }
        return null;
    }

    public boolean h() {
        return this.f12540b == null;
    }

    public void i() {
        c();
    }

    public void j() {
        if (this.f12540b == null) {
            return;
        }
        l();
        c();
    }

    public final void k() {
        if (this.f12540b == null) {
            return;
        }
        String string = null;
        if (this.f12541c.isEmpty()) {
            this.f12543e.b(this.f12540b, null);
            return;
        }
        WebBackForwardList webBackForwardListRestoreState = this.f12540b.restoreState(this.f12541c);
        if (webBackForwardListRestoreState != null && webBackForwardListRestoreState.getCurrentItem() != null) {
            string = webBackForwardListRestoreState.getCurrentItem().getUrl();
        }
        boolean z10 = false;
        if ((string == null || string.isEmpty()) && (string = this.f12541c.getString("url")) != null && !string.isEmpty()) {
            z10 = true;
        }
        this.f12543e.b(this.f12540b, string);
        if (z10) {
            this.f12540b.loadUrl(string);
        }
        long j10 = this.f12541c.getLong("scroll", 0L);
        if (j10 != 0) {
            this.f12540b.postDelayed(new a(new WeakReference(this.f12540b), j10), z10 ? 500L : 100L);
        }
    }

    public final void l() {
        if (this.f12540b == null) {
            return;
        }
        this.f12541c.clear();
        this.f12540b.saveState(this.f12541c);
        String url = this.f12540b.getUrl();
        if (url != null && !url.isEmpty()) {
            this.f12541c.putString("url", url);
        }
        long scrollX = ((long) this.f12540b.getScrollX()) | (((long) this.f12540b.getScrollY()) << 32);
        if (scrollX != 0) {
            this.f12541c.putLong("scroll", scrollX);
        }
    }

    public void m(long j10) {
        this.f12542d = j10;
    }

    public void n(Bundle bundle) {
        this.f12541c = bundle;
        c();
    }
}
