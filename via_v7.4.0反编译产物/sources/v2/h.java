package v2;

import android.util.Base64;
import android.util.JsonReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import u2.b0;
import u2.c0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public static final c3.a f12963a = new e3.d().j(u2.a.f12449a).k(true).i();

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface a {
        Object a(JsonReader jsonReader);
    }

    public static b0.d A(JsonReader jsonReader) throws IOException {
        b0.d.a aVarA = b0.d.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            if (strNextName.equals("files")) {
                aVarA.b(l(jsonReader, new a() { // from class: v2.d
                    @Override // v2.h.a
                    public final Object a(JsonReader jsonReader2) {
                        return h.z(jsonReader2);
                    }
                }));
            } else if (strNextName.equals("orgId")) {
                aVarA.c(jsonReader.nextString());
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return aVarA.a();
    }

    public static b0.e.AbstractC0143e B(JsonReader jsonReader) throws IOException {
        b0.e.AbstractC0143e.a aVarA = b0.e.AbstractC0143e.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            switch (strNextName) {
                case "buildVersion":
                    aVarA.b(jsonReader.nextString());
                    break;
                case "jailbroken":
                    aVarA.c(jsonReader.nextBoolean());
                    break;
                case "version":
                    aVarA.e(jsonReader.nextString());
                    break;
                case "platform":
                    aVarA.d(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return aVarA.a();
    }

    public static b0 C(JsonReader jsonReader) throws IOException {
        b0.b bVarB = b0.b();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            switch (strNextName) {
                case "ndkPayload":
                    bVarB.g(A(jsonReader));
                    break;
                case "sdkVersion":
                    bVarB.i(jsonReader.nextString());
                    break;
                case "appExitInfo":
                    bVarB.b(k(jsonReader));
                    break;
                case "buildVersion":
                    bVarB.c(jsonReader.nextString());
                    break;
                case "gmpAppId":
                    bVarB.e(jsonReader.nextString());
                    break;
                case "installationUuid":
                    bVarB.f(jsonReader.nextString());
                    break;
                case "platform":
                    bVarB.h(jsonReader.nextInt());
                    break;
                case "displayVersion":
                    bVarB.d(jsonReader.nextString());
                    break;
                case "session":
                    bVarB.j(D(jsonReader));
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return bVarB.a();
    }

    public static b0.e D(JsonReader jsonReader) throws IOException {
        b0.e.b bVarA = b0.e.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            switch (strNextName) {
                case "startedAt":
                    bVarA.l(jsonReader.nextLong());
                    break;
                case "identifier":
                    bVarA.j(Base64.decode(jsonReader.nextString(), 2));
                    break;
                case "endedAt":
                    bVarA.e(Long.valueOf(jsonReader.nextLong()));
                    break;
                case "device":
                    bVarA.d(o(jsonReader));
                    break;
                case "events":
                    bVarA.f(l(jsonReader, new a() { // from class: v2.c
                        @Override // v2.h.a
                        public final Object a(JsonReader jsonReader2) {
                            return h.p(jsonReader2);
                        }
                    }));
                    break;
                case "os":
                    bVarA.k(B(jsonReader));
                    break;
                case "app":
                    bVarA.b(j(jsonReader));
                    break;
                case "user":
                    bVarA.m(E(jsonReader));
                    break;
                case "generator":
                    bVarA.g(jsonReader.nextString());
                    break;
                case "crashed":
                    bVarA.c(jsonReader.nextBoolean());
                    break;
                case "generatorType":
                    bVarA.h(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return bVarA.a();
    }

    public static b0.e.f E(JsonReader jsonReader) throws IOException {
        b0.e.f.a aVarA = b0.e.f.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            if (strNextName.equals("identifier")) {
                aVarA.b(jsonReader.nextString());
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return aVarA.a();
    }

    public static b0.e.a j(JsonReader jsonReader) throws IOException {
        b0.e.a.AbstractC0130a abstractC0130aA = b0.e.a.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            switch (strNextName) {
                case "identifier":
                    abstractC0130aA.e(jsonReader.nextString());
                    break;
                case "developmentPlatform":
                    abstractC0130aA.b(jsonReader.nextString());
                    break;
                case "developmentPlatformVersion":
                    abstractC0130aA.c(jsonReader.nextString());
                    break;
                case "version":
                    abstractC0130aA.g(jsonReader.nextString());
                    break;
                case "installationUuid":
                    abstractC0130aA.f(jsonReader.nextString());
                    break;
                case "displayVersion":
                    abstractC0130aA.d(jsonReader.nextString());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return abstractC0130aA.a();
    }

    public static b0.a k(JsonReader jsonReader) throws IOException {
        b0.a.b bVarA = b0.a.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            switch (strNextName) {
                case "buildIdMappingForArch":
                    bVarA.b(l(jsonReader, new a() { // from class: v2.a
                        @Override // v2.h.a
                        public final Object a(JsonReader jsonReader2) {
                            return h.m(jsonReader2);
                        }
                    }));
                    break;
                case "pid":
                    bVarA.d(jsonReader.nextInt());
                    break;
                case "pss":
                    bVarA.f(jsonReader.nextLong());
                    break;
                case "rss":
                    bVarA.h(jsonReader.nextLong());
                    break;
                case "timestamp":
                    bVarA.i(jsonReader.nextLong());
                    break;
                case "processName":
                    bVarA.e(jsonReader.nextString());
                    break;
                case "reasonCode":
                    bVarA.g(jsonReader.nextInt());
                    break;
                case "traceFile":
                    bVarA.j(jsonReader.nextString());
                    break;
                case "importance":
                    bVarA.c(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return bVarA.a();
    }

    public static c0 l(JsonReader jsonReader, a aVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            arrayList.add(aVar.a(jsonReader));
        }
        jsonReader.endArray();
        return c0.c(arrayList);
    }

    public static b0.a.AbstractC0128a m(JsonReader jsonReader) throws IOException {
        b0.a.AbstractC0128a.AbstractC0129a abstractC0129aA = b0.a.AbstractC0128a.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            switch (strNextName) {
                case "libraryName":
                    abstractC0129aA.d(jsonReader.nextString());
                    break;
                case "arch":
                    abstractC0129aA.b(jsonReader.nextString());
                    break;
                case "buildId":
                    abstractC0129aA.c(jsonReader.nextString());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return abstractC0129aA.a();
    }

    public static b0.c n(JsonReader jsonReader) throws IOException {
        b0.c.a aVarA = b0.c.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            if (strNextName.equals("key")) {
                aVarA.b(jsonReader.nextString());
            } else if (strNextName.equals("value")) {
                aVarA.c(jsonReader.nextString());
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return aVarA.a();
    }

    public static b0.e.c o(JsonReader jsonReader) throws IOException {
        b0.e.c.a aVarA = b0.e.c.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            switch (strNextName) {
                case "simulator":
                    aVarA.i(jsonReader.nextBoolean());
                    break;
                case "manufacturer":
                    aVarA.e(jsonReader.nextString());
                    break;
                case "ram":
                    aVarA.h(jsonReader.nextLong());
                    break;
                case "arch":
                    aVarA.b(jsonReader.nextInt());
                    break;
                case "diskSpace":
                    aVarA.d(jsonReader.nextLong());
                    break;
                case "cores":
                    aVarA.c(jsonReader.nextInt());
                    break;
                case "model":
                    aVarA.f(jsonReader.nextString());
                    break;
                case "state":
                    aVarA.j(jsonReader.nextInt());
                    break;
                case "modelClass":
                    aVarA.g(jsonReader.nextString());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return aVarA.a();
    }

    public static b0.e.d p(JsonReader jsonReader) throws IOException {
        b0.e.d.b bVarA = b0.e.d.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            switch (strNextName) {
                case "device":
                    bVarA.c(s(jsonReader));
                    break;
                case "app":
                    bVarA.b(q(jsonReader));
                    break;
                case "log":
                    bVarA.d(w(jsonReader));
                    break;
                case "type":
                    bVarA.f(jsonReader.nextString());
                    break;
                case "timestamp":
                    bVarA.e(jsonReader.nextLong());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return bVarA.a();
    }

    public static b0.e.d.a q(JsonReader jsonReader) throws IOException {
        b0.e.d.a.AbstractC0131a abstractC0131aA = b0.e.d.a.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            switch (strNextName) {
                case "background":
                    abstractC0131aA.b(Boolean.valueOf(jsonReader.nextBoolean()));
                    break;
                case "execution":
                    abstractC0131aA.d(t(jsonReader));
                    break;
                case "internalKeys":
                    abstractC0131aA.e(l(jsonReader, new a() { // from class: v2.b
                        @Override // v2.h.a
                        public final Object a(JsonReader jsonReader2) {
                            return h.n(jsonReader2);
                        }
                    }));
                    break;
                case "customAttributes":
                    abstractC0131aA.c(l(jsonReader, new a() { // from class: v2.b
                        @Override // v2.h.a
                        public final Object a(JsonReader jsonReader2) {
                            return h.n(jsonReader2);
                        }
                    }));
                    break;
                case "uiOrientation":
                    abstractC0131aA.f(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return abstractC0131aA.a();
    }

    public static b0.e.d.a.b.AbstractC0132a r(JsonReader jsonReader) throws IOException {
        b0.e.d.a.b.AbstractC0132a.AbstractC0133a abstractC0133aA = b0.e.d.a.b.AbstractC0132a.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            switch (strNextName) {
                case "name":
                    abstractC0133aA.c(jsonReader.nextString());
                    break;
                case "size":
                    abstractC0133aA.d(jsonReader.nextLong());
                    break;
                case "uuid":
                    abstractC0133aA.f(Base64.decode(jsonReader.nextString(), 2));
                    break;
                case "baseAddress":
                    abstractC0133aA.b(jsonReader.nextLong());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return abstractC0133aA.a();
    }

    public static b0.e.d.c s(JsonReader jsonReader) throws IOException {
        b0.e.d.c.a aVarA = b0.e.d.c.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            switch (strNextName) {
                case "batteryLevel":
                    aVarA.b(Double.valueOf(jsonReader.nextDouble()));
                    break;
                case "batteryVelocity":
                    aVarA.c(jsonReader.nextInt());
                    break;
                case "orientation":
                    aVarA.e(jsonReader.nextInt());
                    break;
                case "diskUsed":
                    aVarA.d(jsonReader.nextLong());
                    break;
                case "ramUsed":
                    aVarA.g(jsonReader.nextLong());
                    break;
                case "proximityOn":
                    aVarA.f(jsonReader.nextBoolean());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return aVarA.a();
    }

    public static b0.e.d.a.b t(JsonReader jsonReader) throws IOException {
        b0.e.d.a.b.AbstractC0134b abstractC0134bA = b0.e.d.a.b.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            switch (strNextName) {
                case "appExitInfo":
                    abstractC0134bA.b(k(jsonReader));
                    break;
                case "threads":
                    abstractC0134bA.f(l(jsonReader, new a() { // from class: v2.e
                        @Override // v2.h.a
                        public final Object a(JsonReader jsonReader2) {
                            return h.y(jsonReader2);
                        }
                    }));
                    break;
                case "signal":
                    abstractC0134bA.e(x(jsonReader));
                    break;
                case "binaries":
                    abstractC0134bA.c(l(jsonReader, new a() { // from class: v2.f
                        @Override // v2.h.a
                        public final Object a(JsonReader jsonReader2) {
                            return h.r(jsonReader2);
                        }
                    }));
                    break;
                case "exception":
                    abstractC0134bA.d(u(jsonReader));
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return abstractC0134bA.a();
    }

    public static b0.e.d.a.b.c u(JsonReader jsonReader) throws IOException {
        b0.e.d.a.b.c.AbstractC0135a abstractC0135aA = b0.e.d.a.b.c.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            switch (strNextName) {
                case "frames":
                    abstractC0135aA.c(l(jsonReader, new g()));
                    break;
                case "reason":
                    abstractC0135aA.e(jsonReader.nextString());
                    break;
                case "type":
                    abstractC0135aA.f(jsonReader.nextString());
                    break;
                case "causedBy":
                    abstractC0135aA.b(u(jsonReader));
                    break;
                case "overflowCount":
                    abstractC0135aA.d(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return abstractC0135aA.a();
    }

    public static b0.e.d.a.b.AbstractC0138e.AbstractC0140b v(JsonReader jsonReader) throws IOException {
        b0.e.d.a.b.AbstractC0138e.AbstractC0140b.AbstractC0141a abstractC0141aA = b0.e.d.a.b.AbstractC0138e.AbstractC0140b.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            switch (strNextName) {
                case "offset":
                    abstractC0141aA.d(jsonReader.nextLong());
                    break;
                case "symbol":
                    abstractC0141aA.f(jsonReader.nextString());
                    break;
                case "pc":
                    abstractC0141aA.e(jsonReader.nextLong());
                    break;
                case "file":
                    abstractC0141aA.b(jsonReader.nextString());
                    break;
                case "importance":
                    abstractC0141aA.c(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return abstractC0141aA.a();
    }

    public static b0.e.d.AbstractC0142d w(JsonReader jsonReader) throws IOException {
        b0.e.d.AbstractC0142d.a aVarA = b0.e.d.AbstractC0142d.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            if (strNextName.equals("content")) {
                aVarA.b(jsonReader.nextString());
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return aVarA.a();
    }

    public static b0.e.d.a.b.AbstractC0136d x(JsonReader jsonReader) throws IOException {
        b0.e.d.a.b.AbstractC0136d.AbstractC0137a abstractC0137aA = b0.e.d.a.b.AbstractC0136d.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            switch (strNextName) {
                case "address":
                    abstractC0137aA.b(jsonReader.nextLong());
                    break;
                case "code":
                    abstractC0137aA.c(jsonReader.nextString());
                    break;
                case "name":
                    abstractC0137aA.d(jsonReader.nextString());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return abstractC0137aA.a();
    }

    public static b0.e.d.a.b.AbstractC0138e y(JsonReader jsonReader) throws IOException {
        b0.e.d.a.b.AbstractC0138e.AbstractC0139a abstractC0139aA = b0.e.d.a.b.AbstractC0138e.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            switch (strNextName) {
                case "frames":
                    abstractC0139aA.b(l(jsonReader, new g()));
                    break;
                case "name":
                    abstractC0139aA.d(jsonReader.nextString());
                    break;
                case "importance":
                    abstractC0139aA.c(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return abstractC0139aA.a();
    }

    public static b0.d.b z(JsonReader jsonReader) throws IOException {
        b0.d.b.a aVarA = b0.d.b.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            if (strNextName.equals("filename")) {
                aVarA.c(jsonReader.nextString());
            } else if (strNextName.equals("contents")) {
                aVarA.b(Base64.decode(jsonReader.nextString(), 2));
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return aVarA.a();
    }

    public b0 F(String str) throws IOException {
        try {
            JsonReader jsonReader = new JsonReader(new StringReader(str));
            try {
                b0 b0VarC = C(jsonReader);
                jsonReader.close();
                return b0VarC;
            } finally {
            }
        } catch (IllegalStateException e10) {
            throw new IOException(e10);
        }
    }

    public String G(b0 b0Var) {
        return f12963a.b(b0Var);
    }

    public b0.e.d h(String str) throws IOException {
        try {
            JsonReader jsonReader = new JsonReader(new StringReader(str));
            try {
                b0.e.d dVarP = p(jsonReader);
                jsonReader.close();
                return dVarP;
            } finally {
            }
        } catch (IllegalStateException e10) {
            throw new IOException(e10);
        }
    }

    public String i(b0.e.d dVar) {
        return f12963a.b(dVar);
    }
}
