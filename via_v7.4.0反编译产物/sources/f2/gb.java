package f2;

import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Pair;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class gb {

    /* renamed from: a, reason: collision with root package name */
    public com.google.android.gms.internal.measurement.j4 f5223a;

    /* renamed from: b, reason: collision with root package name */
    public Long f5224b;

    /* renamed from: c, reason: collision with root package name */
    public long f5225c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ b f5226d;

    /* JADX WARN: Not initialized variable reg: 12, insn: 0x00e4: MOVE (r5 I:??[OBJECT, ARRAY]) = (r12 I:??[OBJECT, ARRAY]), block:B:35:0x00e4 */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01da  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final com.google.android.gms.internal.measurement.j4 a(String str, com.google.android.gms.internal.measurement.j4 j4Var) {
        Cursor cursorRawQuery;
        Cursor cursor;
        Pair pairCreate;
        Object obj;
        String strK = j4Var.K();
        List listL = j4Var.L();
        this.f5226d.f5039b.g0();
        Long l10 = (Long) ra.p(j4Var, "_eid");
        if (l10 != null) {
            if (strK.equals("_ep")) {
                t1.f.h(l10);
                this.f5226d.f5039b.g0();
                String str2 = (String) ra.p(j4Var, "_en");
                Cursor cursor2 = null;
                if (TextUtils.isEmpty(str2)) {
                    this.f5226d.f5030a.d().t().b("Extra parameter without an event name. eventId", l10);
                    return null;
                }
                if (this.f5223a == null || this.f5224b == null || l10.longValue() != this.f5224b.longValue()) {
                    k kVarV = this.f5226d.f5039b.V();
                    kVarV.h();
                    kVarV.i();
                    try {
                        try {
                            cursorRawQuery = kVarV.P().rawQuery("select main_event, children_to_process from main_event_params where app_id=? and event_id=?", new String[]{str, l10.toString()});
                            try {
                            } catch (SQLiteException e10) {
                                e = e10;
                                kVarV.f5030a.d().r().b("Error selecting main event", e);
                                if (cursorRawQuery != null) {
                                    cursorRawQuery.close();
                                }
                                pairCreate = null;
                                if (pairCreate != null) {
                                }
                                this.f5226d.f5030a.d().t().c("Extra parameter without existing main event. eventName, eventId", str2, l10);
                                return null;
                            }
                        } catch (Throwable th) {
                            th = th;
                            cursor2 = cursor;
                            if (cursor2 != null) {
                                cursor2.close();
                            }
                            throw th;
                        }
                    } catch (SQLiteException e11) {
                        e = e11;
                        cursorRawQuery = null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (cursor2 != null) {
                        }
                        throw th;
                    }
                    if (cursorRawQuery.moveToFirst()) {
                        try {
                            pairCreate = Pair.create((com.google.android.gms.internal.measurement.j4) ((com.google.android.gms.internal.measurement.i4) ra.E(com.google.android.gms.internal.measurement.j4.H(), cursorRawQuery.getBlob(0))).o(), Long.valueOf(cursorRawQuery.getLong(1)));
                            cursorRawQuery.close();
                        } catch (IOException e12) {
                            kVarV.f5030a.d().r().d("Failed to merge main event. appId, eventId", v3.z(str), l10, e12);
                        }
                        if (pairCreate != null || (obj = pairCreate.first) == null) {
                            this.f5226d.f5030a.d().t().c("Extra parameter without existing main event. eventName, eventId", str2, l10);
                            return null;
                        }
                        this.f5223a = (com.google.android.gms.internal.measurement.j4) obj;
                        this.f5225c = ((Long) pairCreate.second).longValue();
                        this.f5226d.f5039b.g0();
                        this.f5224b = (Long) ra.p(this.f5223a, "_eid");
                    } else {
                        kVarV.f5030a.d().v().a("Main event not found");
                    }
                    cursorRawQuery.close();
                    pairCreate = null;
                    if (pairCreate != null) {
                    }
                    this.f5226d.f5030a.d().t().c("Extra parameter without existing main event. eventName, eventId", str2, l10);
                    return null;
                }
                long j10 = this.f5225c - 1;
                this.f5225c = j10;
                if (j10 <= 0) {
                    k kVarV2 = this.f5226d.f5039b.V();
                    kVarV2.h();
                    kVarV2.f5030a.d().v().b("Clearing complex main event info. appId", str);
                    try {
                        kVarV2.P().execSQL("delete from main_event_params where app_id=?", new String[]{str});
                    } catch (SQLiteException e13) {
                        kVarV2.f5030a.d().r().b("Error clearing complex main event", e13);
                    }
                } else {
                    this.f5226d.f5039b.V().v(str, l10, this.f5225c, this.f5223a);
                }
                ArrayList arrayList = new ArrayList();
                for (com.google.android.gms.internal.measurement.n4 n4Var : this.f5223a.L()) {
                    this.f5226d.f5039b.g0();
                    if (ra.o(j4Var, n4Var.J()) == null) {
                        arrayList.add(n4Var);
                    }
                }
                if (arrayList.isEmpty()) {
                    this.f5226d.f5030a.d().t().b("No unique parameters in main event. eventName", str2);
                } else {
                    arrayList.addAll(listL);
                    listL = arrayList;
                }
                strK = str2;
            } else {
                this.f5224b = l10;
                this.f5223a = j4Var;
                this.f5226d.f5039b.g0();
                Object objP = ra.p(j4Var, "_epc");
                long jLongValue = ((Long) (objP != null ? objP : 0L)).longValue();
                this.f5225c = jLongValue;
                if (jLongValue <= 0) {
                    this.f5226d.f5030a.d().t().b("Complex event with zero extra param count. eventName", strK);
                } else {
                    this.f5226d.f5039b.V().v(str, (Long) t1.f.h(l10), this.f5225c, j4Var);
                }
            }
        }
        com.google.android.gms.internal.measurement.i4 i4Var = (com.google.android.gms.internal.measurement.i4) j4Var.m();
        i4Var.A(strK);
        i4Var.y();
        i4Var.v(listL);
        return (com.google.android.gms.internal.measurement.j4) i4Var.o();
    }
}
