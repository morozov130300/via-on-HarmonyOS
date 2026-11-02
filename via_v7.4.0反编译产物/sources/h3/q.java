package h3;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import java.text.SimpleDateFormat;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    public final SharedPreferences f6371a;

    public q(Context context, String str) {
        this.f6371a = context.getSharedPreferences("FirebaseHeartBeat" + str, 0);
    }

    public final synchronized void a() {
        try {
            long j10 = this.f6371a.getLong("fire-count", 0L);
            String key = "";
            String str = null;
            for (Map.Entry<String, ?> entry : this.f6371a.getAll().entrySet()) {
                if (entry.getValue() instanceof Set) {
                    for (String str2 : (Set) entry.getValue()) {
                        if (str == null || str.compareTo(str2) > 0) {
                            key = entry.getKey();
                            str = str2;
                        }
                    }
                }
            }
            HashSet hashSet = new HashSet(this.f6371a.getStringSet(key, new HashSet()));
            hashSet.remove(str);
            this.f6371a.edit().putStringSet(key, hashSet).putLong("fire-count", j10 - 1).commit();
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void b() {
        try {
            SharedPreferences.Editor editorEdit = this.f6371a.edit();
            for (Map.Entry<String, ?> entry : this.f6371a.getAll().entrySet()) {
                if (entry.getValue() instanceof Set) {
                    editorEdit.remove(entry.getKey());
                }
            }
            editorEdit.remove("fire-count");
            editorEdit.commit();
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized List c() {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            for (Map.Entry<String, ?> entry : this.f6371a.getAll().entrySet()) {
                if (entry.getValue() instanceof Set) {
                    arrayList.add(r.a(entry.getKey(), new ArrayList((Set) entry.getValue())));
                }
            }
            h(System.currentTimeMillis());
        } catch (Throwable th) {
            throw th;
        }
        return arrayList;
    }

    public final synchronized String d(long j10) {
        if (Build.VERSION.SDK_INT >= 26) {
            return new Date(j10).toInstant().atOffset(ZoneOffset.UTC).toLocalDateTime().format(DateTimeFormatter.ISO_LOCAL_DATE);
        }
        return new SimpleDateFormat("yyyy-MM-dd", Locale.UK).format(new Date(j10));
    }

    public final synchronized String e(String str) {
        for (Map.Entry<String, ?> entry : this.f6371a.getAll().entrySet()) {
            if (entry.getValue() instanceof Set) {
                Iterator it = ((Set) entry.getValue()).iterator();
                while (it.hasNext()) {
                    if (str.equals((String) it.next())) {
                        return entry.getKey();
                    }
                }
            }
        }
        return null;
    }

    public final synchronized void f(String str) {
        try {
            String strE = e(str);
            if (strE == null) {
                return;
            }
            HashSet hashSet = new HashSet(this.f6371a.getStringSet(strE, new HashSet()));
            hashSet.remove(str);
            if (hashSet.isEmpty()) {
                this.f6371a.edit().remove(strE).commit();
            } else {
                this.f6371a.edit().putStringSet(strE, hashSet).commit();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void g(long j10, String str) {
        String strD = d(j10);
        if (this.f6371a.getString("last-used-date", "").equals(strD)) {
            String strE = e(strD);
            if (strE == null) {
                return;
            }
            if (strE.equals(str)) {
                return;
            }
            i(str, strD);
            return;
        }
        long j11 = this.f6371a.getLong("fire-count", 0L);
        if (j11 + 1 == 30) {
            a();
            j11 = this.f6371a.getLong("fire-count", 0L);
        }
        HashSet hashSet = new HashSet(this.f6371a.getStringSet(str, new HashSet()));
        hashSet.add(strD);
        this.f6371a.edit().putStringSet(str, hashSet).putLong("fire-count", j11 + 1).putString("last-used-date", strD).commit();
    }

    public synchronized void h(long j10) {
        this.f6371a.edit().putLong("fire-global", j10).commit();
    }

    public final synchronized void i(String str, String str2) {
        f(str2);
        HashSet hashSet = new HashSet(this.f6371a.getStringSet(str, new HashSet()));
        hashSet.add(str2);
        this.f6371a.edit().putStringSet(str, hashSet).commit();
    }
}
