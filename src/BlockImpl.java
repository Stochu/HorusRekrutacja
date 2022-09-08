public class BlockImpl implements Block {

    private String color;
    private String material;

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getMaterial() {
        return material;
    }
}
