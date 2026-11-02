package v5;

import android.os.SystemClock;
import android.view.View;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class d implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public long f13041a;

    public abstract void a(View view);

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (jElapsedRealtime - this.f13041a >= 300) {
            this.f13041a = jElapsedRealtime;
        } else {
            this.f13041a = 0L;
            a(view);
        }
    }
}
