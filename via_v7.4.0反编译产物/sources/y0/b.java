package y0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class b implements g, Cloneable {

    /* renamed from: e, reason: collision with root package name */
    public final String f14387e;

    /* renamed from: j, reason: collision with root package name */
    public final String f14388j;

    /* renamed from: k, reason: collision with root package name */
    public final j[] f14389k;

    public b(String str, String str2, j[] jVarArr) {
        if (str == null) {
            throw new IllegalArgumentException("Name may not be null");
        }
        this.f14387e = str;
        this.f14388j = str2;
        if (jVarArr != null) {
            this.f14389k = jVarArr;
        } else {
            this.f14389k = new j[0];
        }
    }

    public Object clone() {
        return super.clone();
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f14387e.equals(bVar.f14387e) && i.a(this.f14388j, bVar.f14388j) && i.b(this.f14389k, bVar.f14389k);
    }

    @Override // y0.g
    public String getName() {
        return this.f14387e;
    }

    @Override // y0.g
    public String getValue() {
        return this.f14388j;
    }

    public int hashCode() {
        int iD = i.d(i.d(17, this.f14387e), this.f14388j);
        int i10 = 0;
        while (true) {
            j[] jVarArr = this.f14389k;
            if (i10 >= jVarArr.length) {
                return iD;
            }
            iD = i.d(iD, jVarArr[i10]);
            i10++;
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(64);
        sb2.append(this.f14387e);
        if (this.f14388j != null) {
            sb2.append("=");
            sb2.append(this.f14388j);
        }
        for (int i10 = 0; i10 < this.f14389k.length; i10++) {
            sb2.append("; ");
            sb2.append(this.f14389k[i10]);
        }
        return sb2.toString();
    }
}
