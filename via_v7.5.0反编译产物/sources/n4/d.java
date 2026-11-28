package n4;

import com.thegrizzlylabs.sardineandroid.model.Prop;
import com.thegrizzlylabs.sardineandroid.model.Property;
import com.thegrizzlylabs.sardineandroid.model.Resourcetype;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.convert.Registry;
import org.simpleframework.xml.convert.RegistryStrategy;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.stream.Format;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f10584a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final DocumentBuilderFactory f10585b = DocumentBuilderFactory.newInstance();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List f10586c;

    static {
        String[] strArr = {"yyyy-MM-dd'T'HH:mm:ss'Z'", "EEE, dd MMM yyyy HH:mm:ss zzz", "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", "yyyy-MM-dd'T'HH:mm:ssZ", "EEE MMM dd HH:mm:ss zzz yyyy", "EEEEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMMM d HH:mm:ss yyyy"};
        f10584a = strArr;
        ArrayList arrayList = new ArrayList(strArr.length);
        for (int i10 = 0; i10 < f10584a.length; i10++) {
            arrayList.add(new ThreadLocal());
        }
        f10586c = Collections.unmodifiableList(arrayList);
    }

    public static Document a() {
        try {
            return f10585b.newDocumentBuilder().newDocument();
        } catch (ParserConfigurationException e10) {
            throw new RuntimeException(e10.getMessage(), e10);
        }
    }

    public static Element b(QName qName) {
        return a().createElementNS(qName.getNamespaceURI(), qName.getPrefix() + ":" + qName.getLocalPart());
    }

    public static QName c(String str) {
        return new QName("DAV:", str, "D");
    }

    public static Serializer d() {
        Format format = new Format("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
        Registry registry = new Registry();
        Persister persister = new Persister(new RegistryStrategy(registry), format);
        registry.bind(Prop.class, new b(persister, Prop.class));
        registry.bind(Resourcetype.class, new b(persister, Resourcetype.class));
        registry.bind(Property.class, Property.PropertyConverter.class);
        return persister;
    }

    public static Date e(String str) {
        Date date = null;
        if (str == null) {
            return null;
        }
        int i10 = 0;
        while (true) {
            List list = f10586c;
            if (i10 >= list.size()) {
                break;
            }
            ThreadLocal threadLocal = (ThreadLocal) list.get(i10);
            SimpleDateFormat simpleDateFormat = (SimpleDateFormat) threadLocal.get();
            if (simpleDateFormat == null) {
                simpleDateFormat = new SimpleDateFormat(f10584a[i10], Locale.US);
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                threadLocal.set(simpleDateFormat);
            }
            try {
                continue;
                date = simpleDateFormat.parse(str);
                break;
            } catch (ParseException unused) {
                i10++;
            }
        }
        return date;
    }

    public static QName f(Element element) {
        if (element.getNamespaceURI() == null) {
            return new QName("DAV:", element.getLocalName(), "D");
        }
        return element.getPrefix() == null ? new QName(element.getNamespaceURI(), element.getLocalName()) : new QName(element.getNamespaceURI(), element.getLocalName(), element.getPrefix());
    }

    public static String g(Object obj) {
        StringWriter stringWriter = new StringWriter();
        try {
            d().write(obj, stringWriter);
            return stringWriter.toString();
        } catch (Exception e10) {
            throw new RuntimeException(e10.getMessage(), e10);
        }
    }

    public static Object h(Class cls, InputStream inputStream) throws IOException {
        try {
            return d().read(cls, inputStream);
        } catch (SAXException e10) {
            throw new RuntimeException(e10.getMessage(), e10);
        } catch (Exception e11) {
            throw new IOException("Not a valid DAV response", e11);
        }
    }
}
