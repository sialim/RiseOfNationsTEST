package me.sialim.riseofnations.listeners;

import me.sialim.riseofnations.RiseOfNations;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class ClaimMenuListener implements Listener {
    private final RiseOfNations plugin;

    public ClaimMenuListener(RiseOfNations plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onMenuClick(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        if(e.getView().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("claim-menu-title")) + plugin.blocks.get(p)));
    }
}
