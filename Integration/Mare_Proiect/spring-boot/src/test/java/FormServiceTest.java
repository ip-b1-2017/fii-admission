import fii.admission.forms.FormService;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by rusub on 5/19/2017.
 */
class FormServiceTest {

    FormService formService;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        formService = new FormService();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        formService = null;
    }

    @org.junit.jupiter.api.Test
    void insertNewField() {
        String oldForm = "\"prenume\":\"bogdan\"";
        String updates = "\"nume\":\"rusu\"";
        String finalForm = formService.updateOldForm("{" + oldForm + "}",
                                                     "{" + updates + "}");
        boolean res = finalForm.contains(oldForm) && finalForm.contains(updates);
        assertTrue(res);
    }

    @org.junit.jupiter.api.Test
    void updateField() {
        String oldForm = "\"prenume\":\"gigel\"";
        String updates = "\"prenume\":\"bogdan\"";
        String finalForm = formService.updateOldForm("{" + oldForm + "}",
                "{" + updates + "}");
        boolean res = finalForm.contains(updates);
        assertTrue(res);
    }

    @org.junit.jupiter.api.Test
    void updateOnlyOneFromTwoFields() {
        String oldFormPart1 = "\"prenume\":\"gigel\"";
        String oldFormPart2 = "\"nume\":\"popescu\"";
        String updates = "\"prenume\":\"bogdan\"";
        String finalForm = formService.updateOldForm("{" + oldFormPart1 + "," + oldFormPart2 + "}",
                "{" + updates + "}");
        boolean res = finalForm.contains(updates) && finalForm.contains(oldFormPart2);
        assertTrue(res);
    }

    @org.junit.jupiter.api.Test
    void updateShouldNotContainOldValuesThatHaveBeenUpdated() {
        String oldFormPart1 = "\"prenume\":\"gigel\"";
        String oldFormPart2 = "\"nume\":\"popescu\"";
        String updates = "\"prenume\":\"bogdan\"";
        String finalForm = formService.updateOldForm("{" + oldFormPart1 + "," + oldFormPart2 + "}",
                "{" + updates + "}");
        boolean res = finalForm.contains(updates) && finalForm.contains(oldFormPart1);
        assertFalse(res);
    }

}