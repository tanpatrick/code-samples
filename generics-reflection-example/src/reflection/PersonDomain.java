package reflection;

public class PersonDomain {

    @MyFieldAnnotation(field = "name")
    private String myName;
    @MyFieldAnnotation(field = "address")
    private String myAddress;

    public String getMyName() {
        return myName;
    }

    public void setMyName(String myName) {
        this.myName = myName;
    }

    public String getMyAddress() {
        return myAddress;
    }

    public void setMyAddress(String myAddress) {
        this.myAddress = myAddress;
    }

    @Override
    public String toString() {
        return "domain: " + myAddress + " > " + myName;
    }

}
