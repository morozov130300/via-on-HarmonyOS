package p9;

import android.content.Context;
import c9.z;
import com.launchdarkly.eventsource.UnsuccessfulResponseException;
import i6.i0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import org.json.JSONObject;
import z8.c0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class s {
    public static String a(String str) {
        if (str != null) {
            i0 i0Var = i0.f7006a;
            if (i0Var.s(str)) {
                String strF = i0Var.f(str);
                if ("api.openai.com".equals(strF)) {
                    return "https://platform.openai.com/api-keys";
                }
                if ("ark.cn-beijing.volces.com".equals(strF)) {
                    return "https://console.volcengine.com/ark/region:ark+cn-beijing/apiKey?apikey=%7B%7D";
                }
                if ("openrouter.ai".equals(strF)) {
                    return "https://openrouter.ai/settings/provisioning-keys";
                }
                if ("dashscope.aliyuncs.com".equals(strF)) {
                    return "https://bailian.console.aliyun.com/?tab=model#/api-key";
                }
                if ("api.deepseek.com".equals(strF)) {
                    return "https://platform.deepseek.com/api_keys";
                }
                if ("api.siliconflow.cn".equals(strF)) {
                    return "https://cloud.siliconflow.cn/account/ak";
                }
                if ("api.anthropic.com".equals(strF)) {
                    return "https://console.anthropic.com/account/keys";
                }
                if ("generativelanguage.googleapis.com".equals(strF)) {
                    return "https://aistudio.google.com/app/apikey";
                }
            }
        }
        return null;
    }

    public static String b(z zVar) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("You're a proficient AI assistant skilled in concise, on-point responses. Please follow the following principles:\n1. Ground answers in the provided webpage, allowing minor thematic tangents but avoiding irrelevance. If info is missing, note gaps clearly.\n2. Match the user's language ({{user_language}}) and tone precisely.\n3. Prioritize clarity: lead with direct answers, add context only if critical.");
        sb2.append("\n\n");
        sb2.append("The webpage is as follows:\n");
        if (zVar.c() != null && !zVar.c().isEmpty()) {
            sb2.append("Link: ");
            sb2.append(zVar.c());
            sb2.append("\n");
        }
        if (zVar.getTitle() != null && !zVar.getTitle().isEmpty()) {
            sb2.append("Title: ");
            sb2.append(zVar.getTitle());
            sb2.append("\n");
        }
        if (zVar.b() != null && !zVar.b().isEmpty()) {
            sb2.append("Content:\n");
            sb2.append(zVar.b());
        }
        return sb2.toString();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:11:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static l c(String str) {
        char c10 = 1;
        boolean z10 = z8.f.h() || c0.f();
        str.getClass();
        switch (str.hashCode()) {
            case -166038563:
                if (!str.equals("SILICONFLOW")) {
                    c10 = '\uffff';
                    break;
                } else {
                    c10 = 0;
                    break;
                }
            case 739509131:
                if (!str.equals("BYTEDANCE")) {
                }
                break;
            case 1412064612:
                if (str.equals("DEEPSEEK")) {
                    c10 = 2;
                    break;
                }
                break;
            case 1457105459:
                if (str.equals("CHATGPT")) {
                    c10 = 3;
                    break;
                }
                break;
            case 1716668947:
                if (str.equals("OPENROUTER")) {
                    c10 = 4;
                    break;
                }
                break;
            case 1933345396:
                if (str.equals("ALIYUN")) {
                    c10 = 5;
                    break;
                }
                break;
            case 1990360990:
                if (str.equals("CLAUDE")) {
                    c10 = 6;
                    break;
                }
                break;
            case 2098759221:
                if (str.equals("GEMINI")) {
                    c10 = 7;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                l lVar = new l();
                lVar.p(z10 ? "\u7845\u57fa\u6d41\u52a8" : "SiliconFlow");
                lVar.r("https://api.siliconflow.cn/v1");
                lVar.n("deepseek-ai/DeepSeek-V3,deepseek-ai/DeepSeek-R1,Qwen/Qwen3-8B");
                return lVar;
            case 1:
                l lVar2 = new l();
                lVar2.p(z10 ? "\u5b57\u8282\u706b\u5c71\u5f15\u64ce" : "ByteDance");
                lVar2.r("https://ark.cn-beijing.volces.com/api/v3");
                lVar2.n("deepseek-v3-250324,deepseek-r1-250120");
                return lVar2;
            case 2:
                l lVar3 = new l();
                lVar3.p("DeepSeek");
                lVar3.r("https://api.deepseek.com");
                lVar3.n("deepseek-chat,deepseek-reasoner");
                return lVar3;
            case WebSettingsBoundaryInterface.AttributionBehavior.APP_SOURCE_AND_APP_TRIGGER /* 3 */:
                l lVar4 = new l();
                lVar4.p("ChatGPT");
                lVar4.r("https://api.openai.com/v1");
                lVar4.n("gpt-4.1-mini,o4-mini,o3");
                return lVar4;
            case 4:
                l lVar5 = new l();
                lVar5.p("OpenRouter");
                lVar5.r("https://openrouter.ai/api/v1");
                lVar5.n("deepseek/deepseek-chat-v3-0324:free,deepseek/deepseek-r1:free,google/gemini-2.0-flash-exp:free");
                return lVar5;
            case 5:
                l lVar6 = new l();
                lVar6.p(z10 ? "\u963f\u91cc\u4e91\u767e\u70bc" : "AlibabaCloud");
                lVar6.r("https://dashscope.aliyuncs.com/compatible-mode/v1");
                lVar6.n("deepseek-v3,deepseek-r1");
                return lVar6;
            case 6:
                l lVar7 = new l();
                lVar7.p("Claude");
                lVar7.r("https://api.anthropic.com/v1/");
                lVar7.n("claude-3-7-sonnet-20250219");
                return lVar7;
            case 7:
                l lVar8 = new l();
                lVar8.p("Google Gemini");
                lVar8.r("https://generativelanguage.googleapis.com/v1beta/openai/");
                lVar8.n("gemini-2.0-flash,gemini-1.5-pro");
                return lVar8;
            default:
                return null;
        }
    }

    public static String[] d() {
        return c0.j() ? new String[0] : (z8.f.h() || c0.f()) ? new String[]{"", "BYTEDANCE", "ALIYUN", "DEEPSEEK", "SILICONFLOW", "OPENROUTER", "CHATGPT", "GEMINI", "CLAUDE"} : new String[]{"", "CHATGPT", "OPENROUTER", "GEMINI", "CLAUDE", "BYTEDANCE", "ALIYUN", "DEEPSEEK", "SILICONFLOW"};
    }

    public static String e(Context context, g gVar) {
        if (context == null || gVar == null) {
            return null;
        }
        switch (gVar.f()) {
            case 101:
                return context.getString(x7.u.P8);
            case 102:
                return context.getString(x7.u.F4);
            case 103:
                return context.getString(x7.u.G4);
            case 104:
                return context.getString(x7.u.D4);
            default:
                Throwable thG = gVar.g();
                if (!(thG instanceof UnsuccessfulResponseException)) {
                    return context.getString(x7.u.H4, g6.p.n(gVar.e(), "Unknow error"));
                }
                UnsuccessfulResponseException unsuccessfulResponseException = (UnsuccessfulResponseException) thG;
                return context.getString(x7.u.E4, Integer.valueOf(unsuccessfulResponseException.getCode()), g6.p.n(unsuccessfulResponseException.getResponse(), "Empty"));
        }
    }

    public static String f(JSONObject jSONObject, String str) {
        if (jSONObject == null || str == null || str.isEmpty() || jSONObject.isNull(str)) {
            return null;
        }
        return jSONObject.getString(str);
    }

    public static int g(List list) {
        if (list == null || list.isEmpty()) {
            return 0;
        }
        return (list.contains("{{webpage_url}}") || list.contains("{{webpage_title}}") || list.contains("{{webpage_content}}")) ? 1 : 0;
    }

    public static String h(c9.a aVar, List list) {
        if (aVar instanceof z) {
            return b((z) aVar);
        }
        if (list == null || list.isEmpty()) {
            return "Act as an Expert Answerer. Follow these rules:\n\n1. Concisely answer the core question within 3 sentences. Prioritize clarity.\n2. Match the user's language (e.g., respond in Chinese if asked in Chinese).\n3. Structure answers when answering professional content.\n4. Omit polite filler, disclaimers, or redundant content.\n\nStay strictly on-task.";
        }
        Iterator it = list.iterator();
        if (it.hasNext()) {
            n.g.a(it.next());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("\n\nYou have access to the following tools:");
            sb2.append("\n- ");
            throw null;
        }
        return "Act as an Expert Answerer. Follow these rules:\n\n1. Concisely answer the core question within 3 sentences. Prioritize clarity.\n2. Match the user's language (e.g., respond in Chinese if asked in Chinese).\n3. Structure answers when answering professional content.\n4. Omit polite filler, disclaimers, or redundant content.\n\nStay strictly on-task." + ("\n\nYou have access to the following tools:\n\nYou should always think about what to do.");
    }

    public static List i(String str, int i10) {
        int iIndexOf;
        ArrayList arrayList = new ArrayList();
        if (str != null && !str.isEmpty()) {
            int length = str.length();
            int i11 = 0;
            do {
                int iIndexOf2 = str.indexOf("{{", i11);
                if (iIndexOf2 < 0 || (iIndexOf = str.indexOf("}}", iIndexOf2 + 2)) < 0) {
                    break;
                }
                int iLastIndexOf = str.lastIndexOf("{{", iIndexOf);
                if (iLastIndexOf > iIndexOf2) {
                    iIndexOf2 = iLastIndexOf;
                }
                if (iIndexOf2 + 2 < iIndexOf) {
                    String strSubstring = str.substring(iIndexOf2, iIndexOf + 2);
                    if (j(strSubstring, i10) && !arrayList.contains(strSubstring)) {
                        arrayList.add(strSubstring);
                    }
                }
                i11 = iIndexOf + 2;
            } while (i11 < length);
        }
        return arrayList;
    }

    public static boolean j(String str, int i10) {
        if (str.indexOf(32) >= 0) {
            return false;
        }
        return i10 == 1 ? "{{webpage_title}}".equals(str) || "{{webpage_url}}".equals(str) || "{{webpage_content}}".equals(str) : i10 == 2 ? "{{input}}".equals(str) : "{{input}}".equals(str);
    }
}
