package com.Infinity.Nexus.Miner.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;

public class MinerTP {
    public MinerTP(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("infinitynexusminer")
                .then(Commands.literal("minertp")
                        .then(Commands.argument("player", EntityArgument.player())
                                .then(Commands.argument("level", StringArgumentType.string()) // Nome da dimensão
                                        .then(Commands.argument("x", DoubleArgumentType.doubleArg())
                                                .then(Commands.argument("y", DoubleArgumentType.doubleArg())
                                                        .then(Commands.argument("z", DoubleArgumentType.doubleArg())
                                                                .executes(this::execute)
                                                        )
                                                )
                                        )
                                )
                        )
                )
        );
    }

    private int execute(CommandContext<CommandSourceStack> context) {
        try {
            if (context.getSource().isPlayer()){
                context.getSource().sendFailure(Component.literal("Comando indisponível para jogadores"));
                return 0;
            }
            ServerPlayer player = EntityArgument.getPlayer(context, "player");
            String levelName = StringArgumentType.getString(context, "level");
            double x = DoubleArgumentType.getDouble(context, "x");
            double y = DoubleArgumentType.getDouble(context, "y");
            double z = DoubleArgumentType.getDouble(context, "z");

            // Obtém o nível (dimensão) pelo nome fornecido
            ResourceKey<Level> dimensionKey = ResourceKey.create(net.minecraft.core.registries.Registries.DIMENSION, new ResourceLocation(levelName));
            ServerLevel targetWorld = player.getServer().getLevel(dimensionKey);

            if (targetWorld == null) {
                context.getSource().sendFailure(Component.literal("Dimensão inválida: " + levelName));
                return 0;
            }
            player.teleportTo(targetWorld, x, y, z, player.getYRot(), player.getXRot());


            context.getSource().sendSuccess(() -> Component.literal("Teleportado com sucesso para a mineradora!"), true);
            return 1;
        } catch (Exception e) {
            context.getSource().sendFailure(Component.literal("Erro ao teleportar o jogador!"));
            return 0;
        }
    }
}
