package com.Infinity.Nexus.Miner.config;

import com.Infinity.Nexus.Miner.InfinityNexusMiner;
import com.Infinity.Nexus.Miner.block.entity.MinerBlockEntity;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
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

    private static final ForgeConfigSpec.BooleanValue MINER_MINE_COST_COMPONENT_DURABILITY = BUILDER
            .comment("Define ao minerar o componente de perderá durabilidade (se o componente não for um item duravel ele será consumido)")
            .define("miner_mining_cost_component_durability", false);
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
    private static final ForgeConfigSpec.IntValue MAX_PROGRESS = BUILDER.comment("Define o delay maximo de progresso da Mineradora").defineInRange("max_progress", 120, 1, Integer.MAX_VALUE);
    private static final ForgeConfigSpec.IntValue CRYSTAL_CHANCE = BUILDER.comment("Fator de chance de um cristal ser gerado. Quanto menor, maior a chance de cair cristais! Padrão = 100.").defineInRange("crystal_chance", 100, 1, Integer.MAX_VALUE);
    //Builda o Arquivo
    public static final ForgeConfigSpec SPEC = BUILDER.build();


    //Cria as Variaveis de Configuração
    public static boolean as_infinity_mod_installed;
    public static List<String> list_of_structures;
    public static int max_fortune_level;

    public static int miner_energy_capacity;
    public static int miner_energy_transfer;
    public static int miner_fuel_multiplier;
    public static boolean miner_mining_cost_component_durability;

    public static int energy_per_operation_base;
    public static boolean miner_can_be_use_silk_touch;

    public static int max_progress;
    public static int crystal_chance;


    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
        //Carrega as variaveis de Configuração para a memoria para uso posterior
        as_infinity_mod_installed = AS_INFINITY_MOD_INSTALLED.get();

        list_of_structures = BLOCK_STRUCTURE_LIST.get();

        max_fortune_level = MAX_FORTUNE_LEVEL.get();

        miner_energy_capacity = MINER_ENERGY.get();
        miner_energy_transfer = MINER_ENERGY_TRANSFER.get();
        miner_fuel_multiplier = MINER_FUEL_MULTIPLIER.get();

        miner_mining_cost_component_durability = MINER_MINE_COST_COMPONENT_DURABILITY.get();

        energy_per_operation_base = ENERGY_PER_OPERATION_BASE.get();
        miner_can_be_use_silk_touch = CAN_BE_USER_SILK_TOUCH.get();

        max_progress = MAX_PROGRESS.get();
        crystal_chance = CRYSTAL_CHANCE.get();
    }

    public static void reloadConfig(CommandSourceStack source) {
        source.sendSystemMessage(Component.literal("§eReloading: §bStructures..."));
        source.sendSystemMessage(Component.literal("§cStructures unloaded: §c"+ list_of_structures));
        list_of_structures = BLOCK_STRUCTURE_LIST.get();
        source.sendSystemMessage(Component.literal("§bStructures loaded: §a"+ list_of_structures));

        source.sendSystemMessage(Component.literal("§eReloading: §bMax Fortune Level..."));
        source.sendSystemMessage(Component.literal("§c"+ max_fortune_level +" §cMax Fortune Level unloaded!"));
        max_fortune_level = MAX_FORTUNE_LEVEL.get();
        source.sendSystemMessage(Component.literal("§a"+ max_fortune_level +" §bMax Fortune Level loaded!"));

        source.sendSystemMessage(Component.literal("§eReloading: §bMiner Fuel Multiplier..."));
        source.sendSystemMessage(Component.literal("§c"+ miner_fuel_multiplier +" §cMiner Fuel Multiplier unloaded!"));
        miner_fuel_multiplier = MINER_FUEL_MULTIPLIER.get();
        source.sendSystemMessage(Component.literal("§a"+ miner_fuel_multiplier +" §bMiner Fuel Multiplier loaded!"));

        source.sendSystemMessage(Component.literal("§eReloading: §bMiner Operation Cost Component Durability..."));
        source.sendSystemMessage(Component.literal("§c"+ miner_mining_cost_component_durability +" §cMiner Operation Cost Component Durability unloaded!"));
        miner_mining_cost_component_durability = MINER_MINE_COST_COMPONENT_DURABILITY.get();
        source.sendSystemMessage(Component.literal("§a"+ miner_mining_cost_component_durability +" §bMiner Operation Cost Component Durability loaded!"));

        source.sendSystemMessage(Component.literal("§eReloading: §bMiner Energy Per Operation..."));
        source.sendSystemMessage(Component.literal("§c"+ energy_per_operation_base +" §cMiner Energy Per Operation unloaded!"));
        energy_per_operation_base = ENERGY_PER_OPERATION_BASE.get();
        source.sendSystemMessage(Component.literal("§a"+ energy_per_operation_base +" §bMiner Energy Per Operation loaded!"));

        source.sendSystemMessage(Component.literal("§eReloading: §bMiner Can Be Use Silk Touch..."));
        source.sendSystemMessage(Component.literal("§c"+ miner_can_be_use_silk_touch +" §cMiner Can Be Use Silk Touch unloaded!"));
        miner_can_be_use_silk_touch = CAN_BE_USER_SILK_TOUCH.get();
        source.sendSystemMessage(Component.literal("§a"+ miner_can_be_use_silk_touch +" §bMiner Can Be Use Silk Touch loaded!"));

        source.sendSystemMessage(Component.literal("§eReloading: §bMax Progress..."));
        source.sendSystemMessage(Component.literal("§c"+ max_progress +" §cMax Progress unloaded!"));
        max_progress = MAX_PROGRESS.get();
        source.sendSystemMessage(Component.literal("§a"+ max_progress +" §bMax Progress loaded!"));
    }
}
