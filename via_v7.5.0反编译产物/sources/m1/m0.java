package m1;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.SystemClock;
import android.util.Base64;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import com.google.android.datatransport.runtime.synchronization.SynchronizationException;
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

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class m0 implements m1.d, n1.a, m1.c {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final b1.b f7824p = b1.b.b("proto");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final t0 f7825c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final o1.a f7826e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final o1.a f7827m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final e f7828n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final c7.a f7829o;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface b {
        Object apply(Object obj);
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f7830a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f7831b;

        public c(String str, String str2) {
            this.f7830a = str;
            this.f7831b = str2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface d {
        Object a();
    }

    public m0(o1.a aVar, o1.a aVar2, e eVar, t0 t0Var, c7.a aVar3) {
        this.f7825c = t0Var;
        this.f7826e = aVar;
        this.f7827m = aVar2;
        this.f7828n = eVar;
        this.f7829o = aVar3;
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
        B0(sQLiteDatabase.rawQuery("SELECT COUNT(*), transport_name FROM events WHERE timestamp_ms < ? GROUP BY transport_name", strArr), new b() { // from class: m1.q
            @Override // m1.m0.b
            public final Object apply(Object obj) {
                return m0.l(this.f7841a, (Cursor) obj);
            }
        });
        return Integer.valueOf(sQLiteDatabase.delete("events", "timestamp_ms < ?", strArr));
    }

    public static /* synthetic */ Object b0(m0 m0Var, List list, e1.p pVar, Cursor cursor) {
        m0Var.getClass();
        while (cursor.moveToNext()) {
            long j10 = cursor.getLong(0);
            boolean z10 = cursor.getInt(7) != 0;
            e1.i.a aVarK = e1.i.a().j(cursor.getString(1)).i(cursor.getLong(2)).k(cursor.getLong(3));
            if (z10) {
                aVarK.h(new e1.h(z0(cursor.getString(4)), cursor.getBlob(5)));
            } else {
                aVarK.h(new e1.h(z0(cursor.getString(4)), m0Var.x0(j10)));
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
        sQLiteDatabase.compileStatement("UPDATE global_log_event_state SET last_metrics_upload_ms=" + m0Var.f7826e.a()).execute();
        return null;
    }

    public static /* synthetic */ h1.a d0(final m0 m0Var, String str, final Map map, final h1.a.C0072a c0072a, SQLiteDatabase sQLiteDatabase) {
        m0Var.getClass();
        return (h1.a) B0(sQLiteDatabase.rawQuery(str, new String[0]), new b() { // from class: m1.z
            @Override // m1.m0.b
            public final Object apply(Object obj) {
                return m0.r(this.f7864a, map, c0072a, (Cursor) obj);
            }
        });
    }

    public static /* synthetic */ Long e0(Cursor cursor) {
        if (cursor.moveToNext()) {
            return Long.valueOf(cursor.getLong(0));
        }
        return 0L;
    }

    public static /* synthetic */ h1.e f(long j10, Cursor cursor) {
        cursor.moveToNext();
        return h1.e.c().c(cursor.getLong(0)).b(j10).a();
    }

    public static /* synthetic */ h1.e f0(final long j10, SQLiteDatabase sQLiteDatabase) {
        return (h1.e) B0(sQLiteDatabase.rawQuery("SELECT last_metrics_upload_ms FROM global_log_event_state LIMIT 1", new String[0]), new b() { // from class: m1.d0
            @Override // m1.m0.b
            public final Object apply(Object obj) {
                return m0.f(j10, (Cursor) obj);
            }
        });
    }

    public static /* synthetic */ List g(m0 m0Var, e1.p pVar, SQLiteDatabase sQLiteDatabase) {
        List listT0 = m0Var.t0(sQLiteDatabase, pVar, m0Var.f7828n.d());
        for (Priority priority : Priority.values()) {
            if (priority != pVar.d()) {
                int iD = m0Var.f7828n.d() - listT0.size();
                if (iD <= 0) {
                    break;
                }
                listT0.addAll(m0Var.t0(sQLiteDatabase, pVar.f(priority), iD));
            }
        }
        return m0Var.s0(listT0, m0Var.u0(sQLiteDatabase, listT0));
    }

    public static /* synthetic */ List h(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            arrayList.add(e1.p.a().b(cursor.getString(1)).d(p1.a.b(cursor.getInt(2))).c(v0(cursor.getString(3))).a());
        }
        return arrayList;
    }

    public static /* synthetic */ Object j(m0 m0Var, Cursor cursor) {
        m0Var.getClass();
        while (cursor.moveToNext()) {
            m0Var.e(cursor.getInt(0), LogEventDropped.Reason.MAX_RETRIES_REACHED, cursor.getString(1));
        }
        return null;
    }

    public static /* synthetic */ SQLiteDatabase k(Throwable th) {
        throw new SynchronizationException("Timed out while trying to open db.", th);
    }

    public static /* synthetic */ Object l(m0 m0Var, Cursor cursor) {
        m0Var.getClass();
        while (cursor.moveToNext()) {
            m0Var.e(cursor.getInt(0), LogEventDropped.Reason.MESSAGE_TOO_OLD, cursor.getString(1));
        }
        return null;
    }

    public static /* synthetic */ Object m(final m0 m0Var, String str, String str2, SQLiteDatabase sQLiteDatabase) {
        m0Var.getClass();
        sQLiteDatabase.compileStatement(str).execute();
        B0(sQLiteDatabase.rawQuery(str2, null), new b() { // from class: m1.t
            @Override // m1.m0.b
            public final Object apply(Object obj) {
                return m0.j(this.f7846a, (Cursor) obj);
            }
        });
        sQLiteDatabase.compileStatement("DELETE FROM events WHERE num_attempts >= 16").execute();
        return null;
    }

    public static /* synthetic */ Boolean n(m0 m0Var, e1.p pVar, SQLiteDatabase sQLiteDatabase) {
        Long lP0 = m0Var.p0(sQLiteDatabase, pVar);
        return lP0 == null ? Boolean.FALSE : (Boolean) B0(m0Var.k0().rawQuery("SELECT 1 FROM events WHERE context_id = ? LIMIT 1", new String[]{lP0.toString()}), new b() { // from class: m1.s
            @Override // m1.m0.b
            public final Object apply(Object obj) {
                return Boolean.valueOf(((Cursor) obj).moveToNext());
            }
        });
    }

    public static /* synthetic */ Object o(long j10, e1.p pVar, SQLiteDatabase sQLiteDatabase) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("next_request_ms", Long.valueOf(j10));
        if (sQLiteDatabase.update("transport_contexts", contentValues, "backend_name = ? and priority = ?", new String[]{pVar.b(), String.valueOf(p1.a.a(pVar.d()))}) < 1) {
            contentValues.put("backend_name", pVar.b());
            contentValues.put("priority", Integer.valueOf(p1.a.a(pVar.d())));
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
        return (List) B0(sQLiteDatabase.rawQuery("SELECT distinct t._id, t.backend_name, t.priority, t.extras FROM transport_contexts AS t, events AS e WHERE e.context_id = t._id", new String[0]), new b() { // from class: m1.p
            @Override // m1.m0.b
            public final Object apply(Object obj) {
                return m0.h((Cursor) obj);
            }
        });
    }

    public static /* synthetic */ h1.a r(m0 m0Var, Map map, h1.a.C0072a c0072a, Cursor cursor) {
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
        m0Var.w0(c0072a, map);
        c0072a.e(m0Var.o0());
        c0072a.d(m0Var.l0());
        c0072a.c((String) m0Var.f7829o.get());
        return c0072a.b();
    }

    public static /* synthetic */ Long t(m0 m0Var, e1.i iVar, e1.p pVar, SQLiteDatabase sQLiteDatabase) {
        if (m0Var.r0()) {
            m0Var.e(1L, LogEventDropped.Reason.CACHE_FULL, iVar.j());
            return -1L;
        }
        long jI0 = m0Var.i0(sQLiteDatabase, pVar);
        int iE = m0Var.f7828n.e();
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

    public static /* synthetic */ Object x(String str, LogEventDropped.Reason reason, long j10, SQLiteDatabase sQLiteDatabase) {
        if (((Boolean) B0(sQLiteDatabase.rawQuery("SELECT 1 FROM log_event_dropped WHERE log_source = ? AND reason = ?", new String[]{str, Integer.toString(reason.getNumber())}), new b() { // from class: m1.v
            @Override // m1.m0.b
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

    public static b1.b z0(String str) {
        return str == null ? f7824p : b1.b.b(str);
    }

    @Override // m1.d
    public void A(Iterable iterable) {
        if (iterable.iterator().hasNext()) {
            k0().compileStatement("DELETE FROM events WHERE _id in " + A0(iterable)).execute();
        }
    }

    @Override // m1.d
    public void D(final e1.p pVar, final long j10) {
        q0(new b() { // from class: m1.m
            @Override // m1.m0.b
            public final Object apply(Object obj) {
                return m0.o(j10, pVar, (SQLiteDatabase) obj);
            }
        });
    }

    @Override // m1.d
    public Iterable E() {
        return (Iterable) q0(new b() { // from class: m1.h0
            @Override // m1.m0.b
            public final Object apply(Object obj) {
                return m0.q((SQLiteDatabase) obj);
            }
        });
    }

    @Override // m1.d
    public Iterable G(final e1.p pVar) {
        return (Iterable) q0(new b() { // from class: m1.k0
            @Override // m1.m0.b
            public final Object apply(Object obj) {
                return m0.g(this.f7817a, pVar, (SQLiteDatabase) obj);
            }
        });
    }

    @Override // m1.d
    public boolean P(final e1.p pVar) {
        return ((Boolean) q0(new b() { // from class: m1.l0
            @Override // m1.m0.b
            public final Object apply(Object obj) {
                return m0.n(this.f7820a, pVar, (SQLiteDatabase) obj);
            }
        })).booleanValue();
    }

    @Override // m1.d
    public k Q(final e1.p pVar, final e1.i iVar) {
        i1.a.c("SQLiteEventStore", "Storing event with priority=%s, name=%s for destination %s", pVar.d(), iVar.j(), pVar.b());
        long jLongValue = ((Long) q0(new b() { // from class: m1.b0
            @Override // m1.m0.b
            public final Object apply(Object obj) {
                return m0.t(this.f7801a, iVar, pVar, (SQLiteDatabase) obj);
            }
        })).longValue();
        if (jLongValue < 1) {
            return null;
        }
        return k.a(jLongValue, pVar, iVar);
    }

    @Override // m1.d
    public void V(Iterable iterable) {
        if (iterable.iterator().hasNext()) {
            final String str = "UPDATE events SET num_attempts = num_attempts + 1 WHERE _id in " + A0(iterable);
            final String str2 = "SELECT COUNT(*), transport_name FROM events WHERE num_attempts >= 16 GROUP BY transport_name";
            q0(new b() { // from class: m1.j0
                @Override // m1.m0.b
                public final Object apply(Object obj) {
                    return m0.m(this.f7814a, str, str2, (SQLiteDatabase) obj);
                }
            });
        }
    }

    @Override // n1.a
    public Object a(n1.a.InterfaceC0101a interfaceC0101a) {
        SQLiteDatabase sQLiteDatabaseK0 = k0();
        h0(sQLiteDatabaseK0);
        try {
            Object objC = interfaceC0101a.c();
            sQLiteDatabaseK0.setTransactionSuccessful();
            return objC;
        } finally {
            sQLiteDatabaseK0.endTransaction();
        }
    }

    @Override // m1.c
    public void b() {
        q0(new b() { // from class: m1.n
            @Override // m1.m0.b
            public final Object apply(Object obj) {
                return m0.c0(this.f7832a, (SQLiteDatabase) obj);
            }
        });
    }

    @Override // m1.c
    public h1.a c() {
        final h1.a.C0072a c0072aE = h1.a.e();
        final HashMap map = new HashMap();
        final String str = "SELECT log_source, reason, events_dropped_count FROM log_event_dropped";
        return (h1.a) q0(new b() { // from class: m1.r
            @Override // m1.m0.b
            public final Object apply(Object obj) {
                return m0.d0(this.f7842a, str, map, c0072aE, (SQLiteDatabase) obj);
            }
        });
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f7825c.close();
    }

    @Override // m1.c
    public void e(final long j10, final LogEventDropped.Reason reason, final String str) {
        q0(new b() { // from class: m1.o
            @Override // m1.m0.b
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
        i1.a.b("SQLiteEventStore", "%n is not valid. No matched LogEventDropped-Reason found. Treated it as REASON_UNKNOWN", Integer.valueOf(i10));
        return reason;
    }

    public final void h0(final SQLiteDatabase sQLiteDatabase) {
        y0(new d() { // from class: m1.l
            @Override // m1.m0.d
            public final Object a() {
                return m0.u(sQLiteDatabase);
            }
        }, new b() { // from class: m1.w
            @Override // m1.m0.b
            public final Object apply(Object obj) {
                return m0.w((Throwable) obj);
            }
        });
    }

    public final long i0(SQLiteDatabase sQLiteDatabase, e1.p pVar) {
        Long lP0 = p0(sQLiteDatabase, pVar);
        if (lP0 != null) {
            return lP0.longValue();
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("backend_name", pVar.b());
        contentValues.put("priority", Integer.valueOf(p1.a.a(pVar.d())));
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
        final t0 t0Var = this.f7825c;
        Objects.requireNonNull(t0Var);
        return (SQLiteDatabase) y0(new d() { // from class: m1.e0
            @Override // m1.m0.d
            public final Object a() {
                return t0Var.getWritableDatabase();
            }
        }, new b() { // from class: m1.f0
            @Override // m1.m0.b
            public final Object apply(Object obj) {
                return m0.k((Throwable) obj);
            }
        });
    }

    public final h1.b l0() {
        return h1.b.b().b(h1.d.c().b(j0()).c(e.f7806a.f()).a()).a();
    }

    public final long m0() {
        return k0().compileStatement("PRAGMA page_count").simpleQueryForLong();
    }

    public final long n0() {
        return k0().compileStatement("PRAGMA page_size").simpleQueryForLong();
    }

    public final h1.e o0() {
        final long jA = this.f7826e.a();
        return (h1.e) q0(new b() { // from class: m1.c0
            @Override // m1.m0.b
            public final Object apply(Object obj) {
                return m0.f0(jA, (SQLiteDatabase) obj);
            }
        });
    }

    public final Long p0(SQLiteDatabase sQLiteDatabase, e1.p pVar) {
        StringBuilder sb2 = new StringBuilder("backend_name = ? and priority = ?");
        ArrayList arrayList = new ArrayList(Arrays.asList(pVar.b(), String.valueOf(p1.a.a(pVar.d()))));
        if (pVar.c() != null) {
            sb2.append(" and extras = ?");
            arrayList.add(Base64.encodeToString(pVar.c(), 0));
        } else {
            sb2.append(" and extras is null");
        }
        return (Long) B0(sQLiteDatabase.query("transport_contexts", new String[]{"_id"}, sb2.toString(), (String[]) arrayList.toArray(new String[0]), null, null, null), new b() { // from class: m1.y
            @Override // m1.m0.b
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
        return m0() * n0() >= this.f7828n.f();
    }

    public final List s0(List list, Map map) {
        ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            k kVar = (k) listIterator.next();
            if (map.containsKey(Long.valueOf(kVar.c()))) {
                e1.i.a aVarL = kVar.b().l();
                for (c cVar : (Set) map.get(Long.valueOf(kVar.c()))) {
                    aVarL.c(cVar.f7830a, cVar.f7831b);
                }
                listIterator.set(k.a(kVar.c(), kVar.d(), aVarL.d()));
            }
        }
        return list;
    }

    public final List t0(SQLiteDatabase sQLiteDatabase, final e1.p pVar, int i10) {
        final ArrayList arrayList = new ArrayList();
        Long lP0 = p0(sQLiteDatabase, pVar);
        if (lP0 == null) {
            return arrayList;
        }
        B0(sQLiteDatabase.query("events", new String[]{"_id", "transport_name", "timestamp_ms", "uptime_ms", "payload_encoding", "payload", "code", "inline"}, "context_id = ?", new String[]{lP0.toString()}, null, null, null, String.valueOf(i10)), new b() { // from class: m1.u
            @Override // m1.m0.b
            public final Object apply(Object obj) {
                return m0.b0(this.f7857a, arrayList, pVar, (Cursor) obj);
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
        B0(sQLiteDatabase.query("event_metadata", new String[]{"event_id", "name", "value"}, sb2.toString(), null, null, null, null), new b() { // from class: m1.x
            @Override // m1.m0.b
            public final Object apply(Object obj) {
                return m0.J(map, (Cursor) obj);
            }
        });
        return map;
    }

    public final void w0(h1.a.C0072a c0072a, Map map) {
        for (Map.Entry entry : map.entrySet()) {
            c0072a.a(h1.c.c().c((String) entry.getKey()).b((List) entry.getValue()).a());
        }
    }

    public final byte[] x0(long j10) {
        return (byte[]) B0(k0().query("event_payloads", new String[]{"bytes"}, "event_id = ?", new String[]{String.valueOf(j10)}, null, null, "sequence_num"), new b() { // from class: m1.a0
            @Override // m1.m0.b
            public final Object apply(Object obj) {
                return m0.p((Cursor) obj);
            }
        });
    }

    @Override // m1.d
    public int y() {
        final long jA = this.f7826e.a() - this.f7828n.c();
        return ((Integer) q0(new b() { // from class: m1.g0
            @Override // m1.m0.b
            public final Object apply(Object obj) {
                return m0.W(this.f7809a, jA, (SQLiteDatabase) obj);
            }
        })).intValue();
    }

    public final Object y0(d dVar, b bVar) {
        long jA = this.f7827m.a();
        while (true) {
            try {
                return dVar.a();
            } catch (SQLiteDatabaseLockedException e10) {
                if (this.f7827m.a() >= ((long) this.f7828n.b()) + jA) {
                    return bVar.apply(e10);
                }
                SystemClock.sleep(50L);
            }
        }
    }

    @Override // m1.d
    public long z(e1.p pVar) {
        return ((Long) B0(k0().rawQuery("SELECT next_request_ms FROM transport_contexts WHERE backend_name = ? and priority = ?", new String[]{pVar.b(), String.valueOf(p1.a.a(pVar.d()))}), new b() { // from class: m1.i0
            @Override // m1.m0.b
            public final Object apply(Object obj) {
                return m0.e0((Cursor) obj);
            }
        })).longValue();
    }
}
