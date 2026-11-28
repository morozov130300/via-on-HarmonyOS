package g2;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import com.google.android.gms.internal.measurement.cc;
import java.io.IOException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class b extends ba {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f4658d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Set f4659e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Map f4660f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Long f4661g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Long f4662h;

    public b(pa paVar) {
        super(paVar);
    }

    @Override // g2.ba
    public final boolean l() {
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0249  */
    /* JADX WARN: Code duplicated, block: B:105:0x0259  */
    /* JADX WARN: Code duplicated, block: B:107:0x0264  */
    /* JADX WARN: Code duplicated, block: B:111:0x0290 A[Catch: all -> 0x02ab, SQLiteException -> 0x02ad, LOOP:11: B:111:0x0290->B:508:?, LOOP_START, TryCatch #7 {all -> 0x02ab, blocks: (B:109:0x028a, B:111:0x0290, B:113:0x02a1, B:119:0x02af, B:122:0x02c4, B:131:0x02d2), top: B:435:0x0280 }] */
    /* JADX WARN: Code duplicated, block: B:113:0x02a1 A[Catch: all -> 0x02ab, SQLiteException -> 0x02ad, TryCatch #7 {all -> 0x02ab, blocks: (B:109:0x028a, B:111:0x0290, B:113:0x02a1, B:119:0x02af, B:122:0x02c4, B:131:0x02d2), top: B:435:0x0280 }] */
    /* JADX WARN: Code duplicated, block: B:122:0x02c4 A[Catch: all -> 0x02ab, SQLiteException -> 0x02ad, TRY_ENTER, TRY_LEAVE, TryCatch #7 {all -> 0x02ab, blocks: (B:109:0x028a, B:111:0x0290, B:113:0x02a1, B:119:0x02af, B:122:0x02c4, B:131:0x02d2), top: B:435:0x0280 }] */
    /* JADX WARN: Code duplicated, block: B:137:0x02ff  */
    /* JADX WARN: Code duplicated, block: B:140:0x030d  */
    /* JADX WARN: Code duplicated, block: B:142:0x0324  */
    /* JADX WARN: Code duplicated, block: B:166:0x03f5  */
    /* JADX WARN: Code duplicated, block: B:168:0x03f9  */
    /* JADX WARN: Code duplicated, block: B:172:0x0406  */
    /* JADX WARN: Code duplicated, block: B:174:0x0426  */
    /* JADX WARN: Code duplicated, block: B:180:0x043d  */
    /* JADX WARN: Code duplicated, block: B:184:0x0459  */
    /* JADX WARN: Code duplicated, block: B:185:0x0462  */
    /* JADX WARN: Code duplicated, block: B:189:0x0470  */
    /* JADX WARN: Code duplicated, block: B:195:0x0487  */
    /* JADX WARN: Code duplicated, block: B:201:0x04bd  */
    /* JADX WARN: Code duplicated, block: B:204:0x04c6  */
    /* JADX WARN: Code duplicated, block: B:206:0x04d0  */
    /* JADX WARN: Code duplicated, block: B:208:0x04f2  */
    /* JADX WARN: Code duplicated, block: B:209:0x04f6  */
    /* JADX WARN: Code duplicated, block: B:214:0x050f A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:239:0x05a6  */
    /* JADX WARN: Code duplicated, block: B:242:0x05bb  */
    /* JADX WARN: Code duplicated, block: B:246:0x05df  */
    /* JADX WARN: Code duplicated, block: B:247:0x0620  */
    /* JADX WARN: Code duplicated, block: B:250:0x066e  */
    /* JADX WARN: Code duplicated, block: B:256:0x06ab  */
    /* JADX WARN: Code duplicated, block: B:263:0x06d3 A[Catch: all -> 0x06dc, SQLiteException -> 0x06de, TryCatch #11 {SQLiteException -> 0x06de, blocks: (B:258:0x06ae, B:259:0x06b2, B:261:0x06c3, B:263:0x06d3, B:268:0x06e0, B:271:0x06f6, B:270:0x06e5, B:275:0x0703), top: B:442:0x06ae }] */
    /* JADX WARN: Code duplicated, block: B:274:0x0701  */
    /* JADX WARN: Code duplicated, block: B:276:0x0705 A[PHI: r0 r5 r20 r22
  0x0705: PHI (r0v167 java.util.Map) = (r0v169 java.util.Map), (r0v175 java.util.Map) binds: [B:288:0x072d, B:275:0x0703] A[DONT_GENERATE, DONT_INLINE]
  0x0705: PHI (r5v37 android.database.Cursor) = (r5v38 android.database.Cursor), (r5v39 android.database.Cursor) binds: [B:288:0x072d, B:275:0x0703] A[DONT_GENERATE, DONT_INLINE]
  0x0705: PHI (r20v9 long) = (r20v10 long), (r20v13 long) binds: [B:288:0x072d, B:275:0x0703] A[DONT_GENERATE, DONT_INLINE]
  0x0705: PHI (r22v17 g2.q) = (r22v18 g2.q), (r22v20 g2.q) binds: [B:288:0x072d, B:275:0x0703] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:294:0x073a  */
    /* JADX WARN: Code duplicated, block: B:298:0x074e  */
    /* JADX WARN: Code duplicated, block: B:304:0x077f  */
    /* JADX WARN: Code duplicated, block: B:306:0x07a8 A[LOOP:5: B:302:0x0779->B:306:0x07a8, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:310:0x07bc  */
    /* JADX WARN: Code duplicated, block: B:316:0x07d2  */
    /* JADX WARN: Code duplicated, block: B:319:0x07e1  */
    /* JADX WARN: Code duplicated, block: B:321:0x07f4  */
    /* JADX WARN: Code duplicated, block: B:325:0x082d A[Catch: all -> 0x085e, SQLiteException -> 0x086e, LOOP:7: B:325:0x082d->B:347:0x0895, LOOP_START, PHI: r4 r8
  0x082d: PHI (r4v40 java.util.Iterator) = (r4v32 java.util.Iterator), (r4v44 java.util.Iterator) binds: [B:324:0x082b, B:347:0x0895] A[DONT_GENERATE, DONT_INLINE]
  0x082d: PHI (r8v44 java.lang.String) = (r8v41 java.lang.String), (r8v46 java.lang.String) binds: [B:324:0x082b, B:347:0x0895] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #18 {SQLiteException -> 0x086e, blocks: (B:323:0x0827, B:325:0x082d, B:326:0x0832, B:328:0x0843), top: B:451:0x0827 }] */
    /* JADX WARN: Code duplicated, block: B:330:0x0853  */
    /* JADX WARN: Code duplicated, block: B:336:0x0864  */
    /* JADX WARN: Code duplicated, block: B:347:0x0895 A[LOOP:7: B:325:0x082d->B:347:0x0895, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:350:0x089c  */
    /* JADX WARN: Code duplicated, block: B:352:0x08a2 A[PHI: r0 r13 r41
  0x08a2: PHI (r0v123 java.util.Map) = (r0v125 java.util.Map), (r0v131 java.util.Map) binds: [B:361:0x08c6, B:351:0x08a0] A[DONT_GENERATE, DONT_INLINE]
  0x08a2: PHI (r13v12 android.database.Cursor) = (r13v13 android.database.Cursor), (r13v14 android.database.Cursor) binds: [B:361:0x08c6, B:351:0x08a0] A[DONT_GENERATE, DONT_INLINE]
  0x08a2: PHI (r41v4 java.util.Iterator) = (r41v5 java.util.Iterator), (r41v9 java.util.Iterator) binds: [B:361:0x08c6, B:351:0x08a0] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:367:0x08d3  */
    /* JADX WARN: Code duplicated, block: B:371:0x08e3  */
    /* JADX WARN: Code duplicated, block: B:375:0x0906  */
    /* JADX WARN: Code duplicated, block: B:378:0x0917  */
    /* JADX WARN: Code duplicated, block: B:380:0x092e  */
    /* JADX WARN: Code duplicated, block: B:382:0x093e  */
    /* JADX WARN: Code duplicated, block: B:384:0x0949  */
    /* JADX WARN: Code duplicated, block: B:386:0x097a  */
    /* JADX WARN: Code duplicated, block: B:389:0x0984  */
    /* JADX WARN: Code duplicated, block: B:398:0x09cf  */
    /* JADX WARN: Code duplicated, block: B:399:0x09d8  */
    /* JADX WARN: Code duplicated, block: B:403:0x09e9 A[PHI: r16 r42
  0x09e9: PHI (r16v8 java.lang.String) = (r16v9 java.lang.String), (r2v29 java.lang.String) binds: [B:402:0x09e7, B:400:0x09d9] A[DONT_GENERATE, DONT_INLINE]
  0x09e9: PHI (r42v3 java.util.Map) = (r42v4 java.util.Map), (r0v102 java.util.Map) binds: [B:402:0x09e7, B:400:0x09d9] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:408:0x0a0e  */
    /* JADX WARN: Code duplicated, block: B:476:0x05c9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:478:0x05b5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:483:0x076e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:484:0x0760 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:488:0x07b2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:489:0x07b8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:493:0x0890 A[EDGE_INSN: B:493:0x0890->B:346:0x0890 BREAK  A[LOOP:7: B:325:0x082d->B:347:0x0895], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:494:0x08f5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:496:0x09ee A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:497:0x09b9 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:500:0x09e3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:502:0x0a68 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:504:0x0a08 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:510:0x0571 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:517:0x0449 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:519:0x0437 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:522:0x0493 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:525:0x0481 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:536:0x032a A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:549:0x020f A[EDGE_INSN: B:549:0x020f->B:83:0x020f BREAK  A[LOOP:20: B:70:0x01c3->B:84:0x0214], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:55:0x016f  */
    /* JADX WARN: Code duplicated, block: B:61:0x01a4 A[Catch: all -> 0x01b2, SQLiteException -> 0x01b5, TRY_LEAVE, TryCatch #15 {all -> 0x01b2, blocks: (B:59:0x019e, B:61:0x01a4, B:69:0x01be, B:70:0x01c3, B:71:0x01cd, B:72:0x01dd, B:81:0x0209, B:74:0x01ec, B:78:0x01fc, B:80:0x0202, B:98:0x0232), top: B:448:0x019e }] */
    /* JADX WARN: Code duplicated, block: B:69:0x01be A[Catch: all -> 0x01b2, SQLiteException -> 0x01b5, TRY_ENTER, TryCatch #15 {all -> 0x01b2, blocks: (B:59:0x019e, B:61:0x01a4, B:69:0x01be, B:70:0x01c3, B:71:0x01cd, B:72:0x01dd, B:81:0x0209, B:74:0x01ec, B:78:0x01fc, B:80:0x0202, B:98:0x0232), top: B:448:0x019e }] */
    /* JADX WARN: Code duplicated, block: B:84:0x0214 A[LOOP:20: B:70:0x01c3->B:84:0x0214, LOOP_END] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v42 */
    /* JADX WARN: Type inference failed for: r5v44, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r5v53 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final List m(String str, List list, List list2, Long l10, Long l11) throws Throwable {
        int i10;
        int i11;
        boolean z10;
        Object obj;
        Map map;
        Cursor cursor;
        boolean z11;
        String str2;
        Cursor cursorQuery;
        Map map2;
        HashSet hashSet;
        HashSet<Integer> hashSet2;
        Map map3;
        com.google.android.gms.internal.measurement.z4 z4Var;
        BitSet bitSet;
        BitSet bitSet2;
        k.a aVar;
        com.google.android.gms.internal.measurement.z4 z4Var2;
        List list3;
        int i12;
        boolean z12;
        Iterator it;
        com.google.android.gms.internal.measurement.b5 b5Var;
        Long lValueOf;
        String str3;
        Map aVar2;
        SQLiteDatabase sQLiteDatabaseP;
        ?? r10;
        Cursor cursorRawQuery;
        k.a aVar3;
        Iterator it2;
        Integer num;
        com.google.android.gms.internal.measurement.z4 z4Var3;
        List list4;
        Map map4;
        Iterator it3;
        Integer numValueOf;
        List arrayList;
        String str4;
        String str5;
        String str6;
        ArrayList arrayList2;
        k kVarV;
        String str7;
        ContentValues contentValues;
        k.a aVar4;
        Iterator it4;
        String strI;
        Map map5;
        Iterator it5;
        Iterator it6;
        boolean zK;
        com.google.android.gms.internal.measurement.i3 i3Var;
        Integer numValueOf2;
        jb jbVar;
        Integer numValueOf3;
        k kVarV2;
        String str8;
        k.a aVar5;
        Cursor cursor2;
        String str9;
        Cursor cursorQuery2;
        Integer numValueOf4;
        List list5;
        List arrayList3;
        gb gbVar;
        k.a aVar6;
        Iterator it7;
        com.google.android.gms.internal.measurement.j4 j4Var;
        com.google.android.gms.internal.measurement.j4 j4VarA;
        k kVarV3;
        String str10;
        String strK;
        q qVarV;
        q qVar;
        long j10;
        String strK2;
        Map map6;
        q qVar2;
        long j11;
        int iIntValue;
        Iterator it8;
        boolean zK2;
        Map map7;
        hb hbVar;
        k kVarV4;
        String str11;
        k.a aVar7;
        Cursor cursorQuery3;
        Integer numValueOf5;
        List arrayList4;
        k.a aVar8;
        int i13;
        ?? r11;
        Cursor cursorQuery4;
        List arrayList5;
        u1.f.d(str);
        u1.f.h(list);
        u1.f.h(list2);
        this.f4658d = str;
        this.f4659e = new HashSet();
        this.f4660f = new k.a();
        this.f4661g = l10;
        this.f4662h = l11;
        Iterator it9 = list.iterator();
        while (true) {
            i10 = 0;
            i11 = 1;
            if (!it9.hasNext()) {
                z10 = false;
                break;
            }
            if ("_s".equals(((com.google.android.gms.internal.measurement.j4) it9.next()).K())) {
                z10 = true;
                break;
            }
        }
        cc.b();
        boolean zB = this.f4646a.z().B(this.f4658d, i3.f4912a0);
        cc.b();
        boolean zB2 = this.f4646a.z().B(this.f4658d, i3.Z);
        if (z10) {
            k kVarV5 = this.f4655b.V();
            String str12 = this.f4658d;
            kVarV5.i();
            kVarV5.h();
            u1.f.d(str12);
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("current_session_count", (Integer) 0);
            try {
                SQLiteDatabase sQLiteDatabaseP2 = kVarV5.P();
                sQLiteDatabaseP2.update("events", contentValues2, "app_id = ?", new String[]{str12});
                obj = sQLiteDatabaseP2;
            } catch (SQLiteException e10) {
                kVarV5.f4646a.d().r().c("Error resetting session-scoped event counts. appId", v3.z(str12), e10);
                obj = "Error resetting session-scoped event counts. appId";
            }
        }
        Map map8 = Collections.EMPTY_MAP;
        String str13 = "data";
        String str14 = "audience_id";
        if (zB2 && zB) {
            k kVarV6 = this.f4655b.V();
            String str15 = this.f4658d;
            u1.f.d(str15);
            k.a aVar9 = new k.a();
            try {
                try {
                    cursorQuery4 = kVarV6.P().query("event_filters", new String[]{"audience_id", "data"}, "app_id=?", new String[]{str15}, null, null, null);
                    try {
                        if (cursorQuery4.moveToFirst()) {
                            while (true) {
                                try {
                                    com.google.android.gms.internal.measurement.z2 z2Var = (com.google.android.gms.internal.measurement.z2) ((com.google.android.gms.internal.measurement.y2) ra.E(com.google.android.gms.internal.measurement.z2.F(), cursorQuery4.getBlob(i11))).o();
                                    if (z2Var.Q()) {
                                        Integer numValueOf6 = Integer.valueOf(cursorQuery4.getInt(i10));
                                        List list6 = (List) aVar9.get(numValueOf6);
                                        if (list6 == null) {
                                            arrayList5 = new ArrayList();
                                            aVar9.put(numValueOf6, arrayList5);
                                        } else {
                                            arrayList5 = list6;
                                        }
                                        arrayList5.add(z2Var);
                                    }
                                } catch (IOException e11) {
                                    kVarV6.f4646a.d().r().c("Failed to merge filter. appId", v3.z(str15), e11);
                                }
                                if (!cursorQuery4.moveToNext()) {
                                    break;
                                }
                                i10 = 0;
                                i11 = 1;
                            }
                            cursorQuery4.close();
                            map = aVar9;
                        } else {
                            cursorQuery4.close();
                            map = map8;
                        }
                    } catch (SQLiteException e12) {
                        e = e12;
                        kVarV6.f4646a.d().r().c("Database error querying filters. appId", v3.z(str15), e);
                        map8 = Collections.EMPTY_MAP;
                        if (cursorQuery4 != null) {
                        }
                        map = map8;
                        k kVarV7 = this.f4655b.V();
                        String str16 = this.f4658d;
                        kVarV7.i();
                        kVarV7.h();
                        u1.f.d(str16);
                        cursorQuery = kVarV7.P().query("audience_filter_values", new String[]{"audience_id", "current_results"}, "app_id=?", new String[]{str16}, null, null, null);
                        try {
                            try {
                                if (cursorQuery.moveToFirst()) {
                                    aVar8 = new k.a();
                                    while (true) {
                                        i13 = cursorQuery.getInt(0);
                                        try {
                                            aVar8.put(Integer.valueOf(i13), (com.google.android.gms.internal.measurement.z4) ((com.google.android.gms.internal.measurement.y4) ra.E(com.google.android.gms.internal.measurement.z4.H(), cursorQuery.getBlob(1))).o());
                                            z11 = z10;
                                            str2 = str13;
                                        } catch (IOException e13) {
                                            z11 = z10;
                                            str2 = str13;
                                            try {
                                                kVarV7.f4646a.d().r().d("Failed to merge filter results. appId, audienceId, error", v3.z(str16), Integer.valueOf(i13), e13);
                                            } catch (SQLiteException e14) {
                                                e = e14;
                                                str14 = str14;
                                                kVarV7.f4646a.d().r().c("Database error querying filter results. appId", v3.z(str16), e);
                                                Map map9 = Collections.EMPTY_MAP;
                                                if (cursorQuery != null) {
                                                    cursorQuery.close();
                                                }
                                                map2 = map9;
                                                if (!map2.isEmpty()) {
                                                    hashSet = new HashSet(map2.keySet());
                                                    if (z11) {
                                                        String str17 = this.f4658d;
                                                        k kVarV8 = this.f4655b.V();
                                                        str3 = this.f4658d;
                                                        kVarV8.i();
                                                        kVarV8.h();
                                                        u1.f.d(str3);
                                                        aVar2 = new k.a();
                                                        sQLiteDatabaseP = kVarV8.P();
                                                        try {
                                                            try {
                                                                cursorRawQuery = sQLiteDatabaseP.rawQuery("select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;", new String[]{str3, str3});
                                                                try {
                                                                    if (cursorRawQuery.moveToFirst()) {
                                                                        do {
                                                                            numValueOf = Integer.valueOf(cursorRawQuery.getInt(0));
                                                                            arrayList = (List) aVar2.get(numValueOf);
                                                                            if (arrayList == null) {
                                                                                arrayList = new ArrayList();
                                                                                aVar2.put(numValueOf, arrayList);
                                                                            }
                                                                            arrayList.add(Integer.valueOf(cursorRawQuery.getInt(1)));
                                                                        } while (cursorRawQuery.moveToNext());
                                                                    } else {
                                                                        aVar2 = Collections.EMPTY_MAP;
                                                                    }
                                                                } catch (SQLiteException e15) {
                                                                    e = e15;
                                                                    kVarV8.f4646a.d().r().c("Database error querying scoped filters. appId", v3.z(str3), e);
                                                                    aVar2 = Collections.EMPTY_MAP;
                                                                    if (cursorRawQuery != null) {
                                                                    }
                                                                    u1.f.d(str17);
                                                                    u1.f.h(map2);
                                                                    aVar3 = new k.a();
                                                                    if (!map2.isEmpty()) {
                                                                        it2 = map2.keySet().iterator();
                                                                        while (it2.hasNext()) {
                                                                            num = (Integer) it2.next();
                                                                            num.intValue();
                                                                            z4Var3 = (com.google.android.gms.internal.measurement.z4) map2.get(num);
                                                                            list4 = (List) aVar2.get(num);
                                                                            if (list4 != null) {
                                                                            }
                                                                            map4 = aVar2;
                                                                            it3 = it2;
                                                                            aVar3.put(num, z4Var3);
                                                                            aVar2 = map4;
                                                                            hashSet = hashSet;
                                                                            it2 = it3;
                                                                        }
                                                                    }
                                                                    hashSet2 = hashSet;
                                                                    map3 = aVar3;
                                                                    for (Integer num2 : hashSet2) {
                                                                        num2.intValue();
                                                                        z4Var = (com.google.android.gms.internal.measurement.z4) map3.get(num2);
                                                                        bitSet = new BitSet();
                                                                        bitSet2 = new BitSet();
                                                                        aVar = new k.a();
                                                                        if (z4Var != null) {
                                                                            for (com.google.android.gms.internal.measurement.h4 h4Var : z4Var.K()) {
                                                                                if (h4Var.K()) {
                                                                                    Map map10 = map3;
                                                                                    Integer numValueOf7 = Integer.valueOf(h4Var.D());
                                                                                    if (h4Var.J()) {
                                                                                        lValueOf = Long.valueOf(h4Var.E());
                                                                                    } else {
                                                                                        lValueOf = null;
                                                                                    }
                                                                                    aVar.put(numValueOf7, lValueOf);
                                                                                    map3 = map10;
                                                                                }
                                                                            }
                                                                        }
                                                                        Map map11 = map3;
                                                                        k.a aVar10 = new k.a();
                                                                        if (z4Var != null) {
                                                                            it = z4Var.M().iterator();
                                                                            while (it.hasNext()) {
                                                                                b5Var = (com.google.android.gms.internal.measurement.b5) it.next();
                                                                                if (!b5Var.L()) {
                                                                                }
                                                                            }
                                                                        }
                                                                        z4Var2 = z4Var;
                                                                        if (z4Var2 != null) {
                                                                            i12 = 0;
                                                                            while (i12 < z4Var2.G() * 64) {
                                                                                if (ra.N(z4Var2.N(), i12)) {
                                                                                    z12 = zB;
                                                                                    this.f4646a.d().v().c("Filter already evaluated. audience ID, filter ID", num2, Integer.valueOf(i12));
                                                                                    bitSet2.set(i12);
                                                                                    if (ra.N(z4Var2.L(), i12)) {
                                                                                        bitSet.set(i12);
                                                                                    }
                                                                                    i12++;
                                                                                    zB = z12;
                                                                                } else {
                                                                                    z12 = zB;
                                                                                }
                                                                                aVar.remove(Integer.valueOf(i12));
                                                                                i12++;
                                                                                zB = z12;
                                                                            }
                                                                        }
                                                                        boolean z13 = zB;
                                                                        com.google.android.gms.internal.measurement.z4 z4Var4 = (com.google.android.gms.internal.measurement.z4) map2.get(num2);
                                                                        if (!zB2) {
                                                                        }
                                                                        this.f4660f.put(num2, new eb(this, this.f4658d, z4Var4, bitSet, bitSet2, aVar, aVar10, null));
                                                                        str2 = str2;
                                                                        map = map;
                                                                        str14 = str14;
                                                                        map2 = map2;
                                                                        zB = z13;
                                                                        map3 = map11;
                                                                    }
                                                                    str4 = str2;
                                                                    str5 = str14;
                                                                    str6 = "Skipping failed audience ID";
                                                                    if (!list.isEmpty()) {
                                                                        gbVar = new gb(this, null);
                                                                        aVar6 = new k.a();
                                                                        it7 = list.iterator();
                                                                        while (it7.hasNext()) {
                                                                            j4Var = (com.google.android.gms.internal.measurement.j4) it7.next();
                                                                            j4VarA = gbVar.a(this.f4658d, j4Var);
                                                                            if (j4VarA != null) {
                                                                                kVarV3 = this.f4655b.V();
                                                                                str10 = this.f4658d;
                                                                                strK = j4VarA.K();
                                                                                qVarV = kVarV3.V(str10, j4Var.K());
                                                                                if (qVarV == null) {
                                                                                    kVarV3.f4646a.d().w().c("Event aggregate wasn't created during raw event logging. appId, event", v3.z(str10), kVarV3.f4646a.D().d(strK));
                                                                                    qVar = new q(str10, j4Var.K(), 1L, 1L, 1L, j4Var.G(), 0L, null, null, null, null);
                                                                                } else {
                                                                                    qVar = new q(qVarV.f5229a, qVarV.f5230b, qVarV.f5231c + 1, qVarV.f5232d + 1, qVarV.f5233e + 1, qVarV.f5234f, qVarV.f5235g, qVarV.f5236h, qVarV.f5237i, qVarV.f5238j, qVarV.f5239k);
                                                                                }
                                                                                this.f4655b.V().q(qVar);
                                                                                j10 = qVar.f5231c;
                                                                                strK2 = j4VarA.K();
                                                                                map6 = (Map) aVar6.get(strK2);
                                                                                if (map6 == null) {
                                                                                    kVarV4 = this.f4655b.V();
                                                                                    str11 = this.f4658d;
                                                                                    kVarV4.i();
                                                                                    kVarV4.h();
                                                                                    u1.f.d(str11);
                                                                                    u1.f.d(strK2);
                                                                                    aVar7 = new k.a();
                                                                                    try {
                                                                                        try {
                                                                                            qVar2 = qVar;
                                                                                            try {
                                                                                                cursorQuery3 = kVarV4.P().query("event_filters", new String[]{str5, str4}, "app_id=? AND event_name=?", new String[]{str11, strK2}, null, null, null);
                                                                                                try {
                                                                                                    try {
                                                                                                        if (cursorQuery3.moveToFirst()) {
                                                                                                            j11 = j10;
                                                                                                            do {
                                                                                                                try {
                                                                                                                    try {
                                                                                                                        com.google.android.gms.internal.measurement.z2 z2Var2 = (com.google.android.gms.internal.measurement.z2) ((com.google.android.gms.internal.measurement.y2) ra.E(com.google.android.gms.internal.measurement.z2.F(), cursorQuery3.getBlob(1))).o();
                                                                                                                        numValueOf5 = Integer.valueOf(cursorQuery3.getInt(0));
                                                                                                                        arrayList4 = (List) aVar7.get(numValueOf5);
                                                                                                                        if (arrayList4 == null) {
                                                                                                                            arrayList4 = new ArrayList();
                                                                                                                            aVar7.put(numValueOf5, arrayList4);
                                                                                                                        }
                                                                                                                        arrayList4.add(z2Var2);
                                                                                                                    } catch (IOException e16) {
                                                                                                                        kVarV4.f4646a.d().r().c("Failed to merge filter. appId", v3.z(str11), e16);
                                                                                                                    }
                                                                                                                } catch (SQLiteException e17) {
                                                                                                                    e = e17;
                                                                                                                    kVarV4.f4646a.d().r().c("Database error querying filters. appId", v3.z(str11), e);
                                                                                                                    map6 = Collections.EMPTY_MAP;
                                                                                                                    if (cursorQuery3 != null) {
                                                                                                                        cursorQuery3.close();
                                                                                                                    }
                                                                                                                }
                                                                                                            } while (cursorQuery3.moveToNext());
                                                                                                            cursorQuery3.close();
                                                                                                            map6 = aVar7;
                                                                                                        } else {
                                                                                                            j11 = j10;
                                                                                                            map6 = Collections.EMPTY_MAP;
                                                                                                            cursorQuery3.close();
                                                                                                        }
                                                                                                    } catch (SQLiteException e18) {
                                                                                                        e = e18;
                                                                                                        j11 = j10;
                                                                                                    }
                                                                                                    aVar6.put(strK2, map6);
                                                                                                } catch (Throwable th) {
                                                                                                    th = th;
                                                                                                    if (cursorQuery3 != null) {
                                                                                                        cursorQuery3.close();
                                                                                                    }
                                                                                                    throw th;
                                                                                                }
                                                                                            } catch (SQLiteException e19) {
                                                                                                e = e19;
                                                                                                j11 = j10;
                                                                                                cursorQuery3 = null;
                                                                                                kVarV4.f4646a.d().r().c("Database error querying filters. appId", v3.z(str11), e);
                                                                                                map6 = Collections.EMPTY_MAP;
                                                                                                if (cursorQuery3 != null) {
                                                                                                    cursorQuery3.close();
                                                                                                }
                                                                                                aVar6.put(strK2, map6);
                                                                                                for (Integer num3 : map6.keySet()) {
                                                                                                    iIntValue = num3.intValue();
                                                                                                    if (this.f4659e.contains(num3)) {
                                                                                                        this.f4646a.d().v().b("Skipping failed audience ID", num3);
                                                                                                    } else {
                                                                                                        it8 = ((List) map6.get(num3)).iterator();
                                                                                                        zK2 = true;
                                                                                                        while (true) {
                                                                                                            if (!it8.hasNext()) {
                                                                                                                map7 = map6;
                                                                                                                break;
                                                                                                            }
                                                                                                            com.google.android.gms.internal.measurement.z2 z2Var3 = (com.google.android.gms.internal.measurement.z2) it8.next();
                                                                                                            hbVar = new hb(this, this.f4658d, iIntValue, z2Var3);
                                                                                                            map7 = map6;
                                                                                                            zK2 = hbVar.k(this.f4661g, this.f4662h, j4VarA, j11, qVar2, o(iIntValue, z2Var3.E()));
                                                                                                            if (!zK2) {
                                                                                                                this.f4659e.add(num3);
                                                                                                                break;
                                                                                                            }
                                                                                                            n(num3).c(hbVar);
                                                                                                            map6 = map7;
                                                                                                        }
                                                                                                        if (!zK2) {
                                                                                                            this.f4659e.add(num3);
                                                                                                        }
                                                                                                        map6 = map7;
                                                                                                    }
                                                                                                }
                                                                                                it7 = it7;
                                                                                                gbVar = gbVar;
                                                                                            }
                                                                                        } catch (SQLiteException e20) {
                                                                                            e = e20;
                                                                                            qVar2 = qVar;
                                                                                        }
                                                                                    } catch (Throwable th2) {
                                                                                        th = th2;
                                                                                        cursorQuery3 = null;
                                                                                    }
                                                                                } else {
                                                                                    qVar2 = qVar;
                                                                                    j11 = j10;
                                                                                }
                                                                                while (r3.hasNext()) {
                                                                                    iIntValue = num3.intValue();
                                                                                    if (this.f4659e.contains(num3)) {
                                                                                        this.f4646a.d().v().b("Skipping failed audience ID", num3);
                                                                                    } else {
                                                                                        it8 = ((List) map6.get(num3)).iterator();
                                                                                        zK2 = true;
                                                                                        while (true) {
                                                                                            if (!it8.hasNext()) {
                                                                                                map7 = map6;
                                                                                                break;
                                                                                            }
                                                                                            com.google.android.gms.internal.measurement.z2 z2Var4 = (com.google.android.gms.internal.measurement.z2) it8.next();
                                                                                            hbVar = new hb(this, this.f4658d, iIntValue, z2Var4);
                                                                                            map7 = map6;
                                                                                            zK2 = hbVar.k(this.f4661g, this.f4662h, j4VarA, j11, qVar2, o(iIntValue, z2Var4.E()));
                                                                                            if (!zK2) {
                                                                                                this.f4659e.add(num3);
                                                                                                break;
                                                                                            }
                                                                                            n(num3).c(hbVar);
                                                                                            map6 = map7;
                                                                                        }
                                                                                        if (!zK2) {
                                                                                            this.f4659e.add(num3);
                                                                                        }
                                                                                        map6 = map7;
                                                                                    }
                                                                                }
                                                                                it7 = it7;
                                                                                gbVar = gbVar;
                                                                            }
                                                                        }
                                                                    }
                                                                    if (!list2.isEmpty()) {
                                                                        aVar4 = new k.a();
                                                                        it4 = list2.iterator();
                                                                        while (it4.hasNext()) {
                                                                            com.google.android.gms.internal.measurement.d5 d5Var = (com.google.android.gms.internal.measurement.d5) it4.next();
                                                                            strI = d5Var.I();
                                                                            map5 = (Map) aVar4.get(strI);
                                                                            if (map5 == null) {
                                                                                kVarV2 = this.f4655b.V();
                                                                                str8 = this.f4658d;
                                                                                kVarV2.i();
                                                                                kVarV2.h();
                                                                                u1.f.d(str8);
                                                                                u1.f.d(strI);
                                                                                aVar5 = new k.a();
                                                                                try {
                                                                                    cursorQuery2 = kVarV2.P().query("property_filters", new String[]{str5, str4}, "app_id=? AND property_name=?", new String[]{str8, strI}, null, null, null);
                                                                                    try {
                                                                                        try {
                                                                                            if (cursorQuery2.moveToFirst()) {
                                                                                                while (true) {
                                                                                                    try {
                                                                                                        com.google.android.gms.internal.measurement.i3 i3Var2 = (com.google.android.gms.internal.measurement.i3) ((com.google.android.gms.internal.measurement.h3) ra.E(com.google.android.gms.internal.measurement.i3.F(), cursorQuery2.getBlob(1))).o();
                                                                                                        numValueOf4 = Integer.valueOf(cursorQuery2.getInt(0));
                                                                                                        list5 = (List) aVar5.get(numValueOf4);
                                                                                                        if (list5 == null) {
                                                                                                            it5 = it4;
                                                                                                            try {
                                                                                                                arrayList3 = new ArrayList();
                                                                                                                aVar5.put(numValueOf4, arrayList3);
                                                                                                            } catch (SQLiteException e21) {
                                                                                                                e = e21;
                                                                                                                str9 = str8;
                                                                                                                kVarV2.f4646a.d().r().c("Database error querying filters. appId", v3.z(str9), e);
                                                                                                                map5 = Collections.EMPTY_MAP;
                                                                                                                if (cursorQuery2 != null) {
                                                                                                                    cursorQuery2.close();
                                                                                                                }
                                                                                                                aVar4.put(strI, map5);
                                                                                                                for (Integer num4 : map5.keySet()) {
                                                                                                                    int iIntValue2 = num4.intValue();
                                                                                                                    if (this.f4659e.contains(num4)) {
                                                                                                                        this.f4646a.d().v().b(str6, num4);
                                                                                                                        break;
                                                                                                                    }
                                                                                                                    it6 = ((List) map5.get(num4)).iterator();
                                                                                                                    zK = true;
                                                                                                                    while (true) {
                                                                                                                        if (it6.hasNext()) {
                                                                                                                            i3Var = (com.google.android.gms.internal.measurement.i3) it6.next();
                                                                                                                            if (Log.isLoggable(this.f4646a.d().D(), 2)) {
                                                                                                                                t3 t3VarV = this.f4646a.d().v();
                                                                                                                                if (i3Var.M()) {
                                                                                                                                    numValueOf3 = Integer.valueOf(i3Var.D());
                                                                                                                                } else {
                                                                                                                                    numValueOf3 = null;
                                                                                                                                }
                                                                                                                                t3VarV.d("Evaluating filter. audience, filter, property", num4, numValueOf3, this.f4646a.D().f(i3Var.H()));
                                                                                                                                this.f4646a.d().v().b("Filter definition", this.f4655b.g0().H(i3Var));
                                                                                                                            }
                                                                                                                            if (i3Var.M()) {
                                                                                                                            }
                                                                                                                            t3 t3VarW = this.f4646a.d().w();
                                                                                                                            Object objZ = v3.z(this.f4658d);
                                                                                                                            if (i3Var.M()) {
                                                                                                                                numValueOf2 = Integer.valueOf(i3Var.D());
                                                                                                                            } else {
                                                                                                                                numValueOf2 = null;
                                                                                                                            }
                                                                                                                            t3VarW.c("Invalid property filter ID. appId, id", objZ, String.valueOf(numValueOf2));
                                                                                                                            this.f4659e.add(num4);
                                                                                                                            map5 = map5;
                                                                                                                            str6 = str6;
                                                                                                                        } else {
                                                                                                                            map5 = map5;
                                                                                                                            str6 = str6;
                                                                                                                        }
                                                                                                                        if (!zK) {
                                                                                                                            this.f4659e.add(num4);
                                                                                                                        }
                                                                                                                        map5 = map5;
                                                                                                                        str6 = str6;
                                                                                                                        n(num4).c(jbVar);
                                                                                                                        map5 = map5;
                                                                                                                        str6 = str6;
                                                                                                                    }
                                                                                                                }
                                                                                                                it4 = it5;
                                                                                                            }
                                                                                                        } else {
                                                                                                            it5 = it4;
                                                                                                            arrayList3 = list5;
                                                                                                        }
                                                                                                        arrayList3.add(i3Var2);
                                                                                                        str9 = str8;
                                                                                                    } catch (IOException e22) {
                                                                                                        it5 = it4;
                                                                                                        str9 = str8;
                                                                                                        kVarV2.f4646a.d().r().c("Failed to merge filter", v3.z(str9), e22);
                                                                                                    }
                                                                                                    try {
                                                                                                        if (!cursorQuery2.moveToNext()) {
                                                                                                            break;
                                                                                                        }
                                                                                                        it4 = it5;
                                                                                                        str8 = str9;
                                                                                                    } catch (SQLiteException e23) {
                                                                                                        e = e23;
                                                                                                        kVarV2.f4646a.d().r().c("Database error querying filters. appId", v3.z(str9), e);
                                                                                                        map5 = Collections.EMPTY_MAP;
                                                                                                        if (cursorQuery2 != null) {
                                                                                                            cursorQuery2.close();
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                                cursorQuery2.close();
                                                                                                map5 = aVar5;
                                                                                            } else {
                                                                                                it5 = it4;
                                                                                                map5 = Collections.EMPTY_MAP;
                                                                                                cursorQuery2.close();
                                                                                            }
                                                                                        } catch (SQLiteException e24) {
                                                                                            e = e24;
                                                                                            it5 = it4;
                                                                                        }
                                                                                    } catch (Throwable th3) {
                                                                                        th = th3;
                                                                                        cursor2 = cursorQuery2;
                                                                                        if (cursor2 != null) {
                                                                                            cursor2.close();
                                                                                        }
                                                                                        throw th;
                                                                                    }
                                                                                } catch (SQLiteException e25) {
                                                                                    e = e25;
                                                                                    it5 = it4;
                                                                                    str9 = str8;
                                                                                    cursorQuery2 = null;
                                                                                } catch (Throwable th4) {
                                                                                    th = th4;
                                                                                    cursor2 = null;
                                                                                }
                                                                                aVar4.put(strI, map5);
                                                                            } else {
                                                                                it5 = it4;
                                                                            }
                                                                            while (r4.hasNext()) {
                                                                                int iIntValue3 = num4.intValue();
                                                                                if (this.f4659e.contains(num4)) {
                                                                                    this.f4646a.d().v().b(str6, num4);
                                                                                    break;
                                                                                    break;
                                                                                }
                                                                                it6 = ((List) map5.get(num4)).iterator();
                                                                                zK = true;
                                                                                while (true) {
                                                                                    if (it6.hasNext()) {
                                                                                        i3Var = (com.google.android.gms.internal.measurement.i3) it6.next();
                                                                                        if (Log.isLoggable(this.f4646a.d().D(), 2)) {
                                                                                            t3 t3VarV2 = this.f4646a.d().v();
                                                                                            if (i3Var.M()) {
                                                                                                numValueOf3 = Integer.valueOf(i3Var.D());
                                                                                            } else {
                                                                                                numValueOf3 = null;
                                                                                            }
                                                                                            t3VarV2.d("Evaluating filter. audience, filter, property", num4, numValueOf3, this.f4646a.D().f(i3Var.H()));
                                                                                            this.f4646a.d().v().b("Filter definition", this.f4655b.g0().H(i3Var));
                                                                                        }
                                                                                        if (i3Var.M()) {
                                                                                        }
                                                                                        t3 t3VarW2 = this.f4646a.d().w();
                                                                                        Object objZ2 = v3.z(this.f4658d);
                                                                                        if (i3Var.M()) {
                                                                                            numValueOf2 = Integer.valueOf(i3Var.D());
                                                                                        } else {
                                                                                            numValueOf2 = null;
                                                                                        }
                                                                                        t3VarW2.c("Invalid property filter ID. appId, id", objZ2, String.valueOf(numValueOf2));
                                                                                        this.f4659e.add(num4);
                                                                                        map5 = map5;
                                                                                        str6 = str6;
                                                                                    } else {
                                                                                        map5 = map5;
                                                                                        str6 = str6;
                                                                                    }
                                                                                    if (!zK) {
                                                                                        this.f4659e.add(num4);
                                                                                    }
                                                                                    map5 = map5;
                                                                                    str6 = str6;
                                                                                    n(num4).c(jbVar);
                                                                                    map5 = map5;
                                                                                    str6 = str6;
                                                                                }
                                                                            }
                                                                            it4 = it5;
                                                                        }
                                                                    }
                                                                    arrayList2 = new ArrayList();
                                                                    Set<Integer> setKeySet = this.f4660f.keySet();
                                                                    setKeySet.removeAll(this.f4659e);
                                                                    for (Integer num5 : setKeySet) {
                                                                        int iIntValue4 = num5.intValue();
                                                                        eb ebVar = (eb) this.f4660f.get(num5);
                                                                        u1.f.h(ebVar);
                                                                        com.google.android.gms.internal.measurement.f4 f4VarA = ebVar.a(iIntValue4);
                                                                        arrayList2.add(f4VarA);
                                                                        kVarV = this.f4655b.V();
                                                                        str7 = this.f4658d;
                                                                        com.google.android.gms.internal.measurement.z4 z4VarG = f4VarA.G();
                                                                        kVarV.i();
                                                                        kVarV.h();
                                                                        u1.f.d(str7);
                                                                        u1.f.h(z4VarG);
                                                                        byte[] bArrJ = z4VarG.j();
                                                                        contentValues = new ContentValues();
                                                                        contentValues.put("app_id", str7);
                                                                        contentValues.put(str5, num5);
                                                                        contentValues.put("current_results", bArrJ);
                                                                        try {
                                                                            try {
                                                                                if (kVarV.P().insertWithOnConflict("audience_filter_values", null, contentValues, 5) == -1) {
                                                                                    kVarV.f4646a.d().r().b("Failed to insert filter results (got -1). appId", v3.z(str7));
                                                                                }
                                                                            } catch (SQLiteException e26) {
                                                                                e = e26;
                                                                                kVarV.f4646a.d().r().c("Error storing filter results. appId", v3.z(str7), e);
                                                                            }
                                                                        } catch (SQLiteException e27) {
                                                                            e = e27;
                                                                        }
                                                                    }
                                                                    return arrayList2;
                                                                }
                                                            } catch (Throwable th5) {
                                                                th = th5;
                                                                r10 = sQLiteDatabaseP;
                                                                if (r10 != 0) {
                                                                    r10.close();
                                                                }
                                                                throw th;
                                                            }
                                                        } catch (SQLiteException e28) {
                                                            e = e28;
                                                            cursorRawQuery = null;
                                                        } catch (Throwable th6) {
                                                            th = th6;
                                                            r10 = 0;
                                                            if (r10 != 0) {
                                                                r10.close();
                                                            }
                                                            throw th;
                                                        }
                                                        cursorRawQuery.close();
                                                        u1.f.d(str17);
                                                        u1.f.h(map2);
                                                        aVar3 = new k.a();
                                                        if (!map2.isEmpty()) {
                                                            it2 = map2.keySet().iterator();
                                                            while (it2.hasNext()) {
                                                                num = (Integer) it2.next();
                                                                num.intValue();
                                                                z4Var3 = (com.google.android.gms.internal.measurement.z4) map2.get(num);
                                                                list4 = (List) aVar2.get(num);
                                                                if (list4 != null) {
                                                                }
                                                                map4 = aVar2;
                                                                it3 = it2;
                                                                aVar3.put(num, z4Var3);
                                                                aVar2 = map4;
                                                                hashSet = hashSet;
                                                                it2 = it3;
                                                            }
                                                        }
                                                        hashSet2 = hashSet;
                                                        map3 = aVar3;
                                                    } else {
                                                        hashSet2 = hashSet;
                                                        map3 = map2;
                                                    }
                                                    while (r16.hasNext()) {
                                                        num2.intValue();
                                                        z4Var = (com.google.android.gms.internal.measurement.z4) map3.get(num2);
                                                        bitSet = new BitSet();
                                                        bitSet2 = new BitSet();
                                                        aVar = new k.a();
                                                        if (z4Var != null) {
                                                            while (r7.hasNext()) {
                                                                if (h4Var.K()) {
                                                                    Map map12 = map3;
                                                                    Integer numValueOf8 = Integer.valueOf(h4Var.D());
                                                                    if (h4Var.J()) {
                                                                        lValueOf = Long.valueOf(h4Var.E());
                                                                    } else {
                                                                        lValueOf = null;
                                                                    }
                                                                    aVar.put(numValueOf8, lValueOf);
                                                                    map3 = map12;
                                                                }
                                                            }
                                                        }
                                                        Map map13 = map3;
                                                        k.a aVar11 = new k.a();
                                                        if (z4Var != null) {
                                                            it = z4Var.M().iterator();
                                                            while (it.hasNext()) {
                                                                b5Var = (com.google.android.gms.internal.measurement.b5) it.next();
                                                                if (!b5Var.L()) {
                                                                }
                                                            }
                                                        }
                                                        z4Var2 = z4Var;
                                                        if (z4Var2 != null) {
                                                            i12 = 0;
                                                            while (i12 < z4Var2.G() * 64) {
                                                                if (ra.N(z4Var2.N(), i12)) {
                                                                    z12 = zB;
                                                                    this.f4646a.d().v().c("Filter already evaluated. audience ID, filter ID", num2, Integer.valueOf(i12));
                                                                    bitSet2.set(i12);
                                                                    if (ra.N(z4Var2.L(), i12)) {
                                                                        bitSet.set(i12);
                                                                    }
                                                                    i12++;
                                                                    zB = z12;
                                                                } else {
                                                                    z12 = zB;
                                                                }
                                                                aVar.remove(Integer.valueOf(i12));
                                                                i12++;
                                                                zB = z12;
                                                            }
                                                        }
                                                        boolean z14 = zB;
                                                        com.google.android.gms.internal.measurement.z4 z4Var5 = (com.google.android.gms.internal.measurement.z4) map2.get(num2);
                                                        if (!zB2) {
                                                        }
                                                        this.f4660f.put(num2, new eb(this, this.f4658d, z4Var5, bitSet, bitSet2, aVar, aVar11, null));
                                                        str2 = str2;
                                                        map = map;
                                                        str14 = str14;
                                                        map2 = map2;
                                                        zB = z14;
                                                        map3 = map13;
                                                    }
                                                }
                                                str4 = str2;
                                                str5 = str14;
                                                str6 = "Skipping failed audience ID";
                                                if (!list.isEmpty()) {
                                                    gbVar = new gb(this, null);
                                                    aVar6 = new k.a();
                                                    it7 = list.iterator();
                                                    while (it7.hasNext()) {
                                                        j4Var = (com.google.android.gms.internal.measurement.j4) it7.next();
                                                        j4VarA = gbVar.a(this.f4658d, j4Var);
                                                        if (j4VarA != null) {
                                                            kVarV3 = this.f4655b.V();
                                                            str10 = this.f4658d;
                                                            strK = j4VarA.K();
                                                            qVarV = kVarV3.V(str10, j4Var.K());
                                                            if (qVarV == null) {
                                                                kVarV3.f4646a.d().w().c("Event aggregate wasn't created during raw event logging. appId, event", v3.z(str10), kVarV3.f4646a.D().d(strK));
                                                                qVar = new q(str10, j4Var.K(), 1L, 1L, 1L, j4Var.G(), 0L, null, null, null, null);
                                                            } else {
                                                                qVar = new q(qVarV.f5229a, qVarV.f5230b, qVarV.f5231c + 1, qVarV.f5232d + 1, qVarV.f5233e + 1, qVarV.f5234f, qVarV.f5235g, qVarV.f5236h, qVarV.f5237i, qVarV.f5238j, qVarV.f5239k);
                                                            }
                                                            this.f4655b.V().q(qVar);
                                                            j10 = qVar.f5231c;
                                                            strK2 = j4VarA.K();
                                                            map6 = (Map) aVar6.get(strK2);
                                                            if (map6 == null) {
                                                                kVarV4 = this.f4655b.V();
                                                                str11 = this.f4658d;
                                                                kVarV4.i();
                                                                kVarV4.h();
                                                                u1.f.d(str11);
                                                                u1.f.d(strK2);
                                                                aVar7 = new k.a();
                                                                qVar2 = qVar;
                                                                cursorQuery3 = kVarV4.P().query("event_filters", new String[]{str5, str4}, "app_id=? AND event_name=?", new String[]{str11, strK2}, null, null, null);
                                                                if (cursorQuery3.moveToFirst()) {
                                                                    j11 = j10;
                                                                    do {
                                                                        com.google.android.gms.internal.measurement.z2 z2Var5 = (com.google.android.gms.internal.measurement.z2) ((com.google.android.gms.internal.measurement.y2) ra.E(com.google.android.gms.internal.measurement.z2.F(), cursorQuery3.getBlob(1))).o();
                                                                        numValueOf5 = Integer.valueOf(cursorQuery3.getInt(0));
                                                                        arrayList4 = (List) aVar7.get(numValueOf5);
                                                                        if (arrayList4 == null) {
                                                                            arrayList4 = new ArrayList();
                                                                            aVar7.put(numValueOf5, arrayList4);
                                                                        }
                                                                        arrayList4.add(z2Var5);
                                                                    } while (cursorQuery3.moveToNext());
                                                                    cursorQuery3.close();
                                                                    map6 = aVar7;
                                                                } else {
                                                                    j11 = j10;
                                                                    map6 = Collections.EMPTY_MAP;
                                                                    cursorQuery3.close();
                                                                }
                                                                aVar6.put(strK2, map6);
                                                            } else {
                                                                qVar2 = qVar;
                                                                j11 = j10;
                                                            }
                                                            while (r3.hasNext()) {
                                                                iIntValue = num3.intValue();
                                                                if (this.f4659e.contains(num3)) {
                                                                    this.f4646a.d().v().b("Skipping failed audience ID", num3);
                                                                } else {
                                                                    it8 = ((List) map6.get(num3)).iterator();
                                                                    zK2 = true;
                                                                    while (true) {
                                                                        if (!it8.hasNext()) {
                                                                            map7 = map6;
                                                                            break;
                                                                        }
                                                                        com.google.android.gms.internal.measurement.z2 z2Var6 = (com.google.android.gms.internal.measurement.z2) it8.next();
                                                                        hbVar = new hb(this, this.f4658d, iIntValue, z2Var6);
                                                                        map7 = map6;
                                                                        zK2 = hbVar.k(this.f4661g, this.f4662h, j4VarA, j11, qVar2, o(iIntValue, z2Var6.E()));
                                                                        if (!zK2) {
                                                                            this.f4659e.add(num3);
                                                                            break;
                                                                        }
                                                                        n(num3).c(hbVar);
                                                                        map6 = map7;
                                                                    }
                                                                    if (!zK2) {
                                                                        this.f4659e.add(num3);
                                                                    }
                                                                    map6 = map7;
                                                                }
                                                            }
                                                            it7 = it7;
                                                            gbVar = gbVar;
                                                        }
                                                    }
                                                }
                                                if (!list2.isEmpty()) {
                                                    aVar4 = new k.a();
                                                    it4 = list2.iterator();
                                                    while (it4.hasNext()) {
                                                        com.google.android.gms.internal.measurement.d5 d5Var2 = (com.google.android.gms.internal.measurement.d5) it4.next();
                                                        strI = d5Var2.I();
                                                        map5 = (Map) aVar4.get(strI);
                                                        if (map5 == null) {
                                                            kVarV2 = this.f4655b.V();
                                                            str8 = this.f4658d;
                                                            kVarV2.i();
                                                            kVarV2.h();
                                                            u1.f.d(str8);
                                                            u1.f.d(strI);
                                                            aVar5 = new k.a();
                                                            cursorQuery2 = kVarV2.P().query("property_filters", new String[]{str5, str4}, "app_id=? AND property_name=?", new String[]{str8, strI}, null, null, null);
                                                            if (cursorQuery2.moveToFirst()) {
                                                                while (true) {
                                                                    com.google.android.gms.internal.measurement.i3 i3Var3 = (com.google.android.gms.internal.measurement.i3) ((com.google.android.gms.internal.measurement.h3) ra.E(com.google.android.gms.internal.measurement.i3.F(), cursorQuery2.getBlob(1))).o();
                                                                    numValueOf4 = Integer.valueOf(cursorQuery2.getInt(0));
                                                                    list5 = (List) aVar5.get(numValueOf4);
                                                                    if (list5 == null) {
                                                                        it5 = it4;
                                                                        arrayList3 = new ArrayList();
                                                                        aVar5.put(numValueOf4, arrayList3);
                                                                    } else {
                                                                        it5 = it4;
                                                                        arrayList3 = list5;
                                                                    }
                                                                    arrayList3.add(i3Var3);
                                                                    str9 = str8;
                                                                    if (!cursorQuery2.moveToNext()) {
                                                                        break;
                                                                        break;
                                                                    }
                                                                    it4 = it5;
                                                                    str8 = str9;
                                                                }
                                                                cursorQuery2.close();
                                                                map5 = aVar5;
                                                            } else {
                                                                it5 = it4;
                                                                map5 = Collections.EMPTY_MAP;
                                                                cursorQuery2.close();
                                                            }
                                                            aVar4.put(strI, map5);
                                                        } else {
                                                            it5 = it4;
                                                        }
                                                        while (r4.hasNext()) {
                                                            int iIntValue5 = num4.intValue();
                                                            if (this.f4659e.contains(num4)) {
                                                                this.f4646a.d().v().b(str6, num4);
                                                                break;
                                                                break;
                                                            }
                                                            it6 = ((List) map5.get(num4)).iterator();
                                                            zK = true;
                                                            while (true) {
                                                                if (it6.hasNext()) {
                                                                    i3Var = (com.google.android.gms.internal.measurement.i3) it6.next();
                                                                    if (Log.isLoggable(this.f4646a.d().D(), 2)) {
                                                                        t3 t3VarV3 = this.f4646a.d().v();
                                                                        if (i3Var.M()) {
                                                                            numValueOf3 = Integer.valueOf(i3Var.D());
                                                                        } else {
                                                                            numValueOf3 = null;
                                                                        }
                                                                        t3VarV3.d("Evaluating filter. audience, filter, property", num4, numValueOf3, this.f4646a.D().f(i3Var.H()));
                                                                        this.f4646a.d().v().b("Filter definition", this.f4655b.g0().H(i3Var));
                                                                    }
                                                                    if (i3Var.M()) {
                                                                    }
                                                                    t3 t3VarW3 = this.f4646a.d().w();
                                                                    Object objZ3 = v3.z(this.f4658d);
                                                                    if (i3Var.M()) {
                                                                        numValueOf2 = Integer.valueOf(i3Var.D());
                                                                    } else {
                                                                        numValueOf2 = null;
                                                                    }
                                                                    t3VarW3.c("Invalid property filter ID. appId, id", objZ3, String.valueOf(numValueOf2));
                                                                    this.f4659e.add(num4);
                                                                    map5 = map5;
                                                                    str6 = str6;
                                                                } else {
                                                                    map5 = map5;
                                                                    str6 = str6;
                                                                }
                                                                if (!zK) {
                                                                    this.f4659e.add(num4);
                                                                }
                                                                map5 = map5;
                                                                str6 = str6;
                                                                n(num4).c(jbVar);
                                                                map5 = map5;
                                                                str6 = str6;
                                                            }
                                                        }
                                                        it4 = it5;
                                                    }
                                                }
                                                arrayList2 = new ArrayList();
                                                Set<Integer> setKeySet2 = this.f4660f.keySet();
                                                setKeySet2.removeAll(this.f4659e);
                                                while (r3.hasNext()) {
                                                    int iIntValue6 = num5.intValue();
                                                    eb ebVar2 = (eb) this.f4660f.get(num5);
                                                    u1.f.h(ebVar2);
                                                    com.google.android.gms.internal.measurement.f4 f4VarA2 = ebVar2.a(iIntValue6);
                                                    arrayList2.add(f4VarA2);
                                                    kVarV = this.f4655b.V();
                                                    str7 = this.f4658d;
                                                    com.google.android.gms.internal.measurement.z4 z4VarG2 = f4VarA2.G();
                                                    kVarV.i();
                                                    kVarV.h();
                                                    u1.f.d(str7);
                                                    u1.f.h(z4VarG2);
                                                    byte[] bArrJ2 = z4VarG2.j();
                                                    contentValues = new ContentValues();
                                                    contentValues.put("app_id", str7);
                                                    contentValues.put(str5, num5);
                                                    contentValues.put("current_results", bArrJ2);
                                                    if (kVarV.P().insertWithOnConflict("audience_filter_values", null, contentValues, 5) == -1) {
                                                        kVarV.f4646a.d().r().b("Failed to insert filter results (got -1). appId", v3.z(str7));
                                                    }
                                                }
                                                return arrayList2;
                                            }
                                        }
                                        try {
                                            if (!cursorQuery.moveToNext()) {
                                                break;
                                            }
                                            z10 = z11;
                                            str13 = str2;
                                            str14 = str14;
                                        } catch (SQLiteException e29) {
                                            e = e29;
                                            kVarV7.f4646a.d().r().c("Database error querying filter results. appId", v3.z(str16), e);
                                            Map map14 = Collections.EMPTY_MAP;
                                            if (cursorQuery != null) {
                                                cursorQuery.close();
                                            }
                                            map2 = map14;
                                        }
                                    }
                                    cursorQuery.close();
                                    map2 = aVar8;
                                } else {
                                    Map map15 = Collections.EMPTY_MAP;
                                    cursorQuery.close();
                                    map2 = map15;
                                    z11 = z10;
                                    str2 = "data";
                                    str14 = "audience_id";
                                }
                            } catch (Throwable th7) {
                                th = th7;
                                cursor = cursorQuery;
                                if (cursor != null) {
                                    cursor.close();
                                }
                                throw th;
                            }
                        } catch (SQLiteException e30) {
                            e = e30;
                            z11 = z10;
                            str2 = "data";
                        }
                        if (!map2.isEmpty()) {
                            hashSet = new HashSet(map2.keySet());
                            if (z11) {
                                String str18 = this.f4658d;
                                k kVarV9 = this.f4655b.V();
                                str3 = this.f4658d;
                                kVarV9.i();
                                kVarV9.h();
                                u1.f.d(str3);
                                aVar2 = new k.a();
                                sQLiteDatabaseP = kVarV9.P();
                                cursorRawQuery = sQLiteDatabaseP.rawQuery("select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;", new String[]{str3, str3});
                                if (cursorRawQuery.moveToFirst()) {
                                    do {
                                        numValueOf = Integer.valueOf(cursorRawQuery.getInt(0));
                                        arrayList = (List) aVar2.get(numValueOf);
                                        if (arrayList == null) {
                                            arrayList = new ArrayList();
                                            aVar2.put(numValueOf, arrayList);
                                        }
                                        arrayList.add(Integer.valueOf(cursorRawQuery.getInt(1)));
                                    } while (cursorRawQuery.moveToNext());
                                } else {
                                    aVar2 = Collections.EMPTY_MAP;
                                }
                                cursorRawQuery.close();
                                u1.f.d(str18);
                                u1.f.h(map2);
                                aVar3 = new k.a();
                                if (!map2.isEmpty()) {
                                    it2 = map2.keySet().iterator();
                                    while (it2.hasNext()) {
                                        num = (Integer) it2.next();
                                        num.intValue();
                                        z4Var3 = (com.google.android.gms.internal.measurement.z4) map2.get(num);
                                        list4 = (List) aVar2.get(num);
                                        if (list4 != null) {
                                        }
                                        map4 = aVar2;
                                        it3 = it2;
                                        aVar3.put(num, z4Var3);
                                        aVar2 = map4;
                                        hashSet = hashSet;
                                        it2 = it3;
                                    }
                                }
                                hashSet2 = hashSet;
                                map3 = aVar3;
                            } else {
                                hashSet2 = hashSet;
                                map3 = map2;
                            }
                            while (r16.hasNext()) {
                                num2.intValue();
                                z4Var = (com.google.android.gms.internal.measurement.z4) map3.get(num2);
                                bitSet = new BitSet();
                                bitSet2 = new BitSet();
                                aVar = new k.a();
                                if (z4Var != null) {
                                    while (r7.hasNext()) {
                                        if (h4Var.K()) {
                                            Map map16 = map3;
                                            Integer numValueOf9 = Integer.valueOf(h4Var.D());
                                            if (h4Var.J()) {
                                                lValueOf = Long.valueOf(h4Var.E());
                                            } else {
                                                lValueOf = null;
                                            }
                                            aVar.put(numValueOf9, lValueOf);
                                            map3 = map16;
                                        }
                                    }
                                }
                                Map map17 = map3;
                                k.a aVar12 = new k.a();
                                if (z4Var != null) {
                                    it = z4Var.M().iterator();
                                    while (it.hasNext()) {
                                        b5Var = (com.google.android.gms.internal.measurement.b5) it.next();
                                        if (!b5Var.L()) {
                                        }
                                    }
                                }
                                z4Var2 = z4Var;
                                if (z4Var2 != null) {
                                    i12 = 0;
                                    while (i12 < z4Var2.G() * 64) {
                                        if (ra.N(z4Var2.N(), i12)) {
                                            z12 = zB;
                                            this.f4646a.d().v().c("Filter already evaluated. audience ID, filter ID", num2, Integer.valueOf(i12));
                                            bitSet2.set(i12);
                                            if (ra.N(z4Var2.L(), i12)) {
                                                bitSet.set(i12);
                                            }
                                            i12++;
                                            zB = z12;
                                        } else {
                                            z12 = zB;
                                        }
                                        aVar.remove(Integer.valueOf(i12));
                                        i12++;
                                        zB = z12;
                                    }
                                }
                                boolean z15 = zB;
                                com.google.android.gms.internal.measurement.z4 z4Var6 = (com.google.android.gms.internal.measurement.z4) map2.get(num2);
                                if (!zB2) {
                                }
                                this.f4660f.put(num2, new eb(this, this.f4658d, z4Var6, bitSet, bitSet2, aVar, aVar12, null));
                                str2 = str2;
                                map = map;
                                str14 = str14;
                                map2 = map2;
                                zB = z15;
                                map3 = map17;
                            }
                        }
                        str4 = str2;
                        str5 = str14;
                        str6 = "Skipping failed audience ID";
                        if (!list.isEmpty()) {
                            gbVar = new gb(this, null);
                            aVar6 = new k.a();
                            it7 = list.iterator();
                            while (it7.hasNext()) {
                                j4Var = (com.google.android.gms.internal.measurement.j4) it7.next();
                                j4VarA = gbVar.a(this.f4658d, j4Var);
                                if (j4VarA != null) {
                                    kVarV3 = this.f4655b.V();
                                    str10 = this.f4658d;
                                    strK = j4VarA.K();
                                    qVarV = kVarV3.V(str10, j4Var.K());
                                    if (qVarV == null) {
                                        kVarV3.f4646a.d().w().c("Event aggregate wasn't created during raw event logging. appId, event", v3.z(str10), kVarV3.f4646a.D().d(strK));
                                        qVar = new q(str10, j4Var.K(), 1L, 1L, 1L, j4Var.G(), 0L, null, null, null, null);
                                    } else {
                                        qVar = new q(qVarV.f5229a, qVarV.f5230b, qVarV.f5231c + 1, qVarV.f5232d + 1, qVarV.f5233e + 1, qVarV.f5234f, qVarV.f5235g, qVarV.f5236h, qVarV.f5237i, qVarV.f5238j, qVarV.f5239k);
                                    }
                                    this.f4655b.V().q(qVar);
                                    j10 = qVar.f5231c;
                                    strK2 = j4VarA.K();
                                    map6 = (Map) aVar6.get(strK2);
                                    if (map6 == null) {
                                        kVarV4 = this.f4655b.V();
                                        str11 = this.f4658d;
                                        kVarV4.i();
                                        kVarV4.h();
                                        u1.f.d(str11);
                                        u1.f.d(strK2);
                                        aVar7 = new k.a();
                                        qVar2 = qVar;
                                        cursorQuery3 = kVarV4.P().query("event_filters", new String[]{str5, str4}, "app_id=? AND event_name=?", new String[]{str11, strK2}, null, null, null);
                                        if (cursorQuery3.moveToFirst()) {
                                            j11 = j10;
                                            do {
                                                com.google.android.gms.internal.measurement.z2 z2Var7 = (com.google.android.gms.internal.measurement.z2) ((com.google.android.gms.internal.measurement.y2) ra.E(com.google.android.gms.internal.measurement.z2.F(), cursorQuery3.getBlob(1))).o();
                                                numValueOf5 = Integer.valueOf(cursorQuery3.getInt(0));
                                                arrayList4 = (List) aVar7.get(numValueOf5);
                                                if (arrayList4 == null) {
                                                    arrayList4 = new ArrayList();
                                                    aVar7.put(numValueOf5, arrayList4);
                                                }
                                                arrayList4.add(z2Var7);
                                            } while (cursorQuery3.moveToNext());
                                            cursorQuery3.close();
                                            map6 = aVar7;
                                        } else {
                                            j11 = j10;
                                            map6 = Collections.EMPTY_MAP;
                                            cursorQuery3.close();
                                        }
                                        aVar6.put(strK2, map6);
                                    } else {
                                        qVar2 = qVar;
                                        j11 = j10;
                                    }
                                    while (r3.hasNext()) {
                                        iIntValue = num3.intValue();
                                        if (this.f4659e.contains(num3)) {
                                            this.f4646a.d().v().b("Skipping failed audience ID", num3);
                                        } else {
                                            it8 = ((List) map6.get(num3)).iterator();
                                            zK2 = true;
                                            while (true) {
                                                if (!it8.hasNext()) {
                                                    map7 = map6;
                                                    break;
                                                }
                                                com.google.android.gms.internal.measurement.z2 z2Var8 = (com.google.android.gms.internal.measurement.z2) it8.next();
                                                hbVar = new hb(this, this.f4658d, iIntValue, z2Var8);
                                                map7 = map6;
                                                zK2 = hbVar.k(this.f4661g, this.f4662h, j4VarA, j11, qVar2, o(iIntValue, z2Var8.E()));
                                                if (!zK2) {
                                                    this.f4659e.add(num3);
                                                    break;
                                                }
                                                n(num3).c(hbVar);
                                                map6 = map7;
                                            }
                                            if (!zK2) {
                                                this.f4659e.add(num3);
                                            }
                                            map6 = map7;
                                        }
                                    }
                                    it7 = it7;
                                    gbVar = gbVar;
                                }
                            }
                        }
                        if (!list2.isEmpty()) {
                            aVar4 = new k.a();
                            it4 = list2.iterator();
                            while (it4.hasNext()) {
                                com.google.android.gms.internal.measurement.d5 d5Var3 = (com.google.android.gms.internal.measurement.d5) it4.next();
                                strI = d5Var3.I();
                                map5 = (Map) aVar4.get(strI);
                                if (map5 == null) {
                                    kVarV2 = this.f4655b.V();
                                    str8 = this.f4658d;
                                    kVarV2.i();
                                    kVarV2.h();
                                    u1.f.d(str8);
                                    u1.f.d(strI);
                                    aVar5 = new k.a();
                                    cursorQuery2 = kVarV2.P().query("property_filters", new String[]{str5, str4}, "app_id=? AND property_name=?", new String[]{str8, strI}, null, null, null);
                                    if (cursorQuery2.moveToFirst()) {
                                        while (true) {
                                            com.google.android.gms.internal.measurement.i3 i3Var4 = (com.google.android.gms.internal.measurement.i3) ((com.google.android.gms.internal.measurement.h3) ra.E(com.google.android.gms.internal.measurement.i3.F(), cursorQuery2.getBlob(1))).o();
                                            numValueOf4 = Integer.valueOf(cursorQuery2.getInt(0));
                                            list5 = (List) aVar5.get(numValueOf4);
                                            if (list5 == null) {
                                                it5 = it4;
                                                arrayList3 = new ArrayList();
                                                aVar5.put(numValueOf4, arrayList3);
                                            } else {
                                                it5 = it4;
                                                arrayList3 = list5;
                                            }
                                            arrayList3.add(i3Var4);
                                            str9 = str8;
                                            if (!cursorQuery2.moveToNext()) {
                                                break;
                                                break;
                                            }
                                            it4 = it5;
                                            str8 = str9;
                                        }
                                        cursorQuery2.close();
                                        map5 = aVar5;
                                    } else {
                                        it5 = it4;
                                        map5 = Collections.EMPTY_MAP;
                                        cursorQuery2.close();
                                    }
                                    aVar4.put(strI, map5);
                                } else {
                                    it5 = it4;
                                }
                                while (r4.hasNext()) {
                                    int iIntValue7 = num4.intValue();
                                    if (this.f4659e.contains(num4)) {
                                        this.f4646a.d().v().b(str6, num4);
                                        break;
                                        break;
                                    }
                                    it6 = ((List) map5.get(num4)).iterator();
                                    zK = true;
                                    while (true) {
                                        if (it6.hasNext()) {
                                            i3Var = (com.google.android.gms.internal.measurement.i3) it6.next();
                                            if (Log.isLoggable(this.f4646a.d().D(), 2)) {
                                                t3 t3VarV4 = this.f4646a.d().v();
                                                if (i3Var.M()) {
                                                    numValueOf3 = Integer.valueOf(i3Var.D());
                                                } else {
                                                    numValueOf3 = null;
                                                }
                                                t3VarV4.d("Evaluating filter. audience, filter, property", num4, numValueOf3, this.f4646a.D().f(i3Var.H()));
                                                this.f4646a.d().v().b("Filter definition", this.f4655b.g0().H(i3Var));
                                            }
                                            if (i3Var.M()) {
                                            }
                                            t3 t3VarW4 = this.f4646a.d().w();
                                            Object objZ4 = v3.z(this.f4658d);
                                            if (i3Var.M()) {
                                                numValueOf2 = Integer.valueOf(i3Var.D());
                                            } else {
                                                numValueOf2 = null;
                                            }
                                            t3VarW4.c("Invalid property filter ID. appId, id", objZ4, String.valueOf(numValueOf2));
                                            this.f4659e.add(num4);
                                            map5 = map5;
                                            str6 = str6;
                                        } else {
                                            map5 = map5;
                                            str6 = str6;
                                        }
                                        if (!zK) {
                                            this.f4659e.add(num4);
                                        }
                                        map5 = map5;
                                        str6 = str6;
                                        n(num4).c(jbVar);
                                        map5 = map5;
                                        str6 = str6;
                                    }
                                }
                                it4 = it5;
                            }
                        }
                        arrayList2 = new ArrayList();
                        Set<Integer> setKeySet3 = this.f4660f.keySet();
                        setKeySet3.removeAll(this.f4659e);
                        while (r3.hasNext()) {
                            int iIntValue8 = num5.intValue();
                            eb ebVar3 = (eb) this.f4660f.get(num5);
                            u1.f.h(ebVar3);
                            com.google.android.gms.internal.measurement.f4 f4VarA3 = ebVar3.a(iIntValue8);
                            arrayList2.add(f4VarA3);
                            kVarV = this.f4655b.V();
                            str7 = this.f4658d;
                            com.google.android.gms.internal.measurement.z4 z4VarG3 = f4VarA3.G();
                            kVarV.i();
                            kVarV.h();
                            u1.f.d(str7);
                            u1.f.h(z4VarG3);
                            byte[] bArrJ3 = z4VarG3.j();
                            contentValues = new ContentValues();
                            contentValues.put("app_id", str7);
                            contentValues.put(str5, num5);
                            contentValues.put("current_results", bArrJ3);
                            if (kVarV.P().insertWithOnConflict("audience_filter_values", null, contentValues, 5) == -1) {
                                kVarV.f4646a.d().r().b("Failed to insert filter results (got -1). appId", v3.z(str7));
                            }
                        }
                        return arrayList2;
                    }
                } catch (Throwable th8) {
                    th = th8;
                    r11 = obj;
                    if (r11 != 0) {
                        r11.close();
                    }
                    throw th;
                }
            } catch (SQLiteException e31) {
                e = e31;
                cursorQuery4 = null;
            } catch (Throwable th9) {
                th = th9;
                r11 = 0;
                if (r11 != 0) {
                    r11.close();
                }
                throw th;
            }
        } else {
            map = map8;
        }
        k kVarV10 = this.f4655b.V();
        String str19 = this.f4658d;
        kVarV10.i();
        kVarV10.h();
        u1.f.d(str19);
        try {
            cursorQuery = kVarV10.P().query("audience_filter_values", new String[]{"audience_id", "current_results"}, "app_id=?", new String[]{str19}, null, null, null);
            if (cursorQuery.moveToFirst()) {
                Map map18 = Collections.EMPTY_MAP;
                cursorQuery.close();
                map2 = map18;
                z11 = z10;
                str2 = "data";
                str14 = "audience_id";
            } else {
                aVar8 = new k.a();
                while (true) {
                    i13 = cursorQuery.getInt(0);
                    aVar8.put(Integer.valueOf(i13), (com.google.android.gms.internal.measurement.z4) ((com.google.android.gms.internal.measurement.y4) ra.E(com.google.android.gms.internal.measurement.z4.H(), cursorQuery.getBlob(1))).o());
                    z11 = z10;
                    str2 = str13;
                    if (!cursorQuery.moveToNext()) {
                        break;
                        break;
                    }
                    z10 = z11;
                    str13 = str2;
                    str14 = str14;
                }
                cursorQuery.close();
                map2 = aVar8;
            }
        } catch (SQLiteException e32) {
            e = e32;
            z11 = z10;
            str2 = "data";
            str14 = "audience_id";
            cursorQuery = null;
        } catch (Throwable th10) {
            th = th10;
            cursor = null;
        }
        if (!map2.isEmpty()) {
            hashSet = new HashSet(map2.keySet());
            if (z11) {
                String str110 = this.f4658d;
                k kVarV11 = this.f4655b.V();
                str3 = this.f4658d;
                kVarV11.i();
                kVarV11.h();
                u1.f.d(str3);
                aVar2 = new k.a();
                sQLiteDatabaseP = kVarV11.P();
                cursorRawQuery = sQLiteDatabaseP.rawQuery("select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;", new String[]{str3, str3});
                if (cursorRawQuery.moveToFirst()) {
                    do {
                        numValueOf = Integer.valueOf(cursorRawQuery.getInt(0));
                        arrayList = (List) aVar2.get(numValueOf);
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                            aVar2.put(numValueOf, arrayList);
                        }
                        arrayList.add(Integer.valueOf(cursorRawQuery.getInt(1)));
                    } while (cursorRawQuery.moveToNext());
                } else {
                    aVar2 = Collections.EMPTY_MAP;
                }
                cursorRawQuery.close();
                u1.f.d(str110);
                u1.f.h(map2);
                aVar3 = new k.a();
                if (!map2.isEmpty()) {
                    it2 = map2.keySet().iterator();
                    while (it2.hasNext()) {
                        num = (Integer) it2.next();
                        num.intValue();
                        z4Var3 = (com.google.android.gms.internal.measurement.z4) map2.get(num);
                        list4 = (List) aVar2.get(num);
                        if (list4 != null || list4.isEmpty()) {
                            map4 = aVar2;
                            it3 = it2;
                            aVar3.put(num, z4Var3);
                            aVar2 = map4;
                            hashSet = hashSet;
                            it2 = it3;
                        } else {
                            map4 = aVar2;
                            List listI = this.f4655b.g0().I(z4Var3.L(), list4);
                            if (listI.isEmpty()) {
                                aVar2 = map4;
                            } else {
                                com.google.android.gms.internal.measurement.y4 y4Var = (com.google.android.gms.internal.measurement.y4) z4Var3.m();
                                y4Var.x();
                                y4Var.t(listI);
                                List listI2 = this.f4655b.g0().I(z4Var3.N(), list4);
                                y4Var.z();
                                y4Var.v(listI2);
                                ArrayList arrayList6 = new ArrayList();
                                Iterator it10 = z4Var3.K().iterator();
                                while (it10.hasNext()) {
                                    Iterator it11 = it10;
                                    com.google.android.gms.internal.measurement.h4 h4Var2 = (com.google.android.gms.internal.measurement.h4) it10.next();
                                    Iterator it12 = it2;
                                    if (!list4.contains(Integer.valueOf(h4Var2.D()))) {
                                        arrayList6.add(h4Var2);
                                    }
                                    it10 = it11;
                                    it2 = it12;
                                }
                                it3 = it2;
                                y4Var.w();
                                y4Var.s(arrayList6);
                                ArrayList arrayList7 = new ArrayList();
                                for (com.google.android.gms.internal.measurement.b5 b5Var2 : z4Var3.M()) {
                                    if (!list4.contains(Integer.valueOf(b5Var2.E()))) {
                                        arrayList7.add(b5Var2);
                                    }
                                }
                                y4Var.y();
                                y4Var.u(arrayList7);
                                aVar3.put(num, (com.google.android.gms.internal.measurement.z4) y4Var.o());
                                aVar2 = map4;
                                hashSet = hashSet;
                                it2 = it3;
                            }
                        }
                    }
                }
                hashSet2 = hashSet;
                map3 = aVar3;
            } else {
                hashSet2 = hashSet;
                map3 = map2;
            }
            while (r16.hasNext()) {
                num2.intValue();
                z4Var = (com.google.android.gms.internal.measurement.z4) map3.get(num2);
                bitSet = new BitSet();
                bitSet2 = new BitSet();
                aVar = new k.a();
                if (z4Var != null && z4Var.D() != 0) {
                    while (r7.hasNext()) {
                        if (h4Var.K()) {
                            Map map19 = map3;
                            Integer numValueOf10 = Integer.valueOf(h4Var.D());
                            if (h4Var.J()) {
                                lValueOf = Long.valueOf(h4Var.E());
                            } else {
                                lValueOf = null;
                            }
                            aVar.put(numValueOf10, lValueOf);
                            map3 = map19;
                        }
                    }
                }
                Map map110 = map3;
                k.a aVar13 = new k.a();
                if (z4Var != null && z4Var.F() != 0) {
                    it = z4Var.M().iterator();
                    while (it.hasNext()) {
                        b5Var = (com.google.android.gms.internal.measurement.b5) it.next();
                        if (!b5Var.L() && b5Var.D() > 0) {
                            aVar13.put(Integer.valueOf(b5Var.E()), Long.valueOf(b5Var.F(b5Var.D() - 1)));
                            it = it;
                            z4Var = z4Var;
                        }
                    }
                }
                z4Var2 = z4Var;
                if (z4Var2 != null) {
                    i12 = 0;
                    while (i12 < z4Var2.G() * 64) {
                        if (ra.N(z4Var2.N(), i12)) {
                            z12 = zB;
                            this.f4646a.d().v().c("Filter already evaluated. audience ID, filter ID", num2, Integer.valueOf(i12));
                            bitSet2.set(i12);
                            if (ra.N(z4Var2.L(), i12)) {
                                bitSet.set(i12);
                            }
                            i12++;
                            zB = z12;
                        } else {
                            z12 = zB;
                        }
                        aVar.remove(Integer.valueOf(i12));
                        i12++;
                        zB = z12;
                    }
                }
                boolean z16 = zB;
                com.google.android.gms.internal.measurement.z4 z4Var7 = (com.google.android.gms.internal.measurement.z4) map2.get(num2);
                if (!zB2 && z16 && (list3 = (List) map.get(num2)) != null && this.f4662h != null && this.f4661g != null) {
                    Iterator it13 = list3.iterator();
                    while (it13.hasNext()) {
                        com.google.android.gms.internal.measurement.z2 z2Var9 = (com.google.android.gms.internal.measurement.z2) it13.next();
                        int iE = z2Var9.E();
                        Iterator it14 = it13;
                        long jLongValue = this.f4662h.longValue() / 1000;
                        if (z2Var9.O()) {
                            jLongValue = this.f4661g.longValue() / 1000;
                        }
                        Integer numValueOf11 = Integer.valueOf(iE);
                        if (aVar.containsKey(numValueOf11)) {
                            aVar.put(numValueOf11, Long.valueOf(jLongValue));
                        }
                        if (aVar13.containsKey(numValueOf11)) {
                            aVar13.put(numValueOf11, Long.valueOf(jLongValue));
                        }
                        it13 = it14;
                    }
                }
                this.f4660f.put(num2, new eb(this, this.f4658d, z4Var7, bitSet, bitSet2, aVar, aVar13, null));
                str2 = str2;
                map = map;
                str14 = str14;
                map2 = map2;
                zB = z16;
                map3 = map110;
            }
        }
        str4 = str2;
        str5 = str14;
        str6 = "Skipping failed audience ID";
        if (!list.isEmpty()) {
            gbVar = new gb(this, null);
            aVar6 = new k.a();
            it7 = list.iterator();
            while (it7.hasNext()) {
                j4Var = (com.google.android.gms.internal.measurement.j4) it7.next();
                j4VarA = gbVar.a(this.f4658d, j4Var);
                if (j4VarA != null) {
                    kVarV3 = this.f4655b.V();
                    str10 = this.f4658d;
                    strK = j4VarA.K();
                    qVarV = kVarV3.V(str10, j4Var.K());
                    if (qVarV == null) {
                        kVarV3.f4646a.d().w().c("Event aggregate wasn't created during raw event logging. appId, event", v3.z(str10), kVarV3.f4646a.D().d(strK));
                        qVar = new q(str10, j4Var.K(), 1L, 1L, 1L, j4Var.G(), 0L, null, null, null, null);
                    } else {
                        qVar = new q(qVarV.f5229a, qVarV.f5230b, qVarV.f5231c + 1, qVarV.f5232d + 1, qVarV.f5233e + 1, qVarV.f5234f, qVarV.f5235g, qVarV.f5236h, qVarV.f5237i, qVarV.f5238j, qVarV.f5239k);
                    }
                    this.f4655b.V().q(qVar);
                    j10 = qVar.f5231c;
                    strK2 = j4VarA.K();
                    map6 = (Map) aVar6.get(strK2);
                    if (map6 == null) {
                        kVarV4 = this.f4655b.V();
                        str11 = this.f4658d;
                        kVarV4.i();
                        kVarV4.h();
                        u1.f.d(str11);
                        u1.f.d(strK2);
                        aVar7 = new k.a();
                        qVar2 = qVar;
                        cursorQuery3 = kVarV4.P().query("event_filters", new String[]{str5, str4}, "app_id=? AND event_name=?", new String[]{str11, strK2}, null, null, null);
                        if (cursorQuery3.moveToFirst()) {
                            j11 = j10;
                            do {
                                com.google.android.gms.internal.measurement.z2 z2Var10 = (com.google.android.gms.internal.measurement.z2) ((com.google.android.gms.internal.measurement.y2) ra.E(com.google.android.gms.internal.measurement.z2.F(), cursorQuery3.getBlob(1))).o();
                                numValueOf5 = Integer.valueOf(cursorQuery3.getInt(0));
                                arrayList4 = (List) aVar7.get(numValueOf5);
                                if (arrayList4 == null) {
                                    arrayList4 = new ArrayList();
                                    aVar7.put(numValueOf5, arrayList4);
                                }
                                arrayList4.add(z2Var10);
                            } while (cursorQuery3.moveToNext());
                            cursorQuery3.close();
                            map6 = aVar7;
                        } else {
                            j11 = j10;
                            map6 = Collections.EMPTY_MAP;
                            cursorQuery3.close();
                        }
                        aVar6.put(strK2, map6);
                    } else {
                        qVar2 = qVar;
                        j11 = j10;
                    }
                    while (r3.hasNext()) {
                        iIntValue = num3.intValue();
                        if (this.f4659e.contains(num3)) {
                            this.f4646a.d().v().b("Skipping failed audience ID", num3);
                        } else {
                            it8 = ((List) map6.get(num3)).iterator();
                            zK2 = true;
                            while (true) {
                                if (!it8.hasNext()) {
                                    map7 = map6;
                                    break;
                                }
                                com.google.android.gms.internal.measurement.z2 z2Var11 = (com.google.android.gms.internal.measurement.z2) it8.next();
                                hbVar = new hb(this, this.f4658d, iIntValue, z2Var11);
                                map7 = map6;
                                zK2 = hbVar.k(this.f4661g, this.f4662h, j4VarA, j11, qVar2, o(iIntValue, z2Var11.E()));
                                if (!zK2) {
                                    this.f4659e.add(num3);
                                    break;
                                }
                                n(num3).c(hbVar);
                                map6 = map7;
                            }
                            if (!zK2) {
                                this.f4659e.add(num3);
                            }
                            map6 = map7;
                        }
                    }
                    it7 = it7;
                    gbVar = gbVar;
                }
            }
        }
        if (!list2.isEmpty()) {
            aVar4 = new k.a();
            it4 = list2.iterator();
            while (it4.hasNext()) {
                com.google.android.gms.internal.measurement.d5 d5Var4 = (com.google.android.gms.internal.measurement.d5) it4.next();
                strI = d5Var4.I();
                map5 = (Map) aVar4.get(strI);
                if (map5 == null) {
                    kVarV2 = this.f4655b.V();
                    str8 = this.f4658d;
                    kVarV2.i();
                    kVarV2.h();
                    u1.f.d(str8);
                    u1.f.d(strI);
                    aVar5 = new k.a();
                    cursorQuery2 = kVarV2.P().query("property_filters", new String[]{str5, str4}, "app_id=? AND property_name=?", new String[]{str8, strI}, null, null, null);
                    if (cursorQuery2.moveToFirst()) {
                        while (true) {
                            com.google.android.gms.internal.measurement.i3 i3Var5 = (com.google.android.gms.internal.measurement.i3) ((com.google.android.gms.internal.measurement.h3) ra.E(com.google.android.gms.internal.measurement.i3.F(), cursorQuery2.getBlob(1))).o();
                            numValueOf4 = Integer.valueOf(cursorQuery2.getInt(0));
                            list5 = (List) aVar5.get(numValueOf4);
                            if (list5 == null) {
                                it5 = it4;
                                arrayList3 = new ArrayList();
                                aVar5.put(numValueOf4, arrayList3);
                            } else {
                                it5 = it4;
                                arrayList3 = list5;
                            }
                            arrayList3.add(i3Var5);
                            str9 = str8;
                            if (!cursorQuery2.moveToNext()) {
                                break;
                                break;
                            }
                            it4 = it5;
                            str8 = str9;
                        }
                        cursorQuery2.close();
                        map5 = aVar5;
                    } else {
                        it5 = it4;
                        map5 = Collections.EMPTY_MAP;
                        cursorQuery2.close();
                    }
                    aVar4.put(strI, map5);
                } else {
                    it5 = it4;
                }
                while (r4.hasNext()) {
                    int iIntValue9 = num4.intValue();
                    if (this.f4659e.contains(num4)) {
                        this.f4646a.d().v().b(str6, num4);
                        break;
                        break;
                    }
                    it6 = ((List) map5.get(num4)).iterator();
                    zK = true;
                    while (true) {
                        if (it6.hasNext()) {
                            i3Var = (com.google.android.gms.internal.measurement.i3) it6.next();
                            if (Log.isLoggable(this.f4646a.d().D(), 2)) {
                                t3 t3VarV5 = this.f4646a.d().v();
                                if (i3Var.M()) {
                                    numValueOf3 = Integer.valueOf(i3Var.D());
                                } else {
                                    numValueOf3 = null;
                                }
                                t3VarV5.d("Evaluating filter. audience, filter, property", num4, numValueOf3, this.f4646a.D().f(i3Var.H()));
                                this.f4646a.d().v().b("Filter definition", this.f4655b.g0().H(i3Var));
                            }
                            if (i3Var.M() || i3Var.D() > 256) {
                                t3 t3VarW5 = this.f4646a.d().w();
                                Object objZ5 = v3.z(this.f4658d);
                                if (i3Var.M()) {
                                    numValueOf2 = Integer.valueOf(i3Var.D());
                                } else {
                                    numValueOf2 = null;
                                }
                                t3VarW5.c("Invalid property filter ID. appId, id", objZ5, String.valueOf(numValueOf2));
                                this.f4659e.add(num4);
                                map5 = map5;
                                str6 = str6;
                            } else {
                                jbVar = new jb(this, this.f4658d, iIntValue9, i3Var);
                                zK = jbVar.k(this.f4661g, this.f4662h, d5Var4, o(iIntValue9, i3Var.D()));
                                if (zK) {
                                    n(num4).c(jbVar);
                                    map5 = map5;
                                    str6 = str6;
                                } else {
                                    this.f4659e.add(num4);
                                }
                            }
                        } else {
                            map5 = map5;
                            str6 = str6;
                        }
                        if (!zK) {
                            this.f4659e.add(num4);
                        }
                        map5 = map5;
                        str6 = str6;
                    }
                }
                it4 = it5;
            }
        }
        arrayList2 = new ArrayList();
        Set<Integer> setKeySet4 = this.f4660f.keySet();
        setKeySet4.removeAll(this.f4659e);
        while (r3.hasNext()) {
            int iIntValue10 = num5.intValue();
            eb ebVar4 = (eb) this.f4660f.get(num5);
            u1.f.h(ebVar4);
            com.google.android.gms.internal.measurement.f4 f4VarA4 = ebVar4.a(iIntValue10);
            arrayList2.add(f4VarA4);
            kVarV = this.f4655b.V();
            str7 = this.f4658d;
            com.google.android.gms.internal.measurement.z4 z4VarG4 = f4VarA4.G();
            kVarV.i();
            kVarV.h();
            u1.f.d(str7);
            u1.f.h(z4VarG4);
            byte[] bArrJ4 = z4VarG4.j();
            contentValues = new ContentValues();
            contentValues.put("app_id", str7);
            contentValues.put(str5, num5);
            contentValues.put("current_results", bArrJ4);
            if (kVarV.P().insertWithOnConflict("audience_filter_values", null, contentValues, 5) == -1) {
                kVarV.f4646a.d().r().b("Failed to insert filter results (got -1). appId", v3.z(str7));
            }
        }
        return arrayList2;
    }

    public final eb n(Integer num) {
        if (this.f4660f.containsKey(num)) {
            return (eb) this.f4660f.get(num);
        }
        eb ebVar = new eb(this, this.f4658d, null);
        this.f4660f.put(num, ebVar);
        return ebVar;
    }

    public final boolean o(int i10, int i11) {
        eb ebVar = (eb) this.f4660f.get(Integer.valueOf(i10));
        if (ebVar == null) {
            return false;
        }
        return ebVar.f4779d.get(i11);
    }
}
