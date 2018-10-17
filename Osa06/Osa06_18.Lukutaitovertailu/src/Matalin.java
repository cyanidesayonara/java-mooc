public class Matalin {
    private String maa;
    private int vuosi;
    private String sex;
    private double prs;
    
    public Matalin(String maa, int vuosi, String sex, double prs) {
        this.maa = maa;
        this.vuosi = vuosi;
        this.sex = sex;
        this.prs = prs;
    }
    
    public String getMaa() {
        return this.maa;
    }
    public int getVuosi() {
        return this.vuosi;
    }
    public String getSex() {
        return this.sex;
    }
    public double getPrs() {
        return this.prs;
    }
}
