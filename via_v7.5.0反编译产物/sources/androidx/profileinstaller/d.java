package androidx.profileinstaller;

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
import k0.m;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f1008a = {112, 114, 111, 0};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f1009b = {112, 114, 109, 0};

    public static void A(InputStream inputStream) {
        k0.e.h(inputStream);
        int iJ = k0.e.j(inputStream);
        if (iJ == 6 || iJ == 7) {
            return;
        }
        while (iJ > 0) {
            k0.e.j(inputStream);
            for (int iJ2 = k0.e.j(inputStream); iJ2 > 0; iJ2--) {
                k0.e.h(inputStream);
            }
            iJ--;
        }
    }

    public static boolean B(OutputStream outputStream, byte[] bArr, k0.d[] dVarArr) throws IOException {
        if (Arrays.equals(bArr, m.f7140a)) {
            N(outputStream, dVarArr);
            return true;
        }
        if (Arrays.equals(bArr, m.f7141b)) {
            M(outputStream, dVarArr);
            return true;
        }
        if (Arrays.equals(bArr, m.f7143d)) {
            K(outputStream, dVarArr);
            return true;
        }
        if (Arrays.equals(bArr, m.f7142c)) {
            L(outputStream, dVarArr);
            return true;
        }
        if (!Arrays.equals(bArr, m.f7144e)) {
            return false;
        }
        J(outputStream, dVarArr);
        return true;
    }

    public static void C(OutputStream outputStream, k0.d dVar) throws IOException {
        int[] iArr = dVar.f7130h;
        int length = iArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            int i12 = iArr[i10];
            k0.e.p(outputStream, i12 - i11);
            i10++;
            i11 = i12;
        }
    }

    public static f D(k0.d[] dVarArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            k0.e.p(byteArrayOutputStream, dVarArr.length);
            int i10 = 2;
            for (k0.d dVar : dVarArr) {
                k0.e.q(byteArrayOutputStream, dVar.f7125c);
                k0.e.q(byteArrayOutputStream, dVar.f7126d);
                k0.e.q(byteArrayOutputStream, dVar.f7129g);
                String strJ = j(dVar.f7123a, dVar.f7124b, m.f7140a);
                int iK = k0.e.k(strJ);
                k0.e.p(byteArrayOutputStream, iK);
                i10 = i10 + 14 + iK;
                k0.e.n(byteArrayOutputStream, strJ);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (i10 == byteArray.length) {
                f fVar = new f(FileSectionType.DEX_FILES, i10, byteArray, false);
                byteArrayOutputStream.close();
                return fVar;
            }
            throw k0.e.c("Expected size " + i10 + ", does not match actual size " + byteArray.length);
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
        outputStream.write(f1008a);
        outputStream.write(bArr);
    }

    public static void F(OutputStream outputStream, k0.d dVar) throws IOException {
        I(outputStream, dVar);
        C(outputStream, dVar);
        H(outputStream, dVar);
    }

    public static void G(OutputStream outputStream, k0.d dVar, String str) throws IOException {
        k0.e.p(outputStream, k0.e.k(str));
        k0.e.p(outputStream, dVar.f7127e);
        k0.e.q(outputStream, dVar.f7128f);
        k0.e.q(outputStream, dVar.f7125c);
        k0.e.q(outputStream, dVar.f7129g);
        k0.e.n(outputStream, str);
    }

    public static void H(OutputStream outputStream, k0.d dVar) throws IOException {
        byte[] bArr = new byte[k(dVar.f7129g)];
        for (Map.Entry entry : dVar.f7131i.entrySet()) {
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

    public static void I(OutputStream outputStream, k0.d dVar) throws IOException {
        int i10 = 0;
        for (Map.Entry entry : dVar.f7131i.entrySet()) {
            int iIntValue = ((Integer) entry.getKey()).intValue();
            if ((((Integer) entry.getValue()).intValue() & 1) != 0) {
                k0.e.p(outputStream, iIntValue - i10);
                k0.e.p(outputStream, 0);
                i10 = iIntValue;
            }
        }
    }

    public static void J(OutputStream outputStream, k0.d[] dVarArr) throws IOException {
        k0.e.p(outputStream, dVarArr.length);
        for (k0.d dVar : dVarArr) {
            String strJ = j(dVar.f7123a, dVar.f7124b, m.f7144e);
            k0.e.p(outputStream, k0.e.k(strJ));
            k0.e.p(outputStream, dVar.f7131i.size());
            k0.e.p(outputStream, dVar.f7130h.length);
            k0.e.q(outputStream, dVar.f7125c);
            k0.e.n(outputStream, strJ);
            Iterator it = dVar.f7131i.keySet().iterator();
            while (it.hasNext()) {
                k0.e.p(outputStream, ((Integer) it.next()).intValue());
            }
            for (int i10 : dVar.f7130h) {
                k0.e.p(outputStream, i10);
            }
        }
    }

    public static void K(OutputStream outputStream, k0.d[] dVarArr) throws IOException {
        k0.e.r(outputStream, dVarArr.length);
        for (k0.d dVar : dVarArr) {
            int size = dVar.f7131i.size() * 4;
            String strJ = j(dVar.f7123a, dVar.f7124b, m.f7143d);
            k0.e.p(outputStream, k0.e.k(strJ));
            k0.e.p(outputStream, dVar.f7130h.length);
            k0.e.q(outputStream, size);
            k0.e.q(outputStream, dVar.f7125c);
            k0.e.n(outputStream, strJ);
            Iterator it = dVar.f7131i.keySet().iterator();
            while (it.hasNext()) {
                k0.e.p(outputStream, ((Integer) it.next()).intValue());
                k0.e.p(outputStream, 0);
            }
            for (int i10 : dVar.f7130h) {
                k0.e.p(outputStream, i10);
            }
        }
    }

    public static void L(OutputStream outputStream, k0.d[] dVarArr) throws IOException {
        byte[] bArrB = b(dVarArr, m.f7142c);
        k0.e.r(outputStream, dVarArr.length);
        k0.e.m(outputStream, bArrB);
    }

    public static void M(OutputStream outputStream, k0.d[] dVarArr) throws IOException {
        byte[] bArrB = b(dVarArr, m.f7141b);
        k0.e.r(outputStream, dVarArr.length);
        k0.e.m(outputStream, bArrB);
    }

    public static void N(OutputStream outputStream, k0.d[] dVarArr) throws IOException {
        O(outputStream, dVarArr);
    }

    public static void O(OutputStream outputStream, k0.d[] dVarArr) throws IOException {
        int length;
        ArrayList arrayList = new ArrayList(3);
        ArrayList arrayList2 = new ArrayList(3);
        arrayList.add(D(dVarArr));
        arrayList.add(c(dVarArr));
        arrayList.add(d(dVarArr));
        long length2 = ((long) m.f7140a.length) + ((long) f1008a.length) + 4 + ((long) (arrayList.size() * 16));
        k0.e.q(outputStream, arrayList.size());
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            f fVar = (f) arrayList.get(i10);
            k0.e.q(outputStream, fVar.f1020a.getValue());
            k0.e.q(outputStream, length2);
            if (fVar.f1023d) {
                byte[] bArr = fVar.f1022c;
                long length3 = bArr.length;
                byte[] bArrB = k0.e.b(bArr);
                arrayList2.add(bArrB);
                k0.e.q(outputStream, bArrB.length);
                k0.e.q(outputStream, length3);
                length = bArrB.length;
            } else {
                arrayList2.add(fVar.f1022c);
                k0.e.q(outputStream, fVar.f1022c.length);
                k0.e.q(outputStream, 0L);
                length = fVar.f1022c.length;
            }
            length2 += (long) length;
        }
        for (int i11 = 0; i11 < arrayList2.size(); i11++) {
            outputStream.write((byte[]) arrayList2.get(i11));
        }
    }

    public static int a(k0.d dVar) {
        Iterator it = dVar.f7131i.entrySet().iterator();
        int iIntValue = 0;
        while (it.hasNext()) {
            iIntValue |= ((Integer) ((Map.Entry) it.next()).getValue()).intValue();
        }
        return iIntValue;
    }

    public static byte[] b(k0.d[] dVarArr, byte[] bArr) throws IOException {
        int i10 = 0;
        int iK = 0;
        for (k0.d dVar : dVarArr) {
            iK += k0.e.k(j(dVar.f7123a, dVar.f7124b, bArr)) + 16 + (dVar.f7127e * 2) + dVar.f7128f + k(dVar.f7129g);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(iK);
        if (Arrays.equals(bArr, m.f7142c)) {
            int length = dVarArr.length;
            while (i10 < length) {
                k0.d dVar2 = dVarArr[i10];
                G(byteArrayOutputStream, dVar2, j(dVar2.f7123a, dVar2.f7124b, bArr));
                F(byteArrayOutputStream, dVar2);
                i10++;
            }
        } else {
            for (k0.d dVar3 : dVarArr) {
                G(byteArrayOutputStream, dVar3, j(dVar3.f7123a, dVar3.f7124b, bArr));
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
        throw k0.e.c("The bytes saved do not match expectation. actual=" + byteArrayOutputStream.size() + " expected=" + iK);
    }

    public static f c(k0.d[] dVarArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i10 = 0;
        for (int i11 = 0; i11 < dVarArr.length; i11++) {
            try {
                k0.d dVar = dVarArr[i11];
                k0.e.p(byteArrayOutputStream, i11);
                k0.e.p(byteArrayOutputStream, dVar.f7127e);
                i10 = i10 + 4 + (dVar.f7127e * 2);
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
        throw k0.e.c("Expected size " + i10 + ", does not match actual size " + byteArray.length);
    }

    public static f d(k0.d[] dVarArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i10 = 0;
        for (int i11 = 0; i11 < dVarArr.length; i11++) {
            try {
                k0.d dVar = dVarArr[i11];
                int iA = a(dVar);
                byte[] bArrE = e(dVar);
                byte[] bArrF = f(dVar);
                k0.e.p(byteArrayOutputStream, i11);
                int length = bArrE.length + 2 + bArrF.length;
                k0.e.q(byteArrayOutputStream, length);
                k0.e.p(byteArrayOutputStream, iA);
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
        throw k0.e.c("Expected size " + i10 + ", does not match actual size " + byteArray.length);
    }

    public static byte[] e(k0.d dVar) throws IOException {
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

    public static byte[] f(k0.d dVar) throws IOException {
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
        if ("!".equals(str2)) {
            return str.replace(":", "!");
        }
        return ":".equals(str2) ? str.replace("!", ":") : str;
    }

    public static String h(String str) {
        int iIndexOf = str.indexOf("!");
        if (iIndexOf < 0) {
            iIndexOf = str.indexOf(":");
        }
        return iIndexOf > 0 ? str.substring(iIndexOf + 1) : str;
    }

    public static k0.d i(k0.d[] dVarArr, String str) {
        if (dVarArr.length <= 0) {
            return null;
        }
        String strH = h(str);
        for (int i10 = 0; i10 < dVarArr.length; i10++) {
            if (dVarArr[i10].f7124b.equals(strH)) {
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
            throw k0.e.c("HOT methods are not stored in the bitmap");
        }
        if (i10 == 2) {
            return i11;
        }
        if (i10 == 4) {
            return i11 + i12;
        }
        throw k0.e.c("Unexpected flag: " + i10);
    }

    public static int[] m(InputStream inputStream, int i10) {
        int[] iArr = new int[i10];
        int iH = 0;
        for (int i11 = 0; i11 < i10; i11++) {
            iH += k0.e.h(inputStream);
            iArr[i11] = iH;
        }
        return iArr;
    }

    public static int n(BitSet bitSet, int i10, int i11) {
        int i12 = bitSet.get(l(2, i10, i11)) ? 2 : 0;
        return bitSet.get(l(4, i10, i11)) ? i12 | 4 : i12;
    }

    public static byte[] o(InputStream inputStream, byte[] bArr) {
        if (Arrays.equals(bArr, k0.e.d(inputStream, bArr.length))) {
            return k0.e.d(inputStream, m.f7141b.length);
        }
        throw k0.e.c("Invalid magic");
    }

    public static void p(InputStream inputStream, k0.d dVar) {
        int iAvailable = inputStream.available() - dVar.f7128f;
        int iH = 0;
        while (inputStream.available() > iAvailable) {
            iH += k0.e.h(inputStream);
            dVar.f7131i.put(Integer.valueOf(iH), 1);
            for (int iH2 = k0.e.h(inputStream); iH2 > 0; iH2--) {
                A(inputStream);
            }
        }
        if (inputStream.available() != iAvailable) {
            throw k0.e.c("Read too much data during profile line parse");
        }
    }

    public static k0.d[] q(InputStream inputStream, byte[] bArr, byte[] bArr2, k0.d[] dVarArr) {
        if (Arrays.equals(bArr, m.f7145f)) {
            if (Arrays.equals(m.f7140a, bArr2)) {
                throw k0.e.c("Requires new Baseline Profile Metadata. Please rebuild the APK with Android Gradle Plugin 7.2 Canary 7 or higher");
            }
            return r(inputStream, bArr, dVarArr);
        }
        if (Arrays.equals(bArr, m.f7146g)) {
            return t(inputStream, bArr2, dVarArr);
        }
        throw k0.e.c("Unsupported meta version");
    }

    public static k0.d[] r(InputStream inputStream, byte[] bArr, k0.d[] dVarArr) throws IOException {
        if (!Arrays.equals(bArr, m.f7145f)) {
            throw k0.e.c("Unsupported meta version");
        }
        int iJ = k0.e.j(inputStream);
        byte[] bArrE = k0.e.e(inputStream, (int) k0.e.i(inputStream), (int) k0.e.i(inputStream));
        if (inputStream.read() > 0) {
            throw k0.e.c("Content found after the end of file");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrE);
        try {
            k0.d[] dVarArrS = s(byteArrayInputStream, iJ, dVarArr);
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

    public static k0.d[] s(InputStream inputStream, int i10, k0.d[] dVarArr) {
        if (inputStream.available() == 0) {
            return new k0.d[0];
        }
        if (i10 != dVarArr.length) {
            throw k0.e.c("Mismatched number of dex files found in metadata");
        }
        String[] strArr = new String[i10];
        int[] iArr = new int[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            int iH = k0.e.h(inputStream);
            iArr[i11] = k0.e.h(inputStream);
            strArr[i11] = k0.e.f(inputStream, iH);
        }
        for (int i12 = 0; i12 < i10; i12++) {
            k0.d dVar = dVarArr[i12];
            if (!dVar.f7124b.equals(strArr[i12])) {
                throw k0.e.c("Order of dexfiles in metadata did not match baseline");
            }
            int i13 = iArr[i12];
            dVar.f7127e = i13;
            dVar.f7130h = m(inputStream, i13);
        }
        return dVarArr;
    }

    public static k0.d[] t(InputStream inputStream, byte[] bArr, k0.d[] dVarArr) throws IOException {
        int iH = k0.e.h(inputStream);
        byte[] bArrE = k0.e.e(inputStream, (int) k0.e.i(inputStream), (int) k0.e.i(inputStream));
        if (inputStream.read() > 0) {
            throw k0.e.c("Content found after the end of file");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrE);
        try {
            k0.d[] dVarArrU = u(byteArrayInputStream, bArr, iH, dVarArr);
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

    public static k0.d[] u(InputStream inputStream, byte[] bArr, int i10, k0.d[] dVarArr) {
        if (inputStream.available() == 0) {
            return new k0.d[0];
        }
        if (i10 != dVarArr.length) {
            throw k0.e.c("Mismatched number of dex files found in metadata");
        }
        for (int i11 = 0; i11 < i10; i11++) {
            k0.e.h(inputStream);
            String strF = k0.e.f(inputStream, k0.e.h(inputStream));
            long jI = k0.e.i(inputStream);
            int iH = k0.e.h(inputStream);
            k0.d dVarI = i(dVarArr, strF);
            if (dVarI == null) {
                throw k0.e.c("Missing profile key: " + strF);
            }
            dVarI.f7126d = jI;
            int[] iArrM = m(inputStream, iH);
            if (Arrays.equals(bArr, m.f7144e)) {
                dVarI.f7127e = iH;
                dVarI.f7130h = iArrM;
            }
        }
        return dVarArr;
    }

    public static void v(InputStream inputStream, k0.d dVar) {
        BitSet bitSetValueOf = BitSet.valueOf(k0.e.d(inputStream, k0.e.a(dVar.f7129g * 2)));
        int i10 = 0;
        while (true) {
            int i11 = dVar.f7129g;
            if (i10 >= i11) {
                return;
            }
            int iN = n(bitSetValueOf, i10, i11);
            if (iN != 0) {
                Integer num = (Integer) dVar.f7131i.get(Integer.valueOf(i10));
                if (num == null) {
                    num = 0;
                }
                dVar.f7131i.put(Integer.valueOf(i10), Integer.valueOf(iN | num.intValue()));
            }
            i10++;
        }
    }

    public static k0.d[] w(InputStream inputStream, byte[] bArr, String str) throws IOException {
        if (!Arrays.equals(bArr, m.f7141b)) {
            throw k0.e.c("Unsupported version");
        }
        int iJ = k0.e.j(inputStream);
        byte[] bArrE = k0.e.e(inputStream, (int) k0.e.i(inputStream), (int) k0.e.i(inputStream));
        if (inputStream.read() > 0) {
            throw k0.e.c("Content found after the end of file");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrE);
        try {
            k0.d[] dVarArrX = x(byteArrayInputStream, str, iJ);
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

    public static k0.d[] x(InputStream inputStream, String str, int i10) {
        if (inputStream.available() == 0) {
            return new k0.d[0];
        }
        k0.d[] dVarArr = new k0.d[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            int iH = k0.e.h(inputStream);
            int iH2 = k0.e.h(inputStream);
            long jI = k0.e.i(inputStream);
            dVarArr[i11] = new k0.d(str, k0.e.f(inputStream, iH), k0.e.i(inputStream), 0L, iH2, (int) jI, (int) k0.e.i(inputStream), new int[iH2], new TreeMap());
        }
        for (int i12 = 0; i12 < i10; i12++) {
            k0.d dVar = dVarArr[i12];
            p(inputStream, dVar);
            dVar.f7130h = m(inputStream, dVar.f7127e);
            v(inputStream, dVar);
        }
        return dVarArr;
    }

    public static int y(int i10) {
        return (i10 + 7) & (-8);
    }

    public static void z(byte[] bArr, int i10, int i11, k0.d dVar) {
        int iL = l(i10, i11, dVar.f7129g);
        int i12 = iL / 8;
        bArr[i12] = (byte) ((1 << (iL % 8)) | bArr[i12]);
    }
}
