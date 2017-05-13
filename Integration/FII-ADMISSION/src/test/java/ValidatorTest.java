import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import validator.IValidator;
import validator.Validator;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by rusub on 5/7/2017.
 */
class ValidatorTest {

    IValidator validator;
    @BeforeEach
    void setUp() {
        validator = new Validator();
    }

    @AfterEach
    void tearDown() {
        validator = null;
    }

    /*@Test
    void numbersContainsOnlyDigits() {
        boolean res = validator.isValid("res-num=123");
        assertTrue(res);
    }

    @Test
    void numbersDoNotContainsLetters(){
        boolean res = validator.isValid("res-num=123a");
        assertFalse(res);
    }

    @Test
    void wordsContainsOnlyLetters(){
        boolean res = validator.isValid("res-alfa=word");
        assertTrue(res);
    }

    @Test
    void wordsDoNotContainsCharactersOtherThanLetters(){
        boolean res = validator.isValid("res-alfa=word21");
        assertFalse(res);
    }

    @Test
    void alphaNumericWordsShouldContainsOnlyLettersAndDigits(){
        boolean res = validator.isValid("res-alfn=word21");
        assertTrue(res);
    }

    @Test
    void alphaNumericWordsShouldOtherCharacters(){
        boolean res = validator.isValid("res-alfn=12as@#");
        assertFalse(res);
    }

    @Test
    void emailsShouldNotContainsAtSymbolInLocalPart(){
        boolean res = validator.isValid(("res-email=popescu@ion@gmail.com"));
        assertFalse(res);
    }

    @Test
    void emailsShouldContainsOnlyOneAtSymbol(){
        boolean res = validator.isValid("res-email=popescu@gmail.com");
        assertTrue(res);
    }

    @Test
    void allShouldAcceptAnyWord(){
        boolean res = validator.isValid("res-all=o4r01012!@@@^%25");
        assertTrue(res);
    }

    @Test
    void dateShouldContainsThreeNumbersSeparateByDots(){
        boolean res = validator.isValid("red-date=01.01.2017");
        assertTrue(true);
    }

    @Test
    void dateShouldNotContainYearFormatedWithLessThenFourDigites(){
        boolean res = validator.isValid("red-date=01.01.200");
        assertFalse(res);
    }*/


}