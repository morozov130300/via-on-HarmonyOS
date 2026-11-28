package androidx.activity;

import android.window.BackEvent;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f386e = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f387a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f388b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f389c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f390d;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }

        public a() {
        }
    }

    public b(float f10, float f11, float f12, int i10) {
        this.f387a = f10;
        this.f388b = f11;
        this.f389c = f12;
        this.f390d = i10;
    }

    public final float a() {
        return this.f389c;
    }

    public String toString() {
        return "BackEventCompat{touchX=" + this.f387a + ", touchY=" + this.f388b + ", progress=" + this.f389c + ", swipeEdge=" + this.f390d + '}';
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public b(BackEvent backEvent) {
        kotlin.jvm.internal.h.f(backEvent, "backEvent");
        androidx.activity.a aVar = androidx.activity.a.f385a;
        this(aVar.d(backEvent), aVar.e(backEvent), aVar.b(backEvent), aVar.c(backEvent));
    }
}
