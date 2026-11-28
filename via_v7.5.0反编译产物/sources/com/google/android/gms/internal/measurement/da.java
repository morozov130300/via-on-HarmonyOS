package com.google.android.gms.internal.measurement;

import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class da implements la {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int[] f2746p = new int[0];

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Unsafe f2747q = ab.l();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f2748a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object[] f2749b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f2750c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f2751d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final aa f2752e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f2753f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f2754g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int[] f2755h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f2756i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f2757j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final p9 f2758k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final qa f2759l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final r8 f2760m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final fa f2761n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final v9 f2762o;

    public da(int[] iArr, Object[] objArr, int i10, int i11, aa aaVar, boolean z10, boolean z11, int[] iArr2, int i12, int i13, fa faVar, p9 p9Var, qa qaVar, r8 r8Var, v9 v9Var) {
        this.f2748a = iArr;
        this.f2749b = objArr;
        this.f2750c = i10;
        this.f2751d = i11;
        this.f2754g = z10;
        boolean z12 = false;
        if (r8Var != null && r8Var.c(aaVar)) {
            z12 = true;
        }
        this.f2753f = z12;
        this.f2755h = iArr2;
        this.f2756i = i12;
        this.f2757j = i13;
        this.f2761n = faVar;
        this.f2758k = p9Var;
        this.f2759l = qaVar;
        this.f2760m = r8Var;
        this.f2752e = aaVar;
        this.f2762o = v9Var;
    }

    public static boolean A(Object obj, int i10, la laVar) {
        return laVar.c(ab.k(obj, i10 & 1048575));
    }

    public static boolean B(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof a9) {
            return ((a9) obj).A();
        }
        return true;
    }

    public static boolean D(Object obj, long j10) {
        return ((Boolean) ab.k(obj, j10)).booleanValue();
    }

    public static final void E(int i10, Object obj, gb gbVar) {
        if (obj instanceof String) {
            gbVar.h(i10, (String) obj);
        } else {
            gbVar.A(i10, (zzka) obj);
        }
    }

    public static ra G(Object obj) {
        a9 a9Var = (a9) obj;
        ra raVar = a9Var.zzc;
        if (raVar != ra.c()) {
            return raVar;
        }
        ra raVarF = ra.f();
        a9Var.zzc = raVarF;
        return raVarF;
    }

    /* JADX WARN: Code duplicated, block: B:124:0x0277  */
    /* JADX WARN: Code duplicated, block: B:125:0x027a  */
    /* JADX WARN: Code duplicated, block: B:128:0x0291  */
    /* JADX WARN: Code duplicated, block: B:129:0x0294  */
    /* JADX WARN: Code duplicated, block: B:177:0x038e  */
    public static da H(Class cls, x9 x9Var, fa faVar, p9 p9Var, qa qaVar, r8 r8Var, v9 v9Var) {
        int i10;
        int iCharAt;
        int[] iArr;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        char cCharAt;
        int i17;
        char cCharAt2;
        int i18;
        char cCharAt3;
        int i19;
        char cCharAt4;
        int i20;
        char cCharAt5;
        int i21;
        char cCharAt6;
        int i22;
        char cCharAt7;
        int i23;
        char cCharAt8;
        ka kaVar;
        int i24;
        int i25;
        int iObjectFieldOffset;
        int iObjectFieldOffset2;
        int i26;
        int i27;
        int i28;
        int i29;
        Field fieldO;
        char cCharAt9;
        int i30;
        int i31;
        int i32;
        Object obj;
        Field fieldO2;
        int i33;
        Object obj2;
        Field fieldO3;
        int i34;
        char cCharAt10;
        int i35;
        char cCharAt11;
        int i36;
        char cCharAt12;
        int i37;
        char cCharAt13;
        if (!(x9Var instanceof ka)) {
            n.g.a(x9Var);
            throw null;
        }
        ka kaVar2 = (ka) x9Var;
        int iB = kaVar2.b();
        String strC = kaVar2.c();
        int length = strC.length();
        int i38 = 0;
        int i39 = 55296;
        if (strC.charAt(0) >= 55296) {
            int i40 = 1;
            while (true) {
                i10 = i40 + 1;
                if (strC.charAt(i40) < 55296) {
                    break;
                }
                i40 = i10;
            }
        } else {
            i10 = 1;
        }
        int i41 = i10 + 1;
        int iCharAt2 = strC.charAt(i10);
        if (iCharAt2 >= 55296) {
            int i42 = iCharAt2 & 8191;
            int i43 = 13;
            while (true) {
                i37 = i41 + 1;
                cCharAt13 = strC.charAt(i41);
                if (cCharAt13 < 55296) {
                    break;
                }
                i42 |= (cCharAt13 & 8191) << i43;
                i43 += 13;
                i41 = i37;
            }
            iCharAt2 = i42 | (cCharAt13 << i43);
            i41 = i37;
        }
        if (iCharAt2 == 0) {
            iArr = f2746p;
            i11 = 0;
            i14 = 0;
            iCharAt = 0;
            i13 = 0;
            i15 = 0;
            i12 = 0;
        } else {
            int i44 = i41 + 1;
            int iCharAt3 = strC.charAt(i41);
            if (iCharAt3 >= 55296) {
                int i45 = iCharAt3 & 8191;
                int i46 = 13;
                while (true) {
                    i23 = i44 + 1;
                    cCharAt8 = strC.charAt(i44);
                    if (cCharAt8 < 55296) {
                        break;
                    }
                    i45 |= (cCharAt8 & 8191) << i46;
                    i46 += 13;
                    i44 = i23;
                }
                iCharAt3 = i45 | (cCharAt8 << i46);
                i44 = i23;
            }
            int i47 = i44 + 1;
            int iCharAt4 = strC.charAt(i44);
            if (iCharAt4 >= 55296) {
                int i48 = iCharAt4 & 8191;
                int i49 = 13;
                while (true) {
                    i22 = i47 + 1;
                    cCharAt7 = strC.charAt(i47);
                    if (cCharAt7 < 55296) {
                        break;
                    }
                    i48 |= (cCharAt7 & 8191) << i49;
                    i49 += 13;
                    i47 = i22;
                }
                iCharAt4 = i48 | (cCharAt7 << i49);
                i47 = i22;
            }
            int i50 = i47 + 1;
            int iCharAt5 = strC.charAt(i47);
            if (iCharAt5 >= 55296) {
                int i51 = iCharAt5 & 8191;
                int i52 = 13;
                while (true) {
                    i21 = i50 + 1;
                    cCharAt6 = strC.charAt(i50);
                    if (cCharAt6 < 55296) {
                        break;
                    }
                    i51 |= (cCharAt6 & 8191) << i52;
                    i52 += 13;
                    i50 = i21;
                }
                iCharAt5 = i51 | (cCharAt6 << i52);
                i50 = i21;
            }
            int i53 = i50 + 1;
            int iCharAt6 = strC.charAt(i50);
            if (iCharAt6 >= 55296) {
                int i54 = iCharAt6 & 8191;
                int i55 = 13;
                while (true) {
                    i20 = i53 + 1;
                    cCharAt5 = strC.charAt(i53);
                    if (cCharAt5 < 55296) {
                        break;
                    }
                    i54 |= (cCharAt5 & 8191) << i55;
                    i55 += 13;
                    i53 = i20;
                }
                iCharAt6 = i54 | (cCharAt5 << i55);
                i53 = i20;
            }
            int i56 = i53 + 1;
            iCharAt = strC.charAt(i53);
            if (iCharAt >= 55296) {
                int i57 = iCharAt & 8191;
                int i58 = 13;
                while (true) {
                    i19 = i56 + 1;
                    cCharAt4 = strC.charAt(i56);
                    if (cCharAt4 < 55296) {
                        break;
                    }
                    i57 |= (cCharAt4 & 8191) << i58;
                    i58 += 13;
                    i56 = i19;
                }
                iCharAt = i57 | (cCharAt4 << i58);
                i56 = i19;
            }
            int i59 = i56 + 1;
            int iCharAt7 = strC.charAt(i56);
            if (iCharAt7 >= 55296) {
                int i60 = iCharAt7 & 8191;
                int i61 = 13;
                while (true) {
                    i18 = i59 + 1;
                    cCharAt3 = strC.charAt(i59);
                    if (cCharAt3 < 55296) {
                        break;
                    }
                    i60 |= (cCharAt3 & 8191) << i61;
                    i61 += 13;
                    i59 = i18;
                }
                iCharAt7 = i60 | (cCharAt3 << i61);
                i59 = i18;
            }
            int i62 = i59 + 1;
            int iCharAt8 = strC.charAt(i59);
            if (iCharAt8 >= 55296) {
                int i63 = iCharAt8 & 8191;
                int i64 = 13;
                while (true) {
                    i17 = i62 + 1;
                    cCharAt2 = strC.charAt(i62);
                    if (cCharAt2 < 55296) {
                        break;
                    }
                    i63 |= (cCharAt2 & 8191) << i64;
                    i64 += 13;
                    i62 = i17;
                }
                iCharAt8 = i63 | (cCharAt2 << i64);
                i62 = i17;
            }
            int i65 = i62 + 1;
            int iCharAt9 = strC.charAt(i62);
            if (iCharAt9 >= 55296) {
                int i66 = iCharAt9 & 8191;
                int i67 = i65;
                int i68 = 13;
                while (true) {
                    i16 = i67 + 1;
                    cCharAt = strC.charAt(i67);
                    if (cCharAt < 55296) {
                        break;
                    }
                    i66 |= (cCharAt & 8191) << i68;
                    i68 += 13;
                    i67 = i16;
                }
                iCharAt9 = i66 | (cCharAt << i68);
                i65 = i16;
            }
            int i69 = iCharAt9 + iCharAt7 + iCharAt8;
            int i70 = iCharAt3 + iCharAt3 + iCharAt4;
            int[] iArr2 = new int[i69];
            i38 = iCharAt3;
            iArr = iArr2;
            i11 = iCharAt7;
            i12 = iCharAt9;
            i41 = i65;
            i13 = iCharAt5;
            i14 = i70;
            i15 = iCharAt6;
        }
        Unsafe unsafe = f2747q;
        Object[] objArrD = kaVar2.d();
        Class<?> cls2 = kaVar2.zza().getClass();
        int i71 = i12 + i11;
        int i72 = iCharAt + iCharAt;
        int[] iArr3 = new int[iCharAt * 3];
        Object[] objArr = new Object[i72];
        int i73 = i12;
        int i74 = i71;
        int i75 = 0;
        int i76 = 0;
        while (true) {
            boolean z10 = iB == 2;
            if (i41 >= length) {
                return new da(iArr3, objArr, i13, i15, kaVar2.zza(), z10, false, iArr, i12, i71, faVar, p9Var, qaVar, r8Var, v9Var);
            }
            int i77 = i41 + 1;
            int iCharAt10 = strC.charAt(i41);
            if (iCharAt10 >= i39) {
                int i78 = iCharAt10 & 8191;
                int i79 = i77;
                int i80 = 13;
                while (true) {
                    i36 = i79 + 1;
                    cCharAt12 = strC.charAt(i79);
                    kaVar = kaVar2;
                    if (cCharAt12 < 55296) {
                        break;
                    }
                    i78 |= (cCharAt12 & 8191) << i80;
                    i80 += 13;
                    i79 = i36;
                    kaVar2 = kaVar;
                }
                iCharAt10 = i78 | (cCharAt12 << i80);
                i24 = i36;
            } else {
                kaVar = kaVar2;
                i24 = i77;
            }
            int i81 = i24 + 1;
            int iCharAt11 = strC.charAt(i24);
            int i82 = iB;
            char c10 = 55296;
            if (iCharAt11 >= 55296) {
                int i83 = iCharAt11 & 8191;
                int i84 = 13;
                while (true) {
                    i35 = i81 + 1;
                    cCharAt11 = strC.charAt(i81);
                    if (cCharAt11 < c10) {
                        break;
                    }
                    i83 |= (cCharAt11 & 8191) << i84;
                    i84 += 13;
                    i81 = i35;
                    c10 = 55296;
                }
                iCharAt11 = i83 | (cCharAt11 << i84);
                i81 = i35;
            }
            if ((iCharAt11 & 1024) != 0) {
                iArr[i75] = i76;
                i75++;
            }
            int i85 = iCharAt11 & 255;
            int i86 = length;
            if (i85 >= 51) {
                int i87 = i81 + 1;
                int iCharAt12 = strC.charAt(i81);
                char c11 = 55296;
                if (iCharAt12 >= 55296) {
                    int i88 = iCharAt12 & 8191;
                    int i89 = i87;
                    int i90 = 13;
                    while (true) {
                        i34 = i89 + 1;
                        cCharAt10 = strC.charAt(i89);
                        if (cCharAt10 < c11) {
                            break;
                        }
                        i88 |= (cCharAt10 & 8191) << i90;
                        i90 += 13;
                        i89 = i34;
                        c11 = 55296;
                    }
                    iCharAt12 = i88 | (cCharAt10 << i90);
                    i30 = i34;
                } else {
                    i30 = i87;
                }
                int i91 = i30;
                int i92 = i85 - 51;
                i25 = i38;
                if (i92 == 9 || i92 == 17) {
                    int i93 = i76 / 3;
                    i31 = i14 + 1;
                    objArr[i93 + i93 + 1] = objArrD[i14];
                } else {
                    if (i92 == 12 && !z10) {
                        int i94 = i76 / 3;
                        i31 = i14 + 1;
                        objArr[i94 + i94 + 1] = objArrD[i14];
                    }
                    i32 = iCharAt12 + iCharAt12;
                    obj = objArrD[i32];
                    if (obj instanceof Field) {
                        fieldO2 = (Field) obj;
                    } else {
                        fieldO2 = o(cls2, (String) obj);
                        objArrD[i32] = fieldO2;
                    }
                    int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldO2);
                    i33 = i32 + 1;
                    obj2 = objArrD[i33];
                    if (obj2 instanceof Field) {
                        fieldO3 = (Field) obj2;
                    } else {
                        fieldO3 = o(cls2, (String) obj2);
                        objArrD[i33] = fieldO3;
                    }
                    iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldO3);
                    i28 = iObjectFieldOffset3;
                    strC = strC;
                    i81 = i91;
                    i27 = 0;
                }
                i14 = i31;
                i32 = iCharAt12 + iCharAt12;
                obj = objArrD[i32];
                if (obj instanceof Field) {
                    fieldO2 = (Field) obj;
                } else {
                    fieldO2 = o(cls2, (String) obj);
                    objArrD[i32] = fieldO2;
                }
                int iObjectFieldOffset4 = (int) unsafe.objectFieldOffset(fieldO2);
                i33 = i32 + 1;
                obj2 = objArrD[i33];
                if (obj2 instanceof Field) {
                    fieldO3 = (Field) obj2;
                } else {
                    fieldO3 = o(cls2, (String) obj2);
                    objArrD[i33] = fieldO3;
                }
                iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldO3);
                i28 = iObjectFieldOffset4;
                strC = strC;
                i81 = i91;
                i27 = 0;
            } else {
                i25 = i38;
                int i95 = i14 + 1;
                Field fieldO4 = o(cls2, (String) objArrD[i14]);
                if (i85 == 9 || i85 == 17) {
                    int i96 = i76 / 3;
                    objArr[i96 + i96 + 1] = fieldO4.getType();
                } else {
                    if (i85 == 27 || i85 == 49) {
                        int i97 = i76 / 3;
                        i14 += 2;
                        objArr[i97 + i97 + 1] = objArrD[i95];
                    } else if (i85 == 12 || i85 == 30 || i85 == 44) {
                        if (!z10) {
                            int i98 = i76 / 3;
                            i14 += 2;
                            objArr[i98 + i98 + 1] = objArrD[i95];
                        }
                    } else if (i85 == 50) {
                        int i99 = i73 + 1;
                        iArr[i73] = i76;
                        int i100 = i76 / 3;
                        int i101 = i14 + 2;
                        int i102 = i100 + i100;
                        objArr[i102] = objArrD[i95];
                        if ((iCharAt11 & 2048) != 0) {
                            objArr[i102 + 1] = objArrD[i101];
                            i14 += 3;
                        } else {
                            i14 = i101;
                        }
                        i73 = i99;
                    }
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldO4);
                    iObjectFieldOffset2 = 1048575;
                    if ((iCharAt11 & 4096) == 4096 || i85 > 17) {
                        i26 = 0;
                    } else {
                        int i103 = i81 + 1;
                        int iCharAt13 = strC.charAt(i81);
                        if (iCharAt13 >= 55296) {
                            int i104 = iCharAt13 & 8191;
                            int i105 = 13;
                            while (true) {
                                i29 = i103 + 1;
                                cCharAt9 = strC.charAt(i103);
                                if (cCharAt9 < 55296) {
                                    break;
                                }
                                i104 |= (cCharAt9 & 8191) << i105;
                                i105 += 13;
                                i103 = i29;
                            }
                            iCharAt13 = i104 | (cCharAt9 << i105);
                        } else {
                            i29 = i103;
                        }
                        int i106 = i25 + i25 + (iCharAt13 / 32);
                        Object obj3 = objArrD[i106];
                        if (obj3 instanceof Field) {
                            fieldO = (Field) obj3;
                        } else {
                            fieldO = o(cls2, (String) obj3);
                            objArrD[i106] = fieldO;
                        }
                        i26 = iCharAt13 % 32;
                        iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldO);
                        i81 = i29;
                    }
                    if (i85 >= 18 && i85 <= 49) {
                        iArr[i74] = iObjectFieldOffset;
                        i74++;
                    }
                    i27 = i26;
                    i28 = iObjectFieldOffset;
                }
                i14 = i95;
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldO4);
                iObjectFieldOffset2 = 1048575;
                if ((iCharAt11 & 4096) == 4096) {
                    i26 = 0;
                } else {
                    i26 = 0;
                }
                if (i85 >= 18) {
                    iArr[i74] = iObjectFieldOffset;
                    i74++;
                }
                i27 = i26;
                i28 = iObjectFieldOffset;
            }
            int i107 = i76 + 1;
            iArr3[i76] = iCharAt10;
            int i108 = i76 + 2;
            iArr3[i107] = ((iCharAt11 & 256) != 0 ? 268435456 : 0) | ((iCharAt11 & 512) != 0 ? 536870912 : 0) | (i85 << 20) | i28;
            i76 += 3;
            iArr3[i108] = (i27 << 20) | iObjectFieldOffset2;
            i41 = i81;
            i75 = i75;
            iB = i82;
            length = i86;
            kaVar2 = kaVar;
            strC = strC;
            i38 = i25;
            i39 = 55296;
        }
    }

    public static double I(Object obj, long j10) {
        return ((Double) ab.k(obj, j10)).doubleValue();
    }

    public static float J(Object obj, long j10) {
        return ((Float) ab.k(obj, j10)).floatValue();
    }

    public static int L(Object obj, long j10) {
        return ((Integer) ab.k(obj, j10)).intValue();
    }

    public static int T(int i10) {
        return (i10 >>> 20) & 255;
    }

    public static long V(Object obj, long j10) {
        return ((Long) ab.k(obj, j10)).longValue();
    }

    public static Field o(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    public static void p(Object obj) {
        if (!B(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(obj)));
        }
    }

    public final boolean C(Object obj, int i10, int i11) {
        return ab.h(obj, (long) (R(i11) & 1048575)) == i10;
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 12441. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    public final int F(java.lang.Object r28, byte[] r29, int r30, int r31, int r32, com.google.android.gms.internal.measurement.w7 r33) {
        /*
            Method dump skipped, instruction units count: 1244
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.da.F(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.measurement.w7):int");
    }

    public final int K(Object obj) {
        int i10;
        int iY;
        int iY2;
        int iZ;
        int iY3;
        int iY4;
        int iY5;
        int iY6;
        int iJ;
        int iY7;
        int iZ2;
        int iY8;
        int iY9;
        Unsafe unsafe = f2747q;
        int i11 = 0;
        int i12 = 1048575;
        int i13 = 0;
        for (int i14 = 0; i14 < this.f2748a.length; i14 += 3) {
            int iU = U(i14);
            int[] iArr = this.f2748a;
            int i15 = iArr[i14];
            int iT = T(iU);
            if (iT <= 17) {
                int i16 = iArr[i14 + 2];
                int i17 = i16 & 1048575;
                int i18 = i16 >>> 20;
                if (i17 != i12) {
                    i13 = unsafe.getInt(obj, i17);
                    i12 = i17;
                }
                i10 = 1 << i18;
            } else {
                i10 = 0;
            }
            long j10 = iU & 1048575;
            switch (iT) {
                case 0:
                    if ((i13 & i10) != 0) {
                        iY = m8.y(i15 << 3);
                        iJ = iY + 8;
                        i11 += iJ;
                    }
                    break;
                case 1:
                    if ((i13 & i10) != 0) {
                        iY2 = m8.y(i15 << 3);
                        iJ = iY2 + 4;
                        i11 += iJ;
                    }
                    break;
                case 2:
                    if ((i13 & i10) != 0) {
                        iZ = m8.z(unsafe.getLong(obj, j10));
                        iY3 = m8.y(i15 << 3);
                        i11 += iY3 + iZ;
                    }
                    break;
                case 3:
                    if ((i13 & i10) != 0) {
                        iZ = m8.z(unsafe.getLong(obj, j10));
                        iY3 = m8.y(i15 << 3);
                        i11 += iY3 + iZ;
                    }
                    break;
                case 4:
                    if ((i13 & i10) != 0) {
                        iZ = m8.v(unsafe.getInt(obj, j10));
                        iY3 = m8.y(i15 << 3);
                        i11 += iY3 + iZ;
                    }
                    break;
                case 5:
                    if ((i13 & i10) != 0) {
                        iY = m8.y(i15 << 3);
                        iJ = iY + 8;
                        i11 += iJ;
                    }
                    break;
                case 6:
                    if ((i13 & i10) != 0) {
                        iY2 = m8.y(i15 << 3);
                        iJ = iY2 + 4;
                        i11 += iJ;
                    }
                    break;
                case 7:
                    if ((i13 & i10) != 0) {
                        iY4 = m8.y(i15 << 3);
                        iJ = iY4 + 1;
                        i11 += iJ;
                    }
                    break;
                case 8:
                    if ((i13 & i10) != 0) {
                        Object object = unsafe.getObject(obj, j10);
                        if (object instanceof zzka) {
                            int i19 = i15 << 3;
                            Logger logger = m8.f2919b;
                            int iZzd = ((zzka) object).zzd();
                            iY5 = m8.y(iZzd) + iZzd;
                            iY6 = m8.y(i19);
                            iJ = iY6 + iY5;
                            i11 += iJ;
                        } else {
                            iZ = m8.x((String) object);
                            iY3 = m8.y(i15 << 3);
                            i11 += iY3 + iZ;
                        }
                    }
                    break;
                case 9:
                    if ((i13 & i10) != 0) {
                        iJ = na.J(i15, unsafe.getObject(obj, j10), k(i14));
                        i11 += iJ;
                    }
                    break;
                case 10:
                    if ((i13 & i10) != 0) {
                        zzka zzkaVar = (zzka) unsafe.getObject(obj, j10);
                        int i20 = i15 << 3;
                        Logger logger2 = m8.f2919b;
                        int iZzd2 = zzkaVar.zzd();
                        iY5 = m8.y(iZzd2) + iZzd2;
                        iY6 = m8.y(i20);
                        iJ = iY6 + iY5;
                        i11 += iJ;
                    }
                    break;
                case 11:
                    if ((i13 & i10) != 0) {
                        iZ = m8.y(unsafe.getInt(obj, j10));
                        iY3 = m8.y(i15 << 3);
                        i11 += iY3 + iZ;
                    }
                    break;
                case 12:
                    if ((i13 & i10) != 0) {
                        iZ = m8.v(unsafe.getInt(obj, j10));
                        iY3 = m8.y(i15 << 3);
                        i11 += iY3 + iZ;
                    }
                    break;
                case 13:
                    if ((i13 & i10) != 0) {
                        iY2 = m8.y(i15 << 3);
                        iJ = iY2 + 4;
                        i11 += iJ;
                    }
                    break;
                case 14:
                    if ((i13 & i10) != 0) {
                        iY = m8.y(i15 << 3);
                        iJ = iY + 8;
                        i11 += iJ;
                    }
                    break;
                case 15:
                    if ((i13 & i10) != 0) {
                        int i21 = unsafe.getInt(obj, j10);
                        iY3 = m8.y(i15 << 3);
                        iZ = m8.y((i21 >> 31) ^ (i21 + i21));
                        i11 += iY3 + iZ;
                    }
                    break;
                case 16:
                    if ((i10 & i13) != 0) {
                        long j11 = unsafe.getLong(obj, j10);
                        iY7 = m8.y(i15 << 3);
                        iZ2 = m8.z((j11 >> 63) ^ (j11 + j11));
                        iJ = iY7 + iZ2;
                        i11 += iJ;
                    }
                    break;
                case 17:
                    if ((i13 & i10) != 0) {
                        iJ = m8.u(i15, (aa) unsafe.getObject(obj, j10), k(i14));
                        i11 += iJ;
                    }
                    break;
                case 18:
                    iJ = na.C(i15, (List) unsafe.getObject(obj, j10), false);
                    i11 += iJ;
                    break;
                case 19:
                    iJ = na.A(i15, (List) unsafe.getObject(obj, j10), false);
                    i11 += iJ;
                    break;
                case 20:
                    iJ = na.H(i15, (List) unsafe.getObject(obj, j10), false);
                    i11 += iJ;
                    break;
                case 21:
                    iJ = na.S(i15, (List) unsafe.getObject(obj, j10), false);
                    i11 += iJ;
                    break;
                case 22:
                    iJ = na.F(i15, (List) unsafe.getObject(obj, j10), false);
                    i11 += iJ;
                    break;
                case 23:
                    iJ = na.C(i15, (List) unsafe.getObject(obj, j10), false);
                    i11 += iJ;
                    break;
                case 24:
                    iJ = na.A(i15, (List) unsafe.getObject(obj, j10), false);
                    i11 += iJ;
                    break;
                case 25:
                    iJ = na.w(i15, (List) unsafe.getObject(obj, j10), false);
                    i11 += iJ;
                    break;
                case 26:
                    iJ = na.P(i15, (List) unsafe.getObject(obj, j10));
                    i11 += iJ;
                    break;
                case 27:
                    iJ = na.K(i15, (List) unsafe.getObject(obj, j10), k(i14));
                    i11 += iJ;
                    break;
                case 28:
                    iJ = na.x(i15, (List) unsafe.getObject(obj, j10));
                    i11 += iJ;
                    break;
                case 29:
                    iJ = na.Q(i15, (List) unsafe.getObject(obj, j10), false);
                    i11 += iJ;
                    break;
                case 30:
                    iJ = na.y(i15, (List) unsafe.getObject(obj, j10), false);
                    i11 += iJ;
                    break;
                case 31:
                    iJ = na.A(i15, (List) unsafe.getObject(obj, j10), false);
                    i11 += iJ;
                    break;
                case 32:
                    iJ = na.C(i15, (List) unsafe.getObject(obj, j10), false);
                    i11 += iJ;
                    break;
                case 33:
                    iJ = na.L(i15, (List) unsafe.getObject(obj, j10), false);
                    i11 += iJ;
                    break;
                case 34:
                    iJ = na.N(i15, (List) unsafe.getObject(obj, j10), false);
                    i11 += iJ;
                    break;
                case 35:
                    iZ = na.D((List) unsafe.getObject(obj, j10));
                    if (iZ > 0) {
                        int i22 = i15 << 3;
                        iY8 = m8.y(iZ);
                        iY9 = m8.y(i22);
                        iY3 = iY9 + iY8;
                        i11 += iY3 + iZ;
                    }
                    break;
                case 36:
                    iZ = na.B((List) unsafe.getObject(obj, j10));
                    if (iZ > 0) {
                        int i23 = i15 << 3;
                        iY8 = m8.y(iZ);
                        iY9 = m8.y(i23);
                        iY3 = iY9 + iY8;
                        i11 += iY3 + iZ;
                    }
                    break;
                case 37:
                    iZ = na.I((List) unsafe.getObject(obj, j10));
                    if (iZ > 0) {
                        int i24 = i15 << 3;
                        iY8 = m8.y(iZ);
                        iY9 = m8.y(i24);
                        iY3 = iY9 + iY8;
                        i11 += iY3 + iZ;
                    }
                    break;
                case 38:
                    iZ = na.T((List) unsafe.getObject(obj, j10));
                    if (iZ > 0) {
                        int i25 = i15 << 3;
                        iY8 = m8.y(iZ);
                        iY9 = m8.y(i25);
                        iY3 = iY9 + iY8;
                        i11 += iY3 + iZ;
                    }
                    break;
                case 39:
                    iZ = na.G((List) unsafe.getObject(obj, j10));
                    if (iZ > 0) {
                        int i26 = i15 << 3;
                        iY8 = m8.y(iZ);
                        iY9 = m8.y(i26);
                        iY3 = iY9 + iY8;
                        i11 += iY3 + iZ;
                    }
                    break;
                case 40:
                    iZ = na.D((List) unsafe.getObject(obj, j10));
                    if (iZ > 0) {
                        int i27 = i15 << 3;
                        iY8 = m8.y(iZ);
                        iY9 = m8.y(i27);
                        iY3 = iY9 + iY8;
                        i11 += iY3 + iZ;
                    }
                    break;
                case 41:
                    iZ = na.B((List) unsafe.getObject(obj, j10));
                    if (iZ > 0) {
                        int i28 = i15 << 3;
                        iY8 = m8.y(iZ);
                        iY9 = m8.y(i28);
                        iY3 = iY9 + iY8;
                        i11 += iY3 + iZ;
                    }
                    break;
                case 42:
                    List list = (List) unsafe.getObject(obj, j10);
                    Class cls = na.f2932a;
                    iZ = list.size();
                    if (iZ > 0) {
                        int i29 = i15 << 3;
                        iY8 = m8.y(iZ);
                        iY9 = m8.y(i29);
                        iY3 = iY9 + iY8;
                        i11 += iY3 + iZ;
                    }
                    break;
                case 43:
                    iZ = na.R((List) unsafe.getObject(obj, j10));
                    if (iZ > 0) {
                        int i30 = i15 << 3;
                        iY8 = m8.y(iZ);
                        iY9 = m8.y(i30);
                        iY3 = iY9 + iY8;
                        i11 += iY3 + iZ;
                    }
                    break;
                case 44:
                    iZ = na.z((List) unsafe.getObject(obj, j10));
                    if (iZ > 0) {
                        int i31 = i15 << 3;
                        iY8 = m8.y(iZ);
                        iY9 = m8.y(i31);
                        iY3 = iY9 + iY8;
                        i11 += iY3 + iZ;
                    }
                    break;
                case 45:
                    iZ = na.B((List) unsafe.getObject(obj, j10));
                    if (iZ > 0) {
                        int i32 = i15 << 3;
                        iY8 = m8.y(iZ);
                        iY9 = m8.y(i32);
                        iY3 = iY9 + iY8;
                        i11 += iY3 + iZ;
                    }
                    break;
                case 46:
                    iZ = na.D((List) unsafe.getObject(obj, j10));
                    if (iZ > 0) {
                        int i33 = i15 << 3;
                        iY8 = m8.y(iZ);
                        iY9 = m8.y(i33);
                        iY3 = iY9 + iY8;
                        i11 += iY3 + iZ;
                    }
                    break;
                case 47:
                    iZ = na.M((List) unsafe.getObject(obj, j10));
                    if (iZ > 0) {
                        int i34 = i15 << 3;
                        iY8 = m8.y(iZ);
                        iY9 = m8.y(i34);
                        iY3 = iY9 + iY8;
                        i11 += iY3 + iZ;
                    }
                    break;
                case 48:
                    iZ = na.O((List) unsafe.getObject(obj, j10));
                    if (iZ > 0) {
                        int i35 = i15 << 3;
                        iY8 = m8.y(iZ);
                        iY9 = m8.y(i35);
                        iY3 = iY9 + iY8;
                        i11 += iY3 + iZ;
                    }
                    break;
                case 49:
                    iJ = na.E(i15, (List) unsafe.getObject(obj, j10), k(i14));
                    i11 += iJ;
                    break;
                case 50:
                    v9.a(i15, unsafe.getObject(obj, j10), l(i14));
                    break;
                case 51:
                    if (C(obj, i15, i14)) {
                        iY = m8.y(i15 << 3);
                        iJ = iY + 8;
                        i11 += iJ;
                    }
                    break;
                case 52:
                    if (C(obj, i15, i14)) {
                        iY2 = m8.y(i15 << 3);
                        iJ = iY2 + 4;
                        i11 += iJ;
                    }
                    break;
                case 53:
                    if (C(obj, i15, i14)) {
                        iZ = m8.z(V(obj, j10));
                        iY3 = m8.y(i15 << 3);
                        i11 += iY3 + iZ;
                    }
                    break;
                case 54:
                    if (C(obj, i15, i14)) {
                        iZ = m8.z(V(obj, j10));
                        iY3 = m8.y(i15 << 3);
                        i11 += iY3 + iZ;
                    }
                    break;
                case 55:
                    if (C(obj, i15, i14)) {
                        iZ = m8.v(L(obj, j10));
                        iY3 = m8.y(i15 << 3);
                        i11 += iY3 + iZ;
                    }
                    break;
                case 56:
                    if (C(obj, i15, i14)) {
                        iY = m8.y(i15 << 3);
                        iJ = iY + 8;
                        i11 += iJ;
                    }
                    break;
                case 57:
                    if (C(obj, i15, i14)) {
                        iY2 = m8.y(i15 << 3);
                        iJ = iY2 + 4;
                        i11 += iJ;
                    }
                    break;
                case 58:
                    if (C(obj, i15, i14)) {
                        iY4 = m8.y(i15 << 3);
                        iJ = iY4 + 1;
                        i11 += iJ;
                    }
                    break;
                case 59:
                    if (C(obj, i15, i14)) {
                        Object object2 = unsafe.getObject(obj, j10);
                        if (object2 instanceof zzka) {
                            int i36 = i15 << 3;
                            Logger logger3 = m8.f2919b;
                            int iZzd3 = ((zzka) object2).zzd();
                            iY5 = m8.y(iZzd3) + iZzd3;
                            iY6 = m8.y(i36);
                            iJ = iY6 + iY5;
                            i11 += iJ;
                        } else {
                            iZ = m8.x((String) object2);
                            iY3 = m8.y(i15 << 3);
                            i11 += iY3 + iZ;
                        }
                    }
                    break;
                case 60:
                    if (C(obj, i15, i14)) {
                        iJ = na.J(i15, unsafe.getObject(obj, j10), k(i14));
                        i11 += iJ;
                    }
                    break;
                case 61:
                    if (C(obj, i15, i14)) {
                        zzka zzkaVar2 = (zzka) unsafe.getObject(obj, j10);
                        int i37 = i15 << 3;
                        Logger logger4 = m8.f2919b;
                        int iZzd4 = zzkaVar2.zzd();
                        iY5 = m8.y(iZzd4) + iZzd4;
                        iY6 = m8.y(i37);
                        iJ = iY6 + iY5;
                        i11 += iJ;
                    }
                    break;
                case 62:
                    if (C(obj, i15, i14)) {
                        iZ = m8.y(L(obj, j10));
                        iY3 = m8.y(i15 << 3);
                        i11 += iY3 + iZ;
                    }
                    break;
                case 63:
                    if (C(obj, i15, i14)) {
                        iZ = m8.v(L(obj, j10));
                        iY3 = m8.y(i15 << 3);
                        i11 += iY3 + iZ;
                    }
                    break;
                case 64:
                    if (C(obj, i15, i14)) {
                        iY2 = m8.y(i15 << 3);
                        iJ = iY2 + 4;
                        i11 += iJ;
                    }
                    break;
                case 65:
                    if (C(obj, i15, i14)) {
                        iY = m8.y(i15 << 3);
                        iJ = iY + 8;
                        i11 += iJ;
                    }
                    break;
                case 66:
                    if (C(obj, i15, i14)) {
                        int iL = L(obj, j10);
                        iY3 = m8.y(i15 << 3);
                        iZ = m8.y((iL >> 31) ^ (iL + iL));
                        i11 += iY3 + iZ;
                    }
                    break;
                case 67:
                    if (C(obj, i15, i14)) {
                        long jV = V(obj, j10);
                        iY7 = m8.y(i15 << 3);
                        iZ2 = m8.z((jV >> 63) ^ (jV + jV));
                        iJ = iY7 + iZ2;
                        i11 += iJ;
                    }
                    break;
                case 68:
                    if (C(obj, i15, i14)) {
                        iJ = m8.u(i15, (aa) unsafe.getObject(obj, j10), k(i14));
                        i11 += iJ;
                    }
                    break;
            }
        }
        qa qaVar = this.f2759l;
        int iA = i11 + qaVar.a(qaVar.d(obj));
        if (!this.f2753f) {
            return iA;
        }
        this.f2760m.a(obj);
        throw null;
    }

    public final int M(Object obj, byte[] bArr, int i10, int i11, int i12, long j10, w7 w7Var) {
        Unsafe unsafe = f2747q;
        Object objL = l(i12);
        Object object = unsafe.getObject(obj, j10);
        if (!((zzmc) object).zze()) {
            zzmc zzmcVarZzb = zzmc.zza().zzb();
            v9.b(zzmcVarZzb, object);
            unsafe.putObject(obj, j10, zzmcVarZzb);
        }
        n.g.a(objL);
        throw null;
    }

    public final int N(Object obj, byte[] bArr, int i10, int i11, int i12, int i13, int i14, int i15, int i16, long j10, int i17, w7 w7Var) throws zzll {
        Unsafe unsafe = f2747q;
        long j11 = this.f2748a[i17 + 2] & 1048575;
        switch (i16) {
            case 51:
                if (i14 != 1) {
                    return i10;
                }
                unsafe.putObject(obj, j10, Double.valueOf(Double.longBitsToDouble(x7.p(bArr, i10))));
                int i18 = i10 + 8;
                unsafe.putInt(obj, j11, i13);
                return i18;
            case 52:
                if (i14 != 5) {
                    return i10;
                }
                unsafe.putObject(obj, j10, Float.valueOf(Float.intBitsToFloat(x7.b(bArr, i10))));
                int i19 = i10 + 4;
                unsafe.putInt(obj, j11, i13);
                return i19;
            case 53:
            case 54:
                if (i14 != 0) {
                    return i10;
                }
                int iM = x7.m(bArr, i10, w7Var);
                unsafe.putObject(obj, j10, Long.valueOf(w7Var.f3164b));
                unsafe.putInt(obj, j11, i13);
                return iM;
            case 55:
            case 62:
                if (i14 != 0) {
                    return i10;
                }
                int iJ = x7.j(bArr, i10, w7Var);
                unsafe.putObject(obj, j10, Integer.valueOf(w7Var.f3163a));
                unsafe.putInt(obj, j11, i13);
                return iJ;
            case 56:
            case 65:
                if (i14 != 1) {
                    return i10;
                }
                unsafe.putObject(obj, j10, Long.valueOf(x7.p(bArr, i10)));
                int i20 = i10 + 8;
                unsafe.putInt(obj, j11, i13);
                return i20;
            case 57:
            case 64:
                if (i14 != 5) {
                    return i10;
                }
                unsafe.putObject(obj, j10, Integer.valueOf(x7.b(bArr, i10)));
                int i21 = i10 + 4;
                unsafe.putInt(obj, j11, i13);
                return i21;
            case 58:
                if (i14 != 0) {
                    return i10;
                }
                int iM2 = x7.m(bArr, i10, w7Var);
                unsafe.putObject(obj, j10, Boolean.valueOf(w7Var.f3164b != 0));
                unsafe.putInt(obj, j11, i13);
                return iM2;
            case 59:
                if (i14 != 2) {
                    return i10;
                }
                int iJ2 = x7.j(bArr, i10, w7Var);
                int i22 = w7Var.f3163a;
                if (i22 == 0) {
                    unsafe.putObject(obj, j10, "");
                } else {
                    if ((i15 & 536870912) != 0 && !eb.e(bArr, iJ2, iJ2 + i22)) {
                        throw zzll.zzc();
                    }
                    unsafe.putObject(obj, j10, new String(bArr, iJ2, i22, h9.f2835b));
                    iJ2 += i22;
                }
                unsafe.putInt(obj, j11, i13);
                return iJ2;
            case 60:
                if (i14 != 2) {
                    return i10;
                }
                Object objN = n(obj, i13, i17);
                int iO = x7.o(objN, k(i17), bArr, i10, i11, w7Var);
                v(obj, i13, i17, objN);
                return iO;
            case 61:
                if (i14 != 2) {
                    return i10;
                }
                int iA = x7.a(bArr, i10, w7Var);
                unsafe.putObject(obj, j10, w7Var.f3165c);
                unsafe.putInt(obj, j11, i13);
                return iA;
            case 63:
                if (i14 != 0) {
                    return i10;
                }
                int iJ3 = x7.j(bArr, i10, w7Var);
                int i23 = w7Var.f3163a;
                d9 d9VarJ = j(i17);
                if (d9VarJ != null && !d9VarJ.i(i23)) {
                    G(obj).j(i12, Long.valueOf(i23));
                    return iJ3;
                }
                unsafe.putObject(obj, j10, Integer.valueOf(i23));
                unsafe.putInt(obj, j11, i13);
                return iJ3;
            case 66:
                if (i14 != 0) {
                    return i10;
                }
                int iJ4 = x7.j(bArr, i10, w7Var);
                unsafe.putObject(obj, j10, Integer.valueOf(j8.a(w7Var.f3163a)));
                unsafe.putInt(obj, j11, i13);
                return iJ4;
            case 67:
                if (i14 != 0) {
                    return i10;
                }
                int iM3 = x7.m(bArr, i10, w7Var);
                unsafe.putObject(obj, j10, Long.valueOf(j8.b(w7Var.f3164b)));
                unsafe.putInt(obj, j11, i13);
                return iM3;
            case 68:
                if (i14 == 3) {
                    Object objN2 = n(obj, i13, i17);
                    int iN = x7.n(objN2, k(i17), bArr, i10, i11, (i12 & (-8)) | 4, w7Var);
                    v(obj, i13, i17, objN2);
                    return iN;
                }
                break;
        }
        return i10;
    }

    public final int O(Object obj, byte[] bArr, int i10, int i11, int i12, int i13, int i14, int i15, long j10, int i16, long j11, w7 w7Var) throws zzll {
        int iL;
        Unsafe unsafe = f2747q;
        g9 g9VarJ = (g9) unsafe.getObject(obj, j11);
        if (!g9VarJ.b()) {
            int size = g9VarJ.size();
            g9VarJ = g9VarJ.j(size == 0 ? 10 : size + size);
            unsafe.putObject(obj, j11, g9VarJ);
        }
        g9 g9Var = g9VarJ;
        Object objA = null;
        switch (i16) {
            case 18:
            case 35:
                if (i14 != 2) {
                    if (i14 == 1) {
                        n.g.a(g9Var);
                        Double.longBitsToDouble(x7.p(bArr, i10));
                        throw null;
                    }
                    return i10;
                }
                n.g.a(g9Var);
                int iJ = x7.j(bArr, i10, w7Var);
                int i17 = w7Var.f3163a + iJ;
                if (iJ < i17) {
                    Double.longBitsToDouble(x7.p(bArr, iJ));
                    throw null;
                }
                if (iJ == i17) {
                    return iJ;
                }
                throw zzll.zzf();
            case 19:
            case 36:
                if (i14 != 2) {
                    if (i14 == 5) {
                        n.g.a(g9Var);
                        Float.intBitsToFloat(x7.b(bArr, i10));
                        throw null;
                    }
                    return i10;
                }
                n.g.a(g9Var);
                int iJ2 = x7.j(bArr, i10, w7Var);
                int i18 = w7Var.f3163a + iJ2;
                if (iJ2 < i18) {
                    Float.intBitsToFloat(x7.b(bArr, iJ2));
                    throw null;
                }
                if (iJ2 == i18) {
                    return iJ2;
                }
                throw zzll.zzf();
            case 20:
            case 21:
            case 37:
            case 38:
                if (i14 == 2) {
                    q9 q9Var = (q9) g9Var;
                    int iJ3 = x7.j(bArr, i10, w7Var);
                    int i19 = w7Var.f3163a + iJ3;
                    while (iJ3 < i19) {
                        iJ3 = x7.m(bArr, iJ3, w7Var);
                        q9Var.g(w7Var.f3164b);
                    }
                    if (iJ3 == i19) {
                        return iJ3;
                    }
                    throw zzll.zzf();
                }
                if (i14 == 0) {
                    q9 q9Var2 = (q9) g9Var;
                    int iM = x7.m(bArr, i10, w7Var);
                    q9Var2.g(w7Var.f3164b);
                    while (iM < i11) {
                        int iJ4 = x7.j(bArr, iM, w7Var);
                        if (i12 != w7Var.f3163a) {
                            return iM;
                        }
                        iM = x7.m(bArr, iJ4, w7Var);
                        q9Var2.g(w7Var.f3164b);
                    }
                    return iM;
                }
                return i10;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i14 == 2) {
                    return x7.f(bArr, i10, g9Var, w7Var);
                }
                if (i14 == 0) {
                    return x7.l(i12, bArr, i10, i11, g9Var, w7Var);
                }
                return i10;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i14 == 2) {
                    q9 q9Var3 = (q9) g9Var;
                    int iJ5 = x7.j(bArr, i10, w7Var);
                    int i20 = w7Var.f3163a + iJ5;
                    while (iJ5 < i20) {
                        q9Var3.g(x7.p(bArr, iJ5));
                        iJ5 += 8;
                    }
                    if (iJ5 == i20) {
                        return iJ5;
                    }
                    throw zzll.zzf();
                }
                if (i14 == 1) {
                    q9 q9Var4 = (q9) g9Var;
                    q9Var4.g(x7.p(bArr, i10));
                    int i21 = i10 + 8;
                    while (i21 < i11) {
                        int iJ6 = x7.j(bArr, i21, w7Var);
                        if (i12 != w7Var.f3163a) {
                            return i21;
                        }
                        q9Var4.g(x7.p(bArr, iJ6));
                        i21 = iJ6 + 8;
                    }
                    return i21;
                }
                return i10;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i14 == 2) {
                    b9 b9Var = (b9) g9Var;
                    int iJ7 = x7.j(bArr, i10, w7Var);
                    int i22 = w7Var.f3163a + iJ7;
                    while (iJ7 < i22) {
                        b9Var.h(x7.b(bArr, iJ7));
                        iJ7 += 4;
                    }
                    if (iJ7 == i22) {
                        return iJ7;
                    }
                    throw zzll.zzf();
                }
                if (i14 == 5) {
                    b9 b9Var2 = (b9) g9Var;
                    b9Var2.h(x7.b(bArr, i10));
                    int i23 = i10 + 4;
                    while (i23 < i11) {
                        int iJ8 = x7.j(bArr, i23, w7Var);
                        if (i12 != w7Var.f3163a) {
                            return i23;
                        }
                        b9Var2.h(x7.b(bArr, iJ8));
                        i23 = iJ8 + 4;
                    }
                    return i23;
                }
                return i10;
            case 25:
            case 42:
                if (i14 != 2) {
                    if (i14 == 0) {
                        n.g.a(g9Var);
                        x7.m(bArr, i10, w7Var);
                        long j12 = w7Var.f3164b;
                        throw null;
                    }
                    return i10;
                }
                n.g.a(g9Var);
                int iJ9 = x7.j(bArr, i10, w7Var);
                int i24 = w7Var.f3163a + iJ9;
                if (iJ9 < i24) {
                    x7.m(bArr, iJ9, w7Var);
                    throw null;
                }
                if (iJ9 == i24) {
                    return iJ9;
                }
                throw zzll.zzf();
            case 26:
                if (i14 == 2) {
                    if ((j10 & 536870912) == 0) {
                        int iJ10 = x7.j(bArr, i10, w7Var);
                        int i25 = w7Var.f3163a;
                        if (i25 < 0) {
                            throw zzll.zzd();
                        }
                        if (i25 == 0) {
                            g9Var.add("");
                        } else {
                            g9Var.add(new String(bArr, iJ10, i25, h9.f2835b));
                            iJ10 += i25;
                        }
                        while (iJ10 < i11) {
                            int iJ11 = x7.j(bArr, iJ10, w7Var);
                            if (i12 != w7Var.f3163a) {
                                return iJ10;
                            }
                            iJ10 = x7.j(bArr, iJ11, w7Var);
                            int i26 = w7Var.f3163a;
                            if (i26 < 0) {
                                throw zzll.zzd();
                            }
                            if (i26 == 0) {
                                g9Var.add("");
                            } else {
                                g9Var.add(new String(bArr, iJ10, i26, h9.f2835b));
                                iJ10 += i26;
                            }
                        }
                        return iJ10;
                    }
                    int iJ12 = x7.j(bArr, i10, w7Var);
                    int i27 = w7Var.f3163a;
                    if (i27 < 0) {
                        throw zzll.zzd();
                    }
                    if (i27 == 0) {
                        g9Var.add("");
                    } else {
                        int i28 = iJ12 + i27;
                        if (!eb.e(bArr, iJ12, i28)) {
                            throw zzll.zzc();
                        }
                        g9Var.add(new String(bArr, iJ12, i27, h9.f2835b));
                        iJ12 = i28;
                    }
                    while (iJ12 < i11) {
                        int iJ13 = x7.j(bArr, iJ12, w7Var);
                        if (i12 != w7Var.f3163a) {
                            return iJ12;
                        }
                        iJ12 = x7.j(bArr, iJ13, w7Var);
                        int i29 = w7Var.f3163a;
                        if (i29 < 0) {
                            throw zzll.zzd();
                        }
                        if (i29 == 0) {
                            g9Var.add("");
                        } else {
                            int i30 = iJ12 + i29;
                            if (!eb.e(bArr, iJ12, i30)) {
                                throw zzll.zzc();
                            }
                            g9Var.add(new String(bArr, iJ12, i29, h9.f2835b));
                            iJ12 = i30;
                        }
                    }
                    return iJ12;
                }
                return i10;
            case 27:
                if (i14 == 2) {
                    return x7.e(k(i15), i12, bArr, i10, i11, g9Var, w7Var);
                }
                return i10;
            case 28:
                if (i14 == 2) {
                    int iJ14 = x7.j(bArr, i10, w7Var);
                    int i31 = w7Var.f3163a;
                    if (i31 < 0) {
                        throw zzll.zzd();
                    }
                    if (i31 > bArr.length - iJ14) {
                        throw zzll.zzf();
                    }
                    if (i31 == 0) {
                        g9Var.add(zzka.zzb);
                    } else {
                        g9Var.add(zzka.zzl(bArr, iJ14, i31));
                        iJ14 += i31;
                    }
                    while (iJ14 < i11) {
                        int iJ15 = x7.j(bArr, iJ14, w7Var);
                        if (i12 != w7Var.f3163a) {
                            return iJ14;
                        }
                        iJ14 = x7.j(bArr, iJ15, w7Var);
                        int i32 = w7Var.f3163a;
                        if (i32 < 0) {
                            throw zzll.zzd();
                        }
                        if (i32 > bArr.length - iJ14) {
                            throw zzll.zzf();
                        }
                        if (i32 == 0) {
                            g9Var.add(zzka.zzb);
                        } else {
                            g9Var.add(zzka.zzl(bArr, iJ14, i32));
                            iJ14 += i32;
                        }
                    }
                    return iJ14;
                }
                return i10;
            case 30:
            case 44:
                if (i14 != 2) {
                    if (i14 == 0) {
                        iL = x7.l(i12, bArr, i10, i11, g9Var, w7Var);
                    }
                    return i10;
                }
                iL = x7.f(bArr, i10, g9Var, w7Var);
                d9 d9VarJ = j(i15);
                qa qaVar = this.f2759l;
                Class cls = na.f2932a;
                if (d9VarJ != null) {
                    if (androidx.activity.p.a(g9Var)) {
                        int size2 = g9Var.size();
                        int i33 = 0;
                        for (int i34 = 0; i34 < size2; i34++) {
                            Integer num = (Integer) g9Var.get(i34);
                            int iIntValue = num.intValue();
                            if (d9VarJ.i(iIntValue)) {
                                if (i34 != i33) {
                                    g9Var.set(i33, num);
                                }
                                i33++;
                            } else {
                                objA = na.a(obj, i13, iIntValue, objA, qaVar);
                            }
                        }
                        if (i33 != size2) {
                            g9Var.subList(i33, size2).clear();
                            return iL;
                        }
                    } else {
                        Iterator it = g9Var.iterator();
                        while (it.hasNext()) {
                            int iIntValue2 = ((Integer) it.next()).intValue();
                            if (!d9VarJ.i(iIntValue2)) {
                                objA = na.a(obj, i13, iIntValue2, objA, qaVar);
                                it.remove();
                            }
                        }
                    }
                }
                return iL;
            case 33:
            case 47:
                if (i14 == 2) {
                    b9 b9Var3 = (b9) g9Var;
                    int iJ16 = x7.j(bArr, i10, w7Var);
                    int i35 = w7Var.f3163a + iJ16;
                    while (iJ16 < i35) {
                        iJ16 = x7.j(bArr, iJ16, w7Var);
                        b9Var3.h(j8.a(w7Var.f3163a));
                    }
                    if (iJ16 == i35) {
                        return iJ16;
                    }
                    throw zzll.zzf();
                }
                if (i14 == 0) {
                    b9 b9Var4 = (b9) g9Var;
                    int iJ17 = x7.j(bArr, i10, w7Var);
                    b9Var4.h(j8.a(w7Var.f3163a));
                    while (iJ17 < i11) {
                        int iJ18 = x7.j(bArr, iJ17, w7Var);
                        if (i12 != w7Var.f3163a) {
                            return iJ17;
                        }
                        iJ17 = x7.j(bArr, iJ18, w7Var);
                        b9Var4.h(j8.a(w7Var.f3163a));
                    }
                    return iJ17;
                }
                return i10;
            case 34:
            case 48:
                if (i14 == 2) {
                    q9 q9Var5 = (q9) g9Var;
                    int iJ19 = x7.j(bArr, i10, w7Var);
                    int i36 = w7Var.f3163a + iJ19;
                    while (iJ19 < i36) {
                        iJ19 = x7.m(bArr, iJ19, w7Var);
                        q9Var5.g(j8.b(w7Var.f3164b));
                    }
                    if (iJ19 == i36) {
                        return iJ19;
                    }
                    throw zzll.zzf();
                }
                if (i14 == 0) {
                    q9 q9Var6 = (q9) g9Var;
                    int iM2 = x7.m(bArr, i10, w7Var);
                    q9Var6.g(j8.b(w7Var.f3164b));
                    while (iM2 < i11) {
                        int iJ20 = x7.j(bArr, iM2, w7Var);
                        if (i12 != w7Var.f3163a) {
                            return iM2;
                        }
                        iM2 = x7.m(bArr, iJ20, w7Var);
                        q9Var6.g(j8.b(w7Var.f3164b));
                    }
                    return iM2;
                }
                return i10;
            default:
                if (i14 == 3) {
                    la laVarK = k(i15);
                    int i37 = (i12 & (-8)) | 4;
                    int iC = x7.c(laVarK, bArr, i10, i11, i37, w7Var);
                    la laVar = laVarK;
                    w7 w7Var2 = w7Var;
                    g9Var.add(w7Var2.f3165c);
                    while (iC < i11) {
                        int iJ21 = x7.j(bArr, iC, w7Var2);
                        if (i12 != w7Var2.f3163a) {
                            return iC;
                        }
                        la laVar2 = laVar;
                        w7 w7Var3 = w7Var2;
                        iC = x7.c(laVar2, bArr, iJ21, i11, i37, w7Var3);
                        g9Var.add(w7Var3.f3165c);
                        laVar = laVar2;
                        w7Var2 = w7Var3;
                    }
                    return iC;
                }
                return i10;
        }
    }

    public final int P(int i10) {
        if (i10 < this.f2750c || i10 > this.f2751d) {
            return -1;
        }
        return S(i10, 0);
    }

    public final int Q(int i10, int i11) {
        if (i10 < this.f2750c || i10 > this.f2751d) {
            return -1;
        }
        return S(i10, i11);
    }

    public final int R(int i10) {
        return this.f2748a[i10 + 2];
    }

    public final int S(int i10, int i11) {
        int length = (this.f2748a.length / 3) - 1;
        while (i11 <= length) {
            int i12 = (length + i11) >>> 1;
            int i13 = i12 * 3;
            int i14 = this.f2748a[i13];
            if (i10 == i14) {
                return i13;
            }
            if (i10 < i14) {
                length = i12 - 1;
            } else {
                i11 = i12 + 1;
            }
        }
        return -1;
    }

    public final int U(int i10) {
        return this.f2748a[i10 + 1];
    }

    /* JADX WARN: Code duplicated, block: B:25:0x006d  */
    /* JADX WARN: Code duplicated, block: B:27:0x0073  */
    /* JADX WARN: Code duplicated, block: B:40:0x0080 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.measurement.la
    public final void a(Object obj) {
        if (B(obj)) {
            if (obj instanceof a9) {
                a9 a9Var = (a9) obj;
                a9Var.z(Integer.MAX_VALUE);
                a9Var.zzb = 0;
                a9Var.x();
            }
            int length = this.f2748a.length;
            for (int i10 = 0; i10 < length; i10 += 3) {
                int iU = U(i10);
                int i11 = 1048575 & iU;
                int iT = T(iU);
                long j10 = i11;
                if (iT != 9) {
                    if (iT != 60 && iT != 68) {
                        switch (iT) {
                            case 17:
                                if (y(obj, i10)) {
                                    k(i10).a(f2747q.getObject(obj, j10));
                                }
                                break;
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                            case 27:
                            case 28:
                            case 29:
                            case 30:
                            case 31:
                            case 32:
                            case 33:
                            case 34:
                            case 35:
                            case 36:
                            case 37:
                            case 38:
                            case 39:
                            case 40:
                            case 41:
                            case 42:
                            case 43:
                            case 44:
                            case 45:
                            case 46:
                            case 47:
                            case 48:
                            case 49:
                                this.f2758k.a(obj, j10);
                                break;
                            case 50:
                                Unsafe unsafe = f2747q;
                                Object object = unsafe.getObject(obj, j10);
                                if (object != null) {
                                    ((zzmc) object).zzc();
                                    unsafe.putObject(obj, j10, object);
                                }
                                break;
                        }
                    } else if (C(obj, this.f2748a[i10], i10)) {
                        k(i10).a(f2747q.getObject(obj, j10));
                    }
                } else if (y(obj, i10)) {
                    k(i10).a(f2747q.getObject(obj, j10));
                }
            }
            this.f2759l.g(obj);
            if (this.f2753f) {
                this.f2760m.b(obj);
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.la
    public final void b(Object obj, gb gbVar) {
        int i10;
        int i11 = 1048575;
        if (this.f2754g) {
            if (this.f2753f) {
                this.f2760m.a(obj);
                throw null;
            }
            int length = this.f2748a.length;
            for (int i12 = 0; i12 < length; i12 += 3) {
                int iU = U(i12);
                int i13 = this.f2748a[i12];
                switch (T(iU)) {
                    case 0:
                        if (y(obj, i12)) {
                            gbVar.s(i13, ab.f(obj, iU & 1048575));
                        }
                        break;
                    case 1:
                        if (y(obj, i12)) {
                            gbVar.w(i13, ab.g(obj, iU & 1048575));
                        }
                        break;
                    case 2:
                        if (y(obj, i12)) {
                            gbVar.i(i13, ab.i(obj, iU & 1048575));
                        }
                        break;
                    case 3:
                        if (y(obj, i12)) {
                            gbVar.D(i13, ab.i(obj, iU & 1048575));
                        }
                        break;
                    case 4:
                        if (y(obj, i12)) {
                            gbVar.q(i13, ab.h(obj, iU & 1048575));
                        }
                        break;
                    case 5:
                        if (y(obj, i12)) {
                            gbVar.G(i13, ab.i(obj, iU & 1048575));
                        }
                        break;
                    case 6:
                        if (y(obj, i12)) {
                            gbVar.e(i13, ab.h(obj, iU & 1048575));
                        }
                        break;
                    case 7:
                        if (y(obj, i12)) {
                            gbVar.f(i13, ab.B(obj, iU & 1048575));
                        }
                        break;
                    case 8:
                        if (y(obj, i12)) {
                            E(i13, ab.k(obj, iU & 1048575), gbVar);
                        }
                        break;
                    case 9:
                        if (y(obj, i12)) {
                            gbVar.t(i13, ab.k(obj, iU & 1048575), k(i12));
                        }
                        break;
                    case 10:
                        if (y(obj, i12)) {
                            gbVar.A(i13, (zzka) ab.k(obj, iU & 1048575));
                        }
                        break;
                    case 11:
                        if (y(obj, i12)) {
                            gbVar.b(i13, ab.h(obj, iU & 1048575));
                        }
                        break;
                    case 12:
                        if (y(obj, i12)) {
                            gbVar.o(i13, ab.h(obj, iU & 1048575));
                        }
                        break;
                    case 13:
                        if (y(obj, i12)) {
                            gbVar.v(i13, ab.h(obj, iU & 1048575));
                        }
                        break;
                    case 14:
                        if (y(obj, i12)) {
                            gbVar.k(i13, ab.i(obj, iU & 1048575));
                        }
                        break;
                    case 15:
                        if (y(obj, i12)) {
                            gbVar.g(i13, ab.h(obj, iU & 1048575));
                        }
                        break;
                    case 16:
                        if (y(obj, i12)) {
                            gbVar.I(i13, ab.i(obj, iU & 1048575));
                        }
                        break;
                    case 17:
                        if (y(obj, i12)) {
                            gbVar.a(i13, ab.k(obj, iU & 1048575), k(i12));
                        }
                        break;
                    case 18:
                        na.f(i13, (List) ab.k(obj, iU & 1048575), gbVar, false);
                        break;
                    case 19:
                        na.j(i13, (List) ab.k(obj, iU & 1048575), gbVar, false);
                        break;
                    case 20:
                        na.m(i13, (List) ab.k(obj, iU & 1048575), gbVar, false);
                        break;
                    case 21:
                        na.u(i13, (List) ab.k(obj, iU & 1048575), gbVar, false);
                        break;
                    case 22:
                        na.l(i13, (List) ab.k(obj, iU & 1048575), gbVar, false);
                        break;
                    case 23:
                        na.i(i13, (List) ab.k(obj, iU & 1048575), gbVar, false);
                        break;
                    case 24:
                        na.h(i13, (List) ab.k(obj, iU & 1048575), gbVar, false);
                        break;
                    case 25:
                        na.d(i13, (List) ab.k(obj, iU & 1048575), gbVar, false);
                        break;
                    case 26:
                        na.s(i13, (List) ab.k(obj, iU & 1048575), gbVar);
                        break;
                    case 27:
                        na.n(i13, (List) ab.k(obj, iU & 1048575), gbVar, k(i12));
                        break;
                    case 28:
                        na.e(i13, (List) ab.k(obj, iU & 1048575), gbVar);
                        break;
                    case 29:
                        na.t(i13, (List) ab.k(obj, iU & 1048575), gbVar, false);
                        break;
                    case 30:
                        na.g(i13, (List) ab.k(obj, iU & 1048575), gbVar, false);
                        break;
                    case 31:
                        na.o(i13, (List) ab.k(obj, iU & 1048575), gbVar, false);
                        break;
                    case 32:
                        na.p(i13, (List) ab.k(obj, iU & 1048575), gbVar, false);
                        break;
                    case 33:
                        na.q(i13, (List) ab.k(obj, iU & 1048575), gbVar, false);
                        break;
                    case 34:
                        na.r(i13, (List) ab.k(obj, iU & 1048575), gbVar, false);
                        break;
                    case 35:
                        na.f(i13, (List) ab.k(obj, iU & 1048575), gbVar, true);
                        break;
                    case 36:
                        na.j(i13, (List) ab.k(obj, iU & 1048575), gbVar, true);
                        break;
                    case 37:
                        na.m(i13, (List) ab.k(obj, iU & 1048575), gbVar, true);
                        break;
                    case 38:
                        na.u(i13, (List) ab.k(obj, iU & 1048575), gbVar, true);
                        break;
                    case 39:
                        na.l(i13, (List) ab.k(obj, iU & 1048575), gbVar, true);
                        break;
                    case 40:
                        na.i(i13, (List) ab.k(obj, iU & 1048575), gbVar, true);
                        break;
                    case 41:
                        na.h(i13, (List) ab.k(obj, iU & 1048575), gbVar, true);
                        break;
                    case 42:
                        na.d(i13, (List) ab.k(obj, iU & 1048575), gbVar, true);
                        break;
                    case 43:
                        na.t(i13, (List) ab.k(obj, iU & 1048575), gbVar, true);
                        break;
                    case 44:
                        na.g(i13, (List) ab.k(obj, iU & 1048575), gbVar, true);
                        break;
                    case 45:
                        na.o(i13, (List) ab.k(obj, iU & 1048575), gbVar, true);
                        break;
                    case 46:
                        na.p(i13, (List) ab.k(obj, iU & 1048575), gbVar, true);
                        break;
                    case 47:
                        na.q(i13, (List) ab.k(obj, iU & 1048575), gbVar, true);
                        break;
                    case 48:
                        na.r(i13, (List) ab.k(obj, iU & 1048575), gbVar, true);
                        break;
                    case 49:
                        na.k(i13, (List) ab.k(obj, iU & 1048575), gbVar, k(i12));
                        break;
                    case 50:
                        w(gbVar, i13, ab.k(obj, iU & 1048575), i12);
                        break;
                    case 51:
                        if (C(obj, i13, i12)) {
                            gbVar.s(i13, I(obj, iU & 1048575));
                        }
                        break;
                    case 52:
                        if (C(obj, i13, i12)) {
                            gbVar.w(i13, J(obj, iU & 1048575));
                        }
                        break;
                    case 53:
                        if (C(obj, i13, i12)) {
                            gbVar.i(i13, V(obj, iU & 1048575));
                        }
                        break;
                    case 54:
                        if (C(obj, i13, i12)) {
                            gbVar.D(i13, V(obj, iU & 1048575));
                        }
                        break;
                    case 55:
                        if (C(obj, i13, i12)) {
                            gbVar.q(i13, L(obj, iU & 1048575));
                        }
                        break;
                    case 56:
                        if (C(obj, i13, i12)) {
                            gbVar.G(i13, V(obj, iU & 1048575));
                        }
                        break;
                    case 57:
                        if (C(obj, i13, i12)) {
                            gbVar.e(i13, L(obj, iU & 1048575));
                        }
                        break;
                    case 58:
                        if (C(obj, i13, i12)) {
                            gbVar.f(i13, D(obj, iU & 1048575));
                        }
                        break;
                    case 59:
                        if (C(obj, i13, i12)) {
                            E(i13, ab.k(obj, iU & 1048575), gbVar);
                        }
                        break;
                    case 60:
                        if (C(obj, i13, i12)) {
                            gbVar.t(i13, ab.k(obj, iU & 1048575), k(i12));
                        }
                        break;
                    case 61:
                        if (C(obj, i13, i12)) {
                            gbVar.A(i13, (zzka) ab.k(obj, iU & 1048575));
                        }
                        break;
                    case 62:
                        if (C(obj, i13, i12)) {
                            gbVar.b(i13, L(obj, iU & 1048575));
                        }
                        break;
                    case 63:
                        if (C(obj, i13, i12)) {
                            gbVar.o(i13, L(obj, iU & 1048575));
                        }
                        break;
                    case 64:
                        if (C(obj, i13, i12)) {
                            gbVar.v(i13, L(obj, iU & 1048575));
                        }
                        break;
                    case 65:
                        if (C(obj, i13, i12)) {
                            gbVar.k(i13, V(obj, iU & 1048575));
                        }
                        break;
                    case 66:
                        if (C(obj, i13, i12)) {
                            gbVar.g(i13, L(obj, iU & 1048575));
                        }
                        break;
                    case 67:
                        if (C(obj, i13, i12)) {
                            gbVar.I(i13, V(obj, iU & 1048575));
                        }
                        break;
                    case 68:
                        if (C(obj, i13, i12)) {
                            gbVar.a(i13, ab.k(obj, iU & 1048575), k(i12));
                        }
                        break;
                }
            }
            qa qaVar = this.f2759l;
            qaVar.i(qaVar.d(obj), gbVar);
            return;
        }
        if (this.f2753f) {
            this.f2760m.a(obj);
            throw null;
        }
        int length2 = this.f2748a.length;
        Unsafe unsafe = f2747q;
        int i14 = 0;
        int i15 = 1048575;
        int i16 = 0;
        while (i14 < length2) {
            int iU2 = U(i14);
            int[] iArr = this.f2748a;
            int i17 = iArr[i14];
            int iT = T(iU2);
            if (iT <= 17) {
                int i18 = iArr[i14 + 2];
                int i19 = i18 & i11;
                if (i19 != i15) {
                    i16 = unsafe.getInt(obj, i19);
                    i15 = i19;
                }
                i10 = 1 << (i18 >>> 20);
            } else {
                i10 = 0;
            }
            long j10 = iU2 & i11;
            switch (iT) {
                case 0:
                    if ((i16 & i10) != 0) {
                        gbVar.s(i17, ab.f(obj, j10));
                        continue;
                    }
                    i14 += 3;
                    i11 = 1048575;
                    break;
                case 1:
                    if ((i16 & i10) != 0) {
                        gbVar.w(i17, ab.g(obj, j10));
                    } else {
                        continue;
                    }
                    i14 += 3;
                    i11 = 1048575;
                    break;
                case 2:
                    if ((i16 & i10) != 0) {
                        gbVar.i(i17, unsafe.getLong(obj, j10));
                    } else {
                        continue;
                    }
                    i14 += 3;
                    i11 = 1048575;
                    break;
                case 3:
                    if ((i16 & i10) != 0) {
                        gbVar.D(i17, unsafe.getLong(obj, j10));
                    } else {
                        continue;
                    }
                    i14 += 3;
                    i11 = 1048575;
                    break;
                case 4:
                    if ((i16 & i10) != 0) {
                        gbVar.q(i17, unsafe.getInt(obj, j10));
                    } else {
                        continue;
                    }
                    i14 += 3;
                    i11 = 1048575;
                    break;
                case 5:
                    if ((i16 & i10) != 0) {
                        gbVar.G(i17, unsafe.getLong(obj, j10));
                    } else {
                        continue;
                    }
                    i14 += 3;
                    i11 = 1048575;
                    break;
                case 6:
                    if ((i16 & i10) != 0) {
                        gbVar.e(i17, unsafe.getInt(obj, j10));
                    } else {
                        continue;
                    }
                    i14 += 3;
                    i11 = 1048575;
                    break;
                case 7:
                    if ((i16 & i10) != 0) {
                        gbVar.f(i17, ab.B(obj, j10));
                    } else {
                        continue;
                    }
                    i14 += 3;
                    i11 = 1048575;
                    break;
                case 8:
                    if ((i16 & i10) != 0) {
                        E(i17, unsafe.getObject(obj, j10), gbVar);
                    } else {
                        continue;
                    }
                    i14 += 3;
                    i11 = 1048575;
                    break;
                case 9:
                    if ((i16 & i10) != 0) {
                        gbVar.t(i17, unsafe.getObject(obj, j10), k(i14));
                    } else {
                        continue;
                    }
                    i14 += 3;
                    i11 = 1048575;
                    break;
                case 10:
                    if ((i16 & i10) != 0) {
                        gbVar.A(i17, (zzka) unsafe.getObject(obj, j10));
                    } else {
                        continue;
                    }
                    i14 += 3;
                    i11 = 1048575;
                    break;
                case 11:
                    if ((i16 & i10) != 0) {
                        gbVar.b(i17, unsafe.getInt(obj, j10));
                    } else {
                        continue;
                    }
                    i14 += 3;
                    i11 = 1048575;
                    break;
                case 12:
                    if ((i16 & i10) != 0) {
                        gbVar.o(i17, unsafe.getInt(obj, j10));
                    } else {
                        continue;
                    }
                    i14 += 3;
                    i11 = 1048575;
                    break;
                case 13:
                    if ((i16 & i10) != 0) {
                        gbVar.v(i17, unsafe.getInt(obj, j10));
                    } else {
                        continue;
                    }
                    i14 += 3;
                    i11 = 1048575;
                    break;
                case 14:
                    if ((i16 & i10) != 0) {
                        gbVar.k(i17, unsafe.getLong(obj, j10));
                    } else {
                        continue;
                    }
                    i14 += 3;
                    i11 = 1048575;
                    break;
                case 15:
                    if ((i16 & i10) != 0) {
                        gbVar.g(i17, unsafe.getInt(obj, j10));
                    } else {
                        continue;
                    }
                    i14 += 3;
                    i11 = 1048575;
                    break;
                case 16:
                    if ((i16 & i10) != 0) {
                        gbVar.I(i17, unsafe.getLong(obj, j10));
                    } else {
                        continue;
                    }
                    i14 += 3;
                    i11 = 1048575;
                    break;
                case 17:
                    if ((i16 & i10) != 0) {
                        gbVar.a(i17, unsafe.getObject(obj, j10), k(i14));
                    } else {
                        continue;
                    }
                    i14 += 3;
                    i11 = 1048575;
                    break;
                case 18:
                    na.f(this.f2748a[i14], (List) unsafe.getObject(obj, j10), gbVar, false);
                    continue;
                    i14 += 3;
                    i11 = 1048575;
                    break;
                case 19:
                    na.j(this.f2748a[i14], (List) unsafe.getObject(obj, j10), gbVar, false);
                    continue;
                    i14 += 3;
                    i11 = 1048575;
                    break;
                case 20:
                    na.m(this.f2748a[i14], (List) unsafe.getObject(obj, j10), gbVar, false);
                    continue;
                    i14 += 3;
                    i11 = 1048575;
                    break;
                case 21:
                    na.u(this.f2748a[i14], (List) unsafe.getObject(obj, j10), gbVar, false);
                    continue;
                    i14 += 3;
                    i11 = 1048575;
                    break;
                case 22:
                    na.l(this.f2748a[i14], (List) unsafe.getObject(obj, j10), gbVar, false);
                    continue;
                    i14 += 3;
                    i11 = 1048575;
                    break;
                case 23:
                    na.i(this.f2748a[i14], (List) unsafe.getObject(obj, j10), gbVar, false);
                    continue;
                    i14 += 3;
                    i11 = 1048575;
                    break;
                case 24:
                    na.h(this.f2748a[i14], (List) unsafe.getObject(obj, j10), gbVar, false);
                    continue;
                    i14 += 3;
                    i11 = 1048575;
                    break;
                case 25:
                    na.d(this.f2748a[i14], (List) unsafe.getObject(obj, j10), gbVar, false);
                    continue;
                    i14 += 3;
                    i11 = 1048575;
                    break;
                case 26:
                    na.s(this.f2748a[i14], (List) unsafe.getObject(obj, j10), gbVar);
                    break;
                case 27:
                    na.n(this.f2748a[i14], (List) unsafe.getObject(obj, j10), gbVar, k(i14));
                    break;
                case 28:
                    na.e(this.f2748a[i14], (List) unsafe.getObject(obj, j10), gbVar);
                    break;
                case 29:
                    na.t(this.f2748a[i14], (List) unsafe.getObject(obj, j10), gbVar, false);
                    break;
                case 30:
                    na.g(this.f2748a[i14], (List) unsafe.getObject(obj, j10), gbVar, false);
                    continue;
                    i14 += 3;
                    i11 = 1048575;
                    break;
                case 31:
                    na.o(this.f2748a[i14], (List) unsafe.getObject(obj, j10), gbVar, false);
                    continue;
                    i14 += 3;
                    i11 = 1048575;
                    break;
                case 32:
                    na.p(this.f2748a[i14], (List) unsafe.getObject(obj, j10), gbVar, false);
                    continue;
                    i14 += 3;
                    i11 = 1048575;
                    break;
                case 33:
                    na.q(this.f2748a[i14], (List) unsafe.getObject(obj, j10), gbVar, false);
                    continue;
                    i14 += 3;
                    i11 = 1048575;
                    break;
                case 34:
                    na.r(this.f2748a[i14], (List) unsafe.getObject(obj, j10), gbVar, false);
                    continue;
                    i14 += 3;
                    i11 = 1048575;
                    break;
                case 35:
                    na.f(this.f2748a[i14], (List) unsafe.getObject(obj, j10), gbVar, true);
                    break;
                case 36:
                    na.j(this.f2748a[i14], (List) unsafe.getObject(obj, j10), gbVar, true);
                    break;
                case 37:
                    na.m(this.f2748a[i14], (List) unsafe.getObject(obj, j10), gbVar, true);
                    break;
                case 38:
                    na.u(this.f2748a[i14], (List) unsafe.getObject(obj, j10), gbVar, true);
                    break;
                case 39:
                    na.l(this.f2748a[i14], (List) unsafe.getObject(obj, j10), gbVar, true);
                    break;
                case 40:
                    na.i(this.f2748a[i14], (List) unsafe.getObject(obj, j10), gbVar, true);
                    break;
                case 41:
                    na.h(this.f2748a[i14], (List) unsafe.getObject(obj, j10), gbVar, true);
                    break;
                case 42:
                    na.d(this.f2748a[i14], (List) unsafe.getObject(obj, j10), gbVar, true);
                    break;
                case 43:
                    na.t(this.f2748a[i14], (List) unsafe.getObject(obj, j10), gbVar, true);
                    break;
                case 44:
                    na.g(this.f2748a[i14], (List) unsafe.getObject(obj, j10), gbVar, true);
                    break;
                case 45:
                    na.o(this.f2748a[i14], (List) unsafe.getObject(obj, j10), gbVar, true);
                    break;
                case 46:
                    na.p(this.f2748a[i14], (List) unsafe.getObject(obj, j10), gbVar, true);
                    break;
                case 47:
                    na.q(this.f2748a[i14], (List) unsafe.getObject(obj, j10), gbVar, true);
                    break;
                case 48:
                    na.r(this.f2748a[i14], (List) unsafe.getObject(obj, j10), gbVar, true);
                    break;
                case 49:
                    na.k(this.f2748a[i14], (List) unsafe.getObject(obj, j10), gbVar, k(i14));
                    break;
                case 50:
                    w(gbVar, i17, unsafe.getObject(obj, j10), i14);
                    break;
                case 51:
                    if (C(obj, i17, i14)) {
                        gbVar.s(i17, I(obj, j10));
                    }
                    break;
                case 52:
                    if (C(obj, i17, i14)) {
                        gbVar.w(i17, J(obj, j10));
                    }
                    break;
                case 53:
                    if (C(obj, i17, i14)) {
                        gbVar.i(i17, V(obj, j10));
                    }
                    break;
                case 54:
                    if (C(obj, i17, i14)) {
                        gbVar.D(i17, V(obj, j10));
                    }
                    break;
                case 55:
                    if (C(obj, i17, i14)) {
                        gbVar.q(i17, L(obj, j10));
                    }
                    break;
                case 56:
                    if (C(obj, i17, i14)) {
                        gbVar.G(i17, V(obj, j10));
                    }
                    break;
                case 57:
                    if (C(obj, i17, i14)) {
                        gbVar.e(i17, L(obj, j10));
                    }
                    break;
                case 58:
                    if (C(obj, i17, i14)) {
                        gbVar.f(i17, D(obj, j10));
                    }
                    break;
                case 59:
                    if (C(obj, i17, i14)) {
                        E(i17, unsafe.getObject(obj, j10), gbVar);
                    }
                    break;
                case 60:
                    if (C(obj, i17, i14)) {
                        gbVar.t(i17, unsafe.getObject(obj, j10), k(i14));
                    }
                    break;
                case 61:
                    if (C(obj, i17, i14)) {
                        gbVar.A(i17, (zzka) unsafe.getObject(obj, j10));
                    }
                    break;
                case 62:
                    if (C(obj, i17, i14)) {
                        gbVar.b(i17, L(obj, j10));
                    }
                    break;
                case 63:
                    if (C(obj, i17, i14)) {
                        gbVar.o(i17, L(obj, j10));
                    }
                    break;
                case 64:
                    if (C(obj, i17, i14)) {
                        gbVar.v(i17, L(obj, j10));
                    }
                    break;
                case 65:
                    if (C(obj, i17, i14)) {
                        gbVar.k(i17, V(obj, j10));
                    }
                    break;
                case 66:
                    if (C(obj, i17, i14)) {
                        gbVar.g(i17, L(obj, j10));
                    }
                    break;
                case 67:
                    if (C(obj, i17, i14)) {
                        gbVar.I(i17, V(obj, j10));
                    }
                    break;
                case 68:
                    if (C(obj, i17, i14)) {
                        gbVar.a(i17, unsafe.getObject(obj, j10), k(i14));
                    }
                    break;
            }
            i14 += 3;
            i11 = 1048575;
        }
        qa qaVar2 = this.f2759l;
        qaVar2.i(qaVar2.d(obj), gbVar);
    }

    /* JADX WARN: Code duplicated, block: B:43:0x0094  */
    /* JADX WARN: Code duplicated, block: B:45:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:48:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:51:0x00b9 A[LOOP:1: B:46:0x00a8->B:51:0x00b9, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:68:0x00b8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:72:0x00ce A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.measurement.la
    public final boolean c(Object obj) {
        int i10;
        int i11;
        int i12;
        List list;
        la laVarK;
        int i13;
        int i14 = 1048575;
        int i15 = 0;
        int i16 = 0;
        while (i16 < this.f2756i) {
            int i17 = this.f2755h[i16];
            int i18 = this.f2748a[i17];
            int iU = U(i17);
            int i19 = this.f2748a[i17 + 2];
            int i20 = i19 & 1048575;
            int i21 = 1 << (i19 >>> 20);
            if (i20 != i14) {
                if (i20 != 1048575) {
                    i15 = f2747q.getInt(obj, i20);
                }
                i10 = i15;
                i14 = i20;
            } else {
                i10 = i15;
            }
            if ((268435456 & iU) != 0) {
                i11 = i17;
                i12 = i14;
                if (!z(obj, i11, i12, i10, i21)) {
                    return false;
                }
            } else {
                i11 = i17;
                i12 = i14;
            }
            int iT = T(iU);
            if (iT == 9 || iT == 17) {
                if (z(obj, i11, i12, i10, i21) && !A(obj, iU, k(i11))) {
                    return false;
                }
            } else if (iT == 27) {
                list = (List) ab.k(obj, iU & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    laVarK = k(i11);
                    for (i13 = 0; i13 < list.size(); i13++) {
                        if (!laVarK.c(list.get(i13))) {
                            return false;
                        }
                    }
                }
            } else if (iT == 60 || iT == 68) {
                if (C(obj, i18, i11) && !A(obj, iU, k(i11))) {
                    return false;
                }
            } else if (iT == 49) {
                list = (List) ab.k(obj, iU & 1048575);
                if (list.isEmpty()) {
                    laVarK = k(i11);
                    while (i13 < list.size()) {
                        if (!laVarK.c(list.get(i13))) {
                            return false;
                        }
                    }
                } else {
                    continue;
                }
            } else if (iT == 50 && !((zzmc) ab.k(obj, iU & 1048575)).isEmpty()) {
                n.g.a(l(i11));
                throw null;
            }
            i16++;
            i14 = i12;
            i15 = i10;
        }
        if (!this.f2753f) {
            return true;
        }
        this.f2760m.a(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.la
    public final Object d() {
        return ((a9) this.f2752e).o();
    }

    @Override // com.google.android.gms.internal.measurement.la
    public final int e(Object obj) {
        int i10;
        long jDoubleToLongBits;
        int i11;
        int iFloatToIntBits;
        int length = this.f2748a.length;
        int i12 = 0;
        for (int i13 = 0; i13 < length; i13 += 3) {
            int iU = U(i13);
            int i14 = this.f2748a[i13];
            long j10 = 1048575 & iU;
            int iHashCode = 37;
            switch (T(iU)) {
                case 0:
                    i10 = i12 * 53;
                    jDoubleToLongBits = Double.doubleToLongBits(ab.f(obj, j10));
                    Charset charset = h9.f2834a;
                    i12 = i10 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    break;
                case 1:
                    i11 = i12 * 53;
                    iFloatToIntBits = Float.floatToIntBits(ab.g(obj, j10));
                    i12 = i11 + iFloatToIntBits;
                    break;
                case 2:
                    i10 = i12 * 53;
                    jDoubleToLongBits = ab.i(obj, j10);
                    Charset charset2 = h9.f2834a;
                    i12 = i10 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    break;
                case 3:
                    i10 = i12 * 53;
                    jDoubleToLongBits = ab.i(obj, j10);
                    Charset charset3 = h9.f2834a;
                    i12 = i10 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    break;
                case 4:
                    i11 = i12 * 53;
                    iFloatToIntBits = ab.h(obj, j10);
                    i12 = i11 + iFloatToIntBits;
                    break;
                case 5:
                    i10 = i12 * 53;
                    jDoubleToLongBits = ab.i(obj, j10);
                    Charset charset4 = h9.f2834a;
                    i12 = i10 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    break;
                case 6:
                    i11 = i12 * 53;
                    iFloatToIntBits = ab.h(obj, j10);
                    i12 = i11 + iFloatToIntBits;
                    break;
                case 7:
                    i11 = i12 * 53;
                    iFloatToIntBits = h9.a(ab.B(obj, j10));
                    i12 = i11 + iFloatToIntBits;
                    break;
                case 8:
                    i11 = i12 * 53;
                    iFloatToIntBits = ((String) ab.k(obj, j10)).hashCode();
                    i12 = i11 + iFloatToIntBits;
                    break;
                case 9:
                    Object objK = ab.k(obj, j10);
                    if (objK != null) {
                        iHashCode = objK.hashCode();
                    }
                    i12 = (i12 * 53) + iHashCode;
                    break;
                case 10:
                    i11 = i12 * 53;
                    iFloatToIntBits = ab.k(obj, j10).hashCode();
                    i12 = i11 + iFloatToIntBits;
                    break;
                case 11:
                    i11 = i12 * 53;
                    iFloatToIntBits = ab.h(obj, j10);
                    i12 = i11 + iFloatToIntBits;
                    break;
                case 12:
                    i11 = i12 * 53;
                    iFloatToIntBits = ab.h(obj, j10);
                    i12 = i11 + iFloatToIntBits;
                    break;
                case 13:
                    i11 = i12 * 53;
                    iFloatToIntBits = ab.h(obj, j10);
                    i12 = i11 + iFloatToIntBits;
                    break;
                case 14:
                    i10 = i12 * 53;
                    jDoubleToLongBits = ab.i(obj, j10);
                    Charset charset5 = h9.f2834a;
                    i12 = i10 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    break;
                case 15:
                    i11 = i12 * 53;
                    iFloatToIntBits = ab.h(obj, j10);
                    i12 = i11 + iFloatToIntBits;
                    break;
                case 16:
                    i10 = i12 * 53;
                    jDoubleToLongBits = ab.i(obj, j10);
                    Charset charset6 = h9.f2834a;
                    i12 = i10 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    break;
                case 17:
                    Object objK2 = ab.k(obj, j10);
                    if (objK2 != null) {
                        iHashCode = objK2.hashCode();
                    }
                    i12 = (i12 * 53) + iHashCode;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i11 = i12 * 53;
                    iFloatToIntBits = ab.k(obj, j10).hashCode();
                    i12 = i11 + iFloatToIntBits;
                    break;
                case 50:
                    i11 = i12 * 53;
                    iFloatToIntBits = ab.k(obj, j10).hashCode();
                    i12 = i11 + iFloatToIntBits;
                    break;
                case 51:
                    if (C(obj, i14, i13)) {
                        i10 = i12 * 53;
                        jDoubleToLongBits = Double.doubleToLongBits(I(obj, j10));
                        Charset charset7 = h9.f2834a;
                        i12 = i10 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    }
                    break;
                case 52:
                    if (C(obj, i14, i13)) {
                        i11 = i12 * 53;
                        iFloatToIntBits = Float.floatToIntBits(J(obj, j10));
                        i12 = i11 + iFloatToIntBits;
                    }
                    break;
                case 53:
                    if (C(obj, i14, i13)) {
                        i10 = i12 * 53;
                        jDoubleToLongBits = V(obj, j10);
                        Charset charset8 = h9.f2834a;
                        i12 = i10 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    }
                    break;
                case 54:
                    if (C(obj, i14, i13)) {
                        i10 = i12 * 53;
                        jDoubleToLongBits = V(obj, j10);
                        Charset charset9 = h9.f2834a;
                        i12 = i10 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    }
                    break;
                case 55:
                    if (C(obj, i14, i13)) {
                        i11 = i12 * 53;
                        iFloatToIntBits = L(obj, j10);
                        i12 = i11 + iFloatToIntBits;
                    }
                    break;
                case 56:
                    if (C(obj, i14, i13)) {
                        i10 = i12 * 53;
                        jDoubleToLongBits = V(obj, j10);
                        Charset charset10 = h9.f2834a;
                        i12 = i10 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    }
                    break;
                case 57:
                    if (C(obj, i14, i13)) {
                        i11 = i12 * 53;
                        iFloatToIntBits = L(obj, j10);
                        i12 = i11 + iFloatToIntBits;
                    }
                    break;
                case 58:
                    if (C(obj, i14, i13)) {
                        i11 = i12 * 53;
                        iFloatToIntBits = h9.a(D(obj, j10));
                        i12 = i11 + iFloatToIntBits;
                    }
                    break;
                case 59:
                    if (C(obj, i14, i13)) {
                        i11 = i12 * 53;
                        iFloatToIntBits = ((String) ab.k(obj, j10)).hashCode();
                        i12 = i11 + iFloatToIntBits;
                    }
                    break;
                case 60:
                    if (C(obj, i14, i13)) {
                        i11 = i12 * 53;
                        iFloatToIntBits = ab.k(obj, j10).hashCode();
                        i12 = i11 + iFloatToIntBits;
                    }
                    break;
                case 61:
                    if (C(obj, i14, i13)) {
                        i11 = i12 * 53;
                        iFloatToIntBits = ab.k(obj, j10).hashCode();
                        i12 = i11 + iFloatToIntBits;
                    }
                    break;
                case 62:
                    if (C(obj, i14, i13)) {
                        i11 = i12 * 53;
                        iFloatToIntBits = L(obj, j10);
                        i12 = i11 + iFloatToIntBits;
                    }
                    break;
                case 63:
                    if (C(obj, i14, i13)) {
                        i11 = i12 * 53;
                        iFloatToIntBits = L(obj, j10);
                        i12 = i11 + iFloatToIntBits;
                    }
                    break;
                case 64:
                    if (C(obj, i14, i13)) {
                        i11 = i12 * 53;
                        iFloatToIntBits = L(obj, j10);
                        i12 = i11 + iFloatToIntBits;
                    }
                    break;
                case 65:
                    if (C(obj, i14, i13)) {
                        i10 = i12 * 53;
                        jDoubleToLongBits = V(obj, j10);
                        Charset charset11 = h9.f2834a;
                        i12 = i10 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    }
                    break;
                case 66:
                    if (C(obj, i14, i13)) {
                        i11 = i12 * 53;
                        iFloatToIntBits = L(obj, j10);
                        i12 = i11 + iFloatToIntBits;
                    }
                    break;
                case 67:
                    if (C(obj, i14, i13)) {
                        i10 = i12 * 53;
                        jDoubleToLongBits = V(obj, j10);
                        Charset charset12 = h9.f2834a;
                        i12 = i10 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    }
                    break;
                case 68:
                    if (C(obj, i14, i13)) {
                        i11 = i12 * 53;
                        iFloatToIntBits = ab.k(obj, j10).hashCode();
                        i12 = i11 + iFloatToIntBits;
                    }
                    break;
            }
        }
        int iHashCode2 = (i12 * 53) + this.f2759l.d(obj).hashCode();
        if (!this.f2753f) {
            return iHashCode2;
        }
        this.f2760m.a(obj);
        throw null;
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 9881. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    @Override // com.google.android.gms.internal.measurement.la
    public final void f(java.lang.Object r26, byte[] r27, int r28, int r29, com.google.android.gms.internal.measurement.w7 r30) {
        /*
            Method dump skipped, instruction units count: 988
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.da.f(java.lang.Object, byte[], int, int, com.google.android.gms.internal.measurement.w7):void");
    }

    @Override // com.google.android.gms.internal.measurement.la
    public final int g(Object obj) {
        int iY;
        int iY2;
        int iZ;
        int iY3;
        int iY4;
        int iY5;
        int iY6;
        int iJ;
        int iY7;
        int iZ2;
        int iY8;
        int iY9;
        if (!this.f2754g) {
            return K(obj);
        }
        Unsafe unsafe = f2747q;
        int i10 = 0;
        for (int i11 = 0; i11 < this.f2748a.length; i11 += 3) {
            int iU = U(i11);
            int iT = T(iU);
            int i12 = this.f2748a[i11];
            int i13 = iU & 1048575;
            if (iT >= zzkt.zzJ.zza() && iT <= zzkt.zzW.zza()) {
                int i14 = this.f2748a[i11 + 2];
            }
            long j10 = i13;
            switch (iT) {
                case 0:
                    if (y(obj, i11)) {
                        iY = m8.y(i12 << 3);
                        iJ = iY + 8;
                        i10 += iJ;
                    }
                    break;
                case 1:
                    if (y(obj, i11)) {
                        iY2 = m8.y(i12 << 3);
                        iJ = iY2 + 4;
                        i10 += iJ;
                    }
                    break;
                case 2:
                    if (y(obj, i11)) {
                        iZ = m8.z(ab.i(obj, j10));
                        iY3 = m8.y(i12 << 3);
                        i10 += iY3 + iZ;
                    }
                    break;
                case 3:
                    if (y(obj, i11)) {
                        iZ = m8.z(ab.i(obj, j10));
                        iY3 = m8.y(i12 << 3);
                        i10 += iY3 + iZ;
                    }
                    break;
                case 4:
                    if (y(obj, i11)) {
                        iZ = m8.v(ab.h(obj, j10));
                        iY3 = m8.y(i12 << 3);
                        i10 += iY3 + iZ;
                    }
                    break;
                case 5:
                    if (y(obj, i11)) {
                        iY = m8.y(i12 << 3);
                        iJ = iY + 8;
                        i10 += iJ;
                    }
                    break;
                case 6:
                    if (y(obj, i11)) {
                        iY2 = m8.y(i12 << 3);
                        iJ = iY2 + 4;
                        i10 += iJ;
                    }
                    break;
                case 7:
                    if (y(obj, i11)) {
                        iY4 = m8.y(i12 << 3);
                        iJ = iY4 + 1;
                        i10 += iJ;
                    }
                    break;
                case 8:
                    if (y(obj, i11)) {
                        Object objK = ab.k(obj, j10);
                        if (objK instanceof zzka) {
                            int i15 = i12 << 3;
                            Logger logger = m8.f2919b;
                            int iZzd = ((zzka) objK).zzd();
                            iY5 = m8.y(iZzd) + iZzd;
                            iY6 = m8.y(i15);
                            iJ = iY6 + iY5;
                            i10 += iJ;
                        } else {
                            iZ = m8.x((String) objK);
                            iY3 = m8.y(i12 << 3);
                            i10 += iY3 + iZ;
                        }
                    }
                    break;
                case 9:
                    if (y(obj, i11)) {
                        iJ = na.J(i12, ab.k(obj, j10), k(i11));
                        i10 += iJ;
                    }
                    break;
                case 10:
                    if (y(obj, i11)) {
                        zzka zzkaVar = (zzka) ab.k(obj, j10);
                        int i16 = i12 << 3;
                        Logger logger2 = m8.f2919b;
                        int iZzd2 = zzkaVar.zzd();
                        iY5 = m8.y(iZzd2) + iZzd2;
                        iY6 = m8.y(i16);
                        iJ = iY6 + iY5;
                        i10 += iJ;
                    }
                    break;
                case 11:
                    if (y(obj, i11)) {
                        iZ = m8.y(ab.h(obj, j10));
                        iY3 = m8.y(i12 << 3);
                        i10 += iY3 + iZ;
                    }
                    break;
                case 12:
                    if (y(obj, i11)) {
                        iZ = m8.v(ab.h(obj, j10));
                        iY3 = m8.y(i12 << 3);
                        i10 += iY3 + iZ;
                    }
                    break;
                case 13:
                    if (y(obj, i11)) {
                        iY2 = m8.y(i12 << 3);
                        iJ = iY2 + 4;
                        i10 += iJ;
                    }
                    break;
                case 14:
                    if (y(obj, i11)) {
                        iY = m8.y(i12 << 3);
                        iJ = iY + 8;
                        i10 += iJ;
                    }
                    break;
                case 15:
                    if (y(obj, i11)) {
                        int iH = ab.h(obj, j10);
                        iY3 = m8.y(i12 << 3);
                        iZ = m8.y((iH >> 31) ^ (iH + iH));
                        i10 += iY3 + iZ;
                    }
                    break;
                case 16:
                    if (y(obj, i11)) {
                        long jI = ab.i(obj, j10);
                        iY7 = m8.y(i12 << 3);
                        iZ2 = m8.z((jI >> 63) ^ (jI + jI));
                        iJ = iY7 + iZ2;
                        i10 += iJ;
                    }
                    break;
                case 17:
                    if (y(obj, i11)) {
                        iJ = m8.u(i12, (aa) ab.k(obj, j10), k(i11));
                        i10 += iJ;
                    }
                    break;
                case 18:
                    iJ = na.C(i12, (List) ab.k(obj, j10), false);
                    i10 += iJ;
                    break;
                case 19:
                    iJ = na.A(i12, (List) ab.k(obj, j10), false);
                    i10 += iJ;
                    break;
                case 20:
                    iJ = na.H(i12, (List) ab.k(obj, j10), false);
                    i10 += iJ;
                    break;
                case 21:
                    iJ = na.S(i12, (List) ab.k(obj, j10), false);
                    i10 += iJ;
                    break;
                case 22:
                    iJ = na.F(i12, (List) ab.k(obj, j10), false);
                    i10 += iJ;
                    break;
                case 23:
                    iJ = na.C(i12, (List) ab.k(obj, j10), false);
                    i10 += iJ;
                    break;
                case 24:
                    iJ = na.A(i12, (List) ab.k(obj, j10), false);
                    i10 += iJ;
                    break;
                case 25:
                    iJ = na.w(i12, (List) ab.k(obj, j10), false);
                    i10 += iJ;
                    break;
                case 26:
                    iJ = na.P(i12, (List) ab.k(obj, j10));
                    i10 += iJ;
                    break;
                case 27:
                    iJ = na.K(i12, (List) ab.k(obj, j10), k(i11));
                    i10 += iJ;
                    break;
                case 28:
                    iJ = na.x(i12, (List) ab.k(obj, j10));
                    i10 += iJ;
                    break;
                case 29:
                    iJ = na.Q(i12, (List) ab.k(obj, j10), false);
                    i10 += iJ;
                    break;
                case 30:
                    iJ = na.y(i12, (List) ab.k(obj, j10), false);
                    i10 += iJ;
                    break;
                case 31:
                    iJ = na.A(i12, (List) ab.k(obj, j10), false);
                    i10 += iJ;
                    break;
                case 32:
                    iJ = na.C(i12, (List) ab.k(obj, j10), false);
                    i10 += iJ;
                    break;
                case 33:
                    iJ = na.L(i12, (List) ab.k(obj, j10), false);
                    i10 += iJ;
                    break;
                case 34:
                    iJ = na.N(i12, (List) ab.k(obj, j10), false);
                    i10 += iJ;
                    break;
                case 35:
                    iZ = na.D((List) unsafe.getObject(obj, j10));
                    if (iZ > 0) {
                        int i17 = i12 << 3;
                        iY8 = m8.y(iZ);
                        iY9 = m8.y(i17);
                        iY3 = iY9 + iY8;
                        i10 += iY3 + iZ;
                    }
                    break;
                case 36:
                    iZ = na.B((List) unsafe.getObject(obj, j10));
                    if (iZ > 0) {
                        int i18 = i12 << 3;
                        iY8 = m8.y(iZ);
                        iY9 = m8.y(i18);
                        iY3 = iY9 + iY8;
                        i10 += iY3 + iZ;
                    }
                    break;
                case 37:
                    iZ = na.I((List) unsafe.getObject(obj, j10));
                    if (iZ > 0) {
                        int i19 = i12 << 3;
                        iY8 = m8.y(iZ);
                        iY9 = m8.y(i19);
                        iY3 = iY9 + iY8;
                        i10 += iY3 + iZ;
                    }
                    break;
                case 38:
                    iZ = na.T((List) unsafe.getObject(obj, j10));
                    if (iZ > 0) {
                        int i20 = i12 << 3;
                        iY8 = m8.y(iZ);
                        iY9 = m8.y(i20);
                        iY3 = iY9 + iY8;
                        i10 += iY3 + iZ;
                    }
                    break;
                case 39:
                    iZ = na.G((List) unsafe.getObject(obj, j10));
                    if (iZ > 0) {
                        int i21 = i12 << 3;
                        iY8 = m8.y(iZ);
                        iY9 = m8.y(i21);
                        iY3 = iY9 + iY8;
                        i10 += iY3 + iZ;
                    }
                    break;
                case 40:
                    iZ = na.D((List) unsafe.getObject(obj, j10));
                    if (iZ > 0) {
                        int i22 = i12 << 3;
                        iY8 = m8.y(iZ);
                        iY9 = m8.y(i22);
                        iY3 = iY9 + iY8;
                        i10 += iY3 + iZ;
                    }
                    break;
                case 41:
                    iZ = na.B((List) unsafe.getObject(obj, j10));
                    if (iZ > 0) {
                        int i23 = i12 << 3;
                        iY8 = m8.y(iZ);
                        iY9 = m8.y(i23);
                        iY3 = iY9 + iY8;
                        i10 += iY3 + iZ;
                    }
                    break;
                case 42:
                    List list = (List) unsafe.getObject(obj, j10);
                    Class cls = na.f2932a;
                    iZ = list.size();
                    if (iZ > 0) {
                        int i24 = i12 << 3;
                        iY8 = m8.y(iZ);
                        iY9 = m8.y(i24);
                        iY3 = iY9 + iY8;
                        i10 += iY3 + iZ;
                    }
                    break;
                case 43:
                    iZ = na.R((List) unsafe.getObject(obj, j10));
                    if (iZ > 0) {
                        int i25 = i12 << 3;
                        iY8 = m8.y(iZ);
                        iY9 = m8.y(i25);
                        iY3 = iY9 + iY8;
                        i10 += iY3 + iZ;
                    }
                    break;
                case 44:
                    iZ = na.z((List) unsafe.getObject(obj, j10));
                    if (iZ > 0) {
                        int i26 = i12 << 3;
                        iY8 = m8.y(iZ);
                        iY9 = m8.y(i26);
                        iY3 = iY9 + iY8;
                        i10 += iY3 + iZ;
                    }
                    break;
                case 45:
                    iZ = na.B((List) unsafe.getObject(obj, j10));
                    if (iZ > 0) {
                        int i27 = i12 << 3;
                        iY8 = m8.y(iZ);
                        iY9 = m8.y(i27);
                        iY3 = iY9 + iY8;
                        i10 += iY3 + iZ;
                    }
                    break;
                case 46:
                    iZ = na.D((List) unsafe.getObject(obj, j10));
                    if (iZ > 0) {
                        int i28 = i12 << 3;
                        iY8 = m8.y(iZ);
                        iY9 = m8.y(i28);
                        iY3 = iY9 + iY8;
                        i10 += iY3 + iZ;
                    }
                    break;
                case 47:
                    iZ = na.M((List) unsafe.getObject(obj, j10));
                    if (iZ > 0) {
                        int i29 = i12 << 3;
                        iY8 = m8.y(iZ);
                        iY9 = m8.y(i29);
                        iY3 = iY9 + iY8;
                        i10 += iY3 + iZ;
                    }
                    break;
                case 48:
                    iZ = na.O((List) unsafe.getObject(obj, j10));
                    if (iZ > 0) {
                        int i30 = i12 << 3;
                        iY8 = m8.y(iZ);
                        iY9 = m8.y(i30);
                        iY3 = iY9 + iY8;
                        i10 += iY3 + iZ;
                    }
                    break;
                case 49:
                    iJ = na.E(i12, (List) ab.k(obj, j10), k(i11));
                    i10 += iJ;
                    break;
                case 50:
                    v9.a(i12, ab.k(obj, j10), l(i11));
                    break;
                case 51:
                    if (C(obj, i12, i11)) {
                        iY = m8.y(i12 << 3);
                        iJ = iY + 8;
                        i10 += iJ;
                    }
                    break;
                case 52:
                    if (C(obj, i12, i11)) {
                        iY2 = m8.y(i12 << 3);
                        iJ = iY2 + 4;
                        i10 += iJ;
                    }
                    break;
                case 53:
                    if (C(obj, i12, i11)) {
                        iZ = m8.z(V(obj, j10));
                        iY3 = m8.y(i12 << 3);
                        i10 += iY3 + iZ;
                    }
                    break;
                case 54:
                    if (C(obj, i12, i11)) {
                        iZ = m8.z(V(obj, j10));
                        iY3 = m8.y(i12 << 3);
                        i10 += iY3 + iZ;
                    }
                    break;
                case 55:
                    if (C(obj, i12, i11)) {
                        iZ = m8.v(L(obj, j10));
                        iY3 = m8.y(i12 << 3);
                        i10 += iY3 + iZ;
                    }
                    break;
                case 56:
                    if (C(obj, i12, i11)) {
                        iY = m8.y(i12 << 3);
                        iJ = iY + 8;
                        i10 += iJ;
                    }
                    break;
                case 57:
                    if (C(obj, i12, i11)) {
                        iY2 = m8.y(i12 << 3);
                        iJ = iY2 + 4;
                        i10 += iJ;
                    }
                    break;
                case 58:
                    if (C(obj, i12, i11)) {
                        iY4 = m8.y(i12 << 3);
                        iJ = iY4 + 1;
                        i10 += iJ;
                    }
                    break;
                case 59:
                    if (C(obj, i12, i11)) {
                        Object objK2 = ab.k(obj, j10);
                        if (objK2 instanceof zzka) {
                            int i31 = i12 << 3;
                            Logger logger3 = m8.f2919b;
                            int iZzd3 = ((zzka) objK2).zzd();
                            iY5 = m8.y(iZzd3) + iZzd3;
                            iY6 = m8.y(i31);
                            iJ = iY6 + iY5;
                            i10 += iJ;
                        } else {
                            iZ = m8.x((String) objK2);
                            iY3 = m8.y(i12 << 3);
                            i10 += iY3 + iZ;
                        }
                    }
                    break;
                case 60:
                    if (C(obj, i12, i11)) {
                        iJ = na.J(i12, ab.k(obj, j10), k(i11));
                        i10 += iJ;
                    }
                    break;
                case 61:
                    if (C(obj, i12, i11)) {
                        zzka zzkaVar2 = (zzka) ab.k(obj, j10);
                        int i32 = i12 << 3;
                        Logger logger4 = m8.f2919b;
                        int iZzd4 = zzkaVar2.zzd();
                        iY5 = m8.y(iZzd4) + iZzd4;
                        iY6 = m8.y(i32);
                        iJ = iY6 + iY5;
                        i10 += iJ;
                    }
                    break;
                case 62:
                    if (C(obj, i12, i11)) {
                        iZ = m8.y(L(obj, j10));
                        iY3 = m8.y(i12 << 3);
                        i10 += iY3 + iZ;
                    }
                    break;
                case 63:
                    if (C(obj, i12, i11)) {
                        iZ = m8.v(L(obj, j10));
                        iY3 = m8.y(i12 << 3);
                        i10 += iY3 + iZ;
                    }
                    break;
                case 64:
                    if (C(obj, i12, i11)) {
                        iY2 = m8.y(i12 << 3);
                        iJ = iY2 + 4;
                        i10 += iJ;
                    }
                    break;
                case 65:
                    if (C(obj, i12, i11)) {
                        iY = m8.y(i12 << 3);
                        iJ = iY + 8;
                        i10 += iJ;
                    }
                    break;
                case 66:
                    if (C(obj, i12, i11)) {
                        int iL = L(obj, j10);
                        iY3 = m8.y(i12 << 3);
                        iZ = m8.y((iL >> 31) ^ (iL + iL));
                        i10 += iY3 + iZ;
                    }
                    break;
                case 67:
                    if (C(obj, i12, i11)) {
                        long jV = V(obj, j10);
                        iY7 = m8.y(i12 << 3);
                        iZ2 = m8.z((jV >> 63) ^ (jV + jV));
                        iJ = iY7 + iZ2;
                        i10 += iJ;
                    }
                    break;
                case 68:
                    if (C(obj, i12, i11)) {
                        iJ = m8.u(i12, (aa) ab.k(obj, j10), k(i11));
                        i10 += iJ;
                    }
                    break;
            }
        }
        qa qaVar = this.f2759l;
        return i10 + qaVar.a(qaVar.d(obj));
    }

    @Override // com.google.android.gms.internal.measurement.la
    public final void h(Object obj, Object obj2) {
        p(obj);
        obj2.getClass();
        for (int i10 = 0; i10 < this.f2748a.length; i10 += 3) {
            int iU = U(i10);
            int i11 = this.f2748a[i10];
            long j10 = 1048575 & iU;
            switch (T(iU)) {
                case 0:
                    if (y(obj2, i10)) {
                        ab.t(obj, j10, ab.f(obj2, j10));
                        s(obj, i10);
                    }
                    break;
                case 1:
                    if (y(obj2, i10)) {
                        ab.u(obj, j10, ab.g(obj2, j10));
                        s(obj, i10);
                    }
                    break;
                case 2:
                    if (y(obj2, i10)) {
                        ab.w(obj, j10, ab.i(obj2, j10));
                        s(obj, i10);
                    }
                    break;
                case 3:
                    if (y(obj2, i10)) {
                        ab.w(obj, j10, ab.i(obj2, j10));
                        s(obj, i10);
                    }
                    break;
                case 4:
                    if (y(obj2, i10)) {
                        ab.v(obj, j10, ab.h(obj2, j10));
                        s(obj, i10);
                    }
                    break;
                case 5:
                    if (y(obj2, i10)) {
                        ab.w(obj, j10, ab.i(obj2, j10));
                        s(obj, i10);
                    }
                    break;
                case 6:
                    if (y(obj2, i10)) {
                        ab.v(obj, j10, ab.h(obj2, j10));
                        s(obj, i10);
                    }
                    break;
                case 7:
                    if (y(obj2, i10)) {
                        ab.r(obj, j10, ab.B(obj2, j10));
                        s(obj, i10);
                    }
                    break;
                case 8:
                    if (y(obj2, i10)) {
                        ab.x(obj, j10, ab.k(obj2, j10));
                        s(obj, i10);
                    }
                    break;
                case 9:
                    q(obj, obj2, i10);
                    break;
                case 10:
                    if (y(obj2, i10)) {
                        ab.x(obj, j10, ab.k(obj2, j10));
                        s(obj, i10);
                    }
                    break;
                case 11:
                    if (y(obj2, i10)) {
                        ab.v(obj, j10, ab.h(obj2, j10));
                        s(obj, i10);
                    }
                    break;
                case 12:
                    if (y(obj2, i10)) {
                        ab.v(obj, j10, ab.h(obj2, j10));
                        s(obj, i10);
                    }
                    break;
                case 13:
                    if (y(obj2, i10)) {
                        ab.v(obj, j10, ab.h(obj2, j10));
                        s(obj, i10);
                    }
                    break;
                case 14:
                    if (y(obj2, i10)) {
                        ab.w(obj, j10, ab.i(obj2, j10));
                        s(obj, i10);
                    }
                    break;
                case 15:
                    if (y(obj2, i10)) {
                        ab.v(obj, j10, ab.h(obj2, j10));
                        s(obj, i10);
                    }
                    break;
                case 16:
                    if (y(obj2, i10)) {
                        ab.w(obj, j10, ab.i(obj2, j10));
                        s(obj, i10);
                    }
                    break;
                case 17:
                    q(obj, obj2, i10);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.f2758k.b(obj, obj2, j10);
                    break;
                case 50:
                    Class cls = na.f2932a;
                    ab.x(obj, j10, v9.b(ab.k(obj, j10), ab.k(obj2, j10)));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (C(obj2, i11, i10)) {
                        ab.x(obj, j10, ab.k(obj2, j10));
                        t(obj, i11, i10);
                    }
                    break;
                case 60:
                    r(obj, obj2, i10);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (C(obj2, i11, i10)) {
                        ab.x(obj, j10, ab.k(obj2, j10));
                        t(obj, i11, i10);
                    }
                    break;
                case 68:
                    r(obj, obj2, i10);
                    break;
            }
        }
        na.b(this.f2759l, obj, obj2);
        if (this.f2753f) {
            this.f2760m.a(obj2);
            throw null;
        }
    }

    @Override // com.google.android.gms.internal.measurement.la
    public final boolean i(Object obj, Object obj2) {
        boolean zV;
        int length = this.f2748a.length;
        for (int i10 = 0; i10 < length; i10 += 3) {
            int iU = U(i10);
            long j10 = iU & 1048575;
            switch (T(iU)) {
                case 0:
                    if (!x(obj, obj2, i10) || Double.doubleToLongBits(ab.f(obj, j10)) != Double.doubleToLongBits(ab.f(obj2, j10))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 1:
                    if (!x(obj, obj2, i10) || Float.floatToIntBits(ab.g(obj, j10)) != Float.floatToIntBits(ab.g(obj2, j10))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 2:
                    if (!x(obj, obj2, i10) || ab.i(obj, j10) != ab.i(obj2, j10)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 3:
                    if (!x(obj, obj2, i10) || ab.i(obj, j10) != ab.i(obj2, j10)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 4:
                    if (!x(obj, obj2, i10) || ab.h(obj, j10) != ab.h(obj2, j10)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 5:
                    if (!x(obj, obj2, i10) || ab.i(obj, j10) != ab.i(obj2, j10)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 6:
                    if (!x(obj, obj2, i10) || ab.h(obj, j10) != ab.h(obj2, j10)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 7:
                    if (!x(obj, obj2, i10) || ab.B(obj, j10) != ab.B(obj2, j10)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 8:
                    if (!x(obj, obj2, i10) || !na.v(ab.k(obj, j10), ab.k(obj2, j10))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 9:
                    if (!x(obj, obj2, i10) || !na.v(ab.k(obj, j10), ab.k(obj2, j10))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 10:
                    if (!x(obj, obj2, i10) || !na.v(ab.k(obj, j10), ab.k(obj2, j10))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 11:
                    if (!x(obj, obj2, i10) || ab.h(obj, j10) != ab.h(obj2, j10)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 12:
                    if (!x(obj, obj2, i10) || ab.h(obj, j10) != ab.h(obj2, j10)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 13:
                    if (!x(obj, obj2, i10) || ab.h(obj, j10) != ab.h(obj2, j10)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 14:
                    if (!x(obj, obj2, i10) || ab.i(obj, j10) != ab.i(obj2, j10)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 15:
                    if (!x(obj, obj2, i10) || ab.h(obj, j10) != ab.h(obj2, j10)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 16:
                    if (!x(obj, obj2, i10) || ab.i(obj, j10) != ab.i(obj2, j10)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 17:
                    if (!x(obj, obj2, i10) || !na.v(ab.k(obj, j10), ab.k(obj2, j10))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    zV = na.v(ab.k(obj, j10), ab.k(obj2, j10));
                    break;
                case 50:
                    zV = na.v(ab.k(obj, j10), ab.k(obj2, j10));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                    long jR = R(i10) & 1048575;
                    if (ab.h(obj, jR) != ab.h(obj2, jR) || !na.v(ab.k(obj, j10), ab.k(obj2, j10))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                default:
                    continue;
                    break;
            }
            if (!zV) {
                return false;
            }
        }
        if (!this.f2759l.d(obj).equals(this.f2759l.d(obj2))) {
            return false;
        }
        if (!this.f2753f) {
            return true;
        }
        this.f2760m.a(obj);
        this.f2760m.a(obj2);
        throw null;
    }

    public final d9 j(int i10) {
        int i11 = i10 / 3;
        return (d9) this.f2749b[i11 + i11 + 1];
    }

    public final la k(int i10) {
        int i11 = i10 / 3;
        int i12 = i11 + i11;
        la laVar = (la) this.f2749b[i12];
        if (laVar != null) {
            return laVar;
        }
        la laVarB = ia.a().b((Class) this.f2749b[i12 + 1]);
        this.f2749b[i12] = laVarB;
        return laVarB;
    }

    public final Object l(int i10) {
        int i11 = i10 / 3;
        return this.f2749b[i11 + i11];
    }

    public final Object m(Object obj, int i10) {
        la laVarK = k(i10);
        int iU = U(i10) & 1048575;
        if (!y(obj, i10)) {
            return laVarK.d();
        }
        Object object = f2747q.getObject(obj, iU);
        if (B(object)) {
            return object;
        }
        Object objD = laVarK.d();
        if (object != null) {
            laVarK.h(objD, object);
        }
        return objD;
    }

    public final Object n(Object obj, int i10, int i11) {
        la laVarK = k(i11);
        if (!C(obj, i10, i11)) {
            return laVarK.d();
        }
        Object object = f2747q.getObject(obj, U(i11) & 1048575);
        if (B(object)) {
            return object;
        }
        Object objD = laVarK.d();
        if (object != null) {
            laVarK.h(objD, object);
        }
        return objD;
    }

    public final void q(Object obj, Object obj2, int i10) {
        if (y(obj2, i10)) {
            int iU = U(i10) & 1048575;
            Unsafe unsafe = f2747q;
            long j10 = iU;
            Object object = unsafe.getObject(obj2, j10);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.f2748a[i10] + " is present but null: " + obj2.toString());
            }
            la laVarK = k(i10);
            if (!y(obj, i10)) {
                if (B(object)) {
                    Object objD = laVarK.d();
                    laVarK.h(objD, object);
                    unsafe.putObject(obj, j10, objD);
                } else {
                    unsafe.putObject(obj, j10, object);
                }
                s(obj, i10);
                return;
            }
            Object object2 = unsafe.getObject(obj, j10);
            if (!B(object2)) {
                Object objD2 = laVarK.d();
                laVarK.h(objD2, object2);
                unsafe.putObject(obj, j10, objD2);
                object2 = objD2;
            }
            laVarK.h(object2, object);
        }
    }

    public final void r(Object obj, Object obj2, int i10) {
        int i11 = this.f2748a[i10];
        if (C(obj2, i11, i10)) {
            int iU = U(i10) & 1048575;
            Unsafe unsafe = f2747q;
            long j10 = iU;
            Object object = unsafe.getObject(obj2, j10);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.f2748a[i10] + " is present but null: " + obj2.toString());
            }
            la laVarK = k(i10);
            if (!C(obj, i11, i10)) {
                if (B(object)) {
                    Object objD = laVarK.d();
                    laVarK.h(objD, object);
                    unsafe.putObject(obj, j10, objD);
                } else {
                    unsafe.putObject(obj, j10, object);
                }
                t(obj, i11, i10);
                return;
            }
            Object object2 = unsafe.getObject(obj, j10);
            if (!B(object2)) {
                Object objD2 = laVarK.d();
                laVarK.h(objD2, object2);
                unsafe.putObject(obj, j10, objD2);
                object2 = objD2;
            }
            laVarK.h(object2, object);
        }
    }

    public final void s(Object obj, int i10) {
        int iR = R(i10);
        long j10 = 1048575 & iR;
        if (j10 == 1048575) {
            return;
        }
        ab.v(obj, j10, (1 << (iR >>> 20)) | ab.h(obj, j10));
    }

    public final void t(Object obj, int i10, int i11) {
        ab.v(obj, R(i11) & 1048575, i10);
    }

    public final void u(Object obj, int i10, Object obj2) {
        f2747q.putObject(obj, U(i10) & 1048575, obj2);
        s(obj, i10);
    }

    public final void v(Object obj, int i10, int i11, Object obj2) {
        f2747q.putObject(obj, U(i11) & 1048575, obj2);
        t(obj, i10, i11);
    }

    public final void w(gb gbVar, int i10, Object obj, int i11) {
        if (obj == null) {
            return;
        }
        n.g.a(l(i11));
        throw null;
    }

    public final boolean x(Object obj, Object obj2, int i10) {
        return y(obj, i10) == y(obj2, i10);
    }

    public final boolean y(Object obj, int i10) {
        int iR = R(i10);
        long j10 = iR & 1048575;
        if (j10 != 1048575) {
            return (ab.h(obj, j10) & (1 << (iR >>> 20))) != 0;
        }
        int iU = U(i10);
        long j11 = iU & 1048575;
        switch (T(iU)) {
            case 0:
                return Double.doubleToRawLongBits(ab.f(obj, j11)) != 0;
            case 1:
                return Float.floatToRawIntBits(ab.g(obj, j11)) != 0;
            case 2:
                return ab.i(obj, j11) != 0;
            case 3:
                return ab.i(obj, j11) != 0;
            case 4:
                return ab.h(obj, j11) != 0;
            case 5:
                return ab.i(obj, j11) != 0;
            case 6:
                return ab.h(obj, j11) != 0;
            case 7:
                return ab.B(obj, j11);
            case 8:
                Object objK = ab.k(obj, j11);
                if (objK instanceof String) {
                    return !((String) objK).isEmpty();
                }
                if (objK instanceof zzka) {
                    return !zzka.zzb.equals(objK);
                }
                throw new IllegalArgumentException();
            case 9:
                return ab.k(obj, j11) != null;
            case 10:
                return !zzka.zzb.equals(ab.k(obj, j11));
            case 11:
                return ab.h(obj, j11) != 0;
            case 12:
                return ab.h(obj, j11) != 0;
            case 13:
                return ab.h(obj, j11) != 0;
            case 14:
                return ab.i(obj, j11) != 0;
            case 15:
                return ab.h(obj, j11) != 0;
            case 16:
                return ab.i(obj, j11) != 0;
            case 17:
                return ab.k(obj, j11) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    public final boolean z(Object obj, int i10, int i11, int i12, int i13) {
        if (i11 == 1048575) {
            return y(obj, i10);
        }
        return (i12 & i13) != 0;
    }
}
