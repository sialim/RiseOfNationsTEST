package me.sialim.riseofnations;

import me.sialim.riseofnations.commands.ClaimCommand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;

public final class RiseOfNations extends JavaPlugin {
    private static RiseOfNations plugin;
    public static HashMap<String, UUID> blocks;
    @Override
    public void onEnable() {
        this.blocks = new HashMap<>();
        getCommand("claim").setExecutor(new ClaimCommand(this));
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        plugin = this;
    }

    public void addBlock(String block, UUID owner){
        blocks.put(block, owner);
    }

    public boolean isBlock(String block){
        return blocks.containsKey(block);
    }

    public UUID getOwner(String block){
        return blocks.get(block);
    }

    public void openClaimMenu(Player p, String block){
        String claimMenuTitle = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("claim-menu-title")) + blocks.get(block);
        Inventory claimMenu = Bukkit.createInventory(p, 45, claimMenuTitle);

        ItemStack blockTest = new ItemStack(Material.STONE, 1);
        ItemMeta blockTestMeta = blockTest.getItemMeta();
        blockTestMeta.setDisplayName(ChatColor.GRAY + "|| " + ChatColor.BOLD + blocks.get(block));
        p.openInventory(claimMenu);
    }
}
