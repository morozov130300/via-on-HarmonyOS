package m4;

import com.thegrizzlylabs.sardineandroid.model.EntityWithAnyElement;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.convert.Converter;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class b implements Converter {

    /* renamed from: a, reason: collision with root package name */
    public Class f8618a;

    /* renamed from: b, reason: collision with root package name */
    public Serializer f8619b;

    public b(Serializer serializer, Class cls) {
        this.f8619b = serializer;
        this.f8618a = cls;
    }

    public final Map a() {
        HashMap map = new HashMap();
        for (Field field : this.f8618a.getDeclaredFields()) {
            Element element = (Element) field.getAnnotation(Element.class);
            if (element != null) {
                map.put(element.name().equals("") ? field.getName() : element.name(), field);
            }
        }
        return map;
    }

    public final Method b(Field field) {
        String name = field.getName();
        String str = name.substring(0, 1).toUpperCase() + name.substring(1);
        return this.f8618a.getMethod("get" + str, null);
    }

    public final Method c(Field field) {
        String name = field.getName();
        String str = name.substring(0, 1).toUpperCase() + name.substring(1);
        return this.f8618a.getMethod("set" + str, field.getType());
    }

    @Override // org.simpleframework.xml.convert.Converter
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public EntityWithAnyElement read(InputNode inputNode) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Map mapA = a();
        EntityWithAnyElement entityWithAnyElement = (EntityWithAnyElement) this.f8618a.newInstance();
        List<org.w3c.dom.Element> any = entityWithAnyElement.getAny();
        while (true) {
            InputNode next = inputNode.getNext();
            if (next == null) {
                return entityWithAnyElement;
            }
            if (mapA.containsKey(next.getName())) {
                Field field = (Field) mapA.get(next.getName());
                c(field).invoke(entityWithAnyElement, this.f8619b.read((Class) field.getType(), next));
            } else if (next.getPrefix() == null || next.getPrefix().isEmpty()) {
                e(next);
            } else {
                any.add(a.a(next));
            }
        }
    }

    public final void e(InputNode inputNode) {
        while (inputNode.getNext() != null) {
        }
    }

    @Override // org.simpleframework.xml.convert.Converter
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void write(OutputNode outputNode, EntityWithAnyElement entityWithAnyElement) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Iterator<org.w3c.dom.Element> it = entityWithAnyElement.getAny().iterator();
        while (it.hasNext()) {
            a.b(outputNode, it.next());
        }
        Map mapA = a();
        for (String str : mapA.keySet()) {
            Object objInvoke = b((Field) mapA.get(str)).invoke(entityWithAnyElement, null);
            if (objInvoke != null) {
                if (objInvoke instanceof String) {
                    OutputNode child = outputNode.getChild(str);
                    child.setReference("DAV:");
                    child.setValue((String) objInvoke);
                } else {
                    this.f8619b.write(objInvoke, outputNode);
                }
            }
        }
    }
}
