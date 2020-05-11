package q003;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Q003 集計と並べ替え
 *
 * 以下のデータファイルを読み込んで、出現する単語ごとに数をカウントし、アルファベット辞書順に並び変えて出力してください。
 * resources/q003/data.txt
 * 単語の条件は以下となります
 * - "I"以外は全て小文字で扱う（"My"と"my"は同じく"my"として扱う）
 * - 単数形と複数形のように少しでも文字列が異れば別単語として扱う（"dream"と"dreams"は別単語）
 * - アポストロフィーやハイフン付の単語は1単語として扱う（"isn't"や"dead-end"）
 *
 * 出力形式:単語=数
 *
[出力イメージ]
（省略）
highest=1
I=3
if=2
ignorance=1
（省略）

 * 参考
 * http://eikaiwa.dmm.com/blog/4690/
 */
public class Q003 {
    /**
     * データファイルを開く
     * resources/q003/data.txt
     */
    private static InputStream openDataFile() {
        return Q003.class.getResourceAsStream("data.txt");
    }

    /**
     * InputStreamをStringへ変換
     * @param in
     * @return
     * @throws IOException
     */
    public static String inputStreemToString(InputStream in) throws IOException{
        
        BufferedReader reader = 
            new BufferedReader(new InputStreamReader(in, "UTF-8"));
        StringBuffer buf = new StringBuffer();
        String str;
        while ((str = reader.readLine()) != null) {
                buf.append(str);
                buf.append("\n");
        }
        return buf.toString();
    }

    /**
     * 文字列をカウント
     * 
     * @param data
     */
    public static void countChar(String data) {
        // 文字列を変換
        String replaceWord = data.replace(",", "").replace(";", "").replace(".", "").toLowerCase();
        // 分割して配列に格納
        List<String> list = Arrays.asList(replaceWord.split(" "));
        // 文字列をカウント
        Map<String, Integer> resultMap = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        for(String word : list) {
            if (resultMap.containsKey(word)) {
                Integer count = resultMap.get(word);
                resultMap.put(word, count + 1);
            } else {
                resultMap.put(word, 1);
            }
        }

        // カウント結果を表示
        for (String key : resultMap.keySet()) {
            System.out.println(key + "=" + resultMap.get(key));
        }
        

    }

    public static void main(String[] args) {
        String data = "";
        try {
            data = inputStreemToString(openDataFile());
        } catch (IOException e) {
            e.printStackTrace();
        }

        countChar(data);
    }
}
// 完成までの時間: xx時間 xx分