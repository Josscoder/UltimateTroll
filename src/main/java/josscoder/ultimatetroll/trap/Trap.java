package josscoder.ultimatetroll.trap;

public abstract class Trap implements ITrap {

    @Override
    public String getId() {
        return getClass().getSimpleName().replaceAll("([a-z])([A-Z])", "$1_$2").toLowerCase();
    }

    @Override
    public String getName() {
        return getClass().getSimpleName().replace("Trap", "").replaceAll("([a-z])([A-Z])", "$1 $2");
    }

    @Override
    public String getImage() {
        return "textures/blocks/barrier.png";
    }
}
