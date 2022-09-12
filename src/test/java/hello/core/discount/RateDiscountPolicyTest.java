package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10%할인이 적용되어야 한다.")
    void vip_o(){
        //given
        Member member = new Member(1L,"second member", Grade.VIP);

        //when
        int discount1 = discountPolicy.discount(member, 20000);

        //then
        assertThat(discount1).isEqualTo(2000);

    }

    @Test
    @DisplayName("VIP가 아닌경우")
    void vip_x(){
        //given
        Member member = new Member(1L,"second member", Grade.BASIC);

        //when
        int discount1 = discountPolicy.discount(member, 10000);

        //then
        assertThat(discount1).isEqualTo(0);
    }


}