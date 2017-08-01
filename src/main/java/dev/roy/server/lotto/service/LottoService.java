package dev.roy.server.lotto.service;

import dev.roy.server.lotto.domain.Lotto;
import dev.roy.server.lotto.repository.LottoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LottoService {

    @Autowired
    private LottoRepository repository;

    public static boolean duplicate = false;
    public static int[] numbers;


    public void makeLottoNumber() {
        numbers = new int[7];

        numbers  =getNormalNumber();//로또번호 6개생성
        numbers[6] = getBounusNumber(numbers);  // 보너스 번호 추가

        Lotto lotto = new Lotto();
        lotto.name ="yongchol";
        lotto.email = "yongchols@gmail.com";
        lotto.passwd = "1234";

        lotto.firstNummber = numbers[0];
        lotto.secondNumber = numbers[1];
        lotto.thirdNumber = numbers[2];
        lotto.fourthNumber = numbers[3];
        lotto.fifthNumber = numbers[4];
        lotto.sixthNumber = numbers[5];
        lotto.bonusNumber = numbers[6];

        repository.save(lotto);

    }


    public int[] getNormalNumber() {
        int[] normal_number = new int[7];
        int temp_number = 0;

        for (int i = 0; i < normal_number.length; i++) {
            temp_number = (int) (Math.random() * 45 + 1);
            for (int j = 0; j < i; j++) {
                if (normal_number[j] == temp_number) {
                    duplicate = true;
                }
            }
            if (!duplicate) {
                normal_number[i] = temp_number;
            } else {
                duplicate = false;
                i--;
            }

        }

        return normal_number;
    }

    public int getBounusNumber(int[] normal_number) {
        int bonus = 0;
        int temp_number = 0;

        while (true) {
            temp_number = (int) (Math.random() * 45 + 1);
            for (int j = 0; j < normal_number.length; j++) {
                if (normal_number[j] == temp_number) {
                    duplicate = true;
                }
            }
            if (duplicate) {
                duplicate = false;
                continue;
            } else {
                break;
            }
        }
        bonus = temp_number;

        return bonus;
    }

}


