package n9;

import a9.z;
import android.content.Context;
import c6.a2;
import com.launchdarkly.eventsource.UnsuccessfulResponseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
import x8.a0;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class s {
    public static String a(String str) {
        if (str != null) {
            a2 a2Var = a2.f1958a;
            if (a2Var.t(str)) {
                String strG = a2Var.g(str);
                if ("api.openai.com".equals(strG)) {
                    return "https://platform.openai.com/api-keys";
                }
                if ("ark.cn-beijing.volces.com".equals(strG)) {
                    return "https://console.volcengine.com/ark/region:ark+cn-beijing/apiKey?apikey=%7B%7D";
                }
                if ("openrouter.ai".equals(strG)) {
                    return "https://openrouter.ai/settings/provisioning-keys";
                }
                if ("dashscope.aliyuncs.com".equals(strG)) {
                    return "https://bailian.console.aliyun.com/?tab=model#/api-key";
                }
                if ("api.deepseek.com".equals(strG)) {
                    return "https://platform.deepseek.com/api_keys";
                }
                if ("api.siliconflow.cn".equals(strG)) {
                    return "https://cloud.siliconflow.cn/account/ak";
                }
                if ("api.anthropic.com".equals(strG)) {
                    return "https://console.anthropic.com/account/keys";
                }
                if ("generativelanguage.googleapis.com".equals(strG)) {
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
    /* JADX WARN: Code duplicated, block: B:11:0x001d  */
    public static l c(String str) {
        boolean z10 = x8.f.h() || a0.f();
        str.getClass();
        switch (str) {
            case "SILICONFLOW":
                l lVar = new l();
                lVar.p(z10 ? "硅基流动" : "SiliconFlow");
                lVar.r("https://api.siliconflow.cn/v1");
                lVar.n("deepseek-ai/DeepSeek-V3,deepseek-ai/DeepSeek-R1,Qwen/Qwen3-8B");
                return lVar;
            case "BYTEDANCE":
                l lVar2 = new l();
                lVar2.p(z10 ? "字节火山引擎" : "ByteDance");
                lVar2.r("https://ark.cn-beijing.volces.com/api/v3");
                lVar2.n("deepseek-v3-250324,deepseek-r1-250120");
                return lVar2;
            case "DEEPSEEK":
                l lVar3 = new l();
                lVar3.p("DeepSeek");
                lVar3.r("https://api.deepseek.com");
                lVar3.n("deepseek-chat,deepseek-reasoner");
                return lVar3;
            case "CHATGPT":
                l lVar4 = new l();
                lVar4.p("ChatGPT");
                lVar4.r("https://api.openai.com/v1");
                lVar4.n("gpt-4.1-mini,o4-mini,o3");
                return lVar4;
            case "OPENROUTER":
                l lVar5 = new l();
                lVar5.p("OpenRouter");
                lVar5.r("https://openrouter.ai/api/v1");
                lVar5.n("deepseek/deepseek-chat-v3-0324:free,deepseek/deepseek-r1:free,google/gemini-2.0-flash-exp:free");
                return lVar5;
            case "ALIYUN":
                l lVar6 = new l();
                lVar6.p(z10 ? "阿里云百炼" : "AlibabaCloud");
                lVar6.r("https://dashscope.aliyuncs.com/compatible-mode/v1");
                lVar6.n("deepseek-v3,deepseek-r1");
                return lVar6;
            case "CLAUDE":
                l lVar7 = new l();
                lVar7.p("Claude");
                lVar7.r("https://api.anthropic.com/v1/");
                lVar7.n("claude-3-7-sonnet-20250219");
                return lVar7;
            case "GEMINI":
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
        if (a0.i()) {
            return new String[0];
        }
        return (x8.f.h() || a0.f()) ? new String[]{"", "BYTEDANCE", "ALIYUN", "DEEPSEEK", "SILICONFLOW", "OPENROUTER", "CHATGPT", "GEMINI", "CLAUDE"} : new String[]{"", "CHATGPT", "OPENROUTER", "GEMINI", "CLAUDE", "BYTEDANCE", "ALIYUN", "DEEPSEEK", "SILICONFLOW"};
    }

    public static String e(Context context, g gVar) {
        if (context == null || gVar == null) {
            return null;
        }
        switch (gVar.f()) {
            case 101:
                return context.getString(w7.u.f13990b9);
            case 102:
                return context.getString(w7.u.S4);
            case 103:
                return context.getString(w7.u.T4);
            case 104:
                return context.getString(w7.u.Q4);
            default:
                Throwable thG = gVar.g();
                if (!(thG instanceof UnsuccessfulResponseException)) {
                    return context.getString(w7.u.U4, com.tuyafeng.support.utils.p.n(gVar.e(), "Unknow error"));
                }
                UnsuccessfulResponseException unsuccessfulResponseException = (UnsuccessfulResponseException) thG;
                return context.getString(w7.u.R4, Integer.valueOf(unsuccessfulResponseException.getCode()), com.tuyafeng.support.utils.p.n(unsuccessfulResponseException.getResponse(), "Empty"));
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

    public static String h(a9.a aVar, List list) {
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
        if (i10 == 1) {
            return "{{webpage_title}}".equals(str) || "{{webpage_url}}".equals(str) || "{{webpage_content}}".equals(str);
        }
        if (i10 == 2) {
            return "{{input}}".equals(str);
        }
        return "{{input}}".equals(str);
    }
}
