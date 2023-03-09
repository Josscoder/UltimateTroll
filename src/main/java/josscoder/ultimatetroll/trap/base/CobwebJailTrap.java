package josscoder.ultimatetroll.trap.base;

import cn.nukkit.Player;
import cn.nukkit.block.BlockCobweb;

public class CobwebJailTrap extends JailTrap {

    @Override
    public void init() {
        setBlockBase(new BlockCobweb());
    }

    @Override
    public String getImage() {
        return "textures/blocks/web.png";
    }

    @Override
    public void close() {

    }

    @Override
    public void whenJailBuilt(Player target) {

    }
}
