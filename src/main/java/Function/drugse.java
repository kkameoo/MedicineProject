package Function;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class drugse {
    public String insert() throws IOException {
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
        return sb.toString();
    }
}
