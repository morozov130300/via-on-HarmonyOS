package com.google.android.gms.internal.measurement;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'zzb' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:422)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:351)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class zzlm {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ zzlm[] f3242c;
    public static final zzlm zza;
    public static final zzlm zzb;
    public static final zzlm zzc;
    public static final zzlm zzd;
    public static final zzlm zze;
    public static final zzlm zzf;
    public static final zzlm zzg;
    public static final zzlm zzh;
    public static final zzlm zzi;
    public static final zzlm zzj;
    private final Class zzl;
    private final Class zzm;
    private final Object zzn;

    static {
        zzlm zzlmVar = new zzlm("VOID", 0, Void.class, Void.class, null);
        zza = zzlmVar;
        Class cls = Integer.TYPE;
        zzlm zzlmVar2 = new zzlm("INT", 1, cls, Integer.class, 0);
        zzb = zzlmVar2;
        zzlm zzlmVar3 = new zzlm("LONG", 2, Long.TYPE, Long.class, 0L);
        zzc = zzlmVar3;
        zzlm zzlmVar4 = new zzlm("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(0.0f));
        zzd = zzlmVar4;
        zzlm zzlmVar5 = new zzlm("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf(0.0d));
        zze = zzlmVar5;
        zzlm zzlmVar6 = new zzlm("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
        zzf = zzlmVar6;
        zzlm zzlmVar7 = new zzlm("STRING", 6, String.class, String.class, "");
        zzg = zzlmVar7;
        zzlm zzlmVar8 = new zzlm("BYTE_STRING", 7, zzka.class, zzka.class, zzka.zzb);
        zzh = zzlmVar8;
        zzlm zzlmVar9 = new zzlm("ENUM", 8, cls, Integer.class, null);
        zzi = zzlmVar9;
        zzlm zzlmVar10 = new zzlm("MESSAGE", 9, Object.class, Object.class, null);
        zzj = zzlmVar10;
        f3242c = new zzlm[]{zzlmVar, zzlmVar2, zzlmVar3, zzlmVar4, zzlmVar5, zzlmVar6, zzlmVar7, zzlmVar8, zzlmVar9, zzlmVar10};
    }

    public zzlm(String str, int i10, Class cls, Class cls2, Object obj) {
        super(str, i10);
        this.zzl = cls;
        this.zzm = cls2;
        this.zzn = obj;
    }

    public static zzlm[] values() {
        return (zzlm[]) f3242c.clone();
    }

    public final Class zza() {
        return this.zzm;
    }
}
