package q004;

/**
 * Q004 ソートアルゴリズム
 *
 * ListManagerクラスをnewして、小さい順に並び変えた上でcheckResult()を呼び出してください。
 *
 * 実装イメージ:
 * ListManager data = new ListManager();
 * // TODO 並び換え
 * data.checkResult();
 *
 * - ListManagerクラスを修正してはいけません
 * - ListManagerクラスの dataList を直接変更してはいけません
 * - ListManagerクラスの比較 compare と入れ替え exchange を使って実現してください
 */
public class Q004 {
    public static void main(String[] args) {
        ListManager data = new ListManager();

        for (int j = data.size(); 0 < j; j--) {
            for (int i = 0; i < j - 1 ; i++) {
                if (data.compare(i, i+1) == 1) {
                    data.exchange(i, i+1);
                }
            }
        }

        data.checkResult();
    }
}
// 完成までの時間: xx時間 xx分