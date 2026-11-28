package i0;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f6186a = new LinkedHashMap();

    /* JADX INFO: renamed from: i0.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class C0074a extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final C0074a f6187b = new C0074a();

        @Override // i0.a
        public Object a(b key) {
            h.f(key, "key");
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface b {
    }

    public abstract Object a(b bVar);

    public final Map b() {
        return this.f6186a;
    }
}
