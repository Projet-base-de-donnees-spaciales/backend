package ilisi.ma.projetmoveanddescover.events.controllers;


import ilisi.ma.projetmoveanddescover.events.repository.entities.BasicResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class BasicApiController {
    public  <Response extends BasicResponse> ResponseEntity<Response> Respond(Response res)
    {
        if(res.isSuccessful())
            return new ResponseEntity<>(res, HttpStatus.OK);
        else
            return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);//400
    }
}
