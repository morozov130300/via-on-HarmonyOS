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

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final zb.a[] f14819a;

    /* renamed from: b, reason: collision with root package name */
    public static final Map f14820b;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final List f14821a;

        /* renamed from: b, reason: collision with root package name */
        public final okio.e f14822b;

        /* renamed from: c, reason: collision with root package name */
        public final int f14823c;

        /* renamed from: d, reason: collision with root package name */
        public int f14824d;

        /* renamed from: e, reason: collision with root package name */
        public zb.a[] f14825e;

        /* renamed from: f, reason: collision with root package name */
        public int f14826f;

        /* renamed from: g, reason: collision with root package name */
        public int f14827g;

        /* renamed from: h, reason: collision with root package name */
        public int f14828h;

        public a(int i10, int i11, q qVar) {
            this.f14821a = new ArrayList();
            this.f14825e = new zb.a[8];
            this.f14826f = r0.length - 1;
            this.f14827g = 0;
            this.f14828h = 0;
            this.f14823c = i10;
            this.f14824d = i11;
            this.f14822b = okio.k.b(qVar);
        }

        public a(int i10, q qVar) {
            this(i10, i10, qVar);
        }

        public final void a() {
            int i10 = this.f14824d;
            int i11 = this.f14828h;
            if (i10 < i11) {
                if (i10 == 0) {
                    b();
                } else {
                    d(i11 - i10);
                }
            }
        }

        public final void b() {
            Arrays.fill(this.f14825e, (Object) null);
            this.f14826f = this.f14825e.length - 1;
            this.f14827g = 0;
            this.f14828h = 0;
        }

        public final int c(int i10) {
            return this.f14826f + 1 + i10;
        }

        public final int d(int i10) {
            int i11;
            int i12 = 0;
            if (i10 > 0) {
                int length = this.f14825e.length;
                while (true) {
                    length--;
                    i11 = this.f14826f;
                    if (length < i11 || i10 <= 0) {
                        break;
                    }
                    int i13 = this.f14825e[length].f14818c;
                    i10 -= i13;
                    this.f14828h -= i13;
                    this.f14827g--;
                    i12++;
                }
                zb.a[] aVarArr = this.f14825e;
                System.arraycopy(aVarArr, i11 + 1, aVarArr, i11 + 1 + i12, this.f14827g);
                this.f14826f += i12;
            }
            return i12;
        }

        public List e() {
            ArrayList arrayList = new ArrayList(this.f14821a);
            this.f14821a.clear();
            return arrayList;
        }

        public final ByteString f(int i10) throws IOException {
            if (h(i10)) {
                return b.f14819a[i10].f14816a;
            }
            int iC = c(i10 - b.f14819a.length);
            if (iC >= 0) {
                zb.a[] aVarArr = this.f14825e;
                if (iC < aVarArr.length) {
                    return aVarArr[iC].f14816a;
                }
            }
            throw new IOException("Header index too large " + (i10 + 1));
        }

        public final void g(int i10, zb.a aVar) {
            this.f14821a.add(aVar);
            int i11 = aVar.f14818c;
            if (i10 != -1) {
                i11 -= this.f14825e[c(i10)].f14818c;
            }
            int i12 = this.f14824d;
            if (i11 > i12) {
                b();
                return;
            }
            int iD = d((this.f14828h + i11) - i12);
            if (i10 == -1) {
                int i13 = this.f14827g + 1;
                zb.a[] aVarArr = this.f14825e;
                if (i13 > aVarArr.length) {
                    zb.a[] aVarArr2 = new zb.a[aVarArr.length * 2];
                    System.arraycopy(aVarArr, 0, aVarArr2, aVarArr.length, aVarArr.length);
                    this.f14826f = this.f14825e.length - 1;
                    this.f14825e = aVarArr2;
                }
                int i14 = this.f14826f;
                this.f14826f = i14 - 1;
                this.f14825e[i14] = aVar;
                this.f14827g++;
            } else {
                this.f14825e[i10 + c(i10) + iD] = aVar;
            }
            this.f14828h += i11;
        }

        public final boolean h(int i10) {
            return i10 >= 0 && i10 <= b.f14819a.length - 1;
        }

        public final int i() {
            return this.f14822b.readByte() & 255;
        }

        public ByteString j() {
            int i10 = i();
            boolean z10 = (i10 & 128) == 128;
            int iM = m(i10, 127);
            return z10 ? ByteString.of(i.f().c(this.f14822b.P(iM))) : this.f14822b.A(iM);
        }

        public void k() throws IOException {
            while (!this.f14822b.C()) {
                byte b10 = this.f14822b.readByte();
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
                    this.f14824d = iM;
                    if (iM < 0 || iM > this.f14823c) {
                        throw new IOException("Invalid dynamic table size update " + this.f14824d);
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
                this.f14821a.add(b.f14819a[i10]);
                return;
            }
            int iC = c(i10 - b.f14819a.length);
            if (iC >= 0) {
                zb.a[] aVarArr = this.f14825e;
                if (iC < aVarArr.length) {
                    this.f14821a.add(aVarArr[iC]);
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
            this.f14821a.add(new zb.a(f(i10), j()));
        }

        public final void q() throws IOException {
            this.f14821a.add(new zb.a(b.a(j()), j()));
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    /* renamed from: zb.b$b, reason: collision with other inner class name */
    public static final class C0162b {

        /* renamed from: a, reason: collision with root package name */
        public final okio.c f14829a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f14830b;

        /* renamed from: c, reason: collision with root package name */
        public int f14831c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f14832d;

        /* renamed from: e, reason: collision with root package name */
        public int f14833e;

        /* renamed from: f, reason: collision with root package name */
        public int f14834f;

        /* renamed from: g, reason: collision with root package name */
        public zb.a[] f14835g;

        /* renamed from: h, reason: collision with root package name */
        public int f14836h;

        /* renamed from: i, reason: collision with root package name */
        public int f14837i;

        /* renamed from: j, reason: collision with root package name */
        public int f14838j;

        public C0162b(int i10, boolean z10, okio.c cVar) {
            this.f14831c = Integer.MAX_VALUE;
            this.f14835g = new zb.a[8];
            this.f14836h = r0.length - 1;
            this.f14837i = 0;
            this.f14838j = 0;
            this.f14833e = i10;
            this.f14834f = i10;
            this.f14830b = z10;
            this.f14829a = cVar;
        }

        public C0162b(okio.c cVar) {
            this(4096, true, cVar);
        }

        public final void a() {
            int i10 = this.f14834f;
            int i11 = this.f14838j;
            if (i10 < i11) {
                if (i10 == 0) {
                    b();
                } else {
                    c(i11 - i10);
                }
            }
        }

        public final void b() {
            Arrays.fill(this.f14835g, (Object) null);
            this.f14836h = this.f14835g.length - 1;
            this.f14837i = 0;
            this.f14838j = 0;
        }

        public final int c(int i10) {
            int i11;
            int i12 = 0;
            if (i10 > 0) {
                int length = this.f14835g.length;
                while (true) {
                    length--;
                    i11 = this.f14836h;
                    if (length < i11 || i10 <= 0) {
                        break;
                    }
                    int i13 = this.f14835g[length].f14818c;
                    i10 -= i13;
                    this.f14838j -= i13;
                    this.f14837i--;
                    i12++;
                }
                zb.a[] aVarArr = this.f14835g;
                System.arraycopy(aVarArr, i11 + 1, aVarArr, i11 + 1 + i12, this.f14837i);
                zb.a[] aVarArr2 = this.f14835g;
                int i14 = this.f14836h;
                Arrays.fill(aVarArr2, i14 + 1, i14 + 1 + i12, (Object) null);
                this.f14836h += i12;
            }
            return i12;
        }

        public final void d(zb.a aVar) {
            int i10 = aVar.f14818c;
            int i11 = this.f14834f;
            if (i10 > i11) {
                b();
                return;
            }
            c((this.f14838j + i10) - i11);
            int i12 = this.f14837i + 1;
            zb.a[] aVarArr = this.f14835g;
            if (i12 > aVarArr.length) {
                zb.a[] aVarArr2 = new zb.a[aVarArr.length * 2];
                System.arraycopy(aVarArr, 0, aVarArr2, aVarArr.length, aVarArr.length);
                this.f14836h = this.f14835g.length - 1;
                this.f14835g = aVarArr2;
            }
            int i13 = this.f14836h;
            this.f14836h = i13 - 1;
            this.f14835g[i13] = aVar;
            this.f14837i++;
            this.f14838j += i10;
        }

        public void e(int i10) {
            this.f14833e = i10;
            int iMin = Math.min(i10, 16384);
            int i11 = this.f14834f;
            if (i11 == iMin) {
                return;
            }
            if (iMin < i11) {
                this.f14831c = Math.min(this.f14831c, iMin);
            }
            this.f14832d = true;
            this.f14834f = iMin;
            a();
        }

        public void f(ByteString byteString) {
            if (!this.f14830b || i.f().e(byteString) >= byteString.size()) {
                h(byteString.size(), 127, 0);
                this.f14829a.w(byteString);
                return;
            }
            okio.c cVar = new okio.c();
            i.f().d(byteString, cVar);
            ByteString byteStringO = cVar.o();
            h(byteStringO.size(), 127, 128);
            this.f14829a.w(byteStringO);
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x0070  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x00a8  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x00b0  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void g(List list) {
            int length;
            int length2;
            if (this.f14832d) {
                int i10 = this.f14831c;
                if (i10 < this.f14834f) {
                    h(i10, 31, 32);
                }
                this.f14832d = false;
                this.f14831c = Integer.MAX_VALUE;
                h(this.f14834f, 31, 32);
            }
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                zb.a aVar = (zb.a) list.get(i11);
                ByteString asciiLowercase = aVar.f14816a.toAsciiLowercase();
                ByteString byteString = aVar.f14817b;
                Integer num = (Integer) b.f14820b.get(asciiLowercase);
                if (num != null) {
                    int iIntValue = num.intValue();
                    length2 = iIntValue + 1;
                    if (length2 > 1 && length2 < 8) {
                        zb.a[] aVarArr = b.f14819a;
                        if (ub.c.q(aVarArr[iIntValue].f14817b, byteString)) {
                            length = length2;
                        } else if (ub.c.q(aVarArr[length2].f14817b, byteString)) {
                            length2 = iIntValue + 2;
                            length = length2;
                        }
                        if (length2 == -1) {
                            int i12 = this.f14836h + 1;
                            int length3 = this.f14835g.length;
                            while (true) {
                                if (i12 >= length3) {
                                    break;
                                }
                                if (ub.c.q(this.f14835g[i12].f14816a, asciiLowercase)) {
                                    if (ub.c.q(this.f14835g[i12].f14817b, byteString)) {
                                        length2 = (i12 - this.f14836h) + b.f14819a.length;
                                        break;
                                    } else if (length == -1) {
                                        length = (i12 - this.f14836h) + b.f14819a.length;
                                    }
                                }
                                i12++;
                            }
                        }
                        if (length2 == -1) {
                            h(length2, 127, 128);
                        } else if (length == -1) {
                            this.f14829a.writeByte(64);
                            f(asciiLowercase);
                            f(byteString);
                            d(aVar);
                        } else if (!asciiLowercase.startsWith(zb.a.f14810d) || zb.a.f14815i.equals(asciiLowercase)) {
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
                }
                if (length2 == -1) {
                }
            }
        }

        public void h(int i10, int i11, int i12) {
            if (i10 < i11) {
                this.f14829a.writeByte(i10 | i12);
                return;
            }
            this.f14829a.writeByte(i12 | i11);
            int i13 = i10 - i11;
            while (i13 >= 128) {
                this.f14829a.writeByte(128 | (i13 & 127));
                i13 >>>= 7;
            }
            this.f14829a.writeByte(i13);
        }
    }

    static {
        zb.a aVar = new zb.a(zb.a.f14815i, "");
        ByteString byteString = zb.a.f14812f;
        zb.a aVar2 = new zb.a(byteString, "GET");
        zb.a aVar3 = new zb.a(byteString, "POST");
        ByteString byteString2 = zb.a.f14813g;
        zb.a aVar4 = new zb.a(byteString2, "/");
        zb.a aVar5 = new zb.a(byteString2, "/index.html");
        ByteString byteString3 = zb.a.f14814h;
        zb.a aVar6 = new zb.a(byteString3, "http");
        zb.a aVar7 = new zb.a(byteString3, "https");
        ByteString byteString4 = zb.a.f14811e;
        f14819a = new zb.a[]{aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, new zb.a(byteString4, "200"), new zb.a(byteString4, "204"), new zb.a(byteString4, "206"), new zb.a(byteString4, "304"), new zb.a(byteString4, "400"), new zb.a(byteString4, "404"), new zb.a(byteString4, "500"), new zb.a("accept-charset", ""), new zb.a("accept-encoding", "gzip, deflate"), new zb.a("accept-language", ""), new zb.a("accept-ranges", ""), new zb.a("accept", ""), new zb.a("access-control-allow-origin", ""), new zb.a("age", ""), new zb.a("allow", ""), new zb.a("authorization", ""), new zb.a("cache-control", ""), new zb.a("content-disposition", ""), new zb.a("content-encoding", ""), new zb.a("content-language", ""), new zb.a("content-length", ""), new zb.a("content-location", ""), new zb.a("content-range", ""), new zb.a("content-type", ""), new zb.a("cookie", ""), new zb.a("date", ""), new zb.a("etag", ""), new zb.a("expect", ""), new zb.a("expires", ""), new zb.a("from", ""), new zb.a("host", ""), new zb.a("if-match", ""), new zb.a("if-modified-since", ""), new zb.a("if-none-match", ""), new zb.a("if-range", ""), new zb.a("if-unmodified-since", ""), new zb.a("last-modified", ""), new zb.a("link", ""), new zb.a("location", ""), new zb.a("max-forwards", ""), new zb.a("proxy-authenticate", ""), new zb.a("proxy-authorization", ""), new zb.a("range", ""), new zb.a("referer", ""), new zb.a("refresh", ""), new zb.a("retry-after", ""), new zb.a("server", ""), new zb.a("set-cookie", ""), new zb.a("strict-transport-security", ""), new zb.a("transfer-encoding", ""), new zb.a("user-agent", ""), new zb.a("vary", ""), new zb.a("via", ""), new zb.a("www-authenticate", "")};
        f14820b = b();
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
        LinkedHashMap linkedHashMap = new LinkedHashMap(f14819a.length);
        int i10 = 0;
        while (true) {
            zb.a[] aVarArr = f14819a;
            if (i10 >= aVarArr.length) {
                return Collections.unmodifiableMap(linkedHashMap);
            }
            if (!linkedHashMap.containsKey(aVarArr[i10].f14816a)) {
                linkedHashMap.put(aVarArr[i10].f14816a, Integer.valueOf(i10));
            }
            i10++;
        }
    }
}
