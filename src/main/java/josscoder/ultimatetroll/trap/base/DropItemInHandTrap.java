package josscoder.ultimatetroll.trap.base;

import cn.nukkit.Player;
import cn.nukkit.block.BlockAir;
import cn.nukkit.inventory.PlayerInventory;
import josscoder.ultimatetroll.trap.Trap;

public class DropItemInHandTrap extends Trap {

    @Override
    public void init() {

    }

    @Override
    public String getImage() {
        return "https://i.imgur.com/piQOP6U.png";
    }

    @Override
    public void onExecute(Player target) {
        PlayerInventory inventory = target.getInventory();

        target.dropItem(inventory.getItemInHand());
        inventory.setItemInHand(new BlockAir().toItem());
        inventory.sendContents(target);
        inventory.sendHeldItem(target);
    }

    @Override
    public void close() {

    }
}
