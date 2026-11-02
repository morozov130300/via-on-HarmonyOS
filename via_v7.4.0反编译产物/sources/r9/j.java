package r9;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
import w9.m;
import z8.c0;
import z8.c1;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    public final String f11596a;

    /* renamed from: b, reason: collision with root package name */
    public final String f11597b;

    /* renamed from: c, reason: collision with root package name */
    public final String f11598c;

    /* renamed from: d, reason: collision with root package name */
    public final m f11599d;

    /* renamed from: e, reason: collision with root package name */
    public String f11600e;

    public j(String str, String str2, m mVar, String str3) {
        this.f11596a = str;
        this.f11597b = str2;
        this.f11599d = mVar;
        this.f11598c = str3;
    }

    public List a() throws Throwable {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("userId", c());
        } catch (JSONException e10) {
            pc.a.b(e10);
        }
        File file = new File(this.f11598c, "features");
        ArrayList arrayList = new ArrayList();
        List listD = d(c1.O(file));
        if (listD.isEmpty() || System.currentTimeMillis() > b() + 60000) {
            w.d dVarE = e(jSONObject);
            if (((Integer) dVarE.f13207a).intValue() == 200) {
                pc.a.a("fetch done.", new Object[0]);
                arrayList.addAll(d((String) dVarE.f13208b));
                c1.Q(file, (String) dVarE.f13208b);
                f(System.currentTimeMillis());
                t8.f.a().f(true);
            } else {
                pc.a.a("fetch response error, code: %d, message: %s", dVarE.f13207a, dVarE.f13208b);
                arrayList.addAll(listD);
                t8.f.a().f(false);
            }
        } else {
            arrayList.addAll(listD);
        }
        return arrayList;
    }

    public final long b() {
        return this.f11599d.getLong("last_fetched", 0L);
    }

    public final String c() {
        String str = this.f11600e;
        if (str == null || !str.isEmpty()) {
            String string = this.f11599d.getString("uid", null);
            this.f11600e = string;
            if (string == null || string.isEmpty()) {
                String str2 = UUID.randomUUID().toString().replace("-", "").toUpperCase(Locale.ROOT) + c0.b();
                this.f11600e = str2;
                this.f11599d.putString("uid", str2);
            }
        }
        return this.f11600e;
    }

    public final List d(String str) {
        return d.b(str);
    }

    public final w.d e(JSONObject jSONObject) throws IOException {
        String string;
        if (jSONObject == null) {
            string = "{}";
        } else {
            try {
                string = jSONObject.toString();
            } catch (IOException e10) {
                pc.a.b(e10);
                return w.d.a(10, e10.getMessage());
            }
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f11596a).openConnection();
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        httpURLConnection.setRequestProperty("Authorization", this.f11597b);
        httpURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Linux; Android) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.91 Mobile Safari/537.36 Via/7.4.0.beta");
        DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
        try {
            dataOutputStream.writeBytes(string);
            dataOutputStream.flush();
            dataOutputStream.close();
            int responseCode = httpURLConnection.getResponseCode();
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                try {
                    StringBuilder sb2 = new StringBuilder();
                    while (true) {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            w.d dVarA = w.d.a(Integer.valueOf(responseCode), sb2.toString());
                            bufferedReader.close();
                            return dVarA;
                        }
                        sb2.append(line);
                    }
                } finally {
                }
            } finally {
                httpURLConnection.disconnect();
            }
        } finally {
        }
    }

    public void f(long j10) {
        this.f11599d.putLong("last_fetched", j10);
    }
}
