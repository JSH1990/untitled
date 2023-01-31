package 프로퍼티;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Properties;

// 키와 값이 모두 String 타입으로 제한된 Map 컬렉션이며 HashTable 에서 상속 받았습니다.
// 주로 문자열로 이루어진 파일에서 정보를 읽을 때 사용 합니다.
public class PropertiesEx1 {
    public static void main(String[] args) throws IOException { //입출력 최상위 예외처리
        Properties properties = new Properties(); //HashTable 에서 상속 받음
        String path = PropertiesEx1.class.getResource("../해시맵기본/database.properties").getPath(); //현재폴더에서 상위위치 ./ 내위치
        path = URLDecoder.decode(path, "utf-8");
        properties.load(new FileReader(path));
        String driver = properties.getProperty("driver");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        System.out.println("driver : " + driver);
        System.out.println("username : " + username);
        System.out.println("password : " + password);
    }
}
