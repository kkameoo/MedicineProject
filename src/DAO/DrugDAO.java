package DAO;

import DTO.DrugDTO;
import Function.drugse;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DrugDAO {
    public Connection connDB() {
        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/class2jsp";
            String user = "root";
            String pwd = "1234";

            connection = DriverManager.getConnection(url, user, pwd);
            if (connection != null) {
                System.out.println("연결 성공");
            }
        } catch (Exception e) {
            System.out.println("연결 오류 발생");
            e.printStackTrace();
        }
        return connection;
    }

    public ArrayList<DrugDTO> drugInsert() throws IOException {

        ArrayList<DrugDTO> DrugList = new ArrayList<DrugDTO>();

        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1471000/DayMaxDosgQyByIngdService/getDayMaxDosgQyByIngdInq"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=G8s%2BoJ2yZ31khu9wTLk9vXE4UBvjwqnwo7KpCXfhXrWPwMGR2E75QD7PwZTS1PIMa%2BW6cdlx8bRWKoAKMEvZdw%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("3", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("type","UTF-8") + "=" + URLEncoder.encode("xml", "UTF-8")); /*응답데이터 형식(xml/json) Default: xml*/
        urlBuilder.append("&" + URLEncoder.encode("CPNT_CD","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*성분코드*/
        urlBuilder.append("&" + URLEncoder.encode("DRUG_CPNT_KOR_NM","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*성분명(한글)*/
        urlBuilder.append("&" + URLEncoder.encode("DRUG_CPNT_ENG_NM","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*성분명(영문)*/

        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");

        System.out.println("Response code: " + conn.getResponseCode());

        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());

        try {

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document doc = documentBuilder.parse(new InputSource(new StringReader(sb.toString())));

            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("item");


            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                DrugDTO drugDTO = new DrugDTO();
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    System.out.println(getTagValue("DRUG_CPNT_KOR_NM", element));
                    String drugcode = getTagValue("CPNT_CD", element);
                    String drugname = getTagValue("DRUG_CPNT_KOR_NM", element);
                    int formcode = Integer.parseInt(getTagValue("FOML_CD", element));
                    String formname = getTagValue("FOML_NM", element);
                    String path = getTagValue("DOSAGE_ROUTE_CODE", element);

                    drugDTO.setDrugcode(drugcode);
                    drugDTO.setDrugname(drugname);
                    drugDTO.setFormcode(formcode);
                    drugDTO.setFormname(formname);
                    drugDTO.setPath(path);

                    DrugList.add(drugDTO);
                    System.out.println(DrugList);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return DrugList;
    }
    private static String getTagValue(String tag, Element eelement) {
        NodeList nlist = eelement.getElementsByTagName(tag).item(0).getChildNodes();
        Node nValue = (Node) nlist.item(0);
        if (nValue == null)
            return null;
        return nValue.getNodeValue();
    }
}
