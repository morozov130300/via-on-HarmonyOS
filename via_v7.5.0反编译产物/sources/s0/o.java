package s0;

import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class o {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Set f12144c = new HashSet();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f12145a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f12146b;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class a extends o {
        public a(String str, String str2) {
            super(str, str2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class b extends o {
        public b(String str, String str2) {
            super(str, str2);
        }
    }

    public o(String str, String str2) {
        this.f12145a = str;
        this.f12146b = str2;
        f12144c.add(this);
    }
}
