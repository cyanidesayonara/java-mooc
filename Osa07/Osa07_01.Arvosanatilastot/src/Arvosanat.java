import java.util.ArrayList;

public class Arvosanat {
    private ArrayList<Integer> arvosanat;
    
    public Arvosanat() {
        this.arvosanat = new ArrayList<>();
    }
    
    public void lisaa(int pisteet) {
        if (pisteet <= 100 && pisteet >= 0) {
            this.arvosanat.add(pisteet);
        }
    }
    
    public double pisteidenKA() {
        int sum = 0;
        for (int i = 0; i < this.arvosanat.size(); i++) {
            sum += this.arvosanat.get(i);
        }
        return (double) sum / this.arvosanat.size();
    }
    
    public double hyvaksyttyjenPisteidenKA() {
        int sum = 0;
        int count = 0;
        for (int i = 0; i < this.arvosanat.size(); i++) {
            if (this.arvosanat.get(i) > 50) {
                sum += this.arvosanat.get(i);
                count++;
            }
        }
        return (double) sum / count;
    }
    public double hyvaksymisProsentti() {
        int count = 0;
        for (int i = 0; i < this.arvosanat.size(); i++) {
            if (this.arvosanat.get(i) > 50) {
                count++;
            }
        }
        return 100 * (double) count / this.arvosanat.size();
    }
    public void arvosanaJakauma() {
        
        String[] jakauma = new String[6];
        int[] pistemaara = {0, 50, 60, 70, 80, 90};
        
        for (int i = jakauma.length - 1; i >= 0; i--) {
            jakauma[i] = (i + ": ");
        }
        
        for (int i = 0; i < this.arvosanat.size(); i++) {
            for (int j = pistemaara.length - 1; j >= 0; j--) {
                if (this.arvosanat.get(i) > pistemaara[j]) {
                    jakauma[j] += "*";
                    break;
                }
            }
        }
        
        System.out.println("Arvosanajakauma:");
        for (int i = jakauma.length - 1; i >= 0; i--) {
            System.out.println(jakauma[i]);
        }
    }
}
