package t5;

import com.google.zxing.DecodeHintType;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Map;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class l implements h {

    /* renamed from: a, reason: collision with root package name */
    public Collection f12205a;

    /* renamed from: b, reason: collision with root package name */
    public Map f12206b;

    /* renamed from: c, reason: collision with root package name */
    public String f12207c;

    /* renamed from: d, reason: collision with root package name */
    public int f12208d;

    public l() {
    }

    public l(int i10) {
        this(c.a(i10));
    }

    public l(Collection collection) {
        this.f12205a = collection;
    }

    @Override // t5.h
    public g a(Map map) {
        EnumMap enumMap = new EnumMap(DecodeHintType.class);
        enumMap.putAll(map);
        Map map2 = this.f12206b;
        if (map2 != null) {
            enumMap.putAll(map2);
        }
        Collection collection = this.f12205a;
        if (collection != null) {
            enumMap.put((EnumMap) DecodeHintType.POSSIBLE_FORMATS, (DecodeHintType) collection);
        }
        String str = this.f12207c;
        if (str != null) {
            enumMap.put((EnumMap) DecodeHintType.CHARACTER_SET, (DecodeHintType) str);
        }
        com.google.zxing.e eVar = new com.google.zxing.e();
        eVar.e(enumMap);
        int i10 = this.f12208d;
        return i10 != 0 ? i10 != 1 ? i10 != 2 ? new g(eVar) : new n(eVar) : new m(eVar) : new g(eVar);
    }
}
