package me.sialim.riseofnations.commands;

import me.sialim.riseofnations.RiseOfNations;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class ClaimCommand implements CommandExecutor {

    private RiseOfNations plugin;

    public ClaimCommand(RiseOfNations plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(sender instanceof Player p){
            Block block = p.getLocation().getBlock();
            String blockID = block.getX() + "," + block.getZ();
            if(plugin.isBlock(blockID)){
                p.sendMessage("Already claimed.");
            }else{
                plugin.addBlock(blockID, p.getUniqueId());
            }
        }
        return true;
    }
}
