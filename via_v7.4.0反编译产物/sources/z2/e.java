package z2;

import org.json.JSONObject;
import s2.r;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public final r f14575a;

    public e(r rVar) {
        this.f14575a = rVar;
    }

    public static f a(int i10) {
        if (i10 == 3) {
            return new j();
        }
        p2.f.f().d("Could not determine SettingsJsonTransform for settings version " + i10 + ". Using default settings values.");
        return new b();
    }

    public d b(JSONObject jSONObject) {
        return a(jSONObject.getInt("settings_version")).a(this.f14575a, jSONObject);
    }
}
