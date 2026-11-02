package l5;

import android.webkit.MimeTypeMap;
import java.util.Arrays;
import java.util.Locale;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f8400a = {"aac", "audio/aac", "abw", "application/x-abiword", "apk", "application/vnd.android.package-archive", "xapk", "application/xapk-package-archive", "arc", "application/x-freearc", "asf", "video/x-ms-asf", "avi", "video/x-msvideo", "azw", "application/vnd.amazon.ebook", "bin", "application/octet-stream", "bmp", "image/bmp", "bz", "application/x-bzip", "bz2", "application/x-bzip2", "bzip2", "application/x-bzip2", "csh", "application/x-csh", "css", "text/css", "csv", "text/csv", "doc", "application/msword", "docx", "application/vnd.openxmlformats-officedocument.wordprocessingml.document", "eot", "application/vnd.ms-fontobject", "epub", "application/epub+zip", "exe", "application/octet-stream", "gif", "image/gif", "gtar", "application/x-gtar", "gz", "application/x-gzip", "htm", "text/html", "html", "text/html", "mht", "multipart/related", "ico", "image/vnd.microsoft.icon", "ics", "text/calendar", "jar", "application/java-archive", "jpeg", "image/jpeg", "jpg", "image/jpeg", "js", "text/javascript", "json", "application/json", "jsonld", "application/ld+json", "mid", "audio/midi", "midi", "audio/x-midi", "mjs", "text/javascript", "mov", "video/quicktime", "mpc", "application/vnd.mpohun.certificate", "mpe", "video/mpeg", "mpeg", "video/mpeg", "mpg", "video/mpeg", "mpga", "audio/mpeg", "mp4", "video/mp4", "mpkg", "application/vnd.apple.installer+xml", "mp2", "audio/x-mpeg", "mp3", "audio/mpeg", "mp4", "video/mp4", "m3u", "audio/x-mpegurl", "m4a", "audio/mp4a-latm", "m4b", "audio/mp4a-latm", "m4p", "audio/mp4a-latm", "m4u", "video/vnd.mpegurl", "m4v", "video/x-m4v", "odp", "application/vnd.oasis.opendocument.presentation", "ods", "application/vnd.oasis.opendocument.spreadsheet", "odt", "application/vnd.oasis.opendocument.text", "oga", "audio/ogg", "ogg", "audio/ogg", "ogv", "video/ogg", "ogx", "application/ogg", "otf", "font/otf", "png", "image/png", "pdf", "application/pdf", "pps", "application/vnd.ms-powerpoint", "ppt", "application/vnd.ms-powerpoint", "pptx", "application/vnd.openxmlformats-officedocument.presentationml.presentation", "rar", "application/x-rar-compressed", "rmvb", "audio/x-pn-realaudio", "rtf", "application/rtf", "sh", "application/x-sh", "svg", "image/svg+xml", "swf", "application/x-shockwave-flash", "tar", "application/x-tar", "tgz", "application/x-compressed", "tif", "image/tiff", "tiff", "image/tiff", "torrent", "application/x-bittorrent", "ttf", "font/ttf", "txt", "text/plain", "vsd", "application/vnd.visio", "wav", "audio/wav", "weba", "audio/webm", "webm", "video/webm", "webp", "image/webp", "wma", "audio/x-ms-wma", "wmv", "audio/x-ms-wmv", "woff", "font/woff", "woff2", "font/woff2", "wps", "application/vnd.ms-works", "xhtml", "application/xhtml+xml", "xls", "application/vnd.ms-excel", "xlsx", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", "xml", "text/xml", "xul", "application/vnd.mozilla.xul+xml", "z", "application/x-compress", "zip", "application/zip", "3gp", "video/3gpp", "3g2", "video/3gpp2", "7z", "application/x-7z-compressed"};

    public static String a(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        for (byte b10 : bArr) {
            String hexString = Integer.toHexString(b10 & 255);
            if (hexString.length() < 2) {
                sb2.append(0);
            }
            sb2.append(hexString);
        }
        return sb2.toString().toUpperCase(Locale.ROOT);
    }

    public static String b(String str) {
        if (str != null && !str.isEmpty()) {
            int iF = f(str);
            if (iF > 0) {
                return f8400a[iF - 1];
            }
            try {
                return MimeTypeMap.getSingleton().getExtensionFromMimeType(str);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static String c(String str, String str2) {
        String mimeTypeFromExtension;
        if (str == null || str.isEmpty()) {
            return str2;
        }
        int iE = e(str);
        if (iE > 0) {
            return f8400a[iE + 1];
        }
        try {
            mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str);
        } catch (Exception unused) {
            mimeTypeFromExtension = null;
        }
        return mimeTypeFromExtension != null ? mimeTypeFromExtension : str2;
    }

    public static String d(byte[] bArr) {
        if (bArr != null && bArr.length > 0) {
            String strA = a(Arrays.copyOf(bArr, 4));
            if (strA.contains("FFD8FF")) {
                return "image/jpeg";
            }
            if (strA.contains("89504E47")) {
                return "image/png";
            }
            if (strA.contains("47494638")) {
                return "image/gif";
            }
            if (strA.contains("49492A00")) {
                return "image/tiff";
            }
            if (strA.contains("424D")) {
                return "image/bmp";
            }
            if (strA.contains("504B0304")) {
                return "application/zip";
            }
            if (strA.contains("52617221")) {
                return "application/x-rar-compressed";
            }
        }
        return null;
    }

    public static int e(String str) {
        if (str != null && !str.isEmpty()) {
            String lowerCase = str.toLowerCase(Locale.ROOT);
            int length = f8400a.length / 2;
            for (int i10 = 0; i10 < length; i10++) {
                int i11 = i10 * 2;
                if (f8400a[i11].equals(lowerCase)) {
                    return i11;
                }
            }
        }
        return -1;
    }

    public static int f(String str) {
        if (str != null && !str.isEmpty()) {
            String lowerCase = str.toLowerCase(Locale.ROOT);
            int length = f8400a.length / 2;
            for (int i10 = 0; i10 < length; i10++) {
                int i11 = (i10 * 2) + 1;
                if (f8400a[i11].equals(lowerCase)) {
                    return i11;
                }
            }
        }
        return -1;
    }

    public static boolean g(String str) {
        return e(str) >= 0;
    }
}
