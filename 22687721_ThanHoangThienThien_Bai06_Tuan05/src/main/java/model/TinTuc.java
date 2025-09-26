package model;

public class TinTuc {
    private int matt;
    private String tieude;
    private String noidungtt;
    private String lienket;
    private int madm;

    public TinTuc() {}

    // Constructor thêm mới (không cần matt)
    public TinTuc(String tieude, String noidungtt, String lienket, int madm) {
        this.tieude = tieude;
        this.noidungtt = noidungtt;
        this.lienket = lienket;
        this.madm = madm;
    }

    // Constructor đầy đủ (đọc từ DB)
    public TinTuc(int matt, String tieude, String noidungtt, String lienket, int madm) {
        this.matt = matt;
        this.tieude = tieude;
        this.noidungtt = noidungtt;
        this.lienket = lienket;
        this.madm = madm;
    }

    // Getter & Setter
    public int getMatt() { return matt; }
    public void setMatt(int matt) { this.matt = matt; }
    public String getTieude() { return tieude; }
    public void setTieude(String tieude) { this.tieude = tieude; }
    public String getNoidungtt() { return noidungtt; }
    public void setNoidungtt(String noidungtt) { this.noidungtt = noidungtt; }
    public String getLienket() { return lienket; }
    public void setLienket(String lienket) { this.lienket = lienket; }
    public int getMadm() { return madm; }
    public void setMadm(int madm) { this.madm = madm; }
}
