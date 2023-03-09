package josscoder.ultimatetroll.trap.base;

import cn.nukkit.Player;
import cn.nukkit.inventory.PlayerInventory;
import josscoder.ultimatetroll.trap.Trap;

public class DropAllInventoryTrap extends Trap {

    @Override
    public void init() {

    }

    @Override
    public String getImage() {
        return "textures/ui/inventory_icon.png";
    }

    @Override
    public void onExecute(Player target) {
        PlayerInventory inventory = target.getInventory();

        inventory.getContents().values().forEach(target::dropItem);
        inventory.clearAll();
        inventory.sendContents(target);
        inventory.sendHeldItem(target);
    }

    @Override
    public void close() {

    }
}

