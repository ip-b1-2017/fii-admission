  CREATE TRIGGER Examen_Delete_Trigger
         AFTER DELETE
            ON EXAMEN
BEGIN
    DELETE FROM sali_examen
          WHERE sali_examen.EXAMENID = old.ID;
    DELETE FROM sali_examen_candidat
          WHERE sali_examen_candidat.SALI_EXAMENEXAMENID = old.id;
    DELETE FROM note
          WHERE note.EXAMENID = old.id;
END;

CREATE TRIGGER Sali_Delete_Trigger
         AFTER DELETE
            ON Sali
BEGIN
    DELETE FROM sali_examen
          WHERE sali_examen.SALIID = old.ID;
    DELETE FROM sali_examen_candidat
          WHERE sali_examen_candidat.SALI_EXAMENSALIID = old.ID;
END;


CREATE TRIGGER Candidat_Delete_Trigger
         AFTER DELETE
            ON Candidat
BEGIN
    DELETE FROM User
          WHERE user.email = old.useremail;
END;

CREATE TRIGGER Note_Delete_Trigger
         AFTER DELETE
            ON Candidat
BEGIN
    DELETE FROM Note
          WHERE note.candidatcnp = old.cnp;
END;

CREATE TRIGGER Medie_Delete_Trigger
         AFTER DELETE
            ON Candidat
BEGIN
    DELETE FROM Medie
          WHERE medie.candidatcnp = old.cnp;
END;

CREATE TRIGGER Notificari_Delete_Trigger
         AFTER DELETE
            ON Candidat
BEGIN
    DELETE FROM Notificari
          WHERE notificari.useremail = old.useremail;
END;

CREATE TRIGGER Form_Delete_Trigger
         AFTER DELETE
            ON Candidat
BEGIN
    DELETE FROM Form
          WHERE Form.candidatcnp = old.cnp;
END;

CREATE TRIGGER Candidat_Update_Trigger
     UPDATE OF CNP
            ON candidat
BEGIN
    UPDATE sali_examen_candidat
       SET CANDIDATCNP = new.CNP
     WHERE CANDIDATCNP = old.CNP;
    UPDATE form
       SET candidatcnp = new.CNP
     WHERE candidatcnp = old.CNP;
    UPDATE medie
       SET candidatcnp = new.CNP
     WHERE candidatcnp = old.cnp;
    UPDATE note
       SET candidatcnp = new.CNP
     WHERE candidatcnp = old.cnp;
END;

CREATE TRIGGER Examen_Update_Trigger
     UPDATE OF id
            ON examen
BEGIN
    UPDATE sali_examen
       SET examenid = new.id
     WHERE examenid = old.id;
    UPDATE sali_examen_candidat
       SET sali_examensaliid = new.id
     WHERE sali_examensaliid = old.id;
    UPDATE note
       SET examenid = new.id
     WHERE note.EXAMENID = old.id;
END;
