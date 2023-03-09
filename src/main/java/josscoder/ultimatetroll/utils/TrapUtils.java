package josscoder.ultimatetroll.utils;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.block.BlockFire;
import cn.nukkit.entity.Entity;
import cn.nukkit.level.Level;
import cn.nukkit.level.Position;
import cn.nukkit.level.Sound;
import cn.nukkit.network.protocol.AddEntityPacket;
import cn.nukkit.network.protocol.DataPacket;
import cn.nukkit.network.protocol.SetTimePacket;

import java.util.concurrent.ThreadLocalRandom;

public class TrapUtils {

    public static void broadcastPacket(DataPacket packet) {
        Server.broadcastPacket(Server.getInstance().getOnlinePlayers().values(), packet);
    }

    public static void spawnLightning(Position position) {
        if (!position.isValid()) {
            return;
        }

        AddEntityPacket packet = new AddEntityPacket();
        packet.entityRuntimeId = Entity.entityCount++;
        packet.type = 93; // minecraft:lightning_bolt
        packet.x = (float) position.getFloorX();
        packet.y = (float) position.getFloorY();
        packet.z = (float) position.getFloorZ();
        broadcastPacket(packet);

        position.getLevel().addSound(position, Sound.AMBIENT_WEATHER_LIGHTNING_IMPACT);
    }

    public static void setTime(Player player, int time) {
        if (player == null) {
            return;
        }

        SetTimePacket packet = new SetTimePacket();
        packet.time = time;
        player.dataPacket(packet);
    }

    public static void resetTime(Player player) {
        if (player == null) {
            return;
        }

        setTime(player, player.getLevel().getTime());
    }

    public static void burn(Position position) {
        if (!position.isValid()) {
            return;
        }

        Level level = position.getLevel();

        BlockFire fire = new BlockFire();
        fire.x = position.getX();
        fire.y = position.getY();
        fire.z = position.getZ();
        fire.level = level;

        level.setBlock(fire, fire, true);
        level.scheduleUpdate(fire, fire.tickRate() + ThreadLocalRandom.current().nextInt(10));
    }
}
