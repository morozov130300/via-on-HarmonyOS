package i0;

import androidx.lifecycle.a0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.h;
import p7.l;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f6189a = new ArrayList();

    public final void a(t7.c clazz, l initializer) {
        h.f(clazz, "clazz");
        h.f(initializer, "initializer");
        this.f6189a.add(new f(o7.a.a(clazz), initializer));
    }

    public final a0.b b() {
        f[] fVarArr = (f[]) this.f6189a.toArray(new f[0]);
        return new b((f[]) Arrays.copyOf(fVarArr, fVarArr.length));
    }
}
