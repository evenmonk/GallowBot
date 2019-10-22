package GallowBot.Discord;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class CommandHandler extends ListenerAdapter
{
    private static final String Prefix = "--";

    public void onGuildMessageReceived (GuildMessageReceivedEvent event)
    {
        String[] args = event.getMessage().getContentRaw().split(" ");

        switch (args[0].toLowerCase())
        {
            case (Prefix + "help"):
                event.getChannel().sendMessage("I do nothing").queue();
                break;
            case (Prefix + "gallows"):
                break;
            default:
                break;
        }

    }
}
