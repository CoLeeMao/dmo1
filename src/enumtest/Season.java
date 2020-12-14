package enumtest;

public enum Season {
    SPRING("spring", "spring1"),
    SUMMER("summer","summer1"),
    AUTUMN("autumn","autumn1"),
    WINTER("winter","winter1")
    ;

    public String getsName() {
        return sName;
    }

    public String getsState() {
        return sState;
    }

    private final String sName;
    private final String sState;

    @Override
    public String toString() {
        return "Season{" +
                "sName='" + sName + '\'' +
                ", sState='" + sState + '\'' +
                '}';
    }

    Season(String sName, String sState) {
        this.sName = sName;
        this.sState = sState;
    }
}
