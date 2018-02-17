import com.sun.xml.internal.bind.marshaller.CharacterEscapeHandler;
import com.sun.xml.internal.bind.marshaller.DataWriter;
import com.sun.xml.internal.bind.marshaller.DumbEscapeHandler;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by A-8090 on 17-02-2018.
 */
public class JAXBExample {
    public static void main(String[] args) {

        Customer customer = new Customer();
        customer.setId(100);
        customer.setName("mkyong");
        customer.setAge(29);
        customer.setURL("https://abinpeter?tags=1&tags=2&");

        try {

            File file = new File("D:\\file.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.setProperty(CharacterEscapeHandler.class.getName(),
                    new CharacterEscapeHandlers());
            //jaxbMarshaller.setProperty("jaxb.encoding", "Unicode");
            jaxbMarshaller.marshal(customer, file);
            jaxbMarshaller.marshal(customer, System.out);
            PrintWriter printWriter = null;
            try {
                printWriter = new PrintWriter(new FileWriter(file));
            } catch (IOException e) {
                e.printStackTrace();
            }
            DataWriter dataWriter = new DataWriter(printWriter, "UTF-8", DumbEscapeHandler.theInstance);
            jaxbMarshaller.marshal(customer, dataWriter);

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}
