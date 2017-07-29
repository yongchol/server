package dev.roy.server.lotto.domain;

import org.springframework.data.annotation.Id;

public class Lotto {

    @Id
    public String id;

    public String name;
    public String email;
    public String passwd;

    public int firstNummber;
    public int secondNumber;
    public int thirdNumber;
    public int fourthNumber;
    public int fifthNumber;
    public int sixthNumber;
    public int bonusNumber;

    public Lotto() {
    }

    public Lotto(String id, String name, String email, String passwd, int firstNummber, int secondNumber, int thirdNumber, int fourthNumber, int fifthNumber, int sixthNumber, int bonusNumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.passwd = passwd;
        this.firstNummber = firstNummber;
        this.secondNumber = secondNumber;
        this.thirdNumber = thirdNumber;
        this.fourthNumber = fourthNumber;
        this.fifthNumber = fifthNumber;
        this.sixthNumber = sixthNumber;
        this.bonusNumber = bonusNumber;
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

    public int getFirstNummber() {
        return firstNummber;
    }

    public void setFirstNummber(int firstNummber) {
        this.firstNummber = firstNummber;
    }

    public int getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
    }

    public int getThirdNumber() {
        return thirdNumber;
    }

    public void setThirdNumber(int thirdNumber) {
        this.thirdNumber = thirdNumber;
    }

    public int getFourthNumber() {
        return fourthNumber;
    }

    public void setFourthNumber(int fourthNumber) {
        this.fourthNumber = fourthNumber;
    }

    public int getFifthNumber() {
        return fifthNumber;
    }

    public void setFifthNumber(int fifthNumber) {
        this.fifthNumber = fifthNumber;
    }

    public int getSixthNumber() {
        return sixthNumber;
    }

    public void setSixthNumber(int sixthNumber) {
        this.sixthNumber = sixthNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", passwd='" + passwd + '\'' +
                ", firstNummber=" + firstNummber +
                ", secondNumber=" + secondNumber +
                ", thirdNumber=" + thirdNumber +
                ", fourthNumber=" + fourthNumber +
                ", fifthNumber=" + fifthNumber +
                ", sixthNumber=" + sixthNumber +
                ", bonusNumber=" + bonusNumber +
                '}';
    }
}