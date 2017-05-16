package fiiadmission.dto;

import java.util.Map;

public class FormOutEntity {
    AuthEntity authEntity;
    Map<String, String> fields;

    public FormOutEntity(AuthEntity authEntity, Map<String, String> fields) {
        this.authEntity = authEntity;
        this.fields = fields;
    }

    public AuthEntity getAuthEntity() {
        return authEntity;
    }

    public void setAuthEntity(AuthEntity authEntity) {
        this.authEntity = authEntity;
    }

    public Map<String, String> getFields() {
        return fields;
    }

    public void setFields(Map<String, String> fields) {
        this.fields = fields;
    }
}
