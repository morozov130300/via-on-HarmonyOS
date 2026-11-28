package com.tuyafeng.wormhole;

import c6.r;
import c6.u;
import c6.y0;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.internal.h;
import kotlin.text.a;
import kotlin.text.b0;
import kotlin.text.c;
import kotlin.text.t;
import kotlin.text.w;
import kotlin.text.x;
import kotlin.text.z;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidBookmarkHtml {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AndroidBookmarkHtml f3781a = new AndroidBookmarkHtml();

    /* JADX WARN: Code duplicated, block: B:103:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:105:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:107:0x01cc  */
    /* JADX WARN: Code duplicated, block: B:109:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:110:0x01f3  */
    /* JADX WARN: Code duplicated, block: B:112:0x01f7  */
    /* JADX WARN: Code duplicated, block: B:113:0x01fc  */
    /* JADX WARN: Code duplicated, block: B:116:0x0216  */
    /* JADX WARN: Code duplicated, block: B:117:0x0221  */
    /* JADX WARN: Code duplicated, block: B:127:0x0262  */
    /* JADX WARN: Code duplicated, block: B:133:0x0272  */
    /* JADX WARN: Code duplicated, block: B:144:0x0298  */
    /* JADX WARN: Code duplicated, block: B:154:0x02c5  */
    /* JADX WARN: Code duplicated, block: B:157:0x02cf  */
    /* JADX WARN: Code duplicated, block: B:165:0x02e3 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:166:0x02e4  */
    /* JADX WARN: Code duplicated, block: B:16:0x0071  */
    /* JADX WARN: Multi-variable type inference failed */
    public final List a(InputStream input) throws IOException {
        BufferedReader bufferedReader;
        String str;
        CharSequence charSequenceSubSequence;
        String str2;
        String str3;
        long jA;
        String str4;
        Long lM;
        Long lM2;
        String strZ;
        String strSubstring;
        boolean zA;
        String strE;
        u.a aVar;
        String str5;
        int iB;
        Character chB0;
        h.f(input, "input");
        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(input, c.f7329b), 8192);
        u uVar = u.f2105a;
        ArrayList arrayList = new ArrayList();
        e7.h hVar = new e7.h();
        String str6 = "";
        boolean z10 = false;
        int i10 = 2;
        ArrayList arrayList2 = null;
        Object[] objArr = 0;
        hVar.addLast(new u.a(str6, 0 == true ? 1 : 0, i10, 0 == true ? 1 : 0));
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        int i11 = bufferedReader2.read();
        String str7 = "";
        String string = null;
        int i12 = 0;
        int i13 = 0;
        long j10 = 0;
        long jLongValue = 0;
        while (i11 >= 0) {
            if (i11 != 60) {
                if (str7.length() > 0) {
                    sb2.append((char) i11);
                }
                i11 = bufferedReader2.read();
            } else {
                i11 = bufferedReader2.read();
                if (i11 >= 0) {
                    char c10 = (char) i11;
                    if (Character.isLetter(c10) || z.H("/!?", c10, z10, i10, null)) {
                        t.j(sb3);
                        boolean z11 = false;
                        char c11 = 0;
                        while (true) {
                            if (i11 < 0) {
                                bufferedReader = bufferedReader2;
                                str = str6;
                                break;
                            }
                            char c12 = (char) i11;
                            if (z11) {
                                if (c12 == '>') {
                                    bufferedReader = bufferedReader2;
                                    str = str6;
                                    if (z.M(sb3, "--", false, 2, null)) {
                                        break;
                                    }
                                } else {
                                    bufferedReader = bufferedReader2;
                                    str = str6;
                                }
                                if (c12 == '<' && c11 != 0) {
                                    while (true) {
                                        chB0 = b0.B0(sb3);
                                        if (chB0 == null || !a.d(chB0.charValue())) {
                                            break;
                                        }
                                        h.e(sb3.deleteCharAt(z.N(sb3)), "deleteCharAt(...)");
                                    }
                                }
                                sb3.append(c12);
                                if (sb3.length() == 3 && h.a(sb3.toString(), "!--")) {
                                    z11 = true;
                                }
                                i11 = bufferedReader.read();
                                bufferedReader2 = bufferedReader;
                                str6 = str;
                            } else {
                                bufferedReader = bufferedReader2;
                                str = str6;
                                if (c11 != 0) {
                                    if (c12 == c11) {
                                        sb3.append(c12);
                                        i11 = bufferedReader.read();
                                        if (i11 < 0 || i11 == 62 || a.d((char) i11)) {
                                            c11 = 0;
                                        }
                                    }
                                    bufferedReader2 = bufferedReader;
                                    str6 = str;
                                } else {
                                    if (c12 == '>') {
                                        break;
                                    }
                                    if (c12 == '\"' || c12 == '\'') {
                                        c11 = c12;
                                    }
                                }
                                if (c12 == '<') {
                                    while (true) {
                                        chB0 = b0.B0(sb3);
                                        if (chB0 == null) {
                                            break;
                                        }
                                        break;
                                        break;
                                        h.e(sb3.deleteCharAt(z.N(sb3)), "deleteCharAt(...)");
                                    }
                                }
                                sb3.append(c12);
                                if (sb3.length() == 3) {
                                    z11 = true;
                                }
                                i11 = bufferedReader.read();
                                bufferedReader2 = bufferedReader;
                                str6 = str;
                            }
                        }
                        if (i11 < 0) {
                            if (arrayList2 != null) {
                                return arrayList2;
                            }
                            throw new IOException("Incomplete bookmark HTML");
                        }
                        i11 = bufferedReader.read();
                        int length = sb3.length();
                        int i14 = 0;
                        while (true) {
                            if (i14 >= length) {
                                charSequenceSubSequence = sb3.subSequence(0, sb3.length());
                                break;
                            }
                            if (a.d(sb3.charAt(i14))) {
                                charSequenceSubSequence = sb3.subSequence(0, i14);
                                break;
                            }
                            i14++;
                        }
                        String lowerCase = charSequenceSubSequence.toString().toLowerCase(Locale.ROOT);
                        h.e(lowerCase, "toLowerCase(...)");
                        int iHashCode = lowerCase.hashCode();
                        if (iHashCode != 97) {
                            if (iHashCode != 1554) {
                                if (iHashCode != 3208) {
                                    if (iHashCode != 3275) {
                                        if (iHashCode != 48375) {
                                            if (iHashCode == 48442) {
                                                if (lowerCase.equals("/h3")) {
                                                    if (str7.length() > 0) {
                                                        strSubstring = lowerCase.substring(1);
                                                        h.e(strSubstring, "substring(...)");
                                                        if (h.a(strSubstring, str7)) {
                                                            zA = h.a(str7, "h3");
                                                            strE = y0.e();
                                                            aVar = (u.a) hVar.last();
                                                            String strA = aVar.a();
                                                            String string2 = sb2.toString();
                                                            h.e(string2, "toString(...)");
                                                            String strF = uVar.f(string2);
                                                            if (zA) {
                                                                str5 = null;
                                                            } else {
                                                                str5 = string;
                                                            }
                                                            if (zA) {
                                                                i13++;
                                                                iB = i13;
                                                            } else {
                                                                aVar.c(aVar.b() + 1);
                                                                iB = aVar.b();
                                                            }
                                                            arrayList.add(new r(strE, strA, strF, str5, iB, j10, jLongValue));
                                                            if (zA) {
                                                                hVar.addLast(new u.a(strE, 0, 2, objArr == true ? 1 : 0));
                                                            }
                                                            bufferedReader2 = bufferedReader;
                                                            str6 = str;
                                                            str7 = str6;
                                                        }
                                                    }
                                                }
                                            }
                                        } else if (lowerCase.equals("/dl")) {
                                            if (i12 > 0) {
                                                i12--;
                                            }
                                            if (hVar.size() > 1) {
                                                hVar.removeLast();
                                            }
                                        }
                                    } else if (lowerCase.equals("h3")) {
                                        Map mapE = uVar.e(sb3, lowerCase.length());
                                        str2 = (String) mapE.get("href");
                                        if (str2 != null || (strZ = x.z(str2, "&quot;", "\"", false, 4, null)) == null) {
                                            string = null;
                                        } else {
                                            string = z.v0(strZ).toString();
                                        }
                                        if (h.a(lowerCase, "a") || uVar.g(string)) {
                                            str7 = lowerCase;
                                        } else {
                                            str7 = str;
                                        }
                                        t.j(sb2);
                                        str3 = (String) mapE.get("add_date");
                                        if (str3 != null || (lM2 = w.m(str3)) == null) {
                                            jA = y0.a() / ((long) 1000);
                                        } else {
                                            if (lM2.longValue() == 0) {
                                                lM2 = null;
                                            }
                                            if (lM2 != null) {
                                                jA = lM2.longValue();
                                            } else {
                                                jA = y0.a() / ((long) 1000);
                                            }
                                        }
                                        j10 = jA;
                                        str4 = (String) mapE.get("last_modified");
                                        if (str4 != null || (lM = w.m(str4)) == null) {
                                            jLongValue = j10;
                                        } else {
                                            if (lM.longValue() == 0) {
                                                lM = null;
                                            }
                                            if (lM != null) {
                                                jLongValue = lM.longValue();
                                            } else {
                                                jLongValue = j10;
                                            }
                                        }
                                    }
                                } else if (lowerCase.equals("dl")) {
                                    i12++;
                                }
                            } else if (lowerCase.equals("/a")) {
                                if (str7.length() > 0) {
                                    strSubstring = lowerCase.substring(1);
                                    h.e(strSubstring, "substring(...)");
                                    if (h.a(strSubstring, str7)) {
                                        zA = h.a(str7, "h3");
                                        strE = y0.e();
                                        aVar = (u.a) hVar.last();
                                        String strA2 = aVar.a();
                                        String string3 = sb2.toString();
                                        h.e(string3, "toString(...)");
                                        String strF2 = uVar.f(string3);
                                        if (zA) {
                                            str5 = null;
                                        } else {
                                            str5 = string;
                                        }
                                        if (zA) {
                                            i13++;
                                            iB = i13;
                                        } else {
                                            aVar.c(aVar.b() + 1);
                                            iB = aVar.b();
                                        }
                                        arrayList.add(new r(strE, strA2, strF2, str5, iB, j10, jLongValue));
                                        if (zA) {
                                            hVar.addLast(new u.a(strE, 0, 2, objArr == true ? 1 : 0));
                                        }
                                        bufferedReader2 = bufferedReader;
                                        str6 = str;
                                        str7 = str6;
                                    }
                                }
                            }
                        } else if (lowerCase.equals("a")) {
                            Map mapE2 = uVar.e(sb3, lowerCase.length());
                            str2 = (String) mapE2.get("href");
                            if (str2 != null) {
                                string = null;
                            } else {
                                string = null;
                            }
                            if (h.a(lowerCase, "a")) {
                                str7 = lowerCase;
                            } else {
                                str7 = lowerCase;
                            }
                            t.j(sb2);
                            str3 = (String) mapE2.get("add_date");
                            if (str3 != null) {
                                jA = y0.a() / ((long) 1000);
                            } else {
                                jA = y0.a() / ((long) 1000);
                            }
                            j10 = jA;
                            str4 = (String) mapE2.get("last_modified");
                            if (str4 != null) {
                                jLongValue = j10;
                            } else {
                                jLongValue = j10;
                            }
                        }
                    } else {
                        bufferedReader = bufferedReader2;
                        str = str6;
                        if (str7.length() > 0) {
                            sb2.append('<');
                        }
                    }
                    bufferedReader2 = bufferedReader;
                    str6 = str;
                } else {
                    bufferedReader = bufferedReader2;
                    str = str6;
                    if (str7.length() > 0) {
                        sb2.append('<');
                    }
                    bufferedReader2 = bufferedReader;
                    str6 = str;
                }
                z10 = false;
                i10 = 2;
            }
        }
        if (str7.length() != 0 || i12 != 0) {
            arrayList = null;
        }
        arrayList2 = arrayList;
        if (arrayList2 != null) {
            return arrayList2;
        }
        throw new IOException("Incomplete bookmark HTML");
    }

    public final int b(OutputStream output, List entries) throws IllegalAccessException, IOException, InvocationTargetException {
        h.f(output, "output");
        h.f(entries, "entries");
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(output, c.f7329b), 8192);
        try {
            int iJ = u.f2105a.j(entries, new AndroidBookmarkHtml$write$1$1(bufferedWriter));
            n7.a.a(bufferedWriter, null);
            return iJ;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                n7.a.a(bufferedWriter, th);
                throw th2;
            }
        }
    }
}
