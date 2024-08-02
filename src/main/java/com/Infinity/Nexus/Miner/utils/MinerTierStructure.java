package com.Infinity.Nexus.Miner.utils;

import com.Infinity.Nexus.Miner.block.ModBlocksMiner;
import com.Infinity.Nexus.Miner.block.entity.MinerBlockEntity;
import com.Infinity.Nexus.Miner.config.Config;
import com.Infinity.Nexus.Miner.config.ConfigUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.registries.ForgeRegistries;

public class MinerTierStructure {

    public static boolean hasStructure(int tier, BlockPos pos, Level level, IItemHandler itemHandler) {

        switch (tier) {
            case 1:
                boolean t1 =  verificaEstrutura(pos, new BlockPos(pos.getX()-2, pos.getY()-4, pos.getZ()-2), 4, getStructureLevel(0), level, 2, tier, itemHandler);
                boolean t2 =  verificaEstrutura(pos, new BlockPos(pos.getX()+2, pos.getY()-4, pos.getZ()-2), 4, getStructureLevel(0), level, 2, tier, itemHandler);
                boolean t3 =  verificaEstrutura(pos, new BlockPos(pos.getX()+2, pos.getY()-4, pos.getZ()+2), 4, getStructureLevel(0), level, 2, tier, itemHandler);
                boolean t4 =  verificaEstrutura(pos, new BlockPos(pos.getX()-2, pos.getY()-4, pos.getZ()+2), 4, getStructureLevel(0), level, 2, tier, itemHandler);
                return t1 && t2 && t3 && t4;
            case 2:
                boolean t5 = verificaEstrutura(pos, new BlockPos(pos.getX()-2, pos.getY()-4, pos.getZ()-2), 4, getStructureLevel(1), level, 2, tier, itemHandler);
                boolean t6 = verificaEstrutura(pos, new BlockPos(pos.getX()+2, pos.getY()-4, pos.getZ()-2), 4, getStructureLevel(1), level, 2, tier, itemHandler);
                boolean t7 = verificaEstrutura(pos, new BlockPos(pos.getX()+2, pos.getY()-4, pos.getZ()+2), 4, getStructureLevel(1), level, 2, tier, itemHandler);
                boolean t8 = verificaEstrutura(pos, new BlockPos(pos.getX()-2, pos.getY()-4, pos.getZ()+2), 4, getStructureLevel(1), level, 2, tier, itemHandler);
                return t5 && t6 && t7 && t8;
            case 3:
                boolean t9  = verificaEstrutura(pos, new BlockPos(pos.getX()-3, pos.getY()-6, pos.getZ()-3), 6, getStructureLevel(2), level, 3, tier, itemHandler);
                boolean t10 = verificaEstrutura(pos, new BlockPos(pos.getX()+3, pos.getY()-6, pos.getZ()-3), 6, getStructureLevel(2), level, 3, tier, itemHandler);
                boolean t11 = verificaEstrutura(pos, new BlockPos(pos.getX()+3, pos.getY()-6, pos.getZ()+3), 6, getStructureLevel(2), level, 3, tier, itemHandler);
                boolean t12 = verificaEstrutura(pos, new BlockPos(pos.getX()-3, pos.getY()-6, pos.getZ()+3), 6, getStructureLevel(2), level, 3, tier, itemHandler);
                return t9 && t10 && t11 && t12;
            case 4:
                boolean t13 = verificaEstrutura(pos, new BlockPos(pos.getX()-3, pos.getY()-6, pos.getZ()-3), 6, getStructureLevel(3), level, 3, tier, itemHandler);
                boolean t14 = verificaEstrutura(pos, new BlockPos(pos.getX()+3, pos.getY()-6, pos.getZ()-3), 6, getStructureLevel(3), level, 3, tier, itemHandler);
                boolean t15 = verificaEstrutura(pos, new BlockPos(pos.getX()+3, pos.getY()-6, pos.getZ()+3), 6, getStructureLevel(3), level, 3, tier, itemHandler);
                boolean t16 = verificaEstrutura(pos, new BlockPos(pos.getX()-3, pos.getY()-6, pos.getZ()+3), 6, getStructureLevel(3), level, 3, tier, itemHandler);
                return t13 && t14 && t15 && t16;
            case 5:
                boolean t17 = verificaEstrutura(pos, new BlockPos(pos.getX()-4, pos.getY()-8, pos.getZ()-4), 8, getStructureLevel(4), level, 4, tier, itemHandler);
                boolean t18 = verificaEstrutura(pos, new BlockPos(pos.getX()+4, pos.getY()-8, pos.getZ()-4), 8, getStructureLevel(4), level, 4, tier, itemHandler);
                boolean t19 = verificaEstrutura(pos, new BlockPos(pos.getX()+4, pos.getY()-8, pos.getZ()+4), 8, getStructureLevel(4), level, 4, tier, itemHandler);
                boolean t20 = verificaEstrutura(pos, new BlockPos(pos.getX()-4, pos.getY()-8, pos.getZ()+4), 8, getStructureLevel(4), level, 4, tier, itemHandler);
                return t17 && t18 && t19 && t20;
            case 6:
                boolean t21 = verificaEstrutura(pos, new BlockPos(pos.getX()-4, pos.getY()-8, pos.getZ()-4), 8, getStructureLevel(5), level,  4, tier, itemHandler);
                boolean t22 = verificaEstrutura(pos, new BlockPos(pos.getX()+4, pos.getY()-8, pos.getZ()-4), 8, getStructureLevel(5), level,  4, tier, itemHandler);
                boolean t23 = verificaEstrutura(pos, new BlockPos(pos.getX()+4, pos.getY()-8, pos.getZ()+4), 8, getStructureLevel(5), level,  4, tier, itemHandler);
                boolean t24 = verificaEstrutura(pos, new BlockPos(pos.getX()-4, pos.getY()-8, pos.getZ()+4), 8, getStructureLevel(5), level,  4, tier, itemHandler);
                return t21 && t22 && t23 && t24;
            case 7:
                boolean t25 = verificaEstrutura(pos, new BlockPos(pos.getX()-5, pos.getY()-10, pos.getZ()-5), 10, getStructureLevel(6), level,5, tier, itemHandler);
                boolean t26 = verificaEstrutura(pos, new BlockPos(pos.getX()+5, pos.getY()-10, pos.getZ()-5), 10, getStructureLevel(6), level,5, tier, itemHandler);
                boolean t27 = verificaEstrutura(pos, new BlockPos(pos.getX()+5, pos.getY()-10, pos.getZ()+5), 10, getStructureLevel(6), level,5, tier, itemHandler);
                boolean t28 = verificaEstrutura(pos, new BlockPos(pos.getX()-5, pos.getY()-10, pos.getZ()+5), 10, getStructureLevel(6), level,5, tier, itemHandler);
                return t25 && t26 && t27 && t28;
            case 8:
                boolean t29 = verificaEstrutura(pos, new BlockPos(pos.getX()-5, pos.getY()-10, pos.getZ()-5), 10, getStructureLevel(7), level, 5, tier, itemHandler);
                boolean t30 = verificaEstrutura(pos, new BlockPos(pos.getX()+5, pos.getY()-10, pos.getZ()-5), 10, getStructureLevel(7), level, 5, tier, itemHandler);
                boolean t31 = verificaEstrutura(pos, new BlockPos(pos.getX()+5, pos.getY()-10, pos.getZ()+5), 10, getStructureLevel(7), level, 5, tier, itemHandler);
                boolean t32 = verificaEstrutura(pos, new BlockPos(pos.getX()-5, pos.getY()-10, pos.getZ()+5), 10, getStructureLevel(7), level, 5, tier, itemHandler);
                return t29 && t30 && t31 && t32;
            case 9:
                boolean t33 = verificaEstrutura(pos, new BlockPos(pos.getX()-5, pos.getY()-10, pos.getZ()-5), 10, getStructureLevel(8), level, 5, tier, itemHandler);
                boolean t34 = verificaEstrutura(pos, new BlockPos(pos.getX()+5, pos.getY()-10, pos.getZ()-5), 10, getStructureLevel(8), level, 5, tier, itemHandler);
                boolean t35 = verificaEstrutura(pos, new BlockPos(pos.getX()+5, pos.getY()-10, pos.getZ()+5), 10, getStructureLevel(8), level, 5, tier, itemHandler);
                boolean t36 = verificaEstrutura(pos, new BlockPos(pos.getX()-5, pos.getY()-10, pos.getZ()+5), 10, getStructureLevel(8), level, 5, tier, itemHandler);
                return t33 && t34 && t35 && t36;
            default:
                return false;
        }
    }
    public static boolean verificaEstrutura(BlockPos pPos, BlockPos pilarPos, int height, Block blocoComposicao, Level level, int radius, int tier, IItemHandler itemHandler) {
        boolean hasPilars = true;
        boolean hasArc = true;
        boolean hasRadios = true;
        int structureSlot = MinerBlockEntity.getStructureSlot();
        for (int i = 0; i < height; i++) {
            BlockPos pos = pilarPos.above(i);
            BlockState blockState = level.getBlockState(pos);
            if (!blockState.is(blocoComposicao)) {
                hasPilars = false;
                place(blockState, pos, level, itemHandler, structureSlot, tier);
            }
        }
        int minX = pPos.getX() - radius;
        int maxX = pPos.getX() + radius;
        int minZ = pPos.getZ() - radius;
        int maxZ = pPos.getZ() + radius;

        for (int x = minX; x <= maxX; x++) {
            for (int z = minZ; z <= maxZ; z++) {
                if (x == minX || x == maxX || z == minZ || z == maxZ) {
                    BlockPos pos = new BlockPos(x, pPos.getY(), z).below();
                    BlockState blockState = level.getBlockState(pos);
                    place(blockState, pos, level, itemHandler, structureSlot, tier);
                }
            }
        }
        for (Direction direction : Direction.values()) {
            for (int i = 1; i <= radius; i++) {
                BlockPos pos = pPos.below().offset(direction.getStepX() * i, direction.getStepY() * i, direction.getStepZ() * i);
                BlockState blockState = level.getBlockState(pos);
                if (!blockState.is(blocoComposicao) && direction != Direction.DOWN && direction != Direction.UP) {
                    hasRadios = false;
                    place(blockState, pos, level, itemHandler, structureSlot, tier);
                }
            }
        }
        return hasArc && hasPilars && hasRadios;
    }
    private static void place(BlockState blockState, BlockPos pos, Level level, IItemHandler itemHandler, int structureSlot, int tier) {
        if (blockState.getBlock() == ModBlocksMiner.STRUCTURAL_BLOCK.get() || blockState.is(Blocks.AIR)){
            if(getStructureAmount(itemHandler, structureSlot, tier) >= 1) {
                removeStructureFromSlots(itemHandler, structureSlot);
                level.setBlock(pos, Block.byItem(ConfigUtils.getStructureByLevel(tier).getItem()).defaultBlockState(), 3);
            }else{
                level.setBlockAndUpdate(pos, ModBlocksMiner.STRUCTURAL_BLOCK.get().defaultBlockState());
            }
        }
    }
    private static Block getStructureLevel(int t) {
        return ForgeRegistries.BLOCKS.getValue(new ResourceLocation(Config.list_of_structures.get(t)));
    }
    private static void removeStructureFromSlots(IItemHandler itemHandler, int slot) {
        if(itemHandler.getStackInSlot(slot).getCount() > 0 && ConfigUtils.isStructure(itemHandler.getStackInSlot(slot).getItem())) {
            itemHandler.extractItem(slot, 1, false);
        }
    }
    private static int getStructureAmount(IItemHandler itemHandler, int slot, int machineLevel) {
        if (ConfigUtils.getStructureByLevel(machineLevel).getItem() == itemHandler.getStackInSlot(slot).getItem()) {
            return itemHandler.getStackInSlot(slot).getCount();
        }else{
            return 0;
        }
    }
}
