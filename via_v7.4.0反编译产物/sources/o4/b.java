package o4;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    public static volatile b f10355b;

    /* renamed from: a, reason: collision with root package name */
    public int f10356a = 1;

    public static b b() {
        if (f10355b == null) {
            synchronized (b.class) {
                try {
                    if (f10355b == null) {
                        f10355b = new b();
                    }
                } finally {
                }
            }
        }
        return f10355b;
    }

    public int a() {
        int i10 = this.f10356a;
        this.f10356a = i10 + 1;
        return i10;
    }
}
