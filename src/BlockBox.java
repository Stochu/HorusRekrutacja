import java.util.Collections;
import java.util.List;

public class BlockBox implements CompositeBlock {

    private List<Block> blocks;

    @Override
    public List<Block> getBlocks() {
        return Collections.unmodifiableList(blocks);
    }
}
