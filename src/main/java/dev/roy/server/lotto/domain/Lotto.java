package dev.roy.server.lotto.domain;

import org.springframework.data.annotation.Id;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;

public class Lotto {

    @Id
    public String id;

    public String name;
    public int number1;
    public int number2;
    public int number3;
    public int number4;
    public int number5;
    public int number6;

    public String rank;
    public String date;

    public int gameCnt;
    public int shuffleCnt;

    public Lotto() {
    }

    public Lotto(String id, String name, int number1, int number2, int number3, int number4, int number5, int number6, String rank, String date, int gameCnt, int shuffleCnt) {
        this.id = id;
        this.name = name;
        this.number1 = number1;
        this.number2 = number2;
        this.number3 = number3;
        this.number4 = number4;
        this.number5 = number5;
        this.number6 = number6;
        this.rank = rank;
        this.date = date;
        this.gameCnt = gameCnt;
        this.shuffleCnt = shuffleCnt;
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

    public int getNumber1() {
        return number1;
    }

    public void setNumber1(int number1) {
        this.number1 = number1;
    }

    public int getNumber2() {
        return number2;
    }

    public void setNumber2(int number2) {
        this.number2 = number2;
    }

    public int getNumber3() {
        return number3;
    }

    public void setNumber3(int number3) {
        this.number3 = number3;
    }

    public int getNumber4() {
        return number4;
    }

    public void setNumber4(int number4) {
        this.number4 = number4;
    }

    public int getNumber5() {
        return number5;
    }

    public void setNumber5(int number5) {
        this.number5 = number5;
    }

    public int getNumber6() {
        return number6;
    }

    public void setNumber6(int number6) {
        this.number6 = number6;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getGameCnt() {
        return gameCnt;
    }

    public void setGameCnt(int gameCnt) {
        this.gameCnt = gameCnt;
    }

    public int getShuffleCnt() {
        return shuffleCnt;
    }

    public void setShuffleCnt(int shuffleCnt) {
        this.shuffleCnt = shuffleCnt;
    }
}