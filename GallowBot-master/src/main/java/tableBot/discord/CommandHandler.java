package tableBot.discord;

import tableBot.games.*;
import tableBot.games.cards.CardgameModel;
import tableBot.games.gallows.GallowsModel;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.util.HashSet;


public class CommandHandler extends ListenerAdapter
{
    private String[] Message;
    private String LastUsername = "";

    private final String Prefix = "-";
    private final ActivitiesKeeper ActivitiesKeeper = new ActivitiesKeeper();

    HashSet<Integer> players = new HashSet<>();

    public void onGuildMessageReceived (GuildMessageReceivedEvent event)
    {
        LastUsername = event.getAuthor().getName();
        Message = event.getMessage().getContentRaw().split("\\s+");
        switch (Message[0].toLowerCase())
        {
            case (Prefix + "help"):
                event.getChannel().sendMessage("I do nothing").queue();
                break;
            case (Prefix + "gallows"):
                handleGallowsCommands(event);
                break;
            case (Prefix + "twenty-one"):
                handleCardgameCommands(event);
                break;
            case (Prefix + "activities"):
                event.getChannel().sendMessage(ActivitiesKeeper.showActivities()).queue();
                break;
            default:
                break;
        }
    }

    private void handleGallowsCommands(GuildMessageReceivedEvent event)
    {
        switch (Message[1].toLowerCase())
        {
            case ("start"):
                if (! ActivitiesKeeper.userHasActivity(LastUsername))
                {
                    //Creation is correct
                    Activity activity = new Activity(new GallowsModel());
                    ActivitiesKeeper.addActivity(LastUsername, activity);
                    event.getChannel().sendFile(activity.gallowsModel.gameField.getImage(), "Start.jpg").queue();
                }
                else
                    event.getChannel().sendMessage("You have an unfinished game." +
                            " Finish it or complete it with a command '-<Name of game> stop'").queue();
                break;
            case ("letter"):
                //TODO send to gallows's game model Message[2].
                break;
            case ("help"):
                //TODO Write rules and commands for this game. Use message patterns
                break;
            case ("stop"):
                if (ActivitiesKeeper.userHasActivity(LastUsername))
                {
                    ActivitiesKeeper.deleteActivity(LastUsername);
                    event.getChannel().sendMessage("Your game is stopped."
                            + " To start new game use command -<Name of game> start").queue();
                }
                break;
            default:
                break;
        }
    }

    private void handleCardgameCommands(GuildMessageReceivedEvent event)
    {
        players.add(new CardgameModel(1));
        switch (Message[1].toLowerCase())
        {
            case ("start"):
                if (! ActivitiesKeeper.userHasActivity(LastUsername))
                    ActivitiesKeeper.addActivity(LastUsername, new Activity(new CardgameModel()));
                break;
            case ("help"):
                //TODO Write rules and commands for this game.
                break;
            case ("draw"):
                //TODO give that user next card from a remaining list.
                if(!CardgameModel.getOneMoreCard()) {
                    event.getChannel().sendMessage("The game is ended! You've got" + CardgameModel.getValueOfHand() + " points").queue();
                    break;
                }
                break;
            case ("stop"):
                if (ActivitiesKeeper.userHasActivity(LastUsername))
                {
                    ActivitiesKeeper.deleteActivity(LastUsername);
                    event.getChannel().sendMessage("Your game is stopped."
                            + " To start new game use command -<Name of game> start").queue();
                }
                break;
            default:
                break;
        }
    }
}
