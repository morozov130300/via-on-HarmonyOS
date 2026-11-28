package g2;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import java.io.File;
import java.util.Collections;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class l {
    /* JADX WARN: Code duplicated, block: B:24:0x0040  */
    /* JADX WARN: Code duplicated, block: B:30:0x007a A[Catch: SQLiteException -> 0x00a4, TryCatch #3 {SQLiteException -> 0x00a4, blocks: (B:26:0x0046, B:28:0x006c, B:30:0x007a, B:32:0x0082, B:33:0x0085, B:34:0x00a3, B:38:0x00a9, B:40:0x00ac, B:42:0x00b4, B:43:0x00bb, B:44:0x00be, B:46:0x00c4, B:49:0x00d5, B:50:0x00d9, B:27:0x0065), top: B:64:0x0046, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x0082 A[Catch: SQLiteException -> 0x00a4, LOOP:0: B:29:0x0078->B:32:0x0082, LOOP_END, TryCatch #3 {SQLiteException -> 0x00a4, blocks: (B:26:0x0046, B:28:0x006c, B:30:0x007a, B:32:0x0082, B:33:0x0085, B:34:0x00a3, B:38:0x00a9, B:40:0x00ac, B:42:0x00b4, B:43:0x00bb, B:44:0x00be, B:46:0x00c4, B:49:0x00d5, B:50:0x00d9, B:27:0x0065), top: B:64:0x0046, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:38:0x00a9 A[Catch: SQLiteException -> 0x00a4, LOOP:1: B:38:0x00a9->B:43:0x00bb, LOOP_START, PHI: r0
  0x00a9: PHI (r0v11 int) = (r0v10 int), (r0v12 int) binds: [B:37:0x00a7, B:43:0x00bb] A[DONT_GENERATE, DONT_INLINE], TryCatch #3 {SQLiteException -> 0x00a4, blocks: (B:26:0x0046, B:28:0x006c, B:30:0x007a, B:32:0x0082, B:33:0x0085, B:34:0x00a3, B:38:0x00a9, B:40:0x00ac, B:42:0x00b4, B:43:0x00bb, B:44:0x00be, B:46:0x00c4, B:49:0x00d5, B:50:0x00d9, B:27:0x0065), top: B:64:0x0046, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x00ac A[Catch: SQLiteException -> 0x00a4, TryCatch #3 {SQLiteException -> 0x00a4, blocks: (B:26:0x0046, B:28:0x006c, B:30:0x007a, B:32:0x0082, B:33:0x0085, B:34:0x00a3, B:38:0x00a9, B:40:0x00ac, B:42:0x00b4, B:43:0x00bb, B:44:0x00be, B:46:0x00c4, B:49:0x00d5, B:50:0x00d9, B:27:0x0065), top: B:64:0x0046, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:42:0x00b4 A[Catch: SQLiteException -> 0x00a4, TryCatch #3 {SQLiteException -> 0x00a4, blocks: (B:26:0x0046, B:28:0x006c, B:30:0x007a, B:32:0x0082, B:33:0x0085, B:34:0x00a3, B:38:0x00a9, B:40:0x00ac, B:42:0x00b4, B:43:0x00bb, B:44:0x00be, B:46:0x00c4, B:49:0x00d5, B:50:0x00d9, B:27:0x0065), top: B:64:0x0046, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x00c4 A[Catch: SQLiteException -> 0x00a4, TryCatch #3 {SQLiteException -> 0x00a4, blocks: (B:26:0x0046, B:28:0x006c, B:30:0x007a, B:32:0x0082, B:33:0x0085, B:34:0x00a3, B:38:0x00a9, B:40:0x00ac, B:42:0x00b4, B:43:0x00bb, B:44:0x00be, B:46:0x00c4, B:49:0x00d5, B:50:0x00d9, B:27:0x0065), top: B:64:0x0046, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:54:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:70:0x0085 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:73:0x00bb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:74:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:75:? A[SYNTHETIC] */
    public static void a(v3 v3Var, SQLiteDatabase sQLiteDatabase, String str, String str2, String str3, String[] strArr) throws Throwable {
        SQLiteDatabase sQLiteDatabase2;
        Throwable th;
        Cursor cursorQuery;
        HashSet hashSet;
        Cursor cursorRawQuery;
        int i10;
        int i11;
        if (v3Var == null) {
            throw new IllegalArgumentException("Monitor must not be null");
        }
        Cursor cursor = null;
        try {
            try {
                try {
                    try {
                        sQLiteDatabase2 = sQLiteDatabase;
                        try {
                            cursorQuery = sQLiteDatabase2.query("SQLITE_MASTER", new String[]{"name"}, "name=?", new String[]{str}, null, null, null);
                            try {
                                try {
                                    boolean zMoveToFirst = cursorQuery.moveToFirst();
                                    cursorQuery.close();
                                    if (!zMoveToFirst) {
                                        sQLiteDatabase2.execSQL(str2);
                                    }
                                } catch (SQLiteException e10) {
                                    e = e10;
                                    v3Var.w().c("Error querying for table", str, e);
                                    if (cursorQuery != null) {
                                        cursorQuery.close();
                                    }
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                cursor = cursorQuery;
                                if (cursor != null) {
                                    throw th;
                                }
                                cursor.close();
                                throw th;
                            }
                        } catch (SQLiteException e11) {
                            e = e11;
                            cursorQuery = null;
                            v3Var.w().c("Error querying for table", str, e);
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            sQLiteDatabase2.execSQL(str2);
                            hashSet = new HashSet();
                            cursorRawQuery = sQLiteDatabase2.rawQuery("SELECT * FROM " + str + " LIMIT 0", null);
                            Collections.addAll(hashSet, cursorRawQuery.getColumnNames());
                            cursorRawQuery.close();
                            for (String str4 : str3.split(",")) {
                                if (hashSet.remove(str4)) {
                                    throw new SQLiteException("Table " + str + " is missing required column: " + str4);
                                }
                            }
                            if (strArr != null) {
                                for (i10 = 0; i10 < strArr.length; i10 += 2) {
                                    if (!hashSet.remove(strArr[i10])) {
                                        sQLiteDatabase2.execSQL(strArr[i10 + 1]);
                                    }
                                }
                            }
                            if (hashSet.isEmpty()) {
                                return;
                            }
                            v3Var.w().c("Table has extra columns. table, columns", str, TextUtils.join(", ", hashSet));
                            return;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        if (cursor != null) {
                            throw th;
                        }
                        cursor.close();
                        throw th;
                    }
                } catch (SQLiteException e12) {
                    e = e12;
                    sQLiteDatabase2 = sQLiteDatabase;
                }
                Collections.addAll(hashSet, cursorRawQuery.getColumnNames());
                cursorRawQuery.close();
                while (i11 < r14) {
                    if (hashSet.remove(str4)) {
                        throw new SQLiteException("Table " + str + " is missing required column: " + str4);
                    }
                }
                if (strArr != null) {
                    while (i10 < strArr.length) {
                        if (!hashSet.remove(strArr[i10])) {
                            sQLiteDatabase2.execSQL(strArr[i10 + 1]);
                        }
                    }
                }
                if (hashSet.isEmpty()) {
                    v3Var.w().c("Table has extra columns. table, columns", str, TextUtils.join(", ", hashSet));
                    return;
                }
                return;
            } catch (Throwable th4) {
                cursorRawQuery.close();
                throw th4;
            }
            hashSet = new HashSet();
            cursorRawQuery = sQLiteDatabase2.rawQuery("SELECT * FROM " + str + " LIMIT 0", null);
        } catch (SQLiteException e13) {
            v3Var.r().b("Failed to verify columns on table that was just created", str);
            throw e13;
        }
    }

    public static void b(v3 v3Var, SQLiteDatabase sQLiteDatabase) {
        if (v3Var == null) {
            throw new IllegalArgumentException("Monitor must not be null");
        }
        File file = new File(sQLiteDatabase.getPath());
        if (!file.setReadable(false, false)) {
            v3Var.w().a("Failed to turn off database read permission");
        }
        if (!file.setWritable(false, false)) {
            v3Var.w().a("Failed to turn off database write permission");
        }
        if (!file.setReadable(true, true)) {
            v3Var.w().a("Failed to turn on database read permission for owner");
        }
        if (file.setWritable(true, true)) {
            return;
        }
        v3Var.w().a("Failed to turn on database write permission for owner");
    }
}
