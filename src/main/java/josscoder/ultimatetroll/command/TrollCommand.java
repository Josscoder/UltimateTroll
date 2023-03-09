package josscoder.ultimatetroll.command;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.command.data.CommandParamType;
import cn.nukkit.command.data.CommandParameter;
import cn.nukkit.utils.TextFormat;
import com.denzelcode.form.FormAPI;
import com.denzelcode.form.element.Button;
import com.denzelcode.form.element.Dropdown;
import com.denzelcode.form.window.SimpleWindowForm;
import josscoder.ultimatetroll.UltimateTrollPlugin;
import josscoder.ultimatetroll.trap.Trap;
import josscoder.ultimatetroll.trap.Helper;

import java.util.List;
import java.util.stream.Collectors;

public class TrollCommand extends Command {

    public TrollCommand() {
        super("troll", "Troll Command", "/troll help", new String[]{"trap"});
        setPermission("troll.command");
        addCommandParameters("default", new CommandParameter[]{
                CommandParameter.newType("player", false, CommandParamType.TARGET)
        });
    }

    @Override
    public boolean execute(CommandSender sender, String s, String[] args) {
        if (!(sender instanceof Player) || !testPermission(sender)) {
            return false;
        }

        Player player = (Player) sender;

        if (args.length == 0) {
            selectPlayer(player);
            return true;
        }

        String targetName = args[0];

        Player target = sender.getServer().getPlayer(targetName);

        if (target == null) {
            player.sendMessage(TextFormat.RED + "That player is offline");
            return false;
        }

        selectTrap(player, target);

        return true;
    }

    private void selectPlayer(Player sender) {
        Server server = Server.getInstance();

        List<String> playerList = server.getOnlinePlayers().values()
                .stream()
                .map(Player::getName)
                .collect(Collectors.toList());

        FormAPI.customWindowForm(TextFormat.BOLD.toString() + TextFormat.GOLD + "SELECT A PLAYER")
                .addDropdown("targetName", "", playerList)
                .addHandler(event -> {
                    if (event.wasClosed()) {
                        return;
                    }

                    Dropdown targetNameDropdown = event.getForm().getElement("targetName");
                    int targetIndex = targetNameDropdown == null ? 0 : targetNameDropdown.getValue();
                    String targetName = playerList.get(targetIndex);

                    server.dispatchCommand(sender, "troll " + targetName);
                })
                .sendTo(sender);
    }

    private void selectTrap(Player sender, Player target) {
        SimpleWindowForm windowForm = FormAPI.simpleWindowForm(TextFormat.colorize(String.format(
                "&6&lSELECT A TRAP&r&8 | %s",
                target.getName()
        )));

        Helper helper = UltimateTrollPlugin.getInstance().getHelper();

        helper.getTrapList().forEach(trap -> windowForm.addButton(trap.getId(), TextFormat.colorize(String.format(
                "&9&l%s&r\n&3Click to Select",
                trap.getName()
        )), trap.getImage()));

        windowForm.addHandler(event -> {
            if (event.wasClosed()) {
                return;
            }

            Button button = event.getButton();
            if (button == null) {
                return;
            }

            String buttonName = button.getName();

            Trap trap = helper.getTrap(buttonName);
            if (trap == null) {
                return;
            }

            trap.execute(target, sender);
        });
        windowForm.sendTo(sender);
    }
}
