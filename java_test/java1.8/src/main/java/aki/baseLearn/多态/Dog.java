package aki.baseLearn.多态;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Dog extends Base{
    private String name;
}
