package z0;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class b implements g, Cloneable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f15115c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f15116e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final j[] f15117m;

    public b(String str, String str2, j[] jVarArr) {
        if (str == null) {
            throw new IllegalArgumentException("Name may not be null");
        }
        this.f15115c = str;
        this.f15116e = str2;
        if (jVarArr != null) {
            this.f15117m = jVarArr;
        } else {
            this.f15117m = new j[0];
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
        return this.f15115c.equals(bVar.f15115c) && i.a(this.f15116e, bVar.f15116e) && i.b(this.f15117m, bVar.f15117m);
    }

    @Override // z0.g
    public String getName() {
        return this.f15115c;
    }

    @Override // z0.g
    public String getValue() {
        return this.f15116e;
    }

    public int hashCode() {
        int iD = i.d(i.d(17, this.f15115c), this.f15116e);
        int i10 = 0;
        while (true) {
            j[] jVarArr = this.f15117m;
            if (i10 >= jVarArr.length) {
                return iD;
            }
            iD = i.d(iD, jVarArr[i10]);
            i10++;
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(64);
        sb2.append(this.f15115c);
        if (this.f15116e != null) {
            sb2.append("=");
            sb2.append(this.f15116e);
        }
        for (int i10 = 0; i10 < this.f15117m.length; i10++) {
            sb2.append("; ");
            sb2.append(this.f15117m[i10]);
        }
        return sb2.toString();
    }
}
