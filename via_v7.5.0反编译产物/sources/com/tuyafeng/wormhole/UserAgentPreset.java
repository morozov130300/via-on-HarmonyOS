package com.tuyafeng.wormhole;

import java.util.Iterator;
import kotlin.jvm.internal.f;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public enum UserAgentPreset {
    DEFAULT(0, null),
    ANDROID_PHONE(-1, "Mozilla/5.0 (Linux; Android 13; Pixel 7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/148.0.0.0 Mobile Safari/537.36"),
    ANDROID_TABLET(-2, "Mozilla/5.0 (Linux; Android 8.1.0; SM-T837A) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/148.0.0.0 Safari/537.36"),
    WINDOWS_CHROME(-3, "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/148.0.0.0 Safari/537.36"),
    WINDOWS_IE(-4, "Mozilla/5.0 (Windows NT 10.0; Trident/7.0; rv:11.0) like Gecko"),
    OSX_CHROME(-5, "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/148.0.0.0 Safari/537.36"),
    IPHONE(-6, "Mozilla/5.0 (iPhone; CPU iPhone OS 18_5 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/18.5 Mobile/15E148 Safari/604.1"),
    IPAD(-7, "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/18.5 Safari/605.1.15"),
    SYMBIAN(-8, "Mozilla/5.0 (Symbian/3; Series60/5.2 NokiaN8-00/012.002; Profile/MIDP-2.1 Configuration/CLDC-1.1 ) AppleWebKit/533.4 (KHTML, like Gecko) NokiaBrowser/7.3.0 Mobile Safari/533.4 3gpp-gba");

    private final int presetId;
    private final String userAgent;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ j7.a f3791e = kotlin.enums.a.a(a());
    public static final a Companion = new a(null);

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a {
        public /* synthetic */ a(f fVar) {
            this();
        }

        public final UserAgentPreset a(int i10) {
            Object next;
            Iterator<E> it = UserAgentPreset.getEntries().iterator();
            while (it.hasNext()) {
                next = it.next();
                if (((UserAgentPreset) next).getPresetId() == i10) {
                    return (UserAgentPreset) next;
                }
            }
            next = null;
            return (UserAgentPreset) next;
        }

        public a() {
        }
    }

    UserAgentPreset(int i10, String str) {
        this.presetId = i10;
        this.userAgent = str;
    }

    public static j7.a getEntries() {
        return f3791e;
    }

    public final int getPresetId() {
        return this.presetId;
    }

    public final String getUserAgent() {
        return this.userAgent;
    }
}
