package controller;

public class FatorialController {
    public FatorialController() {
        super();
    }

    public int calcular(int num ) {
        if (num <= 1)
            return 1;
        return num * calcular (--num);
    }
}