package u9;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class e implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f12910a;

    public e(Context context, String str) {
        this.f12910a = context.getApplicationContext().getSharedPreferences(str, 0);
    }

    @Override // u9.m
    public boolean a(String str, String str2) {
        return (str == null || str.isEmpty() || !this.f12910a.edit().putString(str, str2).commit()) ? false : true;
    }

    @Override // u9.m
    public boolean contains(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        return this.f12910a.contains(str);
    }

    @Override // u9.m
    public boolean getBoolean(String str, boolean z10) {
        return (str == null || str.isEmpty()) ? z10 : this.f12910a.getBoolean(str, z10);
    }

    @Override // u9.m
    public int getInt(String str, int i10) {
        return (str == null || str.isEmpty()) ? i10 : this.f12910a.getInt(str, i10);
    }

    @Override // u9.m
    public long getLong(String str, long j10) {
        return (str == null || str.isEmpty()) ? j10 : this.f12910a.getLong(str, j10);
    }

    @Override // u9.m
    public String getString(String str, String str2) {
        return (str == null || str.isEmpty()) ? str2 : this.f12910a.getString(str, str2);
    }

    @Override // u9.m
    public void putBoolean(String str, boolean z10) {
        if (str == null || str.isEmpty()) {
            return;
        }
        this.f12910a.edit().putBoolean(str, z10).apply();
    }

    @Override // u9.m
    public void putInt(String str, int i10) {
        if (str == null || str.isEmpty()) {
            return;
        }
        this.f12910a.edit().putInt(str, i10).apply();
    }

    @Override // u9.m
    public void putLong(String str, long j10) {
        if (str == null || str.isEmpty()) {
            return;
        }
        this.f12910a.edit().putLong(str, j10).apply();
    }

    @Override // u9.m
    public void putString(String str, String str2) {
        if (str == null || str.isEmpty()) {
            return;
        }
        this.f12910a.edit().putString(str, str2).apply();
    }
}
