package com.Infinity.Nexus.Miner.config;

import com.Infinity.Nexus.Miner.InfinityNexusMiner;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

import java.util.List;

@Mod.EventBusSubscriber(modid = InfinityNexusMiner.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config
{
    //Instancia a Configuração
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    //Define a Constante de Configuração
    private static final ForgeConfigSpec.BooleanValue AS_INFINITY_MOD_INSTALLED = BUILDER.comment("O Mod Infinity Nexus Machines esta istalado?").define("as_infinity_mod_installed", false);
    private static final ForgeConfigSpec.ConfigValue<List<String>> ITEM_COMPONENT_LIST = BUILDER
            .comment("Lista de Itens Componentes para a Mineradora do Level 1 ao 9")
            .define("list_of_components", List.of(
                    "infinity_nexus_core:redstone_component",
                    "infinity_nexus_core:basic_component",
                    "infinity_nexus_core:reinforced_component",
                    "infinity_nexus_core:logic_component",
                    "infinity_nexus_core:advanced_component",
                    "infinity_nexus_core:refined_component",
                    "infinity_nexus_core:integral_component",
                    "infinity_nexus_core:infinity_component",
                    "infinity_nexus_core:ancestral_component"
            ));
    private static final ForgeConfigSpec.BooleanValue MINER_MINE_COST_COMPONENT_DURABILITY = BUILDER
            .comment("Define ao minerar o componente de perderá durabilidade (se o componente não for um item duravel ele será consumido)")
            .define("miner_mining_cost_component_durability", false);
    private static final ForgeConfigSpec.ConfigValue<List<String>> ITEM_UPGRADE_LIST = BUILDER
            .comment("Lista de Itens Upgrades para a Mineradora 1° = speed, 2° = Eficiencia de energia")
            .define("list_of_upgrades", List.of(
                    "infinity_nexus_core:speed_upgrade",
                    "infinity_nexus_core:strength_upgrade"
            ));
    private static final ForgeConfigSpec.ConfigValue<List<String>> BLOCK_STRUCTURE_LIST = BUILDER
            .comment("Lista de Blocos de estrutura para a Mineradora do Level 1 ao 9")
            .define("list_of_structures", List.of(
            "infinity_nexus_miner:wood_structure",
            "infinity_nexus_miner:stone_structure",
            "infinity_nexus_miner:copper_structure",
            "infinity_nexus_miner:iron_structure",
            "infinity_nexus_miner:gold_structure",
            "infinity_nexus_miner:quartz_structure",
            "infinity_nexus_miner:diamond_structure",
            "infinity_nexus_miner:emerald_structure",
            "infinity_nexus_miner:netherite_structure"
    ));

    private static final ForgeConfigSpec.IntValue MAX_FORTUNE_LEVEL = BUILDER.comment("Define o nivel maximo de fortuna da Mineradora").defineInRange("max_fortune_level", 9, 1, 9);
    private static final ForgeConfigSpec.IntValue MINER_ENERGY = BUILDER.comment("Define a quantidade de energia que a Mineradora vai armazenar").defineInRange("miner_energy_capacity", 150000, 1, Integer.MAX_VALUE);
    private static final ForgeConfigSpec.IntValue MINER_ENERGY_TRANSFER = BUILDER.comment("Define a quantidade de energia que a Mineradora vai transferir").defineInRange("miner_energy_transfer", 100000, 1, Integer.MAX_VALUE);
    private static final ForgeConfigSpec.IntValue MINER_FUEL_MULTIPLIER = BUILDER.comment("Define o valor que a Mineradora vai multiplicar a geração de combustível. Ex: Carvão == 1600 * miner_fuel_multiplier = Energia que um caravão vai gerar").defineInRange("miner_fuel_multiplier", 5, 1, Integer.MAX_VALUE);

    private static final ForgeConfigSpec.IntValue ENERGY_PER_OPERATION_BASE  = BUILDER.comment("Define a quantidade de energia que a Mineradora consumirá por operação (a base para os calculos)").defineInRange("miner_energy_per_operation", 100, 1, Integer.MAX_VALUE);
    private static final ForgeConfigSpec.BooleanValue CAN_BE_USER_SILK_TOUCH  = BUILDER.comment("Define a se a Mineradora pode ou não pegar minerios com Toque Suave").define("miner_can_be_use_silk_touch", false);
    //Builda o Arquivo
    public static final ForgeConfigSpec SPEC = BUILDER.build();


    //Cria as Variaveis de Configuração
    public static boolean as_infinity_mod_installed;
    public static List<String> list_of_components;
    public static List<String> list_of_upgrades;
    public static List<String> list_of_structures;
    public static int max_fortune_level;

    public static int miner_energy_capacity;
    public static int miner_energy_transfer;
    public static int miner_fuel_multiplier;
    public static boolean miner_mining_cost_component_durability;

    public static int energy_per_operation_base;
    public static boolean miner_can_be_use_silk_touch;


    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
        //Carrega as variaveis de Configuração para a memoria para uso posterior
        as_infinity_mod_installed = AS_INFINITY_MOD_INSTALLED.get();

        list_of_components = ITEM_COMPONENT_LIST.get();
        list_of_upgrades = ITEM_UPGRADE_LIST.get();
        list_of_structures = BLOCK_STRUCTURE_LIST.get();

        max_fortune_level = MAX_FORTUNE_LEVEL.get();

        miner_energy_capacity = MINER_ENERGY.get();
        miner_energy_transfer = MINER_ENERGY_TRANSFER.get();
        miner_fuel_multiplier = MINER_FUEL_MULTIPLIER.get();

        miner_mining_cost_component_durability = MINER_MINE_COST_COMPONENT_DURABILITY.get();

        energy_per_operation_base = ENERGY_PER_OPERATION_BASE.get();
        miner_can_be_use_silk_touch = CAN_BE_USER_SILK_TOUCH.get();
    }
}
