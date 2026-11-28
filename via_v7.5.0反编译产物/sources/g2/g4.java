package g2;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class g4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4816a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Bundle f4817b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Bundle f4818c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ l4 f4819d;

    public g4(l4 l4Var, String str, Bundle bundle) {
        this.f4819d = l4Var;
        u1.f.d("default_event_parameters");
        this.f4816a = "default_event_parameters";
        this.f4817b = new Bundle();
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0081 A[Catch: NumberFormatException | JSONException -> 0x0093, NumberFormatException | JSONException -> 0x0093, TRY_LEAVE, TryCatch #0 {NumberFormatException | JSONException -> 0x0093, blocks: (B:10:0x0026, B:20:0x0051, B:20:0x0051, B:29:0x0081, B:29:0x0081, B:24:0x0061, B:24:0x0061, B:28:0x0075, B:28:0x0075), top: B:41:0x0026, outer: #1 }] */
    public final Bundle a() {
        if (this.f4818c == null) {
            String string = this.f4819d.o().getString(this.f4816a, null);
            if (string != null) {
                try {
                    Bundle bundle = new Bundle();
                    JSONArray jSONArray = new JSONArray(string);
                    for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                        try {
                            JSONObject jSONObject = jSONArray.getJSONObject(i10);
                            String string2 = jSONObject.getString("n");
                            String string3 = jSONObject.getString("t");
                            int iHashCode = string3.hashCode();
                            if (iHashCode != 100) {
                                if (iHashCode != 108) {
                                    if (iHashCode == 115 && string3.equals("s")) {
                                        bundle.putString(string2, jSONObject.getString("v"));
                                    } else {
                                        this.f4819d.f4646a.d().r().b("Unrecognized persisted bundle type. Type", string3);
                                    }
                                } else if (string3.equals("l")) {
                                    bundle.putLong(string2, Long.parseLong(jSONObject.getString("v")));
                                } else {
                                    this.f4819d.f4646a.d().r().b("Unrecognized persisted bundle type. Type", string3);
                                }
                            } else if (string3.equals("d")) {
                                bundle.putDouble(string2, Double.parseDouble(jSONObject.getString("v")));
                            } else {
                                this.f4819d.f4646a.d().r().b("Unrecognized persisted bundle type. Type", string3);
                            }
                        } catch (NumberFormatException | JSONException unused) {
                            this.f4819d.f4646a.d().r().a("Error reading value from SharedPreferences. Value dropped");
                        }
                    }
                    this.f4818c = bundle;
                } catch (JSONException unused2) {
                    this.f4819d.f4646a.d().r().a("Error loading bundle from SharedPreferences. Values will be lost");
                }
            }
            if (this.f4818c == null) {
                this.f4818c = this.f4817b;
            }
        }
        return this.f4818c;
    }

    public final void b(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        SharedPreferences.Editor editorEdit = this.f4819d.o().edit();
        if (bundle.size() == 0) {
            editorEdit.remove(this.f4816a);
        } else {
            String str = this.f4816a;
            JSONArray jSONArray = new JSONArray();
            for (String str2 : bundle.keySet()) {
                Object obj = bundle.get(str2);
                if (obj != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("n", str2);
                        jSONObject.put("v", obj.toString());
                        if (obj instanceof String) {
                            jSONObject.put("t", "s");
                        } else if (obj instanceof Long) {
                            jSONObject.put("t", "l");
                        } else if (obj instanceof Double) {
                            jSONObject.put("t", "d");
                        } else {
                            this.f4819d.f4646a.d().r().b("Cannot serialize bundle value to SharedPreferences. Type", obj.getClass());
                        }
                        jSONArray.put(jSONObject);
                    } catch (JSONException e10) {
                        this.f4819d.f4646a.d().r().b("Cannot serialize bundle value to SharedPreferences", e10);
                    }
                }
            }
            editorEdit.putString(str, jSONArray.toString());
        }
        editorEdit.apply();
        this.f4818c = bundle;
    }
}
