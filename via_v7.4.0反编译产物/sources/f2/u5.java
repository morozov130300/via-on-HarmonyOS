package f2;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.internal.measurement.ae;
import com.google.android.gms.internal.measurement.ed;
import com.google.android.gms.measurement.internal.zzau;
import com.google.android.gms.measurement.internal.zzha;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class u5 implements Callable {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzau f5725e;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ String f5726j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ z5 f5727k;

    public u5(z5 z5Var, zzau zzauVar, String str) {
        this.f5727k = z5Var;
        this.f5725e = zzauVar;
        this.f5726j = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x037b  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x038c A[Catch: all -> 0x00a9, LOOP:2: B:114:0x0386->B:116:0x038c, LOOP_END, TryCatch #2 {all -> 0x00a9, blocks: (B:13:0x0082, B:15:0x008e, B:20:0x00ac, B:22:0x00b2, B:25:0x00cd, B:27:0x00e4, B:28:0x00eb, B:30:0x00f5, B:31:0x0102, B:33:0x010c, B:34:0x0119, B:36:0x0124, B:37:0x012c, B:39:0x0148, B:43:0x0155, B:45:0x0166, B:46:0x016d, B:48:0x0182, B:50:0x0192, B:52:0x019a, B:54:0x01a0, B:55:0x01a3, B:57:0x01b2, B:59:0x01b8, B:61:0x01cc, B:63:0x01d6, B:64:0x01e9, B:66:0x01ed, B:72:0x021a, B:73:0x0251, B:75:0x025b, B:77:0x0261, B:81:0x027c, B:83:0x0286, B:84:0x0293, B:85:0x02a5, B:87:0x02ab, B:94:0x02c3, B:97:0x02ee, B:99:0x030f, B:101:0x031d, B:103:0x0329, B:104:0x033c, B:106:0x0342, B:108:0x0352, B:109:0x0355, B:113:0x0380, B:114:0x0386, B:116:0x038c, B:117:0x03c2, B:119:0x0429, B:120:0x043d, B:122:0x044b, B:125:0x047d, B:126:0x04b5, B:128:0x04bb, B:130:0x04ce, B:131:0x04db, B:133:0x0523, B:134:0x0531, B:136:0x0539, B:137:0x053c, B:139:0x0544, B:143:0x054f, B:146:0x0566, B:147:0x0569, B:149:0x05a1, B:150:0x05aa, B:142:0x054c, B:124:0x046e, B:96:0x02c7, B:156:0x0603, B:68:0x01f8, B:40:0x014c, B:42:0x0152), top: B:166:0x0082, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0429 A[Catch: all -> 0x00a9, TryCatch #2 {all -> 0x00a9, blocks: (B:13:0x0082, B:15:0x008e, B:20:0x00ac, B:22:0x00b2, B:25:0x00cd, B:27:0x00e4, B:28:0x00eb, B:30:0x00f5, B:31:0x0102, B:33:0x010c, B:34:0x0119, B:36:0x0124, B:37:0x012c, B:39:0x0148, B:43:0x0155, B:45:0x0166, B:46:0x016d, B:48:0x0182, B:50:0x0192, B:52:0x019a, B:54:0x01a0, B:55:0x01a3, B:57:0x01b2, B:59:0x01b8, B:61:0x01cc, B:63:0x01d6, B:64:0x01e9, B:66:0x01ed, B:72:0x021a, B:73:0x0251, B:75:0x025b, B:77:0x0261, B:81:0x027c, B:83:0x0286, B:84:0x0293, B:85:0x02a5, B:87:0x02ab, B:94:0x02c3, B:97:0x02ee, B:99:0x030f, B:101:0x031d, B:103:0x0329, B:104:0x033c, B:106:0x0342, B:108:0x0352, B:109:0x0355, B:113:0x0380, B:114:0x0386, B:116:0x038c, B:117:0x03c2, B:119:0x0429, B:120:0x043d, B:122:0x044b, B:125:0x047d, B:126:0x04b5, B:128:0x04bb, B:130:0x04ce, B:131:0x04db, B:133:0x0523, B:134:0x0531, B:136:0x0539, B:137:0x053c, B:139:0x0544, B:143:0x054f, B:146:0x0566, B:147:0x0569, B:149:0x05a1, B:150:0x05aa, B:142:0x054c, B:124:0x046e, B:96:0x02c7, B:156:0x0603, B:68:0x01f8, B:40:0x014c, B:42:0x0152), top: B:166:0x0082, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x044b A[Catch: all -> 0x00a9, TryCatch #2 {all -> 0x00a9, blocks: (B:13:0x0082, B:15:0x008e, B:20:0x00ac, B:22:0x00b2, B:25:0x00cd, B:27:0x00e4, B:28:0x00eb, B:30:0x00f5, B:31:0x0102, B:33:0x010c, B:34:0x0119, B:36:0x0124, B:37:0x012c, B:39:0x0148, B:43:0x0155, B:45:0x0166, B:46:0x016d, B:48:0x0182, B:50:0x0192, B:52:0x019a, B:54:0x01a0, B:55:0x01a3, B:57:0x01b2, B:59:0x01b8, B:61:0x01cc, B:63:0x01d6, B:64:0x01e9, B:66:0x01ed, B:72:0x021a, B:73:0x0251, B:75:0x025b, B:77:0x0261, B:81:0x027c, B:83:0x0286, B:84:0x0293, B:85:0x02a5, B:87:0x02ab, B:94:0x02c3, B:97:0x02ee, B:99:0x030f, B:101:0x031d, B:103:0x0329, B:104:0x033c, B:106:0x0342, B:108:0x0352, B:109:0x0355, B:113:0x0380, B:114:0x0386, B:116:0x038c, B:117:0x03c2, B:119:0x0429, B:120:0x043d, B:122:0x044b, B:125:0x047d, B:126:0x04b5, B:128:0x04bb, B:130:0x04ce, B:131:0x04db, B:133:0x0523, B:134:0x0531, B:136:0x0539, B:137:0x053c, B:139:0x0544, B:143:0x054f, B:146:0x0566, B:147:0x0569, B:149:0x05a1, B:150:0x05aa, B:142:0x054c, B:124:0x046e, B:96:0x02c7, B:156:0x0603, B:68:0x01f8, B:40:0x014c, B:42:0x0152), top: B:166:0x0082, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:124:0x046e A[Catch: all -> 0x00a9, TryCatch #2 {all -> 0x00a9, blocks: (B:13:0x0082, B:15:0x008e, B:20:0x00ac, B:22:0x00b2, B:25:0x00cd, B:27:0x00e4, B:28:0x00eb, B:30:0x00f5, B:31:0x0102, B:33:0x010c, B:34:0x0119, B:36:0x0124, B:37:0x012c, B:39:0x0148, B:43:0x0155, B:45:0x0166, B:46:0x016d, B:48:0x0182, B:50:0x0192, B:52:0x019a, B:54:0x01a0, B:55:0x01a3, B:57:0x01b2, B:59:0x01b8, B:61:0x01cc, B:63:0x01d6, B:64:0x01e9, B:66:0x01ed, B:72:0x021a, B:73:0x0251, B:75:0x025b, B:77:0x0261, B:81:0x027c, B:83:0x0286, B:84:0x0293, B:85:0x02a5, B:87:0x02ab, B:94:0x02c3, B:97:0x02ee, B:99:0x030f, B:101:0x031d, B:103:0x0329, B:104:0x033c, B:106:0x0342, B:108:0x0352, B:109:0x0355, B:113:0x0380, B:114:0x0386, B:116:0x038c, B:117:0x03c2, B:119:0x0429, B:120:0x043d, B:122:0x044b, B:125:0x047d, B:126:0x04b5, B:128:0x04bb, B:130:0x04ce, B:131:0x04db, B:133:0x0523, B:134:0x0531, B:136:0x0539, B:137:0x053c, B:139:0x0544, B:143:0x054f, B:146:0x0566, B:147:0x0569, B:149:0x05a1, B:150:0x05aa, B:142:0x054c, B:124:0x046e, B:96:0x02c7, B:156:0x0603, B:68:0x01f8, B:40:0x014c, B:42:0x0152), top: B:166:0x0082, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:128:0x04bb A[Catch: all -> 0x00a9, TryCatch #2 {all -> 0x00a9, blocks: (B:13:0x0082, B:15:0x008e, B:20:0x00ac, B:22:0x00b2, B:25:0x00cd, B:27:0x00e4, B:28:0x00eb, B:30:0x00f5, B:31:0x0102, B:33:0x010c, B:34:0x0119, B:36:0x0124, B:37:0x012c, B:39:0x0148, B:43:0x0155, B:45:0x0166, B:46:0x016d, B:48:0x0182, B:50:0x0192, B:52:0x019a, B:54:0x01a0, B:55:0x01a3, B:57:0x01b2, B:59:0x01b8, B:61:0x01cc, B:63:0x01d6, B:64:0x01e9, B:66:0x01ed, B:72:0x021a, B:73:0x0251, B:75:0x025b, B:77:0x0261, B:81:0x027c, B:83:0x0286, B:84:0x0293, B:85:0x02a5, B:87:0x02ab, B:94:0x02c3, B:97:0x02ee, B:99:0x030f, B:101:0x031d, B:103:0x0329, B:104:0x033c, B:106:0x0342, B:108:0x0352, B:109:0x0355, B:113:0x0380, B:114:0x0386, B:116:0x038c, B:117:0x03c2, B:119:0x0429, B:120:0x043d, B:122:0x044b, B:125:0x047d, B:126:0x04b5, B:128:0x04bb, B:130:0x04ce, B:131:0x04db, B:133:0x0523, B:134:0x0531, B:136:0x0539, B:137:0x053c, B:139:0x0544, B:143:0x054f, B:146:0x0566, B:147:0x0569, B:149:0x05a1, B:150:0x05aa, B:142:0x054c, B:124:0x046e, B:96:0x02c7, B:156:0x0603, B:68:0x01f8, B:40:0x014c, B:42:0x0152), top: B:166:0x0082, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0523 A[Catch: all -> 0x00a9, TryCatch #2 {all -> 0x00a9, blocks: (B:13:0x0082, B:15:0x008e, B:20:0x00ac, B:22:0x00b2, B:25:0x00cd, B:27:0x00e4, B:28:0x00eb, B:30:0x00f5, B:31:0x0102, B:33:0x010c, B:34:0x0119, B:36:0x0124, B:37:0x012c, B:39:0x0148, B:43:0x0155, B:45:0x0166, B:46:0x016d, B:48:0x0182, B:50:0x0192, B:52:0x019a, B:54:0x01a0, B:55:0x01a3, B:57:0x01b2, B:59:0x01b8, B:61:0x01cc, B:63:0x01d6, B:64:0x01e9, B:66:0x01ed, B:72:0x021a, B:73:0x0251, B:75:0x025b, B:77:0x0261, B:81:0x027c, B:83:0x0286, B:84:0x0293, B:85:0x02a5, B:87:0x02ab, B:94:0x02c3, B:97:0x02ee, B:99:0x030f, B:101:0x031d, B:103:0x0329, B:104:0x033c, B:106:0x0342, B:108:0x0352, B:109:0x0355, B:113:0x0380, B:114:0x0386, B:116:0x038c, B:117:0x03c2, B:119:0x0429, B:120:0x043d, B:122:0x044b, B:125:0x047d, B:126:0x04b5, B:128:0x04bb, B:130:0x04ce, B:131:0x04db, B:133:0x0523, B:134:0x0531, B:136:0x0539, B:137:0x053c, B:139:0x0544, B:143:0x054f, B:146:0x0566, B:147:0x0569, B:149:0x05a1, B:150:0x05aa, B:142:0x054c, B:124:0x046e, B:96:0x02c7, B:156:0x0603, B:68:0x01f8, B:40:0x014c, B:42:0x0152), top: B:166:0x0082, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0539 A[Catch: all -> 0x00a9, TryCatch #2 {all -> 0x00a9, blocks: (B:13:0x0082, B:15:0x008e, B:20:0x00ac, B:22:0x00b2, B:25:0x00cd, B:27:0x00e4, B:28:0x00eb, B:30:0x00f5, B:31:0x0102, B:33:0x010c, B:34:0x0119, B:36:0x0124, B:37:0x012c, B:39:0x0148, B:43:0x0155, B:45:0x0166, B:46:0x016d, B:48:0x0182, B:50:0x0192, B:52:0x019a, B:54:0x01a0, B:55:0x01a3, B:57:0x01b2, B:59:0x01b8, B:61:0x01cc, B:63:0x01d6, B:64:0x01e9, B:66:0x01ed, B:72:0x021a, B:73:0x0251, B:75:0x025b, B:77:0x0261, B:81:0x027c, B:83:0x0286, B:84:0x0293, B:85:0x02a5, B:87:0x02ab, B:94:0x02c3, B:97:0x02ee, B:99:0x030f, B:101:0x031d, B:103:0x0329, B:104:0x033c, B:106:0x0342, B:108:0x0352, B:109:0x0355, B:113:0x0380, B:114:0x0386, B:116:0x038c, B:117:0x03c2, B:119:0x0429, B:120:0x043d, B:122:0x044b, B:125:0x047d, B:126:0x04b5, B:128:0x04bb, B:130:0x04ce, B:131:0x04db, B:133:0x0523, B:134:0x0531, B:136:0x0539, B:137:0x053c, B:139:0x0544, B:143:0x054f, B:146:0x0566, B:147:0x0569, B:149:0x05a1, B:150:0x05aa, B:142:0x054c, B:124:0x046e, B:96:0x02c7, B:156:0x0603, B:68:0x01f8, B:40:0x014c, B:42:0x0152), top: B:166:0x0082, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0544 A[Catch: all -> 0x00a9, TryCatch #2 {all -> 0x00a9, blocks: (B:13:0x0082, B:15:0x008e, B:20:0x00ac, B:22:0x00b2, B:25:0x00cd, B:27:0x00e4, B:28:0x00eb, B:30:0x00f5, B:31:0x0102, B:33:0x010c, B:34:0x0119, B:36:0x0124, B:37:0x012c, B:39:0x0148, B:43:0x0155, B:45:0x0166, B:46:0x016d, B:48:0x0182, B:50:0x0192, B:52:0x019a, B:54:0x01a0, B:55:0x01a3, B:57:0x01b2, B:59:0x01b8, B:61:0x01cc, B:63:0x01d6, B:64:0x01e9, B:66:0x01ed, B:72:0x021a, B:73:0x0251, B:75:0x025b, B:77:0x0261, B:81:0x027c, B:83:0x0286, B:84:0x0293, B:85:0x02a5, B:87:0x02ab, B:94:0x02c3, B:97:0x02ee, B:99:0x030f, B:101:0x031d, B:103:0x0329, B:104:0x033c, B:106:0x0342, B:108:0x0352, B:109:0x0355, B:113:0x0380, B:114:0x0386, B:116:0x038c, B:117:0x03c2, B:119:0x0429, B:120:0x043d, B:122:0x044b, B:125:0x047d, B:126:0x04b5, B:128:0x04bb, B:130:0x04ce, B:131:0x04db, B:133:0x0523, B:134:0x0531, B:136:0x0539, B:137:0x053c, B:139:0x0544, B:143:0x054f, B:146:0x0566, B:147:0x0569, B:149:0x05a1, B:150:0x05aa, B:142:0x054c, B:124:0x046e, B:96:0x02c7, B:156:0x0603, B:68:0x01f8, B:40:0x014c, B:42:0x0152), top: B:166:0x0082, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0548  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0564 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:149:0x05a1 A[Catch: all -> 0x00a9, TryCatch #2 {all -> 0x00a9, blocks: (B:13:0x0082, B:15:0x008e, B:20:0x00ac, B:22:0x00b2, B:25:0x00cd, B:27:0x00e4, B:28:0x00eb, B:30:0x00f5, B:31:0x0102, B:33:0x010c, B:34:0x0119, B:36:0x0124, B:37:0x012c, B:39:0x0148, B:43:0x0155, B:45:0x0166, B:46:0x016d, B:48:0x0182, B:50:0x0192, B:52:0x019a, B:54:0x01a0, B:55:0x01a3, B:57:0x01b2, B:59:0x01b8, B:61:0x01cc, B:63:0x01d6, B:64:0x01e9, B:66:0x01ed, B:72:0x021a, B:73:0x0251, B:75:0x025b, B:77:0x0261, B:81:0x027c, B:83:0x0286, B:84:0x0293, B:85:0x02a5, B:87:0x02ab, B:94:0x02c3, B:97:0x02ee, B:99:0x030f, B:101:0x031d, B:103:0x0329, B:104:0x033c, B:106:0x0342, B:108:0x0352, B:109:0x0355, B:113:0x0380, B:114:0x0386, B:116:0x038c, B:117:0x03c2, B:119:0x0429, B:120:0x043d, B:122:0x044b, B:125:0x047d, B:126:0x04b5, B:128:0x04bb, B:130:0x04ce, B:131:0x04db, B:133:0x0523, B:134:0x0531, B:136:0x0539, B:137:0x053c, B:139:0x0544, B:143:0x054f, B:146:0x0566, B:147:0x0569, B:149:0x05a1, B:150:0x05aa, B:142:0x054c, B:124:0x046e, B:96:0x02c7, B:156:0x0603, B:68:0x01f8, B:40:0x014c, B:42:0x0152), top: B:166:0x0082, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:169:0x02be A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0286 A[Catch: all -> 0x00a9, TryCatch #2 {all -> 0x00a9, blocks: (B:13:0x0082, B:15:0x008e, B:20:0x00ac, B:22:0x00b2, B:25:0x00cd, B:27:0x00e4, B:28:0x00eb, B:30:0x00f5, B:31:0x0102, B:33:0x010c, B:34:0x0119, B:36:0x0124, B:37:0x012c, B:39:0x0148, B:43:0x0155, B:45:0x0166, B:46:0x016d, B:48:0x0182, B:50:0x0192, B:52:0x019a, B:54:0x01a0, B:55:0x01a3, B:57:0x01b2, B:59:0x01b8, B:61:0x01cc, B:63:0x01d6, B:64:0x01e9, B:66:0x01ed, B:72:0x021a, B:73:0x0251, B:75:0x025b, B:77:0x0261, B:81:0x027c, B:83:0x0286, B:84:0x0293, B:85:0x02a5, B:87:0x02ab, B:94:0x02c3, B:97:0x02ee, B:99:0x030f, B:101:0x031d, B:103:0x0329, B:104:0x033c, B:106:0x0342, B:108:0x0352, B:109:0x0355, B:113:0x0380, B:114:0x0386, B:116:0x038c, B:117:0x03c2, B:119:0x0429, B:120:0x043d, B:122:0x044b, B:125:0x047d, B:126:0x04b5, B:128:0x04bb, B:130:0x04ce, B:131:0x04db, B:133:0x0523, B:134:0x0531, B:136:0x0539, B:137:0x053c, B:139:0x0544, B:143:0x054f, B:146:0x0566, B:147:0x0569, B:149:0x05a1, B:150:0x05aa, B:142:0x054c, B:124:0x046e, B:96:0x02c7, B:156:0x0603, B:68:0x01f8, B:40:0x014c, B:42:0x0152), top: B:166:0x0082, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x02ab A[Catch: all -> 0x00a9, TryCatch #2 {all -> 0x00a9, blocks: (B:13:0x0082, B:15:0x008e, B:20:0x00ac, B:22:0x00b2, B:25:0x00cd, B:27:0x00e4, B:28:0x00eb, B:30:0x00f5, B:31:0x0102, B:33:0x010c, B:34:0x0119, B:36:0x0124, B:37:0x012c, B:39:0x0148, B:43:0x0155, B:45:0x0166, B:46:0x016d, B:48:0x0182, B:50:0x0192, B:52:0x019a, B:54:0x01a0, B:55:0x01a3, B:57:0x01b2, B:59:0x01b8, B:61:0x01cc, B:63:0x01d6, B:64:0x01e9, B:66:0x01ed, B:72:0x021a, B:73:0x0251, B:75:0x025b, B:77:0x0261, B:81:0x027c, B:83:0x0286, B:84:0x0293, B:85:0x02a5, B:87:0x02ab, B:94:0x02c3, B:97:0x02ee, B:99:0x030f, B:101:0x031d, B:103:0x0329, B:104:0x033c, B:106:0x0342, B:108:0x0352, B:109:0x0355, B:113:0x0380, B:114:0x0386, B:116:0x038c, B:117:0x03c2, B:119:0x0429, B:120:0x043d, B:122:0x044b, B:125:0x047d, B:126:0x04b5, B:128:0x04bb, B:130:0x04ce, B:131:0x04db, B:133:0x0523, B:134:0x0531, B:136:0x0539, B:137:0x053c, B:139:0x0544, B:143:0x054f, B:146:0x0566, B:147:0x0569, B:149:0x05a1, B:150:0x05aa, B:142:0x054c, B:124:0x046e, B:96:0x02c7, B:156:0x0603, B:68:0x01f8, B:40:0x014c, B:42:0x0152), top: B:166:0x0082, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x02c7 A[Catch: all -> 0x00a9, TryCatch #2 {all -> 0x00a9, blocks: (B:13:0x0082, B:15:0x008e, B:20:0x00ac, B:22:0x00b2, B:25:0x00cd, B:27:0x00e4, B:28:0x00eb, B:30:0x00f5, B:31:0x0102, B:33:0x010c, B:34:0x0119, B:36:0x0124, B:37:0x012c, B:39:0x0148, B:43:0x0155, B:45:0x0166, B:46:0x016d, B:48:0x0182, B:50:0x0192, B:52:0x019a, B:54:0x01a0, B:55:0x01a3, B:57:0x01b2, B:59:0x01b8, B:61:0x01cc, B:63:0x01d6, B:64:0x01e9, B:66:0x01ed, B:72:0x021a, B:73:0x0251, B:75:0x025b, B:77:0x0261, B:81:0x027c, B:83:0x0286, B:84:0x0293, B:85:0x02a5, B:87:0x02ab, B:94:0x02c3, B:97:0x02ee, B:99:0x030f, B:101:0x031d, B:103:0x0329, B:104:0x033c, B:106:0x0342, B:108:0x0352, B:109:0x0355, B:113:0x0380, B:114:0x0386, B:116:0x038c, B:117:0x03c2, B:119:0x0429, B:120:0x043d, B:122:0x044b, B:125:0x047d, B:126:0x04b5, B:128:0x04bb, B:130:0x04ce, B:131:0x04db, B:133:0x0523, B:134:0x0531, B:136:0x0539, B:137:0x053c, B:139:0x0544, B:143:0x054f, B:146:0x0566, B:147:0x0569, B:149:0x05a1, B:150:0x05aa, B:142:0x054c, B:124:0x046e, B:96:0x02c7, B:156:0x0603, B:68:0x01f8, B:40:0x014c, B:42:0x0152), top: B:166:0x0082, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x030f A[Catch: all -> 0x00a9, TryCatch #2 {all -> 0x00a9, blocks: (B:13:0x0082, B:15:0x008e, B:20:0x00ac, B:22:0x00b2, B:25:0x00cd, B:27:0x00e4, B:28:0x00eb, B:30:0x00f5, B:31:0x0102, B:33:0x010c, B:34:0x0119, B:36:0x0124, B:37:0x012c, B:39:0x0148, B:43:0x0155, B:45:0x0166, B:46:0x016d, B:48:0x0182, B:50:0x0192, B:52:0x019a, B:54:0x01a0, B:55:0x01a3, B:57:0x01b2, B:59:0x01b8, B:61:0x01cc, B:63:0x01d6, B:64:0x01e9, B:66:0x01ed, B:72:0x021a, B:73:0x0251, B:75:0x025b, B:77:0x0261, B:81:0x027c, B:83:0x0286, B:84:0x0293, B:85:0x02a5, B:87:0x02ab, B:94:0x02c3, B:97:0x02ee, B:99:0x030f, B:101:0x031d, B:103:0x0329, B:104:0x033c, B:106:0x0342, B:108:0x0352, B:109:0x0355, B:113:0x0380, B:114:0x0386, B:116:0x038c, B:117:0x03c2, B:119:0x0429, B:120:0x043d, B:122:0x044b, B:125:0x047d, B:126:0x04b5, B:128:0x04bb, B:130:0x04ce, B:131:0x04db, B:133:0x0523, B:134:0x0531, B:136:0x0539, B:137:0x053c, B:139:0x0544, B:143:0x054f, B:146:0x0566, B:147:0x0569, B:149:0x05a1, B:150:0x05aa, B:142:0x054c, B:124:0x046e, B:96:0x02c7, B:156:0x0603, B:68:0x01f8, B:40:0x014c, B:42:0x0152), top: B:166:0x0082, inners: #0, #1 }] */
    @Override // java.util.concurrent.Callable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* bridge */ /* synthetic */ Object call() {
        f6 f6Var;
        byte[] bArr;
        pa paVar;
        String strL0;
        List listC0;
        Iterator it;
        ta taVar;
        ra raVarG0;
        com.google.android.gms.internal.measurement.r4 r4Var;
        e6 e6Var;
        com.google.android.gms.internal.measurement.t4 t4Var;
        boolean z10;
        q qVarV;
        String str;
        e6 e6Var2;
        String str2;
        q qVarC;
        long j10;
        String str3;
        com.google.android.gms.internal.measurement.i4 i4VarH;
        r rVar;
        long jD0;
        long jF0;
        String strD;
        this.f5727k.f5871d.e();
        t7 t7VarD0 = this.f5727k.f5871d.d0();
        zzau zzauVar = this.f5725e;
        String str4 = this.f5726j;
        t7VarD0.h();
        h5.t();
        t1.f.h(zzauVar);
        t1.f.d(str4);
        if (!t7VarD0.f5030a.z().B(str4, i3.W)) {
            t7VarD0.f5030a.d().q().b("Generating ScionPayload disabled. packageName", str4);
            return new byte[0];
        }
        if (!"_iap".equals(zzauVar.f3964e) && !"_iapx".equals(zzauVar.f3964e)) {
            t7VarD0.f5030a.d().q().c("Generating a payload for this event is not available. package_name, event_name", str4, zzauVar.f3964e);
            return null;
        }
        com.google.android.gms.internal.measurement.r4 r4VarD = com.google.android.gms.internal.measurement.s4.D();
        t7VarD0.f5039b.V().e0();
        try {
            e6 e6VarR = t7VarD0.f5039b.V().R(str4);
            if (e6VarR == null) {
                t7VarD0.f5030a.d().q().b("Log and bundle not available. package_name", str4);
                return new byte[0];
            }
            if (!e6VarR.O()) {
                t7VarD0.f5030a.d().q().b("Log and bundle disabled. package_name", str4);
                return new byte[0];
            }
            com.google.android.gms.internal.measurement.t4 t4VarS1 = com.google.android.gms.internal.measurement.u4.S1();
            t4VarS1.W(1);
            t4VarS1.R("android");
            if (!TextUtils.isEmpty(e6VarR.l0())) {
                t4VarS1.v(e6VarR.l0());
            }
            if (!TextUtils.isEmpty(e6VarR.n0())) {
                t4VarS1.x((String) t1.f.h(e6VarR.n0()));
            }
            if (!TextUtils.isEmpty(e6VarR.o0())) {
                t4VarS1.y((String) t1.f.h(e6VarR.o0()));
            }
            if (e6VarR.R() != -2147483648L) {
                t4VarS1.z((int) e6VarR.R());
            }
            t4VarS1.N(e6VarR.c0());
            t4VarS1.H(e6VarR.a0());
            String strA = e6VarR.a();
            String strJ0 = e6VarR.j0();
            if (!TextUtils.isEmpty(strA)) {
                t4VarS1.M(strA);
            } else if (!TextUtils.isEmpty(strJ0)) {
                t4VarS1.u(strJ0);
            }
            ed.b();
            if (t7VarD0.f5030a.z().B(null, i3.G0)) {
                t4VarS1.c0(e6VarR.h0());
            }
            f6 f6VarC0 = t7VarD0.f5039b.c0(str4);
            t4VarS1.E(e6VarR.Z());
            if (t7VarD0.f5030a.o() && t7VarD0.f5030a.z().C(t4VarS1.j0()) && f6VarC0.j(zzha.AD_STORAGE) && !TextUtils.isEmpty(null)) {
                t4VarS1.G(null);
            }
            t4VarS1.D(f6VarC0.i());
            if (f6VarC0.j(zzha.AD_STORAGE) && e6VarR.N()) {
                Pair pairN = t7VarD0.f5039b.e0().n(e6VarR.l0(), f6VarC0);
                if (e6VarR.N() && !TextUtils.isEmpty((CharSequence) pairN.first)) {
                    try {
                        f6Var = f6VarC0;
                        t4VarS1.X(t7.e((String) pairN.first, Long.toString(zzauVar.f3967l)));
                        Object obj = pairN.second;
                        if (obj != null) {
                            t4VarS1.P(((Boolean) obj).booleanValue());
                        }
                    } catch (SecurityException e10) {
                        t7VarD0.f5030a.d().q().b("Resettable device id encryption failed", e10.getMessage());
                        bArr = new byte[0];
                        paVar = t7VarD0.f5039b;
                    }
                }
                t7VarD0.f5030a.A().k();
                t4VarS1.F(Build.MODEL);
                t7VarD0.f5030a.A().k();
                t4VarS1.Q(Build.VERSION.RELEASE);
                t4VarS1.d0((int) t7VarD0.f5030a.A().p());
                t4VarS1.h0(t7VarD0.f5030a.A().q());
                if (f6Var.j(zzha.ANALYTICS_STORAGE)) {
                    t4VarS1.w(t7.e((String) t1.f.h(e6VarR.m0()), Long.toString(zzauVar.f3967l)));
                }
                if (!TextUtils.isEmpty(e6VarR.p0())) {
                }
                strL0 = e6VarR.l0();
                listC0 = t7VarD0.f5039b.V().c0(strL0);
                it = listC0.iterator();
                while (true) {
                    if (it.hasNext()) {
                    }
                }
                if (taVar != null) {
                    ta taVar2 = new ta(strL0, "auto", "_lte", t7VarD0.f5030a.a().a(), 0L);
                    listC0.add(taVar2);
                    t7VarD0.f5039b.V().x(taVar2);
                }
                raVarG0 = t7VarD0.f5039b.g0();
                raVarG0.f5030a.d().v().a("Checking account type status for ad personalization signals");
                if (raVarG0.f5030a.A().s()) {
                }
                z10 = true;
                com.google.android.gms.internal.measurement.d5[] d5VarArr = new com.google.android.gms.internal.measurement.d5[listC0.size()];
                while (i < listC0.size()) {
                }
                t4Var.w0(Arrays.asList(d5VarArr));
                w3 w3VarB = w3.b(zzauVar);
                t7VarD0.f5030a.N().z(w3VarB.f5785d, t7VarD0.f5039b.V().Q(str4));
                t7VarD0.f5030a.N().B(w3VarB, t7VarD0.f5030a.z().n(str4));
                Bundle bundle = w3VarB.f5785d;
                bundle.putLong("_c", 1L);
                t7VarD0.f5030a.d().q().a("Marking in-app purchase as real-time");
                bundle.putLong("_r", 1L);
                bundle.putString("_o", zzauVar.f3966k);
                if (t7VarD0.f5030a.N().U(t4Var.j0())) {
                }
                qVarV = t7VarD0.f5039b.V().V(str4, zzauVar.f3964e);
                if (qVarV == null) {
                }
                q qVar = qVarC;
                t7VarD0.f5039b.V().q(qVar);
                p pVar = new p(t7VarD0.f5030a, zzauVar.f3966k, str, zzauVar.f3964e, zzauVar.f3967l, j10, bundle);
                str3 = str;
                i4VarH = com.google.android.gms.internal.measurement.j4.H();
                i4VarH.E(pVar.f5573d);
                i4VarH.A(pVar.f5571b);
                i4VarH.D(pVar.f5574e);
                rVar = new r(pVar.f5575f);
                while (rVar.hasNext()) {
                }
                t4Var.x0(i4VarH);
                com.google.android.gms.internal.measurement.v4 v4VarD = com.google.android.gms.internal.measurement.x4.D();
                com.google.android.gms.internal.measurement.k4 k4VarD = com.google.android.gms.internal.measurement.l4.D();
                k4VarD.s(qVar.f5615c);
                k4VarD.t(zzauVar.f3964e);
                v4VarD.s(k4VarD);
                t4Var.T(v4VarD);
                t4Var.s0(t7VarD0.f5039b.T().m(e6Var2.l0(), Collections.EMPTY_LIST, t4Var.n0(), Long.valueOf(i4VarH.u()), Long.valueOf(i4VarH.u())));
                if (i4VarH.I()) {
                }
                jD0 = e6Var2.d0();
                if (jD0 != 0) {
                }
                jF0 = e6Var2.f0();
                if (jF0 != 0) {
                }
                strD = e6Var2.d();
                ae.b();
                if (t7VarD0.f5030a.z().B(str3, i3.f5328q0)) {
                }
                e6Var2.g();
                t4Var.A((int) e6Var2.e0());
                t7VarD0.f5030a.z().q();
                t4Var.f0(79000L);
                t4Var.e0(t7VarD0.f5030a.a().a());
                t4Var.Z(z10);
                if (t7VarD0.f5030a.z().B(str2, i3.f5336u0)) {
                }
                com.google.android.gms.internal.measurement.r4 r4Var2 = r4Var;
                r4Var2.s(t4Var);
                e6Var2.E(t4Var.q0());
                e6Var2.C(t4Var.p0());
                t7VarD0.f5039b.V().p(e6Var2);
                t7VarD0.f5039b.V().o();
                return t7VarD0.f5039b.g0().Q(((com.google.android.gms.internal.measurement.s4) r4Var2.o()).i());
            }
            f6Var = f6VarC0;
            t7VarD0.f5030a.A().k();
            t4VarS1.F(Build.MODEL);
            t7VarD0.f5030a.A().k();
            t4VarS1.Q(Build.VERSION.RELEASE);
            t4VarS1.d0((int) t7VarD0.f5030a.A().p());
            t4VarS1.h0(t7VarD0.f5030a.A().q());
            try {
                if (f6Var.j(zzha.ANALYTICS_STORAGE) && e6VarR.m0() != null) {
                    t4VarS1.w(t7.e((String) t1.f.h(e6VarR.m0()), Long.toString(zzauVar.f3967l)));
                }
                if (!TextUtils.isEmpty(e6VarR.p0())) {
                    t4VarS1.L((String) t1.f.h(e6VarR.p0()));
                }
                strL0 = e6VarR.l0();
                listC0 = t7VarD0.f5039b.V().c0(strL0);
                it = listC0.iterator();
                while (true) {
                    if (it.hasNext()) {
                        taVar = null;
                        break;
                    }
                    taVar = (ta) it.next();
                    if ("_lte".equals(taVar.f5716c)) {
                        break;
                    }
                }
                if (taVar != null || taVar.f5718e == null) {
                    ta taVar22 = new ta(strL0, "auto", "_lte", t7VarD0.f5030a.a().a(), 0L);
                    listC0.add(taVar22);
                    t7VarD0.f5039b.V().x(taVar22);
                }
                raVarG0 = t7VarD0.f5039b.g0();
                raVarG0.f5030a.d().v().a("Checking account type status for ad personalization signals");
                try {
                    if (raVarG0.f5030a.A().s()) {
                        r4Var = r4VarD;
                        e6Var = e6VarR;
                        t4Var = t4VarS1;
                    } else {
                        String strL02 = e6VarR.l0();
                        t1.f.h(strL02);
                        if (e6VarR.N() && raVarG0.f5039b.Z().B(strL02)) {
                            raVarG0.f5030a.d().q().a("Turning off ad personalization due to account type");
                            Iterator it2 = listC0.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    break;
                                }
                                if ("_npa".equals(((ta) it2.next()).f5716c)) {
                                    it2.remove();
                                    break;
                                }
                            }
                            e6Var = e6VarR;
                            long jA = raVarG0.f5030a.a().a();
                            r4Var = r4VarD;
                            t4Var = t4VarS1;
                            z10 = true;
                            listC0.add(new ta(strL02, "auto", "_npa", jA, 1L));
                            com.google.android.gms.internal.measurement.d5[] d5VarArr2 = new com.google.android.gms.internal.measurement.d5[listC0.size()];
                            for (int i10 = 0; i10 < listC0.size(); i10++) {
                                com.google.android.gms.internal.measurement.c5 c5VarG = com.google.android.gms.internal.measurement.d5.G();
                                c5VarG.x(((ta) listC0.get(i10)).f5716c);
                                c5VarG.y(((ta) listC0.get(i10)).f5717d);
                                t7VarD0.f5039b.g0().M(c5VarG, ((ta) listC0.get(i10)).f5718e);
                                d5VarArr2[i10] = (com.google.android.gms.internal.measurement.d5) c5VarG.o();
                            }
                            t4Var.w0(Arrays.asList(d5VarArr2));
                            w3 w3VarB2 = w3.b(zzauVar);
                            t7VarD0.f5030a.N().z(w3VarB2.f5785d, t7VarD0.f5039b.V().Q(str4));
                            t7VarD0.f5030a.N().B(w3VarB2, t7VarD0.f5030a.z().n(str4));
                            Bundle bundle2 = w3VarB2.f5785d;
                            bundle2.putLong("_c", 1L);
                            t7VarD0.f5030a.d().q().a("Marking in-app purchase as real-time");
                            bundle2.putLong("_r", 1L);
                            bundle2.putString("_o", zzauVar.f3966k);
                            if (t7VarD0.f5030a.N().U(t4Var.j0())) {
                                t7VarD0.f5030a.N().D(bundle2, "_dbg", 1L);
                                t7VarD0.f5030a.N().D(bundle2, "_r", 1L);
                            }
                            qVarV = t7VarD0.f5039b.V().V(str4, zzauVar.f3964e);
                            if (qVarV == null) {
                                e6Var2 = e6Var;
                                str2 = null;
                                qVarC = new q(str4, zzauVar.f3964e, 0L, 0L, 0L, zzauVar.f3967l, 0L, null, null, null, null);
                                str = str4;
                                j10 = 0;
                            } else {
                                str = str4;
                                e6Var2 = e6Var;
                                str2 = null;
                                long j11 = qVarV.f5618f;
                                qVarC = qVarV.c(zzauVar.f3967l);
                                j10 = j11;
                            }
                            q qVar2 = qVarC;
                            t7VarD0.f5039b.V().q(qVar2);
                            p pVar2 = new p(t7VarD0.f5030a, zzauVar.f3966k, str, zzauVar.f3964e, zzauVar.f3967l, j10, bundle2);
                            str3 = str;
                            i4VarH = com.google.android.gms.internal.measurement.j4.H();
                            i4VarH.E(pVar2.f5573d);
                            i4VarH.A(pVar2.f5571b);
                            i4VarH.D(pVar2.f5574e);
                            rVar = new r(pVar2.f5575f);
                            while (rVar.hasNext()) {
                                String next = rVar.next();
                                com.google.android.gms.internal.measurement.m4 m4VarH = com.google.android.gms.internal.measurement.n4.H();
                                m4VarH.B(next);
                                Object objN = pVar2.f5575f.n(next);
                                if (objN != null) {
                                    t7VarD0.f5039b.g0().L(m4VarH, objN);
                                    i4VarH.w(m4VarH);
                                }
                            }
                            t4Var.x0(i4VarH);
                            com.google.android.gms.internal.measurement.v4 v4VarD2 = com.google.android.gms.internal.measurement.x4.D();
                            com.google.android.gms.internal.measurement.k4 k4VarD2 = com.google.android.gms.internal.measurement.l4.D();
                            k4VarD2.s(qVar2.f5615c);
                            k4VarD2.t(zzauVar.f3964e);
                            v4VarD2.s(k4VarD2);
                            t4Var.T(v4VarD2);
                            t4Var.s0(t7VarD0.f5039b.T().m(e6Var2.l0(), Collections.EMPTY_LIST, t4Var.n0(), Long.valueOf(i4VarH.u()), Long.valueOf(i4VarH.u())));
                            if (i4VarH.I()) {
                                t4Var.b0(i4VarH.u());
                                t4Var.I(i4VarH.u());
                            }
                            jD0 = e6Var2.d0();
                            if (jD0 != 0) {
                                t4Var.U(jD0);
                            }
                            jF0 = e6Var2.f0();
                            if (jF0 != 0) {
                                t4Var.V(jF0);
                            } else if (jD0 != 0) {
                                t4Var.V(jD0);
                            }
                            strD = e6Var2.d();
                            ae.b();
                            if (t7VarD0.f5030a.z().B(str3, i3.f5328q0) && strD != null) {
                                t4Var.a0(strD);
                            }
                            e6Var2.g();
                            t4Var.A((int) e6Var2.e0());
                            t7VarD0.f5030a.z().q();
                            t4Var.f0(79000L);
                            t4Var.e0(t7VarD0.f5030a.a().a());
                            t4Var.Z(z10);
                            if (t7VarD0.f5030a.z().B(str2, i3.f5336u0)) {
                                t7VarD0.f5039b.h(t4Var.j0(), t4Var);
                            }
                            com.google.android.gms.internal.measurement.r4 r4Var22 = r4Var;
                            r4Var22.s(t4Var);
                            e6Var2.E(t4Var.q0());
                            e6Var2.C(t4Var.p0());
                            t7VarD0.f5039b.V().p(e6Var2);
                            t7VarD0.f5039b.V().o();
                            return t7VarD0.f5039b.g0().Q(((com.google.android.gms.internal.measurement.s4) r4Var22.o()).i());
                        }
                        r4Var = r4VarD;
                        t4Var = t4VarS1;
                        e6Var = e6VarR;
                    }
                    return t7VarD0.f5039b.g0().Q(((com.google.android.gms.internal.measurement.s4) r4Var22.o()).i());
                } catch (IOException e11) {
                    t7VarD0.f5030a.d().r().c("Data loss. Failed to bundle and serialize. appId", v3.z(str3), e11);
                    return str2;
                }
                z10 = true;
                com.google.android.gms.internal.measurement.d5[] d5VarArr22 = new com.google.android.gms.internal.measurement.d5[listC0.size()];
                while (i10 < listC0.size()) {
                }
                t4Var.w0(Arrays.asList(d5VarArr22));
                w3 w3VarB22 = w3.b(zzauVar);
                t7VarD0.f5030a.N().z(w3VarB22.f5785d, t7VarD0.f5039b.V().Q(str4));
                t7VarD0.f5030a.N().B(w3VarB22, t7VarD0.f5030a.z().n(str4));
                Bundle bundle22 = w3VarB22.f5785d;
                bundle22.putLong("_c", 1L);
                t7VarD0.f5030a.d().q().a("Marking in-app purchase as real-time");
                bundle22.putLong("_r", 1L);
                bundle22.putString("_o", zzauVar.f3966k);
                if (t7VarD0.f5030a.N().U(t4Var.j0())) {
                }
                qVarV = t7VarD0.f5039b.V().V(str4, zzauVar.f3964e);
                if (qVarV == null) {
                }
                q qVar22 = qVarC;
                t7VarD0.f5039b.V().q(qVar22);
                p pVar22 = new p(t7VarD0.f5030a, zzauVar.f3966k, str, zzauVar.f3964e, zzauVar.f3967l, j10, bundle22);
                str3 = str;
                i4VarH = com.google.android.gms.internal.measurement.j4.H();
                i4VarH.E(pVar22.f5573d);
                i4VarH.A(pVar22.f5571b);
                i4VarH.D(pVar22.f5574e);
                rVar = new r(pVar22.f5575f);
                while (rVar.hasNext()) {
                }
                t4Var.x0(i4VarH);
                com.google.android.gms.internal.measurement.v4 v4VarD22 = com.google.android.gms.internal.measurement.x4.D();
                com.google.android.gms.internal.measurement.k4 k4VarD22 = com.google.android.gms.internal.measurement.l4.D();
                k4VarD22.s(qVar22.f5615c);
                k4VarD22.t(zzauVar.f3964e);
                v4VarD22.s(k4VarD22);
                t4Var.T(v4VarD22);
                t4Var.s0(t7VarD0.f5039b.T().m(e6Var2.l0(), Collections.EMPTY_LIST, t4Var.n0(), Long.valueOf(i4VarH.u()), Long.valueOf(i4VarH.u())));
                if (i4VarH.I()) {
                }
                jD0 = e6Var2.d0();
                if (jD0 != 0) {
                }
                jF0 = e6Var2.f0();
                if (jF0 != 0) {
                }
                strD = e6Var2.d();
                ae.b();
                if (t7VarD0.f5030a.z().B(str3, i3.f5328q0)) {
                    t4Var.a0(strD);
                }
                e6Var2.g();
                t4Var.A((int) e6Var2.e0());
                t7VarD0.f5030a.z().q();
                t4Var.f0(79000L);
                t4Var.e0(t7VarD0.f5030a.a().a());
                t4Var.Z(z10);
                if (t7VarD0.f5030a.z().B(str2, i3.f5336u0)) {
                }
                com.google.android.gms.internal.measurement.r4 r4Var222 = r4Var;
                r4Var222.s(t4Var);
                e6Var2.E(t4Var.q0());
                e6Var2.C(t4Var.p0());
                t7VarD0.f5039b.V().p(e6Var2);
                t7VarD0.f5039b.V().o();
            } catch (SecurityException e12) {
                t7VarD0.f5030a.d().q().b("app instance id encryption failed", e12.getMessage());
                bArr = new byte[0];
                paVar = t7VarD0.f5039b;
            }
            paVar.V().f0();
            return bArr;
        } finally {
            t7VarD0.f5039b.V().f0();
        }
    }
}
