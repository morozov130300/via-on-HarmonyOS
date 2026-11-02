package v5;

import android.os.SystemClock;
import android.view.View;
import java.util.Map;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class c implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final long f13039a;

    /* renamed from: b, reason: collision with root package name */
    public final Map f13040b;

    public c() {
        this(300L);
    }

    public c(long j10) {
        this.f13039a = j10;
        this.f13040b = new WeakHashMap();
    }

    public abstract void a(View view);

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Long l10 = (Long) this.f13040b.get(view);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (l10 == null || Math.abs(jElapsedRealtime - l10.longValue()) > this.f13039a) {
            this.f13040b.put(view, Long.valueOf(jElapsedRealtime));
            a(view);
        }
    }
}
