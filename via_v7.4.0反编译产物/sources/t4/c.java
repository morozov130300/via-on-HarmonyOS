package t4;

import android.os.Bundle;
import android.webkit.WebBackForwardList;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public final int f12148a;

    /* renamed from: b, reason: collision with root package name */
    public t4.b f12149b;

    /* renamed from: c, reason: collision with root package name */
    public Bundle f12150c = new Bundle();

    /* renamed from: d, reason: collision with root package name */
    public long f12151d = 0;

    /* renamed from: e, reason: collision with root package name */
    public final b f12152e;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ WeakReference f12153e;

        /* renamed from: j, reason: collision with root package name */
        public final /* synthetic */ long f12154j;

        public a(WeakReference weakReference, long j10) {
            this.f12153e = weakReference;
            this.f12154j = j10;
        }

        @Override // java.lang.Runnable
        public void run() {
            t4.b bVar = (t4.b) this.f12153e.get();
            if (bVar == null || bVar.getScrollY() > 1000) {
                return;
            }
            long j10 = this.f12154j;
            bVar.scrollTo((int) j10, (int) (j10 >>> 32));
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface b {
        t4.b a();

        void b(t4.b bVar, String str);
    }

    public c(int i10, b bVar) {
        this.f12148a = i10;
        this.f12152e = bVar;
    }

    public t4.b a() {
        t4.b bVar = this.f12149b;
        if (bVar != null) {
            return bVar;
        }
        t4.b bVarB = b();
        this.f12149b = bVarB;
        bVarB.setId(this.f12148a);
        k();
        return this.f12149b;
    }

    public final t4.b b() {
        return this.f12152e.a();
    }

    public final void c() {
        t4.b bVar = this.f12149b;
        if (bVar == null) {
            return;
        }
        s4.b.a(bVar);
        this.f12149b = null;
    }

    public t4.b d() {
        return this.f12149b;
    }

    public long e() {
        return this.f12151d;
    }

    public Bundle f() {
        if (this.f12149b != null) {
            l();
        }
        return this.f12150c;
    }

    public String g() {
        t4.b bVar = this.f12149b;
        if (bVar != null) {
            return bVar.getUrl();
        }
        Bundle bundle = this.f12150c;
        if (bundle != null) {
            return bundle.getString("url", null);
        }
        return null;
    }

    public boolean h() {
        return this.f12149b == null;
    }

    public void i() {
        c();
    }

    public void j() {
        if (this.f12149b == null) {
            return;
        }
        l();
        c();
    }

    public final void k() {
        if (this.f12149b == null) {
            return;
        }
        String string = null;
        if (this.f12150c.isEmpty()) {
            this.f12152e.b(this.f12149b, null);
            return;
        }
        WebBackForwardList webBackForwardListRestoreState = this.f12149b.restoreState(this.f12150c);
        if (webBackForwardListRestoreState != null && webBackForwardListRestoreState.getCurrentItem() != null) {
            string = webBackForwardListRestoreState.getCurrentItem().getUrl();
        }
        boolean z10 = false;
        if ((string == null || string.isEmpty()) && (string = this.f12150c.getString("url")) != null && !string.isEmpty()) {
            z10 = true;
        }
        this.f12152e.b(this.f12149b, string);
        if (z10) {
            this.f12149b.loadUrl(string);
        }
        long j10 = this.f12150c.getLong("scroll", 0L);
        if (j10 != 0) {
            this.f12149b.postDelayed(new a(new WeakReference(this.f12149b), j10), z10 ? 500L : 100L);
        }
    }

    public final void l() {
        if (this.f12149b == null) {
            return;
        }
        this.f12150c.clear();
        this.f12149b.saveState(this.f12150c);
        String url = this.f12149b.getUrl();
        if (url != null && !url.isEmpty()) {
            this.f12150c.putString("url", url);
        }
        long scrollX = this.f12149b.getScrollX() | (this.f12149b.getScrollY() << 32);
        if (scrollX != 0) {
            this.f12150c.putLong("scroll", scrollX);
        }
    }

    public void m(long j10) {
        this.f12151d = j10;
    }

    public void n(Bundle bundle) {
        this.f12150c = bundle;
        c();
    }
}
