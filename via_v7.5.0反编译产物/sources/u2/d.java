package u2;

import com.google.firebase.crashlytics.internal.common.CommonUtils;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Charset f12821b = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y2.g f12822a;

    public d(y2.g gVar) {
        this.f12822a = gVar;
    }

    public static Map d(String str) {
        JSONObject jSONObject = new JSONObject(str);
        HashMap map = new HashMap();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            map.put(next, j(jSONObject, next));
        }
        return map;
    }

    public static String f(Map map) {
        return new JSONObject(map).toString();
    }

    public static void i(File file) {
        if (file.exists() && file.delete()) {
            q2.f.f().g("Deleted corrupt file: " + file.getAbsolutePath());
        }
    }

    public static String j(JSONObject jSONObject, String str) {
        if (jSONObject.isNull(str)) {
            return null;
        }
        return jSONObject.optString(str, null);
    }

    public File a(String str) {
        return this.f12822a.o(str, "internal-keys");
    }

    public File b(String str) {
        return this.f12822a.o(str, "keys");
    }

    public File c(String str) {
        return this.f12822a.o(str, "user-data");
    }

    public final String e(String str) {
        return j(new JSONObject(str), "userId");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [long] */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v6 */
    public Map g(String str, boolean z10) throws Throwable {
        FileInputStream fileInputStream;
        Exception e10;
        File fileA = z10 ? a(str) : b(str);
        if (fileA.exists()) {
            ?? length = fileA.length();
            if (length != 0) {
                ?? r10 = 0;
                try {
                    try {
                        fileInputStream = new FileInputStream(fileA);
                        try {
                            Map mapD = d(CommonUtils.D(fileInputStream));
                            CommonUtils.e(fileInputStream, "Failed to close user metadata file.");
                            return mapD;
                        } catch (Exception e11) {
                            e10 = e11;
                            q2.f.f().l("Error deserializing user metadata.", e10);
                            i(fileA);
                            CommonUtils.e(fileInputStream, "Failed to close user metadata file.");
                            return Collections.EMPTY_MAP;
                        }
                    } catch (Throwable th) {
                        th = th;
                        r10 = length;
                        CommonUtils.e(r10, "Failed to close user metadata file.");
                        throw th;
                    }
                } catch (Exception e12) {
                    fileInputStream = null;
                    e10 = e12;
                } catch (Throwable th2) {
                    th = th2;
                    CommonUtils.e(r10, "Failed to close user metadata file.");
                    throw th;
                }
            }
        }
        i(fileA);
        return Collections.EMPTY_MAP;
    }

    public String h(String str) throws Throwable {
        FileInputStream fileInputStream;
        File fileC = c(str);
        FileInputStream fileInputStream2 = null;
        if (!fileC.exists() || fileC.length() == 0) {
            q2.f.f().b("No userId set for session " + str);
            i(fileC);
            return null;
        }
        try {
            fileInputStream = new FileInputStream(fileC);
            try {
                try {
                    String strE = e(CommonUtils.D(fileInputStream));
                    q2.f.f().b("Loaded userId " + strE + " for session " + str);
                    CommonUtils.e(fileInputStream, "Failed to close user metadata file.");
                    return strE;
                } catch (Exception e10) {
                    e = e10;
                    q2.f.f().l("Error deserializing user metadata.", e);
                    i(fileC);
                    CommonUtils.e(fileInputStream, "Failed to close user metadata file.");
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                fileInputStream2 = fileInputStream;
                CommonUtils.e(fileInputStream2, "Failed to close user metadata file.");
                throw th;
            }
        } catch (Exception e11) {
            e = e11;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            CommonUtils.e(fileInputStream2, "Failed to close user metadata file.");
            throw th;
        }
    }

    public void k(String str, Map map, boolean z10) throws Throwable {
        File fileA = z10 ? a(str) : b(str);
        BufferedWriter bufferedWriter = null;
        try {
            try {
                String strF = f(map);
                BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileA), f12821b));
                try {
                    bufferedWriter2.write(strF);
                    bufferedWriter2.flush();
                    CommonUtils.e(bufferedWriter2, "Failed to close key/value metadata file.");
                } catch (Exception e10) {
                    e = e10;
                    bufferedWriter = bufferedWriter2;
                    q2.f.f().l("Error serializing key/value metadata.", e);
                    i(fileA);
                    CommonUtils.e(bufferedWriter, "Failed to close key/value metadata file.");
                } catch (Throwable th) {
                    th = th;
                    bufferedWriter = bufferedWriter2;
                    CommonUtils.e(bufferedWriter, "Failed to close key/value metadata file.");
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e11) {
            e = e11;
        }
    }
}
