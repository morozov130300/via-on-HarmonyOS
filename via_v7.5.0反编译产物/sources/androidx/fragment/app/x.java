package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import org.simpleframework.xml.strategy.Name;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class x implements LayoutInflater.Factory2 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FragmentManager f882c;

    public x(FragmentManager fragmentManager) {
        this.f882c = fragmentManager;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    @Override // android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        j0 j0VarA;
        if (t.class.getName().equals(str)) {
            return new t(context, attributeSet, this.f882c);
        }
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue(null, Name.LABEL);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e0.c.f4070a);
        if (attributeValue == null) {
            attributeValue = typedArrayObtainStyledAttributes.getString(e0.c.f4071b);
        }
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(e0.c.f4072c, -1);
        String string = typedArrayObtainStyledAttributes.getString(e0.c.f4073d);
        typedArrayObtainStyledAttributes.recycle();
        if (attributeValue == null || !v.b(context.getClassLoader(), attributeValue)) {
            return null;
        }
        int id = view != null ? view.getId() : 0;
        if (id == -1 && resourceId == -1 && string == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
        }
        Fragment fragmentM0 = resourceId != -1 ? this.f882c.m0(resourceId) : null;
        if (fragmentM0 == null && string != null) {
            fragmentM0 = this.f882c.n0(string);
        }
        if (fragmentM0 == null && id != -1) {
            fragmentM0 = this.f882c.m0(id);
        }
        if (fragmentM0 == null) {
            fragmentM0 = this.f882c.z0().a(context.getClassLoader(), attributeValue);
            fragmentM0.f585z = true;
            fragmentM0.I = resourceId != 0 ? resourceId : id;
            fragmentM0.J = id;
            fragmentM0.K = string;
            fragmentM0.A = true;
            FragmentManager fragmentManager = this.f882c;
            fragmentM0.E = fragmentManager;
            fragmentM0.F = fragmentManager.B0();
            fragmentM0.I1(this.f882c.B0().q(), attributeSet, fragmentM0.f562e);
            j0VarA = this.f882c.k(fragmentM0);
            if (FragmentManager.O0(2)) {
                Log.v("FragmentManager", "Fragment " + fragmentM0 + " has been inflated via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
            }
        } else {
            if (fragmentM0.A) {
                throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + attributeValue);
            }
            fragmentM0.A = true;
            FragmentManager fragmentManager2 = this.f882c;
            fragmentM0.E = fragmentManager2;
            fragmentM0.F = fragmentManager2.B0();
            fragmentM0.I1(this.f882c.B0().q(), attributeSet, fragmentM0.f562e);
            j0VarA = this.f882c.A(fragmentM0);
            if (FragmentManager.O0(2)) {
                Log.v("FragmentManager", "Retained Fragment " + fragmentM0 + " has been re-attached via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
            }
        }
        ViewGroup viewGroup = (ViewGroup) view;
        FragmentStrictMode.g(fragmentM0, viewGroup);
        fragmentM0.S = viewGroup;
        j0VarA.m();
        j0VarA.j();
        View view2 = fragmentM0.T;
        if (view2 == null) {
            throw new IllegalStateException("Fragment " + attributeValue + " did not create a view.");
        }
        if (resourceId != 0) {
            view2.setId(resourceId);
        }
        if (fragmentM0.T.getTag() == null) {
            fragmentM0.T.setTag(string);
        }
        fragmentM0.T.addOnAttachStateChangeListener(new a(j0VarA));
        return fragmentM0.T;
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ j0 f883c;

        public a(j0 j0Var) {
            this.f883c = j0Var;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            Fragment fragmentK = this.f883c.k();
            this.f883c.m();
            SpecialEffectsController.u((ViewGroup) fragmentK.T.getParent(), x.this.f882c).q();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }
}
