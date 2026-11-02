package androidx.activity;

import android.window.BackEvent;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: e, reason: collision with root package name */
    public static final a f483e = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final float f484a;

    /* renamed from: b, reason: collision with root package name */
    public final float f485b;

    /* renamed from: c, reason: collision with root package name */
    public final float f486c;

    /* renamed from: d, reason: collision with root package name */
    public final int f487d;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    public b(float f10, float f11, float f12, int i10) {
        this.f484a = f10;
        this.f485b = f11;
        this.f486c = f12;
        this.f487d = i10;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public b(BackEvent backEvent) {
        kotlin.jvm.internal.h.f(backEvent, "backEvent");
        androidx.activity.a aVar = androidx.activity.a.f482a;
        this(aVar.d(backEvent), aVar.e(backEvent), aVar.b(backEvent), aVar.c(backEvent));
    }

    public final float a() {
        return this.f486c;
    }

    public String toString() {
        return "BackEventCompat{touchX=" + this.f484a + ", touchY=" + this.f485b + ", progress=" + this.f486c + ", swipeEdge=" + this.f487d + '}';
    }
}
