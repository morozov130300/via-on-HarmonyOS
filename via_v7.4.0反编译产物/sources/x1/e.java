package x1;

import android.content.Context;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class e {

    /* renamed from: b, reason: collision with root package name */
    public static e f13570b = new e();

    /* renamed from: a, reason: collision with root package name */
    public d f13571a = null;

    public static d a(Context context) {
        return f13570b.b(context);
    }

    public final synchronized d b(Context context) {
        try {
            if (this.f13571a == null) {
                if (context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                this.f13571a = new d(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f13571a;
    }
}
