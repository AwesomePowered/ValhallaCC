package net.awesomepowered.valhallacc;

import com.google.common.base.Charsets;
import net.md_5.bungee.api.connection.Server;
import net.md_5.bungee.api.event.PluginMessageEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.event.EventHandler;



public class ValhallaCC extends Plugin implements Listener {

    public String prefix = "[ValhallaCC] ";

    public void onEnable() {
        getProxy().registerChannel("ValhallaCC");
        getProxy().getPluginManager().registerListener(this,this);
    }

    @EventHandler
    public void onPluginMessage(PluginMessageEvent ev) {
        if (ev.getSender() instanceof Server) {
            if (ev.getTag().equalsIgnoreCase("ValhallaCC")) {
                String messageStuff = new String(ev.getData(), Charsets.UTF_8);
                System.out.println(prefix + "Recieved command " + messageStuff + " from " + ev.getSender());
                getProxy().getPluginManager().dispatchCommand(getProxy().getConsole(), messageStuff);
            }
        }

    }
}
