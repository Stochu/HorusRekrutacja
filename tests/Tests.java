import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class Tests {

    public List<Block> getBlocks() {
        List<Block> blocks = new ArrayList<>();
        blocks.add(new BlockImpl("green", "steel"));
        blocks.add(new BlockImpl("blue", "wool"));
        blocks.add(new BlockImpl("white", "steel"));
        return blocks;
    }

    @Test
    public void testIfBlockIsFoundByColor() {
        //given
        Wall wall = new Wall(getBlocks());

        //when
        Optional<Block> block = wall.findBlockByColor("green");

        //then
        if (block.isPresent()) {
            Assert.assertEquals("green", block.get().getColor());
        } else {
            Assert.fail();
        }
    }

    @Test
    public void testIfBlocksAreFoundByMaterial() {
        //given
        Wall wall = new Wall(getBlocks());

        //when
        List<Block> blocks = wall.findBlocksByMaterial("steel");

        //then
        Assert.assertEquals(2, blocks.size());
    }

    @Test
    public void testIfBlocksAreNotFoundByMaterial() {
        //given
        Wall wall = new Wall(getBlocks());

        //when
        List<Block> blocks = wall.findBlocksByMaterial("plastic");

        //then
        Assert.assertEquals(0, blocks.size());
    }

    @Test
    public void testIfCountingElementsCorrect() {
        //given
        Wall wall = new Wall(getBlocks());

        //when
        int quantity = wall.count();

        //then
        Assert.assertEquals(3, quantity);
    }
}
