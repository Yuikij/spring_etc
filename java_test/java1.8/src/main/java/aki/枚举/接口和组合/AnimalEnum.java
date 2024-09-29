package aki.枚举.接口和组合;

import lombok.Getter;

@Getter
public enum AnimalEnum implements DicEnumInterface{

    DOG(1, "🐕"),
    CAT(2,"neko"),
    ;

    private final int value;
    private final String name;

    AnimalEnum(int value, String name) {
        this.value = value;
        this.name = name;
    }

    @Override
    public Object getCode() {
        return this.value;
    }

    @Override
    public String getDesc() {
        return this.name;
    }
}
