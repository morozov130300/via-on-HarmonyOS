package t1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class e {

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final List f12037a;

        /* renamed from: b, reason: collision with root package name */
        public final Object f12038b;

        public /* synthetic */ a(Object obj, p pVar) {
            f.h(obj);
            this.f12038b = obj;
            this.f12037a = new ArrayList();
        }

        public a a(String str, Object obj) {
            List list = this.f12037a;
            f.h(str);
            list.add(str + "=" + String.valueOf(obj));
            return this;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder(100);
            sb2.append(this.f12038b.getClass().getSimpleName());
            sb2.append('{');
            int size = this.f12037a.size();
            for (int i10 = 0; i10 < size; i10++) {
                sb2.append((String) this.f12037a.get(i10));
                if (i10 < size - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append('}');
            return sb2.toString();
        }
    }

    public static boolean a(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static int b(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static a c(Object obj) {
        return new a(obj, null);
    }
}
