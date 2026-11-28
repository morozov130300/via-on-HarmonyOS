package dc;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class a implements c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f4051c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f4052e;

    public a(int i10, int i11) {
        this.f4051c = i10;
        this.f4052e = i11;
    }

    @Override // dc.c
    public int b() {
        return this.f4051c;
    }

    @Override // dc.c
    public int c() {
        return this.f4052e;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        if (!(obj instanceof c)) {
            return -1;
        }
        c cVar = (c) obj;
        int iB = this.f4051c - cVar.b();
        return iB != 0 ? iB : this.f4052e - cVar.c();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f4051c == cVar.b() && this.f4052e == cVar.c();
    }

    public int hashCode() {
        return (this.f4051c % 100) + (this.f4052e % 100);
    }

    @Override // dc.c
    public int size() {
        return (this.f4052e - this.f4051c) + 1;
    }

    public String toString() {
        return this.f4051c + ":" + this.f4052e;
    }
}
