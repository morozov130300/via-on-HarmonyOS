package f2;

import com.google.android.gms.measurement.internal.zzas;
import java.util.Iterator;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class r implements Iterator {

    /* renamed from: e, reason: collision with root package name */
    public final Iterator f5645e;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ zzas f5646j;

    public r(zzas zzasVar) {
        this.f5646j = zzasVar;
        this.f5645e = zzasVar.f3963e.keySet().iterator();
    }

    @Override // java.util.Iterator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final String next() {
        return (String) this.f5645e.next();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f5645e.hasNext();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Remove not supported");
    }
}
