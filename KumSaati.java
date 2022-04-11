package SatrancSaati;

public class KumSaati extends SatrancSaatiRunner implements Runnable {

    @Override
    public void run() {
        while (mainloop) {
            while (BeyazinSirasi) {
                System.out.println("***Hamle Beyazda***");
                siyahZamani++;
                beyazZamani--;
                System.out.print("Beyaz: " + beyazZamani + " ");
                System.out.print("Siyah: " + siyahZamani);
                System.out.println();
                if (beyazZamani <= 0 || siyahZamani <= 0) {
                    mainloop = false;
                    BeyazinSirasi = false;
                    SiyahinSirasi = false;
                    System.out.println();
                }
                MethodDB.threadSleep();

                while (SiyahinSirasi) {
                    System.out.println("***Hamle Siyahta***");
                    beyazZamani++;
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
                System.out.println();
            }
        }
    }
}