package reflection;

public class PersonBean {

    @MyFieldAnnotation(field = "name")
    private String name;
    @MyFieldAnnotation(field = "address")
    private String address;
    private String contactNo;
    @MyFieldAnnotation(field = "gender")
    private GenderBean genderBean;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static void main(String[] args) throws Exception {
        PersonBean personBean = new PersonBean();
        personBean.setName("Patrick");
        personBean.setAddress("Cebu");
        personBean.setGenderBean(new GenderBean("male"));

        PersonDomain domain = new PersonDomain();
//        domain.setMyAddress(personBean.getAddress());
//        domain.setMyName(personBean.getName());

        MagicClass.transfer(personBean, domain);
        System.out.println(" ... " + domain);        
        System.out.println(MagicClass.transfer(personBean, PersonDomain.class));
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public GenderBean getGenderBean() {
        return genderBean;
    }

    public void setGenderBean(GenderBean genderBean) {
        this.genderBean = genderBean;
    }
}
