package androidx.profileinstaller;

import j0.m;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f1105a = {112, 114, 111, 0};

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f1106b = {112, 114, 109, 0};

    public static void A(InputStream inputStream) {
        j0.e.h(inputStream);
        int iJ = j0.e.j(inputStream);
        if (iJ == 6 || iJ == 7) {
            return;
        }
        while (iJ > 0) {
            j0.e.j(inputStream);
            for (int iJ2 = j0.e.j(inputStream); iJ2 > 0; iJ2--) {
                j0.e.h(inputStream);
            }
            iJ--;
        }
    }

    public static boolean B(OutputStream outputStream, byte[] bArr, j0.d[] dVarArr) throws IOException {
        if (Arrays.equals(bArr, m.f7508a)) {
            N(outputStream, dVarArr);
            return true;
        }
        if (Arrays.equals(bArr, m.f7509b)) {
            M(outputStream, dVarArr);
            return true;
        }
        if (Arrays.equals(bArr, m.f7511d)) {
            K(outputStream, dVarArr);
            return true;
        }
        if (Arrays.equals(bArr, m.f7510c)) {
            L(outputStream, dVarArr);
            return true;
        }
        if (!Arrays.equals(bArr, m.f7512e)) {
            return false;
        }
        J(outputStream, dVarArr);
        return true;
    }

    public static void C(OutputStream outputStream, j0.d dVar) throws IOException {
        int[] iArr = dVar.f7498h;
        int length = iArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            int i12 = iArr[i10];
            j0.e.p(outputStream, i12 - i11);
            i10++;
            i11 = i12;
        }
    }

    public static f D(j0.d[] dVarArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            j0.e.p(byteArrayOutputStream, dVarArr.length);
            int i10 = 2;
            for (j0.d dVar : dVarArr) {
                j0.e.q(byteArrayOutputStream, dVar.f7493c);
                j0.e.q(byteArrayOutputStream, dVar.f7494d);
                j0.e.q(byteArrayOutputStream, dVar.f7497g);
                String strJ = j(dVar.f7491a, dVar.f7492b, m.f7508a);
                int iK = j0.e.k(strJ);
                j0.e.p(byteArrayOutputStream, iK);
                i10 = i10 + 14 + iK;
                j0.e.n(byteArrayOutputStream, strJ);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (i10 == byteArray.length) {
                f fVar = new f(FileSectionType.DEX_FILES, i10, byteArray, false);
                byteArrayOutputStream.close();
                return fVar;
            }
            throw j0.e.c("Expected size " + i10 + ", does not match actual size " + byteArray.length);
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static void E(OutputStream outputStream, byte[] bArr) throws IOException {
        outputStream.write(f1105a);
        outputStream.write(bArr);
    }

    public static void F(OutputStream outputStream, j0.d dVar) throws IOException {
        I(outputStream, dVar);
        C(outputStream, dVar);
        H(outputStream, dVar);
    }

    public static void G(OutputStream outputStream, j0.d dVar, String str) throws IOException {
        j0.e.p(outputStream, j0.e.k(str));
        j0.e.p(outputStream, dVar.f7495e);
        j0.e.q(outputStream, dVar.f7496f);
        j0.e.q(outputStream, dVar.f7493c);
        j0.e.q(outputStream, dVar.f7497g);
        j0.e.n(outputStream, str);
    }

    public static void H(OutputStream outputStream, j0.d dVar) throws IOException {
        byte[] bArr = new byte[k(dVar.f7497g)];
        for (Map.Entry entry : dVar.f7499i.entrySet()) {
            int iIntValue = ((Integer) entry.getKey()).intValue();
            int iIntValue2 = ((Integer) entry.getValue()).intValue();
            if ((iIntValue2 & 2) != 0) {
                z(bArr, 2, iIntValue, dVar);
            }
            if ((iIntValue2 & 4) != 0) {
                z(bArr, 4, iIntValue, dVar);
            }
        }
        outputStream.write(bArr);
    }

    public static void I(OutputStream outputStream, j0.d dVar) throws IOException {
        int i10 = 0;
        for (Map.Entry entry : dVar.f7499i.entrySet()) {
            int iIntValue = ((Integer) entry.getKey()).intValue();
            if ((((Integer) entry.getValue()).intValue() & 1) != 0) {
                j0.e.p(outputStream, iIntValue - i10);
                j0.e.p(outputStream, 0);
                i10 = iIntValue;
            }
        }
    }

    public static void J(OutputStream outputStream, j0.d[] dVarArr) throws IOException {
        j0.e.p(outputStream, dVarArr.length);
        for (j0.d dVar : dVarArr) {
            String strJ = j(dVar.f7491a, dVar.f7492b, m.f7512e);
            j0.e.p(outputStream, j0.e.k(strJ));
            j0.e.p(outputStream, dVar.f7499i.size());
            j0.e.p(outputStream, dVar.f7498h.length);
            j0.e.q(outputStream, dVar.f7493c);
            j0.e.n(outputStream, strJ);
            Iterator it = dVar.f7499i.keySet().iterator();
            while (it.hasNext()) {
                j0.e.p(outputStream, ((Integer) it.next()).intValue());
            }
            for (int i10 : dVar.f7498h) {
                j0.e.p(outputStream, i10);
            }
        }
    }

    public static void K(OutputStream outputStream, j0.d[] dVarArr) throws IOException {
        j0.e.r(outputStream, dVarArr.length);
        for (j0.d dVar : dVarArr) {
            int size = dVar.f7499i.size() * 4;
            String strJ = j(dVar.f7491a, dVar.f7492b, m.f7511d);
            j0.e.p(outputStream, j0.e.k(strJ));
            j0.e.p(outputStream, dVar.f7498h.length);
            j0.e.q(outputStream, size);
            j0.e.q(outputStream, dVar.f7493c);
            j0.e.n(outputStream, strJ);
            Iterator it = dVar.f7499i.keySet().iterator();
            while (it.hasNext()) {
                j0.e.p(outputStream, ((Integer) it.next()).intValue());
                j0.e.p(outputStream, 0);
            }
            for (int i10 : dVar.f7498h) {
                j0.e.p(outputStream, i10);
            }
        }
    }

    public static void L(OutputStream outputStream, j0.d[] dVarArr) throws IOException {
        byte[] bArrB = b(dVarArr, m.f7510c);
        j0.e.r(outputStream, dVarArr.length);
        j0.e.m(outputStream, bArrB);
    }

    public static void M(OutputStream outputStream, j0.d[] dVarArr) throws IOException {
        byte[] bArrB = b(dVarArr, m.f7509b);
        j0.e.r(outputStream, dVarArr.length);
        j0.e.m(outputStream, bArrB);
    }

    public static void N(OutputStream outputStream, j0.d[] dVarArr) throws IOException {
        O(outputStream, dVarArr);
    }

    public static void O(OutputStream outputStream, j0.d[] dVarArr) throws IOException {
        int length;
        ArrayList arrayList = new ArrayList(3);
        ArrayList arrayList2 = new ArrayList(3);
        arrayList.add(D(dVarArr));
        arrayList.add(c(dVarArr));
        arrayList.add(d(dVarArr));
        long length2 = m.f7508a.length + f1105a.length + 4 + (arrayList.size() * 16);
        j0.e.q(outputStream, arrayList.size());
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            f fVar = (f) arrayList.get(i10);
            j0.e.q(outputStream, fVar.f1117a.getValue());
            j0.e.q(outputStream, length2);
            if (fVar.f1120d) {
                byte[] bArr = fVar.f1119c;
                long length3 = bArr.length;
                byte[] bArrB = j0.e.b(bArr);
                arrayList2.add(bArrB);
                j0.e.q(outputStream, bArrB.length);
                j0.e.q(outputStream, length3);
                length = bArrB.length;
            } else {
                arrayList2.add(fVar.f1119c);
                j0.e.q(outputStream, fVar.f1119c.length);
                j0.e.q(outputStream, 0L);
                length = fVar.f1119c.length;
            }
            length2 += length;
        }
        for (int i11 = 0; i11 < arrayList2.size(); i11++) {
            outputStream.write((byte[]) arrayList2.get(i11));
        }
    }

    public static int a(j0.d dVar) {
        Iterator it = dVar.f7499i.entrySet().iterator();
        int iIntValue = 0;
        while (it.hasNext()) {
            iIntValue |= ((Integer) ((Map.Entry) it.next()).getValue()).intValue();
        }
        return iIntValue;
    }

    public static byte[] b(j0.d[] dVarArr, byte[] bArr) throws IOException {
        int i10 = 0;
        int iK = 0;
        for (j0.d dVar : dVarArr) {
            iK += j0.e.k(j(dVar.f7491a, dVar.f7492b, bArr)) + 16 + (dVar.f7495e * 2) + dVar.f7496f + k(dVar.f7497g);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(iK);
        if (Arrays.equals(bArr, m.f7510c)) {
            int length = dVarArr.length;
            while (i10 < length) {
                j0.d dVar2 = dVarArr[i10];
                G(byteArrayOutputStream, dVar2, j(dVar2.f7491a, dVar2.f7492b, bArr));
                F(byteArrayOutputStream, dVar2);
                i10++;
            }
        } else {
            for (j0.d dVar3 : dVarArr) {
                G(byteArrayOutputStream, dVar3, j(dVar3.f7491a, dVar3.f7492b, bArr));
            }
            int length2 = dVarArr.length;
            while (i10 < length2) {
                F(byteArrayOutputStream, dVarArr[i10]);
                i10++;
            }
        }
        if (byteArrayOutputStream.size() == iK) {
            return byteArrayOutputStream.toByteArray();
        }
        throw j0.e.c("The bytes saved do not match expectation. actual=" + byteArrayOutputStream.size() + " expected=" + iK);
    }

    public static f c(j0.d[] dVarArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i10 = 0;
        for (int i11 = 0; i11 < dVarArr.length; i11++) {
            try {
                j0.d dVar = dVarArr[i11];
                j0.e.p(byteArrayOutputStream, i11);
                j0.e.p(byteArrayOutputStream, dVar.f7495e);
                i10 = i10 + 4 + (dVar.f7495e * 2);
                C(byteArrayOutputStream, dVar);
            } catch (Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (i10 == byteArray.length) {
            f fVar = new f(FileSectionType.CLASSES, i10, byteArray, true);
            byteArrayOutputStream.close();
            return fVar;
        }
        throw j0.e.c("Expected size " + i10 + ", does not match actual size " + byteArray.length);
    }

    public static f d(j0.d[] dVarArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i10 = 0;
        for (int i11 = 0; i11 < dVarArr.length; i11++) {
            try {
                j0.d dVar = dVarArr[i11];
                int iA = a(dVar);
                byte[] bArrE = e(dVar);
                byte[] bArrF = f(dVar);
                j0.e.p(byteArrayOutputStream, i11);
                int length = bArrE.length + 2 + bArrF.length;
                j0.e.q(byteArrayOutputStream, length);
                j0.e.p(byteArrayOutputStream, iA);
                byteArrayOutputStream.write(bArrE);
                byteArrayOutputStream.write(bArrF);
                i10 = i10 + 6 + length;
            } catch (Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (i10 == byteArray.length) {
            f fVar = new f(FileSectionType.METHODS, i10, byteArray, true);
            byteArrayOutputStream.close();
            return fVar;
        }
        throw j0.e.c("Expected size " + i10 + ", does not match actual size " + byteArray.length);
    }

    public static byte[] e(j0.d dVar) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            H(byteArrayOutputStream, dVar);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static byte[] f(j0.d dVar) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            I(byteArrayOutputStream, dVar);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static String g(String str, String str2) {
        return "!".equals(str2) ? str.replace(":", "!") : ":".equals(str2) ? str.replace("!", ":") : str;
    }

    public static String h(String str) {
        int iIndexOf = str.indexOf("!");
        if (iIndexOf < 0) {
            iIndexOf = str.indexOf(":");
        }
        return iIndexOf > 0 ? str.substring(iIndexOf + 1) : str;
    }

    public static j0.d i(j0.d[] dVarArr, String str) {
        if (dVarArr.length <= 0) {
            return null;
        }
        String strH = h(str);
        for (int i10 = 0; i10 < dVarArr.length; i10++) {
            if (dVarArr[i10].f7492b.equals(strH)) {
                return dVarArr[i10];
            }
        }
        return null;
    }

    public static String j(String str, String str2, byte[] bArr) {
        String strA = m.a(bArr);
        if (str.length() <= 0) {
            return g(str2, strA);
        }
        if (str2.equals("classes.dex")) {
            return str;
        }
        if (str2.contains("!") || str2.contains(":")) {
            return g(str2, strA);
        }
        if (str2.endsWith(".apk")) {
            return str2;
        }
        return str + m.a(bArr) + str2;
    }

    public static int k(int i10) {
        return y(i10 * 2) / 8;
    }

    public static int l(int i10, int i11, int i12) {
        if (i10 == 1) {
            throw j0.e.c("HOT methods are not stored in the bitmap");
        }
        if (i10 == 2) {
            return i11;
        }
        if (i10 == 4) {
            return i11 + i12;
        }
        throw j0.e.c("Unexpected flag: " + i10);
    }

    public static int[] m(InputStream inputStream, int i10) {
        int[] iArr = new int[i10];
        int iH = 0;
        for (int i11 = 0; i11 < i10; i11++) {
            iH += j0.e.h(inputStream);
            iArr[i11] = iH;
        }
        return iArr;
    }

    public static int n(BitSet bitSet, int i10, int i11) {
        int i12 = bitSet.get(l(2, i10, i11)) ? 2 : 0;
        return bitSet.get(l(4, i10, i11)) ? i12 | 4 : i12;
    }

    public static byte[] o(InputStream inputStream, byte[] bArr) {
        if (Arrays.equals(bArr, j0.e.d(inputStream, bArr.length))) {
            return j0.e.d(inputStream, m.f7509b.length);
        }
        throw j0.e.c("Invalid magic");
    }

    public static void p(InputStream inputStream, j0.d dVar) {
        int iAvailable = inputStream.available() - dVar.f7496f;
        int iH = 0;
        while (inputStream.available() > iAvailable) {
            iH += j0.e.h(inputStream);
            dVar.f7499i.put(Integer.valueOf(iH), 1);
            for (int iH2 = j0.e.h(inputStream); iH2 > 0; iH2--) {
                A(inputStream);
            }
        }
        if (inputStream.available() != iAvailable) {
            throw j0.e.c("Read too much data during profile line parse");
        }
    }

    public static j0.d[] q(InputStream inputStream, byte[] bArr, byte[] bArr2, j0.d[] dVarArr) {
        if (Arrays.equals(bArr, m.f7513f)) {
            if (Arrays.equals(m.f7508a, bArr2)) {
                throw j0.e.c("Requires new Baseline Profile Metadata. Please rebuild the APK with Android Gradle Plugin 7.2 Canary 7 or higher");
            }
            return r(inputStream, bArr, dVarArr);
        }
        if (Arrays.equals(bArr, m.f7514g)) {
            return t(inputStream, bArr2, dVarArr);
        }
        throw j0.e.c("Unsupported meta version");
    }

    public static j0.d[] r(InputStream inputStream, byte[] bArr, j0.d[] dVarArr) throws IOException {
        if (!Arrays.equals(bArr, m.f7513f)) {
            throw j0.e.c("Unsupported meta version");
        }
        int iJ = j0.e.j(inputStream);
        byte[] bArrE = j0.e.e(inputStream, (int) j0.e.i(inputStream), (int) j0.e.i(inputStream));
        if (inputStream.read() > 0) {
            throw j0.e.c("Content found after the end of file");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrE);
        try {
            j0.d[] dVarArrS = s(byteArrayInputStream, iJ, dVarArr);
            byteArrayInputStream.close();
            return dVarArrS;
        } catch (Throwable th) {
            try {
                byteArrayInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static j0.d[] s(InputStream inputStream, int i10, j0.d[] dVarArr) {
        if (inputStream.available() == 0) {
            return new j0.d[0];
        }
        if (i10 != dVarArr.length) {
            throw j0.e.c("Mismatched number of dex files found in metadata");
        }
        String[] strArr = new String[i10];
        int[] iArr = new int[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            int iH = j0.e.h(inputStream);
            iArr[i11] = j0.e.h(inputStream);
            strArr[i11] = j0.e.f(inputStream, iH);
        }
        for (int i12 = 0; i12 < i10; i12++) {
            j0.d dVar = dVarArr[i12];
            if (!dVar.f7492b.equals(strArr[i12])) {
                throw j0.e.c("Order of dexfiles in metadata did not match baseline");
            }
            int i13 = iArr[i12];
            dVar.f7495e = i13;
            dVar.f7498h = m(inputStream, i13);
        }
        return dVarArr;
    }

    public static j0.d[] t(InputStream inputStream, byte[] bArr, j0.d[] dVarArr) throws IOException {
        int iH = j0.e.h(inputStream);
        byte[] bArrE = j0.e.e(inputStream, (int) j0.e.i(inputStream), (int) j0.e.i(inputStream));
        if (inputStream.read() > 0) {
            throw j0.e.c("Content found after the end of file");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrE);
        try {
            j0.d[] dVarArrU = u(byteArrayInputStream, bArr, iH, dVarArr);
            byteArrayInputStream.close();
            return dVarArrU;
        } catch (Throwable th) {
            try {
                byteArrayInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static j0.d[] u(InputStream inputStream, byte[] bArr, int i10, j0.d[] dVarArr) {
        if (inputStream.available() == 0) {
            return new j0.d[0];
        }
        if (i10 != dVarArr.length) {
            throw j0.e.c("Mismatched number of dex files found in metadata");
        }
        for (int i11 = 0; i11 < i10; i11++) {
            j0.e.h(inputStream);
            String strF = j0.e.f(inputStream, j0.e.h(inputStream));
            long jI = j0.e.i(inputStream);
            int iH = j0.e.h(inputStream);
            j0.d dVarI = i(dVarArr, strF);
            if (dVarI == null) {
                throw j0.e.c("Missing profile key: " + strF);
            }
            dVarI.f7494d = jI;
            int[] iArrM = m(inputStream, iH);
            if (Arrays.equals(bArr, m.f7512e)) {
                dVarI.f7495e = iH;
                dVarI.f7498h = iArrM;
            }
        }
        return dVarArr;
    }

    public static void v(InputStream inputStream, j0.d dVar) {
        BitSet bitSetValueOf = BitSet.valueOf(j0.e.d(inputStream, j0.e.a(dVar.f7497g * 2)));
        int i10 = 0;
        while (true) {
            int i11 = dVar.f7497g;
            if (i10 >= i11) {
                return;
            }
            int iN = n(bitSetValueOf, i10, i11);
            if (iN != 0) {
                Integer num = (Integer) dVar.f7499i.get(Integer.valueOf(i10));
                if (num == null) {
                    num = 0;
                }
                dVar.f7499i.put(Integer.valueOf(i10), Integer.valueOf(iN | num.intValue()));
            }
            i10++;
        }
    }

    public static j0.d[] w(InputStream inputStream, byte[] bArr, String str) throws IOException {
        if (!Arrays.equals(bArr, m.f7509b)) {
            throw j0.e.c("Unsupported version");
        }
        int iJ = j0.e.j(inputStream);
        byte[] bArrE = j0.e.e(inputStream, (int) j0.e.i(inputStream), (int) j0.e.i(inputStream));
        if (inputStream.read() > 0) {
            throw j0.e.c("Content found after the end of file");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrE);
        try {
            j0.d[] dVarArrX = x(byteArrayInputStream, str, iJ);
            byteArrayInputStream.close();
            return dVarArrX;
        } catch (Throwable th) {
            try {
                byteArrayInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static j0.d[] x(InputStream inputStream, String str, int i10) {
        if (inputStream.available() == 0) {
            return new j0.d[0];
        }
        j0.d[] dVarArr = new j0.d[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            int iH = j0.e.h(inputStream);
            int iH2 = j0.e.h(inputStream);
            long jI = j0.e.i(inputStream);
            dVarArr[i11] = new j0.d(str, j0.e.f(inputStream, iH), j0.e.i(inputStream), 0L, iH2, (int) jI, (int) j0.e.i(inputStream), new int[iH2], new TreeMap());
        }
        for (int i12 = 0; i12 < i10; i12++) {
            j0.d dVar = dVarArr[i12];
            p(inputStream, dVar);
            dVar.f7498h = m(inputStream, dVar.f7495e);
            v(inputStream, dVar);
        }
        return dVarArr;
    }

    public static int y(int i10) {
        return (i10 + 7) & (-8);
    }

    public static void z(byte[] bArr, int i10, int i11, j0.d dVar) {
        int iL = l(i10, i11, dVar.f7497g);
        int i12 = iL / 8;
        bArr[i12] = (byte) ((1 << (iL % 8)) | bArr[i12]);
    }
}
