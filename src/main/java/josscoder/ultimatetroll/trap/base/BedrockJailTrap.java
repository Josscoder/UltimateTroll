package josscoder.ultimatetroll.trap.base;

import cn.nukkit.Player;
import cn.nukkit.block.BlockBedrock;

public class BedrockJailTrap extends JailTrap {

    @Override
    public void init() {
        setBlockBase(new BlockBedrock());
    }

    @Override
    public String getImage() {
        return "textures/blocks/bedrock.png";
    }

    @Override
    public void whenJailBuilt(Player target) {

    }

    @Override
    public void close() {

    }
}
