package muotoilija;

import java.lang.StringBuilder;

public class Muotoilija {

    public String muotoile(int[] t) {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        for (int i = 0; i < t.length - 1; i++) {
            if (i < t.length) {
                sb.append(" " + t[i] + ",");
            }
            if (t[i] % 4 == 0 && i < t.length - 1) {
                sb.append("\n");
            }
        }
        sb.append(" " + t[t.length - 1] + "\n}");
        return sb.toString();
    }

}
