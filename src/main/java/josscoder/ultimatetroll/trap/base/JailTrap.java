package josscoder.ultimatetroll.trap.base;

import cn.nukkit.Player;
import cn.nukkit.block.Block;
import cn.nukkit.level.Position;
import cn.nukkit.math.Vector3;
import josscoder.ultimatetroll.trap.Trap;
import josscoder.ultimatetroll.trap.exception.TrapException;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

public abstract class JailTrap extends Trap {

    @Setter
    protected Block blockBase = null;

    @Override
    public void onExecute(Player target) {
        if (blockBase == null) {
            throw new TrapException("JailTrap blockBase is null");
        }

        Position position = target.getPosition().add(0.5, 0, 0.5);

        List<Vector3> positions = Arrays.asList(
                new Vector3(position.getX(), position.getY() - 1, position.getZ()),
                new Vector3(position.getX() + 1, position.getY(), position.getZ()),
                new Vector3(position.getX() - 1, position.getY(), position.getZ()),

                new Vector3(position.getX(), position.getY(), position.getZ() + 1),
                new Vector3(position.getX(), position.getY(), position.getZ() - 1),

                new Vector3(position.getX() + 1, position.getY() + 1, position.getZ()),
                new Vector3(position.getX() - 1, position.getY() + 1, position.getZ()),

                new Vector3(position.getX(), position.getY() + 1, position.getZ() + 1),
                new Vector3(position.getX(), position.getY() + 1, position.getZ() - 1),

                new Vector3(position.getX(), position.getY() + 2, position.getZ())
        );

        for (Vector3 value : positions) {
            position.getLevel().setBlockAt((int) value.getX(), (int) value.getY(), (int) value.getZ(),
                    blockBase.getId(), blockBase.getDamage()
            );
        }

        whenJailBuilt(target);
    }

    public abstract void whenJailBuilt(Player target);
}
