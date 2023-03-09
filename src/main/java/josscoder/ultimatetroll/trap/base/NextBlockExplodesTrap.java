package josscoder.ultimatetroll.trap.base;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.block.BlockID;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerInteractEvent;
import cn.nukkit.event.player.PlayerQuitEvent;
import cn.nukkit.level.Explosion;
import josscoder.ultimatetroll.UltimateTrollPlugin;
import josscoder.ultimatetroll.trap.Trap;

public class NextBlockExplodesTrap extends Trap implements Listener {

    private static final String NBT_NEXT_BLOCK_EXPLODES = "nbt_next_block_explodes";

    @Override
    public void init() {
        Server.getInstance().getPluginManager().registerEvents(this, UltimateTrollPlugin.getInstance());
    }

    @Override
    public String getImage() {
        return "https://i.imgur.com/u85YEt6.png";
    }

    @Override
    public void onExecute(Player target) {
        target.namedTag.putBoolean(NBT_NEXT_BLOCK_EXPLODES, true);
    }

    @EventHandler(priority = EventPriority.LOWEST)
    private void onInteractBlock(PlayerInteractEvent event) {
        if (event.isCancelled() || event.getBlock().getId() == BlockID.AIR) {
            return;
        }

        Player player = event.getPlayer();

        if (!player.namedTag.contains(NBT_NEXT_BLOCK_EXPLODES) || !player.namedTag.getBoolean(NBT_NEXT_BLOCK_EXPLODES)) {
            return;
        }

        player.namedTag.putBoolean(NBT_NEXT_BLOCK_EXPLODES, false);
        new Explosion(player.getLocation(), 10, null).explode();
    }

    @EventHandler
    private void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        if (player.namedTag == null) {
            return;
        }

        player.namedTag.putBoolean(NBT_NEXT_BLOCK_EXPLODES, false);
    }

    @Override
    public void close() {

    }
}

