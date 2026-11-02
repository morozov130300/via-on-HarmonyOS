package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class t7 implements aa {
    protected int zzb = 0;

    public static void f(Iterable iterable, List list) {
        Charset charset = h9.f3535a;
        iterable.getClass();
        if (iterable instanceof j9) {
            List listE = ((j9) iterable).e();
            j9 j9Var = (j9) list;
            int size = list.size();
            for (Object obj : listE) {
                if (obj == null) {
                    String str = "Element at index " + (j9Var.size() - size) + " is null.";
                    int size2 = j9Var.size();
                    while (true) {
                        size2--;
                        if (size2 < size) {
                            throw new NullPointerException(str);
                        }
                        j9Var.remove(size2);
                    }
                } else if (obj instanceof zzka) {
                    j9Var.r((zzka) obj);
                } else {
                    j9Var.add((String) obj);
                }
            }
            return;
        }
        if (iterable instanceof ha) {
            list.addAll((Collection) iterable);
            return;
        }
        if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
            ((ArrayList) list).ensureCapacity(list.size() + ((Collection) iterable).size());
        }
        int size3 = list.size();
        for (Object obj2 : iterable) {
            if (obj2 == null) {
                String str2 = "Element at index " + (list.size() - size3) + " is null.";
                int size4 = list.size();
                while (true) {
                    size4--;
                    if (size4 < size3) {
                        throw new NullPointerException(str2);
                    }
                    list.remove(size4);
                }
            } else {
                list.add(obj2);
            }
        }
    }

    public abstract int e(la laVar);

    public final byte[] i() {
        try {
            int iA = a();
            byte[] bArr = new byte[iA];
            m8 m8VarA = m8.A(bArr, 0, iA);
            d(m8VarA);
            m8VarA.a();
            return bArr;
        } catch (IOException e10) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a byte array threw an IOException (should never happen).", e10);
        }
    }
}
