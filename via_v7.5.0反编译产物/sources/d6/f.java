package d6;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class f extends d6.a {

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class b extends d6.a.AbstractC0057a {
        public f b() {
            return new f(this.f3918a);
        }

        public b c(Object obj, c7.a aVar) {
            super.a(obj, aVar);
            return this;
        }

        public b(int i10) {
            super(i10);
        }
    }

    public static b b(int i10) {
        return new b(i10);
    }

    @Override // c7.a
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public Map get() {
        return a();
    }

    public f(Map map) {
        super(map);
    }
}
