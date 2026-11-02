package e5;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    public static volatile b f4764b;

    /* renamed from: a, reason: collision with root package name */
    public g f4765a;

    public static b b() {
        if (f4764b == null) {
            synchronized (b.class) {
                try {
                    if (f4764b == null) {
                        f4764b = new b();
                    }
                } finally {
                }
            }
        }
        return f4764b;
    }

    public g a() {
        if (this.f4765a == null) {
            synchronized (c.class) {
                try {
                    if (this.f4765a == null) {
                        this.f4765a = new e();
                    }
                } finally {
                }
            }
        }
        return this.f4765a;
    }
}
