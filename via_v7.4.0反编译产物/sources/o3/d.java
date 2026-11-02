package o3;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class d {

    /* renamed from: b, reason: collision with root package name */
    public static volatile d f10351b;

    /* renamed from: a, reason: collision with root package name */
    public final Set f10352a = new HashSet();

    public static d a() {
        d dVar;
        d dVar2 = f10351b;
        if (dVar2 != null) {
            return dVar2;
        }
        synchronized (d.class) {
            try {
                dVar = f10351b;
                if (dVar == null) {
                    dVar = new d();
                    f10351b = dVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return dVar;
    }

    public Set b() {
        Set setUnmodifiableSet;
        synchronized (this.f10352a) {
            setUnmodifiableSet = Collections.unmodifiableSet(this.f10352a);
        }
        return setUnmodifiableSet;
    }
}
