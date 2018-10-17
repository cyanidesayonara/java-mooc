import java.util.ArrayList;

// luo tänne luokkaan oma tekoälysi Uno-peliä varten
public class Tekoalypelaaja implements Pelaaja {

    // Saat luoda tarvittaessa oliomuuttujia. Jos luot konstruktorin, varmista
    // että tekoäly toimii myös parametrittomalla konstruktorilla, eli kutsulla
    // Tekoalypelaaja pelaaja = new Tekoalypelaaja();
    @Override
    public int pelaa(ArrayList<Kortti> omatKortit, Kortti paallimmaisin, String vari, Pelitilanne tilanne) {
        Kasi kasi = new Kasi(omatKortit, paallimmaisin, vari);
        
        /*
        System.out.println("käsi: " + kasi.getKasi());
        System.out.println("sopivat: " + kasi.getSopivat());
        System.out.println("sopivien indeksit: " + kasi.getSopivienIndeksit());
        System.out.println("isoimman numeron indeksi: "+ kasi.sopivienIsoimmanNumeronIndeksi());
        System.out.println("villit: " + kasi.villienIndeksit());
        System.out.println("sopivat ohitukset: " + kasi.ohituksienIndeksit());
        System.out.println("sopivat suunnanvaihdot: " + kasi.suunnanvaihtojenIndeksit());
        System.out.println("yleisin väri: " + kasi.yleisimmanVarinNimi());
        System.out.println("vastustaja pelasi viimeksi: " + tilanne.getPelaajienViimeksiPelaamatVarit()[0]);
        System.out.println("vastustajan korttien lkm: " + tilanne.getPelaajienKorttienLukumaarat()[0]);
        */
        
        // isoimman numerokortin indeksi, 0 jos ei numerokortteja
        int isoimmanNumeronIndeksi = 0;
        if (kasi.sopivienIsoimmanNumeronIndeksi() != 666) {
            isoimmanNumeronIndeksi = kasi.sopivienIsoimmanNumeronIndeksi();
        }
        
        // jos ei sopivia, -1
        if (kasi.sopivienIndeksit(paallimmaisin, vari).isEmpty()) {
            return -1;
        } else {
            
            // yritä ensi lyödä nostokortti...
            if (!kasi.nostojenIndeksit().isEmpty()) {
                return kasi.nostojenIndeksit().get(0);
                
            // ...sitten villi...
            } else if (!kasi.villienIndeksit().isEmpty()) {
                return kasi.villienIndeksit().get(0);
                
            // ...ohitus...
            } else if (!kasi.ohituksienIndeksit().isEmpty()) {
                return kasi.ohituksienIndeksit().get(0);
            
            // ...jos vastustajalla vain yksi kortti (uno), yritä vaihtaa väriä tai lyö korkein numero...
            } else if (tilanne.getPelaajienKorttienLukumaarat()[0] == 1) {
                for (int i = 0; i < kasi.getSopivat().size(); i++) {
                    if (!kasi.getSopivat().get(i).getVari().equals(tilanne.getPelaajienViimeksiPelaamatVarit()[0])) {
                        return kasi.sopivienIndeksit(paallimmaisin, vari).get(i);
                    } else {
                        return kasi.sopivienIndeksit(paallimmaisin, vari).get(isoimmanNumeronIndeksi);
                    }
                }  
                
            // ...suunnanvaihto (aika turha kortti)...
            } else if (!kasi.suunnanvaihtojenIndeksit().isEmpty()) {
                return kasi.suunnanvaihtojenIndeksit().get(0);
                
            // ...jos ei erikoiskortteja, yritä vaihtaa väriä omaan yleisimpään (jos siis pöydällä eri)...
            } else {
                for (int i = 0; i < kasi.getSopivat().size(); i++) {
                    if (kasi.getSopivat().get(i).getVari().equals(kasi.yleisimmanVarinNimi()) &&
                        !kasi.getSopivat().get(i).getVari().equals(tilanne.getPelaajienViimeksiPelaamatVarit()[0])) {
                        return kasi.sopivienIndeksit(paallimmaisin, vari).get(i);
                    }
                }
            }
            
            // ...viimeinen vaihtoehto: lyö korkein numerokortti pöytään
            return kasi.sopivienIndeksit(paallimmaisin, vari).get(isoimmanNumeronIndeksi);
        }
    }

    @Override
    public String valitseVari(ArrayList<Kortti> omatKortit) {
        String[] okVarit = {"Punainen", "Vihreä", "Sininen", "Keltainen"};
        Kasi kasi = new Kasi(omatKortit);
        return okVarit[kasi.yleisimmanVarinIndeksi()];
    }

    @Override
    public String nimi() {
        // kirjoita tänne nimimerkkisi, jonka haluat mahdollisesti näkyvän 
        // myös muualla

        return "cyanidesayonara";
    }

}
