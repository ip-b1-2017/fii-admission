package com.ip_b1.fii.admission;

import com.ip_b1.fii.admission.Controllers.SaveCandidate;
import com.ip_b1.fii.admission.DTO.AuthEntity;
import com.ip_b1.fii.admission.DTO.CandidateInEntity;
import com.ip_b1.fii.admission.DTO.SuccessEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class SaveCandidateTest {
    private SaveCandidate test;

    @AfterEach
    private void tearDown() { test = null; }

    @Test
    public void unauthorized_user_tries_to_candidate() {
        test = new SaveCandidate();
        AuthEntity auth = new AuthEntity("alexx@info.uaic.ro", "invalid");
        CandidateInEntity candidat = new CandidateInEntity(auth, "1234567890123", "Alex", "Domnaru", "address", "0755555555");
        ResponseEntity<SuccessEntity> result = test.saveCandidate(candidat);
        Assert.assertEquals(HttpStatus.UNAUTHORIZED, result.getStatusCode());
    }

    @Test
    public void already_has_candidature_but_candidature_could_not_be_updated() {
        test = new SaveCandidate();
        AuthEntity auth = new AuthEntity("alexd@info.uaic.ro", "meme");
        CandidateInEntity candidat = new CandidateInEntity(auth, "1234567890123", "Alex", "Domnaru", "address", "0755555555");
        ResponseEntity<SuccessEntity> result = test.saveCandidate(candidat);
        Assert.assertEquals(HttpStatus.BAD_REQUEST, result.getStatusCode());
    }

    @Test
    public void already_has_candidature_and_candidature_is_updated() {
        test = new SaveCandidate();
        AuthEntity auth = new AuthEntity("alexx@info.uaic.ro", "meme");
        CandidateInEntity candidat = new CandidateInEntity(auth, "2234567890123", "Alex", "Domnaru", "address", "0755555555");
        ResponseEntity<SuccessEntity> result = test.saveCandidate(candidat);
        Assert.assertEquals(HttpStatus.CREATED, result.getStatusCode());
    }

    @Test
    public void new_candidature_could_not_be_made() {
        test = new SaveCandidate();
        AuthEntity auth = new AuthEntity("alexd@info.uaic.ro", "meme");
        CandidateInEntity candidat = new CandidateInEntity(auth, "2234567890123", "Alexx", "Domnaru", "address", "0755555555");
        ResponseEntity<SuccessEntity> result = test.saveCandidate(candidat);
        Assert.assertEquals(HttpStatus.BAD_REQUEST, result.getStatusCode());
    }

    @Test
    public void new_candidature_made_successfully() {
        test = new SaveCandidate();
        AuthEntity auth = new AuthEntity("alexd@info.uaic.ro", "meme");
        CandidateInEntity candidat = new CandidateInEntity(auth, "1234567890123", "Alex", "Domnaru", "address", "0755555555");
        ResponseEntity<SuccessEntity> result = test.saveCandidate(candidat);
        Assert.assertEquals(HttpStatus.CREATED, result.getStatusCode());
    }
}

