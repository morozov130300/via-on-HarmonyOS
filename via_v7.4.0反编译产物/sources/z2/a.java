package z2;

import com.google.firebase.crashlytics.internal.common.CommonUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import org.json.JSONObject;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public final File f14558a;

    public a(x2.g gVar) {
        this.f14558a = gVar.e("com.crashlytics.settings.json");
    }

    public final File a() {
        return this.f14558a;
    }

    public JSONObject b() throws Throwable {
        Throwable th;
        FileInputStream fileInputStream;
        JSONObject jSONObject;
        p2.f.f().b("Checking for cached settings...");
        FileInputStream fileInputStream2 = null;
        try {
            try {
                File fileA = a();
                if (fileA.exists()) {
                    fileInputStream = new FileInputStream(fileA);
                    try {
                        jSONObject = new JSONObject(CommonUtils.D(fileInputStream));
                        fileInputStream2 = fileInputStream;
                    } catch (Exception e10) {
                        e = e10;
                        p2.f.f().e("Failed to fetch cached settings", e);
                        CommonUtils.e(fileInputStream, "Error while closing settings cache file.");
                        return null;
                    }
                } else {
                    p2.f.f().i("Settings file does not exist.");
                    jSONObject = null;
                }
                CommonUtils.e(fileInputStream2, "Error while closing settings cache file.");
                return jSONObject;
            } catch (Throwable th2) {
                th = th2;
                CommonUtils.e(null, "Error while closing settings cache file.");
                throw th;
            }
        } catch (Exception e11) {
            e = e11;
            fileInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            CommonUtils.e(null, "Error while closing settings cache file.");
            throw th;
        }
    }

    public void c(long j10, JSONObject jSONObject) throws Throwable {
        FileWriter fileWriter;
        p2.f.f().i("Writing settings to cache file...");
        if (jSONObject != null) {
            FileWriter fileWriter2 = null;
            try {
                try {
                    jSONObject.put("expires_at", j10);
                    fileWriter = new FileWriter(a());
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e10) {
                e = e10;
            }
            try {
                fileWriter.write(jSONObject.toString());
                fileWriter.flush();
                CommonUtils.e(fileWriter, "Failed to close settings writer.");
            } catch (Exception e11) {
                e = e11;
                fileWriter2 = fileWriter;
                p2.f.f().e("Failed to cache settings", e);
                CommonUtils.e(fileWriter2, "Failed to close settings writer.");
            } catch (Throwable th2) {
                th = th2;
                fileWriter2 = fileWriter;
                CommonUtils.e(fileWriter2, "Failed to close settings writer.");
                throw th;
            }
        }
    }
}
