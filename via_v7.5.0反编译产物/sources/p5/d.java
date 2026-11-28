package p5;

import android.os.SystemClock;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f11588a;

    public abstract void a(View view);

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (jElapsedRealtime - this.f11588a >= 300) {
            this.f11588a = jElapsedRealtime;
        } else {
            this.f11588a = 0L;
            a(view);
        }
    }
}
