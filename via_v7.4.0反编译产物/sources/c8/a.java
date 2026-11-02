package c8;

import android.content.Context;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class a {
    public static String a(Context context, String str, String str2) {
        return "javascript:(function(){function d(a,b){var c=new FileReader;c.readAsDataURL(b);c.onloadend=function(){window.via.download(\"__SECRET__\",a,c.result)}}function e(a){var b=new XMLHttpRequest;b.open(\"GET\",a,!0);b.responseType=\"blob\";b.onload=function(c){200==this.status&&d(a,this.response)};b.send()}key=\"via-blob-test\";(function(a){window[key]&&window[key][a]?d(a,window[key][a]):e(a)})(\"__BLOB_URL__\")})();".replace("__SECRET__", str).replace("__BLOB_URL__", str2);
    }

    public static String b(Context context) {
        return "(function(){if(!window[\"via-blob-test\"]){window[\"via-blob-test\"]={};var c=URL.createObjectURL;URL.createObjectURL=function(a){var b=c(a);a instanceof MediaSource||(window[\"via-blob-test\"][b]=a);return b}}})();";
    }
}
