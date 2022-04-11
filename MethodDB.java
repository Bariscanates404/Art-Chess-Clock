package SatrancSaati;

import java.util.Scanner;

public class MethodDB {
    static Scanner scanner = new Scanner(System.in);
    static boolean SiyahinSirasi = false;
    static boolean BeyazinSirasi = true;
    static boolean mainloop = true;
    static int beyazZamani = 60;
    static int siyahZamani = 60;
    static int artisMiktari = 5;
    static int secim;

    static public void threadSleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    protected static void secenekler() throws InterruptedException {
        System.out.println("-->Lutfen zaman ayari yapmak icin 1'e \n-->Kum saati modu icin 2'ye \n-->Giyotin modu icin 3'e \n" + "-->Eklemeli mod icin 4'e basiniz \n-->Cikis icin 5'e basiniz: ");
        secim = scanner.nextInt();
        if (secim >= 1 && secim <= 5) {
            switch (secim) {

                case 1:
                    adjustableTempo();
                    break;


                case 2:
                    kumSaati();
                    break;


                case 3:
                    giyotin();
                    break;

                case 4:
                    eklemeliMod();
                    break;

                case 5:
                    cikis();
                    break;

            }
        }
        else
        {
            System.out.println("Yanlis bir secim yaptiniz! Lutfen 1 ve 5 arasinda dogru bir tuslama yapiniz: ");
            secenekler();
        }
    }


    protected static void cikis() {
        System.out.println("******    ART CHESS CLOCK     ******");
        System.out.println("******    ART CHESS CLOCK     ******");
        System.out.println("          Satrancla kalin!");
        System.out.println("******    ART CHESS CLOCK     ******");
        System.out.println("******    ART CHESS CLOCK     ******");
    }

    protected static void tekrar() throws InterruptedException { // ileride oyundan sonra tekrar modu eklemek icin kullancagim.
        System.out.println("Baslangic erkanina cikis icin 1'i saati kapatmak icin lutfen 0'i tuslayin: ");
        int tekrar = scanner.nextInt();
        if (tekrar == 1) {
            secenekler();
        } else if (tekrar == 0) {
            cikis();
        }
    }


    protected static void kumSaati() throws InterruptedException {
        System.out.println("   ~~~~~ KUM SAATI MODU ~~~~~");
        System.out.println("Saati baslatmak icin 0'a basin...");
        while (true) {
            KumSaati ks1 = new KumSaati();
            Thread threadKS1 = new Thread(ks1);

            System.out.println("\n \n " + "Beyaz icin 1 Siyah icin 2");
            int kiminSirasi = scanner.nextInt();
            if (kiminSirasi == 1) {
                BeyazinSirasi = true;
                SiyahinSirasi = false;
                // siyahOynuyor.start();
            } else if (kiminSirasi == 2) {
                BeyazinSirasi = false;
                SiyahinSirasi = true;
                //  siyahOynuyor.stop();
            } else if (kiminSirasi == 0) {
                threadKS1.start();
            }
            Thread.sleep(1);
        }
    }

    protected static void eklemeliMod() throws InterruptedException {
        EklemeliMod em1 = new EklemeliMod();
        Thread threadEM1 = new Thread(em1);
        System.out.println("     ~~~~~ EKLEMELI MOD ~~~~~");
        System.out.println("Saati baslatmak icin 0'a basin...");

        while (true) {

            System.out.println("\n \n " + "Beyaz icin 1 Siyah icin 2");
            int kiminSirasi = scanner.nextInt();
            if (kiminSirasi == 1) {
                BeyazinSirasi = true;
                SiyahinSirasi = false;
            } else if (kiminSirasi == 2) {
                BeyazinSirasi = false;
                SiyahinSirasi = true;
            } else if (kiminSirasi == 0) {
                threadEM1.start();
            }
            Thread.sleep(1);
        }
    }

    protected static void giyotin() throws InterruptedException {
        giyotinModu gm1 = new giyotinModu();
        Thread threadGM1 = new Thread(gm1);
        System.out.println("   ~~~~~ GIYOTIN MODU ~~~~~");
        System.out.println("Saati baslatmak icin 0'a basin...");

        while (true) {

            System.out.println("\n \n " + "Beyaz icin 1 Siyah icin 2");
            int kiminSirasi = scanner.nextInt();
            if (kiminSirasi == 1) {
                BeyazinSirasi = true;
                SiyahinSirasi = false;
            } else if (kiminSirasi == 2) {
                BeyazinSirasi = false;
                SiyahinSirasi = true;
            } else if (kiminSirasi == 0) {
                threadGM1.start();
            }
            Thread.sleep(1);
        }
    }


    protected static void adjustableTempo() throws InterruptedException {
        System.out.println("~~~~~ Zaman kontrolu ayarlama paneline hosgeldiniz! ~~~~~");
        System.out.println("\nLutfen saniye cinsinden secim yapiniz");
        System.out.println("Beyazin zamani: ");
        beyazZamani = scanner.nextInt();
        System.out.println("Siyahin zamani: ");
        siyahZamani = scanner.nextInt();

        secenekler();

    }
}
