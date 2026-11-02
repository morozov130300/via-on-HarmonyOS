package y0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class i {
    public static boolean a(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static boolean b(Object[] objArr, Object[] objArr2) {
        if (objArr == null) {
            return objArr2 == null;
        }
        if (objArr2 == null || objArr.length != objArr2.length) {
            return false;
        }
        for (int i10 = 0; i10 < objArr.length; i10++) {
            if (!a(objArr[i10], objArr2[i10])) {
                return false;
            }
        }
        return true;
    }

    public static int c(int i10, int i11) {
        return (i10 * 37) + i11;
    }

    public static int d(int i10, Object obj) {
        return c(i10, obj != null ? obj.hashCode() : 0);
    }
}
