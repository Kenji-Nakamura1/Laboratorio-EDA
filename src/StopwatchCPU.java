public class StopwatchCPU {
    private static final double NANOSECONDS_PER_SECOND = 1000000000.0;

    private final long start;

    public StopwatchCPU() {
        start = System.nanoTime();
    }

    public double elapsedTime() {
        long now = System.nanoTime();
        return (now - start) / NANOSECONDS_PER_SECOND;
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Por favor, ingresa un número n como argumento.");
            return;
        }

        int n = Integer.parseInt(args[0]);

        StopwatchCPU timer1 = new StopwatchCPU();
        double sum1 = 0.0;
        for (int i = 1; i <= n; i++) {
            sum1 += Math.sqrt(i);
        }
        double time1 = timer1.elapsedTime();
        System.out.printf("%e (%.6f seconds)\n", sum1, time1);

        StopwatchCPU timer2 = new StopwatchCPU();
        double sum2 = 0.0;
        for (int i = 1; i <= n; i++) {
            sum2 += Math.pow(i, 0.5);
        }
        double time2 = timer2.elapsedTime();
        System.out.printf("%e (%.6f seconds)\n", sum2, time2);
    }
}