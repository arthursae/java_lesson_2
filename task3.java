package task3;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.FileReader;

//          3) Дана json-строка (можно сохранить в файл и читать из файла)
//          [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},
//          {"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},
//          {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
//          Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида:
//          Студент [фамилия] получил [оценка] по предмету [предмет].
//          Пример вывода:
//          Студент Иванов получил 5 по предмету Математика.
//          Студент Петрова получил 4 по предмету Информатика.
//          Студент Краснов получил 5 по предмету Физика.

public class task3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("t3_data.json"));
        String str;
        StringBuilder content = new StringBuilder();

        while ((str = br.readLine()) != null) {
            content.append(str);
            content.append("\n");
        }

        br.close();

        JSONArray obj = new JSONArray(content.toString());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < obj.length(); i++) {
            JSONObject block = obj.getJSONObject(i);
            sb.append("Студент ").append(block.getString("фамилия")).append(" ");
            sb.append("получил(a) ").append(block.getString("оценка")).append(" ");
            sb.append("по предмету ").append(block.getString("предмет")).append(" ");
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
