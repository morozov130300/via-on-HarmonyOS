package g2;

import com.google.android.gms.measurement.internal.zzas;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class r implements Iterator {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Iterator f5261c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzas f5262e;

    public r(zzas zzasVar) {
        this.f5262e = zzasVar;
        this.f5261c = zzasVar.f3262c.keySet().iterator();
    }

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final String next() {
        return (String) this.f5261c.next();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f5261c.hasNext();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Remove not supported");
    }
}
