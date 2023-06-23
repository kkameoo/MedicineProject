package Function;
import DAO.DrugDAO;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;


public class drug {

//    private static String getTagValue(String tag, Element eelement) {
//        NodeList nlist = eelement.getElementsByTagName(tag).item(0).getChildNodes();
//        Node nValue = (Node) nlist.item(0);
//        if (nValue == null)
//            return null;
//        return nValue.getNodeValue();
//    }

    public static void main(String[] args) throws Exception {

//        try {
//                drugse sd = new drugse();
//
//                DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
//                DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
//                Document doc = documentBuilder.parse(new InputSource(new StringReader(sd.insert())));
//
//                doc.getDocumentElement().normalize();
//
//                NodeList nodeList = doc.getElementsByTagName("item");
//
//                for (int i = 0; i < nodeList.getLength(); i++) {
//                    Node node = nodeList.item(i);
//                    if (node.getNodeType() == Node.ELEMENT_NODE) {
//                        Element element = (Element) node;
//                        System.out.println(getTagValue("CPNT_CD", element));
//                    }
//                }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        DrugDAO drugDAO = new DrugDAO();
        drugDAO.drugInsert("4");
    }
}
