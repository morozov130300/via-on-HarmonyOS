package s0;

import android.content.pm.PackageInfo;
import android.os.Build;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s0.a.b f12151a = new s0.a.b("VISUAL_STATE_CALLBACK", "VISUAL_STATE_CALLBACK");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final s0.a.b f12153b = new s0.a.b("OFF_SCREEN_PRERASTER", "OFF_SCREEN_PRERASTER");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final s0.a.f f12155c = new s0.a.f("SAFE_BROWSING_ENABLE", "SAFE_BROWSING_ENABLE");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final s0.a.c f12157d = new s0.a.c("DISABLED_ACTION_MODE_MENU_ITEMS", "DISABLED_ACTION_MODE_MENU_ITEMS");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final s0.a.g f12159e = new s0.a.g("START_SAFE_BROWSING", "START_SAFE_BROWSING");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final s0.a.g f12161f = new s0.a.g("SAFE_BROWSING_WHITELIST", "SAFE_BROWSING_WHITELIST");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final s0.a.g f12163g = new s0.a.g("SAFE_BROWSING_WHITELIST", "SAFE_BROWSING_ALLOWLIST");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final s0.a.g f12165h = new s0.a.g("SAFE_BROWSING_ALLOWLIST", "SAFE_BROWSING_WHITELIST");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final s0.a.g f12167i = new s0.a.g("SAFE_BROWSING_ALLOWLIST", "SAFE_BROWSING_ALLOWLIST");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final s0.a.g f12169j = new s0.a.g("SAFE_BROWSING_PRIVACY_POLICY_URL", "SAFE_BROWSING_PRIVACY_POLICY_URL");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final s0.a.c f12171k = new s0.a.c("SERVICE_WORKER_BASIC_USAGE", "SERVICE_WORKER_BASIC_USAGE");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final s0.a.c f12173l = new s0.a.c("SERVICE_WORKER_CACHE_MODE", "SERVICE_WORKER_CACHE_MODE");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final s0.a.c f12175m = new s0.a.c("SERVICE_WORKER_CONTENT_ACCESS", "SERVICE_WORKER_CONTENT_ACCESS");

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final s0.a.c f12177n = new s0.a.c("SERVICE_WORKER_FILE_ACCESS", "SERVICE_WORKER_FILE_ACCESS");

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final s0.a.c f12179o = new s0.a.c("SERVICE_WORKER_BLOCK_NETWORK_LOADS", "SERVICE_WORKER_BLOCK_NETWORK_LOADS");

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final s0.a.c f12181p = new s0.a.c("SERVICE_WORKER_SHOULD_INTERCEPT_REQUEST", "SERVICE_WORKER_SHOULD_INTERCEPT_REQUEST");

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final s0.a.b f12183q = new s0.a.b("RECEIVE_WEB_RESOURCE_ERROR", "RECEIVE_WEB_RESOURCE_ERROR");

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final s0.a.b f12185r = new s0.a.b("RECEIVE_HTTP_ERROR", "RECEIVE_HTTP_ERROR");

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final s0.a.c f12187s = new s0.a.c("SHOULD_OVERRIDE_WITH_REDIRECTS", "SHOULD_OVERRIDE_WITH_REDIRECTS");

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final s0.a.g f12189t = new s0.a.g("SAFE_BROWSING_HIT", "SAFE_BROWSING_HIT");

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final s0.a.c f12191u = new s0.a.c("WEB_RESOURCE_REQUEST_IS_REDIRECT", "WEB_RESOURCE_REQUEST_IS_REDIRECT");

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final s0.a.b f12193v = new s0.a.b("WEB_RESOURCE_ERROR_GET_DESCRIPTION", "WEB_RESOURCE_ERROR_GET_DESCRIPTION");

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final s0.a.b f12195w = new s0.a.b("WEB_RESOURCE_ERROR_GET_CODE", "WEB_RESOURCE_ERROR_GET_CODE");

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final s0.a.g f12197x = new s0.a.g("SAFE_BROWSING_RESPONSE_BACK_TO_SAFETY", "SAFE_BROWSING_RESPONSE_BACK_TO_SAFETY");

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final s0.a.g f12199y = new s0.a.g("SAFE_BROWSING_RESPONSE_PROCEED", "SAFE_BROWSING_RESPONSE_PROCEED");

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final s0.a.g f12201z = new s0.a.g("SAFE_BROWSING_RESPONSE_SHOW_INTERSTITIAL", "SAFE_BROWSING_RESPONSE_SHOW_INTERSTITIAL");
    public static final s0.a.b A = new s0.a.b("WEB_MESSAGE_PORT_POST_MESSAGE", "WEB_MESSAGE_PORT_POST_MESSAGE");
    public static final s0.a.b B = new s0.a.b("WEB_MESSAGE_PORT_CLOSE", "WEB_MESSAGE_PORT_CLOSE");
    public static final s0.a.d C = new s0.a.d("WEB_MESSAGE_ARRAY_BUFFER", "WEB_MESSAGE_ARRAY_BUFFER");
    public static final s0.a.b D = new s0.a.b("WEB_MESSAGE_PORT_SET_MESSAGE_CALLBACK", "WEB_MESSAGE_PORT_SET_MESSAGE_CALLBACK");
    public static final s0.a.b E = new s0.a.b("CREATE_WEB_MESSAGE_CHANNEL", "CREATE_WEB_MESSAGE_CHANNEL");
    public static final s0.a.b F = new s0.a.b("POST_WEB_MESSAGE", "POST_WEB_MESSAGE");
    public static final s0.a.b G = new s0.a.b("WEB_MESSAGE_CALLBACK_ON_MESSAGE", "WEB_MESSAGE_CALLBACK_ON_MESSAGE");
    public static final s0.a.f H = new s0.a.f("GET_WEB_VIEW_CLIENT", "GET_WEB_VIEW_CLIENT");
    public static final s0.a.f I = new s0.a.f("GET_WEB_CHROME_CLIENT", "GET_WEB_CHROME_CLIENT");
    public static final s0.a.i J = new s0.a.i("GET_WEB_VIEW_RENDERER", "GET_WEB_VIEW_RENDERER");
    public static final s0.a.i K = new s0.a.i("WEB_VIEW_RENDERER_TERMINATE", "WEB_VIEW_RENDERER_TERMINATE");
    public static final s0.a.h L = new s0.a.h("TRACING_CONTROLLER_BASIC_USAGE", "TRACING_CONTROLLER_BASIC_USAGE");
    public static final o.b M = new o.b("STARTUP_FEATURE_SET_DATA_DIRECTORY_SUFFIX", "STARTUP_FEATURE_SET_DATA_DIRECTORY_SUFFIX");
    public static final o.a N = new o.a("STARTUP_FEATURE_SET_DIRECTORY_BASE_PATHS", "STARTUP_FEATURE_SET_DIRECTORY_BASE_PATH");
    public static final o.a O = new o.a("STARTUP_FEATURE_CONFIGURE_PARTITIONED_COOKIES", "STARTUP_FEATURE_CONFIGURE_PARTITIONED_COOKIES");
    public static final s0.a.i P = new s0.a.i("WEB_VIEW_RENDERER_CLIENT_BASIC_USAGE", "WEB_VIEW_RENDERER_CLIENT_BASIC_USAGE");
    public static final s0.a.j Q = new a("ALGORITHMIC_DARKENING", "ALGORITHMIC_DARKENING");
    public static final s0.a.d R = new s0.a.d("PROXY_OVERRIDE", "PROXY_OVERRIDE:3");
    public static final s0.a.d S = new s0.a.d("MULTI_PROCESS", "MULTI_PROCESS_QUERY");
    public static final s0.a.i T = new s0.a.i("FORCE_DARK", "FORCE_DARK");
    public static final s0.a.d U = new s0.a.d("FORCE_DARK_STRATEGY", "FORCE_DARK_BEHAVIOR");
    public static final s0.a.d V = new s0.a.d("WEB_MESSAGE_LISTENER", "WEB_MESSAGE_LISTENER");
    public static final s0.a.d W = new s0.a.d("DOCUMENT_START_SCRIPT", "DOCUMENT_START_SCRIPT:1");
    public static final s0.a.d X = new s0.a.d("PROXY_OVERRIDE_REVERSE_BYPASS", "PROXY_OVERRIDE_REVERSE_BYPASS");
    public static final s0.a.d Y = new s0.a.d("GET_VARIATIONS_HEADER", "GET_VARIATIONS_HEADER");
    public static final s0.a.d Z = new s0.a.d("ENTERPRISE_AUTHENTICATION_APP_LINK_POLICY", "ENTERPRISE_AUTHENTICATION_APP_LINK_POLICY");

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final s0.a.d f12152a0 = new s0.a.d("GET_COOKIE_INFO", "GET_COOKIE_INFO");

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final s0.a.d f12154b0 = new s0.a.d("REQUESTED_WITH_HEADER_ALLOW_LIST", "REQUESTED_WITH_HEADER_ALLOW_LIST");

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final s0.a.d f12156c0 = new s0.a.d("USER_AGENT_METADATA", "USER_AGENT_METADATA");

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final s0.a.d f12158d0 = new b("USER_AGENT_METADATA_FORM_FACTORS", "USER_AGENT_METADATA");

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final s0.a.d f12160e0 = new c("MULTI_PROFILE", "MULTI_PROFILE");

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public static final s0.a.d f12162f0 = new s0.a.d("ATTRIBUTION_REGISTRATION_BEHAVIOR", "ATTRIBUTION_BEHAVIOR");

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public static final s0.a.d f12164g0 = new s0.a.d("WEBVIEW_MEDIA_INTEGRITY_API_STATUS", "WEBVIEW_INTEGRITY_API_STATUS");

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public static final s0.a.d f12166h0 = new s0.a.d("MUTE_AUDIO", "MUTE_AUDIO");

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public static final s0.a.d f12168i0 = new s0.a.d("WEB_AUTHENTICATION", "WEB_AUTHENTICATION");

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public static final s0.a.d f12170j0 = new s0.a.d("SPECULATIVE_LOADING_STATUS", "SPECULATIVE_LOADING");

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final s0.a.d f12172k0 = new s0.a.d("BACK_FORWARD_CACHE", "BACK_FORWARD_CACHE");

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public static final s0.a.d f12174l0 = new s0.a.d("BACK_FORWARD_CACHE_SETTINGS", "BACK_FORWARD_CACHE_SETTINGS");

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public static final s0.a.d f12176m0 = new s0.a.d("BACK_FORWARD_CACHE_SETTINGS_EXPERIMENTAL_V3", "BACK_FORWARD_CACHE_SETTINGS_V3");

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public static final s0.a.d f12178n0 = new s0.a.d("BACK_FORWARD_CACHE_SETTINGS_EXPERIMENTAL_V4", "BACK_FORWARD_CACHE_SETTINGS_V4");

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public static final s0.a.d f12180o0 = new s0.a.d("DELETE_BROWSING_DATA", "WEB_STORAGE_DELETE_BROWSING_DATA");

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public static final s0.a.d f12182p0 = new d("PREFETCH_URL_V5", "PREFETCH_URL_V5");

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public static final s0.a.e f12184q0 = new s0.a.e("ASYNC_WEBVIEW_STARTUP_V2");

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public static final s0.a.e f12186r0 = new s0.a.e("ASYNC_WEBVIEW_STARTUP");

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public static final s0.a.e f12188s0 = new s0.a.e("ASYNC_WEBVIEW_STARTUP_ASYNC_STARTUP_LOCATIONS");

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public static final s0.a.d f12190t0 = new s0.a.d("DEFAULT_TRAFFICSTATS_TAGGING", "DEFAULT_TRAFFICSTATS_TAGGING");

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public static final s0.a.d f12192u0 = new s0.a.d("PRERENDER_URL_V2", "PRERENDER_URL_V3");

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public static final s0.a.d f12194v0 = new s0.a.d("SPECULATIVE_LOADING_CONFIG_V2", "SPECULATIVE_LOADING_CONFIG_V2");

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public static final s0.a.d f12196w0 = new s0.a.d("PREFETCH_CACHE_V1", "PREFETCH_CACHE_V1");

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public static final s0.a.d f12198x0 = new s0.a.d("SET_MAX_PRERENDERS_V1", "SET_MAX_PRERENDERS_V1");

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public static final s0.a.d f12200y0 = new s0.a.d("SAVE_STATE", "SAVE_STATE");

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public static final s0.a.d f12202z0 = new s0.a.d("NAVIGATION_GET_WEB_RESOURCE_ERROR", "NAVIGATION_GET_WEB_RESOURCE_ERROR");
    public static final s0.a.d A0 = new s0.a.d("NAVIGATION_LISTENER", "PAGE_GET_URL");
    public static final s0.a.d B0 = new s0.a.d("PROVIDER_WEAKLY_REF_WEBVIEW", "PROVIDER_WEAKLY_REF_WEBVIEW");
    public static final s0.a.d C0 = new s0.a.d("PAYMENT_REQUEST", "PAYMENT_REQUEST");
    public static final s0.a.d D0 = new s0.a.d("WEBVIEW_BUILDER_EXPERIMENTAL_V1", "WEBVIEW_BUILDER_V1");
    public static final s0.a.d E0 = new s0.a.d("WEBVIEW_BUILDER_EXPERIMENTAL_V2", "WEBVIEW_BUILDER_V2");
    public static final s0.a.d F0 = new s0.a.d("COOKIE_INTERCEPT", "COOKIE_INTERCEPT");
    public static final s0.a.d G0 = new s0.a.d("WARM_UP_RENDERER_PROCESS", "WARM_UP_RENDERER_PROCESS");
    public static final s0.a.d H0 = new s0.a.d("ORIGIN_MATCHED_HEADERS", "EXTRA_HEADER_FOR_ORIGINS");
    public static final s0.a.d I0 = new s0.a.d("CUSTOM_REQUEST_HEADERS", "CUSTOM_REQUEST_HEADERS");
    public static final o.a J0 = new o.a("STARTUP_FEATURE_SET_PROFILES_TO_LOAD", "STARTUP_FEATURE_SET_PROFILES_TO_LOAD");
    public static final o.a K0 = new o.a("STARTUP_FEATURE_SET_UI_THREAD_STARTUP_MODE", "STARTUP_FEATURE_SET_UI_THREAD_STARTUP_MODE");
    public static final o.a L0 = new o.a("STARTUP_FEATURE_SET_UI_THREAD_STARTUP_MODE_V2", "STARTUP_FEATURE_SET_UI_THREAD_STARTUP_MODE_V2");
    public static final s0.a.d M0 = new s0.a.d("PRECONNECT", "PRECONNECT");
    public static final s0.a.d N0 = new s0.a.d("ADD_QUIC_HINTS", "ADD_QUIC_HINTS_V1");
    public static final s0.a.d O0 = new s0.a.d("HYPERLINK_CONTEXT_MENU_ITEMS", "HYPERLINK_CONTEXT_MENU_ITEMS");
    public static final s0.a.d P0 = new s0.a.d("JS_INJECTION_IN_FRAME_AND_WORLD", "JS_INJECTION_IN_FRAME_AND_WORLD");

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends s0.a.j {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Pattern f12203d;

        public a(String str, String str2) {
            super(str, str2);
            this.f12203d = Pattern.compile("\\A\\d+");
        }

        @Override // s0.a
        public boolean d() {
            boolean zD = super.d();
            if (!zD || Build.VERSION.SDK_INT >= 29) {
                return zD;
            }
            PackageInfo packageInfoF = r0.k.f();
            if (packageInfoF == null) {
                return false;
            }
            Matcher matcher = this.f12203d.matcher(packageInfoF.versionName);
            return matcher.find() && Integer.parseInt(packageInfoF.versionName.substring(matcher.start(), matcher.end())) >= 105;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b extends s0.a.d {
        public b(String str, String str2) {
            super(str, str2);
        }

        @Override // s0.a
        public boolean d() {
            PackageInfo packageInfoF;
            return super.d() && (packageInfoF = r0.k.f()) != null && p.a.a(packageInfoF) >= 636700000;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class c extends s0.a.d {
        public c(String str, String str2) {
            super(str, str2);
        }

        @Override // s0.a
        public boolean d() {
            if (super.d() && r0.l.a("MULTI_PROCESS")) {
                return r0.k.k();
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class d extends s0.a.d {
        public d(String str, String str2) {
            super(str, str2);
        }

        @Override // s0.a
        public boolean d() {
            if (r0.l.a("MULTI_PROFILE")) {
                return super.d();
            }
            return false;
        }
    }

    public static UnsupportedOperationException a() {
        return new UnsupportedOperationException("This method is not supported by the current version of the framework and the current WebView APK");
    }

    public static boolean b(String str) {
        return c(str, s0.a.e());
    }

    public static boolean c(String str, Collection collection) {
        HashSet hashSet = new HashSet();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            h hVar = (h) it.next();
            if (hVar.a().equals(str)) {
                hashSet.add(hVar);
            }
        }
        if (hashSet.isEmpty()) {
            throw new RuntimeException("Unknown feature " + str);
        }
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            if (((h) it2.next()).b()) {
                return true;
            }
        }
        return false;
    }
}
