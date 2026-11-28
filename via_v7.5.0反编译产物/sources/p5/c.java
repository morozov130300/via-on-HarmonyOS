package p5;

import android.os.SystemClock;
import android.view.View;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f11586a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f11587b;

    public c() {
        this(300L);
    }

    public abstract void a(View view);

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Long l10 = (Long) this.f11587b.get(view);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (l10 == null || Math.abs(jElapsedRealtime - l10.longValue()) > this.f11586a) {
            this.f11587b.put(view, Long.valueOf(jElapsedRealtime));
            a(view);
        }
    }

    public c(long j10) {
        this.f11586a = j10;
        this.f11587b = new WeakHashMap();
    }
}
