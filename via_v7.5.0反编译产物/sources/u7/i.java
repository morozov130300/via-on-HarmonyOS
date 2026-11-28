package u7;

import java.util.Iterator;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import p7.p;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class i {

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p f12893a;

        public a(p pVar) {
            this.f12893a = pVar;
        }

        @Override // u7.f
        public Iterator iterator() {
            return i.a(this.f12893a);
        }
    }

    public static final Iterator a(p block) {
        kotlin.jvm.internal.h.f(block, "block");
        g gVar = new g();
        gVar.d(IntrinsicsKt__IntrinsicsJvmKt.a(block, gVar, gVar));
        return gVar;
    }

    public static f b(p block) {
        kotlin.jvm.internal.h.f(block, "block");
        return new a(block);
    }
}
