package me.sialim.riseofnations.listeners;

import me.sialim.riseofnations.RiseOfNations;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

public class ClickListener implements Listener {
    private final RiseOfNations plugin;

    public ClickListener(RiseOfNations plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent e){
        Block block = e.getClickedBlock();
        String blockID = block.getX() + "," + block.getZ();
        Player p = e.getPlayer();
        if(e.getClickedBlock()!=null){
            if(plugin.isBlock(blockID)){
                if(!plugin.getOwner(blockID).equals(p.getUniqueId())){
                    //
                }else{
                    plugin.openClaimMenu(p, blockID);
                }
            }
        }
        e.setCancelled(true);
    }
}
