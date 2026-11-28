package w2;

import android.util.Base64;
import android.util.JsonReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import v2.b0;
import v2.c0;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d3.a f13578a = new f3.d().j(v2.a.f12988a).k(true).i();

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
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
                aVarA.b(l(jsonReader, new a() { // from class: w2.d
                    @Override // w2.h.a
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

    public static b0.e.AbstractC0148e B(JsonReader jsonReader) throws IOException {
        b0.e.AbstractC0148e.a aVarA = b0.e.AbstractC0148e.a();
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
                    bVarA.f(l(jsonReader, new a() { // from class: w2.c
                        @Override // w2.h.a
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
        b0.e.a.AbstractC0135a abstractC0135aA = b0.e.a.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            switch (strNextName) {
                case "identifier":
                    abstractC0135aA.e(jsonReader.nextString());
                    break;
                case "developmentPlatform":
                    abstractC0135aA.b(jsonReader.nextString());
                    break;
                case "developmentPlatformVersion":
                    abstractC0135aA.c(jsonReader.nextString());
                    break;
                case "version":
                    abstractC0135aA.g(jsonReader.nextString());
                    break;
                case "installationUuid":
                    abstractC0135aA.f(jsonReader.nextString());
                    break;
                case "displayVersion":
                    abstractC0135aA.d(jsonReader.nextString());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return abstractC0135aA.a();
    }

    public static b0.a k(JsonReader jsonReader) throws IOException {
        b0.a.b bVarA = b0.a.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            switch (strNextName) {
                case "buildIdMappingForArch":
                    bVarA.b(l(jsonReader, new a() { // from class: w2.a
                        @Override // w2.h.a
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

    public static b0.a.AbstractC0133a m(JsonReader jsonReader) throws IOException {
        b0.a.AbstractC0133a.AbstractC0134a abstractC0134aA = b0.a.AbstractC0133a.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            switch (strNextName) {
                case "libraryName":
                    abstractC0134aA.d(jsonReader.nextString());
                    break;
                case "arch":
                    abstractC0134aA.b(jsonReader.nextString());
                    break;
                case "buildId":
                    abstractC0134aA.c(jsonReader.nextString());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return abstractC0134aA.a();
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
        b0.e.d.a.AbstractC0136a abstractC0136aA = b0.e.d.a.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            switch (strNextName) {
                case "background":
                    abstractC0136aA.b(Boolean.valueOf(jsonReader.nextBoolean()));
                    break;
                case "execution":
                    abstractC0136aA.d(t(jsonReader));
                    break;
                case "internalKeys":
                    abstractC0136aA.e(l(jsonReader, new a() { // from class: w2.b
                        @Override // w2.h.a
                        public final Object a(JsonReader jsonReader2) {
                            return h.n(jsonReader2);
                        }
                    }));
                    break;
                case "customAttributes":
                    abstractC0136aA.c(l(jsonReader, new a() { // from class: w2.b
                        @Override // w2.h.a
                        public final Object a(JsonReader jsonReader2) {
                            return h.n(jsonReader2);
                        }
                    }));
                    break;
                case "uiOrientation":
                    abstractC0136aA.f(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return abstractC0136aA.a();
    }

    public static b0.e.d.a.b.AbstractC0137a r(JsonReader jsonReader) throws IOException {
        b0.e.d.a.b.AbstractC0137a.AbstractC0138a abstractC0138aA = b0.e.d.a.b.AbstractC0137a.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            switch (strNextName) {
                case "name":
                    abstractC0138aA.c(jsonReader.nextString());
                    break;
                case "size":
                    abstractC0138aA.d(jsonReader.nextLong());
                    break;
                case "uuid":
                    abstractC0138aA.f(Base64.decode(jsonReader.nextString(), 2));
                    break;
                case "baseAddress":
                    abstractC0138aA.b(jsonReader.nextLong());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return abstractC0138aA.a();
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
        b0.e.d.a.b.AbstractC0139b abstractC0139bA = b0.e.d.a.b.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            switch (strNextName) {
                case "appExitInfo":
                    abstractC0139bA.b(k(jsonReader));
                    break;
                case "threads":
                    abstractC0139bA.f(l(jsonReader, new a() { // from class: w2.e
                        @Override // w2.h.a
                        public final Object a(JsonReader jsonReader2) {
                            return h.y(jsonReader2);
                        }
                    }));
                    break;
                case "signal":
                    abstractC0139bA.e(x(jsonReader));
                    break;
                case "binaries":
                    abstractC0139bA.c(l(jsonReader, new a() { // from class: w2.f
                        @Override // w2.h.a
                        public final Object a(JsonReader jsonReader2) {
                            return h.r(jsonReader2);
                        }
                    }));
                    break;
                case "exception":
                    abstractC0139bA.d(u(jsonReader));
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return abstractC0139bA.a();
    }

    public static b0.e.d.a.b.c u(JsonReader jsonReader) throws IOException {
        b0.e.d.a.b.c.AbstractC0140a abstractC0140aA = b0.e.d.a.b.c.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            switch (strNextName) {
                case "frames":
                    abstractC0140aA.c(l(jsonReader, new g()));
                    break;
                case "reason":
                    abstractC0140aA.e(jsonReader.nextString());
                    break;
                case "type":
                    abstractC0140aA.f(jsonReader.nextString());
                    break;
                case "causedBy":
                    abstractC0140aA.b(u(jsonReader));
                    break;
                case "overflowCount":
                    abstractC0140aA.d(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return abstractC0140aA.a();
    }

    public static b0.e.d.a.b.AbstractC0143e.AbstractC0145b v(JsonReader jsonReader) throws IOException {
        b0.e.d.a.b.AbstractC0143e.AbstractC0145b.AbstractC0146a abstractC0146aA = b0.e.d.a.b.AbstractC0143e.AbstractC0145b.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            switch (strNextName) {
                case "offset":
                    abstractC0146aA.d(jsonReader.nextLong());
                    break;
                case "symbol":
                    abstractC0146aA.f(jsonReader.nextString());
                    break;
                case "pc":
                    abstractC0146aA.e(jsonReader.nextLong());
                    break;
                case "file":
                    abstractC0146aA.b(jsonReader.nextString());
                    break;
                case "importance":
                    abstractC0146aA.c(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return abstractC0146aA.a();
    }

    public static b0.e.d.AbstractC0147d w(JsonReader jsonReader) throws IOException {
        b0.e.d.AbstractC0147d.a aVarA = b0.e.d.AbstractC0147d.a();
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

    public static b0.e.d.a.b.AbstractC0141d x(JsonReader jsonReader) throws IOException {
        b0.e.d.a.b.AbstractC0141d.AbstractC0142a abstractC0142aA = b0.e.d.a.b.AbstractC0141d.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            switch (strNextName) {
                case "address":
                    abstractC0142aA.b(jsonReader.nextLong());
                    break;
                case "code":
                    abstractC0142aA.c(jsonReader.nextString());
                    break;
                case "name":
                    abstractC0142aA.d(jsonReader.nextString());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return abstractC0142aA.a();
    }

    public static b0.e.d.a.b.AbstractC0143e y(JsonReader jsonReader) throws IOException {
        b0.e.d.a.b.AbstractC0143e.AbstractC0144a abstractC0144aA = b0.e.d.a.b.AbstractC0143e.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            switch (strNextName) {
                case "frames":
                    abstractC0144aA.b(l(jsonReader, new g()));
                    break;
                case "name":
                    abstractC0144aA.d(jsonReader.nextString());
                    break;
                case "importance":
                    abstractC0144aA.c(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return abstractC0144aA.a();
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
            } catch (Throwable th) {
                try {
                    jsonReader.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IllegalStateException e10) {
            throw new IOException(e10);
        }
    }

    public String G(b0 b0Var) {
        return f13578a.b(b0Var);
    }

    public b0.e.d h(String str) throws IOException {
        try {
            JsonReader jsonReader = new JsonReader(new StringReader(str));
            try {
                b0.e.d dVarP = p(jsonReader);
                jsonReader.close();
                return dVarP;
            } catch (Throwable th) {
                try {
                    jsonReader.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IllegalStateException e10) {
            throw new IOException(e10);
        }
    }

    public String i(b0.e.d dVar) {
        return f13578a.b(dVar);
    }
}
