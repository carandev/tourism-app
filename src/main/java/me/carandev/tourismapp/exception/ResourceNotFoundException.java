package me.carandev.tourismapp.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Data
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    private String resourceName;
    private String fieldName;
    private long fieldContent;

    public ResourceNotFoundException(String resourceName, String fieldName, long fieldContent) {
        super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldContent));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldContent = fieldContent;
    }
}
