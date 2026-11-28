package g2;

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

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class u5 implements Callable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzau f5341c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f5342e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ z5 f5343m;

    public u5(z5 z5Var, zzau zzauVar, String str) {
        this.f5343m = z5Var;
        this.f5341c = zzauVar;
        this.f5342e = str;
    }

    /* JADX WARN: Code duplicated, block: B:112:0x037b  */
    /* JADX WARN: Code duplicated, block: B:116:0x038c A[Catch: all -> 0x00a9, LOOP:2: B:114:0x0386->B:116:0x038c, LOOP_END, TryCatch #2 {all -> 0x00a9, blocks: (B:13:0x0082, B:15:0x008e, B:20:0x00ac, B:22:0x00b2, B:25:0x00cd, B:27:0x00e4, B:28:0x00eb, B:30:0x00f5, B:31:0x0102, B:33:0x010c, B:34:0x0119, B:36:0x0124, B:37:0x012c, B:39:0x0148, B:43:0x0155, B:45:0x0166, B:46:0x016d, B:48:0x0182, B:50:0x0192, B:52:0x019a, B:54:0x01a0, B:55:0x01a3, B:57:0x01b2, B:59:0x01b8, B:61:0x01cc, B:63:0x01d6, B:64:0x01e9, B:66:0x01ed, B:72:0x021a, B:73:0x0251, B:75:0x025b, B:77:0x0261, B:81:0x027c, B:83:0x0286, B:84:0x0293, B:85:0x02a5, B:87:0x02ab, B:94:0x02c3, B:97:0x02ee, B:99:0x030f, B:101:0x031d, B:103:0x0329, B:104:0x033c, B:106:0x0342, B:108:0x0352, B:109:0x0355, B:113:0x0380, B:114:0x0386, B:116:0x038c, B:117:0x03c2, B:119:0x0429, B:120:0x043d, B:122:0x044b, B:125:0x047d, B:126:0x04b5, B:128:0x04bb, B:130:0x04ce, B:131:0x04db, B:133:0x0523, B:134:0x0531, B:136:0x0539, B:137:0x053c, B:139:0x0544, B:143:0x054f, B:146:0x0566, B:147:0x0569, B:149:0x05a1, B:150:0x05aa, B:142:0x054c, B:124:0x046e, B:96:0x02c7, B:156:0x0603, B:68:0x01f8, B:40:0x014c, B:42:0x0152), top: B:166:0x0082, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:119:0x0429 A[Catch: all -> 0x00a9, TryCatch #2 {all -> 0x00a9, blocks: (B:13:0x0082, B:15:0x008e, B:20:0x00ac, B:22:0x00b2, B:25:0x00cd, B:27:0x00e4, B:28:0x00eb, B:30:0x00f5, B:31:0x0102, B:33:0x010c, B:34:0x0119, B:36:0x0124, B:37:0x012c, B:39:0x0148, B:43:0x0155, B:45:0x0166, B:46:0x016d, B:48:0x0182, B:50:0x0192, B:52:0x019a, B:54:0x01a0, B:55:0x01a3, B:57:0x01b2, B:59:0x01b8, B:61:0x01cc, B:63:0x01d6, B:64:0x01e9, B:66:0x01ed, B:72:0x021a, B:73:0x0251, B:75:0x025b, B:77:0x0261, B:81:0x027c, B:83:0x0286, B:84:0x0293, B:85:0x02a5, B:87:0x02ab, B:94:0x02c3, B:97:0x02ee, B:99:0x030f, B:101:0x031d, B:103:0x0329, B:104:0x033c, B:106:0x0342, B:108:0x0352, B:109:0x0355, B:113:0x0380, B:114:0x0386, B:116:0x038c, B:117:0x03c2, B:119:0x0429, B:120:0x043d, B:122:0x044b, B:125:0x047d, B:126:0x04b5, B:128:0x04bb, B:130:0x04ce, B:131:0x04db, B:133:0x0523, B:134:0x0531, B:136:0x0539, B:137:0x053c, B:139:0x0544, B:143:0x054f, B:146:0x0566, B:147:0x0569, B:149:0x05a1, B:150:0x05aa, B:142:0x054c, B:124:0x046e, B:96:0x02c7, B:156:0x0603, B:68:0x01f8, B:40:0x014c, B:42:0x0152), top: B:166:0x0082, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:122:0x044b A[Catch: all -> 0x00a9, TryCatch #2 {all -> 0x00a9, blocks: (B:13:0x0082, B:15:0x008e, B:20:0x00ac, B:22:0x00b2, B:25:0x00cd, B:27:0x00e4, B:28:0x00eb, B:30:0x00f5, B:31:0x0102, B:33:0x010c, B:34:0x0119, B:36:0x0124, B:37:0x012c, B:39:0x0148, B:43:0x0155, B:45:0x0166, B:46:0x016d, B:48:0x0182, B:50:0x0192, B:52:0x019a, B:54:0x01a0, B:55:0x01a3, B:57:0x01b2, B:59:0x01b8, B:61:0x01cc, B:63:0x01d6, B:64:0x01e9, B:66:0x01ed, B:72:0x021a, B:73:0x0251, B:75:0x025b, B:77:0x0261, B:81:0x027c, B:83:0x0286, B:84:0x0293, B:85:0x02a5, B:87:0x02ab, B:94:0x02c3, B:97:0x02ee, B:99:0x030f, B:101:0x031d, B:103:0x0329, B:104:0x033c, B:106:0x0342, B:108:0x0352, B:109:0x0355, B:113:0x0380, B:114:0x0386, B:116:0x038c, B:117:0x03c2, B:119:0x0429, B:120:0x043d, B:122:0x044b, B:125:0x047d, B:126:0x04b5, B:128:0x04bb, B:130:0x04ce, B:131:0x04db, B:133:0x0523, B:134:0x0531, B:136:0x0539, B:137:0x053c, B:139:0x0544, B:143:0x054f, B:146:0x0566, B:147:0x0569, B:149:0x05a1, B:150:0x05aa, B:142:0x054c, B:124:0x046e, B:96:0x02c7, B:156:0x0603, B:68:0x01f8, B:40:0x014c, B:42:0x0152), top: B:166:0x0082, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:124:0x046e A[Catch: all -> 0x00a9, TryCatch #2 {all -> 0x00a9, blocks: (B:13:0x0082, B:15:0x008e, B:20:0x00ac, B:22:0x00b2, B:25:0x00cd, B:27:0x00e4, B:28:0x00eb, B:30:0x00f5, B:31:0x0102, B:33:0x010c, B:34:0x0119, B:36:0x0124, B:37:0x012c, B:39:0x0148, B:43:0x0155, B:45:0x0166, B:46:0x016d, B:48:0x0182, B:50:0x0192, B:52:0x019a, B:54:0x01a0, B:55:0x01a3, B:57:0x01b2, B:59:0x01b8, B:61:0x01cc, B:63:0x01d6, B:64:0x01e9, B:66:0x01ed, B:72:0x021a, B:73:0x0251, B:75:0x025b, B:77:0x0261, B:81:0x027c, B:83:0x0286, B:84:0x0293, B:85:0x02a5, B:87:0x02ab, B:94:0x02c3, B:97:0x02ee, B:99:0x030f, B:101:0x031d, B:103:0x0329, B:104:0x033c, B:106:0x0342, B:108:0x0352, B:109:0x0355, B:113:0x0380, B:114:0x0386, B:116:0x038c, B:117:0x03c2, B:119:0x0429, B:120:0x043d, B:122:0x044b, B:125:0x047d, B:126:0x04b5, B:128:0x04bb, B:130:0x04ce, B:131:0x04db, B:133:0x0523, B:134:0x0531, B:136:0x0539, B:137:0x053c, B:139:0x0544, B:143:0x054f, B:146:0x0566, B:147:0x0569, B:149:0x05a1, B:150:0x05aa, B:142:0x054c, B:124:0x046e, B:96:0x02c7, B:156:0x0603, B:68:0x01f8, B:40:0x014c, B:42:0x0152), top: B:166:0x0082, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:128:0x04bb A[Catch: all -> 0x00a9, TryCatch #2 {all -> 0x00a9, blocks: (B:13:0x0082, B:15:0x008e, B:20:0x00ac, B:22:0x00b2, B:25:0x00cd, B:27:0x00e4, B:28:0x00eb, B:30:0x00f5, B:31:0x0102, B:33:0x010c, B:34:0x0119, B:36:0x0124, B:37:0x012c, B:39:0x0148, B:43:0x0155, B:45:0x0166, B:46:0x016d, B:48:0x0182, B:50:0x0192, B:52:0x019a, B:54:0x01a0, B:55:0x01a3, B:57:0x01b2, B:59:0x01b8, B:61:0x01cc, B:63:0x01d6, B:64:0x01e9, B:66:0x01ed, B:72:0x021a, B:73:0x0251, B:75:0x025b, B:77:0x0261, B:81:0x027c, B:83:0x0286, B:84:0x0293, B:85:0x02a5, B:87:0x02ab, B:94:0x02c3, B:97:0x02ee, B:99:0x030f, B:101:0x031d, B:103:0x0329, B:104:0x033c, B:106:0x0342, B:108:0x0352, B:109:0x0355, B:113:0x0380, B:114:0x0386, B:116:0x038c, B:117:0x03c2, B:119:0x0429, B:120:0x043d, B:122:0x044b, B:125:0x047d, B:126:0x04b5, B:128:0x04bb, B:130:0x04ce, B:131:0x04db, B:133:0x0523, B:134:0x0531, B:136:0x0539, B:137:0x053c, B:139:0x0544, B:143:0x054f, B:146:0x0566, B:147:0x0569, B:149:0x05a1, B:150:0x05aa, B:142:0x054c, B:124:0x046e, B:96:0x02c7, B:156:0x0603, B:68:0x01f8, B:40:0x014c, B:42:0x0152), top: B:166:0x0082, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:133:0x0523 A[Catch: all -> 0x00a9, TryCatch #2 {all -> 0x00a9, blocks: (B:13:0x0082, B:15:0x008e, B:20:0x00ac, B:22:0x00b2, B:25:0x00cd, B:27:0x00e4, B:28:0x00eb, B:30:0x00f5, B:31:0x0102, B:33:0x010c, B:34:0x0119, B:36:0x0124, B:37:0x012c, B:39:0x0148, B:43:0x0155, B:45:0x0166, B:46:0x016d, B:48:0x0182, B:50:0x0192, B:52:0x019a, B:54:0x01a0, B:55:0x01a3, B:57:0x01b2, B:59:0x01b8, B:61:0x01cc, B:63:0x01d6, B:64:0x01e9, B:66:0x01ed, B:72:0x021a, B:73:0x0251, B:75:0x025b, B:77:0x0261, B:81:0x027c, B:83:0x0286, B:84:0x0293, B:85:0x02a5, B:87:0x02ab, B:94:0x02c3, B:97:0x02ee, B:99:0x030f, B:101:0x031d, B:103:0x0329, B:104:0x033c, B:106:0x0342, B:108:0x0352, B:109:0x0355, B:113:0x0380, B:114:0x0386, B:116:0x038c, B:117:0x03c2, B:119:0x0429, B:120:0x043d, B:122:0x044b, B:125:0x047d, B:126:0x04b5, B:128:0x04bb, B:130:0x04ce, B:131:0x04db, B:133:0x0523, B:134:0x0531, B:136:0x0539, B:137:0x053c, B:139:0x0544, B:143:0x054f, B:146:0x0566, B:147:0x0569, B:149:0x05a1, B:150:0x05aa, B:142:0x054c, B:124:0x046e, B:96:0x02c7, B:156:0x0603, B:68:0x01f8, B:40:0x014c, B:42:0x0152), top: B:166:0x0082, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:136:0x0539 A[Catch: all -> 0x00a9, TryCatch #2 {all -> 0x00a9, blocks: (B:13:0x0082, B:15:0x008e, B:20:0x00ac, B:22:0x00b2, B:25:0x00cd, B:27:0x00e4, B:28:0x00eb, B:30:0x00f5, B:31:0x0102, B:33:0x010c, B:34:0x0119, B:36:0x0124, B:37:0x012c, B:39:0x0148, B:43:0x0155, B:45:0x0166, B:46:0x016d, B:48:0x0182, B:50:0x0192, B:52:0x019a, B:54:0x01a0, B:55:0x01a3, B:57:0x01b2, B:59:0x01b8, B:61:0x01cc, B:63:0x01d6, B:64:0x01e9, B:66:0x01ed, B:72:0x021a, B:73:0x0251, B:75:0x025b, B:77:0x0261, B:81:0x027c, B:83:0x0286, B:84:0x0293, B:85:0x02a5, B:87:0x02ab, B:94:0x02c3, B:97:0x02ee, B:99:0x030f, B:101:0x031d, B:103:0x0329, B:104:0x033c, B:106:0x0342, B:108:0x0352, B:109:0x0355, B:113:0x0380, B:114:0x0386, B:116:0x038c, B:117:0x03c2, B:119:0x0429, B:120:0x043d, B:122:0x044b, B:125:0x047d, B:126:0x04b5, B:128:0x04bb, B:130:0x04ce, B:131:0x04db, B:133:0x0523, B:134:0x0531, B:136:0x0539, B:137:0x053c, B:139:0x0544, B:143:0x054f, B:146:0x0566, B:147:0x0569, B:149:0x05a1, B:150:0x05aa, B:142:0x054c, B:124:0x046e, B:96:0x02c7, B:156:0x0603, B:68:0x01f8, B:40:0x014c, B:42:0x0152), top: B:166:0x0082, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:139:0x0544 A[Catch: all -> 0x00a9, TryCatch #2 {all -> 0x00a9, blocks: (B:13:0x0082, B:15:0x008e, B:20:0x00ac, B:22:0x00b2, B:25:0x00cd, B:27:0x00e4, B:28:0x00eb, B:30:0x00f5, B:31:0x0102, B:33:0x010c, B:34:0x0119, B:36:0x0124, B:37:0x012c, B:39:0x0148, B:43:0x0155, B:45:0x0166, B:46:0x016d, B:48:0x0182, B:50:0x0192, B:52:0x019a, B:54:0x01a0, B:55:0x01a3, B:57:0x01b2, B:59:0x01b8, B:61:0x01cc, B:63:0x01d6, B:64:0x01e9, B:66:0x01ed, B:72:0x021a, B:73:0x0251, B:75:0x025b, B:77:0x0261, B:81:0x027c, B:83:0x0286, B:84:0x0293, B:85:0x02a5, B:87:0x02ab, B:94:0x02c3, B:97:0x02ee, B:99:0x030f, B:101:0x031d, B:103:0x0329, B:104:0x033c, B:106:0x0342, B:108:0x0352, B:109:0x0355, B:113:0x0380, B:114:0x0386, B:116:0x038c, B:117:0x03c2, B:119:0x0429, B:120:0x043d, B:122:0x044b, B:125:0x047d, B:126:0x04b5, B:128:0x04bb, B:130:0x04ce, B:131:0x04db, B:133:0x0523, B:134:0x0531, B:136:0x0539, B:137:0x053c, B:139:0x0544, B:143:0x054f, B:146:0x0566, B:147:0x0569, B:149:0x05a1, B:150:0x05aa, B:142:0x054c, B:124:0x046e, B:96:0x02c7, B:156:0x0603, B:68:0x01f8, B:40:0x014c, B:42:0x0152), top: B:166:0x0082, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:140:0x0548  */
    /* JADX WARN: Code duplicated, block: B:142:0x054c A[Catch: all -> 0x00a9, TryCatch #2 {all -> 0x00a9, blocks: (B:13:0x0082, B:15:0x008e, B:20:0x00ac, B:22:0x00b2, B:25:0x00cd, B:27:0x00e4, B:28:0x00eb, B:30:0x00f5, B:31:0x0102, B:33:0x010c, B:34:0x0119, B:36:0x0124, B:37:0x012c, B:39:0x0148, B:43:0x0155, B:45:0x0166, B:46:0x016d, B:48:0x0182, B:50:0x0192, B:52:0x019a, B:54:0x01a0, B:55:0x01a3, B:57:0x01b2, B:59:0x01b8, B:61:0x01cc, B:63:0x01d6, B:64:0x01e9, B:66:0x01ed, B:72:0x021a, B:73:0x0251, B:75:0x025b, B:77:0x0261, B:81:0x027c, B:83:0x0286, B:84:0x0293, B:85:0x02a5, B:87:0x02ab, B:94:0x02c3, B:97:0x02ee, B:99:0x030f, B:101:0x031d, B:103:0x0329, B:104:0x033c, B:106:0x0342, B:108:0x0352, B:109:0x0355, B:113:0x0380, B:114:0x0386, B:116:0x038c, B:117:0x03c2, B:119:0x0429, B:120:0x043d, B:122:0x044b, B:125:0x047d, B:126:0x04b5, B:128:0x04bb, B:130:0x04ce, B:131:0x04db, B:133:0x0523, B:134:0x0531, B:136:0x0539, B:137:0x053c, B:139:0x0544, B:143:0x054f, B:146:0x0566, B:147:0x0569, B:149:0x05a1, B:150:0x05aa, B:142:0x054c, B:124:0x046e, B:96:0x02c7, B:156:0x0603, B:68:0x01f8, B:40:0x014c, B:42:0x0152), top: B:166:0x0082, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:145:0x0564 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:149:0x05a1 A[Catch: all -> 0x00a9, TryCatch #2 {all -> 0x00a9, blocks: (B:13:0x0082, B:15:0x008e, B:20:0x00ac, B:22:0x00b2, B:25:0x00cd, B:27:0x00e4, B:28:0x00eb, B:30:0x00f5, B:31:0x0102, B:33:0x010c, B:34:0x0119, B:36:0x0124, B:37:0x012c, B:39:0x0148, B:43:0x0155, B:45:0x0166, B:46:0x016d, B:48:0x0182, B:50:0x0192, B:52:0x019a, B:54:0x01a0, B:55:0x01a3, B:57:0x01b2, B:59:0x01b8, B:61:0x01cc, B:63:0x01d6, B:64:0x01e9, B:66:0x01ed, B:72:0x021a, B:73:0x0251, B:75:0x025b, B:77:0x0261, B:81:0x027c, B:83:0x0286, B:84:0x0293, B:85:0x02a5, B:87:0x02ab, B:94:0x02c3, B:97:0x02ee, B:99:0x030f, B:101:0x031d, B:103:0x0329, B:104:0x033c, B:106:0x0342, B:108:0x0352, B:109:0x0355, B:113:0x0380, B:114:0x0386, B:116:0x038c, B:117:0x03c2, B:119:0x0429, B:120:0x043d, B:122:0x044b, B:125:0x047d, B:126:0x04b5, B:128:0x04bb, B:130:0x04ce, B:131:0x04db, B:133:0x0523, B:134:0x0531, B:136:0x0539, B:137:0x053c, B:139:0x0544, B:143:0x054f, B:146:0x0566, B:147:0x0569, B:149:0x05a1, B:150:0x05aa, B:142:0x054c, B:124:0x046e, B:96:0x02c7, B:156:0x0603, B:68:0x01f8, B:40:0x014c, B:42:0x0152), top: B:166:0x0082, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:169:0x02be A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:175:0x04ce A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:178:0x04b5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:71:0x0218  */
    /* JADX WARN: Code duplicated, block: B:83:0x0286 A[Catch: all -> 0x00a9, TryCatch #2 {all -> 0x00a9, blocks: (B:13:0x0082, B:15:0x008e, B:20:0x00ac, B:22:0x00b2, B:25:0x00cd, B:27:0x00e4, B:28:0x00eb, B:30:0x00f5, B:31:0x0102, B:33:0x010c, B:34:0x0119, B:36:0x0124, B:37:0x012c, B:39:0x0148, B:43:0x0155, B:45:0x0166, B:46:0x016d, B:48:0x0182, B:50:0x0192, B:52:0x019a, B:54:0x01a0, B:55:0x01a3, B:57:0x01b2, B:59:0x01b8, B:61:0x01cc, B:63:0x01d6, B:64:0x01e9, B:66:0x01ed, B:72:0x021a, B:73:0x0251, B:75:0x025b, B:77:0x0261, B:81:0x027c, B:83:0x0286, B:84:0x0293, B:85:0x02a5, B:87:0x02ab, B:94:0x02c3, B:97:0x02ee, B:99:0x030f, B:101:0x031d, B:103:0x0329, B:104:0x033c, B:106:0x0342, B:108:0x0352, B:109:0x0355, B:113:0x0380, B:114:0x0386, B:116:0x038c, B:117:0x03c2, B:119:0x0429, B:120:0x043d, B:122:0x044b, B:125:0x047d, B:126:0x04b5, B:128:0x04bb, B:130:0x04ce, B:131:0x04db, B:133:0x0523, B:134:0x0531, B:136:0x0539, B:137:0x053c, B:139:0x0544, B:143:0x054f, B:146:0x0566, B:147:0x0569, B:149:0x05a1, B:150:0x05aa, B:142:0x054c, B:124:0x046e, B:96:0x02c7, B:156:0x0603, B:68:0x01f8, B:40:0x014c, B:42:0x0152), top: B:166:0x0082, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:87:0x02ab A[Catch: all -> 0x00a9, TryCatch #2 {all -> 0x00a9, blocks: (B:13:0x0082, B:15:0x008e, B:20:0x00ac, B:22:0x00b2, B:25:0x00cd, B:27:0x00e4, B:28:0x00eb, B:30:0x00f5, B:31:0x0102, B:33:0x010c, B:34:0x0119, B:36:0x0124, B:37:0x012c, B:39:0x0148, B:43:0x0155, B:45:0x0166, B:46:0x016d, B:48:0x0182, B:50:0x0192, B:52:0x019a, B:54:0x01a0, B:55:0x01a3, B:57:0x01b2, B:59:0x01b8, B:61:0x01cc, B:63:0x01d6, B:64:0x01e9, B:66:0x01ed, B:72:0x021a, B:73:0x0251, B:75:0x025b, B:77:0x0261, B:81:0x027c, B:83:0x0286, B:84:0x0293, B:85:0x02a5, B:87:0x02ab, B:94:0x02c3, B:97:0x02ee, B:99:0x030f, B:101:0x031d, B:103:0x0329, B:104:0x033c, B:106:0x0342, B:108:0x0352, B:109:0x0355, B:113:0x0380, B:114:0x0386, B:116:0x038c, B:117:0x03c2, B:119:0x0429, B:120:0x043d, B:122:0x044b, B:125:0x047d, B:126:0x04b5, B:128:0x04bb, B:130:0x04ce, B:131:0x04db, B:133:0x0523, B:134:0x0531, B:136:0x0539, B:137:0x053c, B:139:0x0544, B:143:0x054f, B:146:0x0566, B:147:0x0569, B:149:0x05a1, B:150:0x05aa, B:142:0x054c, B:124:0x046e, B:96:0x02c7, B:156:0x0603, B:68:0x01f8, B:40:0x014c, B:42:0x0152), top: B:166:0x0082, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:96:0x02c7 A[Catch: all -> 0x00a9, TryCatch #2 {all -> 0x00a9, blocks: (B:13:0x0082, B:15:0x008e, B:20:0x00ac, B:22:0x00b2, B:25:0x00cd, B:27:0x00e4, B:28:0x00eb, B:30:0x00f5, B:31:0x0102, B:33:0x010c, B:34:0x0119, B:36:0x0124, B:37:0x012c, B:39:0x0148, B:43:0x0155, B:45:0x0166, B:46:0x016d, B:48:0x0182, B:50:0x0192, B:52:0x019a, B:54:0x01a0, B:55:0x01a3, B:57:0x01b2, B:59:0x01b8, B:61:0x01cc, B:63:0x01d6, B:64:0x01e9, B:66:0x01ed, B:72:0x021a, B:73:0x0251, B:75:0x025b, B:77:0x0261, B:81:0x027c, B:83:0x0286, B:84:0x0293, B:85:0x02a5, B:87:0x02ab, B:94:0x02c3, B:97:0x02ee, B:99:0x030f, B:101:0x031d, B:103:0x0329, B:104:0x033c, B:106:0x0342, B:108:0x0352, B:109:0x0355, B:113:0x0380, B:114:0x0386, B:116:0x038c, B:117:0x03c2, B:119:0x0429, B:120:0x043d, B:122:0x044b, B:125:0x047d, B:126:0x04b5, B:128:0x04bb, B:130:0x04ce, B:131:0x04db, B:133:0x0523, B:134:0x0531, B:136:0x0539, B:137:0x053c, B:139:0x0544, B:143:0x054f, B:146:0x0566, B:147:0x0569, B:149:0x05a1, B:150:0x05aa, B:142:0x054c, B:124:0x046e, B:96:0x02c7, B:156:0x0603, B:68:0x01f8, B:40:0x014c, B:42:0x0152), top: B:166:0x0082, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:99:0x030f A[Catch: all -> 0x00a9, TryCatch #2 {all -> 0x00a9, blocks: (B:13:0x0082, B:15:0x008e, B:20:0x00ac, B:22:0x00b2, B:25:0x00cd, B:27:0x00e4, B:28:0x00eb, B:30:0x00f5, B:31:0x0102, B:33:0x010c, B:34:0x0119, B:36:0x0124, B:37:0x012c, B:39:0x0148, B:43:0x0155, B:45:0x0166, B:46:0x016d, B:48:0x0182, B:50:0x0192, B:52:0x019a, B:54:0x01a0, B:55:0x01a3, B:57:0x01b2, B:59:0x01b8, B:61:0x01cc, B:63:0x01d6, B:64:0x01e9, B:66:0x01ed, B:72:0x021a, B:73:0x0251, B:75:0x025b, B:77:0x0261, B:81:0x027c, B:83:0x0286, B:84:0x0293, B:85:0x02a5, B:87:0x02ab, B:94:0x02c3, B:97:0x02ee, B:99:0x030f, B:101:0x031d, B:103:0x0329, B:104:0x033c, B:106:0x0342, B:108:0x0352, B:109:0x0355, B:113:0x0380, B:114:0x0386, B:116:0x038c, B:117:0x03c2, B:119:0x0429, B:120:0x043d, B:122:0x044b, B:125:0x047d, B:126:0x04b5, B:128:0x04bb, B:130:0x04ce, B:131:0x04db, B:133:0x0523, B:134:0x0531, B:136:0x0539, B:137:0x053c, B:139:0x0544, B:143:0x054f, B:146:0x0566, B:147:0x0569, B:149:0x05a1, B:150:0x05aa, B:142:0x054c, B:124:0x046e, B:96:0x02c7, B:156:0x0603, B:68:0x01f8, B:40:0x014c, B:42:0x0152), top: B:166:0x0082, inners: #0, #1 }] */
    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() {
        f6 f6Var;
        byte[] bArr;
        pa paVar;
        String strL0;
        List listC0;
        Iterator it;
        ta taVar;
        ra raVarG0;
        e6 e6Var;
        boolean z10;
        com.google.android.gms.internal.measurement.d5[] d5VarArr;
        Bundle bundle;
        q qVarV;
        String str;
        q qVarC;
        long j10;
        p pVar;
        com.google.android.gms.internal.measurement.i4 i4VarH;
        r rVar;
        long jD0;
        long jF0;
        String strD;
        com.google.android.gms.internal.measurement.m4 m4VarH;
        Object objN;
        this.f5343m.f5487d.e();
        t7 t7VarD0 = this.f5343m.f5487d.d0();
        zzau zzauVar = this.f5341c;
        String str2 = this.f5342e;
        t7VarD0.h();
        h5.t();
        u1.f.h(zzauVar);
        u1.f.d(str2);
        if (!t7VarD0.f4646a.z().B(str2, i3.W)) {
            t7VarD0.f4646a.d().q().b("Generating ScionPayload disabled. packageName", str2);
            return new byte[0];
        }
        if (!"_iap".equals(zzauVar.f3263c) && !"_iapx".equals(zzauVar.f3263c)) {
            t7VarD0.f4646a.d().q().c("Generating a payload for this event is not available. package_name, event_name", str2, zzauVar.f3263c);
            return null;
        }
        com.google.android.gms.internal.measurement.r4 r4VarD = com.google.android.gms.internal.measurement.s4.D();
        t7VarD0.f4655b.V().e0();
        try {
            e6 e6VarR = t7VarD0.f4655b.V().R(str2);
            if (e6VarR == null) {
                t7VarD0.f4646a.d().q().b("Log and bundle not available. package_name", str2);
                byte[] bArr2 = new byte[0];
                t7VarD0.f4655b.V().f0();
                return bArr2;
            }
            if (!e6VarR.O()) {
                t7VarD0.f4646a.d().q().b("Log and bundle disabled. package_name", str2);
                byte[] bArr3 = new byte[0];
                t7VarD0.f4655b.V().f0();
                return bArr3;
            }
            com.google.android.gms.internal.measurement.t4 t4VarS1 = com.google.android.gms.internal.measurement.u4.S1();
            t4VarS1.W(1);
            t4VarS1.R("android");
            if (!TextUtils.isEmpty(e6VarR.l0())) {
                t4VarS1.v(e6VarR.l0());
            }
            if (!TextUtils.isEmpty(e6VarR.n0())) {
                t4VarS1.x((String) u1.f.h(e6VarR.n0()));
            }
            if (!TextUtils.isEmpty(e6VarR.o0())) {
                t4VarS1.y((String) u1.f.h(e6VarR.o0()));
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
            if (t7VarD0.f4646a.z().B(null, i3.G0)) {
                t4VarS1.c0(e6VarR.h0());
            }
            f6 f6VarC0 = t7VarD0.f4655b.c0(str2);
            t4VarS1.E(e6VarR.Z());
            if (t7VarD0.f4646a.o() && t7VarD0.f4646a.z().C(t4VarS1.j0()) && f6VarC0.j(zzha.AD_STORAGE) && !TextUtils.isEmpty(null)) {
                t4VarS1.G(null);
            }
            t4VarS1.D(f6VarC0.i());
            if (f6VarC0.j(zzha.AD_STORAGE) && e6VarR.N()) {
                Pair pairN = t7VarD0.f4655b.e0().n(e6VarR.l0(), f6VarC0);
                if (!e6VarR.N() || TextUtils.isEmpty((CharSequence) pairN.first)) {
                    f6Var = f6VarC0;
                } else {
                    try {
                        f6Var = f6VarC0;
                        t4VarS1.X(t7.e((String) pairN.first, Long.toString(zzauVar.f3266n)));
                        Object obj = pairN.second;
                        if (obj != null) {
                            t4VarS1.P(((Boolean) obj).booleanValue());
                        }
                    } catch (SecurityException e10) {
                        t7VarD0.f4646a.d().q().b("Resettable device id encryption failed", e10.getMessage());
                        bArr = new byte[0];
                        paVar = t7VarD0.f4655b;
                    }
                }
                t7VarD0.f4646a.A().k();
                t4VarS1.F(Build.MODEL);
                t7VarD0.f4646a.A().k();
                t4VarS1.Q(Build.VERSION.RELEASE);
                t4VarS1.d0((int) t7VarD0.f4646a.A().p());
                t4VarS1.h0(t7VarD0.f4646a.A().q());
                if (f6Var.j(zzha.ANALYTICS_STORAGE)) {
                    t4VarS1.w(t7.e((String) u1.f.h(e6VarR.m0()), Long.toString(zzauVar.f3266n)));
                }
                if (!TextUtils.isEmpty(e6VarR.p0())) {
                    t4VarS1.L((String) u1.f.h(e6VarR.p0()));
                }
                strL0 = e6VarR.l0();
                listC0 = t7VarD0.f4655b.V().c0(strL0);
                it = listC0.iterator();
                do {
                    if (it.hasNext()) {
                        taVar = null;
                        break;
                    }
                    taVar = (ta) it.next();
                } while (!"_lte".equals(taVar.f5332c));
                if (taVar != null) {
                    ta taVar2 = new ta(strL0, "auto", "_lte", t7VarD0.f4646a.a().a(), 0L);
                    listC0.add(taVar2);
                    t7VarD0.f4655b.V().x(taVar2);
                } else {
                    ta taVar3 = new ta(strL0, "auto", "_lte", t7VarD0.f4646a.a().a(), 0L);
                    listC0.add(taVar3);
                    t7VarD0.f4655b.V().x(taVar3);
                }
                raVarG0 = t7VarD0.f4655b.g0();
                raVarG0.f4646a.d().v().a("Checking account type status for ad personalization signals");
                if (raVarG0.f4646a.A().s()) {
                    String strL1 = e6VarR.l0();
                    u1.f.h(strL1);
                    if (e6VarR.N()) {
                    }
                    e6Var = e6VarR;
                } else {
                    e6Var = e6VarR;
                }
                z10 = true;
                d5VarArr = new com.google.android.gms.internal.measurement.d5[listC0.size()];
                for (int i10 = 0; i10 < listC0.size(); i10++) {
                    com.google.android.gms.internal.measurement.c5 c5VarG = com.google.android.gms.internal.measurement.d5.G();
                    c5VarG.x(((ta) listC0.get(i10)).f5332c);
                    c5VarG.y(((ta) listC0.get(i10)).f5333d);
                    t7VarD0.f4655b.g0().M(c5VarG, ((ta) listC0.get(i10)).f5334e);
                    d5VarArr[i10] = (com.google.android.gms.internal.measurement.d5) c5VarG.o();
                }
                t4VarS1.w0(Arrays.asList(d5VarArr));
                w3 w3VarB = w3.b(zzauVar);
                t7VarD0.f4646a.N().z(w3VarB.f5401d, t7VarD0.f4655b.V().Q(str2));
                t7VarD0.f4646a.N().B(w3VarB, t7VarD0.f4646a.z().n(str2));
                bundle = w3VarB.f5401d;
                bundle.putLong("_c", 1L);
                t7VarD0.f4646a.d().q().a("Marking in-app purchase as real-time");
                bundle.putLong("_r", 1L);
                bundle.putString("_o", zzauVar.f3265m);
                if (t7VarD0.f4646a.N().U(t4VarS1.j0())) {
                    t7VarD0.f4646a.N().D(bundle, "_dbg", 1L);
                    t7VarD0.f4646a.N().D(bundle, "_r", 1L);
                }
                qVarV = t7VarD0.f4655b.V().V(str2, zzauVar.f3263c);
                if (qVarV == null) {
                    str = null;
                    qVarC = new q(str2, zzauVar.f3263c, 0L, 0L, 0L, zzauVar.f3266n, 0L, null, null, null, null);
                    j10 = 0;
                } else {
                    str = null;
                    long j11 = qVarV.f5234f;
                    qVarC = qVarV.c(zzauVar.f3266n);
                    j10 = j11;
                }
                q qVar = qVarC;
                t7VarD0.f4655b.V().q(qVar);
                pVar = new p(t7VarD0.f4646a, zzauVar.f3265m, str2, zzauVar.f3263c, zzauVar.f3266n, j10, bundle);
                i4VarH = com.google.android.gms.internal.measurement.j4.H();
                i4VarH.E(pVar.f5189d);
                i4VarH.A(pVar.f5187b);
                i4VarH.D(pVar.f5190e);
                rVar = new r(pVar.f5191f);
                while (rVar.hasNext()) {
                    String next = rVar.next();
                    m4VarH = com.google.android.gms.internal.measurement.n4.H();
                    m4VarH.B(next);
                    objN = pVar.f5191f.n(next);
                    if (objN != null) {
                        t7VarD0.f4655b.g0().L(m4VarH, objN);
                        i4VarH.w(m4VarH);
                    }
                }
                t4VarS1.x0(i4VarH);
                com.google.android.gms.internal.measurement.v4 v4VarD = com.google.android.gms.internal.measurement.x4.D();
                com.google.android.gms.internal.measurement.k4 k4VarD = com.google.android.gms.internal.measurement.l4.D();
                k4VarD.s(qVar.f5231c);
                k4VarD.t(zzauVar.f3263c);
                v4VarD.s(k4VarD);
                t4VarS1.T(v4VarD);
                t4VarS1.s0(t7VarD0.f4655b.T().m(e6Var.l0(), Collections.EMPTY_LIST, t4VarS1.n0(), Long.valueOf(i4VarH.u()), Long.valueOf(i4VarH.u())));
                if (i4VarH.I()) {
                    t4VarS1.b0(i4VarH.u());
                    t4VarS1.I(i4VarH.u());
                }
                jD0 = e6Var.d0();
                if (jD0 != 0) {
                    t4VarS1.U(jD0);
                }
                jF0 = e6Var.f0();
                if (jF0 != 0) {
                    t4VarS1.V(jF0);
                } else if (jD0 != 0) {
                    t4VarS1.V(jD0);
                }
                strD = e6Var.d();
                ae.b();
                if (t7VarD0.f4646a.z().B(str2, i3.f4944q0)) {
                    t4VarS1.a0(strD);
                }
                e6Var.g();
                t4VarS1.A((int) e6Var.e0());
                t7VarD0.f4646a.z().q();
                t4VarS1.f0(79000L);
                t4VarS1.e0(t7VarD0.f4646a.a().a());
                t4VarS1.Z(z10);
                if (t7VarD0.f4646a.z().B(str, i3.f4952u0)) {
                    t7VarD0.f4655b.h(t4VarS1.j0(), t4VarS1);
                }
                com.google.android.gms.internal.measurement.r4 r4Var = r4VarD;
                r4Var.s(t4VarS1);
                e6Var.E(t4VarS1.q0());
                e6Var.C(t4VarS1.p0());
                t7VarD0.f4655b.V().p(e6Var);
                t7VarD0.f4655b.V().o();
                t7VarD0.f4655b.V().f0();
                return t7VarD0.f4655b.g0().Q(((com.google.android.gms.internal.measurement.s4) r4Var.o()).j());
            }
            f6Var = f6VarC0;
            t7VarD0.f4646a.A().k();
            t4VarS1.F(Build.MODEL);
            t7VarD0.f4646a.A().k();
            t4VarS1.Q(Build.VERSION.RELEASE);
            t4VarS1.d0((int) t7VarD0.f4646a.A().p());
            t4VarS1.h0(t7VarD0.f4646a.A().q());
            try {
                if (f6Var.j(zzha.ANALYTICS_STORAGE) && e6VarR.m0() != null) {
                    t4VarS1.w(t7.e((String) u1.f.h(e6VarR.m0()), Long.toString(zzauVar.f3266n)));
                }
                if (!TextUtils.isEmpty(e6VarR.p0())) {
                    t4VarS1.L((String) u1.f.h(e6VarR.p0()));
                }
                strL0 = e6VarR.l0();
                listC0 = t7VarD0.f4655b.V().c0(strL0);
                it = listC0.iterator();
                do {
                    if (it.hasNext()) {
                        taVar = null;
                        break;
                    }
                    taVar = (ta) it.next();
                } while (!"_lte".equals(taVar.f5332c));
                if (taVar != null || taVar.f5334e == null) {
                    ta taVar4 = new ta(strL0, "auto", "_lte", t7VarD0.f4646a.a().a(), 0L);
                    listC0.add(taVar4);
                    t7VarD0.f4655b.V().x(taVar4);
                }
                raVarG0 = t7VarD0.f4655b.g0();
                raVarG0.f4646a.d().v().a("Checking account type status for ad personalization signals");
                try {
                    if (raVarG0.f4646a.A().s()) {
                        String strL2 = e6VarR.l0();
                        u1.f.h(strL2);
                        if (e6VarR.N() || !raVarG0.f4655b.Z().B(strL2)) {
                            e6Var = e6VarR;
                        } else {
                            raVarG0.f4646a.d().q().a("Turning off ad personalization due to account type");
                            Iterator it2 = listC0.iterator();
                            while (it2.hasNext()) {
                                if ("_npa".equals(((ta) it2.next()).f5332c)) {
                                    it2.remove();
                                    break;
                                }
                            }
                            e6Var = e6VarR;
                            long jA = raVarG0.f4646a.a().a();
                            r4VarD = r4VarD;
                            t4VarS1 = t4VarS1;
                            z10 = true;
                            listC0.add(new ta(strL2, "auto", "_npa", jA, 1L));
                        }
                        d5VarArr = new com.google.android.gms.internal.measurement.d5[listC0.size()];
                        while (i10 < listC0.size()) {
                            com.google.android.gms.internal.measurement.c5 c5VarG2 = com.google.android.gms.internal.measurement.d5.G();
                            c5VarG2.x(((ta) listC0.get(i10)).f5332c);
                            c5VarG2.y(((ta) listC0.get(i10)).f5333d);
                            t7VarD0.f4655b.g0().M(c5VarG2, ((ta) listC0.get(i10)).f5334e);
                            d5VarArr[i10] = (com.google.android.gms.internal.measurement.d5) c5VarG2.o();
                        }
                        t4VarS1.w0(Arrays.asList(d5VarArr));
                        w3 w3VarB2 = w3.b(zzauVar);
                        t7VarD0.f4646a.N().z(w3VarB2.f5401d, t7VarD0.f4655b.V().Q(str2));
                        t7VarD0.f4646a.N().B(w3VarB2, t7VarD0.f4646a.z().n(str2));
                        bundle = w3VarB2.f5401d;
                        bundle.putLong("_c", 1L);
                        t7VarD0.f4646a.d().q().a("Marking in-app purchase as real-time");
                        bundle.putLong("_r", 1L);
                        bundle.putString("_o", zzauVar.f3265m);
                        if (t7VarD0.f4646a.N().U(t4VarS1.j0())) {
                            t7VarD0.f4646a.N().D(bundle, "_dbg", 1L);
                            t7VarD0.f4646a.N().D(bundle, "_r", 1L);
                        }
                        qVarV = t7VarD0.f4655b.V().V(str2, zzauVar.f3263c);
                        if (qVarV == null) {
                            str = null;
                            qVarC = new q(str2, zzauVar.f3263c, 0L, 0L, 0L, zzauVar.f3266n, 0L, null, null, null, null);
                            j10 = 0;
                        } else {
                            str = null;
                            long j12 = qVarV.f5234f;
                            qVarC = qVarV.c(zzauVar.f3266n);
                            j10 = j12;
                        }
                        q qVar2 = qVarC;
                        t7VarD0.f4655b.V().q(qVar2);
                        pVar = new p(t7VarD0.f4646a, zzauVar.f3265m, str2, zzauVar.f3263c, zzauVar.f3266n, j10, bundle);
                        i4VarH = com.google.android.gms.internal.measurement.j4.H();
                        i4VarH.E(pVar.f5189d);
                        i4VarH.A(pVar.f5187b);
                        i4VarH.D(pVar.f5190e);
                        rVar = new r(pVar.f5191f);
                        while (rVar.hasNext()) {
                            String next2 = rVar.next();
                            m4VarH = com.google.android.gms.internal.measurement.n4.H();
                            m4VarH.B(next2);
                            objN = pVar.f5191f.n(next2);
                            if (objN != null) {
                                t7VarD0.f4655b.g0().L(m4VarH, objN);
                                i4VarH.w(m4VarH);
                            }
                        }
                        t4VarS1.x0(i4VarH);
                        com.google.android.gms.internal.measurement.v4 v4VarD2 = com.google.android.gms.internal.measurement.x4.D();
                        com.google.android.gms.internal.measurement.k4 k4VarD2 = com.google.android.gms.internal.measurement.l4.D();
                        k4VarD2.s(qVar2.f5231c);
                        k4VarD2.t(zzauVar.f3263c);
                        v4VarD2.s(k4VarD2);
                        t4VarS1.T(v4VarD2);
                        t4VarS1.s0(t7VarD0.f4655b.T().m(e6Var.l0(), Collections.EMPTY_LIST, t4VarS1.n0(), Long.valueOf(i4VarH.u()), Long.valueOf(i4VarH.u())));
                        if (i4VarH.I()) {
                            t4VarS1.b0(i4VarH.u());
                            t4VarS1.I(i4VarH.u());
                        }
                        jD0 = e6Var.d0();
                        if (jD0 != 0) {
                            t4VarS1.U(jD0);
                        }
                        jF0 = e6Var.f0();
                        if (jF0 != 0) {
                            t4VarS1.V(jF0);
                        } else if (jD0 != 0) {
                            t4VarS1.V(jD0);
                        }
                        strD = e6Var.d();
                        ae.b();
                        if (t7VarD0.f4646a.z().B(str2, i3.f4944q0) && strD != null) {
                            t4VarS1.a0(strD);
                        }
                        e6Var.g();
                        t4VarS1.A((int) e6Var.e0());
                        t7VarD0.f4646a.z().q();
                        t4VarS1.f0(79000L);
                        t4VarS1.e0(t7VarD0.f4646a.a().a());
                        t4VarS1.Z(z10);
                        if (t7VarD0.f4646a.z().B(str, i3.f4952u0)) {
                            t7VarD0.f4655b.h(t4VarS1.j0(), t4VarS1);
                        }
                        com.google.android.gms.internal.measurement.r4 r4Var2 = r4VarD;
                        r4Var2.s(t4VarS1);
                        e6Var.E(t4VarS1.q0());
                        e6Var.C(t4VarS1.p0());
                        t7VarD0.f4655b.V().p(e6Var);
                        t7VarD0.f4655b.V().o();
                        t7VarD0.f4655b.V().f0();
                        return t7VarD0.f4655b.g0().Q(((com.google.android.gms.internal.measurement.s4) r4Var2.o()).j());
                    }
                    e6Var = e6VarR;
                    return t7VarD0.f4655b.g0().Q(((com.google.android.gms.internal.measurement.s4) r4Var2.o()).j());
                } catch (IOException e11) {
                    t7VarD0.f4646a.d().r().c("Data loss. Failed to bundle and serialize. appId", v3.z(str2), e11);
                    return str;
                }
                z10 = true;
                d5VarArr = new com.google.android.gms.internal.measurement.d5[listC0.size()];
                while (i10 < listC0.size()) {
                    com.google.android.gms.internal.measurement.c5 c5VarG3 = com.google.android.gms.internal.measurement.d5.G();
                    c5VarG3.x(((ta) listC0.get(i10)).f5332c);
                    c5VarG3.y(((ta) listC0.get(i10)).f5333d);
                    t7VarD0.f4655b.g0().M(c5VarG3, ((ta) listC0.get(i10)).f5334e);
                    d5VarArr[i10] = (com.google.android.gms.internal.measurement.d5) c5VarG3.o();
                }
                t4VarS1.w0(Arrays.asList(d5VarArr));
                w3 w3VarB3 = w3.b(zzauVar);
                t7VarD0.f4646a.N().z(w3VarB3.f5401d, t7VarD0.f4655b.V().Q(str2));
                t7VarD0.f4646a.N().B(w3VarB3, t7VarD0.f4646a.z().n(str2));
                bundle = w3VarB3.f5401d;
                bundle.putLong("_c", 1L);
                t7VarD0.f4646a.d().q().a("Marking in-app purchase as real-time");
                bundle.putLong("_r", 1L);
                bundle.putString("_o", zzauVar.f3265m);
                if (t7VarD0.f4646a.N().U(t4VarS1.j0())) {
                    t7VarD0.f4646a.N().D(bundle, "_dbg", 1L);
                    t7VarD0.f4646a.N().D(bundle, "_r", 1L);
                }
                qVarV = t7VarD0.f4655b.V().V(str2, zzauVar.f3263c);
                if (qVarV == null) {
                    str = null;
                    qVarC = new q(str2, zzauVar.f3263c, 0L, 0L, 0L, zzauVar.f3266n, 0L, null, null, null, null);
                    j10 = 0;
                } else {
                    str = null;
                    long j13 = qVarV.f5234f;
                    qVarC = qVarV.c(zzauVar.f3266n);
                    j10 = j13;
                }
                q qVar3 = qVarC;
                t7VarD0.f4655b.V().q(qVar3);
                pVar = new p(t7VarD0.f4646a, zzauVar.f3265m, str2, zzauVar.f3263c, zzauVar.f3266n, j10, bundle);
                i4VarH = com.google.android.gms.internal.measurement.j4.H();
                i4VarH.E(pVar.f5189d);
                i4VarH.A(pVar.f5187b);
                i4VarH.D(pVar.f5190e);
                rVar = new r(pVar.f5191f);
                while (rVar.hasNext()) {
                    String next3 = rVar.next();
                    m4VarH = com.google.android.gms.internal.measurement.n4.H();
                    m4VarH.B(next3);
                    objN = pVar.f5191f.n(next3);
                    if (objN != null) {
                        t7VarD0.f4655b.g0().L(m4VarH, objN);
                        i4VarH.w(m4VarH);
                    }
                }
                t4VarS1.x0(i4VarH);
                com.google.android.gms.internal.measurement.v4 v4VarD3 = com.google.android.gms.internal.measurement.x4.D();
                com.google.android.gms.internal.measurement.k4 k4VarD3 = com.google.android.gms.internal.measurement.l4.D();
                k4VarD3.s(qVar3.f5231c);
                k4VarD3.t(zzauVar.f3263c);
                v4VarD3.s(k4VarD3);
                t4VarS1.T(v4VarD3);
                t4VarS1.s0(t7VarD0.f4655b.T().m(e6Var.l0(), Collections.EMPTY_LIST, t4VarS1.n0(), Long.valueOf(i4VarH.u()), Long.valueOf(i4VarH.u())));
                if (i4VarH.I()) {
                    t4VarS1.b0(i4VarH.u());
                    t4VarS1.I(i4VarH.u());
                }
                jD0 = e6Var.d0();
                if (jD0 != 0) {
                    t4VarS1.U(jD0);
                }
                jF0 = e6Var.f0();
                if (jF0 != 0) {
                    t4VarS1.V(jF0);
                } else if (jD0 != 0) {
                    t4VarS1.V(jD0);
                }
                strD = e6Var.d();
                ae.b();
                if (t7VarD0.f4646a.z().B(str2, i3.f4944q0)) {
                    t4VarS1.a0(strD);
                }
                e6Var.g();
                t4VarS1.A((int) e6Var.e0());
                t7VarD0.f4646a.z().q();
                t4VarS1.f0(79000L);
                t4VarS1.e0(t7VarD0.f4646a.a().a());
                t4VarS1.Z(z10);
                if (t7VarD0.f4646a.z().B(str, i3.f4952u0)) {
                    t7VarD0.f4655b.h(t4VarS1.j0(), t4VarS1);
                }
                com.google.android.gms.internal.measurement.r4 r4Var3 = r4VarD;
                r4Var3.s(t4VarS1);
                e6Var.E(t4VarS1.q0());
                e6Var.C(t4VarS1.p0());
                t7VarD0.f4655b.V().p(e6Var);
                t7VarD0.f4655b.V().o();
                t7VarD0.f4655b.V().f0();
            } catch (SecurityException e12) {
                t7VarD0.f4646a.d().q().b("app instance id encryption failed", e12.getMessage());
                bArr = new byte[0];
                paVar = t7VarD0.f4655b;
            }
            paVar.V().f0();
            return bArr;
        } catch (Throwable th) {
            t7VarD0.f4655b.V().f0();
            throw th;
        }
    }
}
