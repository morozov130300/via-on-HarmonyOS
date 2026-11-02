package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class pa {
    public static String a(zzka zzkaVar) {
        StringBuilder sb2 = new StringBuilder(zzkaVar.zzd());
        for (int i10 = 0; i10 < zzkaVar.zzd(); i10++) {
            byte bZza = zzkaVar.zza(i10);
            if (bZza == 34) {
                sb2.append("\\\"");
            } else if (bZza == 39) {
                sb2.append("\\'");
            } else if (bZza != 92) {
                switch (bZza) {
                    case 7:
                        sb2.append("\\a");
                        break;
                    case 8:
                        sb2.append("\\b");
                        break;
                    case 9:
                        sb2.append("\\t");
                        break;
                    case 10:
                        sb2.append("\\n");
                        break;
                    case 11:
                        sb2.append("\\v");
                        break;
                    case 12:
                        sb2.append("\\f");
                        break;
                    case 13:
                        sb2.append("\\r");
                        break;
                    default:
                        if (bZza < 32 || bZza > 126) {
                            sb2.append('\\');
                            sb2.append((char) (((bZza >>> 6) & 3) + 48));
                            sb2.append((char) (((bZza >>> 3) & 7) + 48));
                            sb2.append((char) ((bZza & 7) + 48));
                            break;
                        } else {
                            sb2.append((char) bZza);
                            break;
                        }
                }
            } else {
                sb2.append("\\\\");
            }
        }
        return sb2.toString();
    }
}
