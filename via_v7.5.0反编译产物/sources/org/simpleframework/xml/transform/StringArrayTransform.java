package org.simpleframework.xml.transform;

import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
class StringArrayTransform implements Transform<String[]> {
    private final Pattern pattern;
    private final String token;

    public StringArrayTransform() {
        this(",");
    }

    public StringArrayTransform(String str) {
        this.pattern = Pattern.compile(str);
        this.token = str;
    }

    @Override // org.simpleframework.xml.transform.Transform
    public String[] read(String str) {
        return read(str, this.token);
    }

    @Override // org.simpleframework.xml.transform.Transform
    public String write(String[] strArr) {
        return write(strArr, this.token);
    }

    private String[] read(String str, String str2) {
        String[] strArrSplit = this.pattern.split(str);
        for (int i10 = 0; i10 < strArrSplit.length; i10++) {
            String str3 = strArrSplit[i10];
            if (str3 != null) {
                strArrSplit[i10] = str3.trim();
            }
        }
        return strArrSplit;
    }

    private String write(String[] strArr, String str) {
        StringBuilder sb2 = new StringBuilder();
        for (String str2 : strArr) {
            if (str2 != null) {
                if (sb2.length() > 0) {
                    sb2.append(str);
                    sb2.append(' ');
                }
                sb2.append(str2);
            }
        }
        return sb2.toString();
    }
}
