package n5;

import com.google.zxing.DecodeHintType;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class l implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Collection f10634a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map f10635b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f10636c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f10637d;

    public l() {
    }

    @Override // n5.h
    public g a(Map map) {
        EnumMap enumMap = new EnumMap(DecodeHintType.class);
        enumMap.putAll(map);
        Map map2 = this.f10635b;
        if (map2 != null) {
            enumMap.putAll(map2);
        }
        Collection collection = this.f10634a;
        if (collection != null) {
            enumMap.put(DecodeHintType.POSSIBLE_FORMATS, collection);
        }
        String str = this.f10636c;
        if (str != null) {
            enumMap.put(DecodeHintType.CHARACTER_SET, str);
        }
        com.google.zxing.e eVar = new com.google.zxing.e();
        eVar.e(enumMap);
        int i10 = this.f10637d;
        if (i10 == 0) {
            return new g(eVar);
        }
        if (i10 != 1) {
            return i10 != 2 ? new g(eVar) : new n(eVar);
        }
        return new m(eVar);
    }

    public l(int i10) {
        this(c.a(i10));
    }

    public l(Collection collection) {
        this.f10634a = collection;
    }
}
