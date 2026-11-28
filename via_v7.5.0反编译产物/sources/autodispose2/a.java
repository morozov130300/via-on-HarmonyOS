package autodispose2;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: autodispose2.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class C0025a implements autodispose2.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ r6.c f1629a;

        /* JADX INFO: renamed from: autodispose2.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
        public class C0026a implements m {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ r6.f f1630c;

            public C0026a(r6.f fVar) {
                this.f1630c = fVar;
            }

            @Override // autodispose2.m
            public s6.b a(u6.f fVar, u6.f fVar2) {
                return new e(this.f1630c, C0025a.this.f1629a).a(fVar, fVar2);
            }

            @Override // autodispose2.m
            public s6.b b(u6.f fVar) {
                return new e(this.f1630c, C0025a.this.f1629a).b(fVar);
            }
        }

        /* JADX INFO: renamed from: autodispose2.a$a$b */
        /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
        public class b implements n {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ r6.j f1632c;

            public b(r6.j jVar) {
                this.f1632c = jVar;
            }

            @Override // autodispose2.n
            public s6.b a(u6.f fVar, u6.f fVar2) {
                return new f(this.f1632c, C0025a.this.f1629a).a(fVar, fVar2);
            }

            @Override // autodispose2.n
            public s6.b b(u6.f fVar, u6.f fVar2, u6.a aVar) {
                return new f(this.f1632c, C0025a.this.f1629a).b(fVar, fVar2, aVar);
            }
        }

        /* JADX INFO: renamed from: autodispose2.a$a$c */
        /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
        public class c implements r {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ r6.q f1634a;

            public c(r6.q qVar) {
                this.f1634a = qVar;
            }

            @Override // autodispose2.r
            public s6.b a(u6.f fVar, u6.f fVar2) {
                return new h(this.f1634a, C0025a.this.f1629a).a(fVar, fVar2);
            }

            @Override // autodispose2.r
            public s6.b b(u6.f fVar) {
                return new h(this.f1634a, C0025a.this.f1629a).b(fVar);
            }
        }

        public C0025a(r6.c cVar) {
            this.f1629a = cVar;
        }

        @Override // r6.g
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public m a(r6.f fVar) {
            return !g.f1654c ? new e(fVar, this.f1629a) : new C0026a(fVar);
        }

        @Override // r6.k
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public n c(r6.j jVar) {
            return !g.f1654c ? new f(jVar, this.f1629a) : new b(jVar);
        }

        @Override // r6.r
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public r b(r6.q qVar) {
            return !g.f1654c ? new h(qVar, this.f1629a) : new c(qVar);
        }
    }

    public static b a(o oVar) {
        i.a(oVar, "provider == null");
        return b(q.b(oVar));
    }

    public static b b(r6.c cVar) {
        i.a(cVar, "scope == null");
        return new C0025a(cVar);
    }
}
