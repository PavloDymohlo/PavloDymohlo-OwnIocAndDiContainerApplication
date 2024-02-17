package OwnIocAndDiContainer.own_ioc;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Data
@RequiredArgsConstructor
@ToString
@Component
public class Phone {
    private String model;
}
