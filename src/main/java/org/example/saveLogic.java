package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class saveLogic {

    //constructor
    public saveLogic(){}

    //main에서 이주함
    public void allFunc(){
        //declare related class
        TestUtils TUtils = new TestUtils();
        StaticStr staticStr = new StaticStr();


        ArrayList<MyDataFrame> listEdu = new ArrayList<MyDataFrame>();




        //declare vars
        Document doc = null;
        Elements elementsTotal = null;
        Elements elementsTr = null;
        Elements elementsHref = null;
        Long saveNum = 0L;


        try{
            doc = Jsoup.connect( staticStr.getBaseEdu_url() ).get();
            elementsTotal = doc.select(".board_list > table:nth-child(1) > tbody:nth-child(4)");
            elementsTr = elementsTotal.select(".date");
            elementsHref = elementsTotal.select("[href]");
        }catch(Exception e){
            System.err.println(e.getMessage());
        }


        TUtils.printDash();
        for(int i=0; i< elementsHref.size();i++) {

            String str1 = elementsHref.get(i).toString();
            String str2 = elementsTr.get(i).text();
            if(!str2.equals("공지"))
                System.out.println(str2);
            else
                continue;

            boolean containsAny = staticStr.getKeywordsEdu().stream().anyMatch(str1::contains);

            if(containsAny && str1.indexOf("top") != 39)
                System.out.println(elementsHref.get(i).text());
            else
                continue;

            Pattern pattern = Pattern.compile("'(\\d{14})'");
            Matcher matcher = pattern.matcher(str1);

            if (matcher.find()) {
                System.out.println(matcher.group(1));
            }

            String regx1 = "/";
            String reged1 = str2.replaceAll(regx1, "");

            Long pam1 = Long.parseLong(reged1);
            Long pam2 = Long.parseLong(matcher.group(1));
            String pam3 = elementsHref.get(i).text();

            staticStr.setBaseUrlPost(pam2);

            String pam4 = staticStr.getBaseUrlPost();

            listEdu.add( new MyDataFrame(pam1, pam2, pam3,pam4) );
        }
        TUtils.printDash();

        //saveNum = listEdu.get(0).getDate();
        saveNum = 20250805L;

        for(int i=0;i< listEdu.size();i++){

            //날짜 -1 로 인해 중복이 발생하나 , 혹시 모를 누락보단 두 번 보는게 낫잖아 ~~
            if(listEdu.get(i).getDate() > saveNum-1)
                System.out.println(listEdu.get(i));
        }

    }
}
