package josscoder.ultimatetroll.trap.base;

import cn.nukkit.Player;
import cn.nukkit.inventory.PlayerInventory;
import cn.nukkit.item.Item;
import josscoder.ultimatetroll.trap.Trap;

import java.util.*;

public class ShuffleInventoryTrap extends Trap {

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

        List<Item> list = new ArrayList<>(inventory.getContents().values());
        Collections.shuffle(list);

        Map<Integer, Item> contents = new HashMap<>();

        int i = 0;
        for (Item item : list) {
            contents.put(i, item);
            i++;
        }

        inventory.setContents(contents);

        inventory.sendArmorContents(target);
        inventory.sendContents(target);
        inventory.sendHeldItem(target);
    }

    @Override
    public void close() {

    }
}

