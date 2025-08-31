package org.example;

public class TestUtils {

    public void printDash(){
        System.out.println("------------------------------------------------------");
    }

}


/*
* .board_list > table:nth-child(1) > tbody:nth-child(4) > tr:nth-child(23) > td:nth-child(2) > a:nth-child(1)
* <a href="javascript:doRead('stu_812', 'row', '11756368274639');">
					2025학년도 2학기 수강신청 후 폐강과목 안내
					</a>
*
*html body.bbg div.sub_wrap div.sub_contents div.layout div#body_content form#btinForm div.board_list table tbody tr td.subject a
*
*    /html/body/div[1]/div[7]/div[2]/div[2]/form/div/table/tbody/tr[23]/td[2]/a
*
*
* https://www.knu.ac.kr/wbbs/wbbs/bbs/btin/stdViewBtin.action?search_type=search_subject&search_text=&popupDeco=&note_div=row&bltn_no=11755667909667&menu_idx=42&bbs_cde=stu_812
*/