package josscoder.ultimatetroll;

import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.TextFormat;
import com.denzelcode.form.FormAPI;
import josscoder.ultimatetroll.command.TrollCommand;
import josscoder.ultimatetroll.trap.TrapHelper;
import lombok.Getter;

public class UltimateTrollPlugin extends PluginBase {

    @Getter
    private static UltimateTrollPlugin instance;

    @Getter
    private TrapHelper trapHelper;

    @Override
    public void onLoad() {
        instance = this;
        trapHelper = new TrapHelper();
    }

    @Override
    public void onEnable() {
        FormAPI.init(this);
        trapHelper.init();
        getServer().getCommandMap().register("troll", new TrollCommand());
        getLogger().info(TextFormat.GREEN + "UltimateTroll has been enabled");
    }

    @Override
    public void onDisable() {
        trapHelper.close();
        getLogger().info(TextFormat.RED + "UltimateTroll has been disabled");
    }
}