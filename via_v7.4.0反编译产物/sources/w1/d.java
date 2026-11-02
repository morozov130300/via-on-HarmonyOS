package w1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class d {
    public static List a() {
        return Collections.EMPTY_LIST;
    }

    public static List b(Object obj) {
        return Collections.singletonList(obj);
    }

    public static List c(Object... objArr) {
        int length = objArr.length;
        return length != 0 ? length != 1 ? Collections.unmodifiableList(Arrays.asList(objArr)) : b(objArr[0]) : a();
    }
}
