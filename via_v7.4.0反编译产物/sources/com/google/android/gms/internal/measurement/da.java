package com.google.android.gms.internal.measurement;

import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import sun.misc.Unsafe;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class da implements la {

    /* renamed from: p, reason: collision with root package name */
    public static final int[] f3447p = new int[0];

    /* renamed from: q, reason: collision with root package name */
    public static final Unsafe f3448q = ab.l();

    /* renamed from: a, reason: collision with root package name */
    public final int[] f3449a;

    /* renamed from: b, reason: collision with root package name */
    public final Object[] f3450b;

    /* renamed from: c, reason: collision with root package name */
    public final int f3451c;

    /* renamed from: d, reason: collision with root package name */
    public final int f3452d;

    /* renamed from: e, reason: collision with root package name */
    public final aa f3453e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f3454f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f3455g;

    /* renamed from: h, reason: collision with root package name */
    public final int[] f3456h;

    /* renamed from: i, reason: collision with root package name */
    public final int f3457i;

    /* renamed from: j, reason: collision with root package name */
    public final int f3458j;

    /* renamed from: k, reason: collision with root package name */
    public final p9 f3459k;

    /* renamed from: l, reason: collision with root package name */
    public final qa f3460l;

    /* renamed from: m, reason: collision with root package name */
    public final r8 f3461m;

    /* renamed from: n, reason: collision with root package name */
    public final fa f3462n;

    /* renamed from: o, reason: collision with root package name */
    public final v9 f3463o;

    public da(int[] iArr, Object[] objArr, int i10, int i11, aa aaVar, boolean z10, boolean z11, int[] iArr2, int i12, int i13, fa faVar, p9 p9Var, qa qaVar, r8 r8Var, v9 v9Var) {
        this.f3449a = iArr;
        this.f3450b = objArr;
        this.f3451c = i10;
        this.f3452d = i11;
        this.f3455g = z10;
        boolean z12 = false;
        if (r8Var != null && r8Var.c(aaVar)) {
            z12 = true;
        }
        this.f3454f = z12;
        this.f3456h = iArr2;
        this.f3457i = i12;
        this.f3458j = i13;
        this.f3462n = faVar;
        this.f3459k = p9Var;
        this.f3460l = qaVar;
        this.f3461m = r8Var;
        this.f3453e = aaVar;
        this.f3463o = v9Var;
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

    /* JADX WARN: Removed duplicated region for block: B:124:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x038e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
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
        int i24;
        boolean z10;
        ka kaVar;
        int i25;
        int i26;
        int iObjectFieldOffset;
        int iObjectFieldOffset2;
        String str;
        int i27;
        int i28;
        int i29;
        int i30;
        Field fieldO;
        char cCharAt9;
        int i31;
        int i32;
        Object obj;
        Field fieldO2;
        Object obj2;
        Field fieldO3;
        int i33;
        char cCharAt10;
        int i34;
        char cCharAt11;
        int i35;
        char cCharAt12;
        int i36;
        char cCharAt13;
        if (!(x9Var instanceof ka)) {
            n.g.a(x9Var);
            throw null;
        }
        ka kaVar2 = (ka) x9Var;
        int iB = kaVar2.b();
        String strC = kaVar2.c();
        int length = strC.length();
        int i37 = 0;
        int i38 = 55296;
        if (strC.charAt(0) >= '\ud800') {
            int i39 = 1;
            while (true) {
                i10 = i39 + 1;
                if (strC.charAt(i39) < '\ud800') {
                    break;
                }
                i39 = i10;
            }
        } else {
            i10 = 1;
        }
        int i40 = i10 + 1;
        int iCharAt2 = strC.charAt(i10);
        if (iCharAt2 >= 55296) {
            int i41 = iCharAt2 & 8191;
            int i42 = 13;
            while (true) {
                i36 = i40 + 1;
                cCharAt13 = strC.charAt(i40);
                if (cCharAt13 < '\ud800') {
                    break;
                }
                i41 |= (cCharAt13 & '\u1fff') << i42;
                i42 += 13;
                i40 = i36;
            }
            iCharAt2 = i41 | (cCharAt13 << i42);
            i40 = i36;
        }
        if (iCharAt2 == 0) {
            iArr = f3447p;
            i11 = 0;
            i14 = 0;
            iCharAt = 0;
            i13 = 0;
            i15 = 0;
            i12 = 0;
        } else {
            int i43 = i40 + 1;
            int iCharAt3 = strC.charAt(i40);
            if (iCharAt3 >= 55296) {
                int i44 = iCharAt3 & 8191;
                int i45 = 13;
                while (true) {
                    i23 = i43 + 1;
                    cCharAt8 = strC.charAt(i43);
                    if (cCharAt8 < '\ud800') {
                        break;
                    }
                    i44 |= (cCharAt8 & '\u1fff') << i45;
                    i45 += 13;
                    i43 = i23;
                }
                iCharAt3 = i44 | (cCharAt8 << i45);
                i43 = i23;
            }
            int i46 = i43 + 1;
            int iCharAt4 = strC.charAt(i43);
            if (iCharAt4 >= 55296) {
                int i47 = iCharAt4 & 8191;
                int i48 = 13;
                while (true) {
                    i22 = i46 + 1;
                    cCharAt7 = strC.charAt(i46);
                    if (cCharAt7 < '\ud800') {
                        break;
                    }
                    i47 |= (cCharAt7 & '\u1fff') << i48;
                    i48 += 13;
                    i46 = i22;
                }
                iCharAt4 = i47 | (cCharAt7 << i48);
                i46 = i22;
            }
            int i49 = i46 + 1;
            int iCharAt5 = strC.charAt(i46);
            if (iCharAt5 >= 55296) {
                int i50 = iCharAt5 & 8191;
                int i51 = 13;
                while (true) {
                    i21 = i49 + 1;
                    cCharAt6 = strC.charAt(i49);
                    if (cCharAt6 < '\ud800') {
                        break;
                    }
                    i50 |= (cCharAt6 & '\u1fff') << i51;
                    i51 += 13;
                    i49 = i21;
                }
                iCharAt5 = i50 | (cCharAt6 << i51);
                i49 = i21;
            }
            int i52 = i49 + 1;
            int iCharAt6 = strC.charAt(i49);
            if (iCharAt6 >= 55296) {
                int i53 = iCharAt6 & 8191;
                int i54 = 13;
                while (true) {
                    i20 = i52 + 1;
                    cCharAt5 = strC.charAt(i52);
                    if (cCharAt5 < '\ud800') {
                        break;
                    }
                    i53 |= (cCharAt5 & '\u1fff') << i54;
                    i54 += 13;
                    i52 = i20;
                }
                iCharAt6 = i53 | (cCharAt5 << i54);
                i52 = i20;
            }
            int i55 = i52 + 1;
            iCharAt = strC.charAt(i52);
            if (iCharAt >= 55296) {
                int i56 = iCharAt & 8191;
                int i57 = 13;
                while (true) {
                    i19 = i55 + 1;
                    cCharAt4 = strC.charAt(i55);
                    if (cCharAt4 < '\ud800') {
                        break;
                    }
                    i56 |= (cCharAt4 & '\u1fff') << i57;
                    i57 += 13;
                    i55 = i19;
                }
                iCharAt = i56 | (cCharAt4 << i57);
                i55 = i19;
            }
            int i58 = i55 + 1;
            int iCharAt7 = strC.charAt(i55);
            if (iCharAt7 >= 55296) {
                int i59 = iCharAt7 & 8191;
                int i60 = 13;
                while (true) {
                    i18 = i58 + 1;
                    cCharAt3 = strC.charAt(i58);
                    if (cCharAt3 < '\ud800') {
                        break;
                    }
                    i59 |= (cCharAt3 & '\u1fff') << i60;
                    i60 += 13;
                    i58 = i18;
                }
                iCharAt7 = i59 | (cCharAt3 << i60);
                i58 = i18;
            }
            int i61 = i58 + 1;
            int iCharAt8 = strC.charAt(i58);
            if (iCharAt8 >= 55296) {
                int i62 = iCharAt8 & 8191;
                int i63 = 13;
                while (true) {
                    i17 = i61 + 1;
                    cCharAt2 = strC.charAt(i61);
                    if (cCharAt2 < '\ud800') {
                        break;
                    }
                    i62 |= (cCharAt2 & '\u1fff') << i63;
                    i63 += 13;
                    i61 = i17;
                }
                iCharAt8 = i62 | (cCharAt2 << i63);
                i61 = i17;
            }
            int i64 = i61 + 1;
            int iCharAt9 = strC.charAt(i61);
            if (iCharAt9 >= 55296) {
                int i65 = iCharAt9 & 8191;
                int i66 = i64;
                int i67 = 13;
                while (true) {
                    i16 = i66 + 1;
                    cCharAt = strC.charAt(i66);
                    if (cCharAt < '\ud800') {
                        break;
                    }
                    i65 |= (cCharAt & '\u1fff') << i67;
                    i67 += 13;
                    i66 = i16;
                }
                iCharAt9 = i65 | (cCharAt << i67);
                i64 = i16;
            }
            int i68 = iCharAt9 + iCharAt7 + iCharAt8;
            int i69 = iCharAt3 + iCharAt3 + iCharAt4;
            int[] iArr2 = new int[i68];
            i37 = iCharAt3;
            iArr = iArr2;
            i11 = iCharAt7;
            i12 = iCharAt9;
            i40 = i64;
            i13 = iCharAt5;
            i14 = i69;
            i15 = iCharAt6;
        }
        Unsafe unsafe = f3448q;
        Object[] objArrD = kaVar2.d();
        Class<?> cls2 = kaVar2.zza().getClass();
        int i70 = i12 + i11;
        int i71 = iCharAt + iCharAt;
        int[] iArr3 = new int[iCharAt * 3];
        Object[] objArr = new Object[i71];
        int i72 = i12;
        int i73 = i70;
        int i74 = 0;
        int i75 = 0;
        while (true) {
            if (iB == 2) {
                i24 = i74;
                z10 = true;
            } else {
                i24 = i74;
                z10 = false;
            }
            if (i40 >= length) {
                return new da(iArr3, objArr, i13, i15, kaVar2.zza(), z10, false, iArr, i12, i70, faVar, p9Var, qaVar, r8Var, v9Var);
            }
            int i76 = i40 + 1;
            int iCharAt10 = strC.charAt(i40);
            if (iCharAt10 >= i38) {
                int i77 = iCharAt10 & 8191;
                int i78 = i76;
                int i79 = 13;
                while (true) {
                    i35 = i78 + 1;
                    cCharAt12 = strC.charAt(i78);
                    kaVar = kaVar2;
                    if (cCharAt12 < '\ud800') {
                        break;
                    }
                    i77 |= (cCharAt12 & '\u1fff') << i79;
                    i79 += 13;
                    i78 = i35;
                    kaVar2 = kaVar;
                }
                iCharAt10 = i77 | (cCharAt12 << i79);
                i25 = i35;
            } else {
                kaVar = kaVar2;
                i25 = i76;
            }
            int i80 = i25 + 1;
            int iCharAt11 = strC.charAt(i25);
            int i81 = iB;
            char c10 = '\ud800';
            if (iCharAt11 >= 55296) {
                int i82 = iCharAt11 & 8191;
                int i83 = 13;
                while (true) {
                    i34 = i80 + 1;
                    cCharAt11 = strC.charAt(i80);
                    if (cCharAt11 < c10) {
                        break;
                    }
                    i82 |= (cCharAt11 & '\u1fff') << i83;
                    i83 += 13;
                    i80 = i34;
                    c10 = '\ud800';
                }
                iCharAt11 = i82 | (cCharAt11 << i83);
                i80 = i34;
            }
            if ((iCharAt11 & 1024) != 0) {
                iArr[i24] = i75;
                i24++;
            }
            int i84 = iCharAt11 & 255;
            int i85 = length;
            if (i84 >= 51) {
                int i86 = i80 + 1;
                int iCharAt12 = strC.charAt(i80);
                char c11 = '\ud800';
                if (iCharAt12 >= 55296) {
                    int i87 = iCharAt12 & 8191;
                    int i88 = i86;
                    int i89 = 13;
                    while (true) {
                        i33 = i88 + 1;
                        cCharAt10 = strC.charAt(i88);
                        if (cCharAt10 < c11) {
                            break;
                        }
                        i87 |= (cCharAt10 & '\u1fff') << i89;
                        i89 += 13;
                        i88 = i33;
                        c11 = '\ud800';
                    }
                    iCharAt12 = i87 | (cCharAt10 << i89);
                    i31 = i33;
                } else {
                    i31 = i86;
                }
                int i90 = i31;
                int i91 = i84 - 51;
                i26 = i37;
                if (i91 == 9 || i91 == 17) {
                    int i92 = i75 / 3;
                    i32 = i14 + 1;
                    objArr[i92 + i92 + 1] = objArrD[i14];
                } else {
                    if (i91 == 12 && !z10) {
                        int i93 = i75 / 3;
                        i32 = i14 + 1;
                        objArr[i93 + i93 + 1] = objArrD[i14];
                    }
                    int i94 = iCharAt12 + iCharAt12;
                    obj = objArrD[i94];
                    if (obj instanceof Field) {
                        fieldO2 = o(cls2, (String) obj);
                        objArrD[i94] = fieldO2;
                    } else {
                        fieldO2 = (Field) obj;
                    }
                    int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldO2);
                    int i95 = i94 + 1;
                    obj2 = objArrD[i95];
                    if (obj2 instanceof Field) {
                        fieldO3 = o(cls2, (String) obj2);
                        objArrD[i95] = fieldO3;
                    } else {
                        fieldO3 = (Field) obj2;
                    }
                    iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldO3);
                    i29 = iObjectFieldOffset3;
                    str = strC;
                    i80 = i90;
                    i28 = 0;
                }
                i14 = i32;
                int i942 = iCharAt12 + iCharAt12;
                obj = objArrD[i942];
                if (obj instanceof Field) {
                }
                int iObjectFieldOffset32 = (int) unsafe.objectFieldOffset(fieldO2);
                int i952 = i942 + 1;
                obj2 = objArrD[i952];
                if (obj2 instanceof Field) {
                }
                iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldO3);
                i29 = iObjectFieldOffset32;
                str = strC;
                i80 = i90;
                i28 = 0;
            } else {
                i26 = i37;
                int i96 = i14 + 1;
                Field fieldO4 = o(cls2, (String) objArrD[i14]);
                if (i84 == 9 || i84 == 17) {
                    int i97 = i75 / 3;
                    objArr[i97 + i97 + 1] = fieldO4.getType();
                } else {
                    if (i84 == 27 || i84 == 49) {
                        int i98 = i75 / 3;
                        i14 += 2;
                        objArr[i98 + i98 + 1] = objArrD[i96];
                    } else if (i84 == 12 || i84 == 30 || i84 == 44) {
                        if (!z10) {
                            int i99 = i75 / 3;
                            i14 += 2;
                            objArr[i99 + i99 + 1] = objArrD[i96];
                        }
                    } else if (i84 == 50) {
                        int i100 = i72 + 1;
                        iArr[i72] = i75;
                        int i101 = i75 / 3;
                        int i102 = i14 + 2;
                        int i103 = i101 + i101;
                        objArr[i103] = objArrD[i96];
                        if ((iCharAt11 & 2048) != 0) {
                            objArr[i103 + 1] = objArrD[i102];
                            i14 += 3;
                        } else {
                            i14 = i102;
                        }
                        i72 = i100;
                    }
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldO4);
                    iObjectFieldOffset2 = 1048575;
                    if ((iCharAt11 & 4096) == 4096 || i84 > 17) {
                        str = strC;
                        i27 = 0;
                    } else {
                        int i104 = i80 + 1;
                        int iCharAt13 = strC.charAt(i80);
                        if (iCharAt13 >= 55296) {
                            int i105 = iCharAt13 & 8191;
                            int i106 = 13;
                            while (true) {
                                i30 = i104 + 1;
                                cCharAt9 = strC.charAt(i104);
                                if (cCharAt9 < '\ud800') {
                                    break;
                                }
                                i105 |= (cCharAt9 & '\u1fff') << i106;
                                i106 += 13;
                                i104 = i30;
                            }
                            iCharAt13 = i105 | (cCharAt9 << i106);
                        } else {
                            i30 = i104;
                        }
                        int i107 = i26 + i26 + (iCharAt13 / 32);
                        Object obj3 = objArrD[i107];
                        str = strC;
                        if (obj3 instanceof Field) {
                            fieldO = (Field) obj3;
                        } else {
                            fieldO = o(cls2, (String) obj3);
                            objArrD[i107] = fieldO;
                        }
                        i27 = iCharAt13 % 32;
                        iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldO);
                        i80 = i30;
                    }
                    if (i84 >= 18 && i84 <= 49) {
                        iArr[i73] = iObjectFieldOffset;
                        i73++;
                    }
                    i28 = i27;
                    i29 = iObjectFieldOffset;
                }
                i14 = i96;
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldO4);
                iObjectFieldOffset2 = 1048575;
                if ((iCharAt11 & 4096) == 4096) {
                    str = strC;
                    i27 = 0;
                    if (i84 >= 18) {
                        iArr[i73] = iObjectFieldOffset;
                        i73++;
                    }
                    i28 = i27;
                    i29 = iObjectFieldOffset;
                }
            }
            int i108 = i75 + 1;
            iArr3[i75] = iCharAt10;
            int i109 = i75 + 2;
            iArr3[i108] = ((iCharAt11 & 256) != 0 ? 268435456 : 0) | ((iCharAt11 & 512) != 0 ? 536870912 : 0) | (i84 << 20) | i29;
            i75 += 3;
            iArr3[i109] = (i28 << 20) | iObjectFieldOffset2;
            i40 = i80;
            i74 = i24;
            iB = i81;
            length = i85;
            kaVar2 = kaVar;
            strC = str;
            i37 = i26;
            i38 = 55296;
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

    /* JADX WARN: Failed to find 'out' block for switch in B:23:0x0091. Please report as an issue. */
    public final int F(Object obj, byte[] bArr, int i10, int i11, int i12, w7 w7Var) throws zzll {
        int i13;
        Unsafe unsafe;
        da daVar;
        Object obj2;
        w7 w7Var2;
        int i14;
        int i15;
        int i16;
        int i17;
        q8 q8Var;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        w7 w7Var3;
        int i23;
        Unsafe unsafe2;
        int i24;
        int i25;
        int i26;
        byte[] bArr2;
        Unsafe unsafe3;
        byte[] bArr3;
        Object obj3;
        w7 w7Var4;
        int i27;
        byte[] bArr4;
        int iM;
        byte[] bArr5;
        Unsafe unsafe4;
        int i28;
        w7 w7Var5;
        da daVar2 = this;
        Object obj4 = obj;
        byte[] bArr6 = bArr;
        int i29 = i11;
        w7 w7Var6 = w7Var;
        p(obj4);
        Unsafe unsafe5 = f3448q;
        int i30 = -1;
        int iJ = i10;
        int i31 = -1;
        int i32 = 0;
        int i33 = 1048575;
        int i34 = 0;
        int i35 = 0;
        while (true) {
            if (iJ < i29) {
                int iK = iJ + 1;
                int i36 = bArr6[iJ];
                if (i36 < 0) {
                    iK = x7.k(i36, bArr6, iK, w7Var6);
                    i36 = w7Var6.f3864a;
                }
                int i37 = iK;
                i35 = i36;
                int i38 = i35 >>> 3;
                int iQ = i38 > i31 ? daVar2.Q(i38, i32 / 3) : daVar2.P(i38);
                if (iQ == i30) {
                    w7Var2 = w7Var6;
                    i14 = i35;
                    i15 = i37;
                    i13 = i33;
                    unsafe = unsafe5;
                    i31 = i38;
                    i32 = 0;
                    daVar = daVar2;
                    obj2 = obj4;
                } else {
                    int i39 = i35 & 7;
                    int[] iArr = daVar2.f3449a;
                    int i40 = iArr[iQ + 1];
                    int iT = T(i40);
                    long j10 = i40 & 1048575;
                    if (iT <= 17) {
                        int i41 = iArr[iQ + 2];
                        int i42 = 1 << (i41 >>> 20);
                        int i43 = i41 & 1048575;
                        if (i43 != i33) {
                            i21 = i40;
                            if (i33 != 1048575) {
                                unsafe5.putInt(obj4, i33, i34);
                            }
                            i22 = i43;
                            i34 = unsafe5.getInt(obj4, i43);
                        } else {
                            i21 = i40;
                            i22 = i33;
                        }
                        switch (iT) {
                            case 0:
                                w7Var3 = w7Var6;
                                i23 = iQ;
                                unsafe2 = unsafe5;
                                i24 = i34;
                                i25 = i35;
                                i26 = i37;
                                bArr2 = bArr;
                                if (i39 == 1) {
                                    ab.t(obj4, j10, Double.longBitsToDouble(x7.p(bArr2, i26)));
                                    iJ = i26 + 8;
                                    i34 = i24 | i42;
                                    i35 = i25;
                                    i29 = i11;
                                    bArr6 = bArr2;
                                    i32 = i23;
                                    i31 = i38;
                                    unsafe5 = unsafe2;
                                    w7Var6 = w7Var3;
                                    i33 = i22;
                                    i30 = -1;
                                    break;
                                } else {
                                    obj2 = obj4;
                                    i15 = i26;
                                    unsafe = unsafe2;
                                    i34 = i24;
                                    w7Var2 = w7Var3;
                                    i13 = i22;
                                    i32 = i23;
                                    i31 = i38;
                                    i14 = i25;
                                    daVar = daVar2;
                                    break;
                                }
                            case 1:
                                w7Var3 = w7Var6;
                                i23 = iQ;
                                unsafe2 = unsafe5;
                                i24 = i34;
                                i25 = i35;
                                i26 = i37;
                                bArr2 = bArr;
                                if (i39 == 5) {
                                    ab.u(obj4, j10, Float.intBitsToFloat(x7.b(bArr2, i26)));
                                    iJ = i26 + 4;
                                    i34 = i24 | i42;
                                    i35 = i25;
                                    i29 = i11;
                                    bArr6 = bArr2;
                                    i32 = i23;
                                    i31 = i38;
                                    unsafe5 = unsafe2;
                                    w7Var6 = w7Var3;
                                    i33 = i22;
                                    i30 = -1;
                                    break;
                                } else {
                                    obj2 = obj4;
                                    i15 = i26;
                                    unsafe = unsafe2;
                                    i34 = i24;
                                    w7Var2 = w7Var3;
                                    i13 = i22;
                                    i32 = i23;
                                    i31 = i38;
                                    i14 = i25;
                                    daVar = daVar2;
                                    break;
                                }
                            case 2:
                            case WebSettingsBoundaryInterface.AttributionBehavior.APP_SOURCE_AND_APP_TRIGGER /* 3 */:
                                w7Var3 = w7Var6;
                                i23 = iQ;
                                unsafe3 = unsafe5;
                                i26 = i37;
                                bArr2 = bArr;
                                if (i39 == 0) {
                                    int iM2 = x7.m(bArr2, i26, w7Var3);
                                    Object obj5 = obj4;
                                    unsafe3.putLong(obj5, j10, w7Var3.f3865b);
                                    unsafe2 = unsafe3;
                                    obj4 = obj5;
                                    i34 |= i42;
                                    i29 = i11;
                                    iJ = iM2;
                                    bArr6 = bArr2;
                                    i32 = i23;
                                    i31 = i38;
                                    unsafe5 = unsafe2;
                                    w7Var6 = w7Var3;
                                    i33 = i22;
                                    i30 = -1;
                                    break;
                                } else {
                                    unsafe2 = unsafe3;
                                    i24 = i34;
                                    i25 = i35;
                                    obj2 = obj4;
                                    i15 = i26;
                                    unsafe = unsafe2;
                                    i34 = i24;
                                    w7Var2 = w7Var3;
                                    i13 = i22;
                                    i32 = i23;
                                    i31 = i38;
                                    i14 = i25;
                                    daVar = daVar2;
                                    break;
                                }
                            case 4:
                            case 11:
                                w7Var3 = w7Var6;
                                i23 = iQ;
                                unsafe3 = unsafe5;
                                i26 = i37;
                                bArr3 = bArr;
                                if (i39 == 0) {
                                    iJ = x7.j(bArr3, i26, w7Var3);
                                    unsafe3.putInt(obj4, j10, w7Var3.f3864a);
                                    i34 |= i42;
                                    byte[] bArr7 = bArr3;
                                    unsafe5 = unsafe3;
                                    bArr6 = bArr7;
                                    i29 = i11;
                                    w7Var6 = w7Var3;
                                    i33 = i22;
                                    i32 = i23;
                                    i31 = i38;
                                    i30 = -1;
                                    break;
                                } else {
                                    unsafe2 = unsafe3;
                                    i24 = i34;
                                    i25 = i35;
                                    obj2 = obj4;
                                    i15 = i26;
                                    unsafe = unsafe2;
                                    i34 = i24;
                                    w7Var2 = w7Var3;
                                    i13 = i22;
                                    i32 = i23;
                                    i31 = i38;
                                    i14 = i25;
                                    daVar = daVar2;
                                    break;
                                }
                            case 5:
                            case 14:
                                Object obj6 = obj4;
                                i23 = iQ;
                                if (i39 == 1) {
                                    Unsafe unsafe6 = unsafe5;
                                    bArr3 = bArr;
                                    w7Var3 = w7Var;
                                    unsafe6.putLong(obj6, j10, x7.p(bArr, i37));
                                    unsafe3 = unsafe6;
                                    obj4 = obj6;
                                    iJ = i37 + 8;
                                    i34 |= i42;
                                    byte[] bArr72 = bArr3;
                                    unsafe5 = unsafe3;
                                    bArr6 = bArr72;
                                    i29 = i11;
                                    w7Var6 = w7Var3;
                                    i33 = i22;
                                    i32 = i23;
                                    i31 = i38;
                                    i30 = -1;
                                    break;
                                } else {
                                    obj4 = obj6;
                                    w7Var3 = w7Var;
                                    unsafe2 = unsafe5;
                                    i24 = i34;
                                    i25 = i35;
                                    i26 = i37;
                                    obj2 = obj4;
                                    i15 = i26;
                                    unsafe = unsafe2;
                                    i34 = i24;
                                    w7Var2 = w7Var3;
                                    i13 = i22;
                                    i32 = i23;
                                    i31 = i38;
                                    i14 = i25;
                                    daVar = daVar2;
                                    break;
                                }
                            case 6:
                            case 13:
                                Object obj7 = obj4;
                                i23 = iQ;
                                if (i39 == 5) {
                                    unsafe5.putInt(obj7, j10, x7.b(bArr, i37));
                                    iJ = i37 + 4;
                                    i34 |= i42;
                                    i29 = i11;
                                    w7Var6 = w7Var;
                                    bArr6 = bArr;
                                    obj4 = obj7;
                                    i33 = i22;
                                    i32 = i23;
                                    i31 = i38;
                                    i30 = -1;
                                    break;
                                } else {
                                    i26 = i37;
                                    unsafe2 = unsafe5;
                                    i24 = i34;
                                    i25 = i35;
                                    obj4 = obj7;
                                    w7Var3 = w7Var;
                                    obj2 = obj4;
                                    i15 = i26;
                                    unsafe = unsafe2;
                                    i34 = i24;
                                    w7Var2 = w7Var3;
                                    i13 = i22;
                                    i32 = i23;
                                    i31 = i38;
                                    i14 = i25;
                                    daVar = daVar2;
                                    break;
                                }
                            case 7:
                                obj3 = obj4;
                                w7Var4 = w7Var6;
                                i23 = iQ;
                                i27 = i37;
                                bArr4 = bArr;
                                if (i39 == 0) {
                                    iM = x7.m(bArr4, i27, w7Var4);
                                    ab.r(obj3, j10, w7Var4.f3865b != 0);
                                    i34 |= i42;
                                    i29 = i11;
                                    w7Var6 = w7Var4;
                                    i32 = i23;
                                    i31 = i38;
                                    iJ = iM;
                                    bArr6 = bArr4;
                                    obj4 = obj3;
                                    i33 = i22;
                                    i30 = -1;
                                    break;
                                } else {
                                    i26 = i27;
                                    unsafe2 = unsafe5;
                                    i24 = i34;
                                    i25 = i35;
                                    obj4 = obj3;
                                    w7Var3 = w7Var4;
                                    obj2 = obj4;
                                    i15 = i26;
                                    unsafe = unsafe2;
                                    i34 = i24;
                                    w7Var2 = w7Var3;
                                    i13 = i22;
                                    i32 = i23;
                                    i31 = i38;
                                    i14 = i25;
                                    daVar = daVar2;
                                    break;
                                }
                            case 8:
                                obj3 = obj4;
                                w7Var4 = w7Var6;
                                i23 = iQ;
                                i27 = i37;
                                bArr4 = bArr;
                                if (i39 == 2) {
                                    iM = (i21 & 536870912) == 0 ? x7.g(bArr4, i27, w7Var4) : x7.h(bArr4, i27, w7Var4);
                                    unsafe5.putObject(obj3, j10, w7Var4.f3866c);
                                    i34 |= i42;
                                    i29 = i11;
                                    w7Var6 = w7Var4;
                                    i32 = i23;
                                    i31 = i38;
                                    iJ = iM;
                                    bArr6 = bArr4;
                                    obj4 = obj3;
                                    i33 = i22;
                                    i30 = -1;
                                    break;
                                } else {
                                    i26 = i27;
                                    unsafe2 = unsafe5;
                                    i24 = i34;
                                    i25 = i35;
                                    obj4 = obj3;
                                    w7Var3 = w7Var4;
                                    obj2 = obj4;
                                    i15 = i26;
                                    unsafe = unsafe2;
                                    i34 = i24;
                                    w7Var2 = w7Var3;
                                    i13 = i22;
                                    i32 = i23;
                                    i31 = i38;
                                    i14 = i25;
                                    daVar = daVar2;
                                    break;
                                }
                            case 9:
                                i23 = iQ;
                                Unsafe unsafe7 = unsafe5;
                                w7 w7Var7 = w7Var6;
                                if (i39 == 2) {
                                    Object obj8 = obj4;
                                    Object objM = daVar2.m(obj8, i23);
                                    obj3 = obj8;
                                    unsafe5 = unsafe7;
                                    iM = x7.o(objM, daVar2.k(i23), bArr, i37, i11, w7Var7);
                                    bArr4 = bArr;
                                    w7Var4 = w7Var7;
                                    daVar2.u(obj3, i23, objM);
                                    i34 |= i42;
                                    i29 = i11;
                                    w7Var6 = w7Var4;
                                    i32 = i23;
                                    i31 = i38;
                                    iJ = iM;
                                    bArr6 = bArr4;
                                    obj4 = obj3;
                                    i33 = i22;
                                    i30 = -1;
                                    break;
                                } else {
                                    obj3 = obj4;
                                    bArr4 = bArr;
                                    unsafe5 = unsafe7;
                                    i27 = i37;
                                    w7Var4 = w7Var7;
                                    i26 = i27;
                                    unsafe2 = unsafe5;
                                    i24 = i34;
                                    i25 = i35;
                                    obj4 = obj3;
                                    w7Var3 = w7Var4;
                                    obj2 = obj4;
                                    i15 = i26;
                                    unsafe = unsafe2;
                                    i34 = i24;
                                    w7Var2 = w7Var3;
                                    i13 = i22;
                                    i32 = i23;
                                    i31 = i38;
                                    i14 = i25;
                                    daVar = daVar2;
                                    break;
                                }
                            case 10:
                                bArr5 = bArr;
                                i23 = iQ;
                                unsafe4 = unsafe5;
                                i28 = i37;
                                w7Var5 = w7Var6;
                                if (i39 == 2) {
                                    iJ = x7.a(bArr5, i28, w7Var5);
                                    unsafe4.putObject(obj4, j10, w7Var5.f3866c);
                                    i34 |= i42;
                                    i29 = i11;
                                    w7Var6 = w7Var5;
                                    i32 = i23;
                                    i31 = i38;
                                    unsafe5 = unsafe4;
                                    bArr6 = bArr5;
                                    i33 = i22;
                                    i30 = -1;
                                    break;
                                } else {
                                    w7Var3 = w7Var5;
                                    unsafe2 = unsafe4;
                                    i26 = i28;
                                    i24 = i34;
                                    i25 = i35;
                                    obj2 = obj4;
                                    i15 = i26;
                                    unsafe = unsafe2;
                                    i34 = i24;
                                    w7Var2 = w7Var3;
                                    i13 = i22;
                                    i32 = i23;
                                    i31 = i38;
                                    i14 = i25;
                                    daVar = daVar2;
                                    break;
                                }
                            case 12:
                                bArr5 = bArr;
                                i23 = iQ;
                                unsafe4 = unsafe5;
                                i28 = i37;
                                w7Var5 = w7Var6;
                                if (i39 != 0) {
                                    w7Var3 = w7Var5;
                                    unsafe2 = unsafe4;
                                    i26 = i28;
                                    i24 = i34;
                                    i25 = i35;
                                    obj2 = obj4;
                                    i15 = i26;
                                    unsafe = unsafe2;
                                    i34 = i24;
                                    w7Var2 = w7Var3;
                                    i13 = i22;
                                    i32 = i23;
                                    i31 = i38;
                                    i14 = i25;
                                    daVar = daVar2;
                                    break;
                                } else {
                                    iJ = x7.j(bArr5, i28, w7Var5);
                                    int i44 = w7Var5.f3864a;
                                    d9 d9VarJ = daVar2.j(i23);
                                    if (d9VarJ == null || d9VarJ.i(i44)) {
                                        unsafe4.putInt(obj4, j10, i44);
                                        i34 |= i42;
                                        i29 = i11;
                                        w7Var6 = w7Var5;
                                        i32 = i23;
                                        i31 = i38;
                                        unsafe5 = unsafe4;
                                        bArr6 = bArr5;
                                        i33 = i22;
                                        i30 = -1;
                                        break;
                                    } else {
                                        G(obj4).j(i35, Long.valueOf(i44));
                                        i29 = i11;
                                        w7Var6 = w7Var5;
                                        i32 = i23;
                                        i31 = i38;
                                        unsafe5 = unsafe4;
                                        bArr6 = bArr5;
                                        i33 = i22;
                                        i30 = -1;
                                    }
                                }
                                break;
                            case 15:
                                bArr5 = bArr;
                                i23 = iQ;
                                unsafe4 = unsafe5;
                                i28 = i37;
                                w7Var5 = w7Var6;
                                if (i39 == 0) {
                                    iJ = x7.j(bArr5, i28, w7Var5);
                                    unsafe4.putInt(obj4, j10, j8.a(w7Var5.f3864a));
                                    i34 |= i42;
                                    i29 = i11;
                                    w7Var6 = w7Var5;
                                    i32 = i23;
                                    i31 = i38;
                                    unsafe5 = unsafe4;
                                    bArr6 = bArr5;
                                    i33 = i22;
                                    i30 = -1;
                                    break;
                                } else {
                                    w7Var3 = w7Var5;
                                    unsafe2 = unsafe4;
                                    i26 = i28;
                                    i24 = i34;
                                    i25 = i35;
                                    obj2 = obj4;
                                    i15 = i26;
                                    unsafe = unsafe2;
                                    i34 = i24;
                                    w7Var2 = w7Var3;
                                    i13 = i22;
                                    i32 = i23;
                                    i31 = i38;
                                    i14 = i25;
                                    daVar = daVar2;
                                    break;
                                }
                            case 16:
                                bArr5 = bArr;
                                w7 w7Var8 = w7Var6;
                                i23 = iQ;
                                i28 = i37;
                                if (i39 == 0) {
                                    int iM3 = x7.m(bArr5, i28, w7Var8);
                                    long jB = j8.b(w7Var8.f3865b);
                                    Object obj9 = obj4;
                                    Unsafe unsafe8 = unsafe5;
                                    w7Var5 = w7Var8;
                                    unsafe8.putLong(obj9, j10, jB);
                                    unsafe4 = unsafe8;
                                    obj4 = obj9;
                                    i34 |= i42;
                                    i29 = i11;
                                    iJ = iM3;
                                    w7Var6 = w7Var5;
                                    i32 = i23;
                                    i31 = i38;
                                    unsafe5 = unsafe4;
                                    bArr6 = bArr5;
                                    i33 = i22;
                                    i30 = -1;
                                    break;
                                } else {
                                    Unsafe unsafe9 = unsafe5;
                                    w7Var5 = w7Var8;
                                    unsafe4 = unsafe9;
                                    w7Var3 = w7Var5;
                                    unsafe2 = unsafe4;
                                    i26 = i28;
                                    i24 = i34;
                                    i25 = i35;
                                    obj2 = obj4;
                                    i15 = i26;
                                    unsafe = unsafe2;
                                    i34 = i24;
                                    w7Var2 = w7Var3;
                                    i13 = i22;
                                    i32 = i23;
                                    i31 = i38;
                                    i14 = i25;
                                    daVar = daVar2;
                                    break;
                                }
                            default:
                                if (i39 == 3) {
                                    Object objM2 = daVar2.m(obj4, iQ);
                                    w7 w7Var9 = w7Var6;
                                    i23 = iQ;
                                    iJ = x7.n(objM2, daVar2.k(iQ), bArr, i37, i11, (i38 << 3) | 4, w7Var9);
                                    daVar2.u(obj4, i23, objM2);
                                    i34 |= i42;
                                    i29 = i11;
                                    w7Var6 = w7Var9;
                                    bArr6 = bArr;
                                    i33 = i22;
                                    i32 = i23;
                                    i31 = i38;
                                    i30 = -1;
                                    break;
                                } else {
                                    i23 = iQ;
                                    w7Var3 = w7Var6;
                                    unsafe2 = unsafe5;
                                    i24 = i34;
                                    i25 = i35;
                                    i26 = i37;
                                    obj2 = obj4;
                                    i15 = i26;
                                    unsafe = unsafe2;
                                    i34 = i24;
                                    w7Var2 = w7Var3;
                                    i13 = i22;
                                    i32 = i23;
                                    i31 = i38;
                                    i14 = i25;
                                    daVar = daVar2;
                                    break;
                                }
                        }
                    } else {
                        Unsafe unsafe10 = unsafe5;
                        int i45 = i34;
                        int i46 = iQ;
                        if (iT != 27) {
                            i18 = i37;
                            if (iT <= 49) {
                                unsafe = unsafe10;
                                i19 = i45;
                                i13 = i33;
                                int iO = daVar2.O(obj, bArr, i18, i11, i35, i38, i39, i46, i40, iT, j10, w7Var);
                                i35 = i35;
                                i46 = i46;
                                if (iO != i18) {
                                    daVar2 = this;
                                    obj4 = obj;
                                    bArr6 = bArr;
                                    i29 = i11;
                                    w7Var6 = w7Var;
                                    iJ = iO;
                                    i31 = i38;
                                } else {
                                    daVar = this;
                                    i15 = iO;
                                    i31 = i38;
                                    i32 = i46;
                                    i14 = i35;
                                    i34 = i19;
                                    obj2 = obj;
                                    w7Var2 = w7Var;
                                }
                            } else {
                                i35 = i35;
                                unsafe = unsafe10;
                                i19 = i45;
                                i20 = i38;
                                i13 = i33;
                                if (iT != 50) {
                                    w7Var2 = w7Var;
                                    i31 = i20;
                                    i14 = i35;
                                    int iN = N(obj, bArr, i18, i11, i14, i31, i39, i40, iT, j10, i46, w7Var2);
                                    daVar = this;
                                    obj2 = obj;
                                    i46 = i46;
                                    if (iN != i18) {
                                        i35 = i14;
                                        w7Var6 = w7Var2;
                                        bArr6 = bArr;
                                        i29 = i11;
                                        iJ = iN;
                                        daVar2 = daVar;
                                        obj4 = obj2;
                                    } else {
                                        i15 = iN;
                                        i32 = i46;
                                        i34 = i19;
                                    }
                                } else if (i39 == 2) {
                                    int iM4 = M(obj, bArr, i18, i11, i46, j10, w7Var);
                                    if (iM4 != i18) {
                                        daVar2 = this;
                                        obj4 = obj;
                                        bArr6 = bArr;
                                        i29 = i11;
                                        w7Var6 = w7Var;
                                        iJ = iM4;
                                        i31 = i20;
                                    } else {
                                        daVar = this;
                                        obj2 = obj;
                                        i15 = iM4;
                                        i31 = i20;
                                        i32 = i46;
                                        i14 = i35;
                                        i34 = i19;
                                        w7Var2 = w7Var;
                                    }
                                }
                            }
                            i32 = i46;
                            i33 = i13;
                            i34 = i19;
                            unsafe5 = unsafe;
                            i30 = -1;
                        } else if (i39 == 2) {
                            g9 g9VarJ = (g9) unsafe10.getObject(obj4, j10);
                            if (!g9VarJ.b()) {
                                int size = g9VarJ.size();
                                g9VarJ = g9VarJ.j(size == 0 ? 10 : size + size);
                                unsafe10.putObject(obj4, j10, g9VarJ);
                            }
                            unsafe5 = unsafe10;
                            int iE = x7.e(daVar2.k(i46), i35, bArr, i37, i11, g9VarJ, w7Var);
                            bArr6 = bArr;
                            i29 = i11;
                            iJ = iE;
                            i35 = i35;
                            i34 = i45;
                            i32 = i46;
                            i31 = i38;
                            i30 = -1;
                            obj4 = obj;
                            w7Var6 = w7Var;
                        } else {
                            i35 = i35;
                            i18 = i37;
                            i13 = i33;
                            unsafe = unsafe10;
                            i19 = i45;
                            i20 = i38;
                        }
                        daVar = this;
                        obj2 = obj;
                        i15 = i18;
                        i31 = i20;
                        i32 = i46;
                        i14 = i35;
                        i34 = i19;
                        w7Var2 = w7Var;
                    }
                }
                if (i14 != i12 || i12 == 0) {
                    if (!daVar.f3454f || (q8Var = w7Var2.f3867d) == q8.f3704c) {
                        i16 = i14;
                        i17 = x7.i(i16, bArr, i15, i11, G(obj2), w7Var);
                        i29 = i11;
                    } else {
                        q8Var.b(daVar.f3453e, i31);
                        i16 = i14;
                        i17 = x7.i(i16, bArr, i15, i11, G(obj2), w7Var2);
                        i29 = i11;
                    }
                    iJ = i17;
                    bArr6 = bArr;
                    i35 = i16;
                    daVar2 = daVar;
                    obj4 = obj2;
                    i33 = i13;
                    unsafe5 = unsafe;
                    i30 = -1;
                    w7Var6 = w7Var;
                } else {
                    i29 = i11;
                    iJ = i15;
                    i35 = i14;
                }
            } else {
                i13 = i33;
                unsafe = unsafe5;
                daVar = daVar2;
                obj2 = obj4;
            }
        }
        int i47 = i13;
        if (i47 != 1048575) {
            unsafe.putInt(obj2, i47, i34);
        }
        for (int i48 = daVar.f3457i; i48 < daVar.f3458j; i48++) {
            int i49 = daVar.f3456h[i48];
            int i50 = daVar.f3449a[i49];
            Object objK = ab.k(obj2, daVar.U(i49) & 1048575);
            if (objK != null && daVar.j(i49) != null) {
                n.g.a(daVar.l(i49));
                throw null;
            }
        }
        if (i12 == 0) {
            if (iJ != i29) {
                throw zzll.zze();
            }
        } else if (iJ > i29 || i35 != i12) {
            throw zzll.zze();
        }
        return iJ;
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
        Unsafe unsafe = f3448q;
        int i11 = 0;
        int i12 = 1048575;
        int i13 = 0;
        for (int i14 = 0; i14 < this.f3449a.length; i14 += 3) {
            int iU = U(i14);
            int[] iArr = this.f3449a;
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
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if ((i13 & i10) != 0) {
                        iY2 = m8.y(i15 << 3);
                        iJ = iY2 + 4;
                        i11 += iJ;
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if ((i13 & i10) != 0) {
                        iZ = m8.z(unsafe.getLong(obj, j10));
                        iY3 = m8.y(i15 << 3);
                        i11 += iY3 + iZ;
                        break;
                    } else {
                        break;
                    }
                case WebSettingsBoundaryInterface.AttributionBehavior.APP_SOURCE_AND_APP_TRIGGER /* 3 */:
                    if ((i13 & i10) != 0) {
                        iZ = m8.z(unsafe.getLong(obj, j10));
                        iY3 = m8.y(i15 << 3);
                        i11 += iY3 + iZ;
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if ((i13 & i10) != 0) {
                        iZ = m8.v(unsafe.getInt(obj, j10));
                        iY3 = m8.y(i15 << 3);
                        i11 += iY3 + iZ;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if ((i13 & i10) != 0) {
                        iY = m8.y(i15 << 3);
                        iJ = iY + 8;
                        i11 += iJ;
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if ((i13 & i10) != 0) {
                        iY2 = m8.y(i15 << 3);
                        iJ = iY2 + 4;
                        i11 += iJ;
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if ((i13 & i10) != 0) {
                        iY4 = m8.y(i15 << 3);
                        iJ = iY4 + 1;
                        i11 += iJ;
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if ((i13 & i10) != 0) {
                        Object object = unsafe.getObject(obj, j10);
                        if (object instanceof zzka) {
                            int i19 = i15 << 3;
                            Logger logger = m8.f3620b;
                            int iZzd = ((zzka) object).zzd();
                            iY5 = m8.y(iZzd) + iZzd;
                            iY6 = m8.y(i19);
                            iJ = iY6 + iY5;
                            i11 += iJ;
                            break;
                        } else {
                            iZ = m8.x((String) object);
                            iY3 = m8.y(i15 << 3);
                            i11 += iY3 + iZ;
                            break;
                        }
                    } else {
                        break;
                    }
                case 9:
                    if ((i13 & i10) != 0) {
                        iJ = na.J(i15, unsafe.getObject(obj, j10), k(i14));
                        i11 += iJ;
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if ((i13 & i10) != 0) {
                        zzka zzkaVar = (zzka) unsafe.getObject(obj, j10);
                        int i20 = i15 << 3;
                        Logger logger2 = m8.f3620b;
                        int iZzd2 = zzkaVar.zzd();
                        iY5 = m8.y(iZzd2) + iZzd2;
                        iY6 = m8.y(i20);
                        iJ = iY6 + iY5;
                        i11 += iJ;
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if ((i13 & i10) != 0) {
                        iZ = m8.y(unsafe.getInt(obj, j10));
                        iY3 = m8.y(i15 << 3);
                        i11 += iY3 + iZ;
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if ((i13 & i10) != 0) {
                        iZ = m8.v(unsafe.getInt(obj, j10));
                        iY3 = m8.y(i15 << 3);
                        i11 += iY3 + iZ;
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if ((i13 & i10) != 0) {
                        iY2 = m8.y(i15 << 3);
                        iJ = iY2 + 4;
                        i11 += iJ;
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if ((i13 & i10) != 0) {
                        iY = m8.y(i15 << 3);
                        iJ = iY + 8;
                        i11 += iJ;
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if ((i13 & i10) != 0) {
                        int i21 = unsafe.getInt(obj, j10);
                        iY3 = m8.y(i15 << 3);
                        iZ = m8.y((i21 >> 31) ^ (i21 + i21));
                        i11 += iY3 + iZ;
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if ((i10 & i13) != 0) {
                        long j11 = unsafe.getLong(obj, j10);
                        iY7 = m8.y(i15 << 3);
                        iZ2 = m8.z((j11 >> 63) ^ (j11 + j11));
                        iJ = iY7 + iZ2;
                        i11 += iJ;
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if ((i13 & i10) != 0) {
                        iJ = m8.u(i15, (aa) unsafe.getObject(obj, j10), k(i14));
                        i11 += iJ;
                        break;
                    } else {
                        break;
                    }
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
                        break;
                    } else {
                        break;
                    }
                case 36:
                    iZ = na.B((List) unsafe.getObject(obj, j10));
                    if (iZ > 0) {
                        int i23 = i15 << 3;
                        iY8 = m8.y(iZ);
                        iY9 = m8.y(i23);
                        iY3 = iY9 + iY8;
                        i11 += iY3 + iZ;
                        break;
                    } else {
                        break;
                    }
                case 37:
                    iZ = na.I((List) unsafe.getObject(obj, j10));
                    if (iZ > 0) {
                        int i24 = i15 << 3;
                        iY8 = m8.y(iZ);
                        iY9 = m8.y(i24);
                        iY3 = iY9 + iY8;
                        i11 += iY3 + iZ;
                        break;
                    } else {
                        break;
                    }
                case 38:
                    iZ = na.T((List) unsafe.getObject(obj, j10));
                    if (iZ > 0) {
                        int i25 = i15 << 3;
                        iY8 = m8.y(iZ);
                        iY9 = m8.y(i25);
                        iY3 = iY9 + iY8;
                        i11 += iY3 + iZ;
                        break;
                    } else {
                        break;
                    }
                case 39:
                    iZ = na.G((List) unsafe.getObject(obj, j10));
                    if (iZ > 0) {
                        int i26 = i15 << 3;
                        iY8 = m8.y(iZ);
                        iY9 = m8.y(i26);
                        iY3 = iY9 + iY8;
                        i11 += iY3 + iZ;
                        break;
                    } else {
                        break;
                    }
                case 40:
                    iZ = na.D((List) unsafe.getObject(obj, j10));
                    if (iZ > 0) {
                        int i27 = i15 << 3;
                        iY8 = m8.y(iZ);
                        iY9 = m8.y(i27);
                        iY3 = iY9 + iY8;
                        i11 += iY3 + iZ;
                        break;
                    } else {
                        break;
                    }
                case 41:
                    iZ = na.B((List) unsafe.getObject(obj, j10));
                    if (iZ > 0) {
                        int i28 = i15 << 3;
                        iY8 = m8.y(iZ);
                        iY9 = m8.y(i28);
                        iY3 = iY9 + iY8;
                        i11 += iY3 + iZ;
                        break;
                    } else {
                        break;
                    }
                case 42:
                    List list = (List) unsafe.getObject(obj, j10);
                    Class cls = na.f3633a;
                    iZ = list.size();
                    if (iZ > 0) {
                        int i29 = i15 << 3;
                        iY8 = m8.y(iZ);
                        iY9 = m8.y(i29);
                        iY3 = iY9 + iY8;
                        i11 += iY3 + iZ;
                        break;
                    } else {
                        break;
                    }
                case 43:
                    iZ = na.R((List) unsafe.getObject(obj, j10));
                    if (iZ > 0) {
                        int i30 = i15 << 3;
                        iY8 = m8.y(iZ);
                        iY9 = m8.y(i30);
                        iY3 = iY9 + iY8;
                        i11 += iY3 + iZ;
                        break;
                    } else {
                        break;
                    }
                case 44:
                    iZ = na.z((List) unsafe.getObject(obj, j10));
                    if (iZ > 0) {
                        int i31 = i15 << 3;
                        iY8 = m8.y(iZ);
                        iY9 = m8.y(i31);
                        iY3 = iY9 + iY8;
                        i11 += iY3 + iZ;
                        break;
                    } else {
                        break;
                    }
                case 45:
                    iZ = na.B((List) unsafe.getObject(obj, j10));
                    if (iZ > 0) {
                        int i32 = i15 << 3;
                        iY8 = m8.y(iZ);
                        iY9 = m8.y(i32);
                        iY3 = iY9 + iY8;
                        i11 += iY3 + iZ;
                        break;
                    } else {
                        break;
                    }
                case 46:
                    iZ = na.D((List) unsafe.getObject(obj, j10));
                    if (iZ > 0) {
                        int i33 = i15 << 3;
                        iY8 = m8.y(iZ);
                        iY9 = m8.y(i33);
                        iY3 = iY9 + iY8;
                        i11 += iY3 + iZ;
                        break;
                    } else {
                        break;
                    }
                case 47:
                    iZ = na.M((List) unsafe.getObject(obj, j10));
                    if (iZ > 0) {
                        int i34 = i15 << 3;
                        iY8 = m8.y(iZ);
                        iY9 = m8.y(i34);
                        iY3 = iY9 + iY8;
                        i11 += iY3 + iZ;
                        break;
                    } else {
                        break;
                    }
                case 48:
                    iZ = na.O((List) unsafe.getObject(obj, j10));
                    if (iZ > 0) {
                        int i35 = i15 << 3;
                        iY8 = m8.y(iZ);
                        iY9 = m8.y(i35);
                        iY3 = iY9 + iY8;
                        i11 += iY3 + iZ;
                        break;
                    } else {
                        break;
                    }
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
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (C(obj, i15, i14)) {
                        iY2 = m8.y(i15 << 3);
                        iJ = iY2 + 4;
                        i11 += iJ;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (C(obj, i15, i14)) {
                        iZ = m8.z(V(obj, j10));
                        iY3 = m8.y(i15 << 3);
                        i11 += iY3 + iZ;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (C(obj, i15, i14)) {
                        iZ = m8.z(V(obj, j10));
                        iY3 = m8.y(i15 << 3);
                        i11 += iY3 + iZ;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (C(obj, i15, i14)) {
                        iZ = m8.v(L(obj, j10));
                        iY3 = m8.y(i15 << 3);
                        i11 += iY3 + iZ;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (C(obj, i15, i14)) {
                        iY = m8.y(i15 << 3);
                        iJ = iY + 8;
                        i11 += iJ;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (C(obj, i15, i14)) {
                        iY2 = m8.y(i15 << 3);
                        iJ = iY2 + 4;
                        i11 += iJ;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (C(obj, i15, i14)) {
                        iY4 = m8.y(i15 << 3);
                        iJ = iY4 + 1;
                        i11 += iJ;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (C(obj, i15, i14)) {
                        Object object2 = unsafe.getObject(obj, j10);
                        if (object2 instanceof zzka) {
                            int i36 = i15 << 3;
                            Logger logger3 = m8.f3620b;
                            int iZzd3 = ((zzka) object2).zzd();
                            iY5 = m8.y(iZzd3) + iZzd3;
                            iY6 = m8.y(i36);
                            iJ = iY6 + iY5;
                            i11 += iJ;
                            break;
                        } else {
                            iZ = m8.x((String) object2);
                            iY3 = m8.y(i15 << 3);
                            i11 += iY3 + iZ;
                            break;
                        }
                    } else {
                        break;
                    }
                case 60:
                    if (C(obj, i15, i14)) {
                        iJ = na.J(i15, unsafe.getObject(obj, j10), k(i14));
                        i11 += iJ;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (C(obj, i15, i14)) {
                        zzka zzkaVar2 = (zzka) unsafe.getObject(obj, j10);
                        int i37 = i15 << 3;
                        Logger logger4 = m8.f3620b;
                        int iZzd4 = zzkaVar2.zzd();
                        iY5 = m8.y(iZzd4) + iZzd4;
                        iY6 = m8.y(i37);
                        iJ = iY6 + iY5;
                        i11 += iJ;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (C(obj, i15, i14)) {
                        iZ = m8.y(L(obj, j10));
                        iY3 = m8.y(i15 << 3);
                        i11 += iY3 + iZ;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (C(obj, i15, i14)) {
                        iZ = m8.v(L(obj, j10));
                        iY3 = m8.y(i15 << 3);
                        i11 += iY3 + iZ;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (C(obj, i15, i14)) {
                        iY2 = m8.y(i15 << 3);
                        iJ = iY2 + 4;
                        i11 += iJ;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (C(obj, i15, i14)) {
                        iY = m8.y(i15 << 3);
                        iJ = iY + 8;
                        i11 += iJ;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (C(obj, i15, i14)) {
                        int iL = L(obj, j10);
                        iY3 = m8.y(i15 << 3);
                        iZ = m8.y((iL >> 31) ^ (iL + iL));
                        i11 += iY3 + iZ;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (C(obj, i15, i14)) {
                        long jV = V(obj, j10);
                        iY7 = m8.y(i15 << 3);
                        iZ2 = m8.z((jV >> 63) ^ (jV + jV));
                        iJ = iY7 + iZ2;
                        i11 += iJ;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (C(obj, i15, i14)) {
                        iJ = m8.u(i15, (aa) unsafe.getObject(obj, j10), k(i14));
                        i11 += iJ;
                        break;
                    } else {
                        break;
                    }
            }
        }
        qa qaVar = this.f3460l;
        int iA = i11 + qaVar.a(qaVar.d(obj));
        if (!this.f3454f) {
            return iA;
        }
        this.f3461m.a(obj);
        throw null;
    }

    public final int M(Object obj, byte[] bArr, int i10, int i11, int i12, long j10, w7 w7Var) {
        Unsafe unsafe = f3448q;
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
        Unsafe unsafe = f3448q;
        long j11 = this.f3449a[i17 + 2] & 1048575;
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
                unsafe.putObject(obj, j10, Long.valueOf(w7Var.f3865b));
                unsafe.putInt(obj, j11, i13);
                return iM;
            case 55:
            case 62:
                if (i14 != 0) {
                    return i10;
                }
                int iJ = x7.j(bArr, i10, w7Var);
                unsafe.putObject(obj, j10, Integer.valueOf(w7Var.f3864a));
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
                unsafe.putObject(obj, j10, Boolean.valueOf(w7Var.f3865b != 0));
                unsafe.putInt(obj, j11, i13);
                return iM2;
            case 59:
                if (i14 != 2) {
                    return i10;
                }
                int iJ2 = x7.j(bArr, i10, w7Var);
                int i22 = w7Var.f3864a;
                if (i22 == 0) {
                    unsafe.putObject(obj, j10, "");
                } else {
                    if ((i15 & 536870912) != 0 && !eb.e(bArr, iJ2, iJ2 + i22)) {
                        throw zzll.zzc();
                    }
                    unsafe.putObject(obj, j10, new String(bArr, iJ2, i22, h9.f3536b));
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
                unsafe.putObject(obj, j10, w7Var.f3866c);
                unsafe.putInt(obj, j11, i13);
                return iA;
            case 63:
                if (i14 != 0) {
                    return i10;
                }
                int iJ3 = x7.j(bArr, i10, w7Var);
                int i23 = w7Var.f3864a;
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
                unsafe.putObject(obj, j10, Integer.valueOf(j8.a(w7Var.f3864a)));
                unsafe.putInt(obj, j11, i13);
                return iJ4;
            case 67:
                if (i14 != 0) {
                    return i10;
                }
                int iM3 = x7.m(bArr, i10, w7Var);
                unsafe.putObject(obj, j10, Long.valueOf(j8.b(w7Var.f3865b)));
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
        Unsafe unsafe = f3448q;
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
                int i17 = w7Var.f3864a + iJ;
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
                int i18 = w7Var.f3864a + iJ2;
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
                    int i19 = w7Var.f3864a + iJ3;
                    while (iJ3 < i19) {
                        iJ3 = x7.m(bArr, iJ3, w7Var);
                        q9Var.g(w7Var.f3865b);
                    }
                    if (iJ3 == i19) {
                        return iJ3;
                    }
                    throw zzll.zzf();
                }
                if (i14 == 0) {
                    q9 q9Var2 = (q9) g9Var;
                    int iM = x7.m(bArr, i10, w7Var);
                    q9Var2.g(w7Var.f3865b);
                    while (iM < i11) {
                        int iJ4 = x7.j(bArr, iM, w7Var);
                        if (i12 != w7Var.f3864a) {
                            return iM;
                        }
                        iM = x7.m(bArr, iJ4, w7Var);
                        q9Var2.g(w7Var.f3865b);
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
                    int i20 = w7Var.f3864a + iJ5;
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
                        if (i12 != w7Var.f3864a) {
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
                    int i22 = w7Var.f3864a + iJ7;
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
                        if (i12 != w7Var.f3864a) {
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
                        long j12 = w7Var.f3865b;
                        throw null;
                    }
                    return i10;
                }
                n.g.a(g9Var);
                int iJ9 = x7.j(bArr, i10, w7Var);
                int i24 = w7Var.f3864a + iJ9;
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
                        int i25 = w7Var.f3864a;
                        if (i25 < 0) {
                            throw zzll.zzd();
                        }
                        if (i25 == 0) {
                            g9Var.add("");
                        } else {
                            g9Var.add(new String(bArr, iJ10, i25, h9.f3536b));
                            iJ10 += i25;
                        }
                        while (iJ10 < i11) {
                            int iJ11 = x7.j(bArr, iJ10, w7Var);
                            if (i12 != w7Var.f3864a) {
                                return iJ10;
                            }
                            iJ10 = x7.j(bArr, iJ11, w7Var);
                            int i26 = w7Var.f3864a;
                            if (i26 < 0) {
                                throw zzll.zzd();
                            }
                            if (i26 == 0) {
                                g9Var.add("");
                            } else {
                                g9Var.add(new String(bArr, iJ10, i26, h9.f3536b));
                                iJ10 += i26;
                            }
                        }
                        return iJ10;
                    }
                    int iJ12 = x7.j(bArr, i10, w7Var);
                    int i27 = w7Var.f3864a;
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
                        g9Var.add(new String(bArr, iJ12, i27, h9.f3536b));
                        iJ12 = i28;
                    }
                    while (iJ12 < i11) {
                        int iJ13 = x7.j(bArr, iJ12, w7Var);
                        if (i12 != w7Var.f3864a) {
                            return iJ12;
                        }
                        iJ12 = x7.j(bArr, iJ13, w7Var);
                        int i29 = w7Var.f3864a;
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
                            g9Var.add(new String(bArr, iJ12, i29, h9.f3536b));
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
                    int i31 = w7Var.f3864a;
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
                        if (i12 != w7Var.f3864a) {
                            return iJ14;
                        }
                        iJ14 = x7.j(bArr, iJ15, w7Var);
                        int i32 = w7Var.f3864a;
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
                qa qaVar = this.f3460l;
                Class cls = na.f3633a;
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
                    int i35 = w7Var.f3864a + iJ16;
                    while (iJ16 < i35) {
                        iJ16 = x7.j(bArr, iJ16, w7Var);
                        b9Var3.h(j8.a(w7Var.f3864a));
                    }
                    if (iJ16 == i35) {
                        return iJ16;
                    }
                    throw zzll.zzf();
                }
                if (i14 == 0) {
                    b9 b9Var4 = (b9) g9Var;
                    int iJ17 = x7.j(bArr, i10, w7Var);
                    b9Var4.h(j8.a(w7Var.f3864a));
                    while (iJ17 < i11) {
                        int iJ18 = x7.j(bArr, iJ17, w7Var);
                        if (i12 != w7Var.f3864a) {
                            return iJ17;
                        }
                        iJ17 = x7.j(bArr, iJ18, w7Var);
                        b9Var4.h(j8.a(w7Var.f3864a));
                    }
                    return iJ17;
                }
                return i10;
            case 34:
            case 48:
                if (i14 == 2) {
                    q9 q9Var5 = (q9) g9Var;
                    int iJ19 = x7.j(bArr, i10, w7Var);
                    int i36 = w7Var.f3864a + iJ19;
                    while (iJ19 < i36) {
                        iJ19 = x7.m(bArr, iJ19, w7Var);
                        q9Var5.g(j8.b(w7Var.f3865b));
                    }
                    if (iJ19 == i36) {
                        return iJ19;
                    }
                    throw zzll.zzf();
                }
                if (i14 == 0) {
                    q9 q9Var6 = (q9) g9Var;
                    int iM2 = x7.m(bArr, i10, w7Var);
                    q9Var6.g(j8.b(w7Var.f3865b));
                    while (iM2 < i11) {
                        int iJ20 = x7.j(bArr, iM2, w7Var);
                        if (i12 != w7Var.f3864a) {
                            return iM2;
                        }
                        iM2 = x7.m(bArr, iJ20, w7Var);
                        q9Var6.g(j8.b(w7Var.f3865b));
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
                    g9Var.add(w7Var2.f3866c);
                    while (iC < i11) {
                        int iJ21 = x7.j(bArr, iC, w7Var2);
                        if (i12 != w7Var2.f3864a) {
                            return iC;
                        }
                        la laVar2 = laVar;
                        w7 w7Var3 = w7Var2;
                        iC = x7.c(laVar2, bArr, iJ21, i11, i37, w7Var3);
                        g9Var.add(w7Var3.f3866c);
                        laVar = laVar2;
                        w7Var2 = w7Var3;
                    }
                    return iC;
                }
                return i10;
        }
    }

    public final int P(int i10) {
        if (i10 < this.f3451c || i10 > this.f3452d) {
            return -1;
        }
        return S(i10, 0);
    }

    public final int Q(int i10, int i11) {
        if (i10 < this.f3451c || i10 > this.f3452d) {
            return -1;
        }
        return S(i10, i11);
    }

    public final int R(int i10) {
        return this.f3449a[i10 + 2];
    }

    public final int S(int i10, int i11) {
        int length = (this.f3449a.length / 3) - 1;
        while (i11 <= length) {
            int i12 = (length + i11) >>> 1;
            int i13 = i12 * 3;
            int i14 = this.f3449a[i13];
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
        return this.f3449a[i10 + 1];
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x006d  */
    @Override // com.google.android.gms.internal.measurement.la
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(Object obj) {
        if (B(obj)) {
            if (obj instanceof a9) {
                a9 a9Var = (a9) obj;
                a9Var.z(Integer.MAX_VALUE);
                a9Var.zzb = 0;
                a9Var.x();
            }
            int length = this.f3449a.length;
            for (int i10 = 0; i10 < length; i10 += 3) {
                int iU = U(i10);
                int i11 = 1048575 & iU;
                int iT = T(iU);
                long j10 = i11;
                if (iT != 9) {
                    if (iT != 60 && iT != 68) {
                        switch (iT) {
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
                                this.f3459k.a(obj, j10);
                                break;
                            case 50:
                                Unsafe unsafe = f3448q;
                                Object object = unsafe.getObject(obj, j10);
                                if (object != null) {
                                    ((zzmc) object).zzc();
                                    unsafe.putObject(obj, j10, object);
                                    break;
                                } else {
                                    break;
                                }
                        }
                    } else if (C(obj, this.f3449a[i10], i10)) {
                        k(i10).a(f3448q.getObject(obj, j10));
                    }
                } else if (y(obj, i10)) {
                    k(i10).a(f3448q.getObject(obj, j10));
                }
            }
            this.f3460l.g(obj);
            if (this.f3454f) {
                this.f3461m.b(obj);
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.la
    public final void b(Object obj, gb gbVar) {
        int i10;
        int i11 = 1048575;
        if (this.f3455g) {
            if (this.f3454f) {
                this.f3461m.a(obj);
                throw null;
            }
            int length = this.f3449a.length;
            for (int i12 = 0; i12 < length; i12 += 3) {
                int iU = U(i12);
                int i13 = this.f3449a[i12];
                switch (T(iU)) {
                    case 0:
                        if (y(obj, i12)) {
                            gbVar.s(i13, ab.f(obj, iU & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 1:
                        if (y(obj, i12)) {
                            gbVar.w(i13, ab.g(obj, iU & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 2:
                        if (y(obj, i12)) {
                            gbVar.i(i13, ab.i(obj, iU & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case WebSettingsBoundaryInterface.AttributionBehavior.APP_SOURCE_AND_APP_TRIGGER /* 3 */:
                        if (y(obj, i12)) {
                            gbVar.D(i13, ab.i(obj, iU & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 4:
                        if (y(obj, i12)) {
                            gbVar.q(i13, ab.h(obj, iU & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        if (y(obj, i12)) {
                            gbVar.G(i13, ab.i(obj, iU & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 6:
                        if (y(obj, i12)) {
                            gbVar.e(i13, ab.h(obj, iU & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 7:
                        if (y(obj, i12)) {
                            gbVar.f(i13, ab.B(obj, iU & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 8:
                        if (y(obj, i12)) {
                            E(i13, ab.k(obj, iU & 1048575), gbVar);
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        if (y(obj, i12)) {
                            gbVar.t(i13, ab.k(obj, iU & 1048575), k(i12));
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        if (y(obj, i12)) {
                            gbVar.A(i13, (zzka) ab.k(obj, iU & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        if (y(obj, i12)) {
                            gbVar.b(i13, ab.h(obj, iU & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        if (y(obj, i12)) {
                            gbVar.o(i13, ab.h(obj, iU & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        if (y(obj, i12)) {
                            gbVar.v(i13, ab.h(obj, iU & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        if (y(obj, i12)) {
                            gbVar.k(i13, ab.i(obj, iU & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        if (y(obj, i12)) {
                            gbVar.g(i13, ab.h(obj, iU & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        if (y(obj, i12)) {
                            gbVar.I(i13, ab.i(obj, iU & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        if (y(obj, i12)) {
                            gbVar.a(i13, ab.k(obj, iU & 1048575), k(i12));
                            break;
                        } else {
                            break;
                        }
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
                            break;
                        } else {
                            break;
                        }
                    case 52:
                        if (C(obj, i13, i12)) {
                            gbVar.w(i13, J(obj, iU & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 53:
                        if (C(obj, i13, i12)) {
                            gbVar.i(i13, V(obj, iU & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 54:
                        if (C(obj, i13, i12)) {
                            gbVar.D(i13, V(obj, iU & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 55:
                        if (C(obj, i13, i12)) {
                            gbVar.q(i13, L(obj, iU & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 56:
                        if (C(obj, i13, i12)) {
                            gbVar.G(i13, V(obj, iU & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 57:
                        if (C(obj, i13, i12)) {
                            gbVar.e(i13, L(obj, iU & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 58:
                        if (C(obj, i13, i12)) {
                            gbVar.f(i13, D(obj, iU & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 59:
                        if (C(obj, i13, i12)) {
                            E(i13, ab.k(obj, iU & 1048575), gbVar);
                            break;
                        } else {
                            break;
                        }
                    case 60:
                        if (C(obj, i13, i12)) {
                            gbVar.t(i13, ab.k(obj, iU & 1048575), k(i12));
                            break;
                        } else {
                            break;
                        }
                    case 61:
                        if (C(obj, i13, i12)) {
                            gbVar.A(i13, (zzka) ab.k(obj, iU & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 62:
                        if (C(obj, i13, i12)) {
                            gbVar.b(i13, L(obj, iU & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 63:
                        if (C(obj, i13, i12)) {
                            gbVar.o(i13, L(obj, iU & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 64:
                        if (C(obj, i13, i12)) {
                            gbVar.v(i13, L(obj, iU & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 65:
                        if (C(obj, i13, i12)) {
                            gbVar.k(i13, V(obj, iU & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 66:
                        if (C(obj, i13, i12)) {
                            gbVar.g(i13, L(obj, iU & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 67:
                        if (C(obj, i13, i12)) {
                            gbVar.I(i13, V(obj, iU & 1048575));
                            break;
                        } else {
                            break;
                        }
                    case 68:
                        if (C(obj, i13, i12)) {
                            gbVar.a(i13, ab.k(obj, iU & 1048575), k(i12));
                            break;
                        } else {
                            break;
                        }
                }
            }
            qa qaVar = this.f3460l;
            qaVar.i(qaVar.d(obj), gbVar);
            return;
        }
        if (this.f3454f) {
            this.f3461m.a(obj);
            throw null;
        }
        int length2 = this.f3449a.length;
        Unsafe unsafe = f3448q;
        int i14 = 0;
        int i15 = 1048575;
        int i16 = 0;
        while (i14 < length2) {
            int iU2 = U(i14);
            int[] iArr = this.f3449a;
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
                case 1:
                    if ((i16 & i10) != 0) {
                        gbVar.w(i17, ab.g(obj, j10));
                    } else {
                        continue;
                    }
                    i14 += 3;
                    i11 = 1048575;
                case 2:
                    if ((i16 & i10) != 0) {
                        gbVar.i(i17, unsafe.getLong(obj, j10));
                    } else {
                        continue;
                    }
                    i14 += 3;
                    i11 = 1048575;
                case WebSettingsBoundaryInterface.AttributionBehavior.APP_SOURCE_AND_APP_TRIGGER /* 3 */:
                    if ((i16 & i10) != 0) {
                        gbVar.D(i17, unsafe.getLong(obj, j10));
                    } else {
                        continue;
                    }
                    i14 += 3;
                    i11 = 1048575;
                case 4:
                    if ((i16 & i10) != 0) {
                        gbVar.q(i17, unsafe.getInt(obj, j10));
                    } else {
                        continue;
                    }
                    i14 += 3;
                    i11 = 1048575;
                case 5:
                    if ((i16 & i10) != 0) {
                        gbVar.G(i17, unsafe.getLong(obj, j10));
                    } else {
                        continue;
                    }
                    i14 += 3;
                    i11 = 1048575;
                case 6:
                    if ((i16 & i10) != 0) {
                        gbVar.e(i17, unsafe.getInt(obj, j10));
                    } else {
                        continue;
                    }
                    i14 += 3;
                    i11 = 1048575;
                case 7:
                    if ((i16 & i10) != 0) {
                        gbVar.f(i17, ab.B(obj, j10));
                    } else {
                        continue;
                    }
                    i14 += 3;
                    i11 = 1048575;
                case 8:
                    if ((i16 & i10) != 0) {
                        E(i17, unsafe.getObject(obj, j10), gbVar);
                    } else {
                        continue;
                    }
                    i14 += 3;
                    i11 = 1048575;
                case 9:
                    if ((i16 & i10) != 0) {
                        gbVar.t(i17, unsafe.getObject(obj, j10), k(i14));
                    } else {
                        continue;
                    }
                    i14 += 3;
                    i11 = 1048575;
                case 10:
                    if ((i16 & i10) != 0) {
                        gbVar.A(i17, (zzka) unsafe.getObject(obj, j10));
                    } else {
                        continue;
                    }
                    i14 += 3;
                    i11 = 1048575;
                case 11:
                    if ((i16 & i10) != 0) {
                        gbVar.b(i17, unsafe.getInt(obj, j10));
                    } else {
                        continue;
                    }
                    i14 += 3;
                    i11 = 1048575;
                case 12:
                    if ((i16 & i10) != 0) {
                        gbVar.o(i17, unsafe.getInt(obj, j10));
                    } else {
                        continue;
                    }
                    i14 += 3;
                    i11 = 1048575;
                case 13:
                    if ((i16 & i10) != 0) {
                        gbVar.v(i17, unsafe.getInt(obj, j10));
                    } else {
                        continue;
                    }
                    i14 += 3;
                    i11 = 1048575;
                case 14:
                    if ((i16 & i10) != 0) {
                        gbVar.k(i17, unsafe.getLong(obj, j10));
                    } else {
                        continue;
                    }
                    i14 += 3;
                    i11 = 1048575;
                case 15:
                    if ((i16 & i10) != 0) {
                        gbVar.g(i17, unsafe.getInt(obj, j10));
                    } else {
                        continue;
                    }
                    i14 += 3;
                    i11 = 1048575;
                case 16:
                    if ((i16 & i10) != 0) {
                        gbVar.I(i17, unsafe.getLong(obj, j10));
                    } else {
                        continue;
                    }
                    i14 += 3;
                    i11 = 1048575;
                case 17:
                    if ((i16 & i10) != 0) {
                        gbVar.a(i17, unsafe.getObject(obj, j10), k(i14));
                    } else {
                        continue;
                    }
                    i14 += 3;
                    i11 = 1048575;
                case 18:
                    na.f(this.f3449a[i14], (List) unsafe.getObject(obj, j10), gbVar, false);
                    continue;
                    i14 += 3;
                    i11 = 1048575;
                case 19:
                    na.j(this.f3449a[i14], (List) unsafe.getObject(obj, j10), gbVar, false);
                    continue;
                    i14 += 3;
                    i11 = 1048575;
                case 20:
                    na.m(this.f3449a[i14], (List) unsafe.getObject(obj, j10), gbVar, false);
                    continue;
                    i14 += 3;
                    i11 = 1048575;
                case 21:
                    na.u(this.f3449a[i14], (List) unsafe.getObject(obj, j10), gbVar, false);
                    continue;
                    i14 += 3;
                    i11 = 1048575;
                case 22:
                    na.l(this.f3449a[i14], (List) unsafe.getObject(obj, j10), gbVar, false);
                    continue;
                    i14 += 3;
                    i11 = 1048575;
                case 23:
                    na.i(this.f3449a[i14], (List) unsafe.getObject(obj, j10), gbVar, false);
                    continue;
                    i14 += 3;
                    i11 = 1048575;
                case 24:
                    na.h(this.f3449a[i14], (List) unsafe.getObject(obj, j10), gbVar, false);
                    continue;
                    i14 += 3;
                    i11 = 1048575;
                case 25:
                    na.d(this.f3449a[i14], (List) unsafe.getObject(obj, j10), gbVar, false);
                    continue;
                    i14 += 3;
                    i11 = 1048575;
                case 26:
                    na.s(this.f3449a[i14], (List) unsafe.getObject(obj, j10), gbVar);
                    break;
                case 27:
                    na.n(this.f3449a[i14], (List) unsafe.getObject(obj, j10), gbVar, k(i14));
                    break;
                case 28:
                    na.e(this.f3449a[i14], (List) unsafe.getObject(obj, j10), gbVar);
                    break;
                case 29:
                    na.t(this.f3449a[i14], (List) unsafe.getObject(obj, j10), gbVar, false);
                    break;
                case 30:
                    na.g(this.f3449a[i14], (List) unsafe.getObject(obj, j10), gbVar, false);
                    continue;
                    i14 += 3;
                    i11 = 1048575;
                case 31:
                    na.o(this.f3449a[i14], (List) unsafe.getObject(obj, j10), gbVar, false);
                    continue;
                    i14 += 3;
                    i11 = 1048575;
                case 32:
                    na.p(this.f3449a[i14], (List) unsafe.getObject(obj, j10), gbVar, false);
                    continue;
                    i14 += 3;
                    i11 = 1048575;
                case 33:
                    na.q(this.f3449a[i14], (List) unsafe.getObject(obj, j10), gbVar, false);
                    continue;
                    i14 += 3;
                    i11 = 1048575;
                case 34:
                    na.r(this.f3449a[i14], (List) unsafe.getObject(obj, j10), gbVar, false);
                    continue;
                    i14 += 3;
                    i11 = 1048575;
                case 35:
                    na.f(this.f3449a[i14], (List) unsafe.getObject(obj, j10), gbVar, true);
                    break;
                case 36:
                    na.j(this.f3449a[i14], (List) unsafe.getObject(obj, j10), gbVar, true);
                    break;
                case 37:
                    na.m(this.f3449a[i14], (List) unsafe.getObject(obj, j10), gbVar, true);
                    break;
                case 38:
                    na.u(this.f3449a[i14], (List) unsafe.getObject(obj, j10), gbVar, true);
                    break;
                case 39:
                    na.l(this.f3449a[i14], (List) unsafe.getObject(obj, j10), gbVar, true);
                    break;
                case 40:
                    na.i(this.f3449a[i14], (List) unsafe.getObject(obj, j10), gbVar, true);
                    break;
                case 41:
                    na.h(this.f3449a[i14], (List) unsafe.getObject(obj, j10), gbVar, true);
                    break;
                case 42:
                    na.d(this.f3449a[i14], (List) unsafe.getObject(obj, j10), gbVar, true);
                    break;
                case 43:
                    na.t(this.f3449a[i14], (List) unsafe.getObject(obj, j10), gbVar, true);
                    break;
                case 44:
                    na.g(this.f3449a[i14], (List) unsafe.getObject(obj, j10), gbVar, true);
                    break;
                case 45:
                    na.o(this.f3449a[i14], (List) unsafe.getObject(obj, j10), gbVar, true);
                    break;
                case 46:
                    na.p(this.f3449a[i14], (List) unsafe.getObject(obj, j10), gbVar, true);
                    break;
                case 47:
                    na.q(this.f3449a[i14], (List) unsafe.getObject(obj, j10), gbVar, true);
                    break;
                case 48:
                    na.r(this.f3449a[i14], (List) unsafe.getObject(obj, j10), gbVar, true);
                    break;
                case 49:
                    na.k(this.f3449a[i14], (List) unsafe.getObject(obj, j10), gbVar, k(i14));
                    break;
                case 50:
                    w(gbVar, i17, unsafe.getObject(obj, j10), i14);
                    break;
                case 51:
                    if (C(obj, i17, i14)) {
                        gbVar.s(i17, I(obj, j10));
                        break;
                    }
                    break;
                case 52:
                    if (C(obj, i17, i14)) {
                        gbVar.w(i17, J(obj, j10));
                        break;
                    }
                    break;
                case 53:
                    if (C(obj, i17, i14)) {
                        gbVar.i(i17, V(obj, j10));
                        break;
                    }
                    break;
                case 54:
                    if (C(obj, i17, i14)) {
                        gbVar.D(i17, V(obj, j10));
                        break;
                    }
                    break;
                case 55:
                    if (C(obj, i17, i14)) {
                        gbVar.q(i17, L(obj, j10));
                        break;
                    }
                    break;
                case 56:
                    if (C(obj, i17, i14)) {
                        gbVar.G(i17, V(obj, j10));
                        break;
                    }
                    break;
                case 57:
                    if (C(obj, i17, i14)) {
                        gbVar.e(i17, L(obj, j10));
                        break;
                    }
                    break;
                case 58:
                    if (C(obj, i17, i14)) {
                        gbVar.f(i17, D(obj, j10));
                        break;
                    }
                    break;
                case 59:
                    if (C(obj, i17, i14)) {
                        E(i17, unsafe.getObject(obj, j10), gbVar);
                        break;
                    }
                    break;
                case 60:
                    if (C(obj, i17, i14)) {
                        gbVar.t(i17, unsafe.getObject(obj, j10), k(i14));
                        break;
                    }
                    break;
                case 61:
                    if (C(obj, i17, i14)) {
                        gbVar.A(i17, (zzka) unsafe.getObject(obj, j10));
                        break;
                    }
                    break;
                case 62:
                    if (C(obj, i17, i14)) {
                        gbVar.b(i17, L(obj, j10));
                        break;
                    }
                    break;
                case 63:
                    if (C(obj, i17, i14)) {
                        gbVar.o(i17, L(obj, j10));
                        break;
                    }
                    break;
                case 64:
                    if (C(obj, i17, i14)) {
                        gbVar.v(i17, L(obj, j10));
                        break;
                    }
                    break;
                case 65:
                    if (C(obj, i17, i14)) {
                        gbVar.k(i17, V(obj, j10));
                        break;
                    }
                    break;
                case 66:
                    if (C(obj, i17, i14)) {
                        gbVar.g(i17, L(obj, j10));
                        break;
                    }
                    break;
                case 67:
                    if (C(obj, i17, i14)) {
                        gbVar.I(i17, V(obj, j10));
                        break;
                    }
                    break;
                case 68:
                    if (C(obj, i17, i14)) {
                        gbVar.a(i17, unsafe.getObject(obj, j10), k(i14));
                        break;
                    }
                    break;
            }
            i14 += 3;
            i11 = 1048575;
        }
        qa qaVar2 = this.f3460l;
        qaVar2.i(qaVar2.d(obj), gbVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0094  */
    @Override // com.google.android.gms.internal.measurement.la
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean c(Object obj) {
        int i10;
        int i11;
        int i12;
        int i13 = 1048575;
        int i14 = 0;
        int i15 = 0;
        while (i15 < this.f3457i) {
            int i16 = this.f3456h[i15];
            int i17 = this.f3449a[i16];
            int iU = U(i16);
            int i18 = this.f3449a[i16 + 2];
            int i19 = i18 & 1048575;
            int i20 = 1 << (i18 >>> 20);
            if (i19 != i13) {
                if (i19 != 1048575) {
                    i14 = f3448q.getInt(obj, i19);
                }
                i10 = i14;
                i13 = i19;
            } else {
                i10 = i14;
            }
            if ((268435456 & iU) != 0) {
                i11 = i16;
                i12 = i13;
                if (!z(obj, i11, i12, i10, i20)) {
                    return false;
                }
            } else {
                i11 = i16;
                i12 = i13;
            }
            int iT = T(iU);
            if (iT == 9 || iT == 17) {
                if (z(obj, i11, i12, i10, i20) && !A(obj, iU, k(i11))) {
                    return false;
                }
            } else if (iT == 27) {
                List list = (List) ab.k(obj, iU & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    la laVarK = k(i11);
                    for (int i21 = 0; i21 < list.size(); i21++) {
                        if (!laVarK.c(list.get(i21))) {
                            return false;
                        }
                    }
                }
            } else if (iT == 60 || iT == 68) {
                if (C(obj, i17, i11) && !A(obj, iU, k(i11))) {
                    return false;
                }
            } else if (iT != 49) {
                if (iT == 50 && !((zzmc) ab.k(obj, iU & 1048575)).isEmpty()) {
                    n.g.a(l(i11));
                    throw null;
                }
            }
            i15++;
            i13 = i12;
            i14 = i10;
        }
        if (!this.f3454f) {
            return true;
        }
        this.f3461m.a(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.la
    public final Object d() {
        return ((a9) this.f3453e).o();
    }

    @Override // com.google.android.gms.internal.measurement.la
    public final int e(Object obj) {
        int i10;
        long jDoubleToLongBits;
        int i11;
        int iFloatToIntBits;
        int length = this.f3449a.length;
        int i12 = 0;
        for (int i13 = 0; i13 < length; i13 += 3) {
            int iU = U(i13);
            int i14 = this.f3449a[i13];
            long j10 = 1048575 & iU;
            int iHashCode = 37;
            switch (T(iU)) {
                case 0:
                    i10 = i12 * 53;
                    jDoubleToLongBits = Double.doubleToLongBits(ab.f(obj, j10));
                    Charset charset = h9.f3535a;
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
                    Charset charset2 = h9.f3535a;
                    i12 = i10 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    break;
                case WebSettingsBoundaryInterface.AttributionBehavior.APP_SOURCE_AND_APP_TRIGGER /* 3 */:
                    i10 = i12 * 53;
                    jDoubleToLongBits = ab.i(obj, j10);
                    Charset charset3 = h9.f3535a;
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
                    Charset charset4 = h9.f3535a;
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
                    Charset charset5 = h9.f3535a;
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
                    Charset charset6 = h9.f3535a;
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
                        Charset charset7 = h9.f3535a;
                        i12 = i10 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (C(obj, i14, i13)) {
                        i11 = i12 * 53;
                        iFloatToIntBits = Float.floatToIntBits(J(obj, j10));
                        i12 = i11 + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (C(obj, i14, i13)) {
                        i10 = i12 * 53;
                        jDoubleToLongBits = V(obj, j10);
                        Charset charset8 = h9.f3535a;
                        i12 = i10 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (C(obj, i14, i13)) {
                        i10 = i12 * 53;
                        jDoubleToLongBits = V(obj, j10);
                        Charset charset9 = h9.f3535a;
                        i12 = i10 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (C(obj, i14, i13)) {
                        i11 = i12 * 53;
                        iFloatToIntBits = L(obj, j10);
                        i12 = i11 + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (C(obj, i14, i13)) {
                        i10 = i12 * 53;
                        jDoubleToLongBits = V(obj, j10);
                        Charset charset10 = h9.f3535a;
                        i12 = i10 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (C(obj, i14, i13)) {
                        i11 = i12 * 53;
                        iFloatToIntBits = L(obj, j10);
                        i12 = i11 + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (C(obj, i14, i13)) {
                        i11 = i12 * 53;
                        iFloatToIntBits = h9.a(D(obj, j10));
                        i12 = i11 + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (C(obj, i14, i13)) {
                        i11 = i12 * 53;
                        iFloatToIntBits = ((String) ab.k(obj, j10)).hashCode();
                        i12 = i11 + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (C(obj, i14, i13)) {
                        i11 = i12 * 53;
                        iFloatToIntBits = ab.k(obj, j10).hashCode();
                        i12 = i11 + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (C(obj, i14, i13)) {
                        i11 = i12 * 53;
                        iFloatToIntBits = ab.k(obj, j10).hashCode();
                        i12 = i11 + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (C(obj, i14, i13)) {
                        i11 = i12 * 53;
                        iFloatToIntBits = L(obj, j10);
                        i12 = i11 + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (C(obj, i14, i13)) {
                        i11 = i12 * 53;
                        iFloatToIntBits = L(obj, j10);
                        i12 = i11 + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (C(obj, i14, i13)) {
                        i11 = i12 * 53;
                        iFloatToIntBits = L(obj, j10);
                        i12 = i11 + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (C(obj, i14, i13)) {
                        i10 = i12 * 53;
                        jDoubleToLongBits = V(obj, j10);
                        Charset charset11 = h9.f3535a;
                        i12 = i10 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (C(obj, i14, i13)) {
                        i11 = i12 * 53;
                        iFloatToIntBits = L(obj, j10);
                        i12 = i11 + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (C(obj, i14, i13)) {
                        i10 = i12 * 53;
                        jDoubleToLongBits = V(obj, j10);
                        Charset charset12 = h9.f3535a;
                        i12 = i10 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (C(obj, i14, i13)) {
                        i11 = i12 * 53;
                        iFloatToIntBits = ab.k(obj, j10).hashCode();
                        i12 = i11 + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int iHashCode2 = (i12 * 53) + this.f3460l.d(obj).hashCode();
        if (!this.f3454f) {
            return iHashCode2;
        }
        this.f3461m.a(obj);
        throw null;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:28:0x008f. Please report as an issue. */
    @Override // com.google.android.gms.internal.measurement.la
    public final void f(Object obj, byte[] bArr, int i10, int i11, w7 w7Var) throws zzll {
        Object obj2;
        Unsafe unsafe;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        Object obj3;
        Unsafe unsafe2;
        int i18;
        Unsafe unsafe3;
        int i19;
        Object obj4;
        int i20;
        Unsafe unsafe4;
        int i21;
        int i22;
        int i23;
        int i24;
        da daVar = this;
        Object obj5 = obj;
        byte[] bArr2 = bArr;
        int i25 = i11;
        w7 w7Var2 = w7Var;
        if (!daVar.f3455g) {
            F(obj5, bArr, i10, i25, 0, w7Var);
            return;
        }
        p(obj5);
        Unsafe unsafe5 = f3448q;
        int i26 = -1;
        int iM = i10;
        int i27 = -1;
        int i28 = 0;
        int i29 = 1048575;
        int i30 = 0;
        while (iM < i25) {
            int iK = iM + 1;
            int i31 = bArr2[iM];
            if (i31 < 0) {
                iK = x7.k(i31, bArr2, iK, w7Var2);
                i31 = w7Var2.f3864a;
            }
            int i32 = i31 >>> 3;
            int iQ = i32 > i27 ? daVar.Q(i32, i28 / 3) : daVar.P(i32);
            if (iQ == i26) {
                obj2 = obj5;
                unsafe = unsafe5;
                i12 = i31;
                i13 = iK;
                i14 = i32;
                i15 = 0;
            } else {
                int i33 = i31 & 7;
                int[] iArr = daVar.f3449a;
                int i34 = iArr[iQ + 1];
                int iT = T(i34);
                int i35 = i31;
                int i36 = iQ;
                long j10 = i34 & 1048575;
                if (iT <= 17) {
                    int i37 = iArr[i36 + 2];
                    int i38 = 1 << (i37 >>> 20);
                    int i39 = i37 & 1048575;
                    if (i39 != i29) {
                        i16 = iK;
                        if (i29 != 1048575) {
                            unsafe5.putInt(obj5, i29, i30);
                        }
                        if (i39 != 1048575) {
                            i30 = unsafe5.getInt(obj5, i39);
                        }
                        i29 = i39;
                    } else {
                        i16 = iK;
                    }
                    switch (iT) {
                        case 0:
                            int i40 = i16;
                            i14 = i32;
                            i17 = i40;
                            obj3 = obj5;
                            unsafe2 = unsafe5;
                            i18 = i36;
                            if (i33 != 1) {
                                i12 = i35;
                                unsafe = unsafe2;
                                i15 = i18;
                                i13 = i17;
                                obj2 = obj3;
                                break;
                            } else {
                                ab.t(obj3, j10, Double.longBitsToDouble(x7.p(bArr2, i17)));
                                iM = i17 + 8;
                                i30 |= i38;
                                i25 = i11;
                                w7Var2 = w7Var;
                                unsafe5 = unsafe2;
                                i28 = i18;
                                obj5 = obj3;
                                i27 = i14;
                                i26 = -1;
                                break;
                            }
                        case 1:
                            int i41 = i16;
                            i14 = i32;
                            i17 = i41;
                            obj3 = obj5;
                            unsafe2 = unsafe5;
                            i18 = i36;
                            if (i33 != 5) {
                                i12 = i35;
                                unsafe = unsafe2;
                                i15 = i18;
                                i13 = i17;
                                obj2 = obj3;
                                break;
                            } else {
                                ab.u(obj3, j10, Float.intBitsToFloat(x7.b(bArr2, i17)));
                                iM = i17 + 4;
                                i30 |= i38;
                                i25 = i11;
                                w7Var2 = w7Var;
                                unsafe5 = unsafe2;
                                i28 = i18;
                                obj5 = obj3;
                                i27 = i14;
                                i26 = -1;
                                break;
                            }
                        case 2:
                        case WebSettingsBoundaryInterface.AttributionBehavior.APP_SOURCE_AND_APP_TRIGGER /* 3 */:
                            Unsafe unsafe6 = unsafe5;
                            i17 = i16;
                            i18 = i36;
                            if (i33 != 0) {
                                obj3 = obj5;
                                unsafe2 = unsafe6;
                                i14 = i32;
                                i12 = i35;
                                unsafe = unsafe2;
                                i15 = i18;
                                i13 = i17;
                                obj2 = obj3;
                                break;
                            } else {
                                int iM2 = x7.m(bArr2, i17, w7Var2);
                                Object obj6 = obj5;
                                unsafe6.putLong(obj6, j10, w7Var2.f3865b);
                                i30 |= i38;
                                i25 = i11;
                                unsafe5 = unsafe6;
                                i28 = i18;
                                i27 = i32;
                                iM = iM2;
                                obj5 = obj6;
                                i26 = -1;
                                break;
                            }
                        case 4:
                        case 11:
                            unsafe3 = unsafe5;
                            i17 = i16;
                            i18 = i36;
                            if (i33 != 0) {
                                Unsafe unsafe7 = unsafe3;
                                obj3 = obj5;
                                unsafe2 = unsafe7;
                                i14 = i32;
                                i12 = i35;
                                unsafe = unsafe2;
                                i15 = i18;
                                i13 = i17;
                                obj2 = obj3;
                                break;
                            } else {
                                int iJ = x7.j(bArr2, i17, w7Var2);
                                unsafe3.putInt(obj5, j10, w7Var2.f3864a);
                                i30 |= i38;
                                i25 = i11;
                                iM = iJ;
                                i28 = i18;
                                i27 = i32;
                                unsafe5 = unsafe3;
                                i26 = -1;
                                break;
                            }
                        case 5:
                        case 14:
                            int i42 = i16;
                            i18 = i36;
                            Object obj7 = obj5;
                            unsafe3 = unsafe5;
                            if (i33 != 1) {
                                obj5 = obj7;
                                i17 = i42;
                                Unsafe unsafe72 = unsafe3;
                                obj3 = obj5;
                                unsafe2 = unsafe72;
                                i14 = i32;
                                i12 = i35;
                                unsafe = unsafe2;
                                i15 = i18;
                                i13 = i17;
                                obj2 = obj3;
                                break;
                            } else {
                                unsafe3.putLong(obj7, j10, x7.p(bArr2, i42));
                                obj5 = obj7;
                                iM = i42 + 8;
                                i30 |= i38;
                                i25 = i11;
                                i28 = i18;
                                i27 = i32;
                                unsafe5 = unsafe3;
                                i26 = -1;
                                break;
                            }
                        case 6:
                        case 13:
                            i19 = i16;
                            i18 = i36;
                            obj4 = obj5;
                            unsafe3 = unsafe5;
                            if (i33 != 5) {
                                i14 = i32;
                                unsafe2 = unsafe3;
                                obj3 = obj4;
                                i17 = i19;
                                i12 = i35;
                                unsafe = unsafe2;
                                i15 = i18;
                                i13 = i17;
                                obj2 = obj3;
                                break;
                            } else {
                                unsafe3.putInt(obj4, j10, x7.b(bArr2, i19));
                                iM = i19 + 4;
                                i30 |= i38;
                                i25 = i11;
                                i28 = i18;
                                i27 = i32;
                                obj5 = obj4;
                                unsafe5 = unsafe3;
                                i26 = -1;
                                break;
                            }
                        case 7:
                            i19 = i16;
                            i18 = i36;
                            obj4 = obj5;
                            unsafe3 = unsafe5;
                            if (i33 != 0) {
                                i14 = i32;
                                unsafe2 = unsafe3;
                                obj3 = obj4;
                                i17 = i19;
                                i12 = i35;
                                unsafe = unsafe2;
                                i15 = i18;
                                i13 = i17;
                                obj2 = obj3;
                                break;
                            } else {
                                iM = x7.m(bArr2, i19, w7Var2);
                                ab.r(obj4, j10, w7Var2.f3865b != 0);
                                i30 |= i38;
                                i25 = i11;
                                i28 = i18;
                                i27 = i32;
                                obj5 = obj4;
                                unsafe5 = unsafe3;
                                i26 = -1;
                                break;
                            }
                        case 8:
                            i19 = i16;
                            i18 = i36;
                            obj4 = obj5;
                            unsafe3 = unsafe5;
                            if (i33 != 2) {
                                i14 = i32;
                                unsafe2 = unsafe3;
                                obj3 = obj4;
                                i17 = i19;
                                i12 = i35;
                                unsafe = unsafe2;
                                i15 = i18;
                                i13 = i17;
                                obj2 = obj3;
                                break;
                            } else {
                                iM = (i34 & 536870912) == 0 ? x7.g(bArr2, i19, w7Var2) : x7.h(bArr2, i19, w7Var2);
                                unsafe3.putObject(obj4, j10, w7Var2.f3866c);
                                i30 |= i38;
                                i25 = i11;
                                i28 = i18;
                                i27 = i32;
                                obj5 = obj4;
                                unsafe5 = unsafe3;
                                i26 = -1;
                                break;
                            }
                        case 9:
                            obj4 = obj5;
                            unsafe3 = unsafe5;
                            i20 = i16;
                            i18 = i36;
                            if (i33 != 2) {
                                i14 = i32;
                                unsafe2 = unsafe3;
                                obj3 = obj4;
                                i17 = i20;
                                i12 = i35;
                                unsafe = unsafe2;
                                i15 = i18;
                                i13 = i17;
                                obj2 = obj3;
                                break;
                            } else {
                                Object objM = daVar.m(obj4, i18);
                                int iO = x7.o(objM, daVar.k(i18), bArr2, i20, i11, w7Var2);
                                daVar.u(obj4, i18, objM);
                                i30 |= i38;
                                i25 = i11;
                                iM = iO;
                                i28 = i18;
                                i27 = i32;
                                obj5 = obj4;
                                unsafe5 = unsafe3;
                                i26 = -1;
                                break;
                            }
                        case 10:
                            i20 = i16;
                            obj4 = obj5;
                            unsafe4 = unsafe5;
                            if (i33 != 2) {
                                i14 = i32;
                                unsafe2 = unsafe4;
                                i18 = i36;
                                obj3 = obj4;
                                i17 = i20;
                                i12 = i35;
                                unsafe = unsafe2;
                                i15 = i18;
                                i13 = i17;
                                obj2 = obj3;
                                break;
                            } else {
                                iM = x7.a(bArr2, i20, w7Var2);
                                unsafe4.putObject(obj4, j10, w7Var2.f3866c);
                                i30 |= i38;
                                i25 = i11;
                                i27 = i32;
                                obj5 = obj4;
                                unsafe5 = unsafe4;
                                i28 = i36;
                                i26 = -1;
                                break;
                            }
                        case 12:
                            i20 = i16;
                            obj4 = obj5;
                            unsafe4 = unsafe5;
                            if (i33 != 0) {
                                i14 = i32;
                                unsafe2 = unsafe4;
                                i18 = i36;
                                obj3 = obj4;
                                i17 = i20;
                                i12 = i35;
                                unsafe = unsafe2;
                                i15 = i18;
                                i13 = i17;
                                obj2 = obj3;
                                break;
                            } else {
                                iM = x7.j(bArr2, i20, w7Var2);
                                unsafe4.putInt(obj4, j10, w7Var2.f3864a);
                                i30 |= i38;
                                i25 = i11;
                                i27 = i32;
                                obj5 = obj4;
                                unsafe5 = unsafe4;
                                i28 = i36;
                                i26 = -1;
                                break;
                            }
                        case 15:
                            i20 = i16;
                            obj4 = obj5;
                            unsafe4 = unsafe5;
                            if (i33 != 0) {
                                i14 = i32;
                                unsafe2 = unsafe4;
                                i18 = i36;
                                obj3 = obj4;
                                i17 = i20;
                                i12 = i35;
                                unsafe = unsafe2;
                                i15 = i18;
                                i13 = i17;
                                obj2 = obj3;
                                break;
                            } else {
                                iM = x7.j(bArr2, i20, w7Var2);
                                unsafe4.putInt(obj4, j10, j8.a(w7Var2.f3864a));
                                i30 |= i38;
                                i25 = i11;
                                i27 = i32;
                                obj5 = obj4;
                                unsafe5 = unsafe4;
                                i28 = i36;
                                i26 = -1;
                                break;
                            }
                        case 16:
                            if (i33 != 0) {
                                obj3 = obj5;
                                unsafe2 = unsafe5;
                                i17 = i16;
                                i18 = i36;
                                i14 = i32;
                                i12 = i35;
                                unsafe = unsafe2;
                                i15 = i18;
                                i13 = i17;
                                obj2 = obj3;
                                break;
                            } else {
                                int iM3 = x7.m(bArr2, i16, w7Var2);
                                Unsafe unsafe8 = unsafe5;
                                Object obj8 = obj5;
                                unsafe8.putLong(obj8, j10, j8.b(w7Var2.f3865b));
                                unsafe4 = unsafe8;
                                obj4 = obj8;
                                i30 |= i38;
                                i25 = i11;
                                iM = iM3;
                                i27 = i32;
                                obj5 = obj4;
                                unsafe5 = unsafe4;
                                i28 = i36;
                                i26 = -1;
                                break;
                            }
                        default:
                            obj3 = obj5;
                            unsafe2 = unsafe5;
                            i17 = i16;
                            i18 = i36;
                            i14 = i32;
                            i12 = i35;
                            unsafe = unsafe2;
                            i15 = i18;
                            i13 = i17;
                            obj2 = obj3;
                            break;
                    }
                } else {
                    i14 = i32;
                    Object obj9 = obj5;
                    Unsafe unsafe9 = unsafe5;
                    int i43 = iK;
                    if (iT != 27) {
                        i15 = i36;
                        i24 = i43;
                        if (iT <= 49) {
                            long j11 = i34;
                            i23 = i30;
                            unsafe = unsafe9;
                            i22 = i29;
                            int iO2 = daVar.O(obj9, bArr, i24, i11, i35, i14, i33, i15, j11, iT, j10, w7Var);
                            i21 = i35;
                            if (iO2 != i24) {
                                daVar = this;
                                obj5 = obj;
                                i25 = i11;
                                w7Var2 = w7Var;
                                iM = iO2;
                                i29 = i22;
                                i27 = i14;
                                i28 = i15;
                                i30 = i23;
                                unsafe5 = unsafe;
                                i26 = -1;
                                bArr2 = bArr;
                            } else {
                                obj2 = obj;
                                i13 = iO2;
                                i12 = i21;
                                i29 = i22;
                                i30 = i23;
                            }
                        } else {
                            i22 = i29;
                            i23 = i30;
                            unsafe = unsafe9;
                            i21 = i35;
                            if (iT != 50) {
                                i12 = i21;
                                int iN = N(obj, bArr, i24, i11, i12, i14, i33, i34, iT, j10, i15, w7Var);
                                obj2 = obj;
                                if (iN != i24) {
                                    daVar = this;
                                    i25 = i11;
                                    w7Var2 = w7Var;
                                    iM = iN;
                                    obj5 = obj2;
                                    i29 = i22;
                                    i27 = i14;
                                    i28 = i15;
                                    i30 = i23;
                                    unsafe5 = unsafe;
                                    i26 = -1;
                                    bArr2 = bArr;
                                } else {
                                    i13 = iN;
                                    i29 = i22;
                                    i30 = i23;
                                }
                            } else if (i33 == 2) {
                                int iM4 = M(obj, bArr, i24, i11, i15, j10, w7Var);
                                if (iM4 != i24) {
                                    daVar = this;
                                    obj5 = obj;
                                    bArr2 = bArr;
                                    i25 = i11;
                                    w7Var2 = w7Var;
                                    iM = iM4;
                                    i29 = i22;
                                    i27 = i14;
                                    i28 = i15;
                                    i30 = i23;
                                    unsafe5 = unsafe;
                                    i26 = -1;
                                } else {
                                    obj2 = obj;
                                    i13 = iM4;
                                    i12 = i21;
                                    i29 = i22;
                                    i30 = i23;
                                }
                            }
                        }
                    } else if (i33 == 2) {
                        g9 g9VarJ = (g9) unsafe9.getObject(obj9, j10);
                        if (!g9VarJ.b()) {
                            int size = g9VarJ.size();
                            g9VarJ = g9VarJ.j(size == 0 ? 10 : size + size);
                            unsafe9.putObject(obj9, j10, g9VarJ);
                        }
                        la laVarK = daVar.k(i36);
                        i36 = i36;
                        byte[] bArr3 = bArr2;
                        bArr2 = bArr;
                        i25 = i11;
                        w7Var2 = w7Var;
                        iM = x7.e(laVarK, i35, bArr3, i43, i11, g9VarJ, w7Var);
                        unsafe5 = unsafe9;
                        obj5 = obj9;
                        i27 = i14;
                        i28 = i36;
                        i26 = -1;
                    } else {
                        i21 = i35;
                        unsafe = unsafe9;
                        i15 = i36;
                        i22 = i29;
                        i23 = i30;
                        i24 = i43;
                    }
                    obj2 = obj;
                    i13 = i24;
                    i12 = i21;
                    i29 = i22;
                    i30 = i23;
                }
            }
            int i44 = x7.i(i12, bArr, i13, i11, G(obj2), w7Var);
            bArr2 = bArr;
            w7Var2 = w7Var;
            i25 = i11;
            obj5 = obj2;
            i27 = i14;
            i28 = i15;
            unsafe5 = unsafe;
            i26 = -1;
            iM = i44;
            daVar = this;
        }
        Object obj10 = obj5;
        Unsafe unsafe10 = unsafe5;
        int i45 = i25;
        int i46 = i29;
        int i47 = i30;
        if (i46 != 1048575) {
            unsafe10.putInt(obj10, i46, i47);
        }
        if (iM != i45) {
            throw zzll.zze();
        }
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
        if (!this.f3455g) {
            return K(obj);
        }
        Unsafe unsafe = f3448q;
        int i10 = 0;
        for (int i11 = 0; i11 < this.f3449a.length; i11 += 3) {
            int iU = U(i11);
            int iT = T(iU);
            int i12 = this.f3449a[i11];
            int i13 = iU & 1048575;
            if (iT >= zzkt.zzJ.zza() && iT <= zzkt.zzW.zza()) {
                int i14 = this.f3449a[i11 + 2];
            }
            long j10 = i13;
            switch (iT) {
                case 0:
                    if (y(obj, i11)) {
                        iY = m8.y(i12 << 3);
                        iJ = iY + 8;
                        i10 += iJ;
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (y(obj, i11)) {
                        iY2 = m8.y(i12 << 3);
                        iJ = iY2 + 4;
                        i10 += iJ;
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (y(obj, i11)) {
                        iZ = m8.z(ab.i(obj, j10));
                        iY3 = m8.y(i12 << 3);
                        i10 += iY3 + iZ;
                        break;
                    } else {
                        break;
                    }
                case WebSettingsBoundaryInterface.AttributionBehavior.APP_SOURCE_AND_APP_TRIGGER /* 3 */:
                    if (y(obj, i11)) {
                        iZ = m8.z(ab.i(obj, j10));
                        iY3 = m8.y(i12 << 3);
                        i10 += iY3 + iZ;
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (y(obj, i11)) {
                        iZ = m8.v(ab.h(obj, j10));
                        iY3 = m8.y(i12 << 3);
                        i10 += iY3 + iZ;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (y(obj, i11)) {
                        iY = m8.y(i12 << 3);
                        iJ = iY + 8;
                        i10 += iJ;
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (y(obj, i11)) {
                        iY2 = m8.y(i12 << 3);
                        iJ = iY2 + 4;
                        i10 += iJ;
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (y(obj, i11)) {
                        iY4 = m8.y(i12 << 3);
                        iJ = iY4 + 1;
                        i10 += iJ;
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (y(obj, i11)) {
                        Object objK = ab.k(obj, j10);
                        if (objK instanceof zzka) {
                            int i15 = i12 << 3;
                            Logger logger = m8.f3620b;
                            int iZzd = ((zzka) objK).zzd();
                            iY5 = m8.y(iZzd) + iZzd;
                            iY6 = m8.y(i15);
                            iJ = iY6 + iY5;
                            i10 += iJ;
                            break;
                        } else {
                            iZ = m8.x((String) objK);
                            iY3 = m8.y(i12 << 3);
                            i10 += iY3 + iZ;
                            break;
                        }
                    } else {
                        break;
                    }
                case 9:
                    if (y(obj, i11)) {
                        iJ = na.J(i12, ab.k(obj, j10), k(i11));
                        i10 += iJ;
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if (y(obj, i11)) {
                        zzka zzkaVar = (zzka) ab.k(obj, j10);
                        int i16 = i12 << 3;
                        Logger logger2 = m8.f3620b;
                        int iZzd2 = zzkaVar.zzd();
                        iY5 = m8.y(iZzd2) + iZzd2;
                        iY6 = m8.y(i16);
                        iJ = iY6 + iY5;
                        i10 += iJ;
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (y(obj, i11)) {
                        iZ = m8.y(ab.h(obj, j10));
                        iY3 = m8.y(i12 << 3);
                        i10 += iY3 + iZ;
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (y(obj, i11)) {
                        iZ = m8.v(ab.h(obj, j10));
                        iY3 = m8.y(i12 << 3);
                        i10 += iY3 + iZ;
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (y(obj, i11)) {
                        iY2 = m8.y(i12 << 3);
                        iJ = iY2 + 4;
                        i10 += iJ;
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (y(obj, i11)) {
                        iY = m8.y(i12 << 3);
                        iJ = iY + 8;
                        i10 += iJ;
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (y(obj, i11)) {
                        int iH = ab.h(obj, j10);
                        iY3 = m8.y(i12 << 3);
                        iZ = m8.y((iH >> 31) ^ (iH + iH));
                        i10 += iY3 + iZ;
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (y(obj, i11)) {
                        long jI = ab.i(obj, j10);
                        iY7 = m8.y(i12 << 3);
                        iZ2 = m8.z((jI >> 63) ^ (jI + jI));
                        iJ = iY7 + iZ2;
                        i10 += iJ;
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if (y(obj, i11)) {
                        iJ = m8.u(i12, (aa) ab.k(obj, j10), k(i11));
                        i10 += iJ;
                        break;
                    } else {
                        break;
                    }
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
                        break;
                    } else {
                        break;
                    }
                case 36:
                    iZ = na.B((List) unsafe.getObject(obj, j10));
                    if (iZ > 0) {
                        int i18 = i12 << 3;
                        iY8 = m8.y(iZ);
                        iY9 = m8.y(i18);
                        iY3 = iY9 + iY8;
                        i10 += iY3 + iZ;
                        break;
                    } else {
                        break;
                    }
                case 37:
                    iZ = na.I((List) unsafe.getObject(obj, j10));
                    if (iZ > 0) {
                        int i19 = i12 << 3;
                        iY8 = m8.y(iZ);
                        iY9 = m8.y(i19);
                        iY3 = iY9 + iY8;
                        i10 += iY3 + iZ;
                        break;
                    } else {
                        break;
                    }
                case 38:
                    iZ = na.T((List) unsafe.getObject(obj, j10));
                    if (iZ > 0) {
                        int i20 = i12 << 3;
                        iY8 = m8.y(iZ);
                        iY9 = m8.y(i20);
                        iY3 = iY9 + iY8;
                        i10 += iY3 + iZ;
                        break;
                    } else {
                        break;
                    }
                case 39:
                    iZ = na.G((List) unsafe.getObject(obj, j10));
                    if (iZ > 0) {
                        int i21 = i12 << 3;
                        iY8 = m8.y(iZ);
                        iY9 = m8.y(i21);
                        iY3 = iY9 + iY8;
                        i10 += iY3 + iZ;
                        break;
                    } else {
                        break;
                    }
                case 40:
                    iZ = na.D((List) unsafe.getObject(obj, j10));
                    if (iZ > 0) {
                        int i22 = i12 << 3;
                        iY8 = m8.y(iZ);
                        iY9 = m8.y(i22);
                        iY3 = iY9 + iY8;
                        i10 += iY3 + iZ;
                        break;
                    } else {
                        break;
                    }
                case 41:
                    iZ = na.B((List) unsafe.getObject(obj, j10));
                    if (iZ > 0) {
                        int i23 = i12 << 3;
                        iY8 = m8.y(iZ);
                        iY9 = m8.y(i23);
                        iY3 = iY9 + iY8;
                        i10 += iY3 + iZ;
                        break;
                    } else {
                        break;
                    }
                case 42:
                    List list = (List) unsafe.getObject(obj, j10);
                    Class cls = na.f3633a;
                    iZ = list.size();
                    if (iZ > 0) {
                        int i24 = i12 << 3;
                        iY8 = m8.y(iZ);
                        iY9 = m8.y(i24);
                        iY3 = iY9 + iY8;
                        i10 += iY3 + iZ;
                        break;
                    } else {
                        break;
                    }
                case 43:
                    iZ = na.R((List) unsafe.getObject(obj, j10));
                    if (iZ > 0) {
                        int i25 = i12 << 3;
                        iY8 = m8.y(iZ);
                        iY9 = m8.y(i25);
                        iY3 = iY9 + iY8;
                        i10 += iY3 + iZ;
                        break;
                    } else {
                        break;
                    }
                case 44:
                    iZ = na.z((List) unsafe.getObject(obj, j10));
                    if (iZ > 0) {
                        int i26 = i12 << 3;
                        iY8 = m8.y(iZ);
                        iY9 = m8.y(i26);
                        iY3 = iY9 + iY8;
                        i10 += iY3 + iZ;
                        break;
                    } else {
                        break;
                    }
                case 45:
                    iZ = na.B((List) unsafe.getObject(obj, j10));
                    if (iZ > 0) {
                        int i27 = i12 << 3;
                        iY8 = m8.y(iZ);
                        iY9 = m8.y(i27);
                        iY3 = iY9 + iY8;
                        i10 += iY3 + iZ;
                        break;
                    } else {
                        break;
                    }
                case 46:
                    iZ = na.D((List) unsafe.getObject(obj, j10));
                    if (iZ > 0) {
                        int i28 = i12 << 3;
                        iY8 = m8.y(iZ);
                        iY9 = m8.y(i28);
                        iY3 = iY9 + iY8;
                        i10 += iY3 + iZ;
                        break;
                    } else {
                        break;
                    }
                case 47:
                    iZ = na.M((List) unsafe.getObject(obj, j10));
                    if (iZ > 0) {
                        int i29 = i12 << 3;
                        iY8 = m8.y(iZ);
                        iY9 = m8.y(i29);
                        iY3 = iY9 + iY8;
                        i10 += iY3 + iZ;
                        break;
                    } else {
                        break;
                    }
                case 48:
                    iZ = na.O((List) unsafe.getObject(obj, j10));
                    if (iZ > 0) {
                        int i30 = i12 << 3;
                        iY8 = m8.y(iZ);
                        iY9 = m8.y(i30);
                        iY3 = iY9 + iY8;
                        i10 += iY3 + iZ;
                        break;
                    } else {
                        break;
                    }
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
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (C(obj, i12, i11)) {
                        iY2 = m8.y(i12 << 3);
                        iJ = iY2 + 4;
                        i10 += iJ;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (C(obj, i12, i11)) {
                        iZ = m8.z(V(obj, j10));
                        iY3 = m8.y(i12 << 3);
                        i10 += iY3 + iZ;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (C(obj, i12, i11)) {
                        iZ = m8.z(V(obj, j10));
                        iY3 = m8.y(i12 << 3);
                        i10 += iY3 + iZ;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (C(obj, i12, i11)) {
                        iZ = m8.v(L(obj, j10));
                        iY3 = m8.y(i12 << 3);
                        i10 += iY3 + iZ;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (C(obj, i12, i11)) {
                        iY = m8.y(i12 << 3);
                        iJ = iY + 8;
                        i10 += iJ;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (C(obj, i12, i11)) {
                        iY2 = m8.y(i12 << 3);
                        iJ = iY2 + 4;
                        i10 += iJ;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (C(obj, i12, i11)) {
                        iY4 = m8.y(i12 << 3);
                        iJ = iY4 + 1;
                        i10 += iJ;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (C(obj, i12, i11)) {
                        Object objK2 = ab.k(obj, j10);
                        if (objK2 instanceof zzka) {
                            int i31 = i12 << 3;
                            Logger logger3 = m8.f3620b;
                            int iZzd3 = ((zzka) objK2).zzd();
                            iY5 = m8.y(iZzd3) + iZzd3;
                            iY6 = m8.y(i31);
                            iJ = iY6 + iY5;
                            i10 += iJ;
                            break;
                        } else {
                            iZ = m8.x((String) objK2);
                            iY3 = m8.y(i12 << 3);
                            i10 += iY3 + iZ;
                            break;
                        }
                    } else {
                        break;
                    }
                case 60:
                    if (C(obj, i12, i11)) {
                        iJ = na.J(i12, ab.k(obj, j10), k(i11));
                        i10 += iJ;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (C(obj, i12, i11)) {
                        zzka zzkaVar2 = (zzka) ab.k(obj, j10);
                        int i32 = i12 << 3;
                        Logger logger4 = m8.f3620b;
                        int iZzd4 = zzkaVar2.zzd();
                        iY5 = m8.y(iZzd4) + iZzd4;
                        iY6 = m8.y(i32);
                        iJ = iY6 + iY5;
                        i10 += iJ;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (C(obj, i12, i11)) {
                        iZ = m8.y(L(obj, j10));
                        iY3 = m8.y(i12 << 3);
                        i10 += iY3 + iZ;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (C(obj, i12, i11)) {
                        iZ = m8.v(L(obj, j10));
                        iY3 = m8.y(i12 << 3);
                        i10 += iY3 + iZ;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (C(obj, i12, i11)) {
                        iY2 = m8.y(i12 << 3);
                        iJ = iY2 + 4;
                        i10 += iJ;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (C(obj, i12, i11)) {
                        iY = m8.y(i12 << 3);
                        iJ = iY + 8;
                        i10 += iJ;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (C(obj, i12, i11)) {
                        int iL = L(obj, j10);
                        iY3 = m8.y(i12 << 3);
                        iZ = m8.y((iL >> 31) ^ (iL + iL));
                        i10 += iY3 + iZ;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (C(obj, i12, i11)) {
                        long jV = V(obj, j10);
                        iY7 = m8.y(i12 << 3);
                        iZ2 = m8.z((jV >> 63) ^ (jV + jV));
                        iJ = iY7 + iZ2;
                        i10 += iJ;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (C(obj, i12, i11)) {
                        iJ = m8.u(i12, (aa) ab.k(obj, j10), k(i11));
                        i10 += iJ;
                        break;
                    } else {
                        break;
                    }
            }
        }
        qa qaVar = this.f3460l;
        return i10 + qaVar.a(qaVar.d(obj));
    }

    @Override // com.google.android.gms.internal.measurement.la
    public final void h(Object obj, Object obj2) {
        p(obj);
        obj2.getClass();
        for (int i10 = 0; i10 < this.f3449a.length; i10 += 3) {
            int iU = U(i10);
            int i11 = this.f3449a[i10];
            long j10 = 1048575 & iU;
            switch (T(iU)) {
                case 0:
                    if (y(obj2, i10)) {
                        ab.t(obj, j10, ab.f(obj2, j10));
                        s(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (y(obj2, i10)) {
                        ab.u(obj, j10, ab.g(obj2, j10));
                        s(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (y(obj2, i10)) {
                        ab.w(obj, j10, ab.i(obj2, j10));
                        s(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case WebSettingsBoundaryInterface.AttributionBehavior.APP_SOURCE_AND_APP_TRIGGER /* 3 */:
                    if (y(obj2, i10)) {
                        ab.w(obj, j10, ab.i(obj2, j10));
                        s(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (y(obj2, i10)) {
                        ab.v(obj, j10, ab.h(obj2, j10));
                        s(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (y(obj2, i10)) {
                        ab.w(obj, j10, ab.i(obj2, j10));
                        s(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (y(obj2, i10)) {
                        ab.v(obj, j10, ab.h(obj2, j10));
                        s(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (y(obj2, i10)) {
                        ab.r(obj, j10, ab.B(obj2, j10));
                        s(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (y(obj2, i10)) {
                        ab.x(obj, j10, ab.k(obj2, j10));
                        s(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    q(obj, obj2, i10);
                    break;
                case 10:
                    if (y(obj2, i10)) {
                        ab.x(obj, j10, ab.k(obj2, j10));
                        s(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (y(obj2, i10)) {
                        ab.v(obj, j10, ab.h(obj2, j10));
                        s(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (y(obj2, i10)) {
                        ab.v(obj, j10, ab.h(obj2, j10));
                        s(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (y(obj2, i10)) {
                        ab.v(obj, j10, ab.h(obj2, j10));
                        s(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (y(obj2, i10)) {
                        ab.w(obj, j10, ab.i(obj2, j10));
                        s(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (y(obj2, i10)) {
                        ab.v(obj, j10, ab.h(obj2, j10));
                        s(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (y(obj2, i10)) {
                        ab.w(obj, j10, ab.i(obj2, j10));
                        s(obj, i10);
                        break;
                    } else {
                        break;
                    }
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
                    this.f3459k.b(obj, obj2, j10);
                    break;
                case 50:
                    Class cls = na.f3633a;
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
                        break;
                    } else {
                        break;
                    }
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
                        break;
                    } else {
                        break;
                    }
                case 68:
                    r(obj, obj2, i10);
                    break;
            }
        }
        na.b(this.f3460l, obj, obj2);
        if (this.f3454f) {
            this.f3461m.a(obj2);
            throw null;
        }
    }

    @Override // com.google.android.gms.internal.measurement.la
    public final boolean i(Object obj, Object obj2) {
        boolean zV;
        int length = this.f3449a.length;
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
                case 1:
                    if (!x(obj, obj2, i10) || Float.floatToIntBits(ab.g(obj, j10)) != Float.floatToIntBits(ab.g(obj2, j10))) {
                        return false;
                    }
                    continue;
                    break;
                case 2:
                    if (!x(obj, obj2, i10) || ab.i(obj, j10) != ab.i(obj2, j10)) {
                        return false;
                    }
                    continue;
                    break;
                case WebSettingsBoundaryInterface.AttributionBehavior.APP_SOURCE_AND_APP_TRIGGER /* 3 */:
                    if (!x(obj, obj2, i10) || ab.i(obj, j10) != ab.i(obj2, j10)) {
                        return false;
                    }
                    continue;
                    break;
                case 4:
                    if (!x(obj, obj2, i10) || ab.h(obj, j10) != ab.h(obj2, j10)) {
                        return false;
                    }
                    continue;
                    break;
                case 5:
                    if (!x(obj, obj2, i10) || ab.i(obj, j10) != ab.i(obj2, j10)) {
                        return false;
                    }
                    continue;
                    break;
                case 6:
                    if (!x(obj, obj2, i10) || ab.h(obj, j10) != ab.h(obj2, j10)) {
                        return false;
                    }
                    continue;
                    break;
                case 7:
                    if (!x(obj, obj2, i10) || ab.B(obj, j10) != ab.B(obj2, j10)) {
                        return false;
                    }
                    continue;
                    break;
                case 8:
                    if (!x(obj, obj2, i10) || !na.v(ab.k(obj, j10), ab.k(obj2, j10))) {
                        return false;
                    }
                    continue;
                    break;
                case 9:
                    if (!x(obj, obj2, i10) || !na.v(ab.k(obj, j10), ab.k(obj2, j10))) {
                        return false;
                    }
                    continue;
                    break;
                case 10:
                    if (!x(obj, obj2, i10) || !na.v(ab.k(obj, j10), ab.k(obj2, j10))) {
                        return false;
                    }
                    continue;
                    break;
                case 11:
                    if (!x(obj, obj2, i10) || ab.h(obj, j10) != ab.h(obj2, j10)) {
                        return false;
                    }
                    continue;
                    break;
                case 12:
                    if (!x(obj, obj2, i10) || ab.h(obj, j10) != ab.h(obj2, j10)) {
                        return false;
                    }
                    continue;
                    break;
                case 13:
                    if (!x(obj, obj2, i10) || ab.h(obj, j10) != ab.h(obj2, j10)) {
                        return false;
                    }
                    continue;
                    break;
                case 14:
                    if (!x(obj, obj2, i10) || ab.i(obj, j10) != ab.i(obj2, j10)) {
                        return false;
                    }
                    continue;
                    break;
                case 15:
                    if (!x(obj, obj2, i10) || ab.h(obj, j10) != ab.h(obj2, j10)) {
                        return false;
                    }
                    continue;
                    break;
                case 16:
                    if (!x(obj, obj2, i10) || ab.i(obj, j10) != ab.i(obj2, j10)) {
                        return false;
                    }
                    continue;
                    break;
                case 17:
                    if (!x(obj, obj2, i10) || !na.v(ab.k(obj, j10), ab.k(obj2, j10))) {
                        return false;
                    }
                    continue;
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
                default:
            }
            if (!zV) {
                return false;
            }
        }
        if (!this.f3460l.d(obj).equals(this.f3460l.d(obj2))) {
            return false;
        }
        if (!this.f3454f) {
            return true;
        }
        this.f3461m.a(obj);
        this.f3461m.a(obj2);
        throw null;
    }

    public final d9 j(int i10) {
        int i11 = i10 / 3;
        return (d9) this.f3450b[i11 + i11 + 1];
    }

    public final la k(int i10) {
        int i11 = i10 / 3;
        int i12 = i11 + i11;
        la laVar = (la) this.f3450b[i12];
        if (laVar != null) {
            return laVar;
        }
        la laVarB = ia.a().b((Class) this.f3450b[i12 + 1]);
        this.f3450b[i12] = laVarB;
        return laVarB;
    }

    public final Object l(int i10) {
        int i11 = i10 / 3;
        return this.f3450b[i11 + i11];
    }

    public final Object m(Object obj, int i10) {
        la laVarK = k(i10);
        int iU = U(i10) & 1048575;
        if (!y(obj, i10)) {
            return laVarK.d();
        }
        Object object = f3448q.getObject(obj, iU);
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
        Object object = f3448q.getObject(obj, U(i11) & 1048575);
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
            Unsafe unsafe = f3448q;
            long j10 = iU;
            Object object = unsafe.getObject(obj2, j10);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.f3449a[i10] + " is present but null: " + obj2.toString());
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
        int i11 = this.f3449a[i10];
        if (C(obj2, i11, i10)) {
            int iU = U(i10) & 1048575;
            Unsafe unsafe = f3448q;
            long j10 = iU;
            Object object = unsafe.getObject(obj2, j10);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.f3449a[i10] + " is present but null: " + obj2.toString());
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
        f3448q.putObject(obj, U(i10) & 1048575, obj2);
        s(obj, i10);
    }

    public final void v(Object obj, int i10, int i11, Object obj2) {
        f3448q.putObject(obj, U(i11) & 1048575, obj2);
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
            case WebSettingsBoundaryInterface.AttributionBehavior.APP_SOURCE_AND_APP_TRIGGER /* 3 */:
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
        return i11 == 1048575 ? y(obj, i10) : (i12 & i13) != 0;
    }
}
