package com.system.volleyball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.core.annotation.Order;

import com.system.volleyball.Repo.VolleyballRepo;
import com.system.volleyball.entity.Volleyball;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class VolleyballRepositoryTest {
    @Autowired
    private VolleyballRepo volleyballRepo;

    @Test
    @Order(1)
    public void savevolleyballTest() {

        Volleyball volleyball = Volleyball.builder()
                .volleyballname("rak")
                .volleyballcontact("123454")
                .volleyballprice("98888888")
                .build();

        volleyballRepo.save(volleyball);

        Assertions.assertThat(volleyball.getFut_salId()).isGreaterThan(0);
    }

    @Test
    @Order(4)
    public void updatevolleyballTest() {

        Volleyball volleyball = Volleyball.builder()
                .volleyballname("rak")
                .volleyballcontact("123454")
                .volleyballprice("98888888")
                .build();

        volleyballRepo.save(volleyball);

        Volleyball volleyball1 = volleyballRepo.findById(volleyball.getFut_salId()).get();

        volleyball1.setVolleyballcontact("13265");

        Volleyball volleyballupdated = volleyballRepo.save(volleyball);

        Assertions.assertThat(volleyballupdated.getVolleyballcontact()).isEqualTo("85207410");

    }
}