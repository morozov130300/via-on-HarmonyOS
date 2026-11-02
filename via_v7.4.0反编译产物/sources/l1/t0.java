package l1;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.Arrays;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class t0 extends SQLiteOpenHelper {

    /* renamed from: k, reason: collision with root package name */
    public static final String f8373k = "INSERT INTO global_log_event_state VALUES (" + System.currentTimeMillis() + ")";

    /* renamed from: l, reason: collision with root package name */
    public static int f8374l = 5;

    /* renamed from: m, reason: collision with root package name */
    public static final a f8375m;

    /* renamed from: n, reason: collision with root package name */
    public static final a f8376n;

    /* renamed from: o, reason: collision with root package name */
    public static final a f8377o;

    /* renamed from: p, reason: collision with root package name */
    public static final a f8378p;

    /* renamed from: q, reason: collision with root package name */
    public static final a f8379q;

    /* renamed from: r, reason: collision with root package name */
    public static final List f8380r;

    /* renamed from: e, reason: collision with root package name */
    public final int f8381e;

    /* renamed from: j, reason: collision with root package name */
    public boolean f8382j;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface a {
        void a(SQLiteDatabase sQLiteDatabase);
    }

    static {
        a aVar = new a() { // from class: l1.o0
            @Override // l1.t0.a
            public final void a(SQLiteDatabase sQLiteDatabase) throws SQLException {
                t0.a(sQLiteDatabase);
            }
        };
        f8375m = aVar;
        a aVar2 = new a() { // from class: l1.p0
            @Override // l1.t0.a
            public final void a(SQLiteDatabase sQLiteDatabase) throws SQLException {
                t0.f(sQLiteDatabase);
            }
        };
        f8376n = aVar2;
        a aVar3 = new a() { // from class: l1.q0
            @Override // l1.t0.a
            public final void a(SQLiteDatabase sQLiteDatabase) throws SQLException {
                sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN payload_encoding TEXT");
            }
        };
        f8377o = aVar3;
        a aVar4 = new a() { // from class: l1.r0
            @Override // l1.t0.a
            public final void a(SQLiteDatabase sQLiteDatabase) throws SQLException {
                t0.g(sQLiteDatabase);
            }
        };
        f8378p = aVar4;
        a aVar5 = new a() { // from class: l1.s0
            @Override // l1.t0.a
            public final void a(SQLiteDatabase sQLiteDatabase) throws SQLException {
                t0.d(sQLiteDatabase);
            }
        };
        f8379q = aVar5;
        f8380r = Arrays.asList(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public t0(Context context, String str, int i10) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i10);
        this.f8382j = false;
        this.f8381e = i10;
    }

    public static /* synthetic */ void a(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("CREATE TABLE events (_id INTEGER PRIMARY KEY, context_id INTEGER NOT NULL, transport_name TEXT NOT NULL, timestamp_ms INTEGER NOT NULL, uptime_ms INTEGER NOT NULL, payload BLOB NOT NULL, code INTEGER, num_attempts INTEGER NOT NULL,FOREIGN KEY (context_id) REFERENCES transport_contexts(_id) ON DELETE CASCADE)");
        sQLiteDatabase.execSQL("CREATE TABLE event_metadata (_id INTEGER PRIMARY KEY, event_id INTEGER NOT NULL, name TEXT NOT NULL, value TEXT NOT NULL,FOREIGN KEY (event_id) REFERENCES events(_id) ON DELETE CASCADE)");
        sQLiteDatabase.execSQL("CREATE TABLE transport_contexts (_id INTEGER PRIMARY KEY, backend_name TEXT NOT NULL, priority INTEGER NOT NULL, next_request_ms INTEGER NOT NULL)");
        sQLiteDatabase.execSQL("CREATE INDEX events_backend_id on events(context_id)");
        sQLiteDatabase.execSQL("CREATE UNIQUE INDEX contexts_backend_priority on transport_contexts(backend_name, priority)");
    }

    public static /* synthetic */ void d(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS log_event_dropped");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS global_log_event_state");
        sQLiteDatabase.execSQL("CREATE TABLE log_event_dropped (log_source VARCHAR(45) NOT NULL,reason INTEGER NOT NULL,events_dropped_count BIGINT NOT NULL,PRIMARY KEY(log_source, reason))");
        sQLiteDatabase.execSQL("CREATE TABLE global_log_event_state (last_metrics_upload_ms BIGINT PRIMARY KEY)");
        sQLiteDatabase.execSQL(f8373k);
    }

    public static /* synthetic */ void f(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("ALTER TABLE transport_contexts ADD COLUMN extras BLOB");
        sQLiteDatabase.execSQL("CREATE UNIQUE INDEX contexts_backend_priority_extras on transport_contexts(backend_name, priority, extras)");
        sQLiteDatabase.execSQL("DROP INDEX contexts_backend_priority");
    }

    public static /* synthetic */ void g(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN inline BOOLEAN NOT NULL DEFAULT 1");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS event_payloads");
        sQLiteDatabase.execSQL("CREATE TABLE event_payloads (sequence_num INTEGER NOT NULL, event_id INTEGER NOT NULL, bytes BLOB NOT NULL,FOREIGN KEY (event_id) REFERENCES events(_id) ON DELETE CASCADE,PRIMARY KEY (sequence_num, event_id))");
    }

    public final void h(SQLiteDatabase sQLiteDatabase) {
        if (this.f8382j) {
            return;
        }
        onConfigure(sQLiteDatabase);
    }

    public final void i(SQLiteDatabase sQLiteDatabase, int i10) {
        h(sQLiteDatabase);
        j(sQLiteDatabase, 0, i10);
    }

    public final void j(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        List list = f8380r;
        if (i11 <= list.size()) {
            while (i10 < i11) {
                ((a) f8380r.get(i10)).a(sQLiteDatabase);
                i10++;
            }
            return;
        }
        throw new IllegalArgumentException("Migration from " + i10 + " to " + i11 + " was requested, but cannot be performed. Only " + list.size() + " migrations are provided");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onConfigure(SQLiteDatabase sQLiteDatabase) {
        this.f8382j = true;
        sQLiteDatabase.rawQuery("PRAGMA busy_timeout=0;", new String[0]).close();
        sQLiteDatabase.setForeignKeyConstraintsEnabled(true);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        i(sQLiteDatabase, this.f8381e);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) throws SQLException {
        sQLiteDatabase.execSQL("DROP TABLE events");
        sQLiteDatabase.execSQL("DROP TABLE event_metadata");
        sQLiteDatabase.execSQL("DROP TABLE transport_contexts");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS event_payloads");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS log_event_dropped");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS global_log_event_state");
        i(sQLiteDatabase, i11);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        h(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        h(sQLiteDatabase);
        j(sQLiteDatabase, i10, i11);
    }
}
