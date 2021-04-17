package mameie.kfzService.secruity.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping(path="/day")
    public ResponseEntity<MyToken> home() throws JsonProcessingException {
        MyToken token = new MyToken("Hallo alle");
        return  new ResponseEntity<>(token, HttpStatus.OK);
    }

}
@Getter
@NoArgsConstructor
@AllArgsConstructor
class MyToken{
    private String jwtToken;
}
