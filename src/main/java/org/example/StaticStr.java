package org.example;

import java.util.List;

import java.lang.String;

public class StaticStr {

    private final String base_url_edu;
    private final List<String> keywords_edu;
    private String baseUrlPost;
    private Long num;


    public StaticStr(){

        base_url_edu = "https://www.knu.ac.kr/wbbs/wbbs/bbs/btin/stdList.action?menu_idx=42";

        keywords_edu = List.of(
                "등록금",
                "전과",
                "복학",
                "휴학",
                "수강신청",
                "수강정정",
                "수강꾸러미",
                "타대학",
                "성적처리",
                "복수전공",
                "강의평가",
                "여름계절수업",
                "겨울계절수업",
                "학점교류");
    }

    public String getBaseEdu_url() {
        return base_url_edu;
    }
    public List<String> getKeywordsEdu() {
        return keywords_edu;
    }

    public String getBaseUrlPost(){
        return this.baseUrlPost;
    }

    public void setBaseUrlPost(Long num) {
        this.baseUrlPost =
                String.format("https://www.knu.ac.kr/wbbs/wbbs/bbs/btin/stdViewBtin.action?" +
                        "search_type=search_subject&search_text=&popupDeco=&note_div=row&" +
                        "bltn_no=%d" +
                        "&menu_idx=42&bbs_cde=stu_812",num);
    }



}
