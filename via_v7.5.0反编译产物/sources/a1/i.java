package a1;

import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class i implements h {
    @Override // a1.h
    public Set a() {
        if (c() != null) {
            return c().keySet();
        }
        return null;
    }

    @Override // a1.h
    public String[] b(String str) {
        if (c() != null) {
            return (String[]) c().get(str);
        }
        return null;
    }

    public abstract Map c();
}
