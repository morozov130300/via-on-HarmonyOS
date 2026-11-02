package c8;

import android.content.Context;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class nc {
    public static String a(Context context) {
        return "javascript:(function(){__GET_VIDEO_FUNCTION__;var a=findVideoElement();return a?\"VIDEO\"!=a.tagName?\"0,1,16,9\":a.duration+\",\"+a.playbackRate+\",\"+a.videoWidth+\",\"+a.videoHeight:\"\"})();".replace("__GET_VIDEO_FUNCTION__", "function findVideoElement(){var a=null,b=document.fullscreenElement||document.mozFullScreenElement||document.webkitFullscreenElement||document.msFullscreenElement;b&&(a=\"VIDEO\"===b.tagName?b:firstVideoElement(b));a||(a=firstVideoElement(document));if(!a){b=document.getElementsByTagName(\"iframe\");for(var c=0,d=b.length;c<d&&!(a=b[c].contentDocument||b[c].contentWindow.document,a=firstVideoElement(a));c++);}return a?/game/i.test(a.className+\" \"+a.id)?null:a:null}\nfunction firstVideoElement(a){if(!a)return null;a=a.getElementsByTagName(\"video\");return 0>=a.length?null:a[0]};");
    }

    public static String b(Context context) {
        return "javascript:(function(){__GET_VIDEO_FUNCTION__;var a=findVideoElement();return a&&\"VIDEO\"==a.tagName?a.paused?1:2:0})();".replace("__GET_VIDEO_FUNCTION__", "function findVideoElement(){var a=null,b=document.fullscreenElement||document.mozFullScreenElement||document.webkitFullscreenElement||document.msFullscreenElement;b&&(a=\"VIDEO\"===b.tagName?b:firstVideoElement(b));a||(a=firstVideoElement(document));if(!a){b=document.getElementsByTagName(\"iframe\");for(var c=0,d=b.length;c<d&&!(a=b[c].contentDocument||b[c].contentWindow.document,a=firstVideoElement(a));c++);}return a?/game/i.test(a.className+\" \"+a.id)?null:a:null}\nfunction firstVideoElement(a){if(!a)return null;a=a.getElementsByTagName(\"video\");return 0>=a.length?null:a[0]};");
    }

    public static String c(Context context, int i10) {
        return "javascript:(function(){__GET_VIDEO_FUNCTION__;var b=findVideoElement();if(b)try{var a=__DELTA__+b.currentTime,c=b.duration;0>a?a=0:a>c&&(a=c);b.currentTime=a}catch(d){}})();".replace("__GET_VIDEO_FUNCTION__", "function findVideoElement(){var a=null,b=document.fullscreenElement||document.mozFullScreenElement||document.webkitFullscreenElement||document.msFullscreenElement;b&&(a=\"VIDEO\"===b.tagName?b:firstVideoElement(b));a||(a=firstVideoElement(document));if(!a){b=document.getElementsByTagName(\"iframe\");for(var c=0,d=b.length;c<d&&!(a=b[c].contentDocument||b[c].contentWindow.document,a=firstVideoElement(a));c++);}return a?/game/i.test(a.className+\" \"+a.id)?null:a:null}\nfunction firstVideoElement(a){if(!a)return null;a=a.getElementsByTagName(\"video\");return 0>=a.length?null:a[0]};").replace("__DELTA__", String.valueOf(i10));
    }

    public static String d(Context context) {
        return "javascript:(function(){__GET_VIDEO_FUNCTION__;var a=findVideoElement();if(a)try{var b=!a.paused;b?a.pause():a.play();return b?1:2}catch(c){}return 0})();".replace("__GET_VIDEO_FUNCTION__", "function findVideoElement(){var a=null,b=document.fullscreenElement||document.mozFullScreenElement||document.webkitFullscreenElement||document.msFullscreenElement;b&&(a=\"VIDEO\"===b.tagName?b:firstVideoElement(b));a||(a=firstVideoElement(document));if(!a){b=document.getElementsByTagName(\"iframe\");for(var c=0,d=b.length;c<d&&!(a=b[c].contentDocument||b[c].contentWindow.document,a=firstVideoElement(a));c++);}return a?/game/i.test(a.className+\" \"+a.id)?null:a:null}\nfunction firstVideoElement(a){if(!a)return null;a=a.getElementsByTagName(\"video\");return 0>=a.length?null:a[0]};");
    }

    public static String e(Context context, float f10) {
        return "javascript:(function(){__GET_VIDEO_FUNCTION__;var a=findVideoElement();if(a)try{a.playbackRate=__RATE__}catch(b){}})();".replace("__GET_VIDEO_FUNCTION__", "function findVideoElement(){var a=null,b=document.fullscreenElement||document.mozFullScreenElement||document.webkitFullscreenElement||document.msFullscreenElement;b&&(a=\"VIDEO\"===b.tagName?b:firstVideoElement(b));a||(a=firstVideoElement(document));if(!a){b=document.getElementsByTagName(\"iframe\");for(var c=0,d=b.length;c<d&&!(a=b[c].contentDocument||b[c].contentWindow.document,a=firstVideoElement(a));c++);}return a?/game/i.test(a.className+\" \"+a.id)?null:a:null}\nfunction firstVideoElement(a){if(!a)return null;a=a.getElementsByTagName(\"video\");return 0>=a.length?null:a[0]};").replace("__RATE__", String.valueOf(f10));
    }
}
