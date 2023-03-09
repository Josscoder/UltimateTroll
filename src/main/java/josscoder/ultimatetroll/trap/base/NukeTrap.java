package josscoder.ultimatetroll.trap.base;

import cn.nukkit.Player;
import cn.nukkit.entity.Entity;
import cn.nukkit.entity.item.EntityPrimedTNT;
import cn.nukkit.nbt.tag.CompoundTag;
import josscoder.ultimatetroll.trap.Trap;

public class NukeTrap extends Trap {

    @Override
    public void init() {

    }

    @Override
    public String getImage() {
        return "textures/blocks/tnt_side.png";
    }

    @Override
    public void onExecute(Player target) {
        CompoundTag nbt = Entity.getDefaultNBT(target.getPosition().clone().add(0, 1));

        for (int i = 0; i <= 10; i++) {
            EntityPrimedTNT primedTNT = new EntityPrimedTNT(target.getChunk(), nbt);
            primedTNT.spawnToAll();
        }
    }

    @Override
    public void close() {

    }
}

