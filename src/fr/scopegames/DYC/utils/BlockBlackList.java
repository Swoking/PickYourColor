package fr.scopegames.DYC.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.bukkit.Material;

public class BlockBlackList {
    private static List<Material> blacklist = new ArrayList<Material>(Arrays.asList(new Material[]{Material.BRICK_STAIRS, Material.ACACIA_STAIRS, Material.COBBLESTONE_STAIRS, Material.DARK_OAK_STAIRS, Material.JUNGLE_WOOD_STAIRS, Material.NETHER_BRICK_STAIRS, Material.PURPUR_STAIRS, Material.QUARTZ_STAIRS, Material.RED_SANDSTONE_STAIRS, Material.SANDSTONE_STAIRS, Material.SMOOTH_STAIRS, Material.SPRUCE_WOOD_STAIRS, Material.WOOD_STAIRS, Material.TORCH, Material.REDSTONE_TORCH_OFF, Material.REDSTONE_TORCH_ON, Material.DEAD_BUSH, Material.CARPET, Material.LONG_GRASS, Material.STAINED_GLASS}));

    public static List<Material> getBlackList() {
        return blacklist;
    }
}