package GallowBot.ConnectionToDiscord;

import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.apache.log4j.BasicConfigurator;

import javax.security.auth.login.LoginException;

public class Main
{
    public static void main (String[] args) throws LoginException
    {
        BasicConfigurator.configure();
        JDA jda = new JDABuilder(AccountType.BOT).setToken("NjM2MTc4MTkzMDE5MzA1OTk1.Xa8QcA.zraaweswWfn2Cf8zM-x5vlc1lP8").build();
    }
}
