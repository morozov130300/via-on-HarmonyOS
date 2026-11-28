package a3;

import org.json.JSONObject;
import t2.r;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f43a;

    public e(r rVar) {
        this.f43a = rVar;
    }

    public static f a(int i10) {
        if (i10 == 3) {
            return new j();
        }
        q2.f.f().d("Could not determine SettingsJsonTransform for settings version " + i10 + ". Using default settings values.");
        return new b();
    }

    public d b(JSONObject jSONObject) {
        return a(jSONObject.getInt("settings_version")).a(this.f43a, jSONObject);
    }
}
