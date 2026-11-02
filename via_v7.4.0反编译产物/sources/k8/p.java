package k8;

import java.util.Comparator;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class p implements Comparator {
    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(String str, String str2) {
        int length = str == null ? 0 : str.length();
        int length2 = str2 == null ? 0 : str2.length();
        int i10 = length2;
        int i11 = length;
        while (length > 0 && length2 > 0) {
            int iLastIndexOf = str.lastIndexOf(46, length);
            int i12 = iLastIndexOf + 1;
            int iLastIndexOf2 = str2.lastIndexOf(46, length2);
            int i13 = iLastIndexOf2 + 1;
            int i14 = length - i12;
            int iMin = Math.min(i14, length2 - i13);
            for (int i15 = 0; i15 < iMin; i15++) {
                int iCharAt = str.charAt(i12 + i15) - str2.charAt(i13 + i15);
                if (iCharAt != 0) {
                    return iCharAt;
                }
            }
            int i16 = (i14 - length2) + i13;
            if (i16 != 0) {
                return i16;
            }
            length = iLastIndexOf - 1;
            length2 = iLastIndexOf2 - 1;
            i11 = i12;
            i10 = i13;
        }
        return i11 - i10;
    }
}
