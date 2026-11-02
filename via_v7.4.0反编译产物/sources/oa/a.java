package oa;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;
import org.simpleframework.xml.strategy.Name;
import z8.v0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class a implements e {

    /* renamed from: a, reason: collision with root package name */
    public final List f10489a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public final List f10490b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final Locale f10491c;

    public a(Locale locale) {
        this.f10491c = locale;
    }

    @Override // oa.e
    public b a(String str) {
        if (str == null || str.isEmpty()) {
            return (b) this.f10490b.get(0);
        }
        g();
        for (b bVar : this.f10490b) {
            if (str.equals(bVar.a())) {
                return bVar;
            }
        }
        return (b) this.f10490b.get(0);
    }

    @Override // oa.e
    public List b() {
        f();
        return this.f10489a;
    }

    @Override // oa.e
    public d c(String str, String str2, String str3) {
        if (str == null) {
            return null;
        }
        String strTrim = str.trim();
        if (strTrim.isEmpty() || str3 == null || str3.isEmpty()) {
            return null;
        }
        return j(strTrim, str2, str3);
    }

    @Override // oa.e
    public List d() {
        g();
        return this.f10490b;
    }

    @Override // oa.e
    public b e(String str) {
        if (str == null || str.isEmpty()) {
            str = "auto";
        }
        f();
        for (b bVar : this.f10489a) {
            if (str.equals(bVar.a())) {
                return bVar;
            }
        }
        return (b) this.f10489a.get(0);
    }

    public final void f() {
        if (this.f10489a.isEmpty()) {
            this.f10489a.addAll(h(true));
        }
    }

    public final void g() {
        if (this.f10490b.isEmpty()) {
            this.f10490b.addAll(h(false));
        }
    }

    public final List h(boolean z10) {
        ArrayList arrayList = new ArrayList();
        if (z10) {
            arrayList.add(new b("auto", "", "Auto"));
        }
        arrayList.add(i("ar", "Arabic"));
        arrayList.add(i("az", "Azerbaijani"));
        arrayList.add(i("be", "Belarusian"));
        arrayList.add(i("bn", "Bengali"));
        arrayList.add(i("cs", "Czech"));
        arrayList.add(i("de", "German"));
        arrayList.add(i("en", "English"));
        arrayList.add(i("es", "Spanish"));
        arrayList.add(i("fa", "Persian"));
        arrayList.add(i("tl", "Filipino"));
        arrayList.add(i("fr", "French"));
        arrayList.add(i("hi", "Hindi"));
        arrayList.add(i("hr", "Croatian"));
        arrayList.add(i("hu", "Hungarian"));
        arrayList.add(i(Name.MARK, "Indonesian"));
        arrayList.add(i("it", "Italian"));
        arrayList.add(i("ja", "Japanese"));
        arrayList.add(i("ko", "Korean"));
        arrayList.add(i("lt", "Lithuanian"));
        arrayList.add(i("ne", "Nepali"));
        arrayList.add(i("pl", "Polish"));
        arrayList.add(i("pt", "Portuguese"));
        arrayList.add(i("ro", "Romanian"));
        arrayList.add(i("ru", "Russian"));
        arrayList.add(i("sl", "Slovenian"));
        arrayList.add(i("ta", "Tamil"));
        arrayList.add(i("tr", "Turkish"));
        arrayList.add(i("uk", "Ukrainian"));
        arrayList.add(i("uz", "Uzbek"));
        arrayList.add(i("vi", "Vietnamese"));
        arrayList.add(i("zh", "Chinese"));
        arrayList.add(i("zh-TW", "Chinese (Traditional)"));
        return arrayList;
    }

    public final b i(String str, String str2) {
        b bVar = new b(str, null, str2);
        String displayLanguage = "zh-TW".equals(str) ? this.f10491c.getLanguage().equals(new Locale("zh").getLanguage()) ? "\u7e41\u9ad4\u4e2d\u6587" : "Chinese (Traditional)" : new Locale(str).getDisplayLanguage(this.f10491c);
        if (!str.equalsIgnoreCase(displayLanguage)) {
            bVar.c(displayLanguage);
        }
        return bVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0066 A[Catch: all -> 0x00bc, Exception -> 0x00bf, TRY_LEAVE, TryCatch #6 {Exception -> 0x00bf, all -> 0x00bc, blocks: (B:13:0x0043, B:15:0x0066, B:30:0x00b8, B:40:0x00cb, B:39:0x00c8), top: B:59:0x0043 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00db  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final d j(String str, String str2, String str3) throws Throwable {
        Throwable th;
        d dVar;
        Exception e10;
        HttpURLConnection httpURLConnection;
        int responseCode;
        HttpURLConnection httpURLConnection2 = null;
        dVar = null;
        dVar = null;
        dVar = null;
        d dVar2 = null;
        httpURLConnection2 = null;
        try {
            if (str2 != null) {
                try {
                    try {
                        if (str2.isEmpty()) {
                        }
                        httpURLConnection = (HttpURLConnection) new URL("https://translate.google.com/translate_a/single?dj=1&sl=" + str2 + "&tl=" + str3 + "&ie=UTF-8&oe=UTF-8&client=at&dt=t&otf=2&q=" + v0.j(str)).openConnection();
                        httpURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.116 Safari/537.36");
                        httpURLConnection.setRequestMethod("GET");
                        responseCode = httpURLConnection.getResponseCode();
                        pc.a.a("requestFromGoogleTranslate: responseCode=%d", Integer.valueOf(responseCode));
                        if (responseCode == 200) {
                            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "utf-8"));
                            try {
                                StringBuilder sb2 = new StringBuilder();
                                while (true) {
                                    String line = bufferedReader.readLine();
                                    if (line == null) {
                                        break;
                                    }
                                    sb2.append(line.trim());
                                }
                                JSONArray jSONArrayOptJSONArray = new JSONObject(sb2.toString()).optJSONArray("sentences");
                                if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                                    String strOptString = jSONArrayOptJSONArray.getJSONObject(0).optString("trans");
                                    if (!strOptString.isEmpty()) {
                                        dVar2 = new d(str, strOptString, str2, str3);
                                    }
                                }
                                bufferedReader.close();
                            } catch (Throwable th2) {
                                try {
                                    bufferedReader.close();
                                } catch (Throwable th3) {
                                    th2.addSuppressed(th3);
                                }
                                throw th2;
                            }
                        }
                        httpURLConnection.disconnect();
                        return dVar2;
                    } catch (Exception e11) {
                        e10 = e11;
                        dVar = null;
                        e10.printStackTrace();
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                        return dVar;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    throw th;
                }
            }
            httpURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.116 Safari/537.36");
            httpURLConnection.setRequestMethod("GET");
            responseCode = httpURLConnection.getResponseCode();
            pc.a.a("requestFromGoogleTranslate: responseCode=%d", Integer.valueOf(responseCode));
            if (responseCode == 200) {
            }
            httpURLConnection.disconnect();
            return dVar2;
        } catch (Exception e12) {
            e10 = e12;
            dVar = null;
            httpURLConnection2 = httpURLConnection;
            e10.printStackTrace();
            if (httpURLConnection2 != null) {
            }
            return dVar;
        } catch (Throwable th5) {
            th = th5;
            httpURLConnection2 = httpURLConnection;
            if (httpURLConnection2 != null) {
            }
            throw th;
        }
        str2 = "auto";
        httpURLConnection = (HttpURLConnection) new URL("https://translate.google.com/translate_a/single?dj=1&sl=" + str2 + "&tl=" + str3 + "&ie=UTF-8&oe=UTF-8&client=at&dt=t&otf=2&q=" + v0.j(str)).openConnection();
    }
}
