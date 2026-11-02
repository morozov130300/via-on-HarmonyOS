package j8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class u {
    public static List a(String str) {
        if (str == null || str.length() < 2 || "[]".equals(str)) {
            return Collections.EMPTY_LIST;
        }
        try {
            JSONArray jSONArray = new JSONArray(c(str.replace("\u200b", "")));
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            for (int i10 = 0; i10 < length; i10++) {
                String strTrim = jSONArray.optString(i10).trim();
                if (!strTrim.isEmpty()) {
                    if (strTrim.length() < 256) {
                        arrayList.add(strTrim);
                    } else {
                        arrayList.addAll(b(strTrim));
                    }
                }
            }
            return arrayList;
        } catch (JSONException e10) {
            pc.a.b(e10);
            return Collections.EMPTY_LIST;
        }
    }

    public static List b(String str) {
        String str2;
        int length;
        if (str == null || str.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        String[] strArr = {"\u201d", "\u300d", "\u3002", "\uff0c", "\uff1b", "\uff1f", "\uff01", ". ", ", ", "; ", "? ", "! ", "} ", " ", "."};
        int length2 = 0;
        int i10 = 0;
        while (true) {
            if (i10 >= 15) {
                str2 = null;
                length = 0;
                break;
            }
            str2 = strArr[i10];
            if (str.contains(str2)) {
                length = str2.length();
                break;
            }
            i10++;
        }
        ArrayList arrayList = new ArrayList();
        int length3 = str.length();
        if (str2 == null) {
            while (length2 < length3) {
                String strSubstring = str.substring(length2, Math.min(length2 + 256, length3));
                length2 += strSubstring.length();
                arrayList.add(strSubstring.trim());
            }
        } else {
            int length4 = 0;
            while (true) {
                if (length2 >= length3) {
                    break;
                }
                int iIndexOf = str.indexOf(str2, length2);
                if (iIndexOf < 0) {
                    while (length2 < length3) {
                        String strSubstring2 = str.substring(length4, Math.min(length4 + 256, length3));
                        length4 += strSubstring2.length();
                        arrayList.add(strSubstring2.trim());
                        length2 = length4;
                    }
                } else {
                    int i11 = iIndexOf - length4;
                    if (i11 >= 256) {
                        length2 = length4 + 256;
                        arrayList.add(str.substring(length4, length2).trim());
                    } else if (i11 >= 64) {
                        length2 = iIndexOf + length;
                        arrayList.add(str.substring(length4, length2).trim());
                    } else {
                        length2 = iIndexOf + length;
                    }
                    length4 = length2;
                }
            }
        }
        return arrayList;
    }

    public static String c(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        HashMap map = new HashMap();
        for (int i10 = 0; i10 < 214; i10++) {
            map.put(Integer.valueOf("\u2f00\u2f01\u2f02\u2f03\u2f04\u2f05\u2f06\u2f07\u2f08\u2f09\u2f0a\u2f0b\u2f0c\u2f0d\u2f0e\u2f0f\u2f10\u2f11\u2f12\u2f13\u2f14\u2f15\u2f16\u2f17\u2f18\u2f19\u2f1a\u2f1b\u2f1c\u2f1d\u2f1e\u2f1f\u2f20\u2f21\u2f22\u2f23\u2f24\u2f25\u2f26\u2f27\u2f28\u2f29\u2f2a\u2f2b\u2f2c\u2f2d\u2f2e\u2f2f\u2f30\u2f31\u2f32\u2f33\u2f34\u2f35\u2f36\u2f37\u2f38\u2f39\u2f3a\u2f3b\u2f3c\u2f3d\u2f3e\u2f3f\u2f40\u2f41\u2f42\u2f43\u2f44\u2f45\u2f46\u2f47\u2f48\u2f49\u2f4a\u2f4b\u2f4c\u2f4d\u2f4e\u2f4f\u2f50\u2f51\u2f52\u2f53\u2f54\u2f55\u2f56\u2f57\u2f58\u2f59\u2f5a\u2f5b\u2f5c\u2f5d\u2f5e\u2f5f\u2f60\u2f61\u2f62\u2f63\u2f64\u2f65\u2f66\u2f67\u2f68\u2f69\u2f6a\u2f6b\u2f6c\u2f6d\u2f6e\u2f6f\u2f70\u2f71\u2f72\u2f73\u2f74\u2f75\u2f76\u2f77\u2f78\u2f79\u2f7a\u2f7b\u2f7c\u2f7d\u2f7e\u2f7f\u2f80\u2f81\u2f82\u2f83\u2f84\u2f85\u2f86\u2f87\u2f88\u2f89\u2f8a\u2f8b\u2f8c\u2f8d\u2f8e\u2f8f\u2f90\u2f91\u2f92\u2f93\u2f94\u2f95\u2f96\u2f97\u2f98\u2f99\u2f9a\u2f9b\u2f9c\u2f9d\u2f9e\u2f9f\u2fa0\u2fa1\u2fa2\u2fa3\u2fa4\u2fa5\u2fa6\u2fa7\u2fa8\u2fa9\u2faa\u2fab\u2fac\u2fad\u2fae\u2faf\u2fb0\u2fb1\u2fb2\u2fb3\u2fb4\u2fb5\u2fb6\u2fb7\u2fb8\u2fb9\u2fba\u2fbb\u2fbc\u2fbd\u2fbe\u2fbf\u2fc0\u2fc1\u2fc2\u2fc3\u2fc4\u2fc5\u2fc6\u2fc7\u2fc8\u2fc9\u2fca\u2fcb\u2fcc\u2fcd\u2fce\u2fcf\u2fd0\u2fd1\u2fd2\u2fd3\u2fd4\u2fd5".codePointAt(i10)), Integer.valueOf("\u4e00\u4e28\u4e36\u4e3f\u4e59\u4e85\u4e8c\u4ea0\u4eba\u513f\u5165\u516b\u5182\u5196\u51ab\u51e0\u51f5\u5200\u529b\u52f9\u5315\u531a\u5338\u5341\u535c\u5369\u5382\u53b6\u53c8\u53e3\u53e3\u571f\u58eb\u5902\u590a\u5915\u5927\u5973\u5b50\u5b80\u5bf8\u5c0f\u5c22\u5c38\u5c6e\u5c71\u5ddb\u5de5\u5df1\u5dfe\u5e72\u5e7a\u5e7f\u5ef4\u5efe\u5f0b\u5f13\u5f50\u5f61\u5f73\u5fc3\u6208\u6237\u624b\u652f\u6534\u6587\u6597\u65a4\u65b9\u65e0\u65e5\u66f0\u6708\u6728\u6b20\u6b62\u6b79\u6bb3\u6bcb\u6bd4\u6bdb\u6c0f\u6c14\u6c34\u706b\u722a\u7236\u723b\u723f\u7247\u7259\u725b\u72ac\u7384\u7389\u74dc\u74e6\u7518\u751f\u7528\u7530\u758b\u7592\u7676\u767d\u76ae\u76bf\u76ee\u77db\u77e2\u77f3\u793a\u79b8\u79be\u7a74\u7acb\u7af9\u7c73\u7cf8\u7f36\u7f51\u7f8a\u7fbd\u8001\u800c\u8012\u8033\u807f\u8089\u81e3\u81ea\u81f3\u81fc\u820c\u821b\u821f\u826e\u8272\u8278\u864d\u866b\u8840\u884c\u8863\u897e\u898b\u89d2\u8a00\u8c37\u8c46\u8c55\u8c78\u8c9d\u8d64\u8d70\u8db3\u8eab\u8eca\u8f9b\u8fb0\u8fb5\u9091\u9149\u91c7\u91cc\u91d1\u9577\u9580\u961c\u96b6\u96b9\u96e8\u9752\u975e\u9762\u9769\u97cb\u97ed\u97f3\u9801\u98a8\u98db\u98df\u9996\u9999\u99ac\u9aa8\u9ad8\u9adf\u9b25\u9b2f\u9b32\u9b3c\u9b5a\u9ce5\u9e75\u9e7f\u9ea5\u9ebb\u9ec3\u9ecd\u9ed1\u9ef9\u9efd\u9f0e\u9f13\u9f20\u9f3b\u9f4a\u9f52\u9f8d\u9f9c\u9fa0".codePointAt(i10)));
        }
        int length = str.length();
        StringBuilder sb2 = null;
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12++) {
            Integer num = (Integer) map.get(Integer.valueOf(str.codePointAt(i12)));
            if (num != null) {
                if (sb2 == null) {
                    sb2 = new StringBuilder();
                }
                sb2.append(str.substring(i11, i12));
                sb2.append(Character.toChars(num.intValue()));
                i11 = i12 + 1;
            }
        }
        if (i11 > 0) {
            sb2.append(str.substring(i11));
        }
        return sb2 == null ? str : sb2.toString();
    }
}
