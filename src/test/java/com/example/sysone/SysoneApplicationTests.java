package com.example.sysone;

import com.example.sysone.components.AutomovilOperation;
import com.example.sysone.components.AutomovilValidator;
import com.example.sysone.entities.Automovil;
import com.example.sysone.enums.OpcionalesEnum;
import com.example.sysone.enums.TiposAutomovilEnum;
import com.example.sysone.entities.Opcion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SysoneApplicationTests {

    @Autowired
    private AutomovilOperation operation;

    @Autowired
    private AutomovilValidator validator;

    @Test
    public void contextLoads() {
    }

    @Test
    public void costo(){

        Automovil auto = new Automovil();

        Assert.assertEquals( "0", operation.costo(auto).toString());
        auto.setPrice( TiposAutomovilEnum.FAMILIAR.getPrice() );
        Assert.assertEquals(TiposAutomovilEnum.FAMILIAR.getPrice(), operation.costo(auto));

        Opcion op1 = new Opcion(OpcionalesEnum.AIRE_ACONDICIONADO.getName(), OpcionalesEnum.AIRE_ACONDICIONADO.getPrice());
        auto.addOpcion(op1);
        Assert.assertEquals(1, auto.getOpciones().size() );
        Integer total = OpcionalesEnum.AIRE_ACONDICIONADO.getPrice() + TiposAutomovilEnum.FAMILIAR.getPrice();
        Assert.assertEquals(total,  operation.costo(auto) );

    }



    @Test
    public void validator(){
        Assert.assertTrue(validator.validateAutoName(TiposAutomovilEnum.FAMILIAR.getName()) );
        Assert.assertFalse(validator.validateAutoName("Vaina"));

        Assert.assertTrue(
            validator.validateOpciones(
                            Arrays.asList(OpcionalesEnum.AIRE_ACONDICIONADO.getName(),
                                            OpcionalesEnum.AIR_BAG.getName())
                    )
        );

        Assert.assertFalse(
                validator.validateOpciones(
                        Arrays.asList(OpcionalesEnum.AIRE_ACONDICIONADO.getName(),
                                "Vaina" )
                )
        );

    }
}