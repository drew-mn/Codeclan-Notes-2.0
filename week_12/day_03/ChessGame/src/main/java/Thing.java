public class Thing {
    private static Thing ourInstance = new Thing();

    public static Thing getInstance() {
        return ourInstance;
    }

    private Thing() {
    }
}
