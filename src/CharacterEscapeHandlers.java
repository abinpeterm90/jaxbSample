import java.io.StringWriter;



        import java.io.IOException;
        import java.io.StringWriter;
        import java.io.Writer;



/**
 * Created by A-8090 on 17-02-2018.
 */
public class CharacterEscapeHandlers implements com.sun.xml.internal.bind.marshaller.CharacterEscapeHandler {
    public void escape(char[] buf, int start, int len, boolean isAttValue,
                       Writer out) throws IOException {

        StringWriter buffer = new StringWriter();

        for (int i = start; i < start + len; i++) {
            buffer.write(buf[i]);
        }
        String st = buffer.toString();


        if (!st.contains("CDATA")) {
            st = buffer.toString().replace("&", "&amp;").replace("<", "&lt;")
                    .replace(">", "&gt;").replace("'", "&apos;")
                    .replace("\"", "&quot;");
System.out.print(buffer.toString());
        }
        out.write(buffer.toString());
        System.out.println(st);
    }
}
