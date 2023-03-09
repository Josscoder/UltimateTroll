package josscoder.ultimatetroll.trap.base;

import cn.nukkit.Player;
import cn.nukkit.block.BlockTNT;

public class TNTJailTrap extends JailTrap {

    @Override
    public void init() {
        setBlockBase(new BlockTNT());
    }

    @Override
    public String getImage() {
        return "textures/blocks/tnt_top.png";
    }

    @Override
    public void whenJailBuilt(Player target) {

    }

    @Override
    public void close() {

    }
}
