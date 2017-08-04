package dev.roy.server.lotto.domain;

import org.springframework.data.annotation.Id;

public class User {
    @Id
    public String id;

    // 회원정보
    public String name;
    public String email;
    public String passwd;
    public int lottoCnt;
    public int winCnt;

    public User(String id, String name, String email, String passwd, int lottoCnt, int winCnt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.passwd = passwd;
        this.lottoCnt = lottoCnt;
        this.winCnt = winCnt;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", passwd='" + passwd + '\'' +
                ", lottoCnt=" + lottoCnt +
                ", winCnt=" + winCnt +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public int getLottoCnt() {
        return lottoCnt;
    }

    public void setLottoCnt(int lottoCnt) {
        this.lottoCnt = lottoCnt;
    }

    public int getWinCnt() {
        return winCnt;
    }

    public void setWinCnt(int winCnt) {
        this.winCnt = winCnt;
    }
}
