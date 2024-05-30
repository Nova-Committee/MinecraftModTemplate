package committee.nova.mods.examplemod;

import committee.nova.mods.examplemod.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(
        name = Const.MOD_NAME
        , modid = Const.MOD_ID
        , acceptedMinecraftVersions = "[1.12,]"
        , useMetadata = true // 确保mixin载入
        , dependencies = Const.DEPENDENCIES // 前置依赖
)
public class ExampleMod {

    @SidedProxy(serverSide = "committee.nova.mods.examplemod.proxy.ServerProxy", clientSide = "committee.nova.mods.examplemod.proxy.ClientProxy")
    public static CommonProxy proxy;
    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public static void init(FMLInitializationEvent event) {
        proxy.init(event);
    }
}
