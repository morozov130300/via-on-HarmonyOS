package v3;

import com.google.zxing.BarcodeFormat;
import java.util.Collection;
import java.util.Collections;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class e extends r {
    public static void i(int i10, int[] iArr) {
        for (int i11 = 0; i11 < 9; i11++) {
            int i12 = 1;
            if (((1 << (8 - i11)) & i10) != 0) {
                i12 = 2;
            }
            iArr[i11] = i12;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00d8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String j(String str) {
        int length = str.length();
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt = str.charAt(i10);
            if (cCharAt == 0) {
                sb2.append("%U");
            } else if (cCharAt == ' ') {
                sb2.append(cCharAt);
            } else if (cCharAt == '@') {
                sb2.append("%V");
            } else if (cCharAt == '`') {
                sb2.append("%W");
            } else if (cCharAt != '-' && cCharAt != '.') {
                if (cCharAt <= 26) {
                    sb2.append('$');
                    sb2.append((char) (cCharAt + '@'));
                } else if (cCharAt < ' ') {
                    sb2.append('%');
                    sb2.append((char) (cCharAt + '&'));
                } else if (cCharAt <= ',' || cCharAt == '/' || cCharAt == ':') {
                    sb2.append('/');
                    sb2.append((char) (cCharAt + ' '));
                } else if (cCharAt <= '9') {
                    sb2.append(cCharAt);
                } else if (cCharAt <= '?') {
                    sb2.append('%');
                    sb2.append((char) (cCharAt + 11));
                } else if (cCharAt <= 'Z') {
                    sb2.append(cCharAt);
                } else if (cCharAt <= '_') {
                    sb2.append('%');
                    sb2.append((char) (cCharAt - 16));
                } else if (cCharAt <= 'z') {
                    sb2.append('+');
                    sb2.append((char) (cCharAt - ' '));
                } else {
                    if (cCharAt > '\u007f') {
                        throw new IllegalArgumentException("Requested content contains a non-encodable character: '" + str.charAt(i10) + "'");
                    }
                    sb2.append('%');
                    sb2.append((char) (cCharAt - '+'));
                }
            }
        }
        return sb2.toString();
    }

    @Override // v3.r
    public boolean[] d(String str) {
        int length = str.length();
        if (length > 80) {
            throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + length);
        }
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                break;
            }
            if ("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(str.charAt(i10)) < 0) {
                str = j(str);
                length = str.length();
                if (length > 80) {
                    throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + length + " (extended full ASCII mode)");
                }
            } else {
                i10++;
            }
        }
        int[] iArr = new int[9];
        boolean[] zArr = new boolean[(length * 13) + 25];
        i(148, iArr);
        int iB = r.b(zArr, 0, iArr, true);
        int[] iArr2 = {1};
        int iB2 = iB + r.b(zArr, iB, iArr2, false);
        for (int i11 = 0; i11 < length; i11++) {
            i(d.f12975e["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(str.charAt(i11))], iArr);
            int iB3 = iB2 + r.b(zArr, iB2, iArr, true);
            iB2 = iB3 + r.b(zArr, iB3, iArr2, false);
        }
        i(148, iArr);
        r.b(zArr, iB2, iArr, true);
        return zArr;
    }

    @Override // v3.r
    public Collection g() {
        return Collections.singleton(BarcodeFormat.CODE_39);
    }
}
