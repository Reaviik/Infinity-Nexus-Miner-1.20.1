package com.Infinity.Nexus.Miner.config;

import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.config.ModConfigEvent;

import java.util.List;
import java.util.Set;

public class configExemple {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    //Define a Constante de Configuração
    private static final ForgeConfigSpec.BooleanValue BOOLEAN_VALUE = BUILDER.comment("Esta é uma configuração boleana True/False").define("booleanConfig", true);
    private static final ForgeConfigSpec.IntValue RANGED_NUMBER = BUILDER.comment("Numero com alcançe do valor minimo ao maximo 1, 2").defineInRange("rangedNumber", 1, 1, 2);
    public static final ForgeConfigSpec.ConfigValue<String> STRING_VALUE = BUILDER.comment("Uma configuração de string").define("string", "O valor em texto");

    private static final ForgeConfigSpec.ConfigValue<List<String>> ITEM_COMPONENT_LIST = BUILDER.comment("Lista de Itens Componentes para a Mineradora do Level 1 ao 9").define("list_of_components", List.of("minecraft:iron_ingot", "minecraft:gold_ingot"));
    private static final ForgeConfigSpec.ConfigValue<List<String>> ITEM_UPGRADE_LIST = BUILDER.comment("Lista de Itens Upgrades para a Mineradora 1° = speed, 2° = Eficiencia de energia").define("list_of_components", List.of("minecraft:lightning_rod", "minecraft:end_rod"));
    private static final ForgeConfigSpec.ConfigValue<List<String>> BLOCK_STRUCTURE_LIST = BUILDER.comment("Lista de Blocos de estrutura para a Mineradora do Level 1 ao 9").define("list_of_structures", List.of("minecraft:oak_log","minecraft:stone","minecraft:copper_block","minecraft:iron_block", "minecraft:gold_block","minecraft:quartz_block", "minecraft:diamond_block", "minecraft:emerald_block", "minecraft:netherite_block"));
    //Builda o Arquivo
    public static final ForgeConfigSpec SPEC = BUILDER.build();

    //Cria as Variaveis de Configuração
    public static boolean boleanConfig;
    public static int rangedNumber;
    public static String string;
    public static Set<Item> items;
    public static List<String> list_of_components;
    public static List<String> list_of_upgrades;
    public static List<String> list_of_structures;

    //private static boolean validateItemName(final Object obj)
    //{ return obj instanceof final String itemName && ForgeRegistries.ITEMS.containsKey(new ResourceLocation(itemName));}


    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
        //boleanConfig = BOOLEAN_VALUE.get();
        //rangedNumber = RANGED_NUMBER.get();
        //string = STRING_VALUE.get();

        // convert the list of strings into a set of items
        //items = ITEM_STRING_LIST.get().stream().map(itemName -> ForgeRegistries.ITEMS.getValue(new ResourceLocation(itemName))).collect(Collectors.toSet());
        //convert the list of strings into a set of blocks

        list_of_components = ITEM_COMPONENT_LIST.get();
        list_of_upgrades = ITEM_UPGRADE_LIST.get();
        list_of_structures = BLOCK_STRUCTURE_LIST.get();
    }
}
