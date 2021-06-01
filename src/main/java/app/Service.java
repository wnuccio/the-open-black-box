package app;

public interface Service {
    int getNumber();
}

class RealService implements Service {

    @Override
    public int getNumber() {
        return (int) ((Math.random() * 10) + 1);
    }
}
