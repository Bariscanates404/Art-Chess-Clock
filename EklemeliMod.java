package SatrancSaati;

public class EklemeliMod extends SatrancSaatiRunner implements Runnable {

    @Override
    public void run() {
        while (mainloop) {
            while (BeyazinSirasi) {
                System.out.println("***Hamle Beyazda***");;
                beyazZamani--;
                System.out.print("Beyaz: " + beyazZamani + " ");
                System.out.print("Siyah: " + siyahZamani);
                System.out.println();
                if (beyazZamani <= 0 || siyahZamani <= 0) {
                    mainloop = false;
                    BeyazinSirasi = false;
                    SiyahinSirasi = false;
                }
                MethodDB.threadSleep();
            }
            if (BeyazinSirasi == false)
                beyazZamani+=artisMiktari;
            while (SiyahinSirasi) {
                System.out.println("***Hamle Siyahta***");
                siyahZamani--;
                System.out.print("Beyaz: " + beyazZamani + " ");
                System.out.print("Siyah: " + siyahZamani);
                System.out.println();
                if (beyazZamani <= 0 || siyahZamani <= 0) {
                    mainloop = false;
                    BeyazinSirasi = false;
                    SiyahinSirasi = false;
                }
                MethodDB.threadSleep();
            }
            if (SiyahinSirasi == false)
                siyahZamani+=artisMiktari;
            System.out.println();
        }
    }
}
