package f4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class o implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Logger f4478a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f4479b;

    public o(String str) {
        this.f4478a = LoggerFactory.getLogger(str);
        this.f4479b = str;
    }

    @Override // f4.l
    public void a(String str, Object obj, Object obj2) {
        this.f4478a.debug(str, obj, obj2);
    }

    @Override // f4.l
    public void b(String str, Object obj) {
        this.f4478a.debug(str, obj);
    }

    @Override // f4.l
    public void c(String str) {
        this.f4478a.info(str);
    }

    @Override // f4.l
    public void d(String str) {
        this.f4478a.warn(str);
    }
}
