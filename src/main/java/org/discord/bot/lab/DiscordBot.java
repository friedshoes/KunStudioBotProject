package org.discord.bot.lab;


import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;

import org.example.Main;
import org.example.MyDataFrame;

import java.util.ArrayList;

public class DiscordBot extends ListenerAdapter {
    public static void main(String[] args) throws Exception{
        String TOKEN = System.getenv("DISCORD_PRIVATE_TOKEN");
        JDA myApi = JDABuilder
                .createLight(TOKEN, GatewayIntent.GUILD_MESSAGES, GatewayIntent.MESSAGE_CONTENT)
                .build();

        myApi.addEventListener(new DiscordBot());
        myApi.addEventListener(new MyListener());
        myApi.awaitReady();

        Main myMain = new Main();
        ArrayList<MyDataFrame> myArr = myMain.parseLogic();
        double saveNum = 20250805L;
        TextChannel textChannel = myApi.getTextChannelById(1410536285340307508L);

        for(int i=0;i< myArr.size();i++){

            //날짜 -1 로 인해 중복이 발생하나 , 혹시 모를 누락보단 두 번 보는게 낫잖아 ~~
            if(myArr.get(i).getDate() > saveNum-1){
                System.out.println(myArr.get(i));
                String printTittle = myArr.get(i).getTitle();
                String printLink = myArr.get(i).getLink();
                textChannel.sendMessage(printTittle + printLink).queue();
            }

        }

        //일반 채널 아이디 임


        for(int i=0; i<3; i++)
            textChannel.sendMessage("it is test print").queue();


    }

}


//1. registering해야 사용가능
//2. message intent가 꼭 필요함.
class MyListener extends ListenerAdapter
{
    @Override
    public void onMessageReceived(MessageReceivedEvent event)
    {
        if (event.getAuthor().isBot()) return;
        // We don't want to respond to other bot accounts, including ourself
        Message message = event.getMessage();
        String content = message.getContentRaw();
        // getContentRaw() is an atomic getter
        // getContentDisplay() is a lazy getter which modifies the content for e.g. console view (strip discord formatting)
        if (content.equals("!ping"))
        {
            MessageChannel channel = event.getChannel();
            channel.sendMessage("Pong!").queue(); // Important to call .queue() on the RestAction returned by sendMessage(...)
        }
    }
}