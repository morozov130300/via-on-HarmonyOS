package e6;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class m {

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l.b f4247a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g f4248b;

        public a(l.b bVar, g gVar) {
            this.f4247a = bVar;
            this.f4248b = gVar;
        }

        @Override // e6.m
        public l a() {
            return this.f4247a.b(this.f4248b, new r());
        }
    }

    public static m b(l.b bVar, g gVar) {
        return new a(bVar, gVar);
    }

    public abstract l a();
}
