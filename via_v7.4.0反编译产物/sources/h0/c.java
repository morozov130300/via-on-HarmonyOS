package h0;

import androidx.lifecycle.y;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.h;
import q7.l;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final List f6320a = new ArrayList();

    public final void a(u7.c clazz, l initializer) {
        h.f(clazz, "clazz");
        h.f(initializer, "initializer");
        this.f6320a.add(new f(p7.a.a(clazz), initializer));
    }

    public final y.b b() {
        f[] fVarArr = (f[]) this.f6320a.toArray(new f[0]);
        return new b((f[]) Arrays.copyOf(fVarArr, fVarArr.length));
    }
}
