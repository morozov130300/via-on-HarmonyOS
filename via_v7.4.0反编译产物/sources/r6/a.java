package r6;

import android.text.method.MovementMethod;
import k6.i;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class a extends k6.a {

    /* renamed from: a, reason: collision with root package name */
    public final MovementMethod f11584a;

    public a(MovementMethod movementMethod) {
        this.f11584a = movementMethod;
    }

    public static a j(MovementMethod movementMethod) {
        return new a(movementMethod);
    }

    @Override // k6.a, k6.i
    public void h(i.a aVar) {
        ((io.noties.markwon.core.a) aVar.a(io.noties.markwon.core.a.class)).t(true);
    }
}
