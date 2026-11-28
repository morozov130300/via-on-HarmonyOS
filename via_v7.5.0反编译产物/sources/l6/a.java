package l6;

import android.text.method.MovementMethod;
import e6.i;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class a extends e6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MovementMethod f7478a;

    public a(MovementMethod movementMethod) {
        this.f7478a = movementMethod;
    }

    public static a j(MovementMethod movementMethod) {
        return new a(movementMethod);
    }

    @Override // e6.a, e6.i
    public void h(i.a aVar) {
        ((io.noties.markwon.core.a) aVar.a(io.noties.markwon.core.a.class)).t(true);
    }
}
