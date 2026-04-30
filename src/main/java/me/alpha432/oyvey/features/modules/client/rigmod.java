package oyvey.client.modules.combat;

import oyvey.client.modules.Module;
import net.minecraft.network.packet.c2s.play.PlayerInteractEntityC2SPacket;

public class RigMod extends Module {
    public RigMod() {
        super(\"RigMod\", \"Guaranteed hits on DonutSMP\", Category.COMBAT);
    }

    @Override
    public void onUpdate() {
        if (mc.player == null || mc.world == null) return;
        


        if (targetManager.getTarget() != null) {
            mc.getNetworkHandler().sendPacket(PlayerInteractEntityC2SPacket.attack(targetManager.getTarget(), false));
            mc.player.swingHand(net.minecraft.util.Hand.MAIN_HAND);
        }
    }
}
