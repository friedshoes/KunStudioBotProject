package org.example;

public class MyDataFrame {
    private Long date;
    private Long postNum;
    private String title;
    private String link;

    //빈 생성자
    public MyDataFrame() { }

    //데이터 생성용 생성자
    public MyDataFrame(Long date, Long postNum, String title, String link) {
        this.date = date;
        this.postNum = postNum;
        this.title = title;
        this.link = link;
    }

    public Long getDate() { return this.date; }
    public Long getPostNum() { return this.postNum; }
    public String getTitle() { return this.title; }
    public String getLink() { return this.link; }

    @Override
    public String toString() {
        return getDate() + " " + getPostNum() + " " + getTitle() +  " " + getLink();
    }
}
