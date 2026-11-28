package zb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import okio.ByteString;
import okio.q;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final zb.a[] f15556a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map f15557b;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f15558a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final okio.e f15559b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f15560c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f15561d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public zb.a[] f15562e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f15563f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f15564g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f15565h;

        public a(int i10, q qVar) {
            this(i10, i10, qVar);
        }

        public final void a() {
            int i10 = this.f15561d;
            int i11 = this.f15565h;
            if (i10 < i11) {
                if (i10 == 0) {
                    b();
                } else {
                    d(i11 - i10);
                }
            }
        }

        public final void b() {
            Arrays.fill(this.f15562e, (Object) null);
            this.f15563f = this.f15562e.length - 1;
            this.f15564g = 0;
            this.f15565h = 0;
        }

        public final int c(int i10) {
            return this.f15563f + 1 + i10;
        }

        public final int d(int i10) {
            int i11;
            int i12 = 0;
            if (i10 > 0) {
                int length = this.f15562e.length;
                while (true) {
                    length--;
                    i11 = this.f15563f;
                    if (length < i11 || i10 <= 0) {
                        break;
                    }
                    int i13 = this.f15562e[length].f15555c;
                    i10 -= i13;
                    this.f15565h -= i13;
                    this.f15564g--;
                    i12++;
                }
                zb.a[] aVarArr = this.f15562e;
                System.arraycopy(aVarArr, i11 + 1, aVarArr, i11 + 1 + i12, this.f15564g);
                this.f15563f += i12;
            }
            return i12;
        }

        public List e() {
            ArrayList arrayList = new ArrayList(this.f15558a);
            this.f15558a.clear();
            return arrayList;
        }

        public final ByteString f(int i10) throws IOException {
            if (h(i10)) {
                return b.f15556a[i10].f15553a;
            }
            int iC = c(i10 - b.f15556a.length);
            if (iC >= 0) {
                zb.a[] aVarArr = this.f15562e;
                if (iC < aVarArr.length) {
                    return aVarArr[iC].f15553a;
                }
            }
            throw new IOException("Header index too large " + (i10 + 1));
        }

        public final void g(int i10, zb.a aVar) {
            this.f15558a.add(aVar);
            int i11 = aVar.f15555c;
            if (i10 != -1) {
                i11 -= this.f15562e[c(i10)].f15555c;
            }
            int i12 = this.f15561d;
            if (i11 > i12) {
                b();
                return;
            }
            int iD = d((this.f15565h + i11) - i12);
            if (i10 == -1) {
                int i13 = this.f15564g + 1;
                zb.a[] aVarArr = this.f15562e;
                if (i13 > aVarArr.length) {
                    zb.a[] aVarArr2 = new zb.a[aVarArr.length * 2];
                    System.arraycopy(aVarArr, 0, aVarArr2, aVarArr.length, aVarArr.length);
                    this.f15563f = this.f15562e.length - 1;
                    this.f15562e = aVarArr2;
                }
                int i14 = this.f15563f;
                this.f15563f = i14 - 1;
                this.f15562e[i14] = aVar;
                this.f15564g++;
            } else {
                this.f15562e[i10 + c(i10) + iD] = aVar;
            }
            this.f15565h += i11;
        }

        public final boolean h(int i10) {
            return i10 >= 0 && i10 <= b.f15556a.length - 1;
        }

        public final int i() {
            return this.f15559b.readByte() & 255;
        }

        public ByteString j() {
            int i10 = i();
            boolean z10 = (i10 & 128) == 128;
            int iM = m(i10, 127);
            return z10 ? ByteString.of(i.f().c(this.f15559b.S(iM))) : this.f15559b.B(iM);
        }

        public void k() throws IOException {
            while (!this.f15559b.C()) {
                byte b10 = this.f15559b.readByte();
                int i10 = b10 & 255;
                if (i10 == 128) {
                    throw new IOException("index == 0");
                }
                if ((b10 & 128) == 128) {
                    l(m(i10, 127) - 1);
                } else if (i10 == 64) {
                    o();
                } else if ((b10 & 64) == 64) {
                    n(m(i10, 63) - 1);
                } else if ((b10 & 32) == 32) {
                    int iM = m(i10, 31);
                    this.f15561d = iM;
                    if (iM < 0 || iM > this.f15560c) {
                        throw new IOException("Invalid dynamic table size update " + this.f15561d);
                    }
                    a();
                } else if (i10 == 16 || i10 == 0) {
                    q();
                } else {
                    p(m(i10, 15) - 1);
                }
            }
        }

        public final void l(int i10) throws IOException {
            if (h(i10)) {
                this.f15558a.add(b.f15556a[i10]);
                return;
            }
            int iC = c(i10 - b.f15556a.length);
            if (iC >= 0) {
                zb.a[] aVarArr = this.f15562e;
                if (iC < aVarArr.length) {
                    this.f15558a.add(aVarArr[iC]);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i10 + 1));
        }

        public int m(int i10, int i11) {
            int i12 = i10 & i11;
            if (i12 < i11) {
                return i12;
            }
            int i13 = 0;
            while (true) {
                int i14 = i();
                if ((i14 & 128) == 0) {
                    return i11 + (i14 << i13);
                }
                i11 += (i14 & 127) << i13;
                i13 += 7;
            }
        }

        public final void n(int i10) {
            g(-1, new zb.a(f(i10), j()));
        }

        public final void o() {
            g(-1, new zb.a(b.a(j()), j()));
        }

        public final void p(int i10) throws IOException {
            this.f15558a.add(new zb.a(f(i10), j()));
        }

        public final void q() throws IOException {
            this.f15558a.add(new zb.a(b.a(j()), j()));
        }

        public a(int i10, int i11, q qVar) {
            this.f15558a = new ArrayList();
            zb.a[] aVarArr = new zb.a[8];
            this.f15562e = aVarArr;
            this.f15563f = aVarArr.length - 1;
            this.f15564g = 0;
            this.f15565h = 0;
            this.f15560c = i10;
            this.f15561d = i11;
            this.f15559b = okio.k.b(qVar);
        }
    }

    /* JADX INFO: renamed from: zb.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class C0167b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final okio.c f15566a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f15567b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f15568c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f15569d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f15570e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f15571f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public zb.a[] f15572g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f15573h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f15574i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f15575j;

        public C0167b(okio.c cVar) {
            this(4096, true, cVar);
        }

        public final void a() {
            int i10 = this.f15571f;
            int i11 = this.f15575j;
            if (i10 < i11) {
                if (i10 == 0) {
                    b();
                } else {
                    c(i11 - i10);
                }
            }
        }

        public final void b() {
            Arrays.fill(this.f15572g, (Object) null);
            this.f15573h = this.f15572g.length - 1;
            this.f15574i = 0;
            this.f15575j = 0;
        }

        public final int c(int i10) {
            int i11;
            int i12 = 0;
            if (i10 > 0) {
                int length = this.f15572g.length;
                while (true) {
                    length--;
                    i11 = this.f15573h;
                    if (length < i11 || i10 <= 0) {
                        break;
                    }
                    int i13 = this.f15572g[length].f15555c;
                    i10 -= i13;
                    this.f15575j -= i13;
                    this.f15574i--;
                    i12++;
                }
                zb.a[] aVarArr = this.f15572g;
                System.arraycopy(aVarArr, i11 + 1, aVarArr, i11 + 1 + i12, this.f15574i);
                zb.a[] aVarArr2 = this.f15572g;
                int i14 = this.f15573h;
                Arrays.fill(aVarArr2, i14 + 1, i14 + 1 + i12, (Object) null);
                this.f15573h += i12;
            }
            return i12;
        }

        public final void d(zb.a aVar) {
            int i10 = aVar.f15555c;
            int i11 = this.f15571f;
            if (i10 > i11) {
                b();
                return;
            }
            c((this.f15575j + i10) - i11);
            int i12 = this.f15574i + 1;
            zb.a[] aVarArr = this.f15572g;
            if (i12 > aVarArr.length) {
                zb.a[] aVarArr2 = new zb.a[aVarArr.length * 2];
                System.arraycopy(aVarArr, 0, aVarArr2, aVarArr.length, aVarArr.length);
                this.f15573h = this.f15572g.length - 1;
                this.f15572g = aVarArr2;
            }
            int i13 = this.f15573h;
            this.f15573h = i13 - 1;
            this.f15572g[i13] = aVar;
            this.f15574i++;
            this.f15575j += i10;
        }

        public void e(int i10) {
            this.f15570e = i10;
            int iMin = Math.min(i10, 16384);
            int i11 = this.f15571f;
            if (i11 == iMin) {
                return;
            }
            if (iMin < i11) {
                this.f15568c = Math.min(this.f15568c, iMin);
            }
            this.f15569d = true;
            this.f15571f = iMin;
            a();
        }

        public void f(ByteString byteString) {
            if (!this.f15567b || i.f().e(byteString) >= byteString.size()) {
                h(byteString.size(), 127, 0);
                this.f15566a.w(byteString);
                return;
            }
            okio.c cVar = new okio.c();
            i.f().d(byteString, cVar);
            ByteString byteStringO = cVar.o();
            h(byteStringO.size(), 127, 128);
            this.f15566a.w(byteStringO);
        }

        /* JADX WARN: Code duplicated, block: B:26:0x0070  */
        /* JADX WARN: Code duplicated, block: B:28:0x0078  */
        /* JADX WARN: Code duplicated, block: B:30:0x0084  */
        /* JADX WARN: Code duplicated, block: B:33:0x0099 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:34:0x009b  */
        /* JADX WARN: Code duplicated, block: B:37:0x00a8  */
        /* JADX WARN: Code duplicated, block: B:38:0x00b0  */
        /* JADX WARN: Code duplicated, block: B:40:0x00b4  */
        /* JADX WARN: Code duplicated, block: B:41:0x00c3  */
        /* JADX WARN: Code duplicated, block: B:46:0x00dc  */
        /* JADX WARN: Code duplicated, block: B:55:0x0090 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:57:0x00a3 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:58:0x00a3 A[SYNTHETIC] */
        public void g(List list) {
            int length;
            int length2;
            int i10;
            int length3;
            if (this.f15569d) {
                int i11 = this.f15568c;
                if (i11 < this.f15571f) {
                    h(i11, 31, 32);
                }
                this.f15569d = false;
                this.f15568c = Integer.MAX_VALUE;
                h(this.f15571f, 31, 32);
            }
            int size = list.size();
            for (int i12 = 0; i12 < size; i12++) {
                zb.a aVar = (zb.a) list.get(i12);
                ByteString asciiLowercase = aVar.f15553a.toAsciiLowercase();
                ByteString byteString = aVar.f15554b;
                Integer num = (Integer) b.f15557b.get(asciiLowercase);
                if (num != null) {
                    int iIntValue = num.intValue();
                    length2 = iIntValue + 1;
                    if (length2 > 1 && length2 < 8) {
                        zb.a[] aVarArr = b.f15556a;
                        if (ub.c.q(aVarArr[iIntValue].f15554b, byteString)) {
                            length = length2;
                        } else if (ub.c.q(aVarArr[length2].f15554b, byteString)) {
                            length2 = iIntValue + 2;
                            length = length2;
                        }
                        if (length2 == -1) {
                            length3 = this.f15572g.length;
                            for (i10 = this.f15573h + 1; i10 < length3; i10++) {
                                if (!ub.c.q(this.f15572g[i10].f15553a, asciiLowercase)) {
                                    if (ub.c.q(this.f15572g[i10].f15554b, byteString)) {
                                        length2 = (i10 - this.f15573h) + b.f15556a.length;
                                        break;
                                    } else if (length == -1) {
                                        length = (i10 - this.f15573h) + b.f15556a.length;
                                    }
                                }
                            }
                        }
                        if (length2 != -1) {
                            h(length2, 127, 128);
                        } else if (length == -1) {
                            this.f15566a.writeByte(64);
                            f(asciiLowercase);
                            f(byteString);
                            d(aVar);
                        } else if (asciiLowercase.startsWith(zb.a.f15547d) || zb.a.f15552i.equals(asciiLowercase)) {
                            h(length, 63, 64);
                            f(byteString);
                            d(aVar);
                        } else {
                            h(length, 15, 0);
                            f(byteString);
                        }
                    }
                    length = length2;
                } else {
                    length = -1;
                }
                length2 = -1;
                if (length2 == -1) {
                    length3 = this.f15572g.length;
                    while (i10 < length3) {
                        if (!ub.c.q(this.f15572g[i10].f15553a, asciiLowercase)) {
                            if (ub.c.q(this.f15572g[i10].f15554b, byteString)) {
                                length2 = (i10 - this.f15573h) + b.f15556a.length;
                                break;
                            } else if (length == -1) {
                                length = (i10 - this.f15573h) + b.f15556a.length;
                            }
                        }
                    }
                }
                if (length2 != -1) {
                    h(length2, 127, 128);
                } else if (length == -1) {
                    this.f15566a.writeByte(64);
                    f(asciiLowercase);
                    f(byteString);
                    d(aVar);
                } else if (asciiLowercase.startsWith(zb.a.f15547d)) {
                    h(length, 63, 64);
                    f(byteString);
                    d(aVar);
                } else {
                    h(length, 63, 64);
                    f(byteString);
                    d(aVar);
                }
            }
        }

        public void h(int i10, int i11, int i12) {
            if (i10 < i11) {
                this.f15566a.writeByte(i10 | i12);
                return;
            }
            this.f15566a.writeByte(i12 | i11);
            int i13 = i10 - i11;
            while (i13 >= 128) {
                this.f15566a.writeByte(128 | (i13 & 127));
                i13 >>>= 7;
            }
            this.f15566a.writeByte(i13);
        }

        public C0167b(int i10, boolean z10, okio.c cVar) {
            this.f15568c = Integer.MAX_VALUE;
            zb.a[] aVarArr = new zb.a[8];
            this.f15572g = aVarArr;
            this.f15573h = aVarArr.length - 1;
            this.f15574i = 0;
            this.f15575j = 0;
            this.f15570e = i10;
            this.f15571f = i10;
            this.f15567b = z10;
            this.f15566a = cVar;
        }
    }

    static {
        zb.a aVar = new zb.a(zb.a.f15552i, "");
        ByteString byteString = zb.a.f15549f;
        zb.a aVar2 = new zb.a(byteString, "GET");
        zb.a aVar3 = new zb.a(byteString, "POST");
        ByteString byteString2 = zb.a.f15550g;
        zb.a aVar4 = new zb.a(byteString2, "/");
        zb.a aVar5 = new zb.a(byteString2, "/index.html");
        ByteString byteString3 = zb.a.f15551h;
        zb.a aVar6 = new zb.a(byteString3, "http");
        zb.a aVar7 = new zb.a(byteString3, "https");
        ByteString byteString4 = zb.a.f15548e;
        f15556a = new zb.a[]{aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, new zb.a(byteString4, "200"), new zb.a(byteString4, "204"), new zb.a(byteString4, "206"), new zb.a(byteString4, "304"), new zb.a(byteString4, "400"), new zb.a(byteString4, "404"), new zb.a(byteString4, "500"), new zb.a("accept-charset", ""), new zb.a("accept-encoding", "gzip, deflate"), new zb.a("accept-language", ""), new zb.a("accept-ranges", ""), new zb.a("accept", ""), new zb.a("access-control-allow-origin", ""), new zb.a("age", ""), new zb.a("allow", ""), new zb.a("authorization", ""), new zb.a("cache-control", ""), new zb.a("content-disposition", ""), new zb.a("content-encoding", ""), new zb.a("content-language", ""), new zb.a("content-length", ""), new zb.a("content-location", ""), new zb.a("content-range", ""), new zb.a("content-type", ""), new zb.a("cookie", ""), new zb.a("date", ""), new zb.a("etag", ""), new zb.a("expect", ""), new zb.a("expires", ""), new zb.a("from", ""), new zb.a("host", ""), new zb.a("if-match", ""), new zb.a("if-modified-since", ""), new zb.a("if-none-match", ""), new zb.a("if-range", ""), new zb.a("if-unmodified-since", ""), new zb.a("last-modified", ""), new zb.a("link", ""), new zb.a("location", ""), new zb.a("max-forwards", ""), new zb.a("proxy-authenticate", ""), new zb.a("proxy-authorization", ""), new zb.a("range", ""), new zb.a("referer", ""), new zb.a("refresh", ""), new zb.a("retry-after", ""), new zb.a("server", ""), new zb.a("set-cookie", ""), new zb.a("strict-transport-security", ""), new zb.a("transfer-encoding", ""), new zb.a("user-agent", ""), new zb.a("vary", ""), new zb.a("via", ""), new zb.a("www-authenticate", "")};
        f15557b = b();
    }

    public static ByteString a(ByteString byteString) throws IOException {
        int size = byteString.size();
        for (int i10 = 0; i10 < size; i10++) {
            byte b10 = byteString.getByte(i10);
            if (b10 >= 65 && b10 <= 90) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + byteString.utf8());
            }
        }
        return byteString;
    }

    public static Map b() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(f15556a.length);
        int i10 = 0;
        while (true) {
            zb.a[] aVarArr = f15556a;
            if (i10 >= aVarArr.length) {
                return Collections.unmodifiableMap(linkedHashMap);
            }
            if (!linkedHashMap.containsKey(aVarArr[i10].f15553a)) {
                linkedHashMap.put(aVarArr[i10].f15553a, Integer.valueOf(i10));
            }
            i10++;
        }
    }
}
