import java.util.Random;
public class SeedFinder {
    public static void main (String[] args) {
        long mask = (1L <<31)-1;
        for (long i = 0; i < 2*65536; i++) {
            long b = ((205749139540585L*i + 277363943098L) >> 17) & mask;
            // case where 8u = 201793413  * -b
            if ((b & 7) == 0) {
                long u = ((201793413 * -b) & mask) >> 3;
                for (long j = 0; j < 8; j++) {
                    convertToSeed(i, u + (j << 28));
                }
            }
            // case where 2u = 606856477 * (-b -1)
            else if ((b & 1) == 1) {
                long u = ((606856477 * (-b -1)) & mask) >> 1;
                convertToSeed(i, u);
                convertToSeed(i, u + (1 << 30));
            }
        }//50780870847 11622054337284
    }
    public static void convertToSeed(long i, long u) {
        int blocks = 16;
        long seed = (u << 17) + i;
        seed = 254681119335897L * seed + 120305458776662L;
        seed ^= 0x5deece66dL;
        seed &= ((1L << 48)-1);
        Random r = new Random(seed);
        long a = r.nextLong() | 1;
        long b = r.nextLong() | 1;
        if (((blocks*a+blocks*b) & ((1L << 48)-1))==0) {
            System.out.println(seed + " 1 1");
        } else if (((blocks*a-blocks*b) & ((1L << 48)-1))==0) {
            System.out.println(seed + " -1 1");
        }
    }
}