package task1;

//      1) Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, используя StringBuilder.
//      Данные для фильтрации приведены ниже в виде json-строки. Если значение null, то параметр не должен попадать в запрос.
//      Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class task1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("t1_data.json"));
        String str;
        StringBuilder content = new StringBuilder();

        while ((str = br.readLine()) != null) {
            content.append(str);
            content.append("\n");
        }

        br.close();
        System.out.print(content);

        JSONObject obj = new JSONObject(content.toString());
        String query = "SELECT * FROM students";
        StringBuilder sb = new StringBuilder(query);
        Map<String, String> filteredData = filterData(obj);
        Set<String> keys = filteredData.keySet();
        int dataLength = filteredData.size();

        if (dataLength > 0) {
            sb.append(" WHERE ");
            int index = 0;

            for (String key : keys) {
                if (index == dataLength - 1) {
                    sb.append(key + " = '" + filteredData.get(key) + "'");
                } else {
                    sb.append(key + " = '" + filteredData.get(key) + "' AND ");
                }
                index++;
            }

        }
        System.out.print(sb);
    }

    private static Map<String, String> filterData(JSONObject obj) {
        Set<String> keys = obj.keySet();
        Map<String, String> data = new HashMap<String, String>();
        for (String key : keys) {
            if (!obj.getString(key).contains("null")) {
                data.put(key, obj.getString(key));
            }
        }

        return data;
    }
}
