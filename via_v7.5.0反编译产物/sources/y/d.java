package y;

import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.MotionEvent;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f14701a;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface a {
        boolean a(MotionEvent motionEvent);
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class b implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final GestureDetector f14702a;

        public b(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
            this.f14702a = new GestureDetector(context, onGestureListener, handler);
        }

        @Override // y.d.a
        public boolean a(MotionEvent motionEvent) {
            return this.f14702a.onTouchEvent(motionEvent);
        }
    }

    public d(Context context, GestureDetector.OnGestureListener onGestureListener) {
        this(context, onGestureListener, null);
    }

    public boolean a(MotionEvent motionEvent) {
        return this.f14701a.a(motionEvent);
    }

    public d(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
        this.f14701a = new b(context, onGestureListener, handler);
    }
}
