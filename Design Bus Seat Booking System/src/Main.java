public class Main {
    public static void main(String[] args) {
        BusBooking bus = new BusBooking(20);

        bus.toggle("B3");
        bus.toggle("A3");

        System.out.println(bus.getTotalTime());
        System.out.println(bus.getMinTime());

        bus.toggle("C3");
        bus.toggle("D3");

        System.out.println(bus.getTotalTime());
        System.out.println(bus.getMinTime());
    }
}
