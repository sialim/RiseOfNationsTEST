package me.sialim.riseofnations.listeners;

import me.sialim.riseofnations.RiseOfNations;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class PreventionListener implements Listener {
    private final RiseOfNations plugin;

    public PreventionListener(RiseOfNations plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent e){
        if(e.getClickedBlock()!= null){
            Block block = e.getClickedBlock();
            String blockID = block.getX() + "," + block.getZ();
            if(plugin.isBlock(blockID)){
                Player p = e.getPlayer();
                if(!plugin.getOwner(blockID).equals(p.getUniqueId())){
                    if(!p.isOp()){
                        e.setCancelled(true);
                        p.sendMessage("Not allowed.");
                    }
                }
            }
        }
    }
}
