package id.bmri.induction.be.day2.be.induction.be.day2.model.response;

import lombok.Data;

@Data
public class Response {

    private Object data;
    private String message;
    private Boolean result;

    public Response(Object data, String message, Boolean result){
        this.data = data;
        this.message = message;
        this.result = result;
    }

}
