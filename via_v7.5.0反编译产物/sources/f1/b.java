package f1;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class b extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f4418a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o1.a f4419b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final o1.a f4420c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f4421d;

    public b(Context context, o1.a aVar, o1.a aVar2, String str) {
        if (context == null) {
            throw new NullPointerException("Null applicationContext");
        }
        this.f4418a = context;
        if (aVar == null) {
            throw new NullPointerException("Null wallClock");
        }
        this.f4419b = aVar;
        if (aVar2 == null) {
            throw new NullPointerException("Null monotonicClock");
        }
        this.f4420c = aVar2;
        if (str == null) {
            throw new NullPointerException("Null backendName");
        }
        this.f4421d = str;
    }

    @Override // f1.f
    public Context b() {
        return this.f4418a;
    }

    @Override // f1.f
    public String c() {
        return this.f4421d;
    }

    @Override // f1.f
    public o1.a d() {
        return this.f4420c;
    }

    @Override // f1.f
    public o1.a e() {
        return this.f4419b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (this.f4418a.equals(fVar.b()) && this.f4419b.equals(fVar.e()) && this.f4420c.equals(fVar.d()) && this.f4421d.equals(fVar.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((((this.f4418a.hashCode() ^ 1000003) * 1000003) ^ this.f4419b.hashCode()) * 1000003) ^ this.f4420c.hashCode()) * 1000003) ^ this.f4421d.hashCode();
    }

    public String toString() {
        return "CreationContext{applicationContext=" + this.f4418a + ", wallClock=" + this.f4419b + ", monotonicClock=" + this.f4420c + ", backendName=" + this.f4421d + "}";
    }
}
