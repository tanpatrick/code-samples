package training.spring.aop.sample.bean;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Patrick Tan
 */
public class PersonBean {

    private String name;
    private String gender;
    private String createdBy;
    private Date createdDate;

    public PersonBean(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return (Date) (createdDate == null ? null : createdDate.clone());
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = (Date) (createdDate == null ? null : createdDate.clone());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Field[] fields = this.getClass().getDeclaredFields();

        for (Field field : fields) {
            try {
                sb.append("[").append(field.getName()).append(" - ");
                sb.append(field.get(this)).append("] ");
            } catch (SecurityException | IllegalArgumentException | IllegalAccessException ex) {
                Logger.getLogger(PersonBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return sb.toString();
    }

}
