package f2;

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

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class b extends ba {

    /* renamed from: d, reason: collision with root package name */
    public String f5042d;

    /* renamed from: e, reason: collision with root package name */
    public Set f5043e;

    /* renamed from: f, reason: collision with root package name */
    public Map f5044f;

    /* renamed from: g, reason: collision with root package name */
    public Long f5045g;

    /* renamed from: h, reason: collision with root package name */
    public Long f5046h;

    public b(pa paVar) {
        super(paVar);
    }

    @Override // f2.ba
    public final boolean l() {
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:396:0x09b9, code lost:
    
        r0 = r39.f5030a.d().w();
        r2 = f2.v3.z(r39.f5042d);
     */
    /* JADX WARN: Code restructure failed: missing block: B:397:0x09cd, code lost:
    
        if (r12.M() == false) goto L399;
     */
    /* JADX WARN: Code restructure failed: missing block: B:398:0x09cf, code lost:
    
        r7 = java.lang.Integer.valueOf(r12.D());
     */
    /* JADX WARN: Code restructure failed: missing block: B:399:0x09d8, code lost:
    
        r7 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:400:0x09d9, code lost:
    
        r0.c("Invalid property filter ID. appId, id", r2, java.lang.String.valueOf(r7));
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x02ff  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x03f5  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0406  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x05a6  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x0705 A[PHI: r0 r5 r20 r22
  0x0705: PHI (r0v167 java.util.Map) = (r0v169 java.util.Map), (r0v175 java.util.Map) binds: [B:288:0x072d, B:275:0x0703] A[DONT_GENERATE, DONT_INLINE]
  0x0705: PHI (r5v37 android.database.Cursor) = (r5v38 android.database.Cursor), (r5v39 android.database.Cursor) binds: [B:288:0x072d, B:275:0x0703] A[DONT_GENERATE, DONT_INLINE]
  0x0705: PHI (r20v9 long) = (r20v10 long), (r20v13 long) binds: [B:288:0x072d, B:275:0x0703] A[DONT_GENERATE, DONT_INLINE]
  0x0705: PHI (r22v17 f2.q) = (r22v18 f2.q), (r22v20 f2.q) binds: [B:288:0x072d, B:275:0x0703] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:298:0x074e  */
    /* JADX WARN: Removed duplicated region for block: B:316:0x07d2  */
    /* JADX WARN: Removed duplicated region for block: B:352:0x08a2 A[PHI: r0 r13 r41
  0x08a2: PHI (r0v123 java.util.Map) = (r0v125 java.util.Map), (r0v131 java.util.Map) binds: [B:361:0x08c6, B:351:0x08a0] A[DONT_GENERATE, DONT_INLINE]
  0x08a2: PHI (r13v12 android.database.Cursor) = (r13v13 android.database.Cursor), (r13v14 android.database.Cursor) binds: [B:361:0x08c6, B:351:0x08a0] A[DONT_GENERATE, DONT_INLINE]
  0x08a2: PHI (r41v4 java.util.Iterator) = (r41v5 java.util.Iterator), (r41v9 java.util.Iterator) binds: [B:361:0x08c6, B:351:0x08a0] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:371:0x08e3  */
    /* JADX WARN: Removed duplicated region for block: B:408:0x0a0e  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01a4 A[Catch: all -> 0x01b2, SQLiteException -> 0x01b5, TRY_LEAVE, TryCatch #15 {all -> 0x01b2, blocks: (B:59:0x019e, B:61:0x01a4, B:69:0x01be, B:70:0x01c3, B:71:0x01cd, B:72:0x01dd, B:81:0x0209, B:74:0x01ec, B:78:0x01fc, B:80:0x0202, B:98:0x0232), top: B:448:0x019e }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01be A[Catch: all -> 0x01b2, SQLiteException -> 0x01b5, TRY_ENTER, TryCatch #15 {all -> 0x01b2, blocks: (B:59:0x019e, B:61:0x01a4, B:69:0x01be, B:70:0x01c3, B:71:0x01cd, B:72:0x01dd, B:81:0x0209, B:74:0x01ec, B:78:0x01fc, B:80:0x0202, B:98:0x0232), top: B:448:0x019e }] */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v15 */
    /* JADX WARN: Type inference failed for: r11v2, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r5v49, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v50, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List m(String str, List list, List list2, Long l10, Long l11) throws Throwable {
        int i10;
        int i11;
        boolean z10;
        Cursor cursor;
        Map map;
        k kVarV;
        String str2;
        Cursor cursor2;
        boolean z11;
        String str3;
        String str4;
        Cursor cursorQuery;
        ?? r11;
        HashSet<Integer> hashSet;
        k.a aVar;
        List list3;
        boolean z12;
        ?? r52;
        Cursor cursorRawQuery;
        Map map2;
        HashSet hashSet2;
        Iterator it;
        Iterator it2;
        Iterator it3;
        Map map3;
        String str5;
        Cursor cursor3;
        String str6;
        Cursor cursorQuery2;
        List arrayList;
        Iterator it4;
        q qVar;
        gb gbVar;
        q qVar2;
        long j10;
        Map map4;
        Cursor cursorQuery3;
        Cursor cursor4;
        Cursor cursorQuery4;
        List arrayList2;
        t1.f.d(str);
        t1.f.h(list);
        t1.f.h(list2);
        this.f5042d = str;
        this.f5043e = new HashSet();
        this.f5044f = new k.a();
        this.f5045g = l10;
        this.f5046h = l11;
        Iterator it5 = list.iterator();
        while (true) {
            i10 = 0;
            i11 = 1;
            if (!it5.hasNext()) {
                z10 = false;
                break;
            }
            if ("_s".equals(((com.google.android.gms.internal.measurement.j4) it5.next()).K())) {
                z10 = true;
                break;
            }
        }
        cc.b();
        boolean zB = this.f5030a.z().B(this.f5042d, i3.f5296a0);
        cc.b();
        boolean zB2 = this.f5030a.z().B(this.f5042d, i3.Z);
        if (z10) {
            k kVarV2 = this.f5039b.V();
            String str7 = this.f5042d;
            kVarV2.i();
            kVarV2.h();
            t1.f.d(str7);
            ContentValues contentValues = new ContentValues();
            contentValues.put("current_session_count", (Integer) 0);
            try {
                ?? P = kVarV2.P();
                P.update("events", contentValues, "app_id = ?", new String[]{str7});
                cursor = P;
            } catch (SQLiteException e10) {
                kVarV2.f5030a.d().r().c("Error resetting session-scoped event counts. appId", v3.z(str7), e10);
                cursor = "Error resetting session-scoped event counts. appId";
            }
        }
        Map map5 = Collections.EMPTY_MAP;
        String str8 = "data";
        String str9 = "audience_id";
        if (zB2 && zB) {
            k kVarV3 = this.f5039b.V();
            String str10 = this.f5042d;
            t1.f.d(str10);
            k.a aVar2 = new k.a();
            try {
                try {
                    cursorQuery4 = kVarV3.P().query("event_filters", new String[]{"audience_id", "data"}, "app_id=?", new String[]{str10}, null, null, null);
                    try {
                        if (cursorQuery4.moveToFirst()) {
                            while (true) {
                                try {
                                    com.google.android.gms.internal.measurement.z2 z2Var = (com.google.android.gms.internal.measurement.z2) ((com.google.android.gms.internal.measurement.y2) ra.E(com.google.android.gms.internal.measurement.z2.F(), cursorQuery4.getBlob(i11))).o();
                                    if (z2Var.Q()) {
                                        Integer numValueOf = Integer.valueOf(cursorQuery4.getInt(i10));
                                        List list4 = (List) aVar2.get(numValueOf);
                                        if (list4 == null) {
                                            arrayList2 = new ArrayList();
                                            aVar2.put(numValueOf, arrayList2);
                                        } else {
                                            arrayList2 = list4;
                                        }
                                        arrayList2.add(z2Var);
                                    }
                                } catch (IOException e11) {
                                    kVarV3.f5030a.d().r().c("Failed to merge filter. appId", v3.z(str10), e11);
                                }
                                if (!cursorQuery4.moveToNext()) {
                                    break;
                                }
                                i10 = 0;
                                i11 = 1;
                            }
                            cursorQuery4.close();
                            map = aVar2;
                        }
                    } catch (SQLiteException e12) {
                        e = e12;
                        kVarV3.f5030a.d().r().c("Database error querying filters. appId", v3.z(str10), e);
                        map5 = Collections.EMPTY_MAP;
                        if (cursorQuery4 != null) {
                            cursorQuery4.close();
                        }
                        map = map5;
                        kVarV = this.f5039b.V();
                        str2 = this.f5042d;
                        kVarV.i();
                        kVarV.h();
                        t1.f.d(str2);
                        cursorQuery = kVarV.P().query("audience_filter_values", new String[]{"audience_id", "current_results"}, "app_id=?", new String[]{str2}, null, null, null);
                        try {
                            try {
                                if (cursorQuery.moveToFirst()) {
                                }
                            } catch (Throwable th) {
                                th = th;
                                cursor2 = cursorQuery;
                                if (cursor2 != null) {
                                    cursor2.close();
                                }
                                throw th;
                            }
                        } catch (SQLiteException e13) {
                            e = e13;
                            z11 = z10;
                            str3 = "data";
                        }
                        if (!r11.isEmpty()) {
                        }
                        String str11 = str3;
                        String str12 = str4;
                        String str13 = "Skipping failed audience ID";
                        if (!list.isEmpty()) {
                        }
                        if (!list2.isEmpty()) {
                        }
                        ArrayList arrayList3 = new ArrayList();
                        Set<Integer> setKeySet = this.f5044f.keySet();
                        setKeySet.removeAll(this.f5043e);
                        while (r3.hasNext()) {
                        }
                        return arrayList3;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor4 = cursor;
                    if (cursor4 != null) {
                        cursor4.close();
                    }
                    throw th;
                }
            } catch (SQLiteException e14) {
                e = e14;
                cursorQuery4 = null;
            } catch (Throwable th3) {
                th = th3;
                cursor4 = null;
                if (cursor4 != null) {
                }
                throw th;
            }
            cursorQuery4.close();
            map = map5;
        } else {
            map = map5;
        }
        kVarV = this.f5039b.V();
        str2 = this.f5042d;
        kVarV.i();
        kVarV.h();
        t1.f.d(str2);
        try {
            cursorQuery = kVarV.P().query("audience_filter_values", new String[]{"audience_id", "current_results"}, "app_id=?", new String[]{str2}, null, null, null);
            if (cursorQuery.moveToFirst()) {
                Map map6 = Collections.EMPTY_MAP;
                cursorQuery.close();
                r11 = map6;
                z11 = z10;
                str3 = "data";
                str4 = "audience_id";
            } else {
                k.a aVar3 = new k.a();
                while (true) {
                    int i12 = cursorQuery.getInt(0);
                    try {
                        aVar3.put(Integer.valueOf(i12), (com.google.android.gms.internal.measurement.z4) ((com.google.android.gms.internal.measurement.y4) ra.E(com.google.android.gms.internal.measurement.z4.H(), cursorQuery.getBlob(1))).o());
                        z11 = z10;
                        str3 = str8;
                        str4 = str9;
                    } catch (IOException e15) {
                        z11 = z10;
                        str3 = str8;
                        try {
                            str4 = str9;
                            try {
                                kVarV.f5030a.d().r().d("Failed to merge filter results. appId, audienceId, error", v3.z(str2), Integer.valueOf(i12), e15);
                            } catch (SQLiteException e16) {
                                e = e16;
                                kVarV.f5030a.d().r().c("Database error querying filter results. appId", v3.z(str2), e);
                                Map map7 = Collections.EMPTY_MAP;
                                if (cursorQuery != null) {
                                    cursorQuery.close();
                                }
                                r11 = map7;
                                if (!r11.isEmpty()) {
                                }
                                String str112 = str3;
                                String str122 = str4;
                                String str132 = "Skipping failed audience ID";
                                if (!list.isEmpty()) {
                                }
                                if (!list2.isEmpty()) {
                                }
                                ArrayList arrayList32 = new ArrayList();
                                Set<Integer> setKeySet2 = this.f5044f.keySet();
                                setKeySet2.removeAll(this.f5043e);
                                while (r3.hasNext()) {
                                }
                                return arrayList32;
                            }
                        } catch (SQLiteException e17) {
                            e = e17;
                            str4 = str9;
                            kVarV.f5030a.d().r().c("Database error querying filter results. appId", v3.z(str2), e);
                            Map map72 = Collections.EMPTY_MAP;
                            if (cursorQuery != null) {
                            }
                            r11 = map72;
                            if (!r11.isEmpty()) {
                            }
                            String str1122 = str3;
                            String str1222 = str4;
                            String str1322 = "Skipping failed audience ID";
                            if (!list.isEmpty()) {
                            }
                            if (!list2.isEmpty()) {
                            }
                            ArrayList arrayList322 = new ArrayList();
                            Set<Integer> setKeySet22 = this.f5044f.keySet();
                            setKeySet22.removeAll(this.f5043e);
                            while (r3.hasNext()) {
                            }
                            return arrayList322;
                        }
                    }
                    if (!cursorQuery.moveToNext()) {
                        break;
                    }
                    z10 = z11;
                    str8 = str3;
                    str9 = str4;
                }
                cursorQuery.close();
                r11 = aVar3;
            }
        } catch (SQLiteException e18) {
            e = e18;
            z11 = z10;
            str3 = "data";
            str4 = "audience_id";
            cursorQuery = null;
        } catch (Throwable th4) {
            th = th4;
            cursor2 = null;
        }
        if (!r11.isEmpty()) {
            HashSet hashSet3 = new HashSet(r11.keySet());
            if (z11) {
                String str14 = this.f5042d;
                k kVarV4 = this.f5039b.V();
                String str15 = this.f5042d;
                kVarV4.i();
                kVarV4.h();
                t1.f.d(str15);
                Map aVar4 = new k.a();
                SQLiteDatabase sQLiteDatabaseP = kVarV4.P();
                try {
                    try {
                        cursorRawQuery = sQLiteDatabaseP.rawQuery("select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;", new String[]{str15, str15});
                        try {
                            if (cursorRawQuery.moveToFirst()) {
                                do {
                                    Integer numValueOf2 = Integer.valueOf(cursorRawQuery.getInt(0));
                                    List arrayList4 = (List) aVar4.get(numValueOf2);
                                    if (arrayList4 == null) {
                                        arrayList4 = new ArrayList();
                                        aVar4.put(numValueOf2, arrayList4);
                                    }
                                    arrayList4.add(Integer.valueOf(cursorRawQuery.getInt(1)));
                                } while (cursorRawQuery.moveToNext());
                            } else {
                                aVar4 = Collections.EMPTY_MAP;
                            }
                        } catch (SQLiteException e19) {
                            e = e19;
                            kVarV4.f5030a.d().r().c("Database error querying scoped filters. appId", v3.z(str15), e);
                            aVar4 = Collections.EMPTY_MAP;
                            if (cursorRawQuery != null) {
                                cursorRawQuery.close();
                            }
                            t1.f.d(str14);
                            t1.f.h(r11);
                            k.a aVar5 = new k.a();
                            if (!r11.isEmpty()) {
                            }
                            hashSet = hashSet3;
                            aVar = aVar5;
                            Map map8 = r11;
                            while (r16.hasNext()) {
                            }
                            String str11222 = str3;
                            String str12222 = str4;
                            String str13222 = "Skipping failed audience ID";
                            if (!list.isEmpty()) {
                            }
                            if (!list2.isEmpty()) {
                            }
                            ArrayList arrayList3222 = new ArrayList();
                            Set<Integer> setKeySet222 = this.f5044f.keySet();
                            setKeySet222.removeAll(this.f5043e);
                            while (r3.hasNext()) {
                            }
                            return arrayList3222;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        r52 = sQLiteDatabaseP;
                        if (r52 != 0) {
                            r52.close();
                        }
                        throw th;
                    }
                } catch (SQLiteException e20) {
                    e = e20;
                    cursorRawQuery = null;
                } catch (Throwable th6) {
                    th = th6;
                    r52 = 0;
                    if (r52 != 0) {
                    }
                    throw th;
                }
                cursorRawQuery.close();
                t1.f.d(str14);
                t1.f.h(r11);
                k.a aVar52 = new k.a();
                if (!r11.isEmpty()) {
                    Iterator it6 = r11.keySet().iterator();
                    while (it6.hasNext()) {
                        Integer num = (Integer) it6.next();
                        num.intValue();
                        com.google.android.gms.internal.measurement.z4 z4Var = (com.google.android.gms.internal.measurement.z4) r11.get(num);
                        List list5 = (List) aVar4.get(num);
                        if (list5 == null || list5.isEmpty()) {
                            map2 = aVar4;
                            hashSet2 = hashSet3;
                            it = it6;
                            aVar52.put(num, z4Var);
                            aVar4 = map2;
                            hashSet3 = hashSet2;
                            it6 = it;
                        } else {
                            map2 = aVar4;
                            List listI = this.f5039b.g0().I(z4Var.L(), list5);
                            if (listI.isEmpty()) {
                                aVar4 = map2;
                            } else {
                                com.google.android.gms.internal.measurement.y4 y4Var = (com.google.android.gms.internal.measurement.y4) z4Var.m();
                                y4Var.x();
                                y4Var.t(listI);
                                hashSet2 = hashSet3;
                                List listI2 = this.f5039b.g0().I(z4Var.N(), list5);
                                y4Var.z();
                                y4Var.v(listI2);
                                ArrayList arrayList5 = new ArrayList();
                                Iterator it7 = z4Var.K().iterator();
                                while (it7.hasNext()) {
                                    Iterator it8 = it7;
                                    com.google.android.gms.internal.measurement.h4 h4Var = (com.google.android.gms.internal.measurement.h4) it7.next();
                                    Iterator it9 = it6;
                                    if (!list5.contains(Integer.valueOf(h4Var.D()))) {
                                        arrayList5.add(h4Var);
                                    }
                                    it7 = it8;
                                    it6 = it9;
                                }
                                it = it6;
                                y4Var.w();
                                y4Var.s(arrayList5);
                                ArrayList arrayList6 = new ArrayList();
                                for (com.google.android.gms.internal.measurement.b5 b5Var : z4Var.M()) {
                                    if (!list5.contains(Integer.valueOf(b5Var.E()))) {
                                        arrayList6.add(b5Var);
                                    }
                                }
                                y4Var.y();
                                y4Var.u(arrayList6);
                                aVar52.put(num, (com.google.android.gms.internal.measurement.z4) y4Var.o());
                                aVar4 = map2;
                                hashSet3 = hashSet2;
                                it6 = it;
                            }
                        }
                    }
                }
                hashSet = hashSet3;
                aVar = aVar52;
            } else {
                hashSet = hashSet3;
                aVar = r11;
            }
            Map map82 = r11;
            for (Integer num2 : hashSet) {
                num2.intValue();
                com.google.android.gms.internal.measurement.z4 z4Var2 = (com.google.android.gms.internal.measurement.z4) aVar.get(num2);
                BitSet bitSet = new BitSet();
                BitSet bitSet2 = new BitSet();
                k.a aVar6 = new k.a();
                if (z4Var2 != null && z4Var2.D() != 0) {
                    for (com.google.android.gms.internal.measurement.h4 h4Var2 : z4Var2.K()) {
                        if (h4Var2.K()) {
                            k.a aVar7 = aVar;
                            aVar6.put(Integer.valueOf(h4Var2.D()), h4Var2.J() ? Long.valueOf(h4Var2.E()) : null);
                            aVar = aVar7;
                        }
                    }
                }
                k.a aVar8 = aVar;
                k.a aVar9 = new k.a();
                if (z4Var2 != null && z4Var2.F() != 0) {
                    Iterator it10 = z4Var2.M().iterator();
                    while (it10.hasNext()) {
                        com.google.android.gms.internal.measurement.b5 b5Var2 = (com.google.android.gms.internal.measurement.b5) it10.next();
                        if (b5Var2.L() && b5Var2.D() > 0) {
                            aVar9.put(Integer.valueOf(b5Var2.E()), Long.valueOf(b5Var2.F(b5Var2.D() - 1)));
                            it10 = it10;
                            z4Var2 = z4Var2;
                        }
                    }
                }
                com.google.android.gms.internal.measurement.z4 z4Var3 = z4Var2;
                if (z4Var3 != null) {
                    int i13 = 0;
                    while (i13 < z4Var3.G() * 64) {
                        if (ra.N(z4Var3.N(), i13)) {
                            z12 = zB;
                            this.f5030a.d().v().c("Filter already evaluated. audience ID, filter ID", num2, Integer.valueOf(i13));
                            bitSet2.set(i13);
                            if (ra.N(z4Var3.L(), i13)) {
                                bitSet.set(i13);
                            }
                            i13++;
                            zB = z12;
                        } else {
                            z12 = zB;
                        }
                        aVar6.remove(Integer.valueOf(i13));
                        i13++;
                        zB = z12;
                    }
                }
                boolean z13 = zB;
                com.google.android.gms.internal.measurement.z4 z4Var4 = (com.google.android.gms.internal.measurement.z4) map82.get(num2);
                if (zB2 && z13 && (list3 = (List) map.get(num2)) != null && this.f5046h != null && this.f5045g != null) {
                    Iterator it11 = list3.iterator();
                    while (it11.hasNext()) {
                        com.google.android.gms.internal.measurement.z2 z2Var2 = (com.google.android.gms.internal.measurement.z2) it11.next();
                        int iE = z2Var2.E();
                        Iterator it12 = it11;
                        long jLongValue = this.f5046h.longValue() / 1000;
                        if (z2Var2.O()) {
                            jLongValue = this.f5045g.longValue() / 1000;
                        }
                        Integer numValueOf3 = Integer.valueOf(iE);
                        if (aVar6.containsKey(numValueOf3)) {
                            aVar6.put(numValueOf3, Long.valueOf(jLongValue));
                        }
                        if (aVar9.containsKey(numValueOf3)) {
                            aVar9.put(numValueOf3, Long.valueOf(jLongValue));
                        }
                        it11 = it12;
                    }
                }
                this.f5044f.put(num2, new eb(this, this.f5042d, z4Var4, bitSet, bitSet2, aVar6, aVar9, null));
                str3 = str3;
                map = map;
                str4 = str4;
                map82 = map82;
                zB = z13;
                aVar = aVar8;
            }
        }
        String str112222 = str3;
        String str122222 = str4;
        String str132222 = "Skipping failed audience ID";
        if (!list.isEmpty()) {
            gb gbVar2 = new gb(this, null);
            k.a aVar10 = new k.a();
            Iterator it13 = list.iterator();
            while (it13.hasNext()) {
                com.google.android.gms.internal.measurement.j4 j4Var = (com.google.android.gms.internal.measurement.j4) it13.next();
                com.google.android.gms.internal.measurement.j4 j4VarA = gbVar2.a(this.f5042d, j4Var);
                if (j4VarA != null) {
                    k kVarV5 = this.f5039b.V();
                    String str16 = this.f5042d;
                    String strK = j4VarA.K();
                    q qVarV = kVarV5.V(str16, j4Var.K());
                    if (qVarV == null) {
                        kVarV5.f5030a.d().w().c("Event aggregate wasn't created during raw event logging. appId, event", v3.z(str16), kVarV5.f5030a.D().d(strK));
                        it4 = it13;
                        qVar = new q(str16, j4Var.K(), 1L, 1L, 1L, j4Var.G(), 0L, null, null, null, null);
                    } else {
                        it4 = it13;
                        qVar = new q(qVarV.f5613a, qVarV.f5614b, qVarV.f5615c + 1, qVarV.f5616d + 1, qVarV.f5617e + 1, qVarV.f5618f, qVarV.f5619g, qVarV.f5620h, qVarV.f5621i, qVarV.f5622j, qVarV.f5623k);
                    }
                    this.f5039b.V().q(qVar);
                    long j11 = qVar.f5615c;
                    String strK2 = j4VarA.K();
                    Map map9 = (Map) aVar10.get(strK2);
                    if (map9 == null) {
                        k kVarV6 = this.f5039b.V();
                        String str17 = this.f5042d;
                        kVarV6.i();
                        kVarV6.h();
                        t1.f.d(str17);
                        t1.f.d(strK2);
                        gbVar = gbVar2;
                        k.a aVar11 = new k.a();
                        try {
                            try {
                                qVar2 = qVar;
                            } catch (SQLiteException e21) {
                                e = e21;
                                qVar2 = qVar;
                            }
                            try {
                                cursorQuery3 = kVarV6.P().query("event_filters", new String[]{str122222, str112222}, "app_id=? AND event_name=?", new String[]{str17, strK2}, null, null, null);
                            } catch (SQLiteException e22) {
                                e = e22;
                                j10 = j11;
                                cursorQuery3 = null;
                                kVarV6.f5030a.d().r().c("Database error querying filters. appId", v3.z(str17), e);
                                map9 = Collections.EMPTY_MAP;
                                if (cursorQuery3 != null) {
                                }
                                aVar10.put(strK2, map9);
                                while (r3.hasNext()) {
                                }
                                it13 = it4;
                                gbVar2 = gbVar;
                            }
                        } catch (Throwable th7) {
                            th = th7;
                            cursorQuery3 = null;
                        }
                        try {
                            try {
                            } catch (SQLiteException e23) {
                                e = e23;
                                j10 = j11;
                            }
                            if (cursorQuery3.moveToFirst()) {
                                j10 = j11;
                                do {
                                    try {
                                        try {
                                            com.google.android.gms.internal.measurement.z2 z2Var3 = (com.google.android.gms.internal.measurement.z2) ((com.google.android.gms.internal.measurement.y2) ra.E(com.google.android.gms.internal.measurement.z2.F(), cursorQuery3.getBlob(1))).o();
                                            Integer numValueOf4 = Integer.valueOf(cursorQuery3.getInt(0));
                                            List arrayList7 = (List) aVar11.get(numValueOf4);
                                            if (arrayList7 == null) {
                                                arrayList7 = new ArrayList();
                                                aVar11.put(numValueOf4, arrayList7);
                                            }
                                            arrayList7.add(z2Var3);
                                        } catch (IOException e24) {
                                            kVarV6.f5030a.d().r().c("Failed to merge filter. appId", v3.z(str17), e24);
                                        }
                                    } catch (SQLiteException e25) {
                                        e = e25;
                                        kVarV6.f5030a.d().r().c("Database error querying filters. appId", v3.z(str17), e);
                                        map9 = Collections.EMPTY_MAP;
                                        if (cursorQuery3 != null) {
                                            cursorQuery3.close();
                                        }
                                        aVar10.put(strK2, map9);
                                        while (r3.hasNext()) {
                                        }
                                        it13 = it4;
                                        gbVar2 = gbVar;
                                    }
                                } while (cursorQuery3.moveToNext());
                                cursorQuery3.close();
                                map9 = aVar11;
                                aVar10.put(strK2, map9);
                            } else {
                                j10 = j11;
                                map9 = Collections.EMPTY_MAP;
                                cursorQuery3.close();
                                aVar10.put(strK2, map9);
                            }
                        } catch (Throwable th8) {
                            th = th8;
                            if (cursorQuery3 != null) {
                                cursorQuery3.close();
                            }
                            throw th;
                        }
                    } else {
                        gbVar = gbVar2;
                        qVar2 = qVar;
                        j10 = j11;
                    }
                    for (Integer num3 : map9.keySet()) {
                        int iIntValue = num3.intValue();
                        if (this.f5043e.contains(num3)) {
                            this.f5030a.d().v().b("Skipping failed audience ID", num3);
                        } else {
                            Iterator it14 = ((List) map9.get(num3)).iterator();
                            boolean zK = true;
                            while (true) {
                                if (!it14.hasNext()) {
                                    map4 = map9;
                                    break;
                                }
                                com.google.android.gms.internal.measurement.z2 z2Var4 = (com.google.android.gms.internal.measurement.z2) it14.next();
                                hb hbVar = new hb(this, this.f5042d, iIntValue, z2Var4);
                                map4 = map9;
                                zK = hbVar.k(this.f5045g, this.f5046h, j4VarA, j10, qVar2, o(iIntValue, z2Var4.E()));
                                if (!zK) {
                                    this.f5043e.add(num3);
                                    break;
                                }
                                n(num3).c(hbVar);
                                map9 = map4;
                            }
                            if (!zK) {
                                this.f5043e.add(num3);
                            }
                            map9 = map4;
                        }
                    }
                    it13 = it4;
                    gbVar2 = gbVar;
                }
            }
        }
        if (!list2.isEmpty()) {
            k.a aVar12 = new k.a();
            Iterator it15 = list2.iterator();
            while (it15.hasNext()) {
                com.google.android.gms.internal.measurement.d5 d5Var = (com.google.android.gms.internal.measurement.d5) it15.next();
                String strI = d5Var.I();
                Map map10 = (Map) aVar12.get(strI);
                if (map10 == null) {
                    k kVarV7 = this.f5039b.V();
                    String str18 = this.f5042d;
                    kVarV7.i();
                    kVarV7.h();
                    t1.f.d(str18);
                    t1.f.d(strI);
                    k.a aVar13 = new k.a();
                    try {
                        cursorQuery2 = kVarV7.P().query("property_filters", new String[]{str122222, str112222}, "app_id=? AND property_name=?", new String[]{str18, strI}, null, null, null);
                        try {
                            try {
                            } catch (SQLiteException e26) {
                                e = e26;
                                it2 = it15;
                            }
                        } catch (Throwable th9) {
                            th = th9;
                            cursor3 = cursorQuery2;
                            if (cursor3 != null) {
                                cursor3.close();
                            }
                            throw th;
                        }
                    } catch (SQLiteException e27) {
                        e = e27;
                        it2 = it15;
                        str6 = str18;
                        cursorQuery2 = null;
                    } catch (Throwable th10) {
                        th = th10;
                        cursor3 = null;
                    }
                    if (cursorQuery2.moveToFirst()) {
                        while (true) {
                            try {
                                com.google.android.gms.internal.measurement.i3 i3Var = (com.google.android.gms.internal.measurement.i3) ((com.google.android.gms.internal.measurement.h3) ra.E(com.google.android.gms.internal.measurement.i3.F(), cursorQuery2.getBlob(1))).o();
                                Integer numValueOf5 = Integer.valueOf(cursorQuery2.getInt(0));
                                List list6 = (List) aVar13.get(numValueOf5);
                                if (list6 == null) {
                                    it2 = it15;
                                    try {
                                        arrayList = new ArrayList();
                                        aVar13.put(numValueOf5, arrayList);
                                    } catch (SQLiteException e28) {
                                        e = e28;
                                        str6 = str18;
                                        kVarV7.f5030a.d().r().c("Database error querying filters. appId", v3.z(str6), e);
                                        map10 = Collections.EMPTY_MAP;
                                        if (cursorQuery2 != null) {
                                        }
                                        aVar12.put(strI, map10);
                                        it3 = map10.keySet().iterator();
                                        while (true) {
                                            if (it3.hasNext()) {
                                            }
                                            map10 = map3;
                                            str132222 = str5;
                                        }
                                        it15 = it2;
                                    }
                                } else {
                                    it2 = it15;
                                    arrayList = list6;
                                }
                                arrayList.add(i3Var);
                                str6 = str18;
                            } catch (IOException e29) {
                                it2 = it15;
                                str6 = str18;
                                try {
                                    kVarV7.f5030a.d().r().c("Failed to merge filter", v3.z(str6), e29);
                                } catch (SQLiteException e30) {
                                    e = e30;
                                    kVarV7.f5030a.d().r().c("Database error querying filters. appId", v3.z(str6), e);
                                    map10 = Collections.EMPTY_MAP;
                                    if (cursorQuery2 != null) {
                                        cursorQuery2.close();
                                    }
                                    aVar12.put(strI, map10);
                                    it3 = map10.keySet().iterator();
                                    while (true) {
                                        if (it3.hasNext()) {
                                            break;
                                        }
                                        map10 = map3;
                                        str132222 = str5;
                                    }
                                    it15 = it2;
                                }
                            }
                            if (!cursorQuery2.moveToNext()) {
                                break;
                            }
                            it15 = it2;
                            str18 = str6;
                        }
                        cursorQuery2.close();
                        map10 = aVar13;
                        aVar12.put(strI, map10);
                    } else {
                        it2 = it15;
                        map10 = Collections.EMPTY_MAP;
                        cursorQuery2.close();
                        aVar12.put(strI, map10);
                    }
                } else {
                    it2 = it15;
                }
                it3 = map10.keySet().iterator();
                while (true) {
                    if (it3.hasNext()) {
                        Integer num4 = (Integer) it3.next();
                        int iIntValue2 = num4.intValue();
                        if (this.f5043e.contains(num4)) {
                            this.f5030a.d().v().b(str132222, num4);
                            break;
                        }
                        Iterator it16 = ((List) map10.get(num4)).iterator();
                        boolean zK2 = true;
                        while (true) {
                            if (!it16.hasNext()) {
                                map3 = map10;
                                str5 = str132222;
                                break;
                            }
                            com.google.android.gms.internal.measurement.i3 i3Var2 = (com.google.android.gms.internal.measurement.i3) it16.next();
                            if (Log.isLoggable(this.f5030a.d().D(), 2)) {
                                map3 = map10;
                                str5 = str132222;
                                this.f5030a.d().v().d("Evaluating filter. audience, filter, property", num4, i3Var2.M() ? Integer.valueOf(i3Var2.D()) : null, this.f5030a.D().f(i3Var2.H()));
                                this.f5030a.d().v().b("Filter definition", this.f5039b.g0().H(i3Var2));
                            } else {
                                map3 = map10;
                                str5 = str132222;
                            }
                            if (!i3Var2.M() || i3Var2.D() > 256) {
                                break;
                            }
                            jb jbVar = new jb(this, this.f5042d, iIntValue2, i3Var2);
                            zK2 = jbVar.k(this.f5045g, this.f5046h, d5Var, o(iIntValue2, i3Var2.D()));
                            if (!zK2) {
                                this.f5043e.add(num4);
                                break;
                            }
                            n(num4).c(jbVar);
                            map10 = map3;
                            str132222 = str5;
                        }
                        if (!zK2) {
                            this.f5043e.add(num4);
                        }
                        map10 = map3;
                        str132222 = str5;
                    }
                }
                it15 = it2;
            }
        }
        ArrayList arrayList32222 = new ArrayList();
        Set<Integer> setKeySet2222 = this.f5044f.keySet();
        setKeySet2222.removeAll(this.f5043e);
        for (Integer num5 : setKeySet2222) {
            int iIntValue3 = num5.intValue();
            eb ebVar = (eb) this.f5044f.get(num5);
            t1.f.h(ebVar);
            com.google.android.gms.internal.measurement.f4 f4VarA = ebVar.a(iIntValue3);
            arrayList32222.add(f4VarA);
            k kVarV8 = this.f5039b.V();
            String str19 = this.f5042d;
            com.google.android.gms.internal.measurement.z4 z4VarG = f4VarA.G();
            kVarV8.i();
            kVarV8.h();
            t1.f.d(str19);
            t1.f.h(z4VarG);
            byte[] bArrI = z4VarG.i();
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("app_id", str19);
            contentValues2.put(str122222, num5);
            contentValues2.put("current_results", bArrI);
            try {
                try {
                    if (kVarV8.P().insertWithOnConflict("audience_filter_values", null, contentValues2, 5) == -1) {
                        kVarV8.f5030a.d().r().b("Failed to insert filter results (got -1). appId", v3.z(str19));
                    }
                } catch (SQLiteException e31) {
                    e = e31;
                    kVarV8.f5030a.d().r().c("Error storing filter results. appId", v3.z(str19), e);
                }
            } catch (SQLiteException e32) {
                e = e32;
            }
        }
        return arrayList32222;
    }

    public final eb n(Integer num) {
        if (this.f5044f.containsKey(num)) {
            return (eb) this.f5044f.get(num);
        }
        eb ebVar = new eb(this, this.f5042d, null);
        this.f5044f.put(num, ebVar);
        return ebVar;
    }

    public final boolean o(int i10, int i11) {
        eb ebVar = (eb) this.f5044f.get(Integer.valueOf(i10));
        if (ebVar == null) {
            return false;
        }
        return ebVar.f5163d.get(i11);
    }
}
