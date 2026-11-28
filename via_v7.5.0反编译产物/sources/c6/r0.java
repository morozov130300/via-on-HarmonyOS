package c6;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r0 f2099a = new r0();

    public final String a(String str, String str2) {
        String str3;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("<!DOCTYPE html><html><head><meta content=\"text/html; charset=utf-8\" http-equiv=\"Content-Type\"/><meta name=\"color-scheme\" content=\"light dark\"><meta name=\"viewport\" content=\"width=device-width, initial-scale=1, user-scalable=no, minimal-ui\">");
        if (str == null || str.length() == 0) {
            str3 = "";
        } else {
            str3 = "<title>" + str + "</title>";
        }
        sb2.append(str3);
        if (str2 == null || str2.length() == 0) {
            str2 = "";
        }
        sb2.append(str2);
        sb2.append("</head>");
        return sb2.toString();
    }
}
