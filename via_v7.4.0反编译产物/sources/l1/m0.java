package l1;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.SystemClock;
import android.util.Base64;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import com.google.android.datatransport.runtime.synchronization.SynchronizationException;
import d1.i;
import g1.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import m1.a;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class m0 implements l1.d, m1.a, l1.c {

    /* renamed from: n, reason: collision with root package name */
    public static final a1.b f8350n = a1.b.b("proto");

    /* renamed from: e, reason: collision with root package name */
    public final t0 f8351e;

    /* renamed from: j, reason: collision with root package name */
    public final n1.a f8352j;

    /* renamed from: k, reason: collision with root package name */
    public final n1.a f8353k;

    /* renamed from: l, reason: collision with root package name */
    public final e f8354l;

    /* renamed from: m, reason: collision with root package name */
    public final i7.a f8355m;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface b {
        Object apply(Object obj);
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final String f8356a;

        /* renamed from: b, reason: collision with root package name */
        public final String f8357b;

        public c(String str, String str2) {
            this.f8356a = str;
            this.f8357b = str2;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface d {
        Object a();
    }

    public m0(n1.a aVar, n1.a aVar2, e eVar, t0 t0Var, i7.a aVar3) {
        this.f8351e = t0Var;
        this.f8352j = aVar;
        this.f8353k = aVar2;
        this.f8354l = eVar;
        this.f8355m = aVar3;
    }

    public static String A0(Iterable iterable) {
        StringBuilder sb2 = new StringBuilder("(");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            sb2.append(((k) it.next()).c());
            if (it.hasNext()) {
                sb2.append(',');
            }
        }
        sb2.append(')');
        return sb2.toString();
    }

    public static Object B0(Cursor cursor, b bVar) {
        try {
            return bVar.apply(cursor);
        } finally {
            cursor.close();
        }
    }

    public static /* synthetic */ Object J(Map map, Cursor cursor) {
        while (true) {
            if (!cursor.moveToNext()) {
                return null;
            }
            long j10 = cursor.getLong(0);
            Set hashSet = (Set) map.get(Long.valueOf(j10));
            if (hashSet == null) {
                hashSet = new HashSet();
                map.put(Long.valueOf(j10), hashSet);
            }
            hashSet.add(new c(cursor.getString(1), cursor.getString(2)));
        }
    }

    public static /* synthetic */ Integer W(final m0 m0Var, long j10, SQLiteDatabase sQLiteDatabase) {
        m0Var.getClass();
        String[] strArr = {String.valueOf(j10)};
        B0(sQLiteDatabase.rawQuery("SELECT COUNT(*), transport_name FROM events WHERE timestamp_ms < ? GROUP BY transport_name", strArr), new b() { // from class: l1.q
            @Override // l1.m0.b
            public final Object apply(Object obj) {
                return m0.l(this.f8367a, (Cursor) obj);
            }
        });
        return Integer.valueOf(sQLiteDatabase.delete("events", "timestamp_ms < ?", strArr));
    }

    public static /* synthetic */ Object b0(m0 m0Var, List list, d1.p pVar, Cursor cursor) {
        m0Var.getClass();
        while (cursor.moveToNext()) {
            long j10 = cursor.getLong(0);
            boolean z10 = cursor.getInt(7) != 0;
            i.a aVarK = d1.i.a().j(cursor.getString(1)).i(cursor.getLong(2)).k(cursor.getLong(3));
            if (z10) {
                aVarK.h(new d1.h(z0(cursor.getString(4)), cursor.getBlob(5)));
            } else {
                aVarK.h(new d1.h(z0(cursor.getString(4)), m0Var.x0(j10)));
            }
            if (!cursor.isNull(6)) {
                aVarK.g(Integer.valueOf(cursor.getInt(6)));
            }
            list.add(k.a(j10, pVar, aVarK.d()));
        }
        return null;
    }

    public static /* synthetic */ Object c0(m0 m0Var, SQLiteDatabase sQLiteDatabase) {
        m0Var.getClass();
        sQLiteDatabase.compileStatement("DELETE FROM log_event_dropped").execute();
        sQLiteDatabase.compileStatement("UPDATE global_log_event_state SET last_metrics_upload_ms=" + m0Var.f8352j.a()).execute();
        return null;
    }

    public static /* synthetic */ g1.a d0(final m0 m0Var, String str, final Map map, final a.C0071a c0071a, SQLiteDatabase sQLiteDatabase) {
        m0Var.getClass();
        return (g1.a) B0(sQLiteDatabase.rawQuery(str, new String[0]), new b() { // from class: l1.z
            @Override // l1.m0.b
            public final Object apply(Object obj) {
                return m0.r(this.f8390a, map, c0071a, (Cursor) obj);
            }
        });
    }

    public static /* synthetic */ Long e0(Cursor cursor) {
        if (cursor.moveToNext()) {
            return Long.valueOf(cursor.getLong(0));
        }
        return 0L;
    }

    public static /* synthetic */ g1.e f0(final long j10, SQLiteDatabase sQLiteDatabase) {
        return (g1.e) B0(sQLiteDatabase.rawQuery("SELECT last_metrics_upload_ms FROM global_log_event_state LIMIT 1", new String[0]), new b() { // from class: l1.d0
            @Override // l1.m0.b
            public final Object apply(Object obj) {
                return m0.g(j10, (Cursor) obj);
            }
        });
    }

    public static /* synthetic */ g1.e g(long j10, Cursor cursor) {
        cursor.moveToNext();
        return g1.e.c().c(cursor.getLong(0)).b(j10).a();
    }

    public static /* synthetic */ List h(m0 m0Var, d1.p pVar, SQLiteDatabase sQLiteDatabase) {
        List listT0 = m0Var.t0(sQLiteDatabase, pVar, m0Var.f8354l.d());
        for (Priority priority : Priority.values()) {
            if (priority != pVar.d()) {
                int iD = m0Var.f8354l.d() - listT0.size();
                if (iD <= 0) {
                    break;
                }
                listT0.addAll(m0Var.t0(sQLiteDatabase, pVar.f(priority), iD));
            }
        }
        return m0Var.s0(listT0, m0Var.u0(sQLiteDatabase, listT0));
    }

    public static /* synthetic */ List i(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            arrayList.add(d1.p.a().b(cursor.getString(1)).d(o1.a.b(cursor.getInt(2))).c(v0(cursor.getString(3))).a());
        }
        return arrayList;
    }

    public static /* synthetic */ Object j(m0 m0Var, Cursor cursor) {
        m0Var.getClass();
        while (cursor.moveToNext()) {
            m0Var.f(cursor.getInt(0), LogEventDropped.Reason.MAX_RETRIES_REACHED, cursor.getString(1));
        }
        return null;
    }

    public static /* synthetic */ SQLiteDatabase k(Throwable th) {
        throw new SynchronizationException("Timed out while trying to open db.", th);
    }

    public static /* synthetic */ Object l(m0 m0Var, Cursor cursor) {
        m0Var.getClass();
        while (cursor.moveToNext()) {
            m0Var.f(cursor.getInt(0), LogEventDropped.Reason.MESSAGE_TOO_OLD, cursor.getString(1));
        }
        return null;
    }

    public static /* synthetic */ Object m(final m0 m0Var, String str, String str2, SQLiteDatabase sQLiteDatabase) {
        m0Var.getClass();
        sQLiteDatabase.compileStatement(str).execute();
        B0(sQLiteDatabase.rawQuery(str2, null), new b() { // from class: l1.t
            @Override // l1.m0.b
            public final Object apply(Object obj) {
                return m0.j(this.f8372a, (Cursor) obj);
            }
        });
        sQLiteDatabase.compileStatement("DELETE FROM events WHERE num_attempts >= 16").execute();
        return null;
    }

    public static /* synthetic */ Boolean n(m0 m0Var, d1.p pVar, SQLiteDatabase sQLiteDatabase) {
        Long lP0 = m0Var.p0(sQLiteDatabase, pVar);
        return lP0 == null ? Boolean.FALSE : (Boolean) B0(m0Var.k0().rawQuery("SELECT 1 FROM events WHERE context_id = ? LIMIT 1", new String[]{lP0.toString()}), new b() { // from class: l1.s
            @Override // l1.m0.b
            public final Object apply(Object obj) {
                return Boolean.valueOf(((Cursor) obj).moveToNext());
            }
        });
    }

    public static /* synthetic */ Object o(long j10, d1.p pVar, SQLiteDatabase sQLiteDatabase) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("next_request_ms", Long.valueOf(j10));
        if (sQLiteDatabase.update("transport_contexts", contentValues, "backend_name = ? and priority = ?", new String[]{pVar.b(), String.valueOf(o1.a.a(pVar.d()))}) < 1) {
            contentValues.put("backend_name", pVar.b());
            contentValues.put("priority", Integer.valueOf(o1.a.a(pVar.d())));
            sQLiteDatabase.insert("transport_contexts", null, contentValues);
        }
        return null;
    }

    public static /* synthetic */ byte[] p(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        int length = 0;
        while (cursor.moveToNext()) {
            byte[] blob = cursor.getBlob(0);
            arrayList.add(blob);
            length += blob.length;
        }
        byte[] bArr = new byte[length];
        int length2 = 0;
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            byte[] bArr2 = (byte[]) arrayList.get(i10);
            System.arraycopy(bArr2, 0, bArr, length2, bArr2.length);
            length2 += bArr2.length;
        }
        return bArr;
    }

    public static /* synthetic */ List q(SQLiteDatabase sQLiteDatabase) {
        return (List) B0(sQLiteDatabase.rawQuery("SELECT distinct t._id, t.backend_name, t.priority, t.extras FROM transport_contexts AS t, events AS e WHERE e.context_id = t._id", new String[0]), new b() { // from class: l1.p
            @Override // l1.m0.b
            public final Object apply(Object obj) {
                return m0.i((Cursor) obj);
            }
        });
    }

    public static /* synthetic */ g1.a r(m0 m0Var, Map map, a.C0071a c0071a, Cursor cursor) {
        m0Var.getClass();
        while (cursor.moveToNext()) {
            String string = cursor.getString(0);
            LogEventDropped.Reason reasonG0 = m0Var.g0(cursor.getInt(1));
            long j10 = cursor.getLong(2);
            if (!map.containsKey(string)) {
                map.put(string, new ArrayList());
            }
            ((List) map.get(string)).add(LogEventDropped.c().c(reasonG0).b(j10).a());
        }
        m0Var.w0(c0071a, map);
        c0071a.e(m0Var.o0());
        c0071a.d(m0Var.l0());
        c0071a.c((String) m0Var.f8355m.get());
        return c0071a.b();
    }

    public static /* synthetic */ Long t(m0 m0Var, d1.i iVar, d1.p pVar, SQLiteDatabase sQLiteDatabase) {
        if (m0Var.r0()) {
            m0Var.f(1L, LogEventDropped.Reason.CACHE_FULL, iVar.j());
            return -1L;
        }
        long jI0 = m0Var.i0(sQLiteDatabase, pVar);
        int iE = m0Var.f8354l.e();
        byte[] bArrA = iVar.e().a();
        boolean z10 = bArrA.length <= iE;
        ContentValues contentValues = new ContentValues();
        contentValues.put("context_id", Long.valueOf(jI0));
        contentValues.put("transport_name", iVar.j());
        contentValues.put("timestamp_ms", Long.valueOf(iVar.f()));
        contentValues.put("uptime_ms", Long.valueOf(iVar.k()));
        contentValues.put("payload_encoding", iVar.e().b().a());
        contentValues.put("code", iVar.d());
        contentValues.put("num_attempts", (Integer) 0);
        contentValues.put("inline", Boolean.valueOf(z10));
        contentValues.put("payload", z10 ? bArrA : new byte[0]);
        long jInsert = sQLiteDatabase.insert("events", null, contentValues);
        if (!z10) {
            double length = bArrA.length;
            double d10 = iE;
            Double.isNaN(length);
            Double.isNaN(d10);
            int iCeil = (int) Math.ceil(length / d10);
            for (int i10 = 1; i10 <= iCeil; i10++) {
                byte[] bArrCopyOfRange = Arrays.copyOfRange(bArrA, (i10 - 1) * iE, Math.min(i10 * iE, bArrA.length));
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("event_id", Long.valueOf(jInsert));
                contentValues2.put("sequence_num", Integer.valueOf(i10));
                contentValues2.put("bytes", bArrCopyOfRange);
                sQLiteDatabase.insert("event_payloads", null, contentValues2);
            }
        }
        for (Map.Entry entry : iVar.i().entrySet()) {
            ContentValues contentValues3 = new ContentValues();
            contentValues3.put("event_id", Long.valueOf(jInsert));
            contentValues3.put("name", (String) entry.getKey());
            contentValues3.put("value", (String) entry.getValue());
            sQLiteDatabase.insert("event_metadata", null, contentValues3);
        }
        return Long.valueOf(jInsert);
    }

    public static /* synthetic */ Object u(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        return null;
    }

    public static /* synthetic */ Long v(Cursor cursor) {
        if (cursor.moveToNext()) {
            return Long.valueOf(cursor.getLong(0));
        }
        return null;
    }

    public static byte[] v0(String str) {
        if (str == null) {
            return null;
        }
        return Base64.decode(str, 0);
    }

    public static /* synthetic */ Object w(Throwable th) {
        throw new SynchronizationException("Timed out while trying to acquire the lock.", th);
    }

    public static /* synthetic */ Object x(String str, LogEventDropped.Reason reason, long j10, SQLiteDatabase sQLiteDatabase) throws SQLException {
        if (((Boolean) B0(sQLiteDatabase.rawQuery("SELECT 1 FROM log_event_dropped WHERE log_source = ? AND reason = ?", new String[]{str, Integer.toString(reason.getNumber())}), new b() { // from class: l1.v
            @Override // l1.m0.b
            public final Object apply(Object obj) {
                return Boolean.valueOf(((Cursor) obj).getCount() > 0);
            }
        })).booleanValue()) {
            sQLiteDatabase.execSQL("UPDATE log_event_dropped SET events_dropped_count = events_dropped_count + " + j10 + " WHERE log_source = ? AND reason = ?", new String[]{str, Integer.toString(reason.getNumber())});
            return null;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("log_source", str);
        contentValues.put("reason", Integer.valueOf(reason.getNumber()));
        contentValues.put("events_dropped_count", Long.valueOf(j10));
        sQLiteDatabase.insert("log_event_dropped", null, contentValues);
        return null;
    }

    public static a1.b z0(String str) {
        return str == null ? f8350n : a1.b.b(str);
    }

    @Override // l1.d
    public Iterable B(final d1.p pVar) {
        return (Iterable) q0(new b() { // from class: l1.k0
            @Override // l1.m0.b
            public final Object apply(Object obj) {
                return m0.h(this.f8343a, pVar, (SQLiteDatabase) obj);
            }
        });
    }

    @Override // l1.d
    public Iterable D() {
        return (Iterable) q0(new b() { // from class: l1.h0
            @Override // l1.m0.b
            public final Object apply(Object obj) {
                return m0.q((SQLiteDatabase) obj);
            }
        });
    }

    @Override // l1.d
    public boolean M(final d1.p pVar) {
        return ((Boolean) q0(new b() { // from class: l1.l0
            @Override // l1.m0.b
            public final Object apply(Object obj) {
                return m0.n(this.f8346a, pVar, (SQLiteDatabase) obj);
            }
        })).booleanValue();
    }

    @Override // l1.d
    public void Q(final d1.p pVar, final long j10) {
        q0(new b() { // from class: l1.m
            @Override // l1.m0.b
            public final Object apply(Object obj) {
                return m0.o(j10, pVar, (SQLiteDatabase) obj);
            }
        });
    }

    @Override // l1.d
    public k S(final d1.p pVar, final d1.i iVar) {
        h1.a.c("SQLiteEventStore", "Storing event with priority=%s, name=%s for destination %s", pVar.d(), iVar.j(), pVar.b());
        long jLongValue = ((Long) q0(new b() { // from class: l1.b0
            @Override // l1.m0.b
            public final Object apply(Object obj) {
                return m0.t(this.f8327a, iVar, pVar, (SQLiteDatabase) obj);
            }
        })).longValue();
        if (jLongValue < 1) {
            return null;
        }
        return k.a(jLongValue, pVar, iVar);
    }

    @Override // l1.d
    public long T(d1.p pVar) {
        return ((Long) B0(k0().rawQuery("SELECT next_request_ms FROM transport_contexts WHERE backend_name = ? and priority = ?", new String[]{pVar.b(), String.valueOf(o1.a.a(pVar.d()))}), new b() { // from class: l1.i0
            @Override // l1.m0.b
            public final Object apply(Object obj) {
                return m0.e0((Cursor) obj);
            }
        })).longValue();
    }

    @Override // l1.d
    public void V(Iterable iterable) {
        if (iterable.iterator().hasNext()) {
            final String str = "UPDATE events SET num_attempts = num_attempts + 1 WHERE _id in " + A0(iterable);
            final String str2 = "SELECT COUNT(*), transport_name FROM events WHERE num_attempts >= 16 GROUP BY transport_name";
            q0(new b() { // from class: l1.j0
                @Override // l1.m0.b
                public final Object apply(Object obj) {
                    return m0.m(this.f8340a, str, str2, (SQLiteDatabase) obj);
                }
            });
        }
    }

    @Override // m1.a
    public Object a(a.InterfaceC0097a interfaceC0097a) {
        SQLiteDatabase sQLiteDatabaseK0 = k0();
        h0(sQLiteDatabaseK0);
        try {
            Object objF = interfaceC0097a.f();
            sQLiteDatabaseK0.setTransactionSuccessful();
            return objF;
        } finally {
            sQLiteDatabaseK0.endTransaction();
        }
    }

    @Override // l1.c
    public void b() {
        q0(new b() { // from class: l1.n
            @Override // l1.m0.b
            public final Object apply(Object obj) {
                return m0.c0(this.f8358a, (SQLiteDatabase) obj);
            }
        });
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f8351e.close();
    }

    @Override // l1.c
    public g1.a d() {
        final a.C0071a c0071aE = g1.a.e();
        final HashMap map = new HashMap();
        final String str = "SELECT log_source, reason, events_dropped_count FROM log_event_dropped";
        return (g1.a) q0(new b() { // from class: l1.r
            @Override // l1.m0.b
            public final Object apply(Object obj) {
                return m0.d0(this.f8368a, str, map, c0071aE, (SQLiteDatabase) obj);
            }
        });
    }

    @Override // l1.c
    public void f(final long j10, final LogEventDropped.Reason reason, final String str) {
        q0(new b() { // from class: l1.o
            @Override // l1.m0.b
            public final Object apply(Object obj) {
                return m0.x(str, reason, j10, (SQLiteDatabase) obj);
            }
        });
    }

    public final LogEventDropped.Reason g0(int i10) {
        LogEventDropped.Reason reason = LogEventDropped.Reason.REASON_UNKNOWN;
        if (i10 == reason.getNumber()) {
            return reason;
        }
        LogEventDropped.Reason reason2 = LogEventDropped.Reason.MESSAGE_TOO_OLD;
        if (i10 == reason2.getNumber()) {
            return reason2;
        }
        LogEventDropped.Reason reason3 = LogEventDropped.Reason.CACHE_FULL;
        if (i10 == reason3.getNumber()) {
            return reason3;
        }
        LogEventDropped.Reason reason4 = LogEventDropped.Reason.PAYLOAD_TOO_BIG;
        if (i10 == reason4.getNumber()) {
            return reason4;
        }
        LogEventDropped.Reason reason5 = LogEventDropped.Reason.MAX_RETRIES_REACHED;
        if (i10 == reason5.getNumber()) {
            return reason5;
        }
        LogEventDropped.Reason reason6 = LogEventDropped.Reason.INVALID_PAYLOD;
        if (i10 == reason6.getNumber()) {
            return reason6;
        }
        LogEventDropped.Reason reason7 = LogEventDropped.Reason.SERVER_ERROR;
        if (i10 == reason7.getNumber()) {
            return reason7;
        }
        h1.a.b("SQLiteEventStore", "%n is not valid. No matched LogEventDropped-Reason found. Treated it as REASON_UNKNOWN", Integer.valueOf(i10));
        return reason;
    }

    public final void h0(final SQLiteDatabase sQLiteDatabase) {
        y0(new d() { // from class: l1.l
            @Override // l1.m0.d
            public final Object a() {
                return m0.u(sQLiteDatabase);
            }
        }, new b() { // from class: l1.w
            @Override // l1.m0.b
            public final Object apply(Object obj) {
                return m0.w((Throwable) obj);
            }
        });
    }

    public final long i0(SQLiteDatabase sQLiteDatabase, d1.p pVar) {
        Long lP0 = p0(sQLiteDatabase, pVar);
        if (lP0 != null) {
            return lP0.longValue();
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("backend_name", pVar.b());
        contentValues.put("priority", Integer.valueOf(o1.a.a(pVar.d())));
        contentValues.put("next_request_ms", (Integer) 0);
        if (pVar.c() != null) {
            contentValues.put("extras", Base64.encodeToString(pVar.c(), 0));
        }
        return sQLiteDatabase.insert("transport_contexts", null, contentValues);
    }

    public long j0() {
        return m0() * n0();
    }

    public SQLiteDatabase k0() {
        final t0 t0Var = this.f8351e;
        Objects.requireNonNull(t0Var);
        return (SQLiteDatabase) y0(new d() { // from class: l1.e0
            @Override // l1.m0.d
            public final Object a() {
                return t0Var.getWritableDatabase();
            }
        }, new b() { // from class: l1.f0
            @Override // l1.m0.b
            public final Object apply(Object obj) {
                return m0.k((Throwable) obj);
            }
        });
    }

    public final g1.b l0() {
        return g1.b.b().b(g1.d.c().b(j0()).c(e.f8332a.f()).a()).a();
    }

    public final long m0() {
        return k0().compileStatement("PRAGMA page_count").simpleQueryForLong();
    }

    public final long n0() {
        return k0().compileStatement("PRAGMA page_size").simpleQueryForLong();
    }

    public final g1.e o0() {
        final long jA = this.f8352j.a();
        return (g1.e) q0(new b() { // from class: l1.c0
            @Override // l1.m0.b
            public final Object apply(Object obj) {
                return m0.f0(jA, (SQLiteDatabase) obj);
            }
        });
    }

    public final Long p0(SQLiteDatabase sQLiteDatabase, d1.p pVar) {
        StringBuilder sb2 = new StringBuilder("backend_name = ? and priority = ?");
        ArrayList arrayList = new ArrayList(Arrays.asList(pVar.b(), String.valueOf(o1.a.a(pVar.d()))));
        if (pVar.c() != null) {
            sb2.append(" and extras = ?");
            arrayList.add(Base64.encodeToString(pVar.c(), 0));
        } else {
            sb2.append(" and extras is null");
        }
        return (Long) B0(sQLiteDatabase.query("transport_contexts", new String[]{"_id"}, sb2.toString(), (String[]) arrayList.toArray(new String[0]), null, null, null), new b() { // from class: l1.y
            @Override // l1.m0.b
            public final Object apply(Object obj) {
                return m0.v((Cursor) obj);
            }
        });
    }

    public Object q0(b bVar) {
        SQLiteDatabase sQLiteDatabaseK0 = k0();
        sQLiteDatabaseK0.beginTransaction();
        try {
            Object objApply = bVar.apply(sQLiteDatabaseK0);
            sQLiteDatabaseK0.setTransactionSuccessful();
            return objApply;
        } finally {
            sQLiteDatabaseK0.endTransaction();
        }
    }

    public final boolean r0() {
        return m0() * n0() >= this.f8354l.f();
    }

    public final List s0(List list, Map map) {
        ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            k kVar = (k) listIterator.next();
            if (map.containsKey(Long.valueOf(kVar.c()))) {
                i.a aVarL = kVar.b().l();
                for (c cVar : (Set) map.get(Long.valueOf(kVar.c()))) {
                    aVarL.c(cVar.f8356a, cVar.f8357b);
                }
                listIterator.set(k.a(kVar.c(), kVar.d(), aVarL.d()));
            }
        }
        return list;
    }

    public final List t0(SQLiteDatabase sQLiteDatabase, final d1.p pVar, int i10) {
        final ArrayList arrayList = new ArrayList();
        Long lP0 = p0(sQLiteDatabase, pVar);
        if (lP0 == null) {
            return arrayList;
        }
        B0(sQLiteDatabase.query("events", new String[]{"_id", "transport_name", "timestamp_ms", "uptime_ms", "payload_encoding", "payload", "code", "inline"}, "context_id = ?", new String[]{lP0.toString()}, null, null, null, String.valueOf(i10)), new b() { // from class: l1.u
            @Override // l1.m0.b
            public final Object apply(Object obj) {
                return m0.b0(this.f8383a, arrayList, pVar, (Cursor) obj);
            }
        });
        return arrayList;
    }

    public final Map u0(SQLiteDatabase sQLiteDatabase, List list) {
        final HashMap map = new HashMap();
        StringBuilder sb2 = new StringBuilder("event_id IN (");
        for (int i10 = 0; i10 < list.size(); i10++) {
            sb2.append(((k) list.get(i10)).c());
            if (i10 < list.size() - 1) {
                sb2.append(',');
            }
        }
        sb2.append(')');
        B0(sQLiteDatabase.query("event_metadata", new String[]{"event_id", "name", "value"}, sb2.toString(), null, null, null, null), new b() { // from class: l1.x
            @Override // l1.m0.b
            public final Object apply(Object obj) {
                return m0.J(map, (Cursor) obj);
            }
        });
        return map;
    }

    public final void w0(a.C0071a c0071a, Map map) {
        for (Map.Entry entry : map.entrySet()) {
            c0071a.a(g1.c.c().c((String) entry.getKey()).b((List) entry.getValue()).a());
        }
    }

    public final byte[] x0(long j10) {
        return (byte[]) B0(k0().query("event_payloads", new String[]{"bytes"}, "event_id = ?", new String[]{String.valueOf(j10)}, null, null, "sequence_num"), new b() { // from class: l1.a0
            @Override // l1.m0.b
            public final Object apply(Object obj) {
                return m0.p((Cursor) obj);
            }
        });
    }

    @Override // l1.d
    public int y() {
        final long jA = this.f8352j.a() - this.f8354l.c();
        return ((Integer) q0(new b() { // from class: l1.g0
            @Override // l1.m0.b
            public final Object apply(Object obj) {
                return m0.W(this.f8335a, jA, (SQLiteDatabase) obj);
            }
        })).intValue();
    }

    public final Object y0(d dVar, b bVar) {
        long jA = this.f8353k.a();
        while (true) {
            try {
                return dVar.a();
            } catch (SQLiteDatabaseLockedException e10) {
                if (this.f8353k.a() >= this.f8354l.b() + jA) {
                    return bVar.apply(e10);
                }
                SystemClock.sleep(50L);
            }
        }
    }

    @Override // l1.d
    public void z(Iterable iterable) {
        if (iterable.iterator().hasNext()) {
            k0().compileStatement("DELETE FROM events WHERE _id in " + A0(iterable)).execute();
        }
    }
}
