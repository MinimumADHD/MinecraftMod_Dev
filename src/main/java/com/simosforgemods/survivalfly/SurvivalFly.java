import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;

public class SurvivalFly
{
    private static final Minecraft MC = Minecraft.getInstance();
    public SurvivalFly()
    {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onClientTick(TickEvent.ClientTickEvent event)
    {
        if (MC.player != null && MC.currentScreen == null)
        {
            MC.player.abilities.allowFlying = true;

            if (MC.player.abilities.isCreativeMode)
            {
                MC.player.abilities.setFlySpeed(0.05f);
            }
            else
            {
                MC.player.abilities.setFlySpeed(0.1f);
            }
        }
    }
}