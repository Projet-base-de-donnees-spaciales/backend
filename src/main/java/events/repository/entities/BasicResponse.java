package events.repository.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BasicResponse {
    String message;
    boolean successful;
    public void Success(String msg){
        successful=true;
        message=msg;
    }
    public void Error(String err){
        successful=false;
        message=err;

    }

}
