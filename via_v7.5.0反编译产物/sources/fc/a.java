package fc;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List f4607a = new ArrayList();

    @Override // fc.b
    public void a(ec.a aVar) {
        this.f4607a.add(aVar);
    }

    public List b() {
        return this.f4607a;
    }
}
