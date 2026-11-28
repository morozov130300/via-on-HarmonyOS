package u1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class e {

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f12770a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f12771b;

        public /* synthetic */ a(Object obj, p pVar) {
            f.h(obj);
            this.f12771b = obj;
            this.f12770a = new ArrayList();
        }

        public a a(String str, Object obj) {
            List list = this.f12770a;
            f.h(str);
            list.add(str + "=" + String.valueOf(obj));
            return this;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder(100);
            sb2.append(this.f12771b.getClass().getSimpleName());
            sb2.append('{');
            int size = this.f12770a.size();
            for (int i10 = 0; i10 < size; i10++) {
                sb2.append((String) this.f12770a.get(i10));
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
