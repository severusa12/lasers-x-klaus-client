package oyvey.client.modules.combat;

import oyvey.client.modules.Module;
import net.minecraft.network.packet.c2s.play.PlayerInteractBlockC2SPacket;
import net.minecraft.util.hit.BlockHitResult;

public class AnchorMacro extends Module {
    public AnchorMacro() {
        super(\"AnchorMacro\", \"Advanced crystal/anchor placement\", Category.COMBAT);
    }

    @Override
    public void onUpdate() {


        BlockHitResult hit = mc.crosshairTarget instanceof BlockHitResult ? (BlockHitResult) mc.crosshairTarget : null;
        
        if (hit != null) {
            mc.getNetworkHandler().sendPacket(new PlayerInteractBlockC2SPacket(
                net.minecraft.util.Hand.MAIN_HAND, 
                hit, 
                0
            ));
            mc.player.swingHand(net.minecraft.util.Hand.MAIN_HAND);
        }
    }
}
