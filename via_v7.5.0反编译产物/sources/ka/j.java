package ka;

import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.Parcel;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
import org.simpleframework.xml.strategy.Name;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class j {
    public static f a(String str) {
        if (str != null && !str.isEmpty()) {
            try {
                return b(new JSONObject(str));
            } catch (JSONException e10) {
                tc.a.j(e10);
            }
        }
        return null;
    }

    public static f b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String strOptString = jSONObject.optString(Name.MARK);
        if (strOptString.isEmpty()) {
            return null;
        }
        f fVar = new f(strOptString);
        fVar.l(jSONObject.optString("url"));
        fVar.k(jSONObject.optString("title"));
        fVar.g(jSONObject.optString("filePath"));
        fVar.h(jSONObject.optInt("flags"));
        fVar.j(jSONObject.optLong("lastVisitedAt"));
        return fVar;
    }

    public static Bundle c(String str) {
        if (str != null && !str.isEmpty()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(str);
                try {
                    Parcel parcelObtain = Parcel.obtain();
                    int size = (int) fileInputStream.getChannel().size();
                    byte[] bArr = new byte[size];
                    fileInputStream.read(bArr, 0, size);
                    parcelObtain.unmarshall(bArr, 0, size);
                    parcelObtain.setDataPosition(0);
                    Bundle bundle = parcelObtain.readBundle(ClassLoader.getSystemClassLoader());
                    if (bundle != null) {
                        bundle.putAll(bundle);
                    }
                    parcelObtain.recycle();
                    fileInputStream.close();
                    return bundle;
                } catch (Throwable th) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (BadParcelableException | IOException | IllegalStateException | NullPointerException e10) {
                tc.a.j(e10);
            }
        }
        return null;
    }

    public static boolean d(Bundle bundle, String str) {
        if (str != null && !str.isEmpty()) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(str);
                try {
                    Parcel parcelObtain = Parcel.obtain();
                    parcelObtain.writeBundle(bundle);
                    fileOutputStream.write(parcelObtain.marshall());
                    fileOutputStream.flush();
                    parcelObtain.recycle();
                    fileOutputStream.close();
                    return true;
                } catch (Throwable th) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (IOException e10) {
                tc.a.j(e10);
            }
        }
        return false;
    }

    public static r4.g e(f fVar) {
        Bundle bundleC;
        if (fVar == null) {
            throw new NullPointerException("entry cannot be null");
        }
        String strA = fVar.a();
        return (strA == null || strA.isEmpty() || (bundleC = c(strA)) == null) ? g.e(fVar.c(), fVar.f(), fVar.e()) : g.d(fVar.c(), bundleC);
    }
}
