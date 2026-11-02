package o1;

import android.util.SparseArray;
import com.google.android.datatransport.Priority;
import java.util.HashMap;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static SparseArray f10331a = new SparseArray();

    /* renamed from: b, reason: collision with root package name */
    public static HashMap f10332b;

    static {
        HashMap map = new HashMap();
        f10332b = map;
        map.put(Priority.DEFAULT, 0);
        f10332b.put(Priority.VERY_LOW, 1);
        f10332b.put(Priority.HIGHEST, 2);
        for (Priority priority : f10332b.keySet()) {
            f10331a.append(((Integer) f10332b.get(priority)).intValue(), priority);
        }
    }

    public static int a(Priority priority) {
        Integer num = (Integer) f10332b.get(priority);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalStateException("PriorityMapping is missing known Priority value " + priority);
    }

    public static Priority b(int i10) {
        Priority priority = (Priority) f10331a.get(i10);
        if (priority != null) {
            return priority;
        }
        throw new IllegalArgumentException("Unknown Priority for value " + i10);
    }
}
