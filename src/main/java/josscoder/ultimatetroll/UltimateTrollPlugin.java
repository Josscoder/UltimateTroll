package josscoder.ultimatetroll;

import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.TextFormat;
import com.denzelcode.form.FormAPI;
import josscoder.ultimatetroll.command.TrollCommand;
import josscoder.ultimatetroll.trap.Helper;
import lombok.Getter;

public class UltimateTrollPlugin extends PluginBase {

    @Getter
    private static UltimateTrollPlugin instance;

    @Getter
    private Helper helper;

    @Override
    public void onLoad() {
        instance = this;
        helper = new Helper();
    }

    @Override
    public void onEnable() {
        if (FormAPI.mainThread == null) { //Hack to avoid bug when you are already using this api
            FormAPI.init(this);
        }
        helper.init();
        getServer().getCommandMap().register("troll", new TrollCommand());
        getLogger().info(TextFormat.GREEN + "UltimateTroll has been enabled");
    }

    @Override
    public void onDisable() {
        helper.close();
        getLogger().info(TextFormat.RED + "UltimateTroll has been disabled");
    }
}